/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package pepper.domain.services.update;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.eclipse.sirius.components.representations.Message;
import org.eclipse.sirius.components.representations.MessageLevel;
import org.springframework.stereotype.Service;

import pepper.domain.services.PersonCapacityAllocation;
import pepper.domain.services.TaskHelper;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.AssignableObject;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.NamedElement;
import pepper.peppermm.Person;
import pepper.peppermm.Project;
import pepper.peppermm.Workpackage;

/**
 * Service to manage the update of a task and the impacted tasks.
 *
 * @author lfasani
 */
@Service
public class TaskUpdateService {

    // Highest priority first for steps affecting the same task.
    private static final List<Class<? extends TaskUpdateStep>> IMPACTED_STEPS = List.of(
            ParentUpdateStep.class,
            DependencyUpdateStep.class,
            PersonUpdateStep.class);

    private final TaskHelper taskHelper = new TaskHelper();

    private final SimpleCrossReferenceProvider simpleCrossReferenceProvider = new SimpleCrossReferenceProvider();

    private final IFeedbackMessageService feedbackMessageService;

    public TaskUpdateService(IFeedbackMessageService feedbackMessageService) {
        this.feedbackMessageService = Objects.requireNonNull(feedbackMessageService);
    }

    public void updateWithImpacts(EObject task, TaskUpdateStep taskUpdateStep) {
        this.updateWithImpacts(task, List.of(taskUpdateStep));
    }

    public void updateWithImpacts(EObject task, List<TaskUpdateStep> taskUpdateSteps) {
        if (!taskUpdateSteps.isEmpty()) {
            Temporal minTemporal = this.getStartTemporal(taskUpdateSteps);
            if (minTemporal != null) {
                try {
                    List<TaskUpdateStep> taskUpdateStepsWithImpacts = new ArrayList<>(taskUpdateSteps);
                    this.computeTaskToUpdate((EObject) taskUpdateSteps.get(taskUpdateSteps.size() - 1).getImpactedTask(), taskUpdateStepsWithImpacts, List.copyOf(taskUpdateSteps));
                    this.updateTasksAfterGivenTemporal((DependencyRelatedObject) task, minTemporal, taskUpdateStepsWithImpacts);
                } catch (IllegalStateException e) {
                    // logged with IFeedbackMessage;
                }
            }
        }
    }

    private Temporal getStartTemporal(List<TaskUpdateStep> taskUpdateSteps) {
        return taskUpdateSteps.stream()
                .filter(TaskBoundaryUpdateStep.class::isInstance)
                .map(TaskBoundaryUpdateStep.class::cast)
                .filter(taskBoundaryUpdateStep -> taskHelper.getStartTemporal(taskBoundaryUpdateStep.getImpactedTask()) != null)
                .findFirst()
                .flatMap(taskBoundaryUpdateStep -> {
                    Temporal startTemp = taskHelper.getStartTemporal(taskBoundaryUpdateStep.getImpactedTask());
                    Temporal start = taskBoundaryUpdateStep.getStart();
                    Optional<Temporal> earliest = Stream.of(startTemp, start)
                            .min(Comparator.comparing(t -> (Comparable<Object>) t));
                    return earliest;
                })
                .orElseGet(() -> taskHelper.getStartTemporal(taskUpdateSteps.get(taskUpdateSteps.size() - 1).getImpactedTask()));
    }

    private void doUpdate(Collection<TaskUpdateStep> tasksToUpdate) {
        PersonCapacityAllocation allocation = new PersonCapacityAllocation();
        this.seedAllocation(allocation, tasksToUpdate);
        try (PersonCapacityAllocation.Scope ignored = PersonCapacityAllocation.activate(allocation)) {
            tasksToUpdate.forEach(step -> {
                step.update(allocation);
                this.reserve(allocation, step.getImpactedTask());
            });
        }
    }

    /**
     * Reserve allocation for non being updated tasks.
     */
    private void seedAllocation(PersonCapacityAllocation allocation, Collection<TaskUpdateStep> tasksToUpdate) {
        var impactedTasks = tasksToUpdate.stream()
                .map(TaskUpdateStep::getImpactedTask)
                .filter(DependencyRelatedObject.class::isInstance)
                .map(DependencyRelatedObject.class::cast)
                .toList();

        impactedTasks.stream()
                .findFirst()
                .ifPresent(task -> this.getAllTasksOfGantt(task).stream()
                        .filter(ganttTask -> !impactedTasks.contains(ganttTask))
                        .forEach(ganttTask -> this.reserve(allocation, ganttTask)));
    }

    private void reserve(PersonCapacityAllocation allocation, Object task) {
        if (task instanceof AbstractTask abstractTask) {
            allocation.reserve(abstractTask);
        } else if (task instanceof Workpackage workpackage) {
            allocation.reserve(workpackage);
        }
    }

    /**
     * Aggregates the tasksToUpdate with tasks that are dependencies of currentTask.
     */
    private void computeTaskToUpdate(EObject currentTask, List<TaskUpdateStep> tasksToUpdate, List<TaskUpdateStep> currentBranchOfTasksToUpdate) throws IllegalStateException {
        for (var inverseReference : simpleCrossReferenceProvider.getInverseReferences(currentTask)) {
            if (inverseReference.getEObject() instanceof DependencyLink dependencyLink) {
                if (dependencyLink.eContainer() instanceof DependencyRelatedObject targetTask && currentTask instanceof DependencyRelatedObject sourceTask) {
                    if (taskHelper.isComputedDynamically(targetTask)) {
                        this.fail(String.format("Having a dependency targeting a dynamically computed task \"%s\" is not possible.", taskHelper.getName(targetTask)));
                    }
                    this.computeTaskToUpdate(tasksToUpdate, currentBranchOfTasksToUpdate, targetTask, new DependencyUpdateStep(targetTask));
                }
            }
        }

        if (currentTask.eContainer() instanceof AbstractTask abstractTask) {
            if (abstractTask.isComputeStartEndDynamically()) {
                this.computeTaskToUpdate(tasksToUpdate, currentBranchOfTasksToUpdate, abstractTask, new ParentUpdateStep(abstractTask));
            }
        }
    }

    private void computeTaskToUpdate(List<TaskUpdateStep> tasksToUpdate, List<TaskUpdateStep> currentBranchOfTasksToUpdate, EObject targetTask, TaskUpdateStep newUpdateStep) {
        List<TaskUpdateStep> newBranchOfTasksToUpdate = new ArrayList<>(currentBranchOfTasksToUpdate);
        newBranchOfTasksToUpdate.add(newUpdateStep);

        if (newBranchOfTasksToUpdate.stream().distinct().count() != newBranchOfTasksToUpdate.size()) {
            String updatePath = newBranchOfTasksToUpdate.stream()
                    .map(TaskUpdateStep::getName)
                    .collect(Collectors.joining(" -> "));
            this.fail("Creating a cyclic dependency is not possible: " + updatePath);
        }
        if (!tasksToUpdate.contains(newUpdateStep)) {
            tasksToUpdate.add(newUpdateStep);
        }

        this.computeTaskToUpdate(targetTask, tasksToUpdate, newBranchOfTasksToUpdate);
    }

    private void fail(String message) {
        this.feedbackMessageService.addFeedbackMessage(new Message(message, MessageLevel.ERROR));
        throw new IllegalStateException();
    }

    @SuppressWarnings("checkstyle:ReturnCount")
    private List<DependencyRelatedObject> getAllTasksOfGantt(DependencyRelatedObject dependencyRelatedObject) {
        if (dependencyRelatedObject instanceof AbstractTask abstractTask) {
            return taskHelper.getParent(abstractTask, Workpackage.class)
                    .map(workpackage -> {
                        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(workpackage.eAllContents(), Spliterator.ORDERED), false)
                                .filter(AbstractTask.class::isInstance)
                                .map(DependencyRelatedObject.class::cast)
                                .toList();
                    })
                    .orElse(List.of());
        } else if (dependencyRelatedObject instanceof Workpackage workpackage) {
            return taskHelper.getParent(workpackage, Project.class)
                    .map(project -> {
                        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(project.eAllContents(), Spliterator.ORDERED), false)
                                .filter(Workpackage.class::isInstance)
                                .map(DependencyRelatedObject.class::cast)
                                .toList();
                    })
                    .orElse(List.of());
        }
        return List.of();
    }

    public void updateTasksWithImpacts(Person updatePerson) {
        Map<Object, List<DependencyRelatedObject>> rootToAnyTask = new LinkedHashMap<>();
        simpleCrossReferenceProvider.getInverseReferences(updatePerson).stream()
                .map(EStructuralFeature.Setting::getEObject)
                .filter(DependencyRelatedObject.class::isInstance)
                .map(DependencyRelatedObject.class::cast)
                .forEach(dependencyRelatedObject -> {
                    if (dependencyRelatedObject instanceof AbstractTask abstractTask) {
                        taskHelper.getParent(abstractTask, Workpackage.class)
                                .ifPresent(workpackage ->
                                        rootToAnyTask.computeIfAbsent(workpackage, k -> new ArrayList<>())
                                                .add((DependencyRelatedObject) abstractTask));
                    } else if (dependencyRelatedObject instanceof Workpackage workpackage) {
                        taskHelper.getParent(workpackage, Project.class)
                                .ifPresent(project ->
                                        rootToAnyTask.computeIfAbsent(project, k -> new ArrayList<>())
                                                .add(workpackage));
                    }
                });

        rootToAnyTask.forEach((object, dependencyRelatedObjects) -> {
            Comparator<Temporal> temporalComparator = Comparator.comparing(temporal -> (Comparable<Object>) temporal);
            Optional<Temporal> minTemporal = dependencyRelatedObjects.stream()
                    .map(taskHelper::getStartTemporal)
                    .filter(Objects::nonNull)
                    .min(temporalComparator);

            if (minTemporal.isEmpty()) {
                return;
            }

            this.updateTasksAfterGivenTemporal(dependencyRelatedObjects.get(0), minTemporal.get(), List.of());
        });
    }

    private void updateTasksAfterGivenTemporal(DependencyRelatedObject aTaskInGantt, Temporal minTemporal, Collection<TaskUpdateStep> preleminaryTaskUpdateSteps) {
        try {
            Comparator<Temporal> temporalComparator = Comparator.comparing(temporal -> (Comparable<Object>) temporal);
            List<TaskUpdateStep> taskUpdateStepsInGantt = this.getAllTasksOfGantt(aTaskInGantt).stream()
                    .filter(task -> {
                        Temporal startTemporal = taskHelper.getStartTemporal(task);
                        return startTemporal != null && temporalComparator.compare(startTemporal, minTemporal) >= 0;
                    })
                    .flatMap(task -> {
                        List<TaskUpdateStep> updateSteps = new ArrayList<>();
                        if (!task.getDependencies().isEmpty()) {
                            updateSteps.add(new DependencyUpdateStep(task));
                            this.computeTaskToUpdate(task, updateSteps, List.copyOf(updateSteps));
                        } else if (task instanceof AssignableObject assignableObject && !assignableObject.getAssignedPersons().isEmpty()) {
                            updateSteps.add(new PersonUpdateStep(task));
                            this.computeTaskToUpdate(task, updateSteps, List.copyOf(updateSteps));
                        }
                        return updateSteps.stream();
                    })
//                    .sorted(Comparator.comparing((TaskUpdateStep taskUpdateStep) -> taskHelper.getStartTemporal((DependencyRelatedObject) taskUpdateStep.getImpactedTask()), temporalComparator))
                    .toList();

            Collection<TaskUpdateStep> taskUpdateSteps = Stream.concat(preleminaryTaskUpdateSteps.stream(), taskUpdateStepsInGantt.stream())
                    .toList();

            LinkedHashSet<TaskUpdateStep> orderedTaskUpdateSteps = this.filterAndOrderTaskUpdateSteps(taskUpdateSteps);
            orderedTaskUpdateSteps.forEach(taskUpdateStep -> {
                System.out.println(((NamedElement) taskUpdateStep.getImpactedTask()).getName() + "   " + taskUpdateStep.getClass().getSimpleName());
            });
            this.doUpdate(orderedTaskUpdateSteps);

        } catch (IllegalStateException e) {
            // logged with IFeedbackMessage;
        }
    }

    private LinkedHashSet<TaskUpdateStep> filterAndOrderTaskUpdateSteps(Collection<TaskUpdateStep> taskUpdateSteps) {
        // Part 1.1: keep one step per impacted task.
        // Keep the first step of the same type;
        // replace a PersonUpdateStep when another type of step manages that task.
        List<TaskUpdateStep> distinctSteps = new ArrayList<>();
        for (TaskUpdateStep replacement : taskUpdateSteps) {
            int existingIndex = -1;
            for (int index = 0; index < distinctSteps.size(); index++) {
                if (distinctSteps.get(index).getImpactedTask() == replacement.getImpactedTask()) {
                    existingIndex = index;
                    break;
                }
            }

            if (existingIndex == -1) {
                distinctSteps.add(replacement);
                continue;
            }

            TaskUpdateStep existing = distinctSteps.get(existingIndex);
            if (existing.getClass() == replacement.getClass()) {
                continue;
            }
            if (existing instanceof PersonUpdateStep) {
                distinctSteps.set(existingIndex, replacement);
            }
        }

        // Part 1.2: eliminate task with no start or end
        List<TaskUpdateStep> remainingSteps1 = distinctSteps.stream()
            .filter(taskUpdateStep -> {
                return taskHelper.getStartTemporal(taskUpdateStep.getImpactedTask()) != null || taskHelper.getEndTemporal(taskUpdateStep.getImpactedTask()) != null;
            })
            .toList();

        // Part 2.1: order from the oldest to the most recent.
        Comparator<Temporal> temporalComparator = Comparator.comparing(temporal -> (Comparable<Object>) temporal);
        List<TaskUpdateStep> remainingStep2s = new ArrayList<>(remainingSteps1.stream()
                .sorted(Comparator.comparing((TaskUpdateStep taskUpdateStep) -> taskHelper.getStartTemporal(taskUpdateStep.getImpactedTask()), temporalComparator))
                .toList());


        // Part 2.2: move higher-priority steps before lower-priority steps.
        List<TaskUpdateStep> remainingSteps = new ArrayList<>();
        List<TaskUpdateStep> pendingSteps = new ArrayList<>(remainingStep2s);
        while (!pendingSteps.isEmpty()) {
            TaskUpdateStep nextStep = pendingSteps.stream()
                    .filter(step -> pendingSteps.stream().noneMatch(otherStep -> otherStep != step && this.hasHigherPriority(otherStep, step)))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Cannot order task updates: cyclic step priorities."));
            remainingSteps.add(nextStep);
            // Remove this instance, since different step types may compare equal.
            pendingSteps.removeIf(step -> step == nextStep);
        }

        // Part 2.3: order descendants before their ParentUpdateStep.
        LinkedHashSet<TaskUpdateStep> orderedSteps = new LinkedHashSet<>();
        while (!remainingSteps.isEmpty()) {
            // Take the first available step, deferring parents until all descendants have been placed.
            TaskUpdateStep nextStep = remainingSteps.stream()
                    .filter(step -> !(step instanceof ParentUpdateStep) || remainingSteps.stream().noneMatch(otherStep ->
                            otherStep.getImpactedTask() != step.getImpactedTask()
                                    && EcoreUtil.isAncestor((EObject) step.getImpactedTask(), (EObject) otherStep.getImpactedTask())))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Cannot order task updates: cyclic task containment."));
            orderedSteps.add(nextStep);
            remainingSteps.remove(nextStep);
        }
        return orderedSteps;
    }

    private boolean hasHigherPriority(TaskUpdateStep step, TaskUpdateStep otherStep) {
        boolean hasHigherPriority = this.getStepPriority(step) > this.getStepPriority(otherStep);
        if (!hasHigherPriority) {
            if (otherStep instanceof DependencyUpdateStep otherUpdateStep) {
                if (otherUpdateStep.getImpactedTask() instanceof DependencyRelatedObject dependencyRelatedObject) {
                    hasHigherPriority = dependencyRelatedObject.getDependencies().stream()
                            .anyMatch(dependencyLink -> step.getImpactedTask().equals(dependencyLink.getSource()));
                }
            }
        }

        return hasHigherPriority;
    }

    private int getStepPriority(TaskUpdateStep step) {
        if (IMPACTED_STEPS.contains(step.getClass())) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }
}

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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.eclipse.sirius.components.representations.Message;
import org.eclipse.sirius.components.representations.MessageLevel;
import org.springframework.stereotype.Service;

import pepper.domain.services.TaskComputationService;
import pepper.domain.services.TaskHelper;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
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

    private final TaskHelper taskHelper = new TaskHelper();

    private final SimpleCrossReferenceProvider simpleCrossReferenceProvider = new SimpleCrossReferenceProvider();

    private final IFeedbackMessageService feedbackMessageService;

    private final TaskComputationService taskComputationService = new TaskComputationService();

    private final WorkpackageComputationService workpackageComputationService = new WorkpackageComputationService();

    public TaskUpdateService(IFeedbackMessageService feedbackMessageService) {
        this.feedbackMessageService = Objects.requireNonNull(feedbackMessageService);
    }

    public void updateWithImpacts(EObject task, TaskUpdateStep taskUpdateStep) {
        this.updateWithImpacts(task, List.of(taskUpdateStep));
    }

    public void updateWithImpacts(EObject task, List<TaskUpdateStep> taskUpdateSteps) {
        List<TaskUpdateStep> tasksToUpdate = new ArrayList<>(taskUpdateSteps);
        List<TaskUpdateStep> currentBranchOfTasksToUpdate = new ArrayList<>(tasksToUpdate);
        try {
            this.computeTaskToUpdate(task, tasksToUpdate, currentBranchOfTasksToUpdate);
            this.doUpdate(tasksToUpdate);
        } catch (IllegalStateException e) {
            // logged in IFeedbackMessageService
        }
    }

    private void doUpdate(Collection<TaskUpdateStep> tasksToUpdate) {
        tasksToUpdate.forEach(TaskUpdateStep::update);
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

    public void updateTasksFollowingPersonChange(DependencyRelatedObject task) {
        this.updateTasksAfterGivenTemporal(task, taskHelper.getStartTemporal(task));
    }

    public void updateTasksFollowingPersonChange(Person updatePerson) {
        List<DependencyRelatedObject> tasksToUpdate = simpleCrossReferenceProvider.getInverseReferences(updatePerson).stream()
                .map(EStructuralFeature.Setting::getEObject)
                .filter(DependencyRelatedObject.class::isInstance)
                .map(DependencyRelatedObject.class::cast)
                .toList();

        Comparator<Temporal> temporalComparator = Comparator.comparing(temporal -> (Comparable<Object>) temporal);
        Optional<Temporal> minTemporal = tasksToUpdate.stream()
                .map(taskHelper::getStartTemporal)
                .filter(Objects::nonNull)
                .min(temporalComparator);

        if (minTemporal.isEmpty()) {
            return;
        }

        this.updateTasksAfterGivenTemporal(tasksToUpdate.get(0), minTemporal.get());
    }

    private void updateTasksAfterGivenTemporal(DependencyRelatedObject task, Temporal minTemporal) {
        Comparator<Temporal> temporalComparator = Comparator.comparing(temporal -> (Comparable<Object>) temporal);
        Collection<TaskUpdateStep> taskUpdateSteps = this.getAllTasksOfGantt(task).stream()
                .filter(dependencyRelatedObject -> {
                    Temporal startTemporal = taskHelper.getStartTemporal(dependencyRelatedObject);
                    return startTemporal != null && temporalComparator.compare(startTemporal, minTemporal) >= 0;
                })
                .flatMap(dependencyRelatedObject -> {
                    List<TaskUpdateStep> updateSteps = new ArrayList<>(List.of(new SimpleUpdateStep(dependencyRelatedObject)));
                    this.computeTaskToUpdate(dependencyRelatedObject, updateSteps, List.copyOf(updateSteps));
                    return updateSteps.stream();
                })
                .sorted(Comparator.comparing((TaskUpdateStep taskUpdateStep) -> taskHelper.getStartTemporal((DependencyRelatedObject) taskUpdateStep.getImpactedTask()), temporalComparator))
                .toList();
        LinkedHashSet<TaskUpdateStep> orderedTaskUpdateSteps = this.filterAndOrderTaskUpdateSteps(taskUpdateSteps);
        orderedTaskUpdateSteps.forEach(taskUpdateStep -> {
            System.out.println(((NamedElement) taskUpdateStep.getImpactedTask()).getName() + "   " + taskUpdateStep.getClass().getSimpleName());
        });
        this.doUpdate(orderedTaskUpdateSteps);
    }

    private LinkedHashSet<TaskUpdateStep> filterAndOrderTaskUpdateSteps(Collection<TaskUpdateStep> taskUpdateSteps) {
        // Part 1: eliminate identical steps (same type and same impacted task).
        List<TaskUpdateStep> distinctSteps = new ArrayList<>();
        for (TaskUpdateStep step : taskUpdateSteps) {
            boolean alreadyPresent = distinctSteps.stream().anyMatch(otherStep -> otherStep.getClass() == step.getClass()
                    && otherStep.getImpactedTask() == step.getImpactedTask());
            if (!alreadyPresent) {
                distinctSteps.add(step);
            }
        }

        // Part 2: reduce to the preferred step per task, preserving first encounter order.
        List<TaskUpdateStep> remainingSteps = new ArrayList<>();
        for (TaskUpdateStep step : distinctSteps) {
            boolean taskAlreadyPresent = remainingSteps.stream().anyMatch(otherStep -> otherStep.getImpactedTask() == step.getImpactedTask());
            if (!taskAlreadyPresent) {
                TaskUpdateStep preferredStep = distinctSteps.stream()
                        .filter(otherStep -> otherStep.getImpactedTask() == step.getImpactedTask())
                        .reduce(step, this::getPreferredTaskUpdateStep);
                remainingSteps.add(preferredStep);
            }
        }

        // Part 3: order descendants before their ParentUpdateStep.
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

    @SuppressWarnings("checkstyle:ReturnCount")
    private TaskUpdateStep getPreferredTaskUpdateStep(TaskUpdateStep currentTaskUpdateStep, TaskUpdateStep candidateTaskUpdateStep) {
        if (currentTaskUpdateStep instanceof DependencyUpdateStep) {
            return currentTaskUpdateStep;
        }
        if (candidateTaskUpdateStep instanceof DependencyUpdateStep
                || candidateTaskUpdateStep instanceof ParentUpdateStep && currentTaskUpdateStep instanceof SimpleUpdateStep) {
            return candidateTaskUpdateStep;
        }
        return currentTaskUpdateStep;
    }

}

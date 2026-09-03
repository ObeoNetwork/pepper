/*******************************************************************************
 * Copyright (c) 2024, 2026 CEA LIST.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 ******************************************************************************/
package pepper.starter.services.representations;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.eclipse.sirius.components.representations.Message;
import org.eclipse.sirius.components.representations.MessageLevel;

import pepper.domain.services.TaskComputationService;
import pepper.domain.services.WorkpackageComputationService;
import pepper.domain.services.update.CreateDependencyUpdateStep;
import pepper.domain.services.update.DependencyUpdateStep;
import pepper.domain.services.update.TaskBoundaryUpdateStep;
import pepper.domain.services.update.TaskUpdateService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Project;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.Task;
import pepper.peppermm.Workpackage;

/**
 * Java Service for the task related views.
 *
 * @author lfasani
 */
public class PepperMMJavaService {

    private static final String NEW_TASK = "New Task";

    private final SimpleCrossReferenceProvider simpleCrossReferenceProvider = new SimpleCrossReferenceProvider();

    private final IFeedbackMessageService feedbackMessageService;

    private final TaskComputationService taskComputationService = new TaskComputationService();

    private final WorkpackageComputationService workpackageComputationService = new WorkpackageComputationService();

    private final TaskUpdateService taskUpdateService;

    public PepperMMJavaService(IFeedbackMessageService feedbackMessageService, TaskUpdateService taskUpdateService) {
        this.feedbackMessageService = Objects.requireNonNull(feedbackMessageService);
        this.taskUpdateService = taskUpdateService;
    }

//    private static Instant getTaskStartTime(Task task) {
//        if (task.isComputeStartEndDynamically()) {
//            return task.getSubTasks().stream()
//                    .map(PepperMMJavaService::getTaskStartTime)
//                    .min(Instant::compareTo)
//                    .orElse(task.getStartTime());
//        }
//        return task.getStartTime();
//    }

    public void editTask(EObject eObject, String name, String description, Instant startTime, Instant endTime, Integer progress, boolean keepEffort) {

        if (eObject instanceof Task task) {
            taskUpdateService.updateWithImpacts(task, new TaskBoundaryUpdateStep(task, startTime, endTime));

            if (name != null) {
                task.setName(name);
            }
            if (progress != null) {
                task.setProgress(progress);
            }
            if (description != null) {
                task.setDescription(description);
            }
        }
    }

    private void setTaskEffort(Task task, Instant start, Instant end) {
        int effort = (int) ChronoUnit.HOURS.between(start, end) + 1; //+1 because between(00:00, 00:59) = 0. We want 1.
        taskComputationService.updateEffort(task, effort);
    }

    public void createTask(EObject context) {
        if (context instanceof AbstractTask abstractTask) {
            Task task = PepperFactory.eINSTANCE.createTask();
            task.setName(NEW_TASK);
            // The new task follows the last sub-task.
            Optional<Task> optionalTask = abstractTask.getSubTasks().stream().reduce((first, second) -> second)
                    .filter(filteredTask -> filteredTask.getEndTime() != null && filteredTask.getStartTime() != null);

            if (optionalTask.isPresent()) {
                Task lastTask = optionalTask.get();
                if (lastTask.getEndTime().equals(lastTask.getStartTime())) {
                    // If the last task is a Milestone
                    taskComputationService.updateStartTime(task, lastTask.getEndTime());
                    taskComputationService.updateEndTime(task, lastTask.getEndTime());
                } else {
                    taskComputationService.updateStartTime(task, lastTask.getEndTime().plus(1, ChronoUnit.MINUTES));
                    taskComputationService.updateEndTime(task,
                            Instant.ofEpochSecond(2 * lastTask.getEndTime().getEpochSecond() - lastTask.getStartTime().getEpochSecond()).plus(1, ChronoUnit.MINUTES));
                }
            } else {
                if (abstractTask.getEndTime() != null && abstractTask.getStartTime() != null) {
                    taskComputationService.updateStartTime(task, abstractTask.getStartTime());
                    taskComputationService.updateEndTime(task, abstractTask.getEndTime());
                }
            }
            abstractTask.getSubTasks().add(task);
            int levelLayer = 1;
            var parent = context.eContainer();
            while (!(parent instanceof Workpackage)) {
                levelLayer++;
                parent = parent.eContainer();
            }
            if (levelLayer == 4) {
                this.feedbackMessageService.addFeedbackMessage(new Message("Gantt can not display more than 4 levels of tasks. So the created task is not displayed.", MessageLevel.WARNING));
            }
        } else if (context instanceof Workpackage workpackage) {
            Task newTask = taskComputationService.createNewTask(workpackage, NEW_TASK);

            workpackage.getOwnedTasks().add(newTask);
        }
    }

    /**
     * Delete a given {@link DependencyRelatedObject} and all {@link DependencyLink} related to it. Then update all dependency placement of its dependent objects.
     *
     * @param taskToDelete
     *         the task to delete
     */
    public void deleteDependencyRelatedObject(DependencyRelatedObject taskToDelete) {
        List<DependencyRelatedObject> otherTasksToDelete = StreamSupport.stream(Spliterators.spliteratorUnknownSize(taskToDelete.eAllContents(), Spliterator.ORDERED), false)
                .filter(DependencyRelatedObject.class::isInstance)
                .map(DependencyRelatedObject.class::cast)
                .toList();
        List<DependencyRelatedObject> allTasksToDelete = new ArrayList<>(otherTasksToDelete);
        allTasksToDelete.add(taskToDelete);

        List<DependencyLink> dependencyLinkOfNotDeletedImpactedObjects = allTasksToDelete.stream()
                .flatMap(dependencyRelatedObject -> {
                    return simpleCrossReferenceProvider.getInverseReferences(dependencyRelatedObject).stream()
                            .map(setting -> {
                                if (setting.getEObject() instanceof DependencyLink dependencyLink) {
                                    return dependencyLink;
                                }
                                return null;
                            });
                })
                .filter(Objects::nonNull)
                .filter(dependencyLink -> !otherTasksToDelete.contains(dependencyLink.eContainer()))
                .toList();

        List<DependencyRelatedObject> otherImpactedTasks = dependencyLinkOfNotDeletedImpactedObjects.stream()
                .map(EObject::eContainer)
                .filter(DependencyRelatedObject.class::isInstance)
                .map(DependencyRelatedObject.class::cast)
                .toList();

        dependencyLinkOfNotDeletedImpactedObjects.forEach(EcoreUtil::delete);
        EcoreUtil.delete(taskToDelete, true);

        otherImpactedTasks.forEach(dependencyRelatedObject -> taskUpdateService.updateWithImpacts(dependencyRelatedObject, new DependencyUpdateStep(dependencyRelatedObject)));
    }

    /**
     * Deletes the {@link DependencyLink} between the specified source and target {@link DependencyRelatedObject}s.
     * <p>
     * Then the target object's placement is then updated according to its remaining dependencies.
     *
     * @param target
     *         the dependency target
     * @param source
     *         the dependency source
     */
    public void deleteDependencyLink(DependencyRelatedObject source, DependencyRelatedObject target) {
        target.getDependencies().removeIf(dep -> dep.getSource().equals(source));
        taskUpdateService.updateWithImpacts(target, new DependencyUpdateStep(target));
    }

    public void createDependencyLink(DependencyRelatedObject source, DependencyRelatedObject target, org.eclipse.sirius.components.gantt.StartOrEnd sourceStartOrEnd,
            org.eclipse.sirius.components.gantt.StartOrEnd targetStartOrEnd) {

        if (target instanceof Task targetTask && targetTask.isComputeStartEndDynamically()) {
            this.feedbackMessageService.addFeedbackMessage(new Message("Creating a dependency targeting a dynamically computed task is not possible.", MessageLevel.ERROR));
        } else {
            StartOrEnd startBoundary = StartOrEnd.START;
            if (sourceStartOrEnd.equals(org.eclipse.sirius.components.gantt.StartOrEnd.END)) {
                startBoundary = StartOrEnd.END;
            }
            StartOrEnd targetBoundary = StartOrEnd.START;
            if (targetStartOrEnd.equals(org.eclipse.sirius.components.gantt.StartOrEnd.END)) {
                targetBoundary = StartOrEnd.END;
            }

            taskUpdateService.updateWithImpacts(target, List.of(
                    new CreateDependencyUpdateStep(source, target, startBoundary, targetBoundary),
                    new DependencyUpdateStep(target)));

        }
    }

    public void moveTaskIntoTarget(Task sourceTask, EObject target, int indexInTarget) {
        if (target instanceof Task targetTask) {
            // check that the target is not a child of the dropped task
            boolean targetIsChildOfTheDroppedTask = false;
            EObject container = target.eContainer();
            while (container != null) {
                if (container.equals(sourceTask)) {
                    targetIsChildOfTheDroppedTask = true;
                    break;
                }
                container = container.eContainer();
            }
            if (targetIsChildOfTheDroppedTask) {
                this.feedbackMessageService.addFeedbackMessage(new Message("Moving a task inside a sub-task is not possible.", MessageLevel.WARNING));
            } else {
                this.moveTaskInSubTasks(sourceTask, indexInTarget, targetTask);
            }
        } else if (target instanceof Workpackage workpackage) {
            EList<Task> ownedTasks = workpackage.getOwnedTasks();
            if (ownedTasks.contains(sourceTask)) {
                int indexOfSource = ownedTasks.indexOf(sourceTask);
                if (indexOfSource < indexInTarget) {
                    ownedTasks.move(indexInTarget - 1, sourceTask);
                } else {
                    ownedTasks.move(indexInTarget, sourceTask);
                }
            } else {
                workpackage.getOwnedTasks().add(indexInTarget, sourceTask);
            }
        }
    }

    public void createWorkpackage(EObject context) {
        Workpackage newWorkpackage = PepperFactory.eINSTANCE.createWorkpackage();
        newWorkpackage.setName("New Workpackage");
        if (context instanceof Workpackage workpackage) {
            // The new task follows the context task and has the same effort than the context task.
            if (workpackage.getEndDate() != null && workpackage.getStartDate() != null) {
                workpackageComputationService.updateStartDate(newWorkpackage, workpackage.getEndDate());
                workpackageComputationService.updateEndDate(newWorkpackage, workpackage.getEndDate().plusDays(workpackage.getEndDate().toEpochDay() - workpackage.getStartDate().toEpochDay()));
            }

            EObject parent = context.eContainer();
            if (parent instanceof Project project) {
                int index = project.getOwnedWorkpackages().indexOf(context);
                project.getOwnedWorkpackages().add(index + 1, newWorkpackage);
            }
        } else if (context instanceof Project project) {
            LocalDate now = LocalDate.now();
            workpackageComputationService.updateStartDate(newWorkpackage, now);
            workpackageComputationService.updateEndDate(newWorkpackage, now.plusDays(28));

            project.getOwnedWorkpackages().add(newWorkpackage);
        }
    }

    public void deleteWorkpackage(EObject context) {
        if (context instanceof Workpackage sourceWorkpackage) {
            EcoreUtil.delete(sourceWorkpackage, true);
        }
    }

    public void editWorkpackage(EObject eObject, String name, String description, LocalDate startDate, LocalDate endDate, Integer progress, boolean keepEffort) {
        if (eObject instanceof Workpackage workpackage) {
            taskUpdateService.updateWithImpacts(workpackage, new TaskBoundaryUpdateStep(workpackage, startDate, endDate));

            if (name != null) {
                workpackage.setName(name);
            }
            if (progress != null) {
                workpackage.setProgress(progress);
            }
            if (description != null) {
                workpackage.setDescription(description);
            }
        }
    }

    public void moveWorkpackageInProject(Workpackage sourceWorkpackage, Project project, int indexInTarget) {
        EList<Workpackage> ownedWorkpackages = project.getOwnedWorkpackages();
        if (ownedWorkpackages.contains(sourceWorkpackage)) {
            int indexOfSource = ownedWorkpackages.indexOf(sourceWorkpackage);
            if (indexOfSource < indexInTarget) {
                ownedWorkpackages.move(indexInTarget - 1, sourceWorkpackage);
            } else {
                ownedWorkpackages.move(indexInTarget, sourceWorkpackage);
            }
        } else {
            project.getOwnedWorkpackages().add(indexInTarget, sourceWorkpackage);
        }
    }

    private void moveTaskInSubTasks(Task sourceTask, int indexInTarget, Task targetTask) {
        List<Task> subTasks = targetTask.getSubTasks();
        if (subTasks.contains(sourceTask)) {
            if (indexInTarget >= 0 && indexInTarget <= subTasks.size()) {
                int indexOfSource = subTasks.indexOf(sourceTask);
                if (indexOfSource < indexInTarget) {
                    targetTask.getSubTasks().move(indexInTarget - 1, sourceTask);
                } else {
                    targetTask.getSubTasks().move(indexInTarget, sourceTask);
                }
            } else {
                targetTask.getSubTasks().move(subTasks.size() - 1, sourceTask);
            }
        } else {
            boolean targetHadNoChild = subTasks.isEmpty();
            if (targetHadNoChild) {
                targetTask.setComputeStartEndDynamically(true);
            }
            if (indexInTarget >= 0 && indexInTarget <= targetTask.getSubTasks().size()) {
                targetTask.getSubTasks().add(indexInTarget, sourceTask);
            } else {
                targetTask.getSubTasks().add(sourceTask);
            }
        }
    }
}

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
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.eclipse.sirius.components.representations.Message;
import org.eclipse.sirius.components.representations.MessageLevel;

import pepper.domain.services.TaskComputationService;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Project;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;
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

    private final TaskComputationService taskComputationService;

    private final WorkpackageComputationService workpackageComputationService;

    private final ZoneId zone = ZoneId.systemDefault();

    public PepperMMJavaService(IFeedbackMessageService feedbackMessageService, TaskComputationService taskComputationService, WorkpackageComputationService workpackageComputationService) {
        this.feedbackMessageService = Objects.requireNonNull(feedbackMessageService);
        this.taskComputationService = taskComputationService;
        this.workpackageComputationService = workpackageComputationService;
    }

    private static Instant getTaskStartTime(Task task) {
        if (task.isComputeStartEndDynamically()) {
            return task.getSubTasks().stream()
                    .map(PepperMMJavaService::getTaskStartTime)
                    .min(Instant::compareTo)
                    .orElse(task.getStartTime());
        }
        return task.getStartTime();
    }

    private static Instant getTaskEndTime(Task task) {
        if (task.isComputeStartEndDynamically()) {
            return task.getSubTasks().stream()
                    .map(PepperMMJavaService::getTaskEndTime)
                    .max(Instant::compareTo)
                    .orElse(task.getEndTime());
        }
        return task.getEndTime();
    }

    private static Instant getlaterInstant(DependencyLink dep) {
        Instant laterInstant = null;
        Task source = (Task) dep.getSource();
        if (dep.getSourceKind() == StartOrEnd.END) {
            laterInstant = getTaskEndTime(source).plus(dep.getDelay(), ChronoUnit.HOURS);
        } else if (dep.getSourceKind() == StartOrEnd.START) {
            laterInstant = getTaskStartTime(source).plus(dep.getDelay(), ChronoUnit.HOURS);
        }
        return laterInstant;
    }

    @SuppressWarnings({ "checkstyle:NestedIfDepth", "checkstyle:MethodLength", "checkstyle:MissingSwitchDefault" })
    public void editTask(EObject eObject, String name, String description, Instant startTime, Instant endTime, Integer progress, boolean keepEffort) {
        if (eObject instanceof Task task) {
            if (name != null) {
                task.setName(name);
            }
            if (description != null) {
                task.setDescription(description);
            }
            if (endTime != null && startTime != null) {
                Instant newStartTime = taskComputationService.roundToNearestHalfDay(startTime);
                Instant newEndTime = taskComputationService.roundToNearestHalfDay(endTime);
                long differenceStart = newStartTime.getEpochSecond() - taskComputationService.roundToNearestHalfDay(task.getStartTime()).getEpochSecond();
                long differenceEnd = newEndTime.getEpochSecond() - taskComputationService.roundToNearestHalfDay(task.getEndTime()).getEpochSecond();
                boolean taskShifted = differenceStart != 0 && differenceEnd != 0;
                List<DependencyLink> dependencies = task.getDependencies();
                // Nothing is done when moving a task constrained by dependencies
                if (dependencies.isEmpty() || !taskShifted) {
                    boolean startTimeControlledByDependency =
                            dependencies.stream()
                                    .anyMatch(dep -> dep.getTargetKind() == StartOrEnd.START);

                    boolean endTimeControlledByDependency =
                            dependencies.stream()
                                    .anyMatch(dep -> dep.getTargetKind() == StartOrEnd.END);

                    if (taskShifted) {
                        if (dependencies.isEmpty()) {
                            TaskTimeBoundariesConstraint calculationOption = task.getCalculationOption();
                            switch (calculationOption) {
                                case START_EFFORT -> taskComputationService.updateStartTime(task, newStartTime);
                                case END_EFFORT -> taskComputationService.updateEndTime(task, newEndTime);
                                case START_END -> {
                                    taskComputationService.updateStartTime(task, newStartTime);
                                    taskComputationService.updateEndTime(task, newEndTime);
                                }
                            }
                            this.followMoveDependency(task);
                        }
                    } else {
                        if (differenceStart != 0 && !startTimeControlledByDependency) {
                            taskComputationService.updateStartTime(task, newStartTime);
                            this.followMoveDependency(task);
                        }

                        if (differenceEnd != 0 && !endTimeControlledByDependency) {
                            taskComputationService.updateEndTime(task, newEndTime);
                            this.followMoveDependency(task);
                        }
                    }

                }
            }
            if (progress != null) {
                task.setProgress(progress);
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
     * @param context
     *         the object to delete
     */
    public void deleteDependencyRelatedObject(EObject context) {
        if (context instanceof DependencyRelatedObject source) {
            List<DependencyRelatedObject> targetDependencies = new ArrayList<>();
            List<DependencyLink> sourceDependencies = source.getDependencies();

            Collection<EStructuralFeature.Setting> sourceInverseReferences = simpleCrossReferenceProvider.getInverseReferences(source);
            for (EStructuralFeature.Setting sourceInverseReference : sourceInverseReferences) {
                if (sourceInverseReference.getEObject() instanceof DependencyLink dependencyLink) {
                    if (dependencyLink.eContainer() instanceof DependencyRelatedObject object) {
                        targetDependencies.add(object);
                    }
                    EcoreUtil.delete(dependencyLink, true);
                }
            }
            if (source instanceof Task task) {
                for (Task subTask : task.getSubTasks()) {
                    targetDependencies.addAll(this.getAllDependencyTargetTask(new LinkedHashSet<>(), subTask));
                }
            }

            EcoreUtil.delete(source, true);

            for (DependencyLink sourceDependencyLink : sourceDependencies) {
                this.followMoveDependency(sourceDependencyLink.getSource());
            }
            for (DependencyRelatedObject targetDependency : targetDependencies) {
                List<DependencyLink> dependencyLinksOfTargetDependencies = targetDependency.getDependencies();
                for (DependencyLink dependencyLinksOfTargetDependency : dependencyLinksOfTargetDependencies) {
                    this.followMoveDependency(dependencyLinksOfTargetDependency.getSource());
                }
            }
        }
    }

    private LinkedHashSet<Task> getAllDependencyTargetTask(LinkedHashSet<Task> targetTasks, Task task) {

        Collection<EStructuralFeature.Setting> sourceInverseReferences = simpleCrossReferenceProvider.getInverseReferences(task);
        for (EStructuralFeature.Setting sourceInverseReference : sourceInverseReferences) {
            if (sourceInverseReference.getEObject() instanceof DependencyLink dependencyLink) {
                if (dependencyLink.eContainer() instanceof Task object) {
                    targetTasks.add(object);
                }
                EcoreUtil.delete(dependencyLink, true);
            }
        }

        for (Task subTask : task.getSubTasks()) {
            this.getAllDependencyTargetTask(targetTasks, subTask);
        }
        return targetTasks;
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
    public void deleteDependencyLink(EObject target, EObject source) {
        if (target instanceof DependencyRelatedObject targetObject) {
            if (source instanceof DependencyRelatedObject sourceObject) {
                targetObject.getDependencies().removeIf(dep -> dep.getSource().equals(sourceObject));
            }

            for (DependencyLink targetDependencyLink : targetObject.getDependencies()) {
                this.followMoveDependency(targetDependencyLink.getSource());
            }
        }
    }

    public void createDependencyLink(EObject source, EObject target, org.eclipse.sirius.components.gantt.StartOrEnd sourceStartOrEnd, org.eclipse.sirius.components.gantt.StartOrEnd targetStartOrEnd) {
        DependencyLink dependencyLink = PepperFactory.eINSTANCE.createDependencyLink();
        if (sourceStartOrEnd.equals(org.eclipse.sirius.components.gantt.StartOrEnd.END)) {
            dependencyLink.setSourceKind(StartOrEnd.END);
        } else {
            dependencyLink.setSourceKind(StartOrEnd.START);
        }
        if (targetStartOrEnd.equals(org.eclipse.sirius.components.gantt.StartOrEnd.START)) {
            dependencyLink.setTargetKind(StartOrEnd.START);
        } else {
            dependencyLink.setTargetKind(StartOrEnd.END);
        }
        if (source instanceof DependencyRelatedObject sourceObject) {
            dependencyLink.setSource(sourceObject);
            if (target instanceof DependencyRelatedObject targetObject) {
                //Ensure no dependency already exists between source and target to prevent duplicates or cycles
                if (!this.isDuplicateOrCycle(sourceObject, targetObject)) {
                    //Ensure the target task is not computed dynamically
                    if (targetObject instanceof Task targetTask && targetTask.isComputeStartEndDynamically()) {
                        this.feedbackMessageService.addFeedbackMessage(new Message("Creating a dependency targeting a dynamically computed task is not possible.", MessageLevel.ERROR));
                    } else {
                        targetObject.getDependencies().add(dependencyLink);
                        this.followMoveDependency(sourceObject);
                    }
                }
            }
        }
    }

    /**
     * Checks if the source task already depends on one of the target task's ancestor tasks.
     *
     * @param sourceObject
     *         the {@link DependencyRelatedObject} source
     * @param parent
     *         the parent {@link Task} of the target
     * @return {@code true} if the source already depends on the specified parent or one of its ancestors; {@code false} otherwise
     */
    private boolean isParentCycle(DependencyRelatedObject sourceObject, Task parent) {
        for (DependencyLink dep : sourceObject.getDependencies()) {
            if (dep.getSource().equals(parent)) {
                return true;
            }
        }
        boolean isParentCycle = false;
        if (parent.eContainer() instanceof Task grandParent) {
            isParentCycle = this.isParentCycle(sourceObject, grandParent);
        }
        return isParentCycle;
    }

    private boolean isCycle(DependencyRelatedObject sourceObject, DependencyRelatedObject targetObject) {
        boolean isCycle = false;
        for (DependencyLink dep : sourceObject.getDependencies()) {
            if (dep.getSource().equals(targetObject)) {
                isCycle = true;
            } else if (!isCycle) {
                isCycle = this.isCycle(dep.getSource(), targetObject);
            }
        }
        return isCycle;
    }

    /**
     * Validates a dependency creation request.
     *
     * @param sourceObject
     *         the dependency source
     * @param targetObject
     *         the dependency target
     * @return {@code true} if the dependency is invalid because it would create a cycle or duplicate a dependency; {@code false} otherwise
     */
    private boolean isDuplicateOrCycle(DependencyRelatedObject sourceObject, DependencyRelatedObject targetObject) {
        //to prevent cycles
        boolean isParentChildDependency = sourceObject.equals(targetObject.eContainer()) || targetObject.equals(sourceObject.eContainer());
        boolean isParentCycle = false;
        if (targetObject.eContainer() instanceof Task parent) {
            isParentCycle = this.isParentCycle(sourceObject, parent);
        }

        boolean isCycle = this.isCycle(sourceObject, targetObject);

        if (isParentChildDependency) {
            this.feedbackMessageService.addFeedbackMessage(new Message("Creating a dependency between a parent task and one of its children is not possible.", MessageLevel.ERROR));
        }
        if (isParentCycle) {
            this.feedbackMessageService.addFeedbackMessage(
                    new Message("Creating a dependency when the source task already depends on one of the target task's parent tasks is not possible", MessageLevel.ERROR));
        }
        if (isCycle) {
            this.feedbackMessageService.addFeedbackMessage(new Message("Creating a cyclic dependency is not possible.", MessageLevel.ERROR));
        }

        if (isCycle || isParentCycle || isParentChildDependency) {
            return true;
        } else {
            //to prevent duplicates
            boolean isDuplicate = false;
            for (DependencyLink dep : targetObject.getDependencies()) {
                if (dep.getSource().equals(sourceObject)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                this.feedbackMessageService.addFeedbackMessage(new Message("Creating a duplicated dependency is not possible.", MessageLevel.ERROR));
            }
            return isDuplicate;
        }
    }

    /**
     * Finds all {@link DependencyRelatedObject} instances that depend on the given {@link DependencyRelatedObject} and update them according to their dependency relationships.
     *
     * @param sourceObject
     *         the object that has been moved
     */
    public void followMoveDependency(DependencyRelatedObject sourceObject) {
        List<Task> targetTasks = new ArrayList<>();
        List<Workpackage> targetWorkpackages = new ArrayList<>();
        //get all tasks pointed by sourceTask
        for (var inverseReference : simpleCrossReferenceProvider.getInverseReferences(sourceObject)) {
            if (inverseReference.getEObject() instanceof DependencyLink dep) {
                for (var inverseReferenceDependencyLink : simpleCrossReferenceProvider.getInverseReferences(dep)) {
                    var target = inverseReferenceDependencyLink.getEObject();
                    if (target instanceof Task targetTask && sourceObject instanceof Task) {
                        targetTasks.add(targetTask);
                    } else if (target instanceof Workpackage targetWorkpackage && sourceObject instanceof Workpackage) {
                        targetWorkpackages.add(targetWorkpackage);
                    }
                }
            }
        }
        if (sourceObject instanceof Task sourceTask) {
            this.followTaskMoveDependency(targetTasks, sourceTask);
            this.followMoveDependenciesParent(sourceTask);
        }
        if (sourceObject instanceof Workpackage sourceWorkpackage) {
            this.followWorkpackageMoveDependency(targetWorkpackages, sourceWorkpackage);
        }
    }

    /**
     * Updates the dates of all {@link Workpackage} that depend on the given source {@link Workpackage}.
     *
     * @param targetWorkpackages
     *         the dependent workpackages
     * @param sourceWorkpackage
     *         the workpackage that has been moved
     */
    private void followWorkpackageMoveDependency(List<Workpackage> targetWorkpackages, Workpackage sourceWorkpackage) {
        List<Workpackage> dependencies = new ArrayList<>();
        for (Workpackage workpackage : targetWorkpackages) {
            //Get the strongest dependency links
            DependencyLink winnerStart = null;
            DependencyLink winnerEnd = null;
            LocalDate laterStart = null;
            LocalDate laterEnd = null;
            for (DependencyLink dep : workpackage.getDependencies()) {
                if (dep.getTargetKind().equals(StartOrEnd.END)) {
                    LocalDate newLocalDate = this.getlaterLocalDate(dep);
                    if (laterEnd == null || laterEnd.isBefore(newLocalDate)) {
                        laterEnd = newLocalDate;
                        winnerEnd = dep;
                    }
                }
                if (dep.getTargetKind().equals(StartOrEnd.START)) {
                    LocalDate newLocalDate = this.getlaterLocalDate(dep);
                    if (laterStart == null || laterStart.isBefore(newLocalDate)) {
                        laterStart = newLocalDate;
                        winnerStart = dep;
                    }
                }
            }
            for (DependencyLink dep : workpackage.getDependencies()) {
                if ((dep.equals(winnerStart) && winnerEnd == null) || (dep.equals(winnerEnd) && winnerStart == null)) {
                    Workpackage bestSourceWorkpackage = (Workpackage) dep.getSource();
                    this.setWorkpackageNewDates(workpackage, dep);
                    if (bestSourceWorkpackage == sourceWorkpackage) {
                        dependencies.add(workpackage);
                    }
                } else if (dep.equals(winnerEnd)) {
                    Workpackage bestSourceWorkpackage = (Workpackage) dep.getSource();
                    this.setWorkpackageNewEndDate(workpackage, dep);
                    if (bestSourceWorkpackage == sourceWorkpackage) {
                        dependencies.add(workpackage);
                    }
                } else if (dep.equals(winnerStart)) {
                    Workpackage bestSourceWorkpackage = (Workpackage) dep.getSource();
                    this.setWorkpackageNewStartDate(workpackage, dep);
                    if (bestSourceWorkpackage == sourceWorkpackage) {
                        dependencies.add(workpackage);
                    }
                }
            }
            if (winnerEnd != null && winnerStart != null) {
                if (workpackage.getStartDate().isAfter(workpackage.getEndDate())) {
                    workpackageComputationService.updateEffort(workpackage, 1);
                    workpackageComputationService.updateEndDate(workpackage, workpackage.getStartDate().plusDays(1));
                    this.feedbackMessageService.addFeedbackMessage(
                            new Message("Task dependencies overlap : End date has been changed to avoid to have end date before start date.", MessageLevel.WARNING));
                }
            }
        }
        for (Workpackage workpackage : dependencies) {
            this.followMoveDependency(workpackage);
        }
    }

    /**
     * Updates the dates of all {@link Task} that depend on the given source {@link Task}.
     *
     * @param targetTasks
     *         the dependent workpackages
     * @param sourceTask
     *         the workpackage that has been moved
     */
    private void followTaskMoveDependency(List<Task> targetTasks, Task sourceTask) {
        List<Task> dependencies = new ArrayList<>();
        for (Task task : targetTasks) {
            //Get the strongest dependency links
            DependencyLink winnerStart = null;
            DependencyLink winnerEnd = null;
            Instant laterInstantStart = null;
            Instant laterInstantEnd = null;
            for (DependencyLink dep : task.getDependencies()) {
                if (dep.getTargetKind().equals(StartOrEnd.END)) {
                    Instant newInstant = getlaterInstant(dep);
                    if (laterInstantEnd == null || laterInstantEnd.isBefore(newInstant)) {
                        laterInstantEnd = newInstant;
                        winnerEnd = dep;
                    }
                }
                if (dep.getTargetKind().equals(StartOrEnd.START)) {
                    Instant newInstant = getlaterInstant(dep);
                    if (laterInstantStart == null || laterInstantStart.isBefore(newInstant)) {
                        laterInstantStart = newInstant;
                        winnerStart = dep;
                    }
                }
            }
            for (DependencyLink dep : task.getDependencies()) {
                //if the task is only pointed to one extremity
                if ((dep.equals(winnerStart) && winnerEnd == null) || (dep.equals(winnerEnd) && winnerStart == null)) {
                    Task bestSourceTask = (Task) dep.getSource();
                    this.setTaskNewDates(task, dep);
                    if (bestSourceTask == sourceTask) {
                        dependencies.add(task);
                    }
                } else if (dep.equals(winnerEnd)) {
                    Task bestSourceTask = (Task) dep.getSource();
                    this.setTaskNewEndDate(task, dep);
                    if (bestSourceTask == sourceTask) {
                        dependencies.add(task);
                    }
                } else if (dep.equals(winnerStart)) {
                    Task bestSourceTask = (Task) dep.getSource();
                    this.setTaskNewStartDate(task, dep);
                    if (bestSourceTask == sourceTask) {
                        dependencies.add(task);
                    }
                }
            }
            if (winnerEnd != null && winnerStart != null) {
                if (task.getEndTime().isBefore(task.getStartTime())) {
                    Instant newEndTime = task.getStartTime().plus(12, ChronoUnit.HOURS);
                    this.setTaskEffort(task, task.getStartTime(), newEndTime);
                    taskComputationService.updateEndTime(task, newEndTime.minus(1, ChronoUnit.MINUTES));
                    this.feedbackMessageService.addFeedbackMessage(new Message("Task dependencies overlap.", MessageLevel.ERROR));
                }
            }
        }
        for (Task task : dependencies) {
            this.followMoveDependency(task);
        }
    }

    private boolean isMilestone(Task task) {
        return task.getStartTime().equals(task.getEndTime());
    }

    private int startAdjustmentMinutes(Task sourceTask) {
        if (this.isMilestone(sourceTask)) {
            return 0;
        } else {
            return 1;
        }
    }

    private int endAdjustmentMinutes(Task sourceTask, Task targetTask) {
        int adjustment = 0;
        if (this.isMilestone(sourceTask)) {
            adjustment--;
        }
        if (this.isMilestone(targetTask)) {
            adjustment++;
        }
        return adjustment;
    }

    /**
     * Propagates dependency updates through the hierarchy of dynamically computed parent {@link Task}s.
     * <p>
     * The parent task hierarchy is traversed recursively and {@link #followMoveDependency(DependencyRelatedObject)} is invoked on each parent task.
     *
     * @param task
     *         the task from which dependency updates are propagated
     */
    public void followMoveDependenciesParent(Task task) {
        if (task.eContainer() instanceof Task parentTask) {
            if (parentTask.isComputeStartEndDynamically()) {
                this.followMoveDependency(parentTask);
                this.followMoveDependenciesParent(parentTask);
            }
        }
    }

    /**
     * Recalculates and updates the start and end dates of the specified target {@link Task} according to the given {@link DependencyLink}.
     * <p>
     * The task effort is preserved during the calculation. Only the start and end instants are shifted to satisfy the dependency constraints.
     *
     * @param task
     *         the target {@link Task} whose start and end dates must be updated according to the dependency
     * @param dep
     *         the {@link DependencyLink} defining the relationship between the source and the target tasks, including the dependency type and delay
     */
    private void setTaskNewDates(Task task, DependencyLink dep) {
        Task bestSourceTask = (Task) dep.getSource();
        Instant sourceStart = getTaskStartTime(bestSourceTask);
        Instant sourceEnd = getTaskEndTime(bestSourceTask);
        Instant oldTaskStart = task.getStartTime();
        Instant oldTaskEnd = task.getEndTime();
        int delay = dep.getDelay();
        StartOrEnd sourceStartOrEnd = dep.getSourceKind();
        StartOrEnd targetStartOrEnd = dep.getTargetKind();
        if (sourceStartOrEnd == StartOrEnd.END && targetStartOrEnd == StartOrEnd.START) {
            Instant newTaskStart = sourceEnd.plus(delay, ChronoUnit.HOURS)
                    .plus(this.startAdjustmentMinutes(bestSourceTask), ChronoUnit.MINUTES);
            taskComputationService.updateStartTime(task, newTaskStart);
        } else if (sourceStartOrEnd == StartOrEnd.START && targetStartOrEnd == StartOrEnd.START) {
            Instant newTaskStart = sourceStart.plus(delay, ChronoUnit.HOURS);
            taskComputationService.updateStartTime(task, newTaskStart);
        } else if (sourceStartOrEnd == StartOrEnd.END && targetStartOrEnd == StartOrEnd.END) {
            Instant newTaskEnd = sourceEnd.plus(delay, ChronoUnit.HOURS)
                    .plus(this.endAdjustmentMinutes(bestSourceTask, task), ChronoUnit.MINUTES);
            taskComputationService.updateEndTime(task, newTaskEnd);
        } else if (sourceStartOrEnd == StartOrEnd.START && targetStartOrEnd == StartOrEnd.END) {
            Instant newTaskEnd = sourceStart.plus(delay, ChronoUnit.HOURS).minus(1, ChronoUnit.MINUTES);
            if (this.isMilestone(task)) {
                newTaskEnd = newTaskEnd.plus(1, ChronoUnit.MINUTES);
            }
            taskComputationService.updateEndTime(task, newTaskEnd);
        }
    }

    /**
     * Given an XXX-END {@link DependencyLink}, set the new end date of a given {@link Task}
     */
    private void setTaskNewEndDate(Task task, DependencyLink dep) {
        Task bestSourceTask = (Task) dep.getSource();
        Instant sourceStart = getTaskStartTime(bestSourceTask);
        Instant sourceEnd = getTaskEndTime(bestSourceTask);
        int delay = dep.getDelay();
        StartOrEnd sourceStartOrEnd = dep.getSourceKind();
        Instant newTaskEnd = task.getEndTime();
        if (sourceStartOrEnd == StartOrEnd.END) {
            newTaskEnd = sourceEnd.plus(delay, ChronoUnit.HOURS)
                    .plus(this.endAdjustmentMinutes(bestSourceTask, task), ChronoUnit.MINUTES);
        } else if (sourceStartOrEnd == StartOrEnd.START) {
            newTaskEnd = sourceStart.plus(delay, ChronoUnit.HOURS).minus(1, ChronoUnit.MINUTES);
            if (this.isMilestone(task)) {
                newTaskEnd = newTaskEnd.plus(1, ChronoUnit.MINUTES);
            }
        }
        this.setTaskEffort(task, task.getStartTime(), newTaskEnd);
        taskComputationService.updateEndTime(task, newTaskEnd);
    }

    /**
     * Given an XXX-Start {@link DependencyLink}, set the new start date of a given {@link Task}
     */
    private void setTaskNewStartDate(Task task, DependencyLink dep) {
        Task bestSourceTask = (Task) dep.getSource();
        Instant sourceStart = getTaskStartTime(bestSourceTask);
        Instant sourceEnd = getTaskEndTime(bestSourceTask);
        int delay = dep.getDelay();
        StartOrEnd sourceStartOrEnd = dep.getSourceKind();
        Instant newTaskStart = task.getStartTime();
        if (sourceStartOrEnd == StartOrEnd.END) {
            newTaskStart = sourceEnd.plus(delay, ChronoUnit.HOURS)
                    .plus(this.startAdjustmentMinutes(bestSourceTask), ChronoUnit.MINUTES);
        } else if (sourceStartOrEnd == StartOrEnd.START) {
            newTaskStart = sourceStart.plus(delay, ChronoUnit.HOURS);
        }
        this.setTaskEffort(task, task.getStartTime(), newTaskStart);
        taskComputationService.updateStartTime(task, newTaskStart);
    }

    /**
     * Updates a {@link Workpackage} dates based on a dependency relationship.
     *
     * @param workpackage
     *         the {@link Workpackage} to update
     * @param dependencyLink
     *         the {@link DependencyLink} defining how the new dates are calculated
     */
    private void setWorkpackageNewDates(Workpackage workpackage, DependencyLink dependencyLink) {
        Workpackage bestSourceworkpackage = (Workpackage) dependencyLink.getSource();
        LocalDate sourceStart = bestSourceworkpackage.getStartDate();
        LocalDate sourceEnd = bestSourceworkpackage.getEndDate();
        LocalDate oldWorkpackageStart = workpackage.getStartDate();
        LocalDate oldWorkpackageEnd = workpackage.getEndDate();
        long effort = ChronoUnit.DAYS.between(oldWorkpackageStart, oldWorkpackageEnd);
        StartOrEnd sourceStartOrEnd = dependencyLink.getSourceKind();
        StartOrEnd targetStartOrEnd = dependencyLink.getTargetKind();
        int delay = dependencyLink.getDelay();
        if (targetStartOrEnd.equals(StartOrEnd.START)) {
            delay += 1;
        }
        if (sourceStartOrEnd.equals(StartOrEnd.START)) {
            delay -= 1;
        }
        if (sourceStartOrEnd == StartOrEnd.END && targetStartOrEnd == StartOrEnd.START) {
            LocalDate newWorkpackageStart = sourceEnd.plusDays(delay);
            LocalDate newWorkpackageEnd = newWorkpackageStart.plusDays(effort);
            workpackageComputationService.updateStartDate(workpackage, newWorkpackageStart);
        } else if (sourceStartOrEnd == StartOrEnd.START && targetStartOrEnd == StartOrEnd.START) {
            LocalDate newWorkpackageStart = sourceStart.plusDays(delay);
            LocalDate newWorkpackageEnd = newWorkpackageStart.plusDays(effort);
            workpackageComputationService.updateStartDate(workpackage, newWorkpackageStart);
        } else if (sourceStartOrEnd == StartOrEnd.END && targetStartOrEnd == StartOrEnd.END) {
            LocalDate newWorkpackageEnd = sourceEnd.plusDays(delay);
            LocalDate newWorkpackageStart = newWorkpackageEnd.minusDays(effort);
            workpackageComputationService.updateEndDate(workpackage, newWorkpackageEnd);
        } else if (sourceStartOrEnd == StartOrEnd.START && targetStartOrEnd == StartOrEnd.END) {
            LocalDate newWorkpackageEnd = sourceStart.plusDays(delay);
            LocalDate newWorkpackageStart = newWorkpackageEnd.minusDays(effort);
            workpackageComputationService.updateEndDate(workpackage, newWorkpackageEnd);
        }
    }

    /**
     * Given an XXX-END {@link DependencyLink}, set the new end date of a given {@link Workpackage}
     */
    private void setWorkpackageNewEndDate(Workpackage workpackage, DependencyLink dependencyLink) {
        Workpackage bestSourceworkpackage = (Workpackage) dependencyLink.getSource();
        LocalDate sourceStart = bestSourceworkpackage.getStartDate();
        LocalDate sourceEnd = bestSourceworkpackage.getEndDate();
        LocalDate newWorkpackageEnd = workpackage.getEndDate();
        StartOrEnd sourceStartOrEnd = dependencyLink.getSourceKind();
        int delay = dependencyLink.getDelay();
        if (sourceStartOrEnd.equals(StartOrEnd.START)) {
            delay -= 1;
        }
        if (sourceStartOrEnd == StartOrEnd.END) {
            newWorkpackageEnd = sourceEnd.plusDays(delay);

        } else if (sourceStartOrEnd == StartOrEnd.START) {
            newWorkpackageEnd = sourceStart.plusDays(delay);
        }
        workpackageComputationService.updateEffort(workpackage, (int) ChronoUnit.DAYS.between(workpackage.getStartDate(), newWorkpackageEnd));
        workpackageComputationService.updateEndDate(workpackage, newWorkpackageEnd);
    }

    /**
     * Given an XXX-END {@link DependencyLink}, set the new end date of a given {@link Workpackage}
     */
    private void setWorkpackageNewStartDate(Workpackage workpackage, DependencyLink dependencyLink) {
        Workpackage bestSourceworkpackage = (Workpackage) dependencyLink.getSource();
        LocalDate sourceStart = bestSourceworkpackage.getStartDate();
        LocalDate sourceEnd = bestSourceworkpackage.getEndDate();
        LocalDate newWorkpackageStart = workpackage.getEndDate();
        StartOrEnd sourceStartOrEnd = dependencyLink.getSourceKind();
        int delay = dependencyLink.getDelay() - 1;
        if (sourceStartOrEnd == StartOrEnd.END) {
            newWorkpackageStart = sourceEnd.plusDays(delay);

        } else if (sourceStartOrEnd == StartOrEnd.START) {
            newWorkpackageStart = sourceStart.plusDays(delay);
        }
        workpackageComputationService.updateEffort(workpackage, (int) ChronoUnit.DAYS.between(newWorkpackageStart, workpackage.getEndDate()));
        workpackageComputationService.updateStartDate(workpackage, newWorkpackageStart);
    }

    private LocalDate getlaterLocalDate(DependencyLink dep) {
        LocalDate laterLocalDate = null;
        Workpackage source = (Workpackage) dep.getSource();
        if (dep.getSourceKind() == StartOrEnd.END) {
            laterLocalDate = source.getEndDate().plusDays(dep.getDelay());
        } else if (dep.getSourceKind() == StartOrEnd.START) {
            laterLocalDate = source.getStartDate().plusDays(dep.getDelay());
        }
        return laterLocalDate;
    }

    public void editDependencyLinkDelay(DependencyLink depLink, int newDelay) {
        depLink.setDelay(newDelay);
        this.followMoveDependency(depLink.getSource());
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

    @SuppressWarnings({ "checkstyle:NestedIfDepth", "checkstyle:MissingSwitchDefault" })
    public void editWorkpackage(EObject eObject, String name, String description, LocalDate startDate, LocalDate endDate, Integer progress, boolean keepEffort) {
        if (eObject instanceof Workpackage workpackage) {
            if (name != null) {
                workpackage.setName(name);
            }
            if (description != null) {
                workpackage.setDescription(description);
            }
            if (endDate != null && startDate != null) {
                long differenceEnd = ChronoUnit.DAYS.between(endDate, workpackage.getEndDate());
                long differenceStart = ChronoUnit.DAYS.between(startDate, workpackage.getStartDate());
                List<DependencyLink> dependencies = workpackage.getDependencies();
                boolean startDateControlledByDependency =
                        dependencies.stream()
                                .anyMatch(dep -> dep.getTargetKind() == StartOrEnd.START);

                boolean endDateControlledByDependency =
                        dependencies.stream()
                                .anyMatch(dep -> dep.getTargetKind() == StartOrEnd.END);

                if (differenceStart != 0 && differenceEnd != 0) {
                    if (dependencies.isEmpty()) {
                        TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
                        switch (calculationOption) {
                            case START_EFFORT -> workpackageComputationService.updateStartDate(workpackage, startDate);
                            case END_EFFORT -> workpackageComputationService.updateEndDate(workpackage, endDate);
                            case START_END -> {
                                workpackageComputationService.updateStartDate(workpackage, startDate);
                                workpackageComputationService.updateEndDate(workpackage, endDate);
                            }
                        }
                        this.followMoveDependency(workpackage);
                    }
                } else {
                    if (differenceStart != 0 && !startDateControlledByDependency) {
                        workpackageComputationService.updateStartDate(workpackage, startDate);
                        this.followMoveDependency(workpackage);
                    }

                    if (differenceEnd != 0 && !endDateControlledByDependency) {
                        workpackageComputationService.updateEndDate(workpackage, endDate);
                        this.followMoveDependency(workpackage);
                    }
                }
            }
            if (progress != null) {
                workpackage.setProgress(progress);
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

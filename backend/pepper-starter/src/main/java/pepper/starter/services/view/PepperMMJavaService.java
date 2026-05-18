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
package pepper.starter.services.view;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.KeyResult;
import pepper.peppermm.Objective;
import pepper.peppermm.Project;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.TagFolder;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTag;
import pepper.peppermm.Workpackage;

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
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.eclipse.sirius.components.representations.Message;
import org.eclipse.sirius.components.representations.MessageLevel;


/**
 * Java Service for the task related views.
 *
 * @author lfasani
 */
public class PepperMMJavaService {

    private static final String NEW_TASK = "New Task";

    private final SimpleCrossReferenceProvider simpleCrossReferenceProvider = new SimpleCrossReferenceProvider();

    private final IFeedbackMessageService feedbackMessageService;

    public PepperMMJavaService(IFeedbackMessageService feedbackMessageService) {
        this.feedbackMessageService = Objects.requireNonNull(feedbackMessageService);
    }

    @SuppressWarnings("checkstyle:NestedIfDepth")
    public void editTask(EObject eObject, String name, String description, Instant startTime, Instant endTime, Integer progress, boolean keepDuration) {
        if (eObject instanceof Task task) {
            if (name != null) {
                task.setName(name);
            }
            if (description != null) {
                task.setDescription(description);
            }
            if (endTime != null && startTime != null) {
                Instant newStartTime = startTime;
                Instant newEndTime = endTime;
                //set the instants to xx:00 for the start time and xx:59 for the end time
                if ((newEndTime.atZone(ZoneId.systemDefault()).getHour() == 0 || newEndTime.atZone(ZoneId.systemDefault()).getHour() == 12) && !startTime.equals(endTime)) {
                    newEndTime = newEndTime.minus(1, ChronoUnit.MINUTES);
                }
                if (newStartTime.atZone(ZoneId.systemDefault()).getMinute() == 1) {
                    newStartTime = startTime.minus(1, ChronoUnit.MINUTES);
                }

                long differenceEnd = task.getEndTime().getEpochSecond() - newEndTime.getEpochSecond();
                long differenceStart = task.getStartTime().getEpochSecond() - newStartTime.getEpochSecond();
                List<DependencyLink> dependencies = task.getDependencies();
                boolean startTimeControlledByDependency =
                        dependencies.stream()
                                .anyMatch(dep -> dep.getTargetKind() == StartOrEnd.START);

                boolean endTimeControlledByDependency =
                        dependencies.stream()
                                .anyMatch(dep -> dep.getTargetKind() == StartOrEnd.END);
                if (dependencies.isEmpty() || differenceEnd != differenceStart) {
                    if (startTimeControlledByDependency && !endTimeControlledByDependency) {
                        this.setTaskDuration(task, newStartTime, newEndTime);
                        newEndTime = newEndTime.plus(differenceStart, ChronoUnit.SECONDS);
                        task.setEndTime(newEndTime);
                    } else if (!startTimeControlledByDependency && endTimeControlledByDependency) {
                        this.setTaskDuration(task, newStartTime, newEndTime);
                        newStartTime = newStartTime.plus(differenceEnd, ChronoUnit.SECONDS);
                        task.setStartTime(newStartTime);
                    } else if (!startTimeControlledByDependency && !endTimeControlledByDependency) {
                        if (!keepDuration) {
                            this.setTaskDuration(task, newStartTime, newEndTime);
                        }
                        task.setStartTime(newStartTime);
                        task.setEndTime(newEndTime);
                    }
                    if (!startTimeControlledByDependency || !endTimeControlledByDependency) {
                        followMoveDependency(task);
                    }
                }
            }
            if (progress != null) {
                task.setProgress(progress);
            }
        }
    }

    private void setTaskDuration(Task task, Instant start, Instant end) {
        int duration = (int) ChronoUnit.HOURS.between(start, end) + 1; //+1 because between(00:00, 00:59) = 0. We want 1.
        task.setDuration(duration);
    }

    public void createTask(EObject context) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(NEW_TASK);
        if (context instanceof AbstractTask abstractTask) {
            // The new task follows the context task and has the same duration as the context task.
            if (abstractTask.getEndTime() != null && abstractTask.getStartTime() != null) {
                if (abstractTask.getEndTime().equals(abstractTask.getStartTime())) {
                    // If the task is a Milestone
                    task.setStartTime(abstractTask.getEndTime());
                    task.setEndTime(Instant.ofEpochSecond(2 * abstractTask.getEndTime().getEpochSecond() - abstractTask.getStartTime().getEpochSecond()));
                } else {
                    task.setStartTime(abstractTask.getEndTime().plus(1, ChronoUnit.MINUTES));
                    task.setEndTime(Instant.ofEpochSecond(2 * abstractTask.getEndTime().getEpochSecond() - abstractTask.getStartTime().getEpochSecond()).plus(1, ChronoUnit.MINUTES));
                }
            }

            EObject parent = context.eContainer();
            if (parent instanceof Workpackage workpackage) {
                int index = workpackage.getOwnedTasks().indexOf(context);
                workpackage.getOwnedTasks().add(index + 1, task);
            } else if (parent instanceof AbstractTask parentTask) {
                int index = parentTask.getSubTasks().indexOf(context);
                parentTask.getSubTasks().add(index + 1, task);
            }
        } else if (context instanceof Workpackage workpackage) {
            long epochSecondStartTime = Instant.now().getEpochSecond();
            task.setStartTime(Instant.ofEpochMilli(epochSecondStartTime));
            task.setEndTime(Instant.ofEpochMilli(epochSecondStartTime + 3600 * 4));

            workpackage.getOwnedTasks().add(task);
        }
    }

    /** Delete a given {@link DependencyRelatedObject} and all {@link DependencyLink} related to it.
     * Then update all dependency placement of its dependent objects.
     *
     * @param context the object to delete
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
                    targetDependencies.addAll(getAllDependencyTargetTask(new LinkedHashSet<>(), subTask));
                }
            }

            EcoreUtil.delete(source, true);

            for (DependencyLink sourceDependencyLink : sourceDependencies) {
                followMoveDependency(sourceDependencyLink.getSource());
            }
            for (DependencyRelatedObject targetDependency : targetDependencies) {
                List<DependencyLink> dependencyLinksOfTargetDependencies = targetDependency.getDependencies();
                for (DependencyLink dependencyLinksOfTargetDependency : dependencyLinksOfTargetDependencies) {
                    followMoveDependency(dependencyLinksOfTargetDependency.getSource());
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
            getAllDependencyTargetTask(targetTasks, subTask);
        }
        return targetTasks;
    }

    /**
     * Deletes the {@link DependencyLink} between the specified source and target
     *      {@link DependencyRelatedObject}s.
     * <p>
     * Then the target object's placement is then updated according to its remaining dependencies.
     * @param target the dependency target
     * @param source the dependency source
     */
    public void deleteDependencyLink(EObject target, EObject source) {
        if (target instanceof DependencyRelatedObject targetObject) {
            if (source instanceof DependencyRelatedObject sourceObject) {
                targetObject.getDependencies().removeIf(dep -> dep.getSource().equals(sourceObject));
            }

            for (DependencyLink targetDependencyLink : targetObject.getDependencies()) {
                followMoveDependency(targetDependencyLink.getSource());
            }
        }
    }


    public void createDependencyLink(EObject target, EObject source, org.eclipse.sirius.components.gantt.StartOrEnd sourceStartOrEnd, org.eclipse.sirius.components.gantt.StartOrEnd targetStartOrEnd) {
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
                    targetObject.getDependencies().add(dependencyLink);
                    this.followMoveDependency(sourceObject);
                }
            }
        }
    }

    private static boolean isCycle(DependencyRelatedObject sourceObject, DependencyRelatedObject targetObject) {
        boolean isCycle = false;
        for (DependencyLink dep : sourceObject.getDependencies()) {
            if (dep.getSource().equals(targetObject)) {
                isCycle = true;
            } else if (!isCycle) {
                isCycle = isCycle(dep.getSource(), targetObject);
            }
        }
        return isCycle;
    }

    /**
     * Validates a dependency creation request.
     *
     * @param sourceObject the dependency source
     * @param targetObject the dependency target
     * @return {@code true} if the dependency is invalid because it would create a cycle or duplicate a dependency; {@code false} otherwise
     */
    private boolean isDuplicateOrCycle(DependencyRelatedObject sourceObject, DependencyRelatedObject targetObject) {
        //to prevent cycles
        boolean isCycle = isCycle(sourceObject, targetObject);
        if (isCycle) {
            this.feedbackMessageService.addFeedbackMessage(new Message("Creating a cyclic dependency is not possible.", MessageLevel.ERROR));
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
     * Finds all {@link DependencyRelatedObject} instances that depend on the given
     * {@link DependencyRelatedObject} and update them according to their dependency relationships.
     *
     * @param sourceObject the object that has been moved
     */
    private void followMoveDependency(DependencyRelatedObject sourceObject) {
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
        }
        if (sourceObject instanceof Workpackage sourceWorkpackage) {
            this.followWorkpackageMoveDependency(targetWorkpackages, sourceWorkpackage);
        }
    }

    /**
     * Updates the dates of all {@link Workpackage} that depend on the given source {@link Workpackage}.
     *
     * @param targetWorkpackages the dependent workpackages
     * @param sourceWorkpackage the workpackage that has been moved
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
                    LocalDate newLocalDate = getlaterLocalDate(dep);
                    if (laterEnd == null || laterEnd.isBefore(newLocalDate)) {
                        laterEnd = newLocalDate;
                        winnerEnd = dep;
                    }
                }
                if (dep.getTargetKind().equals(StartOrEnd.START)) {
                    LocalDate newLocalDate = getlaterLocalDate(dep);
                    if (laterStart == null || laterStart.isBefore(newLocalDate)) {
                        laterStart = newLocalDate;
                        winnerStart = dep;
                    }
                }
            }
            for (DependencyLink dep : workpackage.getDependencies()) {
                if ((dep.equals(winnerStart) && winnerEnd == null) || (dep.equals(winnerEnd) && winnerStart == null)) {
                    Workpackage bestSourceWorkpackage = (Workpackage) dep.getSource();
                    setWorkpackageNewDates(workpackage, dep);
                    if (bestSourceWorkpackage == sourceWorkpackage) {
                        dependencies.add(workpackage);
                    }
                } else if (dep.equals(winnerEnd)) {
                    Workpackage bestSourceWorkpackage = (Workpackage) dep.getSource();
                    setWorkpackageNewEndDate(workpackage, dep);
                    if (bestSourceWorkpackage == sourceWorkpackage) {
                        dependencies.add(workpackage);
                    }
                }
                else if (dep.equals(winnerStart)) {
                    Workpackage bestSourceWorkpackage = (Workpackage) dep.getSource();
                    setWorkpackageNewStartDate(workpackage, dep);
                    if (bestSourceWorkpackage == sourceWorkpackage) {
                        dependencies.add(workpackage);
                    }
                }
            }
            if (winnerEnd != null && winnerStart != null) {
                if (workpackage.getStartDate().isAfter(workpackage.getEndDate())) {
                    workpackage.setDuration(1);
                    workpackage.setEndDate(workpackage.getStartDate().plusDays(1));
                    this.feedbackMessageService.addFeedbackMessage(new Message("Task dependencies overlap : End date has been changed to avoid to have end date before start date.", MessageLevel.WARNING));
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
     * @param targetTasks the dependent workpackages
     * @param sourceTask the workpackage that has been moved
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
                    setTaskNewDates(task, dep);
                    if (bestSourceTask == sourceTask) {
                        dependencies.add(task);
                    }
                }
                else if (dep.equals(winnerEnd)) {
                    Task bestSourceTask = (Task) dep.getSource();
                    setTaskNewEndDate(task, dep);
                    if (bestSourceTask == sourceTask) {
                        dependencies.add(task);
                    }
                }
                else if (dep.equals(winnerStart)) {
                    Task bestSourceTask = (Task) dep.getSource();
                    setTaskNewStartDate(task, dep);
                    if (bestSourceTask == sourceTask) {
                        dependencies.add(task);
                    }
                }
            }
            if (winnerEnd != null && winnerStart != null) {
                if (task.getEndTime().isBefore(task.getStartTime())) {
                    Instant newEndTime = task.getStartTime().plus(12, ChronoUnit.HOURS);
                    setTaskDuration(task, task.getStartTime(), newEndTime);
                    task.setEndTime(newEndTime.minus(1, ChronoUnit.MINUTES));
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
        if (isMilestone(sourceTask)) {
            return 0;
        }
        else {
            return 1;
        }
    }

    private int endAdjustmentMinutes(Task sourceTask, Task targetTask) {
        int adjustment = 0;
        if (isMilestone(sourceTask)) {
            adjustment--;
        }
        if (isMilestone(targetTask)) {
            adjustment++;
        }
        return adjustment;
    }

    /**
     * Recalculates and updates the start and end dates of the specified target {@link Task}
     *  according to the given {@link DependencyLink}.
     * <p>
     * The task duration is preserved during the calculation. Only the start and
     * end instants are shifted to satisfy the dependency constraints.
     *
     * @param task the target {@link Task} whose start and end dates must be updated
     *             according to the dependency
     * @param dep the {@link DependencyLink} defining the relationship between the source
     *           and the target tasks, including the dependency type and delay
     */
    private void setTaskNewDates(Task task, DependencyLink dep) {
        Task bestSourceTask = (Task) dep.getSource();
        Instant sourceStart = bestSourceTask.getStartTime();
        Instant sourceEnd = bestSourceTask.getEndTime();
        Instant oldTaskStart = task.getStartTime();
        Instant oldTaskEnd = task.getEndTime();
        int delay = dep.getDuration();
        StartOrEnd sourceStartOrEnd = dep.getSourceKind();
        StartOrEnd targetStartOrEnd = dep.getTargetKind();
        if (sourceStartOrEnd == StartOrEnd.END && targetStartOrEnd == StartOrEnd.START) {
            Instant newTaskStart = sourceEnd.plus(delay, ChronoUnit.HOURS)
                            .plus(startAdjustmentMinutes(bestSourceTask), ChronoUnit.MINUTES);
            Instant newTaskEnd = Instant.ofEpochSecond(newTaskStart.getEpochSecond() + oldTaskEnd.getEpochSecond() - oldTaskStart.getEpochSecond());
            task.setEndTime(newTaskEnd);
            task.setStartTime(newTaskStart);
        } else if (sourceStartOrEnd == StartOrEnd.START && targetStartOrEnd == StartOrEnd.START) {
            Instant newTaskStart = sourceStart.plus(delay, ChronoUnit.HOURS);
            Instant newTaskEnd = Instant.ofEpochSecond(newTaskStart.getEpochSecond() + oldTaskEnd.getEpochSecond() - oldTaskStart.getEpochSecond());
            task.setEndTime(newTaskEnd);
            task.setStartTime(newTaskStart);
        } else if (sourceStartOrEnd == StartOrEnd.END && targetStartOrEnd == StartOrEnd.END) {
            Instant newTaskEnd = sourceEnd.plus(delay, ChronoUnit.HOURS)
                            .plus(endAdjustmentMinutes(bestSourceTask, task), ChronoUnit.MINUTES);
            Instant newTaskStart = Instant.ofEpochSecond(newTaskEnd.getEpochSecond() - (oldTaskEnd.getEpochSecond() - oldTaskStart.getEpochSecond()));
            task.setEndTime(newTaskEnd);
            task.setStartTime(newTaskStart);
        } else if (sourceStartOrEnd == StartOrEnd.START && targetStartOrEnd == StartOrEnd.END) {
            Instant newTaskEnd = sourceStart.plus(delay, ChronoUnit.HOURS).minus(1, ChronoUnit.MINUTES);
            if (isMilestone(task)) {
                newTaskEnd = newTaskEnd.plus(1, ChronoUnit.MINUTES);
            }
            Instant newTaskStart = Instant.ofEpochSecond(newTaskEnd.getEpochSecond() - (oldTaskEnd.getEpochSecond() - oldTaskStart.getEpochSecond()));
            task.setEndTime(newTaskEnd);
            task.setStartTime(newTaskStart);
        }
    }

    /**
     * Given an XXX-END {@link DependencyLink}, set the new end date of a given {@link Task}
     */
    private void setTaskNewEndDate(Task task, DependencyLink dep) {
        Task bestSourceTask = (Task) dep.getSource();
        Instant sourceStart = bestSourceTask.getStartTime();
        Instant sourceEnd = bestSourceTask.getEndTime();
        int delay = dep.getDuration();
        StartOrEnd sourceStartOrEnd = dep.getSourceKind();
        Instant newTaskEnd = task.getEndTime();
        if (sourceStartOrEnd == StartOrEnd.END) {
            newTaskEnd = sourceEnd.plus(delay, ChronoUnit.HOURS)
                    .plus(endAdjustmentMinutes(bestSourceTask, task), ChronoUnit.MINUTES);
        } else if (sourceStartOrEnd == StartOrEnd.START) {
            newTaskEnd = sourceStart.plus(delay, ChronoUnit.HOURS).minus(1, ChronoUnit.MINUTES);
            if (isMilestone(task)) {
                newTaskEnd = newTaskEnd.plus(1, ChronoUnit.MINUTES);
            }
        }
        setTaskDuration(task, task.getStartTime(), newTaskEnd);
        task.setEndTime(newTaskEnd);
    }

    /**
     * Given an XXX-Start {@link DependencyLink}, set the new start date of a given {@link Task}
     */
    private void setTaskNewStartDate(Task task, DependencyLink dep) {
        Task bestSourceTask = (Task) dep.getSource();
        Instant sourceStart = bestSourceTask.getStartTime();
        Instant sourceEnd = bestSourceTask.getEndTime();
        int delay = dep.getDuration();
        StartOrEnd sourceStartOrEnd = dep.getSourceKind();
        Instant newTaskStart = task.getStartTime();
        if (sourceStartOrEnd == StartOrEnd.END) {
            newTaskStart = sourceEnd.plus(delay, ChronoUnit.HOURS)
                    .plus(startAdjustmentMinutes(bestSourceTask), ChronoUnit.MINUTES);
        } else if (sourceStartOrEnd == StartOrEnd.START) {
            newTaskStart = sourceStart.plus(delay, ChronoUnit.HOURS);
        }
        setTaskDuration(task, task.getStartTime(), newTaskStart);
        task.setStartTime(newTaskStart);
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
        long duration = ChronoUnit.DAYS.between(oldWorkpackageStart, oldWorkpackageEnd);
        StartOrEnd sourceStartOrEnd = dependencyLink.getSourceKind();
        StartOrEnd targetStartOrEnd = dependencyLink.getTargetKind();
        int delay = dependencyLink.getDuration();
        if (targetStartOrEnd.equals(StartOrEnd.START)) {
            delay += 1;
        }
        if (sourceStartOrEnd.equals(StartOrEnd.START)) {
            delay -= 1;
        }
        if (sourceStartOrEnd == StartOrEnd.END && targetStartOrEnd == StartOrEnd.START) {
            LocalDate newWorkpackageStart = sourceEnd.plusDays(delay);
            LocalDate newWorkpackageEnd = newWorkpackageStart.plusDays(duration);
            workpackage.setEndDate(newWorkpackageEnd);
            workpackage.setStartDate(newWorkpackageStart);
        } else if (sourceStartOrEnd == StartOrEnd.START && targetStartOrEnd == StartOrEnd.START) {
            LocalDate newWorkpackageStart = sourceStart.plusDays(delay);
            LocalDate newWorkpackageEnd = newWorkpackageStart.plusDays(duration);
            workpackage.setEndDate(newWorkpackageEnd);
            workpackage.setStartDate(newWorkpackageStart);
        } else if (sourceStartOrEnd == StartOrEnd.END && targetStartOrEnd == StartOrEnd.END) {
            LocalDate newWorkpackageEnd = sourceEnd.plusDays(delay);
            LocalDate newWorkpackageStart = newWorkpackageEnd.minusDays(duration);
            workpackage.setEndDate(newWorkpackageEnd);
            workpackage.setStartDate(newWorkpackageStart);
        } else if (sourceStartOrEnd == StartOrEnd.START && targetStartOrEnd == StartOrEnd.END) {
            LocalDate newWorkpackageEnd = sourceStart.plusDays(delay);
            LocalDate newWorkpackageStart = newWorkpackageEnd.minusDays(duration);
            workpackage.setEndDate(newWorkpackageEnd);
            workpackage.setStartDate(newWorkpackageStart);
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
        int delay = dependencyLink.getDuration();
        if (sourceStartOrEnd.equals(StartOrEnd.START)) {
            delay -= 1;
        }
        if (sourceStartOrEnd == StartOrEnd.END) {
            newWorkpackageEnd = sourceEnd.plusDays(delay);

        } else if (sourceStartOrEnd == StartOrEnd.START) {
            newWorkpackageEnd = sourceStart.plusDays(delay);
        }
        workpackage.setDuration((int) ChronoUnit.DAYS.between(workpackage.getStartDate(), newWorkpackageEnd));
        workpackage.setEndDate(newWorkpackageEnd);
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
        int delay = dependencyLink.getDuration() - 1;
        if (sourceStartOrEnd == StartOrEnd.END) {
            newWorkpackageStart = sourceEnd.plusDays(delay);

        } else if (sourceStartOrEnd == StartOrEnd.START) {
            newWorkpackageStart = sourceStart.plusDays(delay);
        }
        workpackage.setDuration((int) ChronoUnit.DAYS.between(newWorkpackageStart, workpackage.getEndDate()));
        workpackage.setStartDate(newWorkpackageStart);
    }

    private static Instant getlaterInstant(DependencyLink dep) {
        Instant laterInstant = null;
        Task source = (Task) dep.getSource();
        if (dep.getSourceKind() == StartOrEnd.END) {
            laterInstant = source.getEndTime().plus(dep.getDuration(), ChronoUnit.HOURS);
        } else if (dep.getSourceKind() == StartOrEnd.START) {
            laterInstant = source.getStartTime().plus(dep.getDuration(), ChronoUnit.HOURS);
        }
        return laterInstant;
    }

    private LocalDate getlaterLocalDate(DependencyLink dep) {
        LocalDate laterLocalDate = null;
        Workpackage source = (Workpackage) dep.getSource();
        if (dep.getSourceKind() == StartOrEnd.END) {
            laterLocalDate = source.getEndDate().plusDays(dep.getDuration());
        } else if (dep.getSourceKind() == StartOrEnd.START) {
            laterLocalDate = source.getStartDate().plusDays(dep.getDuration());
        }
        return laterLocalDate;
    }


    public void editDependencyLinkDuration(DependencyLink depLink, int newDuration) {
        depLink.setDuration(newDuration);
        followMoveDependency(depLink.getSource());
    }

    public List<Task> getTasksWithTag(TaskTag tag, Workpackage workpackage) {
        return Optional.of(workpackage).stream()
                .flatMap(wkP -> {
                    Iterable<EObject> content = () -> wkP.eAllContents();
                    return StreamSupport.stream(content.spliterator(), false);
                })
                .filter(Task.class::isInstance)
                .map(Task.class::cast)
                .filter(task -> task.getTags().contains(tag))
                .toList();
    }

    public String computeTaskDurationDays(Task task) {
        String value = "";
        int duration = task.getDuration();
        int dd = duration / 24;
        int hh = duration % 24;
        value = String.format("%02dd%02dh", dd, hh);
        return value;
    }

    public void createCard(EObject context) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(NEW_TASK);
        task.setDescription("new description");
        if (context instanceof TaskTag tag) {
            task.getTags().add(tag);

            EObject parent = context.eContainer();
            if (parent instanceof TagFolder tagFolder) {
                EObject parent2 = tagFolder.eContainer();
                if (parent2 instanceof Project project) {
                    var workpackages = project.getOwnedWorkpackages();
                    if (!workpackages.isEmpty()) {
                        workpackages.get(0).getOwnedTasks().add(task);
                    }
                }
            }
        }
    }

    public void editCard(EObject eObject, String title, String description, String label) {
        if (eObject instanceof AbstractTask task) {
            if (title != null) {
                task.setName(title);
            }
            if (description != null) {
                task.setDescription(description);
            }
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
            // The new task follows the context task and has the same duration than the context task.
            if (workpackage.getEndDate() != null && workpackage.getStartDate() != null) {
                newWorkpackage.setStartDate(workpackage.getEndDate().plusDays(1));
                newWorkpackage.setEndDate(workpackage.getEndDate().plusDays(workpackage.getEndDate().toEpochDay() - workpackage.getStartDate().toEpochDay() + 1));
            }

            EObject parent = context.eContainer();
            if (parent instanceof Project project) {
                int index = project.getOwnedWorkpackages().indexOf(context);
                project.getOwnedWorkpackages().add(index + 1, newWorkpackage);
            }
        } else if (context instanceof Project project) {
            LocalDate now = LocalDate.now();
            newWorkpackage.setStartDate(now);
            newWorkpackage.setEndDate(now.plusDays(28));

            project.getOwnedWorkpackages().add(newWorkpackage);
        }
    }

    public void deleteWorkpackage(EObject context) {
        if (context instanceof Workpackage sourceWorkpackage) {
            EcoreUtil.delete(sourceWorkpackage, true);
        }
    }

    @SuppressWarnings("checkstyle:NestedIfDepth")
    public void editWorkpackage(EObject eObject, String name, String description, LocalDate startDate, LocalDate endDate, Integer progress, boolean keepDuration) {
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
                if (dependencies.isEmpty() || differenceEnd != differenceStart) {
                    if (startDateControlledByDependency && !endDateControlledByDependency) {
                        this.workpackageSetDuration(workpackage, startDate, endDate);
                        workpackage.setEndDate(endDate.plusDays(differenceStart));
                    } else if (endDateControlledByDependency && !startDateControlledByDependency) {
                        this.workpackageSetDuration(workpackage, startDate, endDate);
                        workpackage.setStartDate(startDate.plusDays(differenceEnd));
                    } else if (!startDateControlledByDependency && !endDateControlledByDependency) {
                        if (!keepDuration) {
                            this.workpackageSetDuration(workpackage, startDate, endDate);
                        }
                        workpackage.setStartDate(startDate);
                        workpackage.setEndDate(endDate);
                    }
                    if (!startDateControlledByDependency || !endDateControlledByDependency) {
                        followMoveDependency(workpackage);
                    }
                }
            }
            if (progress != null) {
                workpackage.setProgress(progress);
            }
        }
    }

    private void workpackageSetDuration(Workpackage workpackage, LocalDate start, LocalDate end) {
        int duration = (int) ChronoUnit.DAYS.between(start, end) + 1; //+1 because between(00:00, 00:59) = 0. We want 1.
        workpackage.setDuration(duration);
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

    public void moveKeyResultIntoObjective(KeyResult sourceKeyResult, Objective targetObjective, int indexInTarget) {
        EList<KeyResult> ownedKeyResults = targetObjective.getOwnedKeyResults();
        if (sourceKeyResult.eContainer().equals(targetObjective)) {
            ownedKeyResults.move(indexInTarget, sourceKeyResult);
        } else {
            ownedKeyResults.add(sourceKeyResult);
            ownedKeyResults.move(indexInTarget, sourceKeyResult);
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

    public Task moveTaskInTag(Task moveTask, int index, TaskTag targetTag) {
        Optional<Workpackage> workPackageOpt = getParent(moveTask, Workpackage.class);

        if (workPackageOpt.isPresent()) {
            // We retrieve all tasks with the same tag (in the same lane).
            List<Task> allTaskInTheLane = this.getTasksWithTag(targetTag, workPackageOpt.get());
            Optional<Task> firstTaskAfterTheDroppedTaskWithSameParent = allTaskInTheLane.subList(index, allTaskInTheLane.size()).stream().filter(task -> task.eContainer().equals(moveTask.eContainer())).findFirst();

            List<Task> tasksBeforeTheDroppedTaskWithSameParent = allTaskInTheLane.subList(0, index).stream().filter(task -> task.eContainer().equals(moveTask.eContainer())).toList();
            Optional<Task> lastTaskBeforeTheDroppedTaskWithSameParent = Optional.empty();
            if (!tasksBeforeTheDroppedTaskWithSameParent.isEmpty()) {
                lastTaskBeforeTheDroppedTaskWithSameParent = Optional.of(tasksBeforeTheDroppedTaskWithSameParent.get(tasksBeforeTheDroppedTaskWithSameParent.size() - 1));
            }

            if (lastTaskBeforeTheDroppedTaskWithSameParent.isPresent() || firstTaskAfterTheDroppedTaskWithSameParent.isPresent()) {
                EObject eContainer = moveTask.eContainer();
                if (eContainer instanceof Workpackage workpackage) {
                    int indexInParent = 0;
                    if (lastTaskBeforeTheDroppedTaskWithSameParent.isPresent()) {
                        indexInParent = workpackage.getOwnedTasks().indexOf(lastTaskBeforeTheDroppedTaskWithSameParent.get()) + 1;
                    } else {
                        indexInParent = workpackage.getOwnedTasks().indexOf(firstTaskAfterTheDroppedTaskWithSameParent.get());
                    }
                    workpackage.getOwnedTasks().move(indexInParent, moveTask);
                } else if (eContainer instanceof AbstractTask parentTask) {
                    int indexInParent = 0;
                    if (lastTaskBeforeTheDroppedTaskWithSameParent.isPresent()) {
                        indexInParent = parentTask.getSubTasks().indexOf(lastTaskBeforeTheDroppedTaskWithSameParent.get()) + 1;
                    } else {
                        indexInParent = parentTask.getSubTasks().indexOf(firstTaskAfterTheDroppedTaskWithSameParent.get());
                    }
                    parentTask.getSubTasks().move(indexInParent, moveTask);
                }
            }
        }
        return moveTask;
    }

    <T> Optional<T> getParent(EObject eObject, Class<T> clazz) {
        Optional<T> objectOpt = Optional.empty();
        EObject parent = eObject.eContainer();
        while (parent != null) {
            if (clazz.isInstance(parent)) {
                objectOpt = Optional.of(clazz.cast(parent));
                break;
            }
            parent = parent.eContainer();
        }

        return objectOpt;
    }

    public void moveObjectiveAtIndex(Objective objective, int index) {
        if (objective.eContainer() instanceof Project project) {
            project.getOwnedObjectives().move(index, objective);
        }
    }

    public void moveTagAtIndex(TaskTag movedTag, int index) {
        EObject eContainer = movedTag.eContainer();
        if (eContainer instanceof TagFolder tagFolder) {
            String prefix = movedTag.getPrefix();
            List<TaskTag> tagList = tagFolder.getOwnedTags().stream().filter(tag -> tag.getPrefix().equals(prefix)).toList();

            int newIndex = this.computeIndexOfTagToMove(movedTag, index, tagList, tagFolder);
            // We move the current tag before the tagToReplace in the project ownTags list.
            int oldIndex = tagFolder.getOwnedTags().indexOf(movedTag);
            // If the moved tag was located before the new location, the index after having remove the tag is
            // decremented.
            if (oldIndex < newIndex) {
                newIndex--;
            }
            tagFolder.getOwnedTags().move(newIndex, movedTag);

        }
    }

    /**
     * When a lane is moved, we change the underlying tag ordering. We need to compute the new index in the project tag
     * list.
     *
     * @param tag
     *         the tag to move.
     * @param index
     *         the new index in the project tag list.
     * @param tagList
     *         the current deck representation tag list (might be a sub set of the project tag list).
     * @param tagFolder
     *         the TagFolder owning the tags.
     * @return the index on which the tag should be moved in the project tag list to match the new index in the deck
     * representation.
     */
    private int computeIndexOfTagToMove(TaskTag tag, int index, List<TaskTag> tagList, TagFolder tagFolder) {
        int newIndex;
        List<TaskTag> unmovedLaneTags = tagList.stream().filter(currentTag -> currentTag != tag).toList();
        if (index < unmovedLaneTags.size()) {
            // We retrieve the tag that will be located after the moved one.
            TaskTag tagToMoveAround = unmovedLaneTags.get(index);
            newIndex = tagFolder.getOwnedTags().indexOf(tagToMoveAround);
        } else {
            // We need to locate the tag after the last one in the deck representation
            TaskTag lastTag = unmovedLaneTags.get(unmovedLaneTags.size() - 1);
            newIndex = tagFolder.getOwnedTags().indexOf(lastTag) + 1;
        }
        return newIndex;
    }
}

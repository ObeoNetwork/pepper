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

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Optional;

import pepper.domain.services.TaskComputationService;
import pepper.domain.services.TaskHelper;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * This class represents an update step for the change of boundary of a task.
 */
public final class TaskBoundaryUpdateStep extends TaskUpdateStep {
    private static final TaskHelper TASK_HELPER = new TaskHelper();
    private static final TaskComputationService TASK_COMPUTATION_SERVICE = new TaskComputationService();
    private static final WorkpackageComputationService WORKPACKAGE_COMPUTATION_SERVICE = new WorkpackageComputationService();

    private final DependencyRelatedObject task;

    private final Temporal start;

    private final Temporal end;

    public TaskBoundaryUpdateStep(DependencyRelatedObject task, Temporal start, Temporal end) {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    @Override
    public Object getImpactedTask() {
        return task;
    }

    @Override
    public String getName() {
        return TASK_HELPER.getName(task);
    }

    @SuppressWarnings("checkstyle:MissingSwitchDefault")
    @Override
    public void update() {
        if (task instanceof AbstractTask abstractTask && start instanceof Instant startTime && end instanceof Instant endTime) {
            Instant newStartTime = TASK_COMPUTATION_SERVICE.roundToNearestHalfDay(startTime);
            Instant newEndTime = TASK_COMPUTATION_SERVICE.roundToNearestHalfDay(endTime);
            long differenceStart = Optional.ofNullable(abstractTask.getStartTime())
                    .map(currentStartTime -> newStartTime.getEpochSecond() - TASK_COMPUTATION_SERVICE.roundToNearestHalfDay(currentStartTime).getEpochSecond())
                    .orElse((long) -1);
            long differenceEnd = Optional.ofNullable(abstractTask.getEndTime())
                    .map(currentEndTime -> newEndTime.getEpochSecond() - TASK_COMPUTATION_SERVICE.roundToNearestHalfDay(currentEndTime).getEpochSecond())
                    .orElse((long) -1);
            boolean taskShifted = differenceStart != 0 && differenceEnd != 0;
            List<DependencyLink> dependencies = task.getDependencies();
            // Nothing is done when moving a task constrained by dependencies
            if (dependencies.isEmpty() || !taskShifted) {
                boolean startTimeControlledByDependency = TASK_HELPER.isBoundaryConstrainedByDependency(dependencies, StartOrEnd.START);
                boolean endTimeControlledByDependency = TASK_HELPER.isBoundaryConstrainedByDependency(dependencies, StartOrEnd.END);

                if (taskShifted) {
                    TaskTimeBoundariesConstraint calculationOption = abstractTask.getCalculationOption();
                    switch (calculationOption) {
                        case START_EFFORT -> TASK_COMPUTATION_SERVICE.updateStartTime(abstractTask, newStartTime);
                        case END_EFFORT -> TASK_COMPUTATION_SERVICE.updateEndTime(abstractTask, newEndTime);
                        case START_END -> {
                            TASK_COMPUTATION_SERVICE.updateStartTime(abstractTask, newStartTime);
                            TASK_COMPUTATION_SERVICE.updateEndTime(abstractTask, newEndTime);
                        }
                    }
                } else {
                    if (differenceStart != 0 && !startTimeControlledByDependency) {
                        TASK_COMPUTATION_SERVICE.updateStartTime(abstractTask, newStartTime);
                    }

                    if (differenceEnd != 0 && !endTimeControlledByDependency) {
                        TASK_COMPUTATION_SERVICE.updateEndTime(abstractTask, newEndTime);
                    }
                }

            }
        } else if (task instanceof Workpackage workpackage && start instanceof LocalDate startDate && end instanceof LocalDate endDate) {
            long differenceEnd = Optional.ofNullable(workpackage.getEndDate()).map(currentEndDate -> ChronoUnit.DAYS.between(endDate, currentEndDate))
                    .orElse((long) -1);
            long differenceStart = Optional.ofNullable(workpackage.getStartDate()).map(currentStartDate -> ChronoUnit.DAYS.between(startDate, currentStartDate))
                    .orElse((long) -1);
            boolean taskShifted = differenceStart != 0 && differenceEnd != 0;
            List<DependencyLink> dependencies = workpackage.getDependencies();
            boolean startDateControlledByDependency = TASK_HELPER.isBoundaryConstrainedByDependency(dependencies, StartOrEnd.START);
            boolean endDateControlledByDependency = TASK_HELPER.isBoundaryConstrainedByDependency(dependencies, StartOrEnd.END);

            if (taskShifted) {
                // Nothing is done when moving a task constrained by dependencies
                if (dependencies.isEmpty()) {
                    TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
                    switch (calculationOption) {
                        case START_EFFORT -> WORKPACKAGE_COMPUTATION_SERVICE.updateStartDate(workpackage, startDate);
                        case END_EFFORT -> WORKPACKAGE_COMPUTATION_SERVICE.updateEndDate(workpackage, endDate);
                        case START_END -> {
                            WORKPACKAGE_COMPUTATION_SERVICE.updateStartDate(workpackage, startDate);
                            WORKPACKAGE_COMPUTATION_SERVICE.updateEndDate(workpackage, endDate);
                        }
                    }
                }
            } else {
                if (differenceStart != 0 && !startDateControlledByDependency) {
                    WORKPACKAGE_COMPUTATION_SERVICE.updateStartDate(workpackage, startDate);
                }

                if (differenceEnd != 0 && !endDateControlledByDependency) {
                    WORKPACKAGE_COMPUTATION_SERVICE.updateEndDate(workpackage, endDate);
                }
            }
        }
    }
}

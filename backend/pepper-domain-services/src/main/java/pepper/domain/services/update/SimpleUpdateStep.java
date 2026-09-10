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

import pepper.domain.services.TaskComputationService;
import pepper.domain.services.TaskHelper;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * This class represents an update step for a task that may be changed due to Person assignment change or Person change.
 * The step preserves the effort
 * @author lfasani
 */
public final class SimpleUpdateStep extends TaskUpdateStep {
    private static final TaskHelper TASK_HELPER = new TaskHelper();
    private static final TaskComputationService TASK_COMPUTATION_SERVICE = new TaskComputationService();
    private static final WorkpackageComputationService WORKPACKAGE_COMPUTATION_SERVICE = new WorkpackageComputationService();

    private final DependencyRelatedObject task;

    public SimpleUpdateStep(DependencyRelatedObject task) {
        this.task = task;
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

        if (task instanceof AbstractTask abstractTask) {
            Instant roundedStartTime = TASK_COMPUTATION_SERVICE.roundToNearestHalfDay(abstractTask.getStartTime());
            Instant roundedEndTime = TASK_COMPUTATION_SERVICE.roundToNearestHalfDay(abstractTask.getEndTime());

            if (roundedStartTime != null && roundedEndTime != null) {
                TaskTimeBoundariesConstraint calculationOption = abstractTask.getCalculationOption();
                switch (calculationOption) {
                    case START_EFFORT -> TASK_COMPUTATION_SERVICE.updateStartTime(abstractTask, roundedStartTime);
                    case END_EFFORT -> TASK_COMPUTATION_SERVICE.updateEndTime(abstractTask, roundedEndTime);
                    case START_END -> {
                        abstractTask.setCalculationOption(TaskTimeBoundariesConstraint.START_EFFORT);
                        TASK_COMPUTATION_SERVICE.updateStartTime(abstractTask, roundedStartTime);
                        abstractTask.setCalculationOption(calculationOption);
                    }
                }
            }
        } else if (task instanceof Workpackage workpackage) {
            LocalDate startDate = workpackage.getStartDate();
            LocalDate endDate = workpackage.getEndDate();

            TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
            switch (calculationOption) {
                case START_EFFORT -> WORKPACKAGE_COMPUTATION_SERVICE.updateStartDate(workpackage, startDate);
                case END_EFFORT -> WORKPACKAGE_COMPUTATION_SERVICE.updateEndDate(workpackage, endDate);
                case START_END -> {
                    WORKPACKAGE_COMPUTATION_SERVICE.updateStartDate(workpackage, startDate);
                }
            }
        }
    }
}

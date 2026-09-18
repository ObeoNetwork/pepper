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
import java.time.ZoneId;
import java.time.ZoneOffset;

import pepper.domain.services.NonWorkingDaysService;
import pepper.domain.services.TaskComputationService;
import pepper.domain.services.TaskHelper;
import pepper.domain.services.TemporalHelper;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.AssignableObject;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * This class represents an update step for the change of the effort of a task.
 * @author lfasani
 */
public final class EffortUpdateStep extends TaskUpdateStep {
    private static final TaskHelper TASK_HELPER = new TaskHelper();
    private static final TemporalHelper TEMPORAL_HELPER = new TemporalHelper();

    private static final TaskComputationService TASK_COMPUTATION_SERVICE = new TaskComputationService();
    private static final WorkpackageComputationService WORKPACKAGE_COMPUTATION_SERVICE = new WorkpackageComputationService();
    private static final NonWorkingDaysService NON_WORKING_DAYS_SERVICE = new NonWorkingDaysService();

    private final DependencyRelatedObject task;

    private final String newEffort;

    public EffortUpdateStep(DependencyRelatedObject task, String newEffort) {
        this.task = task;
        this.newEffort = newEffort;
    }

    @Override
    public Object getImpactedTask() {
        return task;
    }

    @Override
    public String getName() {
        return TASK_HELPER.getName(task);
    }

    @Override
    public void update() {
        if (task instanceof AbstractTask abstractTask) {
            if (newEffort != null && !newEffort.isBlank()) {
                try {
                    int valueInHours = TEMPORAL_HELPER.roundToNearestHalfDayInHours(newEffort);
                    if (valueInHours >= 0.5) {
                        TaskTimeBoundariesConstraint calculationOption = TASK_HELPER.getCalculationOption((DependencyRelatedObject) abstractTask);

                        if (calculationOption.equals(TaskTimeBoundariesConstraint.END_EFFORT) && this.mustBeComputedFromStartConsideringPersonAvailability(task, valueInHours)) {
                            abstractTask.setCalculationOption(TaskTimeBoundariesConstraint.START_EFFORT);
                            TASK_HELPER.getEarlierAvailableInstantOfPerson(abstractTask.getAssignedPersons())
                                    .ifPresent(nextStartTime -> TASK_COMPUTATION_SERVICE.updateStartTime(abstractTask, nextStartTime));
                            TASK_COMPUTATION_SERVICE.updateEffort(abstractTask, valueInHours);
                            abstractTask.setCalculationOption(calculationOption);
                        } else {
                            TASK_COMPUTATION_SERVICE.updateEffort(abstractTask, valueInHours);
                        }
                    }
                } catch (NumberFormatException e) {
                    // Ignore
                }
            }
        } else if (task instanceof Workpackage workpackage) {
            if (newEffort != null && !newEffort.isBlank()) {
                try {
                    int valueInDays = (int) Math.round(Double.parseDouble(newEffort));
                    if (valueInDays >= 0) {
                        TaskTimeBoundariesConstraint calculationOption = TASK_HELPER.getCalculationOption(workpackage);

                        if (calculationOption.equals(TaskTimeBoundariesConstraint.END_EFFORT) && this.mustBeComputedFromStartConsideringPersonAvailability(task, valueInDays * 12)) {
                            workpackage.setCalculationOption(TaskTimeBoundariesConstraint.START_END);
                            TASK_HELPER.getEarlierAvailableInstantOfPerson(workpackage.getAssignedPersons())
                                    .ifPresent(nextStartTime -> WORKPACKAGE_COMPUTATION_SERVICE.updateStartDate(workpackage, LocalDate.ofInstant(nextStartTime, ZoneId.systemDefault())));
                            WORKPACKAGE_COMPUTATION_SERVICE.updateEffort(workpackage, valueInDays);
                            workpackage.setCalculationOption(calculationOption);
                        }
                        WORKPACKAGE_COMPUTATION_SERVICE.updateEffort(workpackage, valueInDays);
                    }
                } catch (NumberFormatException e) {
                    // Ignore
                }
            }
        }
    }

    public boolean mustBeComputedFromStartConsideringPersonAvailability(DependencyRelatedObject targetTask, int newEffortInHours) {
        boolean mustBeComputedFromStart = false;
        if (TASK_HELPER.getCalculationOption(targetTask).equals(TaskTimeBoundariesConstraint.END_EFFORT)) {
            if (targetTask instanceof AssignableObject assignableObject && !assignableObject.getAssignedPersons().isEmpty()) {
                if (targetTask instanceof AbstractTask abstractTask) {
                    return TASK_HELPER.getEarlierAvailableInstantOfPerson(abstractTask.getAssignedPersons())
                            .map(earlierAvailableInstantOfPerson -> {
                                Instant nextEndTime = NON_WORKING_DAYS_SERVICE.getNextEndTime(TEMPORAL_HELPER.roundToNearestHalfDay(earlierAvailableInstantOfPerson), newEffortInHours,
                                        abstractTask.getAssignedPersons());
                                return TEMPORAL_HELPER.roundToNearestHalfDay(nextEndTime).isAfter(TEMPORAL_HELPER.roundToNearestHalfDay(abstractTask.getEndTime()));
                            })
                            .orElse(false);
                } else if (targetTask instanceof Workpackage workpackage) {
                    return TASK_HELPER.getEarlierAvailableInstantOfPerson(workpackage.getAssignedPersons())
                            .map(earlierAvailableInstantOfPerson -> earlierAvailableInstantOfPerson.atOffset(ZoneOffset.UTC).toLocalDate())
                            .map(earlierAvailableDateOfPerson -> {
                                LocalDate nextEndDate = NON_WORKING_DAYS_SERVICE.getEndDateFromStartDate(earlierAvailableDateOfPerson, newEffortInHours,
                                        workpackage.getAssignedPersons());
                                return nextEndDate.isAfter(workpackage.getEndDate());
                            })
                            .orElse(false);
                }
            }

        }
        return mustBeComputedFromStart;
    }
}

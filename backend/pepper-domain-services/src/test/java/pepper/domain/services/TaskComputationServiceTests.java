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

package pepper.domain.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

import pepper.peppermm.PepperFactory;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;

/**
 * Tests of {@link TaskComputationService}.
 *
 * @author lfasani
 */
public class TaskComputationServiceTests {

    private static final Instant FRIDAY_2026_07_31_T00_00 = toInstant(2026, 7, 31, 0, 0);
    private static final Instant FRIDAY_2026_07_31_T12_00 = toInstant(2026, 7, 31, 12, 0);
    private static final Instant MONDAY_2026_08_03_T00_00 = toInstant(2026, 8, 03, 0, 0);
    private static final Instant MONDAY_2026_08_03_T12_00 = toInstant(2026, 8, 03, 12, 0);

    private final TaskComputationService taskComputationService = new TaskComputationService();

    private static  Instant toInstant(int year, int month, int dayOfMonth, int hour, int minute) {
        return LocalDateTime.of(year, month, dayOfMonth, hour, minute).atZone(ZoneId.systemDefault()).toInstant();
    }


    @Test
    public void updateStartTimeAcrossWeekendUpdatesEffortForStartEndConstraint() {
        this.updateStartTimeBeforeWeekendAndAssertEffort(TaskTimeBoundariesConstraint.START_END, 24);
    }

    @Test
    public void updateStartTimeAcrossWeekendPreservesEffortForEndEffortConstraint() {
        this.updateStartTimeBeforeWeekendAndAssertEffort(TaskTimeBoundariesConstraint.END_EFFORT, 24);
    }

    @Test
    public void updateStartTimeAcrossWeekendUpdatesEffortForStartEffortConstraint() {
        this.updateStartTimeBeforeWeekendAndAssertEffort(TaskTimeBoundariesConstraint.START_EFFORT, 12);
    }

    private void updateStartTimeBeforeWeekendAndAssertEffort(TaskTimeBoundariesConstraint calculationOption, int expectedEffort) {
        Task task1 = this.createTaskBeginningAfterWeekend(calculationOption);

        taskComputationService.updateStartTime(task1, FRIDAY_2026_07_31_T12_00);
        assertThat(task1.getEffort()).isEqualTo(expectedEffort);
        assertThat(task1.getDuration()).isEqualTo(expectedEffort);
    }

    private Task createTaskBeginningAfterWeekend(TaskTimeBoundariesConstraint calculationOption) {
        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setCalculationOption(calculationOption);
        task1.setEffort(12);
        taskComputationService.updateStartTime(task1, MONDAY_2026_08_03_T00_00);
        taskComputationService.updateEndTime(task1, MONDAY_2026_08_03_T12_00);
        return task1;
    }

    @Test
    public void updateEndTimeAcrossWeekendUpdatesEffortForStartEndConstraint() {
        this.updateEndTimePastWeekendAndAssertEffort(TaskTimeBoundariesConstraint.START_END, 36);
    }

    @Test
    public void updateEndTimeAcrossWeekendPreservesEffortForEndEffortConstraint() {
        this.updateEndTimePastWeekendAndAssertEffort(TaskTimeBoundariesConstraint.END_EFFORT, 12);
    }

    @Test
    public void updateEndTimeAcrossWeekendUpdatesEffortForStartEffortConstraint() {
        this.updateEndTimePastWeekendAndAssertEffort(TaskTimeBoundariesConstraint.START_EFFORT, 36);
    }

    private void updateEndTimePastWeekendAndAssertEffort(TaskTimeBoundariesConstraint calculationOption, int expectedEffort) {
        Task task1 = this.createTaskEndingBeforeWeekend(calculationOption);

        taskComputationService.updateEndTime(task1, MONDAY_2026_08_03_T12_00);
        assertThat(task1.getEffort()).isEqualTo(expectedEffort);
        assertThat(task1.getDuration()).isEqualTo(expectedEffort);
    }

    private Task createTaskEndingBeforeWeekend(TaskTimeBoundariesConstraint calculationOption) {
        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setCalculationOption(calculationOption);
        task1.setEffort(12);
        taskComputationService.updateStartTime(task1, FRIDAY_2026_07_31_T00_00);
        taskComputationService.updateEndTime(task1, FRIDAY_2026_07_31_T12_00);
        return task1;
    }
}

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
    public void updateStartTimeAcrossWeekendUpdatesDurationForStartEndConstraint() {
        this.updateStartTimeBeforeWeekendAndAssertDuration(TaskTimeBoundariesConstraint.START_END, 24);
    }

    @Test
    public void updateStartTimeAcrossWeekendPreservesDurationForEndDurationConstraint() {
        this.updateStartTimeBeforeWeekendAndAssertDuration(TaskTimeBoundariesConstraint.END_DURATION, 24);
    }

    @Test
    public void updateStartTimeAcrossWeekendUpdatesDurationForStartDurationConstraint() {
        this.updateStartTimeBeforeWeekendAndAssertDuration(TaskTimeBoundariesConstraint.START_DURATION, 12);
    }

    private void updateStartTimeBeforeWeekendAndAssertDuration(TaskTimeBoundariesConstraint calculationOption, int expectedDuration) {
        Task task1 = this.createTaskBeginningAfterWeekend(calculationOption);

        taskComputationService.updateStartTime(task1, FRIDAY_2026_07_31_T12_00);
        assertThat(task1.getDuration()).isEqualTo(expectedDuration);
    }

    private Task createTaskBeginningAfterWeekend(TaskTimeBoundariesConstraint calculationOption) {
        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setCalculationOption(calculationOption);
        task1.setDuration(12);
        taskComputationService.updateStartTime(task1, MONDAY_2026_08_03_T00_00);
        taskComputationService.updateEndTime(task1, MONDAY_2026_08_03_T12_00);
        return task1;
    }

    @Test
    public void updateEndTimeAcrossWeekendUpdatesDurationForStartEndConstraint() {
        this.updateEndTimePastWeekendAndAssertDuration(TaskTimeBoundariesConstraint.START_END, 36);
    }

    @Test
    public void updateEndTimeAcrossWeekendPreservesDurationForEndDurationConstraint() {
        this.updateEndTimePastWeekendAndAssertDuration(TaskTimeBoundariesConstraint.END_DURATION, 12);
    }

    @Test
    public void updateEndTimeAcrossWeekendUpdatesDurationForStartDurationConstraint() {
        this.updateEndTimePastWeekendAndAssertDuration(TaskTimeBoundariesConstraint.START_DURATION, 36);
    }

    private void updateEndTimePastWeekendAndAssertDuration(TaskTimeBoundariesConstraint calculationOption, int expectedDuration) {
        Task task1 = this.createTaskEndingBeforeWeekend(calculationOption);

        taskComputationService.updateEndTime(task1, MONDAY_2026_08_03_T12_00);
        assertThat(task1.getDuration()).isEqualTo(expectedDuration);
    }

    private Task createTaskEndingBeforeWeekend(TaskTimeBoundariesConstraint calculationOption) {
        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setCalculationOption(calculationOption);
        task1.setDuration(12);
        taskComputationService.updateStartTime(task1, FRIDAY_2026_07_31_T00_00);
        taskComputationService.updateEndTime(task1, FRIDAY_2026_07_31_T12_00);
        return task1;
    }
}

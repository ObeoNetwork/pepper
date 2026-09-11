/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pepper.domain.services.update;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.time.Instant;
import java.util.List;

import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import pepper.peppermm.PepperFactory;
import pepper.peppermm.Person;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Tests person capacity allocation while updating a Gantt batch.
 */
public class TaskUpdateServicePersonCapacityTests {
    private static final Instant MONDAY_MORNING = Instant.parse("2026-07-06T00:00:00Z");
    private static final Instant TUESDAY_NOON = Instant.parse("2026-07-07T12:00:00Z");

    @ParameterizedTest
    @EnumSource(value = TaskTimeBoundariesConstraint.class, names = {"START_EFFORT", "START_END"})
    public void unchangedTaskReservesItsPersonBeforeTheUpdatedTaskIsComputed(TaskTimeBoundariesConstraint calculationOption) {
        Person paul = PepperFactory.eINSTANCE.createPerson();
        Person bob = PepperFactory.eINSTANCE.createPerson();
        Task unchanged = this.task("unchanged", List.of(bob), calculationOption);
        Task updated = this.task("updated", List.of(paul, bob), calculationOption);
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.getOwnedTasks().addAll(List.of(unchanged, updated));

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateWithImpacts(updated, new SimpleUpdateStep(updated));

        assertThat(updated.getEffort()).isEqualTo(12);
    }

    @ParameterizedTest
    @EnumSource(value = TaskTimeBoundariesConstraint.class, names = {"START_EFFORT", "START_END", "END_EFFORT"})
    public void earlierUpdatedStepWinsSharedPersonCapacity(TaskTimeBoundariesConstraint calculationOption) {
        Person bob = PepperFactory.eINSTANCE.createPerson();
        Task first = this.task("first", List.of(bob), calculationOption);
        first.setCalculationOption(calculationOption);
        Task second = this.task("second", List.of(bob), calculationOption);
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.getOwnedTasks().addAll(List.of(first, second));

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateWithImpacts(first, List.of(new SimpleUpdateStep(first), new SimpleUpdateStep(second)));

        assertThat(first.getEffort()).isEqualTo(12);
        assertThat(second.getEffort()).isEqualTo(12);
        assertThat(second.getStartTime()).isAfterOrEqualTo(first.getEndTime());
    }

    @ParameterizedTest
    @EnumSource(value = TaskTimeBoundariesConstraint.class, names = {"START_EFFORT", "START_END"})
    public void effortStepExtendsPastReservedCapacity(TaskTimeBoundariesConstraint calculationOption) {
        Person bob = PepperFactory.eINSTANCE.createPerson();
        Task unchanged = this.task("unchanged", List.of(bob), calculationOption);
        Task updated = this.task("updated", List.of(bob), calculationOption);
//        updated.setCalculationOption(TaskTimeBoundariesConstraint.START_EFFORT);
//        updated.setStartTime(TUESDAY_NOON);
//        updated.setEffort(24);
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.getOwnedTasks().addAll(List.of(unchanged, updated));

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateWithImpacts(updated, new EffortUpdateStep(updated, "1"));

        assertThat(updated.getEffort()).isEqualTo(24);
        assertThat(updated.getStartTime()).isAfterOrEqualTo(unchanged.getEndTime());
    }

    private Task task(String name, List<Person> persons, TaskTimeBoundariesConstraint calculationOption) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(name);
        task.setCalculationOption(calculationOption);
        task.setStartTime(MONDAY_MORNING);
        task.setEndTime(TUESDAY_NOON.minusSeconds(60));
        task.setEffort(12);
        task.getAssignedPersons().addAll(persons);
        return task;
    }
}

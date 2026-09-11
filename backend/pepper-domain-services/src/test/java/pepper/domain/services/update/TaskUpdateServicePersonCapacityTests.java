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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import pepper.peppermm.DependencyLink;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Person;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Tests person capacity allocation while updating a Gantt batch.
 * @author lfasani
 */
public class TaskUpdateServicePersonCapacityTests {
    private static final Instant MONDAY_2026_07_06_MORNING = Instant.parse("2026-07-06T00:00:00Z");
    private static final Instant TUESDAY_NOON = Instant.parse("2026-07-07T12:00:00Z");

    private final Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();

    @BeforeEach
    public void beforeEach() {
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = new ResourceImpl();
        resourceSet.getResources().add(resource);
        ECrossReferenceAdapter adapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(adapter);
        resource.getContents().add(workpackage);
    }

    @ParameterizedTest
    @EnumSource(value = TaskTimeBoundariesConstraint.class, names = {"START_EFFORT", "START_END"})
    public void unchangedTaskReservesItsPersonBeforeTheUpdatedTaskIsComputed(TaskTimeBoundariesConstraint calculationOption) {
        Person bob = PepperFactory.eINSTANCE.createPerson();
        Task unchanged = this.task("unchanged", List.of(bob), calculationOption);
        Task updated = this.task("updated", List.of(bob), calculationOption);
        workpackage.getOwnedTasks().addAll(List.of(unchanged, updated));

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateTaskWithImpacts(updated);

        assertThat(unchanged.getEffort()).isEqualTo(36);
        assertThat(updated.getEffort()).isEqualTo(36);
        assertThat(updated.getStartTime()).isAfterOrEqualTo(unchanged.getEndTime());
    }

    @ParameterizedTest
    @EnumSource(value = TaskTimeBoundariesConstraint.class, names = {"START_EFFORT", "START_END"})
    public void unchangedTaskUsesOtherPerson(TaskTimeBoundariesConstraint calculationOption) {
        Person paul = PepperFactory.eINSTANCE.createPerson();
        Person bob = PepperFactory.eINSTANCE.createPerson();
        Task unchanged = this.task("unchanged", List.of(bob), calculationOption);
        Task unchanged2 = this.task("unchanged2", List.of(paul, bob), calculationOption);
        workpackage.getOwnedTasks().addAll(List.of(unchanged, unchanged2));

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateTaskWithImpacts(unchanged2);

        assertThat(unchanged.getEffort()).isEqualTo(36);
        assertThat(unchanged2.getEffort()).isEqualTo(36);
        assertThat(unchanged2.getStartTime()).isEqualTo(unchanged.getStartTime());
        assertThat(unchanged2.getEndTime()).isEqualTo(unchanged.getEndTime());
    }

    @ParameterizedTest
    @EnumSource(value = TaskTimeBoundariesConstraint.class, names = {"START_EFFORT", "START_END", "END_EFFORT"})
    public void earlierUpdatedStepWinsSharedPersonCapacity(TaskTimeBoundariesConstraint calculationOption) {
        Person bob = PepperFactory.eINSTANCE.createPerson();
        Task first = this.task("first", List.of(bob), calculationOption);
        Task second = this.task("second", List.of(bob), calculationOption);
        workpackage.getOwnedTasks().addAll(List.of(first, second));

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateTaskWithImpacts(first);

        assertThat(first.getEffort()).isEqualTo(36);
        assertThat(second.getEffort()).isEqualTo(36);
        assertThat(second.getStartTime()).isAfterOrEqualTo(first.getEndTime());
    }

    @ParameterizedTest
    @EnumSource(value = TaskTimeBoundariesConstraint.class, names = {"START_EFFORT", "START_END", "END_EFFORT"})
    public void dependencyStepConsiderPreviousStepPersonCapacity(TaskTimeBoundariesConstraint calculationOption) {
        Person bob = PepperFactory.eINSTANCE.createPerson();
        Task first = this.task("first", List.of(bob), calculationOption);
        Task second = this.task("second", List.of(bob), calculationOption);
        workpackage.getOwnedTasks().addAll(List.of(first, second));

        DependencyLink dependencyLinkFromFirstToSecond = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkFromFirstToSecond.setDelay(0);
        dependencyLinkFromFirstToSecond.setTargetKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkFromFirstToSecond.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkFromFirstToSecond.setSource(first);
        second.getDependencies().add(dependencyLinkFromFirstToSecond);

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateTaskWithImpacts(first);

        assertThat(first.getEffort()).isEqualTo(36);
        assertThat(second.getEffort()).isEqualTo(36);
        assertThat(second.getStartTime()).isAfterOrEqualTo(first.getEndTime());
    }

    @ParameterizedTest
    @EnumSource(value = TaskTimeBoundariesConstraint.class, names = {"START_EFFORT"})
    public void effortStepExtendsPastReservedCapacity(TaskTimeBoundariesConstraint calculationOption) {
        Person bob = PepperFactory.eINSTANCE.createPerson();
        Task updated = this.task("updated", List.of(bob), calculationOption);
        Task effortChanged = this.task("effortChanged", List.of(bob), calculationOption);
        workpackage.getOwnedTasks().addAll(List.of(updated, effortChanged));

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateWithImpacts(effortChanged, new EffortUpdateStep(effortChanged, "1"));

        assertThat(effortChanged.getEffort()).isEqualTo(24);
        assertThat(updated.getEffort()).isEqualTo(36);
        assertThat(updated.getStartTime()).isAfterOrEqualTo(effortChanged.getEndTime());
    }

    private Task task(String name, List<Person> persons, TaskTimeBoundariesConstraint calculationOption) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(name);
        task.setCalculationOption(calculationOption);
        task.setStartTime(MONDAY_2026_07_06_MORNING);
        task.setEndTime(TUESDAY_NOON.minusSeconds(60));
        task.setEffort(36);
        task.getAssignedPersons().addAll(persons);
        return task;
    }
}

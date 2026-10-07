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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.time.Instant;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import pepper.peppermm.DependencyLink;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;

/**
 * Tests priority selection and child-before-parent update ordering.
 * @author not me
 */
public class TaskUpdateServiceOrderingTests {

    private final TaskUpdateService service = new TaskUpdateService(mock(IFeedbackMessageService.class));

    @Test
    public void higherPriorityStepsMoveBeforeOtherTasksWhileTiesKeepTheirOrder() {
        TaskUpdateStep low = new PersonUpdateStep(this.createTask("low"));
        TaskUpdateStep firstHigh = new EffortUpdateStep(this.createTask("first high"), "1");
        TaskUpdateStep secondHigh = new EffortUpdateStep(this.createTask("second high"), "1");

        assertThat(this.filterAndOrderTaskUpdateSteps(List.of(low, firstHigh, secondHigh)))
                .containsExactly(firstHigh, secondHigh, low);
    }

    @Test
    public void dependencyStepReplacesPersonStepForTheSameTask() {
        Task task = this.createTask("task");
        TaskUpdateStep personUpdateStep = new PersonUpdateStep(task);
        TaskUpdateStep dependencyUpdateStep = new DependencyUpdateStep(task);

        assertThat(this.filterAndOrderTaskUpdateSteps(List.of(personUpdateStep, dependencyUpdateStep)).iterator().next())
                .isSameAs(dependencyUpdateStep);
    }

    @Test
    public void duplicateStepKeepsTheFirstInstance() {
        Task task = this.createTask("task");
        TaskUpdateStep first = new DependencyUpdateStep(task);
        TaskUpdateStep duplicate = new DependencyUpdateStep(task);

        assertThat(this.filterAndOrderTaskUpdateSteps(List.of(first, duplicate)).iterator().next())
                .isSameAs(first);
    }

    @Test
    public void dependencySourcesMoveBeforeDependentsAcrossTheWholeList() {
        Task first = this.createTask("first");
        Task middle = this.createTask("middle");
        Task last = this.createTask("last");
        DependencyLink firstToMiddle = PepperFactory.eINSTANCE.createDependencyLink();
        firstToMiddle.setSource(first);
        middle.getDependencies().add(firstToMiddle);
        DependencyLink middleToLast = PepperFactory.eINSTANCE.createDependencyLink();
        middleToLast.setSource(middle);
        last.getDependencies().add(middleToLast);
        TaskUpdateStep firstStep = new DependencyUpdateStep(first);
        TaskUpdateStep middleStep = new DependencyUpdateStep(middle);
        TaskUpdateStep lastStep = new DependencyUpdateStep(last);

        assertThat(this.filterAndOrderTaskUpdateSteps(List.of(lastStep, firstStep, middleStep)))
                .containsExactly(firstStep, middleStep, lastStep);
    }

    @Test
    public void nestedParentsWaitForAllDescendants() {
        Task root = this.createTask("root");
        Task child = this.createTask("child");
        Task grandchild = this.createTask("grandchild");
        Task sibling = this.createTask("sibling");
        root.getSubTasks().addAll(List.of(child, sibling));
        child.getSubTasks().add(grandchild);
        TaskUpdateStep rootStep = new ParentUpdateStep(root);
        TaskUpdateStep childStep = new ParentUpdateStep(child);
        TaskUpdateStep grandchildStep = new DependencyUpdateStep(grandchild);
        TaskUpdateStep siblingStep = new PersonUpdateStep(sibling);
        TaskUpdateStep unrelated = new PersonUpdateStep(this.createTask("unrelated"));

        assertThat(this.filterAndOrderTaskUpdateSteps(List.of(rootStep, childStep, unrelated, grandchildStep, siblingStep)))
                .containsExactly(unrelated, grandchildStep, childStep, siblingStep, rootStep);
    }

    private Task createTask(String name) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(name);
        task.setCalculationOption(TaskTimeBoundariesConstraint.START_EFFORT);
        task.setStartTime(Instant.parse("2026-07-06T00:00:00Z"));
        task.setEndTime(Instant.parse("2026-07-06T12:00:00Z").minusSeconds(60));
        task.setEffort(12);
        return task;
    }

    private LinkedHashSet<TaskUpdateStep> filterAndOrderTaskUpdateSteps(Collection<TaskUpdateStep> steps) {
        return ReflectionTestUtils.invokeMethod(service, "filterAndOrderTaskUpdateSteps", steps);
    }
}

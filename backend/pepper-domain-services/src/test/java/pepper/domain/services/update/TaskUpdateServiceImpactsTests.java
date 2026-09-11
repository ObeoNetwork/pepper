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

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import pepper.peppermm.PepperFactory;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Tests recalculation of the Gantt following explicit task updates.
 */
public class TaskUpdateServiceImpactsTests {
    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    public void movingTaskRecalculatesFromEarlierBoundaryAndExecutesAllExplicitSteps(boolean moveEarlier) {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        Task before = this.createTask(7);
        Task changed = this.createTask(moveEarlier ? 10 : 8);
        Task between = this.createTask(9);
        Task after = this.createTask(11);
        workpackage.getOwnedTasks().addAll(List.of(before, changed, between, after));
        Task destination = this.createTask(moveEarlier ? 8 : 10);
        List<String> executions = new ArrayList<>();
        TaskUpdateStep first = this.recordingStep(changed, () -> {
            executions.add("first");
            changed.setStartTime(destination.getStartTime());
            changed.setEndTime(destination.getEndTime());
        });
        TaskUpdateStep second = this.recordingStep(changed, () -> executions.add("second"));

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateWithImpacts(changed, List.of(first, second));

        assertThat(executions).containsExactly("first", "second");
        assertThat(changed.getStartTime()).isEqualTo(destination.getStartTime());
        assertThat(before.getEffort()).isZero();
        assertThat(between.getEffort()).isEqualTo(12);
        assertThat(after.getEffort()).isEqualTo(12);
    }

    private Task createTask(int day) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setCalculationOption(TaskTimeBoundariesConstraint.START_END);
        task.setStartTime(LocalDate.of(2026, 9, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
        task.setEndTime(LocalDate.of(2026, 9, day).atTime(12, 0).atZone(ZoneId.systemDefault()).toInstant());
        task.setEffort(0);
        return task;
    }

    private TaskUpdateStep recordingStep(Task task, Runnable update) {
        return new TaskUpdateStep() {
            @Override
            public Object getImpactedTask() {
                return task;
            }

            @Override
            public String getName() {
                return "recording step";
            }

            @Override
            public void update() {
                update.run();
            }
        };
    }
}

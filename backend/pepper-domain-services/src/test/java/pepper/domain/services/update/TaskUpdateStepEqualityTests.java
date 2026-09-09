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

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import pepper.peppermm.PepperFactory;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.Task;

/**
 * Tests equality between update steps that represent the same task.
 * @author lfasani
 */
public class TaskUpdateStepEqualityTests {

    private static final Task IMPACTED_TASK = PepperFactory.eINSTANCE.createTask();

    private static final List<TaskUpdateStep> STEPS_FOR_SAME_TASK = List.of(
            new ComputeDynamicallyChangeUpdateStep(IMPACTED_TASK, true),
            new CreateDependencyUpdateStep(IMPACTED_TASK, PepperFactory.eINSTANCE.createTask(), StartOrEnd.START, StartOrEnd.END),
            new DependencyUpdateStep(IMPACTED_TASK),
            new EffortUpdateStep(IMPACTED_TASK, "8"),
            new ParentUpdateStep(IMPACTED_TASK),
            new TaskBoundaryUpdateStep(IMPACTED_TASK, Instant.EPOCH, Instant.EPOCH));

    private static Stream<TaskUpdateStep> stepsForSameTask() {
        return STEPS_FOR_SAME_TASK.stream();
    }

    @ParameterizedTest
    @MethodSource("stepsForSameTask")
    public void updateStepsWithTheSameImpactedTaskAreEqual(TaskUpdateStep step) {
        assertThat(STEPS_FOR_SAME_TASK)
                .allSatisfy(otherStep -> {
                    assertThat(step).isEqualTo(otherStep).hasSameHashCodeAs(otherStep);
                    assertThat(otherStep).isEqualTo(step);
                });
    }

    @ParameterizedTest
    @MethodSource("stepsForSameTask")
    public void updateStepsWithDistinctImpactedTaskInstancesAreNotEqual(TaskUpdateStep step) {
        Task distinctTaskWithTheSameName = PepperFactory.eINSTANCE.createTask();
        IMPACTED_TASK.setName("Task");
        distinctTaskWithTheSameName.setName("Task");
        TaskUpdateStep distinctStep = new EffortUpdateStep(distinctTaskWithTheSameName, "8");

        assertThat(step).isNotEqualTo(distinctStep);
        assertThat(distinctStep).isNotEqualTo(step);
    }

    @Test
    public void setDeduplicatesUpdateStepsForTheSameImpactedTask() {
        Set<TaskUpdateStep> steps = new HashSet<>(STEPS_FOR_SAME_TASK);

        assertThat(steps).hasSize(1);
    }
}

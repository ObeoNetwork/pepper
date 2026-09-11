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

import java.util.List;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import pepper.peppermm.PepperFactory;
import pepper.peppermm.Task;

/**
 * Tests priority selection and child-before-parent update ordering.
 */
public class TaskUpdateServiceOrderingTests {

    private final TaskUpdateService service = new TaskUpdateService(mock(IFeedbackMessageService.class));

    @Test
    public void dependencyWinsAcrossSeparatedDuplicatesInAnyOrder() {
        Task task = PepperFactory.eINSTANCE.createTask();
        TaskUpdateStep simple = new SimpleUpdateStep(task);
        TaskUpdateStep parent = new ParentUpdateStep(task);
        TaskUpdateStep dependency = new DependencyUpdateStep(task);
        TaskUpdateStep unrelated = new SimpleUpdateStep(PepperFactory.eINSTANCE.createTask());
        List<List<TaskUpdateStep>> permutations = List.of(
                List.of(simple, parent, dependency), List.of(simple, dependency, parent),
                List.of(parent, simple, dependency), List.of(parent, dependency, simple),
                List.of(dependency, simple, parent), List.of(dependency, parent, simple));

        for (List<TaskUpdateStep> steps : permutations) {
            List<TaskUpdateStep> result = List.copyOf(this.filterAndOrderTaskUpdateSteps(
                    List.of(steps.get(0), unrelated, steps.get(1), steps.get(2))));

            assertThat(result).hasSize(2);
            assertThat(result.get(0)).isSameAs(dependency);
            assertThat(result.get(1)).isSameAs(unrelated);
        }
    }

    @Test
    public void parentWinsOverSimpleRegardlessOfEncounterOrder() {
        Task task = PepperFactory.eINSTANCE.createTask();
        TaskUpdateStep simple = new SimpleUpdateStep(task);
        TaskUpdateStep parent = new ParentUpdateStep(task);
        TaskUpdateStep unrelated = new SimpleUpdateStep(PepperFactory.eINSTANCE.createTask());

        for (List<TaskUpdateStep> steps : List.of(List.of(simple, unrelated, parent), List.of(parent, unrelated, simple))) {
            List<TaskUpdateStep> result = List.copyOf(this.filterAndOrderTaskUpdateSteps(steps));
            assertThat(result).hasSize(2);
            assertThat(result.get(0)).isSameAs(parent);
            assertThat(result.get(1)).isSameAs(unrelated);
        }
    }

    @Test
    public void nestedParentsWaitForAllDescendants() {
        Task root = PepperFactory.eINSTANCE.createTask();
        Task child = PepperFactory.eINSTANCE.createTask();
        Task grandchild = PepperFactory.eINSTANCE.createTask();
        Task sibling = PepperFactory.eINSTANCE.createTask();
        root.getSubTasks().addAll(List.of(child, sibling));
        child.getSubTasks().add(grandchild);
        TaskUpdateStep rootStep = new ParentUpdateStep(root);
        TaskUpdateStep childStep = new ParentUpdateStep(child);
        TaskUpdateStep grandchildStep = new DependencyUpdateStep(grandchild);
        TaskUpdateStep siblingStep = new SimpleUpdateStep(sibling);
        TaskUpdateStep unrelated = new SimpleUpdateStep(PepperFactory.eINSTANCE.createTask());

        assertThat(this.filterAndOrderTaskUpdateSteps(List.of(rootStep, childStep, unrelated, grandchildStep, siblingStep)))
                .containsExactly(unrelated, grandchildStep, childStep, siblingStep, rootStep);
    }

    private LinkedHashSet<TaskUpdateStep> filterAndOrderTaskUpdateSteps(Collection<TaskUpdateStep> steps) {
        return ReflectionTestUtils.invokeMethod(service, "filterAndOrderTaskUpdateSteps", steps);
    }
}

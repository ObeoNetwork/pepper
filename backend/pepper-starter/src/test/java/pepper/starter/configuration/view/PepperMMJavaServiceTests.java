/*******************************************************************************
 * Copyright (c) 2024, 2026 CEA LIST.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 ******************************************************************************/
package pepper.starter.configuration.view;

import static org.assertj.core.api.Assertions.assertThat;

import pepper.peppermm.DependencyLink;
import pepper.starter.services.view.PepperMMJavaService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Task;
import pepper.peppermm.Workpackage;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.gantt.StartOrEnd;
import org.junit.jupiter.api.Test;

/**
 * Test used to validate the service for the task related views.
 *
 * @author lfasani
 */
public class PepperMMJavaServiceTests {

    private static final String NEW_NAME = "newName";
    private static final String NEW_DESCRIPTION = "newDescription";

    @Test
    public void editTask() {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setStartTime(Instant.now());
        task.setEndTime(Instant.now());
        workpackage.getOwnedTasks().add(task);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.editTask(task, NEW_NAME, NEW_DESCRIPTION, Instant.ofEpochSecond(1704067200), Instant.ofEpochSecond(1704070800), 10);
        assertThat(task.getName()).isEqualTo(NEW_NAME);
        assertThat(task.getDescription()).isEqualTo(NEW_DESCRIPTION);
        assertThat(task.getStartTime().getEpochSecond()).isEqualTo(1704067200);
        assertThat(task.getEndTime().getEpochSecond()).isEqualTo(1704070800);
        assertThat(task.getProgress()).isEqualTo(10);
    }

    @Test
    public void editTaskWithDependency() {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();

        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = new ResourceImpl();
        resourceSet.getResources().add(resource);
        ECrossReferenceAdapter adapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(adapter);
        resource.getContents().add(workpackage);

        Task task = PepperFactory.eINSTANCE.createTask();
        Instant now = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        task.setStartTime(now);
        task.setEndTime(now.plus(1, ChronoUnit.DAYS));

        Task taskDependency = PepperFactory.eINSTANCE.createTask();
        taskDependency.setStartTime(now);
        taskDependency.setEndTime(now.plus(1, ChronoUnit.DAYS));

        Task masterTask = PepperFactory.eINSTANCE.createTask();
        masterTask.setStartTime(now);
        masterTask.setEndTime(now.plus(1, ChronoUnit.DAYS));

        workpackage.getOwnedTasks().add(task);
        workpackage.getOwnedTasks().add(taskDependency);
        workpackage.getOwnedTasks().add(masterTask);

        DependencyLink dependencyLinkOfTask = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkOfTask.setDuration(0);
        dependencyLinkOfTask.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkOfTask.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkOfTask.setSource(taskDependency);
        task.getDependencies().add(dependencyLinkOfTask);

        DependencyLink dependencyLinkOfTaskDependency = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkOfTaskDependency.setDuration(0);
        dependencyLinkOfTaskDependency.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkOfTaskDependency.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkOfTaskDependency.setSource(masterTask);
        taskDependency.getDependencies().add(dependencyLinkOfTaskDependency);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.editTask(taskDependency, null, null, now.plus(1, ChronoUnit.DAYS), now.plus(2, ChronoUnit.DAYS), null);
        assertThat(taskDependency.getStartTime()).isEqualTo(now);
        assertThat(taskDependency.getEndTime()).isEqualTo(now.plus(1, ChronoUnit.DAYS));

        service.editTask(masterTask, null, null, now.plus(1, ChronoUnit.DAYS), now.plus(2, ChronoUnit.DAYS), null);
        assertThat(masterTask.getStartTime()).isEqualTo(now.plus(1, ChronoUnit.DAYS));
        assertThat(masterTask.getEndTime()).isEqualTo(now.plus(2, ChronoUnit.DAYS));
        assertThat(taskDependency.getStartTime()).isEqualTo(masterTask.getEndTime());
        assertThat(taskDependency.getEndTime()).isEqualTo(masterTask.getEndTime().plus(1, ChronoUnit.DAYS));
        // Verify transitive dependency propagation
        assertThat(task.getStartTime()).isEqualTo(taskDependency.getEndTime());
        assertThat(task.getEndTime()).isEqualTo(taskDependency.getEndTime().plus(1, ChronoUnit.DAYS));
    }



    @Test
    public void createDependencyLink() {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();

        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = new ResourceImpl();
        resourceSet.getResources().add(resource);
        ECrossReferenceAdapter adapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(adapter);
        resource.getContents().add(workpackage);

        Task task = PepperFactory.eINSTANCE.createTask();
        Instant now = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        task.setStartTime(now);
        task.setEndTime(now.plus(1, ChronoUnit.DAYS));

        Task taskDependency = PepperFactory.eINSTANCE.createTask();
        taskDependency.setStartTime(now);
        taskDependency.setEndTime(now.plus(1, ChronoUnit.DAYS));

        Task masterTask = PepperFactory.eINSTANCE.createTask();
        masterTask.setStartTime(now);
        masterTask.setEndTime(now.plus(1, ChronoUnit.DAYS));

        workpackage.getOwnedTasks().add(task);
        workpackage.getOwnedTasks().add(taskDependency);
        workpackage.getOwnedTasks().add(masterTask);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.createDependencyLink(task, taskDependency, StartOrEnd.END, StartOrEnd.START);
        assertThat(task.getDependencies().size()).isEqualTo(1);
        assertThat(task.getDependencies().get(0).getSource()).isEqualTo(taskDependency);
        assertThat(task.getStartTime()).isEqualTo(taskDependency.getEndTime());
        assertThat(task.getEndTime()).isEqualTo(task.getStartTime().plus(1, ChronoUnit.DAYS));

        service.createDependencyLink(taskDependency, masterTask, StartOrEnd.END, StartOrEnd.END);
        assertThat(taskDependency.getDependencies().size()).isEqualTo(1);
        assertThat(taskDependency.getDependencies().get(0).getSource()).isEqualTo(masterTask);
        assertThat(taskDependency.getStartTime()).isEqualTo(masterTask.getStartTime());
        assertThat(taskDependency.getEndTime()).isEqualTo(masterTask.getEndTime());
        // Verify transitive dependency propagation
        assertThat(task.getStartTime()).isEqualTo(taskDependency.getEndTime());
        assertThat(task.getEndTime()).isEqualTo(task.getStartTime().plus(1, ChronoUnit.DAYS));

        // Verify that cyclic dependencies are impossible
        assertThat(masterTask.getDependencies()).isEmpty();
        service.createDependencyLink(masterTask, task, StartOrEnd.END, StartOrEnd.START);
        assertThat(masterTask.getDependencies()).isEmpty();

    }

    @Test
    public void deleteDependencyLink() {
        Task task = PepperFactory.eINSTANCE.createTask();
        Task taskDependency = PepperFactory.eINSTANCE.createTask();

        DependencyLink dependencyLink = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLink.setDuration(0);
        dependencyLink.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLink.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLink.setSource(taskDependency);
        task.getDependencies().add(dependencyLink);
        assertThat(task.getDependencies().size()).isEqualTo(1);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.deleteDependencyLink(task, taskDependency);
        assertThat(task.getDependencies().size()).isEqualTo(0);
    }


    @Test
    public void computeTaskDurationDays() {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setStartTime(Instant.ofEpochSecond(1704067200));
        task.setEndTime(Instant.ofEpochSecond(1704157260));
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        var result = service.computeTaskDurationDays(task);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("01d01h01m");
    }

    @Test
    public void editCard() {
        AbstractTask card = PepperFactory.eINSTANCE.createTask();
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.editCard(card, NEW_NAME, NEW_DESCRIPTION, null);
        assertThat(card.getName()).isEqualTo(NEW_NAME);
        assertThat(card.getDescription()).isEqualTo(NEW_DESCRIPTION);
    }

    @Test
    public void createTask() {
        Task task11 = PepperFactory.eINSTANCE.createTask();
        task11.setStartTime(Instant.parse("2024-01-01T00:00:00Z"));
        task11.setEndTime(Instant.parse("2024-01-01T23:59:00Z"));

        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setStartTime(Instant.parse("2024-01-01T00:00:00Z"));
        task1.setEndTime(Instant.parse("2024-01-01T23:59:00Z"));
        task1.getSubTasks().add(task11);

        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.getOwnedTasks().add(task1);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());

        service.createTask(workpackage);
        assertThat(workpackage.getOwnedTasks()).hasSize(2);

        service.createTask(task1);
        assertThat(workpackage.getOwnedTasks()).hasSize(3);
        assertThat(workpackage.getOwnedTasks().get(1).getStartTime()).isEqualTo(Instant.parse("2024-01-02T00:00:00Z"));
        assertThat(workpackage.getOwnedTasks().get(1).getEndTime()).isEqualTo(Instant.parse("2024-01-02T23:59:00Z"));

        service.createTask(task11);
        assertThat(task1.getSubTasks()).hasSize(2);
        assertThat(task1.getSubTasks().get(1).getStartTime()).isEqualTo(Instant.parse("2024-01-02T00:00:00Z"));
        assertThat(task1.getSubTasks().get(1).getEndTime()).isEqualTo(Instant.parse("2024-01-02T23:59:00Z"));
    }

    @Test
    public void deleteTask() {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();

        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = new ResourceImpl();
        resourceSet.getResources().add(resource);
        ECrossReferenceAdapter adapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(adapter);
        resource.getContents().add(workpackage);

        Task task11 = PepperFactory.eINSTANCE.createTask();
        task11.setStartTime(Instant.ofEpochSecond(1704067200));
        task11.setEndTime(Instant.ofEpochSecond(1704157260));

        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setStartTime(Instant.ofEpochSecond(1704067200));
        task1.setEndTime(Instant.ofEpochSecond(1704157260));
        task1.getSubTasks().add(task11);

        Task task2 = PepperFactory.eINSTANCE.createTask();
        task2.setStartTime(Instant.ofEpochSecond(1704067200));
        task2.setEndTime(Instant.ofEpochSecond(1704157260));

        DependencyLink dependencyLinkOfTaskDependency = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkOfTaskDependency.setDuration(0);
        dependencyLinkOfTaskDependency.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkOfTaskDependency.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkOfTaskDependency.setSource(task11);
        task2.getDependencies().add(dependencyLinkOfTaskDependency);

        workpackage.getOwnedTasks().add(task1);
        workpackage.getOwnedTasks().add(task2);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());

        service.deleteTask(task1);
        assertThat(workpackage.getOwnedTasks()).hasSize(1);
        assertThat(task2.getDependencies()).hasSize(0);
    }
}

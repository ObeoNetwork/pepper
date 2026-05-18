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
import pepper.peppermm.Project;
import pepper.peppermm.TagFolder;
import pepper.peppermm.TaskTag;
import pepper.starter.services.view.PepperMMJavaService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Task;
import pepper.peppermm.Workpackage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

    private static final ZonedDateTime ZONED_DATE_TIME = LocalDateTime
            .of(2023, 12, 10, 0, 0)
            .atZone(ZoneId.systemDefault());
    private static final String ZONE = ZONED_DATE_TIME.getOffset().toString();

    private static final String DATE2024_01_01_T00_00_00 = "2024-01-01T00:00:00" + ZONE;
    private static final String DATE2024_01_01_T23_59_00 = "2024-01-01T23:59:00" + ZONE;
    private static final String DATE2024_01_02_T00_00_00 = "2024-01-02T00:00:00" + ZONE;
    private static final String DATE2024_01_02_T23_59_00 = "2024-01-02T23:59:00" + ZONE;



    @Test
    public void editTask() {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setStartTime(Instant.now());
        task.setEndTime(Instant.now());
        workpackage.getOwnedTasks().add(task);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.editTask(task, NEW_NAME, NEW_DESCRIPTION, Instant.ofEpochSecond(1704067200), Instant.ofEpochSecond(1704070800), 10, false);
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
        task.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        Task taskDependency = PepperFactory.eINSTANCE.createTask();
        taskDependency.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        taskDependency.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));
        Task masterTask = PepperFactory.eINSTANCE.createTask();
        masterTask.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        masterTask.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

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
        service.editTask(taskDependency, null, null, Instant.parse(DATE2024_01_02_T00_00_00), Instant.parse(DATE2024_01_02_T00_00_00).plus(1, ChronoUnit.DAYS), null, false);
        assertThat(taskDependency.getStartTime()).isEqualTo(Instant.parse(DATE2024_01_01_T00_00_00));
        assertThat(taskDependency.getEndTime()).isEqualTo(Instant.parse(DATE2024_01_01_T23_59_00));

        service.editTask(masterTask, null, null, Instant.parse(DATE2024_01_02_T00_00_00), Instant.parse(DATE2024_01_02_T00_00_00).plus(1, ChronoUnit.DAYS), null, false);
        assertThat(masterTask.getStartTime()).isEqualTo(DATE2024_01_02_T00_00_00);
        assertThat(masterTask.getEndTime()).isEqualTo(DATE2024_01_02_T23_59_00);
        assertThat(taskDependency.getStartTime()).isEqualTo(masterTask.getEndTime().plus(1, ChronoUnit.MINUTES));
        assertThat(taskDependency.getEndTime()).isEqualTo(masterTask.getEndTime().plus(1, ChronoUnit.DAYS));
        // Verify transitive dependency propagation
        assertThat(task.getStartTime()).isEqualTo(taskDependency.getEndTime().plus(1, ChronoUnit.MINUTES));
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
        task.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        Task taskDependency = PepperFactory.eINSTANCE.createTask();
        taskDependency.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        taskDependency.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        Task masterTask = PepperFactory.eINSTANCE.createTask();
        masterTask.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        masterTask.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        workpackage.getOwnedTasks().add(task);
        workpackage.getOwnedTasks().add(taskDependency);
        workpackage.getOwnedTasks().add(masterTask);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.createDependencyLink(task, taskDependency, StartOrEnd.END, StartOrEnd.START);
        assertThat(task.getDependencies().size()).isEqualTo(1);
        assertThat(task.getDependencies().get(0).getSource()).isEqualTo(taskDependency);
        assertThat(task.getStartTime()).isEqualTo(Instant.parse(DATE2024_01_02_T00_00_00));
        assertThat(task.getEndTime()).isEqualTo(Instant.parse(DATE2024_01_02_T23_59_00));

        service.createDependencyLink(taskDependency, masterTask, StartOrEnd.END, StartOrEnd.END);
        assertThat(taskDependency.getDependencies().size()).isEqualTo(1);
        assertThat(taskDependency.getDependencies().get(0).getSource()).isEqualTo(masterTask);
        assertThat(taskDependency.getStartTime()).isEqualTo(masterTask.getStartTime());
        assertThat(taskDependency.getEndTime()).isEqualTo(masterTask.getEndTime());
        // Verify transitive dependency propagation
        assertThat(task.getStartTime()).isEqualTo(taskDependency.getEndTime().plus(1, ChronoUnit.MINUTES));
        assertThat(task.getEndTime()).isEqualTo(Instant.parse(DATE2024_01_02_T23_59_00));

        // Verify that cyclic dependencies are impossible
        assertThat(masterTask.getDependencies()).isEmpty();
        service.createDependencyLink(masterTask, task, StartOrEnd.END, StartOrEnd.START);
        assertThat(masterTask.getDependencies()).isEmpty();

    }

    @Test
    public void deleteDependencyLink() {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();

        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = new ResourceImpl();
        resourceSet.getResources().add(resource);
        ECrossReferenceAdapter adapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(adapter);
        resource.getContents().add(workpackage);

        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task1.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        Task task2 = PepperFactory.eINSTANCE.createTask();
        task2.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task2.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        Task task3 = PepperFactory.eINSTANCE.createTask();
        task3.setStartTime(Instant.parse(DATE2024_01_02_T00_00_00));
        task3.setEndTime(Instant.parse(DATE2024_01_02_T23_59_00));

        workpackage.getOwnedTasks().add(task1);
        workpackage.getOwnedTasks().add(task2);
        workpackage.getOwnedTasks().add(task3);

        DependencyLink dependencyLinkFromTask1ToTask2 = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkFromTask1ToTask2.setDuration(0);
        dependencyLinkFromTask1ToTask2.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkFromTask1ToTask2.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkFromTask1ToTask2.setSource(task2);
        task1.getDependencies().add(dependencyLinkFromTask1ToTask2);

        DependencyLink dependencyLinkFromTask1ToTask3 = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkFromTask1ToTask3.setDuration(0);
        dependencyLinkFromTask1ToTask3.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkFromTask1ToTask3.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkFromTask1ToTask3.setSource(task3);
        task1.getDependencies().add(dependencyLinkFromTask1ToTask3);
        assertThat(task1.getDependencies().size()).isEqualTo(2);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.deleteDependencyLink(task1, task2);
        assertThat(task1.getDependencies().size()).isEqualTo(1);
        assertThat(task1.getStartTime()).isEqualTo(task3.getEndTime().plus(1, ChronoUnit.MINUTES));
    }

    @Test
    public void computeTaskDurationDays() {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setStartTime(Instant.now());
        task.setEndTime(Instant.now().plus(1, ChronoUnit.HOURS).plus(1, ChronoUnit.DAYS));
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        var result = service.computeTaskDurationDays(task);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("01d01h");
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
    public void createCard() {
        TaskTag tag = PepperFactory.eINSTANCE.createTaskTag();
        TagFolder tagFolder = PepperFactory.eINSTANCE.createTagFolder();
        Project project = PepperFactory.eINSTANCE.createProject();
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        project.getOwnedWorkpackages().add(workpackage);
        project.getOwnedTagFolders().add(tagFolder);
        project.getOwnedTagFolders().get(0).getOwnedTags().add(tag);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.createCard(tag);
        assertThat(project.getOwnedWorkpackages().get(0).getOwnedTasks()).hasSize(1);
        assertThat(project.getOwnedWorkpackages().get(0).getOwnedTasks().get(0).getName()).isEqualTo("New Task");
        assertThat(project.getOwnedWorkpackages().get(0).getOwnedTasks().get(0).getDescription()).isEqualTo("new description");
        assertThat(project.getOwnedWorkpackages().get(0).getOwnedTasks().get(0).getTags()).hasSize(1);
    }

    @Test
    public void createTask() {
        Task task11 = PepperFactory.eINSTANCE.createTask();
        task11.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task11.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task1.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));
        task1.getSubTasks().add(task11);

        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.getOwnedTasks().add(task1);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());

        service.createTask(workpackage);
        assertThat(workpackage.getOwnedTasks()).hasSize(2);

        service.createTask(task1);
        assertThat(workpackage.getOwnedTasks()).hasSize(3);
        assertThat(workpackage.getOwnedTasks().get(1).getStartTime()).isEqualTo(Instant.parse(DATE2024_01_02_T00_00_00));
        assertThat(workpackage.getOwnedTasks().get(1).getEndTime()).isEqualTo(Instant.parse(DATE2024_01_02_T23_59_00));

        service.createTask(task11);
        assertThat(task1.getSubTasks()).hasSize(2);
        assertThat(task1.getSubTasks().get(1).getStartTime()).isEqualTo(Instant.parse(DATE2024_01_02_T00_00_00));
        assertThat(task1.getSubTasks().get(1).getEndTime()).isEqualTo(Instant.parse(DATE2024_01_02_T23_59_00));
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
        task11.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task11.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task1.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));
        task1.getSubTasks().add(task11);

        Task task2 = PepperFactory.eINSTANCE.createTask();
        task2.setStartTime(Instant.parse(DATE2024_01_01_T00_00_00));
        task2.setEndTime(Instant.parse(DATE2024_01_01_T23_59_00));

        Task task3 = PepperFactory.eINSTANCE.createTask();
        task3.setStartTime(Instant.parse(DATE2024_01_02_T00_00_00));
        task3.setEndTime(Instant.parse(DATE2024_01_02_T23_59_00));

        workpackage.getOwnedTasks().add(task1);
        workpackage.getOwnedTasks().add(task2);
        workpackage.getOwnedTasks().add(task3);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());

        service.createDependencyLink(task2, task3, StartOrEnd.END, StartOrEnd.START);
        service.createDependencyLink(task2, task11, StartOrEnd.END, StartOrEnd.START);

        service.deleteDependencyRelatedObject(task1);
        assertThat(workpackage.getOwnedTasks()).hasSize(2);
        assertThat(task2.getDependencies()).hasSize(1);
        assertThat(task2.getStartTime()).isEqualTo(task3.getEndTime().plus(1, ChronoUnit.MINUTES));
    }

    @Test
    public void createWorkpackage() {
        Project project = PepperFactory.eINSTANCE.createProject();
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.setStartDate(LocalDate.ofYearDay(2026, 1));
        workpackage.setEndDate(LocalDate.ofYearDay(2026, 3));
        project.getOwnedWorkpackages().add(workpackage);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.createWorkpackage(workpackage);
        assertThat(project.getOwnedWorkpackages()).hasSize(2);
        assertThat(project.getOwnedWorkpackages().get(1).getStartDate()).isEqualTo(LocalDate.ofYearDay(2026, 4));
        assertThat(project.getOwnedWorkpackages().get(1).getEndDate()).isEqualTo(LocalDate.ofYearDay(2026, 6));
    }

    @Test
    public void editWorkpackage() {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.setStartDate(LocalDate.ofYearDay(2026, 5));
        workpackage.setEndDate(LocalDate.ofYearDay(2026, 8));

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.editWorkpackage(workpackage, NEW_NAME, NEW_DESCRIPTION, LocalDate.ofYearDay(2026, 1), LocalDate.ofYearDay(2026, 3), 10, false);
        assertThat(workpackage.getName()).isEqualTo(NEW_NAME);
        assertThat(workpackage.getDescription()).isEqualTo(NEW_DESCRIPTION);
        assertThat(workpackage.getStartDate()).isEqualTo(LocalDate.ofYearDay(2026, 1));
        assertThat(workpackage.getEndDate()).isEqualTo(LocalDate.ofYearDay(2026, 3));
        assertThat(workpackage.getProgress()).isEqualTo(10);
    }

    @Test
    public void deleteWorkpackage() {
        Project project = PepperFactory.eINSTANCE.createProject();
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.setStartDate(LocalDate.ofYearDay(2026, 5));
        workpackage.setEndDate(LocalDate.ofYearDay(2026, 8));
        project.getOwnedWorkpackages().add(workpackage);
        assertThat(project.getOwnedWorkpackages()).hasSize(1);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
        service.deleteWorkpackage(workpackage);
        assertThat(project.getOwnedWorkpackages()).hasSize(0);
    }
}

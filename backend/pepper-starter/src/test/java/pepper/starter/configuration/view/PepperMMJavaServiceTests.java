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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pepper.domain.services.TaskComputationService;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Project;
import pepper.peppermm.TagFolder;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTag;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;
import pepper.starter.services.representations.PepperMMJavaService;

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

    private static final String MONDAY_2026_01_05_T00_00_00 = "2026-01-05T00:00:00" + ZONE;
    private static final String MONDAY_2026_01_05_T23_59_00 = "2026-01-05T23:59:00" + ZONE;
    private static final String TUESDAY_2026_01_06_T00_00_00 = "2026-01-06T00:00:00" + ZONE;
    private static final String TUESDAY_2026_01_06_T23_59_00 = "2026-01-06T23:59:00" + ZONE;


    private static final LocalDate MONDAY_20260105 = LocalDate.ofYearDay(2026, 5);
    private static final LocalDate TUESDAY_20260106 = LocalDate.ofYearDay(2026, 6);
    private static final LocalDate WEDNESDAY_20260107 = LocalDate.ofYearDay(2026, 7);
    private static final LocalDate THURSDAY_20260108 = LocalDate.ofYearDay(2026, 8);
    private static final LocalDate FRIDAY_20260109 = LocalDate.ofYearDay(2026, 9);

    private final Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();

    private final TaskComputationService taskComputationService = new TaskComputationService();

    private final WorkpackageComputationService workpackageComputationService = new WorkpackageComputationService();

    @BeforeEach
    public void beforeEach() {
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = new ResourceImpl();
        resourceSet.getResources().add(resource);
        ECrossReferenceAdapter adapter = new ECrossReferenceAdapter();
        resourceSet.eAdapters().add(adapter);
        resource.getContents().add(workpackage);
    }


    @Test
    public void editTask() {
        Task task = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task, Instant.now());
        taskComputationService.updateEndTime(task, Instant.now());
        workpackage.getOwnedTasks().add(task);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.editTask(task, NEW_NAME, NEW_DESCRIPTION, Instant.parse(MONDAY_2026_01_05_T00_00_00), Instant.parse(MONDAY_2026_01_05_T23_59_00), 10, false);
        assertThat(task.getName()).isEqualTo(NEW_NAME);
        assertThat(task.getDescription()).isEqualTo(NEW_DESCRIPTION);
        assertThat(task.getStartTime()).isEqualTo(Instant.parse(MONDAY_2026_01_05_T00_00_00));
        assertThat(task.getEndTime()).isEqualTo(Instant.parse(MONDAY_2026_01_05_T23_59_00));
        assertThat(task.getProgress()).isEqualTo(10);
    }

    @Test
    public void editTaskWithDependency() {
        Task task1 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task1, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task1, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task2 = PepperFactory.eINSTANCE.createTask();
        task2.setCalculationOption(TaskTimeBoundariesConstraint.START_DURATION);
        taskComputationService.updateStartTime(task2, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateDuration(task2, 24);

        Task task3 = PepperFactory.eINSTANCE.createTask();
        task3.setCalculationOption(TaskTimeBoundariesConstraint.START_DURATION);
        taskComputationService.updateStartTime(task3, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateDuration(task3, 24);

        workpackage.getOwnedTasks().add(task3);
        workpackage.getOwnedTasks().add(task2);
        workpackage.getOwnedTasks().add(task1);

        DependencyLink dependencyLinkOfTask = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkOfTask.setDuration(0);
        dependencyLinkOfTask.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkOfTask.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkOfTask.setSource(task2);
        task3.getDependencies().add(dependencyLinkOfTask);

        DependencyLink dependencyLinkOfTaskDependency = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkOfTaskDependency.setDuration(0);
        dependencyLinkOfTaskDependency.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkOfTaskDependency.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkOfTaskDependency.setSource(task1);
        task2.getDependencies().add(dependencyLinkOfTaskDependency);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.editTask(task2, null, null, Instant.parse(TUESDAY_2026_01_06_T00_00_00), Instant.parse(TUESDAY_2026_01_06_T00_00_00).plus(1, ChronoUnit.DAYS), null, false);
        assertThat(task2.getStartTime()).isEqualTo(Instant.parse(MONDAY_2026_01_05_T00_00_00));
        assertThat(task2.getEndTime()).isEqualTo(Instant.parse(MONDAY_2026_01_05_T23_59_00));

        service.editTask(task1, null, null, Instant.parse(TUESDAY_2026_01_06_T00_00_00), Instant.parse(TUESDAY_2026_01_06_T00_00_00).plus(1, ChronoUnit.DAYS), null, false);
        assertThat(task1.getStartTime()).isEqualTo(TUESDAY_2026_01_06_T00_00_00);
        assertThat(task1.getEndTime()).isEqualTo(TUESDAY_2026_01_06_T23_59_00);
        assertThat(task2.getStartTime()).isEqualTo(task1.getEndTime().plus(1, ChronoUnit.MINUTES));
        assertThat(task2.getEndTime()).isEqualTo(task1.getEndTime().plus(1, ChronoUnit.DAYS));
        // Verify transitive dependency propagation
        assertThat(task3.getStartTime()).isEqualTo(task2.getEndTime().plus(1, ChronoUnit.MINUTES));
        assertThat(task3.getEndTime()).isEqualTo(task2.getEndTime().plus(1, ChronoUnit.DAYS));
    }

    @Test
    public void editSubTaskOfDynamicTaskWithDependency() {
        Task task1 = PepperFactory.eINSTANCE.createTask();
        task1.setCalculationOption(TaskTimeBoundariesConstraint.START_END);
        taskComputationService.updateStartTime(task1, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task1, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task2 = PepperFactory.eINSTANCE.createTask();
        task2.setCalculationOption(TaskTimeBoundariesConstraint.START_END);
        taskComputationService.updateStartTime(task2, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task2, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task3 = PepperFactory.eINSTANCE.createTask();
        task3.setCalculationOption(TaskTimeBoundariesConstraint.START_END);
        taskComputationService.updateStartTime(task3, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task3, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task31 = PepperFactory.eINSTANCE.createTask();
        task31.setCalculationOption(TaskTimeBoundariesConstraint.START_END);
        taskComputationService.updateStartTime(task31, Instant.parse(TUESDAY_2026_01_06_T00_00_00));
        taskComputationService.updateEndTime(task31, Instant.parse(TUESDAY_2026_01_06_T23_59_00));

        workpackage.getOwnedTasks().add(task1);
        workpackage.getOwnedTasks().add(task2);
        workpackage.getOwnedTasks().add(task3);
        task3.getSubTasks().add(task31);
        task3.setComputeStartEndDynamically(true);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());

        DependencyLink dependencyLinkFromTask3ToTask1 = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkFromTask3ToTask1.setDuration(0);
        dependencyLinkFromTask3ToTask1.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkFromTask3ToTask1.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkFromTask3ToTask1.setSource(task3);
        task1.getDependencies().add(dependencyLinkFromTask3ToTask1);

        service.editTask(task31, null, null, task31.getStartTime(), task31.getEndTime().plus(1, ChronoUnit.DAYS), null, true);

        assertThat(task3.getSubTasks().size()).isEqualTo(1);
        assertThat(task31.getEndTime()).isEqualTo(Instant.parse(TUESDAY_2026_01_06_T23_59_00).plus(1, ChronoUnit.DAYS));
        assertThat(task1.getStartTime()).isEqualTo(task31.getEndTime().plus(1, ChronoUnit.MINUTES));
    }



    @Test
    public void createDependencyLink() {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setCalculationOption(TaskTimeBoundariesConstraint.START_DURATION);
        taskComputationService.updateStartTime(task, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateDuration(task, 24);

        Task taskDependency = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(taskDependency, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(taskDependency, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task masterTask = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(masterTask, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(masterTask, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        workpackage.getOwnedTasks().add(task);
        workpackage.getOwnedTasks().add(taskDependency);
        workpackage.getOwnedTasks().add(masterTask);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.createDependencyLink(taskDependency, task, StartOrEnd.END, StartOrEnd.START);
        assertThat(task.getDependencies().size()).isEqualTo(1);
        assertThat(task.getDependencies().get(0).getSource()).isEqualTo(taskDependency);
        assertThat(task.getStartTime()).isEqualTo(Instant.parse(TUESDAY_2026_01_06_T00_00_00));
        assertThat(task.getEndTime()).isEqualTo(Instant.parse(TUESDAY_2026_01_06_T23_59_00));

        service.createDependencyLink(masterTask, taskDependency, StartOrEnd.END, StartOrEnd.END);
        assertThat(taskDependency.getDependencies().size()).isEqualTo(1);
        assertThat(taskDependency.getDependencies().get(0).getSource()).isEqualTo(masterTask);
        assertThat(taskDependency.getStartTime()).isEqualTo(masterTask.getStartTime());
        assertThat(taskDependency.getEndTime()).isEqualTo(masterTask.getEndTime());
        // Verify transitive dependency propagation
        assertThat(task.getStartTime()).isEqualTo(taskDependency.getEndTime().plus(1, ChronoUnit.MINUTES));
        assertThat(task.getEndTime()).isEqualTo(Instant.parse(TUESDAY_2026_01_06_T23_59_00));

        // Verify that cyclic dependencies are impossible
        assertThat(masterTask.getDependencies()).isEmpty();
        service.createDependencyLink(task, masterTask, StartOrEnd.END, StartOrEnd.START);
        assertThat(masterTask.getDependencies()).isEmpty();

    }

    @Test
    public void deleteDependencyLink() {

        Task task1 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task1, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task1, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task2 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task2, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task2, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task3 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task3, Instant.parse(TUESDAY_2026_01_06_T00_00_00));
        taskComputationService.updateEndTime(task3, Instant.parse(TUESDAY_2026_01_06_T23_59_00));

        workpackage.getOwnedTasks().add(task1);
        workpackage.getOwnedTasks().add(task2);
        workpackage.getOwnedTasks().add(task3);

        DependencyLink dependencyLinkFromTask1ToTask2 = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkFromTask1ToTask2.setDuration(0);
        dependencyLinkFromTask1ToTask2.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkFromTask1ToTask2.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkFromTask1ToTask2.setSource(task2);
        task1.getDependencies().add(dependencyLinkFromTask1ToTask2);

        DependencyLink dependencyLinkFromTask3ToTask1 = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLinkFromTask3ToTask1.setDuration(0);
        dependencyLinkFromTask3ToTask1.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyLinkFromTask3ToTask1.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyLinkFromTask3ToTask1.setSource(task3);
        task1.getDependencies().add(dependencyLinkFromTask3ToTask1);
        assertThat(task1.getDependencies().size()).isEqualTo(2);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.deleteDependencyLink(task1, task2);
        assertThat(task1.getDependencies().size()).isEqualTo(1);
        assertThat(task1.getStartTime()).isEqualTo(task3.getEndTime().plus(1, ChronoUnit.MINUTES));
    }

    @Test
    public void computeTaskDurationDays() {
        Task task = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task, Instant.now());
        taskComputationService.updateEndTime(task, Instant.now().plus(1, ChronoUnit.HOURS).plus(1, ChronoUnit.DAYS));
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        var result = service.computeTaskDurationDays(task);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("01d00h");
    }

    @Test
    public void editCard() {
        AbstractTask card = PepperFactory.eINSTANCE.createTask();
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.editCard(card, NEW_NAME, NEW_DESCRIPTION, null);
        assertThat(card.getName()).isEqualTo(NEW_NAME);
        assertThat(card.getDescription()).isEqualTo(NEW_DESCRIPTION);
    }

    @Test
    public void createCard() {
        TaskTag tag = PepperFactory.eINSTANCE.createTaskTag();
        TagFolder tagFolder = PepperFactory.eINSTANCE.createTagFolder();
        Project project = PepperFactory.eINSTANCE.createProject();
        Workpackage projectWorkpackage = PepperFactory.eINSTANCE.createWorkpackage();
        project.getOwnedWorkpackages().add(projectWorkpackage);
        project.getOwnedTagFolders().add(tagFolder);
        project.getOwnedTagFolders().get(0).getOwnedTags().add(tag);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.createCard(tag);
        assertThat(project.getOwnedWorkpackages().get(0).getOwnedTasks()).hasSize(1);
        assertThat(project.getOwnedWorkpackages().get(0).getOwnedTasks().get(0).getName()).isEqualTo("New Task");
        assertThat(project.getOwnedWorkpackages().get(0).getOwnedTasks().get(0).getDescription()).isEqualTo("new description");
        assertThat(project.getOwnedWorkpackages().get(0).getOwnedTasks().get(0).getTags()).hasSize(1);
    }

    @Test
    public void createTask() {
        Task task11 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task11, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task11, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task1 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task1, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task1, Instant.parse(MONDAY_2026_01_05_T23_59_00));
        task1.getSubTasks().add(task11);

        workpackage.getOwnedTasks().add(task1);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());

        service.createTask(workpackage);
        assertThat(workpackage.getOwnedTasks()).hasSize(2);

        service.createTask(task1);
        assertThat(task1.getSubTasks()).hasSize(2);
        assertThat(task1.getSubTasks().get(1).getStartTime()).isEqualTo(Instant.parse(TUESDAY_2026_01_06_T00_00_00));
        assertThat(task1.getSubTasks().get(1).getEndTime()).isEqualTo(Instant.parse(TUESDAY_2026_01_06_T23_59_00));

        service.createTask(task11);
        assertThat(task11.getSubTasks()).hasSize(1);
        assertThat(task11.getSubTasks().get(0).getStartTime()).isEqualTo(task11.getStartTime());
        assertThat(task11.getSubTasks().get(0).getEndTime()).isEqualTo(task11.getEndTime());
    }

    @Test
    public void deleteTask() {
        Task task11 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task11, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task11, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task1 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task1, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task1, Instant.parse(MONDAY_2026_01_05_T23_59_00));
        task1.getSubTasks().add(task11);

        Task task2 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task2, Instant.parse(MONDAY_2026_01_05_T00_00_00));
        taskComputationService.updateEndTime(task2, Instant.parse(MONDAY_2026_01_05_T23_59_00));

        Task task3 = PepperFactory.eINSTANCE.createTask();
        taskComputationService.updateStartTime(task3, Instant.parse(TUESDAY_2026_01_06_T00_00_00));
        taskComputationService.updateEndTime(task3, Instant.parse(TUESDAY_2026_01_06_T23_59_00));

        workpackage.getOwnedTasks().add(task1);
        workpackage.getOwnedTasks().add(task2);
        workpackage.getOwnedTasks().add(task3);
        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());

        service.createDependencyLink(task3, task2, StartOrEnd.END, StartOrEnd.START);
        service.createDependencyLink(task11, task2, StartOrEnd.END, StartOrEnd.START);

        service.deleteDependencyRelatedObject(task1);
        assertThat(workpackage.getOwnedTasks()).hasSize(2);
        assertThat(task2.getDependencies()).hasSize(1);
        assertThat(task2.getStartTime()).isEqualTo(task3.getEndTime().plus(1, ChronoUnit.MINUTES));
    }

    @Test
    public void createWorkpackage() {
        Project project = PepperFactory.eINSTANCE.createProject();
        Workpackage projectWorkpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackageComputationService.updateStartDate(projectWorkpackage, MONDAY_20260105);
        workpackageComputationService.updateEndDate(projectWorkpackage, WEDNESDAY_20260107);
        project.getOwnedWorkpackages().add(projectWorkpackage);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.createWorkpackage(projectWorkpackage);
        assertThat(project.getOwnedWorkpackages()).hasSize(2);
        assertThat(project.getOwnedWorkpackages().get(1).getStartDate()).isEqualTo(WEDNESDAY_20260107);
        assertThat(project.getOwnedWorkpackages().get(1).getEndDate()).isEqualTo(FRIDAY_20260109);
    }

    @Test
    public void editWorkpackage() {
        workpackageComputationService.updateStartDate(workpackage, MONDAY_20260105);
        workpackageComputationService.updateEndDate(workpackage, TUESDAY_20260106);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.editWorkpackage(workpackage, NEW_NAME, NEW_DESCRIPTION, WEDNESDAY_20260107, FRIDAY_20260109, 10, false);
        assertThat(workpackage.getName()).isEqualTo(NEW_NAME);
        assertThat(workpackage.getDescription()).isEqualTo(NEW_DESCRIPTION);
        assertThat(workpackage.getStartDate()).isEqualTo(WEDNESDAY_20260107);
        assertThat(workpackage.getEndDate()).isEqualTo(FRIDAY_20260109);
        assertThat(workpackage.getProgress()).isEqualTo(10);
    }

    @Test
    public void deleteWorkpackage() {
        Project project = PepperFactory.eINSTANCE.createProject();
        Workpackage projectWorkpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackageComputationService.updateStartDate(projectWorkpackage, LocalDate.ofYearDay(2026, 5));
        workpackageComputationService.updateEndDate(projectWorkpackage, LocalDate.ofYearDay(2026, 8));
        project.getOwnedWorkpackages().add(projectWorkpackage);
        assertThat(project.getOwnedWorkpackages()).hasSize(1);

        var service = new PepperMMJavaService(new IFeedbackMessageService.NoOp(), new TaskComputationService(), new WorkpackageComputationService());
        service.deleteWorkpackage(projectWorkpackage);
        assertThat(project.getOwnedWorkpackages()).hasSize(0);
    }
}

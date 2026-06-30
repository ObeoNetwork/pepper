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
 ******************************************************************************/
package pepper.starter.configuration.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pepper.peppermm.DependencyLink;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.Task;
import pepper.peppermm.Workpackage;
import pepper.starter.services.view.PepperMMJavaService;

/**
 * Test used to validate the editing service for all dependency types and object combinations.
 *
 * @author ncouvert
 */
public class EditDependenciesServiceTests {
    private static final ZonedDateTime ZONED_DATE_TIME = LocalDateTime
            .of(2023, 11, 18, 0, 0)
            .atZone(ZoneId.systemDefault());
    private static final String ZONE = ZONED_DATE_TIME.getOffset().toString();

    private static final String DATE2024_12_13_T00_00_00 = "2024-12-13T00:00:00" + ZONE;
    private static final String DATE2024_12_13_T23_59_00 = "2024-12-13T23:59:00" + ZONE;
    private static final String DATE2024_12_14_T00_00_00 = "2024-12-14T00:00:00" + ZONE;
    private static final String DATE2024_12_14_T23_59_00 = "2024-12-14T23:59:00" + ZONE;


    private final Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
    private final PepperMMJavaService service = new PepperMMJavaService(new IFeedbackMessageService.NoOp());
    private final SimpleCrossReferenceProvider simpleCrossReferenceProvider = new SimpleCrossReferenceProvider();

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
    public void editMilestoneToMilestones() {
        Instant datesInstant = Instant.parse(DATE2024_12_13_T00_00_00);

        Task milestone = PepperFactory.eINSTANCE.createTask();
        milestone.setStartTime(datesInstant);
        milestone.setEndTime(datesInstant);

        Task milestoneDependencyStartEnd = PepperFactory.eINSTANCE.createTask();
        milestoneDependencyStartEnd.setStartTime(datesInstant);
        milestoneDependencyStartEnd.setEndTime(datesInstant);

        Task milestoneDependencyStartStart = PepperFactory.eINSTANCE.createTask();
        milestoneDependencyStartStart.setStartTime(datesInstant);
        milestoneDependencyStartStart.setEndTime(datesInstant);

        Task milestoneDependencyEndStart = PepperFactory.eINSTANCE.createTask();
        milestoneDependencyEndStart.setStartTime(datesInstant);
        milestoneDependencyEndStart.setEndTime(datesInstant);

        Task milestoneDependencyEndEnd = PepperFactory.eINSTANCE.createTask();
        milestoneDependencyEndEnd.setStartTime(datesInstant);
        milestoneDependencyEndEnd.setEndTime(datesInstant);

        workpackage.getOwnedTasks().add(milestone);
        workpackage.getOwnedTasks().add(milestoneDependencyStartEnd);
        workpackage.getOwnedTasks().add(milestoneDependencyStartStart);
        workpackage.getOwnedTasks().add(milestoneDependencyEndStart);
        workpackage.getOwnedTasks().add(milestoneDependencyEndEnd);

        DependencyLink dependencyStartEnd = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyStartEnd.setDuration(0);
        dependencyStartEnd.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartEnd.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyStartEnd.setSource(milestone);
        milestoneDependencyStartEnd.getDependencies().add(dependencyStartEnd);

        DependencyLink dependencyStartStart = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyStartStart.setDuration(0);
        dependencyStartStart.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartStart.setSourceKind(StartOrEnd.START);
        dependencyStartStart.setSource(milestone);
        milestoneDependencyStartStart.getDependencies().add(dependencyStartStart);

        DependencyLink dependencyEndEnd = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyEndEnd.setDuration(0);
        dependencyEndEnd.setTargetKind(StartOrEnd.END);
        dependencyEndEnd.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyEndEnd.setSource(milestone);
        milestoneDependencyEndStart.getDependencies().add(dependencyEndEnd);

        DependencyLink dependencyEndStart = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyEndStart.setDuration(0);
        dependencyEndStart.setTargetKind(StartOrEnd.END);
        dependencyEndStart.setSourceKind(StartOrEnd.START);
        dependencyEndStart.setSource(milestone);
        milestoneDependencyEndEnd.getDependencies().add(dependencyEndStart);

        Instant newDatesInstant = Instant.parse(DATE2024_12_14_T00_00_00);

        service.editTask(milestone, null, null, newDatesInstant, newDatesInstant, null, false);
        assertThat(allDependentMilestonesFromMilestoneHaveCorrectDates(milestone));
    }

    @Test
    public void editMilestoneToTasks() {
        Instant datesInstant1 = Instant.parse(DATE2024_12_13_T00_00_00);
        Instant datesInstant2 = Instant.parse(DATE2024_12_13_T23_59_00);

        Task milestone = PepperFactory.eINSTANCE.createTask();
        milestone.setStartTime(datesInstant1);
        milestone.setEndTime(datesInstant1);

        Task taskDependencyStartEnd = PepperFactory.eINSTANCE.createTask();
        taskDependencyStartEnd.setStartTime(datesInstant1);
        taskDependencyStartEnd.setEndTime(datesInstant2);

        Task taskDependencyStartStart = PepperFactory.eINSTANCE.createTask();
        taskDependencyStartStart.setStartTime(datesInstant1);
        taskDependencyStartStart.setEndTime(datesInstant2);

        Task taskDependencyEndStart = PepperFactory.eINSTANCE.createTask();
        taskDependencyEndStart.setStartTime(datesInstant1);
        taskDependencyEndStart.setEndTime(datesInstant2);

        Task taskDependencyEndEnd = PepperFactory.eINSTANCE.createTask();
        taskDependencyEndEnd.setStartTime(datesInstant1);
        taskDependencyEndEnd.setEndTime(datesInstant2);

        workpackage.getOwnedTasks().add(milestone);
        workpackage.getOwnedTasks().add(taskDependencyStartEnd);
        workpackage.getOwnedTasks().add(taskDependencyStartStart);
        workpackage.getOwnedTasks().add(taskDependencyEndStart);
        workpackage.getOwnedTasks().add(taskDependencyEndEnd);

        DependencyLink dependencyStartEnd = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyStartEnd.setDuration(0);
        dependencyStartEnd.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartEnd.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyStartEnd.setSource(milestone);
        taskDependencyStartEnd.getDependencies().add(dependencyStartEnd);

        DependencyLink dependencyStartStart = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyStartStart.setDuration(0);
        dependencyStartStart.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartStart.setSourceKind(StartOrEnd.START);
        dependencyStartStart.setSource(milestone);
        taskDependencyStartStart.getDependencies().add(dependencyStartStart);

        DependencyLink dependencyEndEnd = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyEndEnd.setDuration(0);
        dependencyEndEnd.setTargetKind(StartOrEnd.END);
        dependencyEndEnd.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyEndEnd.setSource(milestone);
        taskDependencyEndStart.getDependencies().add(dependencyEndEnd);

        DependencyLink dependencyEndStart = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyEndStart.setDuration(0);
        dependencyEndStart.setTargetKind(StartOrEnd.END);
        dependencyEndStart.setSourceKind(StartOrEnd.START);
        dependencyEndStart.setSource(milestone);
        taskDependencyEndEnd.getDependencies().add(dependencyEndStart);

        Instant newDatesInstant = Instant.parse(DATE2024_12_14_T00_00_00);

        service.editTask(milestone, null, null, newDatesInstant, newDatesInstant, null, false);
        assertThat(allDependentTasksFromMilestoneHaveCorrectDates(milestone));
    }

    @Test
    public void editTaskToMilestones() {
        Instant datesInstant1 = Instant.parse(DATE2024_12_13_T00_00_00);
        Instant datesInstant2 = Instant.parse(DATE2024_12_13_T23_59_00);

        Task task = PepperFactory.eINSTANCE.createTask();
        task.setStartTime(datesInstant1);
        task.setEndTime(datesInstant2);

        Task taskDependencyStartEnd = PepperFactory.eINSTANCE.createTask();
        taskDependencyStartEnd.setStartTime(datesInstant1);
        taskDependencyStartEnd.setEndTime(datesInstant2);

        Task taskDependencyStartStart = PepperFactory.eINSTANCE.createTask();
        taskDependencyStartStart.setStartTime(datesInstant1);
        taskDependencyStartStart.setEndTime(datesInstant2);

        Task taskDependencyEndStart = PepperFactory.eINSTANCE.createTask();
        taskDependencyEndStart.setStartTime(datesInstant1);
        taskDependencyEndStart.setEndTime(datesInstant2);

        Task taskDependencyEndEnd = PepperFactory.eINSTANCE.createTask();
        taskDependencyEndEnd.setStartTime(datesInstant1);
        taskDependencyEndEnd.setEndTime(datesInstant2);

        workpackage.getOwnedTasks().add(task);
        workpackage.getOwnedTasks().add(taskDependencyStartEnd);
        workpackage.getOwnedTasks().add(taskDependencyStartStart);
        workpackage.getOwnedTasks().add(taskDependencyEndStart);
        workpackage.getOwnedTasks().add(taskDependencyEndEnd);

        DependencyLink dependencyStartEnd = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyStartEnd.setDuration(0);
        dependencyStartEnd.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartEnd.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyStartEnd.setSource(task);
        taskDependencyStartEnd.getDependencies().add(dependencyStartEnd);

        DependencyLink dependencyStartStart = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyStartStart.setDuration(0);
        dependencyStartStart.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartStart.setSourceKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartStart.setSource(task);
        taskDependencyStartStart.getDependencies().add(dependencyStartStart);

        DependencyLink dependencyEndEnd = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyEndEnd.setDuration(0);
        dependencyEndEnd.setTargetKind(StartOrEnd.END);
        dependencyEndEnd.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyEndEnd.setSource(task);
        taskDependencyEndStart.getDependencies().add(dependencyEndEnd);

        DependencyLink dependencyEndStart = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyEndStart.setDuration(0);
        dependencyEndStart.setTargetKind(StartOrEnd.END);
        dependencyEndStart.setSourceKind(StartOrEnd.START);
        dependencyEndStart.setSource(task);
        taskDependencyEndEnd.getDependencies().add(dependencyEndStart);

        Instant newStartInstant = Instant.parse(DATE2024_12_14_T00_00_00);
        Instant newEndInstant = Instant.parse(DATE2024_12_14_T23_59_00);

        service.editTask(task, null, null, newStartInstant, newEndInstant, null, false);
        assertThat(allDependentMilestonesFromTaskHaveCorrectDates(task));
    }

    @Test
    public void editTaskToTasks() {
        Instant datesInstant1 = Instant.parse(DATE2024_12_13_T00_00_00);
        Instant datesInstant2 = Instant.parse(DATE2024_12_13_T23_59_00);

        Task task = PepperFactory.eINSTANCE.createTask();
        task.setStartTime(datesInstant1);
        task.setEndTime(datesInstant2);

        Task milestoneDependencyStartEnd = PepperFactory.eINSTANCE.createTask();
        milestoneDependencyStartEnd.setStartTime(datesInstant1);
        milestoneDependencyStartEnd.setEndTime(datesInstant1);

        Task milestoneDependencyStartStart = PepperFactory.eINSTANCE.createTask();
        milestoneDependencyStartStart.setStartTime(datesInstant1);
        milestoneDependencyStartStart.setEndTime(datesInstant1);

        Task milestoneDependencyEndStart = PepperFactory.eINSTANCE.createTask();
        milestoneDependencyEndStart.setStartTime(datesInstant1);
        milestoneDependencyEndStart.setEndTime(datesInstant1);

        Task milestoneDependencyEndEnd = PepperFactory.eINSTANCE.createTask();
        milestoneDependencyEndEnd.setStartTime(datesInstant1);
        milestoneDependencyEndEnd.setEndTime(datesInstant1);

        workpackage.getOwnedTasks().add(task);
        workpackage.getOwnedTasks().add(milestoneDependencyStartEnd);
        workpackage.getOwnedTasks().add(milestoneDependencyStartStart);
        workpackage.getOwnedTasks().add(milestoneDependencyEndStart);
        workpackage.getOwnedTasks().add(milestoneDependencyEndEnd);

        DependencyLink dependencyStartEnd = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyStartEnd.setDuration(0);
        dependencyStartEnd.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartEnd.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyStartEnd.setSource(task);
        milestoneDependencyStartEnd.getDependencies().add(dependencyStartEnd);

        DependencyLink dependencyStartStart = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyStartStart.setDuration(0);
        dependencyStartStart.setTargetKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartStart.setSourceKind(pepper.peppermm.StartOrEnd.START);
        dependencyStartStart.setSource(task);
        milestoneDependencyStartStart.getDependencies().add(dependencyStartStart);

        DependencyLink dependencyEndEnd = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyEndEnd.setDuration(0);
        dependencyEndEnd.setTargetKind(StartOrEnd.END);
        dependencyEndEnd.setSourceKind(pepper.peppermm.StartOrEnd.END);
        dependencyEndEnd.setSource(task);
        milestoneDependencyEndStart.getDependencies().add(dependencyEndEnd);

        DependencyLink dependencyEndStart = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyEndStart.setDuration(0);
        dependencyEndStart.setTargetKind(StartOrEnd.END);
        dependencyEndStart.setSourceKind(StartOrEnd.START);
        dependencyEndStart.setSource(task);
        milestoneDependencyEndEnd.getDependencies().add(dependencyEndStart);

        Instant newStartInstant = Instant.parse(DATE2024_12_14_T00_00_00);
        Instant newEndInstant = Instant.parse(DATE2024_12_14_T23_59_00);

        service.editTask(task, null, null, newStartInstant, newEndInstant, null, false);
        assertThat(allDependentTasksFromTaskHaveCorrectDates(task));
    }

    private List<Task> getAllDependentTasks(Task task) {
        List<Task> dependentTasks = new ArrayList<>();
        Collection<EStructuralFeature.Setting> sourceInverseReferences = simpleCrossReferenceProvider.getInverseReferences(task);
        for (EStructuralFeature.Setting sourceInverseReference : sourceInverseReferences) {
            if (sourceInverseReference.getEObject() instanceof DependencyLink dependencyLink) {
                if (dependencyLink.eContainer() instanceof Task object) {
                    dependentTasks.add(object);
                }
            }
        }
        return dependentTasks;
    }

    //used in test 1
    private boolean allDependentMilestonesFromMilestoneHaveCorrectDates(Task milestone) {
        boolean result = true;
        for (Task task : getAllDependentTasks(milestone)) {
            if (task.getEndTime() != milestone.getEndTime() || task.getStartTime() != milestone.getStartTime()) {
                result = false;
            }
        }
        return result;
    }

    //used in test 2
    private boolean allDependentTasksFromMilestoneHaveCorrectDates(Task milestone) {
        boolean result = true;
        for (Task task : getAllDependentTasks(milestone)) {
            DependencyLink dependencyLink = task.getDependencies().get(0);
            if (dependencyLink.getTargetKind().equals(StartOrEnd.START)) {
                if (!task.getStartTime().equals(milestone.getEndTime()) || !task.getEndTime().equals(milestone.getEndTime().plus(1, ChronoUnit.DAYS).minus(1, ChronoUnit.MINUTES))) {
                    result = false;
                }
            } else if (dependencyLink.getTargetKind().equals(StartOrEnd.END)) {
                if (!task.getStartTime().equals(milestone.getEndTime().minus(1, ChronoUnit.DAYS)) || !task.getEndTime().equals(milestone.getEndTime().minus(1, ChronoUnit.MINUTES))) {
                    result = false;
                }
            }
        }
        return result;
    }

    //used in test 3
    private boolean allDependentMilestonesFromTaskHaveCorrectDates(Task task) {
        boolean result = true;
        for (Task milestone : getAllDependentTasks(task)) {
            DependencyLink dependencyLink = milestone.getDependencies().get(0);
            if (dependencyLink.getSourceKind().equals(StartOrEnd.START)) {
                if (!milestone.getStartTime().equals(task.getStartTime()) || !milestone.getEndTime().equals(task.getStartTime())) {
                    result = false;
                }
            } else if (dependencyLink.getSourceKind().equals(StartOrEnd.END)) {
                if (!milestone.getStartTime().equals(task.getEndTime().plus(1, ChronoUnit.MINUTES)) || !milestone.getEndTime().equals(task.getEndTime().plus(1, ChronoUnit.MINUTES))) {
                    result = false;
                }
            }
        }
        return result;
    }

    //used in test 4
    private boolean allDependentTasksFromTaskHaveCorrectDates(Task task) {
        boolean result = true;
        for (Task dependentTask : getAllDependentTasks(task)) {
            DependencyLink dependencyLink = dependentTask.getDependencies().get(0);
            if (dependencyLink.getSourceKind().equals(StartOrEnd.START) && dependencyLink.getTargetKind().equals(StartOrEnd.END)) {
                if (!dependentTask.getStartTime().equals(task.getStartTime().minus(1, ChronoUnit.DAYS)) || !dependentTask.getEndTime().equals(task.getStartTime().minus(1, ChronoUnit.MINUTES))) {
                    result = false;
                }
            } else if (dependencyLink.getSourceKind().equals(StartOrEnd.END) && dependencyLink.getTargetKind().equals(StartOrEnd.END)) {
                if (!dependentTask.getStartTime().equals(task.getEndTime().plus(1, ChronoUnit.MINUTES).minus(1, ChronoUnit.DAYS)) || !dependentTask.getEndTime().equals(task.getEndTime())) {
                    result = false;
                }
            } else if (dependencyLink.getSourceKind().equals(StartOrEnd.START) && dependencyLink.getTargetKind().equals(StartOrEnd.START)) {
                if (!dependentTask.getStartTime().equals(task.getStartTime()) || !dependentTask.getEndTime().equals(task.getEndTime())) {
                    result = false;
                }
            } else if (dependencyLink.getSourceKind().equals(StartOrEnd.END) && dependencyLink.getTargetKind().equals(StartOrEnd.START)) {
                if (!dependentTask.getStartTime().equals(task.getEndTime().plus(1, ChronoUnit.MINUTES)) || !dependentTask.getEndTime().equals(task.getEndTime().plus(1, ChronoUnit.MINUTES).plus(1, ChronoUnit.DAYS))) {
                    result = false;
                }
            }
        }
        return result;
    }
}

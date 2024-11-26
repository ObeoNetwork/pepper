/*******************************************************************************
 * Copyright (c) 2024 CEA LIST.
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
package fr.cea.deeplab.projectmanagement.starter.configuration.view;

import static org.assertj.core.api.Assertions.assertThat;

import fr.cea.deeplab.projectmanagement.starter.services.view.ProjectManagementJavaService;
import fr.cea.deeplab.projectmgmt.AbstractTask;
import fr.cea.deeplab.projectmgmt.ProjectmgmtFactory;
import fr.cea.deeplab.projectmgmt.Task;
import fr.cea.deeplab.projectmgmt.Workpackage;

import java.time.Instant;

import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.junit.jupiter.api.Test;

/**
 * Test used to validate the service for the task related views.
 *
 * @author lfasani
 */
public class ProjectManagementJavaServiceTests {

    private static final String NEW_NAME = "newName";
    private static final String NEW_DESCRIPTION = "newDescription";

    @Test
    public void editTask() {
        AbstractTask task = ProjectmgmtFactory.eINSTANCE.createTask();
        var service = new ProjectManagementJavaService(new IFeedbackMessageService.NoOp());
        service.editTask(task, NEW_NAME, NEW_DESCRIPTION, Instant.ofEpochSecond(1704067200), Instant.ofEpochSecond(1704070800), 10);
        assertThat(task.getName()).isEqualTo(NEW_NAME);
        assertThat(task.getDescription()).isEqualTo(NEW_DESCRIPTION);
        assertThat(task.getStartTime().getEpochSecond()).isEqualTo(1704067200);
        assertThat(task.getEndTime().getEpochSecond()).isEqualTo(1704070800);
        assertThat(task.getProgress()).isEqualTo(10);
    }

    @Test
    public void computeTaskDurationDays() {
        Task task = ProjectmgmtFactory.eINSTANCE.createTask();
        task.setStartTime(Instant.ofEpochSecond(1704067200));
        task.setEndTime(Instant.ofEpochSecond(1704157260));
        var service = new ProjectManagementJavaService(new IFeedbackMessageService.NoOp());
        var result = service.computeTaskDurationDays(task);
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("01d01h01m");
    }

    @Test
    public void editCard() {
        AbstractTask card = ProjectmgmtFactory.eINSTANCE.createTask();
        var service = new ProjectManagementJavaService(new IFeedbackMessageService.NoOp());
        service.editCard(card, NEW_NAME, NEW_DESCRIPTION, null);
        assertThat(card.getName()).isEqualTo(NEW_NAME);
        assertThat(card.getDescription()).isEqualTo(NEW_DESCRIPTION);
    }

    @Test
    public void createTask() {
        Task task11 = ProjectmgmtFactory.eINSTANCE.createTask();
        task11.setStartTime(Instant.ofEpochSecond(1704067200));
        task11.setEndTime(Instant.ofEpochSecond(1704157260));

        Task task1 = ProjectmgmtFactory.eINSTANCE.createTask();
        task1.setStartTime(Instant.ofEpochSecond(1704067200));
        task1.setEndTime(Instant.ofEpochSecond(1704157260));
        task1.getSubTasks().add(task11);

        Workpackage workpackage = ProjectmgmtFactory.eINSTANCE.createWorkpackage();
        workpackage.getOwnedTasks().add(task1);
        var service = new ProjectManagementJavaService(new IFeedbackMessageService.NoOp());

        service.createTask(workpackage);
        assertThat(workpackage.getOwnedTasks()).hasSize(2);

        service.createTask(task1);
        assertThat(workpackage.getOwnedTasks()).hasSize(3);
        assertThat(workpackage.getOwnedTasks().get(1).getStartTime()).isEqualTo(Instant.ofEpochSecond(1704157260));
        assertThat(workpackage.getOwnedTasks().get(1).getEndTime()).isEqualTo(Instant.ofEpochSecond(2L * 1704157260 - 1704067200));

        service.createTask(task11);
        assertThat(task1.getSubTasks()).hasSize(2);
        assertThat(task1.getSubTasks().get(1).getStartTime()).isEqualTo(Instant.ofEpochSecond(1704157260));
        assertThat(task1.getSubTasks().get(1).getEndTime()).isEqualTo(Instant.ofEpochSecond(2L * 1704157260 - 1704067200));
    }
}

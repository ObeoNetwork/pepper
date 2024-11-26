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
package fr.cea.deeplab.projectmanagement.starter.services;

import fr.cea.deeplab.projectmgmt.ExternalStakeholder;
import fr.cea.deeplab.projectmgmt.InternalStakeholder;
import fr.cea.deeplab.projectmgmt.KeyResult;
import fr.cea.deeplab.projectmgmt.Objective;
import fr.cea.deeplab.projectmgmt.Organization;
import fr.cea.deeplab.projectmgmt.Person;
import fr.cea.deeplab.projectmgmt.Project;
import fr.cea.deeplab.projectmgmt.ProjectmgmtFactory;
import fr.cea.deeplab.projectmgmt.ResourceFolder;
import fr.cea.deeplab.projectmgmt.TagFolder;
import fr.cea.deeplab.projectmgmt.Task;
import fr.cea.deeplab.projectmgmt.TaskTag;
import fr.cea.deeplab.projectmgmt.Team;
import fr.cea.deeplab.projectmgmt.Workpackage;
import fr.cea.deeplab.projectmgmt.WorkpackageArtefact;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Builder for samples of ProjectManagement.
 *
 * @author lfasani
 */
public class ProjectManagementSampleBuilder {

    private static final String KANBAN = "kanban";
    private static final String REVIEW = "Review";
    private static final String DEVELOPMENT = "Development";
    private static final String CODE_DEVELOPMENT = "Code Development";
    private static final String RELEASE = "Release";
    private static final String SPECIFICATION = "Specification";
    private static final String IDEA = "Idea";
    private static final String DATE_2023_12_10T08_30_00Z = "2023-12-10T08:30:00Z";
    private static final String DATE_2023_12_16T08_30_00Z = "2023-12-16T08:30:00Z";
    private static final String DATE_2023_12_11T08_30_00Z = "2023-12-11T08:30:00Z";
    private static final String DATE_2023_12_12T17_30_00Z = "2023-12-12T17:30:00Z";
    private static final String DATE_2023_12_15T17_30_00Z = "2023-12-15T17:30:00Z";
    private static final String DATE_2023_12_11T17_30_00Z = "2023-12-11T17:30:00Z";
    private static final String DATE_2023_12_13T08_30_00Z = "2023-12-13T08:30:00Z";
    private static final String DATE_2023_12_16T17_30_00Z = "2023-12-16T17:30:00Z";
    private static final String DATE_2023_12_18T08_30_00Z = "2023-12-18T08:30:00Z";

    private static final String MAIN_WORKPACKAGE = "Main workpackage";

    public Organization getSampleContent() {
        Organization organization = ProjectmgmtFactory.eINSTANCE.createOrganization();
        ResourceFolder resourceFolder = ProjectmgmtFactory.eINSTANCE.createResourceFolder();
        resourceFolder.setName("Resources");
        organization.getOwnedResourceFolders().add(resourceFolder);

        Person paul = ProjectmgmtFactory.eINSTANCE.createPerson();
        paul.setName("Paul");
        Person peter = ProjectmgmtFactory.eINSTANCE.createPerson();
        peter.setName("Peter");
        resourceFolder.getOwnedResources().addAll(List.of(paul, peter));

        Team devTeam = ProjectmgmtFactory.eINSTANCE.createTeam();
        devTeam.setName("Development Team");
        resourceFolder.getOwnedResources().add(devTeam);
        devTeam.getMembers().addAll(List.of(paul, peter));

        InternalStakeholder internalStakeholder1 = ProjectmgmtFactory.eINSTANCE.createInternalStakeholder();
        internalStakeholder1.setName("Indus Department");
        InternalStakeholder internalStakeholder2 = ProjectmgmtFactory.eINSTANCE.createInternalStakeholder();
        internalStakeholder2.setName("Dev Department");
        ExternalStakeholder externalStakeholder = ProjectmgmtFactory.eINSTANCE.createExternalStakeholder();
        externalStakeholder.setName("Customer 1");
        ExternalStakeholder externalStakeholder2 = ProjectmgmtFactory.eINSTANCE.createExternalStakeholder();
        externalStakeholder2.setName("Customer 2");
        resourceFolder.getOwnedResources().addAll(List.of(internalStakeholder1, internalStakeholder2, externalStakeholder, externalStakeholder2));

        Project devProject = this.createDevProject(paul, peter);
        Project dailyProject = this.createDailyProject(paul, peter);
        Project okrProject = this.createOKRProject(paul, peter);
        Project kanbanProject = this.createKanbanProject(paul, peter);
        organization.getOwnedProjects().addAll(List.of(devProject, dailyProject, okrProject, kanbanProject));

        return organization;
    }


    private Project createDevProject(Person paul, Person peter) {
        Project devProject = ProjectmgmtFactory.eINSTANCE.createProject();
        devProject.setName("Project Dev");
        Workpackage workpackage = ProjectmgmtFactory.eINSTANCE.createWorkpackage();
        workpackage.setName(MAIN_WORKPACKAGE);
        devProject.getOwnedWorkpackages().add(workpackage);

        Task idea = ProjectmgmtFactory.eINSTANCE.createTask();
        idea.setName(IDEA);
        idea.setDescription("Description of the Idea");
        idea.setStartTime(Instant.parse("2023-12-10T08:30:00Z"));
        idea.setEndTime(Instant.parse("2023-12-11T17:30:00Z"));
        idea.setProgress(50);
        Task spec = ProjectmgmtFactory.eINSTANCE.createTask();
        spec.setName(SPECIFICATION);
        spec.setDescription("Description of the Specification");
        spec.setStartTime(Instant.parse("2023-12-11T08:30:00Z"));
        spec.setEndTime(Instant.parse("2023-12-12T17:30:00Z"));
        spec.setProgress(50);
        spec.getDependencies().add(idea);

        Task development = ProjectmgmtFactory.eINSTANCE.createTask();
        development.setName(DEVELOPMENT);
        development.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        development.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        development.getDependencies().add(spec);
        development.setComputeStartEndDynamically(true);

        Task codeDev = ProjectmgmtFactory.eINSTANCE.createTask();
        codeDev.setName(CODE_DEVELOPMENT);
        codeDev.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        codeDev.setEndTime(Instant.parse(DATE_2023_12_15T17_30_00Z));
        codeDev.getAssignedPersons().add(peter);
        codeDev.setComputeStartEndDynamically(false);
        codeDev.setProgress(40);
        Task frontDev = ProjectmgmtFactory.eINSTANCE.createTask();
        frontDev.setName("Front");
        frontDev.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        frontDev.setEndTime(Instant.parse("2023-12-14T17:30:00Z"));
        frontDev.setProgress(30);
        frontDev.getAssignedPersons().add(peter);
        Task backDev = ProjectmgmtFactory.eINSTANCE.createTask();
        backDev.setName("Back");
        backDev.setStartTime(Instant.parse("2023-12-14T14:00:00Z"));
        backDev.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        backDev.setProgress(40);
        backDev.getAssignedPersons().add(paul);
        codeDev.getSubTasks().addAll(List.of(frontDev, backDev));

        Task review = ProjectmgmtFactory.eINSTANCE.createTask();
        review.setName(REVIEW);
        review.setStartTime(Instant.parse(DATE_2023_12_16T08_30_00Z));
        review.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        development.getSubTasks().addAll(List.of(codeDev, review));
        codeDev.getAssignedPersons().add(paul);

        Task release = ProjectmgmtFactory.eINSTANCE.createTask();
        release.setName(RELEASE);
        release.setStartTime(Instant.parse(DATE_2023_12_18T08_30_00Z));
        release.setEndTime(Instant.parse(DATE_2023_12_18T08_30_00Z));

        workpackage.getOwnedTasks().addAll(List.of(idea, spec, development, release));
        return devProject;
    }

    private Project createDailyProject(Person paul, Person peter) {
        Project dailyProject = ProjectmgmtFactory.eINSTANCE.createProject();
        dailyProject.setName("Daily Project Dev");
        Workpackage workpackage = ProjectmgmtFactory.eINSTANCE.createWorkpackage();
        workpackage.setName(MAIN_WORKPACKAGE);
        dailyProject.getOwnedWorkpackages().add(workpackage);
        TagFolder tagFolder = ProjectmgmtFactory.eINSTANCE.createTagFolder();
        tagFolder.setName("Tags");
        dailyProject.getOwnedTagFolders().add(tagFolder);

        List<TaskTag> dailyTags = this.createDailyTags();
        tagFolder.getOwnedTags().addAll(dailyTags);

        Task idea = ProjectmgmtFactory.eINSTANCE.createTask();
        idea.setName(IDEA);
        idea.setStartTime(Instant.parse(DATE_2023_12_10T08_30_00Z));
        idea.setEndTime(Instant.parse(DATE_2023_12_11T17_30_00Z));
        idea.setProgress(50);
        idea.getTags().add(dailyTags.get(0));
        Task spec = ProjectmgmtFactory.eINSTANCE.createTask();
        spec.setName(SPECIFICATION);
        spec.setStartTime(Instant.parse(DATE_2023_12_11T08_30_00Z));
        spec.setEndTime(Instant.parse(DATE_2023_12_12T17_30_00Z));
        spec.setProgress(50);
        spec.getDependencies().add(idea);
        spec.getTags().add(dailyTags.get(0));

        Task development = ProjectmgmtFactory.eINSTANCE.createTask();
        development.setName(DEVELOPMENT);
        development.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        development.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        development.getDependencies().add(spec);
        development.getTags().add(dailyTags.get(1));

        Task codeDev = ProjectmgmtFactory.eINSTANCE.createTask();
        codeDev.setName(CODE_DEVELOPMENT);
        codeDev.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        codeDev.setEndTime(Instant.parse(DATE_2023_12_15T17_30_00Z));
        codeDev.getAssignedPersons().add(peter);
        codeDev.getTags().add(dailyTags.get(2));

        Task review = ProjectmgmtFactory.eINSTANCE.createTask();
        review.setName(REVIEW);
        review.setStartTime(Instant.parse(DATE_2023_12_16T08_30_00Z));
        review.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        development.getSubTasks().addAll(List.of(codeDev, review));
        codeDev.getAssignedPersons().add(paul);
        review.getTags().add(dailyTags.get(3));

        Task release = ProjectmgmtFactory.eINSTANCE.createTask();
        release.setName(RELEASE);
        release.setStartTime(Instant.parse(DATE_2023_12_18T08_30_00Z));
        release.setEndTime(Instant.parse(DATE_2023_12_18T08_30_00Z));
        release.getTags().add(dailyTags.get(4));


        workpackage.getOwnedTasks().addAll(List.of(idea, spec, development, release));
        return dailyProject;
    }

    private Project createKanbanProject(Person paul, Person peter) {
        Project kanbanProject = ProjectmgmtFactory.eINSTANCE.createProject();
        kanbanProject.setName("Kanban Project Dev");
        Workpackage workpackage = ProjectmgmtFactory.eINSTANCE.createWorkpackage();
        workpackage.setName(MAIN_WORKPACKAGE);
        kanbanProject.getOwnedWorkpackages().add(workpackage);

        List<TaskTag> kanbanTags = this.createKanbanTags();
        TagFolder tagFolder = ProjectmgmtFactory.eINSTANCE.createTagFolder();
        tagFolder.setName("Tags");
        kanbanProject.getOwnedTagFolders().add(tagFolder);
        tagFolder.getOwnedTags().addAll(kanbanTags);

        Task idea = ProjectmgmtFactory.eINSTANCE.createTask();
        idea.setName(IDEA);
        idea.setStartTime(Instant.parse(DATE_2023_12_10T08_30_00Z));
        idea.setEndTime(Instant.parse(DATE_2023_12_11T17_30_00Z));
        idea.setProgress(50);
        //We add it in Done tag
        idea.getTags().add(kanbanTags.get(2));
        Task spec = ProjectmgmtFactory.eINSTANCE.createTask();
        spec.setName(SPECIFICATION);
        spec.setStartTime(Instant.parse(DATE_2023_12_11T08_30_00Z));
        spec.setEndTime(Instant.parse(DATE_2023_12_12T17_30_00Z));
        spec.setProgress(50);
        spec.getDependencies().add(idea);
        //We add it in Done tag
        spec.getTags().add(kanbanTags.get(2));

        Task development = ProjectmgmtFactory.eINSTANCE.createTask();
        development.setName(DEVELOPMENT);
        development.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        development.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        development.getDependencies().add(spec);
        //We add it in Doing tag
        development.getTags().add(kanbanTags.get(1));

        Task codeDev = ProjectmgmtFactory.eINSTANCE.createTask();
        codeDev.setName(CODE_DEVELOPMENT);
        codeDev.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        codeDev.setEndTime(Instant.parse(DATE_2023_12_15T17_30_00Z));
        codeDev.getAssignedPersons().add(peter);
        //We add it in Doing tag
        codeDev.getTags().add(kanbanTags.get(1));

        Task review = ProjectmgmtFactory.eINSTANCE.createTask();
        review.setName(REVIEW);
        review.setStartTime(Instant.parse(DATE_2023_12_16T08_30_00Z));
        review.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        development.getSubTasks().addAll(List.of(codeDev, review));
        codeDev.getAssignedPersons().add(paul);
        //We add it in To Do tag
        review.getTags().add(kanbanTags.get(0));

        Task release = ProjectmgmtFactory.eINSTANCE.createTask();
        release.setName(RELEASE);
        release.setStartTime(Instant.parse(DATE_2023_12_18T08_30_00Z));
        release.setEndTime(Instant.parse(DATE_2023_12_18T08_30_00Z));
        //We add it in To Do tag
        release.getTags().add(kanbanTags.get(0));


        workpackage.getOwnedTasks().addAll(List.of(idea, spec, development, release));
        return kanbanProject;
    }

    private Project createOKRProject(Person paul, Person peter) {
        Project okrProject = ProjectmgmtFactory.eINSTANCE.createProject();
        okrProject.setName("OKR Project Dev");
        Workpackage workpackage = ProjectmgmtFactory.eINSTANCE.createWorkpackage();
        workpackage.setName(MAIN_WORKPACKAGE);
        okrProject.getOwnedWorkpackages().add(workpackage);

        Objective objectiveApplicationRunning = ProjectmgmtFactory.eINSTANCE.createObjective();
        objectiveApplicationRunning.setName("Have the application running");

        KeyResult keyResultDevCompleted = ProjectmgmtFactory.eINSTANCE.createKeyResult();
        keyResultDevCompleted.setName("Dev completed");
        keyResultDevCompleted.setDescription("The development is completed");

        Task idea = ProjectmgmtFactory.eINSTANCE.createTask();
        idea.setName(IDEA);
        idea.setStartTime(Instant.parse(DATE_2023_12_10T08_30_00Z));
        idea.setEndTime(Instant.parse(DATE_2023_12_11T17_30_00Z));
        idea.setProgress(50);
        Task spec = ProjectmgmtFactory.eINSTANCE.createTask();
        spec.setName(SPECIFICATION);
        spec.setStartTime(Instant.parse(DATE_2023_12_11T08_30_00Z));
        spec.setEndTime(Instant.parse(DATE_2023_12_12T17_30_00Z));
        spec.setProgress(50);
        spec.getDependencies().add(idea);

        Task development = ProjectmgmtFactory.eINSTANCE.createTask();
        development.setName(DEVELOPMENT);
        development.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        development.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        development.getDependencies().add(spec);

        Task codeDev = ProjectmgmtFactory.eINSTANCE.createTask();
        codeDev.setName(CODE_DEVELOPMENT);
        codeDev.setStartTime(Instant.parse(DATE_2023_12_13T08_30_00Z));
        codeDev.setEndTime(Instant.parse(DATE_2023_12_15T17_30_00Z));
        codeDev.getAssignedPersons().add(peter);

        Task review = ProjectmgmtFactory.eINSTANCE.createTask();
        review.setName(REVIEW);
        review.setStartTime(Instant.parse(DATE_2023_12_16T08_30_00Z));
        review.setEndTime(Instant.parse(DATE_2023_12_16T17_30_00Z));
        development.getSubTasks().addAll(List.of(codeDev, review));
        codeDev.getAssignedPersons().add(paul);

        keyResultDevCompleted.getSubTasks().addAll(List.of(idea, spec, development));

        KeyResult keyResultTestsOK = ProjectmgmtFactory.eINSTANCE.createKeyResult();
        keyResultTestsOK.setName("Tests passed");
        keyResultTestsOK.setDescription("The tests are all passed");

        Task manualsTest = ProjectmgmtFactory.eINSTANCE.createTask();
        manualsTest.setName("Manual Test Campaign");
        Task automaticTests = ProjectmgmtFactory.eINSTANCE.createTask();
        manualsTest.setName("Automatic Test Checks");

        keyResultTestsOK.getSubTasks().addAll(List.of(manualsTest, automaticTests));

        objectiveApplicationRunning.getOwnedKeyResults().addAll(List.of(keyResultDevCompleted, keyResultTestsOK));
        okrProject.getOwnedObjectives().add(objectiveApplicationRunning);

        return okrProject;
    }

    private List<TaskTag> createDailyTags() {
        List<TaskTag> tags = new ArrayList<>();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            TaskTag tag = ProjectmgmtFactory.eINSTANCE.createTaskTag();
            tag.setPrefix("daily");
            tag.setSuffix(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
            tags.add(tag);
        }
        return tags;
    }

    private List<TaskTag> createKanbanTags() {
        List<TaskTag> tags = new ArrayList<>();
        TaskTag tag = ProjectmgmtFactory.eINSTANCE.createTaskTag();
        tag.setPrefix(KANBAN);
        tag.setSuffix("To Do");
        tags.add(tag);

        tag = ProjectmgmtFactory.eINSTANCE.createTaskTag();
        tag.setPrefix(KANBAN);
        tag.setSuffix("Doing");
        tags.add(tag);

        tag = ProjectmgmtFactory.eINSTANCE.createTaskTag();
        tag.setPrefix(KANBAN);
        tag.setSuffix("Done");
        tags.add(tag);

        return tags;
    }

    public Organization getEmptySampleContent() {
        Organization organization = ProjectmgmtFactory.eINSTANCE.createOrganization();
        ResourceFolder resourceFolder = ProjectmgmtFactory.eINSTANCE.createResourceFolder();
        resourceFolder.setName("Resources");
        organization.getOwnedResourceFolders().add(resourceFolder);

        Person person = ProjectmgmtFactory.eINSTANCE.createPerson();
        person.setName("Peter");
        InternalStakeholder internalStakeholder = ProjectmgmtFactory.eINSTANCE.createInternalStakeholder();
        internalStakeholder.setName("Department 1");
        ExternalStakeholder externalStakeholder = ProjectmgmtFactory.eINSTANCE.createExternalStakeholder();
        externalStakeholder.setName("Client 1");
        resourceFolder.getOwnedResources().addAll(List.of(person, internalStakeholder, externalStakeholder));

        Project project = ProjectmgmtFactory.eINSTANCE.createProject();
        project.setName("My project");
        Workpackage workpackage = ProjectmgmtFactory.eINSTANCE.createWorkpackage();
        workpackage.setName(MAIN_WORKPACKAGE);
        WorkpackageArtefact workpackageArtefact = ProjectmgmtFactory.eINSTANCE.createWorkpackageArtefact();
        workpackageArtefact.setName("New Workpackage Artefact");
        workpackage.getOutputs().add(workpackageArtefact);
        project.getOwnedWorkpackages().add(workpackage);


        organization.getOwnedProjects().add(project);

        return organization;
    }
}

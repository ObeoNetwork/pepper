/*******************************************************************************
 * Copyright (c) 2023, 2026 Obeo.
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
package pepper.mm.builder.generated.pepper;

/**
 * Builder for TaskMilestoneBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class TaskMilestoneBuilder {

    /**
     * Create instance pepper.peppermm.TaskMilestone.
     * @generated
     */
    private pepper.peppermm.TaskMilestone taskMilestone = pepper.peppermm.PepperFactory.eINSTANCE.createTaskMilestone();

    /**
     * Return instance pepper.peppermm.TaskMilestone.
     * @generated
     */
    protected pepper.peppermm.TaskMilestone getTaskMilestone() {
        return this.taskMilestone;
    }

    /**
     * Return instance pepper.peppermm.TaskMilestone.
     * @generated
     */
    public pepper.peppermm.TaskMilestone build() {
        return this.getTaskMilestone();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public TaskMilestoneBuilder name(java.lang.String value) {
        this.getTaskMilestone().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public TaskMilestoneBuilder description(java.lang.String value) {
        this.getTaskMilestone().setDescription(value);
        return this;
    }
    /**
     * Setter for AssignedPersons.
     *
     * @generated
     */
    public TaskMilestoneBuilder assignedPersons(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getTaskMilestone().getAssignedPersons().add(value);
        }
        return this;
    }

    /**
     * Setter for AssignedTeams.
     *
     * @generated
     */
    public TaskMilestoneBuilder assignedTeams(pepper.peppermm.Team ... values) {
        for (pepper.peppermm.Team value : values) {
            this.getTaskMilestone().getAssignedTeams().add(value);
        }
        return this;
    }

    /**
     * Setter for StartTime.
     *
     * @generated
     */
    public TaskMilestoneBuilder startTime(java.time.Instant value) {
        this.getTaskMilestone().setStartTime(value);
        return this;
    }
    /**
     * Setter for EndTime.
     *
     * @generated
     */
    public TaskMilestoneBuilder endTime(java.time.Instant value) {
        this.getTaskMilestone().setEndTime(value);
        return this;
    }
    /**
     * Setter for Progress.
     *
     * @generated
     */
    public TaskMilestoneBuilder progress(java.lang.Integer value) {
        this.getTaskMilestone().setProgress(value);
        return this;
    }
    /**
     * Setter for ComputeStartEndDynamically.
     *
     * @generated
     */
    public TaskMilestoneBuilder computeStartEndDynamically(java.lang.Boolean value) {
        this.getTaskMilestone().setComputeStartEndDynamically(value);
        return this;
    }
    /**
     * Setter for Tags.
     *
     * @generated
     */
    public TaskMilestoneBuilder tags(pepper.peppermm.TaskTag ... values) {
        for (pepper.peppermm.TaskTag value : values) {
            this.getTaskMilestone().getTags().add(value);
        }
        return this;
    }

    /**
     * Setter for SubTasks.
     *
     * @generated
     */
    public TaskMilestoneBuilder subTasks(pepper.peppermm.Task ... values) {
        for (pepper.peppermm.Task value : values) {
            this.getTaskMilestone().getSubTasks().add(value);
        }
        return this;
    }

    /**
     * Setter for CalculationOption.
     *
     * @generated
     */
    public TaskMilestoneBuilder calculationOption(pepper.peppermm.TaskTimeBoundariesConstraint value) {
        this.getTaskMilestone().setCalculationOption(value);
        return this;
    }
    /**
     * Setter for Duration.
     *
     * @generated
     */
    public TaskMilestoneBuilder duration(java.lang.Integer value) {
        this.getTaskMilestone().setDuration(value);
        return this;
    }
    /**
     * Setter for Effort.
     *
     * @generated
     */
    public TaskMilestoneBuilder effort(java.lang.Integer value) {
        this.getTaskMilestone().setEffort(value);
        return this;
    }
    /**
     * Setter for Dependencies.
     *
     * @generated
     */
    public TaskMilestoneBuilder dependencies(pepper.peppermm.DependencyLink ... values) {
        for (pepper.peppermm.DependencyLink value : values) {
            this.getTaskMilestone().getDependencies().add(value);
        }
        return this;
    }


}


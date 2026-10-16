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
 * Builder for TaskBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class TaskBuilder {

    /**
     * Create instance pepper.peppermm.Task.
     * @generated
     */
    private pepper.peppermm.Task task = pepper.peppermm.PepperFactory.eINSTANCE.createTask();

    /**
     * Return instance pepper.peppermm.Task.
     * @generated
     */
    protected pepper.peppermm.Task getTask() {
        return this.task;
    }

    /**
     * Return instance pepper.peppermm.Task.
     * @generated
     */
    public pepper.peppermm.Task build() {
        return this.getTask();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public TaskBuilder name(java.lang.String value) {
        this.getTask().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public TaskBuilder description(java.lang.String value) {
        this.getTask().setDescription(value);
        return this;
    }
    /**
     * Setter for AssignedPersons.
     *
     * @generated
     */
    public TaskBuilder assignedPersons(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getTask().getAssignedPersons().add(value);
        }
        return this;
    }

    /**
     * Setter for AssignedTeams.
     *
     * @generated
     */
    public TaskBuilder assignedTeams(pepper.peppermm.Team ... values) {
        for (pepper.peppermm.Team value : values) {
            this.getTask().getAssignedTeams().add(value);
        }
        return this;
    }

    /**
     * Setter for StartTime.
     *
     * @generated
     */
    public TaskBuilder startTime(java.time.Instant value) {
        this.getTask().setStartTime(value);
        return this;
    }
    /**
     * Setter for EndTime.
     *
     * @generated
     */
    public TaskBuilder endTime(java.time.Instant value) {
        this.getTask().setEndTime(value);
        return this;
    }
    /**
     * Setter for Progress.
     *
     * @generated
     */
    public TaskBuilder progress(java.lang.Integer value) {
        this.getTask().setProgress(value);
        return this;
    }
    /**
     * Setter for ComputeStartEndDynamically.
     *
     * @generated
     */
    public TaskBuilder computeStartEndDynamically(java.lang.Boolean value) {
        this.getTask().setComputeStartEndDynamically(value);
        return this;
    }
    /**
     * Setter for Tags.
     *
     * @generated
     */
    public TaskBuilder tags(pepper.peppermm.TaskTag ... values) {
        for (pepper.peppermm.TaskTag value : values) {
            this.getTask().getTags().add(value);
        }
        return this;
    }

    /**
     * Setter for SubTasks.
     *
     * @generated
     */
    public TaskBuilder subTasks(pepper.peppermm.Task ... values) {
        for (pepper.peppermm.Task value : values) {
            this.getTask().getSubTasks().add(value);
        }
        return this;
    }

    /**
     * Setter for CalculationOption.
     *
     * @generated
     */
    public TaskBuilder calculationOption(pepper.peppermm.TaskTimeBoundariesConstraint value) {
        this.getTask().setCalculationOption(value);
        return this;
    }
    /**
     * Setter for Duration.
     *
     * @generated
     */
    public TaskBuilder duration(java.lang.Integer value) {
        this.getTask().setDuration(value);
        return this;
    }
    /**
     * Setter for Effort.
     *
     * @generated
     */
    public TaskBuilder effort(java.lang.Integer value) {
        this.getTask().setEffort(value);
        return this;
    }
    /**
     * Setter for Dependencies.
     *
     * @generated
     */
    public TaskBuilder dependencies(pepper.peppermm.DependencyLink ... values) {
        for (pepper.peppermm.DependencyLink value : values) {
            this.getTask().getDependencies().add(value);
        }
        return this;
    }


}


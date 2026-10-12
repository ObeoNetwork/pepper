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
 * Builder for pepper.peppermm.AbstractTask.
 *
 * @author BuilderGenerator
 * @generated
 */
public abstract class AbstractTaskBuilder {

    /**
     * Builder for pepper.peppermm.AbstractTask.
     * @generated
     */
    protected abstract pepper.peppermm.AbstractTask getAbstractTask();

    /**
     * Setter for Name.
     *
     * @generated
     */
    public AbstractTaskBuilder name(java.lang.String value) {
        this.getAbstractTask().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public AbstractTaskBuilder description(java.lang.String value) {
        this.getAbstractTask().setDescription(value);
        return this;
    }
    /**
     * Setter for AssignedPersons.
     *
     * @generated
     */
    public AbstractTaskBuilder assignedPersons(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getAbstractTask().getAssignedPersons().add(value);
        }
        return this;
    }

    /**
     * Setter for AssignedTeams.
     *
     * @generated
     */
    public AbstractTaskBuilder assignedTeams(pepper.peppermm.Team ... values) {
        for (pepper.peppermm.Team value : values) {
            this.getAbstractTask().getAssignedTeams().add(value);
        }
        return this;
    }

    /**
     * Setter for StartTime.
     *
     * @generated
     */
    public AbstractTaskBuilder startTime(java.time.Instant value) {
        this.getAbstractTask().setStartTime(value);
        return this;
    }
    /**
     * Setter for EndTime.
     *
     * @generated
     */
    public AbstractTaskBuilder endTime(java.time.Instant value) {
        this.getAbstractTask().setEndTime(value);
        return this;
    }
    /**
     * Setter for Progress.
     *
     * @generated
     */
    public AbstractTaskBuilder progress(java.lang.Integer value) {
        this.getAbstractTask().setProgress(value);
        return this;
    }
    /**
     * Setter for ComputeStartEndDynamically.
     *
     * @generated
     */
    public AbstractTaskBuilder computeStartEndDynamically(java.lang.Boolean value) {
        this.getAbstractTask().setComputeStartEndDynamically(value);
        return this;
    }
    /**
     * Setter for Tags.
     *
     * @generated
     */
    public AbstractTaskBuilder tags(pepper.peppermm.TaskTag ... values) {
        for (pepper.peppermm.TaskTag value : values) {
            this.getAbstractTask().getTags().add(value);
        }
        return this;
    }

    /**
     * Setter for SubTasks.
     *
     * @generated
     */
    public AbstractTaskBuilder subTasks(pepper.peppermm.Task ... values) {
        for (pepper.peppermm.Task value : values) {
            this.getAbstractTask().getSubTasks().add(value);
        }
        return this;
    }

    /**
     * Setter for CalculationOption.
     *
     * @generated
     */
    public AbstractTaskBuilder calculationOption(pepper.peppermm.TaskTimeBoundariesConstraint value) {
        this.getAbstractTask().setCalculationOption(value);
        return this;
    }
    /**
     * Setter for Duration.
     *
     * @generated
     */
    public AbstractTaskBuilder duration(java.lang.Integer value) {
        this.getAbstractTask().setDuration(value);
        return this;
    }
    /**
     * Setter for Effort.
     *
     * @generated
     */
    public AbstractTaskBuilder effort(java.lang.Integer value) {
        this.getAbstractTask().setEffort(value);
        return this;
    }

}


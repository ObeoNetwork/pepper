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
 * Builder for ObjectiveBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class ObjectiveBuilder {

    /**
     * Create instance pepper.peppermm.Objective.
     * @generated
     */
    private pepper.peppermm.Objective objective = pepper.peppermm.PepperFactory.eINSTANCE.createObjective();

    /**
     * Return instance pepper.peppermm.Objective.
     * @generated
     */
    protected pepper.peppermm.Objective getObjective() {
        return this.objective;
    }

    /**
     * Return instance pepper.peppermm.Objective.
     * @generated
     */
    public pepper.peppermm.Objective build() {
        return this.getObjective();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public ObjectiveBuilder name(java.lang.String value) {
        this.getObjective().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public ObjectiveBuilder description(java.lang.String value) {
        this.getObjective().setDescription(value);
        return this;
    }
    /**
     * Setter for AssignedPersons.
     *
     * @generated
     */
    public ObjectiveBuilder assignedPersons(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getObjective().getAssignedPersons().add(value);
        }
        return this;
    }

    /**
     * Setter for AssignedTeams.
     *
     * @generated
     */
    public ObjectiveBuilder assignedTeams(pepper.peppermm.Team ... values) {
        for (pepper.peppermm.Team value : values) {
            this.getObjective().getAssignedTeams().add(value);
        }
        return this;
    }

    /**
     * Setter for StartTime.
     *
     * @generated
     */
    public ObjectiveBuilder startTime(java.time.Instant value) {
        this.getObjective().setStartTime(value);
        return this;
    }
    /**
     * Setter for EndTime.
     *
     * @generated
     */
    public ObjectiveBuilder endTime(java.time.Instant value) {
        this.getObjective().setEndTime(value);
        return this;
    }
    /**
     * Setter for Progress.
     *
     * @generated
     */
    public ObjectiveBuilder progress(java.lang.Integer value) {
        this.getObjective().setProgress(value);
        return this;
    }
    /**
     * Setter for ComputeStartEndDynamically.
     *
     * @generated
     */
    public ObjectiveBuilder computeStartEndDynamically(java.lang.Boolean value) {
        this.getObjective().setComputeStartEndDynamically(value);
        return this;
    }
    /**
     * Setter for Tags.
     *
     * @generated
     */
    public ObjectiveBuilder tags(pepper.peppermm.TaskTag ... values) {
        for (pepper.peppermm.TaskTag value : values) {
            this.getObjective().getTags().add(value);
        }
        return this;
    }

    /**
     * Setter for SubTasks.
     *
     * @generated
     */
    public ObjectiveBuilder subTasks(pepper.peppermm.Task ... values) {
        for (pepper.peppermm.Task value : values) {
            this.getObjective().getSubTasks().add(value);
        }
        return this;
    }

    /**
     * Setter for CalculationOption.
     *
     * @generated
     */
    public ObjectiveBuilder calculationOption(pepper.peppermm.TaskTimeBoundariesConstraint value) {
        this.getObjective().setCalculationOption(value);
        return this;
    }
    /**
     * Setter for Duration.
     *
     * @generated
     */
    public ObjectiveBuilder duration(java.lang.Integer value) {
        this.getObjective().setDuration(value);
        return this;
    }
    /**
     * Setter for Effort.
     *
     * @generated
     */
    public ObjectiveBuilder effort(java.lang.Integer value) {
        this.getObjective().setEffort(value);
        return this;
    }
    /**
     * Setter for OwnedKeyResults.
     *
     * @generated
     */
    public ObjectiveBuilder ownedKeyResults(pepper.peppermm.KeyResult ... values) {
        for (pepper.peppermm.KeyResult value : values) {
            this.getObjective().getOwnedKeyResults().add(value);
        }
        return this;
    }


}


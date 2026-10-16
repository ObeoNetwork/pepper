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
 * Builder for WorkpackageBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class WorkpackageBuilder {

    /**
     * Create instance pepper.peppermm.Workpackage.
     * @generated
     */
    private pepper.peppermm.Workpackage workpackage = pepper.peppermm.PepperFactory.eINSTANCE.createWorkpackage();

    /**
     * Return instance pepper.peppermm.Workpackage.
     * @generated
     */
    protected pepper.peppermm.Workpackage getWorkpackage() {
        return this.workpackage;
    }

    /**
     * Return instance pepper.peppermm.Workpackage.
     * @generated
     */
    public pepper.peppermm.Workpackage build() {
        return this.getWorkpackage();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public WorkpackageBuilder name(java.lang.String value) {
        this.getWorkpackage().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public WorkpackageBuilder description(java.lang.String value) {
        this.getWorkpackage().setDescription(value);
        return this;
    }
    /**
     * Setter for AssignedPersons.
     *
     * @generated
     */
    public WorkpackageBuilder assignedPersons(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getWorkpackage().getAssignedPersons().add(value);
        }
        return this;
    }

    /**
     * Setter for AssignedTeams.
     *
     * @generated
     */
    public WorkpackageBuilder assignedTeams(pepper.peppermm.Team ... values) {
        for (pepper.peppermm.Team value : values) {
            this.getWorkpackage().getAssignedTeams().add(value);
        }
        return this;
    }

    /**
     * Setter for Dependencies.
     *
     * @generated
     */
    public WorkpackageBuilder dependencies(pepper.peppermm.DependencyLink ... values) {
        for (pepper.peppermm.DependencyLink value : values) {
            this.getWorkpackage().getDependencies().add(value);
        }
        return this;
    }

    /**
     * Setter for StartDate.
     *
     * @generated
     */
    public WorkpackageBuilder startDate(java.time.LocalDate value) {
        this.getWorkpackage().setStartDate(value);
        return this;
    }
    /**
     * Setter for EndDate.
     *
     * @generated
     */
    public WorkpackageBuilder endDate(java.time.LocalDate value) {
        this.getWorkpackage().setEndDate(value);
        return this;
    }
    /**
     * Setter for Leader.
     *
     * @generated
     */
    public WorkpackageBuilder leader(pepper.peppermm.Person value) {
        this.getWorkpackage().setLeader(value);
        return this;
    }
    /**
     * Setter for Effort.
     *
     * @generated
     */
    public WorkpackageBuilder effort(java.lang.Integer value) {
        this.getWorkpackage().setEffort(value);
        return this;
    }
    /**
     * Setter for Outputs.
     *
     * @generated
     */
    public WorkpackageBuilder outputs(pepper.peppermm.WorkpackageArtefact ... values) {
        for (pepper.peppermm.WorkpackageArtefact value : values) {
            this.getWorkpackage().getOutputs().add(value);
        }
        return this;
    }

    /**
     * Setter for OwnedTasks.
     *
     * @generated
     */
    public WorkpackageBuilder ownedTasks(pepper.peppermm.Task ... values) {
        for (pepper.peppermm.Task value : values) {
            this.getWorkpackage().getOwnedTasks().add(value);
        }
        return this;
    }

    /**
     * Setter for OwnedObjectives.
     *
     * @generated
     */
    public WorkpackageBuilder ownedObjectives(pepper.peppermm.Objective ... values) {
        for (pepper.peppermm.Objective value : values) {
            this.getWorkpackage().getOwnedObjectives().add(value);
        }
        return this;
    }

    /**
     * Setter for Progress.
     *
     * @generated
     */
    public WorkpackageBuilder progress(java.lang.Integer value) {
        this.getWorkpackage().setProgress(value);
        return this;
    }
    /**
     * Setter for CalculationOption.
     *
     * @generated
     */
    public WorkpackageBuilder calculationOption(pepper.peppermm.TaskTimeBoundariesConstraint value) {
        this.getWorkpackage().setCalculationOption(value);
        return this;
    }
    /**
     * Setter for Duration.
     *
     * @generated
     */
    public WorkpackageBuilder duration(java.lang.Integer value) {
        this.getWorkpackage().setDuration(value);
        return this;
    }

}


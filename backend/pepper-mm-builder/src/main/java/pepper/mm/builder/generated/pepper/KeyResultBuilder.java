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
 * Builder for KeyResultBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class KeyResultBuilder {

    /**
     * Create instance pepper.peppermm.KeyResult.
     * @generated
     */
    private pepper.peppermm.KeyResult keyResult = pepper.peppermm.PepperFactory.eINSTANCE.createKeyResult();

    /**
     * Return instance pepper.peppermm.KeyResult.
     * @generated
     */
    protected pepper.peppermm.KeyResult getKeyResult() {
        return this.keyResult;
    }

    /**
     * Return instance pepper.peppermm.KeyResult.
     * @generated
     */
    public pepper.peppermm.KeyResult build() {
        return this.getKeyResult();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public KeyResultBuilder name(java.lang.String value) {
        this.getKeyResult().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public KeyResultBuilder description(java.lang.String value) {
        this.getKeyResult().setDescription(value);
        return this;
    }
    /**
     * Setter for AssignedPersons.
     *
     * @generated
     */
    public KeyResultBuilder assignedPersons(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getKeyResult().getAssignedPersons().add(value);
        }
        return this;
    }

    /**
     * Setter for AssignedTeams.
     *
     * @generated
     */
    public KeyResultBuilder assignedTeams(pepper.peppermm.Team ... values) {
        for (pepper.peppermm.Team value : values) {
            this.getKeyResult().getAssignedTeams().add(value);
        }
        return this;
    }

    /**
     * Setter for StartTime.
     *
     * @generated
     */
    public KeyResultBuilder startTime(java.time.Instant value) {
        this.getKeyResult().setStartTime(value);
        return this;
    }
    /**
     * Setter for EndTime.
     *
     * @generated
     */
    public KeyResultBuilder endTime(java.time.Instant value) {
        this.getKeyResult().setEndTime(value);
        return this;
    }
    /**
     * Setter for Progress.
     *
     * @generated
     */
    public KeyResultBuilder progress(java.lang.Integer value) {
        this.getKeyResult().setProgress(value);
        return this;
    }
    /**
     * Setter for ComputeStartEndDynamically.
     *
     * @generated
     */
    public KeyResultBuilder computeStartEndDynamically(java.lang.Boolean value) {
        this.getKeyResult().setComputeStartEndDynamically(value);
        return this;
    }
    /**
     * Setter for Tags.
     *
     * @generated
     */
    public KeyResultBuilder tags(pepper.peppermm.TaskTag ... values) {
        for (pepper.peppermm.TaskTag value : values) {
            this.getKeyResult().getTags().add(value);
        }
        return this;
    }

    /**
     * Setter for SubTasks.
     *
     * @generated
     */
    public KeyResultBuilder subTasks(pepper.peppermm.Task ... values) {
        for (pepper.peppermm.Task value : values) {
            this.getKeyResult().getSubTasks().add(value);
        }
        return this;
    }

    /**
     * Setter for CalculationOption.
     *
     * @generated
     */
    public KeyResultBuilder calculationOption(pepper.peppermm.TaskTimeBoundariesConstraint value) {
        this.getKeyResult().setCalculationOption(value);
        return this;
    }
    /**
     * Setter for Duration.
     *
     * @generated
     */
    public KeyResultBuilder duration(java.lang.Integer value) {
        this.getKeyResult().setDuration(value);
        return this;
    }
    /**
     * Setter for Effort.
     *
     * @generated
     */
    public KeyResultBuilder effort(java.lang.Integer value) {
        this.getKeyResult().setEffort(value);
        return this;
    }

}


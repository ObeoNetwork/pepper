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
 * Builder for WorkpackageArtefactBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class WorkpackageArtefactBuilder {

    /**
     * Create instance pepper.peppermm.WorkpackageArtefact.
     * @generated
     */
    private pepper.peppermm.WorkpackageArtefact workpackageArtefact = pepper.peppermm.PepperFactory.eINSTANCE.createWorkpackageArtefact();

    /**
     * Return instance pepper.peppermm.WorkpackageArtefact.
     * @generated
     */
    protected pepper.peppermm.WorkpackageArtefact getWorkpackageArtefact() {
        return this.workpackageArtefact;
    }

    /**
     * Return instance pepper.peppermm.WorkpackageArtefact.
     * @generated
     */
    public pepper.peppermm.WorkpackageArtefact build() {
        return this.getWorkpackageArtefact();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder name(java.lang.String value) {
        this.getWorkpackageArtefact().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder description(java.lang.String value) {
        this.getWorkpackageArtefact().setDescription(value);
        return this;
    }
    /**
     * Setter for Nature.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder nature(pepper.peppermm.WorkpackageArtefactNature value) {
        this.getWorkpackageArtefact().setNature(value);
        return this;
    }
    /**
     * Setter for PlannedDeadline.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder plannedDeadline(java.time.LocalDate value) {
        this.getWorkpackageArtefact().setPlannedDeadline(value);
        return this;
    }
    /**
     * Setter for EffectiveDeadLine.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder effectiveDeadLine(java.time.LocalDate value) {
        this.getWorkpackageArtefact().setEffectiveDeadLine(value);
        return this;
    }
    /**
     * Setter for IsInvoiceTrigger.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder isInvoiceTrigger(java.lang.Boolean value) {
        this.getWorkpackageArtefact().setIsInvoiceTrigger(value);
        return this;
    }
    /**
     * Setter for InvoiceAmount.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder invoiceAmount(java.lang.Integer value) {
        this.getWorkpackageArtefact().setInvoiceAmount(value);
        return this;
    }
    /**
     * Setter for Responsible.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder responsible(pepper.peppermm.Person value) {
        this.getWorkpackageArtefact().setResponsible(value);
        return this;
    }
    /**
     * Setter for Version.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder version(java.lang.String value) {
        this.getWorkpackageArtefact().setVersion(value);
        return this;
    }
    /**
     * Setter for IsObsolete.
     *
     * @generated
     */
    public WorkpackageArtefactBuilder isObsolete(java.lang.Boolean value) {
        this.getWorkpackageArtefact().setIsObsolete(value);
        return this;
    }

}


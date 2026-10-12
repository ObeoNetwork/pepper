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
 * Builder for ExternalStakeholderBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class ExternalStakeholderBuilder {

    /**
     * Create instance pepper.peppermm.ExternalStakeholder.
     * @generated
     */
    private pepper.peppermm.ExternalStakeholder externalStakeholder = pepper.peppermm.PepperFactory.eINSTANCE.createExternalStakeholder();

    /**
     * Return instance pepper.peppermm.ExternalStakeholder.
     * @generated
     */
    protected pepper.peppermm.ExternalStakeholder getExternalStakeholder() {
        return this.externalStakeholder;
    }

    /**
     * Return instance pepper.peppermm.ExternalStakeholder.
     * @generated
     */
    public pepper.peppermm.ExternalStakeholder build() {
        return this.getExternalStakeholder();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public ExternalStakeholderBuilder name(java.lang.String value) {
        this.getExternalStakeholder().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public ExternalStakeholderBuilder description(java.lang.String value) {
        this.getExternalStakeholder().setDescription(value);
        return this;
    }
    /**
     * Setter for UnavailabilityPeriods.
     *
     * @generated
     */
    public ExternalStakeholderBuilder unavailabilityPeriods(pepper.peppermm.UnavailabilityPeriod ... values) {
        for (pepper.peppermm.UnavailabilityPeriod value : values) {
            this.getExternalStakeholder().getUnavailabilityPeriods().add(value);
        }
        return this;
    }

    /**
     * Setter for Goals.
     *
     * @generated
     */
    public ExternalStakeholderBuilder goals(java.lang.String ... values) {
        for (java.lang.String value : values) {
            this.getExternalStakeholder().getGoals().add(value);
        }
        return this;
    }


}


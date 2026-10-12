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
 * Builder for UnavailabilityPeriodBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class UnavailabilityPeriodBuilder {

    /**
     * Create instance pepper.peppermm.UnavailabilityPeriod.
     * @generated
     */
    private pepper.peppermm.UnavailabilityPeriod unavailabilityPeriod = pepper.peppermm.PepperFactory.eINSTANCE.createUnavailabilityPeriod();

    /**
     * Return instance pepper.peppermm.UnavailabilityPeriod.
     * @generated
     */
    protected pepper.peppermm.UnavailabilityPeriod getUnavailabilityPeriod() {
        return this.unavailabilityPeriod;
    }

    /**
     * Return instance pepper.peppermm.UnavailabilityPeriod.
     * @generated
     */
    public pepper.peppermm.UnavailabilityPeriod build() {
        return this.getUnavailabilityPeriod();
    }

    /**
     * Setter for StartDate.
     *
     * @generated
     */
    public UnavailabilityPeriodBuilder startDate(java.time.LocalDate value) {
        this.getUnavailabilityPeriod().setStartDate(value);
        return this;
    }
    /**
     * Setter for EndDate.
     *
     * @generated
     */
    public UnavailabilityPeriodBuilder endDate(java.time.LocalDate value) {
        this.getUnavailabilityPeriod().setEndDate(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public UnavailabilityPeriodBuilder description(java.lang.String value) {
        this.getUnavailabilityPeriod().setDescription(value);
        return this;
    }

}


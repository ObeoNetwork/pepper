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
 * Builder for InternalStakeholderBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class InternalStakeholderBuilder {

    /**
     * Create instance pepper.peppermm.InternalStakeholder.
     * @generated
     */
    private pepper.peppermm.InternalStakeholder internalStakeholder = pepper.peppermm.PepperFactory.eINSTANCE.createInternalStakeholder();

    /**
     * Return instance pepper.peppermm.InternalStakeholder.
     * @generated
     */
    protected pepper.peppermm.InternalStakeholder getInternalStakeholder() {
        return this.internalStakeholder;
    }

    /**
     * Return instance pepper.peppermm.InternalStakeholder.
     * @generated
     */
    public pepper.peppermm.InternalStakeholder build() {
        return this.getInternalStakeholder();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public InternalStakeholderBuilder name(java.lang.String value) {
        this.getInternalStakeholder().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public InternalStakeholderBuilder description(java.lang.String value) {
        this.getInternalStakeholder().setDescription(value);
        return this;
    }
    /**
     * Setter for UnavailabilityPeriods.
     *
     * @generated
     */
    public InternalStakeholderBuilder unavailabilityPeriods(pepper.peppermm.UnavailabilityPeriod ... values) {
        for (pepper.peppermm.UnavailabilityPeriod value : values) {
            this.getInternalStakeholder().getUnavailabilityPeriods().add(value);
        }
        return this;
    }


}


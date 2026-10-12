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
 * Builder for pepper.peppermm.Resource.
 *
 * @author BuilderGenerator
 * @generated
 */
public abstract class ResourceBuilder {

    /**
     * Builder for pepper.peppermm.Resource.
     * @generated
     */
    protected abstract pepper.peppermm.Resource getResource();

    /**
     * Setter for Name.
     *
     * @generated
     */
    public ResourceBuilder name(java.lang.String value) {
        this.getResource().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public ResourceBuilder description(java.lang.String value) {
        this.getResource().setDescription(value);
        return this;
    }
    /**
     * Setter for UnavailabilityPeriods.
     *
     * @generated
     */
    public ResourceBuilder unavailabilityPeriods(pepper.peppermm.UnavailabilityPeriod ... values) {
        for (pepper.peppermm.UnavailabilityPeriod value : values) {
            this.getResource().getUnavailabilityPeriods().add(value);
        }
        return this;
    }


}


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
 * Builder for PersonBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class PersonBuilder {

    /**
     * Create instance pepper.peppermm.Person.
     * @generated
     */
    private pepper.peppermm.Person person = pepper.peppermm.PepperFactory.eINSTANCE.createPerson();

    /**
     * Return instance pepper.peppermm.Person.
     * @generated
     */
    protected pepper.peppermm.Person getPerson() {
        return this.person;
    }

    /**
     * Return instance pepper.peppermm.Person.
     * @generated
     */
    public pepper.peppermm.Person build() {
        return this.getPerson();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public PersonBuilder name(java.lang.String value) {
        this.getPerson().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public PersonBuilder description(java.lang.String value) {
        this.getPerson().setDescription(value);
        return this;
    }
    /**
     * Setter for UnavailabilityPeriods.
     *
     * @generated
     */
    public PersonBuilder unavailabilityPeriods(pepper.peppermm.UnavailabilityPeriod ... values) {
        for (pepper.peppermm.UnavailabilityPeriod value : values) {
            this.getPerson().getUnavailabilityPeriods().add(value);
        }
        return this;
    }

    /**
     * Setter for Alias.
     *
     * @generated
     */
    public PersonBuilder alias(java.lang.String value) {
        this.getPerson().setAlias(value);
        return this;
    }
    /**
     * Setter for Biography.
     *
     * @generated
     */
    public PersonBuilder biography(java.lang.String value) {
        this.getPerson().setBiography(value);
        return this;
    }
    /**
     * Setter for ImageUrl.
     *
     * @generated
     */
    public PersonBuilder imageUrl(java.lang.String value) {
        this.getPerson().setImageUrl(value);
        return this;
    }

}


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
 * Builder for TeamBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class TeamBuilder {

    /**
     * Create instance pepper.peppermm.Team.
     * @generated
     */
    private pepper.peppermm.Team team = pepper.peppermm.PepperFactory.eINSTANCE.createTeam();

    /**
     * Return instance pepper.peppermm.Team.
     * @generated
     */
    protected pepper.peppermm.Team getTeam() {
        return this.team;
    }

    /**
     * Return instance pepper.peppermm.Team.
     * @generated
     */
    public pepper.peppermm.Team build() {
        return this.getTeam();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public TeamBuilder name(java.lang.String value) {
        this.getTeam().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public TeamBuilder description(java.lang.String value) {
        this.getTeam().setDescription(value);
        return this;
    }
    /**
     * Setter for UnavailabilityPeriods.
     *
     * @generated
     */
    public TeamBuilder unavailabilityPeriods(pepper.peppermm.UnavailabilityPeriod ... values) {
        for (pepper.peppermm.UnavailabilityPeriod value : values) {
            this.getTeam().getUnavailabilityPeriods().add(value);
        }
        return this;
    }

    /**
     * Setter for Members.
     *
     * @generated
     */
    public TeamBuilder members(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getTeam().getMembers().add(value);
        }
        return this;
    }


}


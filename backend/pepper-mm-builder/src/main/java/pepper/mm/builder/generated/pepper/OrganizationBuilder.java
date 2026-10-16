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
 * Builder for OrganizationBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class OrganizationBuilder {

    /**
     * Create instance pepper.peppermm.Organization.
     * @generated
     */
    private pepper.peppermm.Organization organization = pepper.peppermm.PepperFactory.eINSTANCE.createOrganization();

    /**
     * Return instance pepper.peppermm.Organization.
     * @generated
     */
    protected pepper.peppermm.Organization getOrganization() {
        return this.organization;
    }

    /**
     * Return instance pepper.peppermm.Organization.
     * @generated
     */
    public pepper.peppermm.Organization build() {
        return this.getOrganization();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public OrganizationBuilder name(java.lang.String value) {
        this.getOrganization().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public OrganizationBuilder description(java.lang.String value) {
        this.getOrganization().setDescription(value);
        return this;
    }
    /**
     * Setter for OwnedProjects.
     *
     * @generated
     */
    public OrganizationBuilder ownedProjects(pepper.peppermm.Project ... values) {
        for (pepper.peppermm.Project value : values) {
            this.getOrganization().getOwnedProjects().add(value);
        }
        return this;
    }

    /**
     * Setter for OwnedResourceFolders.
     *
     * @generated
     */
    public OrganizationBuilder ownedResourceFolders(pepper.peppermm.ResourceFolder ... values) {
        for (pepper.peppermm.ResourceFolder value : values) {
            this.getOrganization().getOwnedResourceFolders().add(value);
        }
        return this;
    }


}


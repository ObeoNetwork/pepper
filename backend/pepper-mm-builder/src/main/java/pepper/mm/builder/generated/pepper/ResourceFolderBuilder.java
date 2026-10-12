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
 * Builder for ResourceFolderBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class ResourceFolderBuilder {

    /**
     * Create instance pepper.peppermm.ResourceFolder.
     * @generated
     */
    private pepper.peppermm.ResourceFolder resourceFolder = pepper.peppermm.PepperFactory.eINSTANCE.createResourceFolder();

    /**
     * Return instance pepper.peppermm.ResourceFolder.
     * @generated
     */
    protected pepper.peppermm.ResourceFolder getResourceFolder() {
        return this.resourceFolder;
    }

    /**
     * Return instance pepper.peppermm.ResourceFolder.
     * @generated
     */
    public pepper.peppermm.ResourceFolder build() {
        return this.getResourceFolder();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public ResourceFolderBuilder name(java.lang.String value) {
        this.getResourceFolder().setName(value);
        return this;
    }
    /**
     * Setter for OwnedResources.
     *
     * @generated
     */
    public ResourceFolderBuilder ownedResources(pepper.peppermm.Resource ... values) {
        for (pepper.peppermm.Resource value : values) {
            this.getResourceFolder().getOwnedResources().add(value);
        }
        return this;
    }

    /**
     * Setter for SubFolders.
     *
     * @generated
     */
    public ResourceFolderBuilder subFolders(pepper.peppermm.ResourceFolder ... values) {
        for (pepper.peppermm.ResourceFolder value : values) {
            this.getResourceFolder().getSubFolders().add(value);
        }
        return this;
    }


}


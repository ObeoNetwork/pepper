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
 * Builder for TagFolderBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class TagFolderBuilder {

    /**
     * Create instance pepper.peppermm.TagFolder.
     * @generated
     */
    private pepper.peppermm.TagFolder tagFolder = pepper.peppermm.PepperFactory.eINSTANCE.createTagFolder();

    /**
     * Return instance pepper.peppermm.TagFolder.
     * @generated
     */
    protected pepper.peppermm.TagFolder getTagFolder() {
        return this.tagFolder;
    }

    /**
     * Return instance pepper.peppermm.TagFolder.
     * @generated
     */
    public pepper.peppermm.TagFolder build() {
        return this.getTagFolder();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public TagFolderBuilder name(java.lang.String value) {
        this.getTagFolder().setName(value);
        return this;
    }
    /**
     * Setter for OwnedTags.
     *
     * @generated
     */
    public TagFolderBuilder ownedTags(pepper.peppermm.TaskTag ... values) {
        for (pepper.peppermm.TaskTag value : values) {
            this.getTagFolder().getOwnedTags().add(value);
        }
        return this;
    }

    /**
     * Setter for SubFolders.
     *
     * @generated
     */
    public TagFolderBuilder subFolders(pepper.peppermm.TagFolder ... values) {
        for (pepper.peppermm.TagFolder value : values) {
            this.getTagFolder().getSubFolders().add(value);
        }
        return this;
    }


}


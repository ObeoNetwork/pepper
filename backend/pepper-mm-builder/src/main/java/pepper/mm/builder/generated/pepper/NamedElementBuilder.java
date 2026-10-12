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
 * Builder for pepper.peppermm.NamedElement.
 *
 * @author BuilderGenerator
 * @generated
 */
public abstract class NamedElementBuilder {

    /**
     * Builder for pepper.peppermm.NamedElement.
     * @generated
     */
    protected abstract pepper.peppermm.NamedElement getNamedElement();

    /**
     * Setter for Name.
     *
     * @generated
     */
    public NamedElementBuilder name(java.lang.String value) {
        this.getNamedElement().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public NamedElementBuilder description(java.lang.String value) {
        this.getNamedElement().setDescription(value);
        return this;
    }

}


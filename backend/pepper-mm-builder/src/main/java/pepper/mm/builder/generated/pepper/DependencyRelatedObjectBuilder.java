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
 * Builder for pepper.peppermm.DependencyRelatedObject.
 *
 * @author BuilderGenerator
 * @generated
 */
public abstract class DependencyRelatedObjectBuilder {

    /**
     * Builder for pepper.peppermm.DependencyRelatedObject.
     * @generated
     */
    protected abstract pepper.peppermm.DependencyRelatedObject getDependencyRelatedObject();

    /**
     * Setter for Dependencies.
     *
     * @generated
     */
    public DependencyRelatedObjectBuilder dependencies(pepper.peppermm.DependencyLink ... values) {
        for (pepper.peppermm.DependencyLink value : values) {
            this.getDependencyRelatedObject().getDependencies().add(value);
        }
        return this;
    }


}


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
 * Builder for DependencyLinkBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class DependencyLinkBuilder {

    /**
     * Create instance pepper.peppermm.DependencyLink.
     * @generated
     */
    private pepper.peppermm.DependencyLink dependencyLink = pepper.peppermm.PepperFactory.eINSTANCE.createDependencyLink();

    /**
     * Return instance pepper.peppermm.DependencyLink.
     * @generated
     */
    protected pepper.peppermm.DependencyLink getDependencyLink() {
        return this.dependencyLink;
    }

    /**
     * Return instance pepper.peppermm.DependencyLink.
     * @generated
     */
    public pepper.peppermm.DependencyLink build() {
        return this.getDependencyLink();
    }

    /**
     * Setter for TargetKind.
     *
     * @generated
     */
    public DependencyLinkBuilder targetKind(pepper.peppermm.StartOrEnd value) {
        this.getDependencyLink().setTargetKind(value);
        return this;
    }
    /**
     * Setter for SourceKind.
     *
     * @generated
     */
    public DependencyLinkBuilder sourceKind(pepper.peppermm.StartOrEnd value) {
        this.getDependencyLink().setSourceKind(value);
        return this;
    }
    /**
     * Setter for Source.
     *
     * @generated
     */
    public DependencyLinkBuilder source(pepper.peppermm.DependencyRelatedObject value) {
        this.getDependencyLink().setSource(value);
        return this;
    }
    /**
     * Setter for Delay.
     *
     * @generated
     */
    public DependencyLinkBuilder delay(java.lang.Integer value) {
        this.getDependencyLink().setDelay(value);
        return this;
    }

}


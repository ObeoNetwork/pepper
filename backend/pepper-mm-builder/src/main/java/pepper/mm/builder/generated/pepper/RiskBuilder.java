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
 * Builder for RiskBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class RiskBuilder {

    /**
     * Create instance pepper.peppermm.Risk.
     * @generated
     */
    private pepper.peppermm.Risk risk = pepper.peppermm.PepperFactory.eINSTANCE.createRisk();

    /**
     * Return instance pepper.peppermm.Risk.
     * @generated
     */
    protected pepper.peppermm.Risk getRisk() {
        return this.risk;
    }

    /**
     * Return instance pepper.peppermm.Risk.
     * @generated
     */
    public pepper.peppermm.Risk build() {
        return this.getRisk();
    }

    /**
     * Setter for Kind.
     *
     * @generated
     */
    public RiskBuilder kind(pepper.peppermm.RiskKind value) {
        this.getRisk().setKind(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public RiskBuilder description(java.lang.String value) {
        this.getRisk().setDescription(value);
        return this;
    }
    /**
     * Setter for Criticity.
     *
     * @generated
     */
    public RiskBuilder criticity(java.lang.Integer value) {
        this.getRisk().setCriticity(value);
        return this;
    }
    /**
     * Setter for Action.
     *
     * @generated
     */
    public RiskBuilder action(java.lang.String value) {
        this.getRisk().setAction(value);
        return this;
    }
    /**
     * Setter for Responsible.
     *
     * @generated
     */
    public RiskBuilder responsible(pepper.peppermm.Person value) {
        this.getRisk().setResponsible(value);
        return this;
    }
    /**
     * Setter for OperationDate.
     *
     * @generated
     */
    public RiskBuilder operationDate(java.time.LocalDate value) {
        this.getRisk().setOperationDate(value);
        return this;
    }
    /**
     * Setter for State.
     *
     * @generated
     */
    public RiskBuilder state(pepper.peppermm.RiskState value) {
        this.getRisk().setState(value);
        return this;
    }
    /**
     * Setter for Workpackages.
     *
     * @generated
     */
    public RiskBuilder workpackages(pepper.peppermm.Workpackage ... values) {
        for (pepper.peppermm.Workpackage value : values) {
            this.getRisk().getWorkpackages().add(value);
        }
        return this;
    }


}


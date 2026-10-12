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
 * Builder for pepper.peppermm.AssignableObject.
 *
 * @author BuilderGenerator
 * @generated
 */
public abstract class AssignableObjectBuilder {

    /**
     * Builder for pepper.peppermm.AssignableObject.
     * @generated
     */
    protected abstract pepper.peppermm.AssignableObject getAssignableObject();

    /**
     * Setter for Name.
     *
     * @generated
     */
    public AssignableObjectBuilder name(java.lang.String value) {
        this.getAssignableObject().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public AssignableObjectBuilder description(java.lang.String value) {
        this.getAssignableObject().setDescription(value);
        return this;
    }
    /**
     * Setter for AssignedPersons.
     *
     * @generated
     */
    public AssignableObjectBuilder assignedPersons(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getAssignableObject().getAssignedPersons().add(value);
        }
        return this;
    }

    /**
     * Setter for AssignedTeams.
     *
     * @generated
     */
    public AssignableObjectBuilder assignedTeams(pepper.peppermm.Team ... values) {
        for (pepper.peppermm.Team value : values) {
            this.getAssignableObject().getAssignedTeams().add(value);
        }
        return this;
    }


}


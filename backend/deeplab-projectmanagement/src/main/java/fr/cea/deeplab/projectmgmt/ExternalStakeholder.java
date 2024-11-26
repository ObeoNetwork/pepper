/**
 * Copyright (c) 2024 CEA LIST.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.cea.deeplab.projectmgmt;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>External Stakeholder</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.ExternalStakeholder#getGoals <em>Goals</em>}</li>
 * </ul>
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getExternalStakeholder()
 * @model
 * @generated
 */
public interface ExternalStakeholder extends Resource {
    /**
     * Returns the value of the '<em><b>Goals</b></em>' attribute list. The list contents are of type
     * {@link java.lang.String}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Goals</em>' attribute list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getExternalStakeholder_Goals()
     * @model
     * @generated
     */
    EList<String> getGoals();

} // ExternalStakeholder

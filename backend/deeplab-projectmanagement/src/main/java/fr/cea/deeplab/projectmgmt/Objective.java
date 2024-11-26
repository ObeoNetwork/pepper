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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Objective</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.Objective#getOwnedKeyResults <em>Owned Key Results</em>}</li>
 * </ul>
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getObjective()
 * @model
 * @generated
 */
public interface Objective extends AbstractTask {
    /**
     * Returns the value of the '<em><b>Owned Key Results</b></em>' containment reference list. The list contents are of
     * type {@link fr.cea.deeplab.projectmgmt.KeyResult}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Key Results</em>' containment reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getObjective_OwnedKeyResults()
     * @model containment="true"
     * @generated
     */
    EList<KeyResult> getOwnedKeyResults();

} // Objective

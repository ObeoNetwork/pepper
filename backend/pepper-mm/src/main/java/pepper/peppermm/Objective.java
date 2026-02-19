/*******************************************************************************
 * Copyright (c) 2024, 2026 CEA LIST.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 ******************************************************************************/
package pepper.peppermm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Objective</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.Objective#getOwnedKeyResults <em>Owned Key Results</em>}</li>
 * </ul>
 *
 * @see pepper.peppermm.PepperPackage#getObjective()
 * @model
 * @generated
 */
public interface Objective extends AbstractTask {
    /**
     * Returns the value of the '<em><b>Owned Key Results</b></em>' containment reference list. The list contents are of
     * type {@link pepper.peppermm.KeyResult}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Key Results</em>' containment reference list.
     * @see pepper.peppermm.PepperPackage#getObjective_OwnedKeyResults()
     * @model containment="true"
     * @generated
     */
    EList<KeyResult> getOwnedKeyResults();

} // Objective

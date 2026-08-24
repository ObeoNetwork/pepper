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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Resource</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pepper.peppermm.Resource#getUnavailabilityPeriods <em>Unavailability Periods</em>}</li>
 * </ul>
 *
 * @see pepper.peppermm.PepperPackage#getResource()
 * @model abstract="true"
 * @generated
 */
public interface Resource extends NamedElement {
    /**
	 * Returns the value of the '<em><b>Unavailability Periods</b></em>' containment reference list.
	 * The list contents are of type {@link pepper.peppermm.UnavailabilityPeriod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unavailability Periods</em>' containment reference list.
	 * @see pepper.peppermm.PepperPackage#getResource_UnavailabilityPeriods()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnavailabilityPeriod> getUnavailabilityPeriods();

} // Resource

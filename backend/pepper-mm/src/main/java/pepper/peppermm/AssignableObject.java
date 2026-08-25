/*******************************************************************************
 * Copyright (c) 2026 Obeo.
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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignable Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pepper.peppermm.AssignableObject#getAssignedPersons <em>Assigned Persons</em>}</li>
 *   <li>{@link pepper.peppermm.AssignableObject#getAssignedTeams <em>Assigned Teams</em>}</li>
 * </ul>
 *
 * @see pepper.peppermm.PepperPackage#getAssignableObject()
 * @model abstract="true"
 * @generated
 */
public interface AssignableObject extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Assigned Persons</b></em>' reference list.
	 * The list contents are of type {@link pepper.peppermm.Person}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Persons</em>' reference list.
	 * @see pepper.peppermm.PepperPackage#getAssignableObject_AssignedPersons()
	 * @model
	 * @generated
	 */
	EList<Person> getAssignedPersons();

	/**
	 * Returns the value of the '<em><b>Assigned Teams</b></em>' reference list.
	 * The list contents are of type {@link pepper.peppermm.Team}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Teams</em>' reference list.
	 * @see pepper.peppermm.PepperPackage#getAssignableObject_AssignedTeams()
	 * @model
	 * @generated
	 */
	EList<Team> getAssignedTeams();

} // AssignableObject

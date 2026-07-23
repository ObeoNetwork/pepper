/**
 * Copyright (c) 2024, 2026 CEA LIST and Others.
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
package pepper.peppermm;

import java.time.LocalDate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unavailability Period</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link pepper.peppermm.UnavailabilityPeriod#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link pepper.peppermm.UnavailabilityPeriod#getEndDate <em>End Date</em>}</li>
 *   <li>{@link pepper.peppermm.UnavailabilityPeriod#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see pepper.peppermm.PepperPackage#getUnavailabilityPeriod()
 * @model
 * @generated
 */
public interface UnavailabilityPeriod extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #setStartDate(LocalDate)
	 * @see pepper.peppermm.PepperPackage#getUnavailabilityPeriod_StartDate()
	 * @model dataType="pepper.peppermm.Date"
	 * @generated
	 */
	LocalDate getStartDate();

	/**
	 * Sets the value of the '{@link pepper.peppermm.UnavailabilityPeriod#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(LocalDate value);

	/**
	 * Returns the value of the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Date</em>' attribute.
	 * @see #setEndDate(LocalDate)
	 * @see pepper.peppermm.PepperPackage#getUnavailabilityPeriod_EndDate()
	 * @model dataType="pepper.peppermm.Date"
	 * @generated
	 */
	LocalDate getEndDate();

	/**
	 * Sets the value of the '{@link pepper.peppermm.UnavailabilityPeriod#getEndDate <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Date</em>' attribute.
	 * @see #getEndDate()
	 * @generated
	 */
	void setEndDate(LocalDate value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see pepper.peppermm.PepperPackage#getUnavailabilityPeriod_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link pepper.peppermm.UnavailabilityPeriod#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // UnavailabilityPeriod

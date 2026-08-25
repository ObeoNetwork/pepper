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
package pepper.peppermm.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pepper.peppermm.AssignableObject;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Team;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignable Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pepper.peppermm.impl.AssignableObjectImpl#getAssignedPersons <em>Assigned Persons</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AssignableObjectImpl#getAssignedTeams <em>Assigned Teams</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AssignableObjectImpl extends NamedElementImpl implements AssignableObject {
	/**
	 * The cached value of the '{@link #getAssignedPersons() <em>Assigned Persons</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedPersons()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> assignedPersons;

	/**
	 * The cached value of the '{@link #getAssignedTeams() <em>Assigned Teams</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedTeams()
	 * @generated
	 * @ordered
	 */
	protected EList<Team> assignedTeams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignableObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PepperPackage.Literals.ASSIGNABLE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Person> getAssignedPersons() {
		if (assignedPersons == null) {
			assignedPersons = new EObjectResolvingEList<Person>(Person.class, this, PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_PERSONS);
		}
		return assignedPersons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Team> getAssignedTeams() {
		if (assignedTeams == null) {
			assignedTeams = new EObjectResolvingEList<Team>(Team.class, this, PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_TEAMS);
		}
		return assignedTeams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_PERSONS:
				return this.getAssignedPersons();
			case PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_TEAMS:
				return this.getAssignedTeams();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_PERSONS:
                this.getAssignedPersons().clear();
                this.getAssignedPersons().addAll((Collection<? extends Person>)newValue);
				return;
			case PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_TEAMS:
                this.getAssignedTeams().clear();
                this.getAssignedTeams().addAll((Collection<? extends Team>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_PERSONS:
                this.getAssignedPersons().clear();
				return;
			case PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_TEAMS:
                this.getAssignedTeams().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_PERSONS:
				return assignedPersons != null && !assignedPersons.isEmpty();
			case PepperPackage.ASSIGNABLE_OBJECT__ASSIGNED_TEAMS:
				return assignedTeams != null && !assignedTeams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AssignableObjectImpl

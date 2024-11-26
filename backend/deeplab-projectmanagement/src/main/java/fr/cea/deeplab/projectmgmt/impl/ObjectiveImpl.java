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
package fr.cea.deeplab.projectmgmt.impl;

import fr.cea.deeplab.projectmgmt.KeyResult;
import fr.cea.deeplab.projectmgmt.Objective;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Objective</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ObjectiveImpl#getOwnedKeyResults <em>Owned Key Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectiveImpl extends AbstractTaskImpl implements Objective {
    /**
     * The cached value of the '{@link #getOwnedKeyResults() <em>Owned Key Results</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwnedKeyResults()
     * @generated
     * @ordered
     */
    protected EList<KeyResult> ownedKeyResults;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ObjectiveImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProjectmgmtPackage.Literals.OBJECTIVE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<KeyResult> getOwnedKeyResults() {
        if (this.ownedKeyResults == null) {
            this.ownedKeyResults = new EObjectContainmentEList<>(KeyResult.class, this, ProjectmgmtPackage.OBJECTIVE__OWNED_KEY_RESULTS);
        }
        return this.ownedKeyResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProjectmgmtPackage.OBJECTIVE__OWNED_KEY_RESULTS:
                return ((InternalEList<?>) this.getOwnedKeyResults()).basicRemove(otherEnd, msgs);
            default:
                return super.eInverseRemove(otherEnd, featureID, msgs);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProjectmgmtPackage.OBJECTIVE__OWNED_KEY_RESULTS:
                return this.getOwnedKeyResults();
            default:
                return super.eGet(featureID, resolve, coreType);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ProjectmgmtPackage.OBJECTIVE__OWNED_KEY_RESULTS:
                this.getOwnedKeyResults().clear();
                this.getOwnedKeyResults().addAll((Collection<? extends KeyResult>) newValue);
                return;
            default:
                super.eSet(featureID, newValue);
                return;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ProjectmgmtPackage.OBJECTIVE__OWNED_KEY_RESULTS:
                this.getOwnedKeyResults().clear();
                return;
            default:
                super.eUnset(featureID);
                return;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ProjectmgmtPackage.OBJECTIVE__OWNED_KEY_RESULTS:
                return this.ownedKeyResults != null && !this.ownedKeyResults.isEmpty();
            default:
                return super.eIsSet(featureID);
        }
    }

} // ObjectiveImpl

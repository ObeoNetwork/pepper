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
package pepper.peppermm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pepper.peppermm.Organization;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Project;
import pepper.peppermm.ResourceFolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Organization</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.impl.OrganizationImpl#getName <em>Name</em>}</li>
 * <li>{@link pepper.peppermm.impl.OrganizationImpl#getOwnedProjects <em>Owned Projects</em>}</li>
 * <li>{@link pepper.peppermm.impl.OrganizationImpl#getOwnedResourceFolders <em>Owned Resource Folders</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrganizationImpl extends MinimalEObjectImpl.Container implements Organization {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getOwnedProjects() <em>Owned Projects</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOwnedProjects()
     * @generated
     * @ordered
     */
    protected EList<Project> ownedProjects;

    /**
     * The cached value of the '{@link #getOwnedResourceFolders() <em>Owned Resource Folders</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOwnedResourceFolders()
     * @generated
     * @ordered
     */
    protected EList<ResourceFolder> ownedResourceFolders;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OrganizationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PepperPackage.Literals.ORGANIZATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ORGANIZATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Project> getOwnedProjects() {
        if (ownedProjects == null) {
            ownedProjects = new EObjectContainmentEList<Project>(Project.class, this, PepperPackage.ORGANIZATION__OWNED_PROJECTS);
        }
        return ownedProjects;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ResourceFolder> getOwnedResourceFolders() {
        if (ownedResourceFolders == null) {
            ownedResourceFolders = new EObjectContainmentEList<ResourceFolder>(ResourceFolder.class, this, PepperPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS);
        }
        return ownedResourceFolders;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PepperPackage.ORGANIZATION__OWNED_PROJECTS:
                return ((InternalEList<?>) getOwnedProjects()).basicRemove(otherEnd, msgs);
            case PepperPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                return ((InternalEList<?>) getOwnedResourceFolders()).basicRemove(otherEnd, msgs);
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
            case PepperPackage.ORGANIZATION__NAME:
                return getName();
            case PepperPackage.ORGANIZATION__OWNED_PROJECTS:
                return getOwnedProjects();
            case PepperPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                return getOwnedResourceFolders();
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
            case PepperPackage.ORGANIZATION__NAME:
                setName((String) newValue);
                return;
            case PepperPackage.ORGANIZATION__OWNED_PROJECTS:
                getOwnedProjects().clear();
                getOwnedProjects().addAll((Collection<? extends Project>) newValue);
                return;
            case PepperPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                getOwnedResourceFolders().clear();
                getOwnedResourceFolders().addAll((Collection<? extends ResourceFolder>) newValue);
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
            case PepperPackage.ORGANIZATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PepperPackage.ORGANIZATION__OWNED_PROJECTS:
                getOwnedProjects().clear();
                return;
            case PepperPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                getOwnedResourceFolders().clear();
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
            case PepperPackage.ORGANIZATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PepperPackage.ORGANIZATION__OWNED_PROJECTS:
                return ownedProjects != null && !ownedProjects.isEmpty();
            case PepperPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                return ownedResourceFolders != null && !ownedResourceFolders.isEmpty();
            default:
                return super.eIsSet(featureID);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} // OrganizationImpl

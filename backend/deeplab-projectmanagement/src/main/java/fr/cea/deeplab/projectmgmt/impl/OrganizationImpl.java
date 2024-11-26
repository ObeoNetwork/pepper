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

import fr.cea.deeplab.projectmgmt.Organization;
import fr.cea.deeplab.projectmgmt.Project;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;
import fr.cea.deeplab.projectmgmt.ResourceFolder;

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

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Organization</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.OrganizationImpl#getName <em>Name</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.OrganizationImpl#getOwnedProjects <em>Owned Projects</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.OrganizationImpl#getOwnedResourceFolders <em>Owned Resource
 * Folders</em>}</li>
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
        return ProjectmgmtPackage.Literals.ORGANIZATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.ORGANIZATION__NAME, oldName, this.name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Project> getOwnedProjects() {
        if (this.ownedProjects == null) {
            this.ownedProjects = new EObjectContainmentEList<>(Project.class, this, ProjectmgmtPackage.ORGANIZATION__OWNED_PROJECTS);
        }
        return this.ownedProjects;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ResourceFolder> getOwnedResourceFolders() {
        if (this.ownedResourceFolders == null) {
            this.ownedResourceFolders = new EObjectContainmentEList<>(ResourceFolder.class, this, ProjectmgmtPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS);
        }
        return this.ownedResourceFolders;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProjectmgmtPackage.ORGANIZATION__OWNED_PROJECTS:
                return ((InternalEList<?>) this.getOwnedProjects()).basicRemove(otherEnd, msgs);
            case ProjectmgmtPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                return ((InternalEList<?>) this.getOwnedResourceFolders()).basicRemove(otherEnd, msgs);
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
            case ProjectmgmtPackage.ORGANIZATION__NAME:
                return this.getName();
            case ProjectmgmtPackage.ORGANIZATION__OWNED_PROJECTS:
                return this.getOwnedProjects();
            case ProjectmgmtPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                return this.getOwnedResourceFolders();
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
            case ProjectmgmtPackage.ORGANIZATION__NAME:
                this.setName((String) newValue);
                return;
            case ProjectmgmtPackage.ORGANIZATION__OWNED_PROJECTS:
                this.getOwnedProjects().clear();
                this.getOwnedProjects().addAll((Collection<? extends Project>) newValue);
                return;
            case ProjectmgmtPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                this.getOwnedResourceFolders().clear();
                this.getOwnedResourceFolders().addAll((Collection<? extends ResourceFolder>) newValue);
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
            case ProjectmgmtPackage.ORGANIZATION__NAME:
                this.setName(NAME_EDEFAULT);
                return;
            case ProjectmgmtPackage.ORGANIZATION__OWNED_PROJECTS:
                this.getOwnedProjects().clear();
                return;
            case ProjectmgmtPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                this.getOwnedResourceFolders().clear();
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
            case ProjectmgmtPackage.ORGANIZATION__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
            case ProjectmgmtPackage.ORGANIZATION__OWNED_PROJECTS:
                return this.ownedProjects != null && !this.ownedProjects.isEmpty();
            case ProjectmgmtPackage.ORGANIZATION__OWNED_RESOURCE_FOLDERS:
                return this.ownedResourceFolders != null && !this.ownedResourceFolders.isEmpty();
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
        if (this.eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(this.name);
        result.append(')');
        return result.toString();
    }

} // OrganizationImpl

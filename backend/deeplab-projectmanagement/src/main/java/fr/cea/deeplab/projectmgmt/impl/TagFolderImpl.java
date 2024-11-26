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

import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;
import fr.cea.deeplab.projectmgmt.TagFolder;
import fr.cea.deeplab.projectmgmt.TaskTag;

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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tag Folder</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.TagFolderImpl#getName <em>Name</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.TagFolderImpl#getOwnedTags <em>Owned Tags</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.TagFolderImpl#getSubFolders <em>Sub Folders</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TagFolderImpl extends MinimalEObjectImpl.Container implements TagFolder {
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
     * The cached value of the '{@link #getOwnedTags() <em>Owned Tags</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwnedTags()
     * @generated
     * @ordered
     */
    protected EList<TaskTag> ownedTags;

    /**
     * The cached value of the '{@link #getSubFolders() <em>Sub Folders</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSubFolders()
     * @generated
     * @ordered
     */
    protected EList<TagFolder> subFolders;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected TagFolderImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProjectmgmtPackage.Literals.TAG_FOLDER;
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
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.TAG_FOLDER__NAME, oldName, this.name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<TaskTag> getOwnedTags() {
        if (this.ownedTags == null) {
            this.ownedTags = new EObjectContainmentEList<>(TaskTag.class, this, ProjectmgmtPackage.TAG_FOLDER__OWNED_TAGS);
        }
        return this.ownedTags;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<TagFolder> getSubFolders() {
        if (this.subFolders == null) {
            this.subFolders = new EObjectContainmentEList<>(TagFolder.class, this, ProjectmgmtPackage.TAG_FOLDER__SUB_FOLDERS);
        }
        return this.subFolders;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProjectmgmtPackage.TAG_FOLDER__OWNED_TAGS:
                return ((InternalEList<?>) this.getOwnedTags()).basicRemove(otherEnd, msgs);
            case ProjectmgmtPackage.TAG_FOLDER__SUB_FOLDERS:
                return ((InternalEList<?>) this.getSubFolders()).basicRemove(otherEnd, msgs);
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
            case ProjectmgmtPackage.TAG_FOLDER__NAME:
                return this.getName();
            case ProjectmgmtPackage.TAG_FOLDER__OWNED_TAGS:
                return this.getOwnedTags();
            case ProjectmgmtPackage.TAG_FOLDER__SUB_FOLDERS:
                return this.getSubFolders();
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
            case ProjectmgmtPackage.TAG_FOLDER__NAME:
                this.setName((String) newValue);
                return;
            case ProjectmgmtPackage.TAG_FOLDER__OWNED_TAGS:
                this.getOwnedTags().clear();
                this.getOwnedTags().addAll((Collection<? extends TaskTag>) newValue);
                return;
            case ProjectmgmtPackage.TAG_FOLDER__SUB_FOLDERS:
                this.getSubFolders().clear();
                this.getSubFolders().addAll((Collection<? extends TagFolder>) newValue);
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
            case ProjectmgmtPackage.TAG_FOLDER__NAME:
                this.setName(NAME_EDEFAULT);
                return;
            case ProjectmgmtPackage.TAG_FOLDER__OWNED_TAGS:
                this.getOwnedTags().clear();
                return;
            case ProjectmgmtPackage.TAG_FOLDER__SUB_FOLDERS:
                this.getSubFolders().clear();
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
            case ProjectmgmtPackage.TAG_FOLDER__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
            case ProjectmgmtPackage.TAG_FOLDER__OWNED_TAGS:
                return this.ownedTags != null && !this.ownedTags.isEmpty();
            case ProjectmgmtPackage.TAG_FOLDER__SUB_FOLDERS:
                return this.subFolders != null && !this.subFolders.isEmpty();
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

} // TagFolderImpl

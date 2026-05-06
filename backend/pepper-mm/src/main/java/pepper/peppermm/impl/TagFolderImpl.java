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

import pepper.peppermm.PepperPackage;
import pepper.peppermm.TagFolder;
import pepper.peppermm.TaskTag;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tag Folder</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.impl.TagFolderImpl#getName <em>Name</em>}</li>
 * <li>{@link pepper.peppermm.impl.TagFolderImpl#getOwnedTags <em>Owned Tags</em>}</li>
 * <li>{@link pepper.peppermm.impl.TagFolderImpl#getSubFolders <em>Sub Folders</em>}</li>
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
        return PepperPackage.Literals.TAG_FOLDER;
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
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.TAG_FOLDER__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<TaskTag> getOwnedTags() {
        if (ownedTags == null) {
            ownedTags = new EObjectContainmentEList<TaskTag>(TaskTag.class, this, PepperPackage.TAG_FOLDER__OWNED_TAGS);
        }
        return ownedTags;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<TagFolder> getSubFolders() {
        if (subFolders == null) {
            subFolders = new EObjectContainmentEList<TagFolder>(TagFolder.class, this, PepperPackage.TAG_FOLDER__SUB_FOLDERS);
        }
        return subFolders;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PepperPackage.TAG_FOLDER__OWNED_TAGS:
                return ((InternalEList<?>) getOwnedTags()).basicRemove(otherEnd, msgs);
            case PepperPackage.TAG_FOLDER__SUB_FOLDERS:
                return ((InternalEList<?>) getSubFolders()).basicRemove(otherEnd, msgs);
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
            case PepperPackage.TAG_FOLDER__NAME:
                return getName();
            case PepperPackage.TAG_FOLDER__OWNED_TAGS:
                return getOwnedTags();
            case PepperPackage.TAG_FOLDER__SUB_FOLDERS:
                return getSubFolders();
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
            case PepperPackage.TAG_FOLDER__NAME:
                setName((String) newValue);
                return;
            case PepperPackage.TAG_FOLDER__OWNED_TAGS:
                getOwnedTags().clear();
                getOwnedTags().addAll((Collection<? extends TaskTag>) newValue);
                return;
            case PepperPackage.TAG_FOLDER__SUB_FOLDERS:
                getSubFolders().clear();
                getSubFolders().addAll((Collection<? extends TagFolder>) newValue);
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
            case PepperPackage.TAG_FOLDER__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PepperPackage.TAG_FOLDER__OWNED_TAGS:
                getOwnedTags().clear();
                return;
            case PepperPackage.TAG_FOLDER__SUB_FOLDERS:
                getSubFolders().clear();
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
            case PepperPackage.TAG_FOLDER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PepperPackage.TAG_FOLDER__OWNED_TAGS:
                return ownedTags != null && !ownedTags.isEmpty();
            case PepperPackage.TAG_FOLDER__SUB_FOLDERS:
                return subFolders != null && !subFolders.isEmpty();
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

} // TagFolderImpl

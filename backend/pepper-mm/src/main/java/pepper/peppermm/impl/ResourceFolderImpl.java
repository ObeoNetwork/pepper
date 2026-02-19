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
import pepper.peppermm.Resource;
import pepper.peppermm.ResourceFolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Resource Folder</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.impl.ResourceFolderImpl#getName <em>Name</em>}</li>
 * <li>{@link pepper.peppermm.impl.ResourceFolderImpl#getOwnedResources <em>Owned Resources</em>}</li>
 * <li>{@link pepper.peppermm.impl.ResourceFolderImpl#getSubFolders <em>Sub Folders</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceFolderImpl extends MinimalEObjectImpl.Container implements ResourceFolder {
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
     * The cached value of the '{@link #getOwnedResources() <em>Owned Resources</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwnedResources()
     * @generated
     * @ordered
     */
    protected EList<Resource> ownedResources;

    /**
     * The cached value of the '{@link #getSubFolders() <em>Sub Folders</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSubFolders()
     * @generated
     * @ordered
     */
    protected EList<ResourceFolder> subFolders;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceFolderImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PepperPackage.Literals.RESOURCE_FOLDER;
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
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.RESOURCE_FOLDER__NAME, oldName, this.name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Resource> getOwnedResources() {
        if (this.ownedResources == null) {
            this.ownedResources = new EObjectContainmentEList<>(Resource.class, this, PepperPackage.RESOURCE_FOLDER__OWNED_RESOURCES);
        }
        return this.ownedResources;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ResourceFolder> getSubFolders() {
        if (this.subFolders == null) {
            this.subFolders = new EObjectContainmentEList<>(ResourceFolder.class, this, PepperPackage.RESOURCE_FOLDER__SUB_FOLDERS);
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
            case PepperPackage.RESOURCE_FOLDER__OWNED_RESOURCES:
                return ((InternalEList<?>) this.getOwnedResources()).basicRemove(otherEnd, msgs);
            case PepperPackage.RESOURCE_FOLDER__SUB_FOLDERS:
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
            case PepperPackage.RESOURCE_FOLDER__NAME:
                return this.getName();
            case PepperPackage.RESOURCE_FOLDER__OWNED_RESOURCES:
                return this.getOwnedResources();
            case PepperPackage.RESOURCE_FOLDER__SUB_FOLDERS:
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
            case PepperPackage.RESOURCE_FOLDER__NAME:
                this.setName((String) newValue);
                return;
            case PepperPackage.RESOURCE_FOLDER__OWNED_RESOURCES:
                this.getOwnedResources().clear();
                this.getOwnedResources().addAll((Collection<? extends Resource>) newValue);
                return;
            case PepperPackage.RESOURCE_FOLDER__SUB_FOLDERS:
                this.getSubFolders().clear();
                this.getSubFolders().addAll((Collection<? extends ResourceFolder>) newValue);
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
            case PepperPackage.RESOURCE_FOLDER__NAME:
                this.setName(NAME_EDEFAULT);
                return;
            case PepperPackage.RESOURCE_FOLDER__OWNED_RESOURCES:
                this.getOwnedResources().clear();
                return;
            case PepperPackage.RESOURCE_FOLDER__SUB_FOLDERS:
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
            case PepperPackage.RESOURCE_FOLDER__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
            case PepperPackage.RESOURCE_FOLDER__OWNED_RESOURCES:
                return this.ownedResources != null && !this.ownedResources.isEmpty();
            case PepperPackage.RESOURCE_FOLDER__SUB_FOLDERS:
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

} // ResourceFolderImpl

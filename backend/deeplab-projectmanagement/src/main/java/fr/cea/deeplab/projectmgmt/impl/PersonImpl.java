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

import fr.cea.deeplab.projectmgmt.Person;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Person</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.PersonImpl#getAlias <em>Alias</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.PersonImpl#getBiography <em>Biography</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.PersonImpl#getImageUrl <em>Image Url</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonImpl extends ResourceImpl implements Person {
    /**
     * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getAlias()
     * @generated
     * @ordered
     */
    protected static final String ALIAS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getAlias()
     * @generated
     * @ordered
     */
    protected String alias = ALIAS_EDEFAULT;

    /**
     * The default value of the '{@link #getBiography() <em>Biography</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getBiography()
     * @generated
     * @ordered
     */
    protected static final String BIOGRAPHY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBiography() <em>Biography</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getBiography()
     * @generated
     * @ordered
     */
    protected String biography = BIOGRAPHY_EDEFAULT;

    /**
     * The default value of the '{@link #getImageUrl() <em>Image Url</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getImageUrl()
     * @generated
     * @ordered
     */
    protected static final String IMAGE_URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImageUrl() <em>Image Url</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getImageUrl()
     * @generated
     * @ordered
     */
    protected String imageUrl = IMAGE_URL_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PersonImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProjectmgmtPackage.Literals.PERSON;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getAlias() {
        return this.alias;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAlias(String newAlias) {
        String oldAlias = this.alias;
        this.alias = newAlias;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PERSON__ALIAS, oldAlias, this.alias));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getBiography() {
        return this.biography;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBiography(String newBiography) {
        String oldBiography = this.biography;
        this.biography = newBiography;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PERSON__BIOGRAPHY, oldBiography, this.biography));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getImageUrl() {
        return this.imageUrl;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setImageUrl(String newImageUrl) {
        String oldImageUrl = this.imageUrl;
        this.imageUrl = newImageUrl;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PERSON__IMAGE_URL, oldImageUrl, this.imageUrl));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProjectmgmtPackage.PERSON__ALIAS:
                return this.getAlias();
            case ProjectmgmtPackage.PERSON__BIOGRAPHY:
                return this.getBiography();
            case ProjectmgmtPackage.PERSON__IMAGE_URL:
                return this.getImageUrl();
            default:
                return super.eGet(featureID, resolve, coreType);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ProjectmgmtPackage.PERSON__ALIAS:
                this.setAlias((String) newValue);
                return;
            case ProjectmgmtPackage.PERSON__BIOGRAPHY:
                this.setBiography((String) newValue);
                return;
            case ProjectmgmtPackage.PERSON__IMAGE_URL:
                this.setImageUrl((String) newValue);
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
            case ProjectmgmtPackage.PERSON__ALIAS:
                this.setAlias(ALIAS_EDEFAULT);
                return;
            case ProjectmgmtPackage.PERSON__BIOGRAPHY:
                this.setBiography(BIOGRAPHY_EDEFAULT);
                return;
            case ProjectmgmtPackage.PERSON__IMAGE_URL:
                this.setImageUrl(IMAGE_URL_EDEFAULT);
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
            case ProjectmgmtPackage.PERSON__ALIAS:
                return ALIAS_EDEFAULT == null ? this.alias != null : !ALIAS_EDEFAULT.equals(this.alias);
            case ProjectmgmtPackage.PERSON__BIOGRAPHY:
                return BIOGRAPHY_EDEFAULT == null ? this.biography != null : !BIOGRAPHY_EDEFAULT.equals(this.biography);
            case ProjectmgmtPackage.PERSON__IMAGE_URL:
                return IMAGE_URL_EDEFAULT == null ? this.imageUrl != null : !IMAGE_URL_EDEFAULT.equals(this.imageUrl);
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
        result.append(" (alias: ");
        result.append(this.alias);
        result.append(", biography: ");
        result.append(this.biography);
        result.append(", imageUrl: ");
        result.append(this.imageUrl);
        result.append(')');
        return result.toString();
    }

} // PersonImpl

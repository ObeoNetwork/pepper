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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Person</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.impl.PersonImpl#getAlias <em>Alias</em>}</li>
 * <li>{@link pepper.peppermm.impl.PersonImpl#getBiography <em>Biography</em>}</li>
 * <li>{@link pepper.peppermm.impl.PersonImpl#getImageUrl <em>Image Url</em>}</li>
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
        return PepperPackage.Literals.PERSON;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getAlias() {
        return alias;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAlias(String newAlias) {
        String oldAlias = alias;
        alias = newAlias;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PERSON__ALIAS, oldAlias, alias));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getBiography() {
        return biography;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBiography(String newBiography) {
        String oldBiography = biography;
        biography = newBiography;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PERSON__BIOGRAPHY, oldBiography, biography));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setImageUrl(String newImageUrl) {
        String oldImageUrl = imageUrl;
        imageUrl = newImageUrl;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PERSON__IMAGE_URL, oldImageUrl, imageUrl));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PepperPackage.PERSON__ALIAS:
                return getAlias();
            case PepperPackage.PERSON__BIOGRAPHY:
                return getBiography();
            case PepperPackage.PERSON__IMAGE_URL:
                return getImageUrl();
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
            case PepperPackage.PERSON__ALIAS:
                setAlias((String) newValue);
                return;
            case PepperPackage.PERSON__BIOGRAPHY:
                setBiography((String) newValue);
                return;
            case PepperPackage.PERSON__IMAGE_URL:
                setImageUrl((String) newValue);
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
            case PepperPackage.PERSON__ALIAS:
                setAlias(ALIAS_EDEFAULT);
                return;
            case PepperPackage.PERSON__BIOGRAPHY:
                setBiography(BIOGRAPHY_EDEFAULT);
                return;
            case PepperPackage.PERSON__IMAGE_URL:
                setImageUrl(IMAGE_URL_EDEFAULT);
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
            case PepperPackage.PERSON__ALIAS:
                return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
            case PepperPackage.PERSON__BIOGRAPHY:
                return BIOGRAPHY_EDEFAULT == null ? biography != null : !BIOGRAPHY_EDEFAULT.equals(biography);
            case PepperPackage.PERSON__IMAGE_URL:
                return IMAGE_URL_EDEFAULT == null ? imageUrl != null : !IMAGE_URL_EDEFAULT.equals(imageUrl);
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
        result.append(" (alias: ");
        result.append(alias);
        result.append(", biography: ");
        result.append(biography);
        result.append(", imageUrl: ");
        result.append(imageUrl);
        result.append(')');
        return result.toString();
    }

} // PersonImpl

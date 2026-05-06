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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.StartOrEnd;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Dependency Link</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link DependencyLinkImpl#getTargetKind <em>Target</em>}</li>
 * <li>{@link DependencyLinkImpl#getSourceKind <em>Source</em>}</li>
 * <li>{@link DependencyLinkImpl#getSource <em>Dependency</em>}</li>
 * <li>{@link DependencyLinkImpl#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependencyLinkImpl extends MinimalEObjectImpl.Container implements DependencyLink {
    /**
     * The default value of the '{@link #getTargetKind() <em>Target Kind</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getTargetKind()
     * @generated
     * @ordered
     */
    protected static final StartOrEnd TARGET_KIND_EDEFAULT = StartOrEnd.START;

    /**
     * The cached value of the '{@link #getTargetKind() <em>Target Kind</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getTargetKind()
     * @generated
     * @ordered
     */
    protected StartOrEnd targetKind = TARGET_KIND_EDEFAULT;

    /**
     * The default value of the '{@link #getSourceKind() <em>Source Kind</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSourceKind()
     * @generated
     * @ordered
     */
    protected static final StartOrEnd SOURCE_KIND_EDEFAULT = StartOrEnd.END;

    /**
     * The cached value of the '{@link #getSourceKind() <em>Source Kind</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSourceKind()
     * @generated
     * @ordered
     */
    protected StartOrEnd sourceKind = SOURCE_KIND_EDEFAULT;

    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSource()
     * @generated
     * @ordered
     */
    protected DependencyRelatedObject source;

    /**
     * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDuration()
     * @generated
     * @ordered
     */
    protected static final int DURATION_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDuration()
     * @generated
     * @ordered
     */
    protected int duration = DURATION_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DependencyLinkImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PepperPackage.Literals.DEPENDENCY_LINK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public StartOrEnd getTargetKind() {
        return targetKind;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTargetKind(StartOrEnd newTargetKind) {
        StartOrEnd oldTargetKind = targetKind;
        targetKind = newTargetKind == null ? TARGET_KIND_EDEFAULT : newTargetKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.DEPENDENCY_LINK__TARGET_KIND, oldTargetKind, targetKind));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public StartOrEnd getSourceKind() {
        return sourceKind;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSourceKind(StartOrEnd newSourceKind) {
        StartOrEnd oldSourceKind = sourceKind;
        sourceKind = newSourceKind == null ? SOURCE_KIND_EDEFAULT : newSourceKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.DEPENDENCY_LINK__SOURCE_KIND, oldSourceKind, sourceKind));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DependencyRelatedObject getSource() {
        if (source != null && source.eIsProxy()) {
            InternalEObject oldSource = (InternalEObject) source;
            source = (DependencyRelatedObject) eResolveProxy(oldSource);
            if (source != oldSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PepperPackage.DEPENDENCY_LINK__SOURCE, oldSource, source));
            }
        }
        return source;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DependencyRelatedObject basicGetSource() {
        return source;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSource(DependencyRelatedObject newSource) {
        DependencyRelatedObject oldSource = source;
        source = newSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.DEPENDENCY_LINK__SOURCE, oldSource, source));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getDuration() {
        return duration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDuration(int newDuration) {
        int oldDuration = duration;
        duration = newDuration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.DEPENDENCY_LINK__DURATION, oldDuration, duration));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PepperPackage.DEPENDENCY_LINK__TARGET_KIND:
                return getTargetKind();
            case PepperPackage.DEPENDENCY_LINK__SOURCE_KIND:
                return getSourceKind();
            case PepperPackage.DEPENDENCY_LINK__SOURCE:
                if (resolve)
                    return getSource();
                return basicGetSource();
            case PepperPackage.DEPENDENCY_LINK__DURATION:
                return getDuration();
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
            case PepperPackage.DEPENDENCY_LINK__TARGET_KIND:
                setTargetKind((StartOrEnd) newValue);
                return;
            case PepperPackage.DEPENDENCY_LINK__SOURCE_KIND:
                setSourceKind((StartOrEnd) newValue);
                return;
            case PepperPackage.DEPENDENCY_LINK__SOURCE:
                setSource((DependencyRelatedObject) newValue);
                return;
            case PepperPackage.DEPENDENCY_LINK__DURATION:
                setDuration((Integer) newValue);
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
            case PepperPackage.DEPENDENCY_LINK__TARGET_KIND:
                setTargetKind(TARGET_KIND_EDEFAULT);
                return;
            case PepperPackage.DEPENDENCY_LINK__SOURCE_KIND:
                setSourceKind(SOURCE_KIND_EDEFAULT);
                return;
            case PepperPackage.DEPENDENCY_LINK__SOURCE:
                setSource((DependencyRelatedObject) null);
                return;
            case PepperPackage.DEPENDENCY_LINK__DURATION:
                setDuration(DURATION_EDEFAULT);
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
            case PepperPackage.DEPENDENCY_LINK__TARGET_KIND:
                return targetKind != TARGET_KIND_EDEFAULT;
            case PepperPackage.DEPENDENCY_LINK__SOURCE_KIND:
                return sourceKind != SOURCE_KIND_EDEFAULT;
            case PepperPackage.DEPENDENCY_LINK__SOURCE:
                return source != null;
            case PepperPackage.DEPENDENCY_LINK__DURATION:
                return duration != DURATION_EDEFAULT;
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
        result.append(" (targetKind: ");
        result.append(targetKind);
        result.append(", sourceKind: ");
        result.append(sourceKind);
        result.append(", duration: ");
        result.append(duration);
        result.append(')');
        return result.toString();
    }

} // DependencyLinkImpl

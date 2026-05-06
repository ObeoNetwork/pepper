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

import java.time.LocalDate;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Risk;
import pepper.peppermm.RiskKind;
import pepper.peppermm.RiskState;
import pepper.peppermm.Workpackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Risk</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link RiskImpl#getKind <em>Kind</em>}</li>
 * <li>{@link RiskImpl#getDescription <em>Description</em>}</li>
 * <li>{@link RiskImpl#getCriticity <em>Criticity</em>}</li>
 * <li>{@link RiskImpl#getAction <em>Action</em>}</li>
 * <li>{@link RiskImpl#getResponsible <em>Responsible</em>}</li>
 * <li>{@link RiskImpl#getOperationDate <em>Operation Date</em>}</li>
 * <li>{@link RiskImpl#getState <em>State</em>}</li>
 * <li>{@link RiskImpl#getWorkpackages <em>Workpackages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RiskImpl extends MinimalEObjectImpl.Container implements Risk {
    /**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getKind()
     * @generated NOT
     * @ordered
     */
    protected static final RiskKind KIND_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected RiskKind kind = KIND_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getCriticity() <em>Criticity</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getCriticity()
     * @generated
     * @ordered
     */
    protected static final Integer CRITICITY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCriticity() <em>Criticity</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getCriticity()
     * @generated
     * @ordered
     */
    protected Integer criticity = CRITICITY_EDEFAULT;

    /**
     * The default value of the '{@link #getAction() <em>Action</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getAction()
     * @generated
     * @ordered
     */
    protected static final String ACTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAction() <em>Action</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getAction()
     * @generated
     * @ordered
     */
    protected String action = ACTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getResponsible() <em>Responsible</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResponsible()
     * @generated
     * @ordered
     */
    protected Person responsible;

    /**
     * The default value of the '{@link #getOperationDate() <em>Operation Date</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOperationDate()
     * @generated
     * @ordered
     */
    protected static final LocalDate OPERATION_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOperationDate() <em>Operation Date</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOperationDate()
     * @generated
     * @ordered
     */
    protected LocalDate operationDate = OPERATION_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getState() <em>State</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getState()
     * @generated
     * @ordered
     */
    protected static final RiskState STATE_EDEFAULT = RiskState.ON_GOING;

    /**
     * The cached value of the '{@link #getState() <em>State</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getState()
     * @generated
     * @ordered
     */
    protected RiskState state = STATE_EDEFAULT;

    /**
     * The cached value of the '{@link #getWorkpackages() <em>Workpackages</em>}' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getWorkpackages()
     * @generated
     * @ordered
     */
    protected EList<Workpackage> workpackages;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RiskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PepperPackage.Literals.RISK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RiskKind getKind() {
        return kind;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setKind(RiskKind newKind) {
        RiskKind oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.RISK__KIND, oldKind, kind));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.RISK__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Integer getCriticity() {
        return criticity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCriticity(Integer newCriticity) {
        Integer oldCriticity = criticity;
        criticity = newCriticity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.RISK__CRITICITY, oldCriticity, criticity));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getAction() {
        return action;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAction(String newAction) {
        String oldAction = action;
        action = newAction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.RISK__ACTION, oldAction, action));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Person getResponsible() {
        if (responsible != null && responsible.eIsProxy()) {
            InternalEObject oldResponsible = (InternalEObject) responsible;
            responsible = (Person) eResolveProxy(oldResponsible);
            if (responsible != oldResponsible) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PepperPackage.RISK__RESPONSIBLE, oldResponsible, responsible));
            }
        }
        return responsible;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Person basicGetResponsible() {
        return responsible;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResponsible(Person newResponsible) {
        Person oldResponsible = responsible;
        responsible = newResponsible;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.RISK__RESPONSIBLE, oldResponsible, responsible));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getOperationDate() {
        return operationDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOperationDate(LocalDate newOperationDate) {
        LocalDate oldOperationDate = operationDate;
        operationDate = newOperationDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.RISK__OPERATION_DATE, oldOperationDate, operationDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RiskState getState() {
        return state;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setState(RiskState newState) {
        RiskState oldState = state;
        state = newState == null ? STATE_EDEFAULT : newState;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.RISK__STATE, oldState, state));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Workpackage> getWorkpackages() {
        if (workpackages == null) {
            workpackages = new EObjectResolvingEList<Workpackage>(Workpackage.class, this, PepperPackage.RISK__WORKPACKAGES);
        }
        return workpackages;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PepperPackage.RISK__KIND:
                return getKind();
            case PepperPackage.RISK__DESCRIPTION:
                return getDescription();
            case PepperPackage.RISK__CRITICITY:
                return getCriticity();
            case PepperPackage.RISK__ACTION:
                return getAction();
            case PepperPackage.RISK__RESPONSIBLE:
                if (resolve)
                    return getResponsible();
                return basicGetResponsible();
            case PepperPackage.RISK__OPERATION_DATE:
                return getOperationDate();
            case PepperPackage.RISK__STATE:
                return getState();
            case PepperPackage.RISK__WORKPACKAGES:
                return getWorkpackages();
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
            case PepperPackage.RISK__KIND:
                setKind((RiskKind) newValue);
                return;
            case PepperPackage.RISK__DESCRIPTION:
                setDescription((String) newValue);
                return;
            case PepperPackage.RISK__CRITICITY:
                setCriticity((Integer) newValue);
                return;
            case PepperPackage.RISK__ACTION:
                setAction((String) newValue);
                return;
            case PepperPackage.RISK__RESPONSIBLE:
                setResponsible((Person) newValue);
                return;
            case PepperPackage.RISK__OPERATION_DATE:
                setOperationDate((LocalDate) newValue);
                return;
            case PepperPackage.RISK__STATE:
                setState((RiskState) newValue);
                return;
            case PepperPackage.RISK__WORKPACKAGES:
                getWorkpackages().clear();
                getWorkpackages().addAll((Collection<? extends Workpackage>) newValue);
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
            case PepperPackage.RISK__KIND:
                setKind(KIND_EDEFAULT);
                return;
            case PepperPackage.RISK__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case PepperPackage.RISK__CRITICITY:
                setCriticity(CRITICITY_EDEFAULT);
                return;
            case PepperPackage.RISK__ACTION:
                setAction(ACTION_EDEFAULT);
                return;
            case PepperPackage.RISK__RESPONSIBLE:
                setResponsible((Person) null);
                return;
            case PepperPackage.RISK__OPERATION_DATE:
                setOperationDate(OPERATION_DATE_EDEFAULT);
                return;
            case PepperPackage.RISK__STATE:
                setState(STATE_EDEFAULT);
                return;
            case PepperPackage.RISK__WORKPACKAGES:
                getWorkpackages().clear();
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
            case PepperPackage.RISK__KIND:
                return kind != KIND_EDEFAULT;
            case PepperPackage.RISK__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case PepperPackage.RISK__CRITICITY:
                return CRITICITY_EDEFAULT == null ? criticity != null : !CRITICITY_EDEFAULT.equals(criticity);
            case PepperPackage.RISK__ACTION:
                return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
            case PepperPackage.RISK__RESPONSIBLE:
                return responsible != null;
            case PepperPackage.RISK__OPERATION_DATE:
                return OPERATION_DATE_EDEFAULT == null ? operationDate != null : !OPERATION_DATE_EDEFAULT.equals(operationDate);
            case PepperPackage.RISK__STATE:
                return state != STATE_EDEFAULT;
            case PepperPackage.RISK__WORKPACKAGES:
                return workpackages != null && !workpackages.isEmpty();
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
        result.append(" (kind: ");
        result.append(kind);
        result.append(", description: ");
        result.append(description);
        result.append(", criticity: ");
        result.append(criticity);
        result.append(", action: ");
        result.append(action);
        result.append(", operationDate: ");
        result.append(operationDate);
        result.append(", state: ");
        result.append(state);
        result.append(')');
        return result.toString();
    }

} // RiskImpl

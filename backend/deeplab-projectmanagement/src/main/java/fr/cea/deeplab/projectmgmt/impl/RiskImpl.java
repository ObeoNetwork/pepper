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
import fr.cea.deeplab.projectmgmt.Risk;
import fr.cea.deeplab.projectmgmt.RiskKind;
import fr.cea.deeplab.projectmgmt.RiskState;
import fr.cea.deeplab.projectmgmt.Workpackage;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Risk</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.RiskImpl#getKind <em>Kind</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.RiskImpl#getDescription <em>Description</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.RiskImpl#getCriticity <em>Criticity</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.RiskImpl#getAction <em>Action</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.RiskImpl#getResponsible <em>Responsible</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.RiskImpl#getOperationDate <em>Operation Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.RiskImpl#getState <em>State</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.RiskImpl#getWorkpackages <em>Workpackages</em>}</li>
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
     * @generated NOT
     * @ordered
     */
    protected static final RiskState STATE_EDEFAULT = null;

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
        return ProjectmgmtPackage.Literals.RISK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RiskKind getKind() {
        return this.kind;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setKind(RiskKind newKind) {
        RiskKind oldKind = this.kind;
        this.kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.RISK__KIND, oldKind, this.kind));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDescription(String newDescription) {
        String oldDescription = this.description;
        this.description = newDescription;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.RISK__DESCRIPTION, oldDescription, this.description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Integer getCriticity() {
        return this.criticity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setCriticity(Integer newCriticity) {
        Integer oldCriticity = this.criticity;
        this.criticity = newCriticity;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.RISK__CRITICITY, oldCriticity, this.criticity));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getAction() {
        return this.action;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAction(String newAction) {
        String oldAction = this.action;
        this.action = newAction;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.RISK__ACTION, oldAction, this.action));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Person getResponsible() {
        if (this.responsible != null && this.responsible.eIsProxy()) {
            InternalEObject oldResponsible = (InternalEObject) this.responsible;
            this.responsible = (Person) this.eResolveProxy(oldResponsible);
            if (this.responsible != oldResponsible) {
                if (this.eNotificationRequired())
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectmgmtPackage.RISK__RESPONSIBLE, oldResponsible, this.responsible));
            }
        }
        return this.responsible;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Person basicGetResponsible() {
        return this.responsible;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResponsible(Person newResponsible) {
        Person oldResponsible = this.responsible;
        this.responsible = newResponsible;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.RISK__RESPONSIBLE, oldResponsible, this.responsible));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LocalDate getOperationDate() {
        return this.operationDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationDate(LocalDate newOperationDate) {
        LocalDate oldOperationDate = this.operationDate;
        this.operationDate = newOperationDate;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.RISK__OPERATION_DATE, oldOperationDate, this.operationDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RiskState getState() {
        return this.state;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setState(RiskState newState) {
        RiskState oldState = this.state;
        this.state = newState == null ? STATE_EDEFAULT : newState;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.RISK__STATE, oldState, this.state));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Workpackage> getWorkpackages() {
        if (this.workpackages == null) {
            this.workpackages = new EObjectResolvingEList<>(Workpackage.class, this, ProjectmgmtPackage.RISK__WORKPACKAGES);
        }
        return this.workpackages;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProjectmgmtPackage.RISK__KIND:
                return this.getKind();
            case ProjectmgmtPackage.RISK__DESCRIPTION:
                return this.getDescription();
            case ProjectmgmtPackage.RISK__CRITICITY:
                return this.getCriticity();
            case ProjectmgmtPackage.RISK__ACTION:
                return this.getAction();
            case ProjectmgmtPackage.RISK__RESPONSIBLE:
                if (resolve)
                    return this.getResponsible();
                return this.basicGetResponsible();
            case ProjectmgmtPackage.RISK__OPERATION_DATE:
                return this.getOperationDate();
            case ProjectmgmtPackage.RISK__STATE:
                return this.getState();
            case ProjectmgmtPackage.RISK__WORKPACKAGES:
                return this.getWorkpackages();
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
            case ProjectmgmtPackage.RISK__KIND:
                this.setKind((RiskKind) newValue);
                return;
            case ProjectmgmtPackage.RISK__DESCRIPTION:
                this.setDescription((String) newValue);
                return;
            case ProjectmgmtPackage.RISK__CRITICITY:
                this.setCriticity((Integer) newValue);
                return;
            case ProjectmgmtPackage.RISK__ACTION:
                this.setAction((String) newValue);
                return;
            case ProjectmgmtPackage.RISK__RESPONSIBLE:
                this.setResponsible((Person) newValue);
                return;
            case ProjectmgmtPackage.RISK__OPERATION_DATE:
                this.setOperationDate((LocalDate) newValue);
                return;
            case ProjectmgmtPackage.RISK__STATE:
                this.setState((RiskState) newValue);
                return;
            case ProjectmgmtPackage.RISK__WORKPACKAGES:
                this.getWorkpackages().clear();
                this.getWorkpackages().addAll((Collection<? extends Workpackage>) newValue);
                return;
            default:
                super.eSet(featureID, newValue);
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
            case ProjectmgmtPackage.RISK__KIND:
                this.setKind(KIND_EDEFAULT);
                return;
            case ProjectmgmtPackage.RISK__DESCRIPTION:
                this.setDescription(DESCRIPTION_EDEFAULT);
                return;
            case ProjectmgmtPackage.RISK__CRITICITY:
                this.setCriticity(CRITICITY_EDEFAULT);
                return;
            case ProjectmgmtPackage.RISK__ACTION:
                this.setAction(ACTION_EDEFAULT);
                return;
            case ProjectmgmtPackage.RISK__RESPONSIBLE:
                this.setResponsible(null);
                return;
            case ProjectmgmtPackage.RISK__OPERATION_DATE:
                this.setOperationDate(OPERATION_DATE_EDEFAULT);
                return;
            case ProjectmgmtPackage.RISK__STATE:
                this.setState(STATE_EDEFAULT);
                return;
            case ProjectmgmtPackage.RISK__WORKPACKAGES:
                this.getWorkpackages().clear();
                return;
            default:
                super.eUnset(featureID);
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
            case ProjectmgmtPackage.RISK__KIND:
                return this.kind != KIND_EDEFAULT;
            case ProjectmgmtPackage.RISK__DESCRIPTION:
                return !Objects.equals(DESCRIPTION_EDEFAULT, this.description);
            case ProjectmgmtPackage.RISK__CRITICITY:
                return !Objects.equals(CRITICITY_EDEFAULT, this.criticity);
            case ProjectmgmtPackage.RISK__ACTION:
                return !Objects.equals(ACTION_EDEFAULT, this.action);
            case ProjectmgmtPackage.RISK__RESPONSIBLE:
                return this.responsible != null;
            case ProjectmgmtPackage.RISK__OPERATION_DATE:
                return !Objects.equals(OPERATION_DATE_EDEFAULT, this.operationDate);
            case ProjectmgmtPackage.RISK__STATE:
                return this.state != STATE_EDEFAULT;
            case ProjectmgmtPackage.RISK__WORKPACKAGES:
                return this.workpackages != null && !this.workpackages.isEmpty();
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

        String result = super.toString() + " (kind: "
                + this.kind
                + ", description: "
                + this.description
                + ", criticity: "
                + this.criticity
                + ", action: "
                + this.action
                + ", operationDate: "
                + this.operationDate
                + ", state: "
                + this.state
                + ')';
        return result;
    }

} // RiskImpl

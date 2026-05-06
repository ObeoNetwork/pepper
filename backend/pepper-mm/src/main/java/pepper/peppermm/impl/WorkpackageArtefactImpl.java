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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.WorkpackageArtefact;
import pepper.peppermm.WorkpackageArtefactNature;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Workpackage Artefact</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link WorkpackageArtefactImpl#getName <em>Name</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getDescription <em>Description</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getNature <em>Nature</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getPlannedDeadline <em>Planned Deadline</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getEffectiveDeadLine <em>Effective Dead Line</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getIsInvoiceTrigger <em>Is Invoice Trigger</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getInvoiceAmount <em>Invoice Amount</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getResponsible <em>Responsible</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getVersion <em>Version</em>}</li>
 * <li>{@link WorkpackageArtefactImpl#getIsObsolete <em>Is Obsolete</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkpackageArtefactImpl extends MinimalEObjectImpl.Container implements WorkpackageArtefact {
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
     * The default value of the '{@link #getNature() <em>Nature</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getNature()
     * @generated NOT
     * @ordered
     */
    protected static final WorkpackageArtefactNature NATURE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNature() <em>Nature</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getNature()
     * @generated
     * @ordered
     */
    protected WorkpackageArtefactNature nature = NATURE_EDEFAULT;

    /**
     * The default value of the '{@link #getPlannedDeadline() <em>Planned Deadline</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getPlannedDeadline()
     * @generated
     * @ordered
     */
    protected static final LocalDate PLANNED_DEADLINE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPlannedDeadline() <em>Planned Deadline</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getPlannedDeadline()
     * @generated
     * @ordered
     */
    protected LocalDate plannedDeadline = PLANNED_DEADLINE_EDEFAULT;

    /**
     * The default value of the '{@link #getEffectiveDeadLine() <em>Effective Dead Line</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEffectiveDeadLine()
     * @generated
     * @ordered
     */
    protected static final LocalDate EFFECTIVE_DEAD_LINE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEffectiveDeadLine() <em>Effective Dead Line</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEffectiveDeadLine()
     * @generated
     * @ordered
     */
    protected LocalDate effectiveDeadLine = EFFECTIVE_DEAD_LINE_EDEFAULT;

    /**
     * The default value of the '{@link #getIsInvoiceTrigger() <em>Is Invoice Trigger</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIsInvoiceTrigger()
     * @generated
     * @ordered
     */
    protected static final Boolean IS_INVOICE_TRIGGER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIsInvoiceTrigger() <em>Is Invoice Trigger</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIsInvoiceTrigger()
     * @generated
     * @ordered
     */
    protected Boolean isInvoiceTrigger = IS_INVOICE_TRIGGER_EDEFAULT;

    /**
     * The default value of the '{@link #getInvoiceAmount() <em>Invoice Amount</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInvoiceAmount()
     * @generated
     * @ordered
     */
    protected static final Integer INVOICE_AMOUNT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInvoiceAmount() <em>Invoice Amount</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInvoiceAmount()
     * @generated
     * @ordered
     */
    protected Integer invoiceAmount = INVOICE_AMOUNT_EDEFAULT;

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
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected String version = VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getIsObsolete() <em>Is Obsolete</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getIsObsolete()
     * @generated
     * @ordered
     */
    protected static final Boolean IS_OBSOLETE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIsObsolete() <em>Is Obsolete</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getIsObsolete()
     * @generated
     * @ordered
     */
    protected Boolean isObsolete = IS_OBSOLETE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected WorkpackageArtefactImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PepperPackage.Literals.WORKPACKAGE_ARTEFACT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public WorkpackageArtefactNature getNature() {
        return nature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNature(WorkpackageArtefactNature newNature) {
        WorkpackageArtefactNature oldNature = nature;
        nature = newNature == null ? NATURE_EDEFAULT : newNature;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__NATURE, oldNature, nature));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getPlannedDeadline() {
        return plannedDeadline;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPlannedDeadline(LocalDate newPlannedDeadline) {
        LocalDate oldPlannedDeadline = plannedDeadline;
        plannedDeadline = newPlannedDeadline;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE, oldPlannedDeadline, plannedDeadline));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getEffectiveDeadLine() {
        return effectiveDeadLine;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEffectiveDeadLine(LocalDate newEffectiveDeadLine) {
        LocalDate oldEffectiveDeadLine = effectiveDeadLine;
        effectiveDeadLine = newEffectiveDeadLine;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE, oldEffectiveDeadLine, effectiveDeadLine));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Boolean getIsInvoiceTrigger() {
        return isInvoiceTrigger;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIsInvoiceTrigger(Boolean newIsInvoiceTrigger) {
        Boolean oldIsInvoiceTrigger = isInvoiceTrigger;
        isInvoiceTrigger = newIsInvoiceTrigger;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER, oldIsInvoiceTrigger, isInvoiceTrigger));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Integer getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInvoiceAmount(Integer newInvoiceAmount) {
        Integer oldInvoiceAmount = invoiceAmount;
        invoiceAmount = newInvoiceAmount;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT, oldInvoiceAmount, invoiceAmount));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PepperPackage.WORKPACKAGE_ARTEFACT__RESPONSIBLE, oldResponsible, responsible));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__RESPONSIBLE, oldResponsible, responsible));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getVersion() {
        return version;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVersion(String newVersion) {
        String oldVersion = version;
        version = newVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__VERSION, oldVersion, version));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Boolean getIsObsolete() {
        return isObsolete;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIsObsolete(Boolean newIsObsolete) {
        Boolean oldIsObsolete = isObsolete;
        isObsolete = newIsObsolete;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE_ARTEFACT__IS_OBSOLETE, oldIsObsolete, isObsolete));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PepperPackage.WORKPACKAGE_ARTEFACT__NAME:
                return getName();
            case PepperPackage.WORKPACKAGE_ARTEFACT__DESCRIPTION:
                return getDescription();
            case PepperPackage.WORKPACKAGE_ARTEFACT__NATURE:
                return getNature();
            case PepperPackage.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE:
                return getPlannedDeadline();
            case PepperPackage.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE:
                return getEffectiveDeadLine();
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER:
                return getIsInvoiceTrigger();
            case PepperPackage.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT:
                return getInvoiceAmount();
            case PepperPackage.WORKPACKAGE_ARTEFACT__RESPONSIBLE:
                if (resolve)
                    return getResponsible();
                return basicGetResponsible();
            case PepperPackage.WORKPACKAGE_ARTEFACT__VERSION:
                return getVersion();
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_OBSOLETE:
                return getIsObsolete();
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
            case PepperPackage.WORKPACKAGE_ARTEFACT__NAME:
                setName((String) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__DESCRIPTION:
                setDescription((String) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__NATURE:
                setNature((WorkpackageArtefactNature) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE:
                setPlannedDeadline((LocalDate) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE:
                setEffectiveDeadLine((LocalDate) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER:
                setIsInvoiceTrigger((Boolean) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT:
                setInvoiceAmount((Integer) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__RESPONSIBLE:
                setResponsible((Person) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__VERSION:
                setVersion((String) newValue);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_OBSOLETE:
                setIsObsolete((Boolean) newValue);
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
            case PepperPackage.WORKPACKAGE_ARTEFACT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__NATURE:
                setNature(NATURE_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE:
                setPlannedDeadline(PLANNED_DEADLINE_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE:
                setEffectiveDeadLine(EFFECTIVE_DEAD_LINE_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER:
                setIsInvoiceTrigger(IS_INVOICE_TRIGGER_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT:
                setInvoiceAmount(INVOICE_AMOUNT_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__RESPONSIBLE:
                setResponsible((Person) null);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__VERSION:
                setVersion(VERSION_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_OBSOLETE:
                setIsObsolete(IS_OBSOLETE_EDEFAULT);
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
            case PepperPackage.WORKPACKAGE_ARTEFACT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PepperPackage.WORKPACKAGE_ARTEFACT__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case PepperPackage.WORKPACKAGE_ARTEFACT__NATURE:
                return nature != NATURE_EDEFAULT;
            case PepperPackage.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE:
                return PLANNED_DEADLINE_EDEFAULT == null ? plannedDeadline != null : !PLANNED_DEADLINE_EDEFAULT.equals(plannedDeadline);
            case PepperPackage.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE:
                return EFFECTIVE_DEAD_LINE_EDEFAULT == null ? effectiveDeadLine != null : !EFFECTIVE_DEAD_LINE_EDEFAULT.equals(effectiveDeadLine);
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER:
                return IS_INVOICE_TRIGGER_EDEFAULT == null ? isInvoiceTrigger != null : !IS_INVOICE_TRIGGER_EDEFAULT.equals(isInvoiceTrigger);
            case PepperPackage.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT:
                return INVOICE_AMOUNT_EDEFAULT == null ? invoiceAmount != null : !INVOICE_AMOUNT_EDEFAULT.equals(invoiceAmount);
            case PepperPackage.WORKPACKAGE_ARTEFACT__RESPONSIBLE:
                return responsible != null;
            case PepperPackage.WORKPACKAGE_ARTEFACT__VERSION:
                return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_OBSOLETE:
                return IS_OBSOLETE_EDEFAULT == null ? isObsolete != null : !IS_OBSOLETE_EDEFAULT.equals(isObsolete);
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
        result.append(", description: ");
        result.append(description);
        result.append(", nature: ");
        result.append(nature);
        result.append(", plannedDeadline: ");
        result.append(plannedDeadline);
        result.append(", effectiveDeadLine: ");
        result.append(effectiveDeadLine);
        result.append(", isInvoiceTrigger: ");
        result.append(isInvoiceTrigger);
        result.append(", invoiceAmount: ");
        result.append(invoiceAmount);
        result.append(", version: ");
        result.append(version);
        result.append(", isObsolete: ");
        result.append(isObsolete);
        result.append(')');
        return result.toString();
    }

} // WorkpackageArtefactImpl

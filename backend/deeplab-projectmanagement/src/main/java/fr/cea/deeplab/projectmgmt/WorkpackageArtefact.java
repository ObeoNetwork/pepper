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
package fr.cea.deeplab.projectmgmt;

import java.time.LocalDate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Workpackage Artefact</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getName <em>Name</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getDescription <em>Description</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getNature <em>Nature</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getPlannedDeadline <em>Planned Deadline</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getEffectiveDeadLine <em>Effective Dead Line</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getIsInvoiceTrigger <em>Is Invoice Trigger</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getInvoiceAmount <em>Invoice Amount</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getResponsible <em>Responsible</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getVersion <em>Version</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getIsObsolete <em>Is Obsolete</em>}</li>
 * </ul>
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact()
 * @model
 * @generated
 */
public interface WorkpackageArtefact extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getDescription
     * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Nature</b></em>' attribute. The literals are from the enumeration
     * {@link fr.cea.deeplab.projectmgmt.WorkpackageArtefactNature}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Nature</em>' attribute.
     * @see fr.cea.deeplab.projectmgmt.WorkpackageArtefactNature
     * @see #setNature(WorkpackageArtefactNature)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_Nature()
     * @model
     * @generated
     */
    WorkpackageArtefactNature getNature();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getNature <em>Nature</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Nature</em>' attribute.
     * @see fr.cea.deeplab.projectmgmt.WorkpackageArtefactNature
     * @see #getNature()
     * @generated
     */
    void setNature(WorkpackageArtefactNature value);

    /**
     * Returns the value of the '<em><b>Planned Deadline</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Planned Deadline</em>' attribute.
     * @see #setPlannedDeadline(LocalDate)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_PlannedDeadline()
     * @model dataType="fr.cea.deeplab.projectmgmt.Date"
     * @generated
     */
    LocalDate getPlannedDeadline();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getPlannedDeadline <em>Planned
     * Deadline</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Planned Deadline</em>' attribute.
     * @see #getPlannedDeadline()
     * @generated
     */
    void setPlannedDeadline(LocalDate value);

    /**
     * Returns the value of the '<em><b>Effective Dead Line</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Effective Dead Line</em>' attribute.
     * @see #setEffectiveDeadLine(LocalDate)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_EffectiveDeadLine()
     * @model dataType="fr.cea.deeplab.projectmgmt.Date"
     * @generated
     */
    LocalDate getEffectiveDeadLine();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getEffectiveDeadLine <em>Effective
     * Dead Line</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Effective Dead Line</em>' attribute.
     * @see #getEffectiveDeadLine()
     * @generated
     */
    void setEffectiveDeadLine(LocalDate value);

    /**
     * Returns the value of the '<em><b>Is Invoice Trigger</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Is Invoice Trigger</em>' attribute.
     * @see #setIsInvoiceTrigger(Boolean)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_IsInvoiceTrigger()
     * @model
     * @generated
     */
    Boolean getIsInvoiceTrigger();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getIsInvoiceTrigger <em>Is Invoice
     * Trigger</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Is Invoice Trigger</em>' attribute.
     * @see #getIsInvoiceTrigger()
     * @generated
     */
    void setIsInvoiceTrigger(Boolean value);

    /**
     * Returns the value of the '<em><b>Invoice Amount</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Invoice Amount</em>' attribute.
     * @see #setInvoiceAmount(Integer)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_InvoiceAmount()
     * @model
     * @generated
     */
    Integer getInvoiceAmount();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getInvoiceAmount <em>Invoice
     * Amount</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Invoice Amount</em>' attribute.
     * @see #getInvoiceAmount()
     * @generated
     */
    void setInvoiceAmount(Integer value);

    /**
     * Returns the value of the '<em><b>Responsible</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Responsible</em>' reference.
     * @see #setResponsible(Person)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_Responsible()
     * @model
     * @generated
     */
    Person getResponsible();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getResponsible
     * <em>Responsible</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Responsible</em>' reference.
     * @see #getResponsible()
     * @generated
     */
    void setResponsible(Person value);

    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_Version()
     * @model
     * @generated
     */
    String getVersion();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getVersion <em>Version</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion(String value);

    /**
     * Returns the value of the '<em><b>Is Obsolete</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Is Obsolete</em>' attribute.
     * @see #setIsObsolete(Boolean)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefact_IsObsolete()
     * @model
     * @generated
     */
    Boolean getIsObsolete();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact#getIsObsolete <em>Is Obsolete</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Is Obsolete</em>' attribute.
     * @see #getIsObsolete()
     * @generated
     */
    void setIsObsolete(Boolean value);

} // WorkpackageArtefact

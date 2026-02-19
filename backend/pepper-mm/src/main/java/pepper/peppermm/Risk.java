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
package pepper.peppermm;

import java.time.LocalDate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Risk</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.Risk#getKind <em>Kind</em>}</li>
 * <li>{@link pepper.peppermm.Risk#getDescription <em>Description</em>}</li>
 * <li>{@link pepper.peppermm.Risk#getCriticity <em>Criticity</em>}</li>
 * <li>{@link pepper.peppermm.Risk#getAction <em>Action</em>}</li>
 * <li>{@link pepper.peppermm.Risk#getResponsible <em>Responsible</em>}</li>
 * <li>{@link pepper.peppermm.Risk#getOperationDate <em>Operation Date</em>}</li>
 * <li>{@link pepper.peppermm.Risk#getState <em>State</em>}</li>
 * <li>{@link pepper.peppermm.Risk#getWorkpackages <em>Workpackages</em>}</li>
 * </ul>
 *
 * @see pepper.peppermm.PepperPackage#getRisk()
 * @model
 * @generated
 */
public interface Risk extends EObject {
    /**
     * Returns the value of the '<em><b>Kind</b></em>' attribute. The literals are from the enumeration
     * {@link pepper.peppermm.RiskKind}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Kind</em>' attribute.
     * @see pepper.peppermm.RiskKind
     * @see #setKind(RiskKind)
     * @see pepper.peppermm.PepperPackage#getRisk_Kind()
     * @model
     * @generated
     */
    RiskKind getKind();

    /**
     * Sets the value of the '{@link pepper.peppermm.Risk#getKind <em>Kind</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Kind</em>' attribute.
     * @see pepper.peppermm.RiskKind
     * @see #getKind()
     * @generated
     */
    void setKind(RiskKind value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see pepper.peppermm.PepperPackage#getRisk_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link pepper.peppermm.Risk#getDescription <em>Description</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Criticity</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Criticity</em>' attribute.
     * @see #setCriticity(Integer)
     * @see pepper.peppermm.PepperPackage#getRisk_Criticity()
     * @model
     * @generated
     */
    Integer getCriticity();

    /**
     * Sets the value of the '{@link pepper.peppermm.Risk#getCriticity <em>Criticity</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Criticity</em>' attribute.
     * @see #getCriticity()
     * @generated
     */
    void setCriticity(Integer value);

    /**
     * Returns the value of the '<em><b>Action</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Action</em>' attribute.
     * @see #setAction(String)
     * @see pepper.peppermm.PepperPackage#getRisk_Action()
     * @model
     * @generated
     */
    String getAction();

    /**
     * Sets the value of the '{@link pepper.peppermm.Risk#getAction <em>Action</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Action</em>' attribute.
     * @see #getAction()
     * @generated
     */
    void setAction(String value);

    /**
     * Returns the value of the '<em><b>Responsible</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Responsible</em>' reference.
     * @see #setResponsible(Person)
     * @see pepper.peppermm.PepperPackage#getRisk_Responsible()
     * @model
     * @generated
     */
    Person getResponsible();

    /**
     * Sets the value of the '{@link pepper.peppermm.Risk#getResponsible <em>Responsible</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Responsible</em>' reference.
     * @see #getResponsible()
     * @generated
     */
    void setResponsible(Person value);

    /**
     * Returns the value of the '<em><b>Operation Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Operation Date</em>' attribute.
     * @see #setOperationDate(LocalDate)
     * @see pepper.peppermm.PepperPackage#getRisk_OperationDate()
     * @model dataType="pepper.peppermm.Date"
     * @generated
     */
    LocalDate getOperationDate();

    /**
     * Sets the value of the '{@link pepper.peppermm.Risk#getOperationDate <em>Operation Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Operation Date</em>' attribute.
     * @see #getOperationDate()
     * @generated
     */
    void setOperationDate(LocalDate value);

    /**
     * Returns the value of the '<em><b>State</b></em>' attribute. The literals are from the enumeration
     * {@link pepper.peppermm.RiskState}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>State</em>' attribute.
     * @see pepper.peppermm.RiskState
     * @see #setState(RiskState)
     * @see pepper.peppermm.PepperPackage#getRisk_State()
     * @model
     * @generated
     */
    RiskState getState();

    /**
     * Sets the value of the '{@link pepper.peppermm.Risk#getState <em>State</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>State</em>' attribute.
     * @see pepper.peppermm.RiskState
     * @see #getState()
     * @generated
     */
    void setState(RiskState value);

    /**
     * Returns the value of the '<em><b>Workpackages</b></em>' reference list. The list contents are of type
     * {@link pepper.peppermm.Workpackage}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Workpackages</em>' reference list.
     * @see pepper.peppermm.PepperPackage#getRisk_Workpackages()
     * @model
     * @generated
     */
    EList<Workpackage> getWorkpackages();

} // Risk

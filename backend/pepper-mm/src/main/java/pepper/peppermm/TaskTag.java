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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Task Tag</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link TaskTag#getPrefix <em>Prefix</em>}</li>
 * <li>{@link TaskTag#getSuffix <em>Suffix</em>}</li>
 * </ul>
 *
 * @see PepperPackage#getTaskTag()
 * @model
 * @generated
 */
public interface TaskTag extends EObject {
    /**
     * Returns the value of the '<em><b>Prefix</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Prefix</em>' attribute.
     * @see #setPrefix(String)
     * @see PepperPackage#getTaskTag_Prefix()
     * @model
     * @generated
     */
    String getPrefix();

    /**
     * Sets the value of the '{@link TaskTag#getPrefix <em>Prefix</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix(String value);

    /**
     * Returns the value of the '<em><b>Suffix</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Suffix</em>' attribute.
     * @see #setSuffix(String)
     * @see PepperPackage#getTaskTag_Suffix()
     * @model
     * @generated
     */
    String getSuffix();

    /**
     * Sets the value of the '{@link TaskTag#getSuffix <em>Suffix</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Suffix</em>' attribute.
     * @see #getSuffix()
     * @generated
     */
    void setSuffix(String value);

} // TaskTag

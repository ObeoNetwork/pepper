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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Person</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.Person#getAlias <em>Alias</em>}</li>
 * <li>{@link pepper.peppermm.Person#getBiography <em>Biography</em>}</li>
 * <li>{@link pepper.peppermm.Person#getImageUrl <em>Image Url</em>}</li>
 * </ul>
 *
 * @see pepper.peppermm.PepperPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends Resource {
    /**
     * Returns the value of the '<em><b>Alias</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Alias</em>' attribute.
     * @see #setAlias(String)
     * @see pepper.peppermm.PepperPackage#getPerson_Alias()
     * @model
     * @generated
     */
    String getAlias();

    /**
     * Sets the value of the '{@link pepper.peppermm.Person#getAlias <em>Alias</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Alias</em>' attribute.
     * @see #getAlias()
     * @generated
     */
    void setAlias(String value);

    /**
     * Returns the value of the '<em><b>Biography</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Biography</em>' attribute.
     * @see #setBiography(String)
     * @see pepper.peppermm.PepperPackage#getPerson_Biography()
     * @model
     * @generated
     */
    String getBiography();

    /**
     * Sets the value of the '{@link pepper.peppermm.Person#getBiography <em>Biography</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Biography</em>' attribute.
     * @see #getBiography()
     * @generated
     */
    void setBiography(String value);

    /**
     * Returns the value of the '<em><b>Image Url</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Image Url</em>' attribute.
     * @see #setImageUrl(String)
     * @see pepper.peppermm.PepperPackage#getPerson_ImageUrl()
     * @model
     * @generated
     */
    String getImageUrl();

    /**
     * Sets the value of the '{@link pepper.peppermm.Person#getImageUrl <em>Image Url</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Image Url</em>' attribute.
     * @see #getImageUrl()
     * @generated
     */
    void setImageUrl(String value);

} // Person

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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Organization</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.Organization#getName <em>Name</em>}</li>
 * <li>{@link pepper.peppermm.Organization#getOwnedProjects <em>Owned Projects</em>}</li>
 * <li>{@link pepper.peppermm.Organization#getOwnedResourceFolders <em>Owned Resource Folders</em>}</li>
 * </ul>
 *
 * @see pepper.peppermm.PepperPackage#getOrganization()
 * @model
 * @generated
 */
public interface Organization extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see pepper.peppermm.PepperPackage#getOrganization_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link pepper.peppermm.Organization#getName <em>Name</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Owned Projects</b></em>' containment reference list. The list contents are of
     * type {@link pepper.peppermm.Project}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Projects</em>' containment reference list.
     * @see pepper.peppermm.PepperPackage#getOrganization_OwnedProjects()
     * @model containment="true"
     * @generated
     */
    EList<Project> getOwnedProjects();

    /**
     * Returns the value of the '<em><b>Owned Resource Folders</b></em>' containment reference list. The list contents
     * are of type {@link pepper.peppermm.ResourceFolder}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Resource Folders</em>' containment reference list.
     * @see pepper.peppermm.PepperPackage#getOrganization_OwnedResourceFolders()
     * @model containment="true"
     * @generated
     */
    EList<ResourceFolder> getOwnedResourceFolders();

} // Organization

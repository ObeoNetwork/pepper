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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tag Folder</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.TagFolder#getName <em>Name</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.TagFolder#getOwnedTags <em>Owned Tags</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.TagFolder#getSubFolders <em>Sub Folders</em>}</li>
 * </ul>
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getTagFolder()
 * @model
 * @generated
 */
public interface TagFolder extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getTagFolder_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.TagFolder#getName <em>Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Owned Tags</b></em>' containment reference list. The list contents are of type
     * {@link fr.cea.deeplab.projectmgmt.TaskTag}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Tags</em>' containment reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getTagFolder_OwnedTags()
     * @model containment="true"
     * @generated
     */
    EList<TaskTag> getOwnedTags();

    /**
     * Returns the value of the '<em><b>Sub Folders</b></em>' containment reference list. The list contents are of type
     * {@link fr.cea.deeplab.projectmgmt.TagFolder}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Sub Folders</em>' containment reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getTagFolder_SubFolders()
     * @model containment="true"
     * @generated
     */
    EList<TagFolder> getSubFolders();

} // TagFolder

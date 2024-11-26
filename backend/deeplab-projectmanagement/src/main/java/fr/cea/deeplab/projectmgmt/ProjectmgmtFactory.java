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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage
 * @generated
 */
public interface ProjectmgmtFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    ProjectmgmtFactory eINSTANCE = fr.cea.deeplab.projectmgmt.impl.ProjectmgmtFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Organization</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Organization</em>'.
     * @generated
     */
    Organization createOrganization();

    /**
     * Returns a new object of class '<em>Resource Folder</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Resource Folder</em>'.
     * @generated
     */
    ResourceFolder createResourceFolder();

    /**
     * Returns a new object of class '<em>Team</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Team</em>'.
     * @generated
     */
    Team createTeam();

    /**
     * Returns a new object of class '<em>Internal Stakeholder</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Internal Stakeholder</em>'.
     * @generated
     */
    InternalStakeholder createInternalStakeholder();

    /**
     * Returns a new object of class '<em>External Stakeholder</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>External Stakeholder</em>'.
     * @generated
     */
    ExternalStakeholder createExternalStakeholder();

    /**
     * Returns a new object of class '<em>Person</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Person</em>'.
     * @generated
     */
    Person createPerson();

    /**
     * Returns a new object of class '<em>Tag Folder</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Tag Folder</em>'.
     * @generated
     */
    TagFolder createTagFolder();

    /**
     * Returns a new object of class '<em>Task Tag</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Task Tag</em>'.
     * @generated
     */
    TaskTag createTaskTag();

    /**
     * Returns a new object of class '<em>Task</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Task</em>'.
     * @generated
     */
    Task createTask();

    /**
     * Returns a new object of class '<em>Objective</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Objective</em>'.
     * @generated
     */
    Objective createObjective();

    /**
     * Returns a new object of class '<em>Key Result</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Key Result</em>'.
     * @generated
     */
    KeyResult createKeyResult();

    /**
     * Returns a new object of class '<em>Project</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Project</em>'.
     * @generated
     */
    Project createProject();

    /**
     * Returns a new object of class '<em>Workpackage</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Workpackage</em>'.
     * @generated
     */
    Workpackage createWorkpackage();

    /**
     * Returns a new object of class '<em>Workpackage Artefact</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Workpackage Artefact</em>'.
     * @generated
     */
    WorkpackageArtefact createWorkpackageArtefact();

    /**
     * Returns a new object of class '<em>Risk</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Risk</em>'.
     * @generated
     */
    Risk createRisk();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    ProjectmgmtPackage getProjectmgmtPackage();

} // ProjectmgmtFactory

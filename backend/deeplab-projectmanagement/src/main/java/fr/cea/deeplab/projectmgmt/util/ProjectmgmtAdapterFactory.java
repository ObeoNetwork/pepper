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
package fr.cea.deeplab.projectmgmt.util;

import fr.cea.deeplab.projectmgmt.AbstractTask;
import fr.cea.deeplab.projectmgmt.ExternalStakeholder;
import fr.cea.deeplab.projectmgmt.InternalStakeholder;
import fr.cea.deeplab.projectmgmt.KeyResult;
import fr.cea.deeplab.projectmgmt.Objective;
import fr.cea.deeplab.projectmgmt.Organization;
import fr.cea.deeplab.projectmgmt.Person;
import fr.cea.deeplab.projectmgmt.Project;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;
import fr.cea.deeplab.projectmgmt.Resource;
import fr.cea.deeplab.projectmgmt.ResourceFolder;
import fr.cea.deeplab.projectmgmt.Risk;
import fr.cea.deeplab.projectmgmt.TagFolder;
import fr.cea.deeplab.projectmgmt.Task;
import fr.cea.deeplab.projectmgmt.TaskTag;
import fr.cea.deeplab.projectmgmt.Team;
import fr.cea.deeplab.projectmgmt.Workpackage;
import fr.cea.deeplab.projectmgmt.WorkpackageArtefact;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage
 * @generated
 */
public class ProjectmgmtAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static ProjectmgmtPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ProjectmgmtAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ProjectmgmtPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This
     * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
     * the model. <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ProjectmgmtSwitch<Adapter> modelSwitch = new ProjectmgmtSwitch<>() {
        @Override
        public Adapter caseOrganization(Organization object) {
            return ProjectmgmtAdapterFactory.this.createOrganizationAdapter();
        }

        @Override
        public Adapter caseResource(Resource object) {
            return ProjectmgmtAdapterFactory.this.createResourceAdapter();
        }

        @Override
        public Adapter caseResourceFolder(ResourceFolder object) {
            return ProjectmgmtAdapterFactory.this.createResourceFolderAdapter();
        }

        @Override
        public Adapter caseTeam(Team object) {
            return ProjectmgmtAdapterFactory.this.createTeamAdapter();
        }

        @Override
        public Adapter caseInternalStakeholder(InternalStakeholder object) {
            return ProjectmgmtAdapterFactory.this.createInternalStakeholderAdapter();
        }

        @Override
        public Adapter caseExternalStakeholder(ExternalStakeholder object) {
            return ProjectmgmtAdapterFactory.this.createExternalStakeholderAdapter();
        }

        @Override
        public Adapter casePerson(Person object) {
            return ProjectmgmtAdapterFactory.this.createPersonAdapter();
        }

        @Override
        public Adapter caseAbstractTask(AbstractTask object) {
            return ProjectmgmtAdapterFactory.this.createAbstractTaskAdapter();
        }

        @Override
        public Adapter caseTagFolder(TagFolder object) {
            return ProjectmgmtAdapterFactory.this.createTagFolderAdapter();
        }

        @Override
        public Adapter caseTaskTag(TaskTag object) {
            return ProjectmgmtAdapterFactory.this.createTaskTagAdapter();
        }

        @Override
        public Adapter caseTask(Task object) {
            return ProjectmgmtAdapterFactory.this.createTaskAdapter();
        }

        @Override
        public Adapter caseObjective(Objective object) {
            return ProjectmgmtAdapterFactory.this.createObjectiveAdapter();
        }

        @Override
        public Adapter caseKeyResult(KeyResult object) {
            return ProjectmgmtAdapterFactory.this.createKeyResultAdapter();
        }

        @Override
        public Adapter caseProject(Project object) {
            return ProjectmgmtAdapterFactory.this.createProjectAdapter();
        }

        @Override
        public Adapter caseWorkpackage(Workpackage object) {
            return ProjectmgmtAdapterFactory.this.createWorkpackageAdapter();
        }

        @Override
        public Adapter caseWorkpackageArtefact(WorkpackageArtefact object) {
            return ProjectmgmtAdapterFactory.this.createWorkpackageArtefactAdapter();
        }

        @Override
        public Adapter caseRisk(Risk object) {
            return ProjectmgmtAdapterFactory.this.createRiskAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return ProjectmgmtAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Organization
     * <em>Organization</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Organization
     * @generated
     */
    public Adapter createOrganizationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Resource <em>Resource</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Resource
     * @generated
     */
    public Adapter createResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.ResourceFolder <em>Resource
     * Folder</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.ResourceFolder
     * @generated
     */
    public Adapter createResourceFolderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Team <em>Team</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Team
     * @generated
     */
    public Adapter createTeamAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.InternalStakeholder <em>Internal
     * Stakeholder</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.InternalStakeholder
     * @generated
     */
    public Adapter createInternalStakeholderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.ExternalStakeholder <em>External
     * Stakeholder</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.ExternalStakeholder
     * @generated
     */
    public Adapter createExternalStakeholderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Person <em>Person</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Person
     * @generated
     */
    public Adapter createPersonAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.AbstractTask <em>Abstract
     * Task</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.AbstractTask
     * @generated
     */
    public Adapter createAbstractTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.TagFolder <em>Tag Folder</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.TagFolder
     * @generated
     */
    public Adapter createTagFolderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.TaskTag <em>Task Tag</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.TaskTag
     * @generated
     */
    public Adapter createTaskTagAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Task <em>Task</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Task
     * @generated
     */
    public Adapter createTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Objective <em>Objective</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Objective
     * @generated
     */
    public Adapter createObjectiveAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.KeyResult <em>Key Result</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.KeyResult
     * @generated
     */
    public Adapter createKeyResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Project <em>Project</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Project
     * @generated
     */
    public Adapter createProjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Workpackage
     * <em>Workpackage</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Workpackage
     * @generated
     */
    public Adapter createWorkpackageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact
     * <em>Workpackage Artefact</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
     * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.WorkpackageArtefact
     * @generated
     */
    public Adapter createWorkpackageArtefactAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link fr.cea.deeplab.projectmgmt.Risk <em>Risk</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see fr.cea.deeplab.projectmgmt.Risk
     * @generated
     */
    public Adapter createRiskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // ProjectmgmtAdapterFactory

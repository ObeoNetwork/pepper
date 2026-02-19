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
package pepper.peppermm.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.ExternalStakeholder;
import pepper.peppermm.InternalStakeholder;
import pepper.peppermm.KeyResult;
import pepper.peppermm.Objective;
import pepper.peppermm.Organization;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Project;
import pepper.peppermm.Resource;
import pepper.peppermm.ResourceFolder;
import pepper.peppermm.Risk;
import pepper.peppermm.TagFolder;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTag;
import pepper.peppermm.Team;
import pepper.peppermm.Workpackage;
import pepper.peppermm.WorkpackageArtefact;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 *
 * @see pepper.peppermm.PepperPackage
 * @generated
 */
public class PepperAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static PepperPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PepperAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = PepperPackage.eINSTANCE;
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
    protected PepperSwitch<Adapter> modelSwitch = new PepperSwitch<>() {
        @Override
        public Adapter caseOrganization(Organization object) {
            return PepperAdapterFactory.this.createOrganizationAdapter();
        }

        @Override
        public Adapter caseResource(Resource object) {
            return PepperAdapterFactory.this.createResourceAdapter();
        }

        @Override
        public Adapter caseResourceFolder(ResourceFolder object) {
            return PepperAdapterFactory.this.createResourceFolderAdapter();
        }

        @Override
        public Adapter caseTeam(Team object) {
            return PepperAdapterFactory.this.createTeamAdapter();
        }

        @Override
        public Adapter caseInternalStakeholder(InternalStakeholder object) {
            return PepperAdapterFactory.this.createInternalStakeholderAdapter();
        }

        @Override
        public Adapter caseExternalStakeholder(ExternalStakeholder object) {
            return PepperAdapterFactory.this.createExternalStakeholderAdapter();
        }

        @Override
        public Adapter casePerson(Person object) {
            return PepperAdapterFactory.this.createPersonAdapter();
        }

        @Override
        public Adapter caseAbstractTask(AbstractTask object) {
            return PepperAdapterFactory.this.createAbstractTaskAdapter();
        }

        @Override
        public Adapter caseTagFolder(TagFolder object) {
            return PepperAdapterFactory.this.createTagFolderAdapter();
        }

        @Override
        public Adapter caseTaskTag(TaskTag object) {
            return PepperAdapterFactory.this.createTaskTagAdapter();
        }

        @Override
        public Adapter caseTask(Task object) {
            return PepperAdapterFactory.this.createTaskAdapter();
        }

        @Override
        public Adapter caseObjective(Objective object) {
            return PepperAdapterFactory.this.createObjectiveAdapter();
        }

        @Override
        public Adapter caseKeyResult(KeyResult object) {
            return PepperAdapterFactory.this.createKeyResultAdapter();
        }

        @Override
        public Adapter caseProject(Project object) {
            return PepperAdapterFactory.this.createProjectAdapter();
        }

        @Override
        public Adapter caseWorkpackage(Workpackage object) {
            return PepperAdapterFactory.this.createWorkpackageAdapter();
        }

        @Override
        public Adapter caseWorkpackageArtefact(WorkpackageArtefact object) {
            return PepperAdapterFactory.this.createWorkpackageArtefactAdapter();
        }

        @Override
        public Adapter caseRisk(Risk object) {
            return PepperAdapterFactory.this.createRiskAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return PepperAdapterFactory.this.createEObjectAdapter();
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
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Organization <em>Organization</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Organization
     * @generated
     */
    public Adapter createOrganizationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Resource <em>Resource</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Resource
     * @generated
     */
    public Adapter createResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.ResourceFolder <em>Resource Folder</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.ResourceFolder
     * @generated
     */
    public Adapter createResourceFolderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Team <em>Team</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Team
     * @generated
     */
    public Adapter createTeamAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.InternalStakeholder <em>Internal
     * Stakeholder</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.InternalStakeholder
     * @generated
     */
    public Adapter createInternalStakeholderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.ExternalStakeholder <em>External
     * Stakeholder</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.ExternalStakeholder
     * @generated
     */
    public Adapter createExternalStakeholderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Person <em>Person</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Person
     * @generated
     */
    public Adapter createPersonAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.AbstractTask <em>Abstract Task</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.AbstractTask
     * @generated
     */
    public Adapter createAbstractTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.TagFolder <em>Tag Folder</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.TagFolder
     * @generated
     */
    public Adapter createTagFolderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.TaskTag <em>Task Tag</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.TaskTag
     * @generated
     */
    public Adapter createTaskTagAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Task <em>Task</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Task
     * @generated
     */
    public Adapter createTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Objective <em>Objective</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Objective
     * @generated
     */
    public Adapter createObjectiveAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.KeyResult <em>Key Result</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.KeyResult
     * @generated
     */
    public Adapter createKeyResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Project <em>Project</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Project
     * @generated
     */
    public Adapter createProjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Workpackage <em>Workpackage</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Workpackage
     * @generated
     */
    public Adapter createWorkpackageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.WorkpackageArtefact <em>Workpackage
     * Artefact</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.WorkpackageArtefact
     * @generated
     */
    public Adapter createWorkpackageArtefactAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link pepper.peppermm.Risk <em>Risk</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see pepper.peppermm.Risk
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

} // PepperAdapterFactory

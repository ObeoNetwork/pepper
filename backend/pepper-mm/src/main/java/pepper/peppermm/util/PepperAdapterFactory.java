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

import pepper.peppermm.*;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see PepperPackage
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
    protected PepperSwitch<Adapter> modelSwitch = new PepperSwitch<Adapter>() {
        @Override
        public Adapter caseOrganization(Organization object) {
            return createOrganizationAdapter();
        }

        @Override
        public Adapter caseResource(Resource object) {
            return createResourceAdapter();
        }

        @Override
        public Adapter caseResourceFolder(ResourceFolder object) {
            return createResourceFolderAdapter();
        }

        @Override
        public Adapter caseTeam(Team object) {
            return createTeamAdapter();
        }

        @Override
        public Adapter caseInternalStakeholder(InternalStakeholder object) {
            return createInternalStakeholderAdapter();
        }

        @Override
        public Adapter caseExternalStakeholder(ExternalStakeholder object) {
            return createExternalStakeholderAdapter();
        }

        @Override
        public Adapter casePerson(Person object) {
            return createPersonAdapter();
        }

        @Override
        public Adapter caseAbstractTask(AbstractTask object) {
            return createAbstractTaskAdapter();
        }

        @Override
        public Adapter caseTagFolder(TagFolder object) {
            return createTagFolderAdapter();
        }

        @Override
        public Adapter caseTaskTag(TaskTag object) {
            return createTaskTagAdapter();
        }

        @Override
        public Adapter caseTask(Task object) {
            return createTaskAdapter();
        }

        @Override
        public Adapter caseObjective(Objective object) {
            return createObjectiveAdapter();
        }

        @Override
        public Adapter caseKeyResult(KeyResult object) {
            return createKeyResultAdapter();
        }

        @Override
        public Adapter caseProject(Project object) {
            return createProjectAdapter();
        }

        @Override
        public Adapter caseWorkpackage(Workpackage object) {
            return createWorkpackageAdapter();
        }

        @Override
        public Adapter caseWorkpackageArtefact(WorkpackageArtefact object) {
            return createWorkpackageArtefactAdapter();
        }

        @Override
        public Adapter caseRisk(Risk object) {
            return createRiskAdapter();
        }

        @Override
        public Adapter caseDependencyLink(DependencyLink object) {
            return createDependencyLinkAdapter();
        }

        @Override
        public Adapter caseDependencyRelatedObject(DependencyRelatedObject object) {
            return createDependencyRelatedObjectAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
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
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link Organization <em>Organization</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Organization
     * @generated
     */
    public Adapter createOrganizationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link Resource <em>Resource</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Resource
     * @generated
     */
    public Adapter createResourceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link ResourceFolder <em>Resource Folder</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see ResourceFolder
     * @generated
     */
    public Adapter createResourceFolderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link Team <em>Team</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Team
     * @generated
     */
    public Adapter createTeamAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link InternalStakeholder <em>Internal
     * Stakeholder</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see InternalStakeholder
     * @generated
     */
    public Adapter createInternalStakeholderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link ExternalStakeholder <em>External
     * Stakeholder</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see ExternalStakeholder
     * @generated
     */
    public Adapter createExternalStakeholderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link Person <em>Person</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Person
     * @generated
     */
    public Adapter createPersonAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link AbstractTask <em>Abstract Task</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see AbstractTask
     * @generated
     */
    public Adapter createAbstractTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link TagFolder <em>Tag Folder</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see TagFolder
     * @generated
     */
    public Adapter createTagFolderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link TaskTag <em>Task Tag</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see TaskTag
     * @generated
     */
    public Adapter createTaskTagAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link Task <em>Task</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Task
     * @generated
     */
    public Adapter createTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link Objective <em>Objective</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Objective
     * @generated
     */
    public Adapter createObjectiveAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link KeyResult <em>Key Result</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see KeyResult
     * @generated
     */
    public Adapter createKeyResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link Project <em>Project</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Project
     * @generated
     */
    public Adapter createProjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link Workpackage <em>Workpackage</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
     * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Workpackage
     * @generated
     */
    public Adapter createWorkpackageAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link WorkpackageArtefact <em>Workpackage
     * Artefact</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see WorkpackageArtefact
     * @generated
     */
    public Adapter createWorkpackageArtefactAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link Risk <em>Risk</em>}'. <!-- begin-user-doc
     * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see Risk
     * @generated
     */
    public Adapter createRiskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link DependencyLink <em>Dependency Link</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
     * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see DependencyLink
     * @generated
     */
    public Adapter createDependencyLinkAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link DependencyRelatedObject <em>Dependency
     * Related Object</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
     * -->
     * 
     * @return the new adapter.
     * @see DependencyRelatedObject
     * @generated
     */
    public Adapter createDependencyRelatedObjectAdapter() {
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

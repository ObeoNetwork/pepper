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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage
 * @generated
 */
public class ProjectmgmtSwitch<T> extends Switch<T> {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static ProjectmgmtPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ProjectmgmtSwitch() {
        if (modelPackage == null) {
            modelPackage = ProjectmgmtPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
     * result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case ProjectmgmtPackage.ORGANIZATION: {
                Organization organization = (Organization) theEObject;
                T result = this.caseOrganization(organization);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.RESOURCE: {
                Resource resource = (Resource) theEObject;
                T result = this.caseResource(resource);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.RESOURCE_FOLDER: {
                ResourceFolder resourceFolder = (ResourceFolder) theEObject;
                T result = this.caseResourceFolder(resourceFolder);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.TEAM: {
                Team team = (Team) theEObject;
                T result = this.caseTeam(team);
                if (result == null)
                    result = this.caseResource(team);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.INTERNAL_STAKEHOLDER: {
                InternalStakeholder internalStakeholder = (InternalStakeholder) theEObject;
                T result = this.caseInternalStakeholder(internalStakeholder);
                if (result == null)
                    result = this.caseResource(internalStakeholder);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.EXTERNAL_STAKEHOLDER: {
                ExternalStakeholder externalStakeholder = (ExternalStakeholder) theEObject;
                T result = this.caseExternalStakeholder(externalStakeholder);
                if (result == null)
                    result = this.caseResource(externalStakeholder);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.PERSON: {
                Person person = (Person) theEObject;
                T result = this.casePerson(person);
                if (result == null)
                    result = this.caseResource(person);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.ABSTRACT_TASK: {
                AbstractTask abstractTask = (AbstractTask) theEObject;
                T result = this.caseAbstractTask(abstractTask);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.TAG_FOLDER: {
                TagFolder tagFolder = (TagFolder) theEObject;
                T result = this.caseTagFolder(tagFolder);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.TASK_TAG: {
                TaskTag taskTag = (TaskTag) theEObject;
                T result = this.caseTaskTag(taskTag);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.TASK: {
                Task task = (Task) theEObject;
                T result = this.caseTask(task);
                if (result == null)
                    result = this.caseAbstractTask(task);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.OBJECTIVE: {
                Objective objective = (Objective) theEObject;
                T result = this.caseObjective(objective);
                if (result == null)
                    result = this.caseAbstractTask(objective);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.KEY_RESULT: {
                KeyResult keyResult = (KeyResult) theEObject;
                T result = this.caseKeyResult(keyResult);
                if (result == null)
                    result = this.caseAbstractTask(keyResult);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.PROJECT: {
                Project project = (Project) theEObject;
                T result = this.caseProject(project);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.WORKPACKAGE: {
                Workpackage workpackage = (Workpackage) theEObject;
                T result = this.caseWorkpackage(workpackage);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT: {
                WorkpackageArtefact workpackageArtefact = (WorkpackageArtefact) theEObject;
                T result = this.caseWorkpackageArtefact(workpackageArtefact);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            case ProjectmgmtPackage.RISK: {
                Risk risk = (Risk) theEObject;
                T result = this.caseRisk(risk);
                if (result == null)
                    result = this.defaultCase(theEObject);
                return result;
            }
            default:
                return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Organization</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Organization</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOrganization(Organization object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResource(Resource object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Folder</em>'. <!-- begin-user-doc
     * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
     * -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Folder</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceFolder(ResourceFolder object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Team</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Team</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTeam(Team object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Internal Stakeholder</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Internal Stakeholder</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInternalStakeholder(InternalStakeholder object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>External Stakeholder</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>External Stakeholder</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalStakeholder(ExternalStakeholder object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Person</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Person</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePerson(Person object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Task</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractTask(AbstractTask object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tag Folder</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tag Folder</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTagFolder(TagFolder object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Task Tag</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Task Tag</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTaskTag(TaskTag object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Task</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTask(Task object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Objective</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Objective</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseObjective(Objective object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Key Result</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Key Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseKeyResult(KeyResult object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Project</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Project</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProject(Project object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Workpackage</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Workpackage</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWorkpackage(Workpackage object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Workpackage Artefact</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Workpackage Artefact</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWorkpackageArtefact(WorkpackageArtefact object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Risk</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Risk</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRisk(Risk object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
     * anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} // ProjectmgmtSwitch

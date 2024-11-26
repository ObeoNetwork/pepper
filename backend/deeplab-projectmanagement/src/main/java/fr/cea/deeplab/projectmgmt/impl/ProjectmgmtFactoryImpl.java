/*******************************************************************************
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
 *******************************************************************************/
package fr.cea.deeplab.projectmgmt.impl;

import fr.cea.deeplab.projectmgmt.ExternalStakeholder;
import fr.cea.deeplab.projectmgmt.InternalStakeholder;
import fr.cea.deeplab.projectmgmt.KeyResult;
import fr.cea.deeplab.projectmgmt.Objective;
import fr.cea.deeplab.projectmgmt.Organization;
import fr.cea.deeplab.projectmgmt.Person;
import fr.cea.deeplab.projectmgmt.Project;
import fr.cea.deeplab.projectmgmt.ProjectState;
import fr.cea.deeplab.projectmgmt.ProjectmgmtFactory;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;
import fr.cea.deeplab.projectmgmt.ResourceFolder;
import fr.cea.deeplab.projectmgmt.Risk;
import fr.cea.deeplab.projectmgmt.RiskKind;
import fr.cea.deeplab.projectmgmt.RiskState;
import fr.cea.deeplab.projectmgmt.TagFolder;
import fr.cea.deeplab.projectmgmt.Task;
import fr.cea.deeplab.projectmgmt.TaskTag;
import fr.cea.deeplab.projectmgmt.Team;
import fr.cea.deeplab.projectmgmt.Workpackage;
import fr.cea.deeplab.projectmgmt.WorkpackageArtefact;
import fr.cea.deeplab.projectmgmt.WorkpackageArtefactNature;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ProjectmgmtFactoryImpl extends EFactoryImpl implements ProjectmgmtFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static ProjectmgmtFactory init() {
        try {
            ProjectmgmtFactory theProjectmgmtFactory = (ProjectmgmtFactory) EPackage.Registry.INSTANCE.getEFactory(ProjectmgmtPackage.eNS_URI);
            if (theProjectmgmtFactory != null) {
                return theProjectmgmtFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ProjectmgmtFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ProjectmgmtFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ProjectmgmtPackage.ORGANIZATION:
                return this.createOrganization();
            case ProjectmgmtPackage.RESOURCE_FOLDER:
                return this.createResourceFolder();
            case ProjectmgmtPackage.TEAM:
                return this.createTeam();
            case ProjectmgmtPackage.INTERNAL_STAKEHOLDER:
                return this.createInternalStakeholder();
            case ProjectmgmtPackage.EXTERNAL_STAKEHOLDER:
                return this.createExternalStakeholder();
            case ProjectmgmtPackage.PERSON:
                return this.createPerson();
            case ProjectmgmtPackage.TAG_FOLDER:
                return this.createTagFolder();
            case ProjectmgmtPackage.TASK_TAG:
                return this.createTaskTag();
            case ProjectmgmtPackage.TASK:
                return this.createTask();
            case ProjectmgmtPackage.OBJECTIVE:
                return this.createObjective();
            case ProjectmgmtPackage.KEY_RESULT:
                return this.createKeyResult();
            case ProjectmgmtPackage.PROJECT:
                return this.createProject();
            case ProjectmgmtPackage.WORKPACKAGE:
                return this.createWorkpackage();
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT:
                return this.createWorkpackageArtefact();
            case ProjectmgmtPackage.RISK:
                return this.createRisk();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT_NATURE:
                return this.createWorkpackageArtefactNatureFromString(eDataType, initialValue);
            case ProjectmgmtPackage.RISK_KIND:
                return this.createRiskKindFromString(eDataType, initialValue);
            case ProjectmgmtPackage.RISK_STATE:
                return this.createRiskStateFromString(eDataType, initialValue);
            case ProjectmgmtPackage.PROJECT_STATE:
                return this.createProjectStateFromString(eDataType, initialValue);
            case ProjectmgmtPackage.INSTANT:
                return this.createInstantFromString(eDataType, initialValue);
            case ProjectmgmtPackage.DATE:
                return this.createDateFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT_NATURE:
                return this.convertWorkpackageArtefactNatureToString(eDataType, instanceValue);
            case ProjectmgmtPackage.RISK_KIND:
                return this.convertRiskKindToString(eDataType, instanceValue);
            case ProjectmgmtPackage.RISK_STATE:
                return this.convertRiskStateToString(eDataType, instanceValue);
            case ProjectmgmtPackage.PROJECT_STATE:
                return this.convertProjectStateToString(eDataType, instanceValue);
            case ProjectmgmtPackage.INSTANT:
                return this.convertInstantToString(eDataType, instanceValue);
            case ProjectmgmtPackage.DATE:
                return this.convertDateToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Organization createOrganization() {
        OrganizationImpl organization = new OrganizationImpl();
        return organization;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceFolder createResourceFolder() {
        ResourceFolderImpl resourceFolder = new ResourceFolderImpl();
        return resourceFolder;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Team createTeam() {
        TeamImpl team = new TeamImpl();
        return team;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InternalStakeholder createInternalStakeholder() {
        InternalStakeholderImpl internalStakeholder = new InternalStakeholderImpl();
        return internalStakeholder;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ExternalStakeholder createExternalStakeholder() {
        ExternalStakeholderImpl externalStakeholder = new ExternalStakeholderImpl();
        return externalStakeholder;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Person createPerson() {
        PersonImpl person = new PersonImpl();
        return person;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public TagFolder createTagFolder() {
        TagFolderImpl tagFolder = new TagFolderImpl();
        return tagFolder;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public TaskTag createTaskTag() {
        TaskTagImpl taskTag = new TaskTagImpl();
        return taskTag;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Task createTask() {
        TaskImpl task = new TaskImpl();
        return task;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Objective createObjective() {
        ObjectiveImpl objective = new ObjectiveImpl();
        return objective;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public KeyResult createKeyResult() {
        KeyResultImpl keyResult = new KeyResultImpl();
        return keyResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Project createProject() {
        ProjectImpl project = new ProjectImpl();
        return project;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Workpackage createWorkpackage() {
        WorkpackageImpl workpackage = new WorkpackageImpl();
        return workpackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public WorkpackageArtefact createWorkpackageArtefact() {
        WorkpackageArtefactImpl workpackageArtefact = new WorkpackageArtefactImpl();
        return workpackageArtefact;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Risk createRisk() {
        RiskImpl risk = new RiskImpl();
        return risk;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public WorkpackageArtefactNature createWorkpackageArtefactNatureFromString(EDataType eDataType, String initialValue) {
        WorkpackageArtefactNature result = WorkpackageArtefactNature.get(initialValue);
//        if (result == null)
//            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public String convertWorkpackageArtefactNatureToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public RiskKind createRiskKindFromString(EDataType eDataType, String initialValue) {
        RiskKind result = RiskKind.get(initialValue);
//        if (result == null)
//            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public String convertRiskKindToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public RiskState createRiskStateFromString(EDataType eDataType, String initialValue) {
        RiskState result = RiskState.get(initialValue);
//        if (result == null)
//            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public String convertRiskStateToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public ProjectState createProjectStateFromString(EDataType eDataType, String initialValue) {
        ProjectState result = ProjectState.get(initialValue);
//        if (result == null)
//            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public String convertProjectStateToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public Instant createInstantFromString(EDataType eDataType, String initialValue) {
        if (initialValue != null) {
            return Instant.parse(initialValue);
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public String convertInstantToString(EDataType eDataType, Object instanceValue) {
        if (instanceValue instanceof Instant instant) {
            return DateTimeFormatter.ISO_INSTANT.format(instant);
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public LocalDate createDateFromString(EDataType eDataType, String initialValue) {
        if (initialValue != null) {
            return LocalDate.parse(initialValue);
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public String convertDateToString(EDataType eDataType, Object instanceValue) {
        if (instanceValue instanceof LocalDate localDate) {
            return DateTimeFormatter.ISO_LOCAL_DATE.format(localDate);
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProjectmgmtPackage getProjectmgmtPackage() {
        return (ProjectmgmtPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ProjectmgmtPackage getPackage() {
        return ProjectmgmtPackage.eINSTANCE;
    }

} // ProjectmgmtFactoryImpl

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
package pepper.peppermm.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import pepper.peppermm.ExternalStakeholder;
import pepper.peppermm.InternalStakeholder;
import pepper.peppermm.KeyResult;
import pepper.peppermm.Objective;
import pepper.peppermm.Organization;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Project;
import pepper.peppermm.ProjectState;
import pepper.peppermm.ResourceFolder;
import pepper.peppermm.Risk;
import pepper.peppermm.RiskKind;
import pepper.peppermm.RiskState;
import pepper.peppermm.TagFolder;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTag;
import pepper.peppermm.Team;
import pepper.peppermm.Workpackage;
import pepper.peppermm.WorkpackageArtefact;
import pepper.peppermm.WorkpackageArtefactNature;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class PepperFactoryImpl extends EFactoryImpl implements PepperFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static PepperFactory init() {
        try {
            PepperFactory thePepperFactory = (PepperFactory) EPackage.Registry.INSTANCE.getEFactory(PepperPackage.eNS_URI);
            if (thePepperFactory != null) {
                return thePepperFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new PepperFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PepperFactoryImpl() {
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
            case PepperPackage.ORGANIZATION:
                return this.createOrganization();
            case PepperPackage.RESOURCE_FOLDER:
                return this.createResourceFolder();
            case PepperPackage.TEAM:
                return this.createTeam();
            case PepperPackage.INTERNAL_STAKEHOLDER:
                return this.createInternalStakeholder();
            case PepperPackage.EXTERNAL_STAKEHOLDER:
                return this.createExternalStakeholder();
            case PepperPackage.PERSON:
                return this.createPerson();
            case PepperPackage.TAG_FOLDER:
                return this.createTagFolder();
            case PepperPackage.TASK_TAG:
                return this.createTaskTag();
            case PepperPackage.TASK:
                return this.createTask();
            case PepperPackage.OBJECTIVE:
                return this.createObjective();
            case PepperPackage.KEY_RESULT:
                return this.createKeyResult();
            case PepperPackage.PROJECT:
                return this.createProject();
            case PepperPackage.WORKPACKAGE:
                return this.createWorkpackage();
            case PepperPackage.WORKPACKAGE_ARTEFACT:
                return this.createWorkpackageArtefact();
            case PepperPackage.RISK:
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
            case PepperPackage.WORKPACKAGE_ARTEFACT_NATURE:
                return this.createWorkpackageArtefactNatureFromString(eDataType, initialValue);
            case PepperPackage.RISK_KIND:
                return this.createRiskKindFromString(eDataType, initialValue);
            case PepperPackage.RISK_STATE:
                return this.createRiskStateFromString(eDataType, initialValue);
            case PepperPackage.PROJECT_STATE:
                return this.createProjectStateFromString(eDataType, initialValue);
            case PepperPackage.INSTANT:
                return this.createInstantFromString(eDataType, initialValue);
            case PepperPackage.DATE:
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
            case PepperPackage.WORKPACKAGE_ARTEFACT_NATURE:
                return this.convertWorkpackageArtefactNatureToString(eDataType, instanceValue);
            case PepperPackage.RISK_KIND:
                return this.convertRiskKindToString(eDataType, instanceValue);
            case PepperPackage.RISK_STATE:
                return this.convertRiskStateToString(eDataType, instanceValue);
            case PepperPackage.PROJECT_STATE:
                return this.convertProjectStateToString(eDataType, instanceValue);
            case PepperPackage.INSTANT:
                return this.convertInstantToString(eDataType, instanceValue);
            case PepperPackage.DATE:
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
    public PepperPackage getPepperPackage() {
        return (PepperPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @deprecated
     * @generated
     */
    @Deprecated
    public static PepperPackage getPackage() {
        return PepperPackage.eINSTANCE;
    }

} // PepperFactoryImpl

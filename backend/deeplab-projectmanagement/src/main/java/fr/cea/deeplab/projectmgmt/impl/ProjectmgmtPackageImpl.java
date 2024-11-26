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
package fr.cea.deeplab.projectmgmt.impl;

import static fr.cea.deeplab.projectmgmt.ProjectmgmtPackage.RESOURCE;

import fr.cea.deeplab.projectmgmt.AbstractTask;
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
import fr.cea.deeplab.projectmgmt.Resource;
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ProjectmgmtPackageImpl extends EPackageImpl implements ProjectmgmtPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass organizationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass resourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass resourceFolderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass teamEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass internalStakeholderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass externalStakeholderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass personEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass abstractTaskEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass tagFolderEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass taskTagEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass taskEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass objectiveEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass keyResultEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass projectEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass workpackageEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass workpackageArtefactEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass riskEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum workpackageArtefactNatureEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum riskKindEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum riskStateEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EEnum projectStateEEnum = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EDataType instantEDataType = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EDataType dateEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
     * EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ProjectmgmtPackageImpl() {
        super(eNS_URI, ProjectmgmtFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link ProjectmgmtPackage#eINSTANCE} when that field is accessed. Clients
     * should not invoke it directly. Instead, they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ProjectmgmtPackage init() {
        if (isInited)
            return (ProjectmgmtPackage) EPackage.Registry.INSTANCE.getEPackage(ProjectmgmtPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredProjectmgmtPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        ProjectmgmtPackageImpl theProjectmgmtPackage = registeredProjectmgmtPackage instanceof ProjectmgmtPackageImpl ? (ProjectmgmtPackageImpl) registeredProjectmgmtPackage
                : new ProjectmgmtPackageImpl();

        isInited = true;

        // Create package meta-data objects
        theProjectmgmtPackage.createPackageContents();

        // Initialize created meta-data
        theProjectmgmtPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theProjectmgmtPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ProjectmgmtPackage.eNS_URI, theProjectmgmtPackage);
        return theProjectmgmtPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getOrganization() {
        return this.organizationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getOrganization_Name() {
        return (EAttribute) this.organizationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getOrganization_OwnedProjects() {
        return (EReference) this.organizationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getOrganization_OwnedResourceFolders() {
        return (EReference) this.organizationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getResource() {
        return this.resourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getResource_Name() {
        return (EAttribute) this.resourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getResourceFolder() {
        return this.resourceFolderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getResourceFolder_Name() {
        return (EAttribute) this.resourceFolderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getResourceFolder_OwnedResources() {
        return (EReference) this.resourceFolderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getResourceFolder_SubFolders() {
        return (EReference) this.resourceFolderEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTeam() {
        return this.teamEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTeam_Members() {
        return (EReference) this.teamEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getInternalStakeholder() {
        return this.internalStakeholderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getExternalStakeholder() {
        return this.externalStakeholderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getExternalStakeholder_Goals() {
        return (EAttribute) this.externalStakeholderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPerson() {
        return this.personEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getPerson_Alias() {
        return (EAttribute) this.personEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getPerson_Biography() {
        return (EAttribute) this.personEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getPerson_ImageUrl() {
        return (EAttribute) this.personEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAbstractTask() {
        return this.abstractTaskEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_Name() {
        return (EAttribute) this.abstractTaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_Description() {
        return (EAttribute) this.abstractTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_StartTime() {
        return (EAttribute) this.abstractTaskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_EndTime() {
        return (EAttribute) this.abstractTaskEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_Progress() {
        return (EAttribute) this.abstractTaskEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_ComputeStartEndDynamically() {
        return (EAttribute) this.abstractTaskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAbstractTask_Tags() {
        return (EReference) this.abstractTaskEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAbstractTask_AssignedPersons() {
        return (EReference) this.abstractTaskEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAbstractTask_AssignedTeams() {
        return (EReference) this.abstractTaskEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAbstractTask_SubTasks() {
        return (EReference) this.abstractTaskEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTagFolder() {
        return this.tagFolderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTagFolder_Name() {
        return (EAttribute) this.tagFolderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTagFolder_OwnedTags() {
        return (EReference) this.tagFolderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTagFolder_SubFolders() {
        return (EReference) this.tagFolderEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTaskTag() {
        return this.taskTagEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTaskTag_Prefix() {
        return (EAttribute) this.taskTagEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTaskTag_Suffix() {
        return (EAttribute) this.taskTagEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTask() {
        return this.taskEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTask_Dependencies() {
        return (EReference) this.taskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getObjective() {
        return this.objectiveEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getObjective_OwnedKeyResults() {
        return (EReference) this.objectiveEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getKeyResult() {
        return this.keyResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getProject() {
        return this.projectEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_Name() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_OwnedWorkpackages() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_OwnedObjectives() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_OwnedTagFolders() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_OwnedRisks() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_Reference() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_Description() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_LeadingUnit() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_ParticipantUnits() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_PlannifiedClientCopilMeetings() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_MainProgramBrick() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_State() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_Clients() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_Partners() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_IsTransverse() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_Leader() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProject_Members() {
        return (EReference) this.projectEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_IsSensitive() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_ContractualStartDate() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_Duration() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_ContractualEndDate() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_EffectiveStartDate() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_EffectiveEndDate() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_ContractTermExtension() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_GlobalCost() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(24);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_FundingRate() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(25);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_Funding() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(26);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_Manpower() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(27);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_EOTP() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(28);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_StatisticOrder() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(29);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_InternalNeed() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(30);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getProject_ClientNeed() {
        return (EAttribute) this.projectEClass.getEStructuralFeatures().get(31);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getWorkpackage() {
        return this.workpackageEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_Name() {
        return (EAttribute) this.workpackageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_Description() {
        return (EAttribute) this.workpackageEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_StartDate() {
        return (EAttribute) this.workpackageEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_EndDate() {
        return (EAttribute) this.workpackageEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getWorkpackage_Leader() {
        return (EReference) this.workpackageEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getWorkpackage_Participants() {
        return (EReference) this.workpackageEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_Effort() {
        return (EAttribute) this.workpackageEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getWorkpackage_Outputs() {
        return (EReference) this.workpackageEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getWorkpackage_OwnedTasks() {
        return (EReference) this.workpackageEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getWorkpackage_OwnedObjectives() {
        return (EReference) this.workpackageEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_Progress() {
        return (EAttribute) this.workpackageEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getWorkpackageArtefact() {
        return this.workpackageArtefactEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_Name() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_Description() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_Nature() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_PlannedDeadline() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_EffectiveDeadLine() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_IsInvoiceTrigger() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_InvoiceAmount() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getWorkpackageArtefact_Responsible() {
        return (EReference) this.workpackageArtefactEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_Version() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_IsObsolete() {
        return (EAttribute) this.workpackageArtefactEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRisk() {
        return this.riskEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRisk_Kind() {
        return (EAttribute) this.riskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRisk_Description() {
        return (EAttribute) this.riskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRisk_Criticity() {
        return (EAttribute) this.riskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRisk_Action() {
        return (EAttribute) this.riskEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRisk_Responsible() {
        return (EReference) this.riskEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRisk_OperationDate() {
        return (EAttribute) this.riskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getRisk_State() {
        return (EAttribute) this.riskEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRisk_Workpackages() {
        return (EReference) this.riskEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getWorkpackageArtefactNature() {
        return this.workpackageArtefactNatureEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getRiskKind() {
        return this.riskKindEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getRiskState() {
        return this.riskStateEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EEnum getProjectState() {
        return this.projectStateEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EDataType getInstant() {
        return this.instantEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EDataType getDate() {
        return this.dateEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProjectmgmtFactory getProjectmgmtFactory() {
        return (ProjectmgmtFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
     * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated)
            return;
        this.isCreated = true;

        // Create classes and their features
        this.organizationEClass = this.createEClass(ORGANIZATION);
        this.createEAttribute(this.organizationEClass, ORGANIZATION__NAME);
        this.createEReference(this.organizationEClass, ORGANIZATION__OWNED_PROJECTS);
        this.createEReference(this.organizationEClass, ORGANIZATION__OWNED_RESOURCE_FOLDERS);

        this.resourceEClass = this.createEClass(RESOURCE);
        this.createEAttribute(this.resourceEClass, RESOURCE__NAME);

        this.resourceFolderEClass = this.createEClass(RESOURCE_FOLDER);
        this.createEAttribute(this.resourceFolderEClass, RESOURCE_FOLDER__NAME);
        this.createEReference(this.resourceFolderEClass, RESOURCE_FOLDER__OWNED_RESOURCES);
        this.createEReference(this.resourceFolderEClass, RESOURCE_FOLDER__SUB_FOLDERS);

        this.teamEClass = this.createEClass(TEAM);
        this.createEReference(this.teamEClass, TEAM__MEMBERS);

        this.internalStakeholderEClass = this.createEClass(INTERNAL_STAKEHOLDER);

        this.externalStakeholderEClass = this.createEClass(EXTERNAL_STAKEHOLDER);
        this.createEAttribute(this.externalStakeholderEClass, EXTERNAL_STAKEHOLDER__GOALS);

        this.personEClass = this.createEClass(PERSON);
        this.createEAttribute(this.personEClass, PERSON__ALIAS);
        this.createEAttribute(this.personEClass, PERSON__BIOGRAPHY);
        this.createEAttribute(this.personEClass, PERSON__IMAGE_URL);

        this.abstractTaskEClass = this.createEClass(ABSTRACT_TASK);
        this.createEAttribute(this.abstractTaskEClass, ABSTRACT_TASK__NAME);
        this.createEAttribute(this.abstractTaskEClass, ABSTRACT_TASK__DESCRIPTION);
        this.createEAttribute(this.abstractTaskEClass, ABSTRACT_TASK__START_TIME);
        this.createEAttribute(this.abstractTaskEClass, ABSTRACT_TASK__END_TIME);
        this.createEAttribute(this.abstractTaskEClass, ABSTRACT_TASK__PROGRESS);
        this.createEAttribute(this.abstractTaskEClass, ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY);
        this.createEReference(this.abstractTaskEClass, ABSTRACT_TASK__TAGS);
        this.createEReference(this.abstractTaskEClass, ABSTRACT_TASK__ASSIGNED_PERSONS);
        this.createEReference(this.abstractTaskEClass, ABSTRACT_TASK__ASSIGNED_TEAMS);
        this.createEReference(this.abstractTaskEClass, ABSTRACT_TASK__SUB_TASKS);

        this.tagFolderEClass = this.createEClass(TAG_FOLDER);
        this.createEAttribute(this.tagFolderEClass, TAG_FOLDER__NAME);
        this.createEReference(this.tagFolderEClass, TAG_FOLDER__OWNED_TAGS);
        this.createEReference(this.tagFolderEClass, TAG_FOLDER__SUB_FOLDERS);

        this.taskTagEClass = this.createEClass(TASK_TAG);
        this.createEAttribute(this.taskTagEClass, TASK_TAG__PREFIX);
        this.createEAttribute(this.taskTagEClass, TASK_TAG__SUFFIX);

        this.taskEClass = this.createEClass(TASK);
        this.createEReference(this.taskEClass, TASK__DEPENDENCIES);

        this.objectiveEClass = this.createEClass(OBJECTIVE);
        this.createEReference(this.objectiveEClass, OBJECTIVE__OWNED_KEY_RESULTS);

        this.keyResultEClass = this.createEClass(KEY_RESULT);

        this.projectEClass = this.createEClass(PROJECT);
        this.createEAttribute(this.projectEClass, PROJECT__NAME);
        this.createEReference(this.projectEClass, PROJECT__OWNED_WORKPACKAGES);
        this.createEReference(this.projectEClass, PROJECT__OWNED_OBJECTIVES);
        this.createEReference(this.projectEClass, PROJECT__OWNED_TAG_FOLDERS);
        this.createEReference(this.projectEClass, PROJECT__OWNED_RISKS);
        this.createEAttribute(this.projectEClass, PROJECT__REFERENCE);
        this.createEAttribute(this.projectEClass, PROJECT__DESCRIPTION);
        this.createEReference(this.projectEClass, PROJECT__LEADING_UNIT);
        this.createEReference(this.projectEClass, PROJECT__PARTICIPANT_UNITS);
        this.createEAttribute(this.projectEClass, PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS);
        this.createEAttribute(this.projectEClass, PROJECT__MAIN_PROGRAM_BRICK);
        this.createEAttribute(this.projectEClass, PROJECT__STATE);
        this.createEReference(this.projectEClass, PROJECT__CLIENTS);
        this.createEReference(this.projectEClass, PROJECT__PARTNERS);
        this.createEAttribute(this.projectEClass, PROJECT__IS_TRANSVERSE);
        this.createEReference(this.projectEClass, PROJECT__LEADER);
        this.createEReference(this.projectEClass, PROJECT__MEMBERS);
        this.createEAttribute(this.projectEClass, PROJECT__IS_SENSITIVE);
        this.createEAttribute(this.projectEClass, PROJECT__CONTRACTUAL_START_DATE);
        this.createEAttribute(this.projectEClass, PROJECT__DURATION);
        this.createEAttribute(this.projectEClass, PROJECT__CONTRACTUAL_END_DATE);
        this.createEAttribute(this.projectEClass, PROJECT__EFFECTIVE_START_DATE);
        this.createEAttribute(this.projectEClass, PROJECT__EFFECTIVE_END_DATE);
        this.createEAttribute(this.projectEClass, PROJECT__CONTRACT_TERM_EXTENSION);
        this.createEAttribute(this.projectEClass, PROJECT__GLOBAL_COST);
        this.createEAttribute(this.projectEClass, PROJECT__FUNDING_RATE);
        this.createEAttribute(this.projectEClass, PROJECT__FUNDING);
        this.createEAttribute(this.projectEClass, PROJECT__MANPOWER);
        this.createEAttribute(this.projectEClass, PROJECT__EOTP);
        this.createEAttribute(this.projectEClass, PROJECT__STATISTIC_ORDER);
        this.createEAttribute(this.projectEClass, PROJECT__INTERNAL_NEED);
        this.createEAttribute(this.projectEClass, PROJECT__CLIENT_NEED);

        this.workpackageEClass = this.createEClass(WORKPACKAGE);
        this.createEAttribute(this.workpackageEClass, WORKPACKAGE__NAME);
        this.createEAttribute(this.workpackageEClass, WORKPACKAGE__DESCRIPTION);
        this.createEAttribute(this.workpackageEClass, WORKPACKAGE__START_DATE);
        this.createEAttribute(this.workpackageEClass, WORKPACKAGE__END_DATE);
        this.createEReference(this.workpackageEClass, WORKPACKAGE__LEADER);
        this.createEReference(this.workpackageEClass, WORKPACKAGE__PARTICIPANTS);
        this.createEAttribute(this.workpackageEClass, WORKPACKAGE__EFFORT);
        this.createEReference(this.workpackageEClass, WORKPACKAGE__OUTPUTS);
        this.createEReference(this.workpackageEClass, WORKPACKAGE__OWNED_TASKS);
        this.createEReference(this.workpackageEClass, WORKPACKAGE__OWNED_OBJECTIVES);
        this.createEAttribute(this.workpackageEClass, WORKPACKAGE__PROGRESS);

        this.workpackageArtefactEClass = this.createEClass(WORKPACKAGE_ARTEFACT);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__NAME);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__DESCRIPTION);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__NATURE);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT);
        this.createEReference(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__RESPONSIBLE);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__VERSION);
        this.createEAttribute(this.workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__IS_OBSOLETE);

        this.riskEClass = this.createEClass(RISK);
        this.createEAttribute(this.riskEClass, RISK__KIND);
        this.createEAttribute(this.riskEClass, RISK__DESCRIPTION);
        this.createEAttribute(this.riskEClass, RISK__CRITICITY);
        this.createEAttribute(this.riskEClass, RISK__ACTION);
        this.createEReference(this.riskEClass, RISK__RESPONSIBLE);
        this.createEAttribute(this.riskEClass, RISK__OPERATION_DATE);
        this.createEAttribute(this.riskEClass, RISK__STATE);
        this.createEReference(this.riskEClass, RISK__WORKPACKAGES);

        // Create enums
        this.workpackageArtefactNatureEEnum = this.createEEnum(WORKPACKAGE_ARTEFACT_NATURE);
        this.riskKindEEnum = this.createEEnum(RISK_KIND);
        this.riskStateEEnum = this.createEEnum(RISK_STATE);
        this.projectStateEEnum = this.createEEnum(PROJECT_STATE);

        // Create data types
        this.instantEDataType = this.createEDataType(INSTANT);
        this.dateEDataType = this.createEDataType(DATE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
     * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized)
            return;
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.teamEClass.getESuperTypes().add(this.getResource());
        this.internalStakeholderEClass.getESuperTypes().add(this.getResource());
        this.externalStakeholderEClass.getESuperTypes().add(this.getResource());
        this.personEClass.getESuperTypes().add(this.getResource());
        this.taskEClass.getESuperTypes().add(this.getAbstractTask());
        this.objectiveEClass.getESuperTypes().add(this.getAbstractTask());
        this.keyResultEClass.getESuperTypes().add(this.getAbstractTask());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.organizationEClass, Organization.class, "Organization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getOrganization_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getOrganization_OwnedProjects(), this.getProject(), null, "ownedProjects", null, 0, -1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getOrganization_OwnedResourceFolders(), this.getResourceFolder(), null, "ownedResourceFolders", null, 0, -1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.resourceEClass, Resource.class, "Resource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getResource_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.resourceFolderEClass, ResourceFolder.class, "ResourceFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getResourceFolder_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, ResourceFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getResourceFolder_OwnedResources(), this.getResource(), null, "ownedResources", null, 0, -1, ResourceFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getResourceFolder_SubFolders(), this.getResourceFolder(), null, "subFolders", null, 0, -1, ResourceFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.teamEClass, Team.class, "Team", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getTeam_Members(), this.getPerson(), null, "members", null, 0, -1, Team.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.internalStakeholderEClass, InternalStakeholder.class, "InternalStakeholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.externalStakeholderEClass, ExternalStakeholder.class, "ExternalStakeholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getExternalStakeholder_Goals(), this.ecorePackage.getEString(), "goals", null, 0, -1, ExternalStakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getPerson_Alias(), this.ecorePackage.getEString(), "alias", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getPerson_Biography(), this.ecorePackage.getEString(), "biography", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getPerson_ImageUrl(), this.ecorePackage.getEString(), "imageUrl", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.abstractTaskEClass, AbstractTask.class, "AbstractTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getAbstractTask_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getAbstractTask_Description(), this.ecorePackage.getEString(), "description", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getAbstractTask_StartTime(), this.getInstant(), "startTime", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getAbstractTask_EndTime(), this.getInstant(), "endTime", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getAbstractTask_Progress(), this.ecorePackage.getEInt(), "progress", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getAbstractTask_ComputeStartEndDynamically(), this.ecorePackage.getEBoolean(), "computeStartEndDynamically", "false", 0, 1, AbstractTask.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getAbstractTask_Tags(), this.getTaskTag(), null, "tags", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getAbstractTask_AssignedPersons(), this.getPerson(), null, "assignedPersons", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getAbstractTask_AssignedTeams(), this.getTeam(), null, "assignedTeams", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getAbstractTask_SubTasks(), this.getTask(), null, "subTasks", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.tagFolderEClass, TagFolder.class, "TagFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getTagFolder_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, TagFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getTagFolder_OwnedTags(), this.getTaskTag(), null, "ownedTags", null, 0, -1, TagFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getTagFolder_SubFolders(), this.getTagFolder(), null, "subFolders", null, 0, -1, TagFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.taskTagEClass, TaskTag.class, "TaskTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getTaskTag_Prefix(), this.ecorePackage.getEString(), "prefix", null, 0, 1, TaskTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getTaskTag_Suffix(), this.ecorePackage.getEString(), "suffix", null, 0, 1, TaskTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getTask_Dependencies(), this.getTask(), null, "dependencies", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.objectiveEClass, Objective.class, "Objective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getObjective_OwnedKeyResults(), this.getKeyResult(), null, "ownedKeyResults", null, 0, -1, Objective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.keyResultEClass, KeyResult.class, "KeyResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getProject_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_OwnedWorkpackages(), this.getWorkpackage(), null, "ownedWorkpackages", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_OwnedObjectives(), this.getObjective(), null, "ownedObjectives", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_OwnedTagFolders(), this.getTagFolder(), null, "ownedTagFolders", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_OwnedRisks(), this.getRisk(), null, "ownedRisks", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_Reference(), this.ecorePackage.getEString(), "reference", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_Description(), this.ecorePackage.getEString(), "description", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_LeadingUnit(), this.getInternalStakeholder(), null, "leadingUnit", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_ParticipantUnits(), this.getInternalStakeholder(), null, "participantUnits", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_PlannifiedClientCopilMeetings(), this.ecorePackage.getEBooleanObject(), "plannifiedClientCopilMeetings", null, 0, 1, Project.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_MainProgramBrick(), this.ecorePackage.getEString(), "mainProgramBrick", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_State(), this.getProjectState(), "state", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_Clients(), this.getExternalStakeholder(), null, "clients", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_Partners(), this.getExternalStakeholder(), null, "partners", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_IsTransverse(), this.ecorePackage.getEBooleanObject(), "isTransverse", null, 0, 1, Project.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_Leader(), this.getPerson(), null, "leader", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getProject_Members(), this.getPerson(), null, "members", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_IsSensitive(), this.ecorePackage.getEBooleanObject(), "isSensitive", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_ContractualStartDate(), this.getDate(), "contractualStartDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_Duration(), this.ecorePackage.getEIntegerObject(), "duration", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_ContractualEndDate(), this.getDate(), "contractualEndDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_EffectiveStartDate(), this.getDate(), "effectiveStartDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_EffectiveEndDate(), this.getDate(), "effectiveEndDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_ContractTermExtension(), this.ecorePackage.getEIntegerObject(), "contractTermExtension", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_GlobalCost(), this.ecorePackage.getEDoubleObject(), "globalCost", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_FundingRate(), this.ecorePackage.getEDoubleObject(), "fundingRate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_Funding(), this.ecorePackage.getEDoubleObject(), "funding", null, 0, 1, Project.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_Manpower(), this.ecorePackage.getEIntegerObject(), "manpower", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_EOTP(), this.ecorePackage.getEString(), "eOTP", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_StatisticOrder(), this.ecorePackage.getEString(), "statisticOrder", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_InternalNeed(), this.ecorePackage.getEString(), "internalNeed", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getProject_ClientNeed(), this.ecorePackage.getEString(), "clientNeed", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.workpackageEClass, Workpackage.class, "Workpackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getWorkpackage_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackage_Description(), this.ecorePackage.getEString(), "description", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackage_StartDate(), this.getDate(), "startDate", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackage_EndDate(), this.getDate(), "endDate", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getWorkpackage_Leader(), this.getPerson(), null, "leader", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getWorkpackage_Participants(), this.getPerson(), null, "participants", null, 0, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackage_Effort(), this.ecorePackage.getEIntegerObject(), "effort", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getWorkpackage_Outputs(), this.getWorkpackageArtefact(), null, "outputs", null, 0, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getWorkpackage_OwnedTasks(), this.getTask(), null, "ownedTasks", null, 0, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getWorkpackage_OwnedObjectives(), this.getObjective(), null, "ownedObjectives", null, 0, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackage_Progress(), this.ecorePackage.getEInt(), "progress", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.workpackageArtefactEClass, WorkpackageArtefact.class, "WorkpackageArtefact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getWorkpackageArtefact_Name(), this.ecorePackage.getEString(), "name", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackageArtefact_Description(), this.ecorePackage.getEString(), "description", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackageArtefact_Nature(), this.getWorkpackageArtefactNature(), "nature", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackageArtefact_PlannedDeadline(), this.getDate(), "plannedDeadline", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackageArtefact_EffectiveDeadLine(), this.getDate(), "effectiveDeadLine", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackageArtefact_IsInvoiceTrigger(), this.ecorePackage.getEBooleanObject(), "isInvoiceTrigger", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackageArtefact_InvoiceAmount(), this.ecorePackage.getEIntegerObject(), "invoiceAmount", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getWorkpackageArtefact_Responsible(), this.getPerson(), null, "responsible", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackageArtefact_Version(), this.ecorePackage.getEString(), "version", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getWorkpackageArtefact_IsObsolete(), this.ecorePackage.getEBooleanObject(), "isObsolete", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.riskEClass, Risk.class, "Risk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getRisk_Kind(), this.getRiskKind(), "kind", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        this.initEAttribute(this.getRisk_Description(), this.ecorePackage.getEString(), "description", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getRisk_Criticity(), this.ecorePackage.getEIntegerObject(), "criticity", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getRisk_Action(), this.ecorePackage.getEString(), "action", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getRisk_Responsible(), this.getPerson(), null, "responsible", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getRisk_OperationDate(), this.getDate(), "operationDate", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getRisk_State(), this.getRiskState(), "state", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        this.initEReference(this.getRisk_Workpackages(), this.getWorkpackage(), null, "workpackages", null, 0, -1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        this.initEEnum(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.class, "WorkpackageArtefactNature");
        this.addEEnumLiteral(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.DELIVRABLE);
        this.addEEnumLiteral(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.DECISIONAL);
        this.addEEnumLiteral(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.PROJECT_REVIEW);
        this.addEEnumLiteral(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.ACTION);
        this.addEEnumLiteral(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.INVOICING);
        this.addEEnumLiteral(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.EXPENSE_STATEMENT);
        this.addEEnumLiteral(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.CLIENT_SATISFACTION);
        this.addEEnumLiteral(this.workpackageArtefactNatureEEnum, WorkpackageArtefactNature.OTHER);

        this.initEEnum(this.riskKindEEnum, RiskKind.class, "RiskKind");
        this.addEEnumLiteral(this.riskKindEEnum, RiskKind.MANPOWER);
        this.addEEnumLiteral(this.riskKindEEnum, RiskKind.MACHINE);
        this.addEEnumLiteral(this.riskKindEEnum, RiskKind.MATERIAL);
        this.addEEnumLiteral(this.riskKindEEnum, RiskKind.MEASUREMENT);
        this.addEEnumLiteral(this.riskKindEEnum, RiskKind.METHOD);
        this.addEEnumLiteral(this.riskKindEEnum, RiskKind.MISSION);
        this.addEEnumLiteral(this.riskKindEEnum, RiskKind.MANAGEMENT);
        this.addEEnumLiteral(this.riskKindEEnum, RiskKind.MAINTENANCE);

        this.initEEnum(this.riskStateEEnum, RiskState.class, "RiskState");
        this.addEEnumLiteral(this.riskStateEEnum, RiskState.ON_GOING);
        this.addEEnumLiteral(this.riskStateEEnum, RiskState.UNDER_INSTRUCTION);
        this.addEEnumLiteral(this.riskStateEEnum, RiskState.STOP_BEFORE_TERM);
        this.addEEnumLiteral(this.riskStateEEnum, RiskState.COMPLETED);

        this.initEEnum(this.projectStateEEnum, ProjectState.class, "ProjectState");
        this.addEEnumLiteral(this.projectStateEEnum, ProjectState.ON_GOING);
        this.addEEnumLiteral(this.projectStateEEnum, ProjectState.UNDER_INSTRUCTION);
        this.addEEnumLiteral(this.projectStateEEnum, ProjectState.STOP_BEFORE_TERM);
        this.addEEnumLiteral(this.projectStateEEnum, ProjectState.COMPLETED);

        // Initialize data types
        this.initEDataType(this.instantEDataType, Instant.class, "Instant", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        this.initEDataType(this.dateEDataType, LocalDate.class, "Date", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        this.createResource(eNS_URI);
    }

} // ProjectmgmtPackageImpl

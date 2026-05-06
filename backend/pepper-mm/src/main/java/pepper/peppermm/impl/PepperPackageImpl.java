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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import pepper.peppermm.AbstractTask;
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
import pepper.peppermm.Resource;
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
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PepperPackageImpl extends EPackageImpl implements PepperPackage {
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
     * @see pepper.peppermm.PepperPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PepperPackageImpl() {
        super(eNS_URI, PepperFactory.eINSTANCE);
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
     * This method is used to initialize {@link PepperPackage#eINSTANCE} when that field is accessed. Clients should not
     * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static PepperPackage init() {
        if (isInited)
            return (PepperPackage) EPackage.Registry.INSTANCE.getEPackage(PepperPackage.eNS_URI);

        // Obtain or create and register package
        Object registeredPepperPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        PepperPackageImpl thePepperPackage = registeredPepperPackage instanceof PepperPackageImpl ? (PepperPackageImpl) registeredPepperPackage : new PepperPackageImpl();

        isInited = true;

        // Create package meta-data objects
        thePepperPackage.createPackageContents();

        // Initialize created meta-data
        thePepperPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePepperPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(PepperPackage.eNS_URI, thePepperPackage);
        return thePepperPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getOrganization() {
        return organizationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getOrganization_Name() {
        return (EAttribute) organizationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getOrganization_OwnedProjects() {
        return (EReference) organizationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getOrganization_OwnedResourceFolders() {
        return (EReference) organizationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getResource() {
        return resourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getResource_Name() {
        return (EAttribute) resourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getResourceFolder() {
        return resourceFolderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getResourceFolder_Name() {
        return (EAttribute) resourceFolderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourceFolder_OwnedResources() {
        return (EReference) resourceFolderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourceFolder_SubFolders() {
        return (EReference) resourceFolderEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTeam() {
        return teamEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTeam_Members() {
        return (EReference) teamEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getInternalStakeholder() {
        return internalStakeholderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getExternalStakeholder() {
        return externalStakeholderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getExternalStakeholder_Goals() {
        return (EAttribute) externalStakeholderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPerson() {
        return personEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPerson_Alias() {
        return (EAttribute) personEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPerson_Biography() {
        return (EAttribute) personEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPerson_ImageUrl() {
        return (EAttribute) personEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAbstractTask() {
        return abstractTaskEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_Name() {
        return (EAttribute) abstractTaskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_Description() {
        return (EAttribute) abstractTaskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_StartTime() {
        return (EAttribute) abstractTaskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_EndTime() {
        return (EAttribute) abstractTaskEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_Progress() {
        return (EAttribute) abstractTaskEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAbstractTask_ComputeStartEndDynamically() {
        return (EAttribute) abstractTaskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractTask_Tags() {
        return (EReference) abstractTaskEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractTask_AssignedPersons() {
        return (EReference) abstractTaskEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractTask_AssignedTeams() {
        return (EReference) abstractTaskEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAbstractTask_SubTasks() {
        return (EReference) abstractTaskEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTagFolder() {
        return tagFolderEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTagFolder_Name() {
        return (EAttribute) tagFolderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTagFolder_OwnedTags() {
        return (EReference) tagFolderEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTagFolder_SubFolders() {
        return (EReference) tagFolderEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTaskTag() {
        return taskTagEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTaskTag_Prefix() {
        return (EAttribute) taskTagEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTaskTag_Suffix() {
        return (EAttribute) taskTagEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTask() {
        return taskEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTask_Dependencies() {
        return (EReference) taskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getObjective() {
        return objectiveEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getObjective_OwnedKeyResults() {
        return (EReference) objectiveEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getKeyResult() {
        return keyResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getProject() {
        return projectEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_Name() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_OwnedWorkpackages() {
        return (EReference) projectEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_OwnedObjectives() {
        return (EReference) projectEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_OwnedTagFolders() {
        return (EReference) projectEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_OwnedRisks() {
        return (EReference) projectEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_Reference() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_Description() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_LeadingUnit() {
        return (EReference) projectEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_ParticipantUnits() {
        return (EReference) projectEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_PlannifiedClientCopilMeetings() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_MainProgramBrick() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_State() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_Clients() {
        return (EReference) projectEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_Partners() {
        return (EReference) projectEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_IsTransverse() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_Leader() {
        return (EReference) projectEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProject_Members() {
        return (EReference) projectEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_IsSensitive() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_ContractualStartDate() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_Duration() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(19);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_ContractualEndDate() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(20);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_EffectiveStartDate() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(21);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_EffectiveEndDate() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(22);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_ContractTermExtension() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(23);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_GlobalCost() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(24);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_FundingRate() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(25);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_Funding() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(26);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_Manpower() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(27);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_EOTP() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(28);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_StatisticOrder() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(29);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_InternalNeed() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(30);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProject_ClientNeed() {
        return (EAttribute) projectEClass.getEStructuralFeatures().get(31);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getWorkpackage() {
        return workpackageEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_Name() {
        return (EAttribute) workpackageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_Description() {
        return (EAttribute) workpackageEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_StartDate() {
        return (EAttribute) workpackageEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_EndDate() {
        return (EAttribute) workpackageEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorkpackage_Leader() {
        return (EReference) workpackageEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorkpackage_Participants() {
        return (EReference) workpackageEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_Effort() {
        return (EAttribute) workpackageEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorkpackage_Outputs() {
        return (EReference) workpackageEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorkpackage_OwnedTasks() {
        return (EReference) workpackageEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorkpackage_OwnedObjectives() {
        return (EReference) workpackageEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackage_Progress() {
        return (EAttribute) workpackageEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getWorkpackageArtefact() {
        return workpackageArtefactEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_Name() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_Description() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_Nature() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_PlannedDeadline() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_EffectiveDeadLine() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_IsInvoiceTrigger() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_InvoiceAmount() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getWorkpackageArtefact_Responsible() {
        return (EReference) workpackageArtefactEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_Version() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getWorkpackageArtefact_IsObsolete() {
        return (EAttribute) workpackageArtefactEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRisk() {
        return riskEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRisk_Kind() {
        return (EAttribute) riskEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRisk_Description() {
        return (EAttribute) riskEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRisk_Criticity() {
        return (EAttribute) riskEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRisk_Action() {
        return (EAttribute) riskEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getRisk_Responsible() {
        return (EReference) riskEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRisk_OperationDate() {
        return (EAttribute) riskEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getRisk_State() {
        return (EAttribute) riskEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getRisk_Workpackages() {
        return (EReference) riskEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getWorkpackageArtefactNature() {
        return workpackageArtefactNatureEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getRiskKind() {
        return riskKindEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getRiskState() {
        return riskStateEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getProjectState() {
        return projectStateEEnum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getInstant() {
        return instantEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getDate() {
        return dateEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PepperFactory getPepperFactory() {
        return (PepperFactory) getEFactoryInstance();
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
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        organizationEClass = createEClass(ORGANIZATION);
        createEAttribute(organizationEClass, ORGANIZATION__NAME);
        createEReference(organizationEClass, ORGANIZATION__OWNED_PROJECTS);
        createEReference(organizationEClass, ORGANIZATION__OWNED_RESOURCE_FOLDERS);

        resourceEClass = createEClass(RESOURCE);
        createEAttribute(resourceEClass, RESOURCE__NAME);

        resourceFolderEClass = createEClass(RESOURCE_FOLDER);
        createEAttribute(resourceFolderEClass, RESOURCE_FOLDER__NAME);
        createEReference(resourceFolderEClass, RESOURCE_FOLDER__OWNED_RESOURCES);
        createEReference(resourceFolderEClass, RESOURCE_FOLDER__SUB_FOLDERS);

        teamEClass = createEClass(TEAM);
        createEReference(teamEClass, TEAM__MEMBERS);

        internalStakeholderEClass = createEClass(INTERNAL_STAKEHOLDER);

        externalStakeholderEClass = createEClass(EXTERNAL_STAKEHOLDER);
        createEAttribute(externalStakeholderEClass, EXTERNAL_STAKEHOLDER__GOALS);

        personEClass = createEClass(PERSON);
        createEAttribute(personEClass, PERSON__ALIAS);
        createEAttribute(personEClass, PERSON__BIOGRAPHY);
        createEAttribute(personEClass, PERSON__IMAGE_URL);

        abstractTaskEClass = createEClass(ABSTRACT_TASK);
        createEAttribute(abstractTaskEClass, ABSTRACT_TASK__NAME);
        createEAttribute(abstractTaskEClass, ABSTRACT_TASK__DESCRIPTION);
        createEAttribute(abstractTaskEClass, ABSTRACT_TASK__START_TIME);
        createEAttribute(abstractTaskEClass, ABSTRACT_TASK__END_TIME);
        createEAttribute(abstractTaskEClass, ABSTRACT_TASK__PROGRESS);
        createEAttribute(abstractTaskEClass, ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY);
        createEReference(abstractTaskEClass, ABSTRACT_TASK__TAGS);
        createEReference(abstractTaskEClass, ABSTRACT_TASK__ASSIGNED_PERSONS);
        createEReference(abstractTaskEClass, ABSTRACT_TASK__ASSIGNED_TEAMS);
        createEReference(abstractTaskEClass, ABSTRACT_TASK__SUB_TASKS);

        tagFolderEClass = createEClass(TAG_FOLDER);
        createEAttribute(tagFolderEClass, TAG_FOLDER__NAME);
        createEReference(tagFolderEClass, TAG_FOLDER__OWNED_TAGS);
        createEReference(tagFolderEClass, TAG_FOLDER__SUB_FOLDERS);

        taskTagEClass = createEClass(TASK_TAG);
        createEAttribute(taskTagEClass, TASK_TAG__PREFIX);
        createEAttribute(taskTagEClass, TASK_TAG__SUFFIX);

        taskEClass = createEClass(TASK);
        createEReference(taskEClass, TASK__DEPENDENCIES);

        objectiveEClass = createEClass(OBJECTIVE);
        createEReference(objectiveEClass, OBJECTIVE__OWNED_KEY_RESULTS);

        keyResultEClass = createEClass(KEY_RESULT);

        projectEClass = createEClass(PROJECT);
        createEAttribute(projectEClass, PROJECT__NAME);
        createEReference(projectEClass, PROJECT__OWNED_WORKPACKAGES);
        createEReference(projectEClass, PROJECT__OWNED_OBJECTIVES);
        createEReference(projectEClass, PROJECT__OWNED_TAG_FOLDERS);
        createEReference(projectEClass, PROJECT__OWNED_RISKS);
        createEAttribute(projectEClass, PROJECT__REFERENCE);
        createEAttribute(projectEClass, PROJECT__DESCRIPTION);
        createEReference(projectEClass, PROJECT__LEADING_UNIT);
        createEReference(projectEClass, PROJECT__PARTICIPANT_UNITS);
        createEAttribute(projectEClass, PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS);
        createEAttribute(projectEClass, PROJECT__MAIN_PROGRAM_BRICK);
        createEAttribute(projectEClass, PROJECT__STATE);
        createEReference(projectEClass, PROJECT__CLIENTS);
        createEReference(projectEClass, PROJECT__PARTNERS);
        createEAttribute(projectEClass, PROJECT__IS_TRANSVERSE);
        createEReference(projectEClass, PROJECT__LEADER);
        createEReference(projectEClass, PROJECT__MEMBERS);
        createEAttribute(projectEClass, PROJECT__IS_SENSITIVE);
        createEAttribute(projectEClass, PROJECT__CONTRACTUAL_START_DATE);
        createEAttribute(projectEClass, PROJECT__DURATION);
        createEAttribute(projectEClass, PROJECT__CONTRACTUAL_END_DATE);
        createEAttribute(projectEClass, PROJECT__EFFECTIVE_START_DATE);
        createEAttribute(projectEClass, PROJECT__EFFECTIVE_END_DATE);
        createEAttribute(projectEClass, PROJECT__CONTRACT_TERM_EXTENSION);
        createEAttribute(projectEClass, PROJECT__GLOBAL_COST);
        createEAttribute(projectEClass, PROJECT__FUNDING_RATE);
        createEAttribute(projectEClass, PROJECT__FUNDING);
        createEAttribute(projectEClass, PROJECT__MANPOWER);
        createEAttribute(projectEClass, PROJECT__EOTP);
        createEAttribute(projectEClass, PROJECT__STATISTIC_ORDER);
        createEAttribute(projectEClass, PROJECT__INTERNAL_NEED);
        createEAttribute(projectEClass, PROJECT__CLIENT_NEED);

        workpackageEClass = createEClass(WORKPACKAGE);
        createEAttribute(workpackageEClass, WORKPACKAGE__NAME);
        createEAttribute(workpackageEClass, WORKPACKAGE__DESCRIPTION);
        createEAttribute(workpackageEClass, WORKPACKAGE__START_DATE);
        createEAttribute(workpackageEClass, WORKPACKAGE__END_DATE);
        createEReference(workpackageEClass, WORKPACKAGE__LEADER);
        createEReference(workpackageEClass, WORKPACKAGE__PARTICIPANTS);
        createEAttribute(workpackageEClass, WORKPACKAGE__EFFORT);
        createEReference(workpackageEClass, WORKPACKAGE__OUTPUTS);
        createEReference(workpackageEClass, WORKPACKAGE__OWNED_TASKS);
        createEReference(workpackageEClass, WORKPACKAGE__OWNED_OBJECTIVES);
        createEAttribute(workpackageEClass, WORKPACKAGE__PROGRESS);

        workpackageArtefactEClass = createEClass(WORKPACKAGE_ARTEFACT);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__NAME);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__DESCRIPTION);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__NATURE);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT);
        createEReference(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__RESPONSIBLE);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__VERSION);
        createEAttribute(workpackageArtefactEClass, WORKPACKAGE_ARTEFACT__IS_OBSOLETE);

        riskEClass = createEClass(RISK);
        createEAttribute(riskEClass, RISK__KIND);
        createEAttribute(riskEClass, RISK__DESCRIPTION);
        createEAttribute(riskEClass, RISK__CRITICITY);
        createEAttribute(riskEClass, RISK__ACTION);
        createEReference(riskEClass, RISK__RESPONSIBLE);
        createEAttribute(riskEClass, RISK__OPERATION_DATE);
        createEAttribute(riskEClass, RISK__STATE);
        createEReference(riskEClass, RISK__WORKPACKAGES);

        // Create enums
        workpackageArtefactNatureEEnum = createEEnum(WORKPACKAGE_ARTEFACT_NATURE);
        riskKindEEnum = createEEnum(RISK_KIND);
        riskStateEEnum = createEEnum(RISK_STATE);
        projectStateEEnum = createEEnum(PROJECT_STATE);

        // Create data types
        instantEDataType = createEDataType(INSTANT);
        dateEDataType = createEDataType(DATE);
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
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        teamEClass.getESuperTypes().add(this.getResource());
        internalStakeholderEClass.getESuperTypes().add(this.getResource());
        externalStakeholderEClass.getESuperTypes().add(this.getResource());
        personEClass.getESuperTypes().add(this.getResource());
        taskEClass.getESuperTypes().add(this.getAbstractTask());
        objectiveEClass.getESuperTypes().add(this.getAbstractTask());
        keyResultEClass.getESuperTypes().add(this.getAbstractTask());

        // Initialize classes and features; add operations and parameters
        initEClass(organizationEClass, Organization.class, "Organization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOrganization_Name(), ecorePackage.getEString(), "name", null, 0, 1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getOrganization_OwnedProjects(), this.getProject(), null, "ownedProjects", null, 0, -1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOrganization_OwnedResourceFolders(), this.getResourceFolder(), null, "ownedResourceFolders", null, 0, -1, Organization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(resourceEClass, Resource.class, "Resource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getResource_Name(), ecorePackage.getEString(), "name", null, 0, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        initEClass(resourceFolderEClass, ResourceFolder.class, "ResourceFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getResourceFolder_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResourceFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getResourceFolder_OwnedResources(), this.getResource(), null, "ownedResources", null, 0, -1, ResourceFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResourceFolder_SubFolders(), this.getResourceFolder(), null, "subFolders", null, 0, -1, ResourceFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(teamEClass, Team.class, "Team", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTeam_Members(), this.getPerson(), null, "members", null, 0, -1, Team.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(internalStakeholderEClass, InternalStakeholder.class, "InternalStakeholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(externalStakeholderEClass, ExternalStakeholder.class, "ExternalStakeholder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getExternalStakeholder_Goals(), ecorePackage.getEString(), "goals", null, 0, -1, ExternalStakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPerson_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getPerson_Biography(), ecorePackage.getEString(), "biography", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPerson_ImageUrl(), ecorePackage.getEString(), "imageUrl", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(abstractTaskEClass, AbstractTask.class, "AbstractTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAbstractTask_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractTask_Description(), ecorePackage.getEString(), "description", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractTask_StartTime(), this.getInstant(), "startTime", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractTask_EndTime(), this.getInstant(), "endTime", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractTask_Progress(), ecorePackage.getEInt(), "progress", null, 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractTask_ComputeStartEndDynamically(), ecorePackage.getEBoolean(), "computeStartEndDynamically", "false", 0, 1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractTask_Tags(), this.getTaskTag(), null, "tags", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractTask_AssignedPersons(), this.getPerson(), null, "assignedPersons", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractTask_AssignedTeams(), this.getTeam(), null, "assignedTeams", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAbstractTask_SubTasks(), this.getTask(), null, "subTasks", null, 0, -1, AbstractTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(tagFolderEClass, TagFolder.class, "TagFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTagFolder_Name(), ecorePackage.getEString(), "name", null, 0, 1, TagFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getTagFolder_OwnedTags(), this.getTaskTag(), null, "ownedTags", null, 0, -1, TagFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTagFolder_SubFolders(), this.getTagFolder(), null, "subFolders", null, 0, -1, TagFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(taskTagEClass, TaskTag.class, "TaskTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTaskTag_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, TaskTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getTaskTag_Suffix(), ecorePackage.getEString(), "suffix", null, 0, 1, TaskTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);

        initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTask_Dependencies(), this.getTask(), null, "dependencies", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(objectiveEClass, Objective.class, "Objective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getObjective_OwnedKeyResults(), this.getKeyResult(), null, "ownedKeyResults", null, 0, -1, Objective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(keyResultEClass, KeyResult.class, "KeyResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getProject_OwnedWorkpackages(), this.getWorkpackage(), null, "ownedWorkpackages", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProject_OwnedObjectives(), this.getObjective(), null, "ownedObjectives", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProject_OwnedTagFolders(), this.getTagFolder(), null, "ownedTagFolders", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProject_OwnedRisks(), this.getRisk(), null, "ownedRisks", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Reference(), ecorePackage.getEString(), "reference", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Description(), ecorePackage.getEString(), "description", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getProject_LeadingUnit(), this.getInternalStakeholder(), null, "leadingUnit", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProject_ParticipantUnits(), this.getInternalStakeholder(), null, "participantUnits", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_PlannifiedClientCopilMeetings(), ecorePackage.getEBooleanObject(), "plannifiedClientCopilMeetings", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_MainProgramBrick(), ecorePackage.getEString(), "mainProgramBrick", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_State(), this.getProjectState(), "state", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getProject_Clients(), this.getExternalStakeholder(), null, "clients", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProject_Partners(), this.getExternalStakeholder(), null, "partners", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_IsTransverse(), ecorePackage.getEBooleanObject(), "isTransverse", null, 0, 1, Project.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, IS_DERIVED, IS_ORDERED);
        initEReference(getProject_Leader(), this.getPerson(), null, "leader", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProject_Members(), this.getPerson(), null, "members", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_IsSensitive(), ecorePackage.getEBooleanObject(), "isSensitive", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_ContractualStartDate(), this.getDate(), "contractualStartDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Duration(), ecorePackage.getEIntegerObject(), "duration", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_ContractualEndDate(), this.getDate(), "contractualEndDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_EffectiveStartDate(), this.getDate(), "effectiveStartDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_EffectiveEndDate(), this.getDate(), "effectiveEndDate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_ContractTermExtension(), ecorePackage.getEIntegerObject(), "contractTermExtension", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_GlobalCost(), ecorePackage.getEDoubleObject(), "globalCost", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_FundingRate(), ecorePackage.getEDoubleObject(), "fundingRate", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Funding(), ecorePackage.getEDoubleObject(), "funding", null, 0, 1, Project.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_Manpower(), ecorePackage.getEIntegerObject(), "manpower", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_EOTP(), ecorePackage.getEString(), "eOTP", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getProject_StatisticOrder(), ecorePackage.getEString(), "statisticOrder", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_InternalNeed(), ecorePackage.getEString(), "internalNeed", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getProject_ClientNeed(), ecorePackage.getEString(), "clientNeed", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(workpackageEClass, Workpackage.class, "Workpackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWorkpackage_Name(), ecorePackage.getEString(), "name", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackage_Description(), ecorePackage.getEString(), "description", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackage_StartDate(), this.getDate(), "startDate", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackage_EndDate(), this.getDate(), "endDate", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getWorkpackage_Leader(), this.getPerson(), null, "leader", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWorkpackage_Participants(), this.getPerson(), null, "participants", null, 0, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackage_Effort(), ecorePackage.getEIntegerObject(), "effort", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWorkpackage_Outputs(), this.getWorkpackageArtefact(), null, "outputs", null, 0, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWorkpackage_OwnedTasks(), this.getTask(), null, "ownedTasks", null, 0, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWorkpackage_OwnedObjectives(), this.getObjective(), null, "ownedObjectives", null, 0, -1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackage_Progress(), ecorePackage.getEInt(), "progress", null, 0, 1, Workpackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(workpackageArtefactEClass, WorkpackageArtefact.class, "WorkpackageArtefact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWorkpackageArtefact_Name(), ecorePackage.getEString(), "name", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackageArtefact_Description(), ecorePackage.getEString(), "description", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackageArtefact_Nature(), this.getWorkpackageArtefactNature(), "nature", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackageArtefact_PlannedDeadline(), this.getDate(), "plannedDeadline", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackageArtefact_EffectiveDeadLine(), this.getDate(), "effectiveDeadLine", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackageArtefact_IsInvoiceTrigger(), ecorePackage.getEBooleanObject(), "isInvoiceTrigger", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackageArtefact_InvoiceAmount(), ecorePackage.getEIntegerObject(), "invoiceAmount", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getWorkpackageArtefact_Responsible(), this.getPerson(), null, "responsible", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackageArtefact_Version(), ecorePackage.getEString(), "version", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getWorkpackageArtefact_IsObsolete(), ecorePackage.getEBooleanObject(), "isObsolete", null, 0, 1, WorkpackageArtefact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(riskEClass, Risk.class, "Risk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRisk_Kind(), this.getRiskKind(), "kind", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRisk_Description(), ecorePackage.getEString(), "description", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRisk_Criticity(), ecorePackage.getEIntegerObject(), "criticity", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRisk_Action(), ecorePackage.getEString(), "action", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEReference(getRisk_Responsible(), this.getPerson(), null, "responsible", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getRisk_OperationDate(), this.getDate(), "operationDate", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                IS_ORDERED);
        initEAttribute(getRisk_State(), this.getRiskState(), "state", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getRisk_Workpackages(), this.getWorkpackage(), null, "workpackages", null, 0, -1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.class, "WorkpackageArtefactNature");
        addEEnumLiteral(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.DELIVRABLE);
        addEEnumLiteral(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.DECISIONAL);
        addEEnumLiteral(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.PROJECT_REVIEW);
        addEEnumLiteral(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.ACTION);
        addEEnumLiteral(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.INVOICING);
        addEEnumLiteral(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.EXPENSE_STATEMENT);
        addEEnumLiteral(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.CLIENT_SATISFACTION);
        addEEnumLiteral(workpackageArtefactNatureEEnum, WorkpackageArtefactNature.OTHER);

        initEEnum(riskKindEEnum, RiskKind.class, "RiskKind");
        addEEnumLiteral(riskKindEEnum, RiskKind.MANPOWER);
        addEEnumLiteral(riskKindEEnum, RiskKind.MACHINE);
        addEEnumLiteral(riskKindEEnum, RiskKind.MATERIAL);
        addEEnumLiteral(riskKindEEnum, RiskKind.MEASUREMENT);
        addEEnumLiteral(riskKindEEnum, RiskKind.METHOD);
        addEEnumLiteral(riskKindEEnum, RiskKind.MISSION);
        addEEnumLiteral(riskKindEEnum, RiskKind.MANAGEMENT);
        addEEnumLiteral(riskKindEEnum, RiskKind.MAINTENANCE);

        initEEnum(riskStateEEnum, RiskState.class, "RiskState");
        addEEnumLiteral(riskStateEEnum, RiskState.ON_GOING);
        addEEnumLiteral(riskStateEEnum, RiskState.UNDER_INSTRUCTION);
        addEEnumLiteral(riskStateEEnum, RiskState.STOP_BEFORE_TERM);
        addEEnumLiteral(riskStateEEnum, RiskState.COMPLETED);

        initEEnum(projectStateEEnum, ProjectState.class, "ProjectState");
        addEEnumLiteral(projectStateEEnum, ProjectState.ON_GOING);
        addEEnumLiteral(projectStateEEnum, ProjectState.UNDER_INSTRUCTION);
        addEEnumLiteral(projectStateEEnum, ProjectState.STOP_BEFORE_TERM);
        addEEnumLiteral(projectStateEEnum, ProjectState.COMPLETED);

        // Initialize data types
        initEDataType(instantEDataType, Instant.class, "Instant", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(dateEDataType, LocalDate.class, "Date", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} // PepperPackageImpl

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
import fr.cea.deeplab.projectmgmt.Objective;
import fr.cea.deeplab.projectmgmt.Person;
import fr.cea.deeplab.projectmgmt.Project;
import fr.cea.deeplab.projectmgmt.ProjectState;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;
import fr.cea.deeplab.projectmgmt.Risk;
import fr.cea.deeplab.projectmgmt.TagFolder;
import fr.cea.deeplab.projectmgmt.Workpackage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Project</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getName <em>Name</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getOwnedWorkpackages <em>Owned Workpackages</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getOwnedObjectives <em>Owned Objectives</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getOwnedTagFolders <em>Owned Tag Folders</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getOwnedRisks <em>Owned Risks</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getReference <em>Reference</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getDescription <em>Description</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getLeadingUnit <em>Leading Unit</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getParticipantUnits <em>Participant Units</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getPlannifiedClientCopilMeetings <em>Plannified Client Copil
 * Meetings</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getMainProgramBrick <em>Main Program Brick</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getState <em>State</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getClients <em>Clients</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getPartners <em>Partners</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getIsTransverse <em>Is Transverse</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getLeader <em>Leader</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getMembers <em>Members</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getIsSensitive <em>Is Sensitive</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getContractualStartDate <em>Contractual Start Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getDuration <em>Duration</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getContractualEndDate <em>Contractual End Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getEffectiveStartDate <em>Effective Start Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getEffectiveEndDate <em>Effective End Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getContractTermExtension <em>Contract Term
 * Extension</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getGlobalCost <em>Global Cost</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getFundingRate <em>Funding Rate</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getFunding <em>Funding</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getManpower <em>Manpower</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getEOTP <em>EOTP</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getStatisticOrder <em>Statistic Order</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getInternalNeed <em>Internal Need</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.impl.ProjectImpl#getClientNeed <em>Client Need</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends MinimalEObjectImpl.Container implements Project {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getOwnedWorkpackages() <em>Owned Workpackages</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwnedWorkpackages()
     * @generated
     * @ordered
     */
    protected EList<Workpackage> ownedWorkpackages;

    /**
     * The cached value of the '{@link #getOwnedObjectives() <em>Owned Objectives</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwnedObjectives()
     * @generated
     * @ordered
     */
    protected EList<Objective> ownedObjectives;

    /**
     * The cached value of the '{@link #getOwnedTagFolders() <em>Owned Tag Folders</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwnedTagFolders()
     * @generated
     * @ordered
     */
    protected EList<TagFolder> ownedTagFolders;

    /**
     * The cached value of the '{@link #getOwnedRisks() <em>Owned Risks</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOwnedRisks()
     * @generated
     * @ordered
     */
    protected EList<Risk> ownedRisks;

    /**
     * The default value of the '{@link #getReference() <em>Reference</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getReference()
     * @generated
     * @ordered
     */
    protected static final String REFERENCE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getReference()
     * @generated
     * @ordered
     */
    protected String reference = REFERENCE_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getLeadingUnit() <em>Leading Unit</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getLeadingUnit()
     * @generated
     * @ordered
     */
    protected InternalStakeholder leadingUnit;

    /**
     * The cached value of the '{@link #getParticipantUnits() <em>Participant Units</em>}' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getParticipantUnits()
     * @generated
     * @ordered
     */
    protected EList<InternalStakeholder> participantUnits;

    /**
     * The default value of the '{@link #getPlannifiedClientCopilMeetings() <em>Plannified Client Copil Meetings</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPlannifiedClientCopilMeetings()
     * @generated
     * @ordered
     */
    protected static final Boolean PLANNIFIED_CLIENT_COPIL_MEETINGS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPlannifiedClientCopilMeetings() <em>Plannified Client Copil Meetings</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPlannifiedClientCopilMeetings()
     * @generated
     * @ordered
     */
    protected Boolean plannifiedClientCopilMeetings = PLANNIFIED_CLIENT_COPIL_MEETINGS_EDEFAULT;

    /**
     * The default value of the '{@link #getMainProgramBrick() <em>Main Program Brick</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMainProgramBrick()
     * @generated
     * @ordered
     */
    protected static final String MAIN_PROGRAM_BRICK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMainProgramBrick() <em>Main Program Brick</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMainProgramBrick()
     * @generated
     * @ordered
     */
    protected String mainProgramBrick = MAIN_PROGRAM_BRICK_EDEFAULT;

    /**
     * The default value of the '{@link #getState() <em>State</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getState()
     * @generated NOT
     * @ordered
     */
    protected static final ProjectState STATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getState() <em>State</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getState()
     * @generated
     * @ordered
     */
    protected ProjectState state = STATE_EDEFAULT;

    /**
     * The cached value of the '{@link #getClients() <em>Clients</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getClients()
     * @generated
     * @ordered
     */
    protected EList<ExternalStakeholder> clients;

    /**
     * The cached value of the '{@link #getPartners() <em>Partners</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getPartners()
     * @generated
     * @ordered
     */
    protected EList<ExternalStakeholder> partners;

    /**
     * The default value of the '{@link #getIsTransverse() <em>Is Transverse</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getIsTransverse()
     * @generated
     * @ordered
     */
    protected static final Boolean IS_TRANSVERSE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLeader() <em>Leader</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getLeader()
     * @generated
     * @ordered
     */
    protected Person leader;

    /**
     * The cached value of the '{@link #getMembers() <em>Members</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getMembers()
     * @generated
     * @ordered
     */
    protected EList<Person> members;

    /**
     * The default value of the '{@link #getIsSensitive() <em>Is Sensitive</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getIsSensitive()
     * @generated
     * @ordered
     */
    protected static final Boolean IS_SENSITIVE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIsSensitive() <em>Is Sensitive</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getIsSensitive()
     * @generated
     * @ordered
     */
    protected Boolean isSensitive = IS_SENSITIVE_EDEFAULT;

    /**
     * The default value of the '{@link #getContractualStartDate() <em>Contractual Start Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getContractualStartDate()
     * @generated
     * @ordered
     */
    protected static final LocalDate CONTRACTUAL_START_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContractualStartDate() <em>Contractual Start Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getContractualStartDate()
     * @generated
     * @ordered
     */
    protected LocalDate contractualStartDate = CONTRACTUAL_START_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getDuration()
     * @generated
     * @ordered
     */
    protected static final Integer DURATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getDuration()
     * @generated
     * @ordered
     */
    protected Integer duration = DURATION_EDEFAULT;

    /**
     * The default value of the '{@link #getContractualEndDate() <em>Contractual End Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getContractualEndDate()
     * @generated
     * @ordered
     */
    protected static final LocalDate CONTRACTUAL_END_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContractualEndDate() <em>Contractual End Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getContractualEndDate()
     * @generated
     * @ordered
     */
    protected LocalDate contractualEndDate = CONTRACTUAL_END_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getEffectiveStartDate() <em>Effective Start Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getEffectiveStartDate()
     * @generated
     * @ordered
     */
    protected static final LocalDate EFFECTIVE_START_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEffectiveStartDate() <em>Effective Start Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getEffectiveStartDate()
     * @generated
     * @ordered
     */
    protected LocalDate effectiveStartDate = EFFECTIVE_START_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getEffectiveEndDate() <em>Effective End Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getEffectiveEndDate()
     * @generated
     * @ordered
     */
    protected static final LocalDate EFFECTIVE_END_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEffectiveEndDate() <em>Effective End Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getEffectiveEndDate()
     * @generated
     * @ordered
     */
    protected LocalDate effectiveEndDate = EFFECTIVE_END_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getContractTermExtension() <em>Contract Term Extension</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getContractTermExtension()
     * @generated
     * @ordered
     */
    protected static final Integer CONTRACT_TERM_EXTENSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContractTermExtension() <em>Contract Term Extension</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getContractTermExtension()
     * @generated
     * @ordered
     */
    protected Integer contractTermExtension = CONTRACT_TERM_EXTENSION_EDEFAULT;

    /**
     * The default value of the '{@link #getGlobalCost() <em>Global Cost</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getGlobalCost()
     * @generated
     * @ordered
     */
    protected static final Double GLOBAL_COST_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getGlobalCost() <em>Global Cost</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getGlobalCost()
     * @generated
     * @ordered
     */
    protected Double globalCost = GLOBAL_COST_EDEFAULT;

    /**
     * The default value of the '{@link #getFundingRate() <em>Funding Rate</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getFundingRate()
     * @generated
     * @ordered
     */
    protected static final Double FUNDING_RATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFundingRate() <em>Funding Rate</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getFundingRate()
     * @generated
     * @ordered
     */
    protected Double fundingRate = FUNDING_RATE_EDEFAULT;

    /**
     * The default value of the '{@link #getFunding() <em>Funding</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getFunding()
     * @generated
     * @ordered
     */
    protected static final Double FUNDING_EDEFAULT = null;

    /**
     * The default value of the '{@link #getManpower() <em>Manpower</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getManpower()
     * @generated
     * @ordered
     */
    protected static final Integer MANPOWER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getManpower() <em>Manpower</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getManpower()
     * @generated
     * @ordered
     */
    protected Integer manpower = MANPOWER_EDEFAULT;

    /**
     * The default value of the '{@link #getEOTP() <em>EOTP</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getEOTP()
     * @generated
     * @ordered
     */
    protected static final String EOTP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEOTP() <em>EOTP</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getEOTP()
     * @generated
     * @ordered
     */
    protected String eOTP = EOTP_EDEFAULT;

    /**
     * The default value of the '{@link #getStatisticOrder() <em>Statistic Order</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getStatisticOrder()
     * @generated
     * @ordered
     */
    protected static final String STATISTIC_ORDER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStatisticOrder() <em>Statistic Order</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getStatisticOrder()
     * @generated
     * @ordered
     */
    protected String statisticOrder = STATISTIC_ORDER_EDEFAULT;

    /**
     * The default value of the '{@link #getInternalNeed() <em>Internal Need</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getInternalNeed()
     * @generated
     * @ordered
     */
    protected static final String INTERNAL_NEED_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInternalNeed() <em>Internal Need</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getInternalNeed()
     * @generated
     * @ordered
     */
    protected String internalNeed = INTERNAL_NEED_EDEFAULT;

    /**
     * The default value of the '{@link #getClientNeed() <em>Client Need</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getClientNeed()
     * @generated
     * @ordered
     */
    protected static final String CLIENT_NEED_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getClientNeed() <em>Client Need</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getClientNeed()
     * @generated
     * @ordered
     */
    protected String clientNeed = CLIENT_NEED_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ProjectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ProjectmgmtPackage.Literals.PROJECT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__NAME, oldName, this.name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Workpackage> getOwnedWorkpackages() {
        if (this.ownedWorkpackages == null) {
            this.ownedWorkpackages = new EObjectContainmentEList<>(Workpackage.class, this, ProjectmgmtPackage.PROJECT__OWNED_WORKPACKAGES);
        }
        return this.ownedWorkpackages;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Objective> getOwnedObjectives() {
        if (this.ownedObjectives == null) {
            this.ownedObjectives = new EObjectContainmentEList<>(Objective.class, this, ProjectmgmtPackage.PROJECT__OWNED_OBJECTIVES);
        }
        return this.ownedObjectives;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<TagFolder> getOwnedTagFolders() {
        if (this.ownedTagFolders == null) {
            this.ownedTagFolders = new EObjectContainmentEList<>(TagFolder.class, this, ProjectmgmtPackage.PROJECT__OWNED_TAG_FOLDERS);
        }
        return this.ownedTagFolders;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Risk> getOwnedRisks() {
        if (this.ownedRisks == null) {
            this.ownedRisks = new EObjectContainmentEList<>(Risk.class, this, ProjectmgmtPackage.PROJECT__OWNED_RISKS);
        }
        return this.ownedRisks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getReference() {
        return this.reference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setReference(String newReference) {
        String oldReference = this.reference;
        this.reference = newReference;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__REFERENCE, oldReference, this.reference));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDescription(String newDescription) {
        String oldDescription = this.description;
        this.description = newDescription;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__DESCRIPTION, oldDescription, this.description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InternalStakeholder getLeadingUnit() {
        if (this.leadingUnit != null && this.leadingUnit.eIsProxy()) {
            InternalEObject oldLeadingUnit = (InternalEObject) this.leadingUnit;
            this.leadingUnit = (InternalStakeholder) this.eResolveProxy(oldLeadingUnit);
            if (this.leadingUnit != oldLeadingUnit) {
                if (this.eNotificationRequired())
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectmgmtPackage.PROJECT__LEADING_UNIT, oldLeadingUnit, this.leadingUnit));
            }
        }
        return this.leadingUnit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InternalStakeholder basicGetLeadingUnit() {
        return this.leadingUnit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLeadingUnit(InternalStakeholder newLeadingUnit) {
        InternalStakeholder oldLeadingUnit = this.leadingUnit;
        this.leadingUnit = newLeadingUnit;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__LEADING_UNIT, oldLeadingUnit, this.leadingUnit));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<InternalStakeholder> getParticipantUnits() {
        if (this.participantUnits == null) {
            this.participantUnits = new EObjectResolvingEList<>(InternalStakeholder.class, this, ProjectmgmtPackage.PROJECT__PARTICIPANT_UNITS);
        }
        return this.participantUnits;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Boolean getPlannifiedClientCopilMeetings() {
        return this.plannifiedClientCopilMeetings;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPlannifiedClientCopilMeetings(Boolean newPlannifiedClientCopilMeetings) {
        Boolean oldPlannifiedClientCopilMeetings = this.plannifiedClientCopilMeetings;
        this.plannifiedClientCopilMeetings = newPlannifiedClientCopilMeetings;
        if (this.eNotificationRequired())
            this.eNotify(
                    new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS, oldPlannifiedClientCopilMeetings, this.plannifiedClientCopilMeetings));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getMainProgramBrick() {
        return this.mainProgramBrick;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMainProgramBrick(String newMainProgramBrick) {
        String oldMainProgramBrick = this.mainProgramBrick;
        this.mainProgramBrick = newMainProgramBrick;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__MAIN_PROGRAM_BRICK, oldMainProgramBrick, this.mainProgramBrick));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProjectState getState() {
        return this.state;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setState(ProjectState newState) {
        ProjectState oldState = this.state;
        this.state = newState == null ? STATE_EDEFAULT : newState;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__STATE, oldState, this.state));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ExternalStakeholder> getClients() {
        if (this.clients == null) {
            this.clients = new EObjectResolvingEList<>(ExternalStakeholder.class, this, ProjectmgmtPackage.PROJECT__CLIENTS);
        }
        return this.clients;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ExternalStakeholder> getPartners() {
        if (this.partners == null) {
            this.partners = new EObjectResolvingEList<>(ExternalStakeholder.class, this, ProjectmgmtPackage.PROJECT__PARTNERS);
        }
        return this.partners;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Boolean getIsTransverse() {
        return this.getParticipantUnits().size() > 1;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Person getLeader() {
        if (this.leader != null && this.leader.eIsProxy()) {
            InternalEObject oldLeader = (InternalEObject) this.leader;
            this.leader = (Person) this.eResolveProxy(oldLeader);
            if (this.leader != oldLeader) {
                if (this.eNotificationRequired())
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProjectmgmtPackage.PROJECT__LEADER, oldLeader, this.leader));
            }
        }
        return this.leader;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Person basicGetLeader() {
        return this.leader;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLeader(Person newLeader) {
        Person oldLeader = this.leader;
        this.leader = newLeader;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__LEADER, oldLeader, this.leader));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Person> getMembers() {
        if (this.members == null) {
            this.members = new EObjectResolvingEList<>(Person.class, this, ProjectmgmtPackage.PROJECT__MEMBERS);
        }
        return this.members;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Boolean getIsSensitive() {
        return this.isSensitive;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setIsSensitive(Boolean newIsSensitive) {
        Boolean oldIsSensitive = this.isSensitive;
        this.isSensitive = newIsSensitive;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__IS_SENSITIVE, oldIsSensitive, this.isSensitive));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LocalDate getContractualStartDate() {
        return this.contractualStartDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public void setContractualStartDate(LocalDate newContractualStartDate) {
        LocalDate oldContractualStartDate = this.contractualStartDate;
        this.contractualStartDate = newContractualStartDate;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__CONTRACTUAL_START_DATE, oldContractualStartDate, this.contractualStartDate));

        if (this.contractualStartDate == null) {
            this.setContractualEndDate(null);
        } else if (this.duration != null) {
            this.setDuration(this.duration);
        } else if (this.contractualEndDate != null) {
            this.setContractualEndDate(this.contractualEndDate);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Integer getDuration() {
        return this.duration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public void setDuration(Integer newDuration) {
        Integer oldDuration = this.duration;
        if (newDuration != null && newDuration < 0) {
            this.duration = 0;
        } else {
            this.duration = newDuration;
        }

        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__DURATION, oldDuration, this.duration));

        if (this.duration == null) {
            LocalDate oldContractualEndDate = this.contractualEndDate;
            this.contractualEndDate = null;

            if (this.eNotificationRequired())
                this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__CONTRACTUAL_END_DATE, oldContractualEndDate, this.contractualEndDate));
        } else if (this.contractualStartDate != null) {
            LocalDate oldContractualEndDate = this.contractualEndDate;
            this.contractualEndDate = this.contractualStartDate.plusWeeks(this.duration);

            if (this.eNotificationRequired())
                this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__CONTRACTUAL_END_DATE, oldContractualEndDate, this.contractualEndDate));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LocalDate getContractualEndDate() {
        return this.contractualEndDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public void setContractualEndDate(LocalDate newContractualEndDate) {
        LocalDate oldContractualEndDate = this.contractualEndDate;
        this.contractualEndDate = newContractualEndDate;
        if (this.contractualStartDate != null && this.contractualStartDate.until(newContractualEndDate, ChronoUnit.WEEKS) < 0) {
            this.contractualEndDate = this.contractualStartDate;
        }

        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__CONTRACTUAL_END_DATE, oldContractualEndDate, this.contractualEndDate));

        if (this.contractualEndDate == null) {
            Integer oldDuration = this.duration;
            this.duration = null;

            if (this.eNotificationRequired())
                this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__DURATION, oldDuration, this.duration));
        } else if (this.contractualStartDate != null) {
            Integer oldDuration = this.duration;
            this.duration = Integer.valueOf(Long.valueOf(this.contractualStartDate.until(this.contractualEndDate, ChronoUnit.WEEKS)).intValue());

            if (this.eNotificationRequired())
                this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__DURATION, oldDuration, this.duration));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LocalDate getEffectiveStartDate() {
        return this.effectiveStartDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEffectiveStartDate(LocalDate newEffectiveStartDate) {
        LocalDate oldEffectiveStartDate = this.effectiveStartDate;
        this.effectiveStartDate = newEffectiveStartDate;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__EFFECTIVE_START_DATE, oldEffectiveStartDate, this.effectiveStartDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LocalDate getEffectiveEndDate() {
        return this.effectiveEndDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEffectiveEndDate(LocalDate newEffectiveEndDate) {
        LocalDate oldEffectiveEndDate = this.effectiveEndDate;
        this.effectiveEndDate = newEffectiveEndDate;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__EFFECTIVE_END_DATE, oldEffectiveEndDate, this.effectiveEndDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Integer getContractTermExtension() {
        return this.contractTermExtension;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setContractTermExtension(Integer newContractTermExtension) {
        Integer oldContractTermExtension = this.contractTermExtension;
        this.contractTermExtension = newContractTermExtension;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__CONTRACT_TERM_EXTENSION, oldContractTermExtension, this.contractTermExtension));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Double getGlobalCost() {
        return this.globalCost;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setGlobalCost(Double newGlobalCost) {
        Double oldGlobalCost = this.globalCost;
        this.globalCost = newGlobalCost;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__GLOBAL_COST, oldGlobalCost, this.globalCost));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Double getFundingRate() {
        return this.fundingRate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFundingRate(Double newFundingRate) {
        Double oldFundingRate = this.fundingRate;
        this.fundingRate = newFundingRate;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__FUNDING_RATE, oldFundingRate, this.fundingRate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Double getFunding() {
        if (this.globalCost != null && this.fundingRate != null && this.fundingRate > 0) {
            Double value = this.globalCost * this.fundingRate / 100;
            return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Integer getManpower() {
        return this.manpower;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setManpower(Integer newManpower) {
        Integer oldManpower = this.manpower;
        this.manpower = newManpower;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__MANPOWER, oldManpower, this.manpower));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getEOTP() {
        return this.eOTP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEOTP(String newEOTP) {
        String oldEOTP = this.eOTP;
        this.eOTP = newEOTP;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__EOTP, oldEOTP, this.eOTP));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getStatisticOrder() {
        return this.statisticOrder;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStatisticOrder(String newStatisticOrder) {
        String oldStatisticOrder = this.statisticOrder;
        this.statisticOrder = newStatisticOrder;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__STATISTIC_ORDER, oldStatisticOrder, this.statisticOrder));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getInternalNeed() {
        return this.internalNeed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInternalNeed(String newInternalNeed) {
        String oldInternalNeed = this.internalNeed;
        this.internalNeed = newInternalNeed;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__INTERNAL_NEED, oldInternalNeed, this.internalNeed));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getClientNeed() {
        return this.clientNeed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setClientNeed(String newClientNeed) {
        String oldClientNeed = this.clientNeed;
        this.clientNeed = newClientNeed;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, ProjectmgmtPackage.PROJECT__CLIENT_NEED, oldClientNeed, this.clientNeed));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ProjectmgmtPackage.PROJECT__OWNED_WORKPACKAGES:
                return ((InternalEList<?>) this.getOwnedWorkpackages()).basicRemove(otherEnd, msgs);
            case ProjectmgmtPackage.PROJECT__OWNED_OBJECTIVES:
                return ((InternalEList<?>) this.getOwnedObjectives()).basicRemove(otherEnd, msgs);
            case ProjectmgmtPackage.PROJECT__OWNED_TAG_FOLDERS:
                return ((InternalEList<?>) this.getOwnedTagFolders()).basicRemove(otherEnd, msgs);
            case ProjectmgmtPackage.PROJECT__OWNED_RISKS:
                return ((InternalEList<?>) this.getOwnedRisks()).basicRemove(otherEnd, msgs);
            default:
                return super.eInverseRemove(otherEnd, featureID, msgs);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ProjectmgmtPackage.PROJECT__NAME:
                return this.getName();
            case ProjectmgmtPackage.PROJECT__OWNED_WORKPACKAGES:
                return this.getOwnedWorkpackages();
            case ProjectmgmtPackage.PROJECT__OWNED_OBJECTIVES:
                return this.getOwnedObjectives();
            case ProjectmgmtPackage.PROJECT__OWNED_TAG_FOLDERS:
                return this.getOwnedTagFolders();
            case ProjectmgmtPackage.PROJECT__OWNED_RISKS:
                return this.getOwnedRisks();
            case ProjectmgmtPackage.PROJECT__REFERENCE:
                return this.getReference();
            case ProjectmgmtPackage.PROJECT__DESCRIPTION:
                return this.getDescription();
            case ProjectmgmtPackage.PROJECT__LEADING_UNIT:
                if (resolve)
                    return this.getLeadingUnit();
                return this.basicGetLeadingUnit();
            case ProjectmgmtPackage.PROJECT__PARTICIPANT_UNITS:
                return this.getParticipantUnits();
            case ProjectmgmtPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
                return this.getPlannifiedClientCopilMeetings();
            case ProjectmgmtPackage.PROJECT__MAIN_PROGRAM_BRICK:
                return this.getMainProgramBrick();
            case ProjectmgmtPackage.PROJECT__STATE:
                return this.getState();
            case ProjectmgmtPackage.PROJECT__CLIENTS:
                return this.getClients();
            case ProjectmgmtPackage.PROJECT__PARTNERS:
                return this.getPartners();
            case ProjectmgmtPackage.PROJECT__IS_TRANSVERSE:
                return this.getIsTransverse();
            case ProjectmgmtPackage.PROJECT__LEADER:
                if (resolve)
                    return this.getLeader();
                return this.basicGetLeader();
            case ProjectmgmtPackage.PROJECT__MEMBERS:
                return this.getMembers();
            case ProjectmgmtPackage.PROJECT__IS_SENSITIVE:
                return this.getIsSensitive();
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_START_DATE:
                return this.getContractualStartDate();
            case ProjectmgmtPackage.PROJECT__DURATION:
                return this.getDuration();
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_END_DATE:
                return this.getContractualEndDate();
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_START_DATE:
                return this.getEffectiveStartDate();
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_END_DATE:
                return this.getEffectiveEndDate();
            case ProjectmgmtPackage.PROJECT__CONTRACT_TERM_EXTENSION:
                return this.getContractTermExtension();
            case ProjectmgmtPackage.PROJECT__GLOBAL_COST:
                return this.getGlobalCost();
            case ProjectmgmtPackage.PROJECT__FUNDING_RATE:
                return this.getFundingRate();
            case ProjectmgmtPackage.PROJECT__FUNDING:
                return this.getFunding();
            case ProjectmgmtPackage.PROJECT__MANPOWER:
                return this.getManpower();
            case ProjectmgmtPackage.PROJECT__EOTP:
                return this.getEOTP();
            case ProjectmgmtPackage.PROJECT__STATISTIC_ORDER:
                return this.getStatisticOrder();
            case ProjectmgmtPackage.PROJECT__INTERNAL_NEED:
                return this.getInternalNeed();
            case ProjectmgmtPackage.PROJECT__CLIENT_NEED:
                return this.getClientNeed();
            default:
                return super.eGet(featureID, resolve, coreType);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ProjectmgmtPackage.PROJECT__NAME:
                this.setName((String) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_WORKPACKAGES:
                this.getOwnedWorkpackages().clear();
                this.getOwnedWorkpackages().addAll((Collection<? extends Workpackage>) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_OBJECTIVES:
                this.getOwnedObjectives().clear();
                this.getOwnedObjectives().addAll((Collection<? extends Objective>) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_TAG_FOLDERS:
                this.getOwnedTagFolders().clear();
                this.getOwnedTagFolders().addAll((Collection<? extends TagFolder>) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_RISKS:
                this.getOwnedRisks().clear();
                this.getOwnedRisks().addAll((Collection<? extends Risk>) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__REFERENCE:
                this.setReference((String) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__DESCRIPTION:
                this.setDescription((String) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__LEADING_UNIT:
                this.setLeadingUnit((InternalStakeholder) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__PARTICIPANT_UNITS:
                this.getParticipantUnits().clear();
                this.getParticipantUnits().addAll((Collection<? extends InternalStakeholder>) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
                this.setPlannifiedClientCopilMeetings((Boolean) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__MAIN_PROGRAM_BRICK:
                this.setMainProgramBrick((String) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__STATE:
                this.setState((ProjectState) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__CLIENTS:
                this.getClients().clear();
                this.getClients().addAll((Collection<? extends ExternalStakeholder>) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__PARTNERS:
                this.getPartners().clear();
                this.getPartners().addAll((Collection<? extends ExternalStakeholder>) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__LEADER:
                this.setLeader((Person) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__MEMBERS:
                this.getMembers().clear();
                this.getMembers().addAll((Collection<? extends Person>) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__IS_SENSITIVE:
                this.setIsSensitive((Boolean) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_START_DATE:
                this.setContractualStartDate((LocalDate) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__DURATION:
                this.setDuration((Integer) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_END_DATE:
                this.setContractualEndDate((LocalDate) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_START_DATE:
                this.setEffectiveStartDate((LocalDate) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_END_DATE:
                this.setEffectiveEndDate((LocalDate) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__CONTRACT_TERM_EXTENSION:
                this.setContractTermExtension((Integer) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__GLOBAL_COST:
                this.setGlobalCost((Double) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__FUNDING_RATE:
                this.setFundingRate((Double) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__MANPOWER:
                this.setManpower((Integer) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__EOTP:
                this.setEOTP((String) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__STATISTIC_ORDER:
                this.setStatisticOrder((String) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__INTERNAL_NEED:
                this.setInternalNeed((String) newValue);
                return;
            case ProjectmgmtPackage.PROJECT__CLIENT_NEED:
                this.setClientNeed((String) newValue);
                return;
            default:
                super.eSet(featureID, newValue);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ProjectmgmtPackage.PROJECT__NAME:
                this.setName(NAME_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_WORKPACKAGES:
                this.getOwnedWorkpackages().clear();
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_OBJECTIVES:
                this.getOwnedObjectives().clear();
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_TAG_FOLDERS:
                this.getOwnedTagFolders().clear();
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_RISKS:
                this.getOwnedRisks().clear();
                return;
            case ProjectmgmtPackage.PROJECT__REFERENCE:
                this.setReference(REFERENCE_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__DESCRIPTION:
                this.setDescription(DESCRIPTION_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__LEADING_UNIT:
                this.setLeadingUnit(null);
                return;
            case ProjectmgmtPackage.PROJECT__PARTICIPANT_UNITS:
                this.getParticipantUnits().clear();
                return;
            case ProjectmgmtPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
                this.setPlannifiedClientCopilMeetings(PLANNIFIED_CLIENT_COPIL_MEETINGS_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__MAIN_PROGRAM_BRICK:
                this.setMainProgramBrick(MAIN_PROGRAM_BRICK_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__STATE:
                this.setState(STATE_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__CLIENTS:
                this.getClients().clear();
                return;
            case ProjectmgmtPackage.PROJECT__PARTNERS:
                this.getPartners().clear();
                return;
            case ProjectmgmtPackage.PROJECT__LEADER:
                this.setLeader(null);
                return;
            case ProjectmgmtPackage.PROJECT__MEMBERS:
                this.getMembers().clear();
                return;
            case ProjectmgmtPackage.PROJECT__IS_SENSITIVE:
                this.setIsSensitive(IS_SENSITIVE_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_START_DATE:
                this.setContractualStartDate(CONTRACTUAL_START_DATE_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__DURATION:
                this.setDuration(DURATION_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_END_DATE:
                this.setContractualEndDate(CONTRACTUAL_END_DATE_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_START_DATE:
                this.setEffectiveStartDate(EFFECTIVE_START_DATE_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_END_DATE:
                this.setEffectiveEndDate(EFFECTIVE_END_DATE_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__CONTRACT_TERM_EXTENSION:
                this.setContractTermExtension(CONTRACT_TERM_EXTENSION_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__GLOBAL_COST:
                this.setGlobalCost(GLOBAL_COST_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__FUNDING_RATE:
                this.setFundingRate(FUNDING_RATE_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__MANPOWER:
                this.setManpower(MANPOWER_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__EOTP:
                this.setEOTP(EOTP_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__STATISTIC_ORDER:
                this.setStatisticOrder(STATISTIC_ORDER_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__INTERNAL_NEED:
                this.setInternalNeed(INTERNAL_NEED_EDEFAULT);
                return;
            case ProjectmgmtPackage.PROJECT__CLIENT_NEED:
                this.setClientNeed(CLIENT_NEED_EDEFAULT);
                return;
            default:
                super.eUnset(featureID);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ProjectmgmtPackage.PROJECT__NAME:
                return !Objects.equals(NAME_EDEFAULT, this.name);
            case ProjectmgmtPackage.PROJECT__OWNED_WORKPACKAGES:
                return this.ownedWorkpackages != null && !this.ownedWorkpackages.isEmpty();
            case ProjectmgmtPackage.PROJECT__OWNED_OBJECTIVES:
                return this.ownedObjectives != null && !this.ownedObjectives.isEmpty();
            case ProjectmgmtPackage.PROJECT__OWNED_TAG_FOLDERS:
                return this.ownedTagFolders != null && !this.ownedTagFolders.isEmpty();
            case ProjectmgmtPackage.PROJECT__OWNED_RISKS:
                return this.ownedRisks != null && !this.ownedRisks.isEmpty();
            case ProjectmgmtPackage.PROJECT__REFERENCE:
                return !Objects.equals(REFERENCE_EDEFAULT, this.reference);
            case ProjectmgmtPackage.PROJECT__DESCRIPTION:
                return !Objects.equals(DESCRIPTION_EDEFAULT, this.description);
            case ProjectmgmtPackage.PROJECT__LEADING_UNIT:
                return this.leadingUnit != null;
            case ProjectmgmtPackage.PROJECT__PARTICIPANT_UNITS:
                return this.participantUnits != null && !this.participantUnits.isEmpty();
            case ProjectmgmtPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
                return !Objects.equals(PLANNIFIED_CLIENT_COPIL_MEETINGS_EDEFAULT, this.plannifiedClientCopilMeetings);
            case ProjectmgmtPackage.PROJECT__MAIN_PROGRAM_BRICK:
                return !Objects.equals(MAIN_PROGRAM_BRICK_EDEFAULT, this.mainProgramBrick);
            case ProjectmgmtPackage.PROJECT__STATE:
                return this.state != STATE_EDEFAULT;
            case ProjectmgmtPackage.PROJECT__CLIENTS:
                return this.clients != null && !this.clients.isEmpty();
            case ProjectmgmtPackage.PROJECT__PARTNERS:
                return this.partners != null && !this.partners.isEmpty();
            case ProjectmgmtPackage.PROJECT__IS_TRANSVERSE:
                return IS_TRANSVERSE_EDEFAULT == null ? this.getIsTransverse() != null : !IS_TRANSVERSE_EDEFAULT.equals(this.getIsTransverse());
            case ProjectmgmtPackage.PROJECT__LEADER:
                return this.leader != null;
            case ProjectmgmtPackage.PROJECT__MEMBERS:
                return this.members != null && !this.members.isEmpty();
            case ProjectmgmtPackage.PROJECT__IS_SENSITIVE:
                return !Objects.equals(IS_SENSITIVE_EDEFAULT, this.isSensitive);
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_START_DATE:
                return !Objects.equals(CONTRACTUAL_START_DATE_EDEFAULT, this.contractualStartDate);
            case ProjectmgmtPackage.PROJECT__DURATION:
                return !Objects.equals(DURATION_EDEFAULT, this.duration);
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_END_DATE:
                return !Objects.equals(CONTRACTUAL_END_DATE_EDEFAULT, this.contractualEndDate);
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_START_DATE:
                return !Objects.equals(EFFECTIVE_START_DATE_EDEFAULT, this.effectiveStartDate);
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_END_DATE:
                return !Objects.equals(EFFECTIVE_END_DATE_EDEFAULT, this.effectiveEndDate);
            case ProjectmgmtPackage.PROJECT__CONTRACT_TERM_EXTENSION:
                return !Objects.equals(CONTRACT_TERM_EXTENSION_EDEFAULT, this.contractTermExtension);
            case ProjectmgmtPackage.PROJECT__GLOBAL_COST:
                return !Objects.equals(GLOBAL_COST_EDEFAULT, this.globalCost);
            case ProjectmgmtPackage.PROJECT__FUNDING_RATE:
                return !Objects.equals(FUNDING_RATE_EDEFAULT, this.fundingRate);
            case ProjectmgmtPackage.PROJECT__FUNDING:
                return FUNDING_EDEFAULT == null ? this.getFunding() != null : !FUNDING_EDEFAULT.equals(this.getFunding());
            case ProjectmgmtPackage.PROJECT__MANPOWER:
                return !Objects.equals(MANPOWER_EDEFAULT, this.manpower);
            case ProjectmgmtPackage.PROJECT__EOTP:
                return !Objects.equals(EOTP_EDEFAULT, this.eOTP);
            case ProjectmgmtPackage.PROJECT__STATISTIC_ORDER:
                return !Objects.equals(STATISTIC_ORDER_EDEFAULT, this.statisticOrder);
            case ProjectmgmtPackage.PROJECT__INTERNAL_NEED:
                return !Objects.equals(INTERNAL_NEED_EDEFAULT, this.internalNeed);
            case ProjectmgmtPackage.PROJECT__CLIENT_NEED:
                return !Objects.equals(CLIENT_NEED_EDEFAULT, this.clientNeed);
            default:
                return super.eIsSet(featureID);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy())
            return super.toString();

        String result = super.toString() + " (name: "
                + this.name
                + ", reference: "
                + this.reference
                + ", description: "
                + this.description
                + ", plannifiedClientCopilMeetings: "
                + this.plannifiedClientCopilMeetings
                + ", mainProgramBrick: "
                + this.mainProgramBrick
                + ", state: "
                + this.state
                + ", isSensitive: "
                + this.isSensitive
                + ", contractualStartDate: "
                + this.contractualStartDate
                + ", duration: "
                + this.duration
                + ", contractualEndDate: "
                + this.contractualEndDate
                + ", effectiveStartDate: "
                + this.effectiveStartDate
                + ", effectiveEndDate: "
                + this.effectiveEndDate
                + ", contractTermExtension: "
                + this.contractTermExtension
                + ", globalCost: "
                + this.globalCost
                + ", fundingRate: "
                + this.fundingRate
                + ", manpower: "
                + this.manpower
                + ", eOTP: "
                + this.eOTP
                + ", statisticOrder: "
                + this.statisticOrder
                + ", internalNeed: "
                + this.internalNeed
                + ", clientNeed: "
                + this.clientNeed
                + ')';
        return result;
    }

} // ProjectImpl

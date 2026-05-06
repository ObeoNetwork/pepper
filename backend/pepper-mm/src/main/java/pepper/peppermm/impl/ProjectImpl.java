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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import java.util.Collection;

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

import pepper.peppermm.ExternalStakeholder;
import pepper.peppermm.InternalStakeholder;
import pepper.peppermm.Objective;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Project;
import pepper.peppermm.ProjectState;
import pepper.peppermm.Risk;
import pepper.peppermm.TagFolder;
import pepper.peppermm.Workpackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Project</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getName <em>Name</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getOwnedWorkpackages <em>Owned Workpackages</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getOwnedObjectives <em>Owned Objectives</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getOwnedTagFolders <em>Owned Tag Folders</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getOwnedRisks <em>Owned Risks</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getReference <em>Reference</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getDescription <em>Description</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getLeadingUnit <em>Leading Unit</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getParticipantUnits <em>Participant Units</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getPlannifiedClientCopilMeetings <em>Plannified Client Copil
 * Meetings</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getMainProgramBrick <em>Main Program Brick</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getState <em>State</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getClients <em>Clients</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getPartners <em>Partners</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getIsTransverse <em>Is Transverse</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getLeader <em>Leader</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getMembers <em>Members</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getIsSensitive <em>Is Sensitive</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getContractualStartDate <em>Contractual Start Date</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getDuration <em>Duration</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getContractualEndDate <em>Contractual End Date</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getEffectiveStartDate <em>Effective Start Date</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getEffectiveEndDate <em>Effective End Date</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getContractTermExtension <em>Contract Term Extension</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getGlobalCost <em>Global Cost</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getFundingRate <em>Funding Rate</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getFunding <em>Funding</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getManpower <em>Manpower</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getEOTP <em>EOTP</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getStatisticOrder <em>Statistic Order</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getInternalNeed <em>Internal Need</em>}</li>
 * <li>{@link pepper.peppermm.impl.ProjectImpl#getClientNeed <em>Client Need</em>}</li>
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
        return PepperPackage.Literals.PROJECT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Workpackage> getOwnedWorkpackages() {
        if (ownedWorkpackages == null) {
            ownedWorkpackages = new EObjectContainmentEList<Workpackage>(Workpackage.class, this, PepperPackage.PROJECT__OWNED_WORKPACKAGES);
        }
        return ownedWorkpackages;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Objective> getOwnedObjectives() {
        if (ownedObjectives == null) {
            ownedObjectives = new EObjectContainmentEList<Objective>(Objective.class, this, PepperPackage.PROJECT__OWNED_OBJECTIVES);
        }
        return ownedObjectives;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<TagFolder> getOwnedTagFolders() {
        if (ownedTagFolders == null) {
            ownedTagFolders = new EObjectContainmentEList<TagFolder>(TagFolder.class, this, PepperPackage.PROJECT__OWNED_TAG_FOLDERS);
        }
        return ownedTagFolders;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Risk> getOwnedRisks() {
        if (ownedRisks == null) {
            ownedRisks = new EObjectContainmentEList<Risk>(Risk.class, this, PepperPackage.PROJECT__OWNED_RISKS);
        }
        return ownedRisks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getReference() {
        return reference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setReference(String newReference) {
        String oldReference = reference;
        reference = newReference;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__REFERENCE, oldReference, reference));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InternalStakeholder getLeadingUnit() {
        if (leadingUnit != null && leadingUnit.eIsProxy()) {
            InternalEObject oldLeadingUnit = (InternalEObject) leadingUnit;
            leadingUnit = (InternalStakeholder) eResolveProxy(oldLeadingUnit);
            if (leadingUnit != oldLeadingUnit) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PepperPackage.PROJECT__LEADING_UNIT, oldLeadingUnit, leadingUnit));
            }
        }
        return leadingUnit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InternalStakeholder basicGetLeadingUnit() {
        return leadingUnit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLeadingUnit(InternalStakeholder newLeadingUnit) {
        InternalStakeholder oldLeadingUnit = leadingUnit;
        leadingUnit = newLeadingUnit;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__LEADING_UNIT, oldLeadingUnit, leadingUnit));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<InternalStakeholder> getParticipantUnits() {
        if (participantUnits == null) {
            participantUnits = new EObjectResolvingEList<InternalStakeholder>(InternalStakeholder.class, this, PepperPackage.PROJECT__PARTICIPANT_UNITS);
        }
        return participantUnits;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Boolean getPlannifiedClientCopilMeetings() {
        return plannifiedClientCopilMeetings;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPlannifiedClientCopilMeetings(Boolean newPlannifiedClientCopilMeetings) {
        Boolean oldPlannifiedClientCopilMeetings = plannifiedClientCopilMeetings;
        plannifiedClientCopilMeetings = newPlannifiedClientCopilMeetings;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS, oldPlannifiedClientCopilMeetings, plannifiedClientCopilMeetings));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getMainProgramBrick() {
        return mainProgramBrick;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setMainProgramBrick(String newMainProgramBrick) {
        String oldMainProgramBrick = mainProgramBrick;
        mainProgramBrick = newMainProgramBrick;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__MAIN_PROGRAM_BRICK, oldMainProgramBrick, mainProgramBrick));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ProjectState getState() {
        return state;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setState(ProjectState newState) {
        ProjectState oldState = state;
        state = newState == null ? STATE_EDEFAULT : newState;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__STATE, oldState, state));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ExternalStakeholder> getClients() {
        if (clients == null) {
            clients = new EObjectResolvingEList<ExternalStakeholder>(ExternalStakeholder.class, this, PepperPackage.PROJECT__CLIENTS);
        }
        return clients;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ExternalStakeholder> getPartners() {
        if (partners == null) {
            partners = new EObjectResolvingEList<ExternalStakeholder>(ExternalStakeholder.class, this, PepperPackage.PROJECT__PARTNERS);
        }
        return partners;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Boolean getIsTransverse() {
        return getParticipantUnits().size() > 1;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Person getLeader() {
        if (leader != null && leader.eIsProxy()) {
            InternalEObject oldLeader = (InternalEObject) leader;
            leader = (Person) eResolveProxy(oldLeader);
            if (leader != oldLeader) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PepperPackage.PROJECT__LEADER, oldLeader, leader));
            }
        }
        return leader;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Person basicGetLeader() {
        return leader;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLeader(Person newLeader) {
        Person oldLeader = leader;
        leader = newLeader;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__LEADER, oldLeader, leader));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Person> getMembers() {
        if (members == null) {
            members = new EObjectResolvingEList<Person>(Person.class, this, PepperPackage.PROJECT__MEMBERS);
        }
        return members;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Boolean getIsSensitive() {
        return isSensitive;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIsSensitive(Boolean newIsSensitive) {
        Boolean oldIsSensitive = isSensitive;
        isSensitive = newIsSensitive;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__IS_SENSITIVE, oldIsSensitive, isSensitive));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getContractualStartDate() {
        return contractualStartDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setContractualStartDate(LocalDate newContractualStartDate) {
        LocalDate oldContractualStartDate = contractualStartDate;
        contractualStartDate = newContractualStartDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__CONTRACTUAL_START_DATE, oldContractualStartDate, contractualStartDate));

        if (contractualStartDate == null) {
            setContractualEndDate(null);
        } else if (duration != null) {
            setDuration(duration);
        } else if (contractualEndDate != null) {
            setContractualEndDate(contractualEndDate);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Integer getDuration() {
        return duration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDuration(Integer newDuration) {
        Integer oldDuration = duration;
        duration = newDuration;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__DURATION, oldDuration, duration));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getContractualEndDate() {
        return contractualEndDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setContractualEndDate(LocalDate newContractualEndDate) {
        LocalDate oldContractualEndDate = contractualEndDate;
        contractualEndDate = newContractualEndDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__CONTRACTUAL_END_DATE, oldContractualEndDate, contractualEndDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getEffectiveStartDate() {
        return effectiveStartDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEffectiveStartDate(LocalDate newEffectiveStartDate) {
        LocalDate oldEffectiveStartDate = effectiveStartDate;
        effectiveStartDate = newEffectiveStartDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__EFFECTIVE_START_DATE, oldEffectiveStartDate, effectiveStartDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getEffectiveEndDate() {
        return effectiveEndDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEffectiveEndDate(LocalDate newEffectiveEndDate) {
        LocalDate oldEffectiveEndDate = effectiveEndDate;
        effectiveEndDate = newEffectiveEndDate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__EFFECTIVE_END_DATE, oldEffectiveEndDate, effectiveEndDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Integer getContractTermExtension() {
        return contractTermExtension;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setContractTermExtension(Integer newContractTermExtension) {
        Integer oldContractTermExtension = contractTermExtension;
        contractTermExtension = newContractTermExtension;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__CONTRACT_TERM_EXTENSION, oldContractTermExtension, contractTermExtension));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Double getGlobalCost() {
        return globalCost;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setGlobalCost(Double newGlobalCost) {
        Double oldGlobalCost = globalCost;
        globalCost = newGlobalCost;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__GLOBAL_COST, oldGlobalCost, globalCost));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Double getFundingRate() {
        return fundingRate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFundingRate(Double newFundingRate) {
        Double oldFundingRate = fundingRate;
        fundingRate = newFundingRate;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__FUNDING_RATE, oldFundingRate, fundingRate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Double getFunding() {
        if (globalCost != null && fundingRate != null && fundingRate > 0) {
            Double value = globalCost * fundingRate / 100;
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
        return manpower;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setManpower(Integer newManpower) {
        Integer oldManpower = manpower;
        manpower = newManpower;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__MANPOWER, oldManpower, manpower));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getEOTP() {
        return eOTP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEOTP(String newEOTP) {
        String oldEOTP = eOTP;
        eOTP = newEOTP;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__EOTP, oldEOTP, eOTP));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getStatisticOrder() {
        return statisticOrder;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setStatisticOrder(String newStatisticOrder) {
        String oldStatisticOrder = statisticOrder;
        statisticOrder = newStatisticOrder;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__STATISTIC_ORDER, oldStatisticOrder, statisticOrder));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getInternalNeed() {
        return internalNeed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInternalNeed(String newInternalNeed) {
        String oldInternalNeed = internalNeed;
        internalNeed = newInternalNeed;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__INTERNAL_NEED, oldInternalNeed, internalNeed));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getClientNeed() {
        return clientNeed;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setClientNeed(String newClientNeed) {
        String oldClientNeed = clientNeed;
        clientNeed = newClientNeed;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.PROJECT__CLIENT_NEED, oldClientNeed, clientNeed));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PepperPackage.PROJECT__OWNED_WORKPACKAGES:
                return ((InternalEList<?>) getOwnedWorkpackages()).basicRemove(otherEnd, msgs);
            case PepperPackage.PROJECT__OWNED_OBJECTIVES:
                return ((InternalEList<?>) getOwnedObjectives()).basicRemove(otherEnd, msgs);
            case PepperPackage.PROJECT__OWNED_TAG_FOLDERS:
                return ((InternalEList<?>) getOwnedTagFolders()).basicRemove(otherEnd, msgs);
            case PepperPackage.PROJECT__OWNED_RISKS:
                return ((InternalEList<?>) getOwnedRisks()).basicRemove(otherEnd, msgs);
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
            case PepperPackage.PROJECT__NAME:
                return getName();
            case PepperPackage.PROJECT__OWNED_WORKPACKAGES:
                return getOwnedWorkpackages();
            case PepperPackage.PROJECT__OWNED_OBJECTIVES:
                return getOwnedObjectives();
            case PepperPackage.PROJECT__OWNED_TAG_FOLDERS:
                return getOwnedTagFolders();
            case PepperPackage.PROJECT__OWNED_RISKS:
                return getOwnedRisks();
            case PepperPackage.PROJECT__REFERENCE:
                return getReference();
            case PepperPackage.PROJECT__DESCRIPTION:
                return getDescription();
            case PepperPackage.PROJECT__LEADING_UNIT:
                if (resolve)
                    return getLeadingUnit();
                return basicGetLeadingUnit();
            case PepperPackage.PROJECT__PARTICIPANT_UNITS:
                return getParticipantUnits();
            case PepperPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
                return getPlannifiedClientCopilMeetings();
            case PepperPackage.PROJECT__MAIN_PROGRAM_BRICK:
                return getMainProgramBrick();
            case PepperPackage.PROJECT__STATE:
                return getState();
            case PepperPackage.PROJECT__CLIENTS:
                return getClients();
            case PepperPackage.PROJECT__PARTNERS:
                return getPartners();
            case PepperPackage.PROJECT__IS_TRANSVERSE:
                return getIsTransverse();
            case PepperPackage.PROJECT__LEADER:
                if (resolve)
                    return getLeader();
                return basicGetLeader();
            case PepperPackage.PROJECT__MEMBERS:
                return getMembers();
            case PepperPackage.PROJECT__IS_SENSITIVE:
                return getIsSensitive();
            case PepperPackage.PROJECT__CONTRACTUAL_START_DATE:
                return getContractualStartDate();
            case PepperPackage.PROJECT__DURATION:
                return getDuration();
            case PepperPackage.PROJECT__CONTRACTUAL_END_DATE:
                return getContractualEndDate();
            case PepperPackage.PROJECT__EFFECTIVE_START_DATE:
                return getEffectiveStartDate();
            case PepperPackage.PROJECT__EFFECTIVE_END_DATE:
                return getEffectiveEndDate();
            case PepperPackage.PROJECT__CONTRACT_TERM_EXTENSION:
                return getContractTermExtension();
            case PepperPackage.PROJECT__GLOBAL_COST:
                return getGlobalCost();
            case PepperPackage.PROJECT__FUNDING_RATE:
                return getFundingRate();
            case PepperPackage.PROJECT__FUNDING:
                return getFunding();
            case PepperPackage.PROJECT__MANPOWER:
                return getManpower();
            case PepperPackage.PROJECT__EOTP:
                return getEOTP();
            case PepperPackage.PROJECT__STATISTIC_ORDER:
                return getStatisticOrder();
            case PepperPackage.PROJECT__INTERNAL_NEED:
                return getInternalNeed();
            case PepperPackage.PROJECT__CLIENT_NEED:
                return getClientNeed();
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
            case PepperPackage.PROJECT__NAME:
                setName((String) newValue);
                return;
            case PepperPackage.PROJECT__OWNED_WORKPACKAGES:
                getOwnedWorkpackages().clear();
                getOwnedWorkpackages().addAll((Collection<? extends Workpackage>) newValue);
                return;
            case PepperPackage.PROJECT__OWNED_OBJECTIVES:
                getOwnedObjectives().clear();
                getOwnedObjectives().addAll((Collection<? extends Objective>) newValue);
                return;
            case PepperPackage.PROJECT__OWNED_TAG_FOLDERS:
                getOwnedTagFolders().clear();
                getOwnedTagFolders().addAll((Collection<? extends TagFolder>) newValue);
                return;
            case PepperPackage.PROJECT__OWNED_RISKS:
                getOwnedRisks().clear();
                getOwnedRisks().addAll((Collection<? extends Risk>) newValue);
                return;
            case PepperPackage.PROJECT__REFERENCE:
                setReference((String) newValue);
                return;
            case PepperPackage.PROJECT__DESCRIPTION:
                setDescription((String) newValue);
                return;
            case PepperPackage.PROJECT__LEADING_UNIT:
                setLeadingUnit((InternalStakeholder) newValue);
                return;
            case PepperPackage.PROJECT__PARTICIPANT_UNITS:
                getParticipantUnits().clear();
                getParticipantUnits().addAll((Collection<? extends InternalStakeholder>) newValue);
                return;
            case PepperPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
                setPlannifiedClientCopilMeetings((Boolean) newValue);
                return;
            case PepperPackage.PROJECT__MAIN_PROGRAM_BRICK:
                setMainProgramBrick((String) newValue);
                return;
            case PepperPackage.PROJECT__STATE:
                setState((ProjectState) newValue);
                return;
            case PepperPackage.PROJECT__CLIENTS:
                getClients().clear();
                getClients().addAll((Collection<? extends ExternalStakeholder>) newValue);
                return;
            case PepperPackage.PROJECT__PARTNERS:
                getPartners().clear();
                getPartners().addAll((Collection<? extends ExternalStakeholder>) newValue);
                return;
            case PepperPackage.PROJECT__LEADER:
                setLeader((Person) newValue);
                return;
            case PepperPackage.PROJECT__MEMBERS:
                getMembers().clear();
                getMembers().addAll((Collection<? extends Person>) newValue);
                return;
            case PepperPackage.PROJECT__IS_SENSITIVE:
                setIsSensitive((Boolean) newValue);
                return;
            case PepperPackage.PROJECT__CONTRACTUAL_START_DATE:
                setContractualStartDate((LocalDate) newValue);
                return;
            case PepperPackage.PROJECT__DURATION:
                setDuration((Integer) newValue);
                return;
            case PepperPackage.PROJECT__CONTRACTUAL_END_DATE:
                setContractualEndDate((LocalDate) newValue);
                return;
            case PepperPackage.PROJECT__EFFECTIVE_START_DATE:
                setEffectiveStartDate((LocalDate) newValue);
                return;
            case PepperPackage.PROJECT__EFFECTIVE_END_DATE:
                setEffectiveEndDate((LocalDate) newValue);
                return;
            case PepperPackage.PROJECT__CONTRACT_TERM_EXTENSION:
                setContractTermExtension((Integer) newValue);
                return;
            case PepperPackage.PROJECT__GLOBAL_COST:
                setGlobalCost((Double) newValue);
                return;
            case PepperPackage.PROJECT__FUNDING_RATE:
                setFundingRate((Double) newValue);
                return;
            case PepperPackage.PROJECT__MANPOWER:
                setManpower((Integer) newValue);
                return;
            case PepperPackage.PROJECT__EOTP:
                setEOTP((String) newValue);
                return;
            case PepperPackage.PROJECT__STATISTIC_ORDER:
                setStatisticOrder((String) newValue);
                return;
            case PepperPackage.PROJECT__INTERNAL_NEED:
                setInternalNeed((String) newValue);
                return;
            case PepperPackage.PROJECT__CLIENT_NEED:
                setClientNeed((String) newValue);
                return;
            default:
                super.eSet(featureID, newValue);
                return;
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
            case PepperPackage.PROJECT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PepperPackage.PROJECT__OWNED_WORKPACKAGES:
                getOwnedWorkpackages().clear();
                return;
            case PepperPackage.PROJECT__OWNED_OBJECTIVES:
                getOwnedObjectives().clear();
                return;
            case PepperPackage.PROJECT__OWNED_TAG_FOLDERS:
                getOwnedTagFolders().clear();
                return;
            case PepperPackage.PROJECT__OWNED_RISKS:
                getOwnedRisks().clear();
                return;
            case PepperPackage.PROJECT__REFERENCE:
                setReference(REFERENCE_EDEFAULT);
                return;
            case PepperPackage.PROJECT__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case PepperPackage.PROJECT__LEADING_UNIT:
                setLeadingUnit((InternalStakeholder) null);
                return;
            case PepperPackage.PROJECT__PARTICIPANT_UNITS:
                getParticipantUnits().clear();
                return;
            case PepperPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
                setPlannifiedClientCopilMeetings(PLANNIFIED_CLIENT_COPIL_MEETINGS_EDEFAULT);
                return;
            case PepperPackage.PROJECT__MAIN_PROGRAM_BRICK:
                setMainProgramBrick(MAIN_PROGRAM_BRICK_EDEFAULT);
                return;
            case PepperPackage.PROJECT__STATE:
                setState(STATE_EDEFAULT);
                return;
            case PepperPackage.PROJECT__CLIENTS:
                getClients().clear();
                return;
            case PepperPackage.PROJECT__PARTNERS:
                getPartners().clear();
                return;
            case PepperPackage.PROJECT__LEADER:
                setLeader((Person) null);
                return;
            case PepperPackage.PROJECT__MEMBERS:
                getMembers().clear();
                return;
            case PepperPackage.PROJECT__IS_SENSITIVE:
                setIsSensitive(IS_SENSITIVE_EDEFAULT);
                return;
            case PepperPackage.PROJECT__CONTRACTUAL_START_DATE:
                setContractualStartDate(CONTRACTUAL_START_DATE_EDEFAULT);
                return;
            case PepperPackage.PROJECT__DURATION:
                setDuration(DURATION_EDEFAULT);
                return;
            case PepperPackage.PROJECT__CONTRACTUAL_END_DATE:
                setContractualEndDate(CONTRACTUAL_END_DATE_EDEFAULT);
                return;
            case PepperPackage.PROJECT__EFFECTIVE_START_DATE:
                setEffectiveStartDate(EFFECTIVE_START_DATE_EDEFAULT);
                return;
            case PepperPackage.PROJECT__EFFECTIVE_END_DATE:
                setEffectiveEndDate(EFFECTIVE_END_DATE_EDEFAULT);
                return;
            case PepperPackage.PROJECT__CONTRACT_TERM_EXTENSION:
                setContractTermExtension(CONTRACT_TERM_EXTENSION_EDEFAULT);
                return;
            case PepperPackage.PROJECT__GLOBAL_COST:
                setGlobalCost(GLOBAL_COST_EDEFAULT);
                return;
            case PepperPackage.PROJECT__FUNDING_RATE:
                setFundingRate(FUNDING_RATE_EDEFAULT);
                return;
            case PepperPackage.PROJECT__MANPOWER:
                setManpower(MANPOWER_EDEFAULT);
                return;
            case PepperPackage.PROJECT__EOTP:
                setEOTP(EOTP_EDEFAULT);
                return;
            case PepperPackage.PROJECT__STATISTIC_ORDER:
                setStatisticOrder(STATISTIC_ORDER_EDEFAULT);
                return;
            case PepperPackage.PROJECT__INTERNAL_NEED:
                setInternalNeed(INTERNAL_NEED_EDEFAULT);
                return;
            case PepperPackage.PROJECT__CLIENT_NEED:
                setClientNeed(CLIENT_NEED_EDEFAULT);
                return;
            default:
                super.eUnset(featureID);
                return;
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
            case PepperPackage.PROJECT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PepperPackage.PROJECT__OWNED_WORKPACKAGES:
                return ownedWorkpackages != null && !ownedWorkpackages.isEmpty();
            case PepperPackage.PROJECT__OWNED_OBJECTIVES:
                return ownedObjectives != null && !ownedObjectives.isEmpty();
            case PepperPackage.PROJECT__OWNED_TAG_FOLDERS:
                return ownedTagFolders != null && !ownedTagFolders.isEmpty();
            case PepperPackage.PROJECT__OWNED_RISKS:
                return ownedRisks != null && !ownedRisks.isEmpty();
            case PepperPackage.PROJECT__REFERENCE:
                return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
            case PepperPackage.PROJECT__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case PepperPackage.PROJECT__LEADING_UNIT:
                return leadingUnit != null;
            case PepperPackage.PROJECT__PARTICIPANT_UNITS:
                return participantUnits != null && !participantUnits.isEmpty();
            case PepperPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
                return PLANNIFIED_CLIENT_COPIL_MEETINGS_EDEFAULT == null ? plannifiedClientCopilMeetings != null : !PLANNIFIED_CLIENT_COPIL_MEETINGS_EDEFAULT.equals(plannifiedClientCopilMeetings);
            case PepperPackage.PROJECT__MAIN_PROGRAM_BRICK:
                return MAIN_PROGRAM_BRICK_EDEFAULT == null ? mainProgramBrick != null : !MAIN_PROGRAM_BRICK_EDEFAULT.equals(mainProgramBrick);
            case PepperPackage.PROJECT__STATE:
                return state != STATE_EDEFAULT;
            case PepperPackage.PROJECT__CLIENTS:
                return clients != null && !clients.isEmpty();
            case PepperPackage.PROJECT__PARTNERS:
                return partners != null && !partners.isEmpty();
            case PepperPackage.PROJECT__IS_TRANSVERSE:
                return IS_TRANSVERSE_EDEFAULT == null ? getIsTransverse() != null : !IS_TRANSVERSE_EDEFAULT.equals(getIsTransverse());
            case PepperPackage.PROJECT__LEADER:
                return leader != null;
            case PepperPackage.PROJECT__MEMBERS:
                return members != null && !members.isEmpty();
            case PepperPackage.PROJECT__IS_SENSITIVE:
                return IS_SENSITIVE_EDEFAULT == null ? isSensitive != null : !IS_SENSITIVE_EDEFAULT.equals(isSensitive);
            case PepperPackage.PROJECT__CONTRACTUAL_START_DATE:
                return CONTRACTUAL_START_DATE_EDEFAULT == null ? contractualStartDate != null : !CONTRACTUAL_START_DATE_EDEFAULT.equals(contractualStartDate);
            case PepperPackage.PROJECT__DURATION:
                return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
            case PepperPackage.PROJECT__CONTRACTUAL_END_DATE:
                return CONTRACTUAL_END_DATE_EDEFAULT == null ? contractualEndDate != null : !CONTRACTUAL_END_DATE_EDEFAULT.equals(contractualEndDate);
            case PepperPackage.PROJECT__EFFECTIVE_START_DATE:
                return EFFECTIVE_START_DATE_EDEFAULT == null ? effectiveStartDate != null : !EFFECTIVE_START_DATE_EDEFAULT.equals(effectiveStartDate);
            case PepperPackage.PROJECT__EFFECTIVE_END_DATE:
                return EFFECTIVE_END_DATE_EDEFAULT == null ? effectiveEndDate != null : !EFFECTIVE_END_DATE_EDEFAULT.equals(effectiveEndDate);
            case PepperPackage.PROJECT__CONTRACT_TERM_EXTENSION:
                return CONTRACT_TERM_EXTENSION_EDEFAULT == null ? contractTermExtension != null : !CONTRACT_TERM_EXTENSION_EDEFAULT.equals(contractTermExtension);
            case PepperPackage.PROJECT__GLOBAL_COST:
                return GLOBAL_COST_EDEFAULT == null ? globalCost != null : !GLOBAL_COST_EDEFAULT.equals(globalCost);
            case PepperPackage.PROJECT__FUNDING_RATE:
                return FUNDING_RATE_EDEFAULT == null ? fundingRate != null : !FUNDING_RATE_EDEFAULT.equals(fundingRate);
            case PepperPackage.PROJECT__FUNDING:
                return FUNDING_EDEFAULT == null ? getFunding() != null : !FUNDING_EDEFAULT.equals(getFunding());
            case PepperPackage.PROJECT__MANPOWER:
                return MANPOWER_EDEFAULT == null ? manpower != null : !MANPOWER_EDEFAULT.equals(manpower);
            case PepperPackage.PROJECT__EOTP:
                return EOTP_EDEFAULT == null ? eOTP != null : !EOTP_EDEFAULT.equals(eOTP);
            case PepperPackage.PROJECT__STATISTIC_ORDER:
                return STATISTIC_ORDER_EDEFAULT == null ? statisticOrder != null : !STATISTIC_ORDER_EDEFAULT.equals(statisticOrder);
            case PepperPackage.PROJECT__INTERNAL_NEED:
                return INTERNAL_NEED_EDEFAULT == null ? internalNeed != null : !INTERNAL_NEED_EDEFAULT.equals(internalNeed);
            case PepperPackage.PROJECT__CLIENT_NEED:
                return CLIENT_NEED_EDEFAULT == null ? clientNeed != null : !CLIENT_NEED_EDEFAULT.equals(clientNeed);
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
        if (eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", reference: ");
        result.append(reference);
        result.append(", description: ");
        result.append(description);
        result.append(", plannifiedClientCopilMeetings: ");
        result.append(plannifiedClientCopilMeetings);
        result.append(", mainProgramBrick: ");
        result.append(mainProgramBrick);
        result.append(", state: ");
        result.append(state);
        result.append(", isSensitive: ");
        result.append(isSensitive);
        result.append(", contractualStartDate: ");
        result.append(contractualStartDate);
        result.append(", duration: ");
        result.append(duration);
        result.append(", contractualEndDate: ");
        result.append(contractualEndDate);
        result.append(", effectiveStartDate: ");
        result.append(effectiveStartDate);
        result.append(", effectiveEndDate: ");
        result.append(effectiveEndDate);
        result.append(", contractTermExtension: ");
        result.append(contractTermExtension);
        result.append(", globalCost: ");
        result.append(globalCost);
        result.append(", fundingRate: ");
        result.append(fundingRate);
        result.append(", manpower: ");
        result.append(manpower);
        result.append(", eOTP: ");
        result.append(eOTP);
        result.append(", statisticOrder: ");
        result.append(statisticOrder);
        result.append(", internalNeed: ");
        result.append(internalNeed);
        result.append(", clientNeed: ");
        result.append(clientNeed);
        result.append(')');
        return result.toString();
    }

} // ProjectImpl

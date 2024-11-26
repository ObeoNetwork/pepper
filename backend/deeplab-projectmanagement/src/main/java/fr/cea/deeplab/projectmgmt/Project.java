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
package fr.cea.deeplab.projectmgmt;

import java.time.LocalDate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Project</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getName <em>Name</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getOwnedWorkpackages <em>Owned Workpackages</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getOwnedObjectives <em>Owned Objectives</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getOwnedTagFolders <em>Owned Tag Folders</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getOwnedRisks <em>Owned Risks</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getReference <em>Reference</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getDescription <em>Description</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getLeadingUnit <em>Leading Unit</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getParticipantUnits <em>Participant Units</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getPlannifiedClientCopilMeetings <em>Plannified Client Copil
 * Meetings</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getMainProgramBrick <em>Main Program Brick</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getState <em>State</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getClients <em>Clients</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getPartners <em>Partners</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getIsTransverse <em>Is Transverse</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getLeader <em>Leader</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getMembers <em>Members</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getIsSensitive <em>Is Sensitive</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getContractualStartDate <em>Contractual Start Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getDuration <em>Duration</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getContractualEndDate <em>Contractual End Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getEffectiveStartDate <em>Effective Start Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getEffectiveEndDate <em>Effective End Date</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getContractTermExtension <em>Contract Term Extension</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getGlobalCost <em>Global Cost</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getFundingRate <em>Funding Rate</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getFunding <em>Funding</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getManpower <em>Manpower</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getEOTP <em>EOTP</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getStatisticOrder <em>Statistic Order</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getInternalNeed <em>Internal Need</em>}</li>
 * <li>{@link fr.cea.deeplab.projectmgmt.Project#getClientNeed <em>Client Need</em>}</li>
 * </ul>
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getName <em>Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Owned Workpackages</b></em>' containment reference list. The list contents are
     * of type {@link fr.cea.deeplab.projectmgmt.Workpackage}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Workpackages</em>' containment reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_OwnedWorkpackages()
     * @model containment="true"
     * @generated
     */
    EList<Workpackage> getOwnedWorkpackages();

    /**
     * Returns the value of the '<em><b>Owned Objectives</b></em>' containment reference list. The list contents are of
     * type {@link fr.cea.deeplab.projectmgmt.Objective}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Objectives</em>' containment reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_OwnedObjectives()
     * @model containment="true"
     * @generated
     */
    EList<Objective> getOwnedObjectives();

    /**
     * Returns the value of the '<em><b>Owned Tag Folders</b></em>' containment reference list. The list contents are of
     * type {@link fr.cea.deeplab.projectmgmt.TagFolder}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Tag Folders</em>' containment reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_OwnedTagFolders()
     * @model containment="true"
     * @generated
     */
    EList<TagFolder> getOwnedTagFolders();

    /**
     * Returns the value of the '<em><b>Owned Risks</b></em>' containment reference list. The list contents are of type
     * {@link fr.cea.deeplab.projectmgmt.Risk}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Owned Risks</em>' containment reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_OwnedRisks()
     * @model containment="true"
     * @generated
     */
    EList<Risk> getOwnedRisks();

    /**
     * Returns the value of the '<em><b>Reference</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Reference</em>' attribute.
     * @see #setReference(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Reference()
     * @model
     * @generated
     */
    String getReference();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getReference <em>Reference</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Reference</em>' attribute.
     * @see #getReference()
     * @generated
     */
    void setReference(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Leading Unit</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Leading Unit</em>' reference.
     * @see #setLeadingUnit(InternalStakeholder)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_LeadingUnit()
     * @model
     * @generated
     */
    InternalStakeholder getLeadingUnit();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getLeadingUnit <em>Leading Unit</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Leading Unit</em>' reference.
     * @see #getLeadingUnit()
     * @generated
     */
    void setLeadingUnit(InternalStakeholder value);

    /**
     * Returns the value of the '<em><b>Participant Units</b></em>' reference list. The list contents are of type
     * {@link fr.cea.deeplab.projectmgmt.InternalStakeholder}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Participant Units</em>' reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_ParticipantUnits()
     * @model
     * @generated
     */
    EList<InternalStakeholder> getParticipantUnits();

    /**
     * Returns the value of the '<em><b>Plannified Client Copil Meetings</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Plannified Client Copil Meetings</em>' attribute.
     * @see #setPlannifiedClientCopilMeetings(Boolean)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_PlannifiedClientCopilMeetings()
     * @model
     * @generated
     */
    Boolean getPlannifiedClientCopilMeetings();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getPlannifiedClientCopilMeetings <em>Plannified
     * Client Copil Meetings</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Plannified Client Copil Meetings</em>' attribute.
     * @see #getPlannifiedClientCopilMeetings()
     * @generated
     */
    void setPlannifiedClientCopilMeetings(Boolean value);

    /**
     * Returns the value of the '<em><b>Main Program Brick</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Main Program Brick</em>' attribute.
     * @see #setMainProgramBrick(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_MainProgramBrick()
     * @model
     * @generated
     */
    String getMainProgramBrick();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getMainProgramBrick <em>Main Program
     * Brick</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Main Program Brick</em>' attribute.
     * @see #getMainProgramBrick()
     * @generated
     */
    void setMainProgramBrick(String value);

    /**
     * Returns the value of the '<em><b>State</b></em>' attribute. The literals are from the enumeration
     * {@link fr.cea.deeplab.projectmgmt.ProjectState}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>State</em>' attribute.
     * @see fr.cea.deeplab.projectmgmt.ProjectState
     * @see #setState(ProjectState)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_State()
     * @model
     * @generated
     */
    ProjectState getState();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getState <em>State</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>State</em>' attribute.
     * @see fr.cea.deeplab.projectmgmt.ProjectState
     * @see #getState()
     * @generated
     */
    void setState(ProjectState value);

    /**
     * Returns the value of the '<em><b>Clients</b></em>' reference list. The list contents are of type
     * {@link fr.cea.deeplab.projectmgmt.ExternalStakeholder}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Clients</em>' reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Clients()
     * @model
     * @generated
     */
    EList<ExternalStakeholder> getClients();

    /**
     * Returns the value of the '<em><b>Partners</b></em>' reference list. The list contents are of type
     * {@link fr.cea.deeplab.projectmgmt.ExternalStakeholder}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Partners</em>' reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Partners()
     * @model
     * @generated
     */
    EList<ExternalStakeholder> getPartners();

    /**
     * Returns the value of the '<em><b>Is Transverse</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Is Transverse</em>' attribute.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_IsTransverse()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    Boolean getIsTransverse();

    /**
     * Returns the value of the '<em><b>Leader</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Leader</em>' reference.
     * @see #setLeader(Person)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Leader()
     * @model
     * @generated
     */
    Person getLeader();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getLeader <em>Leader</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Leader</em>' reference.
     * @see #getLeader()
     * @generated
     */
    void setLeader(Person value);

    /**
     * Returns the value of the '<em><b>Members</b></em>' reference list. The list contents are of type
     * {@link fr.cea.deeplab.projectmgmt.Person}. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Members</em>' reference list.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Members()
     * @model
     * @generated
     */
    EList<Person> getMembers();

    /**
     * Returns the value of the '<em><b>Is Sensitive</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Is Sensitive</em>' attribute.
     * @see #setIsSensitive(Boolean)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_IsSensitive()
     * @model
     * @generated
     */
    Boolean getIsSensitive();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getIsSensitive <em>Is Sensitive</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Is Sensitive</em>' attribute.
     * @see #getIsSensitive()
     * @generated
     */
    void setIsSensitive(Boolean value);

    /**
     * Returns the value of the '<em><b>Contractual Start Date</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Contractual Start Date</em>' attribute.
     * @see #setContractualStartDate(LocalDate)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_ContractualStartDate()
     * @model dataType="fr.cea.deeplab.projectmgmt.Date"
     * @generated
     */
    LocalDate getContractualStartDate();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getContractualStartDate <em>Contractual Start
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Contractual Start Date</em>' attribute.
     * @see #getContractualStartDate()
     * @generated
     */
    void setContractualStartDate(LocalDate value);

    /**
     * Returns the value of the '<em><b>Duration</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Duration</em>' attribute.
     * @see #setDuration(Integer)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Duration()
     * @model
     * @generated
     */
    Integer getDuration();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getDuration <em>Duration</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Duration</em>' attribute.
     * @see #getDuration()
     * @generated
     */
    void setDuration(Integer value);

    /**
     * Returns the value of the '<em><b>Contractual End Date</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Contractual End Date</em>' attribute.
     * @see #setContractualEndDate(LocalDate)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_ContractualEndDate()
     * @model dataType="fr.cea.deeplab.projectmgmt.Date"
     * @generated
     */
    LocalDate getContractualEndDate();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getContractualEndDate <em>Contractual End
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Contractual End Date</em>' attribute.
     * @see #getContractualEndDate()
     * @generated
     */
    void setContractualEndDate(LocalDate value);

    /**
     * Returns the value of the '<em><b>Effective Start Date</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Effective Start Date</em>' attribute.
     * @see #setEffectiveStartDate(LocalDate)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_EffectiveStartDate()
     * @model dataType="fr.cea.deeplab.projectmgmt.Date"
     * @generated
     */
    LocalDate getEffectiveStartDate();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getEffectiveStartDate <em>Effective Start
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Effective Start Date</em>' attribute.
     * @see #getEffectiveStartDate()
     * @generated
     */
    void setEffectiveStartDate(LocalDate value);

    /**
     * Returns the value of the '<em><b>Effective End Date</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Effective End Date</em>' attribute.
     * @see #setEffectiveEndDate(LocalDate)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_EffectiveEndDate()
     * @model dataType="fr.cea.deeplab.projectmgmt.Date"
     * @generated
     */
    LocalDate getEffectiveEndDate();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getEffectiveEndDate <em>Effective End
     * Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Effective End Date</em>' attribute.
     * @see #getEffectiveEndDate()
     * @generated
     */
    void setEffectiveEndDate(LocalDate value);

    /**
     * Returns the value of the '<em><b>Contract Term Extension</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Contract Term Extension</em>' attribute.
     * @see #setContractTermExtension(Integer)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_ContractTermExtension()
     * @model
     * @generated
     */
    Integer getContractTermExtension();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getContractTermExtension <em>Contract Term
     * Extension</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Contract Term Extension</em>' attribute.
     * @see #getContractTermExtension()
     * @generated
     */
    void setContractTermExtension(Integer value);

    /**
     * Returns the value of the '<em><b>Global Cost</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Global Cost</em>' attribute.
     * @see #setGlobalCost(Double)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_GlobalCost()
     * @model
     * @generated
     */
    Double getGlobalCost();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getGlobalCost <em>Global Cost</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Global Cost</em>' attribute.
     * @see #getGlobalCost()
     * @generated
     */
    void setGlobalCost(Double value);

    /**
     * Returns the value of the '<em><b>Funding Rate</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Funding Rate</em>' attribute.
     * @see #setFundingRate(Double)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_FundingRate()
     * @model
     * @generated
     */
    Double getFundingRate();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getFundingRate <em>Funding Rate</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Funding Rate</em>' attribute.
     * @see #getFundingRate()
     * @generated
     */
    void setFundingRate(Double value);

    /**
     * Returns the value of the '<em><b>Funding</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Funding</em>' attribute.
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Funding()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    Double getFunding();

    /**
     * Returns the value of the '<em><b>Manpower</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Manpower</em>' attribute.
     * @see #setManpower(Integer)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_Manpower()
     * @model
     * @generated
     */
    Integer getManpower();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getManpower <em>Manpower</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Manpower</em>' attribute.
     * @see #getManpower()
     * @generated
     */
    void setManpower(Integer value);

    /**
     * Returns the value of the '<em><b>EOTP</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>EOTP</em>' attribute.
     * @see #setEOTP(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_EOTP()
     * @model
     * @generated
     */
    String getEOTP();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getEOTP <em>EOTP</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>EOTP</em>' attribute.
     * @see #getEOTP()
     * @generated
     */
    void setEOTP(String value);

    /**
     * Returns the value of the '<em><b>Statistic Order</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Statistic Order</em>' attribute.
     * @see #setStatisticOrder(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_StatisticOrder()
     * @model
     * @generated
     */
    String getStatisticOrder();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getStatisticOrder <em>Statistic Order</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Statistic Order</em>' attribute.
     * @see #getStatisticOrder()
     * @generated
     */
    void setStatisticOrder(String value);

    /**
     * Returns the value of the '<em><b>Internal Need</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Internal Need</em>' attribute.
     * @see #setInternalNeed(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_InternalNeed()
     * @model
     * @generated
     */
    String getInternalNeed();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getInternalNeed <em>Internal Need</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Internal Need</em>' attribute.
     * @see #getInternalNeed()
     * @generated
     */
    void setInternalNeed(String value);

    /**
     * Returns the value of the '<em><b>Client Need</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Client Need</em>' attribute.
     * @see #setClientNeed(String)
     * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getProject_ClientNeed()
     * @model
     * @generated
     */
    String getClientNeed();

    /**
     * Sets the value of the '{@link fr.cea.deeplab.projectmgmt.Project#getClientNeed <em>Client Need</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Client Need</em>' attribute.
     * @see #getClientNeed()
     * @generated
     */
    void setClientNeed(String value);

} // Project

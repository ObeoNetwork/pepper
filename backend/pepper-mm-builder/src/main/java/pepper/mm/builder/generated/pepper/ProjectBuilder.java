/*******************************************************************************
 * Copyright (c) 2023, 2026 Obeo.
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
package pepper.mm.builder.generated.pepper;

/**
 * Builder for ProjectBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class ProjectBuilder {

    /**
     * Create instance pepper.peppermm.Project.
     * @generated
     */
    private pepper.peppermm.Project project = pepper.peppermm.PepperFactory.eINSTANCE.createProject();

    /**
     * Return instance pepper.peppermm.Project.
     * @generated
     */
    protected pepper.peppermm.Project getProject() {
        return this.project;
    }

    /**
     * Return instance pepper.peppermm.Project.
     * @generated
     */
    public pepper.peppermm.Project build() {
        return this.getProject();
    }

    /**
     * Setter for Name.
     *
     * @generated
     */
    public ProjectBuilder name(java.lang.String value) {
        this.getProject().setName(value);
        return this;
    }
    /**
     * Setter for Description.
     *
     * @generated
     */
    public ProjectBuilder description(java.lang.String value) {
        this.getProject().setDescription(value);
        return this;
    }
    /**
     * Setter for OwnedWorkpackages.
     *
     * @generated
     */
    public ProjectBuilder ownedWorkpackages(pepper.peppermm.Workpackage ... values) {
        for (pepper.peppermm.Workpackage value : values) {
            this.getProject().getOwnedWorkpackages().add(value);
        }
        return this;
    }

    /**
     * Setter for OwnedObjectives.
     *
     * @generated
     */
    public ProjectBuilder ownedObjectives(pepper.peppermm.Objective ... values) {
        for (pepper.peppermm.Objective value : values) {
            this.getProject().getOwnedObjectives().add(value);
        }
        return this;
    }

    /**
     * Setter for OwnedTagFolders.
     *
     * @generated
     */
    public ProjectBuilder ownedTagFolders(pepper.peppermm.TagFolder ... values) {
        for (pepper.peppermm.TagFolder value : values) {
            this.getProject().getOwnedTagFolders().add(value);
        }
        return this;
    }

    /**
     * Setter for OwnedRisks.
     *
     * @generated
     */
    public ProjectBuilder ownedRisks(pepper.peppermm.Risk ... values) {
        for (pepper.peppermm.Risk value : values) {
            this.getProject().getOwnedRisks().add(value);
        }
        return this;
    }

    /**
     * Setter for Reference.
     *
     * @generated
     */
    public ProjectBuilder reference(java.lang.String value) {
        this.getProject().setReference(value);
        return this;
    }
    /**
     * Setter for LeadingUnit.
     *
     * @generated
     */
    public ProjectBuilder leadingUnit(pepper.peppermm.InternalStakeholder value) {
        this.getProject().setLeadingUnit(value);
        return this;
    }
    /**
     * Setter for ParticipantUnits.
     *
     * @generated
     */
    public ProjectBuilder participantUnits(pepper.peppermm.InternalStakeholder ... values) {
        for (pepper.peppermm.InternalStakeholder value : values) {
            this.getProject().getParticipantUnits().add(value);
        }
        return this;
    }

    /**
     * Setter for PlannifiedClientCopilMeetings.
     *
     * @generated
     */
    public ProjectBuilder plannifiedClientCopilMeetings(java.lang.Boolean value) {
        this.getProject().setPlannifiedClientCopilMeetings(value);
        return this;
    }
    /**
     * Setter for MainProgramBrick.
     *
     * @generated
     */
    public ProjectBuilder mainProgramBrick(java.lang.String value) {
        this.getProject().setMainProgramBrick(value);
        return this;
    }
    /**
     * Setter for State.
     *
     * @generated
     */
    public ProjectBuilder state(pepper.peppermm.ProjectState value) {
        this.getProject().setState(value);
        return this;
    }
    /**
     * Setter for Clients.
     *
     * @generated
     */
    public ProjectBuilder clients(pepper.peppermm.ExternalStakeholder ... values) {
        for (pepper.peppermm.ExternalStakeholder value : values) {
            this.getProject().getClients().add(value);
        }
        return this;
    }

    /**
     * Setter for Partners.
     *
     * @generated
     */
    public ProjectBuilder partners(pepper.peppermm.ExternalStakeholder ... values) {
        for (pepper.peppermm.ExternalStakeholder value : values) {
            this.getProject().getPartners().add(value);
        }
        return this;
    }

    /**
     * Setter for Leader.
     *
     * @generated
     */
    public ProjectBuilder leader(pepper.peppermm.Person value) {
        this.getProject().setLeader(value);
        return this;
    }
    /**
     * Setter for Members.
     *
     * @generated
     */
    public ProjectBuilder members(pepper.peppermm.Person ... values) {
        for (pepper.peppermm.Person value : values) {
            this.getProject().getMembers().add(value);
        }
        return this;
    }

    /**
     * Setter for IsSensitive.
     *
     * @generated
     */
    public ProjectBuilder isSensitive(java.lang.Boolean value) {
        this.getProject().setIsSensitive(value);
        return this;
    }
    /**
     * Setter for ContractualStartDate.
     *
     * @generated
     */
    public ProjectBuilder contractualStartDate(java.time.LocalDate value) {
        this.getProject().setContractualStartDate(value);
        return this;
    }
    /**
     * Setter for Duration.
     *
     * @generated
     */
    public ProjectBuilder duration(java.lang.Integer value) {
        this.getProject().setDuration(value);
        return this;
    }
    /**
     * Setter for ContractualEndDate.
     *
     * @generated
     */
    public ProjectBuilder contractualEndDate(java.time.LocalDate value) {
        this.getProject().setContractualEndDate(value);
        return this;
    }
    /**
     * Setter for EffectiveStartDate.
     *
     * @generated
     */
    public ProjectBuilder effectiveStartDate(java.time.LocalDate value) {
        this.getProject().setEffectiveStartDate(value);
        return this;
    }
    /**
     * Setter for EffectiveEndDate.
     *
     * @generated
     */
    public ProjectBuilder effectiveEndDate(java.time.LocalDate value) {
        this.getProject().setEffectiveEndDate(value);
        return this;
    }
    /**
     * Setter for ContractTermExtension.
     *
     * @generated
     */
    public ProjectBuilder contractTermExtension(java.lang.Integer value) {
        this.getProject().setContractTermExtension(value);
        return this;
    }
    /**
     * Setter for GlobalCost.
     *
     * @generated
     */
    public ProjectBuilder globalCost(java.lang.Double value) {
        this.getProject().setGlobalCost(value);
        return this;
    }
    /**
     * Setter for FundingRate.
     *
     * @generated
     */
    public ProjectBuilder fundingRate(java.lang.Double value) {
        this.getProject().setFundingRate(value);
        return this;
    }
    /**
     * Setter for Manpower.
     *
     * @generated
     */
    public ProjectBuilder manpower(java.lang.Integer value) {
        this.getProject().setManpower(value);
        return this;
    }
    /**
     * Setter for EOTP.
     *
     * @generated
     */
    public ProjectBuilder eOTP(java.lang.String value) {
        this.getProject().setEOTP(value);
        return this;
    }
    /**
     * Setter for StatisticOrder.
     *
     * @generated
     */
    public ProjectBuilder statisticOrder(java.lang.String value) {
        this.getProject().setStatisticOrder(value);
        return this;
    }
    /**
     * Setter for InternalNeed.
     *
     * @generated
     */
    public ProjectBuilder internalNeed(java.lang.String value) {
        this.getProject().setInternalNeed(value);
        return this;
    }
    /**
     * Setter for ClientNeed.
     *
     * @generated
     */
    public ProjectBuilder clientNeed(java.lang.String value) {
        this.getProject().setClientNeed(value);
        return this;
    }

}


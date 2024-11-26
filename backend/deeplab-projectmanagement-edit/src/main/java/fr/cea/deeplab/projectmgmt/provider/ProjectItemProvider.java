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
package fr.cea.deeplab.projectmgmt.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import fr.cea.deeplab.projectmgmt.Project;
import fr.cea.deeplab.projectmgmt.ProjectmgmtFactory;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;

/**
 * This is the item provider adapter for a {@link fr.cea.deeplab.projectmgmt.Project} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ProjectItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ProjectItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addNamePropertyDescriptor(object);
            this.addReferencePropertyDescriptor(object);
            this.addDescriptionPropertyDescriptor(object);
            this.addLeadingUnitPropertyDescriptor(object);
            this.addParticipantUnitsPropertyDescriptor(object);
            this.addPlannifiedClientCopilMeetingsPropertyDescriptor(object);
            this.addMainProgramBrickPropertyDescriptor(object);
            this.addStatePropertyDescriptor(object);
            this.addClientsPropertyDescriptor(object);
            this.addPartnersPropertyDescriptor(object);
            this.addIsTransversePropertyDescriptor(object);
            this.addLeaderPropertyDescriptor(object);
            this.addMembersPropertyDescriptor(object);
            this.addIsSensitivePropertyDescriptor(object);
            this.addContractualStartDatePropertyDescriptor(object);
            this.addDurationPropertyDescriptor(object);
            this.addContractualEndDatePropertyDescriptor(object);
            this.addEffectiveStartDatePropertyDescriptor(object);
            this.addEffectiveEndDatePropertyDescriptor(object);
            this.addContractTermExtensionPropertyDescriptor(object);
            this.addGlobalCostPropertyDescriptor(object);
            this.addFundingRatePropertyDescriptor(object);
            this.addFundingPropertyDescriptor(object);
            this.addManpowerPropertyDescriptor(object);
            this.addEOTPPropertyDescriptor(object);
            this.addStatisticOrderPropertyDescriptor(object);
            this.addInternalNeedPropertyDescriptor(object);
            this.addClientNeedPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_name_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_name_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addReferencePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_reference_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_reference_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__REFERENCE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Description feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDescriptionPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_description_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_description_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__DESCRIPTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Leading Unit feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addLeadingUnitPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_leadingUnit_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_leadingUnit_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__LEADING_UNIT, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Participant Units feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addParticipantUnitsPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_participantUnits_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_participantUnits_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__PARTICIPANT_UNITS, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Plannified Client Copil Meetings feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addPlannifiedClientCopilMeetingsPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_plannifiedClientCopilMeetings_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_Project_plannifiedClientCopilMeetings_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Main Program Brick feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addMainProgramBrickPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_mainProgramBrick_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_mainProgramBrick_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__MAIN_PROGRAM_BRICK, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the State feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addStatePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_state_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_state_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__STATE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Clients feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addClientsPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_clients_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_clients_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__CLIENTS, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Partners feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPartnersPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_partners_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_partners_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__PARTNERS, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Is Transverse feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addIsTransversePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_isTransverse_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_isTransverse_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__IS_TRANSVERSE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Leader feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addLeaderPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_leader_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_leader_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__LEADER, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Members feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addMembersPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_members_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_members_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__MEMBERS, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Is Sensitive feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addIsSensitivePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_isSensitive_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_isSensitive_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__IS_SENSITIVE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Contractual Start Date feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    protected void addContractualStartDatePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_contractualStartDate_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_contractualStartDate_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__CONTRACTUAL_START_DATE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Duration feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDurationPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_duration_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_duration_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__DURATION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Contractual End Date feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    protected void addContractualEndDatePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_contractualEndDate_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_contractualEndDate_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__CONTRACTUAL_END_DATE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Effective Start Date feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    protected void addEffectiveStartDatePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_effectiveStartDate_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_effectiveStartDate_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__EFFECTIVE_START_DATE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Effective End Date feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addEffectiveEndDatePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_effectiveEndDate_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_effectiveEndDate_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__EFFECTIVE_END_DATE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Contract Term Extension feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected void addContractTermExtensionPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_contractTermExtension_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_contractTermExtension_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__CONTRACT_TERM_EXTENSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Global Cost feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addGlobalCostPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_globalCost_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_globalCost_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__GLOBAL_COST, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Funding Rate feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addFundingRatePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_fundingRate_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_fundingRate_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__FUNDING_RATE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Funding feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addFundingPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_funding_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_funding_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__FUNDING, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Manpower feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addManpowerPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_manpower_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_manpower_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__MANPOWER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the EOTP feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addEOTPPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_eOTP_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_eOTP_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__EOTP, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Statistic Order feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addStatisticOrderPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_statisticOrder_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_statisticOrder_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__STATISTIC_ORDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Internal Need feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addInternalNeedPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_internalNeed_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_internalNeed_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__INTERNAL_NEED, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Client Need feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addClientNeedPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_Project_clientNeed_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_Project_clientNeed_feature", "_UI_Project_type"),
                ProjectmgmtPackage.Literals.PROJECT__CLIENT_NEED, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(ProjectmgmtPackage.Literals.PROJECT__OWNED_WORKPACKAGES);
            this.childrenFeatures.add(ProjectmgmtPackage.Literals.PROJECT__OWNED_OBJECTIVES);
            this.childrenFeatures.add(ProjectmgmtPackage.Literals.PROJECT__OWNED_TAG_FOLDERS);
            this.childrenFeatures.add(ProjectmgmtPackage.Literals.PROJECT__OWNED_RISKS);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns Project.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/Project.svg"));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected boolean shouldComposeCreationImage() {
        return true;
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((Project) object).getName();
        return label == null || label.length() == 0 ? this.getString("_UI_Project_type") : this.getString("_UI_Project_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
     * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(Project.class)) {
            case ProjectmgmtPackage.PROJECT__NAME:
            case ProjectmgmtPackage.PROJECT__REFERENCE:
            case ProjectmgmtPackage.PROJECT__DESCRIPTION:
            case ProjectmgmtPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
            case ProjectmgmtPackage.PROJECT__MAIN_PROGRAM_BRICK:
            case ProjectmgmtPackage.PROJECT__STATE:
            case ProjectmgmtPackage.PROJECT__IS_TRANSVERSE:
            case ProjectmgmtPackage.PROJECT__IS_SENSITIVE:
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_START_DATE:
            case ProjectmgmtPackage.PROJECT__DURATION:
            case ProjectmgmtPackage.PROJECT__CONTRACTUAL_END_DATE:
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_START_DATE:
            case ProjectmgmtPackage.PROJECT__EFFECTIVE_END_DATE:
            case ProjectmgmtPackage.PROJECT__CONTRACT_TERM_EXTENSION:
            case ProjectmgmtPackage.PROJECT__GLOBAL_COST:
            case ProjectmgmtPackage.PROJECT__FUNDING_RATE:
            case ProjectmgmtPackage.PROJECT__FUNDING:
            case ProjectmgmtPackage.PROJECT__MANPOWER:
            case ProjectmgmtPackage.PROJECT__EOTP:
            case ProjectmgmtPackage.PROJECT__STATISTIC_ORDER:
            case ProjectmgmtPackage.PROJECT__INTERNAL_NEED:
            case ProjectmgmtPackage.PROJECT__CLIENT_NEED:
                this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case ProjectmgmtPackage.PROJECT__OWNED_WORKPACKAGES:
            case ProjectmgmtPackage.PROJECT__OWNED_OBJECTIVES:
            case ProjectmgmtPackage.PROJECT__OWNED_TAG_FOLDERS:
            case ProjectmgmtPackage.PROJECT__OWNED_RISKS:
                this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
                return;
            default:
                super.notifyChanged(notification);
                return;
        }
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that can be created
     * under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add(this.createChildParameter(ProjectmgmtPackage.Literals.PROJECT__OWNED_WORKPACKAGES, ProjectmgmtFactory.eINSTANCE.createWorkpackage()));

        newChildDescriptors.add(this.createChildParameter(ProjectmgmtPackage.Literals.PROJECT__OWNED_OBJECTIVES, ProjectmgmtFactory.eINSTANCE.createObjective()));

        newChildDescriptors.add(this.createChildParameter(ProjectmgmtPackage.Literals.PROJECT__OWNED_TAG_FOLDERS, ProjectmgmtFactory.eINSTANCE.createTagFolder()));

        newChildDescriptors.add(this.createChildParameter(ProjectmgmtPackage.Literals.PROJECT__OWNED_RISKS, ProjectmgmtFactory.eINSTANCE.createRisk()));
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ProjectManagementEditPlugin.INSTANCE;
    }

}

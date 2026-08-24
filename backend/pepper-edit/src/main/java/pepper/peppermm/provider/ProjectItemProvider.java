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
package pepper.peppermm.provider;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

import pepper.peppermm.PepperFactory;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Project;
import pepper.peppermm.Workpackage;

/**
 * This is the item provider adapter for a {@link pepper.peppermm.Project} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class ProjectItemProvider extends NamedElementItemProvider {
    /**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ProjectItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

    /**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addReferencePropertyDescriptor(object);
			addLeadingUnitPropertyDescriptor(object);
			addParticipantUnitsPropertyDescriptor(object);
			addPlannifiedClientCopilMeetingsPropertyDescriptor(object);
			addMainProgramBrickPropertyDescriptor(object);
			addStatePropertyDescriptor(object);
			addClientsPropertyDescriptor(object);
			addPartnersPropertyDescriptor(object);
			addIsTransversePropertyDescriptor(object);
			addLeaderPropertyDescriptor(object);
			addMembersPropertyDescriptor(object);
			addIsSensitivePropertyDescriptor(object);
			addContractualStartDatePropertyDescriptor(object);
			addDurationPropertyDescriptor(object);
			addContractualEndDatePropertyDescriptor(object);
			addEffectiveStartDatePropertyDescriptor(object);
			addEffectiveEndDatePropertyDescriptor(object);
			addContractTermExtensionPropertyDescriptor(object);
			addGlobalCostPropertyDescriptor(object);
			addFundingRatePropertyDescriptor(object);
			addFundingPropertyDescriptor(object);
			addManpowerPropertyDescriptor(object);
			addEOTPPropertyDescriptor(object);
			addStatisticOrderPropertyDescriptor(object);
			addInternalNeedPropertyDescriptor(object);
			addClientNeedPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

    /**
	 * This adds a property descriptor for the Reference feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addReferencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_reference_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_reference_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__REFERENCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Leading Unit feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addLeadingUnitPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_leadingUnit_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_leadingUnit_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__LEADING_UNIT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Participant Units feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addParticipantUnitsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_participantUnits_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_participantUnits_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__PARTICIPANT_UNITS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Plannified Client Copil Meetings feature.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    protected void addPlannifiedClientCopilMeetingsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_plannifiedClientCopilMeetings_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_plannifiedClientCopilMeetings_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Main Program Brick feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addMainProgramBrickPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_mainProgramBrick_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_mainProgramBrick_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__MAIN_PROGRAM_BRICK,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the State feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_state_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_state_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__STATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Clients feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addClientsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_clients_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_clients_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__CLIENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Partners feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addPartnersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_partners_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_partners_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__PARTNERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Is Transverse feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addIsTransversePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_isTransverse_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_isTransverse_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__IS_TRANSVERSE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Leader feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addLeaderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_leader_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_leader_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__LEADER,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Members feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addMembersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_members_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_members_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__MEMBERS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Is Sensitive feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addIsSensitivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_isSensitive_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_isSensitive_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__IS_SENSITIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
     * This adds a property descriptor for the Contractual Start Date feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addContractualStartDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_contractualStartDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_contractualStartDate_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__CONTRACTUAL_START_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Duration feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addDurationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_duration_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_duration_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__DURATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
     * This adds a property descriptor for the Contractual End Date feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addContractualEndDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_contractualEndDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_contractualEndDate_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__CONTRACTUAL_END_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
     * This adds a property descriptor for the Effective Start Date feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addEffectiveStartDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_effectiveStartDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_effectiveStartDate_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__EFFECTIVE_START_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Effective End Date feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addEffectiveEndDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_effectiveEndDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_effectiveEndDate_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__EFFECTIVE_END_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Contract Term Extension feature.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    protected void addContractTermExtensionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_contractTermExtension_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_contractTermExtension_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__CONTRACT_TERM_EXTENSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Global Cost feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addGlobalCostPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_globalCost_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_globalCost_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__GLOBAL_COST,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Funding Rate feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addFundingRatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_fundingRate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_fundingRate_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__FUNDING_RATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Funding feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addFundingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_funding_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_funding_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__FUNDING,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Manpower feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addManpowerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_manpower_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_manpower_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__MANPOWER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the EOTP feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addEOTPPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_eOTP_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_eOTP_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__EOTP,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Statistic Order feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addStatisticOrderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_statisticOrder_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_statisticOrder_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__STATISTIC_ORDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Internal Need feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addInternalNeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_internalNeed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_internalNeed_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__INTERNAL_NEED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This adds a property descriptor for the Client Need feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected void addClientNeedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Project_clientNeed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Project_clientNeed_feature", "_UI_Project_type"),
				 PepperPackage.Literals.PROJECT__CLIENT_NEED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

    /**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(PepperPackage.Literals.PROJECT__OWNED_WORKPACKAGES);
			childrenFeatures.add(PepperPackage.Literals.PROJECT__OWNED_OBJECTIVES);
			childrenFeatures.add(PepperPackage.Literals.PROJECT__OWNED_TAG_FOLDERS);
			childrenFeatures.add(PepperPackage.Literals.PROJECT__OWNED_RISKS);
		}
		return childrenFeatures;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

    /**
	 * This returns Project.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Project"));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected boolean shouldComposeCreationImage() {
		return true;
	}

    /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String getText(Object object) {
		String label = ((Project)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Project_type") :
			getString("_UI_Project_type") + " " + label;
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
		updateChildren(notification);

		switch (notification.getFeatureID(Project.class)) {
			case PepperPackage.PROJECT__REFERENCE:
			case PepperPackage.PROJECT__PLANNIFIED_CLIENT_COPIL_MEETINGS:
			case PepperPackage.PROJECT__MAIN_PROGRAM_BRICK:
			case PepperPackage.PROJECT__STATE:
			case PepperPackage.PROJECT__IS_TRANSVERSE:
			case PepperPackage.PROJECT__IS_SENSITIVE:
			case PepperPackage.PROJECT__CONTRACTUAL_START_DATE:
			case PepperPackage.PROJECT__DURATION:
			case PepperPackage.PROJECT__CONTRACTUAL_END_DATE:
			case PepperPackage.PROJECT__EFFECTIVE_START_DATE:
			case PepperPackage.PROJECT__EFFECTIVE_END_DATE:
			case PepperPackage.PROJECT__CONTRACT_TERM_EXTENSION:
			case PepperPackage.PROJECT__GLOBAL_COST:
			case PepperPackage.PROJECT__FUNDING_RATE:
			case PepperPackage.PROJECT__FUNDING:
			case PepperPackage.PROJECT__MANPOWER:
			case PepperPackage.PROJECT__EOTP:
			case PepperPackage.PROJECT__STATISTIC_ORDER:
			case PepperPackage.PROJECT__INTERNAL_NEED:
			case PepperPackage.PROJECT__CLIENT_NEED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case PepperPackage.PROJECT__OWNED_WORKPACKAGES:
			case PepperPackage.PROJECT__OWNED_OBJECTIVES:
			case PepperPackage.PROJECT__OWNED_TAG_FOLDERS:
			case PepperPackage.PROJECT__OWNED_RISKS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

    /**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(PepperPackage.Literals.PROJECT__OWNED_WORKPACKAGES,
				 PepperFactory.eINSTANCE.createWorkpackage()));

		newChildDescriptors.add
			(createChildParameter
				(PepperPackage.Literals.PROJECT__OWNED_OBJECTIVES,
				 PepperFactory.eINSTANCE.createObjective()));

		newChildDescriptors.add
			(createChildParameter
				(PepperPackage.Literals.PROJECT__OWNED_TAG_FOLDERS,
				 PepperFactory.eINSTANCE.createTagFolder()));

		newChildDescriptors.add
			(createChildParameter
				(PepperPackage.Literals.PROJECT__OWNED_RISKS,
				 PepperFactory.eINSTANCE.createRisk()));
	}

}

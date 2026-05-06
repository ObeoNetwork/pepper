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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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

import pepper.peppermm.PepperPackage;
import pepper.peppermm.WorkpackageArtefact;

/**
 * This is the item provider adapter for a {@link WorkpackageArtefact} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class WorkpackageArtefactItemProvider extends ItemProviderAdapter
        implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WorkpackageArtefactItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addNamePropertyDescriptor(object);
            addDescriptionPropertyDescriptor(object);
            addNaturePropertyDescriptor(object);
            addPlannedDeadlinePropertyDescriptor(object);
            addEffectiveDeadLinePropertyDescriptor(object);
            addIsInvoiceTriggerPropertyDescriptor(object);
            addInvoiceAmountPropertyDescriptor(object);
            addResponsiblePropertyDescriptor(object);
            addVersionPropertyDescriptor(object);
            addIsObsoletePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_WorkpackageArtefact_name_feature"), getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_name_feature", "_UI_WorkpackageArtefact_type"),
                PepperPackage.Literals.WORKPACKAGE_ARTEFACT__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Description feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDescriptionPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_WorkpackageArtefact_description_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_description_feature", "_UI_WorkpackageArtefact_type"),
                        PepperPackage.Literals.WORKPACKAGE_ARTEFACT__DESCRIPTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Nature feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNaturePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_WorkpackageArtefact_nature_feature"), getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_nature_feature", "_UI_WorkpackageArtefact_type"),
                PepperPackage.Literals.WORKPACKAGE_ARTEFACT__NATURE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Planned Deadline feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPlannedDeadlinePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(
                createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_WorkpackageArtefact_plannedDeadline_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_plannedDeadline_feature", "_UI_WorkpackageArtefact_type"),
                        PepperPackage.Literals.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Effective Dead Line feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    protected void addEffectiveDeadLinePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(
                createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_WorkpackageArtefact_effectiveDeadLine_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_effectiveDeadLine_feature", "_UI_WorkpackageArtefact_type"),
                        PepperPackage.Literals.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Is Invoice Trigger feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIsInvoiceTriggerPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(
                createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_WorkpackageArtefact_isInvoiceTrigger_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_isInvoiceTrigger_feature", "_UI_WorkpackageArtefact_type"),
                        PepperPackage.Literals.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Invoice Amount feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addInvoiceAmountPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(
                createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_WorkpackageArtefact_invoiceAmount_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_invoiceAmount_feature", "_UI_WorkpackageArtefact_type"),
                        PepperPackage.Literals.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Responsible feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addResponsiblePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_WorkpackageArtefact_responsible_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_responsible_feature", "_UI_WorkpackageArtefact_type"),
                        PepperPackage.Literals.WORKPACKAGE_ARTEFACT__RESPONSIBLE, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Version feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addVersionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_WorkpackageArtefact_version_feature"), getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_version_feature", "_UI_WorkpackageArtefact_type"),
                PepperPackage.Literals.WORKPACKAGE_ARTEFACT__VERSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Is Obsolete feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addIsObsoletePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_WorkpackageArtefact_isObsolete_feature"), getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_isObsolete_feature", "_UI_WorkpackageArtefact_type"),
                PepperPackage.Literals.WORKPACKAGE_ARTEFACT__IS_OBSOLETE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns WorkpackageArtefact.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, this.getClass().getClassLoader().getResource("icons/full/obj16/WorkpackageArtefact.svg"));
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
        String label = ((WorkpackageArtefact) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_WorkpackageArtefact_type") : getString("_UI_WorkpackageArtefact_type") + " " + label;
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

        switch (notification.getFeatureID(WorkpackageArtefact.class)) {
            case PepperPackage.WORKPACKAGE_ARTEFACT__NAME:
            case PepperPackage.WORKPACKAGE_ARTEFACT__DESCRIPTION:
            case PepperPackage.WORKPACKAGE_ARTEFACT__NATURE:
            case PepperPackage.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE:
            case PepperPackage.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE:
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER:
            case PepperPackage.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT:
            case PepperPackage.WORKPACKAGE_ARTEFACT__VERSION:
            case PepperPackage.WORKPACKAGE_ARTEFACT__IS_OBSOLETE:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
    }

    /**
     * Return the resource locator for this item provider's resources. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return PepperEditPlugin.INSTANCE;
    }

}

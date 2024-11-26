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

import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;
import fr.cea.deeplab.projectmgmt.WorkpackageArtefact;

/**
 * This is the item provider adapter for a {@link fr.cea.deeplab.projectmgmt.WorkpackageArtefact} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
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
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addNamePropertyDescriptor(object);
            this.addDescriptionPropertyDescriptor(object);
            this.addNaturePropertyDescriptor(object);
            this.addPlannedDeadlinePropertyDescriptor(object);
            this.addEffectiveDeadLinePropertyDescriptor(object);
            this.addIsInvoiceTriggerPropertyDescriptor(object);
            this.addInvoiceAmountPropertyDescriptor(object);
            this.addResponsiblePropertyDescriptor(object);
            this.addVersionPropertyDescriptor(object);
            this.addIsObsoletePropertyDescriptor(object);
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
                this.getString("_UI_WorkpackageArtefact_name_feature"), this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_name_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Description feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDescriptionPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_description_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_description_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__DESCRIPTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Nature feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNaturePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_nature_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_nature_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__NATURE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Planned Deadline feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addPlannedDeadlinePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_plannedDeadline_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_plannedDeadline_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Effective Dead Line feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    protected void addEffectiveDeadLinePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_effectiveDeadLine_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_effectiveDeadLine_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Is Invoice Trigger feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addIsInvoiceTriggerPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_isInvoiceTrigger_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_isInvoiceTrigger_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Invoice Amount feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addInvoiceAmountPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_invoiceAmount_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_invoiceAmount_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Responsible feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addResponsiblePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_responsible_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_responsible_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__RESPONSIBLE, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Version feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addVersionPropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_version_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_version_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__VERSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Is Obsolete feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addIsObsoletePropertyDescriptor(Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_WorkpackageArtefact_isObsolete_feature"),
                this.getString("_UI_PropertyDescriptor_description", "_UI_WorkpackageArtefact_isObsolete_feature", "_UI_WorkpackageArtefact_type"),
                ProjectmgmtPackage.Literals.WORKPACKAGE_ARTEFACT__IS_OBSOLETE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns WorkpackageArtefact.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/WorkpackageArtefact.svg"));
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
        return label == null || label.length() == 0 ? this.getString("_UI_WorkpackageArtefact_type") : this.getString("_UI_WorkpackageArtefact_type") + " " + label;
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

        switch (notification.getFeatureID(WorkpackageArtefact.class)) {
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__NAME:
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__DESCRIPTION:
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__NATURE:
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__PLANNED_DEADLINE:
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__EFFECTIVE_DEAD_LINE:
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__IS_INVOICE_TRIGGER:
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__INVOICE_AMOUNT:
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__VERSION:
            case ProjectmgmtPackage.WORKPACKAGE_ARTEFACT__IS_OBSOLETE:
                this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
        return ProjectManagementEditPlugin.INSTANCE;
    }

}

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

import java.time.Instant;
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
import pepper.peppermm.Task;
import pepper.peppermm.Workpackage;

/**
 * This is the item provider adapter for a {@link Workpackage} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class WorkpackageItemProvider extends ItemProviderAdapter
        implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public WorkpackageItemProvider(AdapterFactory adapterFactory) {
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
            addStartDatePropertyDescriptor(object);
            addEndDatePropertyDescriptor(object);
            addLeaderPropertyDescriptor(object);
            addParticipantsPropertyDescriptor(object);
            addEffortPropertyDescriptor(object);
            addProgressPropertyDescriptor(object);
            addCalculationOptionPropertyDescriptor(object);
            addDurationPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Workpackage_name_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_name_feature", "_UI_Workpackage_type"), PepperPackage.Literals.WORKPACKAGE__NAME, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Description feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDescriptionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_description_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_description_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__DESCRIPTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Start Date feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addStartDatePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_startDate_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_startDate_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__START_DATE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the End Date feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addEndDatePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_endDate_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_endDate_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__END_DATE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Leader feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addLeaderPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_leader_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_leader_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__LEADER, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Participants feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addParticipantsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_participants_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_participants_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__PARTICIPANTS, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Effort feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addEffortPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_effort_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_effort_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__EFFORT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Progress feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addProgressPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_progress_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_progress_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__PROGRESS, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Calculation Option feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addCalculationOptionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_calculationOption_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_calculationOption_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__CALCULATION_OPTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Duration feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDurationPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_Workpackage_duration_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Workpackage_duration_feature", "_UI_Workpackage_type"),
                PepperPackage.Literals.WORKPACKAGE__DURATION, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
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
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(PepperPackage.Literals.DEPENDENCY_RELATED_OBJECT__DEPENDENCIES);
            childrenFeatures.add(PepperPackage.Literals.WORKPACKAGE__OUTPUTS);
            childrenFeatures.add(PepperPackage.Literals.WORKPACKAGE__OWNED_TASKS);
            childrenFeatures.add(PepperPackage.Literals.WORKPACKAGE__OWNED_OBJECTIVES);
        }
        return childrenFeatures;
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
     * This returns Workpackage.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, this.getClass().getClassLoader().getResource("icons/full/obj16/Workpackage.svg"));
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
        String label = ((Workpackage) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_Workpackage_type") : getString("_UI_Workpackage_type") + " " + label;
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

        switch (notification.getFeatureID(Workpackage.class)) {
            case PepperPackage.WORKPACKAGE__NAME:
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
            case PepperPackage.WORKPACKAGE__START_DATE:
            case PepperPackage.WORKPACKAGE__END_DATE:
            case PepperPackage.WORKPACKAGE__EFFORT:
            case PepperPackage.WORKPACKAGE__PROGRESS:
            case PepperPackage.WORKPACKAGE__CALCULATION_OPTION:
            case PepperPackage.WORKPACKAGE__DURATION:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case PepperPackage.WORKPACKAGE__DEPENDENCIES:
            case PepperPackage.WORKPACKAGE__OUTPUTS:
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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
     * @generated NOT
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(getString("_UI_New") + " " + getString("_UI_Task_type"));
        if (object instanceof Workpackage workpackage) {
            Optional<Task> optionalTask = workpackage.getOwnedTasks().stream().reduce((first, second) -> second)
                    .filter(filteredTask -> filteredTask.getEndTime() != null && filteredTask.getStartTime() != null);

            if (optionalTask.isPresent()) {
                Task lastTask = optionalTask.get();
                task.setStartTime(lastTask.getEndTime());
                task.setEndTime(Instant.ofEpochSecond(2 * lastTask.getEndTime().getEpochSecond() - lastTask.getStartTime().getEpochSecond()));
            } else {
                String localDateToInstantString = "T00:00:00.00Z";
                if (workpackage.getEndDate() != null && workpackage.getStartDate() != null) {
                    String endTime = workpackage.getEndDate().toString() + localDateToInstantString;
                    String startTime = workpackage.getStartDate().toString() + localDateToInstantString;
                    Instant endInstant = Instant.parse(endTime);
                    Instant startInstant = Instant.parse(startTime);
                    task.setStartTime(startInstant);
                    task.setEndTime(endInstant);
                }
            }
        }

        newChildDescriptors.add(this.createChildParameter(PepperPackage.Literals.WORKPACKAGE__OWNED_TASKS, task));

        newChildDescriptors.add(this.createChildParameter(PepperPackage.Literals.WORKPACKAGE__OUTPUTS, PepperFactory.eINSTANCE.createWorkpackageArtefact()));

        newChildDescriptors.add(this.createChildParameter(PepperPackage.Literals.WORKPACKAGE__OWNED_OBJECTIVES, PepperFactory.eINSTANCE.createObjective()));
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

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

package fr.cea.deeplab.projectmanagement.starter.services.descriptions;
import fr.cea.deeplab.projectmanagement.starter.messages.IProjectManagementMessageService;
import fr.cea.deeplab.projectmanagement.starter.messages.MessageConstants;
import fr.cea.deeplab.projectmgmt.Organization;
import fr.cea.deeplab.projectmgmt.Project;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IObjectService;
import org.eclipse.sirius.components.emf.forms.EMFFormDescriptionProvider;
import org.eclipse.sirius.components.emf.forms.EStructuralFeatureLabelProvider;
import org.eclipse.sirius.components.forms.CheckboxStyle;
import org.eclipse.sirius.components.forms.ContainerBorderLineStyle;
import org.eclipse.sirius.components.forms.ContainerBorderStyle;
import org.eclipse.sirius.components.forms.FlexDirection;
import org.eclipse.sirius.components.forms.LabelWidgetStyle;
import org.eclipse.sirius.components.forms.MultiSelectStyle;
import org.eclipse.sirius.components.forms.SelectStyle;
import org.eclipse.sirius.components.forms.TextareaStyle;
import org.eclipse.sirius.components.forms.TextfieldStyle;
import org.eclipse.sirius.components.forms.WidgetGridLayout;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.components.SelectComponent;
import org.eclipse.sirius.components.forms.description.AbstractControlDescription;
import org.eclipse.sirius.components.forms.description.CheckboxDescription;
import org.eclipse.sirius.components.forms.description.FlexboxContainerDescription;
import org.eclipse.sirius.components.forms.description.LabelDescription;
import org.eclipse.sirius.components.forms.description.MultiSelectDescription;
import org.eclipse.sirius.components.forms.description.SelectDescription;
import org.eclipse.sirius.components.forms.description.TextareaDescription;
import org.eclipse.sirius.components.forms.description.TextfieldDescription;
import org.eclipse.sirius.components.representations.Failure;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.Message;
import org.eclipse.sirius.components.representations.MessageLevel;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.tables.components.SelectCellComponent;
import org.eclipse.sirius.components.tables.descriptions.ColumnDescription;
import org.eclipse.sirius.components.tables.descriptions.ICellDescription;
import org.eclipse.sirius.components.tables.descriptions.MultiSelectCellDescription;
import org.eclipse.sirius.components.tables.descriptions.SelectCellDescription;
import org.eclipse.sirius.components.tables.descriptions.TextfieldCellDescription;
import org.eclipse.sirius.components.tables.elements.MultiSelectCellElementProps;
import org.eclipse.sirius.components.tables.elements.SelectCellElementProps;
import org.eclipse.sirius.components.tables.elements.TextfieldCellElementProps;

/**
 * Helper for building widget descriptions.
 * @author lfasani
 */
public class WidgetDescriptionBuilderHelper {

    private final Function<VariableManager, String> semanticTargetIdProvider;

    private final IObjectService objectService;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IProjectManagementMessageService projectManagementMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    public WidgetDescriptionBuilderHelper(Function<VariableManager, String> semanticTargetIdProvider, IObjectService objectService, ComposedAdapterFactory composedAdapterFactory,
            IProjectManagementMessageService projectManagementMessageService, IFeedbackMessageService feedbackMessageService) {
        this.semanticTargetIdProvider = semanticTargetIdProvider;
        this.objectService = objectService;
        this.composedAdapterFactory = composedAdapterFactory;
        this.projectManagementMessageService = projectManagementMessageService;
        this.feedbackMessageService = feedbackMessageService;
    }

    FlexboxContainerDescription buildFlexboxContainerDescription(List<AbstractControlDescription> children) {
        return FlexboxContainerDescription.newFlexboxContainerDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(vm -> "")
                .labelProvider(vm -> "")
                .flexDirection(FlexDirection.column)
                .children(children)
                .borderStyleProvider(vm -> ContainerBorderStyle.newContainerBorderStyle()
                        .lineStyle(ContainerBorderLineStyle.Solid)
                        .size(2)
                        .color("theme.palette.text.primary")
                        .radius(6)
                        .build())
                .diagnosticsProvider(vm -> List.of()).kindProvider(object -> "").messageProvider(object -> "").build();
    }

    LabelDescription buildLabelDescription(String label) {
        LabelWidgetStyle labelWidgetStyle = LabelWidgetStyle.newLabelWidgetStyle()
                .fontSize(16)
                .italic(false)
                .bold(true)
                .underline(false)
                .strikeThrough(false)
                .build();

        return LabelDescription.newLabelDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(variableManager -> "")
                .valueProvider(variableManager -> label)
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(diagnostic -> "")
                .messageProvider(diagnostic -> "")
                .styleProvider(variableManager -> labelWidgetStyle)
                .build();
    }

    TextareaDescription buildTextareaDescription(EStructuralFeature feature, Function<Project, String> valueProvider, BiConsumer<Project, String> newValueHandler, String helpMessageKey) {
        TextareaDescription.Builder builder = TextareaDescription.newTextareaDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(this.getLabelProvider(feature))
                .isReadOnlyProvider(variableManager -> false)
                .valueProvider(variableManager -> variableManager.get(VariableManager.SELF, Project.class).map(valueProvider).orElse(""))
                .newValueHandler((variableManager, newValue) -> {
                    Project project = variableManager.get(VariableManager.SELF, Project.class).get();
                    newValueHandler.accept(project, newValue);
                    return new Success();
                })

                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(diagnostic -> "")
                .styleProvider(variableManager -> TextareaStyle.newTextareaStyle().widgetGridLayout(this.buildWidgetGridLayout()).build())
                .messageProvider(diagnostic -> "");

        if (helpMessageKey != null) {
            builder.helpTextProvider(vm -> this.projectManagementMessageService.getMessage(helpMessageKey));
        }

        return builder.build();
    }

    WidgetGridLayout buildWidgetGridLayout() {
        return WidgetGridLayout.newWidgetGridLayout()
                .gridTemplateColumns("min(max(13em,30%),40%) auto")
                .gridTemplateRows("")
                .labelGridColumn("")
                .labelGridRow("")
                .widgetGridRow("")
                .widgetGridColumn("")
                .gap("8px")
                .build();
    }


    TextfieldDescription buildTextfieldDescription(EStructuralFeature feature) {
        return this.buildTextfieldDescription(feature, null, null, false);
    }

    TextfieldDescription buildTextfieldDescription(EStructuralFeature feature, String helpMessage, TextfieldStyle textfieldStyle, Boolean isReadOnly) {
        TextfieldDescription.Builder builder = TextfieldDescription.newTextfieldDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(this.getLabelProvider(feature))
                .isReadOnlyProvider(variableManager -> false)
                .valueProvider(variableManager -> {
                    return variableManager.get(VariableManager.SELF, Project.class)
                            .map(project -> {
                                return Optional.ofNullable(project.eGet(feature)).map(Object::toString).orElse(null);
                            })
                            .orElse("");
                })
                .newValueHandler((variableManager, newValue) -> {
                    Project project = variableManager.get(VariableManager.SELF, Project.class).get();
                    try {
                        if (newValue == null || newValue.isBlank()) {
                            project.eSet(feature, null);
                        } else if (feature.getEType().equals(EcorePackage.Literals.EINT) || feature.getEType().equals(EcorePackage.Literals.EINTEGER_OBJECT)) {
                            project.eSet(feature, Integer.parseInt(newValue));
                        } else if (feature.getEType().equals(EcorePackage.Literals.EDOUBLE) || feature.getEType().equals(EcorePackage.Literals.EDOUBLE_OBJECT)) {
                            project.eSet(feature, Double.parseDouble(newValue));
                        } else if (feature.getEType().equals(EcorePackage.Literals.ESTRING)) {
                            project.eSet(feature, newValue);
                        }
                    } catch (NumberFormatException e) {
                        return new Failure(List.of(new Message(this.projectManagementMessageService.getMessage(MessageConstants.INVALID_VALUE, newValue), MessageLevel.ERROR)));
                    }
                    return new Success();
                })
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(diagnostic -> "")
                .isReadOnlyProvider(variableManager -> isReadOnly)
                .messageProvider(diagnostic -> "")
                .styleProvider(variableManager -> TextfieldStyle.newTextfieldStyle().widgetGridLayout(this.buildWidgetGridLayout()).build());

        if (textfieldStyle != null) {
            builder.styleProvider(variableManager -> textfieldStyle);
        }

        if (helpMessage != null) {
            builder.helpTextProvider(variableManager -> helpMessage);
        }

        return builder.build();
    }

    CheckboxDescription getCheckboxDescription(EStructuralFeature feature, Function<Project, Boolean> valueProvider, BiConsumer<Project, Boolean> newValueHandler, boolean isReadOnly) {
        return CheckboxDescription.newCheckboxDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(this.getLabelProvider(feature)).isReadOnlyProvider(variableManager -> false)
                .valueProvider(variableManager -> variableManager.get(VariableManager.SELF, Project.class).map(valueProvider).orElse(true))
                .newValueHandler((variableManager, newValue) -> {
                    Project project = variableManager.get(VariableManager.SELF, Project.class).get();
                    newValueHandler.accept(project, newValue);
                    return new Success();
                }).diagnosticsProvider(variableManager -> List.of())
                .isReadOnlyProvider(variableManager -> isReadOnly)
                .kindProvider(diagnostic -> "")
                .messageProvider(diagnostic -> "")
                .styleProvider(variableManager -> CheckboxStyle.newCheckboxStyle().widgetGridLayout(this.buildWidgetGridLayout()).build())
                .build();
    }

    SelectDescription buildSelectDescriptionForProjectResource(EStructuralFeature feature, String helpText) {
        Class<?> instanceClass = feature.getEType().getInstanceClass();
        SelectDescription.Builder builder = SelectDescription.newSelectDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(this.getLabelProvider(feature))
                .valueProvider(variableManager -> variableManager.get(VariableManager.SELF, Project.class).map(project -> project.eGet(feature)).map(this.objectService::getId).orElse(""))
                .optionIdProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, instanceClass).map(this.objectService::getId).orElse(""))
                .optionLabelProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, instanceClass).map(this.objectService::getLabel).orElse(""))
                .optionsProvider(variableManager -> variableManager.get(VariableManager.SELF, Project.class)
                        .map(EObject::eContainer)
                        .map(Organization.class::cast).stream()
                        .flatMap(org -> org.getOwnedResourceFolders()
                                .stream())
                        .flatMap(resourceFolder -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(resourceFolder.eAllContents(), Spliterator.ORDERED), false))
                        .filter(instanceClass::isInstance)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
                        .stream()
                        .toList())
                .newValueHandler((variableManager, newValue) -> {
                    var optionalEditingContext = variableManager.get(IEditingContext.EDITING_CONTEXT, IEditingContext.class);
                    if (optionalEditingContext.isPresent()) {
                        variableManager.get(VariableManager.SELF, Project.class).ifPresent(project -> {
                            if (newValue == null || newValue.isBlank()) {
                                project.eSet(feature, null);
                            } else {
                                this.objectService.getObject(optionalEditingContext.get(), newValue)
                                        .filter(instanceClass::isInstance)
                                        .map(instanceClass::cast)
                                        .ifPresent(object -> project.eSet(feature, object));
                            }
                        });
                    }
                    return new Success();
                })
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(diagnostic -> "")
                .messageProvider(diagnostic -> "")
                .styleProvider(variableManager -> SelectStyle.newSelectStyle().widgetGridLayout(this.buildWidgetGridLayout()).build());

        if (helpText != null) {
            builder.helpTextProvider(vm -> helpText);
        }

        return builder.build();
    }

    MultiSelectDescription buildMultiSelectDescriptionForProjectResource(EStructuralFeature feature, String helpText) {
        Class<?> instanceClass = feature.getEType().getInstanceClass();
        MultiSelectDescription.Builder builder = MultiSelectDescription.newMultiSelectDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(this.getLabelProvider(feature))
                .valuesProvider(variableManager -> variableManager.get(VariableManager.SELF, Project.class)
                        .stream()
                        .map(project -> project.eGet(feature))
                        .filter(Collection.class::isInstance)
                        .map(Collection.class::cast)
                        .flatMap(Collection::stream)
                        .map(this.objectService::getId)
                        .toList())
                .optionIdProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, instanceClass).map(this.objectService::getId).orElse(""))
                .optionLabelProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, instanceClass).map(this.objectService::getLabel).orElse(""))
                .optionsProvider(variableManager -> variableManager.get(VariableManager.SELF, Project.class)
                        .map(EObject::eContainer)
                        .map(Organization.class::cast).stream()
                        .flatMap(org -> org.getOwnedResourceFolders()
                                .stream())
                        .flatMap(resourceFolder -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(resourceFolder.eAllContents(), Spliterator.ORDERED), false))
                        .filter(instanceClass::isInstance)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
                        .stream()
                        .toList())
                .newValuesHandler((variableManager, newValues) -> {
                    var optionalEditingContext = variableManager.get(IEditingContext.EDITING_CONTEXT, IEditingContext.class);
                    if (optionalEditingContext.isPresent()) {
                        variableManager.get(VariableManager.SELF, Project.class).ifPresent(project -> {
                            if (newValues == null || newValues.isEmpty()) {
                                ((Collection<?>) project.eGet(feature)).clear();
                            } else {
                                Collection<Object> currentObjectValues = (Collection<Object>) project.eGet(feature);
                                List<Object> newObjectValues = newValues.stream()
                                        .map(newValue -> this.objectService.getObject(optionalEditingContext.get(), newValue))
                                        .filter(Optional::isPresent)
                                        .map(Optional::get)
                                        .toList();

                                newObjectValues.stream()
                                        .filter(object -> !currentObjectValues.contains(object))
                                        .forEach(currentObjectValues::add);
                                currentObjectValues.removeIf(client -> !newObjectValues.contains(client));
                            }
                        });
                    }
                    return new Success();
                })
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(diagnostic -> "")
                .messageProvider(diagnostic -> "")
                .styleProvider(variableManager -> MultiSelectStyle.newMultiSelectStyle().widgetGridLayout(this.buildWidgetGridLayout()).build());

        if (helpText != null) {
            builder.helpTextProvider(vm -> helpText);
        }

        return builder.build();
    }

    private Function<VariableManager, String> getLabelProvider(EStructuralFeature feature) {
        return new EStructuralFeatureLabelProvider(EMFFormDescriptionProvider.ESTRUCTURAL_FEATURE, this.composedAdapterFactory) {
            @Override
            public String apply(VariableManager variableManager) {
                VariableManager childVM = variableManager.createChild();
                childVM.put(EMFFormDescriptionProvider.ESTRUCTURAL_FEATURE, feature);
                return super.apply(childVM);
            }
        };
    }

    ColumnDescription buildFeaturesColumnDescription(EObject eObject) {
        Map<EStructuralFeature, String> featureToDisplayName = this.getColumnsStructuralFeaturesDisplayName(eObject);

        ColumnDescription columnDescription = ColumnDescription.newColumnDescription("features")
                .semanticElementsProvider(vm -> featureToDisplayName.keySet().stream().map(Object.class::cast).toList())
                .headerLabelProvider(vm -> vm.get(VariableManager.SELF, EStructuralFeature.class).map(featureToDisplayName::get).orElse(""))
                .targetObjectIdProvider(vm -> vm.get(VariableManager.SELF, EStructuralFeature.class).map(EStructuralFeature::getName).orElse(""))
                .targetObjectKindProvider(vm -> "")
                .headerIconURLsProvider(vm -> List.of())
                .headerIndexLabelProvider(vm -> "")
                .shouldRenderPredicate(vm -> true)
                .initialWidthProvider(vm -> 40)
                .isResizablePredicate(vm -> true)
                .filterVariantProvider(vm -> "")
                .build();
        return columnDescription;
    }

    private Map<EStructuralFeature, String> getColumnsStructuralFeaturesDisplayName(EObject eObject) {
        Map<EStructuralFeature, String> featureToDisplayName = new LinkedHashMap<>();
        EList<EStructuralFeature> eAllStructuralFeatures = eObject.eClass().getEAllStructuralFeatures();
        List<EStructuralFeature> eAllStructuralFeaturesFiltered = eAllStructuralFeatures.stream().filter(feature -> !feature.getName().equals("name")).toList();
        for (EStructuralFeature eSF : eAllStructuralFeaturesFiltered) {
            if (eSF instanceof EAttribute && !eSF.isMany() && !eSF.isDerived()) {
                featureToDisplayName.put(eSF, this.getDisplayName(eObject, eSF));
            } else if (eSF instanceof EReference ref && !eSF.isDerived() && !ref.isContainment()) {
                featureToDisplayName.put(eSF, this.getDisplayName(eObject, eSF));
            }
        }
        return featureToDisplayName;
    }

    private String getDisplayName(EObject eObject, EStructuralFeature eStructuralFeature) {
        Adapter adapter = this.composedAdapterFactory.adapt(eObject, IItemPropertySource.class);
        if (adapter instanceof IItemPropertySource itemPropertySource) {
            IItemPropertyDescriptor descriptor = itemPropertySource.getPropertyDescriptor(eObject, eStructuralFeature);
            if (descriptor != null) {
                String displayName = descriptor.getDisplayName(eStructuralFeature);
                return displayName;
            }
        }
        return eStructuralFeature.getName();
    }

    List<ICellDescription> buildCellDescription() {
        List<ICellDescription> iCellDescriptionList = new ArrayList<>();
        iCellDescriptionList.add(
                SelectCellDescription.newSelectCellDescription("select cells")
                        .canCreatePredicate(this.canCreateCellProvider(SelectCellElementProps.TYPE))
                        .targetObjectIdProvider(vm -> "")
                        .targetObjectKindProvider(vm -> "")
                        .cellValueProvider(this.getCellValueProvider())
                        .cellOptionsIdProvider(this.getCellOptionsIdProvider())
                        .cellOptionsLabelProvider(this.getCellOptionsLabelProvider())
                        .cellOptionsProvider(this.getCellOptionsProvider())
                        .build()
        );
        iCellDescriptionList.add(
                MultiSelectCellDescription.newMultiSelectCellDescription("multi cells")
                        .targetObjectIdProvider(vm -> "")
                        .targetObjectKindProvider(vm -> "")
                        .canCreatePredicate(this.canCreateCellProvider(MultiSelectCellElementProps.TYPE))
                        .cellValueProvider(this.getMultiCellValueProvider())
                        .cellOptionsIdProvider(this.getCellOptionsIdProvider())
                        .cellOptionsLabelProvider(this.getCellOptionsLabelProvider())
                        .cellOptionsProvider(this.getCellOptionsProvider())
                        .build()
        );
        iCellDescriptionList.add(
                TextfieldCellDescription.newTextfieldCellDescription("text cells")
                        .targetObjectIdProvider(vm-> "")
                        .targetObjectKindProvider(vm-> "")
                        .canCreatePredicate(this.canCreateCellProvider(TextfieldCellElementProps.TYPE))
                        .cellValueProvider(this.getCellValueProvider())
                        .build());
        return iCellDescriptionList;
    }

    BiFunction<VariableManager, Object, String> getCellValueProvider() {
        return (variableManager, columnTargetObject) -> {
            Object value = "";
            Optional<EObject> optionalEObject = variableManager.get(VariableManager.SELF, EObject.class);
            if (optionalEObject.isPresent() && columnTargetObject instanceof EStructuralFeature eStructuralFeature) {
                EObject eObject = optionalEObject.get();
                Object objectValue = eObject.eGet(eStructuralFeature);
                if (eStructuralFeature instanceof EReference eReference) {
                    if (eReference.isMany() && !eReference.isContainment() && objectValue instanceof EList<?>) {
                        value = ((EList<?>) objectValue).stream().map(this.objectService::getId).collect(Collectors.toList());
                    } else if (!eReference.isMany() && !eReference.isContainment()) {
                        value = this.objectService.getId(objectValue);
                    }
                } else if (objectValue != null) {
                    if (objectValue instanceof Enumerator enumerator) {
                        value =  enumerator.getName();
                    } else {
                        value = objectValue.toString();
                    }
                }
            }
            return Optional.ofNullable(value)
                    .map(Object::toString)
                    .orElse("");
        };
    }

    BiFunction<VariableManager, Object, List<String>> getMultiCellValueProvider() {
        return (variableManager, columnTargetObject) -> {
            Object value = "";
            Optional<EObject> optionalEObject = variableManager.get(VariableManager.SELF, EObject.class);
            if (optionalEObject.isPresent() && columnTargetObject instanceof EStructuralFeature eStructuralFeature) {
                EObject eObject = optionalEObject.get();
                Object objectValue = eObject.eGet(eStructuralFeature);
                if (eStructuralFeature instanceof EReference eReference) {
                    if (eReference.isMany() && !eReference.isContainment() && objectValue instanceof EList<?>) {
                        value = ((EList<?>) objectValue).stream().map(this.objectService::getId).collect(Collectors.toList());
                    } else if (!eReference.isMany() && !eReference.isContainment()) {
                        value = this.objectService.getId(objectValue);
                    }
                } else if (objectValue != null) {
                    if (objectValue instanceof Enumerator enumerator) {
                        value =  enumerator.getName();
                    } else {
                        value = objectValue.toString();
                    }
                }
            }
            return List.of(Optional.ofNullable(value)
                    .map(Object::toString)
                    .orElse(""));
        };
    }

    Predicate<VariableManager> canCreateCellProvider(String requiredCellType) {
        return (variableManager) -> {
            String type = "";
            Optional<EStructuralFeature> columnTargetObject = variableManager.get("columnTargetObject", EStructuralFeature.class);
            Optional<EObject> optionalEObject = variableManager.get(VariableManager.SELF, EObject.class);
            if (optionalEObject.isPresent() && columnTargetObject.isPresent()) {
                EStructuralFeature eStructuralFeature = columnTargetObject.get();
                EClassifier eType = eStructuralFeature.getEType();
                if (eStructuralFeature instanceof EAttribute) {
                    if (eType instanceof EEnum) {
                        type = SelectCellElementProps.TYPE;
                    }
                } else {
                    EReference eReference = (EReference) eStructuralFeature;
                    if (eReference.isMany() && !eReference.isContainment()) {
                        type = MultiSelectCellElementProps.TYPE;
                    }
                    if (!eReference.isMany() && !eReference.isContainment()) {
                        type = SelectCellElementProps.TYPE;
                    }
                }
                if (type.isEmpty()) {
                    type = TextfieldCellElementProps.TYPE;
                }
            }
            return requiredCellType.equals(type);
        };
    }

    Function<VariableManager, String> getCellOptionsIdProvider() {
        return variableManager -> {
            Object candidate = variableManager.getVariables().get(SelectCellComponent.CANDIDATE_VARIABLE);
            if (candidate instanceof EEnumLiteral) {
                return this.objectService.getLabel(candidate);
            }
            return this.objectService.getId(candidate);
        };
    }

    Function<VariableManager, String> getCellOptionsLabelProvider() {
        return  variableManager -> {
            Object candidate = variableManager.getVariables().get(SelectCellComponent.CANDIDATE_VARIABLE);
            if (candidate instanceof EEnumLiteral) {
                return this.objectService.getLabel(candidate);
            }
            return this.objectService.getLabel(candidate);
        };
    }

    BiFunction<VariableManager, Object, List<Object>> getCellOptionsProvider() {
        return (variableManager, columnTargetObject) -> {
            List<Object> options = new ArrayList<>();
            Optional<EObject> optionalEObject = variableManager.get(VariableManager.SELF, EObject.class);
            if (optionalEObject.isPresent() && columnTargetObject instanceof EStructuralFeature eStructuralFeature) {
                EObject eObject = optionalEObject.get();
                EClassifier eType = eStructuralFeature.getEType();
                if (eType instanceof EEnum) {
                    options.addAll(((EEnum) eType).getELiterals());
                } else {
                    Optional<Organization> organizationOpt = Optional.empty();
                    EObject current = optionalEObject.get();
                    while (current != null && organizationOpt.isEmpty()) {
                        current = current.eContainer();
                        if (current instanceof Organization organization) {
                            organizationOpt = Optional.of(organization);
                        }
                    }
                    return organizationOpt.stream()
                            .flatMap(org -> org.getOwnedResourceFolders()
                                    .stream())
                            .flatMap(resourceFolder -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(resourceFolder.eAllContents(), Spliterator.ORDERED), false))
                            .filter(eObj -> eType.getInstanceClass().isInstance(eObj))
                            .collect(Collectors.toCollection(LinkedHashSet::new))
                            .stream()
                            .map(Object.class::cast)
                            .toList();
                }
            }
            return options;
        };
    }

    BiFunction<VariableManager, Object, IStatus> getNewCellValueHandler() {
        BiFunction<VariableManager, Object, IStatus> newCellValueHandler = (variableManager, newValue) -> {
            IStatus status = new Failure("");
            var optionalEObject = variableManager.get(VariableManager.SELF, EObject.class);
            var optionalEditingContext = variableManager.get(IEditingContext.EDITING_CONTEXT, IEditingContext.class);
            var optionalFeatureName = variableManager.get(ColumnDescription.COLUMN_TARGET_OBJECT_ID, String.class);
            if (optionalEObject.isPresent() && optionalFeatureName.isPresent()) {
                EObject eObject = optionalEObject.get();
                String featureName = optionalFeatureName.get();
                EStructuralFeature eStructuralFeature = eObject.eClass().getEStructuralFeature(featureName);
                if (eStructuralFeature != null) {
                    EClassifier eType = eStructuralFeature.getEType();
                    if (eStructuralFeature.isMany() && eType instanceof EClass && newValue instanceof Collection<?>) {
                        EList<EObject> refElements = (EList<EObject>) eObject.eGet(eStructuralFeature);
                        List<EObject> newValuesToSet = new ArrayList<>();
                        List<String> newValues = ((Collection<?>) newValue).stream().map(elt -> elt.toString()).collect(Collectors.toList());
                        for (String newStringValue : newValues) {
                            var optionalNewValueToSet = this.objectService.getObject(optionalEditingContext.get(), newStringValue);
                            if (optionalNewValueToSet.isEmpty()) {
                                continue;
                            }
                            EObject newValueToSet = (EObject) optionalNewValueToSet.get();
                            newValuesToSet.add(newValueToSet);
                            try {
                                if (!refElements.contains(newValueToSet)) {
                                    refElements.add(newValueToSet);
                                }
                            } catch (IllegalArgumentException | ClassCastException | ArrayStoreException exception) {
                                return new Failure("");
                            }
                        }
                        refElements.removeIf(refElt -> !newValuesToSet.contains(refElt));
                        status = new Success();
                    } else if (!eStructuralFeature.isMany()) {
                        status = this.handleNewValueForMonoValue(newValue, eType, optionalEditingContext, eObject, eStructuralFeature);
                    } else {
                        status = new Failure("Not handled");
                    }

                }
            }

            //Workaround because the xxxEditCellHandler does not handle the returned IStatus
            if (status instanceof Failure failure) {
                failure.getMessages().forEach(this.feedbackMessageService::addFeedbackMessage);
                status =  new Failure("");
            }
            return status;
        };
        return newCellValueHandler;
    }

    private IStatus handleNewValueForMonoValue(Object newValue, EClassifier eType, Optional<IEditingContext> optionalEditingContext, EObject eObject, EStructuralFeature eStructuralFeature) {
        IStatus status = new Failure(this.projectManagementMessageService.getMessage(MessageConstants.INVALID_VALUE, newValue.toString()));
        if (eType instanceof EClass && newValue instanceof String newStringValue) {
            var optionalNewValueToSet = this.objectService.getObject(optionalEditingContext.get(), newStringValue);
            if (optionalNewValueToSet.isPresent()) {
                eObject.eSet(eStructuralFeature, optionalNewValueToSet.get());
                status = new Success();
            }
        } else if (eType instanceof EEnum enumType && newValue instanceof String newValueString) {
            if (newValueString.isBlank()) {
                eObject.eUnset(eStructuralFeature);
            } else {
                EEnumLiteral eEnumLiteral = enumType.getEEnumLiteral(newValueString);
                eObject.eSet(eStructuralFeature, eEnumLiteral.getInstance());
                status = new Success();
            }
        } else if (eType.getInstanceClass().equals(LocalDate.class)) {
            if (newValue.toString().isBlank()) {
                eObject.eUnset(eStructuralFeature);
                status = new Success();
            } else {
                try {
                    LocalDate localDate = LocalDate.parse(newValue.toString());
                    eObject.eSet(eStructuralFeature, localDate);
                    status = new Success();
                } catch (DateTimeParseException e) {
                }
            }
        } else if (eType instanceof EDataType) {
            String newValueAsString = EcoreUtil.convertToString((EDataType) eStructuralFeature.getEType(), newValue);
            try {
                Object value = EcoreUtil.createFromString((EDataType) eStructuralFeature.getEType(), newValueAsString);
                eObject.eSet(eStructuralFeature, value);
                status = new Success();
            } catch (IllegalArgumentException e) {
            }
        }

        return status;
    }
}

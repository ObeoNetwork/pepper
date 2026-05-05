/*******************************************************************************
 * Copyright (c) 2026 Obeo.
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

package pepper.starter.services;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.sirius.components.collaborative.forms.services.api.IPropertiesDescriptionRegistry;
import org.eclipse.sirius.components.collaborative.forms.services.api.IPropertiesDescriptionRegistryConfigurer;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.forms.DateTimeType;
import org.eclipse.sirius.components.forms.components.SelectComponent;
import org.eclipse.sirius.components.forms.description.AbstractControlDescription;
import org.eclipse.sirius.components.forms.description.DateTimeDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.RadioDescription;
import org.eclipse.sirius.components.forms.description.TextfieldDescription;
import org.eclipse.sirius.components.representations.Failure;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.view.emf.compatibility.IPropertiesWidgetCreationService;
import org.eclipse.sirius.components.view.emf.compatibility.PropertiesConfigurerService;
import org.eclipse.sirius.components.widget.reference.ReferenceWidgetComponent;
import org.eclipse.sirius.components.widget.reference.ReferenceWidgetDescription;
import org.springframework.stereotype.Service;

import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;
import pepper.peppermm.provider.PepperItemProviderAdapterFactory;

/**
 * Customizes the properties view for {@link Workpackage} sub classes.
 *
 * @author ncouvert
 */
@Service
public class WorkpackagePropertiesConfigurer implements IPropertiesDescriptionRegistryConfigurer {

    private final IIdentityService identityService;

    private final IPropertiesWidgetCreationService propertiesWidgetCreationService;

    private final PropertiesConfigurerService propertiesConfigurerService;

    private final ILabelService labelService;

    private final PepperItemProviderAdapterFactory pepperItemProviderAdapterFactory = new PepperItemProviderAdapterFactory();

    private final ItemProviderAdapter workpackageAdapter = (ItemProviderAdapter) pepperItemProviderAdapterFactory.createWorkpackageAdapter();

    public WorkpackagePropertiesConfigurer(IIdentityService identityService, PropertiesConfigurerService propertiesConfigurerService, IPropertiesWidgetCreationService propertiesWidgetCreationService, ILabelService labelService) {
        this.identityService = identityService;
        this.propertiesConfigurerService = Objects.requireNonNull(propertiesConfigurerService);
        this.propertiesWidgetCreationService = Objects.requireNonNull(propertiesWidgetCreationService);
        this.labelService = labelService;
    }

    @Override
    public void addPropertiesDescriptions(IPropertiesDescriptionRegistry registry) {
        String formDescriptionId = UUID.nameUUIDFromBytes("workpackage".getBytes()).toString();

        List<AbstractControlDescription> controlsGeneral = new ArrayList<>(this.getGeneralControlDescription());
        List<AbstractControlDescription> controlsRessources = new ArrayList<>(this.getRessourcesControlDescription());

        Predicate<VariableManager> canCreatePagePredicate = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .filter(Workpackage.class::isInstance)
                .isPresent();

        GroupDescription groupDescriptionGeneral = this.propertiesWidgetCreationService.createSimpleGroupDescription(controlsGeneral);
        GroupDescription groupDescriptionRessources = GroupDescription.newGroupDescription("group2")
                .idProvider(variableManager -> "group2")
                .labelProvider(variableManager -> "Ressources")
                .semanticElementsProvider(this.propertiesConfigurerService.getSemanticElementsProvider())
                .controlDescriptions(controlsRessources)
                .build();

        PageDescription pageDescription = PageDescription.newPageDescription(formDescriptionId)
                .idProvider(variableManager -> "page")
                .labelProvider(variableManager -> "Properties")
                .semanticElementsProvider(this.propertiesConfigurerService.getSemanticElementsProvider())
                .canCreatePredicate(canCreatePagePredicate)
                .groupDescriptions(List.of(groupDescriptionGeneral, groupDescriptionRessources))
                .build();

        registry.add(pageDescription);

    }
    private List<AbstractControlDescription> getGeneralControlDescription() {
        List<AbstractControlDescription> controls = new ArrayList<>();

        var name = this.propertiesWidgetCreationService.createTextField("workpackage.name", workpackageAdapter.getString("_UI_Workpackage_name_feature"),
                workpackage -> Optional.ofNullable(((Workpackage) workpackage).getName()).orElse(""),
                (workpackage, newValue) -> {
                    ((Workpackage) workpackage).setName(newValue);
                },
                PepperPackage.Literals.WORKPACKAGE__NAME);
        controls.add(name);

        var description = this.propertiesWidgetCreationService.createExpressionField("workpackage.description", workpackageAdapter.getString("_UI_Workpackage_description_feature"),
                workpackage -> Optional.ofNullable(((Workpackage) workpackage).getDescription()).orElse(""),
                (workpackage, newValue) -> {
                    ((Workpackage) workpackage).setDescription(newValue);
                },
                PepperPackage.Literals.WORKPACKAGE__DESCRIPTION);
        controls.add(description);

        var calculationOption = this.getCalculationOptionWidget();
        controls.add(calculationOption);

        var startDate = this.getStartDateWidget();
        controls.add(startDate);

        var endDate = this.getEndDateWidget();
        controls.add(endDate);

        var duration = this.getDurationWidget();
        controls.add(duration);

        var dependencies = this.getDependenciesWidget();
        controls.add(dependencies);

        var progress = this.propertiesWidgetCreationService.createTextField("workpackage.progress", workpackageAdapter.getString("_UI_Workpackage_progress_feature"),
                workpackage -> String.valueOf(Optional.of(((Workpackage) workpackage).getProgress()).orElse(0)),
                (workpackage, newValue) -> {
                    try {
                        int intValue = Integer.parseInt(newValue);
                        ((Workpackage) workpackage).setProgress(intValue);
                    } catch (NumberFormatException e) {
                        // Ignore
                    }
                },
                PepperPackage.Literals.WORKPACKAGE__PROGRESS);
        controls.add(progress);

        return controls;
    }

    private List<AbstractControlDescription> getRessourcesControlDescription() {
        List<AbstractControlDescription> controls = new ArrayList<>();

        var leader = this.propertiesWidgetCreationService.createReferenceWidget("workpackage.leader", workpackageAdapter.getString("_UI_Workpackage_leader_feature"),
                PepperPackage.Literals.WORKPACKAGE__LEADER, this.getPersonsProvider());
        controls.add(leader);

        var participants = this.propertiesWidgetCreationService.createReferenceWidget("workpackage.participants", workpackageAdapter.getString("_UI_Workpackage_participants_feature"),
                PepperPackage.Literals.WORKPACKAGE__PARTICIPANTS, this.getPersonsProvider());
        controls.add(participants);

        return controls;
    }

    private RadioDescription getCalculationOptionWidget() {
        Function<VariableManager, Boolean> optionSelectedProvider = variableManager -> {
            var optionalTaskTimeBoundariesConstraint = variableManager.get(SelectComponent.CANDIDATE_VARIABLE, TaskTimeBoundariesConstraint.class);
            if (optionalTaskTimeBoundariesConstraint.isPresent()) {
                TaskTimeBoundariesConstraint taskTimeBoundariesConstraint = optionalTaskTimeBoundariesConstraint.get();
                String optionLitteralId = Integer.valueOf(taskTimeBoundariesConstraint.getValue()).toString();
                var optionalValue = variableManager.get(VariableManager.SELF, Workpackage.class)
                        .map(Workpackage::getCalculationOption)
                        .map(TaskTimeBoundariesConstraint::getValue)
                        .map(String::valueOf);
                if (optionalValue.isPresent()) {
                    String value = optionalValue.get();
                    return optionLitteralId.equals(value);
                }
            }
            return false;
        };

        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var workpackageOpt = variableManager.get(VariableManager.SELF, Workpackage.class);
            if (workpackageOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    workpackageOpt.get().setCalculationOption(TaskTimeBoundariesConstraint.START_END);
                } else {
                    int integer = Integer.parseInt(newValue);
                    TaskTimeBoundariesConstraint newConstraint = TaskTimeBoundariesConstraint.get(integer);
                    workpackageOpt.get().setCalculationOption(newConstraint);
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };

        String id = "workpackage.calculationOption";
        return RadioDescription.newRadioDescription(id)
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> workpackageAdapter.getString("_UI_Workpackage_calculationOption_feature"))
                .isReadOnlyProvider(variableManager -> false)
                .optionSelectedProvider(optionSelectedProvider)
                .optionsProvider(variableManager -> TaskTimeBoundariesConstraint.VALUES)
                .optionIdProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, TaskTimeBoundariesConstraint.class)
                        .map(TaskTimeBoundariesConstraint::getValue)
                        .map(String::valueOf)
                        .orElse(""))
                .optionLabelProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, TaskTimeBoundariesConstraint.class)
                        .map(Enumerator::getName)
                        .orElse(""))
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.WORKPACKAGE__CALCULATION_OPTION))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .build();
    }

    private TextfieldDescription getDurationWidget() {
        Function<VariableManager, String> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, Workpackage.class)
                .map(Workpackage::getDuration)
                .map(String::valueOf)
                .orElse("0");
        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var workpackageOpt = variableManager.get(VariableManager.SELF, Workpackage.class);
            if (workpackageOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    workpackageOpt.get().setDuration(0);
                } else {
                    try {
                        int integer = Integer.parseInt(newValue);
                        workpackageOpt.get().setDuration(integer);
                    } catch (NumberFormatException e) {
                        // Ignore
                    }
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };

        String id = "workpackage.duration";
        return TextfieldDescription.newTextfieldDescription(id)
                .isReadOnlyProvider(vm -> vm.get(VariableManager.SELF, Workpackage.class)
                        .map(workpackage -> workpackage.getCalculationOption() == TaskTimeBoundariesConstraint.START_END)
                        .orElse(true))
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> workpackageAdapter.getString("_UI_Workpackage_duration_feature"))
                .valueProvider(valueProvider)
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.WORKPACKAGE__DURATION))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .build();
    }

    private ReferenceWidgetDescription getDependenciesWidget() {
        Object feature = PepperPackage.Literals.DEPENDENCY_RELATED_OBJECT__DEPENDENCIES;

        Function<VariableManager, List<?>> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, Workpackage.class)
                .map(workpackage -> (DependencyRelatedObject) workpackage)
                .map(DependencyRelatedObject::getDependencies)
                .orElse(null);

        Function<VariableManager, String> labelValueProvider = variableManager ->
                this.getItem(variableManager)
                        .map(o -> (DependencyLink) o)
                        .map(link -> {
                            Workpackage workpackage = (Workpackage) link.getSource();
                            String name = workpackage.getName();
                            String sourceKind = link.getSourceKind().toString();
                            String targetKind = link.getTargetKind().toString();
                            int duration = link.getDuration();
                            if (duration != 0) {
                                return name + ": " + sourceKind + " -> " + targetKind + " " + workpackageAdapter.getString("_UI_Workpackage_dependencyDelay_feature") + " : " + duration;
                            }
                            return name + ": " + sourceKind + " -> " + targetKind;
                        })
                        .orElse("");

        String id = "workpackage.dependencies";
        return ReferenceWidgetDescription.newReferenceWidgetDescription(id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .idProvider(variableManager -> id)
                .labelProvider(variableManager -> workpackageAdapter.getString("_UI_DependencyRelatedObject_dependencies_feature"))
                .optionsProvider(valueProvider)
                .iconURLProvider(variableManager -> List.of())
                .itemsProvider(variableManager -> this.getReferenceValue(variableManager, feature))
                .itemIdProvider(variableManager -> this.getItem(variableManager).map(this.identityService::getId).orElse(""))
                .itemKindProvider(variableManager -> "")
                .itemLabelProvider(labelValueProvider)
                .itemIconURLProvider(variableManager -> this.getItem(variableManager).map(this.labelService::getImagePaths).orElse(List.of()))
                .ownerKindProvider(vm -> "")
                .referenceKindProvider(vm -> "")
                .isContainmentProvider(variableManager -> false)
                .isManyProvider(variableManager -> true)
                .isReadOnlyProvider(variableManager -> true)
                .styleProvider(variableManager -> null)
                .ownerIdProvider(variableManager -> variableManager.get(VariableManager.SELF, EObject.class).map(this.identityService::getId).orElse(""))
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(feature))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                //while the widget is Read-only, we can ignore these providers
                .clearHandlerProvider(variableManager -> new Success())
                .setHandlerProvider(variableManager -> new Success())
                .addHandlerProvider(variableManager -> new Success())
                .moveHandlerProvider(variableManager -> new Success())
                .build();
    }

    private Optional<Object> getItem(VariableManager variableManager) {
        return variableManager.get(ReferenceWidgetComponent.ITEM_VARIABLE, Object.class);
    }

    private List<?> getReferenceValue(VariableManager variableManager, Object feature) {
        List<?> value = List.of();
        EStructuralFeature.Setting setting = this.resolveSetting(variableManager, feature);
        if (setting != null) {
            var rawValue = setting.get(true);
            if (setting.getEStructuralFeature().isMany()) {
                value = (List<?>) rawValue;
            } else if (rawValue != null) {
                value = List.of(rawValue);
            } else {
                value = List.of();
            }
        }
        return value;
    }

    private EStructuralFeature.Setting resolveSetting(VariableManager variableManager, Object feature) {
        EObject referenceOwner = variableManager.get(VariableManager.SELF, EObject.class).orElse(null);
        if (referenceOwner != null && feature instanceof EReference reference) {
            return ((InternalEObject) referenceOwner).eSetting(reference);
        } else {
            return null;
        }
    }


    private DateTimeDescription getStartDateWidget() {
        Function<VariableManager, String> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, Workpackage.class)
                .map(workpackage -> {
                    try {
                        LocalDate startDate = workpackage.getStartDate();
                        return DateTimeFormatter.ISO_LOCAL_DATE.format(startDate);
                    } catch (DateTimeException | NullPointerException e) {
                        // Ignore
                    }
                    return "";
                })
                .orElse("");
        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var workpackageOpt = variableManager.get(VariableManager.SELF, Workpackage.class);
            if (workpackageOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    workpackageOpt.get().setStartDate(null);
                } else {
                    try {
                        LocalDate localDate = LocalDate.parse(newValue);
                        workpackageOpt.get().setStartDate(localDate);
                    } catch (DateTimeParseException e) {
                        // Ignore
                    }
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };
        String id = "workpackage.startTime";
        return DateTimeDescription.newDateTimeDescription(id)
                .isReadOnlyProvider(vm -> vm.get(VariableManager.SELF, Workpackage.class)
                        .map(workpackage -> workpackage.getCalculationOption() == TaskTimeBoundariesConstraint.END_DURATION)
                        .orElse(true))
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> workpackageAdapter.getString("_UI_Workpackage_startDate_feature"))
                .stringValueProvider(valueProvider)
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.WORKPACKAGE__START_DATE))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .type(DateTimeType.DATE)
                .build();
    }

    private DateTimeDescription getEndDateWidget() {
        Function<VariableManager, String> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .map(workpackage -> {
                    try {
                        LocalDate endLocalDate = ((Workpackage) workpackage).getEndDate();
                        return DateTimeFormatter.ISO_LOCAL_DATE.format(endLocalDate);
                    } catch (DateTimeException | NullPointerException e) {
                        // Ignore
                    }
                    return "";
                })
                .orElse("");
        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var workpackageOpt = variableManager.get(VariableManager.SELF, Object.class);
            if (workpackageOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    ((Workpackage) workpackageOpt.get()).setEndDate(null);
                } else {
                    try {
                        LocalDate localDate = LocalDate.parse(newValue);
                        ((Workpackage) workpackageOpt.get()).setEndDate(localDate);
                    } catch (DateTimeParseException e) {
                        // Ignore
                    }
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };
        String id = "workpackage.endTime";
        return DateTimeDescription.newDateTimeDescription(id)
                .isReadOnlyProvider(vm -> vm.get(VariableManager.SELF, Workpackage.class)
                        .map(workpackage -> workpackage.getCalculationOption() == TaskTimeBoundariesConstraint.START_DURATION)
                        .orElse(true))
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> workpackageAdapter.getString("_UI_Workpackage_endDate_feature"))
                .stringValueProvider(valueProvider)
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.WORKPACKAGE__END_DATE))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .type(DateTimeType.DATE)
                .build();
    }

    private Function<VariableManager, List<?>> getPersonsProvider() {
        return variableManager -> variableManager.get(VariableManager.SELF, EObject.class)
                .map(EObject::eResource)
                .stream()
                .flatMap(this::getAllResourceContentStream)
                .filter(Person.class::isInstance)
                .map(Person.class::cast)
                .toList();
    }

    private Stream<EObject> getAllResourceContentStream(Resource resource) {
        Iterable<EObject> content = () -> resource.getAllContents();
        return StreamSupport.stream(content.spliterator(), false);
    }
}


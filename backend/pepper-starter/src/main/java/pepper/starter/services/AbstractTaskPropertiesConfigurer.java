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
import java.time.Instant;
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
import org.eclipse.sirius.components.forms.description.CheckboxDescription;
import org.eclipse.sirius.components.forms.description.DateTimeDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.IfDescription;
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

import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Project;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Team;
import pepper.peppermm.provider.PepperItemProviderAdapterFactory;

/**
 * Customizes the properties view for {@link AbstractTask} sub classes.
 *
 * @author lfasani
 */
@Service
public class AbstractTaskPropertiesConfigurer implements IPropertiesDescriptionRegistryConfigurer {

    private final IIdentityService identityService;

    private final IPropertiesWidgetCreationService propertiesWidgetCreationService;

    private final PropertiesConfigurerService propertiesConfigurerService;

    private final ILabelService labelService;

    private final PepperItemProviderAdapterFactory pepperItemProviderAdapterFactory = new PepperItemProviderAdapterFactory();

    private final ItemProviderAdapter abstractTaskAdapter = (ItemProviderAdapter) pepperItemProviderAdapterFactory.createTaskAdapter();

    public AbstractTaskPropertiesConfigurer(IIdentityService identityService, PropertiesConfigurerService propertiesConfigurerService, IPropertiesWidgetCreationService propertiesWidgetCreationService,
            ILabelService labelService) {
        this.identityService = Objects.requireNonNull(identityService);
        this.propertiesConfigurerService = Objects.requireNonNull(propertiesConfigurerService);
        this.propertiesWidgetCreationService = Objects.requireNonNull(propertiesWidgetCreationService);
        this.labelService = labelService;
    }

    @Override
    public void addPropertiesDescriptions(IPropertiesDescriptionRegistry registry) {
        String formDescriptionId = UUID.nameUUIDFromBytes("abstractTask".getBytes()).toString();

        List<AbstractControlDescription> controlsGeneral = new ArrayList<>(this.getGeneralControlDescription());
        List<AbstractControlDescription> controlsRessources = new ArrayList<>(this.getRessourcesControlDescription());

        Predicate<VariableManager> canCreatePagePredicate = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .filter(AbstractTask.class::isInstance)
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

        var name = this.propertiesWidgetCreationService.createTextField("abstractTask.name", abstractTaskAdapter.getString("_UI_AbstractTask_name_feature"),
                task -> Optional.ofNullable(((AbstractTask) task).getName()).orElse(""),
                (task, newValue) -> {
                    ((AbstractTask) task).setName(newValue);
                },
                PepperPackage.Literals.ABSTRACT_TASK__NAME);
        controls.add(name);

        var description = this.propertiesWidgetCreationService.createExpressionField("abstractTask.description", abstractTaskAdapter.getString("_UI_AbstractTask_description_feature"),
                task -> Optional.ofNullable(((AbstractTask) task).getDescription()).orElse(""),
                (task, newValue) -> {
                    ((AbstractTask) task).setDescription(newValue);
                },
                PepperPackage.Literals.ABSTRACT_TASK__DESCRIPTION);
        controls.add(description);

        var calculationOption = this.getCalculationOptionWidget();
        controls.add(calculationOption);

        var startTime = this.getStartTimeWidget();
        controls.add(startTime);

        var endTime = this.getEndTimeWidget();
        controls.add(endTime);

        var duration = this.getDurationWidget();
        controls.add(duration);

        IfDescription ifComputeDynamically = this.createComputeDynamicallyWidget();
        controls.add(ifComputeDynamically);

        var progress = this.propertiesWidgetCreationService.createTextField("abstractTask.progress", abstractTaskAdapter.getString("_UI_AbstractTask_progress_feature"),
                task -> String.valueOf(Optional.of(((AbstractTask) task).getProgress()).orElse(0)),
                (task, newValue) -> {
                    try {
                        int intValue = Integer.parseInt(newValue);
                        ((AbstractTask) task).setProgress(intValue);
                    } catch (NumberFormatException e) {
                        // Ignore
                    }
                },
                PepperPackage.Literals.ABSTRACT_TASK__PROGRESS);
        controls.add(progress);

        var dependencies = this.getDependenciesWidget();
        controls.add(dependencies);

        return controls;
    }

    private List<AbstractControlDescription> getRessourcesControlDescription() {
        List<AbstractControlDescription> controls = new ArrayList<>();

        var tags = this.propertiesWidgetCreationService.createReferenceWidget("abstractTask.tags", abstractTaskAdapter.getString("_UI_AbstractTask_tags_feature"),
                PepperPackage.Literals.ABSTRACT_TASK__TAGS, this.getTagsProvider());
        controls.add(tags);

        var persons = this.propertiesWidgetCreationService.createReferenceWidget("abstractTask.persons", abstractTaskAdapter.getString("_UI_AbstractTask_assignedPersons_feature"),
                PepperPackage.Literals.ABSTRACT_TASK__ASSIGNED_PERSONS, this.getPersonsProvider());
        controls.add(persons);

        var teams = this.propertiesWidgetCreationService.createReferenceWidget("abstractTask.teams", abstractTaskAdapter.getString("_UI_AbstractTask_assignedTeams_feature"),
                PepperPackage.Literals.ABSTRACT_TASK__ASSIGNED_TEAMS, this.getTeamsProvider());
        controls.add(teams);

        return controls;
    }

    private RadioDescription getCalculationOptionWidget() {
        Function<VariableManager, Boolean> optionSelectedProvider = variableManager -> {
            var optionalTaskTimeBoundariesConstraint = variableManager.get(SelectComponent.CANDIDATE_VARIABLE, TaskTimeBoundariesConstraint.class);
            if (optionalTaskTimeBoundariesConstraint.isPresent()) {
                TaskTimeBoundariesConstraint taskTimeBoundariesConstraint = optionalTaskTimeBoundariesConstraint.get();
                String optionLitteralId = Integer.valueOf(taskTimeBoundariesConstraint.getValue()).toString();
                var optionalValue = variableManager.get(VariableManager.SELF, AbstractTask.class)
                        .map(AbstractTask::getCalculationOption)
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
            var taskOpt = variableManager.get(VariableManager.SELF, AbstractTask.class);
            if (taskOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    taskOpt.get().setCalculationOption(TaskTimeBoundariesConstraint.START_END);
                } else {
                    int integer = Integer.parseInt(newValue);
                    TaskTimeBoundariesConstraint newConstraint = TaskTimeBoundariesConstraint.get(integer);
                    taskOpt.get().setCalculationOption(newConstraint);
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };

        String id = "abstractTask.calculationOption";
        return RadioDescription.newRadioDescription(id)
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> abstractTaskAdapter.getString("_UI_AbstractTask_calculationOption_feature"))
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
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.ABSTRACT_TASK__CALCULATION_OPTION))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .build();
    }

    private TextfieldDescription getDurationWidget() {
        Function<VariableManager, String> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, AbstractTask.class)
                .map(AbstractTask::getDuration)
                .map(String::valueOf)
                .orElse("0");
        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var taskOpt = variableManager.get(VariableManager.SELF, AbstractTask.class);
            if (taskOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    taskOpt.get().setDuration(0);
                } else {
                    try {
                        int integer = Integer.parseInt(newValue);
                        taskOpt.get().setDuration(integer);
                    } catch (NumberFormatException e) {
                        // Ignore
                    }
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };

        String id = "abstractTask.duration";
        return TextfieldDescription.newTextfieldDescription(id)
                .isReadOnlyProvider(vm -> vm.get(VariableManager.SELF, AbstractTask.class)
                        .map(task -> task.getCalculationOption() == TaskTimeBoundariesConstraint.START_END)
                        .orElse(true))
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> abstractTaskAdapter.getString("_UI_AbstractTask_duration_feature"))
                .valueProvider(valueProvider)
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.ABSTRACT_TASK__DURATION))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .build();
    }

    private ReferenceWidgetDescription getDependenciesWidget() {
        Object feature = PepperPackage.Literals.DEPENDENCY_RELATED_OBJECT__DEPENDENCIES;

        Function<VariableManager, List<?>> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, AbstractTask.class)
                .map(task -> (DependencyRelatedObject) task)
                .map(DependencyRelatedObject::getDependencies)
                .orElse(null);

        Function<VariableManager, String> labelValueProvider = variableManager ->
                this.getItem(variableManager)
                        .map(o -> (DependencyLink) o)
                        .map(link -> {
                            AbstractTask task = (AbstractTask) link.getSource();
                            String name = task.getName();
                            String sourceKind = link.getSourceKind().toString();
                            String targetKind = link.getTargetKind().toString();
                            int duration = link.getDuration();
                            if (duration != 0) {
                                return name + ": " + sourceKind + " -> " + targetKind + " " + abstractTaskAdapter.getString("_UI_AbstractTask_durationDelay_feature") + " : " + duration;
                            }
                            return name + ": " + sourceKind + " -> " + targetKind;
                        })
                        .orElse("");

        String id = "abstractTask.dependencies";
        return ReferenceWidgetDescription.newReferenceWidgetDescription(id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .idProvider(variableManager -> id)
                .labelProvider(variableManager -> abstractTaskAdapter.getString("_UI_DependencyRelatedObject_dependencies_feature"))
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

    private DateTimeDescription getStartTimeWidget() {
        Function<VariableManager, String> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, AbstractTask.class)
                .map(task -> {
                    try {
                        Instant startInstant = task.getStartTime();
                        return DateTimeFormatter.ISO_INSTANT.format(startInstant);
                    } catch (DateTimeException | NullPointerException e) {
                        // Ignore
                    }
                    return "";
                })
                .orElse("");
        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var taskOpt = variableManager.get(VariableManager.SELF, AbstractTask.class);
            if (taskOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    taskOpt.get().setStartTime(null);
                } else {
                    try {
                        Instant instant = Instant.parse(newValue);
                        taskOpt.get().setStartTime(instant);
                    } catch (DateTimeParseException e) {
                        // Ignore
                    }
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };
        String id = "abstractTask.startTime";
        return DateTimeDescription.newDateTimeDescription(id)
                .isReadOnlyProvider(vm -> vm.get(VariableManager.SELF, AbstractTask.class)
                        .map(task -> task.getCalculationOption() == TaskTimeBoundariesConstraint.END_DURATION)
                        .orElse(true))
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> abstractTaskAdapter.getString("_UI_AbstractTask_startTime_feature"))
                .stringValueProvider(valueProvider)
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.ABSTRACT_TASK__START_TIME))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .type(DateTimeType.DATE_TIME)
                .build();
    }

    private DateTimeDescription getEndTimeWidget() {
        Function<VariableManager, String> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .map(task -> {
                    try {
                        Instant endInstant = ((AbstractTask) task).getEndTime();
                        return DateTimeFormatter.ISO_INSTANT.format(endInstant);
                    } catch (DateTimeException | NullPointerException e) {
                        // Ignore
                    }
                    return "";
                })
                .orElse("");
        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var taskOpt = variableManager.get(VariableManager.SELF, Object.class);
            if (taskOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    ((AbstractTask) taskOpt.get()).setEndTime(null);
                } else {
                    try {
                        Instant instant = Instant.parse(newValue);
                        ((AbstractTask) taskOpt.get()).setEndTime(instant);
                    } catch (DateTimeParseException e) {
                        // Ignore
                    }
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };
        String id = "abstractTask.endTime";
        return DateTimeDescription.newDateTimeDescription(id)
                .isReadOnlyProvider(vm -> vm.get(VariableManager.SELF, AbstractTask.class)
                        .map(task -> task.getCalculationOption() == TaskTimeBoundariesConstraint.START_DURATION)
                        .orElse(true))
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> abstractTaskAdapter.getString("_UI_AbstractTask_endTime_feature"))
                .stringValueProvider(valueProvider)
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.ABSTRACT_TASK__END_TIME))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .type(DateTimeType.DATE_TIME)
                .build();
    }

    private Function<VariableManager, List<?>> getDependenciesProvider() {
        return variableManager -> variableManager.get(VariableManager.SELF, AbstractTask.class)
                .map(this::getProject)
                .stream()
                .flatMap(this::getAllContentStream)
                .filter(Task.class::isInstance)
                .map(Task.class::cast)
                .toList();
    }

    private Project getProject(EObject eObject) {
        EObject parent = eObject.eContainer();
        while (parent != null) {
            if (parent instanceof Project project) {
                return project;
            }
            parent = parent.eContainer();
        }
        return null;
    }

    private IfDescription createComputeDynamicallyWidget() {
        CheckboxDescription computeDynamically = this.propertiesWidgetCreationService.createCheckbox("abstractTask.computeDynamically", abstractTaskAdapter.getString("_UI_AbstractTask_computeStartEndDynamically_feature"),
                task -> ((AbstractTask) task).isComputeStartEndDynamically(),
                (task, newValue) -> ((AbstractTask) task).setComputeStartEndDynamically(newValue),
                PepperPackage.Literals.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY,
                Optional.empty());

        return IfDescription.newIfDescription("if.abstractTask.computeDynamically")
                .targetObjectIdProvider(variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.identityService::getId).orElse(null))
                .predicate(variableManager-> variableManager.get(VariableManager.SELF, AbstractTask.class)
                        .filter(task -> !task.getSubTasks().isEmpty())
                        .isPresent())
                .controlDescriptions(List.of(computeDynamically))
                .build();
    }

    private Function<VariableManager, List<?>> getTagsProvider() {
        return variableManager -> variableManager.get(VariableManager.SELF, EObject.class)
                .map(this::getProject)
                .stream()
                .flatMap(project -> project.getOwnedTagFolders().stream())
                .flatMap(tagFolder -> tagFolder.getOwnedTags().stream())
                .toList();
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

    private Stream<EObject> getAllContentStream(EObject eObject) {
        Iterable<EObject> content = () -> eObject.eAllContents();
        return StreamSupport.stream(content.spliterator(), false);
    }

    private Function<VariableManager, List<?>> getTeamsProvider() {
        return variableManager -> variableManager.get(VariableManager.SELF, EObject.class)
                .map(EObject::eResource)
                .stream()
                .flatMap(this::getAllResourceContentStream)
                .filter(Team.class::isInstance)
                .map(Team.class::cast)
                .toList();
    }
}


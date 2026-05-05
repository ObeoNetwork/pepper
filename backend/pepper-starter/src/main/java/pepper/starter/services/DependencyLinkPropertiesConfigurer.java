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

import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.sirius.components.collaborative.forms.services.api.IPropertiesDescriptionRegistry;
import org.eclipse.sirius.components.collaborative.forms.services.api.IPropertiesDescriptionRegistryConfigurer;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.forms.components.SelectComponent;
import org.eclipse.sirius.components.forms.description.AbstractControlDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.RadioDescription;
import org.eclipse.sirius.components.forms.description.TextfieldDescription;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.eclipse.sirius.components.representations.Failure;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.view.emf.compatibility.IPropertiesWidgetCreationService;
import org.eclipse.sirius.components.view.emf.compatibility.PropertiesConfigurerService;
import org.eclipse.sirius.components.widget.reference.ReferenceWidgetDescription;
import org.springframework.stereotype.Service;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Project;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.Task;
import pepper.peppermm.Workpackage;
import pepper.peppermm.provider.PepperItemProviderAdapterFactory;

/**
 * Customizes the properties view for {@link DependencyLink} sub classes.
 *
 * @author ncouvert
 */
@Service
public class DependencyLinkPropertiesConfigurer implements IPropertiesDescriptionRegistryConfigurer {

    private final IIdentityService identityService;

    private final ILabelService labelService;

    private final IPropertiesWidgetCreationService propertiesWidgetCreationService;

    private final PropertiesConfigurerService propertiesConfigurerService;

    private final SimpleCrossReferenceProvider simpleCrossReferenceProvider = new SimpleCrossReferenceProvider();

    private final PepperItemProviderAdapterFactory pepperItemProviderAdapterFactory = new PepperItemProviderAdapterFactory();

    private final ItemProviderAdapter dependencyLinkAdapter = (ItemProviderAdapter) pepperItemProviderAdapterFactory.createDependencyLinkAdapter();

    public DependencyLinkPropertiesConfigurer(IIdentityService identityService, ILabelService labelService, PropertiesConfigurerService propertiesConfigurerService, IPropertiesWidgetCreationService propertiesWidgetCreationService) {
        this.identityService = identityService;
        this.labelService = labelService;
        this.propertiesConfigurerService = Objects.requireNonNull(propertiesConfigurerService);
        this.propertiesWidgetCreationService = Objects.requireNonNull(propertiesWidgetCreationService);
    }

    @Override
    public void addPropertiesDescriptions(IPropertiesDescriptionRegistry registry) {
        String formDescriptionId = UUID.nameUUIDFromBytes("dependencyLink".getBytes()).toString();

        List<AbstractControlDescription> controls = new ArrayList<>(this.getControlDescription());

        Predicate<VariableManager> canCreatePagePredicate = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .filter(DependencyLink.class::isInstance)
                .isPresent();

        GroupDescription groupDescriptionGeneral = this.propertiesWidgetCreationService.createSimpleGroupDescription(controls);

        PageDescription pageDescription = PageDescription.newPageDescription(formDescriptionId)
                .idProvider(variableManager -> "page")
                .labelProvider(variableManager -> "Properties")
                .semanticElementsProvider(this.propertiesConfigurerService.getSemanticElementsProvider())
                .canCreatePredicate(canCreatePagePredicate)
                .groupDescriptions(List.of(groupDescriptionGeneral))
                .build();

        registry.add(pageDescription);
    }

    private List<AbstractControlDescription> getControlDescription() {
        List<AbstractControlDescription> controls = new ArrayList<>();

        var sourceKind = this.getSourceTargetKindWidget(true);
        controls.add(sourceKind);

        var targetKind = this.getSourceTargetKindWidget(false);
        controls.add(targetKind);

        var source = this.propertiesWidgetCreationService.createReferenceWidget("dependencyLink.source", dependencyLinkAdapter.getString("_UI_DependencyLink_source_feature"),
                PepperPackage.Literals.DEPENDENCY_LINK__SOURCE, this.getSourceDependenciesProvider());
        controls.add(source);

        var target = this.getTargetWidget();
        controls.add(target);

        var duration = this.getDurationWidget();
        controls.add(duration);

        return controls;
    }

    private RadioDescription getSourceTargetKindWidget(boolean isSource) {
        EAttribute literal;
        String label;
        String id;
        if (isSource) {
            literal = PepperPackage.Literals.DEPENDENCY_LINK__SOURCE_KIND;
            label = dependencyLinkAdapter.getString("_UI_DependencyLink_sourceKind_feature");
            id = "dependencyLink.targetKind";
        } else {
            literal = PepperPackage.Literals.DEPENDENCY_LINK__TARGET_KIND;
            label = dependencyLinkAdapter.getString("_UI_DependencyLink_targetKind_feature");
            id = "dependencyLink.sourceKind";
        }

        Function<VariableManager, Boolean> optionSelectedProvider = variableManager -> {
            var optionalStartOrEnd = variableManager.get(SelectComponent.CANDIDATE_VARIABLE, StartOrEnd.class);
            if (optionalStartOrEnd.isPresent()) {
                StartOrEnd startOrEnd = optionalStartOrEnd.get();
                String optionLiteralId = Integer.valueOf(startOrEnd.getValue()).toString();
                Optional<String> optionalValue;
                if (isSource) {
                    optionalValue = variableManager.get(VariableManager.SELF, DependencyLink.class)
                            .map(DependencyLink::getSourceKind)
                            .map(StartOrEnd::getValue)
                            .map(String::valueOf);
                } else {
                    optionalValue = variableManager.get(VariableManager.SELF, DependencyLink.class)
                            .map(DependencyLink::getTargetKind)
                            .map(StartOrEnd::getValue)
                            .map(String::valueOf);
                }
                if (optionalValue.isPresent()) {
                    String value = optionalValue.get();
                    return optionLiteralId.equals(value);
                }
            }
            return false;
        };

        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var dependencyLinkOptional = variableManager.get(VariableManager.SELF, DependencyLink.class);
            if (dependencyLinkOptional.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    dependencyLinkOptional.get().setSourceKind(StartOrEnd.END);
                    dependencyLinkOptional.get().setTargetKind(StartOrEnd.START);
                } else if (isSource) {
                    int integer = Integer.parseInt(newValue);
                    StartOrEnd newStartOrEnd = StartOrEnd.get(integer);
                    dependencyLinkOptional.get().setSourceKind(newStartOrEnd);
                } else {
                    int integer = Integer.parseInt(newValue);
                    StartOrEnd newStartOrEnd = StartOrEnd.get(integer);
                    dependencyLinkOptional.get().setTargetKind(newStartOrEnd);
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };

        return RadioDescription.newRadioDescription(id)
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(variableManager -> label)
                .isReadOnlyProvider(variableManager -> false)
                .optionSelectedProvider(optionSelectedProvider)
                .optionsProvider(variableManager -> StartOrEnd.VALUES)
                .optionIdProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, StartOrEnd.class)
                        .map(StartOrEnd::getValue)
                        .map(String::valueOf)
                        .orElse(""))
                .optionLabelProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, StartOrEnd.class)
                        .map(Enumerator::getName)
                        .orElse(""))
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(literal))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .build();
    }

    private Function<VariableManager, List<?>> getSourceDependenciesProvider() {
        return variableManager -> {
            DependencyLink dependencyLinkOpt = variableManager.get(VariableManager.SELF, DependencyLink.class).orElse(null);
            List<DependencyRelatedObject> targets = new ArrayList<>();
            Collection<EStructuralFeature.Setting> inverseReferences = simpleCrossReferenceProvider.getInverseReferences(dependencyLinkOpt);
            for (EStructuralFeature.Setting inverseReference : inverseReferences) {
                if (inverseReference.getEObject() instanceof DependencyRelatedObject dep) {
                    targets.add(dep);
                }
            }

            return Optional.ofNullable(dependencyLinkOpt)
                    .map(dep -> this.getContainer(dep)).stream()
                    .flatMap(eObject -> this.getAllContentStream(eObject))
                    .filter(DependencyRelatedObject.class::isInstance)
                    .map(DependencyRelatedObject.class::cast)
                    .filter(dep -> !targets.equals(dep) && dependencyLinkOpt.getSource().getClass().isInstance(dep))
                    .toList();
        };
    }

    private ReferenceWidgetDescription getTargetWidget() {

        Function<VariableManager, String> labelValueProvider = variableManager -> {
            DependencyRelatedObject dep = this.getTargetObject(variableManager);
            String label = "";
            if (dep instanceof AbstractTask task) {
                label = task.getName();
            } else if (dep instanceof Workpackage workpackage) {
                label = workpackage.getName();
            }
            return label;
        };

        String id = "dependencyLink.target";
        return ReferenceWidgetDescription.newReferenceWidgetDescription(id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .idProvider(variableManager -> id)
                .labelProvider(variableManager -> dependencyLinkAdapter.getString("_UI_DependencyLink_target_feature"))
                .optionsProvider(variableManager -> List.of())
                .iconURLProvider(variableManager -> List.of())
                .itemsProvider(variableManager -> List.of(this.getTargetObject(variableManager)))
                .itemIdProvider(variableManager -> this.identityService.getId(this.getTargetObject(variableManager)))
                .itemKindProvider(variableManager -> "")
                .itemLabelProvider(labelValueProvider)
                .itemIconURLProvider(variableManager -> this.labelService.getImagePaths(this.getTargetObject(variableManager)))
                .ownerKindProvider(vm -> "")
                .referenceKindProvider(vm -> "")
                .isContainmentProvider(variableManager -> false)
                .isManyProvider(variableManager -> false)
                .isReadOnlyProvider(variableManager -> true)
                .styleProvider(variableManager -> null)
                .ownerIdProvider(variableManager -> variableManager.get(VariableManager.SELF, EObject.class).map(this.identityService::getId).orElse(""))
                .diagnosticsProvider(vm -> List.of())
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                //while the widget is Read-only, we can ignore these providers
                .clearHandlerProvider(variableManager -> new Success())
                .setHandlerProvider(variableManager -> new Success())
                .addHandlerProvider(variableManager -> new Success())
                .moveHandlerProvider(variableManager -> new Success())
                .build();
    }

    private TextfieldDescription getDurationWidget() {
        Function<VariableManager, String> valueProvider = variableManager -> variableManager.get(VariableManager.SELF, DependencyLink.class)
                .map(DependencyLink::getDuration)
                .map(String::valueOf)
                .orElse("0");
        BiFunction<VariableManager, String, IStatus> newValueHandler = (variableManager, newValue) -> {
            var depOpt = variableManager.get(VariableManager.SELF, DependencyLink.class);
            if (depOpt.isPresent()) {
                if (newValue == null || newValue.isBlank()) {
                    depOpt.get().setDuration(0);
                } else {
                    try {
                        int integer = Integer.parseInt(newValue);
                        depOpt.get().setDuration(integer);
                    } catch (NumberFormatException e) {
                        // Ignore
                    }
                }
                return new Success();
            } else {
                return new Failure("");
            }
        };

        Function<VariableManager, String> labelProvider = variableManager -> {
            var depOpt = variableManager.get(VariableManager.SELF, DependencyLink.class);
            if (depOpt.isPresent()) {
                String value = dependencyLinkAdapter.getString("_UI_DependencyLink_duration_feature");
                if (depOpt.get().getSource() instanceof Workpackage) {
                    value += " " + dependencyLinkAdapter.getString("_UI_DependencyLink_durationDay_feature");
                } else if (depOpt.get().getSource() instanceof AbstractTask) {
                    value += " " + dependencyLinkAdapter.getString("_UI_DependencyLink_durationHours_feature");
                }
                return value;
            } else {
                return "0";
            }
        };

        String id = "dependencyLink.duration";
        return TextfieldDescription.newTextfieldDescription(id)
                .isReadOnlyProvider(variableManager -> false)
                .idProvider(variableManager -> id)
                .targetObjectIdProvider(this.propertiesConfigurerService.getSemanticTargetIdProvider())
                .labelProvider(labelProvider)
                .valueProvider(valueProvider)
                .newValueHandler(newValueHandler)
                .diagnosticsProvider(this.propertiesConfigurerService.getDiagnosticsProvider(PepperPackage.Literals.DEPENDENCY_LINK__DURATION))
                .kindProvider(this.propertiesConfigurerService.getKindProvider())
                .messageProvider(this.propertiesConfigurerService.getMessageProvider())
                .build();
    }

    private DependencyRelatedObject getTargetObject(VariableManager variableManager) {
        DependencyLink dependencyLinkOpt = variableManager.get(VariableManager.SELF, DependencyLink.class).orElse(null);
        DependencyRelatedObject target = null;
        Collection<EStructuralFeature.Setting> inverseReferences = simpleCrossReferenceProvider.getInverseReferences(dependencyLinkOpt);
        for (EStructuralFeature.Setting inverseReference : inverseReferences) {
            if (inverseReference.getEObject() instanceof DependencyRelatedObject dep) {
                target = dep;
            }
        }
        return target;
    }

    private EObject getContainer(EObject eObject) {
        if (eObject != null) {
            Class<?> targetClass = Project.class;

            if (((DependencyLink) eObject).getSource() instanceof Task) {
                targetClass = Workpackage.class;
            }

            EObject parent = eObject.eContainer();
            while (parent != null) {
                if (targetClass.isInstance(parent)) {
                    return parent;
                }
                parent = parent.eContainer();
            }
        }
        return null;
    }

    private Stream<EObject> getAllContentStream(EObject eObject) {
        Iterable<EObject> content = () -> eObject.eAllContents();
        return StreamSupport.stream(content.spliterator(), false);
    }

}


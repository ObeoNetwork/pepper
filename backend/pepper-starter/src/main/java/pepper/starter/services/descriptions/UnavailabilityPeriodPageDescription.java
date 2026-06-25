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
package pepper.starter.services.descriptions;

import pepper.peppermm.PepperPackage;
import pepper.peppermm.UnavailabilityPeriod;
import pepper.starter.messages.IPepperMMMessageService;
import pepper.starter.messages.MessageConstants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.emf.forms.EMFFormDescriptionProvider;
import org.eclipse.sirius.components.emf.forms.EStructuralFeatureLabelProvider;
import org.eclipse.sirius.components.forms.DateTimeStyle;
import org.eclipse.sirius.components.forms.DateTimeType;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.description.DateTimeDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.TextfieldDescription;
import org.eclipse.sirius.components.representations.Failure;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.Message;
import org.eclipse.sirius.components.representations.MessageLevel;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;

/**
 * This class is used to provide the page description for an unavailability period.
 *
 * @author Obeo
 */
public class UnavailabilityPeriodPageDescription {

    private final ILabelService labelService;

    private final IIdentityService identityService;

    private final IObjectSearchService objectSearchService;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IPepperMMMessageService pepperMMMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    private final Function<VariableManager, String> semanticTargetIdProvider;

    public UnavailabilityPeriodPageDescription(ILabelService labelService, IIdentityService identityService, IObjectSearchService objectSearchService, ComposedAdapterFactory composedAdapterFactory,
            IPepperMMMessageService pepperMMMessageService, IFeedbackMessageService feedbackMessageService) {
        this.labelService = labelService;
        this.identityService = identityService;
        this.objectSearchService = objectSearchService;
        this.composedAdapterFactory = composedAdapterFactory;
        this.pepperMMMessageService = pepperMMMessageService;
        this.feedbackMessageService = feedbackMessageService;
        this.semanticTargetIdProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.identityService::getId).orElse(null);
    }

    PageDescription getPageDescription() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.pepperMMMessageService, this.feedbackMessageService);

        GroupDescription group = GroupDescription.newGroupDescription("unavailabilityPeriodGroupId")
                .idProvider(variableManager -> "unavailabilityPeriodGroupId")
                .labelProvider(variableManager -> "")
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .controlDescriptions(List.of(
                        this.buildDateTimeDescription(PepperPackage.eINSTANCE.getUnavailabilityPeriod_StartDate()),
                        this.buildDateTimeDescription(PepperPackage.eINSTANCE.getUnavailabilityPeriod_EndDate()),
                        this.buildDescriptionTextfieldDescription(widgetDescriptionBuilderHelper)))
                .build();

        return PageDescription.newPageDescription("unavailabilityPeriodPageId")
                .idProvider(variableManager -> "unavailabilityPeriodPageId")
                .labelProvider(variableManager -> this.pepperMMMessageService.getMessage(MessageConstants.PAGE_RESOURCE_AVAILABILITY))
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .groupDescriptions(List.of(group))
                .canCreatePredicate(variableManager -> true)
                .build();
    }

    private DateTimeDescription buildDateTimeDescription(EAttribute feature) {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.pepperMMMessageService, this.feedbackMessageService);

        return DateTimeDescription.newDateTimeDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .type(DateTimeType.DATE)
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(this.getLabelProvider(feature))
                .isReadOnlyProvider(variableManager -> false)
                .stringValueProvider(this.getDateValueProvider(feature))
                .newValueHandler(this.getDateNewValueHandler(feature))
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(diagnostic -> "")
                .messageProvider(diagnostic -> "")
                .styleProvider(variableManager -> DateTimeStyle.newDateTimeStyle().widgetGridLayout(widgetDescriptionBuilderHelper.buildWidgetGridLayout()).build())
                .build();
    }

    private TextfieldDescription buildDescriptionTextfieldDescription(WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper) {
        EAttribute feature = PepperPackage.eINSTANCE.getUnavailabilityPeriod_Description();
        return TextfieldDescription.newTextfieldDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(this.getLabelProvider(feature))
                .isReadOnlyProvider(variableManager -> false)
                .valueProvider(variableManager -> variableManager.get(VariableManager.SELF, UnavailabilityPeriod.class)
                        .map(UnavailabilityPeriod::getDescription)
                        .orElse(""))
                .newValueHandler((variableManager, newValue) -> {
                    variableManager.get(VariableManager.SELF, UnavailabilityPeriod.class)
                            .ifPresent(period -> period.setDescription(newValue));
                    return new Success();
                })
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(diagnostic -> "")
                .messageProvider(diagnostic -> "")
                .styleProvider(variableManager -> org.eclipse.sirius.components.forms.TextfieldStyle.newTextfieldStyle().widgetGridLayout(widgetDescriptionBuilderHelper.buildWidgetGridLayout()).build())
                .build();
    }

    private Function<VariableManager, String> getLabelProvider(EStructuralFeature feature) {
        return new EStructuralFeatureLabelProvider(EMFFormDescriptionProvider.ESTRUCTURAL_FEATURE) {
            @Override
            public String apply(VariableManager variableManager) {
                VariableManager childVM = variableManager.createChild();
                childVM.put(EMFFormDescriptionProvider.ESTRUCTURAL_FEATURE, feature);
                return super.apply(childVM);
            }
        };
    }

    private Function<VariableManager, String> getDateValueProvider(EAttribute eAttribute) {
        return variableManager -> variableManager.get(VariableManager.SELF, EObject.class)
                .map(eObject -> eObject.eGet(eAttribute))
                .filter(LocalDate.class::isInstance)
                .map(LocalDate.class::cast)
                .map(DateTimeFormatter.ISO_LOCAL_DATE::format)
                .orElse("");
    }

    private BiFunction<VariableManager, String, IStatus> getDateNewValueHandler(EAttribute eAttribute) {
        return (variableManager, newValue) -> variableManager.get(VariableManager.SELF, UnavailabilityPeriod.class)
                .map(period -> this.setDate(period, eAttribute, newValue))
                .orElseGet(() -> new Failure(""));
    }

    private IStatus setDate(UnavailabilityPeriod period, EAttribute eAttribute, String newValue) {
        try {
            LocalDate localDate = null;
            if (newValue != null && !newValue.isBlank()) {
                localDate = LocalDate.parse(newValue);
            }
            LocalDate startDate = eAttribute == PepperPackage.eINSTANCE.getUnavailabilityPeriod_StartDate() ? localDate : period.getStartDate();
            LocalDate endDate = eAttribute == PepperPackage.eINSTANCE.getUnavailabilityPeriod_EndDate() ? localDate : period.getEndDate();
            if (startDate != null && endDate != null && endDate.isBefore(startDate)) {
                return new Failure(List.of(new Message(this.pepperMMMessageService.getMessage(MessageConstants.INVALID_VALUE, newValue), MessageLevel.ERROR)));
            }
            period.eSet(eAttribute, localDate);
            return new Success();
        } catch (DateTimeParseException exception) {
            return new Failure(List.of(new Message(this.pepperMMMessageService.getMessage(MessageConstants.INVALID_VALUE, newValue), MessageLevel.ERROR)));
        }
    }
}

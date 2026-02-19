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

import pepper.starter.messages.IPepperMMMessageService;
import pepper.starter.messages.MessageConstants;
import pepper.peppermm.PepperPackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.eclipse.sirius.components.forms.FlexDirection;
import org.eclipse.sirius.components.forms.TextfieldStyle;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.description.AbstractWidgetDescription;
import org.eclipse.sirius.components.forms.description.DateTimeDescription;
import org.eclipse.sirius.components.forms.description.FlexboxContainerDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.LabelDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.TextfieldDescription;
import org.eclipse.sirius.components.representations.Failure;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;

/**
 * This class is used to provide the customer page description for the project planning and costing information.
 *
 * @author lfasani
 */
public class PlanningAndCostingPageDescription {

    private final ILabelService labelService;

    private final IIdentityService identityService;

    private final IObjectSearchService objectSearchService;
    private final ComposedAdapterFactory composedAdapterFactory;

    private final IPepperMMMessageService pepperMMMessageService;

    private final Function<VariableManager, String> semanticTargetIdProvider;

    private final IFeedbackMessageService feedbackMessageService;

    public PlanningAndCostingPageDescription(ILabelService labelService, IIdentityService identityService, IObjectSearchService objectSearchService, ComposedAdapterFactory composedAdapterFactory, IPepperMMMessageService pepperMMMessageService,
            IFeedbackMessageService feedbackMessageService) {
        this.labelService = labelService;
        this.identityService = identityService;
        this.objectSearchService = objectSearchService;
        this.composedAdapterFactory = composedAdapterFactory;
        this.pepperMMMessageService = pepperMMMessageService;
        this.feedbackMessageService = feedbackMessageService;
        this.semanticTargetIdProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.identityService::getId).orElse(null);
    }

    PageDescription getPageDescription() {

        AbstractWidgetDescription container1 = this.getContainer1();
        AbstractWidgetDescription container2 = this.getContainer2();

        AbstractWidgetDescription mainFlexboxContainer = FlexboxContainerDescription.newFlexboxContainerDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(vm -> "")
                .labelProvider(vm -> "")
                .flexDirection(FlexDirection.row)
                .children(List.of(container1, container2))
                .diagnosticsProvider(vm -> List.of())
                .kindProvider(object -> "")
                .messageProvider(object -> "")
                .build();

        GroupDescription group = GroupDescription.newGroupDescription("planningCostingGroupId")
                .idProvider(variableManager -> "planningCostingGroupId")
                .labelProvider(variableManager -> "")
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .controlDescriptions(List.of(mainFlexboxContainer))
                .build();

        return PageDescription.newPageDescription("planningCostingPageId")
                .idProvider(variableManager -> "planningCostingPageId")
                .labelProvider(variableManager -> this.pepperMMMessageService.getMessage(MessageConstants.PAGE_PLANNING))
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .groupDescriptions(List.of(group))
                .canCreatePredicate(variableManager -> true)
                .build();
    }

    private AbstractWidgetDescription getContainer1() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.pepperMMMessageService, this.feedbackMessageService);

        LabelDescription labelDescription = widgetDescriptionBuilderHelper.buildLabelDescription(this.pepperMMMessageService.getMessage(MessageConstants.PAGE_PLANNING_GROUP_PLANNING));
        DateTimeDescription contractualStartDateTimeDescription = this.buildDateTimeDescription(PepperPackage.eINSTANCE.getProject_ContractualStartDate());
        TextfieldDescription durationDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(PepperPackage.eINSTANCE.getProject_Duration());
        TextfieldDescription contractTermExtensionDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(PepperPackage.eINSTANCE.getProject_ContractTermExtension());
        DateTimeDescription contractualEndDateTimeDescription = this.buildDateTimeDescription(PepperPackage.eINSTANCE.getProject_ContractualEndDate());
        DateTimeDescription realStartDateTimeDescription = this.buildDateTimeDescription(PepperPackage.eINSTANCE.getProject_EffectiveStartDate());
        DateTimeDescription realEndDateTimeDescription = this.buildDateTimeDescription(PepperPackage.eINSTANCE.getProject_EffectiveEndDate());

        return widgetDescriptionBuilderHelper.buildFlexboxContainerDescription(
                List.of(labelDescription, contractualStartDateTimeDescription, durationDescription, contractTermExtensionDescription, contractualEndDateTimeDescription, realStartDateTimeDescription, realEndDateTimeDescription));
    }

    private AbstractWidgetDescription getContainer2() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.pepperMMMessageService, this.feedbackMessageService);

        LabelDescription labelDescription = widgetDescriptionBuilderHelper.buildLabelDescription(this.pepperMMMessageService.getMessage(MessageConstants.PAGE_PLANNING_GROUP_BUDGET));
        TextfieldDescription globalCostTextfieldDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(PepperPackage.eINSTANCE.getProject_GlobalCost(), this.pepperMMMessageService.getMessage(MessageConstants.GLOBAL_COST_HELP), null, false);
        TextfieldDescription fundingRateTextfieldDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(PepperPackage.eINSTANCE.getProject_FundingRate());
        TextfieldDescription fundingTextfieldDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(PepperPackage.eINSTANCE.getProject_Funding(), this.pepperMMMessageService.getMessage(MessageConstants.FUNDING_HELP), null, true);
        TextfieldDescription manpowerTextfieldDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(PepperPackage.eINSTANCE.getProject_Manpower(), this.pepperMMMessageService.getMessage(MessageConstants.MANPOWER_HELP), null, false);
        TextfieldStyle textfieldStyle = TextfieldStyle.newTextfieldStyle().backgroundColor("lightBlue[50]").widgetGridLayout(widgetDescriptionBuilderHelper.buildWidgetGridLayout()).build();
        TextfieldDescription eotpTextfieldDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(PepperPackage.eINSTANCE.getProject_EOTP(), this.pepperMMMessageService.getMessage(MessageConstants.EOTP_HELP), textfieldStyle, false);
        TextfieldDescription statisticOrderTextfieldDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(PepperPackage.eINSTANCE.getProject_StatisticOrder(), this.pepperMMMessageService.getMessage(MessageConstants.OS_HELP), textfieldStyle, false);

        return widgetDescriptionBuilderHelper.buildFlexboxContainerDescription(
                List.of(labelDescription, globalCostTextfieldDescription, fundingRateTextfieldDescription, fundingTextfieldDescription, manpowerTextfieldDescription, eotpTextfieldDescription, statisticOrderTextfieldDescription));
    }

    DateTimeDescription buildDateTimeDescription(EAttribute feature) {
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
        return variableManager -> {
            var optionalEObject = variableManager.get(VariableManager.SELF, EObject.class);

            if (optionalEObject.isPresent()) {
                EObject eObject = optionalEObject.get();

                Object value = eObject.eGet(eAttribute);
                if (value instanceof LocalDate localDate) {
                    return DateTimeFormatter.ISO_LOCAL_DATE.format(localDate);
                }
            }
            return "";
        };
    }

    private BiFunction<VariableManager, String, IStatus> getDateNewValueHandler(EAttribute eAttribute) {
        return (variableManager, newValue) -> {
            IStatus status = new Failure("");
            var optionalEObject = variableManager.get(VariableManager.SELF, EObject.class);
            if (optionalEObject.isPresent()) {
                EObject eObject = optionalEObject.get();

                if (newValue == null || newValue.isBlank()) {
                    eObject.eSet(eAttribute, null);
                    status = new Success();
                } else {
                    LocalDate localDate = LocalDate.parse(newValue);
                    eObject.eSet(eAttribute, localDate);
                    status = new Success();
                }
            }
            return status;
        };
    }
}

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

import pepper.peppermm.PepperFactory;
import pepper.peppermm.Resource;
import pepper.starter.messages.IPepperMMMessageService;
import pepper.starter.messages.MessageConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.core.api.labels.StyledString;
import org.eclipse.sirius.components.emf.tables.CursorBasedNavigationServices;
import org.eclipse.sirius.components.forms.ButtonStyle;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.description.AbstractControlDescription;
import org.eclipse.sirius.components.forms.description.ButtonDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.tables.descriptions.LineDescription;
import org.eclipse.sirius.components.tables.descriptions.PaginatedData;
import org.eclipse.sirius.components.tables.descriptions.TableDescription;
import org.eclipse.sirius.components.widget.table.TableWidgetDescription;

/**
 * This class is used to provide the resource availability page description.
 *
 * @author Obeo
 */
public class ResourceAvailabilityPageDescription {

    public static final String UNAVAILABILITY_PERIODS_TABLE_ID = "unavailabilityPeriodsTableId";

    private final ILabelService labelService;

    private final IIdentityService identityService;

    private final IObjectSearchService objectSearchService;

    private final CursorBasedNavigationServices cursorBasedNavigationServices;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IPepperMMMessageService pepperMMMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    public ResourceAvailabilityPageDescription(ILabelService labelService, IIdentityService identityService, IObjectSearchService objectSearchService, CursorBasedNavigationServices cursorBasedNavigationServices,
            ComposedAdapterFactory composedAdapterFactory, IPepperMMMessageService pepperMMMessageService, IFeedbackMessageService feedbackMessageService) {
        this.labelService = labelService;
        this.identityService = identityService;
        this.objectSearchService = objectSearchService;
        this.cursorBasedNavigationServices = cursorBasedNavigationServices;
        this.composedAdapterFactory = composedAdapterFactory;
        this.pepperMMMessageService = pepperMMMessageService;
        this.feedbackMessageService = feedbackMessageService;
    }

    PageDescription getPageDescription() {
        List<AbstractControlDescription> controlDescriptions = new ArrayList<>();

        Function<VariableManager, String> labelProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .map(this.labelService::getStyledLabel)
                .map(StyledString::toString)
                .orElse(null);

        LineDescription lineDescription = LineDescription.newLineDescription("Unavailability Periods - Line")
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .semanticElementsProvider(this.getSemanticElementsProvider())
                .headerLabelProvider(labelProvider)
                .headerIconURLsProvider(vm -> List.of())
                .headerIndexLabelProvider(vm -> "")
                .initialHeightProvider(vm -> 60)
                .isResizablePredicate(vm -> true)
                .depthLevelProvider(vm -> 0)
                .hasChildrenProvider(vm -> false)
                .build();

        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.pepperMMMessageService, this.feedbackMessageService);
        TableDescription tableDescription = TableDescription.newTableDescription(UNAVAILABILITY_PERIODS_TABLE_ID)
                .label("")
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .labelProvider(labelProvider)
                .isStripeRowPredicate(vm -> true)
                .lineDescription(lineDescription)
                .columnDescriptions(List.of(widgetDescriptionBuilderHelper.buildFeaturesColumnDescription(PepperFactory.eINSTANCE.createUnavailabilityPeriod())))
                .cellDescriptions(widgetDescriptionBuilderHelper.buildCellDescription())
                .iconURLsProvider(vm -> List.of())
                .enableSubRows(false)
                .pageSizeOptionsProvider(vm -> List.of(10, 20))
                .defaultPageSizeIndexProvider(vm -> 1)
                .build();

        TableWidgetDescription tableWidgetDescription = TableWidgetDescription.newTableWidgetDescription("unavailabilityPeriodsTableWidgetId")
                .idProvider(new WidgetIdProvider())
                .labelProvider(variableManager -> this.pepperMMMessageService.getMessage(MessageConstants.PAGE_RESOURCE_AVAILABILITY_TITLE))
                .targetObjectIdProvider(this::getTargetObjectId)
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(object -> "")
                .messageProvider(object -> "")
                .tableDescription(tableDescription)
                .build();

        controlDescriptions.add(tableWidgetDescription);

        GroupDescription group = GroupDescription.newGroupDescription("resourceAvailabilityGroupId")
                .idProvider(variableManager -> "resourceAvailabilityGroupId")
                .labelProvider(variableManager -> "")
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .controlDescriptions(controlDescriptions)
                .toolbarActionDescriptions(List.of(this.getCreateUnavailabilityPeriodButtonDescription()))
                .build();

        return PageDescription.newPageDescription("resourceAvailabilityPageId")
                .idProvider(variableManager -> "resourceAvailabilityPageId")
                .labelProvider(variableManager -> this.pepperMMMessageService.getMessage(MessageConstants.PAGE_RESOURCE_AVAILABILITY))
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .groupDescriptions(List.of(group))
                .canCreatePredicate(variableManager -> true)
                .build();
    }

    private Function<VariableManager, PaginatedData> getSemanticElementsProvider() {
        return variableManager -> variableManager.get(VariableManager.SELF, Resource.class)
                .map(Resource::getUnavailabilityPeriods)
                .map(periods -> this.cursorBasedNavigationServices.toPaginatedData(periods.stream().map(Object.class::cast).toList(),
                        variableManager.get("cursor", Object.class).orElse(null),
                        variableManager.get("direction", String.class).orElse(null),
                        variableManager.get("size", Integer.class).orElse(10)))
                .orElseGet(() -> new PaginatedData(List.of(), false, false, 0));
    }

    private ButtonDescription getCreateUnavailabilityPeriodButtonDescription() {
        return ButtonDescription.newButtonDescription("createUnavailabilityPeriod")
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this::getTargetObjectId)
                .labelProvider(variableManager -> "")
                .iconURLProvider(variableManager -> List.of())
                .isReadOnlyProvider(variableManager -> false)
                .buttonLabelProvider(variableManager -> this.pepperMMMessageService.getMessage(MessageConstants.CREATE_NEW_UNAVAILABILITY_PERIOD))
                .imageURLProvider(variableManager -> "icons/full/obj16/UnavailabilityPeriod.svg")
                .pushButtonHandler(variableManager -> {
                    variableManager.get(VariableManager.SELF, Resource.class)
                            .ifPresent(resource -> resource.getUnavailabilityPeriods().add(PepperFactory.eINSTANCE.createUnavailabilityPeriod()));
                    return new Success();
                })
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(variableManager -> "")
                .messageProvider(variableManager -> "")
                .styleProvider(variableManager -> ButtonStyle.newButtonStyle()
                        .backgroundColor("#ffffff")
                        .foregroundColor("#261E58")
                        .build())
                .helpTextProvider(variableManager -> this.pepperMMMessageService.getMessage(MessageConstants.CREATE_NEW_UNAVAILABILITY_PERIOD_HELP))
                .build();
    }

    private String getTargetObjectId(VariableManager variableManager) {
        return variableManager.get(VariableManager.SELF, Object.class)
                .map(this.identityService::getId)
                .orElse(null);
    }

    private String getTargetObjectKind(VariableManager variableManager) {
        return variableManager.get(VariableManager.SELF, Object.class)
                .map(this.identityService::getId)
                .orElse(null);
    }
}

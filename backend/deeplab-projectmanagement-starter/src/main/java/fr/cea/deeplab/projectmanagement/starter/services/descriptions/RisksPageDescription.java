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
import fr.cea.deeplab.projectmgmt.Project;
import fr.cea.deeplab.projectmgmt.ProjectmgmtFactory;

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
import org.eclipse.sirius.components.widget.table.TableWidgetDescription;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.tables.descriptions.LineDescription;
import org.eclipse.sirius.components.tables.descriptions.PaginatedData;
import org.eclipse.sirius.components.tables.descriptions.TableDescription;

/**
 * This class is used to provide the project page description for the project risks.
 *
 * @author lfasani
 */
public class RisksPageDescription {

    //private final IObjectService objectService;
    private final ILabelService labelService;

    private final IIdentityService identityService;

    private final IObjectSearchService objectSearchService;

    private final CursorBasedNavigationServices cursorBasedNavigationServices;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IProjectManagementMessageService projectManagementMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    public RisksPageDescription(ILabelService labelService, IIdentityService identityService, IObjectSearchService objectSearchService, CursorBasedNavigationServices cursorBasedNavigationServices, ComposedAdapterFactory composedAdapterFactory,
            IProjectManagementMessageService projectManagementMessageService, IFeedbackMessageService feedbackMessageService) {
        this.labelService = labelService;
        this.identityService = identityService;
        this.objectSearchService = objectSearchService;
        this.cursorBasedNavigationServices = cursorBasedNavigationServices;
        this.composedAdapterFactory = composedAdapterFactory;
        this.projectManagementMessageService = projectManagementMessageService;
        this.feedbackMessageService = feedbackMessageService;
    }

    private Function<VariableManager, PaginatedData> getSemanticElementsProvider() {
        return variableManager -> variableManager.get(VariableManager.SELF, Project.class)
                .map(Project::getOwnedRisks)
                .map(risks -> this.cursorBasedNavigationServices.toPaginatedData(risks.stream().map(Object.class::cast).toList(),
                        variableManager.get("cursor", Object.class).orElse(null),
                        variableManager.get("direction", String.class).orElse(null),
                        variableManager.get("size", Integer.class).orElse(10)))
                .orElseGet(() -> new PaginatedData(List.of(), false, false, 0));
    }

    PageDescription getRisksPageDescription() {
        List<AbstractControlDescription> controlDescriptions = new ArrayList<>();

        Function<VariableManager, String> labelProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .map(this.labelService::getStyledLabel)
                .map(StyledString::toString)
                .orElse(null);

        LineDescription lineDescription = LineDescription.newLineDescription("Table - Line")
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .semanticElementsProvider(this.getSemanticElementsProvider())
                .headerLabelProvider(labelProvider)
                .headerIconURLsProvider(vm -> List.of())
                .headerIndexLabelProvider(vm -> "")
                .initialHeightProvider(vm -> 40)
                .isResizablePredicate(vm -> true)
                .depthLevelProvider(vm -> 0)
                .build();


        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);
        TableDescription tableDescription = TableDescription.newTableDescription("risksTableId")
                .label("")
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .labelProvider(labelProvider)
                .isStripeRowPredicate(vm -> true)
                .lineDescription(lineDescription)
                .columnDescriptions(List.of(widgetDescriptionBuilderHelper.buildFeaturesColumnDescription(ProjectmgmtFactory.eINSTANCE.createRisk())))
                .cellDescriptions(widgetDescriptionBuilderHelper.buildCellDescription())
                .iconURLsProvider(vm -> List.of())
                .enableSubRows(true)
                .pageSizeOptionsProvider(vm -> List.of(10, 20))
                .defaultPageSizeIndexProvider(vm -> 20)
                .build();

        TableWidgetDescription tableWidgetDescription = TableWidgetDescription.newTableWidgetDescription("risksTableWidgetId")
                .idProvider(new WidgetIdProvider())
                .labelProvider(variableManager -> this.projectManagementMessageService.getMessage(MessageConstants.PAGE_RISKS_TITLE))
                .targetObjectIdProvider(this::getTargetObjectId)
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(object -> "")
                .messageProvider(object -> "")
                .tableDescription(tableDescription)
                .build();

        controlDescriptions.add(tableWidgetDescription);

        GroupDescription risksGroup = GroupDescription.newGroupDescription("risksGroupId")
                .idProvider(variableManager -> "risksGroupId")
                .labelProvider(variableManager -> "")
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .controlDescriptions(controlDescriptions)
                .toolbarActionDescriptions(List.of(this.getCreateRiskButtonDescription()))
                .build();

        return PageDescription.newPageDescription("risksPageId")
                .idProvider(variableManager -> "risksPageId")
                .labelProvider(variableManager -> this.projectManagementMessageService.getMessage(MessageConstants.PAGE_RISKS))
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .groupDescriptions(List.of(risksGroup))
                .canCreatePredicate(variableManager -> true)
                .build();
    }

    private ButtonDescription getCreateRiskButtonDescription() {
        return ButtonDescription.newButtonDescription("createRisk")
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.identityService::getId).orElse(null))
                .labelProvider(variableManager -> "")
                .iconURLProvider(variableManager -> List.of())
                .isReadOnlyProvider(variableManager -> false)
                .buttonLabelProvider(variableManager -> this.projectManagementMessageService.getMessage(MessageConstants.CREATE_NEW_RISK))
                .imageURLProvider(variableManager -> "icons/full/obj16/Risk.svg")
                .pushButtonHandler(variableManager -> {
                    var project = variableManager.get(VariableManager.SELF, Project.class).get();
                    project.getOwnedRisks().add(ProjectmgmtFactory.eINSTANCE.createRisk());
                    return new Success();
                })
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(variableManager -> "")
                .messageProvider(variableManager -> "")
                .styleProvider(variableManager -> ButtonStyle.newButtonStyle()
                        .backgroundColor("#ffffff")
                        .foregroundColor("#261E58")
                        .build()
                )
                .helpTextProvider(variableManager -> this.projectManagementMessageService.getMessage(MessageConstants.CREATE_NEW_RISK_HELP))
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

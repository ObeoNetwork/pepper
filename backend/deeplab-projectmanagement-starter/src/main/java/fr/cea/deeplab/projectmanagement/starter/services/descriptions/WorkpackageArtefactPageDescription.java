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
import fr.cea.deeplab.projectmgmt.WorkpackageArtefact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.IObjectService;
import org.eclipse.sirius.components.emf.tables.CursorBasedNavigationServices;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.description.AbstractControlDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.TableWidgetDescription;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.tables.descriptions.ColumnDescription;
import org.eclipse.sirius.components.tables.descriptions.LineDescription;
import org.eclipse.sirius.components.tables.descriptions.PaginatedData;
import org.eclipse.sirius.components.tables.descriptions.TableDescription;

/**
 * This class is used to provide the project page description for the project workpackage artefact.
 *
 * @author lfasani
 */
public class WorkpackageArtefactPageDescription {

    private final IObjectService objectService;

    private final IIdentityService identityService;

    private final CursorBasedNavigationServices cursorBasedNavigationServices;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IProjectManagementMessageService projectManagementMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    public WorkpackageArtefactPageDescription(IObjectService objectService, IIdentityService identityService, CursorBasedNavigationServices cursorBasedNavigationServices, ComposedAdapterFactory composedAdapterFactory, IProjectManagementMessageService projectManagementMessageService,
            IFeedbackMessageService feedbackMessageService) {
        this.objectService = objectService;
        this.identityService = identityService;
        this.cursorBasedNavigationServices = cursorBasedNavigationServices;
        this.composedAdapterFactory = composedAdapterFactory;
        this.projectManagementMessageService = projectManagementMessageService;
        this.feedbackMessageService = feedbackMessageService;
    }

    private Function<VariableManager, PaginatedData> getSemanticElementsProvider() {
        return variableManager -> {
            List<WorkpackageArtefact> workpackagesArtefact = variableManager.get(VariableManager.SELF, Project.class).stream()
                    .flatMap(project -> project.getOwnedWorkpackages().stream())
                    .flatMap(workpackage -> workpackage.getOutputs().stream()).toList();

            PaginatedData paginatedData = this.cursorBasedNavigationServices.toPaginatedData(workpackagesArtefact.stream().map(Object.class::cast).toList(),
                        variableManager.get("cursor", Object.class).orElse(null),
                        variableManager.get("direction", String.class).orElse(null),
                        variableManager.get("size", Integer.class).orElse(10));
            return paginatedData;
        };
    }


    PageDescription getWorkpackageArtefactsPageDescription() {
        List<AbstractControlDescription> controlDescriptions = new ArrayList<>();

        Function<VariableManager, String> labelProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .map(this.objectService::getLabel)
                .orElse(null);

        List<LineDescription> lineDescriptions = new ArrayList<>();
        LineDescription lineDescription = LineDescription.newLineDescription("Table - Line") //$NON-NLS-1$
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .semanticElementsProvider(this.getSemanticElementsProvider())
                .headerLabelProvider(labelProvider)
                .headerIconURLsProvider(vm -> List.of())
                .headerIndexLabelProvider(vm -> "")
                .initialHeightProvider(vm -> 40)
                .isResizablePredicate(variableManager -> true)
                .build();
        lineDescriptions.add(lineDescription);

        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);
        ColumnDescription workpackageColumnDescription = this.buildWorkpackageColumnDescription();
        TableDescription tableDescription = TableDescription.newTableDescription("workpackageArtefactsTableId")
                .label("")
                .canCreatePredicate(vm -> true)
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .labelProvider(labelProvider)
                .isStripeRowPredicate(vm -> true)
                .lineDescription(lineDescription)
                .columnDescriptions(List.of(workpackageColumnDescription, widgetDescriptionBuilderHelper.buildFeaturesColumnDescription(ProjectmgmtFactory.eINSTANCE.createWorkpackageArtefact())))
                .cellDescriptions(widgetDescriptionBuilderHelper.buildCellDescription())
                .iconURLsProvider(vm -> List.of())
                .build();

        TableWidgetDescription tableWidgetDescription = TableWidgetDescription.newTableWidgetDescription("workpackageArtefactsTableWidgetId")
                .idProvider(new WidgetIdProvider())
                .labelProvider(variableManager -> this.projectManagementMessageService.getMessage(MessageConstants.PAGE_WORKPACKAGE_ARTEFACTS_TITLE))
                .targetObjectIdProvider(this::getTargetObjectId)
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(object -> "")
                .messageProvider(object -> "")
                .tableDescription(tableDescription)
                .build();

        controlDescriptions.add(tableWidgetDescription);

        GroupDescription workpackageArtefactsGroup = GroupDescription.newGroupDescription("workpackageArtefactsGroupId")
                .idProvider(variableManager -> "workpackageArtefactsGroupId")
                .labelProvider(variableManager -> "")
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .controlDescriptions(controlDescriptions)
                .build();

        return PageDescription.newPageDescription("workpackageArtefactsPageId")
                .idProvider(variableManager -> "workpackageArtefactsPageId")
                .labelProvider(variableManager -> this.projectManagementMessageService.getMessage(MessageConstants.PAGE_WORKPACKAGE_ARTEFACTS))
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .groupDescriptions(List.of(workpackageArtefactsGroup))
                .canCreatePredicate(variableManager -> true)
                .build();
    }

    private String getTargetObjectId(VariableManager variableManager) {
        return variableManager.get(VariableManager.SELF, Object.class)
                .map(this.identityService::getId)
                .orElse(null);
    }

    private String getTargetObjectKind(VariableManager variableManager) {
        return variableManager.get(VariableManager.SELF, Object.class)
                .map(this.identityService::getKind)
                .orElse(null);
    }

    ColumnDescription buildWorkpackageColumnDescription() {
        ColumnDescription columnDescription = ColumnDescription.newColumnDescription("features")
                .semanticElementsProvider(vm -> List.of(MessageConstants.WORKPACKAGE_COLUMN_NAME))
                .headerLabelProvider(vm -> this.projectManagementMessageService.getMessage(MessageConstants.WORKPACKAGE_COLUMN_NAME))
                .targetObjectIdProvider(vm -> MessageConstants.WORKPACKAGE_COLUMN_NAME)
                .targetObjectKindProvider(vm -> "")
                .headerIconURLsProvider(vm -> List.of())
                .headerIndexLabelProvider(vm -> "")
                .isResizablePredicate(variableManager -> true)
                .shouldRenderPredicate(vm -> true)
                .initialWidthProvider(vm -> 40)
                .isResizablePredicate(vm -> true)
                .filterVariantProvider(vm -> "")
                .build();
        return columnDescription;
    }
}

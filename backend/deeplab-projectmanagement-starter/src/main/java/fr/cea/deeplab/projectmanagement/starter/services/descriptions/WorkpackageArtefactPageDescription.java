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
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;
import fr.cea.deeplab.projectmgmt.Workpackage;
import fr.cea.deeplab.projectmgmt.WorkpackageArtefact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.IObjectService;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.description.AbstractControlDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.TableWidgetDescription;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.tables.descriptions.CellDescription;
import org.eclipse.sirius.components.tables.descriptions.ColumnDescription;
import org.eclipse.sirius.components.tables.descriptions.LineDescription;
import org.eclipse.sirius.components.tables.descriptions.TableDescription;
import org.eclipse.sirius.components.tables.elements.SelectCellElementProps;

/**
 * This class is used to provide the project page description for the project workpackage artefact.
 *
 * @author lfasani
 */
public class WorkpackageArtefactPageDescription {

    private final IObjectService objectService;

    private final IIdentityService identityService;

    private final Function<VariableManager, String> semanticTargetIdProvider;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IProjectManagementMessageService projectManagementMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    public WorkpackageArtefactPageDescription(IObjectService objectService, IIdentityService identityService, ComposedAdapterFactory composedAdapterFactory, IProjectManagementMessageService projectManagementMessageService,
            IFeedbackMessageService feedbackMessageService) {
        this.objectService = objectService;
        this.identityService = identityService;
        this.composedAdapterFactory = composedAdapterFactory;
        this.projectManagementMessageService = projectManagementMessageService;
        this.feedbackMessageService = feedbackMessageService;
        this.semanticTargetIdProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.objectService::getId).orElse(null);
    }

    PageDescription getWorkpackageArtefactsPageDescription() {
        List<AbstractControlDescription> controlDescriptions = new ArrayList<>();

        Function<VariableManager, List<Object>> semanticElementsProvider = variableManager -> variableManager.get(VariableManager.SELF, Project.class)
                .map(eObject -> {
                    List<Object> objects = new ArrayList<>();
                    objects.addAll(eObject.getOwnedWorkpackages().stream().flatMap(wp -> wp.getOutputs().stream()).toList());
                    return objects;
                })
                .orElse(List.of());

        Function<VariableManager, String> labelProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .map(this.objectService::getLabel)
                .orElse(null);

        List<LineDescription> lineDescriptions = new ArrayList<>();
        LineDescription lineDescription = LineDescription.newLineDescription(UUID.nameUUIDFromBytes("Table - Line".getBytes())) //$NON-NLS-1$
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .semanticElementsProvider(semanticElementsProvider)
                .build();
        lineDescriptions.add(lineDescription);

        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);
        ColumnDescription workpackageColumnDescription = this.buildWorkpackageColumnDescription();
        TableDescription tableDescription = TableDescription.newTableDescription("workpackageArtefactsTableId")
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .labelProvider(labelProvider)
                .lineDescriptions(lineDescriptions)
                .columnDescriptions(List.of(workpackageColumnDescription, widgetDescriptionBuilderHelper.buildFeaturesColumnDescription(ProjectmgmtFactory.eINSTANCE.createWorkpackageArtefact(), ProjectmgmtPackage.eINSTANCE.getWorkpackageArtefact())))
                .cellDescription(this.buildCellDescription())
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
        ColumnDescription columnDescription = ColumnDescription.newColumnDescription(UUID.nameUUIDFromBytes("features".getBytes()))
                .semanticElementsProvider(vm -> List.of(MessageConstants.WORKPACKAGE_COLUMN_NAME))
                .labelProvider(vm -> this.projectManagementMessageService.getMessage(MessageConstants.WORKPACKAGE_COLUMN_NAME))
                .targetObjectIdProvider(vm -> MessageConstants.WORKPACKAGE_COLUMN_NAME)
                .targetObjectKindProvider(vm -> "")
                .build();
        return columnDescription;
    }


    CellDescription buildCellDescription() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);
        return CellDescription.newCellDescription("cells")
                .targetObjectIdProvider(vm-> "")
                .targetObjectKindProvider(vm-> "")
                .cellTypeProvider(this.getCellTypeProvider())
                .cellValueProvider(this.getCellValueProvider())
                .cellOptionsIdProvider(widgetDescriptionBuilderHelper.getCellOptionsIdProvider())
                .cellOptionsLabelProvider(widgetDescriptionBuilderHelper.getCellOptionsLabelProvider())
                .cellOptionsProvider(this.getCellOptionsProvider())
                .newCellValueHandler(this.getNewCellValueHandler())
                .build();
    }

    BiFunction<VariableManager, Object, IStatus> getNewCellValueHandler() {
        BiFunction<VariableManager, Object, IStatus> newCellValueHandler = (variableManager, newValue) -> {
            var isWPColumn = variableManager.get(ColumnDescription.COLUMN_TARGET_OBJECT_ID, Object.class).map(columnTargetObject -> MessageConstants.WORKPACKAGE_COLUMN_NAME.equals(columnTargetObject)).orElse(false);
            if (isWPColumn) {
                var optionalEditingContext = variableManager.get(IEditingContext.EDITING_CONTEXT, IEditingContext.class);
                var optionalWA = variableManager.get(VariableManager.SELF, WorkpackageArtefact.class);
                if (optionalEditingContext.isPresent() && optionalWA.isPresent() && newValue instanceof String newStringValue) {
                    this.objectService.getObject(optionalEditingContext.get(), newStringValue)
                            .filter(Workpackage.class::isInstance)
                            .map(Workpackage.class::cast)
                            .ifPresent(workpackage -> workpackage.getOutputs().add(optionalWA.get()));
                }

                return new Success();
            } else {
                return new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory, this.projectManagementMessageService, this.feedbackMessageService).getNewCellValueHandler().apply(variableManager, newValue);
            }
        };
        return newCellValueHandler;
    }

    private BiFunction<VariableManager, Object, List<Object>> getCellOptionsProvider() {
        return (variableManager, columnTargetObject) -> {
            if (MessageConstants.WORKPACKAGE_COLUMN_NAME.equals(columnTargetObject)) {
                return variableManager.get(VariableManager.SELF, WorkpackageArtefact.class)
                        .map(wpa -> wpa.eContainer().eContainer())
                        .map(Project.class::cast)
                        .stream()
                        .flatMap(project -> project.getOwnedWorkpackages().stream())
                        .map(Object.class::cast)
                        .toList();
            } else {
                return new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory, this.projectManagementMessageService, this.feedbackMessageService).getCellOptionsProvider().apply(variableManager, columnTargetObject);
            }
        };
    }

    private BiFunction<VariableManager, Object, Object> getCellValueProvider() {
        return (variableManager, columnTargetObject) -> {
            Object value = "";
            Optional<WorkpackageArtefact> optionalWorkpackageArtefact = variableManager.get(VariableManager.SELF, WorkpackageArtefact.class);
            if (MessageConstants.WORKPACKAGE_COLUMN_NAME.equals(columnTargetObject)) {
                if (optionalWorkpackageArtefact.isPresent() && optionalWorkpackageArtefact.get().eContainer() instanceof Workpackage workpackage) {
                    value = this.objectService.getId(workpackage);
                }
            } else {
                value = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory, this.projectManagementMessageService, this.feedbackMessageService).getCellValueProvider().apply(variableManager, columnTargetObject);
            }
            return value;
        };
    }

    private BiFunction<VariableManager, Object, String> getCellTypeProvider() {
        return (variableManager, columnTargetObject) -> {
            if (MessageConstants.WORKPACKAGE_COLUMN_NAME.equals(columnTargetObject)) {
                return SelectCellElementProps.TYPE;
            } else {
                return new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory, this.projectManagementMessageService, this.feedbackMessageService).getCellTypeProvider().apply(variableManager, columnTargetObject);
            }
        };
    }
}

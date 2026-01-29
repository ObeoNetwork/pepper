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
import fr.cea.deeplab.projectmgmt.Workpackage;
import fr.cea.deeplab.projectmgmt.WorkpackageArtefact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.core.api.labels.StyledString;
import org.eclipse.sirius.components.emf.tables.CursorBasedNavigationServices;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.description.AbstractControlDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.tables.descriptions.ColumnDescription;
import org.eclipse.sirius.components.tables.descriptions.ICellDescription;
import org.eclipse.sirius.components.tables.descriptions.LineDescription;
import org.eclipse.sirius.components.tables.descriptions.PaginatedData;
import org.eclipse.sirius.components.tables.descriptions.SelectCellDescription;
import org.eclipse.sirius.components.tables.descriptions.TableDescription;
import org.eclipse.sirius.components.tables.descriptions.TextfieldCellDescription;
import org.eclipse.sirius.components.widget.table.TableWidgetDescription;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.tables.components.SelectCellComponent;
import org.eclipse.sirius.components.tables.elements.MultiSelectCellElementProps;
import org.eclipse.sirius.components.tables.elements.SelectCellElementProps;
import org.eclipse.sirius.components.tables.elements.TextfieldCellElementProps;

/**
 * This class is used to provide the project page description for the project workpackage artefact.
 *
 * @author lfasani
 */
public class WorkpackageArtefactPageDescription {

    //private final IObjectService objectService;
    private final ILabelService labelService;

    private final IIdentityService identityService;

    private final IObjectSearchService objectSearchService;

    private final CursorBasedNavigationServices cursorBasedNavigationServices;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IProjectManagementMessageService projectManagementMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    public WorkpackageArtefactPageDescription(ILabelService labelService, IIdentityService identityService, IObjectSearchService objectSearchService, CursorBasedNavigationServices cursorBasedNavigationServices, ComposedAdapterFactory composedAdapterFactory, IProjectManagementMessageService projectManagementMessageService,
            IFeedbackMessageService feedbackMessageService) {
        //this.objectService = objectService;
        this.labelService = labelService;
        this.identityService = identityService;
        this.objectSearchService = objectSearchService;
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
                .map(this.labelService::getStyledLabel)
                .map(StyledString::toString)
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
                .depthLevelProvider(vm -> 0)
                .build();
        lineDescriptions.add(lineDescription);

        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
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
                .cellDescriptions(this.buildCellDescription())
                .iconURLsProvider(vm -> List.of())
                .enableSubRows(true)
                .pageSizeOptionsProvider(vm -> List.of(10, 20))
                .defaultPageSizeIndexProvider(vm -> 20)
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
                .map(this.identityService::getId)
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
                .isSortablePredicate(vm -> true)
                .build();
        return columnDescription;
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
                        .cellTooltipValueProvider((vm, o) -> "")
                        .build()
        );
        iCellDescriptionList.add(
                TextfieldCellDescription.newTextfieldCellDescription("text cells")
                        .targetObjectIdProvider(vm-> "")
                        .targetObjectKindProvider(vm-> "")
                        .canCreatePredicate(this.canCreateCellProvider(TextfieldCellElementProps.TYPE))
                        .cellValueProvider(this.getCellValueProvider())
                        .cellTooltipValueProvider((vm, o) -> "")
                        .build());
        return iCellDescriptionList;
    }

    Function<VariableManager, String> getCellOptionsIdProvider() {
        return variableManager -> {
            Object candidate = variableManager.getVariables().get(SelectCellComponent.CANDIDATE_VARIABLE);
            if (candidate instanceof EEnumLiteral) {
                return this.labelService.getStyledLabel(candidate).toString();
            }
            return this.identityService.getId(candidate);
        };
    }

    Function<VariableManager, String> getCellOptionsLabelProvider() {
        return  variableManager -> {
            Object candidate = variableManager.getVariables().get(SelectCellComponent.CANDIDATE_VARIABLE);
            if (candidate instanceof EEnumLiteral) {
                return this.labelService.getStyledLabel(candidate).toString();
            }
            return this.labelService.getStyledLabel(candidate).toString();
        };
    }

    BiFunction<VariableManager, Object, List<Object>> getCellOptionsProvider() {
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
                return new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory, this.projectManagementMessageService, this.feedbackMessageService).getCellOptionsProvider().apply(variableManager, columnTargetObject);
            }
        };
    }

    private BiFunction<VariableManager, Object, String> getCellValueProvider() {
        return (variableManager, columnTargetObject) -> {
            Object value = "";
            Optional<WorkpackageArtefact> optionalWorkpackageArtefact = variableManager.get(VariableManager.SELF, WorkpackageArtefact.class);
            if (MessageConstants.WORKPACKAGE_COLUMN_NAME.equals(columnTargetObject)) {
                if (optionalWorkpackageArtefact.isPresent() && optionalWorkpackageArtefact.get().eContainer() instanceof Workpackage workpackage) {
                    value = this.identityService.getId(workpackage);
                }
            } else {
                value = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory, this.projectManagementMessageService, this.feedbackMessageService).getCellValueProvider().apply(variableManager, columnTargetObject);
            }
            return value.toString();
        };
    }

    Predicate<VariableManager> canCreateCellProvider(String requiredCellType) {
        return (variableManager) -> {
            Optional<String> optionalString = variableManager.get("columnTargetObject", String.class);
            if (optionalString.isPresent()) {
                String columnWorkpackage = optionalString.get();
                if (columnWorkpackage.equals("WORKPACKAGE_COLUMN_NAME")) {
                    return true;
                }
            }
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
}

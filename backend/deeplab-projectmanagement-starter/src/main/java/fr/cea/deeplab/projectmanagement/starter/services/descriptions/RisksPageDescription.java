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
import fr.cea.deeplab.projectmgmt.Risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.IObjectService;
import org.eclipse.sirius.components.forms.ButtonStyle;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.description.AbstractControlDescription;
import org.eclipse.sirius.components.forms.description.ButtonDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.TableWidgetDescription;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.tables.descriptions.CellDescription;
import org.eclipse.sirius.components.tables.descriptions.LineDescription;
import org.eclipse.sirius.components.tables.descriptions.TableDescription;

/**
 * This class is used to provide the project page description for the project risks.
 *
 * @author lfasani
 */
public class RisksPageDescription {

    private final IObjectService objectService;

    private final IIdentityService identityService;

    private final Function<VariableManager, String> semanticTargetIdProvider;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IProjectManagementMessageService projectManagementMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    public RisksPageDescription(IObjectService objectService, IIdentityService identityService, ComposedAdapterFactory composedAdapterFactory,
            IProjectManagementMessageService projectManagementMessageService, IFeedbackMessageService feedbackMessageService) {
        this.objectService = objectService;
        this.identityService = identityService;
        this.composedAdapterFactory = composedAdapterFactory;
        this.projectManagementMessageService = projectManagementMessageService;
        this.feedbackMessageService = feedbackMessageService;
        this.semanticTargetIdProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.objectService::getId).orElse(null);
    }

    PageDescription getRisksPageDescription() {
        List<AbstractControlDescription> controlDescriptions = new ArrayList<>();

        Function<VariableManager, List<Object>> semanticElementsProvider = variableManager -> variableManager.get(VariableManager.SELF, Project.class)
                .map(eObject -> {
                    List<Object> objects = new ArrayList<>();
                    objects.addAll(eObject.getOwnedRisks());
                    return objects;
                })
                .orElse(List.of());

        Function<VariableManager, String> labelProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class)
                .map(this.objectService::getLabel)
                .orElse(null);

        List<LineDescription> lineDescriptions = new ArrayList<>();
        LineDescription lineDescription = LineDescription.newLineDescription(UUID.nameUUIDFromBytes("Table - Line".getBytes()))
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .semanticElementsProvider(semanticElementsProvider)
                .build();
        lineDescriptions.add(lineDescription);

        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);
        TableDescription tableDescription = TableDescription.newTableDescription("risksTableId")
                .targetObjectIdProvider(this::getTargetObjectId)
                .targetObjectKindProvider(this::getTargetObjectKind)
                .labelProvider(labelProvider)
                .lineDescriptions(lineDescriptions)
                .columnDescriptions(List.of(widgetDescriptionBuilderHelper.buildFeaturesColumnDescription(ProjectmgmtFactory.eINSTANCE.createRisk(),
                        ProjectmgmtPackage.eINSTANCE.getRisk())))
                .cellDescription(this.buildCellDescription())
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
                .targetObjectIdProvider(variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.objectService::getId).orElse(null))
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
                .map(this.identityService::getKind)
                .orElse(null);
    }




    CellDescription buildCellDescription() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this::getTargetObjectId, this.objectService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);
        return CellDescription.newCellDescription("cells")
                .targetObjectIdProvider(vm-> "")
                .targetObjectKindProvider(vm-> "")
                .cellTypeProvider(widgetDescriptionBuilderHelper.getCellTypeProvider())
                .cellValueProvider(widgetDescriptionBuilderHelper.getCellValueProvider())
                .cellOptionsIdProvider(widgetDescriptionBuilderHelper.getCellOptionsIdProvider())
                .cellOptionsLabelProvider(widgetDescriptionBuilderHelper.getCellOptionsLabelProvider())
                .cellOptionsProvider(this.getCellOptionsProvider())
                .newCellValueHandler(widgetDescriptionBuilderHelper.getNewCellValueHandler())
                .build();
    }

    private BiFunction<VariableManager, Object, List<Object>> getCellOptionsProvider() {
        return (variableManager, columnTargetObject) -> {
            if (columnTargetObject.equals(ProjectmgmtPackage.eINSTANCE.getRisk_Workpackages())) {
                return variableManager.get(VariableManager.SELF, Risk.class)
                        .map(wpa -> wpa.eContainer())
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
}

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
import fr.cea.deeplab.projectmgmt.ProjectState;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.emf.forms.EMFFormDescriptionProvider;
import org.eclipse.sirius.components.emf.forms.EStructuralFeatureLabelProvider;
import org.eclipse.sirius.components.forms.ContainerBorderLineStyle;
import org.eclipse.sirius.components.forms.ContainerBorderStyle;
import org.eclipse.sirius.components.forms.FlexDirection;
import org.eclipse.sirius.components.forms.SelectStyle;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.components.SelectComponent;
import org.eclipse.sirius.components.forms.description.AbstractWidgetDescription;
import org.eclipse.sirius.components.forms.description.CheckboxDescription;
import org.eclipse.sirius.components.forms.description.FlexboxContainerDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.LabelDescription;
import org.eclipse.sirius.components.forms.description.MultiSelectDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.SelectDescription;
import org.eclipse.sirius.components.forms.description.TextareaDescription;
import org.eclipse.sirius.components.forms.description.TextfieldDescription;
import org.eclipse.sirius.components.representations.Success;
import org.eclipse.sirius.components.representations.VariableManager;

/**
 * This class is used to provide the project page description for the project management concept.
 *
 * @author lfasani
 */
public class ProjectPageDescription {

    private final ILabelService labelService;

    private final IIdentityService identityService;

    private final IObjectSearchService objectSearchService;

    private final Function<VariableManager, String> semanticTargetIdProvider;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IProjectManagementMessageService projectManagementMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    public ProjectPageDescription(ILabelService labelService, IIdentityService identityService, IObjectSearchService objectSearchService, ComposedAdapterFactory composedAdapterFactory, IProjectManagementMessageService projectManagementMessageService,
            IFeedbackMessageService feedbackMessageService) {
        this.labelService = labelService;
        this.identityService = identityService;
        this.objectSearchService = objectSearchService;
        this.composedAdapterFactory = composedAdapterFactory;
        this.projectManagementMessageService = projectManagementMessageService;
        this.feedbackMessageService = feedbackMessageService;
        this.semanticTargetIdProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.identityService::getId).orElse(null);
    }

    PageDescription getProjectPageDescription() {

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

        GroupDescription group = GroupDescription.newGroupDescription("projectGroupId")
                .idProvider(variableManager -> "workpackagesGroupId")
                .labelProvider(variableManager -> "")
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .controlDescriptions(List.of(mainFlexboxContainer))
                .build();

        return PageDescription.newPageDescription("projectPageId")
                .idProvider(variableManager -> "projectPageId")
                .labelProvider(variableManager -> this.projectManagementMessageService.getMessage(MessageConstants.PAGE_PROJECT))
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .groupDescriptions(List.of(group))
                .canCreatePredicate(variableManager -> true)
                .build();
    }

    private AbstractWidgetDescription getContainer1() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);
        LabelDescription labelDescription = widgetDescriptionBuilderHelper.buildLabelDescription(this.projectManagementMessageService.getMessage(MessageConstants.PAGE_PROJECT_GROUP_INFORMATION));
        TextfieldDescription nameDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(ProjectmgmtPackage.eINSTANCE.getProject_Name());
        TextfieldDescription referenceDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(ProjectmgmtPackage.eINSTANCE.getProject_Reference());
        TextareaDescription descriptionDescription = widgetDescriptionBuilderHelper.buildTextareaDescription(ProjectmgmtPackage.eINSTANCE.getProject_Description(), Project::getDescription, Project::setDescription, null);
        TextfieldDescription mainBrickDescription = widgetDescriptionBuilderHelper.buildTextfieldDescription(ProjectmgmtPackage.eINSTANCE.getProject_MainProgramBrick());

        SelectDescription stateDescription = SelectDescription.newSelectDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(this.semanticTargetIdProvider)
                .labelProvider(this.getLabelProvider(ProjectmgmtPackage.eINSTANCE.getProject_State()))
                .valueProvider(variableManager -> variableManager.get(VariableManager.SELF, Project.class).map(Project::getState).map(Object::toString).orElse(""))
                .optionIdProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, ProjectState.class).map(ProjectState::toString).orElse(""))
                .optionLabelProvider(variableManager -> variableManager.get(SelectComponent.CANDIDATE_VARIABLE, ProjectState.class).map(ProjectState::toString).orElse(""))
                .optionsProvider(variableManager -> List.of(ProjectState.values()))
                .newValueHandler((variableManager, newValue) -> {
                    variableManager.get(VariableManager.SELF, Project.class).ifPresent(project -> {
                        if (newValue == null || newValue.isBlank()) {
                            project.setState(null);
                        } else {
                            project.setState(ProjectState.valueOf(newValue));
                        }
                    });
                    return new Success();
                })
                .diagnosticsProvider(variableManager -> List.of())
                .kindProvider(diagnostic -> "")
                .messageProvider(diagnostic -> "")
                .styleProvider(variableManager -> SelectStyle.newSelectStyle().widgetGridLayout(widgetDescriptionBuilderHelper.buildWidgetGridLayout()).build())
                .build();
        CheckboxDescription isSensitiveCheckButton = widgetDescriptionBuilderHelper.getCheckboxDescription(ProjectmgmtPackage.eINSTANCE.getProject_IsSensitive(), Project::getIsSensitive,
                (project, booleanValue) -> project.setIsSensitive(booleanValue), false);

        return FlexboxContainerDescription.newFlexboxContainerDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(vm -> "")
                .labelProvider(vm -> "")
                .flexDirection(FlexDirection.column)
                .children(List.of(labelDescription, nameDescription, referenceDescription, descriptionDescription, mainBrickDescription, stateDescription, isSensitiveCheckButton))
                .borderStyleProvider(vm -> ContainerBorderStyle.newContainerBorderStyle()
                        .lineStyle(ContainerBorderLineStyle.Solid)
                        .size(2)
                        .color("theme.palette.text.primary")
                        .radius(6)
                        .build())
                .diagnosticsProvider(vm -> List.of()).kindProvider(object -> "").messageProvider(object -> "").build();
    }

    private AbstractWidgetDescription getContainer2() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);
        LabelDescription labelDescription = widgetDescriptionBuilderHelper.buildLabelDescription(this.projectManagementMessageService.getMessage(MessageConstants.PAGE_PROJECT_GROUP_ACTORS));
        SelectDescription leaderSelectDescription = widgetDescriptionBuilderHelper
                .buildSelectDescriptionForProjectResource(ProjectmgmtPackage.eINSTANCE.getProject_Leader(), this.projectManagementMessageService.getMessage(MessageConstants.PROJECT_LEADER_HELP));
        MultiSelectDescription membersMultiSelectDescription = widgetDescriptionBuilderHelper
                .buildMultiSelectDescriptionForProjectResource(ProjectmgmtPackage.eINSTANCE.getProject_Members(), this.projectManagementMessageService.getMessage(MessageConstants.PROJECT_MEMBERS_HELP));
        SelectDescription leadingUnitSelectDescription = widgetDescriptionBuilderHelper
                .buildSelectDescriptionForProjectResource(ProjectmgmtPackage.eINSTANCE.getProject_LeadingUnit(), null);
        MultiSelectDescription participantUnitsMultiSelectDescription = widgetDescriptionBuilderHelper
                .buildMultiSelectDescriptionForProjectResource(ProjectmgmtPackage.eINSTANCE.getProject_ParticipantUnits(), null);
        CheckboxDescription isTransverseCheckButton = widgetDescriptionBuilderHelper.getCheckboxDescription(ProjectmgmtPackage.eINSTANCE.getProject_IsTransverse(), Project::getIsTransverse, (project, aBoolean) -> {
        }, true);

        return FlexboxContainerDescription.newFlexboxContainerDescription(UUID.randomUUID().toString())
                .idProvider(new WidgetIdProvider())
                .targetObjectIdProvider(vm -> "")
                .labelProvider(vm -> "")
                .flexDirection(FlexDirection.column)
                .children(List.of(labelDescription, leaderSelectDescription, membersMultiSelectDescription, leadingUnitSelectDescription, participantUnitsMultiSelectDescription, isTransverseCheckButton))
                .borderStyleProvider(vm -> ContainerBorderStyle.newContainerBorderStyle().lineStyle(ContainerBorderLineStyle.Solid).size(2).color("theme.palette.text.primary").radius(6).build())
                .diagnosticsProvider(vm -> List.of()).kindProvider(object -> "").messageProvider(object -> "").build();
    }

    private Function<VariableManager, String> getLabelProvider(EStructuralFeature feature) {
        return new EStructuralFeatureLabelProvider(EMFFormDescriptionProvider.ESTRUCTURAL_FEATURE, this.composedAdapterFactory) {
            @Override
            public String apply(VariableManager variableManager) {
                VariableManager childVM = variableManager.createChild();
                childVM.put(EMFFormDescriptionProvider.ESTRUCTURAL_FEATURE, feature);
                return super.apply(childVM);
            }
        };
    }
}

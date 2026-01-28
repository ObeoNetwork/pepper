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
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.forms.FlexDirection;
import org.eclipse.sirius.components.forms.WidgetIdProvider;
import org.eclipse.sirius.components.forms.description.AbstractWidgetDescription;
import org.eclipse.sirius.components.forms.description.FlexboxContainerDescription;
import org.eclipse.sirius.components.forms.description.GroupDescription;
import org.eclipse.sirius.components.forms.description.LabelDescription;
import org.eclipse.sirius.components.forms.description.MultiSelectDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.forms.description.TextareaDescription;
import org.eclipse.sirius.components.representations.VariableManager;

/**
 * This class is used to provide the customer page description for the project management concept.
 *
 * @author lfasani
 */
public class CustomerPageDescription {

    private final ILabelService labelService;

    private final IIdentityService identityService;

    private final IObjectSearchService objectSearchService;

    private final ComposedAdapterFactory composedAdapterFactory;

    private final IProjectManagementMessageService projectManagementMessageService;

    private final Function<VariableManager, String> semanticTargetIdProvider;

    private final IFeedbackMessageService feedbackMessageService;

    public CustomerPageDescription(ILabelService labelService, IIdentityService identityService, IObjectSearchService objectSearchService,  ComposedAdapterFactory composedAdapterFactory, IProjectManagementMessageService projectManagementMessageService,
            IFeedbackMessageService feedbackMessageService) {
        this.labelService = labelService;
        this.identityService = identityService;
        this.objectSearchService = objectSearchService;
        this.composedAdapterFactory = composedAdapterFactory;
        this.projectManagementMessageService = projectManagementMessageService;
        this.feedbackMessageService = feedbackMessageService;
        this.semanticTargetIdProvider = variableManager -> variableManager.get(VariableManager.SELF, Object.class).map(this.identityService::getId).orElse(null);
    }

    PageDescription getCustomerPageDescription() {

        AbstractWidgetDescription container1  = this.getContainer1();
        AbstractWidgetDescription container2  = this.getContainer2();


        AbstractWidgetDescription mainFlexboxContainer  = FlexboxContainerDescription.newFlexboxContainerDescription(UUID.randomUUID().toString())
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

        return PageDescription.newPageDescription("customerPageId")
                .idProvider(variableManager -> "customerPageId")
                .labelProvider(variableManager -> this.projectManagementMessageService.getMessage(MessageConstants.PAGE_CLIENTS))
                .semanticElementsProvider(variableManager -> Collections.singletonList(variableManager.getVariables().get(VariableManager.SELF)))
                .groupDescriptions(List.of(group))
                .canCreatePredicate(variableManager -> true)
                .build();
    }

    private AbstractWidgetDescription getContainer1() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);

        LabelDescription labelDescription = widgetDescriptionBuilderHelper.buildLabelDescription(this.projectManagementMessageService.getMessage(MessageConstants.PAGE_CLIENTS_GROUP_CLIENTS));
        MultiSelectDescription clientsMultiSelectDescription = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService)
                .buildMultiSelectDescriptionForProjectResource(ProjectmgmtPackage.eINSTANCE.getProject_Clients(), null);

        MultiSelectDescription partnersMultiSelectDescription = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService)
                .buildMultiSelectDescriptionForProjectResource(ProjectmgmtPackage.eINSTANCE.getProject_Partners(), null);

        return widgetDescriptionBuilderHelper.buildFlexboxContainerDescription(List.of(labelDescription, clientsMultiSelectDescription, partnersMultiSelectDescription));
    }

    private AbstractWidgetDescription getContainer2() {
        WidgetDescriptionBuilderHelper widgetDescriptionBuilderHelper = new WidgetDescriptionBuilderHelper(this.semanticTargetIdProvider, this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory,
                this.projectManagementMessageService, this.feedbackMessageService);

        LabelDescription labelDescription = widgetDescriptionBuilderHelper.buildLabelDescription(this.projectManagementMessageService.getMessage(MessageConstants.PAGE_CLIENTS_GROUP_NEEDS));
        TextareaDescription clientNeedsDescription = widgetDescriptionBuilderHelper.buildTextareaDescription(ProjectmgmtPackage.eINSTANCE.getProject_ClientNeed(), Project::getClientNeed, Project::setClientNeed, MessageConstants.CLIENT_NEEDS_HELP);
        TextareaDescription descriptionDescription = widgetDescriptionBuilderHelper.buildTextareaDescription(ProjectmgmtPackage.eINSTANCE.getProject_InternalNeed(), Project::getInternalNeed, Project::setInternalNeed, MessageConstants.INTERNAL_NEEDS_HELP);

        return widgetDescriptionBuilderHelper.buildFlexboxContainerDescription(List.of(labelDescription, clientNeedsDescription, descriptionDescription));
    }
}

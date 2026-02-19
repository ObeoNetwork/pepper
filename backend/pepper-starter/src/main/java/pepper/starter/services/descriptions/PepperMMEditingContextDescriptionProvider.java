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
import pepper.peppermm.Project;

import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IEditingContextRepresentationDescriptionProvider;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.IIdentityService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.emf.tables.CursorBasedNavigationServices;
import org.eclipse.sirius.components.forms.description.FormDescription;
import org.eclipse.sirius.components.forms.description.PageDescription;
import org.eclipse.sirius.components.representations.GetOrCreateRandomIdProvider;
import org.eclipse.sirius.components.representations.IRepresentationDescription;
import org.eclipse.sirius.components.representations.VariableManager;
import org.springframework.stereotype.Service;

/**
 * This class is used to provide the description for the pepper meta model concepts.
 *
 * @author lfasani
 */
@Service
public class PepperMMEditingContextDescriptionProvider implements IEditingContextRepresentationDescriptionProvider {

    public static final String PROJECT_FORM_ID = "projectFormDescription";

    private final ComposedAdapterFactory composedAdapterFactory;

    private final ILabelService labelService;

    private final IIdentityService identityService;

    private final IObjectSearchService objectSearchService;

    private final IPepperMMMessageService pepperMMMessageService;

    private final IFeedbackMessageService feedbackMessageService;

    private final CursorBasedNavigationServices cursorBasedNavigationServices;

    public PepperMMEditingContextDescriptionProvider(List<ComposedAdapterFactory.Descriptor> composedAdapterFactoryDescriptors, ILabelService labelService, IIdentityService identityService, IObjectSearchService objectSearchService, IPepperMMMessageService pepperMMMessageService,
            IFeedbackMessageService feedbackMessageService) {
        this.labelService = Objects.requireNonNull(labelService);
        this.identityService = Objects.requireNonNull(identityService);
        this.objectSearchService = Objects.requireNonNull(objectSearchService);
        this.pepperMMMessageService = Objects.requireNonNull(pepperMMMessageService);
        this.feedbackMessageService = feedbackMessageService;
        this.cursorBasedNavigationServices = new CursorBasedNavigationServices();

        ComposedAdapterFactory factory = new ComposedAdapterFactory();
        composedAdapterFactoryDescriptors.forEach(descriptor ->
                factory.addAdapterFactory(descriptor.createAdapterFactory())
        );
        this.composedAdapterFactory = factory;
    }

    @Override
    public List<IRepresentationDescription> getRepresentationDescriptions(IEditingContext editingContext) {

        PageDescription projectPageDescription = new ProjectPageDescription(this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory, this.pepperMMMessageService, this.feedbackMessageService).getProjectPageDescription();
        PageDescription customerPageDescription = new CustomerPageDescription(this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory, this.pepperMMMessageService, this.feedbackMessageService).getCustomerPageDescription();
        PageDescription planningAndCostingPageDescription = new PlanningAndCostingPageDescription(this.labelService, this.identityService, this.objectSearchService, this.composedAdapterFactory, this.pepperMMMessageService, this.feedbackMessageService).getPageDescription();
        PageDescription workpackagesPageDescription = new WorkpackagesPageDescription(this.labelService, this.identityService, this.objectSearchService, this.cursorBasedNavigationServices, this.composedAdapterFactory, this.pepperMMMessageService, this.feedbackMessageService).getWorkpackagesPageDescription();
        PageDescription workpackageArtefactPageDescription = new WorkpackageArtefactPageDescription(this.labelService, this.identityService, this.objectSearchService, this.cursorBasedNavigationServices, this.composedAdapterFactory, this.pepperMMMessageService, this.feedbackMessageService).getWorkpackageArtefactsPageDescription();
        PageDescription risksPageDescription = new RisksPageDescription(this.labelService, this.identityService, this.objectSearchService, this.cursorBasedNavigationServices, this.composedAdapterFactory, this.pepperMMMessageService, this.feedbackMessageService).getRisksPageDescription();


        FormDescription projectFormDescription =  FormDescription.newFormDescription(PROJECT_FORM_ID)
                .label(this.pepperMMMessageService.getMessage(MessageConstants.FORM_TITLE))
                .idProvider(new GetOrCreateRandomIdProvider())
                .canCreatePredicate(vm -> true)
                .labelProvider(variableManager -> this.pepperMMMessageService.getMessage(MessageConstants.FORM_TITLE))
                .targetObjectIdProvider(this::getTargetObjectId)
                .canCreatePredicate(this::canCreate)
                .pageDescriptions(List.of(projectPageDescription, customerPageDescription, planningAndCostingPageDescription, workpackagesPageDescription, workpackageArtefactPageDescription, risksPageDescription))
                .iconURLsProvider(vm -> List.of())
                .build();
        return List.of(projectFormDescription);
    }

    private String getTargetObjectId(VariableManager variableManager) {
        return variableManager.get(VariableManager.SELF, Object.class)
                .map(this.identityService::getId)
                .orElse(null);
    }

    private boolean canCreate(VariableManager variableManager) {
        return variableManager.get(VariableManager.SELF, EObject.class)
                .filter(Project.class::isInstance)
                .isPresent();
    }
}

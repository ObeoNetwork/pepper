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
package pepper.starter.services.project;

import static pepper.starter.services.project.PepperMMProjectTemplateProvider.PEPPERMM_PEPPER_SAMPLE;

import java.util.UUID;

import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IEditingContextPersistenceService;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.eclipse.sirius.components.emf.services.api.IEMFEditingContext;
import org.eclipse.sirius.components.events.ICause;
import org.eclipse.sirius.web.application.project.services.api.ISemanticDataInitializer;
import org.springframework.stereotype.Service;

/**
 * Provides Pepper meta model specific project sample template.
 *
 * @author lfasani
 */
@Service
public class PepperMMProjectTemplateInitializerSample implements ISemanticDataInitializer {

    private final IEditingContextPersistenceService editingContextPersistenceService;

    private final DefaultRepresentationsCreation defaultRepresentationsCreation;

    public PepperMMProjectTemplateInitializerSample(IEditingContextPersistenceService editingContextPersistenceService, DefaultRepresentationsCreation defaultRepresentationsCreation) {
        this.editingContextPersistenceService = editingContextPersistenceService;
        this.defaultRepresentationsCreation = defaultRepresentationsCreation;
    }

    @Override
    public boolean canHandle(String projectTemplateId) {
        return PepperMMProjectTemplateProvider.PEPPERMM_EXAMPLE_TEMPLATE_ID.equals(projectTemplateId);
    }

    @Override
    public void handle(ICause cause, IEditingContext editingContext, String projectTemplateId) {
        if (PepperMMProjectTemplateProvider.PEPPERMM_EXAMPLE_TEMPLATE_ID.equals(projectTemplateId) && editingContext instanceof IEMFEditingContext emfEditingContext) {
            var documentId = UUID.randomUUID();
            var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());
            var resourceMetadataAdapter = new ResourceMetadataAdapter(PEPPERMM_PEPPER_SAMPLE);
            resource.eAdapters().add(resourceMetadataAdapter);
            emfEditingContext.getDomain().getResourceSet().getResources().add(resource);

            resource.getContents().add(new PepperMMSampleBuilder().getSampleContent());

            this.editingContextPersistenceService.persist(cause, editingContext);

            defaultRepresentationsCreation.createGanttOfWorkpackage(cause, editingContext, resource);
        }
    }


}

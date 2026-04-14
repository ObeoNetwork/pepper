/*******************************************************************************
 * Copyright (c) 2026 Obeo
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
package pepper.starter.services;

import static pepper.starter.services.PepperMMProjectTemplateProvider.PEPPERMM_EMPTY;

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
 * Provides Pepper meta model specific project empty template.
 *
 * @author ncouvert
 */
@Service
public class PepperMMProjectTemplateInitializerEmpty implements ISemanticDataInitializer {

    private final IEditingContextPersistenceService editingContextPersistenceService;

    public PepperMMProjectTemplateInitializerEmpty(IEditingContextPersistenceService editingContextPersistenceService) {
        this.editingContextPersistenceService = editingContextPersistenceService;
    }

    @Override
    public boolean canHandle(String projectTemplateId) {
        return PepperMMProjectTemplateProvider.PEPPERMM_EMPTY_TEMPLATE_ID.equals(projectTemplateId);
    }

    @Override
    public void handle(ICause cause, IEditingContext editingContext, String projectTemplateId) {
        if (PepperMMProjectTemplateProvider.PEPPERMM_EMPTY_TEMPLATE_ID.equals(projectTemplateId) && editingContext instanceof IEMFEditingContext emfEditingContext) {
            var documentId = UUID.randomUUID();
            var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());
            var resourceMetadataAdapter = new ResourceMetadataAdapter(PEPPERMM_EMPTY);
            resource.eAdapters().add(resourceMetadataAdapter);
            emfEditingContext.getDomain().getResourceSet().getResources().add(resource);

            resource.getContents().add(new PepperMMSampleBuilder().getEmptySampleContent());

            this.editingContextPersistenceService.persist(cause, editingContext);
        }
    }
}

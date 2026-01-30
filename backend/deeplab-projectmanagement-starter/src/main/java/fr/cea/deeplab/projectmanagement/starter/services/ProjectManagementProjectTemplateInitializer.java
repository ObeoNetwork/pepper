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
package fr.cea.deeplab.projectmanagement.starter.services;

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
 * Provides Project Management specific project templates initializers.
 *
 * @author lfasani
 */
@Service
public class ProjectManagementProjectTemplateInitializer implements ISemanticDataInitializer {

    private final IEditingContextPersistenceService editingContextPersistenceService;

    public ProjectManagementProjectTemplateInitializer(IEditingContextPersistenceService editingContextPersistenceService) {
        this.editingContextPersistenceService = editingContextPersistenceService;
    }

    @Override
    public boolean canHandle(String projectTemplateId) {
        return ProjectManagementProjectTemplateProvider.PROJECTMANAGEMENT_EXAMPLE_TEMPLATE_ID.equals(projectTemplateId);
    }

    @Override
    public void handle(ICause cause, IEditingContext editingContext, String projectTemplateId) {
        if (ProjectManagementProjectTemplateProvider.PROJECTMANAGEMENT_EXAMPLE_TEMPLATE_ID.equals(projectTemplateId) && editingContext instanceof IEMFEditingContext emfEditingContext) {
            var documentId = UUID.randomUUID();
            var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());
            var resourceMetadataAdapter = new ResourceMetadataAdapter("Project Management");
            resource.eAdapters().add(resourceMetadataAdapter);
            emfEditingContext.getDomain().getResourceSet().getResources().add(resource);

            resource.getContents().add(new ProjectManagementSampleBuilder().getSampleContent());

            this.editingContextPersistenceService.persist(cause, editingContext);
        }
    }
}

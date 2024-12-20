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
package fr.cea.deeplab.projectmanagement.starter.services;

import java.util.Optional;
import java.util.UUID;

import org.eclipse.sirius.components.core.RepresentationMetadata;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.eclipse.sirius.components.emf.services.api.IEMFEditingContext;
import org.eclipse.sirius.components.events.ICause;
import org.eclipse.sirius.web.application.project.services.api.IProjectTemplateInitializer;
import org.springframework.stereotype.Service;

/**
 * Provides Project Management specific project templates initializers.
 *
 * @author lfasani
 */
@Service
public class ProjectManagementProjectTemplateInitializer implements IProjectTemplateInitializer {
    @Override
    public boolean canHandle(String projectTemplateId) {
        return ProjectManagementProjectTemplateProvider.PROJECTMANAGEMENT_EXAMPLE_TEMPLATE_ID.equals(projectTemplateId);
    }

    @Override
    public Optional<RepresentationMetadata> handle(ICause cause, String projectTemplateId, IEditingContext editingContext) {
        if (ProjectManagementProjectTemplateProvider.PROJECTMANAGEMENT_EXAMPLE_TEMPLATE_ID.equals(projectTemplateId)) {
            return this.initializeProjectManagementModel(editingContext);
        }
        return Optional.empty();
    }

    private Optional<RepresentationMetadata> initializeProjectManagementModel(IEditingContext editingContext) {
        Optional<RepresentationMetadata> result = Optional.empty();
        if (editingContext instanceof IEMFEditingContext emfEditingContext) {
            var documentId = UUID.randomUUID();
            var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());
            var resourceMetadataAdapter = new ResourceMetadataAdapter("Project Management");
            resource.eAdapters().add(resourceMetadataAdapter);
            emfEditingContext.getDomain().getResourceSet().getResources().add(resource);

            resource.getContents().add(new ProjectManagementSampleBuilder().getEmptySampleContent());
        }
        return result;
    }
}

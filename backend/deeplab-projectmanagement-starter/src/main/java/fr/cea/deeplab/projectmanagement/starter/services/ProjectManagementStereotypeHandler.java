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

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.emf.services.api.IEMFEditingContext;
import org.eclipse.sirius.web.application.document.dto.DocumentDTO;
import org.eclipse.sirius.web.application.document.services.api.IStereotypeHandler;
import org.eclipse.sirius.web.application.views.explorer.services.ExplorerDescriptionProvider;
import org.springframework.stereotype.Service;

/**
 * Used to create documents from a stereotype.
 *
 * @author lfasani
 */
@Service
public class ProjectManagementStereotypeHandler implements IStereotypeHandler {

    private final ProjectManagementSamplesProvider projectManagementSamplesProvider;

    public ProjectManagementStereotypeHandler(ProjectManagementSamplesProvider projectManagementSamplesProvider) {
        this.projectManagementSamplesProvider = Objects.requireNonNull(projectManagementSamplesProvider);
    }

    @Override
    public boolean canHandle(IEditingContext editingContext, String stereotypeId) {
        return List.of(
                ProjectManagementStereotypeProvider.PROJECT_MANAGEMENT_EMPTY,
                ProjectManagementStereotypeProvider.PROJECT_MANAGEMENT_SAMPLE
        ).contains(stereotypeId);
    }

    @Override
    public Optional<DocumentDTO> handle(IEditingContext editingContext, String stereotypeId, String name) {
        if (editingContext instanceof IEMFEditingContext emfEditingContext) {
            return switch (stereotypeId) {
                case ProjectManagementStereotypeProvider.PROJECT_MANAGEMENT_EMPTY -> createEmptyProjectManagementDocument(emfEditingContext, name);
                case ProjectManagementStereotypeProvider.PROJECT_MANAGEMENT_SAMPLE -> createProjectManagementSampleDocument(emfEditingContext, name);
                default -> Optional.empty();
            };
        }
        return Optional.empty();
    }

    private Optional<DocumentDTO> createEmptyProjectManagementDocument(IEMFEditingContext editingContext, String name) {
        var documentId = this.projectManagementSamplesProvider.addEmptyProjectManagement(editingContext.getDomain().getResourceSet(), name);
        return Optional.of(new DocumentDTO(documentId, name, ExplorerDescriptionProvider.DOCUMENT_KIND));
    }

    private Optional<DocumentDTO> createProjectManagementSampleDocument(IEMFEditingContext editingContext, String name) {
        var documentId = this.projectManagementSamplesProvider.addProjectManagementSample(editingContext.getDomain().getResourceSet(), name);
        return Optional.of(new DocumentDTO(documentId, name, ExplorerDescriptionProvider.DOCUMENT_KIND));
    }
}

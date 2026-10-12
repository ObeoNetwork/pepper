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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.emf.services.api.IEMFEditingContext;
import org.eclipse.sirius.web.application.document.dto.CreateDocumentInput;
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
public class PepperMMStereotypeHandler implements IStereotypeHandler {

    private final PepperMMSamplesProvider pepperMMSamplesProvider;
    private final DefaultRepresentationsCreation defaultRepresentationsCreation;

    public PepperMMStereotypeHandler(PepperMMSamplesProvider pepperMMSamplesProvider, DefaultRepresentationsCreation defaultRepresentationsCreation) {
        this.pepperMMSamplesProvider = Objects.requireNonNull(pepperMMSamplesProvider);
        this.defaultRepresentationsCreation = defaultRepresentationsCreation;
    }

    @Override
    public boolean canHandle(IEditingContext editingContext, String stereotypeId) {
        return List.of(
                PepperMMStereotypeProvider.PROJECT_MANAGEMENT_EMPTY,
                PepperMMStereotypeProvider.PROJECT_MANAGEMENT_SAMPLE
        ).contains(stereotypeId);
    }

    @Override
    public Optional<DocumentDTO> handle(IEditingContext editingContext, String stereotypeId, String name) {
        if (editingContext instanceof IEMFEditingContext emfEditingContext) {
            Optional<DocumentDTO> document = switch (stereotypeId) {
                case PepperMMStereotypeProvider.PROJECT_MANAGEMENT_EMPTY -> this.createEmptyPepperMMDocument(emfEditingContext, name);
                case PepperMMStereotypeProvider.PROJECT_MANAGEMENT_SAMPLE -> this.createPepperMMSampleDocument(emfEditingContext, name);
                default -> Optional.empty();
            };

            List<Resource> resources = emfEditingContext.getDomain().getResourceSet().getResources();
            defaultRepresentationsCreation.createGanttOfWorkpackage(new CreateDocumentInput(UUID.randomUUID(), editingContext.getId(), stereotypeId, name), editingContext, resources.get(resources.size() - 1));
            return document;
        }
        return Optional.empty();
    }

    private Optional<DocumentDTO> createEmptyPepperMMDocument(IEMFEditingContext editingContext, String name) {
        var documentId = this.pepperMMSamplesProvider.addEmptyPepperMM(editingContext.getDomain().getResourceSet(), name);
        return Optional.of(new DocumentDTO(documentId, name, ExplorerDescriptionProvider.DOCUMENT_KIND));
    }

    private Optional<DocumentDTO> createPepperMMSampleDocument(IEMFEditingContext editingContext, String name) {
        var documentId = this.pepperMMSamplesProvider.addPepperMMSample(editingContext.getDomain().getResourceSet(), name);
        return Optional.of(new DocumentDTO(documentId, name, ExplorerDescriptionProvider.DOCUMENT_KIND));
    }
}

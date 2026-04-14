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
package pepper.starter.services;

import pepper.peppermm.Organization;
import pepper.peppermm.Workpackage;

import java.util.List;
import java.util.UUID;

import org.eclipse.sirius.components.collaborative.api.IRepresentationMetadataPersistenceService;
import org.eclipse.sirius.components.collaborative.api.IRepresentationPersistenceService;
import org.eclipse.sirius.components.collaborative.gantt.api.IGanttCreationService;
import org.eclipse.sirius.components.core.RepresentationMetadata;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IEditingContextPersistenceService;
import org.eclipse.sirius.components.core.api.IRepresentationDescriptionSearchService;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.eclipse.sirius.components.emf.services.api.IEMFEditingContext;
import org.eclipse.sirius.components.events.ICause;
import org.eclipse.sirius.components.gantt.Gantt;
import org.eclipse.sirius.components.gantt.description.GanttDescription;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.emfjson.resource.JsonResource;
import org.eclipse.sirius.web.application.project.services.api.ISemanticDataInitializer;
import org.springframework.stereotype.Service;

import static pepper.starter.services.PepperMMProjectTemplateProvider.PEPPERMM_EMPTY;
import static pepper.starter.services.PepperMMProjectTemplateProvider.PEPPERMM_PEPPER_SAMPLE;
import static pepper.starter.services.view.ViewGanttDescriptionBuilder.WORKPACKAGE_GANTT_REP_DESC_NAME;

/**
 * Provides Pepper meta model specific project templates initializers.
 *
 * @author lfasani
 */
@Service
public class PepperMMProjectTemplateInitializer implements ISemanticDataInitializer {

    private final IEditingContextPersistenceService editingContextPersistenceService;
    private final IRepresentationPersistenceService representationPersistenceService;
    private final IGanttCreationService ganttCreationService;
    private final IRepresentationDescriptionSearchService representationDescriptionSearchService;
    private final IRepresentationMetadataPersistenceService representationMetadataPersistenceService;

    public PepperMMProjectTemplateInitializer(IEditingContextPersistenceService editingContextPersistenceService, IRepresentationPersistenceService representationPersistenceService,
            IGanttCreationService ganttCreationService, IRepresentationDescriptionSearchService representationDescriptionSearchService,
            IRepresentationMetadataPersistenceService representationMetadataPersistenceService) {
        this.editingContextPersistenceService = editingContextPersistenceService;
        this.representationPersistenceService = representationPersistenceService;
        this.ganttCreationService = ganttCreationService;
        this.representationDescriptionSearchService = representationDescriptionSearchService;
        this.representationMetadataPersistenceService = representationMetadataPersistenceService;
    }

    @Override
    public boolean canHandle(String projectTemplateId) {
        return PepperMMProjectTemplateProvider.PEPPERMM_EXAMPLE_TEMPLATE_ID.equals(projectTemplateId) || PepperMMProjectTemplateProvider.PEPPERMM_EMPTY_TEMPLATE_ID.equals(projectTemplateId);
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

            this.createGanttOfWorkpackage(cause, editingContext, resource);
        } else if (PepperMMProjectTemplateProvider.PEPPERMM_EMPTY_TEMPLATE_ID.equals(projectTemplateId) && editingContext instanceof IEMFEditingContext emfEditingContext) {
            var documentId = UUID.randomUUID();
            var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());
            var resourceMetadataAdapter = new ResourceMetadataAdapter(PEPPERMM_EMPTY);
            resource.eAdapters().add(resourceMetadataAdapter);
            emfEditingContext.getDomain().getResourceSet().getResources().add(resource);

            resource.getContents().add(new PepperMMSampleBuilder().getEmptySampleContent());

            this.editingContextPersistenceService.persist(cause, editingContext);
        }
    }

    private void createGanttOfWorkpackage(ICause cause, IEditingContext editingContext, JsonResource resource) {
        var optionalGanttDescription = this.representationDescriptionSearchService.findAll(editingContext)
                .values()
                .stream()
                .filter(GanttDescription.class::isInstance)
                .map(GanttDescription.class::cast)
                .filter(desc -> WORKPACKAGE_GANTT_REP_DESC_NAME.equals(desc.getLabel()))
                .findFirst();
        if (optionalGanttDescription.isPresent()) {
            GanttDescription ganttDescription = optionalGanttDescription.get();
            Workpackage workpackage = ((Organization) resource.getContents().get(0)).getOwnedProjects().get(0).getOwnedWorkpackages().get(0);
            var variableManager = new VariableManager();
            variableManager.put(VariableManager.SELF, workpackage);
            String label = ganttDescription.labelProvider().apply(variableManager);
            List<String> iconURLs = ganttDescription.getIconURLsProvider().apply(variableManager);

            Gantt gantt = this.ganttCreationService.create(workpackage, ganttDescription, editingContext);
            var representationMetadata = RepresentationMetadata.newRepresentationMetadata(gantt.getId())
                    .kind(gantt.getKind())
                    .label(label)
                    .descriptionId(gantt.descriptionId())
                    .iconURLs(iconURLs)
                    .build();
            this.representationMetadataPersistenceService.save(cause, editingContext, representationMetadata, gantt.targetObjectId());
            this.representationPersistenceService.save(cause, editingContext, gantt);
        }
    }
}

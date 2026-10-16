/*******************************************************************************
 * Copyright (c) 2026 Obeo.
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

package pepper.starter.services.project;

import static pepper.starter.services.representations.gantt.ViewGanttDescriptionBuilder.WORKPACKAGE_GANTT_REP_DESC_NAME;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.components.collaborative.api.IRepresentationMetadataPersistenceService;
import org.eclipse.sirius.components.collaborative.api.IRepresentationPersistenceService;
import org.eclipse.sirius.components.collaborative.gantt.api.IGanttCreationService;
import org.eclipse.sirius.components.core.RepresentationMetadata;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IRepresentationDescriptionSearchService;
import org.eclipse.sirius.components.events.ICause;
import org.eclipse.sirius.components.gantt.Gantt;
import org.eclipse.sirius.components.gantt.description.GanttDescription;
import org.eclipse.sirius.components.representations.VariableManager;
import org.springframework.stereotype.Service;

import pepper.peppermm.Organization;
import pepper.peppermm.Workpackage;

/**
 * Creates representation on some semantic objects.
 * @author lfasani
 */
@Service
public class DefaultRepresentationsCreation {

    private final IRepresentationPersistenceService representationPersistenceService;
    private final IGanttCreationService ganttCreationService;
    private final IRepresentationDescriptionSearchService representationDescriptionSearchService;
    private final IRepresentationMetadataPersistenceService representationMetadataPersistenceService;

    public DefaultRepresentationsCreation(IRepresentationPersistenceService representationPersistenceService,
            IGanttCreationService ganttCreationService, IRepresentationDescriptionSearchService representationDescriptionSearchService,
            IRepresentationMetadataPersistenceService representationMetadataPersistenceService) {
        this.representationPersistenceService = representationPersistenceService;
        this.ganttCreationService = ganttCreationService;
        this.representationDescriptionSearchService = representationDescriptionSearchService;
        this.representationMetadataPersistenceService = representationMetadataPersistenceService;
    }

    public void createGanttOfWorkpackage(ICause cause, IEditingContext editingContext, Resource resource) {
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

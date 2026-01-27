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
import java.util.UUID;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.migration.MigrationService;
import org.eclipse.sirius.components.emf.migration.api.IMigrationParticipant;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.springframework.stereotype.Service;

/**
 * Used to provide an example of ProjectManagement.
 *
 * @author lfasani
 */
@Service
public class ProjectManagementSamplesProvider {

    private final List<IMigrationParticipant> migrationParticipants;

    public ProjectManagementSamplesProvider(List<IMigrationParticipant> migrationParticipants) {
        this.migrationParticipants = Objects.requireNonNull(migrationParticipants);
    }

    public UUID addProjectManagementSample(ResourceSet resourceSet, String resourceName) {
        var documentId = UUID.randomUUID();
        var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());

        var resourceMetadataAdapter = new ResourceMetadataAdapter(resourceName);
        var migrationService = new MigrationService(this.migrationParticipants);

        resourceMetadataAdapter.addMigrationData(migrationService.getMostRecentParticipantMigrationData());

        resource.eAdapters().add(resourceMetadataAdapter);
        resourceSet.getResources().add(resource);

        resource.getContents().add(new ProjectManagementSampleBuilder().getSampleContent());

        return documentId;
    }

    public UUID addEmptyProjectManagement(ResourceSet resourceSet, String resourceName) {
        var documentId = UUID.randomUUID();
        var resource = new JSONResourceFactory().createResourceFromPath(documentId.toString());

        var resourceMetadataAdapter = new ResourceMetadataAdapter(resourceName);
        var migrationService = new MigrationService(this.migrationParticipants);

        resourceMetadataAdapter.addMigrationData(migrationService.getMostRecentParticipantMigrationData());

        resource.eAdapters().add(resourceMetadataAdapter);
        resourceSet.getResources().add(resource);

        resource.getContents().add(new ProjectManagementSampleBuilder().getEmptySampleContent());

        return documentId;
    }
}

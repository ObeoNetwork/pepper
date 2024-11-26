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

import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.web.application.UUIDParser;
import org.eclipse.sirius.web.application.document.dto.Stereotype;
import org.eclipse.sirius.web.application.document.services.api.IStereotypeProvider;
import org.eclipse.sirius.web.domain.boundedcontexts.project.Nature;
import org.eclipse.sirius.web.domain.boundedcontexts.project.services.api.IProjectSearchService;
import org.springframework.stereotype.Service;

/**
 * Used to return the list of stereotypes to create documents.
 *
 * @author lfasani
 */
@Service
public class ProjectManagementStereotypeProvider implements IStereotypeProvider {

    public static final String PROJECT_MANAGEMENT_SAMPLE = "projectmgmt_sample";

    public static final String PROJECT_MANAGEMENT_EMPTY = "projectmgmt_empty";

    private final IProjectSearchService projectSearchService;

    public ProjectManagementStereotypeProvider(IProjectSearchService projectSearchService) {
        this.projectSearchService = Objects.requireNonNull(projectSearchService);
    }

    @Override
    public List<Stereotype> getStereotypes(IEditingContext editingContext) {
        var isProjectMgmtProject = new UUIDParser().parse(editingContext.getId())
                .flatMap(this.projectSearchService::findById)
                .filter(project -> project.getNatures().stream()
                        .map(Nature::name)
                        .anyMatch(ProjectManagementProjectTemplateProvider.PROJECTMANAGEMENT_NATURE::equals))
                .isPresent();

        if (isProjectMgmtProject) {
            return List.of(
                    new Stereotype(PROJECT_MANAGEMENT_EMPTY, "Empty Project Management Model"),
                    new Stereotype(PROJECT_MANAGEMENT_SAMPLE, "Project Management Sample Model")
            );
        }
        return List.of();
    }
}

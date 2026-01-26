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

package fr.cea.deeplab.projectmanagement.starter.services;

import java.util.Objects;
import java.util.function.Predicate;

import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.web.application.UUIDParser;
import org.eclipse.sirius.web.domain.boundedcontexts.project.Nature;
import org.eclipse.sirius.web.domain.boundedcontexts.project.Project;
import org.eclipse.sirius.web.domain.boundedcontexts.project.services.api.IProjectSearchService;
import org.eclipse.sirius.web.domain.boundedcontexts.projectsemanticdata.ProjectSemanticData;
import org.eclipse.sirius.web.domain.boundedcontexts.projectsemanticdata.services.api.IProjectSemanticDataSearchService;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

/**
 * Used to test if an editing context is capable of supporting an ontology project.
 * @author lfasani ncouvert
 */
@Service
public class PepperEditingContextPredicate implements Predicate<IEditingContext> {

    private final IProjectSearchService projectSearchService;

    private final IProjectSemanticDataSearchService projectSemanticDataSearchService;

    public PepperEditingContextPredicate(IProjectSearchService projectSearchService, IProjectSemanticDataSearchService projectSemanticDataSearchService) {
        this.projectSearchService = Objects.requireNonNull(projectSearchService);
        this.projectSemanticDataSearchService = projectSemanticDataSearchService;
    }

    @Override
    public boolean test(IEditingContext editingContext) {
        return new UUIDParser().parse(editingContext.getId())
                .flatMap(semanticDataId -> this.projectSemanticDataSearchService.findBySemanticDataId(AggregateReference.to(semanticDataId)))
                .map(ProjectSemanticData::getProject)
                .map(AggregateReference::getId)
                .flatMap(this.projectSearchService::findById)
                .filter(this::isPepperProject)
                .isPresent();
    }

    private boolean isPepperProject(Project project) {
        return project.getNatures().stream()
                .map(Nature::name)
                .anyMatch(ProjectManagementProjectTemplateProvider.PROJECTMANAGEMENT_NATURE::equals);
    }
}

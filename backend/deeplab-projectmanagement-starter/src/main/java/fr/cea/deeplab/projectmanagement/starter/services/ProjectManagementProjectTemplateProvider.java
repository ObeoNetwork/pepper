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

import org.eclipse.sirius.web.application.project.services.api.IProjectTemplateProvider;
import org.eclipse.sirius.web.application.project.services.api.ProjectTemplate;
import org.eclipse.sirius.web.application.project.services.api.ProjectTemplateNature;
import org.springframework.stereotype.Service;

/**
 * Provides ProjectManagement-specific project templates.
 *
 * @author lfasani
 */
@Service
public class ProjectManagementProjectTemplateProvider implements IProjectTemplateProvider {

    public static final String PROJECTMANAGEMENT_EXAMPLE_TEMPLATE_ID = "projectmanagement-template";

    public static final String PROJECTMANAGEMENT_NATURE = "siriusWeb://nature?kind=projectmgmt";

    @Override
    public List<ProjectTemplate> getProjectTemplates() {
        var projectManagementTemplate = new ProjectTemplate(PROJECTMANAGEMENT_EXAMPLE_TEMPLATE_ID, "Project Management", "/project-templates/ProjectManagement-Template.png", List.of(new ProjectTemplateNature(PROJECTMANAGEMENT_NATURE)));
        return List.of(projectManagementTemplate);
    }
}

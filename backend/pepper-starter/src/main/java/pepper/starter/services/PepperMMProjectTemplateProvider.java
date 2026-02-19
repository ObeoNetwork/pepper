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

import java.util.List;

import org.eclipse.sirius.web.application.project.services.api.IProjectTemplateProvider;
import org.eclipse.sirius.web.application.project.services.api.ProjectTemplate;
import org.eclipse.sirius.web.application.project.services.api.ProjectTemplateNature;
import org.springframework.stereotype.Service;

/**
 * Provides PepperMM-specific project templates.
 *
 * @author lfasani
 */
@Service
public class PepperMMProjectTemplateProvider implements IProjectTemplateProvider {

    public static final String PEPPERMM_EXAMPLE_TEMPLATE_ID = "pepper-template";

    public static final String PEPPERMM_NATURE = "siriusWeb://nature?kind=peppermm";

    @Override
    public List<ProjectTemplate> getProjectTemplates() {
        var pepperMMTemplate = new ProjectTemplate(PEPPERMM_EXAMPLE_TEMPLATE_ID, "Pepper", "/project-templates/PepperMM-Template.png", List.of(new ProjectTemplateNature(PEPPERMM_NATURE)));
        return List.of(pepperMMTemplate);
    }
}

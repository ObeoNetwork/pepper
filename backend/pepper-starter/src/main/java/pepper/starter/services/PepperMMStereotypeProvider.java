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

import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.web.application.document.dto.Stereotype;
import org.eclipse.sirius.web.application.document.services.api.IStereotypeProvider;
import org.eclipse.sirius.web.domain.boundedcontexts.project.services.api.IProjectSearchService;
import org.eclipse.sirius.web.domain.boundedcontexts.projectsemanticdata.services.api.IProjectSemanticDataSearchService;
import org.springframework.stereotype.Service;

/**
 * Used to return the list of stereotypes to create documents.
 *
 * @author lfasani
 */
@Service
public class PepperMMStereotypeProvider implements IStereotypeProvider {

    public static final String PROJECT_MANAGEMENT_SAMPLE = "peppermm_sample";

    public static final String PROJECT_MANAGEMENT_EMPTY = "peppermm_empty";

    private final PepperEditingContextPredicate pepperEditingContextPredicate;

    public PepperMMStereotypeProvider(IProjectSearchService projectSearchService, IProjectSemanticDataSearchService projectSemanticDataSearchService) {
        this.pepperEditingContextPredicate = new PepperEditingContextPredicate(projectSearchService, projectSemanticDataSearchService);
    }

    @Override
    public List<Stereotype> getStereotypes(IEditingContext editingContext) {

        if (this.pepperEditingContextPredicate.test(editingContext)) {
            return List.of(
                    new Stereotype(PROJECT_MANAGEMENT_EMPTY, "Empty Pepper Model"),
                    new Stereotype(PROJECT_MANAGEMENT_SAMPLE, "Pepper Sample Model")
            );
        }
        return List.of();
    }
}

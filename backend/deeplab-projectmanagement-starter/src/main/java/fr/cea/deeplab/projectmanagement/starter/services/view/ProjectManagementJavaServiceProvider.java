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
package fr.cea.deeplab.projectmanagement.starter.services.view;

import java.util.List;

import org.eclipse.sirius.components.view.RepresentationDescription;
import org.eclipse.sirius.components.view.View;
import org.eclipse.sirius.components.view.deck.DeckDescription;
import org.eclipse.sirius.components.view.emf.IJavaServiceProvider;
import org.eclipse.sirius.components.view.gantt.GanttDescription;
import org.springframework.stereotype.Service;

/**
 * Used to provide Java services for the Task related views.
 *
 * @author lfasani
 */
@Service
public class ProjectManagementJavaServiceProvider implements IJavaServiceProvider {

    @Override
    public List<Class<?>> getServiceClasses(View view) {
        boolean isProjectManagementRelatedView = view.getDescriptions().stream()
                .filter(repDescription -> {
                    return repDescription instanceof GanttDescription || repDescription instanceof DeckDescription;
                })
                .map(RepresentationDescription.class::cast)
                .anyMatch(representationDescription -> {
                    return representationDescription.getDomainType().contains("projectmgmt::");
                });

        if (isProjectManagementRelatedView) {
            return List.of(ProjectManagementJavaService.class);
        }
        return List.of();
    }

}

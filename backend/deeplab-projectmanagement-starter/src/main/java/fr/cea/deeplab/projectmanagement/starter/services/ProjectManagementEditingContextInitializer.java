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

import fr.cea.deeplab.projectmanagement.starter.services.view.ViewDeckDescriptionBuilder;
import fr.cea.deeplab.projectmanagement.starter.services.view.ViewGanttDescriptionBuilder;
import fr.cea.deeplab.projectmgmt.ProjectmgmtPackage;

import java.util.Objects;
import java.util.UUID;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IEditingContextProcessor;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.services.IDAdapter;
import org.eclipse.sirius.components.emf.services.JSONResourceFactory;
import org.eclipse.sirius.components.view.View;
import org.eclipse.sirius.components.view.ViewFactory;
import org.eclipse.sirius.emfjson.resource.JsonResource;
import org.eclipse.sirius.web.application.UUIDParser;
import org.eclipse.sirius.web.application.editingcontext.EditingContext;
import org.eclipse.sirius.web.domain.boundedcontexts.project.Nature;
import org.eclipse.sirius.web.domain.boundedcontexts.project.services.api.IProjectSearchService;
import org.springframework.stereotype.Service;

/**
 * Used to initialize the editing context of a project management project.
 *
 * @author lfasani
 */
@Service
public class ProjectManagementEditingContextInitializer implements IEditingContextProcessor {

    private final IProjectSearchService projectSearchService;

    public ProjectManagementEditingContextInitializer(IProjectSearchService projectSearchService) {
        this.projectSearchService = Objects.requireNonNull(projectSearchService);
    }

    @Override
    public void preProcess(IEditingContext editingContext) {
        var isProjectManagementProject = new UUIDParser().parse(editingContext.getId())
                .flatMap(this.projectSearchService::findById)
                .filter(project -> project.getNatures().stream()
                        .map(Nature::name)
                        .anyMatch(ProjectManagementProjectTemplateProvider.PROJECTMANAGEMENT_NATURE::equals))
                .isPresent();

        if (isProjectManagementProject && editingContext instanceof EditingContext emfEditingContext) {
            var packageRegistry = emfEditingContext.getDomain().getResourceSet().getPackageRegistry();
            packageRegistry.put(ProjectmgmtPackage.eNS_URI, ProjectmgmtPackage.eINSTANCE);

            emfEditingContext.getViews().add(this.getProjectManagementView());
        }
    }

    private View getProjectManagementView() {
        View view = ViewFactory.eINSTANCE.createView();
        new ViewGanttDescriptionBuilder().addRepresentationDescription(view);
        new ViewDeckDescriptionBuilder().addRepresentationDescriptions(view);

        view.eAllContents().forEachRemaining(eObject -> {
            eObject.eAdapters().add(new IDAdapter(UUID.nameUUIDFromBytes(EcoreUtil.getURI(eObject).toString().getBytes())));
        });

        String resourcePath = UUID.nameUUIDFromBytes("TaskView".getBytes()).toString();
        JsonResource resource = new JSONResourceFactory().createResourceFromPath(resourcePath);
        resource.eAdapters().add(new ResourceMetadataAdapter("TaskView"));
        resource.getContents().add(view);

        return view;
    }
}

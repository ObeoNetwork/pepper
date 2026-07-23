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
package pepper.starter.services.representations;

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
import org.eclipse.sirius.web.application.editingcontext.EditingContext;
import org.eclipse.sirius.web.domain.boundedcontexts.project.services.api.IProjectSearchService;
import org.eclipse.sirius.web.domain.boundedcontexts.projectsemanticdata.services.api.IProjectSemanticDataSearchService;
import org.springframework.stereotype.Service;

import pepper.peppermm.PepperPackage;
import pepper.starter.services.project.PepperEditingContextPredicate;
import pepper.starter.services.representations.deck.ViewDeckDescriptionBuilder;
import pepper.starter.services.representations.gantt.ViewGanttDescriptionBuilder;

/**
 * Used to initialize the editing context of a pepper project.
 *
 * @author lfasani
 */
@Service
public class PepperViewRepresentationDescriptionProvider implements IEditingContextProcessor {

    private final PepperEditingContextPredicate pepperEditingContextPredicate;

    public PepperViewRepresentationDescriptionProvider(IProjectSearchService projectSearchService, IProjectSemanticDataSearchService projectSemanticDataSearchService) {
        this.pepperEditingContextPredicate = new PepperEditingContextPredicate(projectSearchService, projectSemanticDataSearchService);
    }

    @Override
    public void preProcess(IEditingContext editingContext) {

        if (this.pepperEditingContextPredicate.test(editingContext) && editingContext instanceof EditingContext emfEditingContext) {
            var packageRegistry = emfEditingContext.getDomain().getResourceSet().getPackageRegistry();
            packageRegistry.put(PepperPackage.eNS_URI, PepperPackage.eINSTANCE);

            emfEditingContext.getViews().add(this.getPepperMMView());
        }
    }

    private View getPepperMMView() {
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

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

import pepper.peppermm.TaskTag;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.components.collaborative.api.IRepresentationImageProvider;
import org.eclipse.sirius.components.core.CoreImageConstants;
import org.eclipse.sirius.components.core.api.ILabelServiceDelegate;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.core.api.labels.StyledString;
import org.eclipse.sirius.components.emf.ResourceMetadataAdapter;
import org.eclipse.sirius.components.emf.services.api.IEMFLabelService;
import org.eclipse.sirius.ext.emf.edit.EditingDomainServices;
import org.eclipse.sirius.web.domain.boundedcontexts.representationdata.RepresentationIconURL;
import org.eclipse.sirius.web.domain.boundedcontexts.representationdata.RepresentationMetadata;
import org.springframework.stereotype.Service;

/**
 * This class allows to override {@link IObjectSearchService} behavior.
 *
 * @author Laurent Fasani
 */
@Service
public class PepperMMLabelServiceDelegate implements ILabelServiceDelegate {

    private final EditingDomainServices editingDomainServices = new EditingDomainServices();

    private final List<IRepresentationImageProvider> representationImageProviders;

    private final IEMFLabelService emfLabelService;

    public PepperMMLabelServiceDelegate(IEMFLabelService iemfLabelService, List<IRepresentationImageProvider> representationImageProviders) {
        this.representationImageProviders = representationImageProviders;
        this.emfLabelService = iemfLabelService;
    }

    @Override
    public boolean canHandle(Object object) {
        return object instanceof TaskTag;
    }

    @Override
    public StyledString getStyledLabel(Object object) {
        if (object instanceof TaskTag tag) {
            return StyledString.of(this.editingDomainServices.getLabelProviderText(tag));
        } else {
            StyledString label = StyledString.of("");
            if (object instanceof RepresentationMetadata representationMetadata) {
                label = StyledString.of(representationMetadata.getLabel());
            } else if (object instanceof Resource resource) {
                label = resource.eAdapters().stream()
                        .filter(ResourceMetadataAdapter.class::isInstance)
                        .map(ResourceMetadataAdapter.class::cast).findFirst()
                        .map(ResourceMetadataAdapter::getName)
                        .map(StyledString::of)
                        .orElse(StyledString.of(resource.getURI().lastSegment()));
            } else if (object instanceof EObject eObject) {
                label = this.emfLabelService.getStyledLabel(eObject);
            }
            return label;
        }
    }

    @Override
    public List<String> getImagePaths(Object self) {
        List<String> imagePaths = List.of(CoreImageConstants.DEFAULT_SVG);
        if (self instanceof RepresentationMetadata representationMetadata) {
            if (!representationMetadata.getIconURLs().isEmpty()) {
                imagePaths = representationMetadata.getIconURLs().stream()
                        .map(RepresentationIconURL::url)
                        .toList();
            } else {
                imagePaths = this.representationImageProviders.stream()
                        .flatMap(provider -> provider.getImageURL(representationMetadata.getKind()).stream())
                        .toList();
            }
        } else if (self instanceof Resource) {
            imagePaths = List.of("/icons/Resource.svg");
        } else if (self instanceof EObject eObject) {
            imagePaths = this.emfLabelService.getImagePaths(eObject);
        }
        return imagePaths;
    }
}

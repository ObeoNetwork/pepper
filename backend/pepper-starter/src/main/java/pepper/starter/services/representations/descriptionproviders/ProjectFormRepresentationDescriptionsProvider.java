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
package pepper.starter.services.representations.descriptionproviders;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.components.collaborative.api.IRepresentationDescriptionsProvider;
import org.eclipse.sirius.components.collaborative.dto.RepresentationDescriptionMetadataDTO;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.representations.IRepresentationDescription;
import org.springframework.stereotype.Service;

/**
 * Used to provide support for the representation description metadata.
 *
 * @author lfasani
 */
@Service
public class ProjectFormRepresentationDescriptionsProvider implements IRepresentationDescriptionsProvider {

    public ProjectFormRepresentationDescriptionsProvider() {
    }

    @Override
    public boolean canHandle(IRepresentationDescription representationDescription) {
        return ProjectFormEditingContextDescriptionProvider.PROJECT_FORM_ID.equals(representationDescription.getId());
    }

    @Override
    public List<RepresentationDescriptionMetadataDTO> handle(IEditingContext editingContext, Object object, IRepresentationDescription representationDescription) {
        List<RepresentationDescriptionMetadataDTO> result = new ArrayList<>();
        result.add(new RepresentationDescriptionMetadataDTO(representationDescription.getId(), representationDescription.getLabel(), representationDescription.getLabel(), ""));

        return result;
    }
}

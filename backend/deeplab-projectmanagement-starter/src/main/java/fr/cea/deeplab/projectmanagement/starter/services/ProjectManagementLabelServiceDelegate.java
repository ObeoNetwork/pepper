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

import fr.cea.deeplab.projectmgmt.TaskTag;

import java.util.List;

import org.eclipse.sirius.components.collaborative.api.IRepresentationImageProvider;
import org.eclipse.sirius.components.core.api.ILabelServiceDelegate;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.core.api.labels.StyledString;
import org.eclipse.sirius.components.emf.services.api.IEMFLabelService;
import org.eclipse.sirius.web.application.object.services.DefaultLabelService;
import org.eclipse.sirius.ext.emf.edit.EditingDomainServices;
import org.springframework.stereotype.Service;

/**
 * This class allows to override {@link IObjectSearchService} behavior.
 *
 * @author Laurent Fasani
 */
@Service
public class ProjectManagementLabelServiceDelegate extends DefaultLabelService implements ILabelServiceDelegate {

    private final EditingDomainServices editingDomainServices = new EditingDomainServices();

    public ProjectManagementLabelServiceDelegate(List<IRepresentationImageProvider> iRepresentationImageProviders, IEMFLabelService iemfLabelService) {
        super(iRepresentationImageProviders, iemfLabelService);
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
            return super.getStyledLabel(object);
        }
    }

}

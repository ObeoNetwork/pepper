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

import java.util.Optional;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.sirius.components.core.api.IEditService;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.core.api.ILabelService;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.web.application.object.services.DefaultEditService;
import org.eclipse.sirius.components.emf.services.ISuggestedRootObjectTypesProvider;
import org.eclipse.sirius.components.emf.services.api.IEMFKindService;
import org.eclipse.sirius.components.emf.services.messages.IEMFMessageService;
import org.eclipse.sirius.web.application.views.explorer.services.api.IExplorerLabelServiceDelegate;
import org.springframework.stereotype.Service;

/**
 *  This class allows to override {@link IEditService} behavior.
 *
 * @author Laurent Fasani
 */
@Service
public class ProjectManagementEditServiceDelegate extends DefaultEditService implements IExplorerLabelServiceDelegate {

    public ProjectManagementEditServiceDelegate(IEMFKindService emfKindService, ComposedAdapterFactory composedAdapterFactory, Optional<ISuggestedRootObjectTypesProvider> optionalSuggestedRootObjectsProvider,
            IObjectSearchService objectSearchService, ILabelService labelService, IFeedbackMessageService feedbackMessageService, IEMFMessageService messageService) {
        super(emfKindService, composedAdapterFactory, optionalSuggestedRootObjectsProvider, objectSearchService, labelService, feedbackMessageService, messageService);
    }

    @Override
    public boolean canHandle(Object object) {
        return object instanceof TaskTag;
    }

    @Override
    public boolean isEditable(Object self) {
        return true;
    }

    @Override
    public void editLabel(Object object, String newValue) {
        if (object instanceof TaskTag tag) {
            String[] split = newValue.split("::");
            if (split.length > 0) {
                tag.setPrefix(split[0]);
            }
            if (split.length > 1) {
                tag.setSuffix(split[1]);
            }
        } 
    }
}

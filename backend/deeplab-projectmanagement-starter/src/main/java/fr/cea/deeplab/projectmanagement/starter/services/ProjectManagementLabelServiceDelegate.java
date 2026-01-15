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
import org.eclipse.sirius.components.core.api.ILabelServiceDelegate;
import org.eclipse.sirius.components.core.api.IObjectSearchService;
import org.eclipse.sirius.components.core.api.labels.StyledString;
import org.eclipse.sirius.components.emf.services.DefaultLabelService;
import org.eclipse.sirius.components.emf.services.LabelFeatureProviderRegistry;
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

    public ProjectManagementLabelServiceDelegate(ComposedAdapterFactory composedAdapterFactory, LabelFeatureProviderRegistry labelFeatureProviderRegistry) {
        super(labelFeatureProviderRegistry, composedAdapterFactory);
    }

    @Override
    public boolean canHandle(Object object) {
        return object instanceof TaskTag;
    }

    @Override
    public StyledString getStyledLabel(Object object) {
        return StyledString.of(this.getLabel(object));
    }

    @Override
    public String getLabel(Object object) {
        if (object instanceof TaskTag tag) {
            return this.editingDomainServices.getLabelProviderText(tag);
        } else {
            return super.getLabel(object);
        }
    }

    @Override
    public String getFullLabel(Object object) {
        if (object instanceof TaskTag tag) {
            return this.editingDomainServices.getLabelProviderText(tag);
        } else {
            return super.getFullLabel(object);
        }
    }

    @Override
    public Optional<String> getLabelField(Object object) {
        if (object instanceof TaskTag tag) {
            return Optional.of(this.editingDomainServices.getLabelProviderText(tag));
        } else {
            return super.getLabelField(object);
        }
    }
}

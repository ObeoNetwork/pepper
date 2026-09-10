/*******************************************************************************
 * Copyright (c) 2026 Obeo.
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
package pepper.starter.services.project;

import java.util.Objects;

import org.eclipse.sirius.components.collaborative.editingcontext.api.IChangeDescriptionConsumer;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IEditingContextProcessor;
import org.eclipse.sirius.components.emf.services.api.IEMFEditingContext;
import org.springframework.stereotype.Service;

import pepper.domain.services.update.TaskUpdateAdapter;
import pepper.domain.services.update.TaskUpdateService;

/**
 * Installs the adapter responsible for updating tasks.
 *
 * @author lfasani
 */
@Service
public class TaskAutomaticUpdateAdapterInstaller implements IEditingContextProcessor, IChangeDescriptionConsumer {
    private final TaskUpdateService taskUpdateService;

    public TaskAutomaticUpdateAdapterInstaller(TaskUpdateService taskUpdateService) {
        this.taskUpdateService = Objects.requireNonNull(taskUpdateService);
    }

    @Override
    public void postProcess(IEditingContext editingContext) {
        if (editingContext instanceof IEMFEditingContext siriusWebEditingContext) {
            var resourceSet = siriusWebEditingContext.getDomain().getResourceSet();
            if (resourceSet.eAdapters().stream().noneMatch(TaskUpdateAdapter.class::isInstance)) {
                resourceSet.eAdapters().add(new TaskUpdateAdapter(taskUpdateService));
            }
        }
    }
}

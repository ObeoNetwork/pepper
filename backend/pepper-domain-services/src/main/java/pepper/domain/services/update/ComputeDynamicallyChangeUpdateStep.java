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

package pepper.domain.services.update;

import pepper.domain.services.TaskHelper;
import pepper.peppermm.AbstractTask;

/**
 * This class represents an update step for the change of the effort of a task.
 * @author lfasani
 */
public final class ComputeDynamicallyChangeUpdateStep extends TaskUpdateStep {
    private static final TaskHelper TASK_HELPER = new TaskHelper();

    private final AbstractTask abstractTask;

    private final Boolean newValue;

    public ComputeDynamicallyChangeUpdateStep(AbstractTask abstractTask, Boolean newValue) {
        this.abstractTask = abstractTask;
        this.newValue = newValue;
    }

    @Override
    public Object getImpactedTask() {
        return abstractTask;
    }

    @Override
    public String getName() {
        return TASK_HELPER.getName(abstractTask);
    }

    @Override
    public void update() {
        abstractTask.setComputeStartEndDynamically(newValue != null && newValue);
    }
}

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

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

import pepper.domain.services.TaskHelper;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.Task;

/**
 * This class represents the update of a dynamic task which is a parent of updated tasks.
 * @author lfasani
 */
public final class ParentUpdateStep extends TaskUpdateStep {
    private static final TaskHelper TASK_HELPER = new TaskHelper();

    private final AbstractTask abstractTask;

    public ParentUpdateStep(AbstractTask abstractTask) {
        this.abstractTask = abstractTask;
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
        List<Task> subTasks = abstractTask.getSubTasks();
        Instant startTime = subTasks.stream()
                .map(AbstractTask::getStartTime)
                .min(Comparator.naturalOrder())
                .orElse(null);
        abstractTask.setStartTime(startTime);

        Instant endTime = subTasks.stream()
                .map(AbstractTask::getEndTime)
                .max(Comparator.naturalOrder())
                .orElse(null);
        abstractTask.setEndTime(endTime);
    }

}

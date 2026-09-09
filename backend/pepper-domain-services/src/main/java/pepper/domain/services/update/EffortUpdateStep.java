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

import pepper.domain.services.TaskComputationService;
import pepper.domain.services.TaskHelper;
import pepper.domain.services.TemporalHelper;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.Workpackage;

/**
 * This class represents an update step for the change of the effort of a task.
 * @author lfasani
 */
public final class EffortUpdateStep extends TaskUpdateStep {
    private static final TaskHelper TASK_HELPER = new TaskHelper();
    private static final TemporalHelper TEMPORAL_HELPER = new TemporalHelper();

    private static final TaskComputationService TASK_COMPUTATION_SERVICE = new TaskComputationService();
    private static final WorkpackageComputationService WORKPACKAGE_COMPUTATION_SERVICE = new WorkpackageComputationService();

    private final DependencyRelatedObject task;

    private final String newEffort;

    public EffortUpdateStep(DependencyRelatedObject task, String newEffort) {
        this.task = task;
        this.newEffort = newEffort;
    }

    @Override
    public Object getImpactedTask() {
        return task;
    }

    @Override
    public String getName() {
        return TASK_HELPER.getName(task);
    }

    @Override
    public void update() {
        if (task instanceof AbstractTask abstractTask) {
            if (newEffort == null || newEffort.isBlank()) {
                TASK_COMPUTATION_SERVICE.updateEffort(abstractTask, 0);
            } else {
                try {
                    int valueInHours = TEMPORAL_HELPER.roundToNearestHalfDayInHours(newEffort);
                    if (valueInHours >= 0) {
                        TASK_COMPUTATION_SERVICE.updateEffort(abstractTask, valueInHours);
                    }
                } catch (NumberFormatException e) {
                    // Ignore
                }
            }
        } else if (task instanceof Workpackage workpackage) {
            if (newEffort == null || newEffort.isBlank()) {
                WORKPACKAGE_COMPUTATION_SERVICE.updateEffort(workpackage, 0);
            } else {
                try {
                    int valueInHours = (int) Math.round(Double.parseDouble(newEffort));
                    if (valueInHours >= 0) {
                        WORKPACKAGE_COMPUTATION_SERVICE.updateEffort(workpackage, valueInHours);
                    }
                } catch (NumberFormatException e) {
                    // Ignore
                }
            }
        }
    }
}

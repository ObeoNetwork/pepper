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

/**
 * Represent a step in the update of a task.
 * Steps are equal when their impacted task instances are the same.
 * @author lfasani
 */
public abstract class TaskUpdateStep {
    /**
     * Returns the object affected by this update step.
     *
     * @return the impacted task
     */
    public abstract Object getImpactedTask();

    public abstract String getName();

    public abstract void update();

    @Override
    public final boolean equals(Object object) {
        return object instanceof TaskUpdateStep that && this.getImpactedTask() == that.getImpactedTask();
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this.getImpactedTask());
    }
}

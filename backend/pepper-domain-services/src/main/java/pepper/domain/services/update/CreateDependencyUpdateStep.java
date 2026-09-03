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
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.StartOrEnd;

/**
 * This class represents the creation of a {@link DependencyLink}.
 * @author lfasani
 */
public final class CreateDependencyUpdateStep extends TaskUpdateStep {
    private static final TaskHelper TASK_HELPER = new TaskHelper();

    private final DependencyRelatedObject source;

    private final DependencyRelatedObject target;

    private final StartOrEnd sourceBoundary;

    private final StartOrEnd endBoundary;

    public CreateDependencyUpdateStep(DependencyRelatedObject source, DependencyRelatedObject target, StartOrEnd sourceBoundary, StartOrEnd endBoundary) {
        this.source = source;
        this.target = target;
        this.sourceBoundary = sourceBoundary;
        this.endBoundary = endBoundary;
    }

    @Override
    public Object getImpactedTask() {
        return source;
    }

    @Override
    public String getName() {
        return TASK_HELPER.getName(source);
    }

    @Override
    public void update() {
        DependencyLink dependencyLink = PepperFactory.eINSTANCE.createDependencyLink();
        dependencyLink.setSourceKind(sourceBoundary);
        dependencyLink.setTargetKind(endBoundary);

        dependencyLink.setSource(source);
        target.getDependencies().add(dependencyLink);
    }

}

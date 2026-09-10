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
package pepper.domain.services;

import java.time.temporal.Temporal;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.NamedElement;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Helper related to tasks (AbstractTask and Workpackage).
 *
 * @author lfasani
 */
public class TaskHelper {
    public Temporal getStartTemporal(DependencyRelatedObject dependencyRelatedObject) {
        Temporal startTemporal = null;
        if (dependencyRelatedObject instanceof AbstractTask abstractTask) {
            startTemporal = abstractTask.getStartTime();
        } else if (dependencyRelatedObject instanceof Workpackage workpackage) {
            startTemporal = workpackage.getStartDate();
        }
        return startTemporal;
    }

    public String getName(Object task) {
        return Optional.of(task)
                .filter(NamedElement.class::isInstance)
                .map(NamedElement.class::cast)
                .map(NamedElement::getName)
                .orElse("(no name)");
    }

    public boolean isComputedDynamically(DependencyRelatedObject targetTask) {
        boolean isComputedDynamically = false;
        if (targetTask instanceof AbstractTask abstractTask && abstractTask.isComputeStartEndDynamically()) {
            isComputedDynamically = abstractTask.isComputeStartEndDynamically();
        } else if (targetTask instanceof Workpackage workpackage && !workpackage.getOwnedTasks().isEmpty()) {
            isComputedDynamically = true;
        }
        return isComputedDynamically;
    }

    public <T> Optional<T> getParent(EObject eObject, Class<T> clazz) {
        Optional<T> objectOpt = Optional.empty();
        EObject parent = eObject.eContainer();
        while (parent != null) {
            if (clazz.isInstance(parent)) {
                objectOpt = Optional.of(clazz.cast(parent));
                break;
            }
            parent = parent.eContainer();
        }

        return objectOpt;
    }

    public boolean isParent(EObject parent, EObject child) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(parent.eAllContents(), Spliterator.ORDERED), false)
                .anyMatch(eObject -> eObject.equals(child));
    }

    public TaskTimeBoundariesConstraint getCalculationOption(DependencyRelatedObject task) {
        TaskTimeBoundariesConstraint calculationOption = null;
        if (task instanceof AbstractTask abstractTask) {
            calculationOption = abstractTask.getCalculationOption();
        } else if (task instanceof Workpackage workpackage) {
            calculationOption = workpackage.getCalculationOption();
        }
        return calculationOption;
    }

    public void setCalculationOption(DependencyRelatedObject task, TaskTimeBoundariesConstraint calculationOption) {
        if (task instanceof AbstractTask abstractTask) {
            abstractTask.setCalculationOption(calculationOption);
        } else if (task instanceof Workpackage workpackage) {
            workpackage.setCalculationOption(calculationOption);
        }
    }

    public boolean isBoundaryConstrainedByDependency(List<DependencyLink> dependencies, StartOrEnd boundary) {
        return dependencies.stream()
                .anyMatch(dep -> dep.getTargetKind() == boundary);
    }
}

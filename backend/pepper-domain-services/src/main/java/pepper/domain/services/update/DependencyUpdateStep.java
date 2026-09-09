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
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import pepper.domain.services.NonWorkingDaysService;
import pepper.domain.services.TaskComputationService;
import pepper.domain.services.TaskHelper;
import pepper.domain.services.TemporalHelper;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * This class represents the update of a task due to a {@link pepper.peppermm.DependencyLink}.
 * @author lfasani
 */
public final class DependencyUpdateStep extends TaskUpdateStep {
    private static final TaskHelper TASK_HELPER = new TaskHelper();

    private static final TaskComputationService TASK_COMPUTATION_SERVICE = new TaskComputationService();

    private static final WorkpackageComputationService WORKPACKAGE_COMPUTATION_SERVICE = new WorkpackageComputationService();

    private final NonWorkingDaysService nonWorkingDaysService = new NonWorkingDaysService();

    private final TemporalHelper temporalHelper = new TemporalHelper();

    private final DependencyRelatedObject targetTask;

    public DependencyUpdateStep(DependencyRelatedObject targetTask) {
        this.targetTask = targetTask;
    }

    @Override
    public Object getImpactedTask() {
        return targetTask;
    }

    @Override
    public String getName() {
        return TASK_HELPER.getName(targetTask);
    }

    @Override
    public void update() {
        List<DependencyLink> dependencies = targetTask.getDependencies();
        boolean startTimeControlledByDependency = TASK_HELPER.isBoundaryConstrainedByDependency(dependencies, StartOrEnd.START);
        boolean endTimeControlledByDependency = TASK_HELPER.isBoundaryConstrainedByDependency(dependencies, StartOrEnd.END);

        TaskTimeBoundariesConstraint initialCalculationOption = TASK_HELPER.getCalculationOption(targetTask);
        if (startTimeControlledByDependency) { //Whatever endTimeControlledByDependency
            TASK_HELPER.setCalculationOption(targetTask, TaskTimeBoundariesConstraint.START_EFFORT);

            if (targetTask instanceof AbstractTask abstractTask) {
                Instant nextTimeFromDependency = this.getNextTimeFromDependency(dependencies, StartOrEnd.START);
                TASK_COMPUTATION_SERVICE.updateStartTime(abstractTask, nextTimeFromDependency);
            } else if (targetTask instanceof Workpackage workpackage) {
                LocalDate nextDateFromDependency = this.getNextDateFromDependency(dependencies, StartOrEnd.START);
                WORKPACKAGE_COMPUTATION_SERVICE.updateStartDate(workpackage, nextDateFromDependency);
            }
        }
        if (endTimeControlledByDependency) {
            TASK_HELPER.setCalculationOption(targetTask, TaskTimeBoundariesConstraint.END_EFFORT);

            if (targetTask instanceof AbstractTask abstractTask) {
                Instant nextTimeFromDependency = this.getNextTimeFromDependency(dependencies, StartOrEnd.END);
                TASK_COMPUTATION_SERVICE.updateEndTime(abstractTask, nextTimeFromDependency);
            } else if (targetTask instanceof Workpackage workpackage) {
                LocalDate nextDateFromDependency = this.getNextDateFromDependency(dependencies, StartOrEnd.END);
                WORKPACKAGE_COMPUTATION_SERVICE.updateEndDate(workpackage, nextDateFromDependency);
            }
        }
        TASK_HELPER.setCalculationOption(targetTask, initialCalculationOption);

    }

    @SuppressWarnings("checkstyle:ReturnCount")
    Instant getNextTimeFromDependency(List<DependencyLink> dependencies, StartOrEnd targetBoundary) {
        return dependencies.stream()
                .filter(dep -> dep.getTargetKind() == targetBoundary)
                .filter(dependencyLink -> dependencyLink.getSource() instanceof AbstractTask)
                .map(dependencyLink -> {
                    Instant roundedStartTime = temporalHelper.roundToNearestHalfDay(((AbstractTask) dependencyLink.getSource()).getStartTime());
                    Instant roundedEndTime = temporalHelper.roundToNearestHalfDay(((AbstractTask) dependencyLink.getSource()).getEndTime());
                    if (targetBoundary == StartOrEnd.START) {
                        if (dependencyLink.getSourceKind() == StartOrEnd.START) {
                            return nonWorkingDaysService.getNextStartTime(roundedStartTime, dependencyLink.getDelay(), List.of());
                        } else {
                            return nonWorkingDaysService.getNextStartTime(roundedEndTime, dependencyLink.getDelay(), List.of());
                        }
                    } else {
                        if (dependencyLink.getSourceKind() == StartOrEnd.START) {
                            return nonWorkingDaysService.getNextEndTime(roundedStartTime, dependencyLink.getDelay(), List.of());
                        } else {
                            return nonWorkingDaysService.getNextEndTime(roundedEndTime, dependencyLink.getDelay(), List.of());
                        }
                    }
                })
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    LocalDate getNextDateFromDependency(List<DependencyLink> dependencies, StartOrEnd targetBoundary) {
        return dependencies.stream()
                .filter(dep -> dep.getTargetKind() == targetBoundary)
                .filter(dependencyLink -> dependencyLink.getSource() instanceof Workpackage)
                .map(dependencyLink -> {
                    if (dependencyLink.getSourceKind() == StartOrEnd.START) {
                        return nonWorkingDaysService.getNextEndDate(((Workpackage) dependencyLink.getSource()).getStartDate().plusDays(1), dependencyLink.getDelay() + 1, List.of());
                    } else {
                        return nonWorkingDaysService.getNextEndDate(((Workpackage) dependencyLink.getSource()).getEndDate().plusDays(1), dependencyLink.getDelay() + 1, List.of());
                    }
                })
                .max(Comparator.naturalOrder())
                .orElse(null);
    }
}

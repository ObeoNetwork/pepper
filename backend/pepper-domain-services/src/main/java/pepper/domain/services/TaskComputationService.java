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

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.TaskTimeBoundariesConstraint;

@Service
public class TaskComputationService {

    public void updateEndTime(AbstractTask abstractTask, Instant newEndTime) {
        TaskTimeBoundariesConstraint calculationOption = abstractTask.getCalculationOption();
        if (TaskTimeBoundariesConstraint.START_DURATION.equals(calculationOption)) {
            return;
        }
        abstractTask.setEndTime(newEndTime);

        Instant currentStartTime = abstractTask.getStartTime();
        int currentDuration = abstractTask.getDuration();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_END)) {
            if (newEndTime != null && currentStartTime != null) {
                int newDuration = (int) ChronoUnit.HOURS.between(currentStartTime, newEndTime);
                if (ChronoUnit.MINUTES.between(currentStartTime, newEndTime) % 60 != 0) {
                    newDuration += 1;
                }
                abstractTask.setDuration(newDuration);
            }
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_DURATION) && newEndTime != null) {
            Instant newStartTime = newEndTime.minus(currentDuration, ChronoUnit.HOURS).plus(1, ChronoUnit.MINUTES);
            abstractTask.setStartTime(newStartTime);
        }
    }

    public void updateStartTime(AbstractTask abstractTask, Instant newStartTime) {
        TaskTimeBoundariesConstraint calculationOption = abstractTask.getCalculationOption();
        if (TaskTimeBoundariesConstraint.END_DURATION.equals(calculationOption)) {
            return;
        }
        abstractTask.setStartTime(newStartTime);

        Instant currentEndTime = abstractTask.getEndTime();
        int currentDuration = abstractTask.getDuration();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_END)) {
            if (currentEndTime != null && newStartTime != null) {
                int newDuration = (int) ChronoUnit.HOURS.between(newStartTime, currentEndTime);
                if (ChronoUnit.MINUTES.between(newStartTime, currentEndTime) % 60 != 0) {
                    newDuration += 1;
                }
                abstractTask.setDuration(newDuration);
            }
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.START_DURATION) && newStartTime != null) {
            Instant newEndTime = newStartTime.plus(currentDuration, ChronoUnit.HOURS).minus(1, ChronoUnit.MINUTES);
            abstractTask.setEndTime(newEndTime);
        }
    }

    public void updateDuration(AbstractTask abstractTask, int newDuration) {
        TaskTimeBoundariesConstraint calculationOption = abstractTask.getCalculationOption();
        if (TaskTimeBoundariesConstraint.START_END.equals(calculationOption)) {
            return;
        }
        abstractTask.setDuration(newDuration);

        Instant currentStartTime = abstractTask.getStartTime();
        Instant currentEndTime = abstractTask.getEndTime();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_DURATION)) {
            Instant newEndTime = currentStartTime.plus(newDuration, ChronoUnit.HOURS).minus(1, ChronoUnit.MINUTES);
            abstractTask.setEndTime(newEndTime);
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_DURATION)) {
            Instant newStartTime = currentEndTime.minus(newDuration, ChronoUnit.HOURS).plus(1, ChronoUnit.MINUTES);
            abstractTask.setStartTime(newStartTime);
        }
    }
}

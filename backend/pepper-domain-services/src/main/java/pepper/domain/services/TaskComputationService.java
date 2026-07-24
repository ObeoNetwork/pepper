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
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Domain service related to AbstractTask entities.
 * @author lfasani
 */
@Service
public class TaskComputationService {

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

    public Task createNewTask(Workpackage workpackage, String name) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(name);
        Optional<Task> optionalTask = workpackage.getOwnedTasks().stream().reduce((first, second) -> second)
                .filter(filteredTask -> filteredTask.getEndTime() != null && filteredTask.getStartTime() != null);

        if (optionalTask.isPresent()) {
            Task lastTask = optionalTask.get();
            if (lastTask.getEndTime().equals(lastTask.getStartTime())) {
                // If the last task is a Milestone
                updateStartTime(task, lastTask.getEndTime());
                updateEndTime(task, lastTask.getEndTime());
            } else {
                updateStartTime(task, lastTask.getEndTime().plus(1, ChronoUnit.MINUTES));
                updateEndTime(task, Instant.ofEpochSecond(2 * lastTask.getEndTime().getEpochSecond() - lastTask.getStartTime().getEpochSecond()).plus(1, ChronoUnit.MINUTES));
            }
        } else {
            if (workpackage.getEndDate() != null && workpackage.getStartDate() != null) {
                ZonedDateTime zdt = workpackage.getStartDate().atStartOfDay(ZoneId.systemDefault());
                String zone = zdt.getOffset().toString();
                String startTime = workpackage.getStartDate().toString() + "T00:00:00.00" + zone;
                String endTime = workpackage.getEndDate().toString() + "T23:59:00.00" + zone;
                Instant startInstant = Instant.parse(startTime);
                Instant endInstant = Instant.parse(endTime);
                updateStartTime(task, startInstant);
                updateEndTime(task, endInstant);
            }
        }
        return task;
    }

    public Task createNewTask(AbstractTask abstractTask, String name) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(name);
        Optional<Task> optionalTask = abstractTask.getSubTasks().stream().reduce((first, second) -> second)
                .filter(filteredTask -> filteredTask.getEndTime() != null && filteredTask.getStartTime() != null);

        if (optionalTask.isPresent()) {
            Task lastTask = optionalTask.get();
            if (lastTask.getEndTime().equals(lastTask.getStartTime())) {
                // If the last task is a Milestone
                task.setStartTime(lastTask.getEndTime());
                task.setEndTime(lastTask.getEndTime());
            } else {
                task.setStartTime(lastTask.getEndTime().plus(1, ChronoUnit.MINUTES));
                task.setEndTime(Instant.ofEpochSecond(2 * lastTask.getEndTime().getEpochSecond() - lastTask.getStartTime().getEpochSecond()).plus(1, ChronoUnit.MINUTES));
            }
        } else {
            if (abstractTask.getEndTime() != null && abstractTask.getStartTime() != null) {
                task.setStartTime(abstractTask.getStartTime());
                task.setEndTime(abstractTask.getEndTime());
            }
        }
        return task;
    }
}

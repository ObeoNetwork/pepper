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

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Domain service related to AbstractTask entities.
 *
 * @author lfasani
 */
@Service
public class TaskComputationService {
    private final NonWorkingDaysService nonWorkingDaysService = new NonWorkingDaysService();

    private final ZoneId localZone = ZoneId.systemDefault();

    /**
     * Update the newStartTime and potentially effort or endTime according to the calculationOption. It also rounds newStartTime and shifts it sooner if included in a non-working day period.
     */
    public void updateStartTime(AbstractTask abstractTask, Instant newStartTime) {
        TaskTimeBoundariesConstraint calculationOption = abstractTask.getCalculationOption();
        Instant roundedNewStartTime = this.roundToNearestHalfDay(newStartTime);
        Instant previousStartTime = nonWorkingDaysService.getPreviousStartTime(roundedNewStartTime, abstractTask.getAssignedPersons());
        abstractTask.setStartTime(this.convertAccordingToTimeZone(previousStartTime));

        Instant currentEndTime = this.roundToNearestHalfDay(abstractTask.getEndTime());
        int currentEffort = abstractTask.getEffort();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_EFFORT) && previousStartTime != null) {
            Instant newEndTime = nonWorkingDaysService.getNextEndTime(previousStartTime, currentEffort, abstractTask.getAssignedPersons()).minus(1, ChronoUnit.MINUTES);
            abstractTask.setEndTime(this.convertAccordingToTimeZone(newEndTime));
        } else {
            if (currentEndTime != null && previousStartTime != null) {
                long hourEffort = nonWorkingDaysService.getEffort(previousStartTime, currentEndTime, abstractTask.getAssignedPersons()).toHours();
                abstractTask.setEffort((int) hourEffort);
            }
        }

        this.updateDuration(abstractTask);
    }

    /**
     * Update the endTime and potentially effort or startTime according to the calculationOption. It also rounds newEndTime and shifts it later if included in a non-working day period.
     */
    public void updateEndTime(AbstractTask abstractTask, Instant newEndTime) {
        TaskTimeBoundariesConstraint calculationOption = abstractTask.getCalculationOption();
        Instant roundedNewEndTime = this.roundToNearestHalfDay(newEndTime);
        Instant nextEndTime = nonWorkingDaysService.getNextEndTime(roundedNewEndTime, abstractTask.getAssignedPersons());
        abstractTask.setEndTime(this.convertAccordingToTimeZone(nextEndTime).minus(1, ChronoUnit.MINUTES));

        Instant currentStartTime = this.roundToNearestHalfDay(abstractTask.getStartTime());
        int currentEffort = abstractTask.getEffort();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.END_EFFORT) && nextEndTime != null) {
            Instant newStartTime = nonWorkingDaysService.getPreviousStartTime(nextEndTime, currentEffort, abstractTask.getAssignedPersons()); //.plus(1, ChronoUnit.MINUTES);
            abstractTask.setStartTime(this.convertAccordingToTimeZone(newStartTime));
        } else {
            if (nextEndTime != null && currentStartTime != null) {
                long hourEffort = nonWorkingDaysService.getEffort(currentStartTime, nextEndTime, abstractTask.getAssignedPersons()).toHours();
                abstractTask.setEffort((int) hourEffort);
            }
        }

        this.updateDuration(abstractTask);
    }

    private void updateDuration(AbstractTask abstractTask) {
        if (abstractTask.getStartTime() != null && abstractTask.getEndTime() != null) {
            long hourDuration = nonWorkingDaysService.getDuration(this.roundToNearestHalfDay(abstractTask.getStartTime()), this.roundToNearestHalfDay(abstractTask.getEndTime())).toHours();
            abstractTask.setDuration((int) hourDuration);
        }
    }

    public void updateEffort(AbstractTask abstractTask, int newEffort) {
        int newEffortRouned = this.roundToNearestHalfDay(newEffort);
        TaskTimeBoundariesConstraint calculationOption = abstractTask.getCalculationOption();
        if (TaskTimeBoundariesConstraint.START_END.equals(calculationOption)) {
            return;
        }
        abstractTask.setEffort(newEffortRouned);

        Instant currentStartTime = this.roundToNearestHalfDay(abstractTask.getStartTime());
        Instant currentEndTime = this.roundToNearestHalfDay(abstractTask.getEndTime());
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_EFFORT) && currentStartTime != null) {
            Instant newEndTime = nonWorkingDaysService.getNextEndTime(currentStartTime, newEffortRouned, abstractTask.getAssignedPersons()).minus(1, ChronoUnit.MINUTES);
            abstractTask.setEndTime(this.convertAccordingToTimeZone(newEndTime));
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_EFFORT) && currentEndTime != null) {
            Instant newStartTime = nonWorkingDaysService.getPreviousStartTime(currentEndTime, newEffortRouned, abstractTask.getAssignedPersons()); //.plus(1, ChronoUnit.MINUTES);
            abstractTask.setStartTime(this.convertAccordingToTimeZone(newStartTime));
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
                this.updateStartTime(task, lastTask.getEndTime());
                this.updateEndTime(task, lastTask.getEndTime());
            } else {
                this.updateStartTime(task, lastTask.getEndTime().plus(1, ChronoUnit.MINUTES));
                this.updateEndTime(task, Instant.ofEpochSecond(2 * lastTask.getEndTime().getEpochSecond() - lastTask.getStartTime().getEpochSecond()).plus(1, ChronoUnit.MINUTES));
            }
        } else {
            if (workpackage.getEndDate() != null && workpackage.getStartDate() != null) {
                ZonedDateTime zdt = workpackage.getStartDate().atStartOfDay(ZoneId.systemDefault());
                String zone = zdt.getOffset().toString();
                String startTime = workpackage.getStartDate().toString() + "T00:00:00.00" + zone;
                String endTime = workpackage.getEndDate().toString() + "T23:59:00.00" + zone;
                Instant startInstant = Instant.parse(startTime);
                Instant endInstant = Instant.parse(endTime);
                this.updateStartTime(task, startInstant);
                this.updateEndTime(task, endInstant);
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

    private int roundToNearestHalfDay(int nbHours) {
        Duration inputDuration = Duration.ofHours(nbHours);
        Duration duration = inputDuration.isNegative()
                ? inputDuration.minusHours(6).truncatedTo(ChronoUnit.HALF_DAYS)
                : inputDuration.plusMinutes(6).truncatedTo(ChronoUnit.HALF_DAYS);

        return Math.toIntExact(duration.toHours());
    }

    public Instant roundToNearestHalfDay(Instant instant) {
        return Optional.ofNullable(instant)
                .map(inst -> inst.plus(Duration.ofHours(6)).truncatedTo(ChronoUnit.HALF_DAYS))
                .orElse(null);
    }

    private Instant convertAccordingToTimeZone(Instant instant) {
        ZoneId systemZone = ZoneId.systemDefault();
        ZoneOffset offset = systemZone.getRules().getOffset(instant);

        return instant.atZone(systemZone).minusHours(offset.getTotalSeconds() / 3600).toInstant();
    }

    private boolean hasDependency(AbstractTask abstractTask, StartOrEnd boundaryKind) {
        if (abstractTask instanceof DependencyRelatedObject dependencyRelatedObject) {
            return dependencyRelatedObject.getDependencies().stream()
                    .anyMatch(dependencyLink -> boundaryKind.equals(dependencyLink.getTargetKind()));
        }
        return false;
    }
}

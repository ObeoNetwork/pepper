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
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.AssignableObject;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.NamedElement;
import pepper.peppermm.Person;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Helper related to tasks (AbstractTask and Workpackage).
 *
 * @author lfasani
 */
public class TaskHelper {
    private final NonWorkingDaysService nonWorkingDaysService = new NonWorkingDaysService();

    private final TemporalHelper temporalHelper = new TemporalHelper();

    public Temporal getStartTemporal(Object object) {
        Temporal startTemporal = null;
        if (object instanceof AbstractTask abstractTask) {
            startTemporal = abstractTask.getStartTime();
        } else if (object instanceof Workpackage workpackage) {
            startTemporal = workpackage.getStartDate();
        }
        return startTemporal;
    }

    public Temporal getEndTemporal(Object object) {
        Temporal endTemporal = null;
        if (object instanceof AbstractTask abstractTask) {
            endTemporal = abstractTask.getEndTime();
        } else if (object instanceof Workpackage workpackage) {
            endTemporal = workpackage.getEndDate();
        }
        return endTemporal;
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

    public boolean mustBeComputedFromStartDateConsideringPersonAvailability(DependencyRelatedObject targetTask) {
        return this.mustBeComputedFromStartDateConsideringPersonAvailability(targetTask, this.getEndTemporal(targetTask));
    }

    /**
     * The task must be computed from the start if there is not enough assigned person manpower between the earliest moment of an available assigned person and the endTime.
     */
    public boolean mustBeComputedFromStartDateConsideringPersonAvailability(DependencyRelatedObject targetTask, Temporal end) {
        boolean mustBeComputedFromEndDate = false;
        if (targetTask instanceof AssignableObject assignableObject && !assignableObject.getAssignedPersons().isEmpty()) {
            if (targetTask instanceof AbstractTask abstractTask && end instanceof Instant newEndTime) {
                mustBeComputedFromEndDate = this.getEarlierAvailableInstantOfPerson(abstractTask.getAssignedPersons())
                        .map(earlierAvailableInstantOfPerson -> {
                            Instant nextEndTime = nonWorkingDaysService.getNextEndTime(temporalHelper.roundToNearestHalfDay(earlierAvailableInstantOfPerson), abstractTask.getEffort(),
                                    abstractTask.getAssignedPersons());
                            return temporalHelper.roundToNearestHalfDay(nextEndTime).isAfter(temporalHelper.roundToNearestHalfDay(newEndTime));
                        })
                        .orElse(false);
            } else if (targetTask instanceof Workpackage workpackage && end instanceof LocalDate newEndDate) {
                mustBeComputedFromEndDate = this.getEarlierAvailableInstantOfPerson(workpackage.getAssignedPersons())
                        .map(instant -> instant.atZone(ZoneId.systemDefault()).toLocalDate())
                        .map(earlierAvailableDateOfPerson -> {
                            LocalDate nextEndDate = nonWorkingDaysService.getEndDateFromStartDate(earlierAvailableDateOfPerson, workpackage.getEffort(), workpackage.getAssignedPersons());
                            return nextEndDate.isAfter(newEndDate);
                        })
                        .orElse(false);
            }
        }
        return mustBeComputedFromEndDate;
    }

    public Optional<Instant> getEarlierAvailableInstantOfPerson(List<Person> persons) {
        return persons.stream()
                .flatMap(person -> PersonCapacityAllocation.current().getNextAvailableSlot(person).stream())
                .min(Comparator.naturalOrder());
    }
}

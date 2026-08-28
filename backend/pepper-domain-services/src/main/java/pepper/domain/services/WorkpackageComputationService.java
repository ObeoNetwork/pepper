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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pepper.peppermm.PepperFactory;
import pepper.peppermm.Project;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Domain service related to Workpackage entity.
 *
 * @author lfasani
 */
@Service
public class WorkpackageComputationService {
    private final NonWorkingDaysService nonWorkingDaysService = new NonWorkingDaysService();

    public void updateStartDate(Workpackage workpackage, LocalDate newStartDate) {
        LocalDate previousNewStartDate = nonWorkingDaysService.getPreviousStartDate(newStartDate, workpackage.getAssignedPersons());
        TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
        workpackage.setStartDate(previousNewStartDate);

        LocalDate currentEndDate = workpackage.getEndDate();
        int currentEffort = workpackage.getEffort();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_EFFORT) && previousNewStartDate != null) {
            LocalDate newEndDate = nonWorkingDaysService.getNextEndDate(previousNewStartDate, currentEffort, workpackage.getAssignedPersons());
            workpackage.setEndDate(newEndDate);
        } else {
            if (currentEndDate != null && previousNewStartDate != null) {
                long newEffort = nonWorkingDaysService.getEffort(previousNewStartDate, currentEndDate, workpackage.getAssignedPersons()).toDays();
                workpackage.setEffort((int) newEffort);
            }
        }

        this.updateDuration(workpackage);
    }

    private void updateDuration(Workpackage workpackage) {
        if (workpackage.getStartDate() != null && workpackage.getEndDate() != null) {
            long hourDuration = nonWorkingDaysService.getDuration(workpackage.getStartDate(), workpackage.getEndDate(), workpackage.getAssignedPersons()).toHours();
            workpackage.setDuration((int) hourDuration);
        }
    }

    public void updateEndDate(Workpackage workpackage, LocalDate newEndDate) {
        LocalDate nextNewEndDate = nonWorkingDaysService.getNextEndDate(newEndDate, workpackage.getAssignedPersons());
        TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
        workpackage.setEndDate(nextNewEndDate);

        LocalDate currentStartDate = workpackage.getStartDate();
        int currentEffort = workpackage.getEffort();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.END_EFFORT) && nextNewEndDate != null) {
            LocalDate newStartDate = nonWorkingDaysService.getPreviousStartDate(nextNewEndDate, currentEffort, workpackage.getAssignedPersons());
            workpackage.setStartDate(newStartDate);
        } else {
            if (nextNewEndDate != null && currentStartDate != null) {
                long newEffort = nonWorkingDaysService.getEffort(currentStartDate, nextNewEndDate, workpackage.getAssignedPersons()).toDays();
                workpackage.setEffort((int) newEffort);
            }
        }

        this.updateDuration(workpackage);
    }

    public void updateEffort(Workpackage workpackage, int newEffort) {
        TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
        if (TaskTimeBoundariesConstraint.START_END.equals(calculationOption)) {
            return;
        }
        workpackage.setEffort(newEffort);

        LocalDate currentStartDate = workpackage.getStartDate();
        LocalDate currentEndDate = workpackage.getEndDate();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_EFFORT)) {
            LocalDate newEndDate = nonWorkingDaysService.getNextEndDate(currentStartDate, newEffort, workpackage.getAssignedPersons());
            workpackage.setEndDate(newEndDate);
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_EFFORT)) {
            LocalDate newStartDate = nonWorkingDaysService.getPreviousStartDate(currentEndDate, newEffort, workpackage.getAssignedPersons());
            workpackage.setStartDate(newStartDate);
        }
    }

    public Workpackage createNewWorkpackage(Project project, String name) {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.setName(name);

        Optional<Workpackage> optionalWorkpackage = project.getOwnedWorkpackages().stream().reduce((first, second) -> second)
                .filter(filteredWorkpackage -> filteredWorkpackage.getEndDate() != null && filteredWorkpackage.getStartDate() != null);
        if (optionalWorkpackage.isPresent()) {
            Workpackage lastWorkpackage = optionalWorkpackage.get();
            this.updateStartDate(workpackage, lastWorkpackage.getEndDate().plusDays(1));
            long difference = lastWorkpackage.getStartDate().until(lastWorkpackage.getEndDate(), ChronoUnit.DAYS);
            this.updateEndDate(workpackage, lastWorkpackage.getEndDate().plusDays(difference + 1));
        } else {
            LocalDate endDate = null;
            if (project.getEffectiveEndDate() != null) {
                endDate = project.getEffectiveEndDate();
            } else if (project.getContractualEndDate() != null) {
                endDate = project.getContractualEndDate();
            }
            LocalDate startDate = null;
            if (project.getEffectiveStartDate() != null) {
                startDate = project.getEffectiveStartDate();
            } else if (project.getContractualStartDate() != null) {
                startDate = project.getContractualStartDate();
            }
            if (startDate != null && endDate != null) {
                this.updateStartDate(workpackage, startDate);
                this.updateEndDate(workpackage, endDate);
            }
        }
        return workpackage;
    }

    private boolean hasDependency(Workpackage workpackage, StartOrEnd boundaryKind) {
        return workpackage.getDependencies().stream()
                .anyMatch(dependencyLink -> boundaryKind.equals(dependencyLink.getTargetKind()));
    }
}

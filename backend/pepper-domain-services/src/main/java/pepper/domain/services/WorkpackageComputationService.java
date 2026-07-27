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
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Domain service related to Workpackage entity.
 * @author lfasani
 */
@Service
public class WorkpackageComputationService {

    public void updateStartDate(Workpackage workpackage, LocalDate newStartDate) {
        TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
        if (TaskTimeBoundariesConstraint.END_DURATION.equals(calculationOption)) {
            return;
        }
        workpackage.setStartDate(newStartDate);

        LocalDate currentEndDate = workpackage.getEndDate();
        int currentDuration = workpackage.getDuration();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_END)) {
            if (currentEndDate != null && newStartDate != null) {
                int newDuration = (int) ChronoUnit.DAYS.between(newStartDate, currentEndDate) + 1;
                workpackage.setDuration(newDuration);
            }
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.START_DURATION) && newStartDate != null) {
            LocalDate newEndDate = newStartDate.plusDays(currentDuration - 1);
            workpackage.setEndDate(newEndDate);
        }
    }

    public void updateEndDate(Workpackage workpackage, LocalDate newEndDate) {
        TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
        if (TaskTimeBoundariesConstraint.START_DURATION.equals(calculationOption)) {
            return;
        }
        workpackage.setEndDate(newEndDate);

        LocalDate currentStartDate = workpackage.getStartDate();
        int currentDuration = workpackage.getDuration();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_END)) {
            if (newEndDate != null && currentStartDate != null) {
                int newDuration = (int) ChronoUnit.DAYS.between(currentStartDate, newEndDate) + 1;
                workpackage.setDuration(newDuration);
            }
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_DURATION) && newEndDate != null) {
            LocalDate newStartDate = newEndDate.minusDays(currentDuration - 1);
            workpackage.setStartDate(newStartDate);
        }
    }

    public void updateDuration(Workpackage workpackage, int newDuration) {
        TaskTimeBoundariesConstraint calculationOption = workpackage.getCalculationOption();
        if (TaskTimeBoundariesConstraint.START_END.equals(calculationOption)) {
            return;
        }
        workpackage.setDuration(newDuration);

        LocalDate currentStartDate = workpackage.getStartDate();
        LocalDate currentEndDate = workpackage.getEndDate();
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_DURATION)) {
            LocalDate newEndDate = currentStartDate.plusDays(newDuration - 1);
            workpackage.setEndDate(newEndDate);
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_DURATION)) {
            LocalDate newStartDate = currentEndDate.minusDays(newDuration - 1);
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
}

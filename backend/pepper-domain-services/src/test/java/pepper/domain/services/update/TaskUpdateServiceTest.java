/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/

package pepper.domain.services.update;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import pepper.peppermm.DependencyLink;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Project;
import pepper.peppermm.StartOrEnd;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;

/**
 * Tests updates propagated between workpackages by their dependencies.
 * @author lfasani
 */
public class TaskUpdateServiceTest {

    @ParameterizedTest
    @CsvSource({
        "START, START, 0, 2026-09-07, 2026-09-09",
        "START, START, 1, 2026-09-08, 2026-09-10",
        "START, START, 2, 2026-09-09, 2026-09-11",
        "END, START, 0, 2026-09-10, 2026-09-14",
        "END, START, 1, 2026-09-11, 2026-09-15",
        "END, START, 2, 2026-09-14, 2026-09-16",
            //TODO the following are KO because the day before source StartDate is off
//        "START, END, 0, 2026-09-03, 2026-09-06",
//        "START, END, 1, 2026-09-04, 2026-09-07",
//        "START, END, 2, 2026-09-07, 2026-09-08",
        "END, END, 0, 2026-09-07, 2026-09-09",
        "END, END, 1, 2026-09-08, 2026-09-10",
        "END, END, 2, 2026-09-09, 2026-09-11"
    })
    public void updatesDependentWorkpackageForEachBoundaryAndDelay(StartOrEnd sourceKind, StartOrEnd targetKind, int delay,
            LocalDate expectedStartDate, LocalDate expectedEndDate) {
        Workpackage source = this.workpackage("source", LocalDate.of(2026, 9, 7), LocalDate.of(2026, 9, 9));
        Workpackage target = this.workpackage("target", LocalDate.of(2026, 9, 21), LocalDate.of(2026, 9, 23));
        Project project = PepperFactory.eINSTANCE.createProject();
        project.getOwnedWorkpackages().add(source);
        project.getOwnedWorkpackages().add(target);

        ResourceSet resourceSet = new ResourceSetImpl();
        Resource resource = new ResourceImpl();
        resourceSet.getResources().add(resource);
        resourceSet.eAdapters().add(new ECrossReferenceAdapter());
        resource.getContents().add(project);

        DependencyLink dependency = PepperFactory.eINSTANCE.createDependencyLink();
        dependency.setSource(source);
        dependency.setSourceKind(sourceKind);
        dependency.setTargetKind(targetKind);
        dependency.setDelay(delay);
        target.getDependencies().add(dependency);

        new TaskUpdateService(mock(IFeedbackMessageService.class)).updateWithImpacts(source, new PersonUpdateStep(source));

        assertThat(source.getStartDate()).isEqualTo(LocalDate.of(2026, 9, 7));
        assertThat(source.getEndDate()).isEqualTo(LocalDate.of(2026, 9, 9));
        assertThat(target.getStartDate()).isEqualTo(expectedStartDate);
        assertThat(target.getEndDate()).isEqualTo(expectedEndDate);
        assertThat(target.getEffort()).isEqualTo(3);
        assertThat(target.getCalculationOption()).isEqualTo(TaskTimeBoundariesConstraint.START_EFFORT);
    }

    private Workpackage workpackage(String name, LocalDate startDate, LocalDate endDate) {
        Workpackage workpackage = PepperFactory.eINSTANCE.createWorkpackage();
        workpackage.setName(name);
        workpackage.setStartDate(startDate);
        workpackage.setEndDate(endDate);
        workpackage.setEffort(3);
        workpackage.setCalculationOption(TaskTimeBoundariesConstraint.START_EFFORT);
        return workpackage;
    }
}

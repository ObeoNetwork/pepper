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

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import pepper.peppermm.PepperFactory;
import pepper.peppermm.Person;
import pepper.peppermm.UnavailabilityPeriod;

/**
 * Tests of {@link NonWorkingDaysService}.
 *
 * @author lfasani
 */
@SuppressWarnings("checkstyle:MultipleStringLiterals")
public class NonWorkingDaysServiceTests {

    private static final LocalDate MONDAY_2026_07_06 = LocalDate.of(2026, 7, 6);
    private static final LocalDate TUESDAY_2026_07_07 = LocalDate.of(2026, 7, 7);
    private static final LocalDate WEDNESDAY_2026_07_08 = LocalDate.of(2026, 7, 8);
    private static final LocalDate FRIDAY_2026_07_10 = LocalDate.of(2026, 7, 10);

    private static final Instant MONDAY_2026_07_06_12_00 = Instant.parse("2026-07-06T12:00:00Z");
    private static final Instant TUESDAY_2026_07_07_12_00 = Instant.parse("2026-07-07T12:00:00Z");
    private static final Instant TUESDAY_2026_07_07_00_00 = Instant.parse("2026-07-07T00:00:00Z");
    private static final Instant WEDNESDAY_2026_07_08_00_00 = Instant.parse("2026-07-08T00:00:00Z");
    private static final Instant WEDNESDAY_2026_07_08_12_00 = Instant.parse("2026-07-08T12:00:00Z");
    private static final Instant THURSDAY_2026_07_09_00_00 = Instant.parse("2026-07-09T00:00:00Z");

    @Test
    public void getEffortIncludesPartialStartAndEndDays() {
        var service = new NonWorkingDaysService();

        Instant startTime = Instant.parse("2026-07-13T11:00:00Z");
        Instant endTime = Instant.parse("2026-07-15T12:00:00Z");

        assertThat(service.getEffort(startTime, endTime, List.of())).isEqualTo(Duration.ofHours(24));

        startTime = Instant.parse("2026-07-13T05:00:00Z");
        endTime = Instant.parse("2026-07-15T17:00:00Z");

        assertThat(service.getEffort(startTime, endTime, List.of())).isEqualTo(Duration.ofHours(36));
    }

    @Test
    public void getEffortBetweenInstantExcludesWeekendDays() {
        var service = new NonWorkingDaysService();

        // 10 and 11 are in a week-end and 14 is off
        Instant startTime = Instant.parse("2026-07-10T12:00:00Z");
        Instant endTime = Instant.parse("2026-07-16T12:00:00Z");

        assertThat(service.getEffort(startTime, endTime, List.of())).isEqualTo(Duration.ofDays(3));
    }

    @Test
    public void getEffortBetweenEqualWorkingDatesIsOneDay() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 13);

        assertThat(service.getEffort(date, date, List.of())).isEqualTo(Duration.ofDays(1));
    }

    @Test
    public void getEffortBetweenConsecutiveWorkingDatesIsOneDay() {
        var service = new NonWorkingDaysService();
        LocalDate startDate = FRIDAY_2026_07_10;

        assertThat(service.getEffort(startDate, startDate.plusDays(1), List.of())).isEqualTo(Duration.ofDays(1));
    }

    @Test
    public void getEffortBetweenDatesExcludesNonWorkingDays() {
        var service = new NonWorkingDaysService();
        // 10 and 11 are in a week-end and 14 is off
        LocalDate startDate = FRIDAY_2026_07_10;
        LocalDate endDate = LocalDate.of(2026, 7, 16);

        assertThat(service.getEffort(startDate, endDate, List.of())).isEqualTo(Duration.ofDays(4));
    }

    @Test
    public void getNextEndTimeSkipsWeekendDays() {
        var service = new NonWorkingDaysService();
        Instant startTime = Instant.parse("2026-07-31T13:00:00Z");

        assertThat(service.getNextEndTime(startTime, 23, List.of())).isEqualTo(Instant.parse("2026-08-03T12:00:00Z"));
    }

    @Test
    public void getNextEndTimeSkipsNonWorkingDays() {
        var service = new NonWorkingDaysService();
        Instant startTime = Instant.parse("2026-07-13T12:00:00Z");

        assertThat(service.getNextEndTime(startTime, 24, List.of())).isEqualTo(Instant.parse("2026-07-15T12:00:00Z"));
    }

    @Test
    public void getNextEndTimeKeepsAnInstantOnAWorkingDay() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-07-31T13:00:00Z");

        assertThat(service.getNextEndTime(instant, List.of())).isEqualTo(instant);
    }

    @Test
    public void getNextEndTimeMovesPastAWeekend() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-08-01T13:00:00Z");

        assertThat(service.getNextEndTime(instant, List.of())).isEqualTo(Instant.parse("2026-08-03T12:00:00Z"));
    }

    @Test
    public void getNextEndTimeMovesPastANonWorkingDay() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-07-14T09:00:00Z");

        assertThat(service.getNextEndTime(instant, List.of())).isEqualTo(Instant.parse("2026-07-15T12:00:00Z"));
    }

    @Test
    public void getPreviousStartTimeKeepsAnInstantOnAWorkingDay() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-07-31T13:00:00Z");

        assertThat(service.getPreviousStartTime(instant, List.of())).isEqualTo(instant);
    }

    @Test
    public void getPreviousStartTimeMovesBeforeAWeekend() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-08-02T18:00:00Z");

        assertThat(service.getPreviousStartTime(instant, List.of())).isEqualTo(Instant.parse("2026-07-31T12:00:00Z"));
    }

    @Test
    public void getPreviousStartTimeMovesBeforeANonWorkingDay() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-07-14T09:00:00Z");

        assertThat(service.getPreviousStartTime(instant, List.of())).isEqualTo(Instant.parse("2026-07-13T12:00:00Z"));
    }

    @Test
    public void getPreviousStartDateKeepsAWorkingDate() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 31);

        assertThat(service.getPreviousStartDate(date, List.of())).isEqualTo(date);
    }

    @Test
    public void getPreviousStartDateMovesBeforeAWeekend() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 8, 2);

        assertThat(service.getPreviousStartDate(date, List.of())).isEqualTo(LocalDate.of(2026, 7, 31));
    }

    @Test
    public void getPreviousStartDateMovesBeforeANonWorkingDay() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 14);

        assertThat(service.getPreviousStartDate(date, List.of())).isEqualTo(LocalDate.of(2026, 7, 13));
    }

    @Test
    public void getNextEndDateKeepsAWorkingDate() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 31);

        assertThat(service.getNextEndDate(date, List.of())).isEqualTo(date);
    }

    @Test
    public void getNextEndDateMovesPastAWeekend() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 8, 1);

        assertThat(service.getNextEndDate(date, List.of())).isEqualTo(LocalDate.of(2026, 8, 3));
    }

    @Test
    public void getNextEndDateMovesPastANonWorkingDate() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 14);

        assertThat(service.getNextEndDate(date, List.of())).isEqualTo(LocalDate.of(2026, 7, 15));
    }

    @Test
    public void getNextEndDateKeepsAWorkingDateFollowingANonWorkingDay() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 15);

        assertThat(service.getNextEndDate(date, List.of())).isEqualTo(date);
    }

    @Test
    public void getPreviousStartTimeSkipsWeekendDays() {
        var service = new NonWorkingDaysService();
        Instant endTime = Instant.parse("2026-08-03T13:00:00Z");

        assertThat(service.getPreviousStartTime(endTime, 25, List.of())).isEqualTo(Instant.parse("2026-07-31T12:00:00Z"));
    }

    @Test
    public void getPreviousStartTimeSkipsNonWorkingDays() {
        var service = new NonWorkingDaysService();
        Instant endTime = Instant.parse("2026-07-15T12:00:00Z");
        assertThat(service.getPreviousStartTime(endTime, 24, List.of())).isEqualTo(Instant.parse("2026-07-13T12:00:00Z"));

//        endTime = Instant.parse("2026-07-15T09:59:00Z");
//        assertThat(service.getStartTime(endTime, 24)).isEqualTo(Instant.parse("2026-07-13T12:00:00Z"));

        endTime = Instant.parse("2026-07-16T00:00:00Z");
        assertThat(service.getPreviousStartTime(endTime, 36, List.of())).isEqualTo(Instant.parse("2026-07-13T12:00:00Z"));

//        endTime = Instant.parse("2026-07-15T21:59:00Z");
//        assertThat(service.getStartTime(endTime, 36)).isEqualTo(Instant.parse("2026-07-13T12:00:00Z"));
    }

    @Test
    public void getEffortBetweenInstantWithAssignedPersons() {
        var service = new NonWorkingDaysService();

        // only non working days
        Instant startTime = MONDAY_2026_07_06_12_00;
        Instant endTime = Instant.parse("2026-07-10T12:00:00Z");

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getEffort(startTime, endTime, List.of())).isEqualTo(Duration.ofHours(4 * 24));
        assertThat(service.getEffort(startTime, endTime, List.of(person1))).isEqualTo(Duration.ofHours(60));
        assertThat(service.getEffort(startTime, endTime, List.of(person1, person2))).isEqualTo(Duration.ofHours(60 + 4 * 24));
    }

    private Person getPerson1() {
        Person person1 = PepperFactory.eINSTANCE.createPerson();
        UnavailabilityPeriod unavailabilityPeriod = PepperFactory.eINSTANCE.createUnavailabilityPeriod();
        unavailabilityPeriod.setStartDate(TUESDAY_2026_07_07);
        unavailabilityPeriod.setEndDate(TUESDAY_2026_07_07);
        person1.getUnavailabilityPeriods().add(unavailabilityPeriod);
        UnavailabilityPeriod unavailabilityPeriod2 = PepperFactory.eINSTANCE.createUnavailabilityPeriod();
        unavailabilityPeriod2.setStartDate(FRIDAY_2026_07_10);
        unavailabilityPeriod2.setEndDate(FRIDAY_2026_07_10);
        person1.getUnavailabilityPeriods().add(unavailabilityPeriod2);
        return person1;
    }

    @Test
    public void getEffortBetweenDateWithAssignedPersons() {
        var service = new NonWorkingDaysService();

        // only non working days
        LocalDate startDate = MONDAY_2026_07_06;
        LocalDate endDate = FRIDAY_2026_07_10;

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getEffort(startDate, endDate, List.of())).isEqualTo(Duration.ofDays(5));
        assertThat(service.getEffort(startDate, endDate, List.of(person1))).isEqualTo(Duration.ofDays(3));
        assertThat(service.getEffort(startDate, endDate, List.of(person1, person2))).isEqualTo(Duration.ofDays(8));
    }

    @Test
    public void getNextEndDateMovesWithAssignedPersons() {
        var service = new NonWorkingDaysService();
        LocalDate date = TUESDAY_2026_07_07;

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getNextEndDate(date, List.of())).isEqualTo(TUESDAY_2026_07_07);
        assertThat(service.getNextEndDate(date, List.of(person1))).isEqualTo(WEDNESDAY_2026_07_08);
        assertThat(service.getNextEndDate(date, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07);
    }

    @Test
    public void getPreviousStartDateMovesWithAssignedPersons() {
        var service = new NonWorkingDaysService();
        LocalDate date = TUESDAY_2026_07_07;

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getPreviousStartDate(date, List.of())).isEqualTo(TUESDAY_2026_07_07);
        assertThat(service.getPreviousStartDate(date, List.of(person1))).isEqualTo(MONDAY_2026_07_06);
        assertThat(service.getPreviousStartDate(date, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07);
    }

    @Test
    public void getPreviousStartDateWithEffortWithAssignedPersons() {
        var service = new NonWorkingDaysService();

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getPreviousStartDate(WEDNESDAY_2026_07_08, 1, List.of(person1))).isEqualTo(WEDNESDAY_2026_07_08);
        assertThat(service.getPreviousStartDate(WEDNESDAY_2026_07_08, 2, List.of(person1))).isEqualTo(MONDAY_2026_07_06);
        assertThat(service.getPreviousStartDate(WEDNESDAY_2026_07_08, 1, List.of(person1, person2))).isEqualTo(WEDNESDAY_2026_07_08);
        assertThat(service.getPreviousStartDate(WEDNESDAY_2026_07_08, 2, List.of(person1, person2))).isEqualTo(WEDNESDAY_2026_07_08);
        assertThat(service.getPreviousStartDate(WEDNESDAY_2026_07_08, 3, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07);
        assertThat(service.getPreviousStartDate(WEDNESDAY_2026_07_08, 4, List.of(person1, person2))).isEqualTo(MONDAY_2026_07_06);
    }

    @Test
    public void getNextEndDateWithEffortWithAssignedPersons() {
        var service = new NonWorkingDaysService();

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getNextEndDate(MONDAY_2026_07_06, 1, List.of(person1))).isEqualTo(MONDAY_2026_07_06);
        assertThat(service.getNextEndDate(MONDAY_2026_07_06, 2, List.of(person1))).isEqualTo(WEDNESDAY_2026_07_08);
        assertThat(service.getNextEndDate(MONDAY_2026_07_06, 1, List.of(person1, person2))).isEqualTo(MONDAY_2026_07_06);
        assertThat(service.getNextEndDate(MONDAY_2026_07_06, 2, List.of(person1, person2))).isEqualTo(MONDAY_2026_07_06);
        assertThat(service.getNextEndDate(MONDAY_2026_07_06, 3, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07);
        assertThat(service.getNextEndDate(MONDAY_2026_07_06, 4, List.of(person1, person2))).isEqualTo(WEDNESDAY_2026_07_08);
        assertThat(service.getNextEndDate(MONDAY_2026_07_06, 5, List.of(person1, person2))).isEqualTo(WEDNESDAY_2026_07_08);
    }

    @Test
    public void getNextTimeMovesWithAssignedPersons() {
        var service = new NonWorkingDaysService();
        LocalDate date = TUESDAY_2026_07_07;

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getNextEndDate(date, List.of())).isEqualTo(TUESDAY_2026_07_07);
        assertThat(service.getNextEndDate(date, List.of(person1))).isEqualTo(WEDNESDAY_2026_07_08);
        assertThat(service.getNextEndDate(date, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07);
    }

    @Test
    public void getNextEndTimeWithAssignedPersons() {
        var service = new NonWorkingDaysService();

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getNextEndTime(MONDAY_2026_07_06_12_00, List.of(person1))).isEqualTo(MONDAY_2026_07_06_12_00);
        assertThat(service.getNextEndTime(TUESDAY_2026_07_07_12_00, List.of(person1))).isEqualTo(WEDNESDAY_2026_07_08_12_00);
        assertThat(service.getNextEndTime(TUESDAY_2026_07_07_12_00, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07_12_00);
    }

    @Test
    public void getNextEndTimeWithEffortWithAssignedPersons() {
        var service = new NonWorkingDaysService();

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getNextEndTime(MONDAY_2026_07_06_12_00, 24, List.of(person1))).isEqualTo(WEDNESDAY_2026_07_08_12_00);
        assertThat(service.getNextEndTime(MONDAY_2026_07_06_12_00, 36, List.of(person1))).isEqualTo(THURSDAY_2026_07_09_00_00);
        assertThat(service.getNextEndTime(MONDAY_2026_07_06_12_00, 36, List.of(person1))).isEqualTo(THURSDAY_2026_07_09_00_00);
        assertThat(service.getNextEndTime(MONDAY_2026_07_06_12_00, 12, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07_00_00);
        assertThat(service.getNextEndTime(MONDAY_2026_07_06_12_00, 24, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07_00_00);
        assertThat(service.getNextEndTime(MONDAY_2026_07_06_12_00, 36, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07_12_00);
    }

    @Test
    public void getPreviousStartTimeWithAssignedPersons() {
        var service = new NonWorkingDaysService();

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getPreviousStartTime(WEDNESDAY_2026_07_08_00_00, List.of(person1))).isEqualTo(WEDNESDAY_2026_07_08_00_00);
        assertThat(service.getPreviousStartTime(WEDNESDAY_2026_07_08_00_00, List.of(person1, person2))).isEqualTo(WEDNESDAY_2026_07_08_00_00);
        assertThat(service.getPreviousStartTime(TUESDAY_2026_07_07_12_00, List.of(person1))).isEqualTo(MONDAY_2026_07_06_12_00);
        assertThat(service.getPreviousStartTime(TUESDAY_2026_07_07_12_00, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07_12_00);
    }

    @Test
    public void getPreviousStartTimeWithEffortWithAssignedPersons() {
        var service = new NonWorkingDaysService();
        Instant startTime = WEDNESDAY_2026_07_08_12_00;

        Person person1 = this.getPerson1();
        Person person2 = PepperFactory.eINSTANCE.createPerson();

        assertThat(service.getPreviousStartTime(startTime, 12, List.of(person1))).isEqualTo(WEDNESDAY_2026_07_08_00_00);
        assertThat(service.getPreviousStartTime(startTime, 24, List.of(person1))).isEqualTo(MONDAY_2026_07_06_12_00);
        assertThat(service.getPreviousStartTime(startTime, 12, List.of(person1, person2))).isEqualTo(WEDNESDAY_2026_07_08_00_00);
        assertThat(service.getPreviousStartTime(startTime, 24, List.of(person1, person2))).isEqualTo(WEDNESDAY_2026_07_08_00_00);
        assertThat(service.getPreviousStartTime(startTime, 36, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07_12_00);
        assertThat(service.getPreviousStartTime(startTime, 48, List.of(person1, person2))).isEqualTo(TUESDAY_2026_07_07_00_00);
    }
}

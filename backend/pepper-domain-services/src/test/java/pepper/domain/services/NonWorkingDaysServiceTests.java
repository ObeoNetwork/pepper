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

import org.junit.jupiter.api.Test;

/**
 * Tests of {@link NonWorkingDaysService}.
 *
 * @author lfasani
 */
@SuppressWarnings("checkstyle:MultipleStringLiterals")
public class NonWorkingDaysServiceTests {

    @Test
    public void getDurationIncludesPartialStartAndEndDays() {
        var service = new NonWorkingDaysService();

        Instant startTime = Instant.parse("2026-07-13T11:00:00Z");
        Instant endTime = Instant.parse("2026-07-15T12:00:00Z");

        assertThat(service.getDuration(startTime, endTime)).isEqualTo(Duration.ofHours(24));

        startTime = Instant.parse("2026-07-13T05:00:00Z");
        endTime = Instant.parse("2026-07-15T17:00:00Z");

        assertThat(service.getDuration(startTime, endTime)).isEqualTo(Duration.ofHours(36));
    }

    @Test
    public void getDurationBetweenInstantExcludesWeekendDays() {
        var service = new NonWorkingDaysService();

        // 10 and 11 are in a week-end and 14 is off
        Instant startTime = Instant.parse("2026-07-10T12:00:00Z");
        Instant endTime = Instant.parse("2026-07-16T12:00:00Z");

        assertThat(service.getDuration(startTime, endTime)).isEqualTo(Duration.ofDays(3));
    }

    @Test
    public void getDurationBetweenEqualDatesIsZero() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 13);

        assertThat(service.getDuration(date, date)).isEqualTo(Duration.ZERO);
    }

    @Test
    public void getDurationBetweenConsecutiveWorkingDatesIsOneDay() {
        var service = new NonWorkingDaysService();
        LocalDate startDate = LocalDate.of(2026, 7, 10);

        assertThat(service.getDuration(startDate, startDate.plusDays(1))).isEqualTo(Duration.ofDays(1));
    }

    @Test
    public void getDurationBetweenDatesExcludesNonWorkingDays() {
        var service = new NonWorkingDaysService();
        // 10 and 11 are in a week-end and 14 is off
        LocalDate startDate = LocalDate.of(2026, 7, 10);
        LocalDate endDate = LocalDate.of(2026, 7, 16);

        assertThat(service.getDuration(startDate, endDate)).isEqualTo(Duration.ofDays(3));
    }

    @Test
    public void getEndTimeSkipsWeekendDays() {
        var service = new NonWorkingDaysService();
        Instant startTime = Instant.parse("2026-07-31T13:00:00Z");

        assertThat(service.getEndTime(startTime, 23)).isEqualTo(Instant.parse("2026-08-03T12:00:00Z"));
    }

    @Test
    public void getEndTimeSkipsNonWorkingDays() {
        var service = new NonWorkingDaysService();
        Instant startTime = Instant.parse("2026-07-13T12:00:00Z");

        assertThat(service.getEndTime(startTime, 24)).isEqualTo(Instant.parse("2026-07-15T12:00:00Z"));
    }

    @Test
    public void getNextEndTimeKeepsAnInstantOnAWorkingDay() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-07-31T13:00:00Z");

        assertThat(service.getNextEndTime(instant)).isEqualTo(instant);
    }

    @Test
    public void getNextEndTimeMovesPastAWeekend() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-08-01T13:00:00Z");

        assertThat(service.getNextEndTime(instant)).isEqualTo(Instant.parse("2026-08-03T12:00:00Z"));
    }

    @Test
    public void getNextEndTimeMovesPastANonWorkingDay() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-07-14T09:00:00Z");

        assertThat(service.getNextEndTime(instant)).isEqualTo(Instant.parse("2026-07-15T12:00:00Z"));
    }

    @Test
    public void getPreviousStartTimeKeepsAnInstantOnAWorkingDay() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-07-31T13:00:00Z");

        assertThat(service.getPreviousStartTime(instant)).isEqualTo(instant);
    }

    @Test
    public void getPreviousStartTimeMovesBeforeAWeekend() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-08-02T18:00:00Z");

        assertThat(service.getPreviousStartTime(instant)).isEqualTo(Instant.parse("2026-07-31T12:00:00Z"));
    }

    @Test
    public void getPreviousStartTimeMovesBeforeANonWorkingDay() {
        var service = new NonWorkingDaysService();
        Instant instant = Instant.parse("2026-07-14T09:00:00Z");

        assertThat(service.getPreviousStartTime(instant)).isEqualTo(Instant.parse("2026-07-13T12:00:00Z"));
    }

    @Test
    public void getPreviousStartDateKeepsAWorkingDate() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 31);

        assertThat(service.getPreviousStartDate(date)).isEqualTo(date);
    }

    @Test
    public void getPreviousStartDateMovesBeforeAWeekend() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 8, 2);

        assertThat(service.getPreviousStartDate(date)).isEqualTo(LocalDate.of(2026, 7, 31));
    }

    @Test
    public void getPreviousStartDateMovesBeforeANonWorkingDay() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 14);

        assertThat(service.getPreviousStartDate(date)).isEqualTo(LocalDate.of(2026, 7, 13));
    }

    @Test
    public void getNextEndDateKeepsAWorkingDate() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 31);

        assertThat(service.getNextEndDate(date)).isEqualTo(date);
    }

    @Test
    public void getNextEndDateAcceptsAnExcludedWeekendDate() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 8, 1);

        assertThat(service.getNextEndDate(date)).isEqualTo(date);
    }

    @Test
    public void getNextEndDateAcceptsAnExcludedNonWorkingDate() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 14);

        assertThat(service.getNextEndDate(date)).isEqualTo(date);
    }

    @Test
    public void getNextEndDateMovesABoundaryFollowingANonWorkingDay() {
        var service = new NonWorkingDaysService();
        LocalDate date = LocalDate.of(2026, 7, 15);

        assertThat(service.getNextEndDate(date)).isEqualTo(LocalDate.of(2026, 7, 16));
    }

    @Test
    public void getStartTimeSkipsWeekendDays() {
        var service = new NonWorkingDaysService();
        Instant endTime = Instant.parse("2026-08-03T13:00:00Z");

        assertThat(service.getStartTime(endTime, 25)).isEqualTo(Instant.parse("2026-07-31T12:00:00Z"));
    }

    @Test
    public void getStartTimeSkipsNonWorkingDays() {
        var service = new NonWorkingDaysService();
        Instant endTime = Instant.parse("2026-07-15T12:00:00Z");

        assertThat(service.getStartTime(endTime, 24)).isEqualTo(Instant.parse("2026-07-13T12:00:00Z"));
    }

    @Test
    public void getStartDateSkipsWeekendDays() {
        var service = new NonWorkingDaysService();
        LocalDate endDate = LocalDate.of(2026, 8, 3);

        assertThat(service.getStartDate(endDate, 1)).isEqualTo(LocalDate.of(2026, 7, 31));
    }

    @Test
    public void getStartDateSkipsNonWorkingDays() {
        var service = new NonWorkingDaysService();
        LocalDate endDate = LocalDate.of(2026, 7, 15);

        assertThat(service.getStartDate(endDate, 1)).isEqualTo(LocalDate.of(2026, 7, 13));
    }

    @Test
    public void getEndDateSkipsWeekendDays() {
        var service = new NonWorkingDaysService();
        LocalDate startDate = LocalDate.of(2026, 7, 31);

        assertThat(service.getEndDate(startDate, 2)).isEqualTo(LocalDate.of(2026, 8, 4));
    }

    @Test
    public void getEndDateSkipsNonWorkingDays() {
        var service = new NonWorkingDaysService();
        LocalDate startDate = LocalDate.of(2026, 7, 13);

        assertThat(service.getEndDate(startDate, 2)).isEqualTo(LocalDate.of(2026, 7, 16));
    }
}

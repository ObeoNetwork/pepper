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

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Service that manages the non working days.
 * @author lfasani
 */
public class NonWorkingDaysService {

    /**
     * National public holidays in metropolitan France for 2026.
     */
    private static final List<LocalDate> FRENCH_NON_WORKING_DAYS_2026 = List.of(
            LocalDate.of(2026, 1, 1),
            LocalDate.of(2026, 4, 6),
            LocalDate.of(2026, 5, 1),
            LocalDate.of(2026, 5, 8),
            LocalDate.of(2026, 5, 14),
            LocalDate.of(2026, 5, 25),
            LocalDate.of(2026, 7, 14),
            LocalDate.of(2026, 8, 15),
            LocalDate.of(2026, 11, 1),
            LocalDate.of(2026, 11, 11),
            LocalDate.of(2026, 12, 25));

    private static final List<DayOfWeek> NON_WORKING_DAYS_IN_WEEK = List.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

    /**
     * Returns the duration bounded by {@code startTime} and {@code endTime}, including the working-time
     * portions of both boundary days. Any portion that falls on a Saturday, Sunday, or configured fixed
     * non-working day is excluded.
     *
     * @param startTime
     *            the start of the interval
     * @param endTime
     *            the end of the interval
     * @return the duration spent on working days rounded to the closest hour, or {@link Duration#ZERO} for a null or empty interval
     */
    public Duration getDuration(Instant startTime, Instant endTime) {
        if (startTime == null || endTime == null || !endTime.isAfter(startTime)) {
            return Duration.ZERO;
        }

        Duration duration = Duration.ZERO;
        Instant currentTime = startTime;
        while (currentTime.isBefore(endTime)) {
            LocalDate currentDate = currentTime.atZone(ZoneOffset.UTC).toLocalDate();
            Instant nextDayStart = currentDate.plusDays(1).atStartOfDay(ZoneOffset.UTC).toInstant();
            Instant intervalEnd = endTime.isBefore(nextDayStart) ? endTime : nextDayStart;
            if (!this.isNonWorkingDay(currentDate)) {
                duration = duration.plus(Duration.between(currentTime, intervalEnd));
            }
            currentTime = intervalEnd;
        }
        return this.roundToNearestHalfDay(duration);
    }

    /**
     * Returns the duration of the working days from {@code startDate} (inclusive) to
     * {@code endDate} (exclusive). Therefore, equal dates produce {@link Duration#ZERO}, while
     * consecutive working dates produce a duration of one day.
     *
     * @param startDate
     *            the start boundary
     * @param endDate
     *            the end boundary
     * @return the duration of the working days in the interval, or {@link Duration#ZERO} for a null,
     *         empty, or reversed interval
     */
    public Duration getDuration(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null || !endDate.isAfter(startDate)) {
            return Duration.ZERO;
        }

        Duration duration = Duration.ZERO;
        LocalDate currentDate = startDate;
        while (currentDate.isBefore(endDate)) {
            if (!this.isNonWorkingDay(currentDate)) {
                duration = duration.plusDays(1);
            }
            currentDate = currentDate.plusDays(1);
        }
        return duration;
    }

    /**
     * Returns the end time reached after the specified number of working hours from {@code startTime}.
     * Non-working days in week and configured fixed non-working days do not consume any duration.
     *
     * @param startTime
     *            the non-null start of the interval
     * @param durationInHours
     *            the number of working hours to add
     * @return the resulting end time, or {@code null} when {@code startTime} is null
     */
    public Instant getEndTime(Instant startTime, int durationInHours) {
        Duration remainingDuration = Duration.ofHours(durationInHours);
        Instant currentEndTime = startTime;
        while (!remainingDuration.isZero()) {
            LocalDate currentDate = currentEndTime.atZone(ZoneOffset.UTC).toLocalDate();
            Instant nextDayStart = currentDate.plusDays(1).atStartOfDay(ZoneOffset.UTC).toInstant();
            if (this.isNonWorkingDay(currentDate)) {
                currentEndTime = nextDayStart;
            } else {
                Duration availableDuration = Duration.between(currentEndTime, nextDayStart);
                Duration consumedDuration = remainingDuration.compareTo(availableDuration) < 0
                        ? remainingDuration
                        : availableDuration;
                currentEndTime = currentEndTime.plus(consumedDuration);
                remainingDuration = remainingDuration.minus(consumedDuration);
            }
        }
        return currentEndTime;
    }
 
    /**
     * Returns the supplied instant when it is on a working day. Otherwise, moves forward in
     * half-day steps through the non-working period and returns the instant half a day into the
     * next working day.
     *
     * @param instant
     *            the non-null instant to evaluate
     * @return the supplied instant or the next valid end time
     */
    public Instant getNextEndTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        Instant nextEndTime = instant;
        LocalDate date = instant.atZone(ZoneOffset.UTC).toLocalDate();
        if (this.isNonWorkingDay(date)) {
            nextEndTime = instant.plus(6, ChronoUnit.HOURS).truncatedTo(ChronoUnit.HALF_DAYS);
            while (this.isNonWorkingDay(nextEndTime.atZone(ZoneOffset.UTC).toLocalDate())) {
                nextEndTime = nextEndTime.plus(1, ChronoUnit.HALF_DAYS);
            }
            nextEndTime = nextEndTime.plus(1, ChronoUnit.HALF_DAYS);
        }
        return nextEndTime;
    }

    /**
     * Returns the supplied instant when it is on a working day. Otherwise, moves backward in
     * half-day steps through the non-working period and returns the instant half a day before that
     * period.
     *
     * @param instant
     *            the non-null instant to evaluate
     * @return the supplied instant or the previous valid start time
     */
    public Instant getPreviousStartTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        Instant previousStartTime = instant;
        LocalDate date = instant.atZone(ZoneOffset.UTC).toLocalDate();
        if (this.isNonWorkingDay(date)) {
            previousStartTime = instant.truncatedTo(ChronoUnit.HALF_DAYS);
            while (this.isNonWorkingDay(previousStartTime.atZone(ZoneOffset.UTC).toLocalDate())) {
                previousStartTime = previousStartTime.minus(1, ChronoUnit.HALF_DAYS);
            }
        }
        return previousStartTime;
    }

    /**
     * Returns the supplied date when it is a working day. Otherwise, moves backward one day at a
     * time through the non-working period and returns the preceding working date.
     *
     * @param startDate
     *            the non-null date to evaluate
     * @return the supplied date or the previous valid start date
     */
    public LocalDate getPreviousStartDate(LocalDate startDate) {
        if (startDate == null) {
            return null;
        }
        LocalDate previousStartDate = startDate;
        while (this.isNonWorkingDay(previousStartDate)) {
            previousStartDate = previousStartDate.minusDays(1);
        }
        return previousStartDate;
    }

    /**
     * Returns the supplied exclusive end date when the preceding, included date is a working day.
     * Otherwise, moves the end boundary forward one day at a time until it follows a working day.
     * The end date itself may be a non-working day because it is excluded from the interval.
     *
     * @param endDate
     *            the non-null exclusive end date to evaluate
     * @return the supplied date or the next valid exclusive end date
     */
    public LocalDate getNextEndDate(LocalDate endDate) {
        if (endDate == null) {
            return null;
        }
        LocalDate nextEndDate = endDate;
        while (this.isNonWorkingDay(nextEndDate.minusDays(1))) {
            nextEndDate = nextEndDate.plusDays(1);
        }
        return nextEndDate;
    }

    /**
     * Returns the start time reached after moving backward by the specified number of working hours
     * from {@code endTime}. Non-working days in week and configured fixed non-working days do not
     * consume any duration. Days are evaluated in UTC.
     *
     * @param endTime
     *            the non-null end of the interval
     * @param durationInHours
     *            the number of working hours to subtract
     * @return the resulting start time
     */
    public Instant getStartTime(Instant endTime, int durationInHours) {
        Duration remainingDuration = Duration.ofHours(durationInHours);
        Instant currentStartTime = endTime;

        while (!remainingDuration.isZero()) {
            LocalDate currentDate = currentStartTime.atZone(ZoneOffset.UTC).toLocalDate();
            Instant currentDayStart = currentDate.atStartOfDay(ZoneOffset.UTC).toInstant();

            // Midnight is the end of the previous day when moving backward.
            if (currentStartTime.equals(currentDayStart)) {
                currentDate = currentDate.minusDays(1);
                currentDayStart = currentDate.atStartOfDay(ZoneOffset.UTC).toInstant();
            }

            if (this.isNonWorkingDay(currentDate)) {
                currentStartTime = currentDayStart;
            } else {
                Duration availableDuration = Duration.between(currentDayStart, currentStartTime);
                Duration consumedDuration = remainingDuration.compareTo(availableDuration) < 0
                        ? remainingDuration
                        : availableDuration;
                currentStartTime = currentStartTime.minus(consumedDuration);
                remainingDuration = remainingDuration.minus(consumedDuration);
            }
        }
        return currentStartTime;
    }

    /**
     * Returns the start date reached after moving backward by the specified number of working days
     * from {@code endDate}. The end date is excluded. Non-working days in week and configured fixed
     * non-working days do not consume any duration.
     *
     * @param endDate
     *            the non-null end date
     * @param durationInDays
     *            the number of working days to subtract
     * @return the resulting start date
     */
    public LocalDate getStartDate(LocalDate endDate, int durationInDays) {
        int remainingDays = durationInDays;
        LocalDate currentStartDate = endDate;
        while (remainingDays > 0) {
            currentStartDate = currentStartDate.minusDays(1);
            if (!this.isNonWorkingDay(currentStartDate)) {
                remainingDays--;
            }
        }
        return currentStartDate;
    }

    /**
     * Returns the exclusive end date reached after moving forward by the specified number of working
     * days from {@code startDate}. The start date is included. Non-working days in week and configured
     * fixed non-working days do not consume any duration.
     *
     * @param startDate
     *            the non-null start date
     * @param durationInDays
     *            the number of working days to add
     * @return the resulting exclusive end date
     */
    public LocalDate getEndDate(LocalDate startDate, int durationInDays) {
        int remainingDays = durationInDays;
        LocalDate currentEndDate = startDate;
        while (remainingDays > 0) {
            if (!this.isNonWorkingDay(currentEndDate)) {
                remainingDays--;
            }
            currentEndDate = currentEndDate.plusDays(1);
        }
        return currentEndDate;
    }

    private boolean isNonWorkingDay(LocalDate date) {
        return NON_WORKING_DAYS_IN_WEEK.contains(date.getDayOfWeek()) || FRENCH_NON_WORKING_DAYS_2026.contains(date);
    }

    public Duration roundToNearestHalfDay(Duration duration) {
        return duration.isNegative()
                ? duration.minusHours(6).truncatedTo(ChronoUnit.HALF_DAYS)
                : duration.plusMinutes(6).truncatedTo(ChronoUnit.HALF_DAYS);
    }
}

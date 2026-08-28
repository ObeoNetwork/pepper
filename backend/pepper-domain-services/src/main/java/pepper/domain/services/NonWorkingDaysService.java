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

import pepper.peppermm.Person;

/**
 * Service that manages the non working days.
 *
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
     * Returns the effort bounded by {@code startTime} and {@code endTime}, including the working-time portions of both boundary days. Any portion that falls on a Saturday, Sunday, or configured fixed
     * non-working day is excluded.
     * When assignedPersons is provided, days that correspond of unavailability period of all the persons are also excluded.
     *
     * @param startTime
     *         the start of the interval
     * @param endTime
     *         the end of the interval
     * @return the effort spent on working days rounded to the closest hour, or {@link Duration#ZERO} for a null or empty interval
     */
    public Duration getEffort(Instant startTime, Instant endTime, List<Person> assignedPersons) {
        if (startTime == null || endTime == null || !endTime.isAfter(startTime)) {
            return Duration.ZERO;
        }

        Duration effort = Duration.ZERO;
        Instant currentTime = startTime;
        while (currentTime.isBefore(endTime)) {
            LocalDate currentDate = currentTime.atZone(ZoneOffset.UTC).toLocalDate();
            Instant nextDayStart = currentDate.plusDays(1).atStartOfDay(ZoneOffset.UTC).toInstant();
            Instant intervalEnd = endTime.isBefore(nextDayStart) ? endTime : nextDayStart;
            int nbWorkingPersons = this.getNbWorkingPersons(currentDate, assignedPersons);
            if (nbWorkingPersons > 0) {
                effort = effort.plus(Duration.ofHours(Duration.between(currentTime, intervalEnd).toHours() * nbWorkingPersons));
            }
            currentTime = intervalEnd;
        }
        return this.roundToNearestHalfDay(effort);
    }

    /**
     * Returns the duration bounded by {@code startTime} and {@code endTime}, including the working-time portions of both boundary days. Any portion that falls on a Saturday, Sunday, or configured
     * fixed non-working day is excluded.
     *
     * @param startTime
     *         the start of the interval
     * @param endTime
     *         the end of the interval
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
            if (this.isWorkingDay(currentDate, List.of())) {
                duration = duration.plus(Duration.between(currentTime, intervalEnd));
            }
            currentTime = intervalEnd;
        }
        return this.roundToNearestHalfDay(duration);
    }

    /**
     * Returns the effort of the working days from {@code startDate} to {@code endDate}, with both boundary dates included. Therefore, equal working dates produce a effort of one day.
     * When persons is provided, days that correspond of unavailability period of all the persons are also excluded.
     *
     * @param startDate
     *         the start boundary
     * @param endDate
     *         the end boundary
     * @return the effort of the working days in the interval, or {@link Duration#ZERO} for a null or reversed interval
     */
    public Duration getEffort(LocalDate startDate, LocalDate endDate, List<Person> persons) {
        if (startDate == null || endDate == null || endDate.isBefore(startDate)) {
            return Duration.ZERO;
        }

        Duration effort = Duration.ZERO;
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            int nbWorkingPersons = this.getNbWorkingPersons(currentDate, persons);
            effort = effort.plusDays(nbWorkingPersons);
            currentDate = currentDate.plusDays(1);
        }
        return effort;
    }

    /**
     * Returns the duration of the working days from {@code startDate} to {@code endDate}, with both boundary dates included. Therefore, equal working dates produce a duration of one day.
     *
     * @param startDate
     *         the start boundary
     * @param endDate
     *         the end boundary
     * @return the duration of the working days in the interval, or {@link Duration#ZERO} for a null or reversed interval
     */
    public Duration getDuration(LocalDate startDate, LocalDate endDate, List<Person> persons) {
        if (startDate == null || endDate == null || endDate.isBefore(startDate)) {
            return Duration.ZERO;
        }

        Duration duration = Duration.ZERO;
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (this.isWorkingDay(currentDate, persons)) {
                duration = duration.plusDays(1);
            }
            currentDate = currentDate.plusDays(1);
        }
        return duration;
    }

    /**
     * Returns the end time reached after the specified number of working hours from {@code startTime}. Non-working days in week and configured fixed non-working days do not consume any effort.
     * When persons is provided, days that correspond of unavailability period of all the persons are also excluded.
     *
     * @param startTime
     *         the non-null start of the interval
     * @param effortInHours
     *         the number of working hours to add
     * @return the resulting end time, or {@code null} when {@code startTime} is null
     */
    public Instant getNextEndTime(Instant startTime, int effortInHours, List<Person> persons) {
        if (startTime == null) {
            return null;
        }

        Duration remainingDuration = Duration.ofHours(effortInHours);
        Instant currentEndTime = startTime;
        while (!remainingDuration.isZero()) {
            LocalDate currentDate = currentEndTime.atZone(ZoneOffset.UTC).toLocalDate();
            Instant nextHalfDayStart = currentEndTime.truncatedTo(ChronoUnit.HALF_DAYS).plus(1, ChronoUnit.HALF_DAYS);
            int nbWorkingPersons = this.getNbWorkingPersons(currentDate, persons);
            if (nbWorkingPersons == 0) {
                currentEndTime = nextHalfDayStart;
            } else {
                Duration availableDuration = Duration.ofHours(Duration.between(currentEndTime, nextHalfDayStart).toHours() * nbWorkingPersons);
                Duration consumedDuration = remainingDuration.compareTo(availableDuration) < 0
                        ? remainingDuration
                        : availableDuration;
                remainingDuration = remainingDuration.minus(consumedDuration);
                currentEndTime = nextHalfDayStart;
            }
        }
        return currentEndTime;
    }

    /**
     * Returns the supplied instant when it is on a working day. Otherwise, moves forward in half-day steps through the non-working period and returns the instant half a day into the next working
     * day.
     * When persons is provided, days that correspond of unavailability period of all the persons are also excluded.
     *
     * @param instant
     *         the non-null instant to evaluate
     * @param persons
     * @return the supplied instant or the next valid end time
     */
    public Instant getNextEndTime(Instant instant, List<Person> persons) {
        if (instant == null) {
            return null;
        }
        Instant nextEndTime = instant;
        if (!this.isWorkingDay(nextEndTime.minus(1, ChronoUnit.MINUTES).atZone(ZoneOffset.UTC).toLocalDate(), persons)) {
            nextEndTime = instant.plus(6, ChronoUnit.HOURS).truncatedTo(ChronoUnit.HALF_DAYS);
            while (!this.isWorkingDay(nextEndTime.atZone(ZoneOffset.UTC).toLocalDate(), persons)) {
                nextEndTime = nextEndTime.plus(1, ChronoUnit.HALF_DAYS);
            }
            nextEndTime = nextEndTime.plus(1, ChronoUnit.HALF_DAYS);
        }
        return nextEndTime;
    }

    /**
     * Returns the supplied instant when it is on a working day. Otherwise, moves backward in half-day steps through the non-working period and returns the instant half a day before that period.
     * When persons is provided, days that correspond of unavailability period of all the persons are also excluded.
     *
     * @param instant
     *         the non-null instant to evaluate
     * @return the supplied instant or the previous valid start time
     */
    public Instant getPreviousStartTime(Instant instant, List<Person> persons) {
        if (instant == null) {
            return null;
        }
        Instant previousStartTime = instant;
        if (!this.isWorkingDay(instant.atZone(ZoneOffset.UTC).toLocalDate(), persons)) {
            previousStartTime = instant.truncatedTo(ChronoUnit.HALF_DAYS);
            while (!this.isWorkingDay(previousStartTime.atZone(ZoneOffset.UTC).toLocalDate(), persons)) {
                previousStartTime = previousStartTime.minus(1, ChronoUnit.HALF_DAYS);
            }
        }
        return previousStartTime;
    }

    /**
     * Returns the start time reached after moving backward by the specified number of working hours from {@code endTime}. Non-working days in week and configured fixed non-working days do not consume
     * any effort.
     * When persons is provided, days that correspond of unavailability period of all the persons are also excluded.
     *
     * @param endTime
     *         the non-null end of the interval
     * @param effortInHours
     *         the number of working hours to subtract
     * @return the resulting start time
     */
    public Instant getPreviousStartTime(Instant endTime, int effortInHours, List<Person> persons) {
        if (endTime == null) {
            return null;
        }

        Duration remainingDuration = Duration.ofHours(effortInHours);
        Instant currentStartTime = endTime;

        while (!remainingDuration.isZero()) {
            Instant previousHalfDayStart = currentStartTime.minusNanos(1).truncatedTo(ChronoUnit.HALF_DAYS);
            LocalDate currentDate = previousHalfDayStart.atZone(ZoneOffset.UTC).toLocalDate();
            int nbWorkingPersons = this.getNbWorkingPersons(currentDate, persons);
            if (nbWorkingPersons == 0) {
                currentStartTime = previousHalfDayStart;
            } else {
                Duration availableDuration = Duration.ofHours(Duration.between(previousHalfDayStart, currentStartTime).toHours() * nbWorkingPersons);
                Duration consumedDuration = remainingDuration.compareTo(availableDuration) < 0
                        ? remainingDuration
                        : availableDuration;
                remainingDuration = remainingDuration.minus(consumedDuration);
                currentStartTime = previousHalfDayStart;
            }
        }
        return currentStartTime;
    }

    /**
     * Returns the supplied date when it is a working day. Otherwise, moves backward one day at a time through the non-working period and returns the preceding working date.
     * When persons is provided, days that correspond of unavailability period of all the persons are also excluded.
     *
     * @param startDate
     *         the non-null date to evaluate
     * @return the supplied date or the previous valid start date
     */
    public LocalDate getPreviousStartDate(LocalDate startDate, List<Person> persons) {
        if (startDate == null) {
            return null;
        }
        LocalDate previousStartDate = startDate;
        while (!this.isWorkingDay(previousStartDate, persons)) {
            previousStartDate = previousStartDate.minusDays(1);
        }
        return previousStartDate;
    }

    /**
     * Returns the inclusive start date reached after moving backward by the specified number of working days from {@code startDate}. Non-working days in week and configured fixed non-working days do
     * not consume any effort. When persons is provided, each available person contributes one day of effort per calendar day.
     *
     * @param startDate
     *         the non-null date from which to move backward
     * @param effortInDays
     *         the number of working days to subtract
     * @param persons
     *         the assigned persons
     * @return the resulting start date, or {@code null} when {@code startDate} is null
     */
    public LocalDate getPreviousStartDate(LocalDate startDate, int effortInDays, List<Person> persons) {
        if (startDate == null) {
            return null;
        }

        int remainingEffort = effortInDays;
        LocalDate currentStartDate = startDate;
        while (remainingEffort > 0) {
            remainingEffort -= this.getNbWorkingPersons(currentStartDate, persons);
            if (remainingEffort > 0) {
                currentStartDate = currentStartDate.minusDays(1);
            }
        }
        return currentStartDate;
    }

    /**
     * Returns the supplied end date when it is a working day. Otherwise, moves forward one day at a time through the non-working period and returns the next working date. The end date is included.
     * When persons is provided, days that correspond of unavailability period of all the persons are also excluded.
     *
     * @param endDate
     *         the end date to evaluate
     * @return the supplied date or the next valid inclusive end date
     */
    public LocalDate getNextEndDate(LocalDate endDate, List<Person> persons) {
        if (endDate == null) {
            return null;
        }
        LocalDate nextEndDate = endDate;
        while (!this.isWorkingDay(nextEndDate, persons)) {
            nextEndDate = nextEndDate.plusDays(1);
        }
        return nextEndDate;
    }

    /**
     * Returns the inclusive end date reached after moving forward by the specified number of working days from {@code startDate}. Non-working days in week and configured fixed non-working days do not
     * consume any effort. When persons is provided, each available person contributes one day of effort per calendar day.
     *
     * @param startDate
     *         the non-null date from which to move forward
     * @param effortInDays
     *         the number of working days to add
     * @param persons
     *         the assigned persons
     * @return the resulting end date, or {@code null} when {@code startDate} is null
     */
    public LocalDate getNextEndDate(LocalDate startDate, int effortInDays, List<Person> persons) {
        if (startDate == null) {
            return null;
        }

        int remainingEffort = effortInDays;
        LocalDate currentEndDate = startDate;
        while (remainingEffort > 0) {
            remainingEffort -= this.getNbWorkingPersons(currentEndDate, persons);
            if (remainingEffort > 0) {
                currentEndDate = currentEndDate.plusDays(1);
            }
        }
        return currentEndDate;
    }

    private boolean isWorkingDay(LocalDate date, List<Person> persons) {
        return this.getNbWorkingPersons(date, persons) > 0;
    }

    private int getNbWorkingPersons(LocalDate date, List<Person> assignedPersons) {
        long nbWorkingDays = 0;
        boolean isNonWorkingDay = NON_WORKING_DAYS_IN_WEEK.contains(date.getDayOfWeek()) || FRENCH_NON_WORKING_DAYS_2026.contains(date);
        if (!isNonWorkingDay) {
            if (assignedPersons == null || assignedPersons.isEmpty()) {
                nbWorkingDays = 1;
            } else {
                nbWorkingDays = assignedPersons.stream()
                        .filter(person -> person.getUnavailabilityPeriods().stream()
                                .noneMatch(unavailabilityPeriod -> !date.isBefore(unavailabilityPeriod.getStartDate()) && !date.isAfter(unavailabilityPeriod.getEndDate())))
                        .count();
            }
        }

        return Math.toIntExact(nbWorkingDays);
    }

    public Duration roundToNearestHalfDay(Duration duration) {
        return duration.isNegative()
                ? duration.minusHours(6).truncatedTo(ChronoUnit.HALF_DAYS)
                : duration.plusMinutes(6).truncatedTo(ChronoUnit.HALF_DAYS);
    }
}

/*******************************************************************************
 * Copyright (c) 2026 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package pepper.domain.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.Person;
import pepper.peppermm.Workpackage;

/**
 * Per-update-batch allocation of person capacity in UTC half-day slots.
 */
public final class PersonCapacityAllocation {
    private static final ThreadLocal<PersonCapacityAllocation> CURRENT = new ThreadLocal<>();

    private final Map<Person, Set<Instant>> reservedSlots = new IdentityHashMap<>();

    public static Scope activate(PersonCapacityAllocation allocation) {
        CURRENT.set(allocation);
        return CURRENT::remove;
    }

    static PersonCapacityAllocation current() {
        return CURRENT.get();
    }

    public boolean isAvailable(Person person, Instant instant) {
        return !reservedSlots.getOrDefault(person, Collections.emptySet()).contains(this.slotStart(instant));
    }

    public boolean isAvailableForDate(Person person, LocalDate date) {
        Instant start = date.atStartOfDay(ZoneOffset.UTC).toInstant();
        return this.isAvailable(person, start) && this.isAvailable(person, start.plus(12, ChronoUnit.HOURS));
    }

    public void reserve(AbstractTask task) {
        if (task.isComputeStartEndDynamically()) {
            return;
        }
        Instant start = task.getStartTime();
        Instant end = task.getEndTime();
        if (start == null || end == null || end.isBefore(start)) {
            return;
        }
        Instant slot = this.slotStart(start);
        Instant lastSlot = this.slotStart(end);
        while (!slot.isAfter(lastSlot)) {
            this.reserveAvailablePersons(task.getAssignedPersons(), slot);
            slot = slot.plus(12, ChronoUnit.HOURS);
        }
    }

    public void reserve(Workpackage workpackage) {
        LocalDate start = workpackage.getStartDate();
        LocalDate end = workpackage.getEndDate();
        if (start == null || end == null || end.isBefore(start)) {
            return;
        }
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            Instant firstSlot = date.atStartOfDay(ZoneOffset.UTC).toInstant();
            for (Person person : workpackage.getAssignedPersons()) {
                if (this.isAvailableForDate(person, date)) {
                    this.reserveAvailablePersons(List.of(person), firstSlot);
                    this.reserveAvailablePersons(List.of(person), firstSlot.plus(12, ChronoUnit.HOURS));
                }
            }
        }
    }

    private void reserveAvailablePersons(List<Person> persons, Instant slot) {
        for (Person person : persons) {
            if (this.isAvailable(person, slot)) {
                reservedSlots.computeIfAbsent(person, key -> new HashSet<>()).add(this.slotStart(slot));
            }
        }
    }

    private Instant slotStart(Instant instant) {
        return instant.truncatedTo(ChronoUnit.HALF_DAYS);
    }

    /** Scope that makes an allocation available to scheduling calculations on the current thread. */
    public interface Scope extends AutoCloseable {
        @Override
        void close();
    }
}

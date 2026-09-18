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
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Helper related to Instant and Date.
 *
 * @author lfasani
 */
public class TemporalHelper {
    public Duration roundToNearestHalfDay(Duration duration) {
        long totalSeconds = duration.getSeconds();
        long halfDayInSeconds = 12 * 3600;

        long halfDays = Math.round((double) totalSeconds / halfDayInSeconds);

        return Duration.ofSeconds(halfDays * halfDayInSeconds);
    }

    public int roundToNearestHalfDay(int nbHours) {
        return Math.toIntExact(Math.round(nbHours / 12.0) * 12);
    }

    public int roundToNearestHalfDayInHours(String nbDaysString) {
        double nbDaysDouble = Double.parseDouble(nbDaysString.replace(',', '.'));
        double nbDaysRounded = Math.round(nbDaysDouble / 0.5) * 0.5;

        return (int) (nbDaysRounded * 24);
    }

    public Instant roundToNearestHalfDay(Instant instant) {
        return Optional.ofNullable(instant)
                .map(inst -> inst.plus(Duration.ofHours(6)).truncatedTo(ChronoUnit.HALF_DAYS))
                .orElse(null);
    }
}

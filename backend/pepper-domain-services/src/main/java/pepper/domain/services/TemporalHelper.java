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
    public int roundToNearestHalfDayInHours(String nbDaysString) {
        double doubleValue = Double.parseDouble(nbDaysString.replace(',', '.'));

        Duration inputDuration = Duration.ofHours((int) (doubleValue * 24));
        Duration duration = inputDuration.isNegative()
                ? inputDuration.minusHours(6).truncatedTo(ChronoUnit.HALF_DAYS)
                : inputDuration.plusMinutes(6).truncatedTo(ChronoUnit.HALF_DAYS);

        return Math.toIntExact(duration.toHours());
    }

    public Instant roundToNearestHalfDay(Instant instant) {
        return Optional.ofNullable(instant)
                .map(inst -> inst.plus(Duration.ofHours(6)).truncatedTo(ChronoUnit.HALF_DAYS))
                .orElse(null);
    }
}

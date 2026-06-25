/*******************************************************************************
 * Copyright (c) 2024, 2026 CEA LIST.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 ******************************************************************************/
package pepper.starter.services.descriptions;

import pepper.starter.messages.IPepperMMMessageService;
import pepper.starter.messages.MessageConstants;

import java.util.List;
import java.util.Objects;

import org.eclipse.sirius.components.collaborative.tables.api.IRowContextMenuEntryProvider;
import org.eclipse.sirius.components.collaborative.tables.dto.RowContextMenuEntry;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.tables.Line;
import org.eclipse.sirius.components.tables.Table;
import org.eclipse.sirius.components.tables.descriptions.TableDescription;
import org.springframework.stereotype.Service;

/**
 * Provides row actions for unavailability period tables.
 *
 * @author Obeo
 */
@Service
public class UnavailabilityPeriodRowContextMenuProvider implements IRowContextMenuEntryProvider {

    public static final String DELETE_ID = "pepper-unavailability-period-delete-row";

    private final IPepperMMMessageService pepperMMMessageService;

    public UnavailabilityPeriodRowContextMenuProvider(IPepperMMMessageService pepperMMMessageService) {
        this.pepperMMMessageService = Objects.requireNonNull(pepperMMMessageService);
    }

    @Override
    public boolean canHandle(IEditingContext editingContext, TableDescription tableDescription, Table table, Line row) {
        return Objects.equals(tableDescription.getId(), ResourceAvailabilityPageDescription.UNAVAILABILITY_PERIODS_TABLE_ID);
    }

    @Override
    public List<RowContextMenuEntry> getRowContextMenuEntries(IEditingContext editingContext, TableDescription tableDescription, Table table, Line row) {
        return List.of(new RowContextMenuEntry(DELETE_ID, this.pepperMMMessageService.getMessage(MessageConstants.DELETE_UNAVAILABILITY_PERIOD), List.of()));
    }
}

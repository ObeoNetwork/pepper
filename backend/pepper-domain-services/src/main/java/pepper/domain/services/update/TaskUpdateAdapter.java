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

package pepper.domain.services.update;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import pepper.peppermm.DependencyRelatedObject;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.UnavailabilityPeriod;

/**
 * This adapter is used to update tasks.
 * @author lfasani
 */
public class TaskUpdateAdapter extends EContentAdapter {
    private final TaskUpdateService taskUpdateService;

    public TaskUpdateAdapter(TaskUpdateService taskUpdateService) {
        this.taskUpdateService = taskUpdateService;
    }

    @Override
    public void notifyChanged(Notification notification) {
        super.notifyChanged(notification);
        if (!notification.isTouch()) {
            this.handleNotification(notification);
        }
    }

    private void handleNotification(Notification notification) {
        Object notifier = notification.getNotifier();
        Object feature = notification.getFeature();
        if (notifier instanceof DependencyRelatedObject task && feature.equals(PepperPackage.eINSTANCE.getAssignableObject_AssignedPersons())) {
            taskUpdateService.updateTasksFollowingPersonChange(task);
        } else if (notifier instanceof Person person && feature.equals(PepperPackage.eINSTANCE.getResource_UnavailabilityPeriods())) {
            taskUpdateService.updateTasksFollowingPersonChange(person);
        } else if (notifier instanceof UnavailabilityPeriod unavailabilityPeriod
                && (feature.equals(PepperPackage.eINSTANCE.getUnavailabilityPeriod_StartDate()) || feature.equals(PepperPackage.eINSTANCE.getUnavailabilityPeriod_EndDate()))) {
            if (unavailabilityPeriod.eContainer() instanceof Person person) {
                taskUpdateService.updateTasksFollowingPersonChange(person);
            }
        }
    }
}

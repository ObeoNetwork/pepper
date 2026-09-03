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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.components.core.api.IFeedbackMessageService;
import org.eclipse.sirius.components.interpreter.SimpleCrossReferenceProvider;
import org.eclipse.sirius.components.representations.Message;
import org.eclipse.sirius.components.representations.MessageLevel;
import org.springframework.stereotype.Service;

import pepper.domain.services.TaskComputationService;
import pepper.domain.services.TaskHelper;
import pepper.domain.services.WorkpackageComputationService;
import pepper.peppermm.AbstractTask;
import pepper.peppermm.DependencyLink;
import pepper.peppermm.DependencyRelatedObject;

/**
 * Service to manage the update of a task and the impacted tasks.
 *
 * @author lfasani
 */
@Service
public class TaskUpdateService {

    private final TaskHelper taskHelper = new TaskHelper();

    private final SimpleCrossReferenceProvider simpleCrossReferenceProvider = new SimpleCrossReferenceProvider();

    private final IFeedbackMessageService feedbackMessageService;

    private final TaskComputationService taskComputationService = new TaskComputationService();

    private final WorkpackageComputationService workpackageComputationService = new WorkpackageComputationService();

    public TaskUpdateService(IFeedbackMessageService feedbackMessageService) {
        this.feedbackMessageService = Objects.requireNonNull(feedbackMessageService);
    }

    public void updateWithImpacts(EObject task, TaskUpdateStep taskUpdateStep) {
        this.updateWithImpacts(task, List.of(taskUpdateStep));
    }

    public void updateWithImpacts(EObject task, List<TaskUpdateStep> taskUpdateSteps) {
        List<TaskUpdateStep> tasksToUpdate = new ArrayList<>(taskUpdateSteps);
        List<TaskUpdateStep> currentBranchOfTasksToUpdate = new ArrayList<>(tasksToUpdate);
        try {
            this.computeTaskToUpdate(task, tasksToUpdate, currentBranchOfTasksToUpdate);
            this.doUpdate(tasksToUpdate);
        } catch (IllegalStateException e) {
            // logged in IFeedbackMessageService
        }
    }

    public void doUpdate(List<TaskUpdateStep> tasksToUpdate) {
        tasksToUpdate.forEach(TaskUpdateStep::update);
    }

    /**
     * Aggregates the tasksToUpdate with tasks that are dependencies of currentTask.
     */
    public void computeTaskToUpdate(EObject currentTask, List<TaskUpdateStep> tasksToUpdate, List<TaskUpdateStep> currentBranchOfTasksToUpdate) throws IllegalStateException {
        for (var inverseReference : simpleCrossReferenceProvider.getInverseReferences(currentTask)) {
            if (inverseReference.getEObject() instanceof DependencyLink dependencyLink) {
                if (dependencyLink.eContainer() instanceof DependencyRelatedObject targetTask && currentTask instanceof DependencyRelatedObject sourceTask) {
                    if (taskHelper.isComputedDynamically(targetTask)) {
                        this.fail(String.format("Having a dependency targeting a dynamically computed task \"%s\" is not possible.", taskHelper.getName(targetTask)));
                    }
                    this.computeTaskToUpdate(tasksToUpdate, currentBranchOfTasksToUpdate, targetTask, new DependencyUpdateStep(targetTask));
                }
            }
        }

        if (currentTask.eContainer() instanceof AbstractTask abstractTask) {
            if (abstractTask.isComputeStartEndDynamically()) {
                this.computeTaskToUpdate(tasksToUpdate, currentBranchOfTasksToUpdate, abstractTask, new ParentUpdateStep(abstractTask));
            }
        }
    }

    private void computeTaskToUpdate(List<TaskUpdateStep> tasksToUpdate, List<TaskUpdateStep> currentBranchOfTasksToUpdate, EObject targetTask, TaskUpdateStep newUpdateStep) {
        List<TaskUpdateStep> newBranchOfTasksToUpdate = new ArrayList<>(currentBranchOfTasksToUpdate);
        newBranchOfTasksToUpdate.add(newUpdateStep);

        if (newBranchOfTasksToUpdate.stream().distinct().count() != newBranchOfTasksToUpdate.size()) {
            String updatePath = newBranchOfTasksToUpdate.stream()
                    .map(TaskUpdateStep::getName)
                    .collect(Collectors.joining(" -> "));
            this.fail("Creating a cyclic dependency is not possible: " + updatePath);
        }
        if (!tasksToUpdate.contains(newUpdateStep)) {
            tasksToUpdate.add(newUpdateStep);
        }

        this.computeTaskToUpdate(targetTask, tasksToUpdate, newBranchOfTasksToUpdate);
    }

    void fail(String message) {
        this.feedbackMessageService.addFeedbackMessage(new Message(message, MessageLevel.ERROR));
        throw new IllegalStateException();
    }


}

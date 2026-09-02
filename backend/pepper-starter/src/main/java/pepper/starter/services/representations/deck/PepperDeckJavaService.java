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
 ******************************************************************************/
package pepper.starter.services.representations.deck;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.KeyResult;
import pepper.peppermm.Objective;
import pepper.peppermm.PepperFactory;
import pepper.peppermm.Project;
import pepper.peppermm.TagFolder;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTag;
import pepper.peppermm.Workpackage;

/**
 * Java Service for the task related views.
 *
 * @author lfasani
 */
public class PepperDeckJavaService {

    private static final String NEW_TASK = "New Task";

    public PepperDeckJavaService() {
    }

    public List<Task> getTasksWithTag(TaskTag tag, Workpackage workpackage) {
        return Optional.of(workpackage).stream()
                .flatMap(wkP -> {
                    Iterable<EObject> content = () -> wkP.eAllContents();
                    return StreamSupport.stream(content.spliterator(), false);
                })
                .filter(Task.class::isInstance)
                .map(Task.class::cast)
                .filter(task -> task.getTags().contains(tag))
                .toList();
    }

    public String computeTaskEffortDays(Task task) {
        String value = "";
        int effort = task.getEffort();
        int dd = effort / 24;
        int hh = effort % 24;
        value = String.format("%02dd%02dh", dd, hh);
        return value;
    }

    public void createCard(EObject context) {
        Task task = PepperFactory.eINSTANCE.createTask();
        task.setName(NEW_TASK);
        task.setDescription("new description");
        if (context instanceof TaskTag tag) {
            task.getTags().add(tag);

            EObject parent = context.eContainer();
            if (parent instanceof TagFolder tagFolder) {
                EObject parent2 = tagFolder.eContainer();
                if (parent2 instanceof Project project) {
                    var workpackages = project.getOwnedWorkpackages();
                    if (!workpackages.isEmpty()) {
                        workpackages.get(0).getOwnedTasks().add(task);
                    }
                }
            }
        }
    }

    public void editCard(EObject eObject, String title, String description, String label) {
        if (eObject instanceof AbstractTask task) {
            if (title != null) {
                task.setName(title);
            }
            if (description != null) {
                task.setDescription(description);
            }
        }
    }

    public void moveKeyResultIntoObjective(KeyResult sourceKeyResult, Objective targetObjective, int indexInTarget) {
        EList<KeyResult> ownedKeyResults = targetObjective.getOwnedKeyResults();
        if (sourceKeyResult.eContainer().equals(targetObjective)) {
            ownedKeyResults.move(indexInTarget, sourceKeyResult);
        } else {
            ownedKeyResults.add(sourceKeyResult);
            ownedKeyResults.move(indexInTarget, sourceKeyResult);
        }
    }

    private void moveTaskInSubTasks(Task sourceTask, int indexInTarget, Task targetTask) {
        List<Task> subTasks = targetTask.getSubTasks();
        if (subTasks.contains(sourceTask)) {
            if (indexInTarget >= 0 && indexInTarget <= subTasks.size()) {
                int indexOfSource = subTasks.indexOf(sourceTask);
                if (indexOfSource < indexInTarget) {
                    targetTask.getSubTasks().move(indexInTarget - 1, sourceTask);
                } else {
                    targetTask.getSubTasks().move(indexInTarget, sourceTask);
                }
            } else {
                targetTask.getSubTasks().move(subTasks.size() - 1, sourceTask);
            }
        } else {
            boolean targetHadNoChild = subTasks.isEmpty();
            if (targetHadNoChild) {
                targetTask.setComputeStartEndDynamically(true);
            }
            if (indexInTarget >= 0 && indexInTarget <= targetTask.getSubTasks().size()) {
                targetTask.getSubTasks().add(indexInTarget, sourceTask);
            } else {
                targetTask.getSubTasks().add(sourceTask);
            }
        }
    }

    public Task moveTaskInTag(Task moveTask, int index, TaskTag targetTag) {
        Optional<Workpackage> workPackageOpt = this.getParent(moveTask, Workpackage.class);

        if (workPackageOpt.isPresent()) {
            // We retrieve all tasks with the same tag (in the same lane).
            List<Task> allTaskInTheLane = this.getTasksWithTag(targetTag, workPackageOpt.get());
            Optional<Task> firstTaskAfterTheDroppedTaskWithSameParent = allTaskInTheLane.subList(index, allTaskInTheLane.size()).stream()
                    .filter(task -> task.eContainer().equals(moveTask.eContainer())).findFirst();

            List<Task> tasksBeforeTheDroppedTaskWithSameParent = allTaskInTheLane.subList(0, index).stream().filter(task -> task.eContainer().equals(moveTask.eContainer())).toList();
            Optional<Task> lastTaskBeforeTheDroppedTaskWithSameParent = Optional.empty();
            if (!tasksBeforeTheDroppedTaskWithSameParent.isEmpty()) {
                lastTaskBeforeTheDroppedTaskWithSameParent = Optional.of(tasksBeforeTheDroppedTaskWithSameParent.get(tasksBeforeTheDroppedTaskWithSameParent.size() - 1));
            }

            if (lastTaskBeforeTheDroppedTaskWithSameParent.isPresent() || firstTaskAfterTheDroppedTaskWithSameParent.isPresent()) {
                EObject eContainer = moveTask.eContainer();
                if (eContainer instanceof Workpackage workpackage) {
                    int indexInParent = 0;
                    if (lastTaskBeforeTheDroppedTaskWithSameParent.isPresent()) {
                        indexInParent = workpackage.getOwnedTasks().indexOf(lastTaskBeforeTheDroppedTaskWithSameParent.get()) + 1;
                    } else {
                        indexInParent = workpackage.getOwnedTasks().indexOf(firstTaskAfterTheDroppedTaskWithSameParent.get());
                    }
                    workpackage.getOwnedTasks().move(indexInParent, moveTask);
                } else if (eContainer instanceof AbstractTask parentTask) {
                    int indexInParent = 0;
                    if (lastTaskBeforeTheDroppedTaskWithSameParent.isPresent()) {
                        indexInParent = parentTask.getSubTasks().indexOf(lastTaskBeforeTheDroppedTaskWithSameParent.get()) + 1;
                    } else {
                        indexInParent = parentTask.getSubTasks().indexOf(firstTaskAfterTheDroppedTaskWithSameParent.get());
                    }
                    parentTask.getSubTasks().move(indexInParent, moveTask);
                }
            }
        }
        return moveTask;
    }

    <T> Optional<T> getParent(EObject eObject, Class<T> clazz) {
        Optional<T> objectOpt = Optional.empty();
        EObject parent = eObject.eContainer();
        while (parent != null) {
            if (clazz.isInstance(parent)) {
                objectOpt = Optional.of(clazz.cast(parent));
                break;
            }
            parent = parent.eContainer();
        }

        return objectOpt;
    }

    public void moveObjectiveAtIndex(Objective objective, int index) {
        if (objective.eContainer() instanceof Project project) {
            project.getOwnedObjectives().move(index, objective);
        }
    }

    public void moveTagAtIndex(TaskTag movedTag, int index) {
        EObject eContainer = movedTag.eContainer();
        if (eContainer instanceof TagFolder tagFolder) {
            String prefix = movedTag.getPrefix();
            List<TaskTag> tagList = tagFolder.getOwnedTags().stream().filter(tag -> tag.getPrefix().equals(prefix)).toList();

            int newIndex = this.computeIndexOfTagToMove(movedTag, index, tagList, tagFolder);
            // We move the current tag before the tagToReplace in the project ownTags list.
            int oldIndex = tagFolder.getOwnedTags().indexOf(movedTag);
            // If the moved tag was located before the new location, the index after having remove the tag is
            // decremented.
            if (oldIndex < newIndex) {
                newIndex--;
            }
            tagFolder.getOwnedTags().move(newIndex, movedTag);

        }
    }

    /**
     * When a lane is moved, we change the underlying tag ordering. We need to compute the new index in the project tag list.
     *
     * @param tag
     *         the tag to move.
     * @param index
     *         the new index in the project tag list.
     * @param tagList
     *         the current deck representation tag list (might be a sub set of the project tag list).
     * @param tagFolder
     *         the TagFolder owning the tags.
     * @return the index on which the tag should be moved in the project tag list to match the new index in the deck representation.
     */
    private int computeIndexOfTagToMove(TaskTag tag, int index, List<TaskTag> tagList, TagFolder tagFolder) {
        int newIndex;
        List<TaskTag> unmovedLaneTags = tagList.stream().filter(currentTag -> currentTag != tag).toList();
        if (index < unmovedLaneTags.size()) {
            // We retrieve the tag that will be located after the moved one.
            TaskTag tagToMoveAround = unmovedLaneTags.get(index);
            newIndex = tagFolder.getOwnedTags().indexOf(tagToMoveAround);
        } else {
            // We need to locate the tag after the last one in the deck representation
            TaskTag lastTag = unmovedLaneTags.get(unmovedLaneTags.size() - 1);
            newIndex = tagFolder.getOwnedTags().indexOf(lastTag) + 1;
        }
        return newIndex;
    }
}

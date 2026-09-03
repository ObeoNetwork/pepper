## Managing time zones

Pepper only supports a single time zone.
The server and the browser must use the same time zone.


## Upadate philosophy

There are two approaches to solve the update.

### Approach 1: Full update

Except if there is a cycle that is detected, the update should always succeed.

The philophy is "I know what I am doing, so I let the algorithm change task boundaries I specifically set in the model"

### Approach 2: Validation

"I don't want the update to change task boundaries I specifically set in the model"

If this occurs, then conflicting changes are not applied until the user cancel or accept the changes.

## Considering task constraints

A task is constrained by two `TimeConstraint` values among:

- `START`
- `END`
- `EFFORT`
  If a constrained boundary (`START` or `END`) is also constrained by a dependency, the dependency constraint is considered stronger than the task constraint.

A boundary constrained by a dependency can not be changed by a user.


## Task boundaries computation

An AbstractTask has its boundaries defined as Instant.
When modifying the task, either from Gantt, details view or by the algorithm, the AbstractTask boundaries are rounded to the closest half-day.
Non-working days (in week and configured fixed non-working days) do not consume any effort.

The workpackage has its boundaries defined as LocalDate.
Both workpackage startDate and endDate are included.

### Task with assigned persons

If a task has assigned persons, then the calculation of time constraints will consider the unavailability periods of Person.
An unavailability period does not consume any effort.
On the contrary if multiple persons are available on a task, the effort is more consumed.
If no person is assigned, one working day consume an effort of one day.

## Gantt interactions

### Changing one task boundary

- If the changed boundary is constraining, this moved boundary is updated and the other constraint is preserved.
- If the changed boundary is not constraining or the opposite boundary is constrained by a dependency, then the moved boundary is updated along with the effort.
- Otherwise, the change is interpreted as a user intent to update the effort by the move delta.
  -- [FUTURE ENHANCEMENT] A global option could forbid changing a non-constraining boundary directly. In that mode, moving such a task boundary would not be allowed.

For example: A START-EFFORT task has its end date constrained by a dependency. If the start date is moved, the end date remains unchanged and the effort is updated accordingly.

In any case, the impacted tasks are updating keeping the effort unchanged
  -- [FUTURE ENHANCEMENT] Clicking on an alternative key while updating the task, the impacted task would be updated according to their constraint.

### Moving a task

- If the task is constrained by dependencies nothing is done.
- Otherwise, the moved task and all the impacted tasks are updating keeping the effort unchanged.

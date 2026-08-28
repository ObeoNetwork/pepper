## Managing time zones

Pepper only supports a single time zone.
The server and the browser must use the same time zone.

## Considering task constraints

A task is constrained by two `TimeConstraint` values among:

- `START`
- `END`
- `EFFORT`
  If a constrained boundary (`START` or `END`) is also constrained by a dependency, the dependency constraint is considered stronger than the task constraint.

In that case, the effort is no longer considered constraining.

A boundary constrained by a dependency can not be changed directly.

For example: A START-EFFORT task has its end date constrained by a dependency. If the start date is moved, the end date remains unchanged and the effort is updated accordingly.

## Task bounds computation

An AbstractTask has its bounds defined as Instant.
When modifying the task, either from Gantt, details view or by the algorithm, the AbstractTask bounds are rounded to the closest half-day.
Non-working days (in week and configured fixed non-working days) do not consume any effort.

The workpackage has its bounds defined as LocalDate
Both workpackage startDate and endDate are included.

### Task with assigned persons

If a task has assigned persons, then the calculation of time constraints will consider the unavailability periods of Person.
An unavailability period does not consume any effort.
On the contrary if multiple persons are available on a task, the effort is more consumed.
If no person is assigned, one working day consume an effort of one day.

## Gantt interactions

### Moving a task

- If the task is constrained by dependencies nothing is done.
- Otherwise, the constraining boundary or boundaries are updated according to the task calculation option:
  -- `START-END`: both boundaries are updated. The effort may change if the number of included non-working days changes.
  -- `START-EFFORT` and `END-EFFORT`: the constraining boundary is updated. The constrained boundary may move by more than the drag delta if the number of included non-working days changes, because the effort is preserved.

### Changing one task boundary

- If the boundary is constraining, this boundary is updated and the other constraint is preserved.
- If the opposite boundary is constrained by a dependency, the moved boundary is updated and the effort is updated as well.
- Otherwise, the change is interpreted as a user intent to update the effort by the move delta.
  -- [FUTURE ENHANCEMENT] A global option could forbid changing a non-constraining boundary directly. In that mode, moving such a task boundary would not be allowed.

## Managing time zones

Pepper only supports a single time zone.
The server and the browser must use the same time zone.

## Considering task constraints

A task is constrained by two `TimeConstraint` values among:

- `START`
- `END`
- `DURATION`
  If a constrained boundary (`START` or `END`) is also constrained by a dependency, the dependency constraint is considered stronger than the task constraint.

In that case, the duration is no longer considered constraining.

A boundary constrained by a dependency can not be changed directly.

For example: A START-DURATION task has its end date constrained by a dependency. If the start date is moved, the end date remains unchanged and the duration is updated accordingly.

## Gantt interactions

### Moving a task

- If the task is constrained by dependencies nothing is done.
- Otherwise, the constraining boundary or boundaries are updated according to the task calculation option:
  -- `START-END`: both boundaries are updated. The duration may change if the number of included non-working days changes.
  -- `START-DURATION` and `END-DURATION`: the constraining boundary is updated. The constrained boundary may move by more than the drag delta if the number of included non-working days changes, because the duration is preserved.

### Changing one task boundary

- If the boundary is constraining, this boundary is updated and the other constraint is preserved.
- If the opposite boundary is constrained by a dependency, the moved boundary is updated and the duration is updated as well.
- Otherwise, the change is interpreted as a user intent to update the duration by the move delta.
  -- [FUTURE ENHANCEMENT] A global option could forbid changing a non-constraining boundary directly. In that mode, moving such a task boundary would not be allowed.

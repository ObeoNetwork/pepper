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
package pepper.peppermm.impl;

import java.time.Instant;

import java.time.temporal.ChronoUnit;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTag;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Team;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Task</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link AbstractTaskImpl#getName <em>Name</em>}</li>
 * <li>{@link AbstractTaskImpl#getDescription <em>Description</em>}</li>
 * <li>{@link AbstractTaskImpl#getStartTime <em>Start Time</em>}</li>
 * <li>{@link AbstractTaskImpl#getEndTime <em>End Time</em>}</li>
 * <li>{@link AbstractTaskImpl#getProgress <em>Progress</em>}</li>
 * <li>{@link AbstractTaskImpl#isComputeStartEndDynamically <em>Compute Start End
 * Dynamically</em>}</li>
 * <li>{@link AbstractTaskImpl#getTags <em>Tags</em>}</li>
 * <li>{@link AbstractTaskImpl#getAssignedPersons <em>Assigned Persons</em>}</li>
 * <li>{@link AbstractTaskImpl#getAssignedTeams <em>Assigned Teams</em>}</li>
 * <li>{@link AbstractTaskImpl#getSubTasks <em>Sub Tasks</em>}</li>
 * <li>{@link AbstractTaskImpl#getCalculationOption <em>Calculation Option</em>}</li>
 * <li>{@link AbstractTaskImpl#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractTaskImpl extends MinimalEObjectImpl.Container implements AbstractTask {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStartTime()
     * @generated
     * @ordered
     */
    protected static final Instant START_TIME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStartTime()
     * @generated
     * @ordered
     */
    protected Instant startTime = START_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEndTime()
     * @generated
     * @ordered
     */
    protected static final Instant END_TIME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEndTime()
     * @generated
     * @ordered
     */
    protected Instant endTime = END_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getProgress() <em>Progress</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProgress()
     * @generated
     * @ordered
     */
    protected static final int PROGRESS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getProgress() <em>Progress</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getProgress()
     * @generated
     * @ordered
     */
    protected int progress = PROGRESS_EDEFAULT;

    /**
     * The default value of the '{@link #isComputeStartEndDynamically() <em>Compute Start End Dynamically</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isComputeStartEndDynamically()
     * @generated
     * @ordered
     */
    protected static final boolean COMPUTE_START_END_DYNAMICALLY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isComputeStartEndDynamically() <em>Compute Start End Dynamically</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isComputeStartEndDynamically()
     * @generated
     * @ordered
     */
    protected boolean computeStartEndDynamically = COMPUTE_START_END_DYNAMICALLY_EDEFAULT;

    /**
     * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getTags()
     * @generated
     * @ordered
     */
    protected EList<TaskTag> tags;

    /**
     * The cached value of the '{@link #getAssignedPersons() <em>Assigned Persons</em>}' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAssignedPersons()
     * @generated
     * @ordered
     */
    protected EList<Person> assignedPersons;

    /**
     * The cached value of the '{@link #getAssignedTeams() <em>Assigned Teams</em>}' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getAssignedTeams()
     * @generated
     * @ordered
     */
    protected EList<Team> assignedTeams;

    /**
     * The cached value of the '{@link #getSubTasks() <em>Sub Tasks</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSubTasks()
     * @generated
     * @ordered
     */
    protected EList<Task> subTasks;

    /**
     * The default value of the '{@link #getCalculationOption() <em>Calculation Option</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCalculationOption()
     * @generated
     * @ordered
     */
    protected static final TaskTimeBoundariesConstraint CALCULATION_OPTION_EDEFAULT = TaskTimeBoundariesConstraint.START_END;

    /**
     * The cached value of the '{@link #getCalculationOption() <em>Calculation Option</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getCalculationOption()
     * @generated
     * @ordered
     */
    protected TaskTimeBoundariesConstraint calculationOption = CALCULATION_OPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDuration()
     * @generated
     * @ordered
     */
    protected static final int DURATION_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDuration()
     * @generated
     * @ordered
     */
    protected int duration = DURATION_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AbstractTaskImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PepperPackage.Literals.ABSTRACT_TASK;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDescription(String newDescription) {
        String oldDescription = description;
        description = newDescription;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Instant getStartTime() {
        return startTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setStartTime(Instant newStartTime) {
        Instant oldStartTime = startTime;
        Instant oldEndTime = endTime;
        int oldDuration = duration;
        if (calculationOption != TaskTimeBoundariesConstraint.END_DURATION) {
            startTime = newStartTime;
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__START_TIME, oldStartTime, startTime));
        }
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_END)) {
            if (endTime != null && startTime != null) {
                int difference = (int) ChronoUnit.HOURS.between(startTime, endTime);
                if (ChronoUnit.MINUTES.between(startTime, endTime) % 60 != 0) {
                    difference +=1 ;
                }
                duration = difference;
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__DURATION, oldDuration, duration));
            }
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.START_DURATION)) {
            endTime = startTime.plus(duration, ChronoUnit.HOURS).minus(1, ChronoUnit.MINUTES);
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__END_TIME, oldEndTime, endTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Instant getEndTime() {
        return endTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setEndTime(Instant newEndTime) {
        Instant oldEndTime = endTime;
        Instant oldStartTime = startTime;
        int oldDuration = duration;
        if (calculationOption != TaskTimeBoundariesConstraint.START_DURATION) {
            endTime = newEndTime;
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__END_TIME, oldEndTime, endTime));
        }
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_END)) {
            int difference = (int) ChronoUnit.HOURS.between(startTime, endTime);
            if (ChronoUnit.MINUTES.between(startTime, endTime) % 60 != 0) {
                difference += 1;
            }
            duration = difference;
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__DURATION, oldDuration, duration));
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_DURATION) && endTime != null) {
            startTime = endTime.minus(duration, ChronoUnit.HOURS).plus(1, ChronoUnit.MINUTES);
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__START_TIME, oldStartTime, startTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getProgress() {
        return progress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public void setProgress(int newProgress) {
        if (newProgress >= 0 && newProgress <= 100) {
            int oldProgress = progress;
            progress = newProgress;
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__PROGRESS, oldProgress, progress));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isComputeStartEndDynamically() {
        return computeStartEndDynamically;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setComputeStartEndDynamically(boolean newComputeStartEndDynamically) {
        boolean oldComputeStartEndDynamically = computeStartEndDynamically;
        computeStartEndDynamically = newComputeStartEndDynamically;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY, oldComputeStartEndDynamically, computeStartEndDynamically));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<TaskTag> getTags() {
        if (tags == null) {
            tags = new EObjectResolvingEList<TaskTag>(TaskTag.class, this, PepperPackage.ABSTRACT_TASK__TAGS);
        }
        return tags;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Person> getAssignedPersons() {
        if (assignedPersons == null) {
            assignedPersons = new EObjectResolvingEList<Person>(Person.class, this, PepperPackage.ABSTRACT_TASK__ASSIGNED_PERSONS);
        }
        return assignedPersons;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Team> getAssignedTeams() {
        if (assignedTeams == null) {
            assignedTeams = new EObjectResolvingEList<Team>(Team.class, this, PepperPackage.ABSTRACT_TASK__ASSIGNED_TEAMS);
        }
        return assignedTeams;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Task> getSubTasks() {
        if (subTasks == null) {
            subTasks = new EObjectContainmentEList<Task>(Task.class, this, PepperPackage.ABSTRACT_TASK__SUB_TASKS);
        }
        return subTasks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TaskTimeBoundariesConstraint getCalculationOption() {
        return calculationOption;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCalculationOption(TaskTimeBoundariesConstraint newCalculationOption) {
        TaskTimeBoundariesConstraint oldCalculationOption = calculationOption;
        calculationOption = newCalculationOption == null ? CALCULATION_OPTION_EDEFAULT : newCalculationOption;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION, oldCalculationOption, calculationOption));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getDuration() {
        return duration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setDuration(int newDuration) {
        Instant oldStartTime = startTime;
        Instant oldEndTime = endTime;
        int oldDuration = duration;
        if (calculationOption != TaskTimeBoundariesConstraint.START_END) {
            duration = newDuration;
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__DURATION, oldDuration, duration));
        }
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_DURATION)) {
            endTime = startTime.plus(duration, ChronoUnit.HOURS).minus(1, ChronoUnit.MINUTES);
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__END_TIME, oldEndTime, endTime));
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_DURATION)) {
            startTime = endTime.minus(duration, ChronoUnit.HOURS).plus(1, ChronoUnit.MINUTES);
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__START_TIME, oldStartTime, startTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
                return ((InternalEList<?>) getSubTasks()).basicRemove(otherEnd, msgs);
            default:
                return super.eInverseRemove(otherEnd, featureID, msgs);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PepperPackage.ABSTRACT_TASK__NAME:
                return getName();
            case PepperPackage.ABSTRACT_TASK__DESCRIPTION:
                return getDescription();
            case PepperPackage.ABSTRACT_TASK__START_TIME:
                return getStartTime();
            case PepperPackage.ABSTRACT_TASK__END_TIME:
                return getEndTime();
            case PepperPackage.ABSTRACT_TASK__PROGRESS:
                return getProgress();
            case PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY:
                return isComputeStartEndDynamically();
            case PepperPackage.ABSTRACT_TASK__TAGS:
                return getTags();
            case PepperPackage.ABSTRACT_TASK__ASSIGNED_PERSONS:
                return getAssignedPersons();
            case PepperPackage.ABSTRACT_TASK__ASSIGNED_TEAMS:
                return getAssignedTeams();
            case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
                return getSubTasks();
            case PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION:
                return getCalculationOption();
            case PepperPackage.ABSTRACT_TASK__DURATION:
                return getDuration();
            default:
                return super.eGet(featureID, resolve, coreType);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case PepperPackage.ABSTRACT_TASK__NAME:
                setName((String) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__DESCRIPTION:
                setDescription((String) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__START_TIME:
                setStartTime((Instant) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__END_TIME:
                setEndTime((Instant) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__PROGRESS:
                setProgress((Integer) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY:
                setComputeStartEndDynamically((Boolean) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__TAGS:
                getTags().clear();
                getTags().addAll((Collection<? extends TaskTag>) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__ASSIGNED_PERSONS:
                getAssignedPersons().clear();
                getAssignedPersons().addAll((Collection<? extends Person>) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__ASSIGNED_TEAMS:
                getAssignedTeams().clear();
                getAssignedTeams().addAll((Collection<? extends Team>) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
                getSubTasks().clear();
                getSubTasks().addAll((Collection<? extends Task>) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION:
                setCalculationOption((TaskTimeBoundariesConstraint) newValue);
                return;
            case PepperPackage.ABSTRACT_TASK__DURATION:
                setDuration((Integer) newValue);
                return;
            default:
                super.eSet(featureID, newValue);
                return;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case PepperPackage.ABSTRACT_TASK__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PepperPackage.ABSTRACT_TASK__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case PepperPackage.ABSTRACT_TASK__START_TIME:
                setStartTime(START_TIME_EDEFAULT);
                return;
            case PepperPackage.ABSTRACT_TASK__END_TIME:
                setEndTime(END_TIME_EDEFAULT);
                return;
            case PepperPackage.ABSTRACT_TASK__PROGRESS:
                setProgress(PROGRESS_EDEFAULT);
                return;
            case PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY:
                setComputeStartEndDynamically(COMPUTE_START_END_DYNAMICALLY_EDEFAULT);
                return;
            case PepperPackage.ABSTRACT_TASK__TAGS:
                getTags().clear();
                return;
            case PepperPackage.ABSTRACT_TASK__ASSIGNED_PERSONS:
                getAssignedPersons().clear();
                return;
            case PepperPackage.ABSTRACT_TASK__ASSIGNED_TEAMS:
                getAssignedTeams().clear();
                return;
            case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
                getSubTasks().clear();
                return;
            case PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION:
                setCalculationOption(CALCULATION_OPTION_EDEFAULT);
                return;
            case PepperPackage.ABSTRACT_TASK__DURATION:
                setDuration(DURATION_EDEFAULT);
                return;
            default:
                super.eUnset(featureID);
                return;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case PepperPackage.ABSTRACT_TASK__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PepperPackage.ABSTRACT_TASK__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case PepperPackage.ABSTRACT_TASK__START_TIME:
                return START_TIME_EDEFAULT == null ? startTime != null : !START_TIME_EDEFAULT.equals(startTime);
            case PepperPackage.ABSTRACT_TASK__END_TIME:
                return END_TIME_EDEFAULT == null ? endTime != null : !END_TIME_EDEFAULT.equals(endTime);
            case PepperPackage.ABSTRACT_TASK__PROGRESS:
                return progress != PROGRESS_EDEFAULT;
            case PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY:
                return computeStartEndDynamically != COMPUTE_START_END_DYNAMICALLY_EDEFAULT;
            case PepperPackage.ABSTRACT_TASK__TAGS:
                return tags != null && !tags.isEmpty();
            case PepperPackage.ABSTRACT_TASK__ASSIGNED_PERSONS:
                return assignedPersons != null && !assignedPersons.isEmpty();
            case PepperPackage.ABSTRACT_TASK__ASSIGNED_TEAMS:
                return assignedTeams != null && !assignedTeams.isEmpty();
            case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
                return subTasks != null && !subTasks.isEmpty();
            case PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION:
                return calculationOption != CALCULATION_OPTION_EDEFAULT;
            case PepperPackage.ABSTRACT_TASK__DURATION:
                return duration != DURATION_EDEFAULT;
            default:
                return super.eIsSet(featureID);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", description: ");
        result.append(description);
        result.append(", startTime: ");
        result.append(startTime);
        result.append(", endTime: ");
        result.append(endTime);
        result.append(", progress: ");
        result.append(progress);
        result.append(", computeStartEndDynamically: ");
        result.append(computeStartEndDynamically);
        result.append(", calculationOption: ");
        result.append(calculationOption);
        result.append(", duration: ");
        result.append(duration);
        result.append(')');
        return result.toString();
    }

} // AbstractTaskImpl

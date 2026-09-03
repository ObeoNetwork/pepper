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
import java.util.Collection;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import pepper.peppermm.AbstractTask;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTag;
import pepper.peppermm.TaskTimeBoundariesConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Abstract Task</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#getProgress <em>Progress</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#isComputeStartEndDynamically <em>Compute Start End Dynamically</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#getSubTasks <em>Sub Tasks</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#getCalculationOption <em>Calculation Option</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link pepper.peppermm.impl.AbstractTaskImpl#getEffort <em>Effort</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractTaskImpl extends AssignableObjectImpl implements AbstractTask {
    /**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
    protected static final Instant START_TIME_EDEFAULT = null;

    /**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
    protected static final Instant END_TIME_EDEFAULT = null;

    /**
	 * The default value of the '{@link #getProgress() <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
    protected static final int PROGRESS_EDEFAULT = 0;

    /**
	 * The default value of the '{@link #isComputeStartEndDynamically() <em>Compute Start End Dynamically</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isComputeStartEndDynamically()
	 * @generated
	 * @ordered
	 */
    protected static final boolean COMPUTE_START_END_DYNAMICALLY_EDEFAULT = false;

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
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
    protected static final int DURATION_EDEFAULT = 0;

    /**
	 * The default value of the '{@link #getEffort() <em>Effort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffort()
	 * @generated
	 * @ordered
	 */
	protected static final int EFFORT_EDEFAULT = 0;

    /**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
    protected Instant startTime = START_TIME_EDEFAULT;

    /**
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
    protected Instant endTime = END_TIME_EDEFAULT;

    /**
	 * The cached value of the '{@link #getProgress() <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
    protected int progress = PROGRESS_EDEFAULT;

    /**
	 * The cached value of the '{@link #isComputeStartEndDynamically() <em>Compute Start End Dynamically</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isComputeStartEndDynamically()
	 * @generated
	 * @ordered
	 */
    protected boolean computeStartEndDynamically = COMPUTE_START_END_DYNAMICALLY_EDEFAULT;

    /**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
    protected EList<TaskTag> tags;

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
     * The cached value of the '{@link #getCalculationOption() <em>Calculation Option</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getCalculationOption()
     * @generated
     * @ordered
     */
    protected TaskTimeBoundariesConstraint calculationOption = CALCULATION_OPTION_EDEFAULT;

    /**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
    protected int duration = DURATION_EDEFAULT;

				/**
	 * The cached value of the '{@link #getEffort() <em>Effort</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffort()
	 * @generated
	 * @ordered
	 */
	protected int effort = EFFORT_EDEFAULT;

				/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected AbstractTaskImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return PepperPackage.Literals.ABSTRACT_TASK;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Instant getStartTime() {
		return startTime;
	}

    /**
     * If the task's {@code startTime} is constrained by {@code END_DURATION}, it is not changed
     * 
     * @generated
     */
    @Override
    public void setStartTime(Instant newStartTime) {
		Instant oldStartTime = startTime;
		startTime = newStartTime;
		if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__START_TIME, oldStartTime, startTime));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Instant getEndTime() {
		return endTime;
	}

    /**
     * If the task's {@code endTime} is constrained by {@code START_DURATION}, it is not changed
     *
     * @generated
     */
    @Override
    public void setEndTime(Instant newEndTime) {
		Instant oldEndTime = endTime;
		endTime = newEndTime;
		if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__END_TIME, oldEndTime, endTime));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
            if (this.eNotificationRequired())
                this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__PROGRESS, oldProgress, progress));
        }
    }

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
    @Override
    public boolean isComputeStartEndDynamically() {
		return computeStartEndDynamically && this instanceof Task task && !task.getSubTasks().isEmpty();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setComputeStartEndDynamically(boolean newComputeStartEndDynamically) {
		boolean oldComputeStartEndDynamically = computeStartEndDynamically;
		computeStartEndDynamically = newComputeStartEndDynamically;
		if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY, oldComputeStartEndDynamically, computeStartEndDynamically));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
    @Override
    public TaskTimeBoundariesConstraint getCalculationOption() {
		return calculationOption;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setCalculationOption(TaskTimeBoundariesConstraint newCalculationOption) {
		TaskTimeBoundariesConstraint oldCalculationOption = calculationOption;
		calculationOption = newCalculationOption == null ? CALCULATION_OPTION_EDEFAULT : newCalculationOption;
		if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION, oldCalculationOption, calculationOption));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int getDuration() {
		return duration;
	}

    /**
     * If the task's {@code duration} is constrained by {@code START_END}, it is not changed
     * 
     * @generated
     */
    @Override
    public void setDuration(int newDuration) {
		int oldDuration = duration;
		duration = newDuration;
		if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__DURATION, oldDuration, duration));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getEffort() {
		return effort;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEffort(int newEffort) {
		int oldEffort = effort;
		effort = newEffort;
		if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.ABSTRACT_TASK__EFFORT, oldEffort, effort));
	}

				/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
				return ((InternalEList<?>) this.getSubTasks()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PepperPackage.ABSTRACT_TASK__START_TIME:
				return this.getStartTime();
			case PepperPackage.ABSTRACT_TASK__END_TIME:
				return this.getEndTime();
			case PepperPackage.ABSTRACT_TASK__PROGRESS:
				return this.getProgress();
			case PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY:
				return this.isComputeStartEndDynamically();
			case PepperPackage.ABSTRACT_TASK__TAGS:
				return this.getTags();
			case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
				return this.getSubTasks();
			case PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION:
				return this.getCalculationOption();
			case PepperPackage.ABSTRACT_TASK__DURATION:
				return this.getDuration();
			case PepperPackage.ABSTRACT_TASK__EFFORT:
				return this.getEffort();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PepperPackage.ABSTRACT_TASK__START_TIME:
                this.setStartTime((Instant)newValue);
				return;
			case PepperPackage.ABSTRACT_TASK__END_TIME:
                this.setEndTime((Instant)newValue);
				return;
			case PepperPackage.ABSTRACT_TASK__PROGRESS:
                this.setProgress((Integer)newValue);
				return;
			case PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY:
                this.setComputeStartEndDynamically((Boolean)newValue);
				return;
			case PepperPackage.ABSTRACT_TASK__TAGS:
                this.getTags().clear();
                this.getTags().addAll((Collection<? extends TaskTag>)newValue);
				return;
			case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
                this.getSubTasks().clear();
                this.getSubTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION:
                this.setCalculationOption((TaskTimeBoundariesConstraint)newValue);
				return;
			case PepperPackage.ABSTRACT_TASK__DURATION:
                this.setDuration((Integer)newValue);
				return;
			case PepperPackage.ABSTRACT_TASK__EFFORT:
                this.setEffort((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case PepperPackage.ABSTRACT_TASK__START_TIME:
                this.setStartTime(START_TIME_EDEFAULT);
				return;
			case PepperPackage.ABSTRACT_TASK__END_TIME:
                this.setEndTime(END_TIME_EDEFAULT);
				return;
			case PepperPackage.ABSTRACT_TASK__PROGRESS:
                this.setProgress(PROGRESS_EDEFAULT);
				return;
			case PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY:
                this.setComputeStartEndDynamically(COMPUTE_START_END_DYNAMICALLY_EDEFAULT);
				return;
			case PepperPackage.ABSTRACT_TASK__TAGS:
                this.getTags().clear();
				return;
			case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
                this.getSubTasks().clear();
				return;
			case PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION:
                this.setCalculationOption(CALCULATION_OPTION_EDEFAULT);
				return;
			case PepperPackage.ABSTRACT_TASK__DURATION:
                this.setDuration(DURATION_EDEFAULT);
				return;
			case PepperPackage.ABSTRACT_TASK__EFFORT:
                this.setEffort(EFFORT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PepperPackage.ABSTRACT_TASK__START_TIME:
				return !Objects.equals(START_TIME_EDEFAULT, startTime);
			case PepperPackage.ABSTRACT_TASK__END_TIME:
				return !Objects.equals(END_TIME_EDEFAULT, endTime);
			case PepperPackage.ABSTRACT_TASK__PROGRESS:
				return progress != PROGRESS_EDEFAULT;
			case PepperPackage.ABSTRACT_TASK__COMPUTE_START_END_DYNAMICALLY:
				return computeStartEndDynamically != COMPUTE_START_END_DYNAMICALLY_EDEFAULT;
			case PepperPackage.ABSTRACT_TASK__TAGS:
				return tags != null && !tags.isEmpty();
			case PepperPackage.ABSTRACT_TASK__SUB_TASKS:
				return subTasks != null && !subTasks.isEmpty();
			case PepperPackage.ABSTRACT_TASK__CALCULATION_OPTION:
				return calculationOption != CALCULATION_OPTION_EDEFAULT;
			case PepperPackage.ABSTRACT_TASK__DURATION:
				return duration != DURATION_EDEFAULT;
			case PepperPackage.ABSTRACT_TASK__EFFORT:
				return effort != EFFORT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (this.eIsProxy()) return super.toString();

        String result = super.toString() + " (startTime: "
                + startTime
                + ", endTime: "
                + endTime
                + ", progress: "
                + progress
                + ", computeStartEndDynamically: "
                + computeStartEndDynamically
                + ", calculationOption: "
                + calculationOption
                + ", duration: "
                + duration
                + ", effort: "
                + effort
                + ')';
		return result;
	}

} // AbstractTaskImpl

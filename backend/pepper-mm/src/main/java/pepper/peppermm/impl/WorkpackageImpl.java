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

import java.time.LocalDate;

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

import pepper.peppermm.DependencyLink;
import pepper.peppermm.Objective;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Task;
import pepper.peppermm.TaskTimeBoundariesConstraint;
import pepper.peppermm.Workpackage;
import pepper.peppermm.WorkpackageArtefact;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Workpackage</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link WorkpackageImpl#getDependencies <em>Dependencies</em>}</li>
 * <li>{@link WorkpackageImpl#getName <em>Name</em>}</li>
 * <li>{@link WorkpackageImpl#getDescription <em>Description</em>}</li>
 * <li>{@link WorkpackageImpl#getStartDate <em>Start Date</em>}</li>
 * <li>{@link WorkpackageImpl#getEndDate <em>End Date</em>}</li>
 * <li>{@link WorkpackageImpl#getLeader <em>Leader</em>}</li>
 * <li>{@link WorkpackageImpl#getParticipants <em>Participants</em>}</li>
 * <li>{@link WorkpackageImpl#getEffort <em>Effort</em>}</li>
 * <li>{@link WorkpackageImpl#getOutputs <em>Outputs</em>}</li>
 * <li>{@link WorkpackageImpl#getOwnedTasks <em>Owned Tasks</em>}</li>
 * <li>{@link WorkpackageImpl#getOwnedObjectives <em>Owned Objectives</em>}</li>
 * <li>{@link WorkpackageImpl#getProgress <em>Progress</em>}</li>
 * <li>{@link WorkpackageImpl#getCalculationOption <em>Calculation Option</em>}</li>
 * <li>{@link WorkpackageImpl#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkpackageImpl extends MinimalEObjectImpl.Container implements Workpackage {
    /**
     * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDependencies()
     * @generated
     * @ordered
     */
    protected EList<DependencyLink> dependencies;

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
     * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStartDate()
     * @generated
     * @ordered
     */
    protected static final LocalDate START_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStartDate()
     * @generated
     * @ordered
     */
    protected LocalDate startDate = START_DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEndDate()
     * @generated
     * @ordered
     */
    protected static final LocalDate END_DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEndDate()
     * @generated
     * @ordered
     */
    protected LocalDate endDate = END_DATE_EDEFAULT;

    /**
     * The cached value of the '{@link #getLeader() <em>Leader</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getLeader()
     * @generated
     * @ordered
     */
    protected Person leader;

    /**
     * The cached value of the '{@link #getParticipants() <em>Participants</em>}' reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getParticipants()
     * @generated
     * @ordered
     */
    protected EList<Person> participants;

    /**
     * The default value of the '{@link #getEffort() <em>Effort</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEffort()
     * @generated
     * @ordered
     */
    protected static final Integer EFFORT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEffort() <em>Effort</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEffort()
     * @generated
     * @ordered
     */
    protected Integer effort = EFFORT_EDEFAULT;

    /**
     * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getOutputs()
     * @generated
     * @ordered
     */
    protected EList<WorkpackageArtefact> outputs;

    /**
     * The cached value of the '{@link #getOwnedTasks() <em>Owned Tasks</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOwnedTasks()
     * @generated
     * @ordered
     */
    protected EList<Task> ownedTasks;

    /**
     * The cached value of the '{@link #getOwnedObjectives() <em>Owned Objectives</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOwnedObjectives()
     * @generated
     * @ordered
     */
    protected EList<Objective> ownedObjectives;

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
    protected WorkpackageImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PepperPackage.Literals.WORKPACKAGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<DependencyLink> getDependencies() {
        if (dependencies == null) {
            dependencies = new EObjectContainmentEList<DependencyLink>(DependencyLink.class, this, PepperPackage.WORKPACKAGE__DEPENDENCIES);
        }
        return dependencies;
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
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__NAME, oldName, name));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__DESCRIPTION, oldDescription, description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setStartDate(LocalDate newStartDate) {
        LocalDate oldStartDate = startDate;
        if (calculationOption != TaskTimeBoundariesConstraint.END_DURATION) {
            startDate = newStartDate;
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__START_DATE, oldStartDate, startDate));
        }
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_END)) {
            if (endDate != null && startDate != null) {
                int difference = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
                duration = difference;
            }
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.START_DURATION)) {
            endDate = startDate.plusDays(duration - 1);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public void setEndDate(LocalDate newEndDate) {
        LocalDate oldEndDate = endDate;
        if (calculationOption != TaskTimeBoundariesConstraint.START_DURATION) {
            endDate = newEndDate;
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__END_DATE, oldEndDate, endDate));
        }
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_END) && endDate != null && startDate != null) {
            int difference = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
            duration = difference;
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_DURATION) && startDate != null) {
            startDate = endDate.minusDays(duration - 1);
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Person getLeader() {
        if (leader != null && leader.eIsProxy()) {
            InternalEObject oldLeader = (InternalEObject) leader;
            leader = (Person) eResolveProxy(oldLeader);
            if (leader != oldLeader) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PepperPackage.WORKPACKAGE__LEADER, oldLeader, leader));
            }
        }
        return leader;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Person basicGetLeader() {
        return leader;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLeader(Person newLeader) {
        Person oldLeader = leader;
        leader = newLeader;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__LEADER, oldLeader, leader));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Person> getParticipants() {
        if (participants == null) {
            participants = new EObjectResolvingEList<Person>(Person.class, this, PepperPackage.WORKPACKAGE__PARTICIPANTS);
        }
        return participants;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Integer getEffort() {
        return effort;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEffort(Integer newEffort) {
        Integer oldEffort = effort;
        effort = newEffort;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__EFFORT, oldEffort, effort));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<WorkpackageArtefact> getOutputs() {
        if (outputs == null) {
            outputs = new EObjectContainmentEList<WorkpackageArtefact>(WorkpackageArtefact.class, this, PepperPackage.WORKPACKAGE__OUTPUTS);
        }
        return outputs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Task> getOwnedTasks() {
        if (ownedTasks == null) {
            ownedTasks = new EObjectContainmentEList<Task>(Task.class, this, PepperPackage.WORKPACKAGE__OWNED_TASKS);
        }
        return ownedTasks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Objective> getOwnedObjectives() {
        if (ownedObjectives == null) {
            ownedObjectives = new EObjectContainmentEList<Objective>(Objective.class, this, PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES);
        }
        return ownedObjectives;
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
     * @generated
     */
    @Override
    public void setProgress(int newProgress) {
        int oldProgress = progress;
        progress = newProgress;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__PROGRESS, oldProgress, progress));
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
            eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__CALCULATION_OPTION, oldCalculationOption, calculationOption));
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
        int oldDuration = duration;
        if (calculationOption != TaskTimeBoundariesConstraint.START_END) {
            duration = newDuration;
            if (eNotificationRequired())
                eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__DURATION, oldDuration, duration));
        }
        if (calculationOption.equals(TaskTimeBoundariesConstraint.START_DURATION)) {
            endDate = startDate.plusDays(duration - 1);
        } else if (calculationOption.equals(TaskTimeBoundariesConstraint.END_DURATION)) {
            startDate = endDate.minusDays(duration - 1);
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
            case PepperPackage.WORKPACKAGE__DEPENDENCIES:
                return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd, msgs);
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                return ((InternalEList<?>) getOutputs()).basicRemove(otherEnd, msgs);
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                return ((InternalEList<?>) getOwnedTasks()).basicRemove(otherEnd, msgs);
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                return ((InternalEList<?>) getOwnedObjectives()).basicRemove(otherEnd, msgs);
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
            case PepperPackage.WORKPACKAGE__DEPENDENCIES:
                return getDependencies();
            case PepperPackage.WORKPACKAGE__NAME:
                return getName();
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
                return getDescription();
            case PepperPackage.WORKPACKAGE__START_DATE:
                return getStartDate();
            case PepperPackage.WORKPACKAGE__END_DATE:
                return getEndDate();
            case PepperPackage.WORKPACKAGE__LEADER:
                if (resolve)
                    return getLeader();
                return basicGetLeader();
            case PepperPackage.WORKPACKAGE__PARTICIPANTS:
                return getParticipants();
            case PepperPackage.WORKPACKAGE__EFFORT:
                return getEffort();
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                return getOutputs();
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                return getOwnedTasks();
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                return getOwnedObjectives();
            case PepperPackage.WORKPACKAGE__PROGRESS:
                return getProgress();
            case PepperPackage.WORKPACKAGE__CALCULATION_OPTION:
                return getCalculationOption();
            case PepperPackage.WORKPACKAGE__DURATION:
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
            case PepperPackage.WORKPACKAGE__DEPENDENCIES:
                getDependencies().clear();
                getDependencies().addAll((Collection<? extends DependencyLink>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__NAME:
                setName((String) newValue);
                return;
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
                setDescription((String) newValue);
                return;
            case PepperPackage.WORKPACKAGE__START_DATE:
                setStartDate((LocalDate) newValue);
                return;
            case PepperPackage.WORKPACKAGE__END_DATE:
                setEndDate((LocalDate) newValue);
                return;
            case PepperPackage.WORKPACKAGE__LEADER:
                setLeader((Person) newValue);
                return;
            case PepperPackage.WORKPACKAGE__PARTICIPANTS:
                getParticipants().clear();
                getParticipants().addAll((Collection<? extends Person>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__EFFORT:
                setEffort((Integer) newValue);
                return;
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                getOutputs().clear();
                getOutputs().addAll((Collection<? extends WorkpackageArtefact>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                getOwnedTasks().clear();
                getOwnedTasks().addAll((Collection<? extends Task>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                getOwnedObjectives().clear();
                getOwnedObjectives().addAll((Collection<? extends Objective>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__PROGRESS:
                setProgress((Integer) newValue);
                return;
            case PepperPackage.WORKPACKAGE__CALCULATION_OPTION:
                setCalculationOption((TaskTimeBoundariesConstraint) newValue);
                return;
            case PepperPackage.WORKPACKAGE__DURATION:
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
            case PepperPackage.WORKPACKAGE__DEPENDENCIES:
                getDependencies().clear();
                return;
            case PepperPackage.WORKPACKAGE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
                setDescription(DESCRIPTION_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__START_DATE:
                setStartDate(START_DATE_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__END_DATE:
                setEndDate(END_DATE_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__LEADER:
                setLeader((Person) null);
                return;
            case PepperPackage.WORKPACKAGE__PARTICIPANTS:
                getParticipants().clear();
                return;
            case PepperPackage.WORKPACKAGE__EFFORT:
                setEffort(EFFORT_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                getOutputs().clear();
                return;
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                getOwnedTasks().clear();
                return;
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                getOwnedObjectives().clear();
                return;
            case PepperPackage.WORKPACKAGE__PROGRESS:
                setProgress(PROGRESS_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__CALCULATION_OPTION:
                setCalculationOption(CALCULATION_OPTION_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__DURATION:
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
            case PepperPackage.WORKPACKAGE__DEPENDENCIES:
                return dependencies != null && !dependencies.isEmpty();
            case PepperPackage.WORKPACKAGE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
            case PepperPackage.WORKPACKAGE__START_DATE:
                return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
            case PepperPackage.WORKPACKAGE__END_DATE:
                return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
            case PepperPackage.WORKPACKAGE__LEADER:
                return leader != null;
            case PepperPackage.WORKPACKAGE__PARTICIPANTS:
                return participants != null && !participants.isEmpty();
            case PepperPackage.WORKPACKAGE__EFFORT:
                return EFFORT_EDEFAULT == null ? effort != null : !EFFORT_EDEFAULT.equals(effort);
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                return outputs != null && !outputs.isEmpty();
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                return ownedTasks != null && !ownedTasks.isEmpty();
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                return ownedObjectives != null && !ownedObjectives.isEmpty();
            case PepperPackage.WORKPACKAGE__PROGRESS:
                return progress != PROGRESS_EDEFAULT;
            case PepperPackage.WORKPACKAGE__CALCULATION_OPTION:
                return calculationOption != CALCULATION_OPTION_EDEFAULT;
            case PepperPackage.WORKPACKAGE__DURATION:
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
        result.append(", startDate: ");
        result.append(startDate);
        result.append(", endDate: ");
        result.append(endDate);
        result.append(", effort: ");
        result.append(effort);
        result.append(", progress: ");
        result.append(progress);
        result.append(", calculationOption: ");
        result.append(calculationOption);
        result.append(", duration: ");
        result.append(duration);
        result.append(')');
        return result.toString();
    }

} // WorkpackageImpl

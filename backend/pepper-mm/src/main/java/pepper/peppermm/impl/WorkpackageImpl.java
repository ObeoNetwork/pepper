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

import pepper.peppermm.Objective;
import pepper.peppermm.PepperPackage;
import pepper.peppermm.Person;
import pepper.peppermm.Task;
import pepper.peppermm.Workpackage;
import pepper.peppermm.WorkpackageArtefact;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Workpackage</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getName <em>Name</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getDescription <em>Description</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getStartDate <em>Start Date</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getEndDate <em>End Date</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getLeader <em>Leader</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getParticipants <em>Participants</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getEffort <em>Effort</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getOutputs <em>Outputs</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getOwnedTasks <em>Owned Tasks</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getOwnedObjectives <em>Owned Objectives</em>}</li>
 * <li>{@link pepper.peppermm.impl.WorkpackageImpl#getProgress <em>Progress</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkpackageImpl extends MinimalEObjectImpl.Container implements Workpackage {
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
    public String getName() {
        return this.name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__NAME, oldName, this.name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDescription(String newDescription) {
        String oldDescription = this.description;
        this.description = newDescription;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__DESCRIPTION, oldDescription, this.description));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStartDate(LocalDate newStartDate) {
        LocalDate oldStartDate = this.startDate;
        this.startDate = newStartDate;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__START_DATE, oldStartDate, this.startDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public LocalDate getEndDate() {
        return this.endDate;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEndDate(LocalDate newEndDate) {
        LocalDate oldEndDate = this.endDate;
        this.endDate = newEndDate;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__END_DATE, oldEndDate, this.endDate));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Person getLeader() {
        if (this.leader != null && this.leader.eIsProxy()) {
            InternalEObject oldLeader = (InternalEObject) this.leader;
            this.leader = (Person) this.eResolveProxy(oldLeader);
            if (this.leader != oldLeader) {
                if (this.eNotificationRequired())
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, PepperPackage.WORKPACKAGE__LEADER, oldLeader, this.leader));
            }
        }
        return this.leader;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Person basicGetLeader() {
        return this.leader;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setLeader(Person newLeader) {
        Person oldLeader = this.leader;
        this.leader = newLeader;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__LEADER, oldLeader, this.leader));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Person> getParticipants() {
        if (this.participants == null) {
            this.participants = new EObjectResolvingEList<>(Person.class, this, PepperPackage.WORKPACKAGE__PARTICIPANTS);
        }
        return this.participants;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Integer getEffort() {
        return this.effort;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEffort(Integer newEffort) {
        Integer oldEffort = this.effort;
        this.effort = newEffort;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__EFFORT, oldEffort, this.effort));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<WorkpackageArtefact> getOutputs() {
        if (this.outputs == null) {
            this.outputs = new EObjectContainmentEList<>(WorkpackageArtefact.class, this, PepperPackage.WORKPACKAGE__OUTPUTS);
        }
        return this.outputs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Task> getOwnedTasks() {
        if (this.ownedTasks == null) {
            this.ownedTasks = new EObjectContainmentEList<>(Task.class, this, PepperPackage.WORKPACKAGE__OWNED_TASKS);
        }
        return this.ownedTasks;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Objective> getOwnedObjectives() {
        if (this.ownedObjectives == null) {
            this.ownedObjectives = new EObjectContainmentEList<>(Objective.class, this, PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES);
        }
        return this.ownedObjectives;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getProgress() {
        return this.progress;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProgress(int newProgress) {
        int oldProgress = this.progress;
        this.progress = newProgress;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, PepperPackage.WORKPACKAGE__PROGRESS, oldProgress, this.progress));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                return ((InternalEList<?>) this.getOutputs()).basicRemove(otherEnd, msgs);
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                return ((InternalEList<?>) this.getOwnedTasks()).basicRemove(otherEnd, msgs);
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                return ((InternalEList<?>) this.getOwnedObjectives()).basicRemove(otherEnd, msgs);
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
            case PepperPackage.WORKPACKAGE__NAME:
                return this.getName();
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
                return this.getDescription();
            case PepperPackage.WORKPACKAGE__START_DATE:
                return this.getStartDate();
            case PepperPackage.WORKPACKAGE__END_DATE:
                return this.getEndDate();
            case PepperPackage.WORKPACKAGE__LEADER:
                if (resolve)
                    return this.getLeader();
                return this.basicGetLeader();
            case PepperPackage.WORKPACKAGE__PARTICIPANTS:
                return this.getParticipants();
            case PepperPackage.WORKPACKAGE__EFFORT:
                return this.getEffort();
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                return this.getOutputs();
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                return this.getOwnedTasks();
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                return this.getOwnedObjectives();
            case PepperPackage.WORKPACKAGE__PROGRESS:
                return this.getProgress();
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
            case PepperPackage.WORKPACKAGE__NAME:
                this.setName((String) newValue);
                return;
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
                this.setDescription((String) newValue);
                return;
            case PepperPackage.WORKPACKAGE__START_DATE:
                this.setStartDate((LocalDate) newValue);
                return;
            case PepperPackage.WORKPACKAGE__END_DATE:
                this.setEndDate((LocalDate) newValue);
                return;
            case PepperPackage.WORKPACKAGE__LEADER:
                this.setLeader((Person) newValue);
                return;
            case PepperPackage.WORKPACKAGE__PARTICIPANTS:
                this.getParticipants().clear();
                this.getParticipants().addAll((Collection<? extends Person>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__EFFORT:
                this.setEffort((Integer) newValue);
                return;
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                this.getOutputs().clear();
                this.getOutputs().addAll((Collection<? extends WorkpackageArtefact>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                this.getOwnedTasks().clear();
                this.getOwnedTasks().addAll((Collection<? extends Task>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                this.getOwnedObjectives().clear();
                this.getOwnedObjectives().addAll((Collection<? extends Objective>) newValue);
                return;
            case PepperPackage.WORKPACKAGE__PROGRESS:
                this.setProgress((Integer) newValue);
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
            case PepperPackage.WORKPACKAGE__NAME:
                this.setName(NAME_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
                this.setDescription(DESCRIPTION_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__START_DATE:
                this.setStartDate(START_DATE_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__END_DATE:
                this.setEndDate(END_DATE_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__LEADER:
                this.setLeader((Person) null);
                return;
            case PepperPackage.WORKPACKAGE__PARTICIPANTS:
                this.getParticipants().clear();
                return;
            case PepperPackage.WORKPACKAGE__EFFORT:
                this.setEffort(EFFORT_EDEFAULT);
                return;
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                this.getOutputs().clear();
                return;
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                this.getOwnedTasks().clear();
                return;
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                this.getOwnedObjectives().clear();
                return;
            case PepperPackage.WORKPACKAGE__PROGRESS:
                this.setProgress(PROGRESS_EDEFAULT);
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
            case PepperPackage.WORKPACKAGE__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
            case PepperPackage.WORKPACKAGE__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? this.description != null : !DESCRIPTION_EDEFAULT.equals(this.description);
            case PepperPackage.WORKPACKAGE__START_DATE:
                return START_DATE_EDEFAULT == null ? this.startDate != null : !START_DATE_EDEFAULT.equals(this.startDate);
            case PepperPackage.WORKPACKAGE__END_DATE:
                return END_DATE_EDEFAULT == null ? this.endDate != null : !END_DATE_EDEFAULT.equals(this.endDate);
            case PepperPackage.WORKPACKAGE__LEADER:
                return this.leader != null;
            case PepperPackage.WORKPACKAGE__PARTICIPANTS:
                return this.participants != null && !this.participants.isEmpty();
            case PepperPackage.WORKPACKAGE__EFFORT:
                return EFFORT_EDEFAULT == null ? this.effort != null : !EFFORT_EDEFAULT.equals(this.effort);
            case PepperPackage.WORKPACKAGE__OUTPUTS:
                return this.outputs != null && !this.outputs.isEmpty();
            case PepperPackage.WORKPACKAGE__OWNED_TASKS:
                return this.ownedTasks != null && !this.ownedTasks.isEmpty();
            case PepperPackage.WORKPACKAGE__OWNED_OBJECTIVES:
                return this.ownedObjectives != null && !this.ownedObjectives.isEmpty();
            case PepperPackage.WORKPACKAGE__PROGRESS:
                return this.progress != PROGRESS_EDEFAULT;
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
        if (this.eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (name: ");
        result.append(this.name);
        result.append(", description: ");
        result.append(this.description);
        result.append(", startDate: ");
        result.append(this.startDate);
        result.append(", endDate: ");
        result.append(this.endDate);
        result.append(", effort: ");
        result.append(this.effort);
        result.append(", progress: ");
        result.append(this.progress);
        result.append(')');
        return result.toString();
    }

} // WorkpackageImpl

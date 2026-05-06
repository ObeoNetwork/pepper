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
package pepper.peppermm;

import java.time.LocalDate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Workpackage</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link Workpackage#getName <em>Name</em>}</li>
 * <li>{@link Workpackage#getDescription <em>Description</em>}</li>
 * <li>{@link Workpackage#getStartDate <em>Start Date</em>}</li>
 * <li>{@link Workpackage#getEndDate <em>End Date</em>}</li>
 * <li>{@link Workpackage#getLeader <em>Leader</em>}</li>
 * <li>{@link Workpackage#getParticipants <em>Participants</em>}</li>
 * <li>{@link Workpackage#getEffort <em>Effort</em>}</li>
 * <li>{@link Workpackage#getOutputs <em>Outputs</em>}</li>
 * <li>{@link Workpackage#getOwnedTasks <em>Owned Tasks</em>}</li>
 * <li>{@link Workpackage#getOwnedObjectives <em>Owned Objectives</em>}</li>
 * <li>{@link Workpackage#getProgress <em>Progress</em>}</li>
 * <li>{@link Workpackage#getCalculationOption <em>Calculation Option</em>}</li>
 * <li>{@link Workpackage#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see PepperPackage#getWorkpackage()
 * @model
 * @generated
 */
public interface Workpackage extends DependencyRelatedObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see PepperPackage#getWorkpackage_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link Workpackage#getName <em>Name</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see PepperPackage#getWorkpackage_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link Workpackage#getDescription <em>Description</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Start Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Start Date</em>' attribute.
     * @see #setStartDate(LocalDate)
     * @see PepperPackage#getWorkpackage_StartDate()
     * @model dataType="pepper.peppermm.Date"
     * @generated
     */
    LocalDate getStartDate();

    /**
     * Sets the value of the '{@link Workpackage#getStartDate <em>Start Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Start Date</em>' attribute.
     * @see #getStartDate()
     * @generated
     */
    void setStartDate(LocalDate value);

    /**
     * Returns the value of the '<em><b>End Date</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>End Date</em>' attribute.
     * @see #setEndDate(LocalDate)
     * @see PepperPackage#getWorkpackage_EndDate()
     * @model dataType="pepper.peppermm.Date"
     * @generated
     */
    LocalDate getEndDate();

    /**
     * Sets the value of the '{@link Workpackage#getEndDate <em>End Date</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>End Date</em>' attribute.
     * @see #getEndDate()
     * @generated
     */
    void setEndDate(LocalDate value);

    /**
     * Returns the value of the '<em><b>Leader</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Leader</em>' reference.
     * @see #setLeader(Person)
     * @see PepperPackage#getWorkpackage_Leader()
     * @model
     * @generated
     */
    Person getLeader();

    /**
     * Sets the value of the '{@link Workpackage#getLeader <em>Leader</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Leader</em>' reference.
     * @see #getLeader()
     * @generated
     */
    void setLeader(Person value);

    /**
     * Returns the value of the '<em><b>Participants</b></em>' reference list. The list contents are of type
     * {@link Person}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Participants</em>' reference list.
     * @see PepperPackage#getWorkpackage_Participants()
     * @model
     * @generated
     */
    EList<Person> getParticipants();

    /**
     * Returns the value of the '<em><b>Effort</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Effort</em>' attribute.
     * @see #setEffort(Integer)
     * @see PepperPackage#getWorkpackage_Effort()
     * @model
     * @generated
     */
    Integer getEffort();

    /**
     * Sets the value of the '{@link Workpackage#getEffort <em>Effort</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Effort</em>' attribute.
     * @see #getEffort()
     * @generated
     */
    void setEffort(Integer value);

    /**
     * Returns the value of the '<em><b>Outputs</b></em>' containment reference list. The list contents are of type
     * {@link WorkpackageArtefact}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Outputs</em>' containment reference list.
     * @see PepperPackage#getWorkpackage_Outputs()
     * @model containment="true"
     * @generated
     */
    EList<WorkpackageArtefact> getOutputs();

    /**
     * Returns the value of the '<em><b>Owned Tasks</b></em>' containment reference list. The list contents are of type
     * {@link Task}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Owned Tasks</em>' containment reference list.
     * @see PepperPackage#getWorkpackage_OwnedTasks()
     * @model containment="true"
     * @generated
     */
    EList<Task> getOwnedTasks();

    /**
     * Returns the value of the '<em><b>Owned Objectives</b></em>' containment reference list. The list contents are of
     * type {@link Objective}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Owned Objectives</em>' containment reference list.
     * @see PepperPackage#getWorkpackage_OwnedObjectives()
     * @model containment="true"
     * @generated
     */
    EList<Objective> getOwnedObjectives();

    /**
     * Returns the value of the '<em><b>Progress</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Progress</em>' attribute.
     * @see #setProgress(int)
     * @see PepperPackage#getWorkpackage_Progress()
     * @model
     * @generated
     */
    int getProgress();

    /**
     * Sets the value of the '{@link Workpackage#getProgress <em>Progress</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Progress</em>' attribute.
     * @see #getProgress()
     * @generated
     */
    void setProgress(int value);

    /**
     * Returns the value of the '<em><b>Calculation Option</b></em>' attribute. The default value is
     * <code>"START_END"</code>. The literals are from the enumeration
     * {@link TaskTimeBoundariesConstraint}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Calculation Option</em>' attribute.
     * @see TaskTimeBoundariesConstraint
     * @see #setCalculationOption(TaskTimeBoundariesConstraint)
     * @see PepperPackage#getWorkpackage_CalculationOption()
     * @model default="START_END"
     * @generated
     */
    TaskTimeBoundariesConstraint getCalculationOption();

    /**
     * Sets the value of the '{@link Workpackage#getCalculationOption <em>Calculation Option</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Calculation Option</em>' attribute.
     * @see TaskTimeBoundariesConstraint
     * @see #getCalculationOption()
     * @generated
     */
    void setCalculationOption(TaskTimeBoundariesConstraint value);

    /**
     * Returns the value of the '<em><b>Duration</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Duration</em>' attribute.
     * @see #setDuration(int)
     * @see PepperPackage#getWorkpackage_Duration()
     * @model
     * @generated
     */
    int getDuration();

    /**
     * Sets the value of the '{@link Workpackage#getDuration <em>Duration</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Duration</em>' attribute.
     * @see #getDuration()
     * @generated
     */
    void setDuration(int value);

} // Workpackage

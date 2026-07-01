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

import java.time.Instant;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Abstract Task</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link AbstractTask#getName <em>Name</em>}</li>
 * <li>{@link AbstractTask#getDescription <em>Description</em>}</li>
 * <li>{@link AbstractTask#getStartTime <em>Start Time</em>}</li>
 * <li>{@link AbstractTask#getEndTime <em>End Time</em>}</li>
 * <li>{@link AbstractTask#getProgress <em>Progress</em>}</li>
 * <li>{@link AbstractTask#isComputeStartEndDynamically <em>Compute Start End Dynamically</em>}</li>
 * <li>{@link AbstractTask#getTags <em>Tags</em>}</li>
 * <li>{@link AbstractTask#getAssignedPersons <em>Assigned Persons</em>}</li>
 * <li>{@link AbstractTask#getAssignedTeams <em>Assigned Teams</em>}</li>
 * <li>{@link AbstractTask#getSubTasks <em>Sub Tasks</em>}</li>
 * <li>{@link AbstractTask#getCalculationOption <em>Calculation Option</em>}</li>
 * <li>{@link AbstractTask#getDuration <em>Duration</em>}</li>
 * <li>{@link AbstractTask#getDurationViewMode <em>Duration View Mode</em>}</li>
 * </ul>
 *
 * @see PepperPackage#getAbstractTask()
 * @model abstract="true"
 * @generated
 */
public interface AbstractTask extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see PepperPackage#getAbstractTask_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link AbstractTask#getName <em>Name</em>}' attribute. <!-- begin-user-doc
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
     * @see PepperPackage#getAbstractTask_Description()
     * @model
     * @generated
     */
    String getDescription();

    /**
     * Sets the value of the '{@link AbstractTask#getDescription <em>Description</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription(String value);

    /**
     * Returns the value of the '<em><b>Start Time</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Start Time</em>' attribute.
     * @see #setStartTime(Instant)
     * @see PepperPackage#getAbstractTask_StartTime()
     * @model dataType="pepper.peppermm.Instant"
     * @generated
     */
    Instant getStartTime();

    /**
     * Sets the value of the '{@link AbstractTask#getStartTime <em>Start Time</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Start Time</em>' attribute.
     * @see #getStartTime()
     * @generated
     */
    void setStartTime(Instant value);

    /**
     * Returns the value of the '<em><b>End Time</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>End Time</em>' attribute.
     * @see #setEndTime(Instant)
     * @see PepperPackage#getAbstractTask_EndTime()
     * @model dataType="pepper.peppermm.Instant"
     * @generated
     */
    Instant getEndTime();

    /**
     * Sets the value of the '{@link AbstractTask#getEndTime <em>End Time</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>End Time</em>' attribute.
     * @see #getEndTime()
     * @generated
     */
    void setEndTime(Instant value);

    /**
     * Returns the value of the '<em><b>Progress</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Progress</em>' attribute.
     * @see #setProgress(int)
     * @see PepperPackage#getAbstractTask_Progress()
     * @model
     * @generated
     */
    int getProgress();

    /**
     * Sets the value of the '{@link AbstractTask#getProgress <em>Progress</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Progress</em>' attribute.
     * @see #getProgress()
     * @generated
     */
    void setProgress(int value);

    /**
     * Returns the value of the '<em><b>Compute Start End Dynamically</b></em>' attribute. The default value is
     * <code>"false"</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Compute Start End Dynamically</em>' attribute.
     * @see #setComputeStartEndDynamically(boolean)
     * @see PepperPackage#getAbstractTask_ComputeStartEndDynamically()
     * @model default="false"
     * @generated
     */
    boolean isComputeStartEndDynamically();

    /**
     * Sets the value of the '{@link AbstractTask#isComputeStartEndDynamically <em>Compute Start End
     * Dynamically</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Compute Start End Dynamically</em>' attribute.
     * @see #isComputeStartEndDynamically()
     * @generated
     */
    void setComputeStartEndDynamically(boolean value);

    /**
     * Returns the value of the '<em><b>Tags</b></em>' reference list. The list contents are of type
     * {@link TaskTag}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Tags</em>' reference list.
     * @see PepperPackage#getAbstractTask_Tags()
     * @model
     * @generated
     */
    EList<TaskTag> getTags();

    /**
     * Returns the value of the '<em><b>Assigned Persons</b></em>' reference list. The list contents are of type
     * {@link Person}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Assigned Persons</em>' reference list.
     * @see PepperPackage#getAbstractTask_AssignedPersons()
     * @model
     * @generated
     */
    EList<Person> getAssignedPersons();

    /**
     * Returns the value of the '<em><b>Assigned Teams</b></em>' reference list. The list contents are of type
     * {@link Team}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Assigned Teams</em>' reference list.
     * @see PepperPackage#getAbstractTask_AssignedTeams()
     * @model
     * @generated
     */
    EList<Team> getAssignedTeams();

    /**
     * Returns the value of the '<em><b>Sub Tasks</b></em>' containment reference list. The list contents are of type
     * {@link Task}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Sub Tasks</em>' containment reference list.
     * @see PepperPackage#getAbstractTask_SubTasks()
     * @model containment="true"
     * @generated
     */
    EList<Task> getSubTasks();

    /**
     * Returns the value of the '<em><b>Calculation Option</b></em>' attribute. The default value is
     * <code>"START_END"</code>. The literals are from the enumeration
     * {@link TaskTimeBoundariesConstraint}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Calculation Option</em>' attribute.
     * @see TaskTimeBoundariesConstraint
     * @see #setCalculationOption(TaskTimeBoundariesConstraint)
     * @see PepperPackage#getAbstractTask_CalculationOption()
     * @model default="START_END"
     * @generated
     */
    TaskTimeBoundariesConstraint getCalculationOption();

    /**
     * Sets the value of the '{@link AbstractTask#getCalculationOption <em>Calculation Option</em>}'
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
     * @see PepperPackage#getAbstractTask_Duration()
     * @model
     * @generated
     */
    int getDuration();

    /**
     * Sets the value of the '{@link AbstractTask#getDuration <em>Duration</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Duration</em>' attribute.
     * @see #getDuration()
     * @generated
     */
    void setDuration(int value);

    /**
     * Returns the value of the '<em><b>Duration View Mode</b></em>' attribute. The literals are from the enumeration
     * {@link DurationViewMode}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Duration View Mode</em>' attribute.
     * @see DurationViewMode
     * @see #setDurationViewMode(DurationViewMode)
     * @see PepperPackage#getAbstractTask_DurationViewMode()
     * @model
     * @generated
     */
    DurationViewMode getDurationViewMode();

    /**
     * Sets the value of the '{@link AbstractTask#getDurationViewMode <em>Duration View Mode</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Duration View Mode</em>' attribute.
     * @see DurationViewMode
     * @see #getDurationViewMode()
     * @generated
     */
    void setDurationViewMode(DurationViewMode value);

} // AbstractTask

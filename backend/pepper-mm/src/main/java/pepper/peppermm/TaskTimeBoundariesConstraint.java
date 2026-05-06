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
package pepper.peppermm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Task Time Boundaries
 * Constraint</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see PepperPackage#getTaskTimeBoundariesConstraint()
 * @model
 * @generated
 */
public enum TaskTimeBoundariesConstraint implements Enumerator {
    /**
     * The '<em><b>Start End</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #START_END_VALUE
     * @generated
     * @ordered
     */
    START_END(0, "StartEnd", "START_END"),

    /**
     * The '<em><b>End Duration</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #END_DURATION_VALUE
     * @generated
     * @ordered
     */
    END_DURATION(1, "EndDuration", "END_DURATION"),

    /**
     * The '<em><b>Start Duration</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #START_DURATION_VALUE
     * @generated
     * @ordered
     */
    START_DURATION(2, "StartDuration", "START_DURATION");

    /**
     * The '<em><b>Start End</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #START_END
     * @model name="StartEnd" literal="START_END"
     * @generated
     * @ordered
     */
    public static final int START_END_VALUE = 0;

    /**
     * The '<em><b>End Duration</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #END_DURATION
     * @model name="EndDuration" literal="END_DURATION"
     * @generated
     * @ordered
     */
    public static final int END_DURATION_VALUE = 1;

    /**
     * The '<em><b>Start Duration</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #START_DURATION
     * @model name="StartDuration" literal="START_DURATION"
     * @generated
     * @ordered
     */
    public static final int START_DURATION_VALUE = 2;

    /**
     * An array of all the '<em><b>Task Time Boundaries Constraint</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private static final TaskTimeBoundariesConstraint[] VALUES_ARRAY = new TaskTimeBoundariesConstraint[] { START_END, END_DURATION, START_DURATION, };

    /**
     * A public read-only list of all the '<em><b>Task Time Boundaries Constraint</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<TaskTimeBoundariesConstraint> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Task Time Boundaries Constraint</b></em>' literal with the specified literal value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TaskTimeBoundariesConstraint get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TaskTimeBoundariesConstraint result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Task Time Boundaries Constraint</b></em>' literal with the specified name. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TaskTimeBoundariesConstraint getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TaskTimeBoundariesConstraint result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Task Time Boundaries Constraint</b></em>' literal with the specified integer value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static TaskTimeBoundariesConstraint get(int value) {
        switch (value) {
            case START_END_VALUE:
                return START_END;
            case END_DURATION_VALUE:
                return END_DURATION;
            case START_DURATION_VALUE:
                return START_DURATION;
            default:
                return null;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private TaskTimeBoundariesConstraint(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getValue() {
        return value;
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
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} // TaskTimeBoundariesConstraint

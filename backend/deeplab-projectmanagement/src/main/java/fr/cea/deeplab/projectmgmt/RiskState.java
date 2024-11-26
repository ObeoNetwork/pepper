/**
 * Copyright (c) 2024 CEA LIST.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.cea.deeplab.projectmgmt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Risk State</b></em>', and utility
 * methods for working with them. <!-- end-user-doc -->
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getRiskState()
 * @model
 * @generated
 */
public enum RiskState implements Enumerator {
    /**
     * The '<em><b>On Going</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ON_GOING_VALUE
     * @generated
     * @ordered
     */
    ON_GOING(0, "OnGoing", "ON_GOING"),

    /**
     * The '<em><b>Under Instruction</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #UNDER_INSTRUCTION_VALUE
     * @generated
     * @ordered
     */
    UNDER_INSTRUCTION(1, "UnderInstruction", "UNDER_INSTRUCTION"),

    /**
     * The '<em><b>Stop Before Term</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #STOP_BEFORE_TERM_VALUE
     * @generated
     * @ordered
     */
    STOP_BEFORE_TERM(2, "StopBeforeTerm", "STOP_BEFORE_TERM"),

    /**
     * The '<em><b>Completed</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #COMPLETED_VALUE
     * @generated
     * @ordered
     */
    COMPLETED(3, "Completed", "COMPLETED");

    /**
     * The '<em><b>On Going</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ON_GOING
     * @model name="OnGoing" literal="ON_GOING"
     * @generated
     * @ordered
     */
    public static final int ON_GOING_VALUE = 0;

    /**
     * The '<em><b>Under Instruction</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #UNDER_INSTRUCTION
     * @model name="UnderInstruction" literal="UNDER_INSTRUCTION"
     * @generated
     * @ordered
     */
    public static final int UNDER_INSTRUCTION_VALUE = 1;

    /**
     * The '<em><b>Stop Before Term</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #STOP_BEFORE_TERM
     * @model name="StopBeforeTerm" literal="STOP_BEFORE_TERM"
     * @generated
     * @ordered
     */
    public static final int STOP_BEFORE_TERM_VALUE = 2;

    /**
     * The '<em><b>Completed</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #COMPLETED
     * @model name="Completed" literal="COMPLETED"
     * @generated
     * @ordered
     */
    public static final int COMPLETED_VALUE = 3;

    /**
     * An array of all the '<em><b>Risk State</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final RiskState[] VALUES_ARRAY = new RiskState[] { ON_GOING, UNDER_INSTRUCTION, STOP_BEFORE_TERM, COMPLETED, };

    /**
     * A public read-only list of all the '<em><b>Risk State</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final List<RiskState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Risk State</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RiskState get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            RiskState result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Risk State</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RiskState getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            RiskState result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Risk State</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RiskState get(int value) {
        switch (value) {
            case ON_GOING_VALUE:
                return ON_GOING;
            case UNDER_INSTRUCTION_VALUE:
                return UNDER_INSTRUCTION;
            case STOP_BEFORE_TERM_VALUE:
                return STOP_BEFORE_TERM;
            case COMPLETED_VALUE:
                return COMPLETED;
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
    private RiskState(int value, String name, String literal) {
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
        return this.value;
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
    public String getLiteral() {
        return this.literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        return this.literal;
    }

} // RiskState

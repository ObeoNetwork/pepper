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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Workpackage Artefact
 * Nature</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getWorkpackageArtefactNature()
 * @model
 * @generated
 */
public enum WorkpackageArtefactNature implements Enumerator {
    /**
     * The '<em><b>Delivrable</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #DELIVRABLE_VALUE
     * @generated
     * @ordered
     */
    DELIVRABLE(0, "Delivrable", "DELIVRABLE"),

    /**
     * The '<em><b>Decisional</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #DECISIONAL_VALUE
     * @generated
     * @ordered
     */
    DECISIONAL(1, "Decisional", "DECISIONAL"),

    /**
     * The '<em><b>Project Review</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #PROJECT_REVIEW_VALUE
     * @generated
     * @ordered
     */
    PROJECT_REVIEW(2, "ProjectReview", "PROJECT_REVIEW"),

    /**
     * The '<em><b>Action</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ACTION_VALUE
     * @generated
     * @ordered
     */
    ACTION(3, "Action", "ACTION"),

    /**
     * The '<em><b>Invoicing</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #INVOICING_VALUE
     * @generated
     * @ordered
     */
    INVOICING(4, "Invoicing", "INVOICING"),

    /**
     * The '<em><b>Expense Statement</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EXPENSE_STATEMENT_VALUE
     * @generated
     * @ordered
     */
    EXPENSE_STATEMENT(5, "ExpenseStatement", "EXPENSE_STATEMENT"),

    /**
     * The '<em><b>Client Satisfaction</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #CLIENT_SATISFACTION_VALUE
     * @generated
     * @ordered
     */
    CLIENT_SATISFACTION(6, "ClientSatisfaction", "CLIENT_SATISFACTION"),

    /**
     * The '<em><b>Other</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #OTHER_VALUE
     * @generated
     * @ordered
     */
    OTHER(7, "Other", "OTHER");

    /**
     * The '<em><b>Delivrable</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #DELIVRABLE
     * @model name="Delivrable" literal="DELIVRABLE"
     * @generated
     * @ordered
     */
    public static final int DELIVRABLE_VALUE = 0;

    /**
     * The '<em><b>Decisional</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #DECISIONAL
     * @model name="Decisional" literal="DECISIONAL"
     * @generated
     * @ordered
     */
    public static final int DECISIONAL_VALUE = 1;

    /**
     * The '<em><b>Project Review</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #PROJECT_REVIEW
     * @model name="ProjectReview" literal="PROJECT_REVIEW"
     * @generated
     * @ordered
     */
    public static final int PROJECT_REVIEW_VALUE = 2;

    /**
     * The '<em><b>Action</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ACTION
     * @model name="Action" literal="ACTION"
     * @generated
     * @ordered
     */
    public static final int ACTION_VALUE = 3;

    /**
     * The '<em><b>Invoicing</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #INVOICING
     * @model name="Invoicing" literal="INVOICING"
     * @generated
     * @ordered
     */
    public static final int INVOICING_VALUE = 4;

    /**
     * The '<em><b>Expense Statement</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EXPENSE_STATEMENT
     * @model name="ExpenseStatement" literal="EXPENSE_STATEMENT"
     * @generated
     * @ordered
     */
    public static final int EXPENSE_STATEMENT_VALUE = 5;

    /**
     * The '<em><b>Client Satisfaction</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #CLIENT_SATISFACTION
     * @model name="ClientSatisfaction" literal="CLIENT_SATISFACTION"
     * @generated
     * @ordered
     */
    public static final int CLIENT_SATISFACTION_VALUE = 6;

    /**
     * The '<em><b>Other</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #OTHER
     * @model name="Other" literal="OTHER"
     * @generated
     * @ordered
     */
    public static final int OTHER_VALUE = 7;

    /**
     * An array of all the '<em><b>Workpackage Artefact Nature</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    private static final WorkpackageArtefactNature[] VALUES_ARRAY = new WorkpackageArtefactNature[] { DELIVRABLE, DECISIONAL, PROJECT_REVIEW, ACTION, INVOICING, EXPENSE_STATEMENT, CLIENT_SATISFACTION,
            OTHER, };

    /**
     * A public read-only list of all the '<em><b>Workpackage Artefact Nature</b></em>' enumerators. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final List<WorkpackageArtefactNature> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Workpackage Artefact Nature</b></em>' literal with the specified literal value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static WorkpackageArtefactNature get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            WorkpackageArtefactNature result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Workpackage Artefact Nature</b></em>' literal with the specified name. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static WorkpackageArtefactNature getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            WorkpackageArtefactNature result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Workpackage Artefact Nature</b></em>' literal with the specified integer value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static WorkpackageArtefactNature get(int value) {
        switch (value) {
            case DELIVRABLE_VALUE:
                return DELIVRABLE;
            case DECISIONAL_VALUE:
                return DECISIONAL;
            case PROJECT_REVIEW_VALUE:
                return PROJECT_REVIEW;
            case ACTION_VALUE:
                return ACTION;
            case INVOICING_VALUE:
                return INVOICING;
            case EXPENSE_STATEMENT_VALUE:
                return EXPENSE_STATEMENT;
            case CLIENT_SATISFACTION_VALUE:
                return CLIENT_SATISFACTION;
            case OTHER_VALUE:
                return OTHER;
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
    private WorkpackageArtefactNature(int value, String name, String literal) {
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

} // WorkpackageArtefactNature

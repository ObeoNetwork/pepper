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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Risk Kind</b></em>', and utility
 * methods for working with them. <!-- end-user-doc -->
 *
 * @see fr.cea.deeplab.projectmgmt.ProjectmgmtPackage#getRiskKind()
 * @model
 * @generated
 */
public enum RiskKind implements Enumerator {
    /**
     * The '<em><b>Manpower</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MANPOWER_VALUE
     * @generated
     * @ordered
     */
    MANPOWER(0, "Manpower", "MANPOWER"),

    /**
     * The '<em><b>Machine</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MACHINE_VALUE
     * @generated
     * @ordered
     */
    MACHINE(1, "Machine", "MACHINE"),

    /**
     * The '<em><b>Material</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MATERIAL_VALUE
     * @generated
     * @ordered
     */
    MATERIAL(2, "Material", "MATERIAL"),

    /**
     * The '<em><b>Measurement</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MEASUREMENT_VALUE
     * @generated
     * @ordered
     */
    MEASUREMENT(3, "Measurement", "MEASUREMENT"),

    /**
     * The '<em><b>Method</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #METHOD_VALUE
     * @generated
     * @ordered
     */
    METHOD(4, "Method", "METHOD"),

    /**
     * The '<em><b>Mission</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MISSION_VALUE
     * @generated
     * @ordered
     */
    MISSION(5, "Mission", "MISSION"),

    /**
     * The '<em><b>Management</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MANAGEMENT_VALUE
     * @generated
     * @ordered
     */
    MANAGEMENT(6, "Management", "MANAGEMENT"),

    /**
     * The '<em><b>Maintenance</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MAINTENANCE_VALUE
     * @generated
     * @ordered
     */
    MAINTENANCE(7, "Maintenance", "MAINTENANCE");

    /**
     * The '<em><b>Manpower</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MANPOWER
     * @model name="Manpower" literal="MANPOWER"
     * @generated
     * @ordered
     */
    public static final int MANPOWER_VALUE = 0;

    /**
     * The '<em><b>Machine</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MACHINE
     * @model name="Machine" literal="MACHINE"
     * @generated
     * @ordered
     */
    public static final int MACHINE_VALUE = 1;

    /**
     * The '<em><b>Material</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MATERIAL
     * @model name="Material" literal="MATERIAL"
     * @generated
     * @ordered
     */
    public static final int MATERIAL_VALUE = 2;

    /**
     * The '<em><b>Measurement</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MEASUREMENT
     * @model name="Measurement" literal="MEASUREMENT"
     * @generated
     * @ordered
     */
    public static final int MEASUREMENT_VALUE = 3;

    /**
     * The '<em><b>Method</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #METHOD
     * @model name="Method" literal="METHOD"
     * @generated
     * @ordered
     */
    public static final int METHOD_VALUE = 4;

    /**
     * The '<em><b>Mission</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MISSION
     * @model name="Mission" literal="MISSION"
     * @generated
     * @ordered
     */
    public static final int MISSION_VALUE = 5;

    /**
     * The '<em><b>Management</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MANAGEMENT
     * @model name="Management" literal="MANAGEMENT"
     * @generated
     * @ordered
     */
    public static final int MANAGEMENT_VALUE = 6;

    /**
     * The '<em><b>Maintenance</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #MAINTENANCE
     * @model name="Maintenance" literal="MAINTENANCE"
     * @generated
     * @ordered
     */
    public static final int MAINTENANCE_VALUE = 7;

    /**
     * An array of all the '<em><b>Risk Kind</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private static final RiskKind[] VALUES_ARRAY = new RiskKind[] { MANPOWER, MACHINE, MATERIAL, MEASUREMENT, METHOD, MISSION, MANAGEMENT, MAINTENANCE, };

    /**
     * A public read-only list of all the '<em><b>Risk Kind</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final List<RiskKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Risk Kind</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param literal
     *            the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RiskKind get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            RiskKind result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Risk Kind</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param name
     *            the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RiskKind getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            RiskKind result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Risk Kind</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static RiskKind get(int value) {
        switch (value) {
            case MANPOWER_VALUE:
                return MANPOWER;
            case MACHINE_VALUE:
                return MACHINE;
            case MATERIAL_VALUE:
                return MATERIAL;
            case MEASUREMENT_VALUE:
                return MEASUREMENT;
            case METHOD_VALUE:
                return METHOD;
            case MISSION_VALUE:
                return MISSION;
            case MANAGEMENT_VALUE:
                return MANAGEMENT;
            case MAINTENANCE_VALUE:
                return MAINTENANCE;
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
    private RiskKind(int value, String name, String literal) {
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

} // RiskKind

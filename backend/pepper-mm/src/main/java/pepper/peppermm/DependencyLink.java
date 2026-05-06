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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Dependency Link</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link DependencyLink#getTargetKind <em>Target Kind</em>}</li>
 * <li>{@link DependencyLink#getSourceKind <em>Source Kind</em>}</li>
 * <li>{@link DependencyLink#getSource <em>Source</em>}</li>
 * <li>{@link DependencyLink#getDuration <em>Duration</em>}</li>
 * </ul>
 *
 * @see PepperPackage#getDependencyLink()
 * @model
 * @generated
 */
public interface DependencyLink extends EObject {
    /**
     * Returns the value of the '<em><b>Target Kind</b></em>' attribute. The default value is <code>"START"</code>. The
     * literals are from the enumeration {@link StartOrEnd}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the value of the '<em>Target Kind</em>' attribute.
     * @see StartOrEnd
     * @see #setTargetKind(StartOrEnd)
     * @see PepperPackage#getDependencyLink_TargetKind()
     * @model default="START"
     * @generated
     */
    StartOrEnd getTargetKind();

    /**
     * Sets the value of the '{@link DependencyLink#getTargetKind <em>Target Kind</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Target Kind</em>' attribute.
     * @see StartOrEnd
     * @see #getTargetKind()
     * @generated
     */
    void setTargetKind(StartOrEnd value);

    /**
     * Returns the value of the '<em><b>Source Kind</b></em>' attribute. The default value is <code>"END"</code>. The
     * literals are from the enumeration {@link StartOrEnd}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the value of the '<em>Source Kind</em>' attribute.
     * @see StartOrEnd
     * @see #setSourceKind(StartOrEnd)
     * @see PepperPackage#getDependencyLink_SourceKind()
     * @model default="END"
     * @generated
     */
    StartOrEnd getSourceKind();

    /**
     * Sets the value of the '{@link DependencyLink#getSourceKind <em>Source Kind</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Source Kind</em>' attribute.
     * @see StartOrEnd
     * @see #getSourceKind()
     * @generated
     */
    void setSourceKind(StartOrEnd value);

    /**
     * Returns the value of the '<em><b>Source</b></em>' attribute. The default value is <code>"END"</code>. The
     * literals are from the enumeration {@link StartOrEnd}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the value of the '<em>Source</em>' attribute.
     * @see StartOrEnd
     * @see #setSource(DependencyRelatedObject)
     * @see PepperPackage#getDependencyLink_Source()
     * @model default="END"
     * @generated
     */
    DependencyRelatedObject getSource();

    /**
     * Sets the value of the '{@link DependencyLink#getSource <em>Source</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource(DependencyRelatedObject value);

    /**
     * Returns the value of the '<em><b>Duration</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Duration</em>' attribute.
     * @see #setDuration(int)
     * @see PepperPackage#getDependencyLink_Duration()
     * @model
     * @generated
     */
    int getDuration();

    /**
     * Sets the value of the '{@link DependencyLink#getDuration <em>Duration</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Duration</em>' attribute.
     * @see #getDuration()
     * @generated
     */
    void setDuration(int value);

} // DependencyLink

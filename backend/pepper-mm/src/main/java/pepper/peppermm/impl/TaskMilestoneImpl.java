/**
 * Copyright (c) 2024, 2026 CEA LIST and Others.
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
package pepper.peppermm.impl;

import java.time.Instant;

import org.eclipse.emf.ecore.EClass;

import pepper.peppermm.PepperPackage;
import pepper.peppermm.TaskMilestone;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task Milestone</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TaskMilestoneImpl extends TaskImpl implements TaskMilestone {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskMilestoneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PepperPackage.Literals.TASK_MILESTONE;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public int getDuration() {
		return 0;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public int getEffort() {
		return 0;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Instant getEndTime() {
		return super.getStartTime();
	}
} //TaskMilestoneImpl

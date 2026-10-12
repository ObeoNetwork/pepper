/*******************************************************************************
 * Copyright (c) 2023, 2026 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package pepper.mm.builder.generated.pepper;

/**
 * Builder for TaskTagBuilder.
 *
 * @author BuilderGenerator
 * @generated
 */
public class TaskTagBuilder {

    /**
     * Create instance pepper.peppermm.TaskTag.
     * @generated
     */
    private pepper.peppermm.TaskTag taskTag = pepper.peppermm.PepperFactory.eINSTANCE.createTaskTag();

    /**
     * Return instance pepper.peppermm.TaskTag.
     * @generated
     */
    protected pepper.peppermm.TaskTag getTaskTag() {
        return this.taskTag;
    }

    /**
     * Return instance pepper.peppermm.TaskTag.
     * @generated
     */
    public pepper.peppermm.TaskTag build() {
        return this.getTaskTag();
    }

    /**
     * Setter for Prefix.
     *
     * @generated
     */
    public TaskTagBuilder prefix(java.lang.String value) {
        this.getTaskTag().setPrefix(value);
        return this;
    }
    /**
     * Setter for Suffix.
     *
     * @generated
     */
    public TaskTagBuilder suffix(java.lang.String value) {
        this.getTaskTag().setSuffix(value);
        return this;
    }

}


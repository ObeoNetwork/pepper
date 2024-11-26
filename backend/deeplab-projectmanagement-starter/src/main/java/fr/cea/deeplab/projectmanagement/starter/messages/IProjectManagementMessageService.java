/*******************************************************************************
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
 *******************************************************************************/
package fr.cea.deeplab.projectmanagement.starter.messages;

/**
 * Interface of the message service.
 *
 * @author lfasani
 */
public interface IProjectManagementMessageService {

    String invalidInput(String expectedInputTypeName, String receivedInputTypeName);

    String getMessage(String messageType, String... expectedInputTypeName);
}

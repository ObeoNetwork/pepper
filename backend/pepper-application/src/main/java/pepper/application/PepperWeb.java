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
package pepper.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of the Pepper Web server.
 *
 * @author lfasani
 */
@SpringBootApplication
public class PepperWeb {
    /**
     * The entry point of the server.
     *
     * @param args
     *            The command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PepperWeb.class, args);
    }
}

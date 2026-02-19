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
package pepper.starter.configuration;

import pepper.peppermm.provider.PepperItemProviderAdapterFactory;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of the EMF support for task MM and representation description related to Task.
 *
 * @author lfasani
 */
@Configuration
public class PepperMMEMFConfiguration {

    @Bean
    public ComposedAdapterFactory.Descriptor pepperMMAdapterFactory() {
        return PepperItemProviderAdapterFactory::new;
    }
}

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
package fr.cea.deeplab.projectmanagement.starter.configuration.view;

import static org.assertj.core.api.Assertions.assertThat;

import fr.cea.deeplab.projectmanagement.starter.services.view.ViewDeckDescriptionBuilder;

import org.eclipse.sirius.components.view.View;
import org.eclipse.sirius.components.view.ViewFactory;
import org.junit.jupiter.api.Test;

/**
 * Test used to validate the builder of the "Deck" view description.
 *
 * @author frouene
 */
public class ViewDeckDescriptionBuilderTests {

    @Test
    public void testRepresentationDescriptions() {
        View view = ViewFactory.eINSTANCE.createView();
        new ViewDeckDescriptionBuilder().addRepresentationDescriptions(view);

        assertThat(view.getDescriptions()).hasSize(4);
        assertThat(view.getDescriptions()).anySatisfy(desc -> assertThat(desc.getName()).isEqualTo("Deck Daily Representation"));
        assertThat(view.getDescriptions()).anySatisfy(desc -> assertThat(desc.getName()).isEqualTo("Deck OKR on Project"));
        assertThat(view.getDescriptions()).anySatisfy(desc -> assertThat(desc.getName()).isEqualTo("Deck OKR on Workpackage"));
        assertThat(view.getDescriptions()).anySatisfy(desc -> assertThat(desc.getName()).isEqualTo("Deck Kanban Representation"));
    }

}

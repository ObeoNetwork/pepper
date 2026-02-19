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

import static org.assertj.core.api.Assertions.assertThat;

import pepper.starter.services.PepperMMSampleBuilder;
import pepper.peppermm.Organization;
import pepper.peppermm.PepperPackage;

import org.junit.jupiter.api.Test;

/**
 * Test used to validate the template of task model create by TaskExampleBuilder.
 *
 * @author lfasani
 */
public class PepperMMSampleBuilderTests {

    @Test
    public void testExampleContent() {
        var content = new PepperMMSampleBuilder().getSampleContent();

        assertThat(content).isNotNull();
        assertThat(content.eClass()).isEqualTo(PepperPackage.eINSTANCE.getOrganization());
        Organization organization = (Organization) content;
        assertThat(organization.getOwnedProjects()).hasSize(4);
        assertThat(organization.getOwnedProjects()).anySatisfy(project -> assertThat(project.getName()).isEqualTo("Project Dev"));
        assertThat(organization.getOwnedProjects()).anySatisfy(project -> assertThat(project.getName()).isEqualTo("Daily Project Dev"));
        assertThat(organization.getOwnedProjects()).anySatisfy(project -> assertThat(project.getName()).isEqualTo("Kanban Project Dev"));
        assertThat(organization.getOwnedProjects()).anySatisfy(project -> assertThat(project.getName()).isEqualTo("OKR Project Dev"));
    }
}

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
 *******************************************************************************/

package org.eclipse.sirius.components.codegen.emf.internal;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

public class ProjectUriMapperTest {
    @Test
    public void mapsRootRelativeGeneratorOutputUris() {
        ResourceSet resourceSet = new ResourceSetImpl();
        Path projectRoot = Path.of("C:/workspace/pepper-edit");

        new ProjectUriMapper().registerProject(resourceSet, "pepper-edit", projectRoot);

        URI normalized = resourceSet.getURIConverter()
                .normalize(URI.createURI("platform:/resource/pepper-edit/src/main/java/Example.java"));

        assertEquals(URI.createFileURI("C:/workspace/pepper-edit/src/main/java/Example.java"), normalized);
    }

}

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

package org.eclipse.sirius.components.codegen.emf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.sirius.components.codegen.emf.internal.ProjectLocation;
import org.eclipse.sirius.components.codegen.emf.internal.ProjectLocationResolver;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ProjectLocationResolverTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void resolvesProjectLocationWithoutAssumingRepositoryFolders() throws Exception {
        Path root = this.temporaryFolder.newFolder("repository").toPath();
        Path genmodel = Files.createDirectories(root.resolve("any/nesting/my-project/src/main/resources"))
                .resolve("model.genmodel");

        ProjectLocation location = new ProjectLocationResolver().resolve(root, genmodel);

        assertEquals("my-project", location.projectName());
        assertEquals("src/main/resources/model.genmodel", location.projectRelativePath());
        assertEquals(root.resolve("any/nesting/my-project"), location.projectRoot());
    }

    @Test
    public void returnsNullOutsideRepository() throws Exception {
        Path root = this.temporaryFolder.newFolder("repository").toPath();
        assertNull(new ProjectLocationResolver().resolve(root, Path.of("C:/outside/model.genmodel")));
    }

    @Test
    public void resolvesProjectDirectlyBelowTheRepositoryRoot() throws Exception {
        Path root = this.temporaryFolder.newFolder("arbitrary-root").toPath();
        Path genmodel = Files.createDirectories(root.resolve("pepper-mm/src/main/resources/model"))
                .resolve("pepper.genmodel");

        ProjectLocation location = new ProjectLocationResolver().resolve(root, genmodel);

        assertEquals("pepper-mm", location.projectName());
        assertEquals("src/main/resources/model/pepper.genmodel", location.projectRelativePath());
        assertEquals(root.resolve("pepper-mm"), location.projectRoot());
    }

    @Test
    public void resolvesTheRepositoryRootWhenItIsTheProject() throws Exception {
        Path projectRoot = this.temporaryFolder.newFolder("my-project").toPath();
        Path genmodel = Files.createDirectories(projectRoot.resolve("src/main/resources/model"))
                .resolve("model.genmodel");

        ProjectLocation location = new ProjectLocationResolver().resolve(projectRoot, genmodel);

        assertEquals("my-project", location.projectName());
        assertEquals("src/main/resources/model/model.genmodel", location.projectRelativePath());
        assertEquals(projectRoot, location.projectRoot());
    }

    @Test
    public void returnsNullWhenTheGenmodelIsNotBelowASourceFolder() throws Exception {
        Path root = this.temporaryFolder.newFolder("root-without-source-folder").toPath();
        Path genmodel = Files.createDirectories(root.resolve("my-project/model"))
                .resolve("model.genmodel");

        assertNull(new ProjectLocationResolver().resolve(root, genmodel));
    }
}

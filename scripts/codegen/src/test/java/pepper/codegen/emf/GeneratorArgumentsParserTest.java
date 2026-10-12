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

package pepper.codegen.emf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Path;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import pepper.codegen.emf.internal.GeneratorArguments;
import pepper.codegen.emf.internal.GeneratorArgumentsParser;

public class GeneratorArgumentsParserTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void parsesPlainPathAndPattern() throws Exception {
        Path root = this.temporaryFolder.newFolder("repository").toPath();

        GeneratorArguments arguments = new GeneratorArgumentsParser().parse(new String[] {
                root.toString(), "--genmodel-pattern=**/*.genmodel" });

        assertEquals(root, arguments.repositoryRoot());
        assertEquals("**/*.genmodel", arguments.genmodelPattern());
        assertTrue(arguments.format());
    }

    @Test
    public void parsesFileUri() throws Exception {
        Path root = this.temporaryFolder.newFolder("repository").toPath();

        GeneratorArguments arguments = new GeneratorArgumentsParser().parse(new String[] { root.toUri().toString() });

        assertEquals(root, arguments.repositoryRoot());
        assertEquals("**/src/**.genmodel", arguments.genmodelPattern());
        assertTrue(arguments.format());
    }

    @Test
    public void parsesExplicitFormatValues() throws Exception {
        Path root = this.temporaryFolder.newFolder("repository").toPath();

        GeneratorArguments enabled = new GeneratorArgumentsParser().parse(new String[] { root.toString(), "--format=true" });
        GeneratorArguments disabled = new GeneratorArgumentsParser().parse(new String[] { root.toString(), "--format=false" });

        assertTrue(enabled.format());
        assertFalse(disabled.format());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectsBlankPattern() throws Exception {
        Path root = this.temporaryFolder.newFolder("repository").toPath();
        new GeneratorArgumentsParser().parse(new String[] { root.toString(), "--genmodel-pattern=" });
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectsFormatWithoutValue() throws Exception {
        Path root = this.temporaryFolder.newFolder("repository").toPath();
        new GeneratorArgumentsParser().parse(new String[] { root.toString(), "--format" });
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectsInvalidFormatValue() throws Exception {
        Path root = this.temporaryFolder.newFolder("repository").toPath();
        new GeneratorArgumentsParser().parse(new String[] { root.toString(), "--format=maybe" });
    }
}

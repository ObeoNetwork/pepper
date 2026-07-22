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

import java.nio.file.Path;

public final class ProjectLocationResolver {
    public ProjectLocation resolve(Path repositoryRoot, Path genmodelPath) {
        Path absoluteGenmodel = genmodelPath.toAbsolutePath().normalize();
        Path absoluteRoot = repositoryRoot.toAbsolutePath().normalize();
        if (!absoluteGenmodel.startsWith(absoluteRoot)) {
            return null;
        }
        Path relativeToRoot = absoluteRoot.relativize(absoluteGenmodel);
        int sourceIndex = this.lastIndexOfSegment(relativeToRoot, "src");
        if (sourceIndex < 0 || absoluteRoot.getFileName() == null) {
            return null;
        }
        Path projectRoot = sourceIndex == 0
                ? absoluteRoot
                : absoluteRoot.resolve(relativeToRoot.subpath(0, sourceIndex));
        String projectName = projectRoot.getFileName().toString();
        return new ProjectLocation(projectName, this.toUnixPath(projectRoot.relativize(absoluteGenmodel)), projectRoot);
    }

    private int lastIndexOfSegment(Path path, String segment) {
        for (int index = path.getNameCount() - 1; index >= 0; index--) {
            if (segment.equals(path.getName(index).toString())) {
                return index;
            }
        }
        return -1;
    }

    private String toUnixPath(Path path) {
        StringBuilder result = new StringBuilder();
        for (Path segment : path) {
            if (!result.isEmpty()) {
                result.append('/');
            }
            result.append(segment);
        }
        return result.toString();
    }
}

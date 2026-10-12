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

import java.nio.file.Path;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;

import pepper.codegen.emf.internal.EditProjectLocationResolver;
import pepper.codegen.emf.internal.EmfResourceSetFactory;
import pepper.codegen.emf.internal.GeneratedEditProjectCleaner;
import pepper.codegen.emf.internal.GeneratedModelProjectCleaner;
import pepper.codegen.emf.internal.GeneratorArguments;
import pepper.codegen.emf.internal.GeneratorArgumentsParser;
import pepper.codegen.emf.internal.GeneratorFormattingConfigurer;
import pepper.codegen.emf.internal.GenmodelFinder;
import pepper.codegen.emf.internal.GenmodelGenerationService;
import pepper.codegen.emf.internal.GenmodelLoader;
import pepper.codegen.emf.internal.GenmodelValidator;
import pepper.codegen.emf.internal.LoadedGenmodel;
import pepper.codegen.emf.internal.PluginPropertiesMerger;
import pepper.codegen.emf.internal.ProjectLocationResolver;
import pepper.codegen.emf.internal.ProjectUriMapper;
import pepper.codegen.emf.internal.SvgIconInitializer;

/** EMF code generation entry point for the Sirius Web repository. */
public final class SiriusWebEMFGenerator {
    private final GeneratorArgumentsParser argumentsParser;
    private final GenmodelFinder genmodelFinder;
    private final EmfResourceSetFactory resourceSetFactory;
    private final GenmodelLoader genmodelLoader;
    private final GenmodelValidator genmodelValidator;
    private final GenmodelGenerationService generationService;

    SiriusWebEMFGenerator() {
        ProjectUriMapper projectUriMapper = new ProjectUriMapper();
        this.argumentsParser = new GeneratorArgumentsParser();
        this.genmodelFinder = new GenmodelFinder();
        this.resourceSetFactory = new EmfResourceSetFactory();
        this.genmodelLoader = new GenmodelLoader(new ProjectLocationResolver(), projectUriMapper);
        this.genmodelValidator = new GenmodelValidator();
        this.generationService = new GenmodelGenerationService(projectUriMapper,
                new EditProjectLocationResolver(), new GeneratorFormattingConfigurer(),
                new GeneratedModelProjectCleaner(),
                new GeneratedEditProjectCleaner(new PluginPropertiesMerger(), new SvgIconInitializer()));
    }

    /** Run the generator from the command line. */
    public static void main(String[] args) {
        new SiriusWebEMFGenerator().run(args);
    }

    void run(String[] args) {
        GeneratorArguments arguments = this.argumentsParser.parse(args);
        List<Path> genmodels = this.genmodelFinder.find(arguments.repositoryRoot(), arguments.genmodelPattern());
        ResourceSet resourceSet = this.resourceSetFactory.create();
        List<LoadedGenmodel> loadedGenmodels = this.genmodelLoader.loadAll(resourceSet, arguments.repositoryRoot(), genmodels);
        this.printSummary(arguments, genmodels);
        System.out.printf("Genmodels loaded: %d%n", loadedGenmodels.size());
        this.generationService.generateAll(this.genmodelValidator.validateAll(resourceSet, loadedGenmodels), arguments.format());
    }

    private void printSummary(GeneratorArguments arguments, List<Path> genmodels) {
        System.out.printf("Repository root:  %s%n", arguments.repositoryRoot());
        System.out.printf("Genmodel filter:  %s%n", arguments.genmodelPattern());
        System.out.printf("Formatting:       %s%n", arguments.format());
        System.out.printf("Genmodels found:  %d%n", genmodels.size());
        genmodels.forEach(System.out::println);
    }
}

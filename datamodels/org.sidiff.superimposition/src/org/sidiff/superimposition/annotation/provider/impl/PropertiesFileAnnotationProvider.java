package org.sidiff.superimposition.annotation.provider.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.extension.configuration.*;
import org.sidiff.common.file.PropertiesUtil;
import org.sidiff.common.util.StringListSerializer;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.formula.exception.InvalidFormulaException;
import org.sidiff.formula.parser.FormulaParser;
import org.sidiff.superimposition.annotation.provider.AbstractAnnotationProvider;

/**
 * <p>Reads models annotations from a .properties file, with the key being the name of the model
 * and the value being a semicolon separated set of annotations (may be Formulas).</p>
 * <p>First looks for the exact filename including extension, then for the filename without extension.</p>
 * <p>The location of the properties file is configured using the configuration option,
 * relative to the project which contains the models to be annotated. Leave the option empty
 * to automatically search for an appropriate properties file.</p>
 * <p>Example: <code>annot.properties</code></p>
 * <pre>
 * A.ecore=Foo and Bar
 * B.ecore=and not and
 * C.ecore=Foo;Bar
 * D=Bar
 * </pre>
 * @author rmueller
 */
public class PropertiesFileAnnotationProvider extends AbstractAnnotationProvider {

	private ConfigurationOption<String> propertiesFileOption;
	private ConfigurationOption<Boolean> useConditionAnnotationsOption;
	private IExtensionConfiguration configuration;

	public PropertiesFileAnnotationProvider() {
		propertiesFileOption =
			ConfigurationOption.builder(String.class)
				.key("propertiesFile")
				.name("Annotation .properties file (in the model's project) (empty to search automatically)")
				.defaultValue("")
				.build();
		useConditionAnnotationsOption =
			ConfigurationOption.builder(Boolean.class)
				.key("useConditionAnnotations")
				.name("Use condition (Formula) annotations where possible")
				.defaultValue(false)
				.build();
		configuration = new BasicExtensionConfiguration(Arrays.asList(
				propertiesFileOption, useConditionAnnotationsOption));
	}

	@Override
	public Set<Annotation> getAnnotations(Collection<Resource> allModels, Resource currentModel) {
		Properties properties = loadProperties(currentModel);
		String annotationValue = properties.getProperty(currentModel.getURI().lastSegment());
		if(annotationValue == null) {
			annotationValue = properties.getProperty(currentModel.getURI().trimFileExtension().lastSegment());
		}
		if(annotationValue == null) {
			return Collections.emptySet();
		}
		return StringListSerializer.DEFAULT.deserialize(annotationValue).stream()
			.map(String::trim)
			.distinct()
			.map(this::parseAnnotationString)
			.collect(Collectors.toSet());
	}

	private Properties loadProperties(Resource model) {
		IFile modelFile = EMFStorage.toIFile(model.getURI());
		String fileName = propertiesFileOption.getValue().trim();
		if (fileName.isEmpty()) {
			try {
				return PropertiesUtil.findPreferredProperties(modelFile);
			} catch (CoreException e) {
				throw new IllegalStateException("Could not find a properties file", e);
			}
		}

		IFile propertiesFile = modelFile.getProject().getFile(fileName);
		if(!propertiesFile.exists()) {
			throw new IllegalStateException("Configured properties file does not exist");
		}
		try {
			return PropertiesUtil.loadProperties(propertiesFile);
		} catch (CoreException e) {
			throw new IllegalStateException("Properties file could not be loaded", e);
		}
	}

	private Annotation parseAnnotationString(String annotString) {
		if(useConditionAnnotationsOption.getValue()) {
			try {
				return EntitiesUtil.createConditionAnnotation(FormulaParser.INSTANCE.parse(annotString));
			} catch (InvalidFormulaException e) {
				// fall through
			}
		}
		return EntitiesUtil.createModelAnnotation(annotString);
	}

	@Override
	public IExtensionConfiguration getConfiguration() {
		return configuration;
	}
}

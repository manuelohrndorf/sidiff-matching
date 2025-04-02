package org.sidiff.superimposition.annotation.provider.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.extension.configuration.BasicExtensionConfiguration;
import org.sidiff.common.extension.configuration.ConfigurationOption;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
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
 * relative to the project which contains the models to be annotated.</p>
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
				.name("Annotation .properties file (in the model's project)")
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
	public Set<Annotation> getAnnotations(Resource model) {
		Properties properties = loadProperties(model);
		String annotationValue = properties.getProperty(model.getURI().lastSegment());
		if(annotationValue == null) {
			annotationValue = properties.getProperty(model.getURI().trimFileExtension().lastSegment());
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
		IProject project = EMFStorage.toIFile(model.getURI()).getProject();
		IFile propertiesFile = project.getFile(propertiesFileOption.getValue());
		if(!propertiesFile.exists()) {
			throw new IllegalStateException("Configured properties file does not exist");			
		}
		try (InputStream contents = propertiesFile.getContents(true)) {
			Properties properties = new Properties();
			properties.load(contents);
			return properties;
		} catch (IOException | CoreException e) {
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

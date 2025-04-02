package org.sidiff.matcher.signature.name;

import java.util.Arrays;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.extension.configuration.BasicExtensionConfiguration;
import org.sidiff.common.extension.configuration.ConfigurationOption;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.matcher.LocalSignatureMatcher;

public class NamedElementMatcher extends LocalSignatureMatcher {	

	protected ConfigurationOption<Boolean> allowAmbiguousNames;
	protected ConfigurationOption<Boolean> useQualifiedNames;
	protected ConfigurationOption<Boolean> useToStringSignatureForUnnamed;
	protected IExtensionConfiguration configuration;

	public NamedElementMatcher() {
		initConfig();
	}

	private void initConfig() {
		allowAmbiguousNames = ConfigurationOption.builder(Boolean.class).key("allowAmbiguousNames")
				.name("Allow Ambiguous Names").defaultValue(super.allowsAmbiguousSignature()).build();
		useQualifiedNames = ConfigurationOption.builder(Boolean.class).key("useQualifiedNames")
				.name("Use Qualified Names").defaultValue(false).build();
		useToStringSignatureForUnnamed = ConfigurationOption.builder(Boolean.class).key("toStringSignatureForUnnamed")
				.name("toString() Signature for Unnamed Elements").defaultValue(false).build();
		configuration = new BasicExtensionConfiguration(Arrays.asList(allowAmbiguousNames, useQualifiedNames, useToStringSignatureForUnnamed));
	}

	@Override
	protected String getElementSignature(EObject element) {
		if (useQualifiedNames.getValue()) {
			return deriveQualifiedName(element);
		}
		return getLabelSignature(element);
	}
	
	private String getLabelSignature(EObject element) {	
		String name = EMFUtil.getEObjectName(element);
		if(name != null) {
			return name;
		}

		// No name found:
		if (useToStringSignatureForUnnamed.getValue()) {
			// Remove Object ID if present:
			return element.toString().replaceFirst("@.*?\\s", "");
		}
		
		return null;
	}
	
	private String deriveQualifiedName(EObject element){
		String elementName = getLabelSignature(element);

		while (elementName != null && element.eContainer() != null){
			element = element.eContainer();
			String containerName = getLabelSignature(element);
			
			if (containerName != null) {
				elementName = containerName + "." + elementName;
			} else {
				elementName = null;
			}
		}

		return elementName;
	}

	@Override
	protected boolean considerCandidatesOnly() {
		return true;
	}
	
	@Override
	protected boolean allowsAmbiguousSignature() {
		return allowAmbiguousNames.getValue();
	}
	
	@Override
	public Optional<String> getDescription() {
		return Optional.of("This matching service matches the elements by the element name");
	}

	@Override
	public String getName() {
		return "Named Element Matcher";
	}
	
	@Override
	public String getKey(){
		return getClass().getName();
	}

	@Override
	public IExtensionConfiguration getConfiguration() {
		return configuration;
	}
}

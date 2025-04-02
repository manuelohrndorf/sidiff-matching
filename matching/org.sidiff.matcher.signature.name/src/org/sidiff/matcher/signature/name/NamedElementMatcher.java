package org.sidiff.matcher.signature.name;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.configuration.IConfigurable;
import org.sidiff.matcher.LocalSignatureMatcher;

public class NamedElementMatcher extends LocalSignatureMatcher implements IConfigurable {	
	
	protected Map<String, Object> configuration;
	
	public NamedElementMatcher() {
		this.configuration = new HashMap<String, Object>();
		this.configuration.put("Allow Ambiguous Names", super.allowsAmbiguousSignature());
		this.configuration.put("Use Qualified Names", false);
		this.configuration.put("toString() Signature for Unnamed Elements", false);
	}
	
	@Override
	protected String getElementSignature(EObject element) {
		boolean useQualifiedNames = (Boolean) getConfigurationOptions().get("Use Qualified Names");
		boolean matchUnnamedElements = (Boolean) getConfigurationOptions().get("toString() Signature for Unnamed Elements");

		if (useQualifiedNames) {
			return deriveQualifiedName(element, matchUnnamedElements);
		} else {
			return getLabelSignature(element, matchUnnamedElements);
		}
	}
	
	private String getLabelSignature(EObject element, boolean matchUnnamedElements) {
		
		EStructuralFeature nameFeature = element.eClass().getEStructuralFeature("name");
		
		if (nameFeature != null) {
			Object nameValue = element.eGet(nameFeature);
			
			if (nameValue != null && nameValue instanceof String && !((String)nameValue).isEmpty()) {
				return (String) nameValue;
			}
		}
		
		// No name found:
		if (matchUnnamedElements) {
			// Remove Object ID if present:
			return element.toString().replaceFirst("@.*?\\s", "");
		}
		
		return null;
	}
	
	private String deriveQualifiedName(EObject element, boolean matchUnnamedElements){
		String elementName = getLabelSignature(element, matchUnnamedElements);

		while (elementName != null && element.eContainer() != null){
			element = element.eContainer();
			String containerName = getLabelSignature(element, matchUnnamedElements);
			
			if (containerName != null) {
				elementName = containerName + "." + elementName;
			} else {
				elementName = null;
			}
		}

		return elementName;
	}
	
	@Override
	public void configure(Map<String, Object> config) {
		this.configuration = config;
	}
	
	@Override
	public void setConfigurationOption(String key, Object value) {
		this.configuration.put(key, value);
	}
	
	@Override
	public Map<String, Object> getConfigurationOptions() {
		return this.configuration;
	}

	@Override
	protected boolean considerCandidatesOnly() {
		return true;
	}
	
	@Override
	protected boolean allowsAmbiguousSignature() {
		return (Boolean) this.configuration.get("Allow Ambiguous Names");
	}
	
	@Override
	public String getDescription() {
		return "This matching service matches the elements by the element name";
	}

	@Override
	public String getName() {
		return "Named Element Matcher";
	}
	
	@Override
	public String getKey(){
		return getClass().getName();
	}
}

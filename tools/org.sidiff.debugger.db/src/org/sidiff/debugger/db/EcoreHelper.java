package org.sidiff.debugger.db;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.pipeline.difference.model.Congruence;
import org.sidiff.pipeline.difference.model.Divergence;

public class EcoreHelper {
	
	private static final String NAME_REGEX = ".*name.*";
	private static final String ID_REGEX = ".*id.*";
	private static final String PATH_REGEX = ".*path.*";
	private static final String RETURN_PATTERN = "(%s) %s";

	/**
	 * Returns the value of an object's feature
	 * @param a model element
	 * @param featureName
	 * @return value of a feature
	 */
	public static String getAffectedFeatureValue(EObject eObject) {
		if(eObject == null){
			return "";
		}
		
		// Determine Symbol for Object
		EClass eclazz = eObject.eClass();
		
		EAttribute idAttribute = eclazz.getEIDAttribute();
		
		if(idAttribute != null){
			return String.format(RETURN_PATTERN, "ID:", eObject.eGet(idAttribute));
		}
		
		for(EAttribute attribute : eclazz.getEAllAttributes()){
			if(attribute.getEType().equals(EcorePackage.eINSTANCE.getEString())){
				String name = attribute.getName();
				Matcher nameMatcher = Pattern.compile(NAME_REGEX, Pattern.CASE_INSENSITIVE).matcher(name);
				
				if(nameMatcher.matches()){
					return String.format(RETURN_PATTERN, "Name", eObject.eGet(attribute));
				}
				
				Matcher idMatcher = Pattern.compile(ID_REGEX, Pattern.CASE_INSENSITIVE).matcher(name);
				if(idMatcher.matches()){
					return String.format(RETURN_PATTERN, "ID", eObject.eGet(attribute));
				}
			}
		}
		
		AnnotateableElement element = EMFAdapter.INSTANCE.adapt(eObject, AnnotateableElement.class);
		for(String key : element.getAnnotations()){
			Matcher nameMatcher = Pattern.compile(NAME_REGEX, Pattern.CASE_INSENSITIVE).matcher(key);
			
			if(nameMatcher.matches()){
				return String.format(RETURN_PATTERN, "Name", element.getAnnotation(key, Object.class));
			}
			
			Matcher idMatcher = Pattern.compile(ID_REGEX, Pattern.CASE_INSENSITIVE).matcher(key);
			if(idMatcher.matches()){
				return String.format(RETURN_PATTERN, "ID", element.getAnnotation(key, Object.class));
			}
			
			Matcher pathMatcher = Pattern.compile(PATH_REGEX, Pattern.CASE_INSENSITIVE).matcher(key);
			if(pathMatcher.matches()){
				return String.format(RETURN_PATTERN, "Path", element.getAnnotation(key, Object.class));
			}
		}
		
		return String.format(RETURN_PATTERN, "EcoreID", EMFUtil.getEObjectID(eObject));
	}

	/**
	 * Returns the name of the feature, which has or has not been modified
	 * @param model element
	 * @return featureName
	 */
	public static String getAffectedFeatureName(EObject object) {
		
		EObject eType = null;
		
		eType = getEObjectByFeatureName(object, "eAttribute");
		
		if(eType==null) {
			eType = getEObjectByFeatureName(object, "eReference");
		}
		
		EStructuralFeature nameFeature = eType.eClass().getEStructuralFeature("name");
		
		return eType.eGet(nameFeature).toString();
		
	}
	/**
	 * This method is merely used to find out if the containerObject has a specific feature.
	 * @param containerObject
	 * @param featureName
	 * @return
	 */
	public static EObject getEObjectByFeatureName(EObject containerObject, String featureName) {
		EObject eObject = null;
		if (containerObject instanceof Divergence) {
			try {
				EStructuralFeature feature = ((Divergence) containerObject).eClass().getEStructuralFeature(featureName);
				eObject = (EObject) containerObject.eGet(feature);
			} catch (NullPointerException npe) {
				return null;
			}
		} else if (containerObject instanceof Congruence) {
			try {
				EStructuralFeature feature = ((Congruence) containerObject).eClass().getEStructuralFeature(featureName);
				eObject = (EObject) containerObject.eGet(feature);
			} catch (NullPointerException npe) {
				return null;
			}
		}		
		
		return eObject;
	}

}

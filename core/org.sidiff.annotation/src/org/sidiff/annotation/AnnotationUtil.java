package org.sidiff.annotation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class AnnotationUtil {

	private static IAnnotation instance = null;

	public static Set<IAnnotation> getAvailableAnnotationServices() {
		Set<IAnnotation> annotationServices = new HashSet<IAnnotation>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				IAnnotation.EXTENSION_POINT_ID)) {
			try {
				IAnnotation annotationServiceExtension = (IAnnotation) configurationElement
						.createExecutableExtension("class");
				annotationServices.add(annotationServiceExtension);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return annotationServices;
	}

	public static IAnnotation getAnnotationService(String annotationServiceID) {
		IAnnotation result = null;
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				IAnnotation.EXTENSION_POINT_ID)) {
			try {
				IAnnotation annotationServiceExtension = (IAnnotation) configurationElement
						.createExecutableExtension("class");
				if (annotationServiceExtension.getServiceID().equals(annotationServiceID)) {
					return annotationServiceExtension;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void setAnnotationServiceInstance(IAnnotation asi) {
		instance = asi;
	}

	public static IAnnotation getAnnotationServiceInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = getAvailableAnnotationServices().iterator().next();
		}
		return instance;
	}

}

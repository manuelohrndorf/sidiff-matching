package org.sidiff.annotator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;

public class AnnotatorUtil {
	public static Set<IAnnotator> getAvailableAnnotators(EClass acceptedType) {
		Set<IAnnotator> annotators = new HashSet<IAnnotator>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IAnnotator.EXTENSION_POINT_ID)) {
			try {
				IAnnotator annotatorExtension = (IAnnotator) configurationElement.createExecutableExtension("class");
				if (annotatorExtension.getType().equals(acceptedType)) {
					annotators.add(annotatorExtension);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return annotators;
	}

	public static Set<IAnnotator> getAvailableAnnotators() {
		Set<IAnnotator> annotators = new HashSet<IAnnotator>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IAnnotator.EXTENSION_POINT_ID)) {
			try {
				IAnnotator annotatorExtension = (IAnnotator) configurationElement.createExecutableExtension("class");
				annotators.add(annotatorExtension);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return annotators;
	}

	public static IAnnotator getAvailableAnnotator(String annotatorID) {
		IAnnotator annotator = null;

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IAnnotator.EXTENSION_POINT_ID)) {
			try {

				IAnnotator annotatortmp = (IAnnotator) configurationElement.createExecutableExtension("class");
				if (annotatortmp.getAnnotatorID().trim().equals(annotatorID.trim())) {
					annotator = annotatortmp;
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return annotator;
	}

}

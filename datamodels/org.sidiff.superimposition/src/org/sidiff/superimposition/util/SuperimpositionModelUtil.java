package org.sidiff.superimposition.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.entities.Annotation;
import org.sidiff.superimposition.SuperimposedElement;

/**
 * Utility functions for the Superimposition Model.
 * @author rmueller
 */
public class SuperimpositionModelUtil {

	private SuperimpositionModelUtil() {
		throw new AssertionError();
	}

	/**
	 * Returns whether an element has the given direct or indirect container element or is equal to it.
	 * @param someElement the element to check
	 * @param containerToFind the container element to find
	 * @return <code>true</code> if the element or any of its containers is equal to given container, <code>false</code> otherwise
	 */
	public static boolean isElementContainedIn(SuperimposedElement someElement, SuperimposedElement containerToFind) {
		SuperimposedElement container = someElement;
		while(container != null) {
			if(container == containerToFind) {
				return true;
			}
			container = container.getContainer();
		}
		return false;
	}

	public static void annotateElement(EObject eObject, Annotation annotation, SuperimposedElement element) {
		if(!element.getAnnotations().contains(annotation)) {
			element.getAnnotations().add(annotation);			
		}
		EList<Annotation> objAnnotations = element.getObjectAnnotations().get(eObject);
		if(objAnnotations == null) {
			objAnnotations = new UniqueEList<>();
			objAnnotations.add(annotation);
			element.getObjectAnnotations().put(eObject, objAnnotations);
		} else {
			objAnnotations.add(annotation);			
		}
	}
}

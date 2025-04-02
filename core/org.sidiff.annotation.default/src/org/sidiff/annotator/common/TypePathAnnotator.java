package org.sidiff.annotator.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * This annotator computes the path of an object. The path is computed by
 * concatenation of the types of the objects (from root) to the annotated
 * object.
 */
public class TypePathAnnotator extends AbstractPathAnnotator {

	private static final String ANNOTATOR_ID = "TypePathAnnotator";

	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {
		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations);
		if (getParameter() != null) {
			throw new IllegalArgumentException("Not parameter expected! (" + getParameter() + ")");
		}
	}

	@Override
	protected String getPathSegment(EObject object) {

		return object.eClass().getName();
	}

	@Override
	public String getAnnotatorID() {
		return ANNOTATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This annotator computes the path of an object. The path is computed by"
				+ " concatenation of the types of the objects (from root) to the annotated object.;";
	}
}

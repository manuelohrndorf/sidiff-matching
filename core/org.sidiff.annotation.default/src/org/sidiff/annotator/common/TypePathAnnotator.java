package org.sidiff.annotator.common;

import java.util.Collection;
import java.util.Optional;

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

	@Override
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
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This annotator computes the path of an object. The path is computed by"
				+ " concatenation of the types of the objects (from root) to the annotated object.;");
	}
}

package org.sidiff.annotator.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;

public class AnnotationPathAnnotator extends AbstractPathAnnotator {

	private final static String MISSING_ANNOTATION = "**MissingData**";
	private static final String ANNOTATOR_ID = "AnnotationPathAnnotator";

	private String annotationKey = null;

	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {
		super.init(documentType, annotationKey, parameter, acceptedType,
				Annotator.addAdditionalRequirements(requiredAnnotations, parameter));

		if (getParameter() != null) {
			this.annotationKey = getParameter();
		} else {
			throw new IllegalAccessError(acceptedType.getName() + " does not contain a Attribute named '"
					+ getParameter() + "'");
		}
	}

	@Override
	protected String getPathSegment(EObject object) {
		String value = null;
		AnnotateableElement ao = EMFAdapter.INSTANCE.adapt(object, AnnotateableElement.class);
		if (ao.hasAnnotation(annotationKey)) {
			value = ao.getAnnotation(annotationKey, String.class);
		} else {
			value = MISSING_ANNOTATION;
		}
		return value;
	}
	
	@Override
	public String getAnnotatorID() {
		return ANNOTATOR_ID;
	}

	@Override
	public String getDescription() {
		return "AnnotationPathAnnotator";
	}
}

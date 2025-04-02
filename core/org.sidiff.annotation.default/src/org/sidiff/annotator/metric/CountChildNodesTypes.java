package org.sidiff.annotator.metric;

import java.util.Collection;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;

/**
 * Zaehlt Kind-Elemente eines bestimmten Typs (Parameter 1).
 * 
 * @author wenzel
 *
 */
public class CountChildNodesTypes extends Annotator {

	private static final String ANNOTATOR_ID = "CountChildNodesTypes";

	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		EClass cls = (EClass) EMFMetaAccess.getMetaObjectByName(getDocumentType().getNsURI(), this.getParameter());
		if (cls == null)
			return 0f;
		return new Float(EMFModelAccess.getChildren(object, cls).size());
	}

	@Override
	public String getAnnotatorID() {
		return ANNOTATOR_ID;
	}

	@Override
	public String getDescription() {
		return "Zaehlt Kind-Elemente eines bestimmten Typs (Parameter 1).";
	}
}

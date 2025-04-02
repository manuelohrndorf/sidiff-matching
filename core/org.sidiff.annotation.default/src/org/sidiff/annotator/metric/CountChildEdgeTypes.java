package org.sidiff.annotator.metric;

import java.util.Collection;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.access.EMFModelAccess;

/**
 * Zaehlt die Kind-Elemente, die ueber eine bestimmte Referenz erreicht werden.
 * 
 * @author wenzel
 *
 */
public class CountChildEdgeTypes extends Annotator {

	private static final String ANNOTATOR_ID = "CountChildEdgeTypes";

	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		EReference ref = (EReference) object.eClass().getEStructuralFeature(this.getParameter());
		return new Float(EMFModelAccess.getChildren(object, ref).size());
	}

	@Override
	public String getAnnotatorID() {
		return ANNOTATOR_ID;
	}

	@Override
	public String getDescription() {
		return "Zaehlt die Kind-Elemente, die ueber eine bestimmte Referenz erreicht werden.";
	}
}

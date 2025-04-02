package org.sidiff.annotator.metric;

import java.util.Collection;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;

/**
 * Zaehlt die Elemente, die ueber eine bestimmte Referenz (Parameter 1) erreicht
 * werden.
 * 
 * @author wenzel
 *
 */
public class CountReferences extends Annotator {

	private static final String ANNOTATOR_ID = "CountReferences";

	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		return new Float(EMFModelAccess.getNodeNeighbors(object,
				EMFMetaAccess.getReferencesByNames(object.eClass(), this.getParameter()).toArray(new EReference[] {}))
				.size());
	}

	@Override
	public String getAnnotatorID() {
		return ANNOTATOR_ID;
	}

	@Override
	public String getDescription() {
		return "Zaehlt die Elemente, die ueber eine bestimmte Referenz (Parameter 1) erreichtwerden.";
	}
}
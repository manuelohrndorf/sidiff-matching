package org.sidiff.annotator.metric;

import java.util.Collection;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;

/**
 * Zeahlt die Elemente, die ueber einen gegebenen Pfad (Parameter 1) erreicht
 * werden.
 * 
 * @author wenzel
 *
 */
public class CountTargets extends Annotator {

	private static final String ANNOTATOR_ID = "CountTargets";

	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		return new Float(EMFModelAccess.evaluatePath(object,
				EMFMetaAccess.translatePath(object.eClass(), this.getParameter())).size());
	}

	@Override
	public String getAnnotatorID() {
		return ANNOTATOR_ID;
	}

	@Override
	public String getDescription() {
		return "Zeahlt die Elemente, die ueber einen gegebenen Pfad (Parameter 1) erreicht werden.";
	}

}
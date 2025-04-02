package org.sidiff.annotator.metric;

import java.util.Collection;
import java.util.Optional;

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

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		return (float)EMFModelAccess.evaluatePath(object,
				EMFMetaAccess.translatePath(object.eClass(), this.getParameter())).size();
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Zeahlt die Elemente, die ueber einen gegebenen Pfad (Parameter 1) erreicht werden.");
	}

}
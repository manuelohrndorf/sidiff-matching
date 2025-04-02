package org.sidiff.annotator.metric;

import java.util.Collection;
import java.util.Optional;

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

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		EClass cls = (EClass) EMFMetaAccess.getMetaObjectByName(getDocumentType().getNsURI(), this.getParameter());
		if (cls == null)
			return 0f;
		return EMFModelAccess.getChildren(object, cls).size();
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Zaehlt Kind-Elemente eines bestimmten Typs (Parameter 1).");
	}
}

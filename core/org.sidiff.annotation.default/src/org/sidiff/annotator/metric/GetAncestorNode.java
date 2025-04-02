package org.sidiff.annotator.metric;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.EMFUtil;

/**
 * Dieser Annotator durchlaeuft die Container eines Elements solange bis ein
 * Element eines bestimmten Typs (Parameter 1) gefunden wird und setzt dieses
 * Element als Annotation.
 * 
 * @author wenzel
 *
 */
public class GetAncestorNode extends Annotator {

	private static final String ANNOTATOR_ID = "GetAncestorNode";

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		while (object != null && !EMFUtil.getModelRelativeName(object.eClass()).equals(this.getParameter())) {
			object = object.eContainer();
		}
		if (object != null && EMFUtil.getModelRelativeName(object.eClass()).equals(this.getParameter())) {
			return object;
		}
		return null;
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Dieser Annotator durchlaeuft die Container eines Elements solange bis ein "
				+ "Element eines bestimmten Typs (Parameter 1) gefunden wird und setzt dieses "
				+ "Element als Annotation.");
	}

}

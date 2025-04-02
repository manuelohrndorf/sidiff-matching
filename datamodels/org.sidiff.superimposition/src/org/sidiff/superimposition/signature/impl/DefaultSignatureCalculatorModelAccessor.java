package org.sidiff.superimposition.signature.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.*;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.*;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.signature.ISignatureCalculator.IModelAccessor;

/**
 * @author rmueller
 */
public class DefaultSignatureCalculatorModelAccessor implements IModelAccessor {

	@Override
	public String getSignatureName(EObject eObject) {
		if (eObject instanceof Entity) {
			final String signature = ((Entity)eObject).getSignature();
			final int nameBegin = signature.lastIndexOf(".");
			return nameBegin == -1 ? signature : signature.substring(nameBegin);
		}
		return EMFUtil.getEObjectSignatureName(eObject);
	}

	@Override
	public EObject getContainer(EObject eObject) {
		if (eObject instanceof SuperimposedElement) {
			return ((SuperimposedElement)eObject).getContainer();
		}
		return eObject.eContainer();
	}

	@Override
	public List<EObject> getReferenceTargets(EObject eObject, EReference reference) {
		if (eObject instanceof Element) {
			return ((Element)eObject).getReferences(reference).stream().map(Reference::getTarget).collect(Collectors.toList());
		}
		return EMFUtil.getReferenceTargets(eObject, reference);
	}

	@Override
	public EClass getType(EObject eObject) {
		if (eObject instanceof Element) {
			return ((Element)eObject).getType();
		}
		return eObject.eClass();
	}
}

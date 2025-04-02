package org.sidiff.superimposition.signature.impl;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.entities.Element;
import org.sidiff.superimposition.signature.ISignatureCalculator;

/**
 * Default {@link ISignatureCalculator} using the qualified name of an {@link EObject},
 * using the existing signature of {@link Element}s.
 *
 * @author cpietsch
 * @author rmueller
 */
public class DefaultSignatureCalculator implements ISignatureCalculator {

	@Override
	public String calculateSignature(EObject eObject, IModelAccessor modelAccessor, IDelegator delegator) {
		if (eObject instanceof Element) {
			return ((Element)eObject).getSignature();
		}
		String name = modelAccessor.getSignatureName(eObject);
		EObject container = modelAccessor.getContainer(eObject);
		if(container != null) {
			return calculateSignature(container, modelAccessor, delegator) + "." + name;
		}
		return name;
	}

	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}

	@Override
	public String getName() {
		return "Default Signature Calculator";
	}
}

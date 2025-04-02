package org.sidiff.superimposition.importer;

import java.util.*;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.entities.Element;
import org.sidiff.entities.importer.signature.AbstractImporterSignatureResolver;

/**
 * @author rmueller
 */
public class SuperimpositionModelImporterSignatureResolver extends AbstractImporterSignatureResolver {

	private Function<EObject,String> signatureCalculation;
	private Set<Element> elementsBeingComputed = new HashSet<>();

	public SuperimpositionModelImporterSignatureResolver(Function<EObject,String> signatureCalculation) {
		this.signatureCalculation = Objects.requireNonNull(signatureCalculation);
	}

	@Override
	public String computeSignature(Element element) {
		// Remember the elements for which the signature calculators are currently
		// computing the signatures, in order to prevent stack overflows when a
		// signature calculator directly/indirectly imports new elements.
		if (elementsBeingComputed.add(element)) {
			try {
				return signatureCalculation.apply(element.getObject());
			} finally {
				elementsBeingComputed.remove(element);
			}
		}
		return element.getSignature();
	}
}

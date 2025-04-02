package org.sidiff.entities.importer.signature;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.Element;

/**
 * Name based importer signature resolver that extends the
 * {@link AbstractImporterSignatureResolver} and computes
 * the signature of elements by using the name of the object
 * as well as those of all of it's containers.
 * @author rmueller
 */
public class DefaultImporterSignatureResolver extends AbstractImporterSignatureResolver {

	@Override
	public String computeSignature(Element element) {
		return computeEObjectSignature(element.getObject());
	}

	protected String computeEObjectSignature(EObject object) {
		String name = EMFUtil.getEObjectSignatureName(object);
		if(object.eContainer() != null) {
			return computeEObjectSignature(object.eContainer()) + "." + name;
		}
		return name;
	}
}

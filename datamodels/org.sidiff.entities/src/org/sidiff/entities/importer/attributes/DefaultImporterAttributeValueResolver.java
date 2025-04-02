package org.sidiff.entities.importer.attributes;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;

/**
 * The default importer attribute value resolver obtains the
 * attribute values using {@link EObject#eGet(EStructuralFeature)}
 * and uses the factory to convert them to strings.
 * @author rmueller
 */
public class DefaultImporterAttributeValueResolver implements IImporterAttributeValueResolver {

	@Override
	public List<String> resolveValues(EObject eObject, EAttribute eAttribute) {
		return EMFUtil.getAttributeValues(eObject, eAttribute).stream()
			.map(value -> EcoreUtil.convertToString(eAttribute.getEAttributeType(), value))
			.collect(Collectors.toList());
	}
}

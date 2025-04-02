package org.sidiff.entities.importer.attributes;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

/**
 * The importer attribute value resolver resolves the values
 * of an imported attribute.
 * @author rmueller
 */
public interface IImporterAttributeValueResolver {

	/**
	 * Returns the values of the attribute of the object.
	 * @param eObject the imported object
	 * @param eAttribute the attribute of the imported object
	 * @return list of attribute values, empty if none
	 */
	List<String> resolveValues(EObject eObject, EAttribute eAttribute);
}

package org.sidiff.entities.importer.type;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * A generic importer type resolver that uses the
 * imported object's meta class ({@link EObject#eClass()}).
 * @author rmueller
 */
public class GenericImporterTypeResolver implements IImporterTypeResolver {

	@Override
	public EClass resolveType(EObject object) {
		return object.eClass();
	}
}

package org.sidiff.entities.importer.type;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * The importer type resolver resolves the type
 * ({@link EClass}) of an imported {@link EObject}.
 * @author rmueller
 */
public interface IImporterTypeResolver {

	/**
	 * Returns the type of the given object.
	 * @param object the object being imported
	 * @return the type for the created element
	 */
	EClass resolveType(EObject object);
}

package org.sidiff.entities.importer.uuid;

import java.util.Collection;

import org.sidiff.entities.IdentifiableEntity;

/**
 * The importer UUID resolver resolves UUIDs for all identifiable entities.
 * 
 * @author rmueller, cpietsch
 */
public interface IImporterUuidResolver {

	/**
	 * Optional method for initializing the {@link IImporterUuidResolver}, e.g., for
	 * passing further arguments that may be used by
	 * {@link #computeUuid(IdentifiableEntity)}.
	 * 
	 * @param object
	 */
	default void init(Collection<Object> arguments) {
		// default - nothing to do
	}

	/**
	 * Computes and returns a UUID for the identifiable entity.
	 * 
	 * @param entity the identifiable entity
	 * @return UUID
	 */
	String computeUuid(IdentifiableEntity entity);
}

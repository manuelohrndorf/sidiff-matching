package org.sidiff.entities.importer.signature;

import org.sidiff.entities.Entity;

/**
 * The importer signature resolver resolves signatures
 * for the imported entities.
 * @author rmueller
 */
public interface IImporterSignatureResolver {

	/**
	 * Computes and returns a signature for the entity.
	 * @param entity the entity
	 * @return signature
	 */
	String computeSignature(Entity entity);
}

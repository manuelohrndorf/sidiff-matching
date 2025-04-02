package org.sidiff.entities.importer.uuid;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.entities.IdentifiableEntity;

/**
 * Importer UUID resolver that always generates new UUIDs.
 * @author rmueller
 */
public class GeneratingImporterUuidResolver implements IImporterUuidResolver {

	@Override
	public String computeUuid(IdentifiableEntity entity) {
		return EcoreUtil.generateUUID();
	}
}

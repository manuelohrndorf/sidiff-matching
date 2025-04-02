package org.sidiff.entities.exporter.filter;

import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;

/**
 * The exporter filter returns for an entity,
 * whether it should be exported.
 * @author rmueller
 */
public interface IExporterFilter {

	/**
	 * Returns whether the entity should be exported.
	 * @param entity the entity
	 * @return <code>true</code> to export, <code>false</code> to skip
	 */
	boolean isExported(Entity entity);

	/**
	 * Returns whether the outgoing reference should be followed
	 * during the export, i.e. if the target should also be exported.
	 * @param reference the outgoing reference
	 * @return <code>true</code> to follow, <code>false</code> otherwise
	 */
	boolean followOutgoing(Reference reference);

	/**
	 * Returns whether the incoming reference should be followed
	 * during the export, i.e. if the source should also be exported.
	 * @param reference the incoming reference
	 * @return <code>true</code> to follow, <code>false</code> otherwise
	 */
	boolean followIncoming(Reference reference);
}

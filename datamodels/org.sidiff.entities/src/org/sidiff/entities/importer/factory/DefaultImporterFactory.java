package org.sidiff.entities.importer.factory;

import org.sidiff.entities.Element;
import org.sidiff.entities.EntitiesFactory;

/**
 * Default importer factory that uses the default
 * {@link Element}, {@link Reference} and {@link Attribute} types.
 * @author rmueller
 */
public class DefaultImporterFactory extends AbstractImporterFactory<Element> {

	@Override
	public Element createElement() {
		return EntitiesFactory.eINSTANCE.createElement();
	}
}
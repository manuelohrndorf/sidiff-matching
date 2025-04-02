package org.sidiff.entities.importer.factory;

import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.EntitiesFactory;
import org.sidiff.entities.Reference;

/**
 * Abstract importer factory that uses the default
 * {@link Reference} and {@link Attribute} types.
 * @param <E> the type of the {@link Element}s
 * @author rmueller
 */
public abstract class AbstractImporterFactory<E extends Element> implements IImporterFactory<E,Reference,Attribute> {

	@Override
	public Reference createReference() {
		return EntitiesFactory.eINSTANCE.createReference();
	}

	@Override
	public Attribute createAttribute() {
		return EntitiesFactory.eINSTANCE.createAttribute();
	}
}
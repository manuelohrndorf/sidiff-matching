package org.sidiff.entities.importer.factory;

import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;

/**
 * The importer factory creates elements, references and attributes for the importer.
 * @param <E> the type of the {@link Element}s
 * @param <R> the type of the {@link Reference}s
 * @param <A> the type of the {@link Attribute}s
 * @author rmueller
 */
public interface IImporterFactory<E extends Element, R extends Reference, A extends Attribute> {

	/**
	 * Creates a new {@link Element}.
	 * @return new Element
	 */
	E createElement();

	/**
	 * Creates a new {@link Reference}.
	 * @return new Reference
	 */
	R createReference();

	/**
	 * Creates a new {@link Attribute}.
	 * @return new Attribute
	 */
	A createAttribute();
}
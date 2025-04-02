package org.sidiff.entities.importer.visitor;

import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.entities.importer.visitor.internal.NullImporterVisitor;

/**
 * The importer visitor visits entities during recursive import.
 * @param <E> the type of the {@link Element}s
 * @param <R> the type of the {@link Reference}s
 * @param <A> the type of the {@link Attribute}s
 * @author rmueller
 */
public interface IImporterVisitor<E extends Element, R extends Reference, A extends Attribute> {

	void visitElement(E element);
	void visitReference(R reference);
	void visitAttribute(A attribute);

	/**
	 * A singleton visitor that does nothing.
	 */
	IImporterVisitor<Element,Reference,Attribute> NULL = new NullImporterVisitor();
}

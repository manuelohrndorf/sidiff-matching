package org.sidiff.entities.importer.visitor;

import java.util.Objects;

import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;

/**
 * A importer visitor that can delegate calls to another visitor.
 * @param <E> the type of the {@link Element}s
 * @param <R> the type of the {@link Reference}s
 * @param <A> the type of the {@link Attribute}s
 * @author rmueller
 */
public class DelegatingImporterVisitor<E extends Element, R extends Reference, A extends Attribute> implements IImporterVisitor<E,R,A>{

	private IImporterVisitor<? super E, ? super R, ? super A> delegate;

	public DelegatingImporterVisitor(IImporterVisitor<? super E, ? super R, ? super A> delegate) {
		setDelegate(delegate);
	}

	@Override
	public void visitElement(E element) {
		getDelegate().visitElement(element);
	}

	@Override
	public void visitReference(R reference) {
		getDelegate().visitReference(reference);
	}

	@Override
	public void visitAttribute(A attribute) {
		getDelegate().visitAttribute(attribute);
	}

	public void setDelegate(IImporterVisitor<? super E, ? super R, ? super A> delegate) {
		this.delegate = Objects.requireNonNull(delegate);
	}

	public IImporterVisitor<? super E, ? super R, ? super A> getDelegate() {
		return delegate;
	}
}

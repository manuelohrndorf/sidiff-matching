package org.sidiff.entities.importer.visitor.internal;

import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.entities.importer.visitor.IImporterVisitor;

/**
 * <p>A importer visitor that does nothing.</p>
 * <p>Only for internal use only. Use the singleton {@link IImporterVisitor#NULL} instead.</p>
 * @author rmueller
 */
public final class NullImporterVisitor implements IImporterVisitor<Element, Reference, Attribute> {

	@Override
	public void visitElement(Element element) {
		// nothing
	}
	@Override
	public void visitReference(Reference reference) {
		// nothing
	}
	@Override
	public void visitAttribute(Attribute attribute) {
		// nothing
	}
}
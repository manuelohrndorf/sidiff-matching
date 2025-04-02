package org.sidiff.entities.importer.visitor;

import org.sidiff.entities.Annotation;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;

/**
 * Importer visitor that attaches an annotation to all entities.
 * @author rmueller
 */
public class AnnotatingImporterVisitor implements IImporterVisitor<Element,Reference,Attribute> {

	private Annotation annotation;

	public AnnotatingImporterVisitor(Annotation annotation) {
		this.annotation = annotation;
	}

	@Override
	public void visitElement(Element element) {
		element.getAnnotations().add(annotation);
	}

	@Override
	public void visitReference(Reference reference) {
		reference.getAnnotations().add(annotation);
	}

	@Override
	public void visitAttribute(Attribute attribute) {
		attribute.getAnnotations().add(annotation);
	}

	public Annotation getAnnotation() {
		return annotation;
	}

	public void setAnnotation(Annotation annotation) {
		this.annotation = annotation;
	}
}

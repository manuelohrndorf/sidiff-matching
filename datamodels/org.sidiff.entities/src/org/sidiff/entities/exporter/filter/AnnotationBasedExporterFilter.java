package org.sidiff.entities.exporter.filter;

import java.util.Objects;

import org.sidiff.entities.Annotation;
import org.sidiff.entities.Entity;

/**
 * An exporter filter that selects only entities that are annotated
 * with a certain annotation. Note that the annotation is compared
 * with the default equals implementation, so the annotation instance
 * from the model must be used.
 * @author rmueller
 */
public class AnnotationBasedExporterFilter extends DefaultExporterFilter {

	private Annotation annotation;

	public AnnotationBasedExporterFilter(Annotation annotation) {
		this.annotation = Objects.requireNonNull(annotation);
	}

	@Override
	public boolean isExported(Entity entity) {
		return entity.getAnnotations().contains(annotation);
	}
}

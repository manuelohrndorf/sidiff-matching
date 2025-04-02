package org.sidiff.entities.exporter.annotations.filter;

import java.util.Collection;
import java.util.function.BiPredicate;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.entities.Annotation;

/**
 * @author Dennis Reuling
 * @author rmueller
 */
@FunctionalInterface
public interface IAnnotationsFilter extends BiPredicate<Collection<Annotation>,EObject> {

	/**
	 * Singleton filter that matches all annotations.
	 */
	IAnnotationsFilter MATCH_ALL = (annotations, context) -> true;
}

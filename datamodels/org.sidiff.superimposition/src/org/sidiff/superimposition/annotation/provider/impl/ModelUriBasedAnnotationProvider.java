package org.sidiff.superimposition.annotation.provider.impl;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.superimposition.annotation.provider.AbstractAnnotationProvider;

/**
 * @author rmueller
 */
public class ModelUriBasedAnnotationProvider extends AbstractAnnotationProvider {

	@Override
	public Set<Annotation> getAnnotations(Resource model) {
		return Collections.singleton(
				EntitiesUtil.createModelAnnotation(model.getURI().trimFileExtension().lastSegment()));
	}
}

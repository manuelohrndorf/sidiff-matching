package org.sidiff.superimposition.annotation.provider.impl;

import java.util.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.superimposition.annotation.provider.AbstractAnnotationProvider;

/**
 * Uses the model's filename without file extension as model annotation.
 * @author rmueller
 */
public class ModelUriBasedAnnotationProvider extends AbstractAnnotationProvider {

	@Override
	public Set<Annotation> getAnnotations(Collection<Resource> allModels, Resource currentModel) {
		return Collections.singleton(
				EntitiesUtil.createModelAnnotation(currentModel.getURI().trimFileExtension().lastSegment()));
	}
}

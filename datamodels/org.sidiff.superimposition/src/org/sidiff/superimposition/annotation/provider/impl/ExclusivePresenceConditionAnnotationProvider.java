package org.sidiff.superimposition.annotation.provider.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.superimposition.annotation.provider.AbstractAnnotationProvider;

/**
 * Creates C-style presence conditions assuming each model excludes all other models.
 * @author rmueller
 */
public class ExclusivePresenceConditionAnnotationProvider extends AbstractAnnotationProvider {

	@Override
	public Set<Annotation> getAnnotations(Collection<Resource> allModels, Resource currentModel) {
		String modelName = currentModel.getURI().trimFileExtension().lastSegment();
		return Collections.singleton(
			EntitiesUtil.createModelAnnotation(
				allModels.stream()
					.map(Resource::getURI)
					.map(URI::trimFileExtension)
					.map(URI::lastSegment)
					.map(segment -> segment.equals(modelName) ? modelName : "!" + segment)
					.collect(Collectors.joining(" && "))));
	}
}

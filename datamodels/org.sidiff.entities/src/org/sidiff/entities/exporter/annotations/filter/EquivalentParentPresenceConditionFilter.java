package org.sidiff.entities.exporter.annotations.filter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.entities.Annotation;

public class EquivalentParentPresenceConditionFilter implements IAnnotationsFilter {

	private Map<EObject,Collection<Annotation>> objectsToAnnotations;

	public EquivalentParentPresenceConditionFilter(Map<EObject,Collection<Annotation>> annotationsMap) {
		this.objectsToAnnotations = Objects.requireNonNull(annotationsMap);
	}

	@Override
	public boolean test(Collection<Annotation> t, EObject context) {
		EObject container = context.eContainer();
		if(container == null) {
			return true;			
		}

		Set<Annotation> difference = new HashSet<>(t);
		difference.removeAll(this.objectsToAnnotations.get(container));
		return !difference.isEmpty();
	}
}

package org.sidiff.entities.exporter.annotations.filter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.entities.Annotation;

public class CorePresenceConditionsAnnotationsFilter implements IAnnotationsFilter {

	private Set<Annotation> allAnnotationsSet;

	public CorePresenceConditionsAnnotationsFilter(Set<Annotation> allAnnotationsSet) {
		this.allAnnotationsSet = allAnnotationsSet;
	}

	@Override
	public boolean test(Collection<Annotation> t, EObject context) {
		Set<Annotation> difference = new HashSet<>(this.allAnnotationsSet);
		difference.removeAll(t);
		return !difference.isEmpty();
	}
}

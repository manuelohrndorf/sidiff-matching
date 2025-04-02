package org.sidiff.entities.exporter.annotations;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.extension.AbstractTypedExtension;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Element;
import org.sidiff.entities.exporter.annotations.filter.IAnnotationsFilter;

/**
 * @author dreuling
 * @author rmueller
 */
public abstract class AbstractAnnotationsExporter extends AbstractTypedExtension implements IAnnotationsExporter {

	private Collection<IAnnotationsFilter> filters = Collections.singleton(IAnnotationsFilter.MATCH_ALL);

	@Override
	public void exportAnnotations(Map<Element,EObject> exportedElements) {
		exportedElements.forEach(this::exportAnnotations);
	}

	protected void exportAnnotations(Element element, EObject eObject) {
		if(element.isExternal()) {
			return;			
		}

		Collection<Annotation> annotations = element.getAnnotations();
		for(IAnnotationsFilter filter : getFilters()) {
			if(!filter.test(annotations, eObject)) {
				return;				
			}
		}

		for(Annotation annotation : annotations) {
			annotateElement(annotation, eObject);
		}
	}

	protected abstract void annotateElement(Annotation annotation, EObject eObject);

	@Override
	public Collection<IAnnotationsFilter> getFilters() {
		return Collections.unmodifiableCollection(filters);
	}

	@Override
	public void setFilters(Collection<IAnnotationsFilter> filters) {
		this.filters = new HashSet<>(filters);
	}

	@Override
	public IExtensionConfiguration getConfiguration() {
		return IExtensionConfiguration.NULL;
	}
}

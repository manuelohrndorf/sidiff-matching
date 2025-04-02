package org.sidiff.entities.exporter.annotations;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.extension.AbstractTypedExtension;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.entities.Element;
import org.sidiff.entities.exporter.annotations.filter.IAnnotationsFilter;

/**
 * @author dreuling
 */
public class DiscardAnnotationsExporter extends AbstractTypedExtension implements IAnnotationsExporter {

	@Override
	public Collection<IAnnotationsFilter> getFilters() {
		return Collections.singleton(IAnnotationsFilter.MATCH_ALL);
	}

	@Override
	public void setFilters(Collection<IAnnotationsFilter> filters) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void exportAnnotations(Map<Element, EObject> exportedElements) {
		// do nothing
	}

	@Override
	public IExtensionConfiguration getConfiguration() {
		return IExtensionConfiguration.NULL;
	}
}

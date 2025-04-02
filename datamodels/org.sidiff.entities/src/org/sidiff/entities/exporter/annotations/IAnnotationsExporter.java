package org.sidiff.entities.exporter.annotations;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.extension.ITypedExtension;
import org.sidiff.common.extension.TypedExtensionManager;
import org.sidiff.common.extension.configuration.IConfigurableExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;
import org.sidiff.entities.Element;
import org.sidiff.entities.exporter.annotations.filter.IAnnotationsFilter;


/**
 * 
 * @author dreuling
 *
 */
public interface IAnnotationsExporter extends ITypedExtension, IConfigurableExtension {

	Description<IAnnotationsExporter> DESCRIPTION = Description.of(IAnnotationsExporter.class,
			"org.sidiff.entities.annotations_exporter", "exporter", "class");
	TypedExtensionManager<IAnnotationsExporter> MANAGER = new TypedExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

	void exportAnnotations(Map<Element,EObject> exportedElements);

	Collection<IAnnotationsFilter> getFilters();
	void setFilters(Collection<IAnnotationsFilter> filters);
}

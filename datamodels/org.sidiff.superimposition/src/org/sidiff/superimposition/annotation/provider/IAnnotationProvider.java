package org.sidiff.superimposition.annotation.provider;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.extension.ITypedExtension;
import org.sidiff.common.extension.TypedExtensionManager;
import org.sidiff.common.extension.configuration.IConfigurableExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;
import org.sidiff.entities.Annotation;

/**
 * @author rmueller
 */
public interface IAnnotationProvider extends ITypedExtension, IConfigurableExtension {

	Description<IAnnotationProvider> DESCRIPTION = Description.of(IAnnotationProvider.class,
			"org.sidiff.superimposition.annotationProviders", "annotationProvider", "class");
	TypedExtensionManager<IAnnotationProvider> MANAGER =
			new TypedExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

	Set<Annotation> getAnnotations(Collection<Resource> allModels, Resource currentModel);
}

package org.sidiff.annotation;

import java.io.IOException;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.configuration.IConfigurableExtension;

/**
 * this class is the interface service for an annotationservice. An
 * annotationsservice can be configured by a configuration. it calculate and
 * annotate the values for a given model.
 */
public interface IAnnotation extends IConfigurableExtension {

	Description<IAnnotation> DESCRIPTION = Description.of(IAnnotation.class, "org.sidiff.annotation.extensionpoint", "client", "class");

	ExtensionManager<IAnnotation> MANAGER = new ExtensionManager<>(DESCRIPTION);


	public void init(Resource model) throws IOException;
	
	public void reset();

	/**
	 * Annotates configured annotations to all elements of the given model.
	 * 
	 * @param model
	 *            Resource containing the Model.
	 */
	public void annotate(Resource model);

	/**
	 * Removes all annotations provided by the current service from the given
	 * model.
	 * 
	 * @param model
	 *            Resource containing the Model.
	 */
	public void removeAnnotations(Resource model);

	/**
	 * Annotates the given attribute to all elements of the given model. As a
	 * side effect, all required annotations keys are tried to annotate
	 * implicitly.
	 * 
	 * @param model
	 *            Resource containing the Model.
	 * @param keys
	 *            a set of configured annotation keys.
	 */
	public void annotate(Resource model, Set<String> keySet);

	/**
	 * Removes a set of annotations, provided by the current service from the
	 * given model.
	 * 
	 * @param keys
	 *            a set of configured annotation keys.
	 * @param model
	 *            Resource containing the Model.
	 */
	public void removeAnnotations(Resource model, Set<String> keySet);

	/**
	 * Annotates the given attribute to all elements of the given model.
	 * 
	 * @param model
	 *            Resource containing the Model.
	 * @param key
	 *            a configured annotation key.
	 */
	public void annotate(Resource model, String key);

	/**
	 * Removes all annotations from the given model.
	 * 
	 * @param model
	 */
	public void removeAnnotations(Resource model, String key);


	public Set<String> executedKeys(Resource model);

}

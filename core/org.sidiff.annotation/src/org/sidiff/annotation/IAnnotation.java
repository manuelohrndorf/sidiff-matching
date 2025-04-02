package org.sidiff.annotation;

import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.configuration.IConfigurationCapable;
import org.sidiff.service.IService;

/**
 * this class is the interface service for an annotationservice. An
 * annotationsservice can be configured by a configuration. it calculate and
 * annotate the values for a given model.
 */
public interface IAnnotation extends IService,IConfigurationCapable {

	public static final String EXTENSION_POINT_ID = "org.sidiff.annotation.extensionpoint";
	public static final String SERVICE_ID = "IAnnotation";
	
	public void init(Resource model);

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

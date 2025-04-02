package org.sidiff.annotator;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * this class defines an interface for an annotator. 
 *
 */
public interface IAnnotator {

	static final String EXTENSION_POINT_ID = "org.sidiff.annotator.extensionpoint";
	static final String ANNOTATOR_ID = "IAnnotator";

	void annotate(EObject object);

	public String getAnnotationKey();

	public EClass getType();

	public String getParameter();

	public ExecutionOrder getOrder();

	public Collection<String> getRequiredAnnotations();

	public enum ExecutionOrder {
		PRE, POST;
	}

	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations);

	public String getAnnotatorID();

	public String getDescription();

}

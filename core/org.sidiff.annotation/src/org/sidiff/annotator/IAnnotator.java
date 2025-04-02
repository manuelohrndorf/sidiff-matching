package org.sidiff.annotator;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;

/**
 * this class defines an interface for an annotator. 
 *
 */
public interface IAnnotator extends IExtension {

	Description<IAnnotator> DESCRIPTION = Description.of(IAnnotator.class,
			"org.sidiff.annotator.extensionpoint", "client", "class");
	ExtensionManager<IAnnotator> MANAGER = new ExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

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

}

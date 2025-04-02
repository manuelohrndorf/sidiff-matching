package org.sidiff.correspondences;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.configuration.IConfigurableExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;

public interface ICorrespondences extends IConfigurableExtension {

	Description<ICorrespondences> DESCRIPTION = Description.of(ICorrespondences.class,
			"org.sidiff.correspondences.extensionpoint", "correspondences", "class");
	ExtensionManager<ICorrespondences> MANAGER = new ExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));


	/**
	 * Creates a correspondence between the given elements.
	 *
	 * @param elements
	 * @throws Exception
	 */
	void addCorrespondence(EObject... elements);
	void addCorrespondence(List<? extends EObject> elements);

	/**
	 * Checks whether the given element has correspondences or not.
	 *
	 * @param element
	 * @return
	 * @throws Exception
	 */
	boolean hasCorrespondences(EObject element);

	/**
	 * Checks whether the given elements do correspond or not.
	 *
	 * @param elements
	 * @return
	 */
	boolean isCorresponding(EObject... elements);
	boolean isCorresponding(List<? extends EObject> elements);

	/**
	 * Returns all "other" elements of a correspondence. I.e. all
	 * correspondences except the given element.
	 *
	 * Returns an empty Collection, if the element has no correspondences.
	 *
	 * @param element
	 * @return
	 * @throws Exception
	 */
	Collection<EObject> getCorrespondences(EObject element);

	/**
	 * Returns all elements of the given model that have a correspondence
	 */
	Collection<EObject> getElementsWithCorrespondences(Resource model);

	/**
	 * Returns all elements of the given model that do not have a correspondence
	 */
	Collection<EObject> getElementsWithoutCorrespondences(Resource model);

	/**
	 * Removes the given correspondence
	 *
	 * @param elements
	 * @throws Exception
	 */
	void removeCorrespondence(EObject... elements);
	void removeCorrespondence(List<? extends EObject> elements);

	/**
	 * Removes element from correspondence
	 *
	 * @param element
	 * @throws Exception
	 */
	void removeFromCorrespondence(EObject element);

	void init(Collection<Resource> models);

	void reset();

	boolean canHandle(Collection<Resource> models);
}

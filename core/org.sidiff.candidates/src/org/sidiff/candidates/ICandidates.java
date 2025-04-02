package org.sidiff.candidates;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;

public interface ICandidates extends IExtension {
	
	Description<ICandidates> DESCRIPTION = Description.of(ICandidates.class,
			"org.sidiff.candidates.extensionpoint", "client", "class");
	
	ExtensionManager<ICandidates> MANAGER = new ExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

	/**
	 * Checks whether the given candidate object(s) is/are candidate(s) for each other
	 * 
	 * @param candidates
	 * @return
	 * @throws Exception
	 */
	public boolean isCandidate(EObject... candidates);
	public boolean isCandidate(Collection<EObject> candidates);

	/**
	 * Checks whether the given element has candidates. This is equal to the
	 * element being candidate for another element. (hasCandidates == true
	 * implies getCandidates().size() > 0)
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean hasCandidates(EObject element) throws Exception;

	/**
	 * Gets the list of candidates for an element.
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public Collection<EObject> getCandidates(EObject element);	
	
	/**
	 * Adds a candidate
	 * 
	 * @param candidate
	 * @return
	 */
	public void addCandidate(EObject candidate);
	
	/**
	 * Removes a candidate
	 * 
	 * @param candidate
	 * @return
	 */
	public void removeCandidate(EObject candidate);

	/**
	 * initialize the Service with the models
	 * 
	 * @param models
	 */
	void init(Collection<Resource> models);

	void reset();
	
}

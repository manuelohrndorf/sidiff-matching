package org.sidiff.comparators;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * Interface for the Comparators
 * @author vdueck
 *
 */
public interface IComparator extends IExtension {
	
	Description<IComparator> DESCRIPTION = Description.of(IComparator.class,
			"org.sidiff.comparators.extensionpoint", "client", "class");
	ExtensionManager<IComparator> MANAGER = new ExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

	void init(EClass dedicatedClass, EClass targetClass, String parameter, ICorrespondences correspondences, ISimilarities similarities);
	float compare(EObject contextElementA, EObject contextElementB, Object elementA, Object ElementB);
}

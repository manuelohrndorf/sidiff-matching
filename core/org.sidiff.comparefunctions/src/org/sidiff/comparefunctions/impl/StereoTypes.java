package org.sidiff.comparefunctions.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.collections.EMFComparators;
import org.sidiff.comparefunctions.exceptions.CompareException;

/**
 * Compare function for comparing two nodes' stereotypes This compare function
 * expects exactly one parameter fragment: The comparator that should be used to
 * compare the two collections "stereotypes of A" and "stereotypes of B".<br>
 * 
 * All types of comparators are allowed for this compare function.
 * 
 * @author Dennis Reuling
 */
public class StereoTypes extends AbstractComparatorCompareFunction {

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		List<EObject> toBeCompared = new ArrayList<>();
		for (EObject obj : CollectionUtil.asIterable(context.eResource().getAllContents())) {

			// Possible stereoType Class
			EClass stereoType = obj.eClass();

			// Check whether this stereotype has already been
			// added to the list. This is not allowed, as no element
			// shall be stereotyped by the same element type more than once.
			for (EObject eobj : toBeCompared) {
				if (eobj.equals(obj.eClass()))
					throw new CompareException("There shall be only on element of the same type added as stereotype!");
			}

			// Get all baseReferences of stereoType
			List<EStructuralFeature> allBaseReferences = EMFMetaAccess.getEStructuralFeaturesByRegEx(stereoType,
					"^(base)_\\w+", true);
			if (allBaseReferences.size() > 0) {
				for (EStructuralFeature baseReference : allBaseReferences) {

					EObject baseType = (EObject) obj.eGet(baseReference);
					// If found referenced type equals the context object
					// Add stereotype object to comparable objects
					if (baseType != null && baseType.equals(context)) {
						if (!toBeCompared.contains(obj))
							toBeCompared.add(obj);
					}

				}
			}

		}

		// Sort the List by type
		Collections.sort(toBeCompared, EMFComparators.EOBJECT_BY_TYPE);

		return toBeCompared;
	}

	@Override
	protected EClass getComparedType(EClass context) {
		return context;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Compare function for comparing two nodes' stereotypes. This compare function expects exactly one parameter fragment: "
				+ "The comparator that should be used to compare the two collections 'stereotypes of A' and 'stereotypes of B'");
	}
}

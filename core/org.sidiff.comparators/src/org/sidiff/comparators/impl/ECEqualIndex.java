package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;

/**
 * This comparator compares two object based on their class. The returned
 * similarity is<br>
 * <ul>
 * <li>1f in case the given objects have the same index in their container or
 * <li>0f in case the indices differ.
 * </ul>
 * No additional parameters are necessary to use this comparator.<br>
 * However, the optional parameter flag "includesize" forces a comparison of the
 * size of the container in which the compared element is contained.<br>
 * <br>
 * 
 * The following example-configuration shows how to use the ECEqualIndex
 * comparator to compare two Elements based on their index. In case they have
 * the same index, 1f is returned, 0f otherwise. <br>
 * <br>
 *
 * &lt;CompareFunction class="SelfCF" weight="1" parameter="ECEqualIndex"/&gt;
 * 
 * @author Sven Wenzel
 */
public class ECEqualIndex extends AbstractElementComparator {

	private String[] paramItems;

	@Override
	protected void init(String parameter) {
		this.paramItems = parameter == null ? null : NestedParameterUtil.getParameterSegments(parameter);
	}

	/**
	 * Compares two elements based on their index in their container. In case
	 * the indices are equal a similarity-value of 1f is returned, 0f otherwise.<br>
	 */
	@Override
	protected float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {

		if (EMFModelAccess.getIndexOf(elementA) == EMFModelAccess.getIndexOf(elementB)) {
			if (paramItems != null && paramItems[0].toLowerCase().equals("includesize")
					&& EMFModelAccess.getNumberOfSiblings(elementA) != EMFModelAccess.getNumberOfSiblings(elementB)) {
				return 0.0f;
			}
			return 1.0f;
		}
		return 0.0f;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator compares two object based on their class");
	}
}

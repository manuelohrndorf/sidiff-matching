package org.sidiff.entities.importer.filter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.common.emf.EMFUtil;

/**
 * The default importer filter, which excludes references and
 * attributes that are derived, transient, not changeable,
 * or (optionally) not set.
 * @author rmueller
 */
public class DefaultImporterFilter implements IImporterFilter {

	private final boolean checkIfSet;

	/**
	 * Creates a new default importer filter.
	 * @param checkIfSet <code>true</code> to consider only
	 * {@link EObject#eIsSet(EStructuralFeature) set} features, <code>false</code> otherwise
	 */
	public DefaultImporterFilter(boolean checkIfSet) {
		this.checkIfSet = checkIfSet;
	}

	@Override
	public boolean isConsidered(EObject eObject) {
		return !EMFUtil.isDynamic(eObject);
	}

	@Override
	public boolean isConsidered(EReference eReference, EObject eObject) {
		return !EMFUtil.isDynamic(eObject, eReference)
				&& (!checkIfSet || !EMFUtil.getReferenceTargets(eObject, eReference).isEmpty());
	}

	@Override
	public boolean isConsidered(EAttribute eAttribute, EObject eObject) {
		return !EMFUtil.isDynamic(eObject, eAttribute)
				&& (!checkIfSet || !EMFUtil.getAttributeValues(eObject, eAttribute).isEmpty());
	}
}
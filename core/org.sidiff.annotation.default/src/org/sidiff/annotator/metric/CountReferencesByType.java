package org.sidiff.annotator.metric;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.collections.EMFSelectors;

/**
 * Zaehlt die Elemente, die ueber eine bestimmte Referenz (Parameter 1) erreicht
 * werden und einen bestimmten Typ (Parameter 2) haben.
 * 
 * @author wenzel
 *
 */
public class CountReferencesByType extends Annotator {

	private static final String ANNOTATOR_ID = "CountReferencesByType";

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		String[] splitParameter = this.getParameter().split(",");
		EClass cls = (EClass) EMFMetaAccess.getMetaObjectByName(getDocumentType().getNsURI(), splitParameter[1]);
		if (cls == null)
			return 0f;

		EReference[] references = EMFMetaAccess.getReferencesByNames(object.eClass(), splitParameter[0]).toArray(new EReference[0]);
		return (float)EMFModelAccess.getNodeNeighbors(object, references)
				.stream().filter(EMFSelectors.byInstance(cls)).count();
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Zaehlt die Elemente, die ueber eine bestimmte Referenz (Parameter 1) erreicht "
				+ "werden und einen bestimmten Typ (Parameter 2) haben.");
	}
}
package org.sidiff.annotator.metric;

import java.util.Collection;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.collections.FilterUtil;
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

	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		EClass cls = (EClass) EMFMetaAccess.getMetaObjectByName(getDocumentType().getNsURI(),
				this.getParameter().split(",")[1]);
		if (cls == null)
			return 0f;

		return new Float(FilterUtil.filter(EMFModelAccess.getNodeNeighbors(object, EMFMetaAccess
				.getReferencesByNames(object.eClass(), this.getParameter().split(",")[0]).toArray(new EReference[] {})),
				true, EMFSelectors.byInstance(cls)).size());
	}

	@Override
	public String getAnnotatorID() {
		return ANNOTATOR_ID;
	}

	@Override
	public String getDescription() {
		return "Zaehlt die Elemente, die ueber eine bestimmte Referenz (Parameter 1) erreicht "
				+ "werden und einen bestimmten Typ (Parameter 2) haben.";
	}
}
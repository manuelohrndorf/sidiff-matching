package org.sidiff.annotator.metric;

import java.util.*;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.access.EMFModelAccess;

/**
 * Zaehlt Elemente, die ueber das aufeinanderfolgende Traversieren zweier
 * Referenzen (Parameter 1+2) erreicht werden, solange einen bestimmten Typ
 * (Parameter 3) haben.
 * 
 * @author wenzel
 *
 */
public class Count2StepNeighbourTypes extends Annotator {

	private static final String ANNOTATOR_ID = "Count2StepNeighbourTypes";
	private String firstReferenceString;
	private String secondReferenceString;
	private String classString;

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);

		StringTokenizer st = new StringTokenizer(parameter, ",");
		firstReferenceString = st.nextToken();
		secondReferenceString = st.nextToken();
		classString = st.nextToken();
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		float answer = 0f;
		EReference firstReference = (EReference) object.eClass().getEStructuralFeature(firstReferenceString);
		List<EObject> firstStep = EMFModelAccess.getNodeNeighbors(object, firstReference);
		for (EObject obj : firstStep) {
			EReference secondReference = (EReference) obj.eClass().getEStructuralFeature(secondReferenceString);
			List<EObject> secondStep = EMFModelAccess.getNodeNeighbors(obj, secondReference);
			for (EObject obj2 : secondStep) {
				if (EMFUtil.getModelRelativeName(obj2.eClass()).equals(classString))
					answer++;
			}
		}
		return answer;
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Zaehlt Elemente, die ueber das aufeinanderfolgende Traversieren zweier"
				+ " Referenzen (Parameter 1+2) erreicht werden, solange einen bestimmten Typ " + "(Parameter 3) haben.");
	}
}

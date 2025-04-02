package org.sidiff.annotator.metric;

import java.util.Collection;
import java.util.Optional;
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;

/**
 * Zaehlt Kind-Elemente eines bestimmten Typs (Parameter 1), deren Attribut
 * (Parameter 2) einen bestimmten Wert (Parameter 3) hat.
 * 
 * @author wenzel
 *
 */
public class CountChildNodesByValue extends Annotator {

	private static final String ANNOTATOR_ID = "CountChildNodesByValue";
	private String classString = null;
	private String attributeString = null;
	private String value = null;

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);

		StringTokenizer st = new StringTokenizer(parameter, ",");
		classString = st.nextToken();
		attributeString = st.nextToken();
		value = st.nextToken();
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		float answer = 0f;
		EClass cls = (EClass) EMFMetaAccess.getMetaObjectByName(getDocumentType().getNsURI(), classString);
		if (cls == null)
			return 0f;
		for (EObject child : EMFModelAccess.getChildren(object, cls)) {
			EAttribute attribute = (EAttribute) child.eClass().getEStructuralFeature(attributeString);
			if (attribute != null && value.equals(child.eGet(attribute).toString()))
				answer++;
		}
		return answer;
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Zaehlt Kind-Elemente eines bestimmten Typs (Parameter 1), deren Attribut"
				+ " (Parameter 2) einen bestimmten Wert (Parameter 3) hat.");
	}
}

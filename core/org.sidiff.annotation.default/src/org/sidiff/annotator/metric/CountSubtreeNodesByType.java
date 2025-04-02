package org.sidiff.annotator.metric;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.emf.access.EMFMetaAccess;

/**
 * Zaehlt Kind-Elemente und Kindes-Kind-Elemente (im gesamten Teilbaum) eines
 * bestimmten Typs (Parameter 1).
 * 
 * @author wenzel
 *
 */
public class CountSubtreeNodesByType extends Annotator {

	private static final String ANNOTATOR_ID = "CountSubtreeNodesByType";

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		EClass cls = (EClass) EMFMetaAccess.getMetaObjectByName(getDocumentType().getNsURI(), this.getParameter());
		if (cls == null) {
			// the class given as parameter cannot be found. We can stop here
			// and return 0
			return 0;
		}

		float result = 0;
		TreeIterator<EObject> iterator = object.eAllContents();
		while (iterator.hasNext()) {
			EObject obj = iterator.next();
			if (cls.isSuperTypeOf(obj.eClass())) {
				result++;
			}
		}

		return result;
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Zaehlt Kind-Elemente und Kindes-Kind-Elemente (im gesamten Teilbaum) eines"
				+ " bestimmten Typs (Parameter 1).");
	}

}

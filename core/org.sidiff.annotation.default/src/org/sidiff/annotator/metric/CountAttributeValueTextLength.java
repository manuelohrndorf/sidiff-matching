package org.sidiff.annotator.metric;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.common.Annotator;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

/**
 * Zaehlt die Anzahl Zeichen des Werts eines gegebenen Attributs.
 * 
 * @author wenzel
 *
 */
public class CountAttributeValueTextLength extends Annotator {

	private static final String ANNOTATOR_ID = "CountAttributeValueTextLength";

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, parameter, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		EAttribute attribute = (EAttribute) object.eClass().getEStructuralFeature(this.getParameter());
		if (attribute == null) {
			assert(LogUtil.log(LogEvent.DEBUG, "No such attribute '", getParameter(), "' on type '",
					object.eClass().getName(), "'.", object));
			return 0.0f;
		}
		return (float)String.valueOf(object.eGet(attribute)).length();
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Zaehlt die Anzahl Zeichen des Werts eines gegebenen Attributs.");
	}
}

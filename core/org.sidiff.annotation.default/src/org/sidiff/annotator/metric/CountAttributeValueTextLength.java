package org.sidiff.annotator.metric;

import java.util.Collection;

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
			return new Float(0);
		}
		return new Float(String.valueOf(object.eGet(attribute)).length());
	}

	@Override
	public String getAnnotatorID() {
		return ANNOTATOR_ID;
	}

	@Override
	public String getDescription() {
		return "Zaehlt die Anzahl Zeichen des Werts eines gegebenen Attributs.";
	}
}

package org.sidiff.annotator.common;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Dieser Annotator setzt die Ecore ID als derived ID. Key ist also
 * normalerweise "DERIVED_ID" (damit der ID-basierte Matcher damit arbeiten
 * kann); value die Ecore ID.
 *   
 * 
 * @author dreuling
 * 
 */
public class IntrinsicIDAnnotator extends Annotator {

	private static final String ANNOTATOR_ID = "IntrinsicIDAnnotator";

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, null, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		String id = EcoreUtil.getID(object);
		return id;
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This IntrinsicIDAnnotator sets the persistant Ecore-ID as a derived ID. The key is 'DERIVED ID'");
	}
}

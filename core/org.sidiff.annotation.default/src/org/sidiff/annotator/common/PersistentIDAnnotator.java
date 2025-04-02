package org.sidiff.annotator.common;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.emf.EMFUtil;

/**
 * Dieser Annotator setzt die persistente XMI ID als derived ID. Key ist also
 * normalerweise "DERIVED_ID" (damit der ID-basierte Matcher damit arbeiten
 * kann); value die persistente ID.
 * 
 * Dieser Annotator hat keine Parameter und erfordert keine anderen Annotations.
 * 
 * @author kehrer
 * 
 */
public class PersistentIDAnnotator extends Annotator {

	private static final String ANNOTATOR_ID = "PersistentIDAnnotator";

	@Override
	public void init(EPackage documentType, String annotationKey, String parameter, EClass acceptedType,
			Collection<String> requiredAnnotations) {

		super.init(documentType, annotationKey, null, acceptedType, requiredAnnotations, ExecutionOrder.PRE);
	}

	@Override
	protected Object computeAnnotationValue(EObject object) {
		String id = EMFUtil.getXmiId(object);
		return id;
	}

	@Override
	public String getKey() {
		return ANNOTATOR_ID;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This PersistantIDAnnotator set the persistant XMI-ID as a derived ID. The key is 'DERIVED ID'");
			
	}
}

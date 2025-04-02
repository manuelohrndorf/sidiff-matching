package org.sidiff.matching.signature.annotated;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.collections.DefaultComparators;
import org.sidiff.common.collections.ValueMap;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.EMFResourceUtil;
import org.sidiff.common.emf.access.EObjectLocation;
import org.sidiff.common.emf.access.tree.TreeVisitorAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;

public class SignatureValueHarvester extends TreeVisitorAdapter {

	private ValueMap<String, EObject> allSigValues = new ValueMap<String, EObject>();

	private String signatureKey = null;

	public SignatureValueHarvester(String signatureKey) {
		this.signatureKey = signatureKey;
	}

	@Override
	public void postExecute(EObject object) {
		if(EMFResourceUtil.locate(object.eResource(), object).equals(EObjectLocation.PACKAGE_REGISTRY))
			return;
		AnnotateableElement ao = EMFAdapter.INSTANCE.adapt(object, AnnotateableElement.class);

		if (signatureKey == null) {
			if (ao.hasAnnotation(MatchingContext.PATH_ANNOTATION)) {
				getAllSigValues().put(object,
						ao.getAnnotation(MatchingContext.PATH_ANNOTATION, String.class));
			}
		} else {
			if (ao.hasAnnotation(signatureKey)) {
				getAllSigValues().put(object, ao.getAnnotation(signatureKey, String.class));
			}
		}

	}

	ValueMap<String, EObject> getAllSigValues() {
		return this.allSigValues;
	}



}

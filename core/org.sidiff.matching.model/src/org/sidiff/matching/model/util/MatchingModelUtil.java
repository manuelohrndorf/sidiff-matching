package org.sidiff.matching.model.util;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.matching.model.MatchingModelFactory;

public class MatchingModelUtil {

	private MatchingModelUtil( ) {
		throw new AssertionError();
	}

	public static Correspondence createCorrespondence(EObject objA, EObject objB) {
		Correspondence correspondence = MatchingModelFactory.eINSTANCE.createCorrespondence();
		correspondence.setMatchedA(objA);
		correspondence.setMatchedB(objB);
		return correspondence;
	}

	public static Correspondence createCorrespondence(Matching matching, EObject objA, EObject objB) {
		Correspondence correspondence = createCorrespondence(objA, objB);
		matching.getCorrespondences().add(correspondence);
		return correspondence;
	}
}

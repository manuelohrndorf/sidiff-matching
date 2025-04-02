package org.sidiff.matcher.id.ecoreid;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.matcher.LocalSignatureMatcher;

public class EcoreIDMatcher extends LocalSignatureMatcher {

	@Override
	protected String getElementSignature(EObject element) {
		return EcoreUtil.getID(element);
	}

	@Override
	protected boolean considerCandidatesOnly() {
		//We try to match all elements
		return false;
	}
	
	@Override
	public String getDescription() {
		return "This matching service matches the elements by the ecore id";
	}

	@Override
	public String getName() {
		return "Ecore ID Matcher";
	}
}

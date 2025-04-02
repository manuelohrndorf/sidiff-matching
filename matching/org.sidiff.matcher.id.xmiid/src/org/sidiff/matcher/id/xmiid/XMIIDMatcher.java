package org.sidiff.matcher.id.xmiid;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.matcher.LocalSignatureMatcher;

public class XMIIDMatcher extends LocalSignatureMatcher {
	
	@Override
	protected String getElementSignature(EObject element) {
		return EMFUtil.getXmiId(element);
	}
	
	@Override
	protected boolean considerCandidatesOnly() {
		//We try to match all elements
		return false;
	}
	
	@Override
	public String getDescription() {
		return "This matcher matches the elementy by the XMI-IDs";
	}

	@Override
	public String getName() {
		return "XMI ID Matcher";
	}

	@Override
	public String getKey() {
		return getClass().getName();
	}
	
	
}

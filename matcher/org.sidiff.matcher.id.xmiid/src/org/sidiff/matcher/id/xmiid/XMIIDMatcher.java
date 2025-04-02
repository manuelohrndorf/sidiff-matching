package org.sidiff.matcher.id.xmiid;

import java.util.Optional;

import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.matcher.LocalSignatureMatcher;

public class XMIIDMatcher extends LocalSignatureMatcher {
	
	@Override
	protected String getElementSignature(EObject element) {
		String xmiID = EMFUtil.getXmiId(element);
		if(xmiID == null && element instanceof EGenericType) {
			EGenericType egt = (EGenericType) element;
			if(EMFUtil.isDynamic(egt)) {
				xmiID = getElementSignature(egt.eContainer()) + "." +
						getElementSignature(egt.getEClassifier());
			}
		}
		return xmiID;
	}
	
	@Override
	protected boolean considerCandidatesOnly() {
		//We try to match all elements
		return false;
	}
	
	@Override
	public Optional<String> getDescription() {
		return Optional.of("This matcher matches the elementy by the XMI-IDs");
	}

	@Override
	public String getName() {
		return "XMI ID Matcher";
	}

	@Override
	public String getKey() {
		return getClass().getName();
	}
	
	@Override
	protected boolean allowsAmbiguousSignature() {
		return true;
	}
	
}

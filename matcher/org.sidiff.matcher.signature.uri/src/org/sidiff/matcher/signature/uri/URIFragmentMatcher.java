package org.sidiff.matcher.signature.uri;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.matcher.LocalSignatureMatcher;

/**
 * Matches two EObjects based on their EMF URI fragments, i.e. their "location"
 * within an EMF Resource.
 * 
 *TODO DR: Migration of UML Profile Support (based on SiLift URI Fragment Matcher)
 *
 * @author kehrer
 */
public class URIFragmentMatcher extends LocalSignatureMatcher {	
			
	@Override
	protected String getElementSignature(EObject element) {	
		return EcoreUtil.getURI(element).fragment();
	}

	@Override
	protected boolean considerCandidatesOnly() {
		return true;
	}
	
	@Override
	public Optional<String> getDescription() {
		return Optional.of("This matching service matches the elements by their location.");
	}

	@Override
	public String getName() {
		return "URI Fragment Matcher";
	}
}

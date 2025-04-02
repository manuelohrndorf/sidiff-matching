package org.sidiff.candidates;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractCandidates implements ICandidates {

	@Override
	public boolean isCandidate(EObject... candidates) {
		return isCandidate(Arrays.asList(candidates));
	}
}

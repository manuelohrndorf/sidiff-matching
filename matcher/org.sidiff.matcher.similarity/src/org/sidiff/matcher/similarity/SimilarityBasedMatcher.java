package org.sidiff.matcher.similarity;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.matcher.BaseMatcher;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similaritiescalculation.ISimilaritiesCalculation;

public abstract class SimilarityBasedMatcher extends BaseMatcher {

	private ISimilaritiesCalculation similaritiesCalculation;

	@Override
	protected void init(Collection<Resource> models, Scope scope) {
		super.init(models, scope);
		this.similaritiesCalculation = initSimilaritiesCalculation(models);
	}

	protected ISimilaritiesCalculation initSimilaritiesCalculation(Collection<Resource> models) {
		ISimilaritiesCalculation calc = ISimilaritiesCalculation.MANAGER.getDefaultExtension()
				.orElseThrow(() -> new IllegalStateException("No similarities calculation service is available."));
		try {
			calc.init(models, getCorrespondencesService(), getCandidatesService());
		} catch (IOException e) {
			throw new IllegalStateException("Could not initialize similarities calculation service", e);
		}
		return calc;
	}

	public ISimilaritiesCalculation getSimilaritiesCalculation() {
		if(similaritiesCalculation == null) {
			throw new IllegalStateException("Similarities calculation is not initialized");
		}
		return similaritiesCalculation;
	}

	public ISimilarities getSimilarities() {
		return getSimilaritiesCalculation().getSimilarities();
	}

	@Override
	public void reset() {
		super.reset();
		if(similaritiesCalculation != null) {
			similaritiesCalculation.reset();
			similaritiesCalculation = null;
		}
	}
}

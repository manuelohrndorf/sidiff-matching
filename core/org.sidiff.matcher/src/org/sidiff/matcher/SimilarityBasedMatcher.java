package org.sidiff.matcher;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similarities.SimilaritiesServiceUtil;
import org.sidiff.similaritiescalculation.ISimilaritiesCalculation;
import org.sidiff.similaritiescalculation.SimilaritiesCalculationUtil;

public abstract class SimilarityBasedMatcher extends BaseMatcher {

	protected ISimilaritiesCalculation similaritiescalculationService = null;
	protected ISimilarities similarities = null;

	@Override
	protected void init(Collection<Resource> models, Scope scope) {
		super.init(models,scope);
		this.similarities = SimilaritiesServiceUtil.getSimilaritiesServiceInstance();
		this.similaritiescalculationService = SimilaritiesCalculationUtil
				.getSimilaritiesCalculationServiceInstance();
	}
	

	public ISimilaritiesCalculation getSimilaritiescalculationService() {
		return similaritiescalculationService;
	}

	public ISimilarities getSimilaritiesService() {
		return similarities;
	}

	@Override
	public void reset() {
		super.reset();
		this.similarities.reset();
		this.similaritiescalculationService.reset();
	}

}

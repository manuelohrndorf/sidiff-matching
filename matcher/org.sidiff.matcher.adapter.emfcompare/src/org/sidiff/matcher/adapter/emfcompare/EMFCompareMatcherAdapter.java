package org.sidiff.matcher.adapter.emfcompare;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.matcher.BaseMatcher;

/**
 * Concrete matcher that delegates to EMFCompare matching engine.
 * 
 * @author kehrer / reuling
 */
public class EMFCompareMatcherAdapter extends BaseMatcher{

	@Override
	protected void match() {		
		List<Resource> models = getModels();
		Assert.isTrue(models.size() == 2 || models.size() == 3, "Only either 2 or 3 models are supported");

		//Get matching engine registry
		IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
		// for OSGi (IDE, RCP) usage
		// IMatchEngine.Factory.Registry registry =EMFCompareRCPPlugin.getMatchEngineFactoryRegistry();
		
		//Set options, e.g. how to use (UU)IDs for model elements
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(UseIdentifiers.WHEN_AVAILABLE);
		matchEngineFactory.setRanking(20); // default engine ranking is 10, must be higher to override.
		registry.add(matchEngineFactory);

		IComparisonScope emfScope = createScope(models);

		// Compare and get all matches
		EMFCompare compare = EMFCompare.builder().setMatchEngineFactoryRegistry(registry).build();
		Comparison comparison = compare.compare(emfScope);
		EList<Match> matches = comparison.getMatches();

		// Convert to our own representation of correspondences
		matches.forEach(this::populateCorrespondence);
	}

	private IComparisonScope createScope(List<Resource> models) {
		boolean hasAncestor = models.size() == 3;
		// Two cases of scopes
		if (scope == Scope.RESOURCE_SET) {
			return new DefaultComparisonScope(
				models.get(0).getResourceSet(),
				models.get(1).getResourceSet(),
				hasAncestor ? models.get(2).getResourceSet() : null);
		}
		return new DefaultComparisonScope(
			models.get(0),
			models.get(1),
			hasAncestor ? models.get(2) : null);
	}

	private void populateCorrespondence(Match match) {
		if (match.getLeft() != null && match.getRight() != null) {
			if(match.getOrigin() != null) {
				getCorrespondencesService().addCorrespondence(match.getLeft(), match.getRight(), match.getOrigin());				
			} else {
				getCorrespondencesService().addCorrespondence(match.getLeft(), match.getRight());				
			}
		}
		for (Match subMatch : match.getSubmatches()) {
			populateCorrespondence(subMatch);
		}
	}

	@Override
	public String getName() {
		return "EMFCompare Generic Matcher";
	}

	@Override
	public boolean isResourceSetCapable() {
		// EMFC is resourceSetCapable if called properly
		return true;
	}	

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This matcher adapter allows for using EMFCompare in SiDiff.");
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(GENERIC_TYPE);
	}
}

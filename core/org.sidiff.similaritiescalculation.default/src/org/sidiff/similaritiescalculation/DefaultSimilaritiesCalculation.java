package org.sidiff.similaritiescalculation;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.extension.configuration.BasicExtensionConfiguration;
import org.sidiff.common.extension.configuration.ConfigurationOption;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.stringresolver.StringUtil;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.comparefunctions.exceptions.CompareException;
import org.sidiff.comparefunctions.util.CompareFunctionUtil;
import org.sidiff.configuration.ConfigurationManagement;
import org.sidiff.configuration.IConfiguration;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similaritiescalculation.configuration.CompareConfiguration;
import org.sidiff.similaritiescalculation.configuration.TypeConfiguration;
import org.sidiff.similaritiescalculation.configuration.XMLConfigurationHandler;
import org.w3c.dom.Document;

public class DefaultSimilaritiesCalculation implements ISimilaritiesCalculation {

	private Resource resourceA;
	private Resource resourceB;

	private ISimilarities similarities;
	private ICandidates candidates;

	private Map<EClass,TypeConfiguration> typeConfigCache;

	private CompareConfiguration compareConfig;
	private ConfigurationOption<Document> compareConfigDocument;
	private IExtensionConfiguration configuration;

	public DefaultSimilaritiesCalculation() {
		compareConfigDocument = ConfigurationOption.builder(Document.class).key("configDocument").build();
		configuration = new BasicExtensionConfiguration(Collections.singleton(compareConfigDocument)); 
	}

	@Override
	public void init(Collection<Resource> models, ICorrespondences correspondences, ICandidates candidates) throws IOException {
		reset();
		//TODO This has to be more generic!
		Assert.isLegal(models.size() == 2, "Only pairwise similarities are supported");
		Iterator<Resource> it = models.iterator();
		resourceA = it.next();
		resourceB = it.next();

		similarities = ISimilarities.MANAGER.getDefaultExtension().get();
		similarities.init(resourceA, resourceB);

		this.candidates = Objects.requireNonNull(candidates, "candidates must be set");

		loadCompareConfig(correspondences);
	}

	private void loadCompareConfig(ICorrespondences correspondences) throws IOException {
		if(correspondences == null) {
			throw new IllegalStateException("correspondences are not initialized");
		}
		if(!compareConfigDocument.isSet()) {
			String docType = EMFModelAccess.getDocumentType(resourceA);
			compareConfigDocument.setValue(ConfigurationManagement.getInstance(docType)
					.getRandomConfiguration(IConfiguration.CONFIG_TYPE_COMPARE));			
		}
		if(compareConfigDocument.isSet()) {
			compareConfig =
				new XMLConfigurationHandler(correspondences, similarities)
					.parseConfiguration(this, compareConfigDocument.getValue());
		}
		if(compareConfig == null) {
			throw new IllegalStateException("No compare configuration is available");
		}
	}

	private void assertInitialized() {
		if(compareConfig == null) {
			throw new IllegalStateException("Similarities calculation is not initialized");
		}
	}

	@Override
	public void calculateSimilarities(Collection<EObject> items) {
		assertInitialized();

		for (EObject what : items) {
			TypeConfiguration config =
				typeConfigCache.computeIfAbsent(what.eClass(), compareConfig::getTypeConfiguration);
			final float threshold = config.getThreshold();

			for (EObject with : candidates.getCandidates(what)) {
				float simVal = compare(what, config, with);
				if (simVal >= threshold) {
					similarities.setSimilarity(what, with, simVal);
				}
			}
		}
	}

	@Override
	public void calculateSimilarities(EObject elem1, EObject elem2) {
		assertInitialized();
		assert((elem1.eResource() == resourceA && elem2.eResource() == resourceB)
				|| (elem2.eResource() == resourceA && elem1.eResource() == resourceB)) : "Invalid Resource/Object!";

		if (elem1.eClass() == elem2.eClass() && candidates.isCandidate(elem1, elem2)) {
			TypeConfiguration typeconfig = compareConfig.getTypeConfiguration(elem1.eClass());
			float simVal = compare(elem1, typeconfig, elem2);
			if (simVal >= typeconfig.getThreshold()) {
				similarities.setSimilarity(elem1, elem2, simVal);
			}
		}
	}

	/**
	 * Actual comparison of two given elements.
	 */
	private float compare(EObject what, TypeConfiguration typeconfig, EObject with) {

		// compared elements must have equal type
		assert(typeconfig.getType().isSuperTypeOf(what.eClass()));
		assert(typeconfig.getType().isSuperTypeOf(with.eClass()));
		assert(what.eClass() == with.eClass()) : "Elements have different types " + what + ", " + with;

		// elements must belong to the given resources
		assert((what.eResource() == resourceA && with.eResource() == resourceB)
				|| (with.eResource() == resourceA && what.eResource() == resourceB)) : "Invalid Resource/Object!"
						+ StringUtil.resolve("what=", what, "what.res=", what.eResource(), "with=", with, "with.res=",
								with.eResource(), "resA=", resourceA, "resB", resourceB);

		assert(LogUtil.log(LogEvent.DEBUG, "Evaluation of ", what, "\nand ", with));

		// The comparison has been extracted into an extra method, because it is
		// also used by the IfThenElse mechanism.

		float totalSimilarity = computeSimilarity(what, with, typeconfig.getCompareFunctions());

		if (compareConfig.isNormalizeWeights()) {
			totalSimilarity = totalSimilarity / CompareFunctionUtil.computeSumOfWeights(typeconfig.getCompareFunctions());
			assert(LogUtil.log(LogEvent.DEBUG, "Normalized similarity:" + totalSimilarity));
		}
		assert(LogUtil.log(LogEvent.DEBUG, "total similarity " + totalSimilarity));

		return totalSimilarity;
	}

	/**
	 * Triggers the execution of a list of compare functions for a given pair of
	 * elements.
	 * 
	 * @param what
	 * @param with
	 * @param compareFunctions
	 *            The list of compare functions to be executed
	 * @return the accumulated similarity with respect to all compare functions.
	 */
	float computeSimilarity(EObject what, EObject with, Collection<ICompareFunction> compareFunctions) {
		assertInitialized();

		float similarity = 0.0f;
		float totalSimilarity = 0.0f;

		EObject objectFromA;
		EObject objectFromB;
		if (what.eResource() == resourceA) {
			objectFromA = what;
			objectFromB = with;
		} else {
			objectFromA = with;
			objectFromB = what;
		}

		for (ICompareFunction compareFunc : compareFunctions) {
			assert(LogUtil.log(LogEvent.DEBUG, "  calling compare function ", compareFunc.toString()));

			try {
				similarity = compareFunc.compare(objectFromA, objectFromB) * compareFunc.getWeight();
			} catch (CompareException e) {

				if (compareFunc.getPolicy() == EvaluationPolicy.mandatory) {
					LogUtil.log(LogEvent.ERROR,
							"Exception during call of compare function. Maybe you have a malformed document:\n"
									+ "Comparing type " + what.eClass() + "\n" + "objects: ",
							what, "<->", with, "\n" + "CompareFunction: " + compareFunc.toString());
					throw e;
				} else if (compareFunc.getPolicy() == EvaluationPolicy.fulfilled) {
					assert(LogUtil.log(LogEvent.DEBUG,
							"Abortable compare function not executeable, Assuming Fulfilled -> returning 1.0f."));
					similarity = 1.0f * compareFunc.getWeight();
				} else if (compareFunc.getPolicy() == EvaluationPolicy.unfulfilled) {
					assert(LogUtil.log(LogEvent.DEBUG,
							"Abortable compare function not executeable, Assuming Unfulfilled -> returning 0.0f."));
					similarity = 0.0f;
				} else {
					LogUtil.log(LogEvent.ERROR, "Unknown Exception Policy:" + compareFunc.getPolicy());
					throw e;
				}
			}

			totalSimilarity += similarity;

			assert(LogUtil.log(LogEvent.DEBUG, "  result " + similarity + " (factor " + compareFunc.getWeight() + ")"));
		}

		return totalSimilarity;
	}

	@Override
	public void reset() {
		compareConfig = null;
		if(candidates != null) {
			candidates.reset();
			candidates = null;
		}
		if(similarities != null) {
			similarities.reset();
			similarities = null;
		}
		typeConfigCache = new HashMap<>();
		resourceA = null;
		resourceB = null;
	}

	@Override
	public ISimilarities getSimilarities() {
		return similarities;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("The default Similarities Calculation Service.");
	}

	@Override
	public String getKey() {
		return "DefaultSimilaritiesCalculationService";
	}

	@Override
	public IExtensionConfiguration getConfiguration() {
		return configuration;
	}
}

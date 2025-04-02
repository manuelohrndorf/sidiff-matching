package org.sidiff.similaritiescalculation;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.CandidatesUtil;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.io.ResourceUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.util.StringUtil;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.comparefunctions.exceptions.CompareException;
import org.sidiff.configuration.ConfigurationManagement;
import org.sidiff.event.EventUtil;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similarities.SimilaritiesServiceUtil;
import org.sidiff.similaritiescalculation.configuration.CompareConfiguration;
import org.sidiff.similaritiescalculation.configuration.TypeConfiguration;
import org.sidiff.similaritiescalculation.configuration.XMLConfigurationHandler;
import org.w3c.dom.Document;

public class DefaultSimilaritiesCalculation implements ISimilaritiesCalculation {
	
	private static Resource resourceA = null;
	private static Resource resourceB = null;
	
	private CompareConfiguration compareConfig = null;
	private Document config = null;


	public static final String CFG_TYPE = "compare";

	private ISimilarities similarities = null;
	private ICandidates candidatesService = null;

	@Override
	public void init(Collection<Resource> models) {
		
		//TODO This has to be more generic!
		Iterator<Resource> it = models.iterator();
		Resource modelA = it.next();
		Resource modelB = it.next();
		
		this.similarities = SimilaritiesServiceUtil.getSimilaritiesServiceInstance();
		this.candidatesService = CandidatesUtil.getCandidatesServiceInstance();
		this.similarities.init(modelA, modelB);

		resourceA = modelA;
		resourceB = modelB;
		
		if(this.config == null)
			this.config = ConfigurationManagement.getInstance(EMFModelAccess.getDocumentType(modelA)).getRandomConfiguration(getSubfolderName());
		
		if(this.config != null){
			this.compareConfig = parseDoc(this.config);
			this.configure();
		}
		
	}
	
	
	
	@Override
	public void configure(Document compareConfiguration) {
		ResourceUtil.registerClassLoader(this.getClass().getClassLoader());
		parseDoc(compareConfiguration);
	}
	
	private CompareConfiguration parseDoc(Document document){
		ResourceUtil.registerClassLoader(this.getClass().getClassLoader());
		XMLConfigurationHandler confighandler = new XMLConfigurationHandler();
		this.compareConfig = confighandler.parseConfiguration(document);

		if (this.compareConfig == null) {
			throw new IllegalArgumentException(
					"Invalid configuration Data " + StringUtil.resolve(document));
		}
		return this.compareConfig;
		
	}

	@Override
	public void calculateSimilarities(Collection<EObject> items) {

		assert(resourceA != null && resourceB != null) : "Missing Resource!";
		assert(this.similarities != null) : "Invalid Context? Missing Similarities!";
		assert(this.candidatesService != null) : "Invalid Context? Missing CandidatesService!";
		assert(items != null) : "Invalid null argument!";

		Iterator<EObject> itemIter = items.iterator();
		if (itemIter.hasNext()) {
			TypeConfiguration typeconfig = compareConfig.getTypeConfiguration(items.iterator().next().eClass());
			for (EObject what : items) {
				if (what.eClass() != typeconfig.getType()) {
					typeconfig = compareConfig.getTypeConfiguration(what.eClass());
				}

				float simVal = 0;
				float threshold = typeconfig.getThreshold();

				try {
					for (EObject with : candidatesService.getCandidates(what)) {

						simVal = compare(what, typeconfig, with);
						if (simVal >= threshold) {
							this.similarities.setSimilarity(what, with, simVal);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void calculateSimilarities(EObject elem1, EObject elem2) {

		assert(resourceA != null && resourceB != null) : "Missing Resource!";
		assert(this.similarities != null) : "Invalid Context? Missing Similarities!";
		assert(this.candidatesService != null) : "Invalid Context? Missing CandidatesService!";
		assert((elem1.eResource() == resourceA && elem2.eResource() == resourceB)
				|| (elem2.eResource() == resourceA && elem1.eResource() == resourceB)) : "Invalid Resource/Object!";

		if (elem1.eClass() == elem2.eClass() && candidatesService.isCandidate(elem1, elem2)) {
			TypeConfiguration typeconfig = compareConfig.getTypeConfiguration(elem1.eClass());
			float simVal = compare(elem1, typeconfig, elem2);
			if (simVal >= typeconfig.getThreshold()) {
				this.similarities.setSimilarity(elem1, elem2, simVal);
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
		EventUtil.fireEvent(
				new SimilarityCalculationEvent(this, SimilarityCalculationEvent.START_COMPARISON, what, with));

		assert(LogUtil.log(LogEvent.DEBUG, "Evaluation of ", what, "\nand ", with));

		// The comparison has been extracted into an extra method, because it is
		// also used by the IfThenElse mechanism.

		float totalSimilarity = computeSimilarity(what, with, typeconfig.getCompareFunctions());

		if (compareConfig.isNormalizeWeights()) {

			totalSimilarity = totalSimilarity / computeSumOfWeights(typeconfig.getCompareFunctions());
			assert(LogUtil.log(LogEvent.DEBUG, "Normalized similarity:" + totalSimilarity));
		}
		assert(LogUtil.log(LogEvent.DEBUG, "total similarity " + totalSimilarity));
		EventUtil.fireEvent(new SimilarityCalculationEvent(this, SimilarityCalculationEvent.STOP_COMPARISON,
				what, with, totalSimilarity));

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
	public static float computeSimilarity(EObject what, EObject with, Collection<ICompareFunction> compareFunctions) {

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
				EventUtil.fireEvent(new SimilarityCalculationEvent(DefaultSimilaritiesCalculation.class,
						SimilarityCalculationEvent.START_COMPAREFUNCTION, compareFunc));
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
			} finally {
				EventUtil.fireEvent(new SimilarityCalculationEvent(DefaultSimilaritiesCalculation.class,
						SimilarityCalculationEvent.STOP_COMPAREFUNCTION, similarity));
			}

			totalSimilarity += similarity;

			assert(LogUtil.log(LogEvent.DEBUG, "  result " + similarity + " (factor " + compareFunc.getWeight() + ")"));

		}

		return totalSimilarity;
	}

	public static float computeSumOfWeights(Collection<ICompareFunction> functions) {

		float sumWeights = 0.0f;
		for (ICompareFunction function : functions) {
			sumWeights += function.getWeight();
		}
		return sumWeights;
	}



	@Override
	public void reset() {
		this.compareConfig = null;
		this.candidatesService.reset();
		this.similarities.reset();
		resourceA = null;
		resourceB = null;
	}

	@Override
	public String getDescription() {
		return "Default SimliaritiesCalculation Service";
	}

	@Override
	public String getServiceID() {
		return "DefaultSimilaritiesCalculationService";
	}


	@Override
	public String getSubfolderName() {
		return CFG_TYPE;
	}


	@Override
	public Document getConfiguration() {
		return this.config;
	}

	@Override
	public void setConfiguration(Document configuration) {
		this.config = configuration;
		this.compareConfig = parseDoc(this.config);
	}

	@Override
	public void configure() {
		this.configure(this.config);
	}

}

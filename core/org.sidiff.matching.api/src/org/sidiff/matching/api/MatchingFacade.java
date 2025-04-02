package org.sidiff.matching.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFValidate;
import org.sidiff.common.emf.exceptions.InvalidModelException;
import org.sidiff.common.emf.exceptions.NoCorrespondencesException;
import org.sidiff.common.emf.input.InputModels;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.settings.MatchingSettings;
import org.sidiff.matching.model.Matching;

/**
 * Convenient access to matching functions.
 */
public class MatchingFacade {

	/**
	 * Matching model file extension.
	 */
	public static String MATCHING_MODEL_EXT = "matching";

	/**
	 * Computes a {@link Matching} between the given models.
	 *
	 * @param models
	 *            The models to be matched.
	 * @param settings
	 *            Specifies the settings of the matching algorithm.
	 * @return A {@link Matching} between the given models
	 * @throws NoCorrespondencesException
	 * @throws InvalidModelException
	 */
	public static Matching match(Collection<Resource> models, MatchingSettings settings) throws NoCorrespondencesException, InvalidModelException {

		LogUtil.log(LogEvent.NOTICE, "Settings:\n" + settings.toString());
		LogUtil.log(LogEvent.NOTICE, "Input models: " + models.stream().map(Resource::getURI).map(URI::lastSegment).collect(Collectors.joining(", ")));

		// Validate models
		if (settings.isValidate()) {
			EMFValidate validate = new EMFValidate(Diagnostic.WARNING);
			for(Resource model : models){
				validate.validateModel(model);
			}
		}

		// Set SiLift default Correspondence-Service:
		MatchingModelCorrespondences correspondences =
			ICorrespondences.MANAGER.getExtension(MatchingModelCorrespondences.class).get();

		// Create matching
		IMatcher matcher = settings.getMatcher();
		matcher.reset();
		matcher.setCorrespondencesService(correspondences);

		LogUtil.log(LogEvent.NOTICE, "Start matching ...");
		matcher.startMatching(models, settings.getScope());
		LogUtil.log(LogEvent.NOTICE, "[finished]");

		// Get Matching
		Matching matching = correspondences.getMatching();
		if (matching.getCorrespondences().size() == 0) {
			throw new NoCorrespondencesException();
		}
		LogUtil.log(LogEvent.NOTICE, "Matched elements: " + matching.getCorrespondences().size());
		return matching;
	}

	/**
	 * Computes a {@link Matching} between the given models.
	 *
	 * @param models
	 *            Models to be matched.
	 * @param settings
	 *            Specifies the settings of the matching algorithm.
	 * @return A {@link Matching} between the given models
	 * @throws NoCorrespondencesException
	 * @throws InvalidModelException
	 */
	public static Matching match(InputModels models, MatchingSettings settings) throws NoCorrespondencesException, InvalidModelException {
		return match(models.getResources(), settings);
	}

	/**
	 * Serializes a matching.
	 *
	 * @param matching
	 *            The matching to be serialized.
	 * @param uri
	 *            The serialization path.
	 * @param fileName
	 *            The file name of the matching.
	 */
	public void serializeMatching(Matching matching, URI outputDir, String filename) {
		URI matchingURI = outputDir.appendSegment(filename);
		if(!MATCHING_MODEL_EXT.equals(matchingURI.fileExtension())) {
			matchingURI = matchingURI.appendFileExtension(MATCHING_MODEL_EXT);
		}
		SiDiffResourceSet.create().saveEObjectAs(matching, matchingURI);
	}

	/**
	 * Load a {@link Matching}
	 * @param path
	 * 			The path to the matching file
	 * @return The loaded {@link Matching}
	 */
	public static Matching loadMatching(URI uri) {
		return SiDiffResourceSet.create().loadEObject(uri, Matching.class);
	}
}

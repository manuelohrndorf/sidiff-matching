package org.sidiff.matching.testdriver;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.app.CommandLine;
import org.sidiff.common.app.CommandLine.Argument;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.api.settings.MatchingSettings;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.matching.model.Matching;

public class TestDriver implements IApplication {
	

	private static final String MODEL_FILE1 = "file1";
	private static final String MODEL_FILE2 = "file2";
	private static final String FOLDER = "folder";
	private static final String MATCHER_KEY = "org.sidiff.matcher.similarity.flooding.SimilarityFloodingMatcher";


	final static Argument<String> FILE1 = CommandLine.createParameter(MODEL_FILE1, String.class, false);
	final static Argument<String> FILE2 = CommandLine.createParameter(MODEL_FILE2, String.class, false);
	final static Argument<String> TARGET_FOLDER = CommandLine.createParameter(FOLDER, String.class, false);
	final SiDiffResourceSet inputResSet = SiDiffResourceSet.create();

	@Override
	public Object start(IApplicationContext context) throws Exception {				
		
		String tmp1 = "/home/dreuling/Repositories/variance/testdata/org.sidiff.variance.examples/ecore/bank/A.ecore";
		String tmp2 = "/home/dreuling/Repositories/variance/testdata/org.sidiff.variance.examples/ecore/bank/B.ecore";
		String tmp3 = "/home/dreuling/Repositories/variance/testdata/org.sidiff.variance.examples/ecore/bank";

		Resource modelA = inputResSet.getResource(URI.createFileURI(tmp1), true);
		Resource modelB = inputResSet.getResource(URI.createFileURI(tmp2), true);
		List<Resource> models = new ArrayList<Resource>();
		models.add(modelA);
		models.add(modelB);
		
		
		IMatcher matcher = MatchingUtils.getMatcherByKey(MATCHER_KEY);
		
	//	IncrementalMatcher ic = new IncrementalMatcher(matchers);
		
		MatchingSettings settings = new MatchingSettings();		
		settings.initDefaults(EMFModelAccess.getDocumentTypes(modelA));
		settings.setMatcher(matcher);
		
		Matching matching = MatchingFacade.match(models, settings);
		String fileName = modelA.getURI().lastSegment() + "-" + modelB.getURI().lastSegment();
		SiDiffResourceSet reSSet = SiDiffResourceSet.create("matching");
		reSSet.saveEObjectAs(matching, URI.createFileURI(tmp3 + File.separator + fileName + ".matching"));
		

		return EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}

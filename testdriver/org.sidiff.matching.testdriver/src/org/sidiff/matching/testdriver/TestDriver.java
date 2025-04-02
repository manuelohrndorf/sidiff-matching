package org.sidiff.matching.testdriver;

import java.io.File;
import java.util.ArrayList;
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
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.IncrementalMatcher;
import org.sidiff.matcher.MatcherUtil;
import org.sidiff.matching.api.MatchingFacade;
import org.sidiff.matching.api.settings.MatchingSettings;
import org.sidiff.matching.model.Matching;

public class TestDriver implements IApplication {
	

	private static final String MODEL_FILE1 = "file1";
	private static final String MODEL_FILE2 = "file2";
	private static final String FOLDER = "folder";


	final static Argument<String> FILE1 = CommandLine.createParameter(MODEL_FILE1, String.class, false);
	final static Argument<String> FILE2 = CommandLine.createParameter(MODEL_FILE2, String.class, false);
	final static Argument<String> TARGET_FOLDER = CommandLine.createParameter(FOLDER, String.class, false);
	final ResourceSet resSet = new ResourceSetImpl();

	@Override
	public Object start(IApplicationContext context) throws Exception {				
		
		String tmp1 = "R:\\sipl\\casestudies\\ppu\\org.sidiff.deltamodeling.casestudy.ppu.models\\products\\00001\\ppu_150percent.uml";
		String tmp2 = "R:\\sipl\\casestudies\\ppu\\org.sidiff.deltamodeling.casestudy.ppu.models\\products\\00002\\ppu_150percent.uml";
		String tmp3 = "R:\\sipl\\casestudies\\ppu\\org.sidiff.deltamodeling.casestudy.ppu.models\\products";

		Resource modelA = resSet.getResource(URI.createFileURI(tmp1), true);
		Resource modelB = resSet.getResource(URI.createFileURI(tmp2), true);
		List<Resource> models = new ArrayList<Resource>();
		models.add(modelA);
		models.add(modelB);
		
	//	List<IMatcher> matchers =  MatcherUtil.getAllAvailableMatchers();
		//IMatcher matcher = MatcherUtil.getMatcher("KEY");
		
	//	IncrementalMatcher ic = new IncrementalMatcher(matchers);
		
		
		MatchingSettings settings = new MatchingSettings(EMFModelAccess.getCharacteristicDocumentType(modelA));		
	//	settings.setMatcher(ic);
		Matching matching = MatchingFacade.match(models, settings);
		String fileName = modelA.getURI().lastSegment() + "-" + modelB.getURI().lastSegment();
		EMFStorage.eSaveAs(URI.createFileURI(tmp3 + File.separator + fileName + ".matching"), matching);
		

		return EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}

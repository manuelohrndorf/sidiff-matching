package org.sidiff.example.library.diff;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.app.CommandLine;
import org.sidiff.common.app.CommandLine.Argument;
import org.sidiff.common.emf.modelstorage.AbstractEMFImporter;
import org.sidiff.common.emf.modelstorage.Loader;
import org.sidiff.common.emf.modelstorage.ModelStorage;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.util.StatisticsUtil;

public class ConsoleDiff implements IApplication {

	private static final String MODEL_LEFT = "left";
	private static final String MODEL_RIGHT = "right";

	final static Argument<String> FILE_LEFT = CommandLine.createParameter(MODEL_LEFT, String.class, false);
	final static Argument<String> FILE_RIGHT = CommandLine.createParameter(MODEL_RIGHT, String.class, false);

	final static Argument<String> options = CommandLine.createParameter("options", String.class, false);

	@Override
	public Object start(IApplicationContext context) throws Exception {
		System.out.println("--start");
		CommandLine.parse((String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS), true);

		System.out.print("SiDiff Commandline Tool\n");

		// Load Models...
		Resource left = null;
		Resource right = null;

		ModelStorage ms = ModelStorage.getInstance();
		ms.registerLoader(modelLoader);

		if (FILE_LEFT.getValue().endsWith(ModelStorage.NATIVE_MODEL_SUFFIX)) {
			left = ms.loadEMF(FILE_LEFT.getValue(), MODEL_LEFT);
		} else {
			left = ms.importEMF(FILE_LEFT.getValue(), MODEL_LEFT);
		}

		if (FILE_RIGHT.getValue().endsWith(ModelStorage.NATIVE_MODEL_SUFFIX)) {
			right = ms.loadEMF(FILE_RIGHT.getValue(), MODEL_RIGHT);
		} else {
			right = ms.importEMF(FILE_RIGHT.getValue(), MODEL_RIGHT);
		}

		if (left != null && right != null) {

			// respect options if present
			Map<Object, Object> optionsMap = null;
			if (options.getValue() != null) {
				optionsMap = new HashMap<Object, Object>();
				String optionsArray[] = options.getValue().split(",");
				for (String optionStr : optionsArray) {
					String optionArray[] = optionStr.split("=");
					if (optionArray.length == 2) {
						Boolean flag = Boolean.parseBoolean(optionArray[1]);
						optionsMap.put(optionArray[0], flag);
						LogUtil.log(LogEvent.MESSAGE, optionArray[0], "==", flag);
					} else {
						System.err.println("Malformed Option argument:" + options.getValue());
						System.err
								.println("Valid option must match: <OptionName1>=(true|false):...:<OptionNameN>=(true|false)");
						return -1;
					}
				}
			} else {
				LogUtil.log(LogEvent.MESSAGE, "Comparison will be performed by default behavior!");
			}

			StatisticsUtil.getInstance().start(this);
			// Perform Compare
			CompareInterface ascetComparator = CompareInterface.getInstance();
			Correspondences correspondences = ascetComparator.compare(left, right, optionsMap);
			StatisticsUtil.getInstance().stop(this);

			// Results
			LogUtil.log(LogEvent.MESSAGE, "Matching computed in ", StatisticsUtil.getInstance().getTime(this));
			LogUtil.log(LogEvent.MESSAGE, "Matched:" + correspondences.matched());
			LogUtil.log(LogEvent.MESSAGE, "Unmatched:" + correspondences.unmatchedIn(left));
			LogUtil.log(LogEvent.MESSAGE, "Unmatched:" + correspondences.unmatchedIn(right));
			if (FILE_LEFT.getValue().equals(FILE_RIGHT.getValue())) {
				// Perform quick validation on self comparison result...
				LogUtil.log(LogEvent.MESSAGE, "Validation:" + (check(left, right, correspondences) ? "OK" : "FAIL!"));
			}
		} else {
			System.out.print("Missing Model!");
		}

		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// Cannot stop anyway
	}

	private boolean check(Resource a, Resource b,Correspondences correspondences) {
		
		boolean check = true;
		
		for(EObject mobjectA : correspondences.getMatchedFrom(a)){
			EObject mobjectB = correspondences.getPartner(mobjectA);
			assert(mobjectA.eResource()==a&&mobjectB.eResource()==b) : "Resource Mismatch!";
			
			if(!a.getURIFragment(mobjectA).equals(b.getURIFragment(mobjectB))){
				LogUtil.log(LogEvent.MESSAGE, "Failure:",a.getURIFragment(mobjectA),"!=",b.getURIFragment(mobjectB) );
				check &= false;
			}
		}
		return check;
	}
	
	private Loader modelLoader = new AbstractEMFImporter() {

		@Override
		public String getSuffix() {
			return "xmi";
		}

		@Override
		public Map<String, String> getSchemaLocationMappings() {
			Map<String, String> map = new HashMap<String, String>();
			map.put(CompareInterface.MODEL_ID,
					"platform:/resource/org.sidiff.example.library.model/model/library.ecore");
			return map;
		}

		@Override
		public String getLoaderDescription() {
			return "Loader for Ecore models";
		}
	};

	
}

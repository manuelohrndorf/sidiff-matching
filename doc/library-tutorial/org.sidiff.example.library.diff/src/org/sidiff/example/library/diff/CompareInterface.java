package org.sidiff.example.library.diff;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.BundleContext;
import org.sidiff.common.services.ServiceContext;
import org.sidiff.common.services.ServiceHelper;
import org.sidiff.core.annotation.AnnotationService;
import org.sidiff.core.candidates.CandidatesService;
import org.sidiff.core.correspondences.CorrespondencesService;
import org.sidiff.core.matching.HashMatchingService;
import org.sidiff.core.matching.IDBasedMatchingService;
import org.sidiff.core.matching.IterativeMatchingService;
import org.sidiff.core.similarities.DefaultSimilaritiesService;
import org.sidiff.core.similaritiescalculator.DefaultSimilaritiesCalculationService;

public class CompareInterface {
	
	// nsuri of the model-rootpackage
	public final static String MODEL_ID = "http://www.eclipse.org/emf/jcrm/samples/emf/sample/Library";  
	
	// Possible Properties
	public final static String ID_BASED_MATCHING = "org.sidiff.core.matching.IDBasedMatchingService";
	public final static String HASH_BASED_MATCHING = "org.sidiff.core.matching.HashMatchingService";
	public final static String ITERATIVE_MATCHING = "org.sidiff.core.matching.IterativeMatchingService";
	
	// Where to find configuation for our model type
	private final static String annotationFileName = "library.annotation.xml";
	private final static String compareFileName = "library.similarities.xml";
	private final static String matchingFileName = "library.matching.xml";
	//private final static String candidatesFileName = "specification.candidates.xml";
		
	// The instance (singleton)
	private static CompareInterface INSTANCE = null;

	// The bundelcontext that allows us to query needed services
	private BundleContext bundleContext = null;
	
	
	private CompareInterface(BundleContext context) {
		
		// Configure/Register all needed (sidiff-core) Services	
		ServiceHelper.configureInstance(context, AnnotationService.class, MODEL_ID, null, annotationFileName);	
		ServiceHelper.configureInstance(context, DefaultSimilaritiesCalculationService.class, MODEL_ID, null, compareFileName);
		ServiceHelper.configureInstance(context, IterativeMatchingService.class, MODEL_ID, null, matchingFileName);
		//ServiceHelper.configureInstance(context, CandidatesService.class, ASCET_MODEL_ID, null, XMLParser.parseStream(IOUtil.getInputStream(candidatesFileName)));

		this.bundleContext = context;	
	}
	
	public static CompareInterface getInstance(){
		
		if(CompareInterface.INSTANCE==null){
			CompareInterface.INSTANCE = new CompareInterface(Activator.getContext());
		}
		return CompareInterface.INSTANCE;
	}
	
	public Correspondences compare(Resource modelA, Resource modelB,Map<?,?> options){
	
		//****************************************************************************************************
		// Get parts and build Difference-Application
		
		ServiceContext context = new ServiceContext();
			
		context.putService(ServiceHelper.getService(this.bundleContext, CorrespondencesService.class, MODEL_ID,null));
		context.putService(ServiceHelper.getService(this.bundleContext, CandidatesService.class, MODEL_ID,null));
		
		if(checkProperty(options, ID_BASED_MATCHING, true)||checkProperty(options, HASH_BASED_MATCHING, true)){
			context.putService(ServiceHelper.getService(this.bundleContext, AnnotationService.class, MODEL_ID,null));
		}
		
		if(checkProperty(options, ID_BASED_MATCHING, true)){
			context.putService(ServiceHelper.getService(this.bundleContext, IDBasedMatchingService.class, MODEL_ID,null));
		}
		
		if(checkProperty(options, HASH_BASED_MATCHING, true)){
			context.putService(ServiceHelper.getService(this.bundleContext, HashMatchingService.class, MODEL_ID,null));
		}
		
		if(checkProperty(options, ITERATIVE_MATCHING, true)){
			context.putService(ServiceHelper.getService(this.bundleContext, DefaultSimilaritiesCalculationService.class, MODEL_ID,null));
			context.putService(ServiceHelper.getService(this.bundleContext, DefaultSimilaritiesService.class, MODEL_ID,null));
			context.putService(ServiceHelper.getService(this.bundleContext, IterativeMatchingService.class, MODEL_ID,null));
		}
		
		// ** done **
		//*****************************************************************************************************
		
		//****************************************************************************************************
		// Perform Matching

		// Initialize Application
		context.initialize(modelA, modelB);

		// Do the job
		if(checkProperty(options, ID_BASED_MATCHING, true)||checkProperty(options, HASH_BASED_MATCHING, true)){
			context.getService(AnnotationService.class).annotate(modelA);
			context.getService(AnnotationService.class).annotate(modelB);
		}
		if(checkProperty(options, ID_BASED_MATCHING, true)){
			context.getService(IDBasedMatchingService.class).match();
		}
		if(checkProperty(options, HASH_BASED_MATCHING, true)){
			context.getService(HashMatchingService.class).match();
		}
		if(checkProperty(options, ITERATIVE_MATCHING, true)){
			context.getService(IterativeMatchingService.class).match();
		}
		
		// ** done **
		//*****************************************************************************************************
	
		return new Correspondences(context.getService(CorrespondencesService.class),modelA,modelB);
	}
	

	private boolean checkProperty(Map<?,?> options,Object key,boolean defaultValue){
		
		if(options!=null&&options.containsKey(key)){
			assert(options.get(key) instanceof Boolean) : "Invalid Property ('"+options.get(key)+"' but Boolean expected)";
			return ((Boolean)options.get(key)).booleanValue();
		} else {
			return defaultValue;
		}
	}
	
	
}

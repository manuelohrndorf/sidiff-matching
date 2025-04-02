package org.sidiff.core.configurator.application;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.app.CommandLine;
import org.sidiff.common.app.CommandLine.Argument;
import org.sidiff.common.emf.modelstorage.ModelStorage;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.services.ServiceHelper;
import org.sidiff.common.xml.XMLDOMCreator;
import org.sidiff.core.configurator.ConfiguratorService;
import org.sidiff.core.configurator.impl.Activator;
import org.sidiff.core.matching.IterativeMatchingService;
import org.sidiff.core.similaritiescalculator.DefaultSimilaritiesCalculationService;
import org.w3c.dom.Document;

public class ConfiguratorApp implements IApplication {
	
	// some convenience string constants
	// http://www.sidiff.org/org.sidiff.uml.model
	// http://www.sidiff.org/org.sidiff.matlab.simulink.model
	
    private final static Argument<String> packageURI = CommandLine.createParameter("packageURI", String.class, false);
    private final static Argument<String> modelFile = CommandLine.createParameter("modelFile", String.class, false);
    private final Argument<String> resultFolder = CommandLine.createParameter("resultFolder", String.class, true);
    
    private static final String MODEL_PARAMETER_USAGE = "Use on of the following CommandLine parameters to provide a Model: \n" +
    "'packageURI' : expects a nsURI of an registered EPackage\n" +
    "'modelFile' : expects a Path to an .ecore File\n" +
    "'packageInstance' : expects an Array of EPackages.";
    
    private final String MATCHING_CONFIG_SUFFIX = ".matching.xml";
    private final String SIMILARITIES_CONFIG_SUFFIX = ".similarities.xml";
    
    private final String FILE_SEPERATOR = System.getProperty("file.separator");


	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		CommandLine.parse((String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS), false);
							
		Collection<EPackage> rootPackages = new HashSet<EPackage>();
		
		if(packageURI.getValue()!=null^modelFile.getValue()!=null){
			
			if(packageURI.getValue()!= null){ // URI Mode
				
				rootPackages.add(EPackage.Registry.INSTANCE.getEPackage(packageURI.getValue()));
				
				if(rootPackages.isEmpty()){
					System.err.println("No registered EPackage(s) found for URI: '" + packageURI.getValue() + "'!");
					return null;
				}
			}
			
			if(modelFile.getValue()!= null){ // File Mode
				
				//Use modelFile to load an .ecore File
				if(ModelStorage.getInstance().registerMetaModel(modelFile.getValue(),"*")){
					//import resource using ModelStorage
					Resource eCoreResource = ModelStorage.getInstance().getModel(modelFile.getValue());
					if(eCoreResource != null) {
						//iterator over direct contents of resource to gather all root packages
						for(EObject eObject : eCoreResource.getContents()){
							if(eObject instanceof EPackage){
								rootPackages.add((EPackage)eObject);
							} else {
								System.err.println("There are non-packages in the direct contents of Resource '" + eCoreResource.getURI() + "' :"+eObject.toString());
							}
						}
					} else {
						System.err.println("Cannot be handled: '" + modelFile.getValue() + "'!");
						return null;
					}
				} else {
					System.err.println("Given modelFile is no '.ecore' File! "+modelFile.getValue());
					return null;
				}
			}
			
		} else {
			System.err.println(MODEL_PARAMETER_USAGE);
		}
		
		//********************************************************************************
		
		if(!rootPackages.isEmpty()){
			if(rootPackages.size()>1){
				System.err.println("Multiple Rootpackages!");
			}
			
			String cfgName = rootPackages.iterator().next().getName(); // First packagename TODO: Multiple Packages!

			//After successful parameter parsing, use ConfiguratorService to do the job
			ConfiguratorService configurator = ServiceHelper.getService(Activator.getContext(), ConfiguratorService.class);
			
			Document similaritiesDOM = configurator.configureService(DefaultSimilaritiesCalculationService.class,  rootPackages.toArray(new EPackage[0]));
			Document matchingDOM = configurator.configureService(IterativeMatchingService.class, rootPackages.toArray(new EPackage[0]));
			
			//Check the required result file parameters
			String folder = resultFolder.getValue();
			if(folder != null){
				if(!folder.endsWith(FILE_SEPERATOR)){
					folder += FILE_SEPERATOR;
				}
				XMLDOMCreator.writeDocument(IOUtil.getOutputStreamIntoFile(folder + cfgName+ MATCHING_CONFIG_SUFFIX), matchingDOM);
				XMLDOMCreator.writeDocument(IOUtil.getOutputStreamIntoFile(folder + cfgName+ SIMILARITIES_CONFIG_SUFFIX), similaritiesDOM);
			}
		}	
		
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {

	}

}

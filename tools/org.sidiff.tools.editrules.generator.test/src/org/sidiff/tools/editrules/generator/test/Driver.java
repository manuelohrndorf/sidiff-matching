package org.sidiff.tools.editrules.generator.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.FileURIHandlerImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.emf.modelstorage.ModelStorage;
import org.sidiff.common.services.ServiceHelper;
import org.sidiff.tools.editrules.generator.EditRulesGeneratingService;
import org.sidiff.tools.editrules.generator.services.HenshinTransformationGenerator;

public class Driver implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		String FILE_SEPERATOR = System.getProperty("file.separator");
		String[] arguments = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);

		File mmBase = new File(new File(arguments[0]).getAbsolutePath() + FILE_SEPERATOR
				+ "org.sidiff.tools.editrules.generator.test" + FILE_SEPERATOR + "metamodels");
		File[] mmDirs = mmBase.listFiles();
		for (int i = 0; i < mmDirs.length; i++) {
			File[] mmFiles = mmDirs[i].listFiles();
			for (int j = 0; j < mmFiles.length; j++) {
				if (mmFiles[j].getAbsolutePath().endsWith("ecore")) {
					System.out.println(mmFiles[j]);

					String INPUT_METAMODEL_PATH = mmFiles[j].getAbsolutePath();
					String INPUT_METAMODEL_RELATIVE_PATH = INPUT_METAMODEL_PATH.substring(mmBase.getAbsolutePath().length());
					String OUTPUT_FOLDER_PATH = INPUT_METAMODEL_PATH.replace("metamodels", "operations") + FILE_SEPERATOR;
					
					String modelKey = ModelStorage.getInstance().loadEMF(new File(INPUT_METAMODEL_PATH).getPath());
					Resource metaModel = ModelStorage.getInstance().getModel(modelKey);
					String mmUri = ((EPackage)metaModel.getContents().get(0)).getNsURI();
					
					// generate
					generate(OUTPUT_FOLDER_PATH, metaModel);
					
					// don't use static EMF, use dynamic EMF
					postProcess(OUTPUT_FOLDER_PATH, mmUri, INPUT_METAMODEL_RELATIVE_PATH);
				}
			}
		}
		
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	private void generate(String OUTPUT_FOLDER_PATH, Resource metaModel) {
		EditRulesGeneratingService generatingService = ServiceHelper.getService(Activator.getContext(),
				EditRulesGeneratingService.class);
		generatingService.generate(HenshinTransformationGenerator.class, OUTPUT_FOLDER_PATH, metaModel);
	}
	
	
	
	public void postProcess( String outPutFolder, String nsUri, String mmRelative ) throws IOException {
		String find =  nsUri + "#";
		String replace = "../../../metamodels" + mmRelative + "#";
       
		File root = new File( outPutFolder);
        File[] list = root.listFiles();

        for ( File f : list ) {
                if (f.isDirectory()){
                	continue;
                }
        		System.out.println( "File:" + f.getAbsoluteFile() );
                Scanner s = new Scanner(f);
            
                String content = s.useDelimiter("\\Z").next();
                content = content.replaceAll(find, replace);
                FileWriter fileWriter = new FileWriter(f);
                fileWriter.write(content);
                fileWriter.close();
        }
    }
}

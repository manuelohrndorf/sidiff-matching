package org.sidiff.resource.converter.relativepath.to.uuid;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.sidiff.common.emf.EMFUtil;

public class RelativePathToUUIDConverter implements IApplication{

	/** Set your path to resouce directory here **/
	private static String pathToResources = "/home/michaela/workspace/runtime-splitjoin/org.silift.modelhistory.maven/models";
	
	/** restrict considers files to filename extension **/
	private static String EXTENSION = "xmi";
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
			
		Path dir = Paths.get(pathToResources);
		
		// file extension filter
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			public boolean accept(Path file) throws IOException {
				return (file.getFileName().toAbsolutePath().toString().endsWith(EXTENSION));
			}
		};
		

		// consider all resources in the path directory
		try (
			DirectoryStream<Path> stream = Files.newDirectoryStream(dir, filter)) {
		    for (Path entry: stream) {
		        	    	
		    	URI inputURI = URI.createFileURI(entry.toAbsolutePath().toString());
		    	URI outputURI = URI.createFileURI(entry.toAbsolutePath().toString()+".converted");
		    	
		    	XMIResourceFactoryImpl resFactory = new XMIResourceFactoryImpl();
				XMIResource resource = (XMIResource) resFactory.createResource(inputURI);
				resource.load(Collections.EMPTY_MAP);
				
				resource.setURI(outputURI);	
				
				Map<Object,Object> saveOptions = new HashMap<Object,Object>();
				saveOptions.put(XMIResource.XMI_ID, Boolean.TRUE);
				
				for(EObject eObject: EMFUtil.getAllContentAsIterable(resource)) {
					EMFUtil.setXmiId(eObject, String.valueOf(System.nanoTime()));
				}
							
				resource.save(saveOptions);
		    	
		    }
		} catch (IOException x) {
		    System.err.println(x);
		}
		
		
		
		
		return null;
	}

	
	@Override
	public void stop() {
		// TODO Auto-generated method stub		
	}

	
	
	
	
}

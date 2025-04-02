package org.sidiff.matching.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.modelstorage.EMFStorage;

public class InputModels {
	
	/**
	 * 
	 */
	private ArrayList<IFile> files;
	
	/**
	 * 
	 */
	private ArrayList<Resource> resources;

	/**
	 * 
	 */
	private String documentType;
	
	/**
	 * 
	 */
	private Set<String> documentTypes;

	/**
	 * 
	 */
	private InputModels(){
		files = new ArrayList<IFile>();
		resources = new ArrayList<Resource>();
	}
	
	/**
	 * @param files
	 */
	public InputModels(IFile[] files) {
		this();
		this.files.addAll(Arrays.asList(files));
		for(int i = 0; i < files.length; i++){
			resources.add(i, getResource(this.files.get(i)));
		}
	}

	/**
	 * @param resources
	 */
	public InputModels(Resource[] resources) {
		this();
		this.resources.addAll(Arrays.asList(resources));
		for(int i = 0; i < resources.length; i++) {
			files.add(i, getFile(this.resources.get(i)));
		}
		
	}

	/**
	 * @param file
	 * @return
	 */
	public Resource getResource(IFile file){
		return EMFStorage.eLoad(EMFStorage.pathToUri(file.getLocation().toOSString())).eResource();
	}
	
	/**
	 * @param resource
	 * @return
	 */
	public IFile getFile(Resource resource){
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(URI.decode(resource.getURI().path())));
	}
	

	/**
	 * @return
	 */
	public String getCharacteristicDocumentType() {
		if (documentType == null) {
			documentType = EMFModelAccess.getCharacteristicDocumentType(resources.get(0));
		}

		return documentType;
	}
	
	/** Returns all document types between input models. This is
	 * the union of all resource document types.
	 * @return
	 */
	public Set<String> getDocumentTypes(){
		if(documentTypes == null){
			documentTypes = EMFModelAccess.getDocumentTypes(resources);
		}
		
		return documentTypes;
	}
	
	/**
	 * @return
	 */
	public ArrayList<Resource> getResources(){
		return resources;
	}

	/**
	 * @return
	 */
	public ArrayList<IFile> getFiles() {
		return files;
	}
	
	/**
	 * 
	 */
	public void swap(){
		Collections.reverse(files);
		Collections.reverse(resources);
	}
}

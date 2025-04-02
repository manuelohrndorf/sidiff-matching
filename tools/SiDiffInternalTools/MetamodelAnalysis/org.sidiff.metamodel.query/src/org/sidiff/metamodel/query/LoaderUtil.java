package org.sidiff.metamodel.query;


import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class LoaderUtil {
	
	
	
	public static EPackage loadAscet(){
		return (EPackage) load("../com.etasgroup.sidiff.datamodel/model/Ascet-Model.ecore");
	}
	
	public static EPackage loadJavaAST(){
		return (EPackage) load("../org.sidiff.javaast.model/model/JavaModel.ecore");
	}
	
	public static EPackage loadEclipseUML2_Ecore(){
		return (EPackage) load("../org.eclipse.uml2.uml/model/UML.ecore");
	}
	
	public static EObject load(String path) {
	    // Initialize the model
	    EcorePackage.eINSTANCE.eClass();
	    
	    // Register the XMI resource factory for the .website extension

	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("ecore", new XMIResourceFactoryImpl());
	    m.put("xmi", new XMIResourceFactoryImpl());
	   
	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // Get the resource
	    Resource resource = resSet.getResource(URI.createURI(path), true);
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    EObject root = resource.getContents().get(0);
	    return root;
	  }

}

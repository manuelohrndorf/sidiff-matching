package org.sidiff.internal.tools.dependencytool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;

import att.grappa.Graph;

public class UMLBuilder {
	
	public Package createClassDiagram(HashMap<String, Plugin> siDiffPluginsMap) {

		UMLPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("uml", new UMLResourceFactoryImpl());
		Resource r = rs.createResource(URI.createFileURI(DependencyCreator.resourcePath + File.separator + DependencyCreator.emptyModel));
		try {
			r.load(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HashMap<String, Package> nodeMap = new HashMap<String, Package>();
		
		Package m = (Package)r.getContents().get(0);
		m.setName("Dependencies");

//		Package p1 = UMLFactory.eINSTANCE.createPackage();
//		p1.setName("Package1");
//		m.getPackagedElements().add(p1);
//		Package p2 = UMLFactory.eINSTANCE.createPackage();
//		p2.setName("Package2");
//		m.getPackagedElements().add(p2);
//		Package p3 = UMLFactory.eINSTANCE.createPackage();
//		p3.setName("Package3");
//		m.getPackagedElements().add(p3);
//		Package p4 = UMLFactory.eINSTANCE.createPackage();
//		p4.setName("Package4");
//		m.getPackagedElements().add(p4);
//		Dependency d1 = UMLFactory.eINSTANCE.createDependency();
//		d1.getClients().add(p2);
//		d1.getSuppliers().add(p1);
//		p2.getPackagedElements().add(d1);
//		Dependency d2 = UMLFactory.eINSTANCE.createDependency();
//		d2.getClients().add(p2);
//		d2.getSuppliers().add(p3);
//		p2.getPackagedElements().add(d2);
//		Dependency d3 = UMLFactory.eINSTANCE.createDependency();
//		d3.getClients().add(p4);
//		d3.getSuppliers().add(p3);
//		p4.getPackagedElements().add(d3);
		
		Vector<String> keySet = new Vector<String>(siDiffPluginsMap.keySet());

		// Knoten erstellen
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String plugin = iterator.next();
			Package p = UMLFactory.eINSTANCE.createPackage();
			p.setName(plugin);
			m.getPackagedElements().add(p);
			nodeMap.put(plugin, p);
		}

		// Kanten erstellen
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String plugin = (String) iterator.next();
			Package parentNode = nodeMap.get(plugin);

			Plugin p = siDiffPluginsMap.get(plugin);
			LinkedList<Plugin> dependencyList = p.sidiffPlugins;

			for (Iterator<Plugin> iterator2 = dependencyList.iterator(); iterator2.hasNext();) {
				Plugin plugin2 = (Plugin) iterator2.next();
				Package childNode = nodeMap.get(plugin2.name);
				
				createDependency(parentNode, childNode);
			}

		}

		r.setURI(URI.createFileURI(DependencyCreator.outputPath + File.separator + DependencyCreator.dependencyModel));
		try {
			r.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	private void createDependency(Package client, Package supplier) {
		Dependency d = UMLFactory.eINSTANCE.createDependency();
		d.getClients().add(client);
		d.getSuppliers().add(supplier);
		client.getPackagedElements().add(d);
	}

}

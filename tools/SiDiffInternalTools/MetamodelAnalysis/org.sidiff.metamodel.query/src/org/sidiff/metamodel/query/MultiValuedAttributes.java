package org.sidiff.metamodel.query;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EPackage;

public class MultiValuedAttributes {
	
	public static void main(String[] args) {
		EPackage mmPackage = LoaderUtil.loadEclipseUML2_Ecore();
		printMultiValuedAttributes(mmPackage);
	}
	
	private static void printMultiValuedAttributes(EPackage p){
		System.out.println("Ordered Attributes ");
		for (EAttribute a : AccessUtil.getAllAttributes(p)) {
			if (a.isMany()){
				PrintUtil.printStructuralFeature(a);
			}
				
			
		}
	}
}

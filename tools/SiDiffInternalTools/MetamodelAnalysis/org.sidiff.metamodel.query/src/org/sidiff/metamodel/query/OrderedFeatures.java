package org.sidiff.metamodel.query;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class OrderedFeatures {
	
	public static void main(String[] args) {
		EPackage mmPackage = LoaderUtil.loadJavaAST();
		printOrderedAttributes(mmPackage);
	}
	
	private static void printOrderedAttributes(EPackage p){
		System.out.println("=== Ordered Attributes ");
		for (EAttribute a : AccessUtil.getAllAttributes(p)) {
			if (a.isOrdered() && a.isMany()){
				PrintUtil.printStructuralFeature(a);
			}
		}
	}
	
	private static void printOrderedStructuralFeatures(EPackage p){
		System.out.println("=== All Ordered EStructural Features ");
		int count = 0;
		for (EStructuralFeature f : AccessUtil.getAllStructuralFeatures(p)) {			
			if (f.isOrdered() && f.isMany()){
				count++;
				PrintUtil.printStructuralFeature(f);
			}
			
		}
		
		System.out.println("=== " + count);
	}
	
	private static void printAllMengenverwaltung(EPackage p){
		System.out.println("=== Mengenverwaltung References ");
		int count = 0;
		for (EReference r : AccessUtil.getAllReferences(p)) {			
			if (r.isContainment() && r.isMany() && r.isOrdered()){
				count++;
				PrintUtil.printStructuralFeature(r);
			}
			
		}
		
		System.out.println("=== " + count);
	}
}

package org.sidiff.metamodel.query;



import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.emf.access.EMFMetaAccess;

public class AccessUtil {
	
	public static Collection<EStructuralFeature> getAllStructuralFeatures(EPackage p){
		Collection<EStructuralFeature> res = new LinkedList<EStructuralFeature>();
		for (EClass eClass : getAllClasses(p)) {
			res.addAll(eClass.getEStructuralFeatures());
		}
		
		return res;
	}
	
	public static Collection<EAttribute> getAllAttributes(EPackage p){
		Collection<EAttribute> res = new LinkedList<EAttribute>();
		for (EClass eClass : getAllClasses(p)) {
			res.addAll(eClass.getEAttributes());
		}
		
		return res;
	}
	
	public static Collection<EReference> getAllReferences(EPackage p){
		Collection<EReference> res = new LinkedList<EReference>();
		for (EClass eClass : getAllClasses(p)) {
			res.addAll(eClass.getEReferences());
		}
		
		return res;
	}
	
	public static Collection<EClassifier> getAllClassifiers(EPackage p){		
		return EMFMetaAccess.getAllMetaClassesForPackage(p);
	}
	
	public static Collection<EClass> getAllClasses(EPackage p){		
		Collection<EClass> res = new LinkedList<EClass>();
		for (EClassifier eClassifier : getAllClassifiers(p)) {
			if (eClassifier instanceof EClass){
				res.add((EClass) eClassifier);
			}
		}
		
		return res;
	}

}

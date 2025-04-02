package org.sidiff.core.configurator.services;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.common.emf.ecore.EClassVisitor;

public abstract class AbstractSimilaritiesCalculatorConfigurator implements EClassVisitor {

	@Override
	public void eClassifier(EClassifier eClassifier, String fullyQualifiedPath) {
		if(eClassifier instanceof EClass && !((EClass) eClassifier).isAbstract()){
			EClass eClass = (EClass) eClassifier;
			createTypeConfiguration(fullyQualifiedPath, eClass, eClass.getEAllReferences(), eClass.getEAllAttributes());
		}
	}
	
	public void finish(){
		//do nothing;
	}
	
	public abstract void createTypeConfiguration(String fullyQualifiedPath, EClass eClass, Collection<EReference> eReferences, Collection<EAttribute> eAttributes);
}

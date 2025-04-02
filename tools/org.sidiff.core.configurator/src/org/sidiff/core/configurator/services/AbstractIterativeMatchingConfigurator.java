package org.sidiff.core.configurator.services;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.sidiff.common.emf.ecore.EClassVisitor;

public abstract class AbstractIterativeMatchingConfigurator implements EClassVisitor {
	
	protected Map<EClass, String> eClasses = new HashMap<EClass, String>();
	
	int abstractCounter = 0;
	int nonAbstractCounter = 0;

	@Override
	public void eClassifier(EClassifier eClassifier, String fullyQualifiedPath) {
		if(eClassifier instanceof EClass && !((EClass) eClassifier).isAbstract()){
			EClass eClass = (EClass) eClassifier;
			createMatchingConfiguration(fullyQualifiedPath, eClass);
			eClasses.put(eClass, fullyQualifiedPath);
			nonAbstractCounter++;
		} else if(eClassifier instanceof EClass){
			EClass eClass = (EClass) eClassifier;
			eClasses.put(eClass, fullyQualifiedPath);
			abstractCounter++;
		}
	}

	public void finish(){
		System.out.println("Non abstract: " + nonAbstractCounter);
		System.out.println("Abstract: " + abstractCounter);

		createSequences(eClasses);
	}
	
	public abstract void createMatchingConfiguration(String fullyQualifiedPath, EClass eClass);

	public abstract void createSequences(Map<EClass, String> eClasses);
}

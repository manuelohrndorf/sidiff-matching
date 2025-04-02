package org.sidiff.tools.editrules.generator.services;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.henshin.model.TransformationSystem;
import org.sidiff.common.emf.ecore.EClassVisitor;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

public abstract class AbstractHenshinTransformationGenerator implements EClassVisitor{

	@Override
	public void eClassifier(EClassifier eClassifier, String fullyQualifiedPath) {
		
		if(eClassifier instanceof EClass) {		
			EClass eClass = (EClass) eClassifier;
			LogUtil.log(LogEvent.NOTICE, "***** " + eClass.getName() + " ***********************************************");
			if(!eClass.isAbstract()) {
				generate_CREATE_And_DELETE_Transformations(eClass);
			}
			generate_Update_Transformation(eClass);
			generate_MOVE_Transformation(eClass);
		}

	}

	@Override
	public void finish() {
		LogUtil.log(LogEvent.NOTICE, "finished");
		
	}

	public abstract void generate_CREATE_And_DELETE_Transformations(EClass eClass);
	
	public abstract void generate_Update_Transformation(EClass eClass);
	
	public abstract void generate_MOVE_Transformation(EClass eClass);
	
	public abstract void serialize(TransformationSystem ts, String outputFileName);
}

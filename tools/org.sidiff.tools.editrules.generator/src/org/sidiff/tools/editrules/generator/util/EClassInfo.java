package org.sidiff.tools.editrules.generator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class EClassInfo {

	private EClass theEClass = null;
		
	private HashMap<EReference, List<EClass>> mandatoryChildren = new HashMap<EReference, List<EClass>>();
	private HashMap<EReference, List<EClass>> mandatoryNeighbours = new HashMap<EReference, List<EClass>>();
	private HashMap<EReference, List<EClass>> mandatoryParentContext = new HashMap<EReference, List<EClass>>();
	private HashMap<EReference, List<EClass>> mandatoryNeighbourContext = new HashMap<EReference, List<EClass>>();
	
	private HashMap<EReference, List<EClass>> optionalChildren = new HashMap<EReference, List<EClass>>();
	private HashMap<EReference, List<EClass>> optionalNeighbours = new HashMap<EReference, List<EClass>>();
	private HashMap<EReference, List<EClass>> optionalParentContext = new HashMap<EReference, List<EClass>>();
	private HashMap<EReference, List<EClass>> optionalNeighbourContext = new HashMap<EReference, List<EClass>>();
	
	private ArrayList<EClass> subTypes = new ArrayList<EClass>();
	private ArrayList<EClass> stereotypes = new ArrayList<EClass>();
	private ArrayList<EClass> extendedMetaClasses = new ArrayList<EClass>();
	
	public enum Map {	MANDATORY_CHILDREN, MANDATORY_NEIGHBOURS, MANDATORY_PARENT_CONTEXT,
						OPTIONAL_CHILDREN,OPTIONAL_NEIGHBOURS, OPTIONAL_PARENT_CONTEXT,OPTIONAL_NEIGHBOUR_CONTEXT;
	}
		
	
	/**	Constructor ************************************************************************/
	
	public EClassInfo(EClass eClass) {
		this.theEClass = eClass;
	}
	
	/** Getter ****************************************************************************/
	
	public HashMap<EReference, List<EClass>> getMandatoryChildren() {
		return mandatoryChildren;
	}
	public HashMap<EReference, List<EClass>> getMandatoryNeighbours() {
		return mandatoryNeighbours;
	}
	public HashMap<EReference, List<EClass>> getMandatoryParentContext() {
		return mandatoryParentContext;
	}
	public HashMap<EReference, List<EClass>> getMandatoryNeighbourContext() {
		return mandatoryNeighbourContext;
	}
	public HashMap<EReference, List<EClass>> getOptionalChildren() {
		return optionalChildren;
	}
	public HashMap<EReference, List<EClass>> getOptionalNeighbours() {
		return optionalNeighbours;
	}
	public HashMap<EReference, List<EClass>> getOptionalParentContext() {
		return optionalParentContext;
	}
	public HashMap<EReference, List<EClass>> getOptionalNeighbourContext() {
		return optionalNeighbourContext;
	}
	public List<EClass> getSubTypes() {
		return subTypes;
	}
	public EClass getTheEClass() {
		return theEClass;
	}	
	public ArrayList<EClass> getStereotypes() {
		return stereotypes;
	}
	public ArrayList<EClass> getExtendedMetaClasses() {
		return extendedMetaClasses;
	}

	/** Setter ****************************************************************************/
	
	public void addExtendedMetaClass(EClass extendedMetaClass) {
		if(!extendedMetaClasses.contains(extendedMetaClass)) {
			extendedMetaClasses.add(extendedMetaClass);
		}
	}
	
	public void addStereotype(EClass stereotype) {
		if(!stereotypes.contains(stereotype)) {
			stereotypes.add(stereotype);
		}
	}
	
	/** Convenience methods ***************************************************************/
	
	public boolean selfMayHaveTransformations(){
		if(!optionalParentContext.isEmpty() || !optionalNeighbourContext.isEmpty()
				|| (mandatoryParentContext.isEmpty() && mandatoryNeighbourContext.isEmpty())) {
			return true;
		}
		return false;
	}
	
	public boolean hasMandatories() {
		if(!mandatoryChildren.isEmpty() || !mandatoryNeighbours.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public ArrayList<EClass> getMandatoryContexts() {
		
		ArrayList<EClass> mandatoryContexts = new ArrayList<EClass>();
		
		for(Entry<EReference, List<EClass>> entry: getMandatoryParentContext().entrySet()) {
			mandatoryContexts.addAll(entry.getValue());
		}		
		for(Entry<EReference, List<EClass>> entry: getMandatoryNeighbourContext().entrySet()) {
			mandatoryContexts.addAll(entry.getValue());
		}
		
		return mandatoryContexts;
	}
}

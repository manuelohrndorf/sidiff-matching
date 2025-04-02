package org.sidiff.similaritiescalculation.configuration;

import java.util.*;

import org.eclipse.emf.ecore.EClass;
import org.sidiff.common.util.StringUtil;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.similaritiescalculation.exceptions.DuplicateCompareItemException;

/**
 * Hold the compare configuration for one type of element.
 *
 */
public class TypeConfiguration {

	private EClass eClass = null;	
	private float threshold =0.0f;

	protected List<ICompareFunction> rwCompareFunctions = null;
	protected List<ICompareFunction> roCompareFunctions = null;

	public TypeConfiguration(EClass eClass,float threshold) {

		this.eClass = eClass;
		this.threshold = threshold;	
		this.rwCompareFunctions = new LinkedList<ICompareFunction>();
		this.roCompareFunctions = Collections.unmodifiableList(this.rwCompareFunctions);
	}
	
	public EClass getType(){
		return this.eClass;
	}

	public float getThreshold() {
		return this.threshold;
	}

	boolean addCompareFunction(ICompareFunction compareFunction) {

		if(!this.rwCompareFunctions.contains(compareFunction)){
			return this.rwCompareFunctions.add(compareFunction);
		} else {
			throw new DuplicateCompareItemException(this,compareFunction);
		}
	}

	public List<ICompareFunction> getCompareFunctions() {
		return this.roCompareFunctions;
		
	}
		
	public String toString(){
		return "NTC("+((eClass!=null)?eClass.getName():"null")+":{"+StringUtil.resolve(this.roCompareFunctions)+"})";
	}
	
}

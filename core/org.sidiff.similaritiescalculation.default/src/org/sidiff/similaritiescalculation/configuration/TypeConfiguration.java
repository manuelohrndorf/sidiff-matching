package org.sidiff.similaritiescalculation.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.sidiff.common.stringresolver.StringUtil;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.similaritiescalculation.exceptions.DuplicateCompareItemException;

/**
 * Hold the compare configuration for one type of element.
 *
 */
public class TypeConfiguration {

	private final EClass eClass;	
	private final float threshold;

	private final List<ICompareFunction> compareFunctions;

	public TypeConfiguration(EClass eClass, float threshold) {
		this.eClass = eClass;
		this.threshold = threshold;	
		this.compareFunctions = new ArrayList<>();
	}

	public EClass getType(){
		return this.eClass;
	}

	public float getThreshold() {
		return this.threshold;
	}

	boolean addCompareFunction(ICompareFunction compareFunction) {
		if(!this.compareFunctions.contains(compareFunction)){
			return this.compareFunctions.add(compareFunction);
		}
		throw new DuplicateCompareItemException(this,compareFunction);
	}

	public List<ICompareFunction> getCompareFunctions() {
		return Collections.unmodifiableList(compareFunctions);
	}

	@Override
	public String toString(){
		return "NTC("+((eClass!=null)?eClass.getName():"null")+":{"+StringUtil.resolve(compareFunctions)+"})";
	}
}

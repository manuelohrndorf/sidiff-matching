package org.sidiff.comparators.impl;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

public class CQName extends AbstractValueComparator {
	public static final String COMPARATOR_ID = "CQName";

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, parameter);
	}

	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA,
			Object elementB) {

		QName elemA = (QName) elementA;
		QName elemB = (QName) elementB;

		if (elemA.equals(elemB))
			return 1;
		else
			return 0;

	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "Qname";
	}
}

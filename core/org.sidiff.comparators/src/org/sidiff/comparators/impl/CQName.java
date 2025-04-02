package org.sidiff.comparators.impl;

import java.util.Optional;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

public class CQName extends AbstractValueComparator {

	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA,
			Object elementB) {

		QName elemA = (QName) elementA;
		QName elemB = (QName) elementB;
		return elemA.equals(elemB) ? 1.0f : 0.0f;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Qname");
	}
}

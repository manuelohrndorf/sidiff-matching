package org.sidiff.metamodel.query;

import org.eclipse.emf.ecore.EStructuralFeature;

public class PrintUtil {

	public static void printStructuralFeature(EStructuralFeature f) {
		System.out.println(f.getEContainingClass().getName() + "."
				+ f.getName() + " [" + getBoundValueAsString(f.getLowerBound())
				+ ".." + getBoundValueAsString(f.getUpperBound()) + "]");
	}

	private static String getBoundValueAsString(int boundValue) {
		if (boundValue < 0) {
			return "*";
		} else {
			return "" + boundValue;
		}
	}
}

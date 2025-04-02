package org.sidiff.uml.query;

import java.util.Collection;

import org.eclipse.uml2.uml.Property;

public class PrintUtil {

	public static void print(Collection<Property> props){		
		System.out.println(props.size());
		for (Property property : props) {
			PrintUtil.printProperty(property);
		}
	}
	
	public static void printProperty(Property f) {
		System.out.println(f.getFeaturingClassifiers().get(0).getName() + "."
				+ f.getName() + " [" + getBoundValueAsString(f.getLower())
				+ ".." + getBoundValueAsString(f.getUpper()) + "]");
	}

	private static String getBoundValueAsString(int boundValue) {
		if (boundValue < 0) {
			return "*";
		} else {
			return "" + boundValue;
		}
	}
}

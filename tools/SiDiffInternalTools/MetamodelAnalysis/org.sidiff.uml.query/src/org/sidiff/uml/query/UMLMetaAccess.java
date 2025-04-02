package org.sidiff.uml.query;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

public class UMLMetaAccess {
		
	public static Collection<Property> getAllManyRedefinedReferences(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllReferences(p)) {
			if (prop.isMultivalued() && !prop.getRedefinedElements().isEmpty() && hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllManyRedefinedAttributes(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllAttributes(p)) {
			if (prop.isMultivalued() && !prop.getRedefinedElements().isEmpty() && hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllManyNonUniqueReferences(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllReferences(p)) {
			if (prop.isMultivalued() && !prop.isUnique() && hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllManyNonContainmentReferences(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllReferences(p)) {
			if (prop.isMultivalued() && !prop.isComposite() && hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllManyReferences(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllReferences(p)) {
			if (prop.isMultivalued() && hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllManyNonUniqueAttributes(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllAttributes(p)) {
			if (prop.isMultivalued() && !prop.isUnique() && hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllManyAttributes(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllAttributes(p)) {
			if (prop.isMultivalued() && hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllReferences(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllReferences(p)) {
			if (hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllAttributes(Package p, EStructuralFeature[] mofAttrs) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllAttributes(p)) {
			if (hasAllMOFAttrsTrue(prop, mofAttrs)){
				res.add(prop);
			}
		}

		return res;
	}

	public static Collection<Property> getAllAttributes(Package p) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllProperties(p)) {
			if (prop.getAssociation() == null) {
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllReferences(Package p) {
		Collection<Property> res = new LinkedList<Property>();
		for (Property prop : getAllProperties(p)) {
			if (prop.getAssociation() != null) {
				res.add(prop);
			}
		}

		return res;
	}
	
	public static Collection<Property> getAllProperties(Package p) {
		Collection<Property> res = new LinkedList<Property>();
		for (Class c : getAllMetaclassesForPackage(p)) {
			res.addAll(c.getAttributes());
		}

		return res;
	}

	public static Collection<Class> getAllMetaclassesForPackage(Package p) {
		List<Class> result = new LinkedList<Class>();
		for (Element element : p.getOwnedElements()) {
			if (element instanceof Class) {
				result.add((Class) element);
			}
		}
		for (Package sub : p.getNestedPackages())
			result.addAll(getAllMetaclassesForPackage(sub));
		return result;
	}
	
	private static boolean hasAllMOFAttrsTrue(Property property, EStructuralFeature[] mofAttrs){
		for (EStructuralFeature eStructuralFeature : mofAttrs) {
			boolean has = (Boolean) property.eGet(eStructuralFeature);
			if (!has){
				return false;
			}
		}
		
		return true;
	}
}

package org.sidiff.matching.model.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.stringresolver.StringUtil;

public class CorrespondenceModelStringUtil {

	/**
	 * Haengt ein Object, welches selbst von StringUtil resolved wird, an einen StringBuffer an.
	 * Dazu kann ein Titel gegeben werden, der die Bedeutung des Objekts erklaert.
	 * Ist das Object eine Collection, so wird jedes Object in der Collection resolved.
	 * 
	 * @param result Der verwendete StringBuffer
	 * @param object Das anzuhaengende Objekt
	 * @param depth Die Tiefe der Einrueckung
	 */
	static void appendSomething(StringBuilder result, int depth, Object... objects) {
		if(objects.length == 1){
			result.append(objects[0]);
		} else if(objects.length > 1) {
			for(Object obj : objects) {	
				StringUtil.appendIndentation(result, computeDepth((EObject)obj), true);
				result.append(StringUtil.resolve(obj));
			}
		}
	}

	static void appendSomething(StringBuilder result, int depth, Collection<?> coll) {
		for(Object obj : coll) {
			StringUtil.appendIndentation(result, computeDepth((EObject)obj), true);
			result.append(StringUtil.resolve(obj));
		}
	}
	
	/**
	 * Berechnet die Einruecktiefe fuer einen String 
	 * @param eObj
	 * @return
	 */
	static int computeDepth(EObject eObj) {
		int depth = 0;
		EObject container = eObj;
		while(container.eContainer() != null) {
			container = container.eContainer();
			depth = depth + 2;
		}
		return depth;
	}

}

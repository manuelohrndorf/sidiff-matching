package org.sidiff.matching.signature.annotated;

import java.util.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.common.collections.ValueMap;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.access.tree.TreeVisitorAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

public class SignatureValueMatcher extends TreeVisitorAdapter {

	private MatchingContext context = null;
	private ValueMap<String, EObject> sigValuesA = null;
	private ValueMap<String, EObject> sigValuesB = null;

	public SignatureValueMatcher(MatchingContext context,ValueMap<String, EObject> sigValuesA, ValueMap<String, EObject> sigValuesB) {
		assert (sigValuesA != null) : "Missing Signature-Values (A - null)";
		assert (sigValuesB != null) : "Missing Signature-Values (B - null)";
		this.context = context;
		this.sigValuesA = sigValuesA;
		this.sigValuesB = sigValuesB;
	}

	@Override
	public boolean preExecute(EObject objectB) {
		// TOP-DOWN
		if (this.sigValuesB.containsObject(objectB)) {
			String sigValue = this.sigValuesB.getValue(objectB);
			if (this.sigValuesA.containsValue(sigValue)) {
				EObject objectA = null;
				// Hash value present in both models, try to match current Object

				if (this.sigValuesA.isUnique(sigValue) && this.sigValuesB.isUnique(sigValue)) {
					// exact one partner, hopefully most recent case
					// A <-> A
					Iterator<EObject> iter = this.sigValuesA.getObjects(sigValue).iterator();
					assert (iter.hasNext()) : "Not Unique?";
					objectA = iter.next();
					assert (!iter.hasNext()) : "Not Unique?";
				} else {
					// ambiguous value, try to find unique partner by matched parents
					// A,A <-> A or A,A <-> A,A or A <-> A,A und beliebigen verschiebungen (global wie lokal)
					// (Wenn verschiebungen nicht erlaubt waeren, dann muesste dies die Hashwertbildung bereits beruecksichtigen!)

					Collection<EObject> objectsA = new LinkedList<EObject>(sigValuesA.getObjects(sigValue));
					Collection<EObject> objectsB = new LinkedList<EObject>(sigValuesB.getObjects(sigValue));

					assert (objectsA.size() > 1 && !objectsB.isEmpty() || objectsB.size() > 1 && !objectsA.isEmpty()) : "Not ambiguous ?";

					// Im folgenden wird als seiteneffekt objectsA/objectsB entsprechend des betrachteten
					// kriteriums verkleiner, bis eindeutigkeit hergestellt ist (true)
					if (((!objectsA.isEmpty()) && reduceToMatchedParents(objectsA, objectsB, objectB)) // Container Untersuchen
							|| ((!objectsA.isEmpty()) && reduceToUnmatchedParents(objectsA, objectsB, objectB)) // Ausschlussprinzip
							|| ((!objectsA.isEmpty()) && reduceToSamePathAnnotation(objectsA, objectsB, objectB)) // Pfad Annotation betrachten
							|| ((!objectsA.isEmpty()) && reduceToContainment(objectsA, objectsB, objectB)) // Containment Assoziation berachten
							|| ((!objectsA.isEmpty()) && reduceToPosition(objectsA, objectsB, objectB))) { // ggf. Position im Container beachten

						// Wir konnten einen eindeutigen Partner bestimmen!
						Iterator<EObject> iter = objectsA.iterator();
						assert (iter.hasNext()) : "Not Unique?";
						objectA = iter.next();
						assert (!iter.hasNext()) : "Not Unique?";

					} else {
						// No Way... giving up
						assert (LogUtil.log(LogEvent.DEBUG, "Cannot resolve ambiguous situation:", objectB, sigValue, "\n", "A:->", objectsA, "\n", "B:->", objectsB, "\n"));
					} // ambiguous situation hopefully resolved
				}

				// Perform Matching, if we found a suitable partner
				if (objectA != null && context.isMatchPermitted(objectA, objectB)) {
					this.context.match(this, objectA, objectB);
					this.sigValuesA.removeObject(objectA);
					this.sigValuesB.removeObject(objectB);
				}

			} // else no equal hash for objectA
		} // else no hash for objectB
		return true;
	}

	/**
	 * Reduziert die uneindeutige Menge potenteller Partner auf diejenigen, die ggf. auf grund eines gematchten Containers in Frage kommen. Anders als man vielleicht erwarten w�rde, impliziert der Match der Container nicht automatisch eindeutigkeit:
	 * 
	 * - - |X| <-> |X| --- --- m| |n m| |n A A A A
	 * 
	 * Anderseits kann es aber auch passieren, dass der Container von objectB anderweilig gematcht ist, sodass keine kandidaten aus ambiguousObjectsA mehr �brig bleiben. IdR. ist jedoch eindeutigkeit gegeben.
	 * 
	 * @param ambiguousObjectsA
	 *            Uneindeutige menge von Objekten mit gleichem Hashwert aus A
	 * @param ambiguousObjectsB
	 *            Uneindeutige menge von Objekten mit gleichem Hashwert aus B
	 * @param scopeObjectB
	 *            Element aus ambiguousObjectsB, auf dem gerade der Scope liegt.
	 * 
	 * @return true, falls auf genau einen partner reduziert werden konnte.
	 */
	private boolean reduceToMatchedParents(Collection<EObject> ambiguousObjectsA, Collection<EObject> ambiguousObjectsB, EObject scopeObjectB) {
		assert (ambiguousObjectsB != null && ambiguousObjectsB.contains(scopeObjectB));
		assert (ambiguousObjectsA != null && (ambiguousObjectsA.size() > 1 || ambiguousObjectsB.size() > 1)) : "not ambiguous?!";

		EObject containerOfB = scopeObjectB.eContainer();
		// Wenn der Container von objectB keinen Match besitzt bleibt alles wie es ist...
		if (context.hasMatch(containerOfB)) {
			for (Iterator<EObject> iterA = ambiguousObjectsA.iterator(); iterA.hasNext();) {
				EObject containerOfA = iterA.next().eContainer();
				if (context.hasMatched(containerOfA, containerOfB)) {
					// Matched Containers - What we are looking for... Skip all other
					while (iterA.hasNext()) {
						if (iterA.next().eContainer() != containerOfA)
							iterA.remove();
					}
					for (Iterator<EObject> iterB = ambiguousObjectsB.iterator(); iterB.hasNext();) {
						if (iterB.next().eContainer() != containerOfB)
							iterB.remove();
					}
				} else {
					iterA.remove();
				}
			}
		}
		assert (ambiguousObjectsB.contains(scopeObjectB));
		return (ambiguousObjectsA.size() == 1 && ambiguousObjectsB.size() == 1);
	}

	/**
	 * Reduziert die uneindeutige Menge potenteller Partner auf die, deren Container (wie der Container des scopeObjects) nicht gematched wurden; Falls der Container des Scope Objectes doch gematcht wurde bleiben die Mengen der "ambiguousObjects"
	 * unver�ndert! Ein entsprechender aufruf kann vorkommen, falls mehrere objekt in einem gematchten Container uneindeutig sind!
	 * 
	 * @param ambiguousObjectsA
	 *            Uneindeutige menge von Objekten mit gleichem Hashwert aus A
	 * @param ambiguousObjectsB
	 *            Uneindeutige menge von Objekten mit gleichem Hashwert aus B
	 * @param scopeObjectB
	 *            Element aus ambiguousObjectsB, auf dem gerade der Scope liegt.
	 * 
	 * @return true, falls auf genau einen partner reduziert werden konnte.
	 */
	private boolean reduceToUnmatchedParents(Collection<EObject> ambiguousObjectsA, Collection<EObject> ambiguousObjectsB, EObject scopeObjectB) {
		assert (ambiguousObjectsB.contains(scopeObjectB) && !ambiguousObjectsA.isEmpty());

		// Ausschlussprinzip darf nur angewendet werden, sofern der Container des "Objektes im Scope" nicht gematched wurde!
		if (!context.hasMatch(scopeObjectB.eContainer())) {
			for (Iterator<EObject> iterA = ambiguousObjectsA.iterator(); iterA.hasNext();) {
				if (context.hasMatch(iterA.next().eContainer()))
					iterA.remove();
			}
			for (Iterator<EObject> iterB = ambiguousObjectsB.iterator(); iterB.hasNext();) {
				if (context.hasMatch(iterB.next().eContainer()))
					iterB.remove();
			}
		}

		assert (ambiguousObjectsB.contains(scopeObjectB));
		return (ambiguousObjectsA.size() == 1 && ambiguousObjectsB.size() == 1);
	}

	private boolean reduceToSamePathAnnotation(Collection<EObject> ambiguousObjectsA, Collection<EObject> ambiguousObjectsB, EObject scopeObjectB) {
		assert (ambiguousObjectsB.contains(scopeObjectB) && !ambiguousObjectsA.isEmpty());

		String expectedAnnotation = EMFAdapter.INSTANCE.adapt(scopeObjectB, AnnotateableElement.class).getAnnotation(MatchingContext.PATH_ANNOTATION, String.class);
		if (expectedAnnotation != null) {
			for (Iterator<EObject> iterA = ambiguousObjectsA.iterator(); iterA.hasNext();) {
				if (!expectedAnnotation.equals(EMFAdapter.INSTANCE.adapt(iterA.next(), AnnotateableElement.class).getAnnotation(MatchingContext.PATH_ANNOTATION, String.class)))
					iterA.remove();
			}
			for (Iterator<EObject> iterB = ambiguousObjectsB.iterator(); iterB.hasNext();) {
				if (!expectedAnnotation.equals(EMFAdapter.INSTANCE.adapt(iterB.next(), AnnotateableElement.class).getAnnotation(MatchingContext.PATH_ANNOTATION, String.class)))
					iterB.remove();
			}
		}

		assert (ambiguousObjectsB.contains(scopeObjectB));
		return (ambiguousObjectsA.size() == 1 && ambiguousObjectsB.size() == 1);
	}

	private boolean reduceToContainment(Collection<EObject> ambiguousObjectsA, Collection<EObject> ambiguousObjectsB, EObject scopeObjectB) {
		assert (ambiguousObjectsB.contains(scopeObjectB) && !ambiguousObjectsA.isEmpty());

		EReference expectedContainment = scopeObjectB.eContainmentFeature();

		for (Iterator<EObject> iterA = ambiguousObjectsA.iterator(); iterA.hasNext();) {
			if (iterA.next().eContainmentFeature() != expectedContainment)
				iterA.remove();
		}
		for (Iterator<EObject> iterB = ambiguousObjectsB.iterator(); iterB.hasNext();) {
			if (iterB.next().eContainmentFeature() != expectedContainment)
				iterB.remove();
		}

		assert (ambiguousObjectsB.contains(scopeObjectB));
		return (ambiguousObjectsA.size() == 1 && ambiguousObjectsB.size() == 1);
	}

	@SuppressWarnings("unchecked")
	private boolean reduceToPosition(Collection<EObject> ambiguousObjectsA, Collection<EObject> ambiguousObjectsB, EObject scopeObjectB) {
		assert (ambiguousObjectsB.contains(scopeObjectB) && !ambiguousObjectsA.isEmpty());
		EReference containmentFeature = scopeObjectB.eContainmentFeature();
		if (containmentFeature.isOrdered() && containmentFeature.isMany()) {

			int myIndex = ((EList<EObject>) scopeObjectB.eContainer().eGet(containmentFeature)).indexOf(scopeObjectB);
			for (Iterator<EObject> iterA = ambiguousObjectsA.iterator(); iterA.hasNext();) {
				EObject ambiguousObjectA = iterA.next();
				if (myIndex != ((EList<EObject>) ambiguousObjectA.eContainer().eGet(containmentFeature)).indexOf(ambiguousObjectA))
					iterA.remove();
			}
			for (Iterator<EObject> iterB = ambiguousObjectsB.iterator(); iterB.hasNext();) {
				EObject ambiguousObjectB = iterB.next();
				if (myIndex != ((EList<EObject>) ambiguousObjectB.eContainer().eGet(containmentFeature)).indexOf(ambiguousObjectB))
					iterB.remove();
			}
		} else {
			if (containmentFeature.isOrdered() && !containmentFeature.isMany())
				LogUtil.log(LogEvent.WARNING, "Error in model: Feature is ordered, but has a cardinality of 1: " + scopeObjectB + ", " + containmentFeature);
		}
		assert (ambiguousObjectsB.contains(scopeObjectB));
		return (ambiguousObjectsA.size() == 1 && ambiguousObjectsB.size() == 1);
	}
}

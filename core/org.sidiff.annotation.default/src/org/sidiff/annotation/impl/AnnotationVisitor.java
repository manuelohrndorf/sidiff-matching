package org.sidiff.annotation.impl;

import java.util.*;

import org.eclipse.emf.ecore.*;
import org.sidiff.annotator.IAnnotator;
import org.sidiff.common.emf.access.tree.TreeVisitor;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;

/**
 * Optimiertes ausfuehren einer gegebenen (ausfuehrbaren) Menge von Keys.
 * 
 * @author Maik Schmidt
 *
 */
public class AnnotationVisitor implements TreeVisitor {

	private Map<EClass, Collection<IAnnotator>> pre = null;
	private Map<EClass, Collection<IAnnotator>> post = null;

	private Set<String> keySet = null;
	private Map<String, Map<EClass, IAnnotator>> configuration = null;

	public AnnotationVisitor(Map<String, Map<EClass, IAnnotator>> configuration, Set<String> keys) {

		this.keySet = keys;
		this.configuration = configuration;

		this.pre = new HashMap<EClass, Collection<IAnnotator>>();
		this.post = new HashMap<EClass, Collection<IAnnotator>>();
	}

	private Collection<IAnnotator> lookup(EClass eClass) {

		Collection<IAnnotator> pre4class = new LinkedList<IAnnotator>();
		Collection<IAnnotator> post4class = new LinkedList<IAnnotator>();

		// Determinate matching annotator set
		for (String key : this.keySet) { // Annotator for each key
			Map<EClass, IAnnotator> annotators4key = this.configuration.get(key);

			IAnnotator annotator = annotators4key.get(eClass);
			if (annotator == null) {

				// No Annotator found, so have a look to superclasses
				Collection<EClass> superClasses = eClass.getESuperTypes();
				while (!superClasses.isEmpty()) {

					Collection<EClass> superSuperClasses = new HashSet<EClass>();
					for (EClass superClass : superClasses) {
						annotator = annotators4key.get(superClass);
						if (annotator != null) {
							break;
						}
						superSuperClasses.addAll(superClass.getESuperTypes());
					}
					superClasses = superSuperClasses;

					// if we have already found an appropriate annotator, we
					// have to stop searching
					if (annotator != null) {
						break;
					}
				}
			}

			if (annotator == null) {
				annotator = annotators4key.get(EcorePackage.eINSTANCE.getEObject());
			}

			if (annotator != null) {
				if (annotator.getOrder() == IAnnotator.ExecutionOrder.PRE) {
					pre4class.add(annotator);
				} else {
					post4class.add(annotator);
				}
			} else {
				assert (LogUtil.log(LogEvent.DEBUG, "Class " + eClass.getName() + " cannot be annotated with " + key
						+ " (missing annotator)"));
			}
		}

		post.put(eClass, post4class);
		pre.put(eClass, pre4class);

		return pre4class; // called while preorder execution
	}

	@Override
	public void postExecute(EObject object) {
		assert (post.get(object.eClass()) != null) : "Internal Error - Precondition Fail";

		Collection<IAnnotator> annotators = post.get(object.eClass());
		for (IAnnotator annotator : annotators) {
			annotator.annotate(object);
		}
	}

	@Override
	public boolean preExecute(EObject object) {

		Collection<IAnnotator> annotators = pre.get(object.eClass());
		if (annotators == null) {
			annotators = lookup(object.eClass());
		}

		for (IAnnotator annotator : annotators) {
			annotator.annotate(object);
		}
		return true;
	}
}

package org.sidiff.annotation.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.annotation.IAnnotation;
import org.sidiff.annotation.impl.exceptions.AnnotationException;
import org.sidiff.annotator.IAnnotator;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.common.extension.configuration.BasicExtensionConfiguration;
import org.sidiff.common.extension.configuration.ConfigurationOption;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.common.io.ResourceUtil;
import org.sidiff.configuration.ConfigurationManagement;
import org.sidiff.configuration.IConfiguration;
import org.w3c.dom.Document;

/**
 * default implementation of the IAnnotationService
 *
 */
public class DefaultAnnotation implements IAnnotation {

	public static final String EXECUTED_ANNOTATIONS = "org.sidiff.annotationservice.Annotator.executedAnnotations";

	// Holds Annotators by Type
	private Map<String, Map<EClass, IAnnotator>> annotators = new TreeMap<String, Map<EClass, IAnnotator>>();
	private Map<String, Set<String>> keyDependencies = new TreeMap<String, Set<String>>();
	
	private ConfigurationOption<Document> annotationConfigDocument;
	private IExtensionConfiguration configuration;

	public DefaultAnnotation() {
		annotationConfigDocument = ConfigurationOption.builder(Document.class).key("configDocument").build();
		configuration = new BasicExtensionConfiguration(Collections.singleton(annotationConfigDocument)); 
	}
	
	@Override
	public void init(Resource model) throws IOException {
		reset();
		if(!annotationConfigDocument.isSet()) {
			annotationConfigDocument.setValue(ConfigurationManagement.getInstance(EMFModelAccess.getDocumentType(model))
					.getRandomConfiguration(IConfiguration.CONFIG_TYPE_ANNOTATION));			
		}
		if(annotationConfigDocument.isSet()) {
			configure(annotationConfigDocument.getValue());
		}
	}

	@Override
	public void annotate(Resource model) {
		// Annotate all
		internal_annotate(model, keyDependencies.keySet());
	}

	@Override
	public void removeAnnotations(Resource model) {
		// Remove all
		internal_remove(model, keyDependencies.keySet());

	}

	@Override
	public void annotate(Resource model, Set<String> keySet) {
		if (keyDependencies.keySet().containsAll(keySet)) {
			internal_annotate(model, computeTransitiveClosure(keySet));
		} else {
			throw new AnnotationException("Set contains non configured key!" + keySet);
		}
	}

	@Override
	public void removeAnnotations(Resource model, Set<String> keySet) {

		if (keyDependencies.keySet().containsAll(keySet)) {
			internal_remove(model, keySet);
		} else {
			throw new AnnotationException("Set contains non configured key!" + keySet);
		}
	}

	@Override
	public void annotate(Resource model, String key) {

		// Annotate known Key
		if (keyDependencies.containsKey(key)) {
			annotate(model, Collections.singleton(key));
		} else {
			throw new IllegalArgumentException("Unknown annotation key " + key);
		}

	}

	@Override
	public void removeAnnotations(Resource model, String key) {

		if (keyDependencies.containsKey(key)) {
			internal_remove(model, Collections.singleton(key));
		}
	}

	public Set<String> availableKeys() {

		return this.keyDependencies.keySet();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<String> executedKeys(Resource model) {
		AnnotateableElement aobject = EMFAdapter.INSTANCE.adapt(model, AnnotateableElement.class);
		return Collections.unmodifiableSet(aobject.getOrCreateAnnotation(EXECUTED_ANNOTATIONS, SortedSet.class));
	}

	public void configure(Document configData) {
		reset();
		try {
			ResourceUtil.registerClassLoader(this.getClass().getClassLoader());
			XMLConfigurationHandler xmlConfigurationHandler = new XMLConfigurationHandler();
			xmlConfigurationHandler.parseConfiguration(configData);
			configureAnnotators(xmlConfigurationHandler.getAnnotators());			
		} finally {
			ResourceUtil.unregisterClassLoader(this.getClass().getClassLoader());			
		}
	}

	public Dictionary<String, String> getProperties() {
		// no special properties
		return null;
	}

	/**
	 * 
	 * configure the given Annotators
	 * 
	 * @param annotators
	 */
	private void configureAnnotators(Collection<IAnnotator> annotators) {

		for (IAnnotator annotator : annotators) {
			String key = annotator.getAnnotationKey();

			// Eintragen des Annotators
			Map<EClass, IAnnotator> annotators4key = this.annotators.get(key);
			if (annotators4key == null) {
				annotators4key = new HashMap<EClass, IAnnotator>();
				this.annotators.put(key, annotators4key);
			}

			if (annotators4key.containsKey(annotator.getType())) {
				throw new IllegalArgumentException("Invalid Configuration! Duplicate entry for key " + key
						+ " of type " + annotator.getType().getName());
			}

			annotators4key.put(annotator.getType(), annotator);

			// Eintragen der abbhaengigkeiten
			Set<String> dependencies = this.keyDependencies.get(key);
			if (dependencies == null) {
				dependencies = new HashSet<String>();
				this.keyDependencies.put(key, dependencies);
			}
			dependencies.addAll(annotator.getRequiredAnnotations());
		}

		// Check Configuration...
		computeTransitiveClosure(this.keyDependencies.keySet());
	}

	private Set<String> computeTransitiveClosure(Set<String> keys) {

		Set<String> closure = new HashSet<String>();

		for (String key : keys) {
			computeTransitiveClosure(key, closure, new HashSet<String>());
			closure.add(key);
		}

		return closure;
	}

	private Set<String> computeTransitiveClosure(String key, Set<String> closure, Set<String> visited) {

		if (this.keyDependencies.containsKey(key) && !visited.contains(key)) {
			// key is configured and has not been visited before.
			visited.add(key); // current top down run

			closure.add(key); // add to common closure
			Collection<String> dependencies = this.keyDependencies.get(key);
			for (String dependency : dependencies) {
				if (!closure.contains(dependency)) {
					// not been visited before -> go down
					computeTransitiveClosure(dependency, closure, visited);
				}
			}
			visited.remove(key); // going up
		} else {
			throw new AnnotationException("Unaccomplishable key '" + key + "' (non provided requirement or cycle)");
		}

		return closure;
	}

	/**
	 * Interne Methode zum durchfuehren der annotationen.
	 * 
	 * @param model
	 *            Das zu annotierende Modell.
	 * @param keySet
	 *            Die Menge der zu annotierenden Keys.
	 */
	@SuppressWarnings("unchecked")
	private void internal_annotate(Resource model, Set<String> keys) {

		AnnotateableElement aobject = EMFAdapter.INSTANCE.adapt(model, AnnotateableElement.class);

		Set<String> providedKeys = aobject.getOrCreateAnnotation(EXECUTED_ANNOTATIONS, HashSet.class);
		Set<String> openKeys = new HashSet<String>(keys);

		// perform missing annotations
		openKeys.removeAll(providedKeys);

		while (!openKeys.isEmpty()) {

			Set<String> executeable = computeExecuteableKeys(openKeys, providedKeys);
			if (!executeable.isEmpty()) {
				AnnotationVisitor visitor = new AnnotationVisitor(this.annotators, executeable);
				openKeys.removeAll(executeable);
				EMFModelAccess.traverse(model, visitor);
				providedKeys.addAll(executeable);
			} else {
				throw new AnnotationException("No more executable Keys '" + openKeys + "'");
			}
		}
	}

	/**
	 * method  removes the annotations, which are annotated with the given key 
	 * 
	 * @param model
	 * @param keys
	 */
	@SuppressWarnings("unchecked")
	private void internal_remove(Resource model, Set<String> keys) {

		AnnotateableElement aobject = EMFAdapter.INSTANCE.adapt(model, AnnotateableElement.class);
		Set<String> computedKeys = aobject.getOrCreateAnnotation(EXECUTED_ANNOTATIONS, HashSet.class);

		Set<String> keysToRemove = new HashSet<String>(keys);
		keysToRemove.retainAll(computedKeys); // Nur tatsaechlich berechnete
		computedKeys.removeAll(keysToRemove);

		Set<String> partition = computeTransitiveClosure(computedKeys);
		if (computedKeys.containsAll(partition)) {
			// We don't break any dependency, so we can proceed
			RemoveAnnotationVisitor remove = new RemoveAnnotationVisitor(keysToRemove);
			EMFModelAccess.traverse(model, remove);
		} else {
			partition.removeAll(computedKeys);
			throw new AnnotationException("Revokation of '" + keys + "' breaks dependencies:" + partition);
		}
	}

	private Set<String> computeExecuteableKeys(Set<String> openKeys, Set<String> providedKeys) {

		Set<String> executeable = new HashSet<String>();
		for (String key : openKeys) {
			if (providedKeys.containsAll(this.keyDependencies.get(key))) {
				executeable.add(key);
			}
		}
		return executeable;
	}

	@Override
	public String getKey() {
		return "DefaultAnnotation";
	}

	@Override
	public void reset() {
		// Drop Configuration
		this.annotators.clear();
		this.keyDependencies.clear();
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This is the AnnotationService. It can be configured by an XML Configuration.");
	}

	@Override
	public IExtensionConfiguration getConfiguration() {
		return configuration;
	}
}

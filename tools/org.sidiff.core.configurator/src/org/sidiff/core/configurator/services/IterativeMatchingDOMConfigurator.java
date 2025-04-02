package org.sidiff.core.configurator.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class IterativeMatchingDOMConfigurator extends
		AbstractIterativeMatchingConfigurator {

	// Nodes
	private static final String NODE_ROOT = "Matching";
	private static final String NODE_SETTINGS = "Settings";
	private static final String NODE_CONFIGURATIONS = "Configurations";
	private static final String NODE_SEQUENCE = "Sequence";
	private static final String NODE_MATCHING_CONFIGURATION = "MatchingConfiguration";
	private static final String NODE_Class = "Class";

	// Attributes of Settings
	private static final String S_ATTRIBUTE_MATCHER_PREFIX = "matcherPrefix";
	private static final String S_ATTRIBUTE_DOCUMENT_TYPE = "documentType";
	private static final String S_ATTRIBUTE_FIRST_PASS_SEQUENCED_MATCHER = "firstPassSequencedMatcher";
	private static final String S_ATTRIBUTE_DEFAULT_SEQUENCED_MATCHER = "defaultSequencedMatcher";
	private static final String S_ATTRIBUTE_DEFAULT_TOP_DOWN_MATCHER = "defaultTopDownMatcher";

	// Attributes of MatchingConfiguration
	private static final String MC_ATTRIBUTE_CLASSNAME = "className";
	private static final String MC_ATTRIBUTE_THRESHOLD = "threshold";
	private static final String MC_ATTRIBUTE_ALLOW_LOCAL_MOVE = "allowLocalMove";
	private static final String MC_ATTRIBUTE_ALLOW_GLOBAL_MOVE = "allowGlobalMove";
	private static final String MC_ATTRIBUTE_ALWAYS_COMPUTE_SIMILARITY = "alwaysComputeSimilarity";
	private static final String MC_ATTRIBUTE_INDEPENDENT_MATCHING = "independentMatching";
	private static final String MC_ATTRIBUTE_TOP_DOWN_MATCHER = "topDownMatcher";

	// Attribute of Class
	private static final String C_ATTRIBUTE_NAME = "name";

	// Settings Default values
	private static final String DEFAULT_MATCHER_PREFIX = "org.sidiff.core.matching.matcher";
	private static final String DEFAULT_FIRST_PASS_SEQUENCED_MATCHER = "UniqueSimilarityMatcher";
	private static final String DEFAULT_DEFAULT_SEQUENCED_MATCHER = "DefaultMatcher";
	private static final String DEFAULT_DEFAULT_TOP_DOWN_MATCHER = "Propagation";

	// Boolean values
	// private static final String FALSE = "false";
	private static final String TRUE = "true";

	// TopDownMatcher values
	private static final String TOP_DOWN_MATCHER_DEFAULT = "";
	private static final String TOP_DOWN_MATCHER_NO_PROPAGATION = "NoPropagation";

	// the document
	private Document document = null;

	// first level nodes
	private Element root = null;
	private Element settings = null;
	private Element configurations = null;
	private Element sequence = null;

	// sequence computation
	private Set<EClass> handledClasses = null;
	private List<Element> sequences = null;

	private Set<EClass> nodes = new HashSet<EClass>();

	// private int maxRecursiveDepth = 10;

	public IterativeMatchingDOMConfigurator(Document document,
			String documentTypeURI) {
		this.document = document;

		handledClasses = new HashSet<EClass>();

		// create root
		root = document.createElement(NODE_ROOT);
		document.appendChild(root);

		// create first level nodes
		settings = document.createElement(NODE_SETTINGS);
		root.appendChild(settings);

		configurations = document.createElement(NODE_CONFIGURATIONS);
		root.appendChild(configurations);

		sequence = document.createElement(NODE_SEQUENCE);
		root.appendChild(sequence);

		// create settings attributes
		Attr matcherPrefix = document
				.createAttribute(S_ATTRIBUTE_MATCHER_PREFIX);
		matcherPrefix.setNodeValue(DEFAULT_MATCHER_PREFIX);
		settings.setAttributeNode(matcherPrefix);

		Attr documentType = document.createAttribute(S_ATTRIBUTE_DOCUMENT_TYPE);
		documentType.setNodeValue(documentTypeURI);
		settings.setAttributeNode(documentType);

		Attr firstPassSequencedMatcher = document
				.createAttribute(S_ATTRIBUTE_FIRST_PASS_SEQUENCED_MATCHER);
		firstPassSequencedMatcher
				.setNodeValue(DEFAULT_FIRST_PASS_SEQUENCED_MATCHER);
		settings.setAttributeNode(firstPassSequencedMatcher);

		Attr defaultSequencedMatcher = document
				.createAttribute(S_ATTRIBUTE_DEFAULT_SEQUENCED_MATCHER);
		defaultSequencedMatcher.setNodeValue(DEFAULT_DEFAULT_SEQUENCED_MATCHER);
		settings.setAttributeNode(defaultSequencedMatcher);

		Attr defaultTopDownMatcher = document
				.createAttribute(S_ATTRIBUTE_DEFAULT_TOP_DOWN_MATCHER);
		defaultTopDownMatcher.setNodeValue(DEFAULT_DEFAULT_TOP_DOWN_MATCHER);
		settings.setAttributeNode(defaultTopDownMatcher);
	}

	@Override
	public void createMatchingConfiguration(String fullyQualifiedPath,
			EClass eClass) {
		// Create Node MatchingConfiguration
		Element matchingConfiguration = document
				.createElement(NODE_MATCHING_CONFIGURATION);
		configurations.appendChild(matchingConfiguration);

		Attr className = document.createAttribute(MC_ATTRIBUTE_CLASSNAME);
		className.setNodeValue(fullyQualifiedPath);
		matchingConfiguration.setAttributeNode(className);

		Attr treshHold = document.createAttribute(MC_ATTRIBUTE_THRESHOLD);
		treshHold.setNodeValue(computeTreshHold(eClass));
		matchingConfiguration.setAttributeNode(treshHold);

		Attr allowLocalMove = document
				.createAttribute(MC_ATTRIBUTE_ALLOW_LOCAL_MOVE);
		allowLocalMove.setNodeValue(computeAllowLocalMove(eClass));
		matchingConfiguration.setAttributeNode(allowLocalMove);

		Attr allowGlobalMove = document
				.createAttribute(MC_ATTRIBUTE_ALLOW_GLOBAL_MOVE);
		allowGlobalMove.setNodeValue(computeAllowGlobalMove(eClass));
		matchingConfiguration.setAttributeNode(allowGlobalMove);

		Attr alwaysComputeSimilartiy = document
				.createAttribute(MC_ATTRIBUTE_ALWAYS_COMPUTE_SIMILARITY);
		alwaysComputeSimilartiy
				.setNodeValue(computeAlwaysComputeSimilarity(eClass));
		matchingConfiguration.setAttributeNode(alwaysComputeSimilartiy);

		Attr independentMatching = document
				.createAttribute(MC_ATTRIBUTE_INDEPENDENT_MATCHING);
		independentMatching.setNodeValue(computeIndependentMatching(eClass));
		matchingConfiguration.setAttributeNode(independentMatching);

		Attr topDownMatcher = document
				.createAttribute(MC_ATTRIBUTE_TOP_DOWN_MATCHER);
		topDownMatcher.setNodeValue(computeTopDownMatcher(eClass));
		matchingConfiguration.setAttributeNode(topDownMatcher);
	}

	@Override
	public void createSequences(Map<EClass, String> eClasses) {
		sequences = new ArrayList<Element>();
		sequences.add(sequence);

		Set<EClass> availableClasses = eClasses.keySet();

		ClassCalculator classCalculator = new ClassCalculator();
		classCalculator.init(availableClasses);

		// get depthList and reverse order
		List<EClass> depthList = classCalculator.getDepthList();
		Collections.reverse(depthList);

		// each set of classes in outGoingReferenceSorting acts as starter set
		// of requiredTargets for the recursion call
		for (Set<EClass> outGoingReferenceSet : classCalculator
				.getOutgoingReferenceSorting()) {
			// remove all classes that have already been reached before
			outGoingReferenceSet.removeAll(handledClasses);
			if (!outGoingReferenceSet.isEmpty()) {
				// create a node for each concrete class in root sequence
				handledClasses.addAll(outGoingReferenceSet);
				for (EClass eClass : outGoingReferenceSet) {
					if (!eClass.isAbstract()) {
						addClassNode(sequence, eClass, eClasses.get(eClass));
					}
				}

				// create subSequence but only add it to sequence
				// if next iteration has created any class nodes.
				Element subSequence;
				if (sequences.size() > 1) {
					subSequence = sequences.get(1);
					recursiveCreateSequences(subSequence, depthList,
							outGoingReferenceSet, 1);
				} else {
					subSequence = document.createElement(NODE_SEQUENCE);
					sequences.add(subSequence);
					recursiveCreateSequences(subSequence, depthList,
							outGoingReferenceSet, 1);
					sequence.appendChild(subSequence);
				}
			}
		}
	}

	private void recursiveCreateSequences(Element sequence,
			List<EClass> depthList, Set<EClass> requiredTargets, int depth) {
		// return true if a class node was created with this call

		// For each target find all classes pointing to it and create a node of
		// each if not abstract
		// Found classes are target for next recursion call
		// Recursion stops if no required targets are left
		if (!requiredTargets.isEmpty()) {
			Set<EClass> nextRequiredClasses = new HashSet<EClass>();
			for (EClass target : requiredTargets) {
				Set<EClass> pointer = findClassesPointingTo(target, depthList);
				nextRequiredClasses.addAll(pointer);
				for (EClass eClass : pointer) {
					if (!eClass.isAbstract()) {
						addClassNode(sequence, eClass, eClasses.get(eClass));
					}
				}
			}
			// create subSequence but only add it to sequence
			// if next iteration has created any class nodes.
			Element subSequence;
			if (sequences.size() > depth) {
				subSequence = sequences.get(depth);
				depth++;
				recursiveCreateSequences(subSequence, depthList,
						nextRequiredClasses, depth);
			} else {
				subSequence = document.createElement(NODE_SEQUENCE);
				sequences.add(subSequence);
				depth++;
				recursiveCreateSequences(subSequence, depthList,
						nextRequiredClasses, depth);
				sequence.appendChild(subSequence);
			}
		}
	}

	private Set<EClass> findClassesPointingTo(EClass target,
			List<EClass> classes) {
		Set<EClass> result = new HashSet<EClass>();

		// Find all classes having a local reference to target or to a supertype
		// of target
		for (EClass eClass : classes) {
			for (EReference eReference : eClass.getEReferences()) {
				if (eReference.getEType() instanceof EClass
						&& ((EClass) eReference.getEType())
								.isSuperTypeOf(target)) {
					if (!handledClasses.contains(eClass)) {
						result.add(eClass);
						handledClasses.add(eClass);
					}
				}
			}
		}

		return result;
	}

	private void addClassNode(Element sequence, EClass eClass,
			String fullyQualifiedPath) {
		if (nodes.contains(eClass)) {
			System.err.println("Multiple nodes for " + eClass.getName());
			return;
		}

		// TODO edit by cwurmbach
		// in case the eClass is from an external package the fullyQualifiedPath
		// might not have been build.
		if (fullyQualifiedPath == null) {
			fullyQualifiedPath = (eClass.getEPackage().getNsURI() + "." + eClass
					.getName());
			createMatchingConfiguration(fullyQualifiedPath, eClass);
		}
		nodes.add(eClass);
		Element clazz = document.createElement(NODE_Class);
		sequence.appendChild(clazz);

		Attr name = document.createAttribute(C_ATTRIBUTE_NAME);
		name.setNodeValue(fullyQualifiedPath);
		clazz.setAttributeNode(name);
	}

	private String computeTreshHold(EClass eClass) {
		// Default implementation
		return String.valueOf(1.0d);
	}

	private String computeAllowLocalMove(EClass eClass) {
		// Default implementation
		return TRUE;
	}

	private String computeAllowGlobalMove(EClass eClass) {
		// Default implementation
		return TRUE;
	}

	private String computeAlwaysComputeSimilarity(EClass eClass) {
		// Default implementation
		return TRUE;
	}

	private String computeIndependentMatching(EClass eClass) {
		// Default implementation
		return TRUE;
	}

	private String computeTopDownMatcher(EClass eClass) {
		if (eClass.getEAllContainments().isEmpty()) {
			return TOP_DOWN_MATCHER_NO_PROPAGATION;
		} else {
			return TOP_DOWN_MATCHER_DEFAULT;
		}
	}

	private class ClassCalculator {

		private Map<EClass, Set<EClass>> inheritanceMap = null;

		// Set of all root Container classes
		private Set<EClass> rootContainer = null;

		// Each set contains all classes that have the same depth relative to
		// any root
		// Because each class can possibly be in multiple trees it can have
		// different depths values
		// and therefore be contained in multiple sets of this list.
		// The sets are sorted by depth, starting from lowest
		private List<Set<EClass>> depthSetList = null;

		// A List off all classes sorted by their maximum depth
		private List<EClass> depthList = null;

		// Each List contains one containment tree, sorted from root to leafs
		// Is used to compute the depthList
		private List<List<EClass>> treeList = null;

		// Each Lists contains one containment path from root to leaf
		// used to detect and break cycles
		private List<List<EClass>> containmentPaths = null;
		// Each List contains a containment path with no leaf
		private List<List<EClass>> containmentCycles = null;

		private Set<EClass> reachedClasses = null;

		private List<Set<EClass>> outGoingReferenceSorting = null;

		// private boolean initialized = false;

		public void init(Set<EClass> classes) {
			inheritanceMap = new HashMap<EClass, Set<EClass>>();
			rootContainer = new HashSet<EClass>();
			depthSetList = new ArrayList<Set<EClass>>();
			depthList = new ArrayList<EClass>();
			treeList = new ArrayList<List<EClass>>();
			containmentPaths = new ArrayList<List<EClass>>();
			containmentCycles = new ArrayList<List<EClass>>();
			outGoingReferenceSorting = new ArrayList<Set<EClass>>();
			reachedClasses = new HashSet<EClass>();

			computeInheritanceMap(classes);
			computeDepthList(classes);
			computeOutgoingReferenceList(classes);

			// initialized = true;
		}

		private Map<EClass, Set<EClass>> computeInheritanceMap(
				Set<EClass> classes) {
			for (EClass eClass : classes) {
				if (!inheritanceMap.containsKey(eClass)) {
					Set<EClass> subClasses = new HashSet<EClass>();
					inheritanceMap.put(eClass, subClasses);
				}
			}

			for (EClass eClass : classes) {
				for (EClass superType : eClass.getEAllSuperTypes()) {
					if (inheritanceMap.containsKey(superType)) {
						inheritanceMap.get(superType).add(eClass);
					}
				}
			}
			return inheritanceMap;
		}

		private List<Set<EClass>> computeDepthList(Set<EClass> classes) {
			Set<EClass> haveContainer = new HashSet<EClass>();

			// collect all classes that are target of a containment reference
			// and are not in another resource
			for (EClass container : classes) {
				for (EReference eReference : container.getEAllContainments()) {
					EClassifier containment = eReference.getEType();
					if (containment instanceof EClass
							&& classes.contains(containment)) {
						haveContainer.add((EClass) containment);
					}
				}
			}

			// remove all classes that are a subtype or supertype of one that
			// has a container
			rootContainer = new HashSet<EClass>(classes);
			for (EClass hasContainer : haveContainer) {
				rootContainer.remove(hasContainer);
				rootContainer.removeAll(inheritanceMap.get(hasContainer));
				for (EClass superType : hasContainer.getEAllSuperTypes()) {
					if (superType.isAbstract()) {
						rootContainer.remove(superType);
					}
				}
			}

			if (rootContainer.isEmpty()) {
				System.out
						.println("No definite concrete root Class found. Searching for abstract roots");
				rootContainer = new HashSet<EClass>(classes);
				for (EClass hasContainer : haveContainer) {
					rootContainer.remove(hasContainer);
					rootContainer.removeAll(inheritanceMap.get(hasContainer));
				}
			}

			int counter = 1;
			Set<EClass> levelSet = new HashSet<EClass>();
			depthSetList.add(levelSet);

			// for each root container it's complete tree is computed
			for (EClass rootClass : rootContainer) {
				System.out.println("Iteration " + counter + " with root "
						+ rootClass.getName());

				LinkedList<EClass> path = new LinkedList<EClass>();
				path.add(rootClass);
				containmentPaths.add(path);

				levelSet.add(rootClass);

				reachedClasses.clear();
				treeList.add(computeTree(rootClass, path, 0));

				counter++;
			}

			Collections.reverse(depthSetList);

			counter = depthSetList.size();
			for (Set<EClass> set : depthSetList) {
				System.out.print(counter + ". level Elements: ");
				counter--;

				for (EClass eClass : set) {
					if (!depthList.contains(eClass)) {
						depthList.add(eClass);
						// for(EClass subClass : classes){
						// if(eClass.isSuperTypeOf(subClass)){
						// depthList.add(subClass);
						// }
						// }
					}
					System.out.print(eClass.getName() + " ");
				}
				System.out.println();
			}
			System.out.println("Resulting DepthList (" + depthList.size()
					+ "): ");
			for (EClass eClass : depthList) {
				System.out.println(eClass.toString() + " ");
			}

			return depthSetList;
		}

		private List<EClass> computeTree(EClass rootClass,
				LinkedList<EClass> path, int depth) {
			// a recursive method that computes a complete containment tree
			// starting from the root.
			// each recursion steps down one level
			List<EClass> result = new ArrayList<EClass>();

			// the current depth. It increments with each call
			depth++;

			// a set of all classes that have the current depth value
			Set<EClass> levelSet;

			reachedClasses.add(rootClass);
			// Each containment class of the rootClass will be added to a new
			// path copied from the old (and so creating a branch), to the set
			// of the current depth
			// and of course to the result tree. Each containment class also
			// causes a recursive call of this method, with this class
			// being the new "root"
			for (EReference eReference : rootClass.getEAllContainments()) {
				if (eReference.getEType() instanceof EClass) {
					// also get all subTypes of a containment
					EClass containmentClass = (EClass) eReference.getEType();
					Set<EClass> containments = new HashSet<EClass>();
					if (inheritanceMap.containsKey(containmentClass)) {
						containments.addAll(inheritanceMap
								.get(containmentClass));
					}
					containments.add(containmentClass);
					for (EClass containment : containments) {
						if (!reachedClasses.contains(containment)) {
							if (!path.contains(containment)) {
								LinkedList<EClass> newPath = new LinkedList<EClass>(
										path);
								newPath.add(containment);
								containmentPaths.add(newPath);

								// if depthList is greater than current depth, a
								// set for this
								// depth has already been created. Else create
								// one
								if (depthSetList.size() > depth) {
									levelSet = depthSetList.get(depth);
								} else {
									levelSet = new HashSet<EClass>();
									depthSetList.add(levelSet);
								}
								levelSet.add(containment);

								result.add(containment);
								result.addAll(computeTree(containment, newPath,
										depth));
							} else {
								// If the containment already is in the path, a
								// cycle was detected, will be saved and of
								// course broken
								List<EClass> cycle = new ArrayList<EClass>();
								int cycleStart = path.indexOf(containment);
								while (cycleStart < path.size()) {
									cycle.add(path.get(cycleStart));
									cycleStart++;
								}
								cycle.add(containment);

								if (!containmentCycles.contains(cycle)) {
									containmentCycles.add(cycle);
									System.out
											.print("Containment cycle detected and broken!\nPath:");
									for (EClass eClass : cycle) {
										System.out.print(eClass.getName()
												+ " -> ");
									}
									System.out.println();
									System.out.println();
								}
							}
						}
					}
				}
			}
			return result;
		}

		private List<Set<EClass>> computeOutgoingReferenceList(
				Set<EClass> classes) {
			int counter = 0;
			Set<EClass> remaingClasses = new HashSet<EClass>(classes);

			// First search classes with 0 outgoing references, then for those 1
			// and so on until all classes are recorded
			// Use getEAllReferences because the config will need the local
			// information for each class INSTANCE
			while (!remaingClasses.isEmpty()) {
				outGoingReferenceSorting.add(new HashSet<EClass>());
				for (EClass eClass : classes) {
					if (eClass.getEAllReferences().size() == counter) {
						remaingClasses.remove(eClass);
						outGoingReferenceSorting.get(counter).add(eClass);
					}
				}
				counter++;
			}

			int i = 0;
			for (Set<EClass> set : outGoingReferenceSorting) {
				System.out
						.print("Classes with " + i + " outgoing References: ");
				for (EClass eClass : set) {
					System.out.print(eClass.getName() + " ");
				}
				System.out.println();
				i++;
			}
			return outGoingReferenceSorting;
		}

		public List<EClass> getDepthList() {
			return depthList;
		}

		public List<Set<EClass>> getOutgoingReferenceSorting() {
			return outGoingReferenceSorting;

		}
	}
}

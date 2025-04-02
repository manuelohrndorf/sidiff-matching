package org.sidiff.superimposition.conflict.detector.impl;

import static org.sidiff.superimposition.conflict.detector.ConflictDetectorUtil.createConflict;
import static org.sidiff.superimposition.conflict.detector.ConflictDetectorUtil.createConflicting;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictType;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.conflict.detector.AbstractConflictDetector;

/**
 * Conflict detector that detects conflicts in
 * violation of the model's meta model.
 * @author rmueller
 */
public class MetaModelBasedConflictDetector extends AbstractConflictDetector {

	@Override
	public Diagnostic detectConflicts(ConflictSet conflictSet, IProgressMonitor monitor) {
		return forEachInput(conflictSet, monitor, MetaModelBasedConflictDetector::detectConflicts);
	}

	private static void detectConflicts(ConflictingEntities input, ConflictSet conflictSet,
			DiagnosticChain diagChain, IProgressMonitor monitor) {

		detectDuplicateElementNames(conflictSet, input);
		detectDuplicateUuid(conflictSet, input);
		if(input.getContext() != null) {
			detectReferenceConflicts(conflictSet, input);
			detectAttributeConflicts(conflictSet, input);			
		}
	}

	private static void detectDuplicateElementNames(ConflictSet conflictSet, ConflictingEntities input) {
		input.getReferences().stream()
			.filter(Reference::isContainment)
			.filter(ref -> ref.getSource() == input.getContext())
			.collect(Collectors.groupingBy(Reference::getType, HashMap::new,
				Collectors.mapping(Reference::getTarget, Collectors.toSet())))
			.entrySet().forEach(refs -> {
				// map of name -> element for duplicate name detection
				Map<String,Collection<Element>> namedElements = new HashMap<>();
				for(Element element : refs.getValue()) {
					element.getAttributes().stream()
						.filter(attr -> "name".equalsIgnoreCase(attr.getType().getName()))
						.forEach(attr -> attr.getValue().forEach(name -> namedElements
								.computeIfAbsent(name, (unused) -> new HashSet<>()).add(element)));
				}
				namedElements.entrySet().stream()
					.filter(entry -> entry.getValue().size() > 1)
					.forEach(entry -> createConflict(conflictSet, "Ecore.ENamedElement.Name.Duplicated",
							"Duplicate element name '" + entry.getKey() + "'", ConflictType.SEMANTIC,
							createConflicting(input.getContext(),
									Stream.concat(
										entry.getValue().stream(),
										entry.getValue().stream()
											.map(Element::getIncomings)
											.flatMap(Collection::stream)
											.filter(Reference::isContainment))
										.collect(Collectors.toSet()),
									refs.getKey())));
			});
	}

	private static void detectDuplicateUuid(ConflictSet conflictSet, ConflictingEntities input) {
		input.getElements().stream()
			.collect(Collectors.groupingBy(Element::getUuid))
			.entrySet().stream()
			.filter(entry -> entry.getValue().size() > 1)
			.forEach(entry -> createConflict(conflictSet, "Superimposed.Element.UUID.Duplicated",
					"Duplicate UUID '" + entry.getKey() + "'", ConflictType.SEMANTIC,
					createConflicting(input.getContext(), entry.getValue())));
	}

	private static void detectReferenceConflicts(ConflictSet conflictSet, ConflictingEntities input) {
		for(EReference type : input.getContext().getType().getEAllReferences()) {
			if(type.isDerived() || type.isTransient() || !type.isChangeable()) {
				continue;
			}

			Collection<Reference> references = input.getReferences(type);
			Collection<Reference> outgoing = references.stream()
					.filter(ref -> ref.getSource() == input.getContext()).collect(Collectors.toList());
			if(outgoing.size() < type.getLowerBound()) {
				createConflict(conflictSet, "Ecore.EReference.LowerBound.Violated", "Lower bound not satisfied", ConflictType.SYNTACTIC,
						createConflicting(input.getContext(), outgoing, type));
			}
			if(type.getUpperBound() != -1 && outgoing.size() > type.getUpperBound()) {
				createConflict(conflictSet, "Ecore.EReference.UpperBound.Violated", "Upper bound not satisfied", ConflictType.SYNTACTIC,
						createConflicting(input.getContext(), outgoing, type));
			}

			if(type.isUnique()) {
				Set<Element> uniqueTargets = outgoing.stream().map(Reference::getTarget).collect(Collectors.toSet());
				if(uniqueTargets.size() < outgoing.size()) {
					createConflict(conflictSet, "Ecore.EReference.Unique.Violated", "Uniqueness not satisfied", ConflictType.SEMANTIC,
							createConflicting(input.getContext(), outgoing, type));
				}
			}

			Collection<Reference> containments = references.stream()
					.filter(ref -> ref.getTarget() == input.getContext())
					.filter(Reference::isContainment).collect(Collectors.toList());
			if(containments.size() > 1) {
				createConflict(conflictSet, "Ecore.EReference.Containment.Multiple", "Element has multiple containers", ConflictType.SEMANTIC,
						createConflicting(input.getContext(), containments, type));
			}
		}
	}

	private static void detectAttributeConflicts(ConflictSet conflictSet, ConflictingEntities input) {
		for(EAttribute type : input.getContext().getType().getEAllAttributes()) {
			if(type.isDerived() || type.isTransient() || !type.isChangeable()) {
				continue;
			}

			Collection<Attribute> attributes = input.getAttributes(type);
			long numValues = attributes.stream().mapToInt(attr -> attr.getValue().size()).sum();
			// if no value is set, check if a default value is set
			if(numValues < type.getLowerBound() && (numValues > 0 || type.getDefaultValue() == null)) {
				createConflict(conflictSet, "Ecore.EAttribute.LowerBound.Violated", "Lower bound not satisfied", ConflictType.SYNTACTIC,
						createConflicting(input.getContext(), attributes, type));
			}
			if(type.getUpperBound() != -1 && numValues > type.getUpperBound()) {
				createConflict(conflictSet, "Ecore.EAttribute.UpperBound.Violated", "Upper bound not satisfied", ConflictType.SYNTACTIC,
						createConflicting(input.getContext(), attributes, type));
			}

			if(type.isUnique()) {
				Set<String> uniqueValues = attributes.stream().map(Attribute::getValue).flatMap(Collection::stream).collect(Collectors.toSet());
				if(uniqueValues.size() < numValues || (uniqueValues.size() == 0 && attributes.size() > 1)) {
					// values contain duplicates | multiple attributes of this type specify no values
					createConflict(conflictSet, "Ecore.EAttribute.Unique.Violated", "Uniqueness not satisfied", ConflictType.SEMANTIC,
							createConflicting(input.getContext(), attributes, type));
				}				
			}
		}
	}
}

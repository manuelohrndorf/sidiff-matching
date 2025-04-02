package org.sidiff.superimposition.conflict.resolver.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimpositionModelPlugin;
import org.sidiff.superimposition.conflict.resolver.AbstractConflictResolver;
import org.sidiff.superimposition.util.SuperimpositionModelModifyHelper;

/**
 * Basic conflict resolver that resolves trivial conflicts.
 * @author rmueller
 */
public class BasicConflictResolver extends AbstractConflictResolver {

	@Override
	public Diagnostic resolveConflict(Conflict conflict, IProgressMonitor monitor) {
		switch(conflict.getId()) {
			case "Ecore.EAttribute.Unique.Violated":
				return forEachConflicting(conflict, monitor, BasicConflictResolver::removeDuplicateAttributes);
			case "Ecore.EReference.Unique.Violated":
				return forEachConflicting(conflict, monitor, BasicConflictResolver::removeDuplicateReferences);
		}
		return errorNotSupported(conflict);
	}

	private static void removeDuplicateAttributes(ConflictingEntities conflicting, Conflict conflict,
			DiagnosticChain diagChain, IProgressMonitor monitor, SuperimpositionModelModifyHelper modifyHelper) {

		Map<String,Attribute> value2attribute = new HashMap<>(); // using null key when attribute has no values
		Collection<Attribute> removedAttributes = new ArrayList<>();
		Collection<Attribute> attributes = conflicting.getAttributes();
		SubMonitor progress = SubMonitor.convert(monitor, attributes.size()+1); // +1 for deletion
		for(Attribute attribute : attributes) {
			if(attribute.getValue().isEmpty()) {
				Attribute uniqueAttr = value2attribute.get(null);
				if(uniqueAttr == null) {
					value2attribute.put(null, attribute);
				} else {
					uniqueAttr.getAnnotations().addAll(attribute.getAnnotations());
					removedAttributes.add(attribute);
				}
			} else {
				for(String value : attribute.getValue()) {
					Attribute uniqueAttr = value2attribute.get(value);
					if(uniqueAttr == null) {
						value2attribute.put(value, attribute);
					} else {
						uniqueAttr.getAnnotations().addAll(attribute.getAnnotations());
						removedAttributes.add(attribute);
					}
				}					
			}
			progress.worked(1);
		}
		removedAttributes.forEach(modifyHelper::remove);
		diagChain.add(new BasicDiagnostic(Diagnostic.INFO, SuperimpositionModelPlugin.ID, 0, "Removed duplicate attributes: "
				+ removedAttributes.stream().map(Entity::getSignature).collect(Collectors.joining(", ")), null));
		progress.worked(1);
	}

	private static void removeDuplicateReferences(ConflictingEntities conflicting, Conflict conflict,
			DiagnosticChain diagChain, IProgressMonitor monitor, SuperimpositionModelModifyHelper modifyHelper) {

		Map<Element,Reference> target2reference = new HashMap<>();
		Collection<Reference> removedReferences = new ArrayList<>();
		Collection<Reference> references = conflicting.getReferences();
		SubMonitor progress = SubMonitor.convert(monitor, references.size()+1); // +1 for deletion
		for(Reference reference : references) {
			Reference uniqueRef = target2reference.get(reference.getTarget());
			if(uniqueRef == null) {
				target2reference.put(reference.getTarget(), reference);
			} else {
				// the target element is already referenced, so this reference can be removed
				uniqueRef.getAnnotations().addAll(reference.getAnnotations());
				removedReferences.add(reference);
			}
			progress.worked(1);
		}
		removedReferences.forEach(modifyHelper::remove);
		diagChain.add(new BasicDiagnostic(Diagnostic.INFO, SuperimpositionModelPlugin.ID, 0, "Removed duplicate references: "
				+ removedReferences.stream().map(Entity::getSignature).collect(Collectors.joining(", ")), null));
		progress.worked(1);
	}
}

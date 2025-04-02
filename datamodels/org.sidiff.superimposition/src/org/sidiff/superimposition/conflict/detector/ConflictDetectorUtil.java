package org.sidiff.superimposition.conflict.detector;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictSeverity;
import org.sidiff.superimposition.ConflictType;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimpositionModelFactory;

/**
 * Utility functions for the {@link IConflictDetector} extension.
 * @author rmueller
 */
public class ConflictDetectorUtil {

	public static Conflict createConflict(ConflictSet conflictSet, String id, String message,
			ConflictSeverity severity, ConflictType type, ConflictingEntities ...conflicting) {

		Conflict conflict = SuperimpositionModelFactory.eINSTANCE.createConflict();
		conflict.setId(id);
		conflict.setMessage(message);
		conflict.setSeverity(severity);
		conflict.setType(type);
		conflictSet.getConflicts().add(conflict);

		for(ConflictingEntities c : conflicting) {
			conflict.getConflicting().add(c);
			conflictSet.getConflicting().add(c);
		}

		return conflict;
	}

	public static Conflict createConflict(ConflictSet conflictSet, String id,
			String message, ConflictType type, ConflictingEntities ...conflicting) {

		return createConflict(conflictSet, id, message, ConflictSeverity.ERROR, type, conflicting);
	}

	public static Conflict createConflict(ConflictSet conflictSet, String id,
			String message, ConflictingEntities ...conflicting) {

		return createConflict(conflictSet, id, message, ConflictSeverity.ERROR, ConflictType.UNSPECIFIED, conflicting);
	}

	public static ConflictingEntities createConflicting(SuperimposedElement context,
			Collection<? extends Entity> entities, EStructuralFeature type) {

		ConflictingEntities conflicting = createConflicting(context, entities);
		conflicting.setType(type);
		return conflicting;
	}

	public static ConflictingEntities createConflicting(SuperimposedElement context, Collection<? extends Entity> entities) {
		ConflictingEntities conflicting = SuperimpositionModelFactory.eINSTANCE.createConflictingEntities();
		conflicting.setContext(context);
		for(Entity entity : entities) {
			if(entity instanceof Element) {
				conflicting.getElements().add((Element)entity);
			} else if(entity instanceof Reference) {
				conflicting.getReferences().add((Reference)entity);
			} else if(entity instanceof Attribute) {
				conflicting.getAttributes().add((Attribute)entity);
			} else {
				throw new IllegalArgumentException("entity not supported: " + entity);
			}
		}
		return conflicting;
	}
}

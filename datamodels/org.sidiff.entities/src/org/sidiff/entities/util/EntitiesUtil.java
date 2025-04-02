package org.sidiff.entities.util;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.AnnotationType;
import org.sidiff.entities.EntitiesFactory;
import org.sidiff.formula.Formula;

/**
 * Contains utility methods for creating and using {@link Annotation}s.
 * @author rmueller
 */
public class EntitiesUtil {

	private EntitiesUtil() {
		throw new AssertionError();
	}

	/**
	 * Compares two annotations and returns whether they are considered equal,
	 * i.e. both are <code>null</code>, or body, type and formula are equal.
	 * @param lhs first annotation
	 * @param rhs second annotation
	 * @return <code>true</code> if equal, <code>false</code> otherwise
	 */
	public static boolean equalAnnotations(Annotation lhs, Annotation rhs) {
		if(lhs == rhs) {
			// Same instance or both null
			return true;
		}
		if(lhs == null || rhs == null) {
			// Only one is null
			return false;
		}
		// Body, Type and Formula must match
		// Cannot use EcoreUtil.equals(lhs, rhs) directly, because that would
		// also compare the annotated entities.
		return Objects.equals(lhs.getBody(), rhs.getBody())
				&& Objects.equals(lhs.getType(), rhs.getType());
		// FIXME (cpietsch: 2019-02-04): structural equality is insufficient, e.g. (x
		// and y) and z == x and (y and z) is logically equivalent but not structurally
//				&& EcoreUtil.equals(lhs.getFormula(), rhs.getFormula()); // compare for structural equality of the formula
	}

	/**
	 * Finds the first annotation in <i>haystack</i> that has the given <i>body</i>.
	 * @param body the body string to find
	 * @param haystack the collection of annotation to search
	 * @return first annotation with the given body, empty optional of none
	 */
	public static Optional<Annotation> getAnnotation(String body, Collection<Annotation> haystack) {
		return haystack.stream()
				.filter(a -> Objects.equals(a.getBody(), body))
				.findFirst();
	}

	/**
	 * Finds the first annotation {@link #equalAnnotations(Annotation, Annotation) equal} to <i>needle</i> in <i>haystack</i>.
	 * @param needle the annotation to find
	 * @param haystack the collection of annotation to search
	 * @return first annotation equal to needle, empty optional of none
	 */
	public static Optional<Annotation> getAnnotation(Annotation needle, Collection<Annotation> haystack) {
		return haystack.stream()
				.filter(annotation -> equalAnnotations(needle, annotation))
				.findFirst();
	}

	/**
	 * Finds the first annotation {@link #equalAnnotations(Annotation, Annotation) equal} to <i>needle</i> in <i>haystack</i>,
	 * adding <i>needle</i> to <i>haystack</i> and returning it, if none is found.
	 * @param needle the annotation to find
	 * @param haystack the collection of annotation to search and add to
	 * @return first annotation equal to needle, needle itself if none found
	 */
	public static Annotation getOrAddAnnotation(Annotation needle, Collection<Annotation> haystack) {
		Optional<Annotation> existing = getAnnotation(needle, haystack);
		if(existing.isPresent()) {
			return existing.get();
		}
		haystack.add(needle);
		return needle;
	}

	public static Annotation createModelAnnotation(URI modelUri) {
		return createModelAnnotation(modelUri.toString());
	}

	public static Annotation createModelAnnotation(String body) {
		Annotation annotation = EntitiesFactory.eINSTANCE.createAnnotation();
		annotation.setType(AnnotationType.MODEL);
		annotation.setBody(body);
		return annotation;
	}

	public static Annotation createConditionAnnotation(Formula formula) {
		Annotation annotation = EntitiesFactory.eINSTANCE.createAnnotation();
		annotation.setType(AnnotationType.CONDITION);
		annotation.setFormula(formula);
		return annotation;
	}
}

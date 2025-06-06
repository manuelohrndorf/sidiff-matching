/**
 */
package org.sidiff.entities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Annotation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sidiff.entities.EntitiesPackage#getAnnotationType()
 * @model
 * @generated
 */
public enum AnnotationType implements Enumerator {
	/**
	 * The '<em><b>Comment</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Annotations with this type are comments with no predefined semantic.
	 * <!-- end-model-doc -->
	 * @see #COMMENT_VALUE
	 * @generated
	 * @ordered
	 */
	COMMENT(0, "Comment", "COMMENT"),

	/**
	 * The '<em><b>Condition</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Annotations with this type are conditions that denote whether the annotated entity is included in some subset, either by using the owned formula or the annotation's body.
	 * <!-- end-model-doc -->
	 * @see #CONDITION_VALUE
	 * @generated
	 * @ordered
	 */
	CONDITION(1, "Condition", "CONDITION"), /**
	 * The '<em><b>Model</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Annotations with this type specify as their body the URI of the model from which the annotated entity was imported.
	 * <!-- end-model-doc -->
	 * @see #MODEL_VALUE
	 * @generated
	 * @ordered
	 */
	MODEL(2, "Model", "MODEL");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Dennis Reuling, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The '<em><b>Comment</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Annotations with this type are comments with no predefined semantic.
	 * <!-- end-model-doc -->
	 * @see #COMMENT
	 * @model name="Comment" literal="COMMENT"
	 * @generated
	 * @ordered
	 */
	public static final int COMMENT_VALUE = 0;

	/**
	 * The '<em><b>Condition</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONDITION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Annotations with this type are conditions that denote whether the annotated entity is included in some subset, either by using the owned formula or the annotation's body.
	 * <!-- end-model-doc -->
	 * @see #CONDITION
	 * @model name="Condition" literal="CONDITION"
	 * @generated
	 * @ordered
	 */
	public static final int CONDITION_VALUE = 1;

	/**
	 * The '<em><b>Model</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Annotations with this type specify as their body the URI of the model from which the annotated entity was imported.
	 * <!-- end-model-doc -->
	 * @see #MODEL
	 * @model name="Model" literal="MODEL"
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_VALUE = 2;

	/**
	 * An array of all the '<em><b>Annotation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AnnotationType[] VALUES_ARRAY =
		new AnnotationType[] {
			COMMENT,
			CONDITION,
			MODEL,
		};

	/**
	 * A public read-only list of all the '<em><b>Annotation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AnnotationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AnnotationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnnotationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AnnotationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnnotationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AnnotationType get(int value) {
		switch (value) {
			case COMMENT_VALUE: return COMMENT;
			case CONDITION_VALUE: return CONDITION;
			case MODEL_VALUE: return MODEL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AnnotationType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //AnnotationType

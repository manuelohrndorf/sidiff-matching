/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sidiff.formula.FormulaPackage#getVariationType()
 * @model
 * @generated
 */
public enum VariationType implements Enumerator {
	/**
	 * The '<em><b>UNDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEFINED(0, "UNDEFINED", "UNDEFINED"),

	/**
	 * The '<em><b>MANDATORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANDATORY_VALUE
	 * @generated
	 * @ordered
	 */
	MANDATORY(1, "MANDATORY", "MANDATORY"),

	/**
	 * The '<em><b>OPTIONAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTIONAL_VALUE
	 * @generated
	 * @ordered
	 */
	OPTIONAL(2, "OPTIONAL", "OPTIONAL");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The '<em><b>UNDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED_VALUE = 0;

	/**
	 * The '<em><b>MANDATORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANDATORY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANDATORY_VALUE = 1;

	/**
	 * The '<em><b>OPTIONAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPTIONAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPTIONAL_VALUE = 2;

	/**
	 * An array of all the '<em><b>Variation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VariationType[] VALUES_ARRAY =
		new VariationType[] {
			UNDEFINED,
			MANDATORY,
			OPTIONAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Variation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VariationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VariationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VariationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VariationType get(int value) {
		switch (value) {
			case UNDEFINED_VALUE: return UNDEFINED;
			case MANDATORY_VALUE: return MANDATORY;
			case OPTIONAL_VALUE: return OPTIONAL;
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
	private VariationType(int value, String name, String literal) {
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
	
} //VariationType

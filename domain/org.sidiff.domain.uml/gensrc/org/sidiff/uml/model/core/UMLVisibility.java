/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>UML Visibility</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.sidiff.uml.model.core.CorePackage#getUMLVisibility()
 * @model
 * @generated
 */
public enum UMLVisibility implements Enumerator
{
  /**
   * The '<em><b>Public</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PUBLIC_VALUE
   * @generated
   * @ordered
   */
  PUBLIC(0, "public", "public"),

  /**
   * The '<em><b>Protected</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PROTECTED_VALUE
   * @generated
   * @ordered
   */
  PROTECTED(1, "protected", "protected"),

  /**
   * The '<em><b>Private</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PRIVATE_VALUE
   * @generated
   * @ordered
   */
  PRIVATE(2, "private", "private"),

  /**
   * The '<em><b>Package</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PACKAGE_VALUE
   * @generated
   * @ordered
   */
  PACKAGE(3, "package", "package");

  /**
   * The '<em><b>Public</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Public</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PUBLIC
   * @model name="public"
   * @generated
   * @ordered
   */
  public static final int PUBLIC_VALUE = 0;

  /**
   * The '<em><b>Protected</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Protected</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PROTECTED
   * @model name="protected"
   * @generated
   * @ordered
   */
  public static final int PROTECTED_VALUE = 1;

  /**
   * The '<em><b>Private</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Private</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PRIVATE
   * @model name="private"
   * @generated
   * @ordered
   */
  public static final int PRIVATE_VALUE = 2;

  /**
   * The '<em><b>Package</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Package</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PACKAGE
   * @model name="package"
   * @generated
   * @ordered
   */
  public static final int PACKAGE_VALUE = 3;

  /**
   * An array of all the '<em><b>UML Visibility</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final UMLVisibility[] VALUES_ARRAY =
    new UMLVisibility[]
    {
      PUBLIC,
      PROTECTED,
      PRIVATE,
      PACKAGE,
    };

  /**
   * A public read-only list of all the '<em><b>UML Visibility</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<UMLVisibility> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>UML Visibility</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLVisibility get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UMLVisibility result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>UML Visibility</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLVisibility getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UMLVisibility result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>UML Visibility</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLVisibility get(int value)
  {
    switch (value)
    {
      case PUBLIC_VALUE: return PUBLIC;
      case PROTECTED_VALUE: return PROTECTED;
      case PRIVATE_VALUE: return PRIVATE;
      case PACKAGE_VALUE: return PACKAGE;
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
  private UMLVisibility(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //UMLVisibility

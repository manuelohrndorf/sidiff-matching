/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.uml.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "model";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.sidiff.org/org.sidiff.uml.model";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "model";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ModelPackage eINSTANCE = org.sidiff.uml.model.impl.ModelPackageImpl.init();

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.impl.DummyImpl <em>Dummy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.impl.DummyImpl
   * @see org.sidiff.uml.model.impl.ModelPackageImpl#getDummy()
   * @generated
   */
  int DUMMY = 0;

  /**
   * The number of structural features of the '<em>Dummy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DUMMY_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.Dummy <em>Dummy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dummy</em>'.
   * @see org.sidiff.uml.model.Dummy
   * @generated
   */
  EClass getDummy();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ModelFactory getModelFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.impl.DummyImpl <em>Dummy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.impl.DummyImpl
     * @see org.sidiff.uml.model.impl.ModelPackageImpl#getDummy()
     * @generated
     */
    EClass DUMMY = eINSTANCE.getDummy();

  }

} //ModelPackage

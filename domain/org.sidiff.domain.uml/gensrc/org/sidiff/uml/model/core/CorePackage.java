/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.sidiff.uml.model.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "core";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.sidiff.org/org.sidiff.uml.model/core";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "model.core";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CorePackage eINSTANCE = org.sidiff.uml.model.core.impl.CorePackageImpl.init();

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLVisibleElementImpl <em>UML Visible Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLVisibleElementImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLVisibleElement()
   * @generated
   */
  int UML_VISIBLE_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_VISIBLE_ELEMENT__VISIBILITY = 0;

  /**
   * The number of structural features of the '<em>UML Visible Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_VISIBLE_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLElementImpl <em>UML Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLElementImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLElement()
   * @generated
   */
  int UML_ELEMENT = 5;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT__ID = 0;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT__COMMENTS = 1;

  /**
   * The number of structural features of the '<em>UML Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLNamedElementImpl <em>UML Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLNamedElementImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLNamedElement()
   * @generated
   */
  int UML_NAMED_ELEMENT = 8;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NAMED_ELEMENT__ID = UML_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NAMED_ELEMENT__COMMENTS = UML_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES = UML_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NAMED_ELEMENT__DEPENDEES = UML_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NAMED_ELEMENT__NAME = UML_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>UML Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_NAMED_ELEMENT_FEATURE_COUNT = UML_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLPackageImpl <em>UML Package</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLPackageImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLPackage()
   * @generated
   */
  int UML_PACKAGE = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__ID = UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__COMMENTS = UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__OUTGOING_DEPENDENCIES = UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__DEPENDEES = UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__NAME = UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__STEREOTYPES = UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__VISIBILITY = UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__MODEL = UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__PACKAGES = UML_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Super Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__SUPER_PACKAGE = UML_NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__CLASSIFIERS = UML_NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Stored Comments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__STORED_COMMENTS = UML_NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Associations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__ASSOCIATIONS = UML_NAMED_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Enumerations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__ENUMERATIONS = UML_NAMED_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Primitive Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE__PRIMITIVE_TYPES = UML_NAMED_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The number of structural features of the '<em>UML Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PACKAGE_FEATURE_COUNT = UML_NAMED_ELEMENT_FEATURE_COUNT + 10;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLStereotypeableElementImpl <em>UML Stereotypeable Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLStereotypeableElementImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLStereotypeableElement()
   * @generated
   */
  int UML_STEREOTYPEABLE_ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES = 0;

  /**
   * The number of structural features of the '<em>UML Stereotypeable Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPEABLE_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLStereotypeImpl <em>UML Stereotype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLStereotypeImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLStereotype()
   * @generated
   */
  int UML_STEREOTYPE = 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPE__ID = UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPE__COMMENTS = UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPE__OUTGOING_DEPENDENCIES = UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPE__DEPENDEES = UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPE__NAME = UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Model</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPE__MODEL = UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Stereotyped Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPE__STEREOTYPED_ELEMENTS = UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>UML Stereotype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_STEREOTYPE_FEATURE_COUNT = UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLModelImpl <em>UML Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLModelImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLModel()
   * @generated
   */
  int UML_MODEL = 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_MODEL__ID = UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_MODEL__COMMENTS = UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_MODEL__OUTGOING_DEPENDENCIES = UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_MODEL__DEPENDEES = UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_MODEL__NAME = UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_MODEL__PACKAGES = UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_MODEL__STEREOTYPES = UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>UML Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_MODEL_FEATURE_COUNT = UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLCommentImpl <em>UML Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLCommentImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLComment()
   * @generated
   */
  int UML_COMMENT = 6;

  /**
   * The feature id for the '<em><b>Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_COMMENT__PACKAGE = 0;

  /**
   * The feature id for the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_COMMENT__COMMENT = 1;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_COMMENT__ELEMENTS = 2;

  /**
   * The number of structural features of the '<em>UML Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_COMMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.impl.UMLDependencyImpl <em>UML Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.impl.UMLDependencyImpl
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLDependency()
   * @generated
   */
  int UML_DEPENDENCY = 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY__ID = UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY__COMMENTS = UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY__OUTGOING_DEPENDENCIES = UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY__DEPENDEES = UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY__NAME = UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY__STEREOTYPES = UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Dependee</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY__DEPENDEE = UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Supplier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY__SUPPLIER = UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>UML Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_DEPENDENCY_FEATURE_COUNT = UML_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.core.UMLVisibility <em>UML Visibility</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.core.UMLVisibility
   * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLVisibility()
   * @generated
   */
  int UML_VISIBILITY = 9;


  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLVisibleElement <em>UML Visible Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Visible Element</em>'.
   * @see org.sidiff.uml.model.core.UMLVisibleElement
   * @generated
   */
  EClass getUMLVisibleElement();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.core.UMLVisibleElement#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.sidiff.uml.model.core.UMLVisibleElement#getVisibility()
   * @see #getUMLVisibleElement()
   * @generated
   */
  EAttribute getUMLVisibleElement_Visibility();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLPackage <em>UML Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Package</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage
   * @generated
   */
  EClass getUMLPackage();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.core.UMLPackage#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage#getModel()
   * @see #getUMLPackage()
   * @generated
   */
  EReference getUMLPackage_Model();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLPackage#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage#getPackages()
   * @see #getUMLPackage()
   * @generated
   */
  EReference getUMLPackage_Packages();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.core.UMLPackage#getSuperPackage <em>Super Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Super Package</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage#getSuperPackage()
   * @see #getUMLPackage()
   * @generated
   */
  EReference getUMLPackage_SuperPackage();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLPackage#getClassifiers <em>Classifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classifiers</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage#getClassifiers()
   * @see #getUMLPackage()
   * @generated
   */
  EReference getUMLPackage_Classifiers();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLPackage#getStoredComments <em>Stored Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stored Comments</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage#getStoredComments()
   * @see #getUMLPackage()
   * @generated
   */
  EReference getUMLPackage_StoredComments();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLPackage#getAssociations <em>Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Associations</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage#getAssociations()
   * @see #getUMLPackage()
   * @generated
   */
  EReference getUMLPackage_Associations();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLPackage#getEnumerations <em>Enumerations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enumerations</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage#getEnumerations()
   * @see #getUMLPackage()
   * @generated
   */
  EReference getUMLPackage_Enumerations();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLPackage#getPrimitiveTypes <em>Primitive Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Primitive Types</em>'.
   * @see org.sidiff.uml.model.core.UMLPackage#getPrimitiveTypes()
   * @see #getUMLPackage()
   * @generated
   */
  EReference getUMLPackage_PrimitiveTypes();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLStereotypeableElement <em>UML Stereotypeable Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Stereotypeable Element</em>'.
   * @see org.sidiff.uml.model.core.UMLStereotypeableElement
   * @generated
   */
  EClass getUMLStereotypeableElement();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.core.UMLStereotypeableElement#getStereotypes <em>Stereotypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stereotypes</em>'.
   * @see org.sidiff.uml.model.core.UMLStereotypeableElement#getStereotypes()
   * @see #getUMLStereotypeableElement()
   * @generated
   */
  EReference getUMLStereotypeableElement_Stereotypes();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLStereotype <em>UML Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Stereotype</em>'.
   * @see org.sidiff.uml.model.core.UMLStereotype
   * @generated
   */
  EClass getUMLStereotype();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.core.UMLStereotype#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Model</em>'.
   * @see org.sidiff.uml.model.core.UMLStereotype#getModel()
   * @see #getUMLStereotype()
   * @generated
   */
  EReference getUMLStereotype_Model();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.core.UMLStereotype#getStereotypedElements <em>Stereotyped Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stereotyped Elements</em>'.
   * @see org.sidiff.uml.model.core.UMLStereotype#getStereotypedElements()
   * @see #getUMLStereotype()
   * @generated
   */
  EReference getUMLStereotype_StereotypedElements();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLModel <em>UML Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Model</em>'.
   * @see org.sidiff.uml.model.core.UMLModel
   * @generated
   */
  EClass getUMLModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLModel#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.sidiff.uml.model.core.UMLModel#getPackages()
   * @see #getUMLModel()
   * @generated
   */
  EReference getUMLModel_Packages();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLModel#getStereotypes <em>Stereotypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stereotypes</em>'.
   * @see org.sidiff.uml.model.core.UMLModel#getStereotypes()
   * @see #getUMLModel()
   * @generated
   */
  EReference getUMLModel_Stereotypes();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLElement <em>UML Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Element</em>'.
   * @see org.sidiff.uml.model.core.UMLElement
   * @generated
   */
  EClass getUMLElement();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.core.UMLElement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.sidiff.uml.model.core.UMLElement#getId()
   * @see #getUMLElement()
   * @generated
   */
  EAttribute getUMLElement_Id();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.core.UMLElement#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Comments</em>'.
   * @see org.sidiff.uml.model.core.UMLElement#getComments()
   * @see #getUMLElement()
   * @generated
   */
  EReference getUMLElement_Comments();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLComment <em>UML Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Comment</em>'.
   * @see org.sidiff.uml.model.core.UMLComment
   * @generated
   */
  EClass getUMLComment();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.core.UMLComment#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Package</em>'.
   * @see org.sidiff.uml.model.core.UMLComment#getPackage()
   * @see #getUMLComment()
   * @generated
   */
  EReference getUMLComment_Package();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.core.UMLComment#getComment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Comment</em>'.
   * @see org.sidiff.uml.model.core.UMLComment#getComment()
   * @see #getUMLComment()
   * @generated
   */
  EAttribute getUMLComment_Comment();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.core.UMLComment#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Elements</em>'.
   * @see org.sidiff.uml.model.core.UMLComment#getElements()
   * @see #getUMLComment()
   * @generated
   */
  EReference getUMLComment_Elements();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLDependency <em>UML Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Dependency</em>'.
   * @see org.sidiff.uml.model.core.UMLDependency
   * @generated
   */
  EClass getUMLDependency();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.core.UMLDependency#getDependee <em>Dependee</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Dependee</em>'.
   * @see org.sidiff.uml.model.core.UMLDependency#getDependee()
   * @see #getUMLDependency()
   * @generated
   */
  EReference getUMLDependency_Dependee();

  /**
   * Returns the meta object for the reference '{@link org.sidiff.uml.model.core.UMLDependency#getSupplier <em>Supplier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Supplier</em>'.
   * @see org.sidiff.uml.model.core.UMLDependency#getSupplier()
   * @see #getUMLDependency()
   * @generated
   */
  EReference getUMLDependency_Supplier();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.core.UMLNamedElement <em>UML Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Named Element</em>'.
   * @see org.sidiff.uml.model.core.UMLNamedElement
   * @generated
   */
  EClass getUMLNamedElement();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.core.UMLNamedElement#getOutgoingDependencies <em>Outgoing Dependencies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Outgoing Dependencies</em>'.
   * @see org.sidiff.uml.model.core.UMLNamedElement#getOutgoingDependencies()
   * @see #getUMLNamedElement()
   * @generated
   */
  EReference getUMLNamedElement_OutgoingDependencies();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.core.UMLNamedElement#getDependees <em>Dependees</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Dependees</em>'.
   * @see org.sidiff.uml.model.core.UMLNamedElement#getDependees()
   * @see #getUMLNamedElement()
   * @generated
   */
  EReference getUMLNamedElement_Dependees();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.core.UMLNamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.sidiff.uml.model.core.UMLNamedElement#getName()
   * @see #getUMLNamedElement()
   * @generated
   */
  EAttribute getUMLNamedElement_Name();

  /**
   * Returns the meta object for enum '{@link org.sidiff.uml.model.core.UMLVisibility <em>UML Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>UML Visibility</em>'.
   * @see org.sidiff.uml.model.core.UMLVisibility
   * @generated
   */
  EEnum getUMLVisibility();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CoreFactory getCoreFactory();

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
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLVisibleElementImpl <em>UML Visible Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLVisibleElementImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLVisibleElement()
     * @generated
     */
    EClass UML_VISIBLE_ELEMENT = eINSTANCE.getUMLVisibleElement();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_VISIBLE_ELEMENT__VISIBILITY = eINSTANCE.getUMLVisibleElement_Visibility();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLPackageImpl <em>UML Package</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLPackageImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLPackage()
     * @generated
     */
    EClass UML_PACKAGE = eINSTANCE.getUMLPackage();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PACKAGE__MODEL = eINSTANCE.getUMLPackage_Model();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PACKAGE__PACKAGES = eINSTANCE.getUMLPackage_Packages();

    /**
     * The meta object literal for the '<em><b>Super Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PACKAGE__SUPER_PACKAGE = eINSTANCE.getUMLPackage_SuperPackage();

    /**
     * The meta object literal for the '<em><b>Classifiers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PACKAGE__CLASSIFIERS = eINSTANCE.getUMLPackage_Classifiers();

    /**
     * The meta object literal for the '<em><b>Stored Comments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PACKAGE__STORED_COMMENTS = eINSTANCE.getUMLPackage_StoredComments();

    /**
     * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PACKAGE__ASSOCIATIONS = eINSTANCE.getUMLPackage_Associations();

    /**
     * The meta object literal for the '<em><b>Enumerations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PACKAGE__ENUMERATIONS = eINSTANCE.getUMLPackage_Enumerations();

    /**
     * The meta object literal for the '<em><b>Primitive Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PACKAGE__PRIMITIVE_TYPES = eINSTANCE.getUMLPackage_PrimitiveTypes();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLStereotypeableElementImpl <em>UML Stereotypeable Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLStereotypeableElementImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLStereotypeableElement()
     * @generated
     */
    EClass UML_STEREOTYPEABLE_ELEMENT = eINSTANCE.getUMLStereotypeableElement();

    /**
     * The meta object literal for the '<em><b>Stereotypes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES = eINSTANCE.getUMLStereotypeableElement_Stereotypes();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLStereotypeImpl <em>UML Stereotype</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLStereotypeImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLStereotype()
     * @generated
     */
    EClass UML_STEREOTYPE = eINSTANCE.getUMLStereotype();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_STEREOTYPE__MODEL = eINSTANCE.getUMLStereotype_Model();

    /**
     * The meta object literal for the '<em><b>Stereotyped Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_STEREOTYPE__STEREOTYPED_ELEMENTS = eINSTANCE.getUMLStereotype_StereotypedElements();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLModelImpl <em>UML Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLModelImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLModel()
     * @generated
     */
    EClass UML_MODEL = eINSTANCE.getUMLModel();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_MODEL__PACKAGES = eINSTANCE.getUMLModel_Packages();

    /**
     * The meta object literal for the '<em><b>Stereotypes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_MODEL__STEREOTYPES = eINSTANCE.getUMLModel_Stereotypes();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLElementImpl <em>UML Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLElementImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLElement()
     * @generated
     */
    EClass UML_ELEMENT = eINSTANCE.getUMLElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_ELEMENT__ID = eINSTANCE.getUMLElement_Id();

    /**
     * The meta object literal for the '<em><b>Comments</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ELEMENT__COMMENTS = eINSTANCE.getUMLElement_Comments();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLCommentImpl <em>UML Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLCommentImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLComment()
     * @generated
     */
    EClass UML_COMMENT = eINSTANCE.getUMLComment();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_COMMENT__PACKAGE = eINSTANCE.getUMLComment_Package();

    /**
     * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_COMMENT__COMMENT = eINSTANCE.getUMLComment_Comment();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_COMMENT__ELEMENTS = eINSTANCE.getUMLComment_Elements();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLDependencyImpl <em>UML Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLDependencyImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLDependency()
     * @generated
     */
    EClass UML_DEPENDENCY = eINSTANCE.getUMLDependency();

    /**
     * The meta object literal for the '<em><b>Dependee</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_DEPENDENCY__DEPENDEE = eINSTANCE.getUMLDependency_Dependee();

    /**
     * The meta object literal for the '<em><b>Supplier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_DEPENDENCY__SUPPLIER = eINSTANCE.getUMLDependency_Supplier();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.impl.UMLNamedElementImpl <em>UML Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.impl.UMLNamedElementImpl
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLNamedElement()
     * @generated
     */
    EClass UML_NAMED_ELEMENT = eINSTANCE.getUMLNamedElement();

    /**
     * The meta object literal for the '<em><b>Outgoing Dependencies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES = eINSTANCE.getUMLNamedElement_OutgoingDependencies();

    /**
     * The meta object literal for the '<em><b>Dependees</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_NAMED_ELEMENT__DEPENDEES = eINSTANCE.getUMLNamedElement_Dependees();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_NAMED_ELEMENT__NAME = eINSTANCE.getUMLNamedElement_Name();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.core.UMLVisibility <em>UML Visibility</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.core.UMLVisibility
     * @see org.sidiff.uml.model.core.impl.CorePackageImpl#getUMLVisibility()
     * @generated
     */
    EEnum UML_VISIBILITY = eINSTANCE.getUMLVisibility();

  }

} //CorePackage

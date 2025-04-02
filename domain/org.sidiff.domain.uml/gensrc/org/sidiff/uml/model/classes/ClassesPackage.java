/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.sidiff.uml.model.core.CorePackage;

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
 * @see org.sidiff.uml.model.classes.ClassesFactory
 * @model kind="package"
 * @generated
 */
public interface ClassesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "classes";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.sidiff.org/org.sidiff.uml.model/classes";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "model.classes";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ClassesPackage eINSTANCE = org.sidiff.uml.model.classes.impl.ClassesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLAssociationImpl <em>UML Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLAssociationImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAssociation()
   * @generated
   */
  int UML_ASSOCIATION = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__ID = CorePackage.UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__COMMENTS = CorePackage.UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__OUTGOING_DEPENDENCIES = CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__DEPENDEES = CorePackage.UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__NAME = CorePackage.UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Specializations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__SPECIALIZATIONS = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Generalizations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__GENERALIZATIONS = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__STEREOTYPES = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__ASSOCIATION_ENDS = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION__PACKAGE = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>UML Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_FEATURE_COUNT = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLTypeImpl <em>UML Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLTypeImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLType()
   * @generated
   */
  int UML_TYPE = 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPE__ID = CorePackage.UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPE__COMMENTS = CorePackage.UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPE__OUTGOING_DEPENDENCIES = CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPE__DEPENDEES = CorePackage.UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPE__NAME = CorePackage.UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Used By Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPE__USED_BY_ELEMENTS = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPE_FEATURE_COUNT = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl <em>UML Classifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLClassifierImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLClassifier()
   * @generated
   */
  int UML_CLASSIFIER = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__ID = UML_TYPE__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__COMMENTS = UML_TYPE__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__OUTGOING_DEPENDENCIES = UML_TYPE__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__DEPENDEES = UML_TYPE__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__NAME = UML_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Used By Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__USED_BY_ELEMENTS = UML_TYPE__USED_BY_ELEMENTS;

  /**
   * The feature id for the '<em><b>Specializations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__SPECIALIZATIONS = UML_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Generalizations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__GENERALIZATIONS = UML_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Template Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__TEMPLATE_BINDINGS = UML_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__STEREOTYPES = UML_TYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Template Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__TEMPLATE_PARAMETERS = UML_TYPE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__VISIBILITY = UML_TYPE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Targeted By Association Ends</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS = UML_TYPE_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER__PACKAGE = UML_TYPE_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>UML Classifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASSIFIER_FEATURE_COUNT = UML_TYPE_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLTypedElementImpl <em>UML Typed Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLTypedElementImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLTypedElement()
   * @generated
   */
  int UML_TYPED_ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPED_ELEMENT__TYPE = 0;

  /**
   * The number of structural features of the '<em>UML Typed Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TYPED_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLGeneralizableElementImpl <em>UML Generalizable Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLGeneralizableElementImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLGeneralizableElement()
   * @generated
   */
  int UML_GENERALIZABLE_ELEMENT = 4;

  /**
   * The feature id for the '<em><b>Specializations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS = 0;

  /**
   * The feature id for the '<em><b>Generalizations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS = 1;

  /**
   * The number of structural features of the '<em>UML Generalizable Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_GENERALIZABLE_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLGeneralizationImpl <em>UML Generalization</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLGeneralizationImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLGeneralization()
   * @generated
   */
  int UML_GENERALIZATION = 5;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_GENERALIZATION__ID = CorePackage.UML_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_GENERALIZATION__COMMENTS = CorePackage.UML_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Special Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_GENERALIZATION__SPECIAL_ELEMENT = CorePackage.UML_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>General Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_GENERALIZATION__GENERAL_ELEMENT = CorePackage.UML_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>UML Generalization</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_GENERALIZATION_FEATURE_COUNT = CorePackage.UML_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLBindingElementImpl <em>UML Binding Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLBindingElementImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLBindingElement()
   * @generated
   */
  int UML_BINDING_ELEMENT = 6;

  /**
   * The feature id for the '<em><b>Template Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_BINDING_ELEMENT__TEMPLATE_BINDINGS = 0;

  /**
   * The number of structural features of the '<em>UML Binding Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_BINDING_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl <em>UML Template Binding</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLTemplateBinding()
   * @generated
   */
  int UML_TEMPLATE_BINDING = 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_BINDING__ID = CorePackage.UML_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_BINDING__COMMENTS = CorePackage.UML_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Formal Param</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_BINDING__FORMAL_PARAM = CorePackage.UML_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Actual Param</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_BINDING__ACTUAL_PARAM = CorePackage.UML_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Binder</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_BINDING__BINDER = CorePackage.UML_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>UML Template Binding</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_BINDING_FEATURE_COUNT = CorePackage.UML_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl <em>UML Template Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLTemplateParameter()
   * @generated
   */
  int UML_TEMPLATE_PARAMETER = 8;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_PARAMETER__ID = CorePackage.UML_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_PARAMETER__COMMENTS = CorePackage.UML_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Templateable Element</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT = CorePackage.UML_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_PARAMETER__TYPE = CorePackage.UML_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_PARAMETER__BINDINGS = CorePackage.UML_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>UML Template Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATE_PARAMETER_FEATURE_COUNT = CorePackage.UML_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLTemplateableElementImpl <em>UML Templateable Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLTemplateableElementImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLTemplateableElement()
   * @generated
   */
  int UML_TEMPLATEABLE_ELEMENT = 9;

  /**
   * The feature id for the '<em><b>Template Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS = 0;

  /**
   * The number of structural features of the '<em>UML Templateable Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_TEMPLATEABLE_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl <em>UML Association End</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAssociationEnd()
   * @generated
   */
  int UML_ASSOCIATION_END = 10;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__ID = CorePackage.UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__COMMENTS = CorePackage.UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__OUTGOING_DEPENDENCIES = CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__DEPENDEES = CorePackage.UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__NAME = CorePackage.UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__STEREOTYPES = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Association</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__ASSOCIATION = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__MULTIPLICITY = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Is Navigable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__IS_NAVIGABLE = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__KIND = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__IS_ORDERED = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END__TARGET = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>UML Association End</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_END_FEATURE_COUNT = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLEnumerationImpl <em>UML Enumeration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLEnumerationImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLEnumeration()
   * @generated
   */
  int UML_ENUMERATION = 11;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__ID = UML_TYPE__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__COMMENTS = UML_TYPE__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__OUTGOING_DEPENDENCIES = UML_TYPE__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__DEPENDEES = UML_TYPE__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__NAME = UML_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Used By Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__USED_BY_ELEMENTS = UML_TYPE__USED_BY_ELEMENTS;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__VISIBILITY = UML_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__LITERALS = UML_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION__PACKAGE = UML_TYPE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>UML Enumeration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ENUMERATION_FEATURE_COUNT = UML_TYPE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLLiteralImpl <em>UML Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLLiteralImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLLiteral()
   * @generated
   */
  int UML_LITERAL = 12;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LITERAL__ID = CorePackage.UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LITERAL__COMMENTS = CorePackage.UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LITERAL__OUTGOING_DEPENDENCIES = CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LITERAL__DEPENDEES = CorePackage.UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LITERAL__NAME = CorePackage.UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Enumeration</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LITERAL__ENUMERATION = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_LITERAL_FEATURE_COUNT = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLPrimitiveTypeImpl <em>UML Primitive Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLPrimitiveTypeImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLPrimitiveType()
   * @generated
   */
  int UML_PRIMITIVE_TYPE = 13;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PRIMITIVE_TYPE__ID = UML_TYPE__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PRIMITIVE_TYPE__COMMENTS = UML_TYPE__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PRIMITIVE_TYPE__OUTGOING_DEPENDENCIES = UML_TYPE__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PRIMITIVE_TYPE__DEPENDEES = UML_TYPE__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PRIMITIVE_TYPE__NAME = UML_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Used By Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PRIMITIVE_TYPE__USED_BY_ELEMENTS = UML_TYPE__USED_BY_ELEMENTS;

  /**
   * The feature id for the '<em><b>Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PRIMITIVE_TYPE__PACKAGE = UML_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Primitive Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PRIMITIVE_TYPE_FEATURE_COUNT = UML_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLAssociationClassImpl <em>UML Association Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLAssociationClassImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAssociationClass()
   * @generated
   */
  int UML_ASSOCIATION_CLASS = 14;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__ID = UML_ASSOCIATION__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__COMMENTS = UML_ASSOCIATION__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__OUTGOING_DEPENDENCIES = UML_ASSOCIATION__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__DEPENDEES = UML_ASSOCIATION__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__NAME = UML_ASSOCIATION__NAME;

  /**
   * The feature id for the '<em><b>Specializations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__SPECIALIZATIONS = UML_ASSOCIATION__SPECIALIZATIONS;

  /**
   * The feature id for the '<em><b>Generalizations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__GENERALIZATIONS = UML_ASSOCIATION__GENERALIZATIONS;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__STEREOTYPES = UML_ASSOCIATION__STEREOTYPES;

  /**
   * The feature id for the '<em><b>Association Ends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__ASSOCIATION_ENDS = UML_ASSOCIATION__ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS__PACKAGE = UML_ASSOCIATION__PACKAGE;

  /**
   * The number of structural features of the '<em>UML Association Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ASSOCIATION_CLASS_FEATURE_COUNT = UML_ASSOCIATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLClassImpl <em>UML Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLClassImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLClass()
   * @generated
   */
  int UML_CLASS = 15;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__ID = UML_CLASSIFIER__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__COMMENTS = UML_CLASSIFIER__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__OUTGOING_DEPENDENCIES = UML_CLASSIFIER__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__DEPENDEES = UML_CLASSIFIER__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__NAME = UML_CLASSIFIER__NAME;

  /**
   * The feature id for the '<em><b>Used By Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__USED_BY_ELEMENTS = UML_CLASSIFIER__USED_BY_ELEMENTS;

  /**
   * The feature id for the '<em><b>Specializations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__SPECIALIZATIONS = UML_CLASSIFIER__SPECIALIZATIONS;

  /**
   * The feature id for the '<em><b>Generalizations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__GENERALIZATIONS = UML_CLASSIFIER__GENERALIZATIONS;

  /**
   * The feature id for the '<em><b>Template Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__TEMPLATE_BINDINGS = UML_CLASSIFIER__TEMPLATE_BINDINGS;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__STEREOTYPES = UML_CLASSIFIER__STEREOTYPES;

  /**
   * The feature id for the '<em><b>Template Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__TEMPLATE_PARAMETERS = UML_CLASSIFIER__TEMPLATE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__VISIBILITY = UML_CLASSIFIER__VISIBILITY;

  /**
   * The feature id for the '<em><b>Targeted By Association Ends</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__TARGETED_BY_ASSOCIATION_ENDS = UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__PACKAGE = UML_CLASSIFIER__PACKAGE;

  /**
   * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__IS_ABSTRACT = UML_CLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Is Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__IS_FINAL = UML_CLASSIFIER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__OPERATIONS = UML_CLASSIFIER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS__ATTRIBUTES = UML_CLASSIFIER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>UML Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_CLASS_FEATURE_COUNT = UML_CLASSIFIER_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLOperationImpl <em>UML Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLOperationImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLOperation()
   * @generated
   */
  int UML_OPERATION = 16;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__ID = CorePackage.UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__COMMENTS = CorePackage.UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__OUTGOING_DEPENDENCIES = CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__DEPENDEES = CorePackage.UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__NAME = CorePackage.UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__STEREOTYPES = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__TYPE = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__VISIBILITY = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__IS_ABSTRACT = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Is Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__IS_STATIC = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Interface</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__INTERFACE = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__PARAMETERS = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Class</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION__CLASS = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>UML Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_OPERATION_FEATURE_COUNT = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLInterfaceImpl <em>UML Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLInterfaceImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLInterface()
   * @generated
   */
  int UML_INTERFACE = 17;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__ID = UML_CLASSIFIER__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__COMMENTS = UML_CLASSIFIER__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__OUTGOING_DEPENDENCIES = UML_CLASSIFIER__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__DEPENDEES = UML_CLASSIFIER__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__NAME = UML_CLASSIFIER__NAME;

  /**
   * The feature id for the '<em><b>Used By Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__USED_BY_ELEMENTS = UML_CLASSIFIER__USED_BY_ELEMENTS;

  /**
   * The feature id for the '<em><b>Specializations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__SPECIALIZATIONS = UML_CLASSIFIER__SPECIALIZATIONS;

  /**
   * The feature id for the '<em><b>Generalizations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__GENERALIZATIONS = UML_CLASSIFIER__GENERALIZATIONS;

  /**
   * The feature id for the '<em><b>Template Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__TEMPLATE_BINDINGS = UML_CLASSIFIER__TEMPLATE_BINDINGS;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__STEREOTYPES = UML_CLASSIFIER__STEREOTYPES;

  /**
   * The feature id for the '<em><b>Template Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__TEMPLATE_PARAMETERS = UML_CLASSIFIER__TEMPLATE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__VISIBILITY = UML_CLASSIFIER__VISIBILITY;

  /**
   * The feature id for the '<em><b>Targeted By Association Ends</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__TARGETED_BY_ASSOCIATION_ENDS = UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS;

  /**
   * The feature id for the '<em><b>Package</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__PACKAGE = UML_CLASSIFIER__PACKAGE;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE__OPERATIONS = UML_CLASSIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>UML Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_INTERFACE_FEATURE_COUNT = UML_CLASSIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLParameterImpl <em>UML Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLParameterImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLParameter()
   * @generated
   */
  int UML_PARAMETER = 18;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__ID = CorePackage.UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__COMMENTS = CorePackage.UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__OUTGOING_DEPENDENCIES = CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__DEPENDEES = CorePackage.UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__NAME = CorePackage.UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__STEREOTYPES = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__TYPE = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__KIND = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Operation</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER__OPERATION = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>UML Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_PARAMETER_FEATURE_COUNT = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl <em>UML Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.impl.UMLAttributeImpl
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAttribute()
   * @generated
   */
  int UML_ATTRIBUTE = 19;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__ID = CorePackage.UML_NAMED_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Comments</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__COMMENTS = CorePackage.UML_NAMED_ELEMENT__COMMENTS;

  /**
   * The feature id for the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__OUTGOING_DEPENDENCIES = CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES;

  /**
   * The feature id for the '<em><b>Dependees</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__DEPENDEES = CorePackage.UML_NAMED_ELEMENT__DEPENDEES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__NAME = CorePackage.UML_NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Stereotypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__STEREOTYPES = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__TYPE = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__VISIBILITY = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Is Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__IS_STATIC = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Is Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__IS_FINAL = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Is Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__IS_READ_ONLY = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Class</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE__CLASS = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>UML Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UML_ATTRIBUTE_FEATURE_COUNT = CorePackage.UML_NAMED_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.UMLAggregationKind <em>UML Aggregation Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.UMLAggregationKind
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAggregationKind()
   * @generated
   */
  int UML_AGGREGATION_KIND = 20;

  /**
   * The meta object id for the '{@link org.sidiff.uml.model.classes.UMLParameterKind <em>UML Parameter Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.sidiff.uml.model.classes.UMLParameterKind
   * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLParameterKind()
   * @generated
   */
  int UML_PARAMETER_KIND = 21;


  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLAssociation <em>UML Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Association</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociation
   * @generated
   */
  EClass getUMLAssociation();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLAssociation#getAssociationEnds <em>Association Ends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Ends</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociation#getAssociationEnds()
   * @see #getUMLAssociation()
   * @generated
   */
  EReference getUMLAssociation_AssociationEnds();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLAssociation#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Package</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociation#getPackage()
   * @see #getUMLAssociation()
   * @generated
   */
  EReference getUMLAssociation_Package();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLClassifier <em>UML Classifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Classifier</em>'.
   * @see org.sidiff.uml.model.classes.UMLClassifier
   * @generated
   */
  EClass getUMLClassifier();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.classes.UMLClassifier#getTargetedByAssociationEnds <em>Targeted By Association Ends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Targeted By Association Ends</em>'.
   * @see org.sidiff.uml.model.classes.UMLClassifier#getTargetedByAssociationEnds()
   * @see #getUMLClassifier()
   * @generated
   */
  EReference getUMLClassifier_TargetedByAssociationEnds();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLClassifier#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Package</em>'.
   * @see org.sidiff.uml.model.classes.UMLClassifier#getPackage()
   * @see #getUMLClassifier()
   * @generated
   */
  EReference getUMLClassifier_Package();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLType <em>UML Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Type</em>'.
   * @see org.sidiff.uml.model.classes.UMLType
   * @generated
   */
  EClass getUMLType();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.classes.UMLType#getUsedByElements <em>Used By Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Used By Elements</em>'.
   * @see org.sidiff.uml.model.classes.UMLType#getUsedByElements()
   * @see #getUMLType()
   * @generated
   */
  EReference getUMLType_UsedByElements();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLTypedElement <em>UML Typed Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Typed Element</em>'.
   * @see org.sidiff.uml.model.classes.UMLTypedElement
   * @generated
   */
  EClass getUMLTypedElement();

  /**
   * Returns the meta object for the reference '{@link org.sidiff.uml.model.classes.UMLTypedElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.sidiff.uml.model.classes.UMLTypedElement#getType()
   * @see #getUMLTypedElement()
   * @generated
   */
  EReference getUMLTypedElement_Type();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLGeneralizableElement <em>UML Generalizable Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Generalizable Element</em>'.
   * @see org.sidiff.uml.model.classes.UMLGeneralizableElement
   * @generated
   */
  EClass getUMLGeneralizableElement();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.classes.UMLGeneralizableElement#getSpecializations <em>Specializations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Specializations</em>'.
   * @see org.sidiff.uml.model.classes.UMLGeneralizableElement#getSpecializations()
   * @see #getUMLGeneralizableElement()
   * @generated
   */
  EReference getUMLGeneralizableElement_Specializations();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLGeneralizableElement#getGeneralizations <em>Generalizations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generalizations</em>'.
   * @see org.sidiff.uml.model.classes.UMLGeneralizableElement#getGeneralizations()
   * @see #getUMLGeneralizableElement()
   * @generated
   */
  EReference getUMLGeneralizableElement_Generalizations();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLGeneralization <em>UML Generalization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Generalization</em>'.
   * @see org.sidiff.uml.model.classes.UMLGeneralization
   * @generated
   */
  EClass getUMLGeneralization();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLGeneralization#getSpecialElement <em>Special Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Special Element</em>'.
   * @see org.sidiff.uml.model.classes.UMLGeneralization#getSpecialElement()
   * @see #getUMLGeneralization()
   * @generated
   */
  EReference getUMLGeneralization_SpecialElement();

  /**
   * Returns the meta object for the reference '{@link org.sidiff.uml.model.classes.UMLGeneralization#getGeneralElement <em>General Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>General Element</em>'.
   * @see org.sidiff.uml.model.classes.UMLGeneralization#getGeneralElement()
   * @see #getUMLGeneralization()
   * @generated
   */
  EReference getUMLGeneralization_GeneralElement();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLBindingElement <em>UML Binding Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Binding Element</em>'.
   * @see org.sidiff.uml.model.classes.UMLBindingElement
   * @generated
   */
  EClass getUMLBindingElement();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLBindingElement#getTemplateBindings <em>Template Bindings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Template Bindings</em>'.
   * @see org.sidiff.uml.model.classes.UMLBindingElement#getTemplateBindings()
   * @see #getUMLBindingElement()
   * @generated
   */
  EReference getUMLBindingElement_TemplateBindings();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLTemplateBinding <em>UML Template Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Template Binding</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateBinding
   * @generated
   */
  EClass getUMLTemplateBinding();

  /**
   * Returns the meta object for the reference '{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getFormalParam <em>Formal Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Formal Param</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateBinding#getFormalParam()
   * @see #getUMLTemplateBinding()
   * @generated
   */
  EReference getUMLTemplateBinding_FormalParam();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getActualParam <em>Actual Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Actual Param</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateBinding#getActualParam()
   * @see #getUMLTemplateBinding()
   * @generated
   */
  EAttribute getUMLTemplateBinding_ActualParam();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getBinder <em>Binder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Binder</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateBinding#getBinder()
   * @see #getUMLTemplateBinding()
   * @generated
   */
  EReference getUMLTemplateBinding_Binder();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLTemplateParameter <em>UML Template Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Template Parameter</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateParameter
   * @generated
   */
  EClass getUMLTemplateParameter();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getTemplateableElement <em>Templateable Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Templateable Element</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateParameter#getTemplateableElement()
   * @see #getUMLTemplateParameter()
   * @generated
   */
  EReference getUMLTemplateParameter_TemplateableElement();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateParameter#getType()
   * @see #getUMLTemplateParameter()
   * @generated
   */
  EAttribute getUMLTemplateParameter_Type();

  /**
   * Returns the meta object for the reference list '{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getBindings <em>Bindings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Bindings</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateParameter#getBindings()
   * @see #getUMLTemplateParameter()
   * @generated
   */
  EReference getUMLTemplateParameter_Bindings();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLTemplateableElement <em>UML Templateable Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Templateable Element</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateableElement
   * @generated
   */
  EClass getUMLTemplateableElement();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLTemplateableElement#getTemplateParameters <em>Template Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Template Parameters</em>'.
   * @see org.sidiff.uml.model.classes.UMLTemplateableElement#getTemplateParameters()
   * @see #getUMLTemplateableElement()
   * @generated
   */
  EReference getUMLTemplateableElement_TemplateParameters();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLAssociationEnd <em>UML Association End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Association End</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd
   * @generated
   */
  EClass getUMLAssociationEnd();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Association</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd#getAssociation()
   * @see #getUMLAssociationEnd()
   * @generated
   */
  EReference getUMLAssociationEnd_Association();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiplicity</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd#getMultiplicity()
   * @see #getUMLAssociationEnd()
   * @generated
   */
  EAttribute getUMLAssociationEnd_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#isIsNavigable <em>Is Navigable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Navigable</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd#isIsNavigable()
   * @see #getUMLAssociationEnd()
   * @generated
   */
  EAttribute getUMLAssociationEnd_IsNavigable();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd#getKind()
   * @see #getUMLAssociationEnd()
   * @generated
   */
  EAttribute getUMLAssociationEnd_Kind();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#isIsOrdered <em>Is Ordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Ordered</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd#isIsOrdered()
   * @see #getUMLAssociationEnd()
   * @generated
   */
  EAttribute getUMLAssociationEnd_IsOrdered();

  /**
   * Returns the meta object for the reference '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd#getTarget()
   * @see #getUMLAssociationEnd()
   * @generated
   */
  EReference getUMLAssociationEnd_Target();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLEnumeration <em>UML Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Enumeration</em>'.
   * @see org.sidiff.uml.model.classes.UMLEnumeration
   * @generated
   */
  EClass getUMLEnumeration();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLEnumeration#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see org.sidiff.uml.model.classes.UMLEnumeration#getLiterals()
   * @see #getUMLEnumeration()
   * @generated
   */
  EReference getUMLEnumeration_Literals();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLEnumeration#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Package</em>'.
   * @see org.sidiff.uml.model.classes.UMLEnumeration#getPackage()
   * @see #getUMLEnumeration()
   * @generated
   */
  EReference getUMLEnumeration_Package();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLLiteral <em>UML Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Literal</em>'.
   * @see org.sidiff.uml.model.classes.UMLLiteral
   * @generated
   */
  EClass getUMLLiteral();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLLiteral#getEnumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Enumeration</em>'.
   * @see org.sidiff.uml.model.classes.UMLLiteral#getEnumeration()
   * @see #getUMLLiteral()
   * @generated
   */
  EReference getUMLLiteral_Enumeration();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLPrimitiveType <em>UML Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Primitive Type</em>'.
   * @see org.sidiff.uml.model.classes.UMLPrimitiveType
   * @generated
   */
  EClass getUMLPrimitiveType();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLPrimitiveType#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Package</em>'.
   * @see org.sidiff.uml.model.classes.UMLPrimitiveType#getPackage()
   * @see #getUMLPrimitiveType()
   * @generated
   */
  EReference getUMLPrimitiveType_Package();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLAssociationClass <em>UML Association Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Association Class</em>'.
   * @see org.sidiff.uml.model.classes.UMLAssociationClass
   * @generated
   */
  EClass getUMLAssociationClass();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLClass <em>UML Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Class</em>'.
   * @see org.sidiff.uml.model.classes.UMLClass
   * @generated
   */
  EClass getUMLClass();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLClass#isIsAbstract <em>Is Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Abstract</em>'.
   * @see org.sidiff.uml.model.classes.UMLClass#isIsAbstract()
   * @see #getUMLClass()
   * @generated
   */
  EAttribute getUMLClass_IsAbstract();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLClass#isIsFinal <em>Is Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Final</em>'.
   * @see org.sidiff.uml.model.classes.UMLClass#isIsFinal()
   * @see #getUMLClass()
   * @generated
   */
  EAttribute getUMLClass_IsFinal();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLClass#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see org.sidiff.uml.model.classes.UMLClass#getOperations()
   * @see #getUMLClass()
   * @generated
   */
  EReference getUMLClass_Operations();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLClass#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.sidiff.uml.model.classes.UMLClass#getAttributes()
   * @see #getUMLClass()
   * @generated
   */
  EReference getUMLClass_Attributes();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLOperation <em>UML Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Operation</em>'.
   * @see org.sidiff.uml.model.classes.UMLOperation
   * @generated
   */
  EClass getUMLOperation();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLOperation#isIsAbstract <em>Is Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Abstract</em>'.
   * @see org.sidiff.uml.model.classes.UMLOperation#isIsAbstract()
   * @see #getUMLOperation()
   * @generated
   */
  EAttribute getUMLOperation_IsAbstract();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLOperation#isIsStatic <em>Is Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Static</em>'.
   * @see org.sidiff.uml.model.classes.UMLOperation#isIsStatic()
   * @see #getUMLOperation()
   * @generated
   */
  EAttribute getUMLOperation_IsStatic();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLOperation#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Interface</em>'.
   * @see org.sidiff.uml.model.classes.UMLOperation#getInterface()
   * @see #getUMLOperation()
   * @generated
   */
  EReference getUMLOperation_Interface();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLOperation#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.sidiff.uml.model.classes.UMLOperation#getParameters()
   * @see #getUMLOperation()
   * @generated
   */
  EReference getUMLOperation_Parameters();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLOperation#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Class</em>'.
   * @see org.sidiff.uml.model.classes.UMLOperation#getClass_()
   * @see #getUMLOperation()
   * @generated
   */
  EReference getUMLOperation_Class();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLInterface <em>UML Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Interface</em>'.
   * @see org.sidiff.uml.model.classes.UMLInterface
   * @generated
   */
  EClass getUMLInterface();

  /**
   * Returns the meta object for the containment reference list '{@link org.sidiff.uml.model.classes.UMLInterface#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see org.sidiff.uml.model.classes.UMLInterface#getOperations()
   * @see #getUMLInterface()
   * @generated
   */
  EReference getUMLInterface_Operations();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLParameter <em>UML Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Parameter</em>'.
   * @see org.sidiff.uml.model.classes.UMLParameter
   * @generated
   */
  EClass getUMLParameter();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLParameter#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.sidiff.uml.model.classes.UMLParameter#getKind()
   * @see #getUMLParameter()
   * @generated
   */
  EAttribute getUMLParameter_Kind();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLParameter#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Operation</em>'.
   * @see org.sidiff.uml.model.classes.UMLParameter#getOperation()
   * @see #getUMLParameter()
   * @generated
   */
  EReference getUMLParameter_Operation();

  /**
   * Returns the meta object for class '{@link org.sidiff.uml.model.classes.UMLAttribute <em>UML Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UML Attribute</em>'.
   * @see org.sidiff.uml.model.classes.UMLAttribute
   * @generated
   */
  EClass getUMLAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLAttribute#isIsStatic <em>Is Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Static</em>'.
   * @see org.sidiff.uml.model.classes.UMLAttribute#isIsStatic()
   * @see #getUMLAttribute()
   * @generated
   */
  EAttribute getUMLAttribute_IsStatic();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLAttribute#isIsFinal <em>Is Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Final</em>'.
   * @see org.sidiff.uml.model.classes.UMLAttribute#isIsFinal()
   * @see #getUMLAttribute()
   * @generated
   */
  EAttribute getUMLAttribute_IsFinal();

  /**
   * Returns the meta object for the attribute '{@link org.sidiff.uml.model.classes.UMLAttribute#isIsReadOnly <em>Is Read Only</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Read Only</em>'.
   * @see org.sidiff.uml.model.classes.UMLAttribute#isIsReadOnly()
   * @see #getUMLAttribute()
   * @generated
   */
  EAttribute getUMLAttribute_IsReadOnly();

  /**
   * Returns the meta object for the container reference '{@link org.sidiff.uml.model.classes.UMLAttribute#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Class</em>'.
   * @see org.sidiff.uml.model.classes.UMLAttribute#getClass_()
   * @see #getUMLAttribute()
   * @generated
   */
  EReference getUMLAttribute_Class();

  /**
   * Returns the meta object for enum '{@link org.sidiff.uml.model.classes.UMLAggregationKind <em>UML Aggregation Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>UML Aggregation Kind</em>'.
   * @see org.sidiff.uml.model.classes.UMLAggregationKind
   * @generated
   */
  EEnum getUMLAggregationKind();

  /**
   * Returns the meta object for enum '{@link org.sidiff.uml.model.classes.UMLParameterKind <em>UML Parameter Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>UML Parameter Kind</em>'.
   * @see org.sidiff.uml.model.classes.UMLParameterKind
   * @generated
   */
  EEnum getUMLParameterKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ClassesFactory getClassesFactory();

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
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLAssociationImpl <em>UML Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLAssociationImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAssociation()
     * @generated
     */
    EClass UML_ASSOCIATION = eINSTANCE.getUMLAssociation();

    /**
     * The meta object literal for the '<em><b>Association Ends</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ASSOCIATION__ASSOCIATION_ENDS = eINSTANCE.getUMLAssociation_AssociationEnds();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ASSOCIATION__PACKAGE = eINSTANCE.getUMLAssociation_Package();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl <em>UML Classifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLClassifierImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLClassifier()
     * @generated
     */
    EClass UML_CLASSIFIER = eINSTANCE.getUMLClassifier();

    /**
     * The meta object literal for the '<em><b>Targeted By Association Ends</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS = eINSTANCE.getUMLClassifier_TargetedByAssociationEnds();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_CLASSIFIER__PACKAGE = eINSTANCE.getUMLClassifier_Package();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLTypeImpl <em>UML Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLTypeImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLType()
     * @generated
     */
    EClass UML_TYPE = eINSTANCE.getUMLType();

    /**
     * The meta object literal for the '<em><b>Used By Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TYPE__USED_BY_ELEMENTS = eINSTANCE.getUMLType_UsedByElements();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLTypedElementImpl <em>UML Typed Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLTypedElementImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLTypedElement()
     * @generated
     */
    EClass UML_TYPED_ELEMENT = eINSTANCE.getUMLTypedElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TYPED_ELEMENT__TYPE = eINSTANCE.getUMLTypedElement_Type();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLGeneralizableElementImpl <em>UML Generalizable Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLGeneralizableElementImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLGeneralizableElement()
     * @generated
     */
    EClass UML_GENERALIZABLE_ELEMENT = eINSTANCE.getUMLGeneralizableElement();

    /**
     * The meta object literal for the '<em><b>Specializations</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS = eINSTANCE.getUMLGeneralizableElement_Specializations();

    /**
     * The meta object literal for the '<em><b>Generalizations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS = eINSTANCE.getUMLGeneralizableElement_Generalizations();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLGeneralizationImpl <em>UML Generalization</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLGeneralizationImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLGeneralization()
     * @generated
     */
    EClass UML_GENERALIZATION = eINSTANCE.getUMLGeneralization();

    /**
     * The meta object literal for the '<em><b>Special Element</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_GENERALIZATION__SPECIAL_ELEMENT = eINSTANCE.getUMLGeneralization_SpecialElement();

    /**
     * The meta object literal for the '<em><b>General Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_GENERALIZATION__GENERAL_ELEMENT = eINSTANCE.getUMLGeneralization_GeneralElement();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLBindingElementImpl <em>UML Binding Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLBindingElementImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLBindingElement()
     * @generated
     */
    EClass UML_BINDING_ELEMENT = eINSTANCE.getUMLBindingElement();

    /**
     * The meta object literal for the '<em><b>Template Bindings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_BINDING_ELEMENT__TEMPLATE_BINDINGS = eINSTANCE.getUMLBindingElement_TemplateBindings();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl <em>UML Template Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLTemplateBinding()
     * @generated
     */
    EClass UML_TEMPLATE_BINDING = eINSTANCE.getUMLTemplateBinding();

    /**
     * The meta object literal for the '<em><b>Formal Param</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEMPLATE_BINDING__FORMAL_PARAM = eINSTANCE.getUMLTemplateBinding_FormalParam();

    /**
     * The meta object literal for the '<em><b>Actual Param</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_TEMPLATE_BINDING__ACTUAL_PARAM = eINSTANCE.getUMLTemplateBinding_ActualParam();

    /**
     * The meta object literal for the '<em><b>Binder</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEMPLATE_BINDING__BINDER = eINSTANCE.getUMLTemplateBinding_Binder();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl <em>UML Template Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLTemplateParameter()
     * @generated
     */
    EClass UML_TEMPLATE_PARAMETER = eINSTANCE.getUMLTemplateParameter();

    /**
     * The meta object literal for the '<em><b>Templateable Element</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT = eINSTANCE.getUMLTemplateParameter_TemplateableElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_TEMPLATE_PARAMETER__TYPE = eINSTANCE.getUMLTemplateParameter_Type();

    /**
     * The meta object literal for the '<em><b>Bindings</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEMPLATE_PARAMETER__BINDINGS = eINSTANCE.getUMLTemplateParameter_Bindings();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLTemplateableElementImpl <em>UML Templateable Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLTemplateableElementImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLTemplateableElement()
     * @generated
     */
    EClass UML_TEMPLATEABLE_ELEMENT = eINSTANCE.getUMLTemplateableElement();

    /**
     * The meta object literal for the '<em><b>Template Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS = eINSTANCE.getUMLTemplateableElement_TemplateParameters();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl <em>UML Association End</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAssociationEnd()
     * @generated
     */
    EClass UML_ASSOCIATION_END = eINSTANCE.getUMLAssociationEnd();

    /**
     * The meta object literal for the '<em><b>Association</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ASSOCIATION_END__ASSOCIATION = eINSTANCE.getUMLAssociationEnd_Association();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_ASSOCIATION_END__MULTIPLICITY = eINSTANCE.getUMLAssociationEnd_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Is Navigable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_ASSOCIATION_END__IS_NAVIGABLE = eINSTANCE.getUMLAssociationEnd_IsNavigable();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_ASSOCIATION_END__KIND = eINSTANCE.getUMLAssociationEnd_Kind();

    /**
     * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_ASSOCIATION_END__IS_ORDERED = eINSTANCE.getUMLAssociationEnd_IsOrdered();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ASSOCIATION_END__TARGET = eINSTANCE.getUMLAssociationEnd_Target();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLEnumerationImpl <em>UML Enumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLEnumerationImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLEnumeration()
     * @generated
     */
    EClass UML_ENUMERATION = eINSTANCE.getUMLEnumeration();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ENUMERATION__LITERALS = eINSTANCE.getUMLEnumeration_Literals();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ENUMERATION__PACKAGE = eINSTANCE.getUMLEnumeration_Package();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLLiteralImpl <em>UML Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLLiteralImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLLiteral()
     * @generated
     */
    EClass UML_LITERAL = eINSTANCE.getUMLLiteral();

    /**
     * The meta object literal for the '<em><b>Enumeration</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_LITERAL__ENUMERATION = eINSTANCE.getUMLLiteral_Enumeration();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLPrimitiveTypeImpl <em>UML Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLPrimitiveTypeImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLPrimitiveType()
     * @generated
     */
    EClass UML_PRIMITIVE_TYPE = eINSTANCE.getUMLPrimitiveType();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PRIMITIVE_TYPE__PACKAGE = eINSTANCE.getUMLPrimitiveType_Package();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLAssociationClassImpl <em>UML Association Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLAssociationClassImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAssociationClass()
     * @generated
     */
    EClass UML_ASSOCIATION_CLASS = eINSTANCE.getUMLAssociationClass();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLClassImpl <em>UML Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLClassImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLClass()
     * @generated
     */
    EClass UML_CLASS = eINSTANCE.getUMLClass();

    /**
     * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_CLASS__IS_ABSTRACT = eINSTANCE.getUMLClass_IsAbstract();

    /**
     * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_CLASS__IS_FINAL = eINSTANCE.getUMLClass_IsFinal();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_CLASS__OPERATIONS = eINSTANCE.getUMLClass_Operations();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_CLASS__ATTRIBUTES = eINSTANCE.getUMLClass_Attributes();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLOperationImpl <em>UML Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLOperationImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLOperation()
     * @generated
     */
    EClass UML_OPERATION = eINSTANCE.getUMLOperation();

    /**
     * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_OPERATION__IS_ABSTRACT = eINSTANCE.getUMLOperation_IsAbstract();

    /**
     * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_OPERATION__IS_STATIC = eINSTANCE.getUMLOperation_IsStatic();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_OPERATION__INTERFACE = eINSTANCE.getUMLOperation_Interface();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_OPERATION__PARAMETERS = eINSTANCE.getUMLOperation_Parameters();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_OPERATION__CLASS = eINSTANCE.getUMLOperation_Class();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLInterfaceImpl <em>UML Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLInterfaceImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLInterface()
     * @generated
     */
    EClass UML_INTERFACE = eINSTANCE.getUMLInterface();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_INTERFACE__OPERATIONS = eINSTANCE.getUMLInterface_Operations();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLParameterImpl <em>UML Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLParameterImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLParameter()
     * @generated
     */
    EClass UML_PARAMETER = eINSTANCE.getUMLParameter();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_PARAMETER__KIND = eINSTANCE.getUMLParameter_Kind();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_PARAMETER__OPERATION = eINSTANCE.getUMLParameter_Operation();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl <em>UML Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.impl.UMLAttributeImpl
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAttribute()
     * @generated
     */
    EClass UML_ATTRIBUTE = eINSTANCE.getUMLAttribute();

    /**
     * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_ATTRIBUTE__IS_STATIC = eINSTANCE.getUMLAttribute_IsStatic();

    /**
     * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_ATTRIBUTE__IS_FINAL = eINSTANCE.getUMLAttribute_IsFinal();

    /**
     * The meta object literal for the '<em><b>Is Read Only</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UML_ATTRIBUTE__IS_READ_ONLY = eINSTANCE.getUMLAttribute_IsReadOnly();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UML_ATTRIBUTE__CLASS = eINSTANCE.getUMLAttribute_Class();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.UMLAggregationKind <em>UML Aggregation Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.UMLAggregationKind
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLAggregationKind()
     * @generated
     */
    EEnum UML_AGGREGATION_KIND = eINSTANCE.getUMLAggregationKind();

    /**
     * The meta object literal for the '{@link org.sidiff.uml.model.classes.UMLParameterKind <em>UML Parameter Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.sidiff.uml.model.classes.UMLParameterKind
     * @see org.sidiff.uml.model.classes.impl.ClassesPackageImpl#getUMLParameterKind()
     * @generated
     */
    EEnum UML_PARAMETER_KIND = eINSTANCE.getUMLParameterKind();

  }

} //ClassesPackage

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sidiff.uml.model.classes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassesFactoryImpl extends EFactoryImpl implements ClassesFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ClassesFactory init()
  {
    try
    {
      ClassesFactory theClassesFactory = (ClassesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.sidiff.org/org.sidiff.uml.model/classes"); 
      if (theClassesFactory != null)
      {
        return theClassesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ClassesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassesFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ClassesPackage.UML_ASSOCIATION: return createUMLAssociation();
      case ClassesPackage.UML_GENERALIZATION: return createUMLGeneralization();
      case ClassesPackage.UML_TEMPLATE_BINDING: return createUMLTemplateBinding();
      case ClassesPackage.UML_TEMPLATE_PARAMETER: return createUMLTemplateParameter();
      case ClassesPackage.UML_ASSOCIATION_END: return createUMLAssociationEnd();
      case ClassesPackage.UML_ENUMERATION: return createUMLEnumeration();
      case ClassesPackage.UML_LITERAL: return createUMLLiteral();
      case ClassesPackage.UML_PRIMITIVE_TYPE: return createUMLPrimitiveType();
      case ClassesPackage.UML_ASSOCIATION_CLASS: return createUMLAssociationClass();
      case ClassesPackage.UML_CLASS: return createUMLClass();
      case ClassesPackage.UML_OPERATION: return createUMLOperation();
      case ClassesPackage.UML_INTERFACE: return createUMLInterface();
      case ClassesPackage.UML_PARAMETER: return createUMLParameter();
      case ClassesPackage.UML_ATTRIBUTE: return createUMLAttribute();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ClassesPackage.UML_AGGREGATION_KIND:
        return createUMLAggregationKindFromString(eDataType, initialValue);
      case ClassesPackage.UML_PARAMETER_KIND:
        return createUMLParameterKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ClassesPackage.UML_AGGREGATION_KIND:
        return convertUMLAggregationKindToString(eDataType, instanceValue);
      case ClassesPackage.UML_PARAMETER_KIND:
        return convertUMLParameterKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAssociation createUMLAssociation()
  {
    UMLAssociationImpl umlAssociation = new UMLAssociationImpl();
    return umlAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLGeneralization createUMLGeneralization()
  {
    UMLGeneralizationImpl umlGeneralization = new UMLGeneralizationImpl();
    return umlGeneralization;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTemplateBinding createUMLTemplateBinding()
  {
    UMLTemplateBindingImpl umlTemplateBinding = new UMLTemplateBindingImpl();
    return umlTemplateBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTemplateParameter createUMLTemplateParameter()
  {
    UMLTemplateParameterImpl umlTemplateParameter = new UMLTemplateParameterImpl();
    return umlTemplateParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAssociationEnd createUMLAssociationEnd()
  {
    UMLAssociationEndImpl umlAssociationEnd = new UMLAssociationEndImpl();
    return umlAssociationEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLEnumeration createUMLEnumeration()
  {
    UMLEnumerationImpl umlEnumeration = new UMLEnumerationImpl();
    return umlEnumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLLiteral createUMLLiteral()
  {
    UMLLiteralImpl umlLiteral = new UMLLiteralImpl();
    return umlLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLPrimitiveType createUMLPrimitiveType()
  {
    UMLPrimitiveTypeImpl umlPrimitiveType = new UMLPrimitiveTypeImpl();
    return umlPrimitiveType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAssociationClass createUMLAssociationClass()
  {
    UMLAssociationClassImpl umlAssociationClass = new UMLAssociationClassImpl();
    return umlAssociationClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLClass createUMLClass()
  {
    UMLClassImpl umlClass = new UMLClassImpl();
    return umlClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLOperation createUMLOperation()
  {
    UMLOperationImpl umlOperation = new UMLOperationImpl();
    return umlOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLInterface createUMLInterface()
  {
    UMLInterfaceImpl umlInterface = new UMLInterfaceImpl();
    return umlInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLParameter createUMLParameter()
  {
    UMLParameterImpl umlParameter = new UMLParameterImpl();
    return umlParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAttribute createUMLAttribute()
  {
    UMLAttributeImpl umlAttribute = new UMLAttributeImpl();
    return umlAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAggregationKind createUMLAggregationKindFromString(EDataType eDataType, String initialValue)
  {
    UMLAggregationKind result = UMLAggregationKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUMLAggregationKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLParameterKind createUMLParameterKindFromString(EDataType eDataType, String initialValue)
  {
    UMLParameterKind result = UMLParameterKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUMLParameterKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassesPackage getClassesPackage()
  {
    return (ClassesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ClassesPackage getPackage()
  {
    return ClassesPackage.eINSTANCE;
  }

} //ClassesFactoryImpl

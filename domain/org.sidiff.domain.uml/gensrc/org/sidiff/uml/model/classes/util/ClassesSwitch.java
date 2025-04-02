/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.sidiff.uml.model.classes.*;

import org.sidiff.uml.model.core.UMLElement;
import org.sidiff.uml.model.core.UMLNamedElement;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sidiff.uml.model.classes.ClassesPackage
 * @generated
 */
public class ClassesSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ClassesPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassesSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ClassesPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ClassesPackage.UML_ASSOCIATION:
      {
        UMLAssociation umlAssociation = (UMLAssociation)theEObject;
        T result = caseUMLAssociation(umlAssociation);
        if (result == null) result = caseUMLNamedElement(umlAssociation);
        if (result == null) result = caseUMLGeneralizableElement(umlAssociation);
        if (result == null) result = caseUMLStereotypeableElement(umlAssociation);
        if (result == null) result = caseUMLElement(umlAssociation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_CLASSIFIER:
      {
        UMLClassifier umlClassifier = (UMLClassifier)theEObject;
        T result = caseUMLClassifier(umlClassifier);
        if (result == null) result = caseUMLType(umlClassifier);
        if (result == null) result = caseUMLGeneralizableElement(umlClassifier);
        if (result == null) result = caseUMLBindingElement(umlClassifier);
        if (result == null) result = caseUMLStereotypeableElement(umlClassifier);
        if (result == null) result = caseUMLTemplateableElement(umlClassifier);
        if (result == null) result = caseUMLVisibleElement(umlClassifier);
        if (result == null) result = caseUMLNamedElement(umlClassifier);
        if (result == null) result = caseUMLElement(umlClassifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_TYPE:
      {
        UMLType umlType = (UMLType)theEObject;
        T result = caseUMLType(umlType);
        if (result == null) result = caseUMLNamedElement(umlType);
        if (result == null) result = caseUMLElement(umlType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_TYPED_ELEMENT:
      {
        UMLTypedElement umlTypedElement = (UMLTypedElement)theEObject;
        T result = caseUMLTypedElement(umlTypedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT:
      {
        UMLGeneralizableElement umlGeneralizableElement = (UMLGeneralizableElement)theEObject;
        T result = caseUMLGeneralizableElement(umlGeneralizableElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_GENERALIZATION:
      {
        UMLGeneralization umlGeneralization = (UMLGeneralization)theEObject;
        T result = caseUMLGeneralization(umlGeneralization);
        if (result == null) result = caseUMLElement(umlGeneralization);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_BINDING_ELEMENT:
      {
        UMLBindingElement umlBindingElement = (UMLBindingElement)theEObject;
        T result = caseUMLBindingElement(umlBindingElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_TEMPLATE_BINDING:
      {
        UMLTemplateBinding umlTemplateBinding = (UMLTemplateBinding)theEObject;
        T result = caseUMLTemplateBinding(umlTemplateBinding);
        if (result == null) result = caseUMLElement(umlTemplateBinding);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_TEMPLATE_PARAMETER:
      {
        UMLTemplateParameter umlTemplateParameter = (UMLTemplateParameter)theEObject;
        T result = caseUMLTemplateParameter(umlTemplateParameter);
        if (result == null) result = caseUMLElement(umlTemplateParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_TEMPLATEABLE_ELEMENT:
      {
        UMLTemplateableElement umlTemplateableElement = (UMLTemplateableElement)theEObject;
        T result = caseUMLTemplateableElement(umlTemplateableElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_ASSOCIATION_END:
      {
        UMLAssociationEnd umlAssociationEnd = (UMLAssociationEnd)theEObject;
        T result = caseUMLAssociationEnd(umlAssociationEnd);
        if (result == null) result = caseUMLNamedElement(umlAssociationEnd);
        if (result == null) result = caseUMLStereotypeableElement(umlAssociationEnd);
        if (result == null) result = caseUMLElement(umlAssociationEnd);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_ENUMERATION:
      {
        UMLEnumeration umlEnumeration = (UMLEnumeration)theEObject;
        T result = caseUMLEnumeration(umlEnumeration);
        if (result == null) result = caseUMLType(umlEnumeration);
        if (result == null) result = caseUMLVisibleElement(umlEnumeration);
        if (result == null) result = caseUMLNamedElement(umlEnumeration);
        if (result == null) result = caseUMLElement(umlEnumeration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_LITERAL:
      {
        UMLLiteral umlLiteral = (UMLLiteral)theEObject;
        T result = caseUMLLiteral(umlLiteral);
        if (result == null) result = caseUMLNamedElement(umlLiteral);
        if (result == null) result = caseUMLElement(umlLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_PRIMITIVE_TYPE:
      {
        UMLPrimitiveType umlPrimitiveType = (UMLPrimitiveType)theEObject;
        T result = caseUMLPrimitiveType(umlPrimitiveType);
        if (result == null) result = caseUMLType(umlPrimitiveType);
        if (result == null) result = caseUMLNamedElement(umlPrimitiveType);
        if (result == null) result = caseUMLElement(umlPrimitiveType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_ASSOCIATION_CLASS:
      {
        UMLAssociationClass umlAssociationClass = (UMLAssociationClass)theEObject;
        T result = caseUMLAssociationClass(umlAssociationClass);
        if (result == null) result = caseUMLAssociation(umlAssociationClass);
        if (result == null) result = caseUMLNamedElement(umlAssociationClass);
        if (result == null) result = caseUMLGeneralizableElement(umlAssociationClass);
        if (result == null) result = caseUMLStereotypeableElement(umlAssociationClass);
        if (result == null) result = caseUMLElement(umlAssociationClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_CLASS:
      {
        UMLClass umlClass = (UMLClass)theEObject;
        T result = caseUMLClass(umlClass);
        if (result == null) result = caseUMLClassifier(umlClass);
        if (result == null) result = caseUMLType(umlClass);
        if (result == null) result = caseUMLGeneralizableElement(umlClass);
        if (result == null) result = caseUMLBindingElement(umlClass);
        if (result == null) result = caseUMLStereotypeableElement(umlClass);
        if (result == null) result = caseUMLTemplateableElement(umlClass);
        if (result == null) result = caseUMLVisibleElement(umlClass);
        if (result == null) result = caseUMLNamedElement(umlClass);
        if (result == null) result = caseUMLElement(umlClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_OPERATION:
      {
        UMLOperation umlOperation = (UMLOperation)theEObject;
        T result = caseUMLOperation(umlOperation);
        if (result == null) result = caseUMLNamedElement(umlOperation);
        if (result == null) result = caseUMLStereotypeableElement(umlOperation);
        if (result == null) result = caseUMLTypedElement(umlOperation);
        if (result == null) result = caseUMLVisibleElement(umlOperation);
        if (result == null) result = caseUMLElement(umlOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_INTERFACE:
      {
        UMLInterface umlInterface = (UMLInterface)theEObject;
        T result = caseUMLInterface(umlInterface);
        if (result == null) result = caseUMLClassifier(umlInterface);
        if (result == null) result = caseUMLType(umlInterface);
        if (result == null) result = caseUMLGeneralizableElement(umlInterface);
        if (result == null) result = caseUMLBindingElement(umlInterface);
        if (result == null) result = caseUMLStereotypeableElement(umlInterface);
        if (result == null) result = caseUMLTemplateableElement(umlInterface);
        if (result == null) result = caseUMLVisibleElement(umlInterface);
        if (result == null) result = caseUMLNamedElement(umlInterface);
        if (result == null) result = caseUMLElement(umlInterface);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_PARAMETER:
      {
        UMLParameter umlParameter = (UMLParameter)theEObject;
        T result = caseUMLParameter(umlParameter);
        if (result == null) result = caseUMLNamedElement(umlParameter);
        if (result == null) result = caseUMLStereotypeableElement(umlParameter);
        if (result == null) result = caseUMLTypedElement(umlParameter);
        if (result == null) result = caseUMLElement(umlParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ClassesPackage.UML_ATTRIBUTE:
      {
        UMLAttribute umlAttribute = (UMLAttribute)theEObject;
        T result = caseUMLAttribute(umlAttribute);
        if (result == null) result = caseUMLNamedElement(umlAttribute);
        if (result == null) result = caseUMLStereotypeableElement(umlAttribute);
        if (result == null) result = caseUMLTypedElement(umlAttribute);
        if (result == null) result = caseUMLVisibleElement(umlAttribute);
        if (result == null) result = caseUMLElement(umlAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Association</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLAssociation(UMLAssociation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Classifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Classifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLClassifier(UMLClassifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLType(UMLType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Typed Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Typed Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLTypedElement(UMLTypedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Generalizable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Generalizable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLGeneralizableElement(UMLGeneralizableElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Generalization</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Generalization</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLGeneralization(UMLGeneralization object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Binding Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Binding Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLBindingElement(UMLBindingElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Template Binding</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Template Binding</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLTemplateBinding(UMLTemplateBinding object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Template Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Template Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLTemplateParameter(UMLTemplateParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Templateable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Templateable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLTemplateableElement(UMLTemplateableElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Association End</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Association End</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLAssociationEnd(UMLAssociationEnd object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Enumeration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Enumeration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLEnumeration(UMLEnumeration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLLiteral(UMLLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Primitive Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Primitive Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLPrimitiveType(UMLPrimitiveType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Association Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Association Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLAssociationClass(UMLAssociationClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLClass(UMLClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLOperation(UMLOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Interface</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Interface</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLInterface(UMLInterface object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLParameter(UMLParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLAttribute(UMLAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLElement(UMLElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLNamedElement(UMLNamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Stereotypeable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Stereotypeable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLStereotypeableElement(UMLStereotypeableElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Visible Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Visible Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLVisibleElement(UMLVisibleElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ClassesSwitch

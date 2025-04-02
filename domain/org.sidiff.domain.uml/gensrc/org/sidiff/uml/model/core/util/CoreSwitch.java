/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.sidiff.uml.model.core.*;

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
 * @see org.sidiff.uml.model.core.CorePackage
 * @generated
 */
public class CoreSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CorePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoreSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = CorePackage.eINSTANCE;
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
      case CorePackage.UML_VISIBLE_ELEMENT:
      {
        UMLVisibleElement umlVisibleElement = (UMLVisibleElement)theEObject;
        T result = caseUMLVisibleElement(umlVisibleElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CorePackage.UML_PACKAGE:
      {
        UMLPackage umlPackage = (UMLPackage)theEObject;
        T result = caseUMLPackage(umlPackage);
        if (result == null) result = caseUMLNamedElement(umlPackage);
        if (result == null) result = caseUMLStereotypeableElement(umlPackage);
        if (result == null) result = caseUMLVisibleElement(umlPackage);
        if (result == null) result = caseUMLElement(umlPackage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CorePackage.UML_STEREOTYPEABLE_ELEMENT:
      {
        UMLStereotypeableElement umlStereotypeableElement = (UMLStereotypeableElement)theEObject;
        T result = caseUMLStereotypeableElement(umlStereotypeableElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CorePackage.UML_STEREOTYPE:
      {
        UMLStereotype umlStereotype = (UMLStereotype)theEObject;
        T result = caseUMLStereotype(umlStereotype);
        if (result == null) result = caseUMLNamedElement(umlStereotype);
        if (result == null) result = caseUMLElement(umlStereotype);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CorePackage.UML_MODEL:
      {
        UMLModel umlModel = (UMLModel)theEObject;
        T result = caseUMLModel(umlModel);
        if (result == null) result = caseUMLNamedElement(umlModel);
        if (result == null) result = caseUMLElement(umlModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CorePackage.UML_ELEMENT:
      {
        UMLElement umlElement = (UMLElement)theEObject;
        T result = caseUMLElement(umlElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CorePackage.UML_COMMENT:
      {
        UMLComment umlComment = (UMLComment)theEObject;
        T result = caseUMLComment(umlComment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CorePackage.UML_DEPENDENCY:
      {
        UMLDependency umlDependency = (UMLDependency)theEObject;
        T result = caseUMLDependency(umlDependency);
        if (result == null) result = caseUMLNamedElement(umlDependency);
        if (result == null) result = caseUMLStereotypeableElement(umlDependency);
        if (result == null) result = caseUMLElement(umlDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CorePackage.UML_NAMED_ELEMENT:
      {
        UMLNamedElement umlNamedElement = (UMLNamedElement)theEObject;
        T result = caseUMLNamedElement(umlNamedElement);
        if (result == null) result = caseUMLElement(umlNamedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>UML Package</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Package</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLPackage(UMLPackage object)
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
   * Returns the result of interpreting the object as an instance of '<em>UML Stereotype</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Stereotype</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLStereotype(UMLStereotype object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLModel(UMLModel object)
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
   * Returns the result of interpreting the object as an instance of '<em>UML Comment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Comment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLComment(UMLComment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>UML Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UML Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUMLDependency(UMLDependency object)
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

} //CoreSwitch

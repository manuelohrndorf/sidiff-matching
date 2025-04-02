/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.uml.model.classes.*;

import org.sidiff.uml.model.core.UMLElement;
import org.sidiff.uml.model.core.UMLNamedElement;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.uml.model.classes.ClassesPackage
 * @generated
 */
public class ClassesAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ClassesPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassesAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ClassesPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassesSwitch<Adapter> modelSwitch =
    new ClassesSwitch<Adapter>()
    {
      @Override
      public Adapter caseUMLAssociation(UMLAssociation object)
      {
        return createUMLAssociationAdapter();
      }
      @Override
      public Adapter caseUMLClassifier(UMLClassifier object)
      {
        return createUMLClassifierAdapter();
      }
      @Override
      public Adapter caseUMLType(UMLType object)
      {
        return createUMLTypeAdapter();
      }
      @Override
      public Adapter caseUMLTypedElement(UMLTypedElement object)
      {
        return createUMLTypedElementAdapter();
      }
      @Override
      public Adapter caseUMLGeneralizableElement(UMLGeneralizableElement object)
      {
        return createUMLGeneralizableElementAdapter();
      }
      @Override
      public Adapter caseUMLGeneralization(UMLGeneralization object)
      {
        return createUMLGeneralizationAdapter();
      }
      @Override
      public Adapter caseUMLBindingElement(UMLBindingElement object)
      {
        return createUMLBindingElementAdapter();
      }
      @Override
      public Adapter caseUMLTemplateBinding(UMLTemplateBinding object)
      {
        return createUMLTemplateBindingAdapter();
      }
      @Override
      public Adapter caseUMLTemplateParameter(UMLTemplateParameter object)
      {
        return createUMLTemplateParameterAdapter();
      }
      @Override
      public Adapter caseUMLTemplateableElement(UMLTemplateableElement object)
      {
        return createUMLTemplateableElementAdapter();
      }
      @Override
      public Adapter caseUMLAssociationEnd(UMLAssociationEnd object)
      {
        return createUMLAssociationEndAdapter();
      }
      @Override
      public Adapter caseUMLEnumeration(UMLEnumeration object)
      {
        return createUMLEnumerationAdapter();
      }
      @Override
      public Adapter caseUMLLiteral(UMLLiteral object)
      {
        return createUMLLiteralAdapter();
      }
      @Override
      public Adapter caseUMLPrimitiveType(UMLPrimitiveType object)
      {
        return createUMLPrimitiveTypeAdapter();
      }
      @Override
      public Adapter caseUMLAssociationClass(UMLAssociationClass object)
      {
        return createUMLAssociationClassAdapter();
      }
      @Override
      public Adapter caseUMLClass(UMLClass object)
      {
        return createUMLClassAdapter();
      }
      @Override
      public Adapter caseUMLOperation(UMLOperation object)
      {
        return createUMLOperationAdapter();
      }
      @Override
      public Adapter caseUMLInterface(UMLInterface object)
      {
        return createUMLInterfaceAdapter();
      }
      @Override
      public Adapter caseUMLParameter(UMLParameter object)
      {
        return createUMLParameterAdapter();
      }
      @Override
      public Adapter caseUMLAttribute(UMLAttribute object)
      {
        return createUMLAttributeAdapter();
      }
      @Override
      public Adapter caseUMLElement(UMLElement object)
      {
        return createUMLElementAdapter();
      }
      @Override
      public Adapter caseUMLNamedElement(UMLNamedElement object)
      {
        return createUMLNamedElementAdapter();
      }
      @Override
      public Adapter caseUMLStereotypeableElement(UMLStereotypeableElement object)
      {
        return createUMLStereotypeableElementAdapter();
      }
      @Override
      public Adapter caseUMLVisibleElement(UMLVisibleElement object)
      {
        return createUMLVisibleElementAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLAssociation <em>UML Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLAssociation
   * @generated
   */
  public Adapter createUMLAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLClassifier <em>UML Classifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLClassifier
   * @generated
   */
  public Adapter createUMLClassifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLType <em>UML Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLType
   * @generated
   */
  public Adapter createUMLTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLTypedElement <em>UML Typed Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLTypedElement
   * @generated
   */
  public Adapter createUMLTypedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLGeneralizableElement <em>UML Generalizable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLGeneralizableElement
   * @generated
   */
  public Adapter createUMLGeneralizableElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLGeneralization <em>UML Generalization</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLGeneralization
   * @generated
   */
  public Adapter createUMLGeneralizationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLBindingElement <em>UML Binding Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLBindingElement
   * @generated
   */
  public Adapter createUMLBindingElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLTemplateBinding <em>UML Template Binding</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLTemplateBinding
   * @generated
   */
  public Adapter createUMLTemplateBindingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLTemplateParameter <em>UML Template Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLTemplateParameter
   * @generated
   */
  public Adapter createUMLTemplateParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLTemplateableElement <em>UML Templateable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLTemplateableElement
   * @generated
   */
  public Adapter createUMLTemplateableElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLAssociationEnd <em>UML Association End</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd
   * @generated
   */
  public Adapter createUMLAssociationEndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLEnumeration <em>UML Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLEnumeration
   * @generated
   */
  public Adapter createUMLEnumerationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLLiteral <em>UML Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLLiteral
   * @generated
   */
  public Adapter createUMLLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLPrimitiveType <em>UML Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLPrimitiveType
   * @generated
   */
  public Adapter createUMLPrimitiveTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLAssociationClass <em>UML Association Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLAssociationClass
   * @generated
   */
  public Adapter createUMLAssociationClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLClass <em>UML Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLClass
   * @generated
   */
  public Adapter createUMLClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLOperation <em>UML Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLOperation
   * @generated
   */
  public Adapter createUMLOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLInterface <em>UML Interface</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLInterface
   * @generated
   */
  public Adapter createUMLInterfaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLParameter <em>UML Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLParameter
   * @generated
   */
  public Adapter createUMLParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.classes.UMLAttribute <em>UML Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.classes.UMLAttribute
   * @generated
   */
  public Adapter createUMLAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLElement <em>UML Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLElement
   * @generated
   */
  public Adapter createUMLElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLNamedElement <em>UML Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLNamedElement
   * @generated
   */
  public Adapter createUMLNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLStereotypeableElement <em>UML Stereotypeable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLStereotypeableElement
   * @generated
   */
  public Adapter createUMLStereotypeableElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLVisibleElement <em>UML Visible Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLVisibleElement
   * @generated
   */
  public Adapter createUMLVisibleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ClassesAdapterFactory

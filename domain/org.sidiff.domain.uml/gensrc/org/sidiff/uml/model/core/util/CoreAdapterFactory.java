/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.uml.model.core.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.uml.model.core.CorePackage
 * @generated
 */
public class CoreAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CorePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoreAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = CorePackage.eINSTANCE;
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
  protected CoreSwitch<Adapter> modelSwitch =
    new CoreSwitch<Adapter>()
    {
      @Override
      public Adapter caseUMLVisibleElement(UMLVisibleElement object)
      {
        return createUMLVisibleElementAdapter();
      }
      @Override
      public Adapter caseUMLPackage(UMLPackage object)
      {
        return createUMLPackageAdapter();
      }
      @Override
      public Adapter caseUMLStereotypeableElement(UMLStereotypeableElement object)
      {
        return createUMLStereotypeableElementAdapter();
      }
      @Override
      public Adapter caseUMLStereotype(UMLStereotype object)
      {
        return createUMLStereotypeAdapter();
      }
      @Override
      public Adapter caseUMLModel(UMLModel object)
      {
        return createUMLModelAdapter();
      }
      @Override
      public Adapter caseUMLElement(UMLElement object)
      {
        return createUMLElementAdapter();
      }
      @Override
      public Adapter caseUMLComment(UMLComment object)
      {
        return createUMLCommentAdapter();
      }
      @Override
      public Adapter caseUMLDependency(UMLDependency object)
      {
        return createUMLDependencyAdapter();
      }
      @Override
      public Adapter caseUMLNamedElement(UMLNamedElement object)
      {
        return createUMLNamedElementAdapter();
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
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLPackage <em>UML Package</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLPackage
   * @generated
   */
  public Adapter createUMLPackageAdapter()
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
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLStereotype <em>UML Stereotype</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLStereotype
   * @generated
   */
  public Adapter createUMLStereotypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLModel <em>UML Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLModel
   * @generated
   */
  public Adapter createUMLModelAdapter()
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
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLComment <em>UML Comment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLComment
   * @generated
   */
  public Adapter createUMLCommentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.sidiff.uml.model.core.UMLDependency <em>UML Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.sidiff.uml.model.core.UMLDependency
   * @generated
   */
  public Adapter createUMLDependencyAdapter()
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

} //CoreAdapterFactory

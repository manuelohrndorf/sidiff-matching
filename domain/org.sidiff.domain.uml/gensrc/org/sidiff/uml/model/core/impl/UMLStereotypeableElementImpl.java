/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Stereotypeable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLStereotypeableElementImpl#getStereotypes <em>Stereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLStereotypeableElementImpl extends EObjectImpl implements UMLStereotypeableElement
{
  /**
   * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotypes()
   * @generated
   * @ordered
   */
  protected EList<UMLStereotype> stereotypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLStereotypeableElementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return CorePackage.Literals.UML_STEREOTYPEABLE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLStereotype> getStereotypes()
  {
    if (stereotypes == null)
    {
      stereotypes = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotype>(UMLStereotype.class, this, CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS);
    }
    return stereotypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES:
        return getStereotypes();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES:
        getStereotypes().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLStereotypeableElementImpl

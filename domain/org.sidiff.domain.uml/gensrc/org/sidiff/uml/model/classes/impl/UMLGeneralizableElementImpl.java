/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.classes.ClassesPackage;
import org.sidiff.uml.model.classes.UMLGeneralizableElement;
import org.sidiff.uml.model.classes.UMLGeneralization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Generalizable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLGeneralizableElementImpl#getSpecializations <em>Specializations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLGeneralizableElementImpl#getGeneralizations <em>Generalizations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UMLGeneralizableElementImpl extends EObjectImpl implements UMLGeneralizableElement
{
  /**
   * The cached value of the '{@link #getSpecializations() <em>Specializations</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecializations()
   * @generated
   * @ordered
   */
  protected EList<UMLGeneralization> specializations;

  /**
   * The cached value of the '{@link #getGeneralizations() <em>Generalizations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGeneralizations()
   * @generated
   * @ordered
   */
  protected EList<UMLGeneralization> generalizations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLGeneralizableElementImpl()
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
    return ClassesPackage.Literals.UML_GENERALIZABLE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLGeneralization> getSpecializations()
  {
    if (specializations == null)
    {
      specializations = new EObjectWithInverseResolvingEList<UMLGeneralization>(UMLGeneralization.class, this, ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS, ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT);
    }
    return specializations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLGeneralization> getGeneralizations()
  {
    if (generalizations == null)
    {
      generalizations = new EObjectContainmentWithInverseEList<UMLGeneralization>(UMLGeneralization.class, this, ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS, ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT);
    }
    return generalizations;
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
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializations()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralizations()).basicAdd(otherEnd, msgs);
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
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS:
        return ((InternalEList<?>)getSpecializations()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS:
        return ((InternalEList<?>)getGeneralizations()).basicRemove(otherEnd, msgs);
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
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS:
        return getSpecializations();
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS:
        return getGeneralizations();
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
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS:
        getSpecializations().clear();
        getSpecializations().addAll((Collection<? extends UMLGeneralization>)newValue);
        return;
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS:
        getGeneralizations().clear();
        getGeneralizations().addAll((Collection<? extends UMLGeneralization>)newValue);
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
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS:
        getSpecializations().clear();
        return;
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS:
        getGeneralizations().clear();
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
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS:
        return specializations != null && !specializations.isEmpty();
      case ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS:
        return generalizations != null && !generalizations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLGeneralizableElementImpl

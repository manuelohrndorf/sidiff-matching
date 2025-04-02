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
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.classes.ClassesPackage;
import org.sidiff.uml.model.classes.UMLBindingElement;
import org.sidiff.uml.model.classes.UMLTemplateBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Binding Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLBindingElementImpl#getTemplateBindings <em>Template Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UMLBindingElementImpl extends EObjectImpl implements UMLBindingElement
{
  /**
   * The cached value of the '{@link #getTemplateBindings() <em>Template Bindings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateBindings()
   * @generated
   * @ordered
   */
  protected EList<UMLTemplateBinding> templateBindings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLBindingElementImpl()
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
    return ClassesPackage.Literals.UML_BINDING_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLTemplateBinding> getTemplateBindings()
  {
    if (templateBindings == null)
    {
      templateBindings = new EObjectContainmentWithInverseEList<UMLTemplateBinding>(UMLTemplateBinding.class, this, ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS, ClassesPackage.UML_TEMPLATE_BINDING__BINDER);
    }
    return templateBindings;
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
      case ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateBindings()).basicAdd(otherEnd, msgs);
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
      case ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS:
        return ((InternalEList<?>)getTemplateBindings()).basicRemove(otherEnd, msgs);
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
      case ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS:
        return getTemplateBindings();
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
      case ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS:
        getTemplateBindings().clear();
        getTemplateBindings().addAll((Collection<? extends UMLTemplateBinding>)newValue);
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
      case ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS:
        getTemplateBindings().clear();
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
      case ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS:
        return templateBindings != null && !templateBindings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLBindingElementImpl

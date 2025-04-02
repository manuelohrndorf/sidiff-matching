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
import org.sidiff.uml.model.classes.UMLTemplateParameter;
import org.sidiff.uml.model.classes.UMLTemplateableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Templateable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLTemplateableElementImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UMLTemplateableElementImpl extends EObjectImpl implements UMLTemplateableElement
{
  /**
   * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateParameters()
   * @generated
   * @ordered
   */
  protected EList<UMLTemplateParameter> templateParameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLTemplateableElementImpl()
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
    return ClassesPackage.Literals.UML_TEMPLATEABLE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLTemplateParameter> getTemplateParameters()
  {
    if (templateParameters == null)
    {
      templateParameters = new EObjectContainmentWithInverseEList<UMLTemplateParameter>(UMLTemplateParameter.class, this, ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS, ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT);
    }
    return templateParameters;
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
      case ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateParameters()).basicAdd(otherEnd, msgs);
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
      case ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS:
        return ((InternalEList<?>)getTemplateParameters()).basicRemove(otherEnd, msgs);
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
      case ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS:
        return getTemplateParameters();
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
      case ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS:
        getTemplateParameters().clear();
        getTemplateParameters().addAll((Collection<? extends UMLTemplateParameter>)newValue);
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
      case ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS:
        getTemplateParameters().clear();
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
      case ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS:
        return templateParameters != null && !templateParameters.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLTemplateableElementImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.sidiff.uml.model.classes.ClassesPackage;
import org.sidiff.uml.model.classes.UMLBindingElement;
import org.sidiff.uml.model.classes.UMLTemplateBinding;
import org.sidiff.uml.model.classes.UMLTemplateParameter;

import org.sidiff.uml.model.core.impl.UMLElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Template Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl#getFormalParam <em>Formal Param</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl#getActualParam <em>Actual Param</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl#getBinder <em>Binder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLTemplateBindingImpl extends UMLElementImpl implements UMLTemplateBinding
{
  /**
   * The cached value of the '{@link #getFormalParam() <em>Formal Param</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormalParam()
   * @generated
   * @ordered
   */
  protected UMLTemplateParameter formalParam;

  /**
   * The default value of the '{@link #getActualParam() <em>Actual Param</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActualParam()
   * @generated
   * @ordered
   */
  protected static final String ACTUAL_PARAM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getActualParam() <em>Actual Param</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActualParam()
   * @generated
   * @ordered
   */
  protected String actualParam = ACTUAL_PARAM_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLTemplateBindingImpl()
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
    return ClassesPackage.Literals.UML_TEMPLATE_BINDING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTemplateParameter getFormalParam()
  {
    if (formalParam != null && formalParam.eIsProxy())
    {
      InternalEObject oldFormalParam = (InternalEObject)formalParam;
      formalParam = (UMLTemplateParameter)eResolveProxy(oldFormalParam);
      if (formalParam != oldFormalParam)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM, oldFormalParam, formalParam));
      }
    }
    return formalParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTemplateParameter basicGetFormalParam()
  {
    return formalParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFormalParam(UMLTemplateParameter newFormalParam, NotificationChain msgs)
  {
    UMLTemplateParameter oldFormalParam = formalParam;
    formalParam = newFormalParam;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM, oldFormalParam, newFormalParam);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFormalParam(UMLTemplateParameter newFormalParam)
  {
    if (newFormalParam != formalParam)
    {
      NotificationChain msgs = null;
      if (formalParam != null)
        msgs = ((InternalEObject)formalParam).eInverseRemove(this, ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS, UMLTemplateParameter.class, msgs);
      if (newFormalParam != null)
        msgs = ((InternalEObject)newFormalParam).eInverseAdd(this, ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS, UMLTemplateParameter.class, msgs);
      msgs = basicSetFormalParam(newFormalParam, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM, newFormalParam, newFormalParam));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getActualParam()
  {
    return actualParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActualParam(String newActualParam)
  {
    String oldActualParam = actualParam;
    actualParam = newActualParam;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_TEMPLATE_BINDING__ACTUAL_PARAM, oldActualParam, actualParam));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLBindingElement getBinder()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_TEMPLATE_BINDING__BINDER) return null;
    return (UMLBindingElement)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBinder(UMLBindingElement newBinder, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newBinder, ClassesPackage.UML_TEMPLATE_BINDING__BINDER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBinder(UMLBindingElement newBinder)
  {
    if (newBinder != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_TEMPLATE_BINDING__BINDER && newBinder != null))
    {
      if (EcoreUtil.isAncestor(this, newBinder))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newBinder != null)
        msgs = ((InternalEObject)newBinder).eInverseAdd(this, ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS, UMLBindingElement.class, msgs);
      msgs = basicSetBinder(newBinder, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_TEMPLATE_BINDING__BINDER, newBinder, newBinder));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM:
        if (formalParam != null)
          msgs = ((InternalEObject)formalParam).eInverseRemove(this, ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS, UMLTemplateParameter.class, msgs);
        return basicSetFormalParam((UMLTemplateParameter)otherEnd, msgs);
      case ClassesPackage.UML_TEMPLATE_BINDING__BINDER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetBinder((UMLBindingElement)otherEnd, msgs);
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
      case ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM:
        return basicSetFormalParam(null, msgs);
      case ClassesPackage.UML_TEMPLATE_BINDING__BINDER:
        return basicSetBinder(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case ClassesPackage.UML_TEMPLATE_BINDING__BINDER:
        return eInternalContainer().eInverseRemove(this, ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS, UMLBindingElement.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM:
        if (resolve) return getFormalParam();
        return basicGetFormalParam();
      case ClassesPackage.UML_TEMPLATE_BINDING__ACTUAL_PARAM:
        return getActualParam();
      case ClassesPackage.UML_TEMPLATE_BINDING__BINDER:
        return getBinder();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM:
        setFormalParam((UMLTemplateParameter)newValue);
        return;
      case ClassesPackage.UML_TEMPLATE_BINDING__ACTUAL_PARAM:
        setActualParam((String)newValue);
        return;
      case ClassesPackage.UML_TEMPLATE_BINDING__BINDER:
        setBinder((UMLBindingElement)newValue);
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
      case ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM:
        setFormalParam((UMLTemplateParameter)null);
        return;
      case ClassesPackage.UML_TEMPLATE_BINDING__ACTUAL_PARAM:
        setActualParam(ACTUAL_PARAM_EDEFAULT);
        return;
      case ClassesPackage.UML_TEMPLATE_BINDING__BINDER:
        setBinder((UMLBindingElement)null);
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
      case ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM:
        return formalParam != null;
      case ClassesPackage.UML_TEMPLATE_BINDING__ACTUAL_PARAM:
        return ACTUAL_PARAM_EDEFAULT == null ? actualParam != null : !ACTUAL_PARAM_EDEFAULT.equals(actualParam);
      case ClassesPackage.UML_TEMPLATE_BINDING__BINDER:
        return getBinder() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (actualParam: ");
    result.append(actualParam);
    result.append(')');
    return result.toString();
  }

} //UMLTemplateBindingImpl

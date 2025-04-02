/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.classes.ClassesPackage;
import org.sidiff.uml.model.classes.UMLTemplateBinding;
import org.sidiff.uml.model.classes.UMLTemplateParameter;
import org.sidiff.uml.model.classes.UMLTemplateableElement;

import org.sidiff.uml.model.core.impl.UMLElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl#getTemplateableElement <em>Templateable Element</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLTemplateParameterImpl extends UMLElementImpl implements UMLTemplateParameter
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getBindings() <em>Bindings</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBindings()
   * @generated
   * @ordered
   */
  protected EList<UMLTemplateBinding> bindings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLTemplateParameterImpl()
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
    return ClassesPackage.Literals.UML_TEMPLATE_PARAMETER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLTemplateableElement getTemplateableElement()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT) return null;
    return (UMLTemplateableElement)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTemplateableElement(UMLTemplateableElement newTemplateableElement, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newTemplateableElement, ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemplateableElement(UMLTemplateableElement newTemplateableElement)
  {
    if (newTemplateableElement != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT && newTemplateableElement != null))
    {
      if (EcoreUtil.isAncestor(this, newTemplateableElement))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newTemplateableElement != null)
        msgs = ((InternalEObject)newTemplateableElement).eInverseAdd(this, ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS, UMLTemplateableElement.class, msgs);
      msgs = basicSetTemplateableElement(newTemplateableElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT, newTemplateableElement, newTemplateableElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_TEMPLATE_PARAMETER__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLTemplateBinding> getBindings()
  {
    if (bindings == null)
    {
      bindings = new EObjectWithInverseResolvingEList<UMLTemplateBinding>(UMLTemplateBinding.class, this, ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS, ClassesPackage.UML_TEMPLATE_BINDING__FORMAL_PARAM);
    }
    return bindings;
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
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetTemplateableElement((UMLTemplateableElement)otherEnd, msgs);
      case ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getBindings()).basicAdd(otherEnd, msgs);
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
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT:
        return basicSetTemplateableElement(null, msgs);
      case ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS:
        return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
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
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT:
        return eInternalContainer().eInverseRemove(this, ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS, UMLTemplateableElement.class, msgs);
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
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT:
        return getTemplateableElement();
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TYPE:
        return getType();
      case ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS:
        return getBindings();
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
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT:
        setTemplateableElement((UMLTemplateableElement)newValue);
        return;
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TYPE:
        setType((String)newValue);
        return;
      case ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS:
        getBindings().clear();
        getBindings().addAll((Collection<? extends UMLTemplateBinding>)newValue);
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
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT:
        setTemplateableElement((UMLTemplateableElement)null);
        return;
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS:
        getBindings().clear();
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
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT:
        return getTemplateableElement() != null;
      case ClassesPackage.UML_TEMPLATE_PARAMETER__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case ClassesPackage.UML_TEMPLATE_PARAMETER__BINDINGS:
        return bindings != null && !bindings.isEmpty();
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
    result.append(" (type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //UMLTemplateParameterImpl

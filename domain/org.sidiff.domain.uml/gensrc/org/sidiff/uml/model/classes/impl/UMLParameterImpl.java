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
import org.sidiff.uml.model.classes.UMLOperation;
import org.sidiff.uml.model.classes.UMLParameter;
import org.sidiff.uml.model.classes.UMLParameterKind;
import org.sidiff.uml.model.classes.UMLType;
import org.sidiff.uml.model.classes.UMLTypedElement;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;

import org.sidiff.uml.model.core.impl.UMLNamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLParameterImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLParameterImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLParameterImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLParameterImpl extends UMLNamedElementImpl implements UMLParameter
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
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected UMLType type;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final UMLParameterKind KIND_EDEFAULT = UMLParameterKind.IN;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected UMLParameterKind kind = KIND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLParameterImpl()
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
    return ClassesPackage.Literals.UML_PARAMETER;
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
      stereotypes = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotype>(UMLStereotype.class, this, ClassesPackage.UML_PARAMETER__STEREOTYPES, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS);
    }
    return stereotypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLType getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (UMLType)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.UML_PARAMETER__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLType basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(UMLType newType, NotificationChain msgs)
  {
    UMLType oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_PARAMETER__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(UMLType newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, ClassesPackage.UML_TYPE__USED_BY_ELEMENTS, UMLType.class, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, ClassesPackage.UML_TYPE__USED_BY_ELEMENTS, UMLType.class, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_PARAMETER__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLParameterKind getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(UMLParameterKind newKind)
  {
    UMLParameterKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_PARAMETER__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLOperation getOperation()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_PARAMETER__OPERATION) return null;
    return (UMLOperation)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperation(UMLOperation newOperation, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newOperation, ClassesPackage.UML_PARAMETER__OPERATION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperation(UMLOperation newOperation)
  {
    if (newOperation != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_PARAMETER__OPERATION && newOperation != null))
    {
      if (EcoreUtil.isAncestor(this, newOperation))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOperation != null)
        msgs = ((InternalEObject)newOperation).eInverseAdd(this, ClassesPackage.UML_OPERATION__PARAMETERS, UMLOperation.class, msgs);
      msgs = basicSetOperation(newOperation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_PARAMETER__OPERATION, newOperation, newOperation));
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
      case ClassesPackage.UML_PARAMETER__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_PARAMETER__TYPE:
        if (type != null)
          msgs = ((InternalEObject)type).eInverseRemove(this, ClassesPackage.UML_TYPE__USED_BY_ELEMENTS, UMLType.class, msgs);
        return basicSetType((UMLType)otherEnd, msgs);
      case ClassesPackage.UML_PARAMETER__OPERATION:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOperation((UMLOperation)otherEnd, msgs);
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
      case ClassesPackage.UML_PARAMETER__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_PARAMETER__TYPE:
        return basicSetType(null, msgs);
      case ClassesPackage.UML_PARAMETER__OPERATION:
        return basicSetOperation(null, msgs);
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
      case ClassesPackage.UML_PARAMETER__OPERATION:
        return eInternalContainer().eInverseRemove(this, ClassesPackage.UML_OPERATION__PARAMETERS, UMLOperation.class, msgs);
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
      case ClassesPackage.UML_PARAMETER__STEREOTYPES:
        return getStereotypes();
      case ClassesPackage.UML_PARAMETER__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case ClassesPackage.UML_PARAMETER__KIND:
        return getKind();
      case ClassesPackage.UML_PARAMETER__OPERATION:
        return getOperation();
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
      case ClassesPackage.UML_PARAMETER__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
        return;
      case ClassesPackage.UML_PARAMETER__TYPE:
        setType((UMLType)newValue);
        return;
      case ClassesPackage.UML_PARAMETER__KIND:
        setKind((UMLParameterKind)newValue);
        return;
      case ClassesPackage.UML_PARAMETER__OPERATION:
        setOperation((UMLOperation)newValue);
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
      case ClassesPackage.UML_PARAMETER__STEREOTYPES:
        getStereotypes().clear();
        return;
      case ClassesPackage.UML_PARAMETER__TYPE:
        setType((UMLType)null);
        return;
      case ClassesPackage.UML_PARAMETER__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case ClassesPackage.UML_PARAMETER__OPERATION:
        setOperation((UMLOperation)null);
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
      case ClassesPackage.UML_PARAMETER__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
      case ClassesPackage.UML_PARAMETER__TYPE:
        return type != null;
      case ClassesPackage.UML_PARAMETER__KIND:
        return kind != KIND_EDEFAULT;
      case ClassesPackage.UML_PARAMETER__OPERATION:
        return getOperation() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == UMLStereotypeableElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_PARAMETER__STEREOTYPES: return CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES;
        default: return -1;
      }
    }
    if (baseClass == UMLTypedElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_PARAMETER__TYPE: return ClassesPackage.UML_TYPED_ELEMENT__TYPE;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == UMLStereotypeableElement.class)
    {
      switch (baseFeatureID)
      {
        case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES: return ClassesPackage.UML_PARAMETER__STEREOTYPES;
        default: return -1;
      }
    }
    if (baseClass == UMLTypedElement.class)
    {
      switch (baseFeatureID)
      {
        case ClassesPackage.UML_TYPED_ELEMENT__TYPE: return ClassesPackage.UML_PARAMETER__TYPE;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} //UMLParameterImpl

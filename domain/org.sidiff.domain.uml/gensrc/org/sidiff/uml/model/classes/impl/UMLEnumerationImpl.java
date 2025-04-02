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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.classes.ClassesPackage;
import org.sidiff.uml.model.classes.UMLEnumeration;
import org.sidiff.uml.model.classes.UMLLiteral;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLPackage;
import org.sidiff.uml.model.core.UMLVisibility;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLEnumerationImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLEnumerationImpl#getLiterals <em>Literals</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLEnumerationImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLEnumerationImpl extends UMLTypeImpl implements UMLEnumeration
{
  /**
   * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected static final UMLVisibility VISIBILITY_EDEFAULT = UMLVisibility.PUBLIC;

  /**
   * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisibility()
   * @generated
   * @ordered
   */
  protected UMLVisibility visibility = VISIBILITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLiterals()
   * @generated
   * @ordered
   */
  protected EList<UMLLiteral> literals;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLEnumerationImpl()
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
    return ClassesPackage.Literals.UML_ENUMERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLVisibility getVisibility()
  {
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisibility(UMLVisibility newVisibility)
  {
    UMLVisibility oldVisibility = visibility;
    visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ENUMERATION__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLLiteral> getLiterals()
  {
    if (literals == null)
    {
      literals = new EObjectContainmentWithInverseEList<UMLLiteral>(UMLLiteral.class, this, ClassesPackage.UML_ENUMERATION__LITERALS, ClassesPackage.UML_LITERAL__ENUMERATION);
    }
    return literals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLPackage getPackage()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_ENUMERATION__PACKAGE) return null;
    return (UMLPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackage(UMLPackage newPackage, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newPackage, ClassesPackage.UML_ENUMERATION__PACKAGE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(UMLPackage newPackage)
  {
    if (newPackage != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_ENUMERATION__PACKAGE && newPackage != null))
    {
      if (EcoreUtil.isAncestor(this, newPackage))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newPackage != null)
        msgs = ((InternalEObject)newPackage).eInverseAdd(this, CorePackage.UML_PACKAGE__ENUMERATIONS, UMLPackage.class, msgs);
      msgs = basicSetPackage(newPackage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ENUMERATION__PACKAGE, newPackage, newPackage));
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
      case ClassesPackage.UML_ENUMERATION__LITERALS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getLiterals()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_ENUMERATION__PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetPackage((UMLPackage)otherEnd, msgs);
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
      case ClassesPackage.UML_ENUMERATION__LITERALS:
        return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_ENUMERATION__PACKAGE:
        return basicSetPackage(null, msgs);
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
      case ClassesPackage.UML_ENUMERATION__PACKAGE:
        return eInternalContainer().eInverseRemove(this, CorePackage.UML_PACKAGE__ENUMERATIONS, UMLPackage.class, msgs);
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
      case ClassesPackage.UML_ENUMERATION__VISIBILITY:
        return getVisibility();
      case ClassesPackage.UML_ENUMERATION__LITERALS:
        return getLiterals();
      case ClassesPackage.UML_ENUMERATION__PACKAGE:
        return getPackage();
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
      case ClassesPackage.UML_ENUMERATION__VISIBILITY:
        setVisibility((UMLVisibility)newValue);
        return;
      case ClassesPackage.UML_ENUMERATION__LITERALS:
        getLiterals().clear();
        getLiterals().addAll((Collection<? extends UMLLiteral>)newValue);
        return;
      case ClassesPackage.UML_ENUMERATION__PACKAGE:
        setPackage((UMLPackage)newValue);
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
      case ClassesPackage.UML_ENUMERATION__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case ClassesPackage.UML_ENUMERATION__LITERALS:
        getLiterals().clear();
        return;
      case ClassesPackage.UML_ENUMERATION__PACKAGE:
        setPackage((UMLPackage)null);
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
      case ClassesPackage.UML_ENUMERATION__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case ClassesPackage.UML_ENUMERATION__LITERALS:
        return literals != null && !literals.isEmpty();
      case ClassesPackage.UML_ENUMERATION__PACKAGE:
        return getPackage() != null;
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
    if (baseClass == UMLVisibleElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_ENUMERATION__VISIBILITY: return CorePackage.UML_VISIBLE_ELEMENT__VISIBILITY;
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
    if (baseClass == UMLVisibleElement.class)
    {
      switch (baseFeatureID)
      {
        case CorePackage.UML_VISIBLE_ELEMENT__VISIBILITY: return ClassesPackage.UML_ENUMERATION__VISIBILITY;
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
    result.append(" (visibility: ");
    result.append(visibility);
    result.append(')');
    return result.toString();
  }

} //UMLEnumerationImpl

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
import org.sidiff.uml.model.classes.UMLAttribute;
import org.sidiff.uml.model.classes.UMLClass;
import org.sidiff.uml.model.classes.UMLType;
import org.sidiff.uml.model.classes.UMLTypedElement;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibility;
import org.sidiff.uml.model.core.UMLVisibleElement;

import org.sidiff.uml.model.core.impl.UMLNamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl#isIsFinal <em>Is Final</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl#isIsReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAttributeImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLAttributeImpl extends UMLNamedElementImpl implements UMLAttribute
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
   * The default value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsStatic()
   * @generated
   * @ordered
   */
  protected static final boolean IS_STATIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsStatic()
   * @generated
   * @ordered
   */
  protected boolean isStatic = IS_STATIC_EDEFAULT;

  /**
   * The default value of the '{@link #isIsFinal() <em>Is Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsFinal()
   * @generated
   * @ordered
   */
  protected static final boolean IS_FINAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsFinal() <em>Is Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsFinal()
   * @generated
   * @ordered
   */
  protected boolean isFinal = IS_FINAL_EDEFAULT;

  /**
   * The default value of the '{@link #isIsReadOnly() <em>Is Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsReadOnly()
   * @generated
   * @ordered
   */
  protected static final boolean IS_READ_ONLY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsReadOnly() <em>Is Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsReadOnly()
   * @generated
   * @ordered
   */
  protected boolean isReadOnly = IS_READ_ONLY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLAttributeImpl()
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
    return ClassesPackage.Literals.UML_ATTRIBUTE;
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
      stereotypes = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotype>(UMLStereotype.class, this, ClassesPackage.UML_ATTRIBUTE__STEREOTYPES, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS);
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.UML_ATTRIBUTE__TYPE, oldType, type));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ATTRIBUTE__TYPE, oldType, newType);
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
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ATTRIBUTE__TYPE, newType, newType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ATTRIBUTE__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsStatic()
  {
    return isStatic;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsStatic(boolean newIsStatic)
  {
    boolean oldIsStatic = isStatic;
    isStatic = newIsStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ATTRIBUTE__IS_STATIC, oldIsStatic, isStatic));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsFinal()
  {
    return isFinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsFinal(boolean newIsFinal)
  {
    boolean oldIsFinal = isFinal;
    isFinal = newIsFinal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ATTRIBUTE__IS_FINAL, oldIsFinal, isFinal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsReadOnly()
  {
    return isReadOnly;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsReadOnly(boolean newIsReadOnly)
  {
    boolean oldIsReadOnly = isReadOnly;
    isReadOnly = newIsReadOnly;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ATTRIBUTE__IS_READ_ONLY, oldIsReadOnly, isReadOnly));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLClass getClass_()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_ATTRIBUTE__CLASS) return null;
    return (UMLClass)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetClass(UMLClass newClass, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newClass, ClassesPackage.UML_ATTRIBUTE__CLASS, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClass(UMLClass newClass)
  {
    if (newClass != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_ATTRIBUTE__CLASS && newClass != null))
    {
      if (EcoreUtil.isAncestor(this, newClass))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newClass != null)
        msgs = ((InternalEObject)newClass).eInverseAdd(this, ClassesPackage.UML_CLASS__ATTRIBUTES, UMLClass.class, msgs);
      msgs = basicSetClass(newClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ATTRIBUTE__CLASS, newClass, newClass));
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
      case ClassesPackage.UML_ATTRIBUTE__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_ATTRIBUTE__TYPE:
        if (type != null)
          msgs = ((InternalEObject)type).eInverseRemove(this, ClassesPackage.UML_TYPE__USED_BY_ELEMENTS, UMLType.class, msgs);
        return basicSetType((UMLType)otherEnd, msgs);
      case ClassesPackage.UML_ATTRIBUTE__CLASS:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetClass((UMLClass)otherEnd, msgs);
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
      case ClassesPackage.UML_ATTRIBUTE__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_ATTRIBUTE__TYPE:
        return basicSetType(null, msgs);
      case ClassesPackage.UML_ATTRIBUTE__CLASS:
        return basicSetClass(null, msgs);
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
      case ClassesPackage.UML_ATTRIBUTE__CLASS:
        return eInternalContainer().eInverseRemove(this, ClassesPackage.UML_CLASS__ATTRIBUTES, UMLClass.class, msgs);
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
      case ClassesPackage.UML_ATTRIBUTE__STEREOTYPES:
        return getStereotypes();
      case ClassesPackage.UML_ATTRIBUTE__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case ClassesPackage.UML_ATTRIBUTE__VISIBILITY:
        return getVisibility();
      case ClassesPackage.UML_ATTRIBUTE__IS_STATIC:
        return isIsStatic();
      case ClassesPackage.UML_ATTRIBUTE__IS_FINAL:
        return isIsFinal();
      case ClassesPackage.UML_ATTRIBUTE__IS_READ_ONLY:
        return isIsReadOnly();
      case ClassesPackage.UML_ATTRIBUTE__CLASS:
        return getClass_();
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
      case ClassesPackage.UML_ATTRIBUTE__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
        return;
      case ClassesPackage.UML_ATTRIBUTE__TYPE:
        setType((UMLType)newValue);
        return;
      case ClassesPackage.UML_ATTRIBUTE__VISIBILITY:
        setVisibility((UMLVisibility)newValue);
        return;
      case ClassesPackage.UML_ATTRIBUTE__IS_STATIC:
        setIsStatic((Boolean)newValue);
        return;
      case ClassesPackage.UML_ATTRIBUTE__IS_FINAL:
        setIsFinal((Boolean)newValue);
        return;
      case ClassesPackage.UML_ATTRIBUTE__IS_READ_ONLY:
        setIsReadOnly((Boolean)newValue);
        return;
      case ClassesPackage.UML_ATTRIBUTE__CLASS:
        setClass((UMLClass)newValue);
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
      case ClassesPackage.UML_ATTRIBUTE__STEREOTYPES:
        getStereotypes().clear();
        return;
      case ClassesPackage.UML_ATTRIBUTE__TYPE:
        setType((UMLType)null);
        return;
      case ClassesPackage.UML_ATTRIBUTE__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case ClassesPackage.UML_ATTRIBUTE__IS_STATIC:
        setIsStatic(IS_STATIC_EDEFAULT);
        return;
      case ClassesPackage.UML_ATTRIBUTE__IS_FINAL:
        setIsFinal(IS_FINAL_EDEFAULT);
        return;
      case ClassesPackage.UML_ATTRIBUTE__IS_READ_ONLY:
        setIsReadOnly(IS_READ_ONLY_EDEFAULT);
        return;
      case ClassesPackage.UML_ATTRIBUTE__CLASS:
        setClass((UMLClass)null);
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
      case ClassesPackage.UML_ATTRIBUTE__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
      case ClassesPackage.UML_ATTRIBUTE__TYPE:
        return type != null;
      case ClassesPackage.UML_ATTRIBUTE__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case ClassesPackage.UML_ATTRIBUTE__IS_STATIC:
        return isStatic != IS_STATIC_EDEFAULT;
      case ClassesPackage.UML_ATTRIBUTE__IS_FINAL:
        return isFinal != IS_FINAL_EDEFAULT;
      case ClassesPackage.UML_ATTRIBUTE__IS_READ_ONLY:
        return isReadOnly != IS_READ_ONLY_EDEFAULT;
      case ClassesPackage.UML_ATTRIBUTE__CLASS:
        return getClass_() != null;
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
        case ClassesPackage.UML_ATTRIBUTE__STEREOTYPES: return CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES;
        default: return -1;
      }
    }
    if (baseClass == UMLTypedElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_ATTRIBUTE__TYPE: return ClassesPackage.UML_TYPED_ELEMENT__TYPE;
        default: return -1;
      }
    }
    if (baseClass == UMLVisibleElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_ATTRIBUTE__VISIBILITY: return CorePackage.UML_VISIBLE_ELEMENT__VISIBILITY;
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
        case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES: return ClassesPackage.UML_ATTRIBUTE__STEREOTYPES;
        default: return -1;
      }
    }
    if (baseClass == UMLTypedElement.class)
    {
      switch (baseFeatureID)
      {
        case ClassesPackage.UML_TYPED_ELEMENT__TYPE: return ClassesPackage.UML_ATTRIBUTE__TYPE;
        default: return -1;
      }
    }
    if (baseClass == UMLVisibleElement.class)
    {
      switch (baseFeatureID)
      {
        case CorePackage.UML_VISIBLE_ELEMENT__VISIBILITY: return ClassesPackage.UML_ATTRIBUTE__VISIBILITY;
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
    result.append(", isStatic: ");
    result.append(isStatic);
    result.append(", isFinal: ");
    result.append(isFinal);
    result.append(", isReadOnly: ");
    result.append(isReadOnly);
    result.append(')');
    return result.toString();
  }

} //UMLAttributeImpl

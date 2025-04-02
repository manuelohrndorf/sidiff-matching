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
import org.sidiff.uml.model.classes.UMLGeneralizableElement;
import org.sidiff.uml.model.classes.UMLGeneralization;

import org.sidiff.uml.model.core.impl.UMLElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Generalization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLGeneralizationImpl#getSpecialElement <em>Special Element</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLGeneralizationImpl#getGeneralElement <em>General Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLGeneralizationImpl extends UMLElementImpl implements UMLGeneralization
{
  /**
   * The cached value of the '{@link #getGeneralElement() <em>General Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGeneralElement()
   * @generated
   * @ordered
   */
  protected UMLGeneralizableElement generalElement;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLGeneralizationImpl()
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
    return ClassesPackage.Literals.UML_GENERALIZATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLGeneralizableElement getSpecialElement()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT) return null;
    return (UMLGeneralizableElement)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecialElement(UMLGeneralizableElement newSpecialElement, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newSpecialElement, ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecialElement(UMLGeneralizableElement newSpecialElement)
  {
    if (newSpecialElement != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT && newSpecialElement != null))
    {
      if (EcoreUtil.isAncestor(this, newSpecialElement))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSpecialElement != null)
        msgs = ((InternalEObject)newSpecialElement).eInverseAdd(this, ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS, UMLGeneralizableElement.class, msgs);
      msgs = basicSetSpecialElement(newSpecialElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT, newSpecialElement, newSpecialElement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLGeneralizableElement getGeneralElement()
  {
    if (generalElement != null && generalElement.eIsProxy())
    {
      InternalEObject oldGeneralElement = (InternalEObject)generalElement;
      generalElement = (UMLGeneralizableElement)eResolveProxy(oldGeneralElement);
      if (generalElement != oldGeneralElement)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT, oldGeneralElement, generalElement));
      }
    }
    return generalElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLGeneralizableElement basicGetGeneralElement()
  {
    return generalElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGeneralElement(UMLGeneralizableElement newGeneralElement, NotificationChain msgs)
  {
    UMLGeneralizableElement oldGeneralElement = generalElement;
    generalElement = newGeneralElement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT, oldGeneralElement, newGeneralElement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGeneralElement(UMLGeneralizableElement newGeneralElement)
  {
    if (newGeneralElement != generalElement)
    {
      NotificationChain msgs = null;
      if (generalElement != null)
        msgs = ((InternalEObject)generalElement).eInverseRemove(this, ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS, UMLGeneralizableElement.class, msgs);
      if (newGeneralElement != null)
        msgs = ((InternalEObject)newGeneralElement).eInverseAdd(this, ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS, UMLGeneralizableElement.class, msgs);
      msgs = basicSetGeneralElement(newGeneralElement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT, newGeneralElement, newGeneralElement));
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
      case ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetSpecialElement((UMLGeneralizableElement)otherEnd, msgs);
      case ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT:
        if (generalElement != null)
          msgs = ((InternalEObject)generalElement).eInverseRemove(this, ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS, UMLGeneralizableElement.class, msgs);
        return basicSetGeneralElement((UMLGeneralizableElement)otherEnd, msgs);
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
      case ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT:
        return basicSetSpecialElement(null, msgs);
      case ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT:
        return basicSetGeneralElement(null, msgs);
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
      case ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT:
        return eInternalContainer().eInverseRemove(this, ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS, UMLGeneralizableElement.class, msgs);
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
      case ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT:
        return getSpecialElement();
      case ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT:
        if (resolve) return getGeneralElement();
        return basicGetGeneralElement();
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
      case ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT:
        setSpecialElement((UMLGeneralizableElement)newValue);
        return;
      case ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT:
        setGeneralElement((UMLGeneralizableElement)newValue);
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
      case ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT:
        setSpecialElement((UMLGeneralizableElement)null);
        return;
      case ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT:
        setGeneralElement((UMLGeneralizableElement)null);
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
      case ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT:
        return getSpecialElement() != null;
      case ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT:
        return generalElement != null;
    }
    return super.eIsSet(featureID);
  }

} //UMLGeneralizationImpl

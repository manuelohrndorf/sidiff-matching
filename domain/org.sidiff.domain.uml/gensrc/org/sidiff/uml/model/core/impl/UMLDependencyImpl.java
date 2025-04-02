/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core.impl;

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

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLDependency;
import org.sidiff.uml.model.core.UMLNamedElement;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLDependencyImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLDependencyImpl#getDependee <em>Dependee</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLDependencyImpl#getSupplier <em>Supplier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLDependencyImpl extends UMLNamedElementImpl implements UMLDependency
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
   * The cached value of the '{@link #getSupplier() <em>Supplier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupplier()
   * @generated
   * @ordered
   */
  protected UMLNamedElement supplier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLDependencyImpl()
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
    return CorePackage.Literals.UML_DEPENDENCY;
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
      stereotypes = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotype>(UMLStereotype.class, this, CorePackage.UML_DEPENDENCY__STEREOTYPES, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS);
    }
    return stereotypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLNamedElement getDependee()
  {
    if (eContainerFeatureID() != CorePackage.UML_DEPENDENCY__DEPENDEE) return null;
    return (UMLNamedElement)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDependee(UMLNamedElement newDependee, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newDependee, CorePackage.UML_DEPENDENCY__DEPENDEE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDependee(UMLNamedElement newDependee)
  {
    if (newDependee != eInternalContainer() || (eContainerFeatureID() != CorePackage.UML_DEPENDENCY__DEPENDEE && newDependee != null))
    {
      if (EcoreUtil.isAncestor(this, newDependee))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newDependee != null)
        msgs = ((InternalEObject)newDependee).eInverseAdd(this, CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES, UMLNamedElement.class, msgs);
      msgs = basicSetDependee(newDependee, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UML_DEPENDENCY__DEPENDEE, newDependee, newDependee));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLNamedElement getSupplier()
  {
    if (supplier != null && supplier.eIsProxy())
    {
      InternalEObject oldSupplier = (InternalEObject)supplier;
      supplier = (UMLNamedElement)eResolveProxy(oldSupplier);
      if (supplier != oldSupplier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.UML_DEPENDENCY__SUPPLIER, oldSupplier, supplier));
      }
    }
    return supplier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLNamedElement basicGetSupplier()
  {
    return supplier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSupplier(UMLNamedElement newSupplier, NotificationChain msgs)
  {
    UMLNamedElement oldSupplier = supplier;
    supplier = newSupplier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.UML_DEPENDENCY__SUPPLIER, oldSupplier, newSupplier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSupplier(UMLNamedElement newSupplier)
  {
    if (newSupplier != supplier)
    {
      NotificationChain msgs = null;
      if (supplier != null)
        msgs = ((InternalEObject)supplier).eInverseRemove(this, CorePackage.UML_NAMED_ELEMENT__DEPENDEES, UMLNamedElement.class, msgs);
      if (newSupplier != null)
        msgs = ((InternalEObject)newSupplier).eInverseAdd(this, CorePackage.UML_NAMED_ELEMENT__DEPENDEES, UMLNamedElement.class, msgs);
      msgs = basicSetSupplier(newSupplier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UML_DEPENDENCY__SUPPLIER, newSupplier, newSupplier));
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
      case CorePackage.UML_DEPENDENCY__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_DEPENDENCY__DEPENDEE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetDependee((UMLNamedElement)otherEnd, msgs);
      case CorePackage.UML_DEPENDENCY__SUPPLIER:
        if (supplier != null)
          msgs = ((InternalEObject)supplier).eInverseRemove(this, CorePackage.UML_NAMED_ELEMENT__DEPENDEES, UMLNamedElement.class, msgs);
        return basicSetSupplier((UMLNamedElement)otherEnd, msgs);
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
      case CorePackage.UML_DEPENDENCY__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_DEPENDENCY__DEPENDEE:
        return basicSetDependee(null, msgs);
      case CorePackage.UML_DEPENDENCY__SUPPLIER:
        return basicSetSupplier(null, msgs);
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
      case CorePackage.UML_DEPENDENCY__DEPENDEE:
        return eInternalContainer().eInverseRemove(this, CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES, UMLNamedElement.class, msgs);
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
      case CorePackage.UML_DEPENDENCY__STEREOTYPES:
        return getStereotypes();
      case CorePackage.UML_DEPENDENCY__DEPENDEE:
        return getDependee();
      case CorePackage.UML_DEPENDENCY__SUPPLIER:
        if (resolve) return getSupplier();
        return basicGetSupplier();
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
      case CorePackage.UML_DEPENDENCY__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
        return;
      case CorePackage.UML_DEPENDENCY__DEPENDEE:
        setDependee((UMLNamedElement)newValue);
        return;
      case CorePackage.UML_DEPENDENCY__SUPPLIER:
        setSupplier((UMLNamedElement)newValue);
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
      case CorePackage.UML_DEPENDENCY__STEREOTYPES:
        getStereotypes().clear();
        return;
      case CorePackage.UML_DEPENDENCY__DEPENDEE:
        setDependee((UMLNamedElement)null);
        return;
      case CorePackage.UML_DEPENDENCY__SUPPLIER:
        setSupplier((UMLNamedElement)null);
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
      case CorePackage.UML_DEPENDENCY__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
      case CorePackage.UML_DEPENDENCY__DEPENDEE:
        return getDependee() != null;
      case CorePackage.UML_DEPENDENCY__SUPPLIER:
        return supplier != null;
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
        case CorePackage.UML_DEPENDENCY__STEREOTYPES: return CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES;
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
        case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES: return CorePackage.UML_DEPENDENCY__STEREOTYPES;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //UMLDependencyImpl

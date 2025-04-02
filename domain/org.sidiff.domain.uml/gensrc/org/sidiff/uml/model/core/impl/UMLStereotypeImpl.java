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
import org.sidiff.uml.model.core.UMLModel;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Stereotype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLStereotypeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLStereotypeImpl#getStereotypedElements <em>Stereotyped Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLStereotypeImpl extends UMLNamedElementImpl implements UMLStereotype
{
  /**
   * The cached value of the '{@link #getStereotypedElements() <em>Stereotyped Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotypedElements()
   * @generated
   * @ordered
   */
  protected EList<UMLStereotypeableElement> stereotypedElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLStereotypeImpl()
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
    return CorePackage.Literals.UML_STEREOTYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLModel getModel()
  {
    if (eContainerFeatureID() != CorePackage.UML_STEREOTYPE__MODEL) return null;
    return (UMLModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModel(UMLModel newModel, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newModel, CorePackage.UML_STEREOTYPE__MODEL, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModel(UMLModel newModel)
  {
    if (newModel != eInternalContainer() || (eContainerFeatureID() != CorePackage.UML_STEREOTYPE__MODEL && newModel != null))
    {
      if (EcoreUtil.isAncestor(this, newModel))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModel != null)
        msgs = ((InternalEObject)newModel).eInverseAdd(this, CorePackage.UML_MODEL__STEREOTYPES, UMLModel.class, msgs);
      msgs = basicSetModel(newModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UML_STEREOTYPE__MODEL, newModel, newModel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLStereotypeableElement> getStereotypedElements()
  {
    if (stereotypedElements == null)
    {
      stereotypedElements = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotypeableElement>(UMLStereotypeableElement.class, this, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS, CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES);
    }
    return stereotypedElements;
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
      case CorePackage.UML_STEREOTYPE__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModel((UMLModel)otherEnd, msgs);
      case CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypedElements()).basicAdd(otherEnd, msgs);
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
      case CorePackage.UML_STEREOTYPE__MODEL:
        return basicSetModel(null, msgs);
      case CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS:
        return ((InternalEList<?>)getStereotypedElements()).basicRemove(otherEnd, msgs);
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
      case CorePackage.UML_STEREOTYPE__MODEL:
        return eInternalContainer().eInverseRemove(this, CorePackage.UML_MODEL__STEREOTYPES, UMLModel.class, msgs);
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
      case CorePackage.UML_STEREOTYPE__MODEL:
        return getModel();
      case CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS:
        return getStereotypedElements();
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
      case CorePackage.UML_STEREOTYPE__MODEL:
        setModel((UMLModel)newValue);
        return;
      case CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS:
        getStereotypedElements().clear();
        getStereotypedElements().addAll((Collection<? extends UMLStereotypeableElement>)newValue);
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
      case CorePackage.UML_STEREOTYPE__MODEL:
        setModel((UMLModel)null);
        return;
      case CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS:
        getStereotypedElements().clear();
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
      case CorePackage.UML_STEREOTYPE__MODEL:
        return getModel() != null;
      case CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS:
        return stereotypedElements != null && !stereotypedElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLStereotypeImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLModel;
import org.sidiff.uml.model.core.UMLPackage;
import org.sidiff.uml.model.core.UMLStereotype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLModelImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLModelImpl#getStereotypes <em>Stereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLModelImpl extends UMLNamedElementImpl implements UMLModel
{
  /**
   * The cached value of the '{@link #getPackages() <em>Packages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackages()
   * @generated
   * @ordered
   */
  protected EList<UMLPackage> packages;

  /**
   * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStereotypes()
   * @generated
   * @ordered
   */
  protected EList<UMLStereotype> stereotypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLModelImpl()
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
    return CorePackage.Literals.UML_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLPackage> getPackages()
  {
    if (packages == null)
    {
      packages = new EObjectContainmentWithInverseEList<UMLPackage>(UMLPackage.class, this, CorePackage.UML_MODEL__PACKAGES, CorePackage.UML_PACKAGE__MODEL);
    }
    return packages;
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
      stereotypes = new EObjectContainmentWithInverseEList<UMLStereotype>(UMLStereotype.class, this, CorePackage.UML_MODEL__STEREOTYPES, CorePackage.UML_STEREOTYPE__MODEL);
    }
    return stereotypes;
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
      case CorePackage.UML_MODEL__PACKAGES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getPackages()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_MODEL__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
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
      case CorePackage.UML_MODEL__PACKAGES:
        return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_MODEL__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
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
      case CorePackage.UML_MODEL__PACKAGES:
        return getPackages();
      case CorePackage.UML_MODEL__STEREOTYPES:
        return getStereotypes();
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
      case CorePackage.UML_MODEL__PACKAGES:
        getPackages().clear();
        getPackages().addAll((Collection<? extends UMLPackage>)newValue);
        return;
      case CorePackage.UML_MODEL__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
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
      case CorePackage.UML_MODEL__PACKAGES:
        getPackages().clear();
        return;
      case CorePackage.UML_MODEL__STEREOTYPES:
        getStereotypes().clear();
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
      case CorePackage.UML_MODEL__PACKAGES:
        return packages != null && !packages.isEmpty();
      case CorePackage.UML_MODEL__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //UMLModelImpl

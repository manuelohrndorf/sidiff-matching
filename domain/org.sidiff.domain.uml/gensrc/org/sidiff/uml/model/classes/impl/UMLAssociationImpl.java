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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.classes.ClassesPackage;
import org.sidiff.uml.model.classes.UMLAssociation;
import org.sidiff.uml.model.classes.UMLAssociationEnd;
import org.sidiff.uml.model.classes.UMLGeneralizableElement;
import org.sidiff.uml.model.classes.UMLGeneralization;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLPackage;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;

import org.sidiff.uml.model.core.impl.UMLNamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationImpl#getSpecializations <em>Specializations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationImpl#getGeneralizations <em>Generalizations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationImpl#getAssociationEnds <em>Association Ends</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLAssociationImpl extends UMLNamedElementImpl implements UMLAssociation
{
  /**
   * The cached value of the '{@link #getSpecializations() <em>Specializations</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecializations()
   * @generated
   * @ordered
   */
  protected EList<UMLGeneralization> specializations;

  /**
   * The cached value of the '{@link #getGeneralizations() <em>Generalizations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGeneralizations()
   * @generated
   * @ordered
   */
  protected EList<UMLGeneralization> generalizations;

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
   * The cached value of the '{@link #getAssociationEnds() <em>Association Ends</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociationEnds()
   * @generated
   * @ordered
   */
  protected EList<UMLAssociationEnd> associationEnds;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLAssociationImpl()
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
    return ClassesPackage.Literals.UML_ASSOCIATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLGeneralization> getSpecializations()
  {
    if (specializations == null)
    {
      specializations = new EObjectWithInverseResolvingEList<UMLGeneralization>(UMLGeneralization.class, this, ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS, ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT);
    }
    return specializations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLGeneralization> getGeneralizations()
  {
    if (generalizations == null)
    {
      generalizations = new EObjectContainmentWithInverseEList<UMLGeneralization>(UMLGeneralization.class, this, ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS, ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT);
    }
    return generalizations;
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
      stereotypes = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotype>(UMLStereotype.class, this, ClassesPackage.UML_ASSOCIATION__STEREOTYPES, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS);
    }
    return stereotypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLAssociationEnd> getAssociationEnds()
  {
    if (associationEnds == null)
    {
      associationEnds = new EObjectContainmentWithInverseEList<UMLAssociationEnd>(UMLAssociationEnd.class, this, ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS, ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION);
    }
    return associationEnds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLPackage getPackage()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_ASSOCIATION__PACKAGE) return null;
    return (UMLPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackage(UMLPackage newPackage, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newPackage, ClassesPackage.UML_ASSOCIATION__PACKAGE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(UMLPackage newPackage)
  {
    if (newPackage != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_ASSOCIATION__PACKAGE && newPackage != null))
    {
      if (EcoreUtil.isAncestor(this, newPackage))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newPackage != null)
        msgs = ((InternalEObject)newPackage).eInverseAdd(this, CorePackage.UML_PACKAGE__ASSOCIATIONS, UMLPackage.class, msgs);
      msgs = basicSetPackage(newPackage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ASSOCIATION__PACKAGE, newPackage, newPackage));
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
      case ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializations()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralizations()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationEnds()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION__PACKAGE:
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
      case ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS:
        return ((InternalEList<?>)getSpecializations()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS:
        return ((InternalEList<?>)getGeneralizations()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS:
        return ((InternalEList<?>)getAssociationEnds()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION__PACKAGE:
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
      case ClassesPackage.UML_ASSOCIATION__PACKAGE:
        return eInternalContainer().eInverseRemove(this, CorePackage.UML_PACKAGE__ASSOCIATIONS, UMLPackage.class, msgs);
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
      case ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS:
        return getSpecializations();
      case ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS:
        return getGeneralizations();
      case ClassesPackage.UML_ASSOCIATION__STEREOTYPES:
        return getStereotypes();
      case ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS:
        return getAssociationEnds();
      case ClassesPackage.UML_ASSOCIATION__PACKAGE:
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
      case ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS:
        getSpecializations().clear();
        getSpecializations().addAll((Collection<? extends UMLGeneralization>)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS:
        getGeneralizations().clear();
        getGeneralizations().addAll((Collection<? extends UMLGeneralization>)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS:
        getAssociationEnds().clear();
        getAssociationEnds().addAll((Collection<? extends UMLAssociationEnd>)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION__PACKAGE:
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
      case ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS:
        getSpecializations().clear();
        return;
      case ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS:
        getGeneralizations().clear();
        return;
      case ClassesPackage.UML_ASSOCIATION__STEREOTYPES:
        getStereotypes().clear();
        return;
      case ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS:
        getAssociationEnds().clear();
        return;
      case ClassesPackage.UML_ASSOCIATION__PACKAGE:
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
      case ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS:
        return specializations != null && !specializations.isEmpty();
      case ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS:
        return generalizations != null && !generalizations.isEmpty();
      case ClassesPackage.UML_ASSOCIATION__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
      case ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS:
        return associationEnds != null && !associationEnds.isEmpty();
      case ClassesPackage.UML_ASSOCIATION__PACKAGE:
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
    if (baseClass == UMLGeneralizableElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS: return ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS;
        case ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS: return ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS;
        default: return -1;
      }
    }
    if (baseClass == UMLStereotypeableElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_ASSOCIATION__STEREOTYPES: return CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES;
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
    if (baseClass == UMLGeneralizableElement.class)
    {
      switch (baseFeatureID)
      {
        case ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS: return ClassesPackage.UML_ASSOCIATION__SPECIALIZATIONS;
        case ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS: return ClassesPackage.UML_ASSOCIATION__GENERALIZATIONS;
        default: return -1;
      }
    }
    if (baseClass == UMLStereotypeableElement.class)
    {
      switch (baseFeatureID)
      {
        case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES: return ClassesPackage.UML_ASSOCIATION__STEREOTYPES;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //UMLAssociationImpl

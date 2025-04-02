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
import org.sidiff.uml.model.classes.UMLAggregationKind;
import org.sidiff.uml.model.classes.UMLAssociation;
import org.sidiff.uml.model.classes.UMLAssociationEnd;
import org.sidiff.uml.model.classes.UMLClassifier;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;

import org.sidiff.uml.model.core.impl.UMLNamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Association End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl#isIsNavigable <em>Is Navigable</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLAssociationEndImpl extends UMLNamedElementImpl implements UMLAssociationEnd
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
   * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected static final String MULTIPLICITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
  protected String multiplicity = MULTIPLICITY_EDEFAULT;

  /**
   * The default value of the '{@link #isIsNavigable() <em>Is Navigable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNavigable()
   * @generated
   * @ordered
   */
  protected static final boolean IS_NAVIGABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsNavigable() <em>Is Navigable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsNavigable()
   * @generated
   * @ordered
   */
  protected boolean isNavigable = IS_NAVIGABLE_EDEFAULT;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final UMLAggregationKind KIND_EDEFAULT = UMLAggregationKind.NONE;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected UMLAggregationKind kind = KIND_EDEFAULT;

  /**
   * The default value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsOrdered()
   * @generated
   * @ordered
   */
  protected static final boolean IS_ORDERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsOrdered() <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsOrdered()
   * @generated
   * @ordered
   */
  protected boolean isOrdered = IS_ORDERED_EDEFAULT;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected UMLClassifier target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLAssociationEndImpl()
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
    return ClassesPackage.Literals.UML_ASSOCIATION_END;
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
      stereotypes = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotype>(UMLStereotype.class, this, ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS);
    }
    return stereotypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAssociation getAssociation()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION) return null;
    return (UMLAssociation)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssociation(UMLAssociation newAssociation, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newAssociation, ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssociation(UMLAssociation newAssociation)
  {
    if (newAssociation != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION && newAssociation != null))
    {
      if (EcoreUtil.isAncestor(this, newAssociation))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newAssociation != null)
        msgs = ((InternalEObject)newAssociation).eInverseAdd(this, ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS, UMLAssociation.class, msgs);
      msgs = basicSetAssociation(newAssociation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION, newAssociation, newAssociation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMultiplicity()
  {
    return multiplicity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplicity(String newMultiplicity)
  {
    String oldMultiplicity = multiplicity;
    multiplicity = newMultiplicity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ASSOCIATION_END__MULTIPLICITY, oldMultiplicity, multiplicity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsNavigable()
  {
    return isNavigable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsNavigable(boolean newIsNavigable)
  {
    boolean oldIsNavigable = isNavigable;
    isNavigable = newIsNavigable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ASSOCIATION_END__IS_NAVIGABLE, oldIsNavigable, isNavigable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLAggregationKind getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(UMLAggregationKind newKind)
  {
    UMLAggregationKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ASSOCIATION_END__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsOrdered()
  {
    return isOrdered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsOrdered(boolean newIsOrdered)
  {
    boolean oldIsOrdered = isOrdered;
    isOrdered = newIsOrdered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ASSOCIATION_END__IS_ORDERED, oldIsOrdered, isOrdered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLClassifier getTarget()
  {
    if (target != null && target.eIsProxy())
    {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (UMLClassifier)eResolveProxy(oldTarget);
      if (target != oldTarget)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassesPackage.UML_ASSOCIATION_END__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLClassifier basicGetTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(UMLClassifier newTarget, NotificationChain msgs)
  {
    UMLClassifier oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ASSOCIATION_END__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(UMLClassifier newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS, UMLClassifier.class, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS, UMLClassifier.class, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_ASSOCIATION_END__TARGET, newTarget, newTarget));
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
      case ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetAssociation((UMLAssociation)otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION_END__TARGET:
        if (target != null)
          msgs = ((InternalEObject)target).eInverseRemove(this, ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS, UMLClassifier.class, msgs);
        return basicSetTarget((UMLClassifier)otherEnd, msgs);
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
      case ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION:
        return basicSetAssociation(null, msgs);
      case ClassesPackage.UML_ASSOCIATION_END__TARGET:
        return basicSetTarget(null, msgs);
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
      case ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION:
        return eInternalContainer().eInverseRemove(this, ClassesPackage.UML_ASSOCIATION__ASSOCIATION_ENDS, UMLAssociation.class, msgs);
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
      case ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES:
        return getStereotypes();
      case ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION:
        return getAssociation();
      case ClassesPackage.UML_ASSOCIATION_END__MULTIPLICITY:
        return getMultiplicity();
      case ClassesPackage.UML_ASSOCIATION_END__IS_NAVIGABLE:
        return isIsNavigable();
      case ClassesPackage.UML_ASSOCIATION_END__KIND:
        return getKind();
      case ClassesPackage.UML_ASSOCIATION_END__IS_ORDERED:
        return isIsOrdered();
      case ClassesPackage.UML_ASSOCIATION_END__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
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
      case ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION:
        setAssociation((UMLAssociation)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__MULTIPLICITY:
        setMultiplicity((String)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__IS_NAVIGABLE:
        setIsNavigable((Boolean)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__KIND:
        setKind((UMLAggregationKind)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__IS_ORDERED:
        setIsOrdered((Boolean)newValue);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__TARGET:
        setTarget((UMLClassifier)newValue);
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
      case ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES:
        getStereotypes().clear();
        return;
      case ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION:
        setAssociation((UMLAssociation)null);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__MULTIPLICITY:
        setMultiplicity(MULTIPLICITY_EDEFAULT);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__IS_NAVIGABLE:
        setIsNavigable(IS_NAVIGABLE_EDEFAULT);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__IS_ORDERED:
        setIsOrdered(IS_ORDERED_EDEFAULT);
        return;
      case ClassesPackage.UML_ASSOCIATION_END__TARGET:
        setTarget((UMLClassifier)null);
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
      case ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
      case ClassesPackage.UML_ASSOCIATION_END__ASSOCIATION:
        return getAssociation() != null;
      case ClassesPackage.UML_ASSOCIATION_END__MULTIPLICITY:
        return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
      case ClassesPackage.UML_ASSOCIATION_END__IS_NAVIGABLE:
        return isNavigable != IS_NAVIGABLE_EDEFAULT;
      case ClassesPackage.UML_ASSOCIATION_END__KIND:
        return kind != KIND_EDEFAULT;
      case ClassesPackage.UML_ASSOCIATION_END__IS_ORDERED:
        return isOrdered != IS_ORDERED_EDEFAULT;
      case ClassesPackage.UML_ASSOCIATION_END__TARGET:
        return target != null;
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
        case ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES: return CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES;
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
        case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES: return ClassesPackage.UML_ASSOCIATION_END__STEREOTYPES;
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
    result.append(" (multiplicity: ");
    result.append(multiplicity);
    result.append(", isNavigable: ");
    result.append(isNavigable);
    result.append(", kind: ");
    result.append(kind);
    result.append(", isOrdered: ");
    result.append(isOrdered);
    result.append(')');
    return result.toString();
  }

} //UMLAssociationEndImpl

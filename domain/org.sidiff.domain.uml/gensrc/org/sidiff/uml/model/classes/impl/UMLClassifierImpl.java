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
import org.sidiff.uml.model.classes.UMLAssociationEnd;
import org.sidiff.uml.model.classes.UMLBindingElement;
import org.sidiff.uml.model.classes.UMLClassifier;
import org.sidiff.uml.model.classes.UMLGeneralizableElement;
import org.sidiff.uml.model.classes.UMLGeneralization;
import org.sidiff.uml.model.classes.UMLTemplateBinding;
import org.sidiff.uml.model.classes.UMLTemplateParameter;
import org.sidiff.uml.model.classes.UMLTemplateableElement;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLPackage;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibility;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl#getSpecializations <em>Specializations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl#getGeneralizations <em>Generalizations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl#getTemplateBindings <em>Template Bindings</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl#getTargetedByAssociationEnds <em>Targeted By Association Ends</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.impl.UMLClassifierImpl#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UMLClassifierImpl extends UMLTypeImpl implements UMLClassifier
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
   * The cached value of the '{@link #getTemplateBindings() <em>Template Bindings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateBindings()
   * @generated
   * @ordered
   */
  protected EList<UMLTemplateBinding> templateBindings;

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
   * The cached value of the '{@link #getTemplateParameters() <em>Template Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateParameters()
   * @generated
   * @ordered
   */
  protected EList<UMLTemplateParameter> templateParameters;

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
   * The cached value of the '{@link #getTargetedByAssociationEnds() <em>Targeted By Association Ends</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetedByAssociationEnds()
   * @generated
   * @ordered
   */
  protected EList<UMLAssociationEnd> targetedByAssociationEnds;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLClassifierImpl()
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
    return ClassesPackage.Literals.UML_CLASSIFIER;
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
      specializations = new EObjectWithInverseResolvingEList<UMLGeneralization>(UMLGeneralization.class, this, ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS, ClassesPackage.UML_GENERALIZATION__GENERAL_ELEMENT);
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
      generalizations = new EObjectContainmentWithInverseEList<UMLGeneralization>(UMLGeneralization.class, this, ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS, ClassesPackage.UML_GENERALIZATION__SPECIAL_ELEMENT);
    }
    return generalizations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLTemplateBinding> getTemplateBindings()
  {
    if (templateBindings == null)
    {
      templateBindings = new EObjectContainmentWithInverseEList<UMLTemplateBinding>(UMLTemplateBinding.class, this, ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS, ClassesPackage.UML_TEMPLATE_BINDING__BINDER);
    }
    return templateBindings;
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
      stereotypes = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotype>(UMLStereotype.class, this, ClassesPackage.UML_CLASSIFIER__STEREOTYPES, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS);
    }
    return stereotypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLTemplateParameter> getTemplateParameters()
  {
    if (templateParameters == null)
    {
      templateParameters = new EObjectContainmentWithInverseEList<UMLTemplateParameter>(UMLTemplateParameter.class, this, ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS, ClassesPackage.UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT);
    }
    return templateParameters;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_CLASSIFIER__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLAssociationEnd> getTargetedByAssociationEnds()
  {
    if (targetedByAssociationEnds == null)
    {
      targetedByAssociationEnds = new EObjectWithInverseResolvingEList<UMLAssociationEnd>(UMLAssociationEnd.class, this, ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS, ClassesPackage.UML_ASSOCIATION_END__TARGET);
    }
    return targetedByAssociationEnds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLPackage getPackage()
  {
    if (eContainerFeatureID() != ClassesPackage.UML_CLASSIFIER__PACKAGE) return null;
    return (UMLPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPackage(UMLPackage newPackage, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newPackage, ClassesPackage.UML_CLASSIFIER__PACKAGE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPackage(UMLPackage newPackage)
  {
    if (newPackage != eInternalContainer() || (eContainerFeatureID() != ClassesPackage.UML_CLASSIFIER__PACKAGE && newPackage != null))
    {
      if (EcoreUtil.isAncestor(this, newPackage))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newPackage != null)
        msgs = ((InternalEObject)newPackage).eInverseAdd(this, CorePackage.UML_PACKAGE__CLASSIFIERS, UMLPackage.class, msgs);
      msgs = basicSetPackage(newPackage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassesPackage.UML_CLASSIFIER__PACKAGE, newPackage, newPackage));
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
      case ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializations()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGeneralizations()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateBindings()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplateParameters()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetedByAssociationEnds()).basicAdd(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__PACKAGE:
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
      case ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS:
        return ((InternalEList<?>)getSpecializations()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS:
        return ((InternalEList<?>)getGeneralizations()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS:
        return ((InternalEList<?>)getTemplateBindings()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS:
        return ((InternalEList<?>)getTemplateParameters()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS:
        return ((InternalEList<?>)getTargetedByAssociationEnds()).basicRemove(otherEnd, msgs);
      case ClassesPackage.UML_CLASSIFIER__PACKAGE:
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
      case ClassesPackage.UML_CLASSIFIER__PACKAGE:
        return eInternalContainer().eInverseRemove(this, CorePackage.UML_PACKAGE__CLASSIFIERS, UMLPackage.class, msgs);
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
      case ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS:
        return getSpecializations();
      case ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS:
        return getGeneralizations();
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS:
        return getTemplateBindings();
      case ClassesPackage.UML_CLASSIFIER__STEREOTYPES:
        return getStereotypes();
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS:
        return getTemplateParameters();
      case ClassesPackage.UML_CLASSIFIER__VISIBILITY:
        return getVisibility();
      case ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS:
        return getTargetedByAssociationEnds();
      case ClassesPackage.UML_CLASSIFIER__PACKAGE:
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
      case ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS:
        getSpecializations().clear();
        getSpecializations().addAll((Collection<? extends UMLGeneralization>)newValue);
        return;
      case ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS:
        getGeneralizations().clear();
        getGeneralizations().addAll((Collection<? extends UMLGeneralization>)newValue);
        return;
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS:
        getTemplateBindings().clear();
        getTemplateBindings().addAll((Collection<? extends UMLTemplateBinding>)newValue);
        return;
      case ClassesPackage.UML_CLASSIFIER__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
        return;
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS:
        getTemplateParameters().clear();
        getTemplateParameters().addAll((Collection<? extends UMLTemplateParameter>)newValue);
        return;
      case ClassesPackage.UML_CLASSIFIER__VISIBILITY:
        setVisibility((UMLVisibility)newValue);
        return;
      case ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS:
        getTargetedByAssociationEnds().clear();
        getTargetedByAssociationEnds().addAll((Collection<? extends UMLAssociationEnd>)newValue);
        return;
      case ClassesPackage.UML_CLASSIFIER__PACKAGE:
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
      case ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS:
        getSpecializations().clear();
        return;
      case ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS:
        getGeneralizations().clear();
        return;
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS:
        getTemplateBindings().clear();
        return;
      case ClassesPackage.UML_CLASSIFIER__STEREOTYPES:
        getStereotypes().clear();
        return;
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS:
        getTemplateParameters().clear();
        return;
      case ClassesPackage.UML_CLASSIFIER__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS:
        getTargetedByAssociationEnds().clear();
        return;
      case ClassesPackage.UML_CLASSIFIER__PACKAGE:
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
      case ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS:
        return specializations != null && !specializations.isEmpty();
      case ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS:
        return generalizations != null && !generalizations.isEmpty();
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS:
        return templateBindings != null && !templateBindings.isEmpty();
      case ClassesPackage.UML_CLASSIFIER__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
      case ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS:
        return templateParameters != null && !templateParameters.isEmpty();
      case ClassesPackage.UML_CLASSIFIER__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case ClassesPackage.UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS:
        return targetedByAssociationEnds != null && !targetedByAssociationEnds.isEmpty();
      case ClassesPackage.UML_CLASSIFIER__PACKAGE:
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
        case ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS: return ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS;
        case ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS: return ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS;
        default: return -1;
      }
    }
    if (baseClass == UMLBindingElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS: return ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS;
        default: return -1;
      }
    }
    if (baseClass == UMLStereotypeableElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_CLASSIFIER__STEREOTYPES: return CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES;
        default: return -1;
      }
    }
    if (baseClass == UMLTemplateableElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS: return ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS;
        default: return -1;
      }
    }
    if (baseClass == UMLVisibleElement.class)
    {
      switch (derivedFeatureID)
      {
        case ClassesPackage.UML_CLASSIFIER__VISIBILITY: return CorePackage.UML_VISIBLE_ELEMENT__VISIBILITY;
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
        case ClassesPackage.UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS: return ClassesPackage.UML_CLASSIFIER__SPECIALIZATIONS;
        case ClassesPackage.UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS: return ClassesPackage.UML_CLASSIFIER__GENERALIZATIONS;
        default: return -1;
      }
    }
    if (baseClass == UMLBindingElement.class)
    {
      switch (baseFeatureID)
      {
        case ClassesPackage.UML_BINDING_ELEMENT__TEMPLATE_BINDINGS: return ClassesPackage.UML_CLASSIFIER__TEMPLATE_BINDINGS;
        default: return -1;
      }
    }
    if (baseClass == UMLStereotypeableElement.class)
    {
      switch (baseFeatureID)
      {
        case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES: return ClassesPackage.UML_CLASSIFIER__STEREOTYPES;
        default: return -1;
      }
    }
    if (baseClass == UMLTemplateableElement.class)
    {
      switch (baseFeatureID)
      {
        case ClassesPackage.UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS: return ClassesPackage.UML_CLASSIFIER__TEMPLATE_PARAMETERS;
        default: return -1;
      }
    }
    if (baseClass == UMLVisibleElement.class)
    {
      switch (baseFeatureID)
      {
        case CorePackage.UML_VISIBLE_ELEMENT__VISIBILITY: return ClassesPackage.UML_CLASSIFIER__VISIBILITY;
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

} //UMLClassifierImpl

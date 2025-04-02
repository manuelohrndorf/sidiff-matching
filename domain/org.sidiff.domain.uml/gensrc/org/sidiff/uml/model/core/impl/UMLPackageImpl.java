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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.classes.ClassesPackage;
import org.sidiff.uml.model.classes.UMLAssociation;
import org.sidiff.uml.model.classes.UMLClassifier;
import org.sidiff.uml.model.classes.UMLEnumeration;
import org.sidiff.uml.model.classes.UMLPrimitiveType;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLComment;
import org.sidiff.uml.model.core.UMLModel;
import org.sidiff.uml.model.core.UMLPackage;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibility;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getSuperPackage <em>Super Package</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getStoredComments <em>Stored Comments</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getEnumerations <em>Enumerations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLPackageImpl#getPrimitiveTypes <em>Primitive Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLPackageImpl extends UMLNamedElementImpl implements UMLPackage
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
   * The cached value of the '{@link #getPackages() <em>Packages</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPackages()
   * @generated
   * @ordered
   */
  protected EList<UMLPackage> packages;

  /**
   * The cached value of the '{@link #getClassifiers() <em>Classifiers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClassifiers()
   * @generated
   * @ordered
   */
  protected EList<UMLClassifier> classifiers;

  /**
   * The cached value of the '{@link #getStoredComments() <em>Stored Comments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStoredComments()
   * @generated
   * @ordered
   */
  protected EList<UMLComment> storedComments;

  /**
   * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssociations()
   * @generated
   * @ordered
   */
  protected EList<UMLAssociation> associations;

  /**
   * The cached value of the '{@link #getEnumerations() <em>Enumerations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumerations()
   * @generated
   * @ordered
   */
  protected EList<UMLEnumeration> enumerations;

  /**
   * The cached value of the '{@link #getPrimitiveTypes() <em>Primitive Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrimitiveTypes()
   * @generated
   * @ordered
   */
  protected EList<UMLPrimitiveType> primitiveTypes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLPackageImpl()
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
    return CorePackage.Literals.UML_PACKAGE;
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
      stereotypes = new EObjectWithInverseResolvingEList.ManyInverse<UMLStereotype>(UMLStereotype.class, this, CorePackage.UML_PACKAGE__STEREOTYPES, CorePackage.UML_STEREOTYPE__STEREOTYPED_ELEMENTS);
    }
    return stereotypes;
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
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UML_PACKAGE__VISIBILITY, oldVisibility, visibility));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLModel getModel()
  {
    if (eContainerFeatureID() != CorePackage.UML_PACKAGE__MODEL) return null;
    return (UMLModel)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModel(UMLModel newModel, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newModel, CorePackage.UML_PACKAGE__MODEL, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModel(UMLModel newModel)
  {
    if (newModel != eInternalContainer() || (eContainerFeatureID() != CorePackage.UML_PACKAGE__MODEL && newModel != null))
    {
      if (EcoreUtil.isAncestor(this, newModel))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModel != null)
        msgs = ((InternalEObject)newModel).eInverseAdd(this, CorePackage.UML_MODEL__PACKAGES, UMLModel.class, msgs);
      msgs = basicSetModel(newModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UML_PACKAGE__MODEL, newModel, newModel));
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
      packages = new EObjectContainmentWithInverseEList<UMLPackage>(UMLPackage.class, this, CorePackage.UML_PACKAGE__PACKAGES, CorePackage.UML_PACKAGE__SUPER_PACKAGE);
    }
    return packages;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLPackage getSuperPackage()
  {
    if (eContainerFeatureID() != CorePackage.UML_PACKAGE__SUPER_PACKAGE) return null;
    return (UMLPackage)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSuperPackage(UMLPackage newSuperPackage, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newSuperPackage, CorePackage.UML_PACKAGE__SUPER_PACKAGE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSuperPackage(UMLPackage newSuperPackage)
  {
    if (newSuperPackage != eInternalContainer() || (eContainerFeatureID() != CorePackage.UML_PACKAGE__SUPER_PACKAGE && newSuperPackage != null))
    {
      if (EcoreUtil.isAncestor(this, newSuperPackage))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSuperPackage != null)
        msgs = ((InternalEObject)newSuperPackage).eInverseAdd(this, CorePackage.UML_PACKAGE__PACKAGES, UMLPackage.class, msgs);
      msgs = basicSetSuperPackage(newSuperPackage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UML_PACKAGE__SUPER_PACKAGE, newSuperPackage, newSuperPackage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLClassifier> getClassifiers()
  {
    if (classifiers == null)
    {
      classifiers = new EObjectContainmentWithInverseEList<UMLClassifier>(UMLClassifier.class, this, CorePackage.UML_PACKAGE__CLASSIFIERS, ClassesPackage.UML_CLASSIFIER__PACKAGE);
    }
    return classifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLComment> getStoredComments()
  {
    if (storedComments == null)
    {
      storedComments = new EObjectContainmentWithInverseEList<UMLComment>(UMLComment.class, this, CorePackage.UML_PACKAGE__STORED_COMMENTS, CorePackage.UML_COMMENT__PACKAGE);
    }
    return storedComments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLAssociation> getAssociations()
  {
    if (associations == null)
    {
      associations = new EObjectContainmentWithInverseEList<UMLAssociation>(UMLAssociation.class, this, CorePackage.UML_PACKAGE__ASSOCIATIONS, ClassesPackage.UML_ASSOCIATION__PACKAGE);
    }
    return associations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLEnumeration> getEnumerations()
  {
    if (enumerations == null)
    {
      enumerations = new EObjectContainmentWithInverseEList<UMLEnumeration>(UMLEnumeration.class, this, CorePackage.UML_PACKAGE__ENUMERATIONS, ClassesPackage.UML_ENUMERATION__PACKAGE);
    }
    return enumerations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLPrimitiveType> getPrimitiveTypes()
  {
    if (primitiveTypes == null)
    {
      primitiveTypes = new EObjectContainmentWithInverseEList<UMLPrimitiveType>(UMLPrimitiveType.class, this, CorePackage.UML_PACKAGE__PRIMITIVE_TYPES, ClassesPackage.UML_PRIMITIVE_TYPE__PACKAGE);
    }
    return primitiveTypes;
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
      case CorePackage.UML_PACKAGE__STEREOTYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStereotypes()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__MODEL:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetModel((UMLModel)otherEnd, msgs);
      case CorePackage.UML_PACKAGE__PACKAGES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getPackages()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__SUPER_PACKAGE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetSuperPackage((UMLPackage)otherEnd, msgs);
      case CorePackage.UML_PACKAGE__CLASSIFIERS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassifiers()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__STORED_COMMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getStoredComments()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__ASSOCIATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociations()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__ENUMERATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnumerations()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__PRIMITIVE_TYPES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrimitiveTypes()).basicAdd(otherEnd, msgs);
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
      case CorePackage.UML_PACKAGE__STEREOTYPES:
        return ((InternalEList<?>)getStereotypes()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__MODEL:
        return basicSetModel(null, msgs);
      case CorePackage.UML_PACKAGE__PACKAGES:
        return ((InternalEList<?>)getPackages()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__SUPER_PACKAGE:
        return basicSetSuperPackage(null, msgs);
      case CorePackage.UML_PACKAGE__CLASSIFIERS:
        return ((InternalEList<?>)getClassifiers()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__STORED_COMMENTS:
        return ((InternalEList<?>)getStoredComments()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__ASSOCIATIONS:
        return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__ENUMERATIONS:
        return ((InternalEList<?>)getEnumerations()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_PACKAGE__PRIMITIVE_TYPES:
        return ((InternalEList<?>)getPrimitiveTypes()).basicRemove(otherEnd, msgs);
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
      case CorePackage.UML_PACKAGE__MODEL:
        return eInternalContainer().eInverseRemove(this, CorePackage.UML_MODEL__PACKAGES, UMLModel.class, msgs);
      case CorePackage.UML_PACKAGE__SUPER_PACKAGE:
        return eInternalContainer().eInverseRemove(this, CorePackage.UML_PACKAGE__PACKAGES, UMLPackage.class, msgs);
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
      case CorePackage.UML_PACKAGE__STEREOTYPES:
        return getStereotypes();
      case CorePackage.UML_PACKAGE__VISIBILITY:
        return getVisibility();
      case CorePackage.UML_PACKAGE__MODEL:
        return getModel();
      case CorePackage.UML_PACKAGE__PACKAGES:
        return getPackages();
      case CorePackage.UML_PACKAGE__SUPER_PACKAGE:
        return getSuperPackage();
      case CorePackage.UML_PACKAGE__CLASSIFIERS:
        return getClassifiers();
      case CorePackage.UML_PACKAGE__STORED_COMMENTS:
        return getStoredComments();
      case CorePackage.UML_PACKAGE__ASSOCIATIONS:
        return getAssociations();
      case CorePackage.UML_PACKAGE__ENUMERATIONS:
        return getEnumerations();
      case CorePackage.UML_PACKAGE__PRIMITIVE_TYPES:
        return getPrimitiveTypes();
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
      case CorePackage.UML_PACKAGE__STEREOTYPES:
        getStereotypes().clear();
        getStereotypes().addAll((Collection<? extends UMLStereotype>)newValue);
        return;
      case CorePackage.UML_PACKAGE__VISIBILITY:
        setVisibility((UMLVisibility)newValue);
        return;
      case CorePackage.UML_PACKAGE__MODEL:
        setModel((UMLModel)newValue);
        return;
      case CorePackage.UML_PACKAGE__PACKAGES:
        getPackages().clear();
        getPackages().addAll((Collection<? extends UMLPackage>)newValue);
        return;
      case CorePackage.UML_PACKAGE__SUPER_PACKAGE:
        setSuperPackage((UMLPackage)newValue);
        return;
      case CorePackage.UML_PACKAGE__CLASSIFIERS:
        getClassifiers().clear();
        getClassifiers().addAll((Collection<? extends UMLClassifier>)newValue);
        return;
      case CorePackage.UML_PACKAGE__STORED_COMMENTS:
        getStoredComments().clear();
        getStoredComments().addAll((Collection<? extends UMLComment>)newValue);
        return;
      case CorePackage.UML_PACKAGE__ASSOCIATIONS:
        getAssociations().clear();
        getAssociations().addAll((Collection<? extends UMLAssociation>)newValue);
        return;
      case CorePackage.UML_PACKAGE__ENUMERATIONS:
        getEnumerations().clear();
        getEnumerations().addAll((Collection<? extends UMLEnumeration>)newValue);
        return;
      case CorePackage.UML_PACKAGE__PRIMITIVE_TYPES:
        getPrimitiveTypes().clear();
        getPrimitiveTypes().addAll((Collection<? extends UMLPrimitiveType>)newValue);
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
      case CorePackage.UML_PACKAGE__STEREOTYPES:
        getStereotypes().clear();
        return;
      case CorePackage.UML_PACKAGE__VISIBILITY:
        setVisibility(VISIBILITY_EDEFAULT);
        return;
      case CorePackage.UML_PACKAGE__MODEL:
        setModel((UMLModel)null);
        return;
      case CorePackage.UML_PACKAGE__PACKAGES:
        getPackages().clear();
        return;
      case CorePackage.UML_PACKAGE__SUPER_PACKAGE:
        setSuperPackage((UMLPackage)null);
        return;
      case CorePackage.UML_PACKAGE__CLASSIFIERS:
        getClassifiers().clear();
        return;
      case CorePackage.UML_PACKAGE__STORED_COMMENTS:
        getStoredComments().clear();
        return;
      case CorePackage.UML_PACKAGE__ASSOCIATIONS:
        getAssociations().clear();
        return;
      case CorePackage.UML_PACKAGE__ENUMERATIONS:
        getEnumerations().clear();
        return;
      case CorePackage.UML_PACKAGE__PRIMITIVE_TYPES:
        getPrimitiveTypes().clear();
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
      case CorePackage.UML_PACKAGE__STEREOTYPES:
        return stereotypes != null && !stereotypes.isEmpty();
      case CorePackage.UML_PACKAGE__VISIBILITY:
        return visibility != VISIBILITY_EDEFAULT;
      case CorePackage.UML_PACKAGE__MODEL:
        return getModel() != null;
      case CorePackage.UML_PACKAGE__PACKAGES:
        return packages != null && !packages.isEmpty();
      case CorePackage.UML_PACKAGE__SUPER_PACKAGE:
        return getSuperPackage() != null;
      case CorePackage.UML_PACKAGE__CLASSIFIERS:
        return classifiers != null && !classifiers.isEmpty();
      case CorePackage.UML_PACKAGE__STORED_COMMENTS:
        return storedComments != null && !storedComments.isEmpty();
      case CorePackage.UML_PACKAGE__ASSOCIATIONS:
        return associations != null && !associations.isEmpty();
      case CorePackage.UML_PACKAGE__ENUMERATIONS:
        return enumerations != null && !enumerations.isEmpty();
      case CorePackage.UML_PACKAGE__PRIMITIVE_TYPES:
        return primitiveTypes != null && !primitiveTypes.isEmpty();
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
        case CorePackage.UML_PACKAGE__STEREOTYPES: return CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES;
        default: return -1;
      }
    }
    if (baseClass == UMLVisibleElement.class)
    {
      switch (derivedFeatureID)
      {
        case CorePackage.UML_PACKAGE__VISIBILITY: return CorePackage.UML_VISIBLE_ELEMENT__VISIBILITY;
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
        case CorePackage.UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES: return CorePackage.UML_PACKAGE__STEREOTYPES;
        default: return -1;
      }
    }
    if (baseClass == UMLVisibleElement.class)
    {
      switch (baseFeatureID)
      {
        case CorePackage.UML_VISIBLE_ELEMENT__VISIBILITY: return CorePackage.UML_PACKAGE__VISIBILITY;
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

} //UMLPackageImpl

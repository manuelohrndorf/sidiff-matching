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
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLDependency;
import org.sidiff.uml.model.core.UMLNamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLNamedElementImpl#getOutgoingDependencies <em>Outgoing Dependencies</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLNamedElementImpl#getDependees <em>Dependees</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.impl.UMLNamedElementImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UMLNamedElementImpl extends UMLElementImpl implements UMLNamedElement
{
  /**
   * The cached value of the '{@link #getOutgoingDependencies() <em>Outgoing Dependencies</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingDependencies()
   * @generated
   * @ordered
   */
  protected EList<UMLDependency> outgoingDependencies;

  /**
   * The cached value of the '{@link #getDependees() <em>Dependees</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDependees()
   * @generated
   * @ordered
   */
  protected EList<UMLDependency> dependees;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UMLNamedElementImpl()
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
    return CorePackage.Literals.UML_NAMED_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLDependency> getOutgoingDependencies()
  {
    if (outgoingDependencies == null)
    {
      outgoingDependencies = new EObjectContainmentWithInverseEList<UMLDependency>(UMLDependency.class, this, CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES, CorePackage.UML_DEPENDENCY__DEPENDEE);
    }
    return outgoingDependencies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UMLDependency> getDependees()
  {
    if (dependees == null)
    {
      dependees = new EObjectWithInverseResolvingEList<UMLDependency>(UMLDependency.class, this, CorePackage.UML_NAMED_ELEMENT__DEPENDEES, CorePackage.UML_DEPENDENCY__SUPPLIER);
    }
    return dependees;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.UML_NAMED_ELEMENT__NAME, oldName, name));
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
      case CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingDependencies()).basicAdd(otherEnd, msgs);
      case CorePackage.UML_NAMED_ELEMENT__DEPENDEES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependees()).basicAdd(otherEnd, msgs);
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
      case CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES:
        return ((InternalEList<?>)getOutgoingDependencies()).basicRemove(otherEnd, msgs);
      case CorePackage.UML_NAMED_ELEMENT__DEPENDEES:
        return ((InternalEList<?>)getDependees()).basicRemove(otherEnd, msgs);
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
      case CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES:
        return getOutgoingDependencies();
      case CorePackage.UML_NAMED_ELEMENT__DEPENDEES:
        return getDependees();
      case CorePackage.UML_NAMED_ELEMENT__NAME:
        return getName();
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
      case CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES:
        getOutgoingDependencies().clear();
        getOutgoingDependencies().addAll((Collection<? extends UMLDependency>)newValue);
        return;
      case CorePackage.UML_NAMED_ELEMENT__DEPENDEES:
        getDependees().clear();
        getDependees().addAll((Collection<? extends UMLDependency>)newValue);
        return;
      case CorePackage.UML_NAMED_ELEMENT__NAME:
        setName((String)newValue);
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
      case CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES:
        getOutgoingDependencies().clear();
        return;
      case CorePackage.UML_NAMED_ELEMENT__DEPENDEES:
        getDependees().clear();
        return;
      case CorePackage.UML_NAMED_ELEMENT__NAME:
        setName(NAME_EDEFAULT);
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
      case CorePackage.UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES:
        return outgoingDependencies != null && !outgoingDependencies.isEmpty();
      case CorePackage.UML_NAMED_ELEMENT__DEPENDEES:
        return dependees != null && !dependees.isEmpty();
      case CorePackage.UML_NAMED_ELEMENT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
    }
    return super.eIsSet(featureID);
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //UMLNamedElementImpl

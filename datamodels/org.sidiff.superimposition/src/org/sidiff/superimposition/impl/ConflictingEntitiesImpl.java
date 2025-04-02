/**
 * (c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.superimposition.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimpositionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflicting Entities</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl#getConflictSet <em>Conflict Set</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl#getEntities <em>Entities</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl#getReferences <em>References</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConflictingEntitiesImpl extends MinimalEObjectImpl.Container implements ConflictingEntities {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected SuperimposedElement context;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature type;

	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap entities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictingEntitiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SuperimpositionModelPackage.Literals.CONFLICTING_ENTITIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureMap getEntities() {
		if (entities == null) {
			entities = new BasicFeatureMap(this, SuperimpositionModelPackage.CONFLICTING_ENTITIES__ENTITIES);
		}
		return entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Reference> getReferences() {
		return getEntities().list(SuperimpositionModelPackage.Literals.CONFLICTING_ENTITIES__REFERENCES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element> getElements() {
		return getEntities().list(SuperimpositionModelPackage.Literals.CONFLICTING_ENTITIES__ELEMENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getAttributes() {
		return getEntities().list(SuperimpositionModelPackage.Literals.CONFLICTING_ENTITIES__ATTRIBUTES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuperimposedElement getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = (SuperimposedElement)eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperimposedElement basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContext(SuperimposedElement newContext) {
		SuperimposedElement oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictSet getConflictSet() {
		if (eContainerFeatureID() != SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET) return null;
		return (ConflictSet)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConflictSet(ConflictSet newConflictSet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConflictSet, SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConflictSet(ConflictSet newConflictSet) {
		if (newConflictSet != eInternalContainer() || (eContainerFeatureID() != SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET && newConflictSet != null)) {
			if (EcoreUtil.isAncestor(this, newConflictSet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConflictSet != null)
				msgs = ((InternalEObject)newConflictSet).eInverseAdd(this, SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING, ConflictSet.class, msgs);
			msgs = basicSetConflictSet(newConflictSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET, newConflictSet, newConflictSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EStructuralFeature getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EStructuralFeature)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SuperimpositionModelPackage.CONFLICTING_ENTITIES__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EStructuralFeature newType) {
		EStructuralFeature oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICTING_ENTITIES__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Attribute> getAttributes(final EAttribute type) {
		return getAttributes().stream()
			.filter(a -> a.getType().equals(type))
			.collect(Collectors.toCollection(BasicEList::new));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Reference> getReferences(final EReference type) {
		return getReferences().stream()
			.filter(r -> r.getType().equals(type))
			.collect(Collectors.toCollection(BasicEList::new));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Element> getElements(final EClass type) {
		return getElements().stream()
			.filter(e -> type.isSuperTypeOf(e.getType()))
			.collect(Collectors.toCollection(BasicEList::new));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean isInvalidated() {
		return (getContext() != null && !getConflictSet().getContext().getElements().contains(getContext()))
			|| getElements().stream().anyMatch(e -> !getConflictSet().getContext().getElements().contains(e))
			|| getReferences().stream().anyMatch(r ->
					r.getSource() == null || r.getTarget() == null
						|| !getConflictSet().getContext().getElements().contains(r.getSource())
						|| !getConflictSet().getContext().getElements().contains(r.getTarget()))
			|| getAttributes().stream().anyMatch(a ->
					a.getContainer() == null
						|| !getConflictSet().getContext().getElements().contains(a.getContainer()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public int getNumberOfConflictingFeatures() {
		if(getType() instanceof EAttribute) {
			return getAttributes().stream()
				.filter(a -> a.getType().equals(getType()))
				.mapToInt(attr -> attr.getValue().size())
				.sum();
		} else if(getType() instanceof EReference) {
			final boolean noElements = getElements().isEmpty();
			return (int)getReferences().stream()
				.filter(r -> r.getType().equals(getType()))
				.filter(r -> noElements || getElements().contains(r.getTarget()))
				.count();
		}
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConflictSet((ConflictSet)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET:
				return basicSetConflictSet(null, msgs);
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ENTITIES:
				return ((InternalEList<?>)getEntities()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET:
				return eInternalContainer().eInverseRemove(this, SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING, ConflictSet.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET:
				return getConflictSet();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ENTITIES:
				if (coreType) return getEntities();
				return ((FeatureMap.Internal)getEntities()).getWrapper();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__REFERENCES:
				return getReferences();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ELEMENTS:
				return getElements();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ATTRIBUTES:
				return getAttributes();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONTEXT:
				setContext((SuperimposedElement)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET:
				setConflictSet((ConflictSet)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__TYPE:
				setType((EStructuralFeature)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ENTITIES:
				((FeatureMap.Internal)getEntities()).set(newValue);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Reference>)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends Element>)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONTEXT:
				setContext((SuperimposedElement)null);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET:
				setConflictSet((ConflictSet)null);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__TYPE:
				setType((EStructuralFeature)null);
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ENTITIES:
				getEntities().clear();
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__REFERENCES:
				getReferences().clear();
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ELEMENTS:
				getElements().clear();
				return;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ATTRIBUTES:
				getAttributes().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONTEXT:
				return context != null;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET:
				return getConflictSet() != null;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__TYPE:
				return type != null;
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ENTITIES:
				return entities != null && !entities.isEmpty();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__REFERENCES:
				return !getReferences().isEmpty();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ELEMENTS:
				return !getElements().isEmpty();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES__ATTRIBUTES:
				return !getAttributes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES___GET_ATTRIBUTES__EATTRIBUTE:
				return getAttributes((EAttribute)arguments.get(0));
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES___GET_REFERENCES__EREFERENCE:
				return getReferences((EReference)arguments.get(0));
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES___GET_ELEMENTS__ECLASS:
				return getElements((EClass)arguments.get(0));
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES___IS_INVALIDATED:
				return isInvalidated();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES___GET_NUMBER_OF_CONFLICTING_FEATURES:
				return getNumberOfConflictingFeatures();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (entities: ");
		result.append(entities);
		result.append(')');
		return result.toString();
	}

} //ConflictingEntitiesImpl

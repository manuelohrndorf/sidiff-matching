/**
 */
package org.sidiff.superimposition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Reference;
import org.sidiff.entities.impl.ElementImpl;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimpositionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Superimposed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedElementImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedElementImpl#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedElementImpl#getOwnedReferences <em>Owned References</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedElementImpl#getObjectAnnotations <em>Object Annotations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SuperimposedElementImpl extends ElementImpl implements SuperimposedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";
	/**
	 * The cached value of the '{@link #getObjects() <em>Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> objects;
	/**
	 * The cached value of the '{@link #getOwnedAttributes() <em>Owned Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> ownedAttributes;
	/**
	 * The cached value of the '{@link #getOwnedReferences() <em>Owned References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference> ownedReferences;
	/**
	 * The cached value of the '{@link #getObjectAnnotations() <em>Object Annotations</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, EList<Annotation>> objectAnnotations;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuperimposedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getObjects() {
		if (objects == null) {
			objects = new EObjectResolvingEList<EObject>(EObject.class, this, SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECTS);
		}
		return objects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getOwnedAttributes() {
		if (ownedAttributes == null) {
			ownedAttributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES);
		}
		return ownedAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Reference> getOwnedReferences() {
		if (ownedReferences == null) {
			ownedReferences = new EObjectContainmentEList<Reference>(Reference.class, this, SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES);
		}
		return ownedReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<EObject, EList<Annotation>> getObjectAnnotations() {
		if (objectAnnotations == null) {
			objectAnnotations = new EcoreEMap<EObject,EList<Annotation>>(SuperimpositionModelPackage.Literals.EOBJECT_TO_ANNOTATIONS_MAP_ENTRY, EObjectToAnnotationsMapEntryImpl.class, this, SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS);
		}
		return objectAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public SuperimposedElement getContainer() {
		return getIncomings().stream()
				.filter(Reference::isContainment)
				.map(Reference::getSource)
				.filter(SuperimposedElement.class::isInstance)
				.map(SuperimposedElement.class::cast)
				.findFirst().orElse(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<SuperimposedElement> getContained() {
		return getOutgoings()
				.stream()
				.filter(Reference::isContainment)
				.map(Reference::getTarget)
				.filter(SuperimposedElement.class::isInstance)
				.map(SuperimposedElement.class::cast)
				.collect(Collectors.toCollection(BasicEList::new));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES:
				return ((InternalEList<?>)getOwnedAttributes()).basicRemove(otherEnd, msgs);
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES:
				return ((InternalEList<?>)getOwnedReferences()).basicRemove(otherEnd, msgs);
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS:
				return ((InternalEList<?>)getObjectAnnotations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECTS:
				return getObjects();
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES:
				return getOwnedAttributes();
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES:
				return getOwnedReferences();
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS:
				if (coreType) return getObjectAnnotations();
				else return getObjectAnnotations().map();
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
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECTS:
				getObjects().clear();
				getObjects().addAll((Collection<? extends EObject>)newValue);
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES:
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES:
				getOwnedReferences().clear();
				getOwnedReferences().addAll((Collection<? extends Reference>)newValue);
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS:
				((EStructuralFeature.Setting)getObjectAnnotations()).set(newValue);
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
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECTS:
				getObjects().clear();
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES:
				getOwnedAttributes().clear();
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES:
				getOwnedReferences().clear();
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS:
				getObjectAnnotations().clear();
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
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECTS:
				return objects != null && !objects.isEmpty();
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES:
				return ownedAttributes != null && !ownedAttributes.isEmpty();
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES:
				return ownedReferences != null && !ownedReferences.isEmpty();
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS:
				return objectAnnotations != null && !objectAnnotations.isEmpty();
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
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT___GET_CONTAINER:
				return getContainer();
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT___GET_CONTAINED:
				return getContained();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SuperimposedElementImpl

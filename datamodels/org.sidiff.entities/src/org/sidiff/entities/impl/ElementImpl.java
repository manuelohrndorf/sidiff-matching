/**
 */
package org.sidiff.entities.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.entities.IdentifiableEntity;
import org.sidiff.entities.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.entities.impl.ElementImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link org.sidiff.entities.impl.ElementImpl#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.sidiff.entities.impl.ElementImpl#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link org.sidiff.entities.impl.ElementImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.sidiff.entities.impl.ElementImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.sidiff.entities.impl.ElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.entities.impl.ElementImpl#isExternal <em>External</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementImpl extends EntityImpl implements Element {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Dennis Reuling, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutgoings() <em>Outgoings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoings()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference> outgoings;

	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference> incomings;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EObject object;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The default value of the '{@link #isExternal() <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTERNAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExternal() <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExternal()
	 * @generated
	 * @ordered
	 */
	protected boolean external = EXTERNAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EntitiesPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Reference> getOutgoings() {
		if (outgoings == null) {
			outgoings = new EObjectWithInverseResolvingEList<Reference>(Reference.class, this, EntitiesPackage.ELEMENT__OUTGOINGS, EntitiesPackage.REFERENCE__SOURCE);
		}
		return outgoings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Reference> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectWithInverseResolvingEList<Reference>(Reference.class, this, EntitiesPackage.ELEMENT__INCOMINGS, EntitiesPackage.REFERENCE__TARGET);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectWithInverseResolvingEList<Attribute>(Attribute.class, this, EntitiesPackage.ELEMENT__ATTRIBUTES, EntitiesPackage.ATTRIBUTE__CONTAINER);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EntitiesPackage.ELEMENT__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObject(EObject newObject) {
		EObject oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.ELEMENT__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUuid() {
		return uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUuid(String newUuid) {
		String oldUuid = uuid;
		uuid = newUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.ELEMENT__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClass)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EntitiesPackage.ELEMENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isExternal() {
		return external;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExternal(boolean newExternal) {
		boolean oldExternal = external;
		external = newExternal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EntitiesPackage.ELEMENT__EXTERNAL, oldExternal, external));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Attribute> getAttributes(final EAttribute type) {
		return getAttributes().stream().filter(a -> Objects.equals(a.getType(), type)).collect(Collectors.toCollection(BasicEList::new));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Reference> getReferences(final EReference type) {
		return Stream.concat(getIncomings().stream(), getOutgoings().stream()).filter(r -> Objects.equals(r.getType(), type)).collect(Collectors.toCollection(BasicEList::new));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void updateExternal() {
		EObject eObject = getObject();
		if(eObject != null) {
			URI modelUri = EcoreUtil.getURI(eObject).trimFragment();
			if(modelUri.isPlatform()) {
				setExternal(isGenModelExtern(modelUri.trimFileExtension().appendFileExtension("genmodel")));
			} else if("pathmap".equals(modelUri.scheme())) {
				// UML pathmap is always external
				setExternal(true);
			} else {
				setExternal(EPackage.Registry.INSTANCE.containsKey(modelUri.toString()));
			}
		} else {
			setExternal(false);
		}
	}

	/**
	 * Caches the result of {@link EcorePlugin#getEPackageNsURIToGenModelLocationMap(boolean)}
	 * for either boolean value.
	 * @generated NOT
	 */
	private static Map<Boolean,Map<String,URI>> platformGenModelCache = new HashMap<>();
	
	/**
	 * Cache that saves whether a GenModel URI is external,
	 * reverse map for {@link EcorePlugin#getEPackageNsURIToGenModelLocationMap(boolean)}.
	 * @generated NOT
	 */
	private static Map<URI,Boolean> genModelExternalCache = new HashMap<>();

	/**
	 * Returns whether the GenModel platform URI is mapped to a registered EPackage,
	 * i.e. refers to an external resource.
	 * @param the URI of the GenModel
	 * @return <code>true</code> if external, <code>false</code> otherwise
	 * @generated NOT
	 */
	private static boolean isGenModelExtern(URI genModelUri) {
		Assert.isLegal(genModelUri.isPlatformPlugin() || genModelUri.isPlatformResource());
		final boolean targetPlatform = genModelUri.isPlatformResource();
		synchronized(genModelExternalCache) {
			// because both EcorePlugin.getEPackageNsURIToGenModelLocationMap() and
			// map.containsValue(uri) are very inefficient, we cache the results of both in two maps
			return genModelExternalCache.computeIfAbsent(
					genModelUri, platformGenModelCache.computeIfAbsent(
							targetPlatform, EcorePlugin::getEPackageNsURIToGenModelLocationMap)::containsValue);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EntitiesPackage.ELEMENT__OUTGOINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoings()).basicAdd(otherEnd, msgs);
			case EntitiesPackage.ELEMENT__INCOMINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomings()).basicAdd(otherEnd, msgs);
			case EntitiesPackage.ELEMENT__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
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
			case EntitiesPackage.ELEMENT__OUTGOINGS:
				return ((InternalEList<?>)getOutgoings()).basicRemove(otherEnd, msgs);
			case EntitiesPackage.ELEMENT__INCOMINGS:
				return ((InternalEList<?>)getIncomings()).basicRemove(otherEnd, msgs);
			case EntitiesPackage.ELEMENT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case EntitiesPackage.ELEMENT__UUID:
				return getUuid();
			case EntitiesPackage.ELEMENT__OUTGOINGS:
				return getOutgoings();
			case EntitiesPackage.ELEMENT__INCOMINGS:
				return getIncomings();
			case EntitiesPackage.ELEMENT__ATTRIBUTES:
				return getAttributes();
			case EntitiesPackage.ELEMENT__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
			case EntitiesPackage.ELEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case EntitiesPackage.ELEMENT__EXTERNAL:
				return isExternal();
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
			case EntitiesPackage.ELEMENT__UUID:
				setUuid((String)newValue);
				return;
			case EntitiesPackage.ELEMENT__OUTGOINGS:
				getOutgoings().clear();
				getOutgoings().addAll((Collection<? extends Reference>)newValue);
				return;
			case EntitiesPackage.ELEMENT__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends Reference>)newValue);
				return;
			case EntitiesPackage.ELEMENT__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case EntitiesPackage.ELEMENT__OBJECT:
				setObject((EObject)newValue);
				return;
			case EntitiesPackage.ELEMENT__TYPE:
				setType((EClass)newValue);
				return;
			case EntitiesPackage.ELEMENT__EXTERNAL:
				setExternal((Boolean)newValue);
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
			case EntitiesPackage.ELEMENT__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case EntitiesPackage.ELEMENT__OUTGOINGS:
				getOutgoings().clear();
				return;
			case EntitiesPackage.ELEMENT__INCOMINGS:
				getIncomings().clear();
				return;
			case EntitiesPackage.ELEMENT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case EntitiesPackage.ELEMENT__OBJECT:
				setObject((EObject)null);
				return;
			case EntitiesPackage.ELEMENT__TYPE:
				setType((EClass)null);
				return;
			case EntitiesPackage.ELEMENT__EXTERNAL:
				setExternal(EXTERNAL_EDEFAULT);
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
			case EntitiesPackage.ELEMENT__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case EntitiesPackage.ELEMENT__OUTGOINGS:
				return outgoings != null && !outgoings.isEmpty();
			case EntitiesPackage.ELEMENT__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
			case EntitiesPackage.ELEMENT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case EntitiesPackage.ELEMENT__OBJECT:
				return object != null;
			case EntitiesPackage.ELEMENT__TYPE:
				return type != null;
			case EntitiesPackage.ELEMENT__EXTERNAL:
				return external != EXTERNAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IdentifiableEntity.class) {
			switch (derivedFeatureID) {
				case EntitiesPackage.ELEMENT__UUID: return EntitiesPackage.IDENTIFIABLE_ENTITY__UUID;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IdentifiableEntity.class) {
			switch (baseFeatureID) {
				case EntitiesPackage.IDENTIFIABLE_ENTITY__UUID: return EntitiesPackage.ELEMENT__UUID;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EntitiesPackage.ELEMENT___GET_ATTRIBUTES__EATTRIBUTE:
				return getAttributes((EAttribute)arguments.get(0));
			case EntitiesPackage.ELEMENT___GET_REFERENCES__EREFERENCE:
				return getReferences((EReference)arguments.get(0));
			case EntitiesPackage.ELEMENT___UPDATE_EXTERNAL:
				updateExternal();
				return null;
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
		result.append(" (uuid: ");
		result.append(uuid);
		result.append(", external: ");
		result.append(external);
		result.append(')');
		return result.toString();
	}

} //ElementImpl

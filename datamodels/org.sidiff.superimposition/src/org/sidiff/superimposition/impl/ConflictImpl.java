/**
 * (c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.superimposition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictSeverity;
import org.sidiff.superimposition.ConflictType;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimpositionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictImpl#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictImpl#getConflicting <em>Conflicting</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictImpl#getConflictSet <em>Conflict Set</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConflictImpl extends MinimalEObjectImpl.Container implements Conflict {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final ConflictSeverity SEVERITY_EDEFAULT = ConflictSeverity.ERROR;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected ConflictSeverity severity = SEVERITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConflicting() <em>Conflicting</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConflicting()
	 * @generated
	 * @ordered
	 */
	protected EList<ConflictingEntities> conflicting;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ConflictType TYPE_EDEFAULT = ConflictType.UNSPECIFIED;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ConflictType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SuperimpositionModelPackage.Literals.CONFLICT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICT__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictSeverity getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSeverity(ConflictSeverity newSeverity) {
		ConflictSeverity oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICT__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConflictingEntities> getConflicting() {
		if (conflicting == null) {
			conflicting = new EObjectResolvingEList<ConflictingEntities>(ConflictingEntities.class, this, SuperimpositionModelPackage.CONFLICT__CONFLICTING);
		}
		return conflicting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictSet getConflictSet() {
		if (eContainerFeatureID() != SuperimpositionModelPackage.CONFLICT__CONFLICT_SET) return null;
		return (ConflictSet)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConflictSet(ConflictSet newConflictSet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConflictSet, SuperimpositionModelPackage.CONFLICT__CONFLICT_SET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConflictSet(ConflictSet newConflictSet) {
		if (newConflictSet != eInternalContainer() || (eContainerFeatureID() != SuperimpositionModelPackage.CONFLICT__CONFLICT_SET && newConflictSet != null)) {
			if (EcoreUtil.isAncestor(this, newConflictSet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConflictSet != null)
				msgs = ((InternalEObject)newConflictSet).eInverseAdd(this, SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS, ConflictSet.class, msgs);
			msgs = basicSetConflictSet(newConflictSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICT__CONFLICT_SET, newConflictSet, newConflictSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(ConflictType newType) {
		ConflictType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SuperimpositionModelPackage.CONFLICT__CONFLICT_SET:
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
			case SuperimpositionModelPackage.CONFLICT__CONFLICT_SET:
				return basicSetConflictSet(null, msgs);
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
			case SuperimpositionModelPackage.CONFLICT__CONFLICT_SET:
				return eInternalContainer().eInverseRemove(this, SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS, ConflictSet.class, msgs);
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
			case SuperimpositionModelPackage.CONFLICT__ID:
				return getId();
			case SuperimpositionModelPackage.CONFLICT__MESSAGE:
				return getMessage();
			case SuperimpositionModelPackage.CONFLICT__SEVERITY:
				return getSeverity();
			case SuperimpositionModelPackage.CONFLICT__CONFLICTING:
				return getConflicting();
			case SuperimpositionModelPackage.CONFLICT__CONFLICT_SET:
				return getConflictSet();
			case SuperimpositionModelPackage.CONFLICT__TYPE:
				return getType();
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
			case SuperimpositionModelPackage.CONFLICT__ID:
				setId((String)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICT__MESSAGE:
				setMessage((String)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICT__SEVERITY:
				setSeverity((ConflictSeverity)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICT__CONFLICTING:
				getConflicting().clear();
				getConflicting().addAll((Collection<? extends ConflictingEntities>)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICT__CONFLICT_SET:
				setConflictSet((ConflictSet)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICT__TYPE:
				setType((ConflictType)newValue);
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
			case SuperimpositionModelPackage.CONFLICT__ID:
				setId(ID_EDEFAULT);
				return;
			case SuperimpositionModelPackage.CONFLICT__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case SuperimpositionModelPackage.CONFLICT__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
				return;
			case SuperimpositionModelPackage.CONFLICT__CONFLICTING:
				getConflicting().clear();
				return;
			case SuperimpositionModelPackage.CONFLICT__CONFLICT_SET:
				setConflictSet((ConflictSet)null);
				return;
			case SuperimpositionModelPackage.CONFLICT__TYPE:
				setType(TYPE_EDEFAULT);
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
			case SuperimpositionModelPackage.CONFLICT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SuperimpositionModelPackage.CONFLICT__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case SuperimpositionModelPackage.CONFLICT__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
			case SuperimpositionModelPackage.CONFLICT__CONFLICTING:
				return conflicting != null && !conflicting.isEmpty();
			case SuperimpositionModelPackage.CONFLICT__CONFLICT_SET:
				return getConflictSet() != null;
			case SuperimpositionModelPackage.CONFLICT__TYPE:
				return type != TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", message: ");
		result.append(message);
		result.append(", severity: ");
		result.append(severity);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ConflictImpl

/**
 * (c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.superimposition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictSeverity;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conflict Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictSetImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictSetImpl#getConflicting <em>Conflicting</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictSetImpl#getConflicts <em>Conflicts</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.ConflictSetImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConflictSetImpl extends MinimalEObjectImpl.Container implements ConflictSet {
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
	protected SuperimposedModel context;

	/**
	 * The cached value of the '{@link #getConflicting() <em>Conflicting</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConflicting()
	 * @generated
	 * @ordered
	 */
	protected EList<ConflictingEntities> conflicting;

	/**
	 * The cached value of the '{@link #getConflicts() <em>Conflicts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConflicts()
	 * @generated
	 * @ordered
	 */
	protected EList<Conflict> conflicts;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<ConflictingEntities> inputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConflictSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SuperimpositionModelPackage.Literals.CONFLICT_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuperimposedModel getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = (SuperimposedModel)eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SuperimpositionModelPackage.CONFLICT_SET__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperimposedModel basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContext(SuperimposedModel newContext) {
		SuperimposedModel oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SuperimpositionModelPackage.CONFLICT_SET__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConflictingEntities> getConflicting() {
		if (conflicting == null) {
			conflicting = new EObjectContainmentWithInverseEList<ConflictingEntities>(ConflictingEntities.class, this, SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING, SuperimpositionModelPackage.CONFLICTING_ENTITIES__CONFLICT_SET);
		}
		return conflicting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Conflict> getConflicts() {
		if (conflicts == null) {
			conflicts = new EObjectContainmentWithInverseEList<Conflict>(Conflict.class, this, SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS, SuperimpositionModelPackage.CONFLICT__CONFLICT_SET);
		}
		return conflicts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConflictingEntities> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<ConflictingEntities>(ConflictingEntities.class, this, SuperimpositionModelPackage.CONFLICT_SET__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ConflictSeverity computeSeverity() {
		return getConflicts().stream().map(Conflict::getSeverity).reduce((a,b) -> a.getValue() < b.getValue() ? a : b).orElse(ConflictSeverity.OK);
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
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConflicting()).basicAdd(otherEnd, msgs);
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConflicts()).basicAdd(otherEnd, msgs);
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
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING:
				return ((InternalEList<?>)getConflicting()).basicRemove(otherEnd, msgs);
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS:
				return ((InternalEList<?>)getConflicts()).basicRemove(otherEnd, msgs);
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
			case SuperimpositionModelPackage.CONFLICT_SET__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING:
				return getConflicting();
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS:
				return getConflicts();
			case SuperimpositionModelPackage.CONFLICT_SET__INPUTS:
				return getInputs();
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
			case SuperimpositionModelPackage.CONFLICT_SET__CONTEXT:
				setContext((SuperimposedModel)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING:
				getConflicting().clear();
				getConflicting().addAll((Collection<? extends ConflictingEntities>)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS:
				getConflicts().clear();
				getConflicts().addAll((Collection<? extends Conflict>)newValue);
				return;
			case SuperimpositionModelPackage.CONFLICT_SET__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends ConflictingEntities>)newValue);
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
			case SuperimpositionModelPackage.CONFLICT_SET__CONTEXT:
				setContext((SuperimposedModel)null);
				return;
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING:
				getConflicting().clear();
				return;
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS:
				getConflicts().clear();
				return;
			case SuperimpositionModelPackage.CONFLICT_SET__INPUTS:
				getInputs().clear();
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
			case SuperimpositionModelPackage.CONFLICT_SET__CONTEXT:
				return context != null;
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTING:
				return conflicting != null && !conflicting.isEmpty();
			case SuperimpositionModelPackage.CONFLICT_SET__CONFLICTS:
				return conflicts != null && !conflicts.isEmpty();
			case SuperimpositionModelPackage.CONFLICT_SET__INPUTS:
				return inputs != null && !inputs.isEmpty();
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
			case SuperimpositionModelPackage.CONFLICT_SET___COMPUTE_SEVERITY:
				return computeSeverity();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConflictSetImpl

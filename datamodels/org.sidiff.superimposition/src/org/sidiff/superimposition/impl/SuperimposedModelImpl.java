/**
 */
package org.sidiff.superimposition.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.*;
import org.sidiff.common.collections.UniqueQueue;
import org.sidiff.entities.*;
import org.sidiff.entities.exporter.filter.IExporterFilter;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.superimposition.*;
import org.sidiff.superimposition.signature.ISignatureCalculator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Superimposed Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedModelImpl#getDocType <em>Doc Type</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedModelImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedModelImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedModelImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.sidiff.superimposition.impl.SuperimposedModelImpl#getSignatureCalculators <em>Signature Calculators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SuperimposedModelImpl extends MinimalEObjectImpl.Container implements SuperimposedModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SuperimposedElement> elements;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> type;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getSignatureCalculators() <em>Signature Calculators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatureCalculators()
	 * @generated
	 * @ordered
	 */
	protected EList<ISignatureCalculator> signatureCalculators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuperimposedModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getDocType() {
		return getType().stream().map(EPackage::getNsURI).collect(Collectors.toCollection(() -> ECollections.newBasicEListWithCapacity(getType().size())));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SuperimposedElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<>(SuperimposedElement.class, this, SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EPackage> getType() {
		if (type == null) {
			type = new EObjectResolvingEList<>(EPackage.class, this, SuperimpositionModelPackage.SUPERIMPOSED_MODEL__TYPE);
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<>(Annotation.class, this, SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ISignatureCalculator> getSignatureCalculators() {
		if (signatureCalculators == null) {
			signatureCalculators = new EDataTypeUniqueEList<>(ISignatureCalculator.class, this, SuperimpositionModelPackage.SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS);
		}
		return signatureCalculators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<SuperimposedElement> getElements(final String signature) {
		return getElements().stream().filter(e -> Objects.equals(e.getSignature(), signature)).collect(Collectors.toCollection(ECollections::newBasicEList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Entity> getEntities(IExporterFilter filter) {
		Set<Entity> entities = new LinkedHashSet<>();
		Queue<Element> toExport = new UniqueQueue<>(getElements());
		for(Element element : toExport) {
			if(filter.isExported(element)) {
				entities.add(element);
				element.getAttributes().stream()
					.filter(filter::isExported).forEach(entities::add);
				element.getOutgoings().stream()
					.filter(filter::isExported).peek(entities::add)
					.filter(filter::followOutgoing).forEach(ref -> toExport.offer(ref.getTarget()));
				element.getIncomings().stream()
					.filter(filter::isExported).peek(entities::add)
					.filter(filter::followIncoming).forEach(ref -> toExport.offer(ref.getSource()));
			}
		}
		return new BasicEList<>(entities);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ConflictSet createConflictSet(IExporterFilter filter) {
		Collection<Entity> entities = getEntities(filter);

		ConflictSet conflictSet = SuperimpositionModelFactory.eINSTANCE.createConflictSet();
		conflictSet.setContext(this);

		// Create a conflicting for each superimposed element, with its attributes,
		// incoming and outgoing references, and elements contained in it.
		// The key null is used for the single conflicting with a
		// null context that contains all uncontained elements.
		Map<SuperimposedElement,ConflictingEntities> elementWrappers = new HashMap<>();
		Function<Element,ConflictingEntities> wrapper = element -> elementWrappers.computeIfAbsent((SuperimposedElement)element, elem -> {
			ConflictingEntities conflicting = SuperimpositionModelFactory.eINSTANCE.createConflictingEntities();
			conflicting.setContext(elem);
			return conflicting;
		});

		// Add entities to conflictings
		for(Entity entity : entities) {
			if(entity instanceof SuperimposedElement) {
				SuperimposedElement element = (SuperimposedElement)entity;
				if(element.getIncomings().stream().noneMatch(Reference::isContainment)) {
					wrapper.apply(null).getElements().add(element);
				}
			} else if(entity instanceof Reference) {
				Reference reference = (Reference)entity;
				ConflictingEntities sourceWrapper = wrapper.apply(reference.getSource());
				sourceWrapper.getReferences().add(reference);
				if(reference.isContainment()) {
					sourceWrapper.getElements().add(reference.getTarget());
				}
				wrapper.apply(reference.getTarget()).getReferences().add(reference);
			} else if(entity instanceof Attribute) {
				Attribute attribute = (Attribute)entity;
				wrapper.apply(attribute.getContainer()).getAttributes().add(attribute);
			}
		}
		conflictSet.getConflicting().addAll(elementWrappers.values());
		conflictSet.getInputs().addAll(elementWrappers.values());
		return conflictSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Annotation getAnnotation(final String body) {
		return EntitiesUtil.getAnnotation(body, getAnnotations()).orElse(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Annotation getAnnotation(final Annotation annotation) {
		return EntitiesUtil.getAnnotation(annotation, getAnnotations()).orElse(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Annotation getOrAddAnnotation(final Annotation annotation) {
		return EntitiesUtil.getOrAddAnnotation(annotation, getAnnotations());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String calculateSignature(final EObject object) {
		return ISignatureCalculator.IDelegator.delegateToFirstOf(getSignatureCalculators())
				.delegateCalculateSignature(object, ISignatureCalculator.IModelAccessor.DEFAULT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
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
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__DOC_TYPE:
				return getDocType();
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ELEMENTS:
				return getElements();
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__TYPE:
				return getType();
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ANNOTATIONS:
				return getAnnotations();
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS:
				return getSignatureCalculators();
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
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends SuperimposedElement>)newValue);
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends EPackage>)newValue);
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS:
				getSignatureCalculators().clear();
				getSignatureCalculators().addAll((Collection<? extends ISignatureCalculator>)newValue);
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
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ELEMENTS:
				getElements().clear();
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__TYPE:
				getType().clear();
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS:
				getSignatureCalculators().clear();
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
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__DOC_TYPE:
				return !getDocType().isEmpty();
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__TYPE:
				return type != null && !type.isEmpty();
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS:
				return signatureCalculators != null && !signatureCalculators.isEmpty();
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
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL___GET_ELEMENTS__STRING:
				return getElements((String)arguments.get(0));
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL___GET_ENTITIES__IEXPORTERFILTER:
				return getEntities((IExporterFilter)arguments.get(0));
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL___CREATE_CONFLICT_SET__IEXPORTERFILTER:
				return createConflictSet((IExporterFilter)arguments.get(0));
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL___GET_ANNOTATION__STRING:
				return getAnnotation((String)arguments.get(0));
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL___GET_ANNOTATION__ANNOTATION:
				return getAnnotation((Annotation)arguments.get(0));
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL___GET_OR_ADD_ANNOTATION__ANNOTATION:
				return getOrAddAnnotation((Annotation)arguments.get(0));
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL___CALCULATE_SIGNATURE__EOBJECT:
				return calculateSignature((EObject)arguments.get(0));
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
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (signatureCalculators: ");
		result.append(signatureCalculators);
		result.append(')');
		return result.toString();
	}

} //SuperimposedModelImpl

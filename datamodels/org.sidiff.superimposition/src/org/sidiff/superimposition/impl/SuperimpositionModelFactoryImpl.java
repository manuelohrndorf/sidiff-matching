/**
 */
package org.sidiff.superimposition.impl;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sidiff.common.extension.ExtensionSerialization;
import org.sidiff.entities.Annotation;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictSeverity;
import org.sidiff.superimposition.ConflictType;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelFactory;
import org.sidiff.superimposition.SuperimpositionModelPackage;
import org.sidiff.superimposition.signature.ISignatureCalculator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SuperimpositionModelFactoryImpl extends EFactoryImpl implements SuperimpositionModelFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SuperimpositionModelFactory init() {
		try {
			SuperimpositionModelFactory theSuperimpositionModelFactory = (SuperimpositionModelFactory)EPackage.Registry.INSTANCE.getEFactory(SuperimpositionModelPackage.eNS_URI);
			if (theSuperimpositionModelFactory != null) {
				return theSuperimpositionModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SuperimpositionModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperimpositionModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL: return createSuperimposedModel();
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT: return createSuperimposedElement();
			case SuperimpositionModelPackage.CONFLICTING_ENTITIES: return createConflictingEntities();
			case SuperimpositionModelPackage.CONFLICT: return createConflict();
			case SuperimpositionModelPackage.CONFLICT_SET: return createConflictSet();
			case SuperimpositionModelPackage.EOBJECT_TO_ANNOTATIONS_MAP_ENTRY: return (EObject)createEObjectToAnnotationsMapEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SuperimpositionModelPackage.CONFLICT_SEVERITY:
				return createConflictSeverityFromString(eDataType, initialValue);
			case SuperimpositionModelPackage.CONFLICT_TYPE:
				return createConflictTypeFromString(eDataType, initialValue);
			case SuperimpositionModelPackage.ISIGNATURE_CALCULATOR:
				return createISignatureCalculatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SuperimpositionModelPackage.CONFLICT_SEVERITY:
				return convertConflictSeverityToString(eDataType, instanceValue);
			case SuperimpositionModelPackage.CONFLICT_TYPE:
				return convertConflictTypeToString(eDataType, instanceValue);
			case SuperimpositionModelPackage.ISIGNATURE_CALCULATOR:
				return convertISignatureCalculatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuperimposedModel createSuperimposedModel() {
		SuperimposedModelImpl superimposedModel = new SuperimposedModelImpl();
		return superimposedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuperimposedElement createSuperimposedElement() {
		SuperimposedElementImpl superimposedElement = new SuperimposedElementImpl();
		return superimposedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictingEntities createConflictingEntities() {
		ConflictingEntitiesImpl conflictingEntities = new ConflictingEntitiesImpl();
		return conflictingEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Conflict createConflict() {
		ConflictImpl conflict = new ConflictImpl();
		return conflict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConflictSet createConflictSet() {
		ConflictSetImpl conflictSet = new ConflictSetImpl();
		return conflictSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EObject, EList<Annotation>> createEObjectToAnnotationsMapEntry() {
		EObjectToAnnotationsMapEntryImpl eObjectToAnnotationsMapEntry = new EObjectToAnnotationsMapEntryImpl();
		return eObjectToAnnotationsMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictSeverity createConflictSeverityFromString(EDataType eDataType, String initialValue) {
		ConflictSeverity result = ConflictSeverity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConflictSeverityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConflictType createConflictTypeFromString(EDataType eDataType, String initialValue) {
		ConflictType result = ConflictType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConflictTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISignatureCalculator createISignatureCalculator(final String it) {
		return ExtensionSerialization.createExtension(ISignatureCalculator.MANAGER, it);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISignatureCalculator createISignatureCalculatorFromString(EDataType eDataType, String initialValue) {
		return createISignatureCalculator(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertISignatureCalculator(final ISignatureCalculator it) {
		return ExtensionSerialization.convertToString(it);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertISignatureCalculatorToString(EDataType eDataType, Object instanceValue) {
		return convertISignatureCalculator((ISignatureCalculator)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuperimpositionModelPackage getSuperimpositionModelPackage() {
		return (SuperimpositionModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SuperimpositionModelPackage getPackage() {
		return SuperimpositionModelPackage.eINSTANCE;
	}

} //SuperimpositionModelFactoryImpl

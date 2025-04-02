/**
 */
package org.sidiff.superimposition.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.formula.FormulaPackage;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SuperimpositionModelPackageImpl extends EPackageImpl implements SuperimpositionModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass superimposedModelEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass superimposedElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictingEntitiesEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conflictSetEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectToAnnotationsMapEntryEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum conflictSeverityEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum conflictTypeEEnum = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iSignatureCalculatorEDataType = null;
	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SuperimpositionModelPackageImpl() {
		super(eNS_URI, SuperimpositionModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link SuperimpositionModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SuperimpositionModelPackage init() {
		if (isInited) return (SuperimpositionModelPackage)EPackage.Registry.INSTANCE.getEPackage(SuperimpositionModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSuperimpositionModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SuperimpositionModelPackageImpl theSuperimpositionModelPackage = registeredSuperimpositionModelPackage instanceof SuperimpositionModelPackageImpl ? (SuperimpositionModelPackageImpl)registeredSuperimpositionModelPackage : new SuperimpositionModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EntitiesPackage.eINSTANCE.eClass();
		FormulaPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSuperimpositionModelPackage.createPackageContents();

		// Initialize created meta-data
		theSuperimpositionModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSuperimpositionModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SuperimpositionModelPackage.eNS_URI, theSuperimpositionModelPackage);
		return theSuperimpositionModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSuperimposedModel() {
		return superimposedModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSuperimposedModel_DocType() {
		return (EAttribute)superimposedModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSuperimposedModel_Elements() {
		return (EReference)superimposedModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSuperimposedModel_Type() {
		return (EReference)superimposedModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSuperimposedModel_Annotations() {
		return (EReference)superimposedModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSuperimposedModel_SignatureCalculators() {
		return (EAttribute)superimposedModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedModel__GetElements__String() {
		return superimposedModelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedModel__GetEntities__IExporterFilter() {
		return superimposedModelEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedModel__CreateConflictSet__IExporterFilter() {
		return superimposedModelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedModel__GetAnnotation__String() {
		return superimposedModelEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedModel__GetAnnotation__Annotation() {
		return superimposedModelEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedModel__GetOrAddAnnotation__Annotation() {
		return superimposedModelEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedModel__CalculateSignature__EObject() {
		return superimposedModelEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSuperimposedElement() {
		return superimposedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSuperimposedElement_Objects() {
		return (EReference)superimposedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSuperimposedElement_OwnedAttributes() {
		return (EReference)superimposedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSuperimposedElement_OwnedReferences() {
		return (EReference)superimposedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSuperimposedElement_ObjectAnnotations() {
		return (EReference)superimposedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedElement__GetContainer() {
		return superimposedElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getSuperimposedElement__GetContained() {
		return superimposedElementEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConflictingEntities() {
		return conflictingEntitiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflictingEntities_Entities() {
		return (EAttribute)conflictingEntitiesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictingEntities_References() {
		return (EReference)conflictingEntitiesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictingEntities_Elements() {
		return (EReference)conflictingEntitiesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictingEntities_Attributes() {
		return (EReference)conflictingEntitiesEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictingEntities_Context() {
		return (EReference)conflictingEntitiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictingEntities_ConflictSet() {
		return (EReference)conflictingEntitiesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictingEntities_Type() {
		return (EReference)conflictingEntitiesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getConflictingEntities__GetAttributes__EAttribute() {
		return conflictingEntitiesEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getConflictingEntities__GetReferences__EReference() {
		return conflictingEntitiesEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getConflictingEntities__GetElements__EClass() {
		return conflictingEntitiesEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getConflictingEntities__IsInvalidated() {
		return conflictingEntitiesEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getConflictingEntities__GetNumberOfConflictingFeatures() {
		return conflictingEntitiesEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConflict() {
		return conflictEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflict_Id() {
		return (EAttribute)conflictEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflict_Message() {
		return (EAttribute)conflictEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflict_Severity() {
		return (EAttribute)conflictEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflict_Conflicting() {
		return (EReference)conflictEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflict_ConflictSet() {
		return (EReference)conflictEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConflict_Type() {
		return (EAttribute)conflictEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConflictSet() {
		return conflictSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictSet_Context() {
		return (EReference)conflictSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictSet_Conflicting() {
		return (EReference)conflictSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictSet_Conflicts() {
		return (EReference)conflictSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConflictSet_Inputs() {
		return (EReference)conflictSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getConflictSet__ComputeSeverity() {
		return conflictSetEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEObjectToAnnotationsMapEntry() {
		return eObjectToAnnotationsMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEObjectToAnnotationsMapEntry_Key() {
		return (EReference)eObjectToAnnotationsMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEObjectToAnnotationsMapEntry_Value() {
		return (EReference)eObjectToAnnotationsMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getConflictSeverity() {
		return conflictSeverityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getConflictType() {
		return conflictTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getISignatureCalculator() {
		return iSignatureCalculatorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SuperimpositionModelFactory getSuperimpositionModelFactory() {
		return (SuperimpositionModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		superimposedModelEClass = createEClass(SUPERIMPOSED_MODEL);
		createEAttribute(superimposedModelEClass, SUPERIMPOSED_MODEL__DOC_TYPE);
		createEReference(superimposedModelEClass, SUPERIMPOSED_MODEL__ELEMENTS);
		createEReference(superimposedModelEClass, SUPERIMPOSED_MODEL__TYPE);
		createEReference(superimposedModelEClass, SUPERIMPOSED_MODEL__ANNOTATIONS);
		createEAttribute(superimposedModelEClass, SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS);
		createEOperation(superimposedModelEClass, SUPERIMPOSED_MODEL___GET_ELEMENTS__STRING);
		createEOperation(superimposedModelEClass, SUPERIMPOSED_MODEL___GET_ENTITIES__IEXPORTERFILTER);
		createEOperation(superimposedModelEClass, SUPERIMPOSED_MODEL___CREATE_CONFLICT_SET__IEXPORTERFILTER);
		createEOperation(superimposedModelEClass, SUPERIMPOSED_MODEL___GET_ANNOTATION__STRING);
		createEOperation(superimposedModelEClass, SUPERIMPOSED_MODEL___GET_ANNOTATION__ANNOTATION);
		createEOperation(superimposedModelEClass, SUPERIMPOSED_MODEL___GET_OR_ADD_ANNOTATION__ANNOTATION);
		createEOperation(superimposedModelEClass, SUPERIMPOSED_MODEL___CALCULATE_SIGNATURE__EOBJECT);

		superimposedElementEClass = createEClass(SUPERIMPOSED_ELEMENT);
		createEReference(superimposedElementEClass, SUPERIMPOSED_ELEMENT__OBJECTS);
		createEReference(superimposedElementEClass, SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES);
		createEReference(superimposedElementEClass, SUPERIMPOSED_ELEMENT__OWNED_REFERENCES);
		createEReference(superimposedElementEClass, SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS);
		createEOperation(superimposedElementEClass, SUPERIMPOSED_ELEMENT___GET_CONTAINER);
		createEOperation(superimposedElementEClass, SUPERIMPOSED_ELEMENT___GET_CONTAINED);

		conflictingEntitiesEClass = createEClass(CONFLICTING_ENTITIES);
		createEReference(conflictingEntitiesEClass, CONFLICTING_ENTITIES__CONTEXT);
		createEReference(conflictingEntitiesEClass, CONFLICTING_ENTITIES__CONFLICT_SET);
		createEReference(conflictingEntitiesEClass, CONFLICTING_ENTITIES__TYPE);
		createEAttribute(conflictingEntitiesEClass, CONFLICTING_ENTITIES__ENTITIES);
		createEReference(conflictingEntitiesEClass, CONFLICTING_ENTITIES__REFERENCES);
		createEReference(conflictingEntitiesEClass, CONFLICTING_ENTITIES__ELEMENTS);
		createEReference(conflictingEntitiesEClass, CONFLICTING_ENTITIES__ATTRIBUTES);
		createEOperation(conflictingEntitiesEClass, CONFLICTING_ENTITIES___GET_ATTRIBUTES__EATTRIBUTE);
		createEOperation(conflictingEntitiesEClass, CONFLICTING_ENTITIES___GET_REFERENCES__EREFERENCE);
		createEOperation(conflictingEntitiesEClass, CONFLICTING_ENTITIES___GET_ELEMENTS__ECLASS);
		createEOperation(conflictingEntitiesEClass, CONFLICTING_ENTITIES___IS_INVALIDATED);
		createEOperation(conflictingEntitiesEClass, CONFLICTING_ENTITIES___GET_NUMBER_OF_CONFLICTING_FEATURES);

		conflictEClass = createEClass(CONFLICT);
		createEAttribute(conflictEClass, CONFLICT__ID);
		createEAttribute(conflictEClass, CONFLICT__MESSAGE);
		createEAttribute(conflictEClass, CONFLICT__SEVERITY);
		createEReference(conflictEClass, CONFLICT__CONFLICTING);
		createEReference(conflictEClass, CONFLICT__CONFLICT_SET);
		createEAttribute(conflictEClass, CONFLICT__TYPE);

		conflictSetEClass = createEClass(CONFLICT_SET);
		createEReference(conflictSetEClass, CONFLICT_SET__CONTEXT);
		createEReference(conflictSetEClass, CONFLICT_SET__CONFLICTING);
		createEReference(conflictSetEClass, CONFLICT_SET__CONFLICTS);
		createEReference(conflictSetEClass, CONFLICT_SET__INPUTS);
		createEOperation(conflictSetEClass, CONFLICT_SET___COMPUTE_SEVERITY);

		eObjectToAnnotationsMapEntryEClass = createEClass(EOBJECT_TO_ANNOTATIONS_MAP_ENTRY);
		createEReference(eObjectToAnnotationsMapEntryEClass, EOBJECT_TO_ANNOTATIONS_MAP_ENTRY__KEY);
		createEReference(eObjectToAnnotationsMapEntryEClass, EOBJECT_TO_ANNOTATIONS_MAP_ENTRY__VALUE);

		// Create enums
		conflictSeverityEEnum = createEEnum(CONFLICT_SEVERITY);
		conflictTypeEEnum = createEEnum(CONFLICT_TYPE);

		// Create data types
		iSignatureCalculatorEDataType = createEDataType(ISIGNATURE_CALCULATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EntitiesPackage theEntitiesPackage = (EntitiesPackage)EPackage.Registry.INSTANCE.getEPackage(EntitiesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		superimposedElementEClass.getESuperTypes().add(theEntitiesPackage.getElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(superimposedModelEClass, SuperimposedModel.class, "SuperimposedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSuperimposedModel_DocType(), ecorePackage.getEString(), "docType", null, 1, -1, SuperimposedModel.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSuperimposedModel_Elements(), this.getSuperimposedElement(), null, "elements", null, 0, -1, SuperimposedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSuperimposedModel_Type(), ecorePackage.getEPackage(), null, "type", null, 1, -1, SuperimposedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSuperimposedModel_Annotations(), theEntitiesPackage.getAnnotation(), null, "annotations", null, 0, -1, SuperimposedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSuperimposedModel_SignatureCalculators(), this.getISignatureCalculator(), "signatureCalculators", null, 1, -1, SuperimposedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getSuperimposedModel__GetElements__String(), this.getSuperimposedElement(), "getElements", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "signature", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSuperimposedModel__GetEntities__IExporterFilter(), theEntitiesPackage.getEntity(), "getEntities", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEntitiesPackage.getIExporterFilter(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSuperimposedModel__CreateConflictSet__IExporterFilter(), this.getConflictSet(), "createConflictSet", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEntitiesPackage.getIExporterFilter(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSuperimposedModel__GetAnnotation__String(), theEntitiesPackage.getAnnotation(), "getAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "body", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSuperimposedModel__GetAnnotation__Annotation(), theEntitiesPackage.getAnnotation(), "getAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEntitiesPackage.getAnnotation(), "annotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSuperimposedModel__GetOrAddAnnotation__Annotation(), theEntitiesPackage.getAnnotation(), "getOrAddAnnotation", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEntitiesPackage.getAnnotation(), "annotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getSuperimposedModel__CalculateSignature__EObject(), ecorePackage.getEString(), "calculateSignature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "object", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(superimposedElementEClass, SuperimposedElement.class, "SuperimposedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSuperimposedElement_Objects(), ecorePackage.getEObject(), null, "objects", null, 0, -1, SuperimposedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSuperimposedElement_OwnedAttributes(), theEntitiesPackage.getAttribute(), null, "ownedAttributes", null, 0, -1, SuperimposedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSuperimposedElement_OwnedReferences(), theEntitiesPackage.getReference(), null, "ownedReferences", null, 0, -1, SuperimposedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSuperimposedElement_ObjectAnnotations(), this.getEObjectToAnnotationsMapEntry(), null, "objectAnnotations", null, 0, -1, SuperimposedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getSuperimposedElement__GetContainer(), this.getSuperimposedElement(), "getContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getSuperimposedElement__GetContained(), this.getSuperimposedElement(), "getContained", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(conflictingEntitiesEClass, ConflictingEntities.class, "ConflictingEntities", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConflictingEntities_Context(), this.getSuperimposedElement(), null, "context", null, 0, 1, ConflictingEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictingEntities_ConflictSet(), this.getConflictSet(), this.getConflictSet_Conflicting(), "conflictSet", null, 1, 1, ConflictingEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictingEntities_Type(), ecorePackage.getEStructuralFeature(), null, "type", null, 0, 1, ConflictingEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConflictingEntities_Entities(), ecorePackage.getEFeatureMapEntry(), "entities", null, 0, -1, ConflictingEntities.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictingEntities_References(), theEntitiesPackage.getReference(), null, "references", null, 0, -1, ConflictingEntities.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getConflictingEntities_Elements(), theEntitiesPackage.getElement(), null, "elements", null, 0, -1, ConflictingEntities.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getConflictingEntities_Attributes(), theEntitiesPackage.getAttribute(), null, "attributes", null, 0, -1, ConflictingEntities.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = initEOperation(getConflictingEntities__GetAttributes__EAttribute(), theEntitiesPackage.getAttribute(), "getAttributes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEAttribute(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConflictingEntities__GetReferences__EReference(), theEntitiesPackage.getReference(), "getReferences", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEReference(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getConflictingEntities__GetElements__EClass(), theEntitiesPackage.getElement(), "getElements", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEClass(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConflictingEntities__IsInvalidated(), ecorePackage.getEBoolean(), "isInvalidated", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getConflictingEntities__GetNumberOfConflictingFeatures(), ecorePackage.getEInt(), "getNumberOfConflictingFeatures", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(conflictEClass, Conflict.class, "Conflict", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConflict_Id(), ecorePackage.getEString(), "id", null, 1, 1, Conflict.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConflict_Message(), ecorePackage.getEString(), "message", null, 0, 1, Conflict.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConflict_Severity(), this.getConflictSeverity(), "severity", null, 1, 1, Conflict.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflict_Conflicting(), this.getConflictingEntities(), null, "conflicting", null, 0, -1, Conflict.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflict_ConflictSet(), this.getConflictSet(), this.getConflictSet_Conflicts(), "conflictSet", null, 1, 1, Conflict.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConflict_Type(), this.getConflictType(), "type", null, 1, 1, Conflict.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conflictSetEClass, ConflictSet.class, "ConflictSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConflictSet_Context(), this.getSuperimposedModel(), null, "context", null, 1, 1, ConflictSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictSet_Conflicting(), this.getConflictingEntities(), this.getConflictingEntities_ConflictSet(), "conflicting", null, 0, -1, ConflictSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictSet_Conflicts(), this.getConflict(), this.getConflict_ConflictSet(), "conflicts", null, 0, -1, ConflictSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConflictSet_Inputs(), this.getConflictingEntities(), null, "inputs", null, 0, -1, ConflictSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getConflictSet__ComputeSeverity(), this.getConflictSeverity(), "computeSeverity", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eObjectToAnnotationsMapEntryEClass, Map.Entry.class, "EObjectToAnnotationsMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectToAnnotationsMapEntry_Key(), ecorePackage.getEObject(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEObjectToAnnotationsMapEntry_Value(), theEntitiesPackage.getAnnotation(), null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(conflictSeverityEEnum, ConflictSeverity.class, "ConflictSeverity");
		addEEnumLiteral(conflictSeverityEEnum, ConflictSeverity.ERROR);
		addEEnumLiteral(conflictSeverityEEnum, ConflictSeverity.WARNING);
		addEEnumLiteral(conflictSeverityEEnum, ConflictSeverity.NOTICE);
		addEEnumLiteral(conflictSeverityEEnum, ConflictSeverity.OK);

		initEEnum(conflictTypeEEnum, ConflictType.class, "ConflictType");
		addEEnumLiteral(conflictTypeEEnum, ConflictType.UNSPECIFIED);
		addEEnumLiteral(conflictTypeEEnum, ConflictType.SYNTACTIC);
		addEEnumLiteral(conflictTypeEEnum, ConflictType.SEMANTIC);

		// Initialize data types
		initEDataType(iSignatureCalculatorEDataType, ISignatureCalculator.class, "ISignatureCalculator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation
		  (getConflictingEntities_Entities(),
		   source,
		   new String[] {
			   "kind", "group"
		   });
		addAnnotation
		  (getConflictingEntities_References(),
		   source,
		   new String[] {
			   "group", "#entities"
		   });
		addAnnotation
		  (getConflictingEntities_Elements(),
		   source,
		   new String[] {
			   "group", "#entities"
		   });
		addAnnotation
		  (getConflictingEntities_Attributes(),
		   source,
		   new String[] {
			   "group", "#entities"
		   });
	}

} //SuperimpositionModelPackageImpl

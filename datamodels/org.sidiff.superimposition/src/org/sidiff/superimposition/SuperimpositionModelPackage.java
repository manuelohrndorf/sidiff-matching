/**
 */
package org.sidiff.superimposition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.entities.EntitiesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.superimposition.SuperimpositionModelFactory
 * @model kind="package"
 * @generated
 */
public interface SuperimpositionModelPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "superimposition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/superimposition/model/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "superimposition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SuperimpositionModelPackage eINSTANCE = org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.superimposition.impl.SuperimposedModelImpl <em>Superimposed Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.impl.SuperimposedModelImpl
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getSuperimposedModel()
	 * @generated
	 */
	int SUPERIMPOSED_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Doc Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL__DOC_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL__ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL__ANNOTATIONS = 3;

	/**
	 * The feature id for the '<em><b>Signature Calculators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS = 4;

	/**
	 * The number of structural features of the '<em>Superimposed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Get Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL___GET_ELEMENTS__STRING = 0;

	/**
	 * The operation id for the '<em>Get Entities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL___GET_ENTITIES__IEXPORTERFILTER = 1;

	/**
	 * The operation id for the '<em>Create Conflict Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL___CREATE_CONFLICT_SET__IEXPORTERFILTER = 2;

	/**
	 * The operation id for the '<em>Get Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL___GET_ANNOTATION__STRING = 3;

	/**
	 * The operation id for the '<em>Get Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL___GET_ANNOTATION__ANNOTATION = 4;

	/**
	 * The operation id for the '<em>Get Or Add Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL___GET_OR_ADD_ANNOTATION__ANNOTATION = 5;

	/**
	 * The operation id for the '<em>Calculate Signature</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL___CALCULATE_SIGNATURE__EOBJECT = 6;

	/**
	 * The number of operations of the '<em>Superimposed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_MODEL_OPERATION_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.sidiff.superimposition.impl.SuperimposedElementImpl <em>Superimposed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.impl.SuperimposedElementImpl
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getSuperimposedElement()
	 * @generated
	 */
	int SUPERIMPOSED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__ANNOTATIONS = EntitiesPackage.ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__SIGNATURE = EntitiesPackage.ELEMENT__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__UUID = EntitiesPackage.ELEMENT__UUID;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__OUTGOINGS = EntitiesPackage.ELEMENT__OUTGOINGS;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__INCOMINGS = EntitiesPackage.ELEMENT__INCOMINGS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__ATTRIBUTES = EntitiesPackage.ELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__OBJECT = EntitiesPackage.ELEMENT__OBJECT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__TYPE = EntitiesPackage.ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__EXTERNAL = EntitiesPackage.ELEMENT__EXTERNAL;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__OBJECTS = EntitiesPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES = EntitiesPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__OWNED_REFERENCES = EntitiesPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Object Annotations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS = EntitiesPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Superimposed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT_FEATURE_COUNT = EntitiesPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT___GET_ATTRIBUTES__EATTRIBUTE = EntitiesPackage.ELEMENT___GET_ATTRIBUTES__EATTRIBUTE;

	/**
	 * The operation id for the '<em>Get References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT___GET_REFERENCES__EREFERENCE = EntitiesPackage.ELEMENT___GET_REFERENCES__EREFERENCE;

	/**
	 * The operation id for the '<em>Update External</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT___UPDATE_EXTERNAL = EntitiesPackage.ELEMENT___UPDATE_EXTERNAL;

	/**
	 * The operation id for the '<em>Get Container</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT___GET_CONTAINER = EntitiesPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Contained</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT___GET_CONTAINED = EntitiesPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Superimposed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPERIMPOSED_ELEMENT_OPERATION_COUNT = EntitiesPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl <em>Conflicting Entities</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.impl.ConflictingEntitiesImpl
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflictingEntities()
	 * @generated
	 */
	int CONFLICTING_ENTITIES = 2;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Conflict Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES__CONFLICT_SET = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES__ENTITIES = 3;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES__REFERENCES = 4;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES__ELEMENTS = 5;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES__ATTRIBUTES = 6;

	/**
	 * The number of structural features of the '<em>Conflicting Entities</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES_FEATURE_COUNT = 7;

	/**
	 * The operation id for the '<em>Get Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES___GET_ATTRIBUTES__EATTRIBUTE = 0;

	/**
	 * The operation id for the '<em>Get References</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES___GET_REFERENCES__EREFERENCE = 1;

	/**
	 * The operation id for the '<em>Get Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES___GET_ELEMENTS__ECLASS = 2;

	/**
	 * The operation id for the '<em>Is Invalidated</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES___IS_INVALIDATED = 3;

	/**
	 * The operation id for the '<em>Get Number Of Conflicting Features</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES___GET_NUMBER_OF_CONFLICTING_FEATURES = 4;

	/**
	 * The number of operations of the '<em>Conflicting Entities</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICTING_ENTITIES_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.sidiff.superimposition.impl.ConflictImpl <em>Conflict</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.impl.ConflictImpl
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflict()
	 * @generated
	 */
	int CONFLICT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__ID = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__SEVERITY = 2;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__CONFLICTING = 3;

	/**
	 * The feature id for the '<em><b>Conflict Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__CONFLICT_SET = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT__TYPE = 5;

	/**
	 * The number of structural features of the '<em>Conflict</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Conflict</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.superimposition.impl.ConflictSetImpl <em>Conflict Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.impl.ConflictSetImpl
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflictSet()
	 * @generated
	 */
	int CONFLICT_SET = 4;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_SET__CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Conflicting</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_SET__CONFLICTING = 1;

	/**
	 * The feature id for the '<em><b>Conflicts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_SET__CONFLICTS = 2;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_SET__INPUTS = 3;

	/**
	 * The number of structural features of the '<em>Conflict Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_SET_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Compute Severity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_SET___COMPUTE_SEVERITY = 0;

	/**
	 * The number of operations of the '<em>Conflict Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFLICT_SET_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.sidiff.superimposition.impl.EObjectToAnnotationsMapEntryImpl <em>EObject To Annotations Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.impl.EObjectToAnnotationsMapEntryImpl
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getEObjectToAnnotationsMapEntry()
	 * @generated
	 */
	int EOBJECT_TO_ANNOTATIONS_MAP_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_ANNOTATIONS_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_ANNOTATIONS_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EObject To Annotations Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_ANNOTATIONS_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EObject To Annotations Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_TO_ANNOTATIONS_MAP_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.sidiff.superimposition.ConflictSeverity <em>Conflict Severity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.ConflictSeverity
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflictSeverity()
	 * @generated
	 */
	int CONFLICT_SEVERITY = 6;

	/**
	 * The meta object id for the '{@link org.sidiff.superimposition.ConflictType <em>Conflict Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.ConflictType
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflictType()
	 * @generated
	 */
	int CONFLICT_TYPE = 7;

	/**
	 * The meta object id for the '<em>ISignature Calculator</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.superimposition.signature.ISignatureCalculator
	 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getISignatureCalculator()
	 * @generated
	 */
	int ISIGNATURE_CALCULATOR = 8;

	/**
	 * Returns the meta object for class '{@link org.sidiff.superimposition.SuperimposedModel <em>Superimposed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Superimposed Model</em>'.
	 * @see org.sidiff.superimposition.SuperimposedModel
	 * @generated
	 */
	EClass getSuperimposedModel();

	/**
	 * Returns the meta object for the attribute list '{@link org.sidiff.superimposition.SuperimposedModel#getDocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Doc Type</em>'.
	 * @see org.sidiff.superimposition.SuperimposedModel#getDocType()
	 * @see #getSuperimposedModel()
	 * @generated
	 */
	EAttribute getSuperimposedModel_DocType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.superimposition.SuperimposedModel#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.sidiff.superimposition.SuperimposedModel#getElements()
	 * @see #getSuperimposedModel()
	 * @generated
	 */
	EReference getSuperimposedModel_Elements();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.superimposition.SuperimposedModel#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Type</em>'.
	 * @see org.sidiff.superimposition.SuperimposedModel#getType()
	 * @see #getSuperimposedModel()
	 * @generated
	 */
	EReference getSuperimposedModel_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.superimposition.SuperimposedModel#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.sidiff.superimposition.SuperimposedModel#getAnnotations()
	 * @see #getSuperimposedModel()
	 * @generated
	 */
	EReference getSuperimposedModel_Annotations();

	/**
	 * Returns the meta object for the attribute list '{@link org.sidiff.superimposition.SuperimposedModel#getSignatureCalculators <em>Signature Calculators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Signature Calculators</em>'.
	 * @see org.sidiff.superimposition.SuperimposedModel#getSignatureCalculators()
	 * @see #getSuperimposedModel()
	 * @generated
	 */
	EAttribute getSuperimposedModel_SignatureCalculators();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedModel#getElements(java.lang.String) <em>Get Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Elements</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedModel#getElements(java.lang.String)
	 * @generated
	 */
	EOperation getSuperimposedModel__GetElements__String();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedModel#getEntities(org.sidiff.entities.exporter.filter.IExporterFilter) <em>Get Entities</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Entities</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedModel#getEntities(org.sidiff.entities.exporter.filter.IExporterFilter)
	 * @generated
	 */
	EOperation getSuperimposedModel__GetEntities__IExporterFilter();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedModel#createConflictSet(org.sidiff.entities.exporter.filter.IExporterFilter) <em>Create Conflict Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Conflict Set</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedModel#createConflictSet(org.sidiff.entities.exporter.filter.IExporterFilter)
	 * @generated
	 */
	EOperation getSuperimposedModel__CreateConflictSet__IExporterFilter();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedModel#getAnnotation(java.lang.String) <em>Get Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Annotation</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedModel#getAnnotation(java.lang.String)
	 * @generated
	 */
	EOperation getSuperimposedModel__GetAnnotation__String();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedModel#getAnnotation(org.sidiff.entities.Annotation) <em>Get Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Annotation</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedModel#getAnnotation(org.sidiff.entities.Annotation)
	 * @generated
	 */
	EOperation getSuperimposedModel__GetAnnotation__Annotation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedModel#getOrAddAnnotation(org.sidiff.entities.Annotation) <em>Get Or Add Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Or Add Annotation</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedModel#getOrAddAnnotation(org.sidiff.entities.Annotation)
	 * @generated
	 */
	EOperation getSuperimposedModel__GetOrAddAnnotation__Annotation();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedModel#calculateSignature(org.eclipse.emf.ecore.EObject) <em>Calculate Signature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Calculate Signature</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedModel#calculateSignature(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	EOperation getSuperimposedModel__CalculateSignature__EObject();

	/**
	 * Returns the meta object for class '{@link org.sidiff.superimposition.SuperimposedElement <em>Superimposed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Superimposed Element</em>'.
	 * @see org.sidiff.superimposition.SuperimposedElement
	 * @generated
	 */
	EClass getSuperimposedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.superimposition.SuperimposedElement#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objects</em>'.
	 * @see org.sidiff.superimposition.SuperimposedElement#getObjects()
	 * @see #getSuperimposedElement()
	 * @generated
	 */
	EReference getSuperimposedElement_Objects();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.superimposition.SuperimposedElement#getOwnedAttributes <em>Owned Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attributes</em>'.
	 * @see org.sidiff.superimposition.SuperimposedElement#getOwnedAttributes()
	 * @see #getSuperimposedElement()
	 * @generated
	 */
	EReference getSuperimposedElement_OwnedAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.superimposition.SuperimposedElement#getOwnedReferences <em>Owned References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned References</em>'.
	 * @see org.sidiff.superimposition.SuperimposedElement#getOwnedReferences()
	 * @see #getSuperimposedElement()
	 * @generated
	 */
	EReference getSuperimposedElement_OwnedReferences();

	/**
	 * Returns the meta object for the map '{@link org.sidiff.superimposition.SuperimposedElement#getObjectAnnotations <em>Object Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Object Annotations</em>'.
	 * @see org.sidiff.superimposition.SuperimposedElement#getObjectAnnotations()
	 * @see #getSuperimposedElement()
	 * @generated
	 */
	EReference getSuperimposedElement_ObjectAnnotations();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedElement#getContainer() <em>Get Container</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Container</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedElement#getContainer()
	 * @generated
	 */
	EOperation getSuperimposedElement__GetContainer();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.SuperimposedElement#getContained() <em>Get Contained</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Contained</em>' operation.
	 * @see org.sidiff.superimposition.SuperimposedElement#getContained()
	 * @generated
	 */
	EOperation getSuperimposedElement__GetContained();

	/**
	 * Returns the meta object for class '{@link org.sidiff.superimposition.ConflictingEntities <em>Conflicting Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflicting Entities</em>'.
	 * @see org.sidiff.superimposition.ConflictingEntities
	 * @generated
	 */
	EClass getConflictingEntities();

	/**
	 * Returns the meta object for the attribute list '{@link org.sidiff.superimposition.ConflictingEntities#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Entities</em>'.
	 * @see org.sidiff.superimposition.ConflictingEntities#getEntities()
	 * @see #getConflictingEntities()
	 * @generated
	 */
	EAttribute getConflictingEntities_Entities();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.superimposition.ConflictingEntities#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>References</em>'.
	 * @see org.sidiff.superimposition.ConflictingEntities#getReferences()
	 * @see #getConflictingEntities()
	 * @generated
	 */
	EReference getConflictingEntities_References();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.superimposition.ConflictingEntities#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.sidiff.superimposition.ConflictingEntities#getElements()
	 * @see #getConflictingEntities()
	 * @generated
	 */
	EReference getConflictingEntities_Elements();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.superimposition.ConflictingEntities#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see org.sidiff.superimposition.ConflictingEntities#getAttributes()
	 * @see #getConflictingEntities()
	 * @generated
	 */
	EReference getConflictingEntities_Attributes();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.superimposition.ConflictingEntities#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.sidiff.superimposition.ConflictingEntities#getContext()
	 * @see #getConflictingEntities()
	 * @generated
	 */
	EReference getConflictingEntities_Context();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.superimposition.ConflictingEntities#getConflictSet <em>Conflict Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Conflict Set</em>'.
	 * @see org.sidiff.superimposition.ConflictingEntities#getConflictSet()
	 * @see #getConflictingEntities()
	 * @generated
	 */
	EReference getConflictingEntities_ConflictSet();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.superimposition.ConflictingEntities#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.sidiff.superimposition.ConflictingEntities#getType()
	 * @see #getConflictingEntities()
	 * @generated
	 */
	EReference getConflictingEntities_Type();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.ConflictingEntities#getAttributes(org.eclipse.emf.ecore.EAttribute) <em>Get Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Attributes</em>' operation.
	 * @see org.sidiff.superimposition.ConflictingEntities#getAttributes(org.eclipse.emf.ecore.EAttribute)
	 * @generated
	 */
	EOperation getConflictingEntities__GetAttributes__EAttribute();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.ConflictingEntities#getReferences(org.eclipse.emf.ecore.EReference) <em>Get References</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get References</em>' operation.
	 * @see org.sidiff.superimposition.ConflictingEntities#getReferences(org.eclipse.emf.ecore.EReference)
	 * @generated
	 */
	EOperation getConflictingEntities__GetReferences__EReference();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.ConflictingEntities#getElements(org.eclipse.emf.ecore.EClass) <em>Get Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Elements</em>' operation.
	 * @see org.sidiff.superimposition.ConflictingEntities#getElements(org.eclipse.emf.ecore.EClass)
	 * @generated
	 */
	EOperation getConflictingEntities__GetElements__EClass();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.ConflictingEntities#isInvalidated() <em>Is Invalidated</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Invalidated</em>' operation.
	 * @see org.sidiff.superimposition.ConflictingEntities#isInvalidated()
	 * @generated
	 */
	EOperation getConflictingEntities__IsInvalidated();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.ConflictingEntities#getNumberOfConflictingFeatures() <em>Get Number Of Conflicting Features</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Number Of Conflicting Features</em>' operation.
	 * @see org.sidiff.superimposition.ConflictingEntities#getNumberOfConflictingFeatures()
	 * @generated
	 */
	EOperation getConflictingEntities__GetNumberOfConflictingFeatures();

	/**
	 * Returns the meta object for class '{@link org.sidiff.superimposition.Conflict <em>Conflict</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflict</em>'.
	 * @see org.sidiff.superimposition.Conflict
	 * @generated
	 */
	EClass getConflict();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.superimposition.Conflict#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.sidiff.superimposition.Conflict#getId()
	 * @see #getConflict()
	 * @generated
	 */
	EAttribute getConflict_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.superimposition.Conflict#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.sidiff.superimposition.Conflict#getMessage()
	 * @see #getConflict()
	 * @generated
	 */
	EAttribute getConflict_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.superimposition.Conflict#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.sidiff.superimposition.Conflict#getSeverity()
	 * @see #getConflict()
	 * @generated
	 */
	EAttribute getConflict_Severity();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.superimposition.Conflict#getConflicting <em>Conflicting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conflicting</em>'.
	 * @see org.sidiff.superimposition.Conflict#getConflicting()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_Conflicting();

	/**
	 * Returns the meta object for the container reference '{@link org.sidiff.superimposition.Conflict#getConflictSet <em>Conflict Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Conflict Set</em>'.
	 * @see org.sidiff.superimposition.Conflict#getConflictSet()
	 * @see #getConflict()
	 * @generated
	 */
	EReference getConflict_ConflictSet();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.superimposition.Conflict#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.sidiff.superimposition.Conflict#getType()
	 * @see #getConflict()
	 * @generated
	 */
	EAttribute getConflict_Type();

	/**
	 * Returns the meta object for class '{@link org.sidiff.superimposition.ConflictSet <em>Conflict Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conflict Set</em>'.
	 * @see org.sidiff.superimposition.ConflictSet
	 * @generated
	 */
	EClass getConflictSet();

	/**
	 * Returns the meta object for the reference '{@link org.sidiff.superimposition.ConflictSet#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.sidiff.superimposition.ConflictSet#getContext()
	 * @see #getConflictSet()
	 * @generated
	 */
	EReference getConflictSet_Context();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.superimposition.ConflictSet#getConflicting <em>Conflicting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conflicting</em>'.
	 * @see org.sidiff.superimposition.ConflictSet#getConflicting()
	 * @see #getConflictSet()
	 * @generated
	 */
	EReference getConflictSet_Conflicting();

	/**
	 * Returns the meta object for the containment reference list '{@link org.sidiff.superimposition.ConflictSet#getConflicts <em>Conflicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conflicts</em>'.
	 * @see org.sidiff.superimposition.ConflictSet#getConflicts()
	 * @see #getConflictSet()
	 * @generated
	 */
	EReference getConflictSet_Conflicts();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.superimposition.ConflictSet#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.sidiff.superimposition.ConflictSet#getInputs()
	 * @see #getConflictSet()
	 * @generated
	 */
	EReference getConflictSet_Inputs();

	/**
	 * Returns the meta object for the '{@link org.sidiff.superimposition.ConflictSet#computeSeverity() <em>Compute Severity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Compute Severity</em>' operation.
	 * @see org.sidiff.superimposition.ConflictSet#computeSeverity()
	 * @generated
	 */
	EOperation getConflictSet__ComputeSeverity();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EObject To Annotations Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject To Annotations Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.eclipse.emf.ecore.EObject" keyRequired="true"
	 *        valueType="org.sidiff.entities.Annotation" valueMany="true"
	 * @generated
	 */
	EClass getEObjectToAnnotationsMapEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEObjectToAnnotationsMapEntry()
	 * @generated
	 */
	EReference getEObjectToAnnotationsMapEntry_Key();

	/**
	 * Returns the meta object for the reference list '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEObjectToAnnotationsMapEntry()
	 * @generated
	 */
	EReference getEObjectToAnnotationsMapEntry_Value();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.superimposition.ConflictSeverity <em>Conflict Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Conflict Severity</em>'.
	 * @see org.sidiff.superimposition.ConflictSeverity
	 * @generated
	 */
	EEnum getConflictSeverity();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.superimposition.ConflictType <em>Conflict Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Conflict Type</em>'.
	 * @see org.sidiff.superimposition.ConflictType
	 * @generated
	 */
	EEnum getConflictType();

	/**
	 * Returns the meta object for data type '{@link org.sidiff.superimposition.signature.ISignatureCalculator <em>ISignature Calculator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ISignature Calculator</em>'.
	 * @see org.sidiff.superimposition.signature.ISignatureCalculator
	 * @model instanceClass="org.sidiff.superimposition.signature.ISignatureCalculator"
	 * @generated
	 */
	EDataType getISignatureCalculator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SuperimpositionModelFactory getSuperimpositionModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.superimposition.impl.SuperimposedModelImpl <em>Superimposed Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.impl.SuperimposedModelImpl
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getSuperimposedModel()
		 * @generated
		 */
		EClass SUPERIMPOSED_MODEL = eINSTANCE.getSuperimposedModel();

		/**
		 * The meta object literal for the '<em><b>Doc Type</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPERIMPOSED_MODEL__DOC_TYPE = eINSTANCE.getSuperimposedModel_DocType();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERIMPOSED_MODEL__ELEMENTS = eINSTANCE.getSuperimposedModel_Elements();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERIMPOSED_MODEL__TYPE = eINSTANCE.getSuperimposedModel_Type();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERIMPOSED_MODEL__ANNOTATIONS = eINSTANCE.getSuperimposedModel_Annotations();

		/**
		 * The meta object literal for the '<em><b>Signature Calculators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS = eINSTANCE.getSuperimposedModel_SignatureCalculators();

		/**
		 * The meta object literal for the '<em><b>Get Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_MODEL___GET_ELEMENTS__STRING = eINSTANCE.getSuperimposedModel__GetElements__String();

		/**
		 * The meta object literal for the '<em><b>Get Entities</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_MODEL___GET_ENTITIES__IEXPORTERFILTER = eINSTANCE.getSuperimposedModel__GetEntities__IExporterFilter();

		/**
		 * The meta object literal for the '<em><b>Create Conflict Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_MODEL___CREATE_CONFLICT_SET__IEXPORTERFILTER = eINSTANCE.getSuperimposedModel__CreateConflictSet__IExporterFilter();

		/**
		 * The meta object literal for the '<em><b>Get Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_MODEL___GET_ANNOTATION__STRING = eINSTANCE.getSuperimposedModel__GetAnnotation__String();

		/**
		 * The meta object literal for the '<em><b>Get Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_MODEL___GET_ANNOTATION__ANNOTATION = eINSTANCE.getSuperimposedModel__GetAnnotation__Annotation();

		/**
		 * The meta object literal for the '<em><b>Get Or Add Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_MODEL___GET_OR_ADD_ANNOTATION__ANNOTATION = eINSTANCE.getSuperimposedModel__GetOrAddAnnotation__Annotation();

		/**
		 * The meta object literal for the '<em><b>Calculate Signature</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_MODEL___CALCULATE_SIGNATURE__EOBJECT = eINSTANCE.getSuperimposedModel__CalculateSignature__EObject();

		/**
		 * The meta object literal for the '{@link org.sidiff.superimposition.impl.SuperimposedElementImpl <em>Superimposed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.impl.SuperimposedElementImpl
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getSuperimposedElement()
		 * @generated
		 */
		EClass SUPERIMPOSED_ELEMENT = eINSTANCE.getSuperimposedElement();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERIMPOSED_ELEMENT__OBJECTS = eINSTANCE.getSuperimposedElement_Objects();

		/**
		 * The meta object literal for the '<em><b>Owned Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES = eINSTANCE.getSuperimposedElement_OwnedAttributes();

		/**
		 * The meta object literal for the '<em><b>Owned References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERIMPOSED_ELEMENT__OWNED_REFERENCES = eINSTANCE.getSuperimposedElement_OwnedReferences();

		/**
		 * The meta object literal for the '<em><b>Object Annotations</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS = eINSTANCE.getSuperimposedElement_ObjectAnnotations();

		/**
		 * The meta object literal for the '<em><b>Get Container</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_ELEMENT___GET_CONTAINER = eINSTANCE.getSuperimposedElement__GetContainer();

		/**
		 * The meta object literal for the '<em><b>Get Contained</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SUPERIMPOSED_ELEMENT___GET_CONTAINED = eINSTANCE.getSuperimposedElement__GetContained();

		/**
		 * The meta object literal for the '{@link org.sidiff.superimposition.impl.ConflictingEntitiesImpl <em>Conflicting Entities</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.impl.ConflictingEntitiesImpl
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflictingEntities()
		 * @generated
		 */
		EClass CONFLICTING_ENTITIES = eINSTANCE.getConflictingEntities();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICTING_ENTITIES__ENTITIES = eINSTANCE.getConflictingEntities_Entities();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICTING_ENTITIES__REFERENCES = eINSTANCE.getConflictingEntities_References();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICTING_ENTITIES__ELEMENTS = eINSTANCE.getConflictingEntities_Elements();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICTING_ENTITIES__ATTRIBUTES = eINSTANCE.getConflictingEntities_Attributes();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICTING_ENTITIES__CONTEXT = eINSTANCE.getConflictingEntities_Context();

		/**
		 * The meta object literal for the '<em><b>Conflict Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICTING_ENTITIES__CONFLICT_SET = eINSTANCE.getConflictingEntities_ConflictSet();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICTING_ENTITIES__TYPE = eINSTANCE.getConflictingEntities_Type();

		/**
		 * The meta object literal for the '<em><b>Get Attributes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFLICTING_ENTITIES___GET_ATTRIBUTES__EATTRIBUTE = eINSTANCE.getConflictingEntities__GetAttributes__EAttribute();

		/**
		 * The meta object literal for the '<em><b>Get References</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFLICTING_ENTITIES___GET_REFERENCES__EREFERENCE = eINSTANCE.getConflictingEntities__GetReferences__EReference();

		/**
		 * The meta object literal for the '<em><b>Get Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFLICTING_ENTITIES___GET_ELEMENTS__ECLASS = eINSTANCE.getConflictingEntities__GetElements__EClass();

		/**
		 * The meta object literal for the '<em><b>Is Invalidated</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFLICTING_ENTITIES___IS_INVALIDATED = eINSTANCE.getConflictingEntities__IsInvalidated();

		/**
		 * The meta object literal for the '<em><b>Get Number Of Conflicting Features</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFLICTING_ENTITIES___GET_NUMBER_OF_CONFLICTING_FEATURES = eINSTANCE.getConflictingEntities__GetNumberOfConflictingFeatures();

		/**
		 * The meta object literal for the '{@link org.sidiff.superimposition.impl.ConflictImpl <em>Conflict</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.impl.ConflictImpl
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflict()
		 * @generated
		 */
		EClass CONFLICT = eINSTANCE.getConflict();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT__ID = eINSTANCE.getConflict_Id();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT__MESSAGE = eINSTANCE.getConflict_Message();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT__SEVERITY = eINSTANCE.getConflict_Severity();

		/**
		 * The meta object literal for the '<em><b>Conflicting</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__CONFLICTING = eINSTANCE.getConflict_Conflicting();

		/**
		 * The meta object literal for the '<em><b>Conflict Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT__CONFLICT_SET = eINSTANCE.getConflict_ConflictSet();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFLICT__TYPE = eINSTANCE.getConflict_Type();

		/**
		 * The meta object literal for the '{@link org.sidiff.superimposition.impl.ConflictSetImpl <em>Conflict Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.impl.ConflictSetImpl
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflictSet()
		 * @generated
		 */
		EClass CONFLICT_SET = eINSTANCE.getConflictSet();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_SET__CONTEXT = eINSTANCE.getConflictSet_Context();

		/**
		 * The meta object literal for the '<em><b>Conflicting</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_SET__CONFLICTING = eINSTANCE.getConflictSet_Conflicting();

		/**
		 * The meta object literal for the '<em><b>Conflicts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_SET__CONFLICTS = eINSTANCE.getConflictSet_Conflicts();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFLICT_SET__INPUTS = eINSTANCE.getConflictSet_Inputs();

		/**
		 * The meta object literal for the '<em><b>Compute Severity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFLICT_SET___COMPUTE_SEVERITY = eINSTANCE.getConflictSet__ComputeSeverity();

		/**
		 * The meta object literal for the '{@link org.sidiff.superimposition.impl.EObjectToAnnotationsMapEntryImpl <em>EObject To Annotations Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.impl.EObjectToAnnotationsMapEntryImpl
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getEObjectToAnnotationsMapEntry()
		 * @generated
		 */
		EClass EOBJECT_TO_ANNOTATIONS_MAP_ENTRY = eINSTANCE.getEObjectToAnnotationsMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_TO_ANNOTATIONS_MAP_ENTRY__KEY = eINSTANCE.getEObjectToAnnotationsMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_TO_ANNOTATIONS_MAP_ENTRY__VALUE = eINSTANCE.getEObjectToAnnotationsMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.sidiff.superimposition.ConflictSeverity <em>Conflict Severity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.ConflictSeverity
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflictSeverity()
		 * @generated
		 */
		EEnum CONFLICT_SEVERITY = eINSTANCE.getConflictSeverity();

		/**
		 * The meta object literal for the '{@link org.sidiff.superimposition.ConflictType <em>Conflict Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.ConflictType
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getConflictType()
		 * @generated
		 */
		EEnum CONFLICT_TYPE = eINSTANCE.getConflictType();

		/**
		 * The meta object literal for the '<em>ISignature Calculator</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.superimposition.signature.ISignatureCalculator
		 * @see org.sidiff.superimposition.impl.SuperimpositionModelPackageImpl#getISignatureCalculator()
		 * @generated
		 */
		EDataType ISIGNATURE_CALCULATOR = eINSTANCE.getISignatureCalculator();

	}

} //SuperimpositionModelPackage

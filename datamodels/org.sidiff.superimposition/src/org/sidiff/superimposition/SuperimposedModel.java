/**
 */
package org.sidiff.superimposition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Entity;
import org.sidiff.entities.exporter.filter.IExporterFilter;
import org.sidiff.superimposition.signature.ISignatureCalculator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Superimposed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.SuperimposedModel#getDocType <em>Doc Type</em>}</li>
 *   <li>{@link org.sidiff.superimposition.SuperimposedModel#getElements <em>Elements</em>}</li>
 *   <li>{@link org.sidiff.superimposition.SuperimposedModel#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.superimposition.SuperimposedModel#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.sidiff.superimposition.SuperimposedModel#getSignatureCalculators <em>Signature Calculators</em>}</li>
 * </ul>
 *
 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedModel()
 * @model
 * @generated
 */
public interface SuperimposedModel extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Doc Type</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Doc Type</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Doc Type</em>' attribute list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedModel_DocType()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<String> getDocType();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.superimposition.SuperimposedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedModel_Elements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SuperimposedElement> getElements();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedModel_Type()
	 * @model required="true"
	 * @generated
	 */
	EList<EPackage> getType();

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.entities.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedModel_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

	/**
	 * Returns the value of the '<em><b>Signature Calculators</b></em>' attribute list.
	 * The list contents are of type {@link org.sidiff.superimposition.signature.ISignatureCalculator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Calculators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature Calculators</em>' attribute list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedModel_SignatureCalculators()
	 * @model dataType="org.sidiff.superimposition.ISignatureCalculator" required="true"
	 * @generated
	 */
	EList<ISignatureCalculator> getSignatureCalculators();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<SuperimposedElement> getElements(String signature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model filterDataType="org.sidiff.entities.IExporterFilter"
	 * @generated
	 */
	EList<Entity> getEntities(IExporterFilter filter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates a new ConflictSet for this SuperimposedModel using its elements, references and attributes as input.
	 * <!-- end-model-doc -->
	 * @model required="true" filterDataType="org.sidiff.entities.IExporterFilter"
	 * @generated
	 */
	ConflictSet createConflictSet(IExporterFilter filter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the first annotation of this superimposed model with the body equal to the argument.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Annotation getAnnotation(String body);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the first annotation of this superimposed model that is equal to the argument.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	Annotation getAnnotation(Annotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the first annotation of this superimposed model that is equal to the argument,
	 * adding it to the superimposed model and returning it, if none is found.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	Annotation getOrAddAnnotation(Annotation annotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Calculates a signature for the given EObject using the signature calculators of this superimposed model.
	 * 	 * The signature calculators are used in order, and the first non-null, non-empty signature is returned.
	 * 	 * Else null is returned.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String calculateSignature(EObject object);

} // SuperimposedModel

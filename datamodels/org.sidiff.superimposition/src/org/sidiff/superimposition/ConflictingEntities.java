/**
 * (c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.superimposition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflicting Entities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.ConflictingEntities#getContext <em>Context</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictingEntities#getConflictSet <em>Conflict Set</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictingEntities#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictingEntities#getEntities <em>Entities</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictingEntities#getReferences <em>References</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictingEntities#getElements <em>Elements</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictingEntities#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictingEntities()
 * @model
 * @generated
 */
public interface ConflictingEntities extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' attribute list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictingEntities_Entities()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group'"
	 * @generated
	 */
	FeatureMap getEntities();

	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.entities.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictingEntities_References()
	 * @model transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#entities'"
	 * @generated
	 */
	EList<Reference> getReferences();

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.entities.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictingEntities_Elements()
	 * @model transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#entities'"
	 * @generated
	 */
	EList<Element> getElements();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.entities.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictingEntities_Attributes()
	 * @model transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#entities'"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(SuperimposedElement)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictingEntities_Context()
	 * @model
	 * @generated
	 */
	SuperimposedElement getContext();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.ConflictingEntities#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(SuperimposedElement value);

	/**
	 * Returns the value of the '<em><b>Conflict Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.superimposition.ConflictSet#getConflicting <em>Conflicting</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflict Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflict Set</em>' container reference.
	 * @see #setConflictSet(ConflictSet)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictingEntities_ConflictSet()
	 * @see org.sidiff.superimposition.ConflictSet#getConflicting
	 * @model opposite="conflicting" required="true" transient="false"
	 * @generated
	 */
	ConflictSet getConflictSet();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.ConflictingEntities#getConflictSet <em>Conflict Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conflict Set</em>' container reference.
	 * @see #getConflictSet()
	 * @generated
	 */
	void setConflictSet(ConflictSet value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EStructuralFeature)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictingEntities_Type()
	 * @model
	 * @generated
	 */
	EStructuralFeature getType();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.ConflictingEntities#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EStructuralFeature value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Attribute> getAttributes(EAttribute type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Reference> getReferences(EReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Element> getElements(EClass type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns whether the conflicting entities refer to entities which have been removed or otherwise become invalid.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isInvalidated();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNumberOfConflictingFeatures();

} // ConflictingEntities

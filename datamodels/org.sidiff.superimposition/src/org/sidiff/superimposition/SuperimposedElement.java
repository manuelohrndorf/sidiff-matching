/**
 */
package org.sidiff.superimposition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import org.sidiff.entities.Annotation;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Superimposed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.SuperimposedElement#getObjects <em>Objects</em>}</li>
 *   <li>{@link org.sidiff.superimposition.SuperimposedElement#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link org.sidiff.superimposition.SuperimposedElement#getOwnedReferences <em>Owned References</em>}</li>
 *   <li>{@link org.sidiff.superimposition.SuperimposedElement#getObjectAnnotations <em>Object Annotations</em>}</li>
 * </ul>
 *
 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedElement()
 * @model
 * @generated
 */
public interface SuperimposedElement extends Element {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Objects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedElement_Objects()
	 * @model
	 * @generated
	 */
	EList<EObject> getObjects();

	/**
	 * Returns the value of the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.entities.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Attributes</em>' containment reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedElement_OwnedAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getOwnedAttributes();

	/**
	 * Returns the value of the '<em><b>Owned References</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.entities.Reference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned References</em>' containment reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedElement_OwnedReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Reference> getOwnedReferences();

	/**
	 * Returns the value of the '<em><b>Object Annotations</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EObject},
	 * and the value is of type list of {@link org.sidiff.entities.Annotation},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Annotations</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Annotations</em>' map.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getSuperimposedElement_ObjectAnnotations()
	 * @model mapType="org.sidiff.superimposition.EObjectToAnnotationsMapEntry&lt;org.eclipse.emf.ecore.EObject, org.sidiff.entities.Annotation&gt;"
	 * @generated
	 */
	EMap<EObject, EList<Annotation>> getObjectAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the first SuperimposedElement that contains this element with containment reference, or null if none.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	SuperimposedElement getContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns all SuperimposedElements that are contained by this element with a containment reference.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<SuperimposedElement> getContained();

} // SuperimposedElement

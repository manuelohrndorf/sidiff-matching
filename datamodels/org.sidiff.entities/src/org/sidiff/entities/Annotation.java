/**
 */
package org.sidiff.entities;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.sidiff.formula.Formula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.entities.Annotation#getBody <em>Body</em>}</li>
 *   <li>{@link org.sidiff.entities.Annotation#getFormula <em>Formula</em>}</li>
 *   <li>{@link org.sidiff.entities.Annotation#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.entities.Annotation#getEntities <em>Entities</em>}</li>
 * </ul>
 *
 * @see org.sidiff.entities.EntitiesPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Dennis Reuling, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' attribute.
	 * @see #setBody(String)
	 * @see org.sidiff.entities.EntitiesPackage#getAnnotation_Body()
	 * @model
	 * @generated
	 */
	String getBody();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.Annotation#getBody <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' attribute.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(String value);

	/**
	 * Returns the value of the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' containment reference.
	 * @see #setFormula(Formula)
	 * @see org.sidiff.entities.EntitiesPackage#getAnnotation_Formula()
	 * @model containment="true"
	 * @generated
	 */
	Formula getFormula();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.Annotation#getFormula <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' containment reference.
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(Formula value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.entities.AnnotationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.sidiff.entities.AnnotationType
	 * @see #setType(AnnotationType)
	 * @see org.sidiff.entities.EntitiesPackage#getAnnotation_Type()
	 * @model required="true"
	 * @generated
	 */
	AnnotationType getType();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.Annotation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.sidiff.entities.AnnotationType
	 * @see #getType()
	 * @generated
	 */
	void setType(AnnotationType value);

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.entities.Entity}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.entities.Entity#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' reference list.
	 * @see org.sidiff.entities.EntitiesPackage#getAnnotation_Entities()
	 * @see org.sidiff.entities.Entity#getAnnotations
	 * @model opposite="annotations" transient="true" ordered="false"
	 * @generated
	 */
	EList<Entity> getEntities();

} // Annotation

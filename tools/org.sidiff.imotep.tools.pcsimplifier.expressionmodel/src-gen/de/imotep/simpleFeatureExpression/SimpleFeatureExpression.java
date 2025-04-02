/**
 * generated by Xtext 2.10.0
 */
package de.imotep.simpleFeatureExpression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Feature Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.imotep.simpleFeatureExpression.SimpleFeatureExpression#getVar <em>Var</em>}</li>
 *   <li>{@link de.imotep.simpleFeatureExpression.SimpleFeatureExpression#getNeg <em>Neg</em>}</li>
 *   <li>{@link de.imotep.simpleFeatureExpression.SimpleFeatureExpression#getBraExpr <em>Bra Expr</em>}</li>
 * </ul>
 *
 * @see de.imotep.simpleFeatureExpression.SimpleFeatureExpressionPackage#getSimpleFeatureExpression()
 * @model
 * @generated
 */
public interface SimpleFeatureExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var</em>' attribute.
   * @see #setVar(String)
   * @see de.imotep.simpleFeatureExpression.SimpleFeatureExpressionPackage#getSimpleFeatureExpression_Var()
   * @model
   * @generated
   */
  String getVar();

  /**
   * Sets the value of the '{@link de.imotep.simpleFeatureExpression.SimpleFeatureExpression#getVar <em>Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var</em>' attribute.
   * @see #getVar()
   * @generated
   */
  void setVar(String value);

  /**
   * Returns the value of the '<em><b>Neg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Neg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Neg</em>' attribute.
   * @see #setNeg(String)
   * @see de.imotep.simpleFeatureExpression.SimpleFeatureExpressionPackage#getSimpleFeatureExpression_Neg()
   * @model
   * @generated
   */
  String getNeg();

  /**
   * Sets the value of the '{@link de.imotep.simpleFeatureExpression.SimpleFeatureExpression#getNeg <em>Neg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Neg</em>' attribute.
   * @see #getNeg()
   * @generated
   */
  void setNeg(String value);

  /**
   * Returns the value of the '<em><b>Bra Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bra Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bra Expr</em>' containment reference.
   * @see #setBraExpr(BracedExpression)
   * @see de.imotep.simpleFeatureExpression.SimpleFeatureExpressionPackage#getSimpleFeatureExpression_BraExpr()
   * @model containment="true"
   * @generated
   */
  BracedExpression getBraExpr();

  /**
   * Sets the value of the '{@link de.imotep.simpleFeatureExpression.SimpleFeatureExpression#getBraExpr <em>Bra Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bra Expr</em>' containment reference.
   * @see #getBraExpr()
   * @generated
   */
  void setBraExpr(BracedExpression value);

} // SimpleFeatureExpression

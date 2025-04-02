/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sidiff.uml.model.ModelPackage;

import org.sidiff.uml.model.classes.ClassesPackage;

import org.sidiff.uml.model.classes.impl.ClassesPackageImpl;

import org.sidiff.uml.model.core.CoreFactory;
import org.sidiff.uml.model.core.CorePackage;
import org.sidiff.uml.model.core.UMLComment;
import org.sidiff.uml.model.core.UMLDependency;
import org.sidiff.uml.model.core.UMLElement;
import org.sidiff.uml.model.core.UMLModel;
import org.sidiff.uml.model.core.UMLNamedElement;
import org.sidiff.uml.model.core.UMLPackage;
import org.sidiff.uml.model.core.UMLStereotype;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibility;
import org.sidiff.uml.model.core.UMLVisibleElement;

import org.sidiff.uml.model.impl.ModelPackageImpl;

import org.sidiff.uml.model.packages.PackagesPackage;

import org.sidiff.uml.model.packages.impl.PackagesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorePackageImpl extends EPackageImpl implements CorePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlVisibleElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlStereotypeableElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlStereotypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlNamedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum umlVisibilityEEnum = null;

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
   * @see org.sidiff.uml.model.core.CorePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private CorePackageImpl()
  {
    super(eNS_URI, CoreFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link CorePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static CorePackage init()
  {
    if (isInited) return (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

    // Obtain or create and register package
    CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CorePackageImpl());

    isInited = true;

    // Obtain or create and register interdependencies
    ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
    ClassesPackageImpl theClassesPackage = (ClassesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI) : ClassesPackage.eINSTANCE);
    PackagesPackageImpl thePackagesPackage = (PackagesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PackagesPackage.eNS_URI) instanceof PackagesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PackagesPackage.eNS_URI) : PackagesPackage.eINSTANCE);

    // Create package meta-data objects
    theCorePackage.createPackageContents();
    theModelPackage.createPackageContents();
    theClassesPackage.createPackageContents();
    thePackagesPackage.createPackageContents();

    // Initialize created meta-data
    theCorePackage.initializePackageContents();
    theModelPackage.initializePackageContents();
    theClassesPackage.initializePackageContents();
    thePackagesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCorePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(CorePackage.eNS_URI, theCorePackage);
    return theCorePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLVisibleElement()
  {
    return umlVisibleElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLVisibleElement_Visibility()
  {
    return (EAttribute)umlVisibleElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLPackage()
  {
    return umlPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPackage_Model()
  {
    return (EReference)umlPackageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPackage_Packages()
  {
    return (EReference)umlPackageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPackage_SuperPackage()
  {
    return (EReference)umlPackageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPackage_Classifiers()
  {
    return (EReference)umlPackageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPackage_StoredComments()
  {
    return (EReference)umlPackageEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPackage_Associations()
  {
    return (EReference)umlPackageEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPackage_Enumerations()
  {
    return (EReference)umlPackageEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPackage_PrimitiveTypes()
  {
    return (EReference)umlPackageEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLStereotypeableElement()
  {
    return umlStereotypeableElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLStereotypeableElement_Stereotypes()
  {
    return (EReference)umlStereotypeableElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLStereotype()
  {
    return umlStereotypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLStereotype_Model()
  {
    return (EReference)umlStereotypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLStereotype_StereotypedElements()
  {
    return (EReference)umlStereotypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLModel()
  {
    return umlModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLModel_Packages()
  {
    return (EReference)umlModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLModel_Stereotypes()
  {
    return (EReference)umlModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLElement()
  {
    return umlElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLElement_Id()
  {
    return (EAttribute)umlElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLElement_Comments()
  {
    return (EReference)umlElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLComment()
  {
    return umlCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLComment_Package()
  {
    return (EReference)umlCommentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLComment_Comment()
  {
    return (EAttribute)umlCommentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLComment_Elements()
  {
    return (EReference)umlCommentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLDependency()
  {
    return umlDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLDependency_Dependee()
  {
    return (EReference)umlDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLDependency_Supplier()
  {
    return (EReference)umlDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLNamedElement()
  {
    return umlNamedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLNamedElement_OutgoingDependencies()
  {
    return (EReference)umlNamedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLNamedElement_Dependees()
  {
    return (EReference)umlNamedElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLNamedElement_Name()
  {
    return (EAttribute)umlNamedElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getUMLVisibility()
  {
    return umlVisibilityEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CoreFactory getCoreFactory()
  {
    return (CoreFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    umlVisibleElementEClass = createEClass(UML_VISIBLE_ELEMENT);
    createEAttribute(umlVisibleElementEClass, UML_VISIBLE_ELEMENT__VISIBILITY);

    umlPackageEClass = createEClass(UML_PACKAGE);
    createEReference(umlPackageEClass, UML_PACKAGE__MODEL);
    createEReference(umlPackageEClass, UML_PACKAGE__PACKAGES);
    createEReference(umlPackageEClass, UML_PACKAGE__SUPER_PACKAGE);
    createEReference(umlPackageEClass, UML_PACKAGE__CLASSIFIERS);
    createEReference(umlPackageEClass, UML_PACKAGE__STORED_COMMENTS);
    createEReference(umlPackageEClass, UML_PACKAGE__ASSOCIATIONS);
    createEReference(umlPackageEClass, UML_PACKAGE__ENUMERATIONS);
    createEReference(umlPackageEClass, UML_PACKAGE__PRIMITIVE_TYPES);

    umlStereotypeableElementEClass = createEClass(UML_STEREOTYPEABLE_ELEMENT);
    createEReference(umlStereotypeableElementEClass, UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES);

    umlStereotypeEClass = createEClass(UML_STEREOTYPE);
    createEReference(umlStereotypeEClass, UML_STEREOTYPE__MODEL);
    createEReference(umlStereotypeEClass, UML_STEREOTYPE__STEREOTYPED_ELEMENTS);

    umlModelEClass = createEClass(UML_MODEL);
    createEReference(umlModelEClass, UML_MODEL__PACKAGES);
    createEReference(umlModelEClass, UML_MODEL__STEREOTYPES);

    umlElementEClass = createEClass(UML_ELEMENT);
    createEAttribute(umlElementEClass, UML_ELEMENT__ID);
    createEReference(umlElementEClass, UML_ELEMENT__COMMENTS);

    umlCommentEClass = createEClass(UML_COMMENT);
    createEReference(umlCommentEClass, UML_COMMENT__PACKAGE);
    createEAttribute(umlCommentEClass, UML_COMMENT__COMMENT);
    createEReference(umlCommentEClass, UML_COMMENT__ELEMENTS);

    umlDependencyEClass = createEClass(UML_DEPENDENCY);
    createEReference(umlDependencyEClass, UML_DEPENDENCY__DEPENDEE);
    createEReference(umlDependencyEClass, UML_DEPENDENCY__SUPPLIER);

    umlNamedElementEClass = createEClass(UML_NAMED_ELEMENT);
    createEReference(umlNamedElementEClass, UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES);
    createEReference(umlNamedElementEClass, UML_NAMED_ELEMENT__DEPENDEES);
    createEAttribute(umlNamedElementEClass, UML_NAMED_ELEMENT__NAME);

    // Create enums
    umlVisibilityEEnum = createEEnum(UML_VISIBILITY);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    ClassesPackage theClassesPackage = (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    umlPackageEClass.getESuperTypes().add(this.getUMLNamedElement());
    umlPackageEClass.getESuperTypes().add(this.getUMLStereotypeableElement());
    umlPackageEClass.getESuperTypes().add(this.getUMLVisibleElement());
    umlStereotypeEClass.getESuperTypes().add(this.getUMLNamedElement());
    umlModelEClass.getESuperTypes().add(this.getUMLNamedElement());
    umlDependencyEClass.getESuperTypes().add(this.getUMLNamedElement());
    umlDependencyEClass.getESuperTypes().add(this.getUMLStereotypeableElement());
    umlNamedElementEClass.getESuperTypes().add(this.getUMLElement());

    // Initialize classes and features; add operations and parameters
    initEClass(umlVisibleElementEClass, UMLVisibleElement.class, "UMLVisibleElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLVisibleElement_Visibility(), this.getUMLVisibility(), "visibility", null, 1, 1, UMLVisibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlPackageEClass, UMLPackage.class, "UMLPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLPackage_Model(), this.getUMLModel(), this.getUMLModel_Packages(), "model", null, 0, 1, UMLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLPackage_Packages(), this.getUMLPackage(), this.getUMLPackage_SuperPackage(), "packages", null, 0, -1, UMLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLPackage_SuperPackage(), this.getUMLPackage(), this.getUMLPackage_Packages(), "superPackage", null, 0, 1, UMLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLPackage_Classifiers(), theClassesPackage.getUMLClassifier(), theClassesPackage.getUMLClassifier_Package(), "classifiers", null, 0, -1, UMLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLPackage_StoredComments(), this.getUMLComment(), this.getUMLComment_Package(), "storedComments", null, 0, -1, UMLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLPackage_Associations(), theClassesPackage.getUMLAssociation(), theClassesPackage.getUMLAssociation_Package(), "associations", null, 0, -1, UMLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLPackage_Enumerations(), theClassesPackage.getUMLEnumeration(), theClassesPackage.getUMLEnumeration_Package(), "enumerations", null, 0, -1, UMLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLPackage_PrimitiveTypes(), theClassesPackage.getUMLPrimitiveType(), theClassesPackage.getUMLPrimitiveType_Package(), "primitiveTypes", null, 0, -1, UMLPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlStereotypeableElementEClass, UMLStereotypeableElement.class, "UMLStereotypeableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLStereotypeableElement_Stereotypes(), this.getUMLStereotype(), this.getUMLStereotype_StereotypedElements(), "stereotypes", null, 0, -1, UMLStereotypeableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlStereotypeEClass, UMLStereotype.class, "UMLStereotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLStereotype_Model(), this.getUMLModel(), this.getUMLModel_Stereotypes(), "model", null, 1, 1, UMLStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLStereotype_StereotypedElements(), this.getUMLStereotypeableElement(), this.getUMLStereotypeableElement_Stereotypes(), "stereotypedElements", null, 0, -1, UMLStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlModelEClass, UMLModel.class, "UMLModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLModel_Packages(), this.getUMLPackage(), this.getUMLPackage_Model(), "packages", null, 0, -1, UMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLModel_Stereotypes(), this.getUMLStereotype(), this.getUMLStereotype_Model(), "stereotypes", null, 0, -1, UMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlElementEClass, UMLElement.class, "UMLElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLElement_Id(), ecorePackage.getEString(), "id", null, 1, 1, UMLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLElement_Comments(), this.getUMLComment(), this.getUMLComment_Elements(), "comments", null, 0, -1, UMLElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlCommentEClass, UMLComment.class, "UMLComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLComment_Package(), this.getUMLPackage(), this.getUMLPackage_StoredComments(), "package", null, 1, 1, UMLComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLComment_Comment(), ecorePackage.getEString(), "comment", null, 1, 1, UMLComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLComment_Elements(), this.getUMLElement(), this.getUMLElement_Comments(), "elements", null, 0, -1, UMLComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlDependencyEClass, UMLDependency.class, "UMLDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLDependency_Dependee(), this.getUMLNamedElement(), this.getUMLNamedElement_OutgoingDependencies(), "dependee", null, 1, 1, UMLDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLDependency_Supplier(), this.getUMLNamedElement(), this.getUMLNamedElement_Dependees(), "supplier", null, 1, 1, UMLDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlNamedElementEClass, UMLNamedElement.class, "UMLNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLNamedElement_OutgoingDependencies(), this.getUMLDependency(), this.getUMLDependency_Dependee(), "outgoingDependencies", null, 0, -1, UMLNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLNamedElement_Dependees(), this.getUMLDependency(), this.getUMLDependency_Supplier(), "dependees", null, 0, -1, UMLNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, UMLNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(umlVisibilityEEnum, UMLVisibility.class, "UMLVisibility");
    addEEnumLiteral(umlVisibilityEEnum, UMLVisibility.PUBLIC);
    addEEnumLiteral(umlVisibilityEEnum, UMLVisibility.PROTECTED);
    addEEnumLiteral(umlVisibilityEEnum, UMLVisibility.PRIVATE);
    addEEnumLiteral(umlVisibilityEEnum, UMLVisibility.PACKAGE);

    // Create annotations
    // INCOMING
    createINCOMINGAnnotations();
    // IGNOREDIFF
    createIGNOREDIFFAnnotations();
  }

  /**
   * Initializes the annotations for <b>INCOMING</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createINCOMINGAnnotations()
  {
    String source = "INCOMING";		
    addAnnotation
      (getUMLStereotype_StereotypedElements(), 
       source, 
       new String[] 
       {
       });			
    addAnnotation
      (getUMLComment_Elements(), 
       source, 
       new String[] 
       {
       });			
    addAnnotation
      (getUMLNamedElement_Dependees(), 
       source, 
       new String[] 
       {
       });	
  }

  /**
   * Initializes the annotations for <b>IGNOREDIFF</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createIGNOREDIFFAnnotations()
  {
    String source = "IGNOREDIFF";			
    addAnnotation
      (getUMLStereotype_StereotypedElements(), 
       source, 
       new String[] 
       {
       });			
    addAnnotation
      (getUMLComment_Elements(), 
       source, 
       new String[] 
       {
       });			
    addAnnotation
      (getUMLNamedElement_Dependees(), 
       source, 
       new String[] 
       {
       });
  }

} //CorePackageImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sidiff.uml.model.ModelPackage;

import org.sidiff.uml.model.classes.ClassesFactory;
import org.sidiff.uml.model.classes.ClassesPackage;
import org.sidiff.uml.model.classes.UMLAggregationKind;
import org.sidiff.uml.model.classes.UMLAssociation;
import org.sidiff.uml.model.classes.UMLAssociationClass;
import org.sidiff.uml.model.classes.UMLAssociationEnd;
import org.sidiff.uml.model.classes.UMLAttribute;
import org.sidiff.uml.model.classes.UMLBindingElement;
import org.sidiff.uml.model.classes.UMLClass;
import org.sidiff.uml.model.classes.UMLClassifier;
import org.sidiff.uml.model.classes.UMLEnumeration;
import org.sidiff.uml.model.classes.UMLGeneralizableElement;
import org.sidiff.uml.model.classes.UMLGeneralization;
import org.sidiff.uml.model.classes.UMLInterface;
import org.sidiff.uml.model.classes.UMLLiteral;
import org.sidiff.uml.model.classes.UMLOperation;
import org.sidiff.uml.model.classes.UMLParameter;
import org.sidiff.uml.model.classes.UMLParameterKind;
import org.sidiff.uml.model.classes.UMLPrimitiveType;
import org.sidiff.uml.model.classes.UMLTemplateBinding;
import org.sidiff.uml.model.classes.UMLTemplateParameter;
import org.sidiff.uml.model.classes.UMLTemplateableElement;
import org.sidiff.uml.model.classes.UMLType;
import org.sidiff.uml.model.classes.UMLTypedElement;

import org.sidiff.uml.model.core.CorePackage;

import org.sidiff.uml.model.core.impl.CorePackageImpl;

import org.sidiff.uml.model.impl.ModelPackageImpl;

import org.sidiff.uml.model.packages.PackagesPackage;

import org.sidiff.uml.model.packages.impl.PackagesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassesPackageImpl extends EPackageImpl implements ClassesPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlAssociationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlClassifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlTypedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlGeneralizableElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlGeneralizationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlBindingElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlTemplateBindingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlTemplateParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlTemplateableElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlAssociationEndEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlEnumerationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlPrimitiveTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlAssociationClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlInterfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass umlAttributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum umlAggregationKindEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum umlParameterKindEEnum = null;

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
   * @see org.sidiff.uml.model.classes.ClassesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ClassesPackageImpl()
  {
    super(eNS_URI, ClassesFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ClassesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ClassesPackage init()
  {
    if (isInited) return (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);

    // Obtain or create and register package
    ClassesPackageImpl theClassesPackage = (ClassesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ClassesPackageImpl());

    isInited = true;

    // Obtain or create and register interdependencies
    ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
    CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
    PackagesPackageImpl thePackagesPackage = (PackagesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PackagesPackage.eNS_URI) instanceof PackagesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PackagesPackage.eNS_URI) : PackagesPackage.eINSTANCE);

    // Create package meta-data objects
    theClassesPackage.createPackageContents();
    theModelPackage.createPackageContents();
    theCorePackage.createPackageContents();
    thePackagesPackage.createPackageContents();

    // Initialize created meta-data
    theClassesPackage.initializePackageContents();
    theModelPackage.initializePackageContents();
    theCorePackage.initializePackageContents();
    thePackagesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theClassesPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ClassesPackage.eNS_URI, theClassesPackage);
    return theClassesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLAssociation()
  {
    return umlAssociationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLAssociation_AssociationEnds()
  {
    return (EReference)umlAssociationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLAssociation_Package()
  {
    return (EReference)umlAssociationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLClassifier()
  {
    return umlClassifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLClassifier_TargetedByAssociationEnds()
  {
    return (EReference)umlClassifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLClassifier_Package()
  {
    return (EReference)umlClassifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLType()
  {
    return umlTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLType_UsedByElements()
  {
    return (EReference)umlTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLTypedElement()
  {
    return umlTypedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTypedElement_Type()
  {
    return (EReference)umlTypedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLGeneralizableElement()
  {
    return umlGeneralizableElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLGeneralizableElement_Specializations()
  {
    return (EReference)umlGeneralizableElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLGeneralizableElement_Generalizations()
  {
    return (EReference)umlGeneralizableElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLGeneralization()
  {
    return umlGeneralizationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLGeneralization_SpecialElement()
  {
    return (EReference)umlGeneralizationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLGeneralization_GeneralElement()
  {
    return (EReference)umlGeneralizationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLBindingElement()
  {
    return umlBindingElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLBindingElement_TemplateBindings()
  {
    return (EReference)umlBindingElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLTemplateBinding()
  {
    return umlTemplateBindingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTemplateBinding_FormalParam()
  {
    return (EReference)umlTemplateBindingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLTemplateBinding_ActualParam()
  {
    return (EAttribute)umlTemplateBindingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTemplateBinding_Binder()
  {
    return (EReference)umlTemplateBindingEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLTemplateParameter()
  {
    return umlTemplateParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTemplateParameter_TemplateableElement()
  {
    return (EReference)umlTemplateParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLTemplateParameter_Type()
  {
    return (EAttribute)umlTemplateParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTemplateParameter_Bindings()
  {
    return (EReference)umlTemplateParameterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLTemplateableElement()
  {
    return umlTemplateableElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLTemplateableElement_TemplateParameters()
  {
    return (EReference)umlTemplateableElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLAssociationEnd()
  {
    return umlAssociationEndEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLAssociationEnd_Association()
  {
    return (EReference)umlAssociationEndEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLAssociationEnd_Multiplicity()
  {
    return (EAttribute)umlAssociationEndEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLAssociationEnd_IsNavigable()
  {
    return (EAttribute)umlAssociationEndEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLAssociationEnd_Kind()
  {
    return (EAttribute)umlAssociationEndEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLAssociationEnd_IsOrdered()
  {
    return (EAttribute)umlAssociationEndEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLAssociationEnd_Target()
  {
    return (EReference)umlAssociationEndEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLEnumeration()
  {
    return umlEnumerationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLEnumeration_Literals()
  {
    return (EReference)umlEnumerationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLEnumeration_Package()
  {
    return (EReference)umlEnumerationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLLiteral()
  {
    return umlLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLLiteral_Enumeration()
  {
    return (EReference)umlLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLPrimitiveType()
  {
    return umlPrimitiveTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLPrimitiveType_Package()
  {
    return (EReference)umlPrimitiveTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLAssociationClass()
  {
    return umlAssociationClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLClass()
  {
    return umlClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLClass_IsAbstract()
  {
    return (EAttribute)umlClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLClass_IsFinal()
  {
    return (EAttribute)umlClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLClass_Operations()
  {
    return (EReference)umlClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLClass_Attributes()
  {
    return (EReference)umlClassEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLOperation()
  {
    return umlOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLOperation_IsAbstract()
  {
    return (EAttribute)umlOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLOperation_IsStatic()
  {
    return (EAttribute)umlOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLOperation_Interface()
  {
    return (EReference)umlOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLOperation_Parameters()
  {
    return (EReference)umlOperationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLOperation_Class()
  {
    return (EReference)umlOperationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLInterface()
  {
    return umlInterfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLInterface_Operations()
  {
    return (EReference)umlInterfaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLParameter()
  {
    return umlParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLParameter_Kind()
  {
    return (EAttribute)umlParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLParameter_Operation()
  {
    return (EReference)umlParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUMLAttribute()
  {
    return umlAttributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLAttribute_IsStatic()
  {
    return (EAttribute)umlAttributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLAttribute_IsFinal()
  {
    return (EAttribute)umlAttributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUMLAttribute_IsReadOnly()
  {
    return (EAttribute)umlAttributeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUMLAttribute_Class()
  {
    return (EReference)umlAttributeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getUMLAggregationKind()
  {
    return umlAggregationKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getUMLParameterKind()
  {
    return umlParameterKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassesFactory getClassesFactory()
  {
    return (ClassesFactory)getEFactoryInstance();
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
    umlAssociationEClass = createEClass(UML_ASSOCIATION);
    createEReference(umlAssociationEClass, UML_ASSOCIATION__ASSOCIATION_ENDS);
    createEReference(umlAssociationEClass, UML_ASSOCIATION__PACKAGE);

    umlClassifierEClass = createEClass(UML_CLASSIFIER);
    createEReference(umlClassifierEClass, UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS);
    createEReference(umlClassifierEClass, UML_CLASSIFIER__PACKAGE);

    umlTypeEClass = createEClass(UML_TYPE);
    createEReference(umlTypeEClass, UML_TYPE__USED_BY_ELEMENTS);

    umlTypedElementEClass = createEClass(UML_TYPED_ELEMENT);
    createEReference(umlTypedElementEClass, UML_TYPED_ELEMENT__TYPE);

    umlGeneralizableElementEClass = createEClass(UML_GENERALIZABLE_ELEMENT);
    createEReference(umlGeneralizableElementEClass, UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS);
    createEReference(umlGeneralizableElementEClass, UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS);

    umlGeneralizationEClass = createEClass(UML_GENERALIZATION);
    createEReference(umlGeneralizationEClass, UML_GENERALIZATION__SPECIAL_ELEMENT);
    createEReference(umlGeneralizationEClass, UML_GENERALIZATION__GENERAL_ELEMENT);

    umlBindingElementEClass = createEClass(UML_BINDING_ELEMENT);
    createEReference(umlBindingElementEClass, UML_BINDING_ELEMENT__TEMPLATE_BINDINGS);

    umlTemplateBindingEClass = createEClass(UML_TEMPLATE_BINDING);
    createEReference(umlTemplateBindingEClass, UML_TEMPLATE_BINDING__FORMAL_PARAM);
    createEAttribute(umlTemplateBindingEClass, UML_TEMPLATE_BINDING__ACTUAL_PARAM);
    createEReference(umlTemplateBindingEClass, UML_TEMPLATE_BINDING__BINDER);

    umlTemplateParameterEClass = createEClass(UML_TEMPLATE_PARAMETER);
    createEReference(umlTemplateParameterEClass, UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT);
    createEAttribute(umlTemplateParameterEClass, UML_TEMPLATE_PARAMETER__TYPE);
    createEReference(umlTemplateParameterEClass, UML_TEMPLATE_PARAMETER__BINDINGS);

    umlTemplateableElementEClass = createEClass(UML_TEMPLATEABLE_ELEMENT);
    createEReference(umlTemplateableElementEClass, UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS);

    umlAssociationEndEClass = createEClass(UML_ASSOCIATION_END);
    createEReference(umlAssociationEndEClass, UML_ASSOCIATION_END__ASSOCIATION);
    createEAttribute(umlAssociationEndEClass, UML_ASSOCIATION_END__MULTIPLICITY);
    createEAttribute(umlAssociationEndEClass, UML_ASSOCIATION_END__IS_NAVIGABLE);
    createEAttribute(umlAssociationEndEClass, UML_ASSOCIATION_END__KIND);
    createEAttribute(umlAssociationEndEClass, UML_ASSOCIATION_END__IS_ORDERED);
    createEReference(umlAssociationEndEClass, UML_ASSOCIATION_END__TARGET);

    umlEnumerationEClass = createEClass(UML_ENUMERATION);
    createEReference(umlEnumerationEClass, UML_ENUMERATION__LITERALS);
    createEReference(umlEnumerationEClass, UML_ENUMERATION__PACKAGE);

    umlLiteralEClass = createEClass(UML_LITERAL);
    createEReference(umlLiteralEClass, UML_LITERAL__ENUMERATION);

    umlPrimitiveTypeEClass = createEClass(UML_PRIMITIVE_TYPE);
    createEReference(umlPrimitiveTypeEClass, UML_PRIMITIVE_TYPE__PACKAGE);

    umlAssociationClassEClass = createEClass(UML_ASSOCIATION_CLASS);

    umlClassEClass = createEClass(UML_CLASS);
    createEAttribute(umlClassEClass, UML_CLASS__IS_ABSTRACT);
    createEAttribute(umlClassEClass, UML_CLASS__IS_FINAL);
    createEReference(umlClassEClass, UML_CLASS__OPERATIONS);
    createEReference(umlClassEClass, UML_CLASS__ATTRIBUTES);

    umlOperationEClass = createEClass(UML_OPERATION);
    createEAttribute(umlOperationEClass, UML_OPERATION__IS_ABSTRACT);
    createEAttribute(umlOperationEClass, UML_OPERATION__IS_STATIC);
    createEReference(umlOperationEClass, UML_OPERATION__INTERFACE);
    createEReference(umlOperationEClass, UML_OPERATION__PARAMETERS);
    createEReference(umlOperationEClass, UML_OPERATION__CLASS);

    umlInterfaceEClass = createEClass(UML_INTERFACE);
    createEReference(umlInterfaceEClass, UML_INTERFACE__OPERATIONS);

    umlParameterEClass = createEClass(UML_PARAMETER);
    createEAttribute(umlParameterEClass, UML_PARAMETER__KIND);
    createEReference(umlParameterEClass, UML_PARAMETER__OPERATION);

    umlAttributeEClass = createEClass(UML_ATTRIBUTE);
    createEAttribute(umlAttributeEClass, UML_ATTRIBUTE__IS_STATIC);
    createEAttribute(umlAttributeEClass, UML_ATTRIBUTE__IS_FINAL);
    createEAttribute(umlAttributeEClass, UML_ATTRIBUTE__IS_READ_ONLY);
    createEReference(umlAttributeEClass, UML_ATTRIBUTE__CLASS);

    // Create enums
    umlAggregationKindEEnum = createEEnum(UML_AGGREGATION_KIND);
    umlParameterKindEEnum = createEEnum(UML_PARAMETER_KIND);
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
    CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    umlAssociationEClass.getESuperTypes().add(theCorePackage.getUMLNamedElement());
    umlAssociationEClass.getESuperTypes().add(this.getUMLGeneralizableElement());
    umlAssociationEClass.getESuperTypes().add(theCorePackage.getUMLStereotypeableElement());
    umlClassifierEClass.getESuperTypes().add(this.getUMLType());
    umlClassifierEClass.getESuperTypes().add(this.getUMLGeneralizableElement());
    umlClassifierEClass.getESuperTypes().add(this.getUMLBindingElement());
    umlClassifierEClass.getESuperTypes().add(theCorePackage.getUMLStereotypeableElement());
    umlClassifierEClass.getESuperTypes().add(this.getUMLTemplateableElement());
    umlClassifierEClass.getESuperTypes().add(theCorePackage.getUMLVisibleElement());
    umlTypeEClass.getESuperTypes().add(theCorePackage.getUMLNamedElement());
    umlGeneralizationEClass.getESuperTypes().add(theCorePackage.getUMLElement());
    umlTemplateBindingEClass.getESuperTypes().add(theCorePackage.getUMLElement());
    umlTemplateParameterEClass.getESuperTypes().add(theCorePackage.getUMLElement());
    umlAssociationEndEClass.getESuperTypes().add(theCorePackage.getUMLNamedElement());
    umlAssociationEndEClass.getESuperTypes().add(theCorePackage.getUMLStereotypeableElement());
    umlEnumerationEClass.getESuperTypes().add(this.getUMLType());
    umlEnumerationEClass.getESuperTypes().add(theCorePackage.getUMLNamedElement());
    umlEnumerationEClass.getESuperTypes().add(theCorePackage.getUMLVisibleElement());
    umlLiteralEClass.getESuperTypes().add(theCorePackage.getUMLNamedElement());
    umlPrimitiveTypeEClass.getESuperTypes().add(this.getUMLType());
    umlAssociationClassEClass.getESuperTypes().add(this.getUMLAssociation());
    umlClassEClass.getESuperTypes().add(this.getUMLClassifier());
    umlOperationEClass.getESuperTypes().add(theCorePackage.getUMLNamedElement());
    umlOperationEClass.getESuperTypes().add(theCorePackage.getUMLStereotypeableElement());
    umlOperationEClass.getESuperTypes().add(this.getUMLTypedElement());
    umlOperationEClass.getESuperTypes().add(theCorePackage.getUMLVisibleElement());
    umlInterfaceEClass.getESuperTypes().add(this.getUMLClassifier());
    umlParameterEClass.getESuperTypes().add(theCorePackage.getUMLNamedElement());
    umlParameterEClass.getESuperTypes().add(theCorePackage.getUMLStereotypeableElement());
    umlParameterEClass.getESuperTypes().add(this.getUMLTypedElement());
    umlAttributeEClass.getESuperTypes().add(theCorePackage.getUMLNamedElement());
    umlAttributeEClass.getESuperTypes().add(theCorePackage.getUMLStereotypeableElement());
    umlAttributeEClass.getESuperTypes().add(this.getUMLTypedElement());
    umlAttributeEClass.getESuperTypes().add(theCorePackage.getUMLVisibleElement());

    // Initialize classes and features; add operations and parameters
    initEClass(umlAssociationEClass, UMLAssociation.class, "UMLAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLAssociation_AssociationEnds(), this.getUMLAssociationEnd(), this.getUMLAssociationEnd_Association(), "associationEnds", null, 0, -1, UMLAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLAssociation_Package(), theCorePackage.getUMLPackage(), theCorePackage.getUMLPackage_Associations(), "package", null, 1, 1, UMLAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlClassifierEClass, UMLClassifier.class, "UMLClassifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLClassifier_TargetedByAssociationEnds(), this.getUMLAssociationEnd(), this.getUMLAssociationEnd_Target(), "targetedByAssociationEnds", null, 0, -1, UMLClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLClassifier_Package(), theCorePackage.getUMLPackage(), theCorePackage.getUMLPackage_Classifiers(), "package", null, 1, 1, UMLClassifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlTypeEClass, UMLType.class, "UMLType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLType_UsedByElements(), this.getUMLTypedElement(), this.getUMLTypedElement_Type(), "usedByElements", null, 0, -1, UMLType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlTypedElementEClass, UMLTypedElement.class, "UMLTypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLTypedElement_Type(), this.getUMLType(), this.getUMLType_UsedByElements(), "type", null, 0, 1, UMLTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlGeneralizableElementEClass, UMLGeneralizableElement.class, "UMLGeneralizableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLGeneralizableElement_Specializations(), this.getUMLGeneralization(), this.getUMLGeneralization_GeneralElement(), "specializations", null, 0, -1, UMLGeneralizableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLGeneralizableElement_Generalizations(), this.getUMLGeneralization(), this.getUMLGeneralization_SpecialElement(), "generalizations", null, 0, -1, UMLGeneralizableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlGeneralizationEClass, UMLGeneralization.class, "UMLGeneralization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLGeneralization_SpecialElement(), this.getUMLGeneralizableElement(), this.getUMLGeneralizableElement_Generalizations(), "specialElement", null, 1, 1, UMLGeneralization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLGeneralization_GeneralElement(), this.getUMLGeneralizableElement(), this.getUMLGeneralizableElement_Specializations(), "generalElement", null, 1, 1, UMLGeneralization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlBindingElementEClass, UMLBindingElement.class, "UMLBindingElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLBindingElement_TemplateBindings(), this.getUMLTemplateBinding(), this.getUMLTemplateBinding_Binder(), "templateBindings", null, 0, -1, UMLBindingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlTemplateBindingEClass, UMLTemplateBinding.class, "UMLTemplateBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLTemplateBinding_FormalParam(), this.getUMLTemplateParameter(), this.getUMLTemplateParameter_Bindings(), "formalParam", null, 1, 1, UMLTemplateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLTemplateBinding_ActualParam(), ecorePackage.getEString(), "actualParam", null, 1, 1, UMLTemplateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLTemplateBinding_Binder(), this.getUMLBindingElement(), this.getUMLBindingElement_TemplateBindings(), "binder", null, 1, 1, UMLTemplateBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlTemplateParameterEClass, UMLTemplateParameter.class, "UMLTemplateParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLTemplateParameter_TemplateableElement(), this.getUMLTemplateableElement(), this.getUMLTemplateableElement_TemplateParameters(), "templateableElement", null, 1, 1, UMLTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLTemplateParameter_Type(), ecorePackage.getEString(), "type", null, 1, 1, UMLTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLTemplateParameter_Bindings(), this.getUMLTemplateBinding(), this.getUMLTemplateBinding_FormalParam(), "bindings", null, 0, -1, UMLTemplateParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlTemplateableElementEClass, UMLTemplateableElement.class, "UMLTemplateableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLTemplateableElement_TemplateParameters(), this.getUMLTemplateParameter(), this.getUMLTemplateParameter_TemplateableElement(), "templateParameters", null, 0, -1, UMLTemplateableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(umlAssociationEndEClass, UMLAssociationEnd.class, "UMLAssociationEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLAssociationEnd_Association(), this.getUMLAssociation(), this.getUMLAssociation_AssociationEnds(), "association", null, 1, 1, UMLAssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLAssociationEnd_Multiplicity(), ecorePackage.getEString(), "multiplicity", null, 1, 1, UMLAssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLAssociationEnd_IsNavigable(), ecorePackage.getEBoolean(), "isNavigable", null, 1, 1, UMLAssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLAssociationEnd_Kind(), this.getUMLAggregationKind(), "kind", null, 1, 1, UMLAssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLAssociationEnd_IsOrdered(), ecorePackage.getEBoolean(), "isOrdered", null, 1, 1, UMLAssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLAssociationEnd_Target(), this.getUMLClassifier(), this.getUMLClassifier_TargetedByAssociationEnds(), "target", null, 1, 1, UMLAssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlEnumerationEClass, UMLEnumeration.class, "UMLEnumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLEnumeration_Literals(), this.getUMLLiteral(), this.getUMLLiteral_Enumeration(), "literals", null, 0, -1, UMLEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLEnumeration_Package(), theCorePackage.getUMLPackage(), theCorePackage.getUMLPackage_Enumerations(), "package", null, 1, 1, UMLEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlLiteralEClass, UMLLiteral.class, "UMLLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLLiteral_Enumeration(), this.getUMLEnumeration(), this.getUMLEnumeration_Literals(), "enumeration", null, 1, 1, UMLLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlPrimitiveTypeEClass, UMLPrimitiveType.class, "UMLPrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLPrimitiveType_Package(), theCorePackage.getUMLPackage(), theCorePackage.getUMLPackage_PrimitiveTypes(), "package", null, 1, 1, UMLPrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlAssociationClassEClass, UMLAssociationClass.class, "UMLAssociationClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(umlClassEClass, UMLClass.class, "UMLClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLClass_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, UMLClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLClass_IsFinal(), ecorePackage.getEBoolean(), "isFinal", null, 1, 1, UMLClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLClass_Operations(), this.getUMLOperation(), this.getUMLOperation_Class(), "operations", null, 0, -1, UMLClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLClass_Attributes(), this.getUMLAttribute(), this.getUMLAttribute_Class(), "attributes", null, 0, -1, UMLClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlOperationEClass, UMLOperation.class, "UMLOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLOperation_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, UMLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLOperation_IsStatic(), ecorePackage.getEBoolean(), "isStatic", null, 1, 1, UMLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLOperation_Interface(), this.getUMLInterface(), this.getUMLInterface_Operations(), "interface", null, 0, 1, UMLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLOperation_Parameters(), this.getUMLParameter(), this.getUMLParameter_Operation(), "parameters", null, 0, -1, UMLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLOperation_Class(), this.getUMLClass(), this.getUMLClass_Operations(), "class", null, 0, 1, UMLOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlInterfaceEClass, UMLInterface.class, "UMLInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUMLInterface_Operations(), this.getUMLOperation(), this.getUMLOperation_Interface(), "operations", null, 0, -1, UMLInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlParameterEClass, UMLParameter.class, "UMLParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLParameter_Kind(), this.getUMLParameterKind(), "kind", null, 1, 1, UMLParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLParameter_Operation(), this.getUMLOperation(), this.getUMLOperation_Parameters(), "operation", null, 1, 1, UMLParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(umlAttributeEClass, UMLAttribute.class, "UMLAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUMLAttribute_IsStatic(), ecorePackage.getEBoolean(), "isStatic", null, 1, 1, UMLAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLAttribute_IsFinal(), ecorePackage.getEBoolean(), "isFinal", null, 1, 1, UMLAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getUMLAttribute_IsReadOnly(), ecorePackage.getEBoolean(), "isReadOnly", null, 1, 1, UMLAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getUMLAttribute_Class(), this.getUMLClass(), this.getUMLClass_Attributes(), "class", null, 0, 1, UMLAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(umlAggregationKindEEnum, UMLAggregationKind.class, "UMLAggregationKind");
    addEEnumLiteral(umlAggregationKindEEnum, UMLAggregationKind.NONE);
    addEEnumLiteral(umlAggregationKindEEnum, UMLAggregationKind.SHARED);
    addEEnumLiteral(umlAggregationKindEEnum, UMLAggregationKind.COMPOSITE);

    initEEnum(umlParameterKindEEnum, UMLParameterKind.class, "UMLParameterKind");
    addEEnumLiteral(umlParameterKindEEnum, UMLParameterKind.IN);
    addEEnumLiteral(umlParameterKindEEnum, UMLParameterKind.OUT);
    addEEnumLiteral(umlParameterKindEEnum, UMLParameterKind.INOUT);

    // Create annotations
    // INCOMING
    createINCOMINGAnnotations();
    // IGNOREDIFF
    createIGNOREDIFFAnnotations();
    // AbsolutePosition
    createAbsolutePositionAnnotations();
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
      (getUMLClassifier_TargetedByAssociationEnds(), 
       source, 
       new String[] 
       {
       });			
    addAnnotation
      (getUMLType_UsedByElements(), 
       source, 
       new String[] 
       {
       });			
    addAnnotation
      (getUMLGeneralizableElement_Specializations(), 
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
      (getUMLClassifier_TargetedByAssociationEnds(), 
       source, 
       new String[] 
       {
       });			
    addAnnotation
      (getUMLType_UsedByElements(), 
       source, 
       new String[] 
       {
       });			
    addAnnotation
      (getUMLGeneralizableElement_Specializations(), 
       source, 
       new String[] 
       {
       });	
  }

  /**
   * Initializes the annotations for <b>AbsolutePosition</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createAbsolutePositionAnnotations()
  {
    String source = "AbsolutePosition";								
    addAnnotation
      (getUMLTemplateableElement_TemplateParameters(), 
       source, 
       new String[] 
       {
       });
  }

} //ClassesPackageImpl

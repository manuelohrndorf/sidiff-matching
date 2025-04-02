/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.packages.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.sidiff.uml.model.ModelPackage;

import org.sidiff.uml.model.classes.ClassesPackage;

import org.sidiff.uml.model.classes.impl.ClassesPackageImpl;

import org.sidiff.uml.model.core.CorePackage;

import org.sidiff.uml.model.core.impl.CorePackageImpl;

import org.sidiff.uml.model.impl.ModelPackageImpl;

import org.sidiff.uml.model.packages.Dummy;
import org.sidiff.uml.model.packages.PackagesFactory;
import org.sidiff.uml.model.packages.PackagesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PackagesPackageImpl extends EPackageImpl implements PackagesPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dummyEClass = null;

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
   * @see org.sidiff.uml.model.packages.PackagesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PackagesPackageImpl()
  {
    super(eNS_URI, PackagesFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link PackagesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PackagesPackage init()
  {
    if (isInited) return (PackagesPackage)EPackage.Registry.INSTANCE.getEPackage(PackagesPackage.eNS_URI);

    // Obtain or create and register package
    PackagesPackageImpl thePackagesPackage = (PackagesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PackagesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PackagesPackageImpl());

    isInited = true;

    // Obtain or create and register interdependencies
    ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
    ClassesPackageImpl theClassesPackage = (ClassesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI) : ClassesPackage.eINSTANCE);
    CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);

    // Create package meta-data objects
    thePackagesPackage.createPackageContents();
    theModelPackage.createPackageContents();
    theClassesPackage.createPackageContents();
    theCorePackage.createPackageContents();

    // Initialize created meta-data
    thePackagesPackage.initializePackageContents();
    theModelPackage.initializePackageContents();
    theClassesPackage.initializePackageContents();
    theCorePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePackagesPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PackagesPackage.eNS_URI, thePackagesPackage);
    return thePackagesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDummy()
  {
    return dummyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackagesFactory getPackagesFactory()
  {
    return (PackagesFactory)getEFactoryInstance();
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
    dummyEClass = createEClass(DUMMY);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(dummyEClass, Dummy.class, "Dummy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
  }

} //PackagesPackageImpl

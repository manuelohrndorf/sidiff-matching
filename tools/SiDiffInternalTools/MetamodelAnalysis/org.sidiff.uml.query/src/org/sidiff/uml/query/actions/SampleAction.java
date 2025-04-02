package org.sidiff.uml.query.actions;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.uml.query.PrintUtil;
import org.sidiff.uml.query.UMLMetaAccess;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SampleAction implements IWorkbenchWindowActionDelegate {
	
	public static final EStructuralFeature ORDERED = UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered();
	public static final EStructuralFeature UNIQUE = UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique();
	//public static final EStructuralFeature REDEFINED = UMLPackage.eINSTANCE.getRedefinableElement
	public static final EStructuralFeature DERIVED = UMLPackage.eINSTANCE.getProperty_IsDerived();
	public static final EStructuralFeature CONTAINMENT = UMLPackage.eINSTANCE.getProperty_IsComposite();
	
	// Selected UML Package
	Package selectedRoot = null;
	
	
	/**
	 * The constructor.
	 */
	public SampleAction() {
	}


	public void run(IAction action) {
		System.out.println("Attributes:\n");
		
		System.out.println("\n=== " + "getAllManyAttributes");
		PrintUtil.print(UMLMetaAccess.getAllManyAttributes(selectedRoot, new EStructuralFeature[]{}));
		
		System.out.println("\n=== " + "getAllManyAttributes ORDERED");
		PrintUtil.print(UMLMetaAccess.getAllManyAttributes(selectedRoot, new EStructuralFeature[]{ORDERED}));
		
		System.out.println("\n=== " + "getAllManyAttributes UNIQUE");
		PrintUtil.print(UMLMetaAccess.getAllManyAttributes(selectedRoot, new EStructuralFeature[]{UNIQUE}));
		
		System.out.println("\n=== " + "getAllManyNonUniqueAttributes");
		PrintUtil.print(UMLMetaAccess.getAllManyNonUniqueAttributes(selectedRoot, new EStructuralFeature[]{}));
		
		System.out.println("\n=== " + "getAllManyAttributes DERIVED");
		PrintUtil.print(UMLMetaAccess.getAllManyAttributes(selectedRoot, new EStructuralFeature[]{DERIVED}));
		
		System.out.println("\n=== " + "getAllManyRedefinedAttributes");
		PrintUtil.print(UMLMetaAccess.getAllManyRedefinedAttributes(selectedRoot, new EStructuralFeature[]{}));
		
		
		System.out.println("\nReferences:\n");
		
		System.out.println("\n=== " + "getAllManyReferences ORDERED");
		PrintUtil.print(UMLMetaAccess.getAllManyReferences(selectedRoot, new EStructuralFeature[]{ORDERED}));
		
		System.out.println("\n=== " + "getAllManyRedefinedReferences ORDERED");
		PrintUtil.print(UMLMetaAccess.getAllManyRedefinedReferences(selectedRoot, new EStructuralFeature[]{ORDERED}));		
		
		System.out.println("\n=== " + "getAllManyReferences ORDERED, CONTAINMENT");
		PrintUtil.print(UMLMetaAccess.getAllManyReferences(selectedRoot, new EStructuralFeature[]{ORDERED, CONTAINMENT}));
		
		System.out.println("\n=== " + "getAllManyNonContainmentReferences ORDERED");
		PrintUtil.print(UMLMetaAccess.getAllManyNonContainmentReferences(selectedRoot, new EStructuralFeature[]{ORDERED}));
		
		System.out.println("\n=== " + "getAllManyReferences ORDERED, DERIVED");
		PrintUtil.print(UMLMetaAccess.getAllManyReferences(selectedRoot, new EStructuralFeature[]{ORDERED, DERIVED}));
		
		System.out.println("\n=== " + "getAllManyReferences ORDERED, CONTAINMENT, DERIVED");
		PrintUtil.print(UMLMetaAccess.getAllManyReferences(selectedRoot, new EStructuralFeature[]{ORDERED, CONTAINMENT, DERIVED}));

		System.out.println("\n=== " + "getAllManyNonUniqueReferences");
		PrintUtil.print(UMLMetaAccess.getAllManyNonUniqueReferences(selectedRoot, new EStructuralFeature[]{}));

		System.out.println("\n=== " + "getAllManyNonUniqueReferences ORDERED");
		PrintUtil.print(UMLMetaAccess.getAllManyNonUniqueReferences(selectedRoot, new EStructuralFeature[]{ORDERED}));

	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection){
			IStructuredSelection sel = (IStructuredSelection) selection;
			if (sel.getFirstElement() instanceof Package){
				selectedRoot = (Package) sel.getFirstElement();
			}
		}
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		//this.window = window;
	}
}
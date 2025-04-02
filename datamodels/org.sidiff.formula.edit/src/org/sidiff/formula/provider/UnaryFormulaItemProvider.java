/**
 */
package org.sidiff.formula.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.UnaryFormula;
import org.sidiff.formula.adapter.ISatSolverAdapter;

/**
 * This is the item provider adapter for a {@link org.sidiff.formula.UnaryFormula} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UnaryFormulaItemProvider 
	extends FormulaItemProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryFormulaItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(FormulaPackage.Literals.UNARY_FORMULA__FORMULA);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		ISatSolverAdapter labelValue = ((UnaryFormula)object).getSatSolverAdapter();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_UnaryFormula_type") :
			getString("_UI_UnaryFormula_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(UnaryFormula.class)) {
			case FormulaPackage.UNARY_FORMULA__FORMULA:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.UNARY_FORMULA__FORMULA,
				 FormulaFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.UNARY_FORMULA__FORMULA,
				 FormulaFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.UNARY_FORMULA__FORMULA,
				 FormulaFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.UNARY_FORMULA__FORMULA,
				 FormulaFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.UNARY_FORMULA__FORMULA,
				 FormulaFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.UNARY_FORMULA__FORMULA,
				 FormulaFactory.eINSTANCE.createImplies()));
	}

}

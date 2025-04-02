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

import org.sidiff.formula.BinaryFormula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.adapter.ISatSolverAdapter;

/**
 * This is the item provider adapter for a {@link org.sidiff.formula.BinaryFormula} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BinaryFormulaItemProvider 
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
	public BinaryFormulaItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(FormulaPackage.Literals.BINARY_FORMULA__LEFT);
			childrenFeatures.add(FormulaPackage.Literals.BINARY_FORMULA__RIGHT);
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
		ISatSolverAdapter labelValue = ((BinaryFormula)object).getSatSolverAdapter();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_BinaryFormula_type") :
			getString("_UI_BinaryFormula_type") + " " + label;
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

		switch (notification.getFeatureID(BinaryFormula.class)) {
			case FormulaPackage.BINARY_FORMULA__LEFT:
			case FormulaPackage.BINARY_FORMULA__RIGHT:
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
				(FormulaPackage.Literals.BINARY_FORMULA__LEFT,
				 FormulaFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__LEFT,
				 FormulaFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__LEFT,
				 FormulaFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__LEFT,
				 FormulaFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__LEFT,
				 FormulaFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__LEFT,
				 FormulaFactory.eINSTANCE.createImplies()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__RIGHT,
				 FormulaFactory.eINSTANCE.createVariable()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__RIGHT,
				 FormulaFactory.eINSTANCE.createNot()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__RIGHT,
				 FormulaFactory.eINSTANCE.createAnd()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__RIGHT,
				 FormulaFactory.eINSTANCE.createOr()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__RIGHT,
				 FormulaFactory.eINSTANCE.createXor()));

		newChildDescriptors.add
			(createChildParameter
				(FormulaPackage.Literals.BINARY_FORMULA__RIGHT,
				 FormulaFactory.eINSTANCE.createImplies()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == FormulaPackage.Literals.BINARY_FORMULA__LEFT ||
			childFeature == FormulaPackage.Literals.BINARY_FORMULA__RIGHT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}

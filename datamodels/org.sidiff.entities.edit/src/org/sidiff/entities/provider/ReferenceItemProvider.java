/**
 */
package org.sidiff.entities.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.common.emf.provider.ItemProviderUtil;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;

/**
 * This is the item provider adapter for a {@link org.sidiff.entities.Reference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceItemProvider extends EntityItemProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Dennis Reuling, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceItemProvider(AdapterFactory adapterFactory) {
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

			addSourcePropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addOppositePropertyDescriptor(object);
			addContainmentPropertyDescriptor(object);
			addContainerPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Reference_source_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Reference_source_feature", "_UI_Reference_type"),
				 EntitiesPackage.Literals.REFERENCE__SOURCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Reference_target_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Reference_target_feature", "_UI_Reference_type"),
				 EntitiesPackage.Literals.REFERENCE__TARGET,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Reference_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Reference_type_feature", "_UI_Reference_type"),
				 EntitiesPackage.Literals.REFERENCE__TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Opposite feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOppositePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Reference_opposite_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Reference_opposite_feature", "_UI_Reference_type"),
				 EntitiesPackage.Literals.REFERENCE__OPPOSITE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Containment feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainmentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Reference_containment_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Reference_containment_feature", "_UI_Reference_type"),
				 EntitiesPackage.Literals.REFERENCE__CONTAINMENT,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Container feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Reference_container_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Reference_container_feature", "_UI_Reference_type"),
				 EntitiesPackage.Literals.REFERENCE__CONTAINER,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns Reference.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		Reference ref = (Reference) object;
		Object image = null;
		if(ref.getType() != null){
			image = ItemProviderUtil.getImageByObject(ref.getType());
		}
		return (image != null) ? image : overlayImage(object, getResourceLocator().getImage("full/obj16/Reference"));
		
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Reference reference = (Reference) object;
		StringBuilder builder = new StringBuilder();
		builder.append(reference.getSource() == null ? "null" : reference.getSource().getSignature());
		builder.append(" ---(");
		builder.append(reference.getType() == null ? "null" : reference.getType().getName());		
		builder.append(")---> ");
		builder.append(reference.getTarget() == null ? "null" : reference.getTarget().getSignature());
		return builder.toString();
	}
	

	/**
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((Reference)object).getSignature();
    	StyledString styledLabel = new StyledString();
		if(!((Entity)object).getAnnotations().isEmpty()) {
			styledLabel.append(EntityItemProvider.getFormattedNumberOfConfigurations(((Entity)object).getAnnotations()));
			styledLabel.append(" ");
		}
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_Reference_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_Reference_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
		}
		if(!((Entity)object).getAnnotations().isEmpty()) {
			styledLabel.append(" ");
			styledLabel.append(EntityItemProvider.getFormattedAnnotationsString(((Entity)object).getAnnotations()));
		}
			
		return styledLabel;
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

		switch (notification.getFeatureID(Reference.class)) {
			case EntitiesPackage.REFERENCE__CONTAINMENT:
			case EntitiesPackage.REFERENCE__CONTAINER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}

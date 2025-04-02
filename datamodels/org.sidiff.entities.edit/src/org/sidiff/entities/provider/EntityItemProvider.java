/**
 */
package org.sidiff.entities.provider;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.AnnotationType;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.entities.Entity;

/**
 * This is the item provider adapter for a {@link org.sidiff.entities.Entity} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EntityItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemStyledLabelProvider {
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
	public EntityItemProvider(AdapterFactory adapterFactory) {
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

			addAnnotationsPropertyDescriptor(object);
			addSignaturePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Annotations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAnnotationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Entity_annotations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Entity_annotations_feature", "_UI_Entity_type"),
				 EntitiesPackage.Literals.ENTITY__ANNOTATIONS,
				 true,
				 true,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Signature feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSignaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Entity_signature_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Entity_signature_feature", "_UI_Entity_type"),
				 EntitiesPackage.Literals.ENTITY__SIGNATURE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return ((StyledString)getStyledText(object)).getString();
	}
	

	/**
	 * This returns the label styled text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getStyledText(Object object) {
		String label = ((Entity)object).getSignature();
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_Entity_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_Entity_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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

		switch (notification.getFeatureID(Entity.class)) {
			case EntitiesPackage.ENTITY__SIGNATURE:
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

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return EntitiesModelEditPlugin.INSTANCE;
	}
	
	/**
	 * Returns the annotations, sorted by lexicographic order and
	 * styled using the decorations pattern.
	 * @param annotations the annotations
	 * @return the styled string of all annotations
	 * @generated NOT
	 */
	public static StyledString getFormattedAnnotationsString(Collection<? extends Annotation> annotations) {
		if(annotations.isEmpty()) {
			return new StyledString();
		}
		
		boolean allModelAnnotations = true;
		List<String> annotationsList = new ArrayList<>();
		for(Annotation a : annotations) {
			annotationsList.add(a.getBody());
			if(a.getType() != AnnotationType.MODEL) {
				allModelAnnotations = false;
			}
		}
		Collections.sort(annotationsList);

		// If all annotations are model annotations, replace common prefix
		// in the models URI with ~ for better readability.
		if(allModelAnnotations) {
			int longestPrefix;
			outer:
			for(longestPrefix = 0; ; longestPrefix++) {
				char currentChar = 0;
				for(String body : annotationsList) {
					if(longestPrefix >= body.length()) {
						break outer; // longest prefix found
					} else if(currentChar == 0) {
						currentChar = body.charAt(longestPrefix);
					} else if(currentChar != body.charAt(longestPrefix)) {
						break outer; // longest prefix found
					}
				}
			}
			if(longestPrefix > 0) {
				for(int i = 1; i < annotationsList.size(); i++) { // the first one shows the prefix
					annotationsList.set(i, "~" + annotationsList.get(i).substring(longestPrefix));
				}
			}
		}

		return new StyledString("[" + String.join(", ", annotationsList) + "]", StyledString.Style.DECORATIONS_STYLER);
	}

	/**
	 * Returns the number of (valid) configurations that an entity with the given annotations is included in. To this end,
	 * we count the number of attached "MODEL" annotations as well as valid configurations defined by formula(s) in case of "CONDITION"
	 * annotations.
	 * @param annotations the annotations
	 * @return the styled string consisting of the number of configurations
	 * @generated NOT
	 */
	public static StyledString getFormattedNumberOfConfigurations(Collection<? extends Annotation> annotations) {
		int nrVariants = 0;
		//We may only compute the number of configurations for model or condition annotations
		for(Annotation a : annotations) {
			if(a.getType() == AnnotationType.MODEL) {
				nrVariants++;				
			} else if (a.getType() == AnnotationType.CONDITION && a.getFormula() != null) {
				nrVariants += a.getFormula().getValidConfigurations(60).size();
			}
		}
		String number = "?";
		if(nrVariants != 0) {
			number = Integer.toString(nrVariants);
		}
		return new StyledString("(" + number + ")", StyledString.Style.COUNTER_STYLER);
	}
}

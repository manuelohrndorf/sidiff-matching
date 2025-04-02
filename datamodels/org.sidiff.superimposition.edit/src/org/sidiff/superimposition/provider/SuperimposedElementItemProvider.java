/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.superimposition.provider;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.sidiff.common.emf.provider.ItemProviderUtil;
import org.sidiff.entities.Element;
import org.sidiff.entities.EntitiesFactory;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.entities.Reference;
import org.sidiff.entities.provider.ElementItemProvider;
import org.sidiff.entities.provider.EntityItemProvider;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelPackage;

/**
 * This is the item provider adapter for a {@link org.sidiff.superimposition.SuperimposedElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SuperimposedElementItemProvider 
	extends ElementItemProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperimposedElementItemProvider(AdapterFactory adapterFactory) {
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

			addObjectsPropertyDescriptor(object);
			addOwnedAttributesPropertyDescriptor(object);
			addOwnedReferencesPropertyDescriptor(object);
			addObjectAnnotationsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Objects feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addObjectsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SuperimposedElement_objects_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SuperimposedElement_objects_feature", "_UI_SuperimposedElement_type"),
				 SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OBJECTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Owned Attributes feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedAttributesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SuperimposedElement_ownedAttributes_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SuperimposedElement_ownedAttributes_feature", "_UI_SuperimposedElement_type"),
				 SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Owned References feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SuperimposedElement_ownedReferences_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SuperimposedElement_ownedReferences_feature", "_UI_SuperimposedElement_type"),
				 SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Object Annotations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addObjectAnnotationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SuperimposedElement_objectAnnotations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SuperimposedElement_objectAnnotations_feature", "_UI_SuperimposedElement_type"),
				 SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS,
				 true,
				 true,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.remove(EntitiesPackage.Literals.ELEMENT__ATTRIBUTES);
			childrenFeatures.add(SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES);
			childrenFeatures.add(SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean hasChildren(Object object) {
		return hasChildren(object, true);
	}

	/**
	 * This returns SuperimposedElement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		SuperimposedElement sel = (SuperimposedElement) object;
		Object image = null;
		if(!sel.getObjects().isEmpty()){
			image = ItemProviderUtil.getImageByObject(sel.getObjects().iterator().next());
		}
		return (image != null) ? image : super.getImage(object);

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
	 * @generated NOT
	 */
	@Override
	public Object getStyledText(Object object) {
    	StyledString styledLabel = new StyledString();
    	SuperimposedElement elem = (SuperimposedElement)object;
		if(!elem.isExternal()) {
			styledLabel.append(EntityItemProvider.getFormattedNumberOfConfigurations(elem.getAnnotations()));
			styledLabel.append(" ");
		}
		if(elem.getType() != null) {
			styledLabel.append("<" + elem.getType().getName() + ">", StyledString.Style.QUALIFIER_STYLER);			
			styledLabel.append(" ");
		}
		Set<String> objectSignatures = new HashSet<>();
		for(EObject obj: elem.getObjects()) {
			objectSignatures.add(ItemProviderUtil.getTextByObject((obj)));
		}
		if(objectSignatures.isEmpty()) {
			objectSignatures.add(elem.getSignature());
		}
		styledLabel.append(String.join(",", objectSignatures));
		styledLabel.append(" ");
		if(!elem.isExternal()) {
			styledLabel.append(EntityItemProvider.getFormattedAnnotationsString(elem.getAnnotations()));
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

		switch (notification.getFeatureID(SuperimposedElement.class)) {
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OBJECT_ANNOTATIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES:
			case SuperimpositionModelPackage.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES:
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
				(SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES,
				 EntitiesFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES,
				 EntitiesFactory.eINSTANCE.createReference()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SuperimpositionModelEditPlugin.INSTANCE;
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {

		Command command = super.createAddCommand(domain, owner, feature, collection, index);
		SuperimposedElement element = (SuperimposedElement)owner;

		Collection<?> addedTargets = collection.stream().filter(Reference.class::isInstance)
				.map(Reference.class::cast).map(Reference::getTarget).collect(Collectors.toSet());
		SuperimposedModel superimposedModel = (SuperimposedModel)element.eContainer();
		if(superimposedModel != null && !superimposedModel.getElements().containsAll(addedTargets)) {
			command = command.chain(AddCommand.create(domain, superimposedModel,
					SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__ELEMENTS, addedTargets));
		}

		if(feature == SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_ATTRIBUTES) {
			command = command.chain(AddCommand.create(domain, owner,
					EntitiesPackage.Literals.ELEMENT__ATTRIBUTES, collection));
		} else if(feature == SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES) {
			command = command.chain(AddCommand.create(domain, owner,
					EntitiesPackage.Literals.ELEMENT__OUTGOINGS, collection));
		}

		return command;
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {

		Command command = super.createRemoveCommand(domain, owner, feature, collection);

		if(feature == SuperimpositionModelPackage.Literals.SUPERIMPOSED_ELEMENT__OWNED_REFERENCES) {
			// removing a contained containment reference also removes the target
			Collection<Element> targetsToRemove =
				collection.stream()
					.map(Reference.class::cast)
					.filter(Reference::isContainment)
					.map(Reference::getTarget)
					.filter(Objects::nonNull)
					.collect(Collectors.toSet());
			if(!targetsToRemove.isEmpty()) {
				return command.chain(RemoveCommand.create(domain, owner.eContainer(),
						SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ELEMENTS, targetsToRemove));
			}
		}

		return command;
	}
}

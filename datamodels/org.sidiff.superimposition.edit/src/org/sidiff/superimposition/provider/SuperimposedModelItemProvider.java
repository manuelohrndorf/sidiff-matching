/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.superimposition.provider;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
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
import org.sidiff.entities.EntitiesFactory;
import org.sidiff.entities.EntitiesPackage;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelFactory;
import org.sidiff.superimposition.SuperimpositionModelPackage;
import org.sidiff.superimposition.signature.ISignatureCalculator;

/**
 * This is the item provider adapter for a {@link org.sidiff.superimposition.SuperimposedModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SuperimposedModelItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource,
		IItemColorProvider,
		IItemStyledLabelProvider {
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
	public SuperimposedModelItemProvider(AdapterFactory adapterFactory) {
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

			addDocTypePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addSignatureCalculatorsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Doc Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDocTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SuperimposedModel_docType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SuperimposedModel_docType_feature", "_UI_SuperimposedModel_type"),
				 SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__DOC_TYPE,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
				 getString("_UI_SuperimposedModel_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SuperimposedModel_type_feature", "_UI_SuperimposedModel_type"),
				 SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Signature Calculators feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addSignatureCalculatorsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SuperimposedModel_signatureCalculators_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SuperimposedModel_signatureCalculators_feature", "_UI_SuperimposedModel_type"),
				 SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null) {

				@Override
				public Collection<?> getChoiceOfValues(Object object) {
					return ISignatureCalculator.MANAGER.getSortedExtensions();
				}
			});
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
			childrenFeatures.add(SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__ELEMENTS);
			childrenFeatures.add(SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__ANNOTATIONS);
		}
		return childrenFeatures;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		SuperimposedModel superimposedModel = (SuperimposedModel) object;
		return Stream.concat(
				superimposedModel.getElements().stream()
					.filter(element -> !element.getIncomings().stream().anyMatch(Reference::isContainment))
					.sorted(Comparator.comparingInt(e -> e.isExternal() ? 1 : 0)), // first normal, then external elements
				superimposedModel.getAnnotations().stream() // then annotations
			).collect(Collectors.toList());
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
	 * This returns SuperimposedModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SuperimposedModel"));
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
		SuperimposedModel superimposedModel = (SuperimposedModel)object;
		String label = "Type(s) : ";
		label += String.join(",", superimposedModel.getDocType());
    	StyledString styledLabel = new StyledString();
		if (label == null || label.length() == 0) {
			styledLabel.append(getString("_UI_SuperimposedModel_type"), StyledString.Style.QUALIFIER_STYLER); 
		} else {
			styledLabel.append(getString("_UI_SuperimposedModel_type"), StyledString.Style.QUALIFIER_STYLER).append(" " + label);
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

		switch (notification.getFeatureID(SuperimposedModel.class)) {
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__DOC_TYPE:
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__SIGNATURE_CALCULATORS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ELEMENTS:
			case SuperimpositionModelPackage.SUPERIMPOSED_MODEL__ANNOTATIONS:
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
				(SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__ELEMENTS,
				 SuperimpositionModelFactory.eINSTANCE.createSuperimposedElement()));

		newChildDescriptors.add
			(createChildParameter
				(SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__ANNOTATIONS,
				 EntitiesFactory.eINSTANCE.createAnnotation()));
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
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {

		Command command = super.createRemoveCommand(domain, owner, feature, collection);

		if(feature == SuperimpositionModelPackage.Literals.SUPERIMPOSED_MODEL__ELEMENTS) {
			Set<Entity> entitiesToDelete = new HashSet<>();

			// remove incoming references
			entitiesToDelete.addAll(
				collection.stream()
					.map(SuperimposedElement.class::cast)
					.map(SuperimposedElement::getIncomings)
					.flatMap(Collection::stream)
					.filter(ref -> !ref.isContainment()) // containments used for recursion; must not include them here
					.collect(Collectors.toSet()));

			// remove owned references
			entitiesToDelete.addAll(
				collection.stream()
					.map(SuperimposedElement.class::cast)
					.map(SuperimposedElement::getOwnedReferences)
					.flatMap(Collection::stream)
					.collect(Collectors.toSet()));

			// remove owned attributes
			entitiesToDelete.addAll(
				collection.stream()
					.map(SuperimposedElement.class::cast)
					.map(SuperimposedElement::getOwnedAttributes)
					.flatMap(Collection::stream)
					.collect(Collectors.toSet()));

			if(!entitiesToDelete.isEmpty()) {
				command = command.chain(DeleteCommand.create(domain, entitiesToDelete));
			}
		}

		// Remove annotation references to removed entities
		for(Object object : collection) {
			if(object instanceof Entity) {
				Entity entity = (Entity)object;
				for(Annotation annotation : entity.getAnnotations()) {
					command = command.chain(RemoveCommand.create(domain, annotation,
							EntitiesPackage.Literals.ANNOTATION__ENTITIES, Collections.singleton(entity)));
				}
			}
		}

		return command;
	}
}

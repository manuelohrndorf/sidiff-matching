package org.sidiff.entities.exporter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;

/**
 * The Entities Exporter exports entities, creating instances
 * of the Elements, References and Attributes for the target meta model.
 * @author Robert Müller, Dennis Reuling
 */
public class EntitiesExporter {

	private final Map<Element,ExportedElementContainer> elementContainers = new LinkedHashMap<>();

	public void exportElement(Element element) {
		getContainer(element); // this creates the container
	}

	public void exportAttribute(Attribute attribute) {
		getContainer(attribute.getContainer()).addAttribute(attribute);
	}

	public void exportReference(Reference reference) {
		getContainer(reference.getSource()).addReference(reference);
	}

	protected Stream<EObject> createAllEntities(IProgressMonitor monitor) {
//		Set<EObject> resultSet = new HashSet<EObject>();
		SubMonitor progress = SubMonitor.convert(monitor, elementContainers.size());
		// just for debugging
//			for(ExportedElementContainer container : elementContainers.values()) {
//				System.out.println(container.getExportedObject());
//				if(!container.getElement().isExternal()) {
//					container.createFeatures();
//					progress.worked(1);
//					if(!container.isContained()) {
//						resultSet.add(container.getExportedObject());
//					}
//				}
//			}
//			return resultSet.stream();
		return elementContainers.values().stream()
			.filter(container -> !container.getElement().isExternal())
			.peek(container -> {
				container.createFeatures();
				progress.worked(1);			
			})
			.filter(container -> !container.isContained())
			.map(ExportedElementContainer::getExportedObject);
	}
	
	protected void clearAllEntities() {
		elementContainers.clear();
	}

	/**
	 * Returns a unmodifiable view of all objects, which have been exported until now.
	 * @return map from exported element to object
	 */
	public Map<Element, EObject> getExportedObjectsMap() {
		return elementContainers.values().stream()
				.collect(Collectors.toMap(ExportedElementContainer::getElement, ExportedElementContainer::getExportedObject));
	}

	public EObject getExportedObject(Element element) {
		return getContainer(element).getExportedObject();
	}

	/**
	 * Sets the <code>xmi:id</code> of all {@link #getExportedObjectsMap() exported objects}
	 * to the UUID of the corresponding element. Has no effect for objects not contained
	 * in an {@link org.eclipse.emf.ecore.xmi.XMIResource XMIResource}, must therefore
	 * be called after the exported objects have been added to the resource, but before
	 * the resource is saved.
	 */
	public void updateXmiIds() {
		elementContainers.values().forEach(ExportedElementContainer::updateXmiId);
	}

	protected ExportedElementContainer getContainer(Element element) {
		return elementContainers.computeIfAbsent(Objects.requireNonNull(element), ExportedElementContainer::new);
		// just for debugging
//		if(elementContainers.containsKey(element)) {
//			return elementContainers.get(element);
//		}else {
//			elementContainers.put(element, new ExportedElementContainer(element));
//			return elementContainers.get(element);
//		}
	}

	@SuppressWarnings("unchecked")
	protected static void setFeatureValue(EObject object, EStructuralFeature type, List<? extends Object> values) {
		if(type.isChangeable() && !type.isDerived() && !type.isTransient() && (!values.isEmpty() || type.isUnsettable())) {
			if(type.isMany()) {
				ECollections.setEList((EList<Object>)object.eGet(type), values);
			} else if(values.isEmpty()) {
				object.eUnset(type);
			} else {
				object.eSet(type, values.get(0));			
			}
		}
	}

	protected class ExportedElementContainer {

		private final Element element;
		private final Map<EReference,Collection<Element>> referenceTargets = new LinkedHashMap<>();
		private final Map<EAttribute,Collection<String>> attributeValues = new LinkedHashMap<>();

		private EObject exportedObject;
		private boolean contained = false;

		public ExportedElementContainer(Element element) {
			this.element = element;
			this.exportedObject = createObject();
		}

		public Element getElement() {
			return element;
		}

		public void addReference(Reference reference) {
			Assert.isTrue(reference.getSource() == element);
			referenceTargets.computeIfAbsent(reference.getType(), this::createCollectionForType).add(reference.getTarget());
			if(reference.isContainment()) {
				getContainer(reference.getTarget()).setContained(true);
			}
		}

		public void addAttribute(Attribute attribute) {
			Assert.isTrue(attribute.getContainer() == element);
			attributeValues.computeIfAbsent(attribute.getType(), this::createCollectionForType).addAll(attribute.getValue());
		}

		private <T> Collection<T> createCollectionForType(EStructuralFeature type) {
			if(type.isUnique()) {
				if(type.isOrdered()) {
					return new LinkedHashSet<>();
				}
				return new HashSet<>();
			}
			return new ArrayList<>();
		}

		public EObject getExportedObject() {
			return exportedObject;
		}

		public void createFeatures() {
			Assert.isLegal(!element.isExternal());
			attributeValues.forEach(this::createAttribute);
			referenceTargets.forEach(this::createReference);
		}

		protected EObject createObject() {
			if(element.isExternal()) {
				return element.getObject();
			}
			return EcoreUtil.create(element.getType());
		}

		protected void createAttribute(EAttribute type, Collection<String> stringValues) {
			List<Object> values = stringValues.stream()
				.map(value -> EcoreUtil.createFromString(type.getEAttributeType(), value))
				.collect(Collectors.toList());
			try {
				setFeatureValue(exportedObject, type, values);
			} catch(Exception e) {
				throw new ExportFailedException("Failed to set attribute " + type.getName()
					+ " of object " + exportedObject + " to " + stringValues, e);
			}
		}

		protected void createReference(EReference type, Collection<Element> tgtElements) {
			List<EObject> tgtObjects = tgtElements.stream()
				.map(EntitiesExporter.this::getExportedObject)
				.collect(Collectors.toList());
			try {
				setFeatureValue(exportedObject, type, tgtObjects);
			} catch(Exception e) {
				throw new ExportFailedException("Failed to set reference " + type.getName()
					+ " of object " + exportedObject + " to "
					+ tgtElements.stream().map(Element::getSignature).collect(Collectors.joining(", ", "[", "]")), e);
			}
		}

		public void updateXmiId() {
			if(!element.isExternal()) {
				EMFUtil.setXmiId(exportedObject, element.getUuid());				
			}
		}
		
		protected boolean isContained() {
			return contained;
		}
		
		protected void setContained(boolean contained) {
			this.contained = contained;
		}
	}
}

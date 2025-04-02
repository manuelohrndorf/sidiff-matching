package org.sidiff.annotation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.annotator.AnnotatorUtil;
import org.sidiff.annotator.IAnnotator;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.exceptions.UnknownDocumentTypeException;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Configurationhandler for the annotationconfiguration in xml format.
 * 
 * @author vdueck
 *
 */
public class XMLConfigurationHandler {

	private static final String SEPERATOR = ",";

	private static final String ELEM_ANNOTATIONS = "Annotations";
	private static final String ATT_DOCTYPE = "documentType";

	private static final String ELEM_ANNOTATION = "Annotation";
	private static final String ATT_NODETYPE = "nodeType";

	private static final String ELEM_SYNTH_ATTR = "SyntheticAttribute";
	private static final String ATT_SA_OPERATION = "operation";
	private static final String ATT_SA_NAME = "attributeName";
	private static final String ATT_SA_PARAMETER = "parameter";
	private static final String ATT_SA_REQUIRES = "requires";

	private ArrayList<IAnnotator> annotators;
	private EPackage documentType;
	private EClass currentClassifier = null;

	public ArrayList<IAnnotator> parseConfiguration(Document xmlconfig) {
		this.annotators = new ArrayList<IAnnotator>();

		NodeList annotationsElements = xmlconfig.getElementsByTagName(ELEM_ANNOTATIONS);
		processGlobalSettings(annotationsElements.item(0));

		NodeList annotationElements = xmlconfig.getElementsByTagName(ELEM_ANNOTATION);
		for (int i = 0; i < annotationElements.getLength(); i++) {
			// get current classifier (e.g. EObject, NamedElement,Model ...)
			prepareAnnotation(annotationElements.item(i));
			// for each classifier get the annotators (SyntheticAttribute)
			NodeList syntheticAttributes = annotationElements.item(i).getChildNodes();
			for (int j = 0; j < syntheticAttributes.getLength(); j++) {
				if (syntheticAttributes.item(j).getNodeName().equals(ELEM_SYNTH_ATTR))
					processAttribute(syntheticAttributes.item(j));
			}
		}
		finishAnnotation();
		return this.annotators;
	}

	private void processAttribute(Node syntheticAttribute) {
		NamedNodeMap atts = syntheticAttribute.getAttributes();
		String attributeName = getValue(atts, ATT_SA_NAME);
		String className = getValue(atts, ATT_SA_OPERATION);
		String parameter = getValue(atts, ATT_SA_PARAMETER);
		String requires = getValue(atts, ATT_SA_REQUIRES);

		if (attributeName != null && !"".equals(attributeName) && className != null && !"".equals(className)) {

			List<String> requiredAttributes = null;

			// Required Attributes
			if (requires != null && !"".equalsIgnoreCase(requires)) {
				requiredAttributes = new ArrayList<String>();
				for (String attribute : requires.split(SEPERATOR)) {
					if (!requiredAttributes.add(attribute)) {
						throw new SiDiffRuntimeException("Duplicate required Attribute! " + attribute);
					}
				}
			} else {
				requiredAttributes = Collections.emptyList();
			}

			IAnnotator availableAnnotator = AnnotatorUtil.getAvailableAnnotator(className);
			availableAnnotator.init(documentType, attributeName, parameter, currentClassifier, requiredAttributes);
			this.annotators.add(availableAnnotator);
		} else {
			throw new SiDiffRuntimeException(this,
					"Synthetic Attribute must have attributes 'attributeName' and 'operation'!");
		}
	}

	private void prepareAnnotation(Node annotation) {
		NamedNodeMap attributes = annotation.getAttributes();
		String currentClassifierName = getValue(attributes, ATT_NODETYPE);

		if (currentClassifierName != null && !"".equals(currentClassifierName)) {
			EClass classifier = (EClass) EMFMetaAccess.getMetaObjectByNameRecursively(documentType.getNsURI(),
					currentClassifierName);
			if (classifier == null) {
				if (currentClassifierName.equals("EObject")) {
					currentClassifier = EcorePackage.eINSTANCE.getEObject();
				} else {
					throw new SiDiffRuntimeException("Illegal classifier " + currentClassifierName);
				}
			} else {
				this.currentClassifier = classifier;
			}
		}
	}

	private void processGlobalSettings(Node settings) {
		NamedNodeMap attributes = settings.getAttributes();
		String documentType = getValue(attributes, ATT_DOCTYPE);
		if (documentType != null && !"".equalsIgnoreCase(documentType)) {
			if (EPackage.Registry.INSTANCE.getEPackage(documentType) != null) {
				this.documentType = EPackage.Registry.INSTANCE.getEPackage(documentType);
			} else {
				throw new UnknownDocumentTypeException("Document type unknown ", documentType);
			}
		} else {
			throw new SiDiffRuntimeException("Missing Documenttype!");
		}
	}

	private String getValue(NamedNodeMap attributes, String attributeName) {
		Node node = attributes.getNamedItem(attributeName);
		return (node != null) ? node.getNodeValue() : null;
	}

	public ArrayList<IAnnotator> getAnnotators() {
		return annotators;
	}

	public String getDocumentType() {
		return documentType.getNsURI();
	}

	private void finishAnnotation() {
		currentClassifier = null;
	}

}

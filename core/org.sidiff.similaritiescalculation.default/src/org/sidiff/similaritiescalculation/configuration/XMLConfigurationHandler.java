package org.sidiff.similaritiescalculation.configuration;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.comparefunctions.CompareFunctionUtil;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.conditions.ICondition;
import org.sidiff.conditions.util.ConditionsUtil;
import org.sidiff.similaritiescalculation.IfThenElse;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Loads the compare configuration from an XML file.
 */
public class XMLConfigurationHandler {

	// Constants - Defaults
	private static final String ATT_COMPAREFUNCTION_POLICY_CONST_DEFAULT = "mandatory";

	// Constants - Tags and Attributes
	private static final String ELEM_SETTINGS = "Settings";
	private static final String ATT_SETTINGS_NORMWEIGHTS = "normalizeWeights";
	private static final String ATT_SETTINGS_DOCTYPE = "documentType";

	private static final String ELEM_CLASS = "Class";
	private static final String ATT_CLASS_NAME = "name";
	private static final String ATT_CLASS_THRESHOLD = "threshold";

	private static final String ELEM_COMPAREFUNCTION = "CompareFunction";
	private static final String ATT_COMPAREFUNCTION_CLASS = "class";
	private static final String ATT_COMPAREFUNCTION_WEIGHT = "weight";
	private static final String ATT_COMPAREFUNCTION_PARAMETER = "parameter";
	private static final String ATT_COMPAREFUNCTION_POLICY = "policy";

	private static final String ELEM_IF = "If";
	private static final String ATT_IF_CONDITION = "condition";
	private static final String ATT_IF_WEIGHT = "weight";
	private static final String ATT_IF_PARAMETER = "parameter";
	private static final String ATT_IF_IFPOLICY = "ifPolicy";
	private static final String ATT_IF_CONDITIONPOLICY = "conditionPolicy";

	private static final String ELEM_THEN = "Then";

	private static final String ELEM_ELSE = "Else";

	public CompareConfiguration parseConfiguration(Document xmlconfig) {

		CompareConfiguration result = processSettings(xmlconfig.getElementsByTagName(ELEM_SETTINGS).item(0));

		NodeList classNodes = xmlconfig.getElementsByTagName(ELEM_CLASS);
		for (int i = 0; i < classNodes.getLength(); i++) {
			if (result.addTypeConfiguration(
					createTypeConfiguration(result.getConfiguredEPackage(), classNodes.item(i), result)) != null) {
				throw new InvalidArgumentException(classNodes.item(i).getAttributes(), ATT_CLASS_NAME,
						"Duplicate Class Definition!");
			}
		}
		return result;
	}

	private CompareConfiguration processSettings(Node settings) {

		NamedNodeMap attributes = settings.getAttributes();

		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(getValue(attributes, ATT_SETTINGS_DOCTYPE));
		if (ePackage == null) {
			throw new MissingPackageException(settings);
		}

		CompareConfiguration result = new CompareConfiguration(ePackage);
		result.setNormalizeWeights(Boolean.parseBoolean(getValue(attributes, ATT_SETTINGS_NORMWEIGHTS)));

		return result;
	}

	private TypeConfiguration createTypeConfiguration(EPackage metamodelPackage, Node classNode,
			CompareConfiguration compareConfiguration) {

		NamedNodeMap attributes = classNode.getAttributes();

		float threshold = -1.0f;
		try {
			threshold = Float.parseFloat(getValue(attributes, ATT_CLASS_THRESHOLD));
		} catch (NumberFormatException e) {
			throw new InvalidArgumentException(attributes, ATT_CLASS_THRESHOLD);
		}

		String value = getValue(attributes, ATT_CLASS_NAME);
		String nsUri = null;
		EClass type = null;
		try {
			// TODO bitte gegenchecken: Bugfix (SW)
			// type = (EClass) ePackage.getEClassifier(getValue(attributes,
			// ATT_CLASS_NAME));

			// If name contains an uri itself, use the uri as metamodel package
			if (value.contains("/")) {
				nsUri = value.substring(0, value.lastIndexOf("/"));
				value = value.substring(value.lastIndexOf("/") + 1, value.length());
			} else {
				nsUri = metamodelPackage.getNsURI();
			}
			type = (EClass) EMFMetaAccess.getMetaObjectByNameRecursively(nsUri, value);

		} catch (ClassCastException e) {
			throw new InvalidArgumentException(attributes, ATT_CLASS_NAME, e);
		} catch (StringIndexOutOfBoundsException e) {
			throw new InvalidArgumentException(attributes, ATT_CLASS_NAME,
					"Type '" + value + "' is not contained in any of the meta-models activated at runtime.");
		}

		if (type == null) {
			throw new InvalidArgumentException(attributes, ATT_CLASS_NAME, "Type not Found in Package " + nsUri);
		}

		TypeConfiguration typeconfig = new TypeConfiguration(type, threshold);

		for (ICompareFunction cf : getCompareFunctions(type, classNode.getChildNodes(), compareConfiguration)) {

			typeconfig.addCompareFunction(cf);
		}

		return typeconfig;
	}

	public Collection<ICompareFunction> getCompareFunctions(EClass dedicatedClass, NodeList compareFunctionsNodes,
			CompareConfiguration compareConfiguration) {

		Collection<ICompareFunction> result = new LinkedList<ICompareFunction>();

		for (int i = 0; i < compareFunctionsNodes.getLength(); i++) {
			Node currentNode = compareFunctionsNodes.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				if (currentNode.getNodeName().equals(ELEM_COMPAREFUNCTION)) {
					result.add(createcCompareFunction(dedicatedClass, currentNode));
				} else if (currentNode.getNodeName().equals(ELEM_IF)) {
					result.add(createIf(dedicatedClass, currentNode, compareConfiguration));
				} else {
					throw new IllegalArgumentException(currentNode.toString());
				}
			}
		}
		return result;
	}

	public ICompareFunction createcCompareFunction(EClass dedicatedClass, Node compareFunctionNode) {

		ICompareFunction item = null;

		NamedNodeMap attributes = compareFunctionNode.getAttributes();

		String className = getValue(attributes, ATT_COMPAREFUNCTION_CLASS);

		float weight = -1.0f;
		try {
			weight = Float.parseFloat(getValue(attributes, ATT_COMPAREFUNCTION_WEIGHT));
		} catch (NumberFormatException e) {
			throw new InvalidArgumentException(attributes, ATT_COMPAREFUNCTION_WEIGHT);
		}

		EvaluationPolicy policy = null;
		try {
			String policyString = getValue(attributes, ATT_COMPAREFUNCTION_POLICY);
			policy = EvaluationPolicy
					.valueOf((policyString == null) ? ATT_COMPAREFUNCTION_POLICY_CONST_DEFAULT : policyString);
		} catch (IllegalArgumentException e) {
			throw new InvalidArgumentException(attributes, ATT_COMPAREFUNCTION_POLICY, "Unknown!");
		}

		String parameter = getValue(attributes, ATT_COMPAREFUNCTION_PARAMETER);
		item = CompareFunctionUtil.getCompareFunction(className);

		if (parameter != null && !"".equals(parameter.trim())) {
			item.init(dedicatedClass, policy, weight, parameter);

		} else {
			item.init(dedicatedClass, policy, weight, null);
		}

		return item;
	}

	public ICompareFunction createIf(EClass dedicatedClass, Node compareFunctionNode,
			CompareConfiguration compareConfiguration) {

		IfThenElse ifStatement = null;

		NamedNodeMap attributes = compareFunctionNode.getAttributes();

		String className = getValue(attributes, ATT_IF_CONDITION);
		String parameter = getValue(attributes, ATT_IF_PARAMETER);

		float weight = -1;
		try {
			weight = Float.parseFloat(getValue(attributes, ATT_IF_WEIGHT));
		} catch (NumberFormatException e) {
			throw new InvalidArgumentException(attributes, ATT_IF_WEIGHT);
		}

		EvaluationPolicy ifPolicy = null;
		try {
			String policyString = getValue(attributes, ATT_IF_IFPOLICY);
			ifPolicy = EvaluationPolicy
					.valueOf((policyString == null) ? ATT_COMPAREFUNCTION_POLICY_CONST_DEFAULT : policyString);
		} catch (IllegalArgumentException e) {
			throw new InvalidArgumentException(attributes, ATT_COMPAREFUNCTION_POLICY, "Unknown!");
		}
		EvaluationPolicy condpolicy = null;
		try {
			String policyString = getValue(attributes, ATT_IF_CONDITIONPOLICY);
			condpolicy = EvaluationPolicy
					.valueOf((policyString == null) ? ATT_COMPAREFUNCTION_POLICY_CONST_DEFAULT : policyString);
		} catch (IllegalArgumentException e) {
			throw new InvalidArgumentException(attributes, ATT_COMPAREFUNCTION_POLICY, "Unknown!");
		}

		ICondition condition = ConditionsUtil.getCondition(className);

		if (parameter != null && !"".equals(parameter.trim())) {
			condition.init(dedicatedClass, condpolicy, parameter);

		} else {
			condition.init(dedicatedClass, condpolicy);
		}

		ifStatement = new IfThenElse(dedicatedClass, condition, ifPolicy, weight, compareConfiguration);

		NodeList ifChilds = compareFunctionNode.getChildNodes();
		for (int i = 0; i < ifChilds.getLength(); i++) {
			if (ifChilds.item(i).getNodeType() == Node.ELEMENT_NODE) {
				if (ELEM_THEN.equals(ifChilds.item(i).getNodeName())) {
					for (ICompareFunction cf : getCompareFunctions(dedicatedClass, ifChilds.item(i).getChildNodes(),
							compareConfiguration)) {
						ifStatement.addThenItem(cf);
					}
				} else if (ELEM_ELSE.equals(ifChilds.item(i).getNodeName())) {
					for (ICompareFunction cf : getCompareFunctions(dedicatedClass, ifChilds.item(i).getChildNodes(),
							compareConfiguration)) {
						ifStatement.addElseItem(cf);
					}
				} else {
					throw new InvalidArgumentException(ifChilds.item(i), "Only Then/Else!");
				}
			}
		}
		return ifStatement;
	}

	private String getValue(NamedNodeMap attributes, String attributeName) {
		Node node = attributes.getNamedItem(attributeName);
		return (node != null) ? node.getNodeValue() : null;
	}

	private class MissingPackageException extends SiDiffRuntimeException {
		private static final long serialVersionUID = 1L;

		public MissingPackageException(Node settings) {
			super("Check your configuration!" + "\n Package '"
					+ settings.getAttributes().getNamedItem(ATT_SETTINGS_DOCTYPE) + "' not found!");
		}
	}

	private class InvalidArgumentException extends SiDiffRuntimeException {
		private static final long serialVersionUID = 1L;

		public InvalidArgumentException(NamedNodeMap attributes, String attributeName) {
			super(XMLConfigurationHandler.this, "\nInvalid value " + getValue(attributes, attributeName) + "!");
		}

		public InvalidArgumentException(NamedNodeMap attributes, String attributeName, Exception e) {
			super(XMLConfigurationHandler.this, "\nInvalid value " + getValue(attributes, attributeName) + "!", e);
		}

		public InvalidArgumentException(NamedNodeMap attributes, String attributeName, String msg) {
			super(XMLConfigurationHandler.this,
					"\n" + msg + "\nInvalid value " + getValue(attributes, attributeName) + "!");
		}

		public InvalidArgumentException(Node node, String message) {
			super(XMLConfigurationHandler.this, message + "\nInvalid Node:" + node.getNodeName());
		}
	}
}

package org.sidiff.core.configurator.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SimiliaritiesCalculatorDOMConfigurator extends AbstractSimilaritiesCalculatorConfigurator {
	
	/**************************************************************************************************
	 * Defaults
	 **************************************************************************************************/
	private static final String DEFAULT_COMPAREFUNCTION = "MinimumSimilarity";
	private static final String ENUM_COMPAREFUNCTION = "Self";
	
	private static final String DEFAULT_COMPARATOR = "";
	private static final String ENUM_COMPARATOR = "CEquals";

	//Default values
	private static final String DEFAULT_NORMALIZE_WEIGHTS = "false";
	
	/**************************************************************************************************
	 * Constants
	 **************************************************************************************************/
	//Nodes
	private static final String NODE_COMPARISON = "Comparison";
	private static final String NODE_SETTINGS = "Settings";
	private static final String NODE_CONFIGURATIONS = "Configurations";
	private static final String NODE_CLASS = "Class";
	private static final String NODE_COMPARE_FUNCTION = "CompareFunction";
	
	//Attributes of Settings
	private static final String S_ATTRIBUTE_DOCUMENT_TYPE = "documentType";
	private static final String S_ATTRIBUTE_NORMALIZE_WEIGHTS = "normalizeWeights";
	
	//Attributes of Class
	private static final String C_ATTRIBUTE_NAME = "name";
	private static final String C_ATTRIBUTE_THRESHOLD = "threshold";
	
	//Attribute of CompareFunction
	private static final String CF_ATTRIBUTE_CLASS = "class";
	private static final String CF_ATTRIBUTE_WEIGHT = "weight";
	private static final String CF_ATTRIBUTE_PARAMETER = "parameter";
	private static final String CF_ATTRIBUTE_POLICY = "policy";
	


	private final static String NAME = "#name#";
	/**************************************************************************************************
	 * The Configuration
	 **************************************************************************************************/
	private static Map<FeatureKey, String> attributeCFMapping = new HashMap<FeatureKey, String>();
	private static Map<FeatureKey, String> attributeCPMapping = new HashMap<FeatureKey, String>();
	private static Map<FeatureKey, String> referenceCFMapping = new HashMap<FeatureKey, String>();
	private static Map<FeatureKey, String> referenceCPMapping = new HashMap<FeatureKey, String>();
	
	static{
		//Attributes        ordered,unique,many,id, Type 
		createAttributeConfig(false,true,false,false,String.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]"); // body 
		//Reference         ordered,unique,many,container,containment)
		//createReferenceConfig(x,x,false,x,x, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);
	
		//**************************************************************************************************************
		//Attributes
		//**************************************************************************************************************
		//Scalar 			  X	   , X   ,false,false              (scalar - ordered/unique don't care)
		createAttributeConfig(false,false,false,false,String.class ,"Self", "ECAttributeStatic[VCStringLCS[ci];"+NAME+"]");
		createAttributeConfig(false,true ,false,false,String.class ,"Self", "ECAttributeStatic[VCStringLCS[ci];"+NAME+"]");
		createAttributeConfig(true ,false,false,false,String.class ,"Self", "ECAttributeStatic[VCStringLCS[ci];"+NAME+"]");
		createAttributeConfig(true ,true ,false,false,String.class ,"Self", "ECAttributeStatic[VCStringLCS[ci];"+NAME+"]");
	
		createAttributeConfig(false,false,false,false,int.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(false,true ,false,false,int.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(true ,false,false,false,int.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(true ,true ,false,false,int.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");

		createAttributeConfig(false,false,false,false,float.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(false,true ,false,false,float.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(true ,false,false,false,float.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(true ,true ,false,false,float.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		
		createAttributeConfig(false,false,false,false,double.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(false,true ,false,false,double.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(true ,false,false,false,double.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");
		createAttributeConfig(true ,true ,false,false,double.class ,"Self", "ECAttributeStatic[VCGauss[0.7f];"+NAME+"]");

		createAttributeConfig(false,false,false,false,boolean.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		createAttributeConfig(false,true ,false,false,boolean.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		createAttributeConfig(true ,false,false,false,boolean.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		createAttributeConfig(true ,true ,false,false,boolean.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
	
		// ID Attributes
		createAttributeConfig(false,false,false,true,String.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		createAttributeConfig(false,false,false,true,int.class,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		
		createAttributeConfig(false,true ,false,true,String.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		createAttributeConfig(false,true ,false,true,int.class,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		
		createAttributeConfig(true ,false,false,true,String.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		createAttributeConfig(true ,false,false,true,int.class,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		
		createAttributeConfig(true ,true ,false,true,String.class ,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		createAttributeConfig(true ,true ,false,true,int.class,"Self", "ECAttributeStatic[CEquals;"+NAME+"]");
		
		//**************************************************************************************************************
		//References
		//**************************************************************************************************************
		//Scalar 			  X	   , X   ,false,false,false, (scalar - ordered/unique don't care)
		createReferenceConfig(false,false,false,false,false, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);
		createReferenceConfig(false,true ,false,false,false, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);   
		createReferenceConfig(true,false ,false,false,false, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);   
		createReferenceConfig(true,true  ,false,false,false, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);   
		// Set                0/1  ,X    ,true,false,true,  Ordered/UnorderedSet - (unique don't care)
		createReferenceConfig(false,false,true,false,false, "NeighboursSingleReference", "SCGreedyMatchedOrSimilar;"+NAME);
		createReferenceConfig(false,true ,true,false,false, "NeighboursSingleReference", "SCGreedyMatchedOrSimilar;"+NAME);   
		// OrderedSet
		createReferenceConfig(true,false ,true,false,false, "NeighboursSingleReference", "LCLongestCommonSubsequence[ECMatchedOrSimilar;0.5f];"+NAME);   
		createReferenceConfig(true,true  ,true,false,false, "NeighboursSingleReference", "LCLongestCommonSubsequence[ECMatchedOrSimilar;0.5f];"+NAME);  
	
		//**************************************************************************************************************
		//Container and Containment
		//**************************************************************************************************************
		//Children 			  X	   , X   ,false,false,true, (scalar - ordered/unique don't care)
		createReferenceConfig(false,false,false,false,true, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);
		createReferenceConfig(false,true ,false,false,true, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);   
		createReferenceConfig(true,false ,false,false,true, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);   
		createReferenceConfig(true,true  ,false,false,true, "SingleNeighbour", "ECMatchedOrSimilar;"+NAME);   
		//Childrens           false,X    ,true ,false,true, UnorderedSet - (unique don't care)
		createReferenceConfig(false,false,true,false,true, "NeighboursSingleReference", "SCGreedyMatchedOrSimilar;"+NAME);
		createReferenceConfig(false,true ,true,false,true, "NeighboursSingleReference", "SCGreedyMatchedOrSimilar;"+NAME);   
		//Childrens           true,X    ,true ,false,true,  OrderedSet - (unique don't care)
		createReferenceConfig(true,false ,true,false,true, "NeighboursSingleReference", "LCLongestCommonSubsequence[ECMatchedOrSimilar;0.5f];"+NAME);   
		createReferenceConfig(true,true  ,true,false,true, "NeighboursSingleReference", "LCLongestCommonSubsequence[ECMatchedOrSimilar;0.5f];"+NAME);  
		//Parent 			  X	   , X   , X   ,true,false, (singel scalar object!)
		createReferenceConfig(false,false,false,true,false, "Parent", "ECMatchedOrSimilar");
		createReferenceConfig(false,false,true ,true,false, "Parent", "ECMatchedOrSimilar");   
		createReferenceConfig(false,true ,false,true,false, "Parent", "ECMatchedOrSimilar");   
		createReferenceConfig(false,true ,true ,true,false, "Parent", "ECMatchedOrSimilar");  
		createReferenceConfig(true ,false,false,true,false, "Parent", "ECMatchedOrSimilar");
		createReferenceConfig(true ,false,true ,true,false, "Parent", "ECMatchedOrSimilar");   
		createReferenceConfig(true ,true ,false,true,false, "Parent", "ECMatchedOrSimilar");   
		createReferenceConfig(true ,true ,true ,true,false, "Parent", "ECMatchedOrSimilar");  
	}
	
	/**************************************************************************************************
	 * Implementation
	 **************************************************************************************************/
	//the document
	private Document document;
	
	//first level Elements
	private Element root = null;
	private Element settings = null;
	private Element configurations = null;
	
	public SimiliaritiesCalculatorDOMConfigurator(Document matchingDocument, String nsURI) {
		this.document = matchingDocument;
		
		//create root
		root = document.createElement(NODE_COMPARISON);
		document.appendChild(root);
		
		//create first level elements
		settings = document.createElement(NODE_SETTINGS);
		root.appendChild(settings);
		
		configurations = document.createElement(NODE_CONFIGURATIONS);
		root.appendChild(configurations);
		
		//create attributes of settings
		Attr documentType = document.createAttribute(S_ATTRIBUTE_DOCUMENT_TYPE);
		documentType.setNodeValue(nsURI);
		settings.setAttributeNode(documentType);
		
		Attr normalizeWeights = document.createAttribute(S_ATTRIBUTE_NORMALIZE_WEIGHTS);
		normalizeWeights.setNodeValue(DEFAULT_NORMALIZE_WEIGHTS);
		settings.setAttributeNode(normalizeWeights);
	}


	@Override
	public void createTypeConfiguration(String fullyQualifiedPath, EClass eClass, Collection<EReference> eReferences, Collection<EAttribute> eAttributes) {
		//create Class node
		Element clazz = document.createElement(NODE_CLASS);
		configurations.appendChild(clazz);
		
		//create Attribute of Class
		//create name attribute and seet value to fullyQualifiedPath
		Attr name = document.createAttribute(C_ATTRIBUTE_NAME);
		name.setNodeValue(fullyQualifiedPath);
		clazz.setAttributeNode(name);
		
		//create treshold attribute and compute value
		Attr treshold = document.createAttribute(C_ATTRIBUTE_THRESHOLD);
		clazz.setAttributeNode(treshold);
		
		Map<EStructuralFeature,Attr> weights = new HashMap<EStructuralFeature, Attr>();
		
		//create compareFunction for each EReference
		for(EStructuralFeature feature : eClass.getEAllStructuralFeatures()){
			
				if (!feature.isTransient() && !feature.isDerived()) {
				// create Node compareFunction
				Element compareFunction = document.createElement(NODE_COMPARE_FUNCTION);
				clazz.appendChild(compareFunction);

				// create class attribute and set value
				Attr classAttr = document.createAttribute(CF_ATTRIBUTE_CLASS);
				classAttr.setNodeValue(getComparefunction(feature));
				compareFunction.setAttributeNode(classAttr);

				// create parameter attribtue and set value
				Attr parameter = document.createAttribute(CF_ATTRIBUTE_PARAMETER);
				parameter.setNodeValue(getComparator(feature));
				compareFunction.setAttributeNode(parameter);

				// create parameter policy and set value 
				if (!feature.isRequired() || !(feature.getLowerBound() > 0))
				{
					Attr policy = document.createAttribute(CF_ATTRIBUTE_POLICY);
					policy.setNodeValue("unfulfilled");
					compareFunction.setAttributeNode(policy);
				}
								
									
				// create weight attribute and compute value
				Attr weight = document.createAttribute(CF_ATTRIBUTE_WEIGHT);
				compareFunction.setAttributeNode(weight);
				weights.put(feature, weight);
			}
		}
		computeTresholdAndWeights(treshold, weights);
	}
	
	private void computeTresholdAndWeights(Attr treshold,Map<EStructuralFeature,Attr> weights){
		if (!weights.isEmpty()) {
			int sum = 0;
			for (EStructuralFeature feature : weights.keySet()) {
				int rank = 1;
				// Perform ranking
				if (feature.isMany()) 		rank += 2;
				if (feature.isRequired()) 	rank += 1;
				if (feature.isUnique())		rank += 1;
				
				if ((feature instanceof EAttribute)
				&& ((EAttribute) feature).isID()) rank += 10;

				if (feature.getName().toLowerCase().contains("name")) rank += 5;
				
				weights.get(feature).setNodeValue(Integer.toString(rank));
				sum += rank;
			}

			// Normalize
			float max =0.0f;
			for (Attr weight : weights.values()) {
				float value = Float.parseFloat(weight.getNodeValue()) / sum;
				max= Math.max(max, value);
				weight.setNodeValue(Float.toString(value));
			}

			treshold.setNodeValue(Float.toString(Math.max(max,0.75f/weights.keySet().size())));
		} else {
			treshold.setNodeValue(Float.toString(1.0f));
		}
	}
	
	private static class FeatureKey {
		
		private boolean ordered;
		private boolean unique;
		private boolean many;
		
		public FeatureKey(boolean ordered, boolean unique, boolean many) {
			
			this.ordered = ordered;
			this.unique = unique;
			this.many = many;
		}
		
		public FeatureKey(EStructuralFeature feature){
			
			this.ordered = feature.isOrdered();
			this.unique = feature.isUnique();
			this.many = feature.isMany();
		}

		@Override
		public boolean equals(Object key){
			if(key instanceof FeatureKey){
				FeatureKey featureKey =(FeatureKey)key;
				return (this.ordered==featureKey.ordered)
					&& (this.unique==featureKey.unique)
					&& (this.many==featureKey.many);	
			} 
			return false;
		}

		@Override
		public int hashCode(){
			int result = 0;
				result = (result<<1) | ((this.ordered)? 0x1 :0x0); 
				result = (result<<1) | ((this.unique)? 0x1 :0x0); 
				result = (result<<1) | ((this.many)? 0x1 :0x0); 
			return result;
		}

	}
	
	private static class ReferenceKey extends FeatureKey {
		private boolean container;
		private boolean containment;
		
		public ReferenceKey(boolean ordered, boolean unique, boolean many,boolean container, boolean containment) {
			super(ordered,unique,many);
			if(!(container||containment)||container^containment){
				this.container=container;
				this.containment= containment;
			} else {
				throw new IllegalArgumentException("Impossible: Reference cannot be container and containment");
			}
		}
		
		public ReferenceKey(EStructuralFeature feature) {
			super(feature);
			if (feature instanceof EReference) {
				EReference reference = (EReference)feature;
				this.container = reference.isContainer();
				this.containment = reference.isContainment();
			} else {
				throw new IllegalArgumentException("Impossible: Feature must be a EReference");
			}
		}
		
		@Override
		public boolean equals(Object key){
			if(key instanceof ReferenceKey){
				ReferenceKey referenceKey =(ReferenceKey)key;
				return (super.equals(key))
					&& (this.container==referenceKey.container)
					&& (this.containment==referenceKey.containment);
			} 
			return false;
		}

		@Override
		public int hashCode(){
			int result = super.hashCode();
				result = (result<<1) | ((this.container)? 0x1 :0x0); 
				result = (result<<1) | ((this.containment)? 0x1 :0x0); 
			return result;
		}
	}

	private static class AttributeKey extends FeatureKey {	
		private boolean id;
		private Class<?> type;
		
		@SuppressWarnings("unchecked")
		public  AttributeKey(boolean ordered, boolean unique, boolean many,boolean id,Class type) {
			super(ordered,unique,many);
			this.id= id;
			this.type=type;
		}
		
		public AttributeKey(EStructuralFeature feature){
			super(feature);
			if (feature instanceof EAttribute) {
				EAttribute attribute = (EAttribute)feature;
				this.id = attribute.isID();
				this.type = attribute.getEAttributeType().getInstanceClass();
			} else {
				throw new IllegalArgumentException("Impossible: Feature must be a EAttribute");
			}
		}
		
		@Override
		public boolean equals(Object key){
			if(key instanceof AttributeKey){
				AttributeKey attributeKey =(AttributeKey)key;
				return (super.equals(key))
					&& (this.id==attributeKey.id)
					&& (this.type==attributeKey.type);
			} 
			return false;
		}

		@Override
		public int hashCode(){
			int result = super.hashCode();
				result = (result<<1) | ((this.id)? 0x1 :0x0); 
				result ^= this.type.hashCode();
			return result;
		}
	}
	@SuppressWarnings("unchecked")
	private static void createAttributeConfig(boolean ordered, boolean unique,boolean many, boolean id,Class type, String CF,String CP){

		FeatureKey key = new AttributeKey(ordered, unique, many,id,type);
		SimiliaritiesCalculatorDOMConfigurator.attributeCFMapping.put(key, CF);
		SimiliaritiesCalculatorDOMConfigurator.attributeCPMapping.put(key, CP);
	}
	
	private static void createReferenceConfig(boolean ordered, boolean unique, boolean many, boolean container, boolean containment, String CF,String CP){

		FeatureKey key = new ReferenceKey(ordered, unique, many, container, containment);
		SimiliaritiesCalculatorDOMConfigurator.referenceCFMapping.put(key, CF);
		SimiliaritiesCalculatorDOMConfigurator.referenceCPMapping.put(key, CP);
	}
	
	private static String getComparefunction(EStructuralFeature feature){

		String compareFunction = null;
		///AttributeKey xkey = new AttributeKey(true, true, true, true, Boolean.class);
		if(feature instanceof EAttribute){
			EDataType type = ((EAttribute)feature).getEAttributeType();
			if(type.getInstanceClass()!=null){
				compareFunction= SimiliaritiesCalculatorDOMConfigurator.attributeCFMapping.get(new AttributeKey(feature));
			} else {
				if(type instanceof EEnum){
					LogUtil.log(LogEvent.NOTICE, "ENUM "+feature.getName()+"["+type.getName()+"]");
					compareFunction = ENUM_COMPAREFUNCTION;
				} else {				
					LogUtil.log(LogEvent.NOTICE, "Attribute "+feature.getName()+" does not have a instance-type for ("+type.getName()+")! (class:"+type.getInstanceClassName()+", classname:"+type.getInstanceClassName()+", typename:"+type.getInstanceTypeName()+")");
					compareFunction = DEFAULT_COMPAREFUNCTION;
				}
			}
		}

		
		if(feature instanceof EReference){
			compareFunction= SimiliaritiesCalculatorDOMConfigurator.referenceCFMapping.get(new ReferenceKey(feature));
		}

		if(compareFunction==null){
			if(feature instanceof EAttribute){
				//createAttributeConfig(ordered, unique, many, id, type, CF, CP)
				LogUtil.log(LogEvent.MESSAGE, "createAttributeConfig("+feature.isOrdered()+"," +feature.isUnique()+","+feature.isMany()+","+((EAttribute)feature).isID()+",Literals.E"+((EAttribute)feature).getEAttributeType().getName().toUpperCase()+" ,\"Self\", \"ECAttributeStatic[CEquals;\"+NAME+\"]\"); // "+feature.getName());
			}
			if(feature instanceof EReference){
				//createReferenceConfig(ordered, unique, many, container, containment, CF, CP)
				LogUtil.log(LogEvent.MESSAGE, "createReferenceConfig("+feature.isOrdered()+"," +feature.isUnique()+","+feature.isMany()+","+((EReference)feature).isContainer()+","+((EReference)feature).isContainment()+", \"NeighboursSingleReference\", \"SCGreedyMatchedOrSimilar;\"+NAME); //"+feature.getName());
			}
			LogUtil.log(LogEvent.ERROR, "Illegal feature or missing configuration:"+feature);
			compareFunction=SimiliaritiesCalculatorDOMConfigurator.DEFAULT_COMPAREFUNCTION;
			//System.exit(1);
		}
		
		compareFunction=compareFunction.replaceAll(NAME, feature.getName());
		
		return compareFunction;
	}
	
	private static String getComparator(EStructuralFeature feature){

		String comparator = null;
		if(feature instanceof EAttribute){
			EDataType type = ((EAttribute)feature).getEAttributeType();
			if(type.getInstanceClass()!=null){
				comparator= SimiliaritiesCalculatorDOMConfigurator.attributeCPMapping.get(new AttributeKey(feature));
			} else {
				if(type instanceof EEnum){
					comparator= ENUM_COMPARATOR;
				} else {
					comparator= DEFAULT_COMPARATOR;
				}
			}
		}
		if(feature instanceof EReference){
			comparator= SimiliaritiesCalculatorDOMConfigurator.referenceCPMapping.get(new ReferenceKey(feature));
		}

		if(comparator==null){
			comparator=SimiliaritiesCalculatorDOMConfigurator.DEFAULT_COMPARATOR;
		}
		
		comparator=comparator.replaceAll(NAME, feature.getName());
		
		return comparator;
	}
}

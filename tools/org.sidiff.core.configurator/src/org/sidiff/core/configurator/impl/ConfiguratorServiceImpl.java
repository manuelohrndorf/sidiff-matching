package org.sidiff.core.configurator.impl;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.emf.ecore.EClassVisitor;
import org.sidiff.common.emf.ecore.ECoreTraversal;
import org.sidiff.common.services.ServiceHelper;
import org.sidiff.common.xml.XMLDOMCreator;
import org.sidiff.core.configurator.ConfiguratorService;
import org.sidiff.core.configurator.services.IterativeMatchingDOMConfigurator;
import org.sidiff.core.configurator.services.SimiliaritiesCalculatorDOMConfigurator;
import org.sidiff.core.matching.IterativeMatchingService;
import org.sidiff.core.similaritiescalculator.DefaultSimilaritiesCalculationService;
import org.w3c.dom.Document;



public class ConfiguratorServiceImpl implements ConfiguratorService {
	
	private static final String DEFAULT_SIMILARITIES_CALC_SERVICE = "org.sidiff.core.similaritiescalculator.DefaultSimilaritiesCalculationServiceProvider";
	private static final String ITERATIVE_MATCHING_SERVICE = "org.sidiff.core.matching.IterativeMatchingServiceProvider";
	
	private static File cacheDir = new File(System.getProperty("user.home")+"/.sidiff/cfgcache");
	static {
		if(!cacheDir.exists()){
			cacheDir.mkdir();
		}
		//assert(cacheDir.exists()&&cacheDir.canRead()&&cacheDir.canWrite());
	}
	
	@Override
	public Document configureService(Class<?> service, EPackage... rootPackages) {		
	
		if(rootPackages.length>0){
			
			Document result= XMLDOMCreator.createDocument();

			String rootURI = null;
			//if there is only one root package, use it's nsURI
			//else generate a synthetic root URI
			if(rootPackages.length == 0){
				return null;
			} else if(rootPackages.length == 1){
				rootURI = rootPackages[0].getNsURI();
			} else {
				rootURI = generateSyntheticDocumentURI(rootPackages);
			}

			if(service == DefaultSimilaritiesCalculationService.class && ServiceHelper.isAvailable(DEFAULT_SIMILARITIES_CALC_SERVICE)){
				//Create Similarities Config
				EClassVisitor similaritiesVisitor = new SimiliaritiesCalculatorDOMConfigurator(result, rootURI);
				ECoreTraversal.traverse(similaritiesVisitor, rootPackages);

				//ServiceHelper.configureInstance(Activator.getContext(), DefaultSimilaritiesCalculationService.class, rootURI, ServiceHelper.DEFAULT, result);
					
			} else if(service == IterativeMatchingService.class && ServiceHelper.isAvailable(ITERATIVE_MATCHING_SERVICE)){			
				//Create Matching Config
				EClassVisitor matchingVisitor = new IterativeMatchingDOMConfigurator(result, rootURI);
				ECoreTraversal.traverse(matchingVisitor, rootPackages);

				//ServiceHelper.configureInstance(Activator.getContext(), IterativeMatchingService.class, rootURI, ServiceHelper.DEFAULT, result);
				
			} else {
				throw new IllegalAccessError("unrecognized service "+service.getName());
			}
			return result;
	} else {
		throw new IllegalArgumentException("No Package(s) to configure!");
	}
	}
	
	private String generateSyntheticDocumentURI(EPackage[] modelroots){
		StringBuffer result = new StringBuffer();
		
		List<EPackage> packages = Arrays.asList(modelroots);
		Iterator<EPackage> iterator = packages.iterator();
		
		result.append("{");
		while(iterator.hasNext()){
			EPackage ePackage = iterator.next();
			result.append(ePackage.getName());
			if(iterator.hasNext()){
				result.append(",");
			}
		}
		result.append("}");
		
		return result.toString();
	}

}

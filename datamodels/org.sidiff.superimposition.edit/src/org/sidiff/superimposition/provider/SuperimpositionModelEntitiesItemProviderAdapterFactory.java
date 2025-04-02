package org.sidiff.superimposition.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.sidiff.entities.provider.EntitiesItemProviderAdapterFactory;

public class SuperimpositionModelEntitiesItemProviderAdapterFactory extends EntitiesItemProviderAdapterFactory {

	@Override
	public Adapter createReferenceAdapter() {
		if(referenceItemProvider == null){
			referenceItemProvider = new SuperimpositionReferenceItemProvider(this);
		}
		return referenceItemProvider;
	}
	
	@Override
	public Adapter createAttributeAdapter() {
		if(attributeItemProvider == null){
			attributeItemProvider = new SuperimpositionAttributeItemProvider(this);
		}
		return attributeItemProvider;
	}

}

package org.sidiff.superimposition.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.StyledString;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.provider.AttributeItemProvider;
import org.sidiff.entities.provider.EntityItemProvider;

public class SuperimpositionAttributeItemProvider extends AttributeItemProvider {

	public SuperimpositionAttributeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public Object getStyledText(Object object) {
		Attribute att = (Attribute) object;
    	StyledString styledLabel = new StyledString();
    	styledLabel.append(getFormattedNumberOfConfigurations(att.getAnnotations()));
    	styledLabel.append(" ");
    	styledLabel.append(att.getType().getName() + " = ", StyledString.Style.QUALIFIER_STYLER);
		styledLabel.append(String.join(", ", att.getValue()));
		styledLabel.append(" ");
		styledLabel.append(EntityItemProvider.getFormattedAnnotationsString(att.getAnnotations()));
		return styledLabel;
	}
}

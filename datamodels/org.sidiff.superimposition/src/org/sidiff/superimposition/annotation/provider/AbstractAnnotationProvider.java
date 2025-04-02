package org.sidiff.superimposition.annotation.provider;

import org.sidiff.common.extension.AbstractTypedExtension;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;

/**
 * @author rmueller
 */
public abstract class AbstractAnnotationProvider extends AbstractTypedExtension implements IAnnotationProvider {

	@Override
	public IExtensionConfiguration getConfiguration() {
		return IExtensionConfiguration.NULL;
	}
}

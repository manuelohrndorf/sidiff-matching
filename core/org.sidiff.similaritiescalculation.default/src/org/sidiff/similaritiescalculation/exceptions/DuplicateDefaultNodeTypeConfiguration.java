package org.sidiff.similaritiescalculation.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.stringresolver.StringUtil;
import org.sidiff.similaritiescalculation.configuration.TypeConfiguration;

public class DuplicateDefaultNodeTypeConfiguration extends SiDiffRuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateDefaultNodeTypeConfiguration(TypeConfiguration configuration) {
		super(StringUtil.resolve(configuration), "DefaultNodeTypeConfiguration already exists!");
	}
}
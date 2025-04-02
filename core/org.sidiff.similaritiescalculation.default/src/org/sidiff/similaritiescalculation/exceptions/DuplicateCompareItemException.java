package org.sidiff.similaritiescalculation.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.stringresolver.StringUtil;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.similaritiescalculation.configuration.TypeConfiguration;


public class DuplicateCompareItemException extends SiDiffRuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DuplicateCompareItemException(TypeConfiguration configuration, ICompareFunction item) {
		super(StringUtil.resolve(configuration, item));
	}
}
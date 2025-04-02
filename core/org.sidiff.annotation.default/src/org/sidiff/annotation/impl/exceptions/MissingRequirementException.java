package org.sidiff.annotation.impl.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;

public class MissingRequirementException extends SiDiffRuntimeException {

	private static final long serialVersionUID = 6223243377860911152L;

	public MissingRequirementException(String message) {
		super(message);
	}

}

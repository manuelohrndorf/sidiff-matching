package org.sidiff.correspondences.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;

public class CannotMatchException extends SiDiffRuntimeException {

	private static final long serialVersionUID = -2400201267392929125L;

	public CannotMatchException(String message) {
		super(message);
	}
}

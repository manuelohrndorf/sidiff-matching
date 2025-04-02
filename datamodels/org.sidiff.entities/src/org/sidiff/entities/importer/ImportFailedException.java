package org.sidiff.entities.importer;

public class ImportFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3998933073860383141L;

	public ImportFailedException(String message) {
		super(message);
	}

	public ImportFailedException(Throwable throwable) {
		super(throwable);
	}

	public ImportFailedException(String message, Throwable throwable) {
		super(message, throwable);
	}
}

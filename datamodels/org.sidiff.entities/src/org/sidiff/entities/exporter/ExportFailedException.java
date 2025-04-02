package org.sidiff.entities.exporter;

/**
 * 
 * @author Robert Müller
 */
public class ExportFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5719887724755308937L;

	public ExportFailedException(String message) {
		super(message);
	}

	public ExportFailedException(Throwable throwable) {
		super(throwable);
	}

	public ExportFailedException(String message, Throwable throwable) {
		super(message, throwable);
	}
}

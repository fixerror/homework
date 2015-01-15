package com.sourceit.radchenko.hw6.exception;

/**
 * If the file copy fails the exception will be thrown
 * 
 * @author source it
 * @version 1.0
 */
public class FileCopyFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1047263155433783709L;

	public FileCopyFailedException(String message) {
		super(message);

	}

	public FileCopyFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}

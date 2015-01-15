package com.sourceit.radchenko.hw6.exception;

/**
 * If the target file already exists. this exception will be thrown
 * 
 * @author source it
 * @version 1.0
 */
public class FileAlreadyExistsException extends FileCopyFailedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7825292144704190242L;

	public FileAlreadyExistsException(String message) {
		super(message);
	}

}

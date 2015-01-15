package com.sourceit.radchenko.hw7.exception;

/**
 * An unexpected error occurred during the execution of tasks
 * 
 * @author source it
 * @version 1.0
 */
public class TaskExecutionFailedException extends Exception {
	private static final long serialVersionUID = -3853034940823091780L;

	public TaskExecutionFailedException(String message) {
		super(message);
	}

	public TaskExecutionFailedException(Throwable cause) {
		super(cause);
	}

	public TaskExecutionFailedException(String message, Throwable cause) {
		super(message, cause);
	}

}

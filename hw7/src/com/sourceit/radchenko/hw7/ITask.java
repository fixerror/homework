package com.sourceit.radchenko.hw7;

import com.sourceit.radchenko.hw7.exception.TaskExecutionFailedException;

/**
 * The interface is an abstract problem.
 * 
 * @author source it
 * @version 1.0
 */
public interface ITask {

	/**
	 * Returns the number of times the task execution
	 * 
	 * @return the number of times the task execution
	 */
	int getTryCount();

	/**
	 * Increase the number of times a task is 1.
	 */
	void incTryCount();

	/**
	 * Method that performs a task.
	 * 
	 * @return
	 * 
	 * @throws TaskExecutionFailedException
	 *             if the task was not completed correctly
	 * @throws Exception
	 */
	boolean execute() throws TaskExecutionFailedException, Exception;
}

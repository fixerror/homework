package com.sourceit.radchenko.hw7;

/**
 * Interface task list.
 * 
 * @author source it
 * @version 1.0
 */
public interface ITasksStorage {

	/**
	 * Add task list for execution.
	 * 
	 * @param task
	 *            task to add
	 * @throws NullPointerException
	 *             if task == null
	 */
	void add(ITask task) throws NullPointerException;

	/**
	 * Get the first task from the task list and remove it from the list.
	 * 
	 * @return task performance, or null if not in the list of tasks.
	 */
	ITask get();

	/**
	 * Returns the number of tasks in the list, which can be taken for
	 * execution.
	 * 
	 * @return the number of tasks in the list, which can be taken for
	 *         execution.
	 */
	int count();
}

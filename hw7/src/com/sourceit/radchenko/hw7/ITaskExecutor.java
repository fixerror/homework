package com.sourceit.radchenko.hw7;

/**
 * Executive interface tasks.
 * 
 * @author source it
 * @version 1.0
 */
public interface ITaskExecutor {

	/**
	 * Set storage tasks.
	 * 
	 * @param storage
	 *            storage problems.
	 * @throws NullPointerException
	 *             if the storage problems = null
	 */
	void setStorage(ITasksStorage storage) throws NullPointerException;

	/**
	 * Get the current storage problems.
	 * 
	 * @return current storage problems.
	 */
	ITasksStorage getStorage();

	/**
	 * Start performer tasks.
	 * 
	 * @throws NullPointerException
	 *             if storage == null
	 * @throws IllegalStateException
	 *             in cases where the function is not available or is incorrect
	 *             (Recall call without stop)
	 */
	void start() throws NullPointerException, IllegalStateException;

	/**
	 * Stop performer tasks. When you stop the executor must wait completion of
	 * the current task, if any, and only then complete executing a thread and
	 * make a way out of the function.
	 * 
	 * @throws IllegalStateException
	 *             in cases where the function is not available or is incorrect
	 *             (call stop without calling the start)
	 */
	void stop() throws IllegalStateException;
}

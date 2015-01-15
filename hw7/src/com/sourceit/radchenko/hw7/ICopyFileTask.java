package com.sourceit.radchenko.hw7;

import com.sourceit.radchenko.hw6.IFileCopyUtils;

/**
 * the task of copying the file in a separate thread
 * 
 * @author source it
 * @version 1.0
 */
public interface ICopyFileTask extends ITask {
	/**
	 * Sets the algorithm to copy files. created in the previous task
	 * 
	 * @param copyUtils
	 *            algorithm to copy files
	 */
	void setFileCopyUtils(IFileCopyUtils copyUtils);
}

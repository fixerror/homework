package com.sourceit.radchenko.hw6;

import com.sourceit.radchenko.hw6.exception.FileAlreadyExistsException;
import com.sourceit.radchenko.hw6.exception.FileCopyFailedException;

/**
 * Interface to copy files
 * 
 * @author source it
 * @version 1.0
 */
public interface IFileCopyUtils {

	/**
	 * Copy function source file to a file destination. Source and destination -
	 * this file paths
	 * 
	 * @param source
	 *            path of the file
	 * @param destination
	 *            path of the file
	 * @throws FileAlreadyExistsException
	 *             if the target file already exists
	 * @throws FileCopyFailedException
	 *             if there is any error occurred while copying files, cause
	 *             should indicate the source of the error
	 */
	void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException;
}

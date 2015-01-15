package com.sourceit.radchenko.hw7;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * The task of finding the file (s) in the specified directory on the specified
 * pattern. This TASK looking for files in the directory wildcard searchString.
 * The result is output to the output stream out. The result is an array of full
 * paths to files
 * 
 * @author source it
 * @version 1.0
 */
public interface IFindFilesTask extends ITask {

	/**
	 * Sets the path to the directory
	 * 
	 * @param directory
	 *            directory path
	 * @throws NullPointerException
	 *             if directory = null
	 * @throws FileNotFoundException
	 *             If the directory does not exist
	 */
	void setDirectory(String directory) throws NullPointerException,
			FileNotFoundException;

	/**
	 * The search string supports Windows compatible templates: <br/>
	 * * - any number of characters <br/>
	 * ? - one character
	 * 
	 * @param searchString
	 *            search string
	 * @throws IllegalArgumentException
	 *             if searchString = null
	 */
	void setFileNameSearchString(String searchString)
			throws IllegalArgumentException;

	/**
	 * Sets the output stream to which the task will be to display search
	 * results
	 * 
	 * @param out
	 *            output stream, where the task will display search results
	 */
	void setPrintStream(PrintStream out);
}

package com.sourceit.radchenko.hw6;

/**
 * Interface testing different types of copying files
 * 
 * @author source it
 * @version 1.0
 */
public interface IFileCopyTestUtils {

	/**
	 * Creates a class using the Copy FileInputStream
	 * 
	 * @return class copy using FileInputStream
	 */
	IFileCopyUtils createSimpleFileCopyUtils();

	/**
	 * Copy creates a class using buffered streams
	 * 
	 * @return class copy using buffered streams
	 */
	IFileCopyUtils createBufferedFileCopyUtils();

	/**
	 * Copy creates a class using channels
	 * 
	 * @return class copy using channels
	 */
	IFileCopyUtils createChannelsFileCopyUtils();

	/**
	 * Copy creates a class using Java 7 features
	 * 
	 * @return class copy using the power of Java 7
	 */
	IFileCopyUtils createJava7CopyUtils();
}

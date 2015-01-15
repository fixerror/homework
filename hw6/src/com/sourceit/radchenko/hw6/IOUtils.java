package com.sourceit.radchenko.hw6;

import java.io.Reader;
import java.io.Writer;

/**
 * Utilities for working with input and output streams.
 * 
 * @author source it
 * @version 1.0
 */
public interface IOUtils {

	/**
	 * Copy a string from the input stream to the output, simultaneously
	 * replacing characters of which are in <code>inChars</code>, on characters
	 * are in the same position <code>outChars</code>. lines
	 * <code>inChars</code> и <code>outChars</code> must be equal length. if
	 * <code>inChars</code> or <code>outChars</code> == null believe that the
	 * entry was filed empty string. <b> example: in = 1234567890<b> inChars =
	 * 357<b> outChars = 480<b> <b> out = 1244860890<b>
	 * 
	 * @param in
	 * @param out
	 * @param inChars
	 * @param outChars
	 * @throws NullPointerException
	 *             if any of the parameters in or out == null
	 * @throws IllegalArgumentException
	 *             if inChars.length! = outChars.length
	 */
	void replaceChars(Reader in, Writer out, String inChars, String outChars)
			throws NullPointerException, IllegalArgumentException;

	/**
	 * The function finds all files in a directory and subdirectories and
	 * returns the full path in the form of an array of strings.
	 * 
	 * @param dir
	 *            folder where you want to begin your search
	 * @return an array of file paths
	 * @throws NullPointerException
	 *             if dir == null
	 * @throws IllegalArgumentException
	 *             if dir does not exist
	 */
	String[] findFiles(String dir) throws NullPointerException,
			IllegalArgumentException;
}

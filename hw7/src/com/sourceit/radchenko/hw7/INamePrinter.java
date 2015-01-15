package com.sourceit.radchenko.hw7;

import java.io.PrintStream;

/**
 * Interface thread print name that you enter via setPrintName.
 * 
 * @author source it
 * @version 1.0
 */
public interface INamePrinter {

	/**
	 * Set the name of the thread.
	 * 
	 * @param name
	 *            the name of the thread
	 * @throws NullPointerException
	 *             if name == null
	 * @throws IllegalArgumentException
	 *             if name.length == 0
	 */
	void setPrintName(String name) throws NullPointerException,
			IllegalArgumentException;

	/**
	 * Set flow which must be printed name. For example System.out
	 * 
	 * @param stream
	 *            stream name to be printed.
	 * @throws NullPointerException
	 *             if stream == null
	 */
	void setStream(PrintStream stream) throws NullPointerException;

	/**
	 * Set the interval in milliseconds between the findings in the stream name.
	 * 
	 * @param ms
	 *            time in milliseconds between the findings in the stream name.
	 * @throws IllegalArgumentException
	 *             if ms <= 0
	 */
	void setInterval(long ms) throws IllegalArgumentException;

	/**
	 * Set the number of taps in the name of the stream.
	 * 
	 * @param count
	 *            number of pins in behalf stream.
	 * @throws IllegalArgumentException
	 *             if count <= 0
	 */
	void setCount(int count) throws IllegalArgumentException;

	void run();
}

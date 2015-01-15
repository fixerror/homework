package com.sourceit.radchenko.hw5;

import java.util.List;

/**
 * Utilitny class for working with lists
 * 
 * @author source it
 * @version 1.0
 */
public interface IListUtils {

	/**
	 * Converts a variable number of parameters in a list of strings
	 * 
	 * @param strings variable number of arguments
	 * @return list of strings
	 * @throws IllegalArgumentException if one of the arguments null
	 */
	List<String> asList (String ... strings) throws IllegalArgumentException;
	
	/**
	 * Returns a sorted list in reverse order (descending)
	 * <b>Source list should not be modified</b>
	 * 
	 * @param data the original list
	 * @return List sorted descending
	 * @throws IllegalArgumentException if data = null
	 */
	List<Double> sortedList(List<Double> data) throws IllegalArgumentException;
}

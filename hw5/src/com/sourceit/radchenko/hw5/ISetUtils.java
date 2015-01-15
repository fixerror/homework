package com.sourceit.radchenko.hw5;

import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

/**
 * Utilitny class to work with sets
 * 
 * @author source it
 * @version 1.0
 */
public interface ISetUtils {
	
	/**
	 * Returns a set of sorted in reverse order (descending) as the union of two collections
	 * collection1 - a collection of numbers (each number must be brought to a string representation) and set2 - set of 
	 * not sorted rows
	 * 
	 * @param colection1 collection numbers
	 * @param set2 set is not sorted rows
	 * @return sorted set in reverse order
	 * @throws NullPointerException if collection1 or set2 == null
	 */
	SortedSet<String> orderedSet(Collection<Integer> collection1, Set<String> set2) throws NullPointerException;
	
	/**
	 * Returns a set of numbers val1, val2, val3, val4, val5 in the same order
	 * 
	 * @param val1 function argument
	 * @param val2 function argument
	 * @param val3 function argument
	 * @param val4 function argument
	 * @param val5 function argument
	 * @return an ordered set in a predetermined order
	 */
	Set<Integer> customOrderSet(int val1, int val2, int val3, int val4,int val5);
}

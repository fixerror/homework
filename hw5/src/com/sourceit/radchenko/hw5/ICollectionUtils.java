package com.sourceit.radchenko.hw5;

import java.util.Collection;
import java.util.Set;

/**
 * Utilities for working with collections of objects
 * 
 * @author source it
 * @version 1.0
 */
public interface ICollectionUtils {

	/**
	 * Combining the two collections with duplicates
	 * 
	 * @param a the first collection
	 * @param b second collection
	 * @return new collection containing the union of a and b, may contain duplicates 
	 * @throws NullPointerException If a or b == null
	 */
	Collection<Integer> union (Collection<Integer> a, Collection<Integer> b) throws NullPointerException;
	
	/**
	 * The intersection of two collections of duplicates
	 * 
	 * @param a the first collection
	 * @param b second collection
	 * @return new collection containing the intersection of a and b, may contain duplicates 
	 * @throws NullPointerException If a or b == null
	 */
	Collection<Integer> intersection (Collection<Integer> a, Collection<Integer> b) throws NullPointerException;
	
	/**
	 * Combining the two collections without duplicates
	 * 
	 * @param a the first collection
	 * @param b second collection
	 * @return new collection containing the union of a and b without duplicates
	 * @throws NullPointerException If a or b == null
	 */
	Set<Integer> unionWithoutDuplicate (Collection<Integer> a, Collection<Integer> b) throws NullPointerException;
	
	/**
	 * The intersection of two collections without duplicates
	 * 
	 * @param a the first collection
	 * @param b second collection
	 * @return new collection containing the intersection of a and b without duplicates
	 * @throws NullPointerException If a or b == null
	 */
	Set<Integer> intersectionWithoutDuplicate (Collection<Integer> a, Collection<Integer> b) throws NullPointerException;
	
	/**
	 * The difference between the two collections
	 * 
	 * @param a the first collection
	 * @param b second collection
	 * @return new collection containing the difference between a and b
	 * @throws NullPointerException If a or b == null
	 */
	Collection<Integer> difference (Collection<Integer> a, Collection<Integer> b) throws NullPointerException;
}

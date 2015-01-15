package com.sourceit.radchenko.hw5;

import java.util.Iterator;
import java.util.Map;

/**
 * Interface cards with multiple values for a single key, ie if called Map.put (key1, value1) and then Map.put (key1, value2), the card
 * will store two values for key key1
 * 
 * @author source it
 * @version 1.0
 */
public interface IMultiMap<K, V> extends Map<K, V> {

	/**
	 * Returns the number of values for the specified key
	 * 
	 * @param key key
	 * @return number of values
	 */
	int countValues(K key);
	
	/**
	 * Returns the last value added to the map
	 */
	public V get(Object key);
	
	
	/**
	 * Returns an iterator to the values stored for the specified key.
	 * If no value exists, must return an empty iterator. Ie iterator should never byit is null
	 * 
	 * @param key key
	 * @return iterator
	 */
	public Iterator<V> valuesIterator(K key);
	
	/**
	 *  Removes all values for the specified key
	 */
	public V remove(Object key);
}

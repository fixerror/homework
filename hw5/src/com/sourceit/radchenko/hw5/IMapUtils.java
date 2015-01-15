package com.sourceit.radchenko.hw5;

import java.util.Map;

/**
 * @author source it
 * @version 1.0
 */
public interface IMapUtils {
	
	/**
	 * Union cards. The resulting map should contain all the keys to the original card, and all the values.
	 * If two different maps will be one and the same key but different values, the resulting map should contain
	 * two values for the specified key. If the values are identical, only one value, i.e. without duplicates
	 * 
	 * @param maps cards
	 * @return the resulting map
	 * @throws IllegalArgumentException if some card is null
	 */
	@SuppressWarnings("unchecked")
	IMultiMap<IMapKey, Integer> merge (Map<IMapKey, Integer> ... maps) throws IllegalArgumentException;
}

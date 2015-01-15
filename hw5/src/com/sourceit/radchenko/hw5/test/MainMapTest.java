package com.sourceit.radchenko.hw5.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sourceit.radchenko.hw5.IMapKey;
import com.sourceit.radchenko.hw5.IMultiMap;
import com.sourceit.radchenko.hw5.impl.MapKeyImpl;
import com.sourceit.radchenko.hw5.impl.MapUtilsImpl;

public class MainMapTest {
	public static <T, X> void printMap(Map<T, X> map) {
		for (Entry<T, X> entry : map.entrySet()) {
			System.out.println(entry.getKey().toString() + " : "
					+ entry.getValue());
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		IMapKey[] keys = { new MapKeyImpl(), new MapKeyImpl(), new MapKeyImpl(),
				new MapKeyImpl(), new MapKeyImpl(), new MapKeyImpl(),
				new MapKeyImpl(), new MapKeyImpl(), new MapKeyImpl(),
				new MapKeyImpl() };
		// Create test map
		Map<IMapKey, Integer> map1 = new HashMap<IMapKey, Integer>();
		Map<IMapKey, Integer> map2 = new HashMap<IMapKey, Integer>();
		// Fill test map with random values
		for (int i = 0; i < 10; i++) {
			map1.put(keys[i], (int) (Math.random() * 10));
		}
		for (int i = 0; i < 10; i++) {
			map2.put(keys[i], (int) (Math.random() * 10));
		}
		// Output to the console test Map1 and Map2
		System.out.println("Map 1");
		MainMapTest.printMap(map1);
		System.out.println("Map 2");
		MainMapTest.printMap(map2);
		// add test maps to multimap
		IMultiMap<IMapKey, Integer> multiMapa = null;
		MapUtilsImpl mapUtil = new MapUtilsImpl();
		/* ========================merge====================== */
		multiMapa = mapUtil.merge(map1, map2);
		// Print size and content of multimap
		System.out.println("Size of multiMap: " + multiMapa.size());

		Set<IMapKey> setKeys = multiMapa.keySet();
		for (IMapKey key : setKeys) {
			System.out.print(key.getValue() + ":");
			for (Iterator<Integer> iter = multiMapa.valuesIterator(key); iter
					.hasNext();) {
				System.out.print(" " + iter.next());
			}
			System.out.println();
		}
		// Test multimap methods
		System.out
				.println("Returns the number of values for the specified key №3: : "
						+ multiMapa.countValues(keys[2]));
		multiMapa.put(keys[2], 4);
		System.out
				.println("Returns the number of values for the specified key №3 : "
						+ multiMapa.countValues(keys[2]));

		System.out.println("Checks if the elements in the collection? "
				+ multiMapa.isEmpty());
		multiMapa.clear();
		System.out.println("Checks if the elements in the collection? "
				+ multiMapa.isEmpty());

	}

}

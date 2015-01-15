package com.sourceit.radchenko.hw5.impl;

import java.util.Map;
import java.util.Map.Entry;

import com.sourceit.radchenko.hw5.IMapKey;
import com.sourceit.radchenko.hw5.IMapUtils;
import com.sourceit.radchenko.hw5.IMultiMap;

public class MapUtilsImpl implements IMapUtils {

	@Override
	public IMultiMap<IMapKey, Integer> merge(
			@SuppressWarnings("unchecked") Map<IMapKey, Integer>... maps)
			throws IllegalArgumentException {

		IMultiMap<IMapKey, Integer> multiMapa = new MultiMapImpl<IMapKey, Integer>();

		for (Map<IMapKey, Integer> map : maps) {

			if (map == null) {
				throw new IllegalArgumentException(
						"One of arguments is not initialized");
			}

			for (Entry<IMapKey, Integer> entry : map.entrySet()) {
				multiMapa.put(entry.getKey(), entry.getValue());
			}

		}

		return multiMapa;
	}

}

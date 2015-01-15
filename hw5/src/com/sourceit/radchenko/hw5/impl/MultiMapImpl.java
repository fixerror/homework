package com.sourceit.radchenko.hw5.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.sourceit.radchenko.hw5.IMultiMap;

public class MultiMapImpl<K, V> implements IMultiMap<K, V> {
	private Map<K, LinkedList<V>> map;

	public MultiMapImpl() {
		this.map = new LinkedHashMap<K, LinkedList<V>>();

	}

	@Override
	public int countValues(K key) {
		LinkedList<V> value = this.map.get(key);
		return value.size();
	}

	@Override
	public Iterator<V> valuesIterator(K key) {
		LinkedList<V> value = this.map.get(key);
		return value.iterator();
	}

	public V get(Object key) {
		LinkedList<V> value = this.map.get(key);
		return value.getLast();
	}

	public V remove(Object key) {
		LinkedList<V> value = this.map.get(key);
		value.clear();
		return null;
	}

	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return this.map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		ArrayList<LinkedList<V>> valueList = new ArrayList<LinkedList<V>>(
				this.map.values());
		boolean result = false;
		for (LinkedList<V> linkedList : valueList) {
			if (linkedList.contains(value)) {
				result = true;
				break;
			}
			;
		}
		return result;
	}

	@Override
	public V put(K key, V value) {
		if (!this.map.containsKey(key)) {
			this.map.put(key, new LinkedList<V>());
			this.map.get(key).add(value);
		} else {
			LinkedList<V> listValue = this.map.get(key);
			listValue.add(value);
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
			this.put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void clear() {
		this.map.clear();
	}

	@Override
	public Set<K> keySet() {
		return this.map.keySet();
	}

	@Override
	public Collection<V> values() {
		ArrayList<V> arrlist = new ArrayList<V>();
		for (java.util.Map.Entry<K, LinkedList<V>> entry : this.map.entrySet()) {
			LinkedList<V> entryList = entry.getValue();
			for (V value : entryList) {
				arrlist.add(value);
			}
		}
		return arrlist;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return null;
	}

}

package com.sourceit.radchenko.hw5.impl;

import com.sourceit.radchenko.hw5.IMapKey;

public class MapKeyImpl implements IMapKey {
	private int numberOfKey;
	private static int numberOfInstanse = 0;

	public MapKeyImpl() {
		this.numberOfKey = numberOfInstanse++;
	}

	@Override
	public String getValue() {
		return "Key " + this.numberOfKey;

	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public static void setCountOfInstanse(int i) {
		MapKeyImpl.numberOfInstanse = i;
	}

}

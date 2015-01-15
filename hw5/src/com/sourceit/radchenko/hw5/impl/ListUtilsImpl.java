package com.sourceit.radchenko.hw5.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.sourceit.radchenko.hw5.IListUtils;

public class ListUtilsImpl implements IListUtils {

	@Override
	public List<String> asList(String... strings)
			throws IllegalArgumentException {
		int len = strings.length;
		List<String> result = new LinkedList<String>();
		for (int i = 0; i < len; i++) {
			if (strings[i] == null) {
				throw new IllegalArgumentException();
			}
			result.add(strings[i]);
		}
		return result;
	}

	@Override
	public List<Double> sortedList(List<Double> data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		List<Double> result = new ArrayList<Double>(data);
		Collections.sort(result, DecComoarator);
		return result;
	}

	static final Comparator<Double> DecComoarator = new Comparator<Double>() {
		@Override
		public int compare(Double o1, Double o2) {
			if (o1 < o2)
				return 1;
			if (o1 > o2)
				return -1;
			return 0;
		}

	};

}

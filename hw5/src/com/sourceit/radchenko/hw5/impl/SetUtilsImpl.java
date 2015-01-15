package com.sourceit.radchenko.hw5.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.sourceit.radchenko.hw5.ISetUtils;

public class SetUtilsImpl implements ISetUtils {
	private int amount;

	public int getAmount() {
		return amount;
	}

	@Override
	public SortedSet<String> orderedSet(Collection<Integer> collection1,
			Set<String> set2) throws NullPointerException {
		if (collection1 == null) {
			throw new NullPointerException();
		}
		if (set2 == null) {
			throw new NullPointerException();
		}
		Comparator<String> compback = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2)

			{
				return (-1) * o1.compareTo(o2);
			}
		};
		SortedSet<String> result = new TreeSet<String>(compback);
		for (Integer val : collection1) {
			result.add(val.toString());
		}
		result.addAll(set2);
		return result;
	}

	public Set<String> asset(String... s) throws IllegalArgumentException {

		int len = s.length;
		Set<String> result = new HashSet<String>();
		for (int k = 0; k < len; k++) {
			if (s[k] == null) {
				throw new IllegalArgumentException();
			}
			result.add(s[k]);
		}
		return result;
	}

	@Override
	public Set<Integer> customOrderSet(int val1, int val2, int val3, int val4,
			int val5) {
		int[] arrayParams = { val1, val2, val3, val4, val5 };
		Set<Integer> result = new TreeSet<Integer>(new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				int val1 = ((Integer) o1).intValue();
				int val2 = ((Integer) o2).intValue();
				return (val1 < val2 ? -1 : (val1 == val2 ? 0 : 1));
			}
		});
		for (int i = 0; i < arrayParams.length; i++) {
			result.add(arrayParams[i]);
		}
		return result;
	}
}

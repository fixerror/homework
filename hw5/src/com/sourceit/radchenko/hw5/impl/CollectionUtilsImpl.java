package com.sourceit.radchenko.hw5.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sourceit.radchenko.hw5.ICollectionUtils;

public class CollectionUtilsImpl implements ICollectionUtils {

	@Override
	public Collection<Integer> union(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		if (a == null || b == null) {
			throw new NullPointerException("One of parametr is null");
		}
		List<Integer> result = new LinkedList<Integer>();
		result.clear();
		result.addAll(a);
		result.addAll(b);
		return result;
	}

	@Override
	public Collection<Integer> intersection(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		List<Integer> result = new LinkedList<Integer>();
		result.clear();
		result.addAll(a);
		result.retainAll(b);
		return result;
	}

	@Override
	public Set<Integer> unionWithoutDuplicate(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		Set<Integer> result = new HashSet<Integer>(a);
		result.addAll(b);
		return result;
	}

	@Override
	public Set<Integer> intersectionWithoutDuplicate(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		Set<Integer> result = new HashSet<Integer>(a);
		result.retainAll(b);
		return result;
	}

	@Override
	public Collection<Integer> difference(Collection<Integer> a,
			Collection<Integer> b) throws NullPointerException {
		if (a == null || b == null) {
			throw new NullPointerException();
		}
		Set<Integer> result = new HashSet<Integer>(a);
		result.removeAll(b);
		return result;
	}

}

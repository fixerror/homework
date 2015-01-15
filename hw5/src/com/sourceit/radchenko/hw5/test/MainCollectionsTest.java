package com.sourceit.radchenko.hw5.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sourceit.radchenko.hw5.impl.CollectionUtilsImpl;
import com.sourceit.radchenko.hw5.impl.ListUtilsImpl;
import com.sourceit.radchenko.hw5.impl.SetUtilsImpl;

public class MainCollectionsTest {

	private static <T> void printCollection(Collection<T> colect) {
		for (T elem : colect) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		/* ========CollectionUtilsImplementation===================== */
		/* ========================================================== */
		// Create test collections, which have different types
		List<Integer> colect1 = new ArrayList<Integer>();
		List<Integer> colect2 = new ArrayList<Integer>();
		// fill collections with random values colect1
		for (int i = 0; i < 10; i++) {
			int j = (int) (Math.random() * 10);
			colect1.add(j);
		}
		// fill collections with random values colect2
		for (int i = 0; i < 10; i++) {
			int j = (int) (Math.random() * 10);
			colect2.add(j);
		}
		// add duplicates and print collections
		colect2.add(colect1.get(0));
		colect2.add(colect1.get(0));
		System.out.println("Creating test of Collection 1:");
		MainCollectionsTest.printCollection(colect1);
		System.out.println("Creating test of Collection 2:");
		MainCollectionsTest.printCollection(colect2);
		/* ========================================================== */
		// create object CollectionUtilites
		CollectionUtilsImpl relizColection = new CollectionUtilsImpl();
		/* ============union========================================= */
		try {
			System.out
					.println("Combining the two collections with duplicate Union: ");
			MainCollectionsTest.printCollection(relizColection.union(colect1,
					colect2));
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
		/* ============intersection================================== */
		try {
			System.out
					.println("The intersection of two collections of duplicates Intersection: ");
			MainCollectionsTest.printCollection(relizColection.intersection(
					colect1, colect2));
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
		/* ============unionWithoutDuplicate========================= */
		try {
			System.out
					.println("Combining the two collections without duplicates unionWithoutDuplicate: ");
			MainCollectionsTest.printCollection(relizColection
					.unionWithoutDuplicate(colect1, colect2));

		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
		/* ============intersectionWithoutDuplicate================== */
		try {
			System.out
					.println("The intersection of two collections without duplicates intersectionWithoutDuplicate: ");
			MainCollectionsTest.printCollection(relizColection
					.intersectionWithoutDuplicate(colect1, colect2));
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
		/* ============difference==================================== */
		// Разность двух коллекций
		try {
			System.out
					.println("The difference between the two collections difference: ");
			MainCollectionsTest.printCollection(relizColection.difference(
					colect1, colect2));
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		}
		/* ============ListUtilsImplementation======================= */
		String str1 = "Hello";
		String str2 = "World";
		String str3 = "Java";
		/* ======================asList============================== */
		ListUtilsImpl listUtil = new ListUtilsImpl();
		List<String> newList = null;
		try {
			newList = listUtil.asList(str1, str2, str3);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			newList = Collections.emptyList();
		} finally {
			System.out
					.println("Converts a variable number of parameters in the list of strings Sting asList: ");
			for (String string : newList) {
				System.out.print(string + " ");
			}
		}
		System.out.println();
		// create test List and fill it with random values
		List<Double> testSortedList = new LinkedList<Double>();
		System.out.println("Prints are not sorted list: ");
		for (int i = 0; i < 10; i++) {
			Double d = Math.round(Math.random() * Math.pow(10, 2))
					/ Math.pow(10, 2);
			testSortedList.add(d);
			System.out.print(d + " ");
		}
		System.out.println();
		/* =====================sortedList=========================== */
		System.out.println("Prints sorted list sortedList: ");
		List<Double> sortList = null;
		try {
			sortList = listUtil.sortedList(testSortedList);
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
			sortList = Collections.emptyList();
		} finally {

			for (Double double1 : sortList) {
				System.out.print(double1 + " ");
			}
			/* ====================SetUtils============================== */
			System.out.println();
			System.out
					.println("Returns a sorted set of in the reverse order (descending) as");
			System.out.println("the union of two collections:");
			List<Integer> colect3 = new ArrayList<Integer>();
			for (int i = 0; i < 6; i++) {
				int j = (int) (Math.random() * 10);
				colect3.add(j);
			}
			String s1 = "c";
			String s2 = "a";
			String s3 = "b";
			SetUtilsImpl set2 = new SetUtilsImpl();
			Set<String> newSet = set2.asset(s1, s2, s3);
			/* ======================orderedSet========================== */
			System.out.println(set2.orderedSet(colect3, newSet));
			/* ========================================================== */
			int val1 = 4;
			int val2 = 5;
			int val3 = 3;
			int val4 = 2;
			int val5 = 1;
			System.out
					.println("Returns a set of numbers val1,val2,val3,val4,val5 ");
			System.out.println("in the same order");
			/* ======================customOrderSet====================== */
			System.out.println(set2
					.customOrderSet(val1, val2, val3, val4, val5));

		}
	}

}

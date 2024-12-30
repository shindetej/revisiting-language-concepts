package com.tejas.day045;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindIntesection {
	public static void main(String[] args) {
		int[] a = { 1, 2, 1, 3, 1 }, b = { 3, 1, 3, 4, 1 };

		System.out.println(intersectionWithDuplicates(a, b));
	}

	private static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			set.add(i);
		}
		Set<Integer> result = new HashSet<>();
		for (int j : b) {
			if (set.contains(j) & !result.contains(j)) {
				result.add(j);
			}
		}
		return new ArrayList(result);
	}
}

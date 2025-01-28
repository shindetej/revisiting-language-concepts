package com.tejas.day075;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BackTrackingPermutation {
	public static void main(String[] args) {
		String s = "FSWA";
		List<String> res = findPermutation(s);
		for (String x : res) {
			System.out.print(x + " ");
		}
	}

	public static void backtrack(int index, StringBuilder s, Set<String> result) {
		if (index == s.length()) {
			result.add(s.toString());
			return;
		}

		for (int i = index; i < s.length(); i++) {
			swap(s, index, i);
			backtrack(index + 1, s, result);

			swap(s, index, i);
		}
	}

	static void swap(StringBuilder s, int i, int j) {
		char temp = s.charAt(i);
		s.setCharAt(i, s.charAt(j));
		s.setCharAt(j, temp);
	}

	public static ArrayList<String> findPermutation(String s) {
		Set<String> result = new HashSet<>();
		ArrayList<String> resultList = new ArrayList<>();
		StringBuilder current = new StringBuilder(s);

		backtrack(0, current, result);

		resultList.addAll(result);
		Collections.sort(resultList);

		return resultList;
	}

}

package com.tejas.day16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnagramProblem {
	public static void main(String[] args) {
		String s1 = "acter";
		String s2 = "hrcat";

		System.out.println(areAnagrams(s1, s2));
		System.out.println(areAnagramsSimpleApproach(s1, s2));
		System.out.println(areAnagramsApproach2(s1, s2));
	}

	public static Boolean areAnagrams(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			map.put(c1, map.getOrDefault(c1, 0) + 1);
			map.put(c2, map.getOrDefault(c2, 0) - 1);
		}

		for (int count : map.values()) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

	public static Boolean areAnagramsApproach2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		char[] cArr = new char[26];

		for (int i = 0; i < s1.length(); i++) {
			cArr[s1.charAt(i) - 'a']++;
			cArr[s2.charAt(i) - 'a']--;
		}

		for (int count : cArr) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

	public static Boolean areAnagramsSimpleApproach(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);

		return Arrays.equals(c1, c2);
	}
}

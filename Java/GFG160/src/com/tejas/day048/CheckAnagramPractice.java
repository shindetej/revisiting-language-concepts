package com.tejas.day048;

import java.util.Arrays;

public class CheckAnagramPractice {
	public static void main(String[] args) {
		String s1 = "dog";
		String s2 = "gd";

		System.out.println("IS ANAGRAM " + checkAnagram(s1, s2));

	}

	private static boolean checkAnagram(String s1, String s2) {
		char[] carr1 = s1.toCharArray();
		char[] carr2 = s2.toCharArray();
		if(s1.length() != s2.length()) {
			return false;
		}
		Arrays.sort(carr1);
		Arrays.sort(carr2);
		for (int i = 0; i < carr1.length; i++) {
			if (carr1[i] != carr2[i])
				return false;
		}
		return true;
	}
}

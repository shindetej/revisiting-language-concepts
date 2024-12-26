package com.tejas.day42;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 10, 4, 6, 12, 8, 34 };
		int target = 18;

		System.out.println(twoSum(arr, target));

	}

	private static boolean twoSum(int[] arr, int target) {
		Set<Integer> set = new HashSet<>();

		for (int i : arr) {
			int balance = target - i;
			if (set.contains(balance)) {
				return true;
			} else {
				set.add(i);
			}
		}
		return false;
	}
}

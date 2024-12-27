package com.tejas.day043;

import java.util.HashMap;
import java.util.Map;

public class CountPairs {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 1, 6, 5, 10, -4, 0 };

		int target = 6;

		System.out.println("COUNT IS :" + countPairs(arr, target));
	}

	public static int countPairs(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int num : arr) {
			int balance = target - num;
			System.out.println("DEBUG : count ("+ count+ ") + "+map.getOrDefault(balance, 0));
			count += map.getOrDefault(balance, 0);
			
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		return count;

	}
}

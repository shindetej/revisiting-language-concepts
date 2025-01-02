package com.tejas.day049;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSumK {
	public static void main(String[] args) {
		int[] arr = {10, 2, -2, -20, 10 };
		int k = -10;
		
		System.out.println("COUNT OF SUB ARRAYS WITH SUM "+ k +"  :  " +countSubarrays(arr, k));
	}

	public static int countSubarrays(int arr[], int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int prefixSum = 0;
		int count = 0;
		for (int num : arr) {
			prefixSum += num;
			int subArraySum = prefixSum - k;

			if (map.containsKey(subArraySum)) {
				count += map.get(subArraySum);
			}
			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		}
		return count;
	}
}

package com.tejas.day062;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKNum {
	public static void main(String[] args) {
		int[] arr = {10, 5, 2, 7, 1, -10};
		int k = 15;
		
		System.out.println("Count of subarray :  "+ longestSubarray(arr, k));
	}
	public static int longestSubarray(int[] arr, int k) {
		int prefixSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];
			if (prefixSum == k) {
				maxLen = i + 1;
			} else if (map.containsKey(prefixSum - k)) {
				maxLen = Math.max(maxLen, i - map.get(prefixSum - k));

			}
			map.putIfAbsent(prefixSum, i);

		}
		return maxLen;
	}
}

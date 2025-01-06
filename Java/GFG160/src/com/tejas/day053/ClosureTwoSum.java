package com.tejas.day053;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosureTwoSum {

	public static void main(String[] args) {
		int[] arr = { 10, 30, 20, 5 };
		int target = 25;
		System.out.println(sumClosest(arr, target)); 
	}

	public static List<Integer> sumClosest(int[] arr, int target) {
		Arrays.sort(arr);
		List<Integer> result = new ArrayList<>();
		int left = 0;
		int right = arr.length - 1;
		int minDiff = Integer.MAX_VALUE;

		while (left < right) {
			int sum = arr[left] + arr[right];
			int diff = Math.abs(sum - target);

			if (diff < minDiff || (diff == minDiff && (arr[right] - arr[left] > (result.get(1) - result.get(0))))) {
				result = Arrays.asList(arr[left], arr[right]);
				minDiff = diff;
			}

			if (sum < target) {
				left++;
			} else {
				right--;
			}
		}

		return result;
	}
}

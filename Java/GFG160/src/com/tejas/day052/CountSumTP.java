package com.tejas.day052;

import java.util.Arrays;

public class CountSumTP {
	public static void main(String[] args) {
		int[] arr = { 7, 2, 5, 3 };
		int target = 8;

		System.out.println(countPairs(arr, target));
	}

	static int countPairs(int arr[], int target) {
		Arrays.sort(arr);

		int left = 0;
		int right = arr.length - 1;
		int cnt = 0;

		while (left < right) {
			if ((arr[left] + arr[right]) < target) {
				cnt += (right - left);
				left += 1;
			} else {
				right -= 1;
			}
		}
		return cnt;
	}
}

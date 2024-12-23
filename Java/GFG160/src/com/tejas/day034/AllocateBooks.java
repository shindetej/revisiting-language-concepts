package com.tejas.day034;

import java.util.Arrays;

public class AllocateBooks {
	public static void main(String[] args) {
		int[] arr = { 12, 34, 67, 90 };
		int k = 2;
		System.out.println(findPages(arr, k));
	}

	private static int findPages(int[] arr, int k) {
		// number of student > books
		if (arr.length < k) {
			return -1;
		}

		int low = Arrays.stream(arr).max().getAsInt();
		int high = Arrays.stream(arr).sum();

		int result = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (checkForBook(arr, mid, k)) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	private static boolean checkForBook(int[] arr, int pageLimit, int k) {
		int cnt = 1;
		int pageSum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (pageSum + arr[i] > pageLimit) {
				cnt++;
				pageSum = arr[i];
			} else {
				pageSum += arr[i];
			}
		}
		return (cnt <= k);
	}
}

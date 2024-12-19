package com.tejas.day033;

public class KthMissing {
	public static void main(String[] args) {
		int[] arr = { 2, 3,5,6};
		int k = 2;
		System.out.println(kthMissing(arr, k));
	}

	private static int kthMissing(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		int result = arr.length + k;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > mid + k) {
				result = mid + k;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;

	}
}

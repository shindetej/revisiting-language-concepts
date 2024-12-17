package com.tejas.day028;

public class MinimumFind {
	public static void main(String[] args) {
		int[] a1 = { 101, 102, 102, 104, 120, 121, 40, 50, 91, 96 };
		System.out.println("find min : " + findMin(a1));
		System.out.println("find min optimized: " + findMinOptimized(a1));
	}

	static int findMin(int[] arr) {
		if (arr[0] <= arr[arr.length - 1]) {
			return arr[0];
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return arr[i + 1];
			}
		}

		return arr[arr.length - 1];
	}

	static int findMinOptimized(int[] arr) {
		int low = 0, high = arr.length - 1;

		if (arr[low] <= arr[high]) {
			return arr[low];
		}

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > arr[mid + 1]) {
				return arr[mid + 1];
			}

			if (arr[mid - 1] > arr[mid]) {
				return arr[mid];
			}

			if (arr[mid] >= arr[low]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
}

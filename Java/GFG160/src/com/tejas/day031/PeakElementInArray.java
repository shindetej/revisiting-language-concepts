package com.tejas.day031;

public class PeakElementInArray {
	public static void main(String[] args) {
		int[] ar1 = { 1, 2, 4, 5, 7, 8, 3 };
		System.out.println("PEAK ELEMENT : " + peakElement(ar1));
	}

	private static int peakElement(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return 0;

		if (arr[0] > arr[1]) {
			return 0;
		}

		if (arr[n - 1] > arr[n - 2]) {
			return n - 1;
		}

		int l = 1, h = n - 2;

		while (l <= h) {
			int mid = l + (h - l) / 2;

			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				return mid;
			}

			if (arr[mid] < arr[mid + 1]) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return 0;
	}

}

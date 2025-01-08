package com.tejas.day055;

import java.util.Arrays;

public class CountTrianglePair {
	public static void main(String[] args) {
		int[] arr = {4, 6, 3, 7 };
	

		System.out.println("Triangle count " + countTriangles(arr));
	}

	static int countTriangles(int arr[]) {
		Arrays.sort(arr);

		int count = 0;
		// in sorted array we find third side is larger
		for (int i = 2; i < arr.length; i++) {
			int left = 0;
			int right = i - 1; // 2nd larger
			while (left < right) {
				if (arr[left] + arr[right] > arr[i]) {
					count += right - left;
					right--;
				} else {
					left++;
				}
			}
		}
		return count;
	}
}

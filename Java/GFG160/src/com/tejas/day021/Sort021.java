package com.tejas.day021;

import java.util.Arrays;

public class Sort021 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 1, 2 };
		sort012(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void sort012(int[] arr) {
		int n = arr.length;
		int left = 0;
		int right = n - 1;
		int mid = 0;

		while (mid <= right) {
			System.out.println(Arrays.toString(arr));
			System.out.println(" mid : " + mid);
			System.out.println(" left : " + left);
			System.out.println(" right : " + right);
			System.out.println(" arr[mid] : " + arr[mid]);

			System.out.println("=======================================\n");
			if (arr[mid] == 0) {
				int temp = arr[mid];
				arr[mid] = arr[left];
				arr[left] = temp;
				left++;
				mid++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				int temp = arr[mid];
				arr[mid] = arr[right];
				arr[right] = temp;
				right--;
			}
		}

	}
}

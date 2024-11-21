package com.tejas.day2;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] arr = { 10, 11, 12, 20, 30 };
		int byPosition = 2;
		rotateArray(arr, byPosition);
	}

	private static void rotateArray(int[] arr, int d) {

		int n = arr.length;
		d = d % n;
		
		System.out.println("Rotate array " + Arrays.toString(arr) + " to left by "+ d +" position");
		reverse(arr, 0, d - 1);
		reverse(arr, d, n - 1);
		reverse(arr, 0, n - 1);
		System.out.println("Rotated array : " + Arrays.toString(arr) );
	}

	public static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
	}

}

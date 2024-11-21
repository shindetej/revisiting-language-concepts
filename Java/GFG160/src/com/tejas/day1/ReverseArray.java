package com.tejas.day1;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr =  { 12, 34, 78, 1 ,10};
		
		reverseArrayReadable(arr);
	}

	private static void reverseArray(int[] arr) {
		int n =  arr.length;
		for(int i = 0;i<n/2;i++) {
			int temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	private static void reverseArrayReadable(int[] arr) {
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
		    int temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}

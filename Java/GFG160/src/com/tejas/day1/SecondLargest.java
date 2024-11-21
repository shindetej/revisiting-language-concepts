package com.tejas.day1;

import java.util.Arrays;

public class SecondLargest {

	public static void main(String[] args) {
		int[] arr = { 12, 35, 1, 10, 34, 78, 1 };
		

		System.out.println(" Second Highest : " + getSecondLargest(arr));
		

	}

	// Two pointers
	public static int getSecondLargest(int[] arr) {
		int highest = arr[0];

		int secondHighest = -1;

		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] > highest) {
				secondHighest = highest;
				highest = arr[i];
			} else if (arr[i] != highest && arr[i] > secondHighest) {
				secondHighest = arr[i];
			}
		}

		return secondHighest;
	}

//	public static void putZerosToEnd(int[] arr) {
//
//		int latestZeroIndex = arr.length - 1;
//
//		for (int i = latestZeroIndex; i > 0; i--) {
//			if (i != arr.length - 1) {
//				if (arr[i] == 0 && arr[i + 1] != 0) {
//					// swap
//					int temp = arr[latestZeroIndex];
//					arr[latestZeroIndex] = arr[i];
//					arr[i] = temp;
//					latestZeroIndex--;
//				}
//			}
//		}
//		
//		System.out.println(Arrays.toString(arr));
//
//	}
	

}

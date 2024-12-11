package com.tejas.day01;

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


	

}

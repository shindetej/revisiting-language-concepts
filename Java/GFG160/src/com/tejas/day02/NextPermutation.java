package com.tejas.day02;

import java.util.Arrays;

/**
 * WHAT IS PERMUTATION : arrangement of elements where order matters
 * 
 * what is next permutation problem It is finding the next lexicographically
 * larger permutation of an array of numbers. when lexographically sorted 3
 * number array it looks like [1,2,5] [1,5,2] [2,1,5] [2,5,1] [5,1,2] [5,2,1]
 * 
 * Algorithm Steps : 1. find from rightmost number which is smaller than
 * immediate right ,assume it pivot 2. find number greater that pivot but
 * smaller than other numbers in right sub array of pivot 3. SWAP those numbers
 * 4. Reverse the sub array right to pivot
 * 
 * @author tshinde
 *
 */

public class NextPermutation {
	public static void main(String[] args) {
//		int[] arr = { 3, 2, 1 };
		int[] arr = { 3, 4, 2, 5, 1 };

		nextPermutation(arr);
	}

	private static void nextPermutation(int[] arr) {
		System.out.println("BEFORE PERMUTATION :  " + Arrays.toString(arr));
		int pivotIndex = -1;
		int len = arr.length;

		// Step 1: Find the pivot (rightmost element smaller than the next one
		for (int i = len - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				pivotIndex = i;
				break;
			}
		}
		
		
		if (pivotIndex != -1) { 
			// Step 2: Find the smallest number larger than pivot (search from the end)
			
			for (int j = len-1; j > pivotIndex; j--) {
				if (arr[j] > arr[pivotIndex])  // IMPORTANT !!
				{	
					int temp  =  arr[pivotIndex];
					arr[pivotIndex] = arr[j];
					arr[j] = temp;
					break;
				}
			}
		}
		
		// Reverse the sub array right to pivot
		RotateArray.reverse(arr, pivotIndex + 1, len - 1);

		System.out.println("AFTER PERMUTATION :  " + Arrays.toString(arr));
	}
}

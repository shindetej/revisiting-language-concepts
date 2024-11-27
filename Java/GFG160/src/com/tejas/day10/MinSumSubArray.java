package com.tejas.day10;

// find max sum subarray from given list of array
public class MinSumSubArray {
	public static void main(String[] args) {
		int[] arr = { 2,3,-5,4,-7 };
//		int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
		int[] arr2 = { -2, -3, 4, -1, -2, 1, 5, -3 };
	
		System.out.println("--------- Kadane's Algorithm -----");
		System.out.println(maxSubarraySum(arr));
		System.out.println(maxSubarraySum(arr2));
		System.out.println("--------- PRINTING SUB ARRAY for Kadane's Algorithm -----");
		maxSumSubarray(arr);
		maxSumSubarray(arr2);
	}

	// KADANE's formula 
	private static int maxSubarraySum(int[] arr) {
		int sum = 0, n = arr.length;
		int minSum = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (sum < minSum) {
				minSum = sum;
			}

			if (sum > 0) {
				sum = 0;
			}
		}

		return minSum;
	}

	private static void maxSumSubarray(int[] arr) {
		int sum = 0, n = arr.length;
		int maxSum = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			if (sum == 0)
				start = i;
			sum += arr[i];

			if (sum > maxSum) {
				maxSum = sum;
				end = i;
			}

			if (sum < 0) {
				sum = 0;
			}
		}

		System.out.println("PRINTING SUB ARRAY :");
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println("");
	}


}

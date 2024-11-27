package com.tejas.day09;

// find max sum subarray from given list of array
public class KadanesAlgo {
	public static void main(String[] args) {
		int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
		int[] arr2 = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("--------- BRUTE FORCE APPROACH -----");
		System.out.println(maxSubarraySumBrute(arr));
		System.out.println(maxSubarraySumBrute(arr2));
		System.out.println("--------- Slight BETTER FORCE APPROACH -----");
		System.out.println(maxSubarraySumBetter(arr));
		System.out.println(maxSubarraySumBetter(arr2));
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
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			sum += arr[i];

			if (sum > maxSum) {
				maxSum = sum;
			}

			if (sum < 0) {
				sum = 0;
			}
		}

		return maxSum;
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

	private static int maxSubarraySumBetter(int[] arr) {

		int n = arr.length;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				maxSum = Math.max(sum, maxSum);
			}
//			System.out.println("max sum after "+ i+"th iteration :"+maxSum );

		}
		return maxSum;
	}

	private static int maxSubarraySumBrute(int[] arr) {

		int n = arr.length;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				// from i to j
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
//				System.out.println("SUM @ i=" +i + " @j="+j +" : ="+sum);
				maxSum = Math.max(sum, maxSum);
			}
		}
		return maxSum;
	}
}

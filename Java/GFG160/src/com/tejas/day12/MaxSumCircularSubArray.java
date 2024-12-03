package com.tejas.day12;



/*
* STEPS: 
*  1.  Use Kadane's algorithm to find the maximum subarray sum (maxSum) for the linear array.
*  2. Use another pass to calculate the minimum subarray sum (minSum).
*  3. Compute the total sum of the array (totalSum).
*  4. If all elements are negative, the maximum circular sum is simply the maximum element.
*  5. Otherwise, calculate the circular sum as totalSum - minSum.
*  6. The result is the maximum of maxSum and the circular sum.
*/
public class MaxSumCircularSubArray {
	public static void main(String[] args) {
		int[] arr = { 8, -8, 9, -9, 10, -11, 12 };

		System.out.println("--------- Kadane's Algorithm -----");
		System.out.println(circularSubarraySum(arr));
		System.out.println("--------- Kadane's Algorithm USING CGPT WAY -----");
		System.out.println(CSumSubArrayWay2(arr));
	}

	// KADANE's formula
	private static int circularSubarraySum(int arr[]) {
		int n = arr.length;
		int currentMax = 0;
		int currentMin = 0;
		int minSum = Integer.MAX_VALUE;
		int maxSum = Integer.MIN_VALUE;
		int totalSumOfArray = 0;

		for (int i = 0; i < n; i++) {
			// Use kadane's to get minimum sum
			currentMin += arr[i];
			currentMax += arr[i];
			totalSumOfArray += arr[i];

			// kadane's min sum condition
			minSum = currentMin < minSum ? currentMin : minSum;
			currentMin = currentMin > 0 ? 0 : currentMin;

			// kadane's max sum condition
			maxSum = currentMax > maxSum ? currentMax : maxSum;
			currentMax = currentMax < 0 ? 0 : currentMax;
		}
		System.out.println("MIN SUM : " + minSum);
		System.out.println("Total SUM : " + totalSumOfArray);
		System.out.println("Max SUM : " + maxSum);
		if (maxSum < 0) {
			return maxSum; // All elements are negative
		}

		return Math.max(maxSum, totalSumOfArray - minSum);
	}

	private static int CSumSubArrayWay2(int arr[]) {
		int n = arr.length;

		// Variables for Kadane's Algorithm
		int currentMax = 0, maxSum = Integer.MIN_VALUE;
		int currentMin = 0, minSum = Integer.MAX_VALUE;
		int totalSumOfArray = 0;

		for (int i = 0; i < n; i++) {
			// Calculate total sum of the array
			totalSumOfArray += arr[i];

			// Kadane's for maximum sum
			currentMax = Math.max(arr[i], currentMax + arr[i]);
			maxSum = Math.max(maxSum, currentMax);

			// Kadane's for minimum sum
			currentMin = Math.min(arr[i], currentMin + arr[i]);
			minSum = Math.min(minSum, currentMin);
		}

		// Edge case: If all elements are negative, return the maximum subarray sum
		if (maxSum < 0) {
			return maxSum;
		}

		// Calculate maximum circular subarray sum
		int circularSum = totalSumOfArray - minSum;

		// Return the maximum of non-circular and circular subarray sums
		return Math.max(maxSum, circularSum);
	}

}

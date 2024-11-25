package com.tejas.day9;

import java.util.Arrays;

// medium level asked in microsoft and adobe
public class MinimizeHeight {

	public static void main(String[] args) {
		int[] heights = { 1,2,4,8 };
		int k = 2;
		System.out.println(getMinDiff(heights, k));
	}

	private static int getMinDiff(int[] arr, int k) {
		int n = arr.length;
		
		Arrays.sort(arr);
		int result =  arr[n-1] -arr[0];
		
		// ITERATE FROM 1 to n-1
		// ON EACH ITERATION 
		// to determine the minimum difference between the maximum and minimum heights of the array after modification.
		for(int i = 1;i<n;i++) {
			if(arr[i]<k) continue; // Step 2 to get min has negative values which fails condition
			
			// Determines the new maximum value in the array after modifications
			int max  = Math.max(arr[i-1]+k, arr[n-1]-k);
			
			// Determines the new minimum value in the array after modifications
			int min = Math.min(arr[0]+k, arr[i]-k);
			
			// Determines minimum among result and current difference
			result =  Math.min(result,(max-min));
			System.out.println("MAX : " + max + " MIN  : " + min + "  difference : " + (max - min)
					+ " RESULT min(existing min ,new difference) :" + result);
		}
		
		return result;
	}

	static int getMinDiffWay1(int[] arr, int k) {

		int n = arr.length;
		if (n == 1)
			return 0;
		// code
		Arrays.sort(arr);
		int minHeight = arr[n - 1] - arr[0];

		// iterate till n-2
		/*
		 * DO: if i+1th value < k then at 2nd step we may get negative value hence skip
		 * this iteration here 1st - get for maximum between ith element after adding k
		 * and n-1th element 2nd - after reducing k get for minimum between 1st (0th)
		 * element after adding k and 3i+1th element after reducing k
		 * 
		 * subtract max - min and store it to min height
		 */
		for (int i = 0; i < n - 1; i++) {

			if (arr[i + 1] < k)
				continue;
			int max = Math.max(arr[i] + k, arr[n - 1] - k);
			int min = Math.min(arr[0] + k, arr[i + 1] - k);
			minHeight = Math.min(minHeight, max - min);

			System.out.println("MAX : " + max + " MIN  : " + min + "  difference : " + (max - min)
					+ " RESULT min(existing min ,new difference) :" + minHeight);

		}

		return minHeight;
	}

}

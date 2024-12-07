package com.tejas.day023;

import java.util.Arrays;

// problem statement
/*
 * Given an array of integers arr[]. Find the Inversion Count in the array.
 * Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
 * Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. 
 * If the array is already sorted then the inversion count is 0.
 * If an array is sorted in the reverse order then the inversion count is the maximum. 
 * */
public class InvertedRotations {
	public static void main(String[] args) {
		int[] arr1 = { 2, 4, 1, 3, 5 };
		int[] arr2 = { 2, 4, 7, 5, 3 };
		int[] arr3 = { 10, 10, 10 };

		System.out.println("Inversion count for arr1  :" + inversionCount(arr1));
		System.out.println("Inversion count for arr2  :" + inversionCount(arr2));
		System.out.println("Inversion count for arr3  :" + inversionCount(arr3));

	}

	static int inversionCount(int arr[]) {
		return invertedCountWithMerging(arr, 0, arr.length - 1);
	}

	private static int invertedCountWithMerging(int[] arr, int left, int right) {
		int count = 0;
		if(left < right) {
			int mid = left + (right - left) / 2;

			count += invertedCountWithMerging(arr, left, mid);
			count += invertedCountWithMerging(arr, mid + 1, right);
			count += mergingWithInversion(arr, left, mid, right);
		}
		return count;
	}

	private static int mergingWithInversion(int[] arr, int left, int mid, int right) {
		// similar steps as in merge sorting
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftSubArray = new int[n1];
		int[] rightSubArray = new int[n2];

		for (int i = 0; i < n1; i++) {
			
			leftSubArray[i] = arr[left + i];
		}

		
		for (int i = 0; i < n2; i++) {
			rightSubArray[i] = arr[mid + 1 + i];
		}
		
		
		int cnt = 0;
		int i = 0, j = 0, k = left;

		while (i < n1 && j < n2) {
			
			if (leftSubArray[i] <= rightSubArray[j]) {
				arr[k] = leftSubArray[i];
				k++;
				i++;
				
			} else {
				// if leftSubArray[i] > rightSubArray[j]
				// inversion will be happening hence increase count	
				arr[k] = rightSubArray[j];
				k++;
				j++;
				cnt +=n1-i;
				
			}
		}
		
		// remaining in left sub array to add
		while(i < n1) {
			arr[k] = leftSubArray[i];
			k++;
			i++;
		}
		while(j < n2) {
			arr[k++] = rightSubArray[j++];
		}
		
		return cnt;
	}
}

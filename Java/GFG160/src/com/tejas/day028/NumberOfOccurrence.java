package com.tejas.day028;

public class NumberOfOccurrence {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 2, 2, 3 };
		int target = 1;
		System.out.println(countFreq(arr, target));

		
		
	}

	


	static int countFreq(int[] arr, int target) {
		int count = 0;
		for (int i : arr) {
			count = (i == target) ? count + 1 : count;
		}
		return count;
	}

	

	
}

package com.tejas.codes;

import java.util.Arrays;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		int[] arr = {3,3,4,5,5,9,10,10};
		int resultIndex = removeDuplicatesFromSortedArray(arr);
		int[] result = Arrays.copyOfRange(arr, 0, resultIndex);
		
		for(int i : result) {
			System.out.println(i);
		}
		
	}

	private static int removeDuplicatesFromSortedArray(int[] arr) {
		int i = 0;
		for(int j = 1;j<arr.length;++j) {
			if(arr[i] != arr[j]) {
				arr[i+1]=arr[j];
				i++;
			}
		}
		
		return i+1;
	}

}

package com.tejas.day027;

import java.util.Arrays;

public class MergingWithoutExtraSpace {
	public static void main(String[] args) {
		
		int[] a = {2, 4, 8, 10};
		int[] b = {2, 7,9};
		
		mergeArrays(a,b);
	}

	private static void mergeArrays(int[] a, int[] b) {
		
//		int an = a.length;
//		int bn = b.length;
//		int i = 0;
//		int j = 0;
		
		int i = a.length-1; // last index of a array
		int j = 0;  // 1st index of b array
		
		while(i >= 0 && j < b.length && a[i] > b[j]) {
			// swap
			int temp = a[i];
			a[i] = b[j];
			b[j] =  temp;
			
			i--;
			j++;
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}

}

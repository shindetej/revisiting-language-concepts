package com.tejas.day01;

import java.util.Arrays;

public class PutZerosToEnd {
	public static void main(String[] args) {
		int[] arrp2 = { 10, 0, 0, 20, 30 };
		putZerosToEnd(arrp2);

	}

	public static void putZerosToEnd(int[] arr) {

		int zeroIndex = -1;
		// find 1st zeroth occurrence
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				zeroIndex = i;
				break;
			}
		}
		// if found zeroth occurrence
		if (zeroIndex != -1) {
			// iterate from next index 
			for (int i = zeroIndex + 1; i < arr.length; i++) {
				// if next index is not 0 then swap zeroIndex with ith and increment zeroth index
				if (arr[i] != 0) {
					int temp = arr[zeroIndex];
					arr[zeroIndex] = arr[i];
					arr[i] = temp;

					zeroIndex++;
				}
			}
		}

		System.out.println(Arrays.toString(arr));

	}
}

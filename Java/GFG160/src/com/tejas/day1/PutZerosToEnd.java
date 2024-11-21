package com.tejas.day1;

import java.util.Arrays;

public class PutZerosToEnd {
	public static void main(String[] args) {
		int[] arrp2 = { 10, 0, 0, 20, 30 };
		putZerosToEnd(arrp2);

	}

	public static void putZerosToEnd(int[] arr) {

		int zeroIndex = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				zeroIndex = i;
				break;
			}
		}
		if (zeroIndex != -1) {
			for (int i = zeroIndex + 1; i < arr.length; i++) {
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

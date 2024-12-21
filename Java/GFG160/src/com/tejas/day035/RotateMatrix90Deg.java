package com.tejas.day035;

import java.util.Arrays;

public class RotateMatrix90Deg {
	public static void main(String arg[]) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

//		rotateArray(arr);
		rotateArrayWithoutExtraSpace(arr);
//		rotateArrayWithoutExtraSpaceWithSingleLoop(arr);

	}

	private static void rotateArrayWithoutExtraSpace(int[][] mat) {
		int n = mat.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;

			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j <= n - 1; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n - 1 - i][j];
				mat[n - 1 - i][j] = temp;
			}
		}

		for (int[] a : mat) {
			System.out.println(Arrays.toString(a));
		}

	}

	private static void rotateArrayWithoutExtraSpaceWithSingleLoop(int[][] mat) {
		int n = mat.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][n - 1 - i];
				mat[j][n - 1 - i] = mat[n - 1 - i][n - 1 - j];
				mat[n - 1 - i][n - 1 - j] = mat[n - 1 - j][i];
				mat[n - 1 - j][i] = temp;
			}
		}

		for (int[] a : mat) {
			System.out.println(Arrays.toString(a));
		}

	}

	// Using extra space
	private static void rotateArray(int[][] arr) {

		int rows = arr.length;
		int cols = arr[0].length;
		int[][] newArr = new int[rows][cols];

		for (int i = cols - 1; i >= 0; i--) {

			for (int j = 0; j <= rows - 1; j++) {
				newArr[cols - 1 - i][j] = arr[j][i];
			}
		}
		for (int[] a : newArr) {
			System.out.println(Arrays.toString(a));
		}
	}
}

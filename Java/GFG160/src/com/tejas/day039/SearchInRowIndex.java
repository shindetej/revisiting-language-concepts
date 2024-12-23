package com.tejas.day039;

public class SearchInRowIndex {
	public static void main(String[] args) {
		int[][] arr = { { 47 }, { 37 }, { 23, 81, 179, 182, 243, 344 } };
		int x = 23;

		System.out.println("is found : " + searchRowMatrix(arr, x));
	}

	private static boolean searchRowMatrix(int[][] mat, int x) {

		int rowSize = mat.length;

		System.out.println("rows  :" + rowSize);

		int i = 0;
		while (i < rowSize ) {
			int colSize = mat[i].length;
			System.out.println("col :" + colSize);
			System.out.println("ith Row Last Element : " + mat[i][colSize - 1]);
			if (mat[i][colSize - 1] > x) {
				System.out.println(mat[i][colSize - 1] + " greater than " + x);
				int low = 0, high = colSize - 1;
				while (low <= high) {
					int mid = low + (high - low) / 2;
					if (mat[i][mid] == x) {
						return true;
					}

					if (mat[i][mid] > x) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				}
			} else if (mat[i][colSize - 1] == x) {
				return true;
			}
			i++;
		}

		return false;

	}
}

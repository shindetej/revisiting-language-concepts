package com.tejas.day038;

public class SearchInMatrix {

	public static void main(String[] args) {
		int[][] arr = { { 3, 30, 38 }, { 20, 52, 54 }, { 35, 60, 69 } };

		int x = 20;

		System.out.println("IS FOUND " + matSearch(arr, x));
	}

	private static boolean matSearch(int[][] mat, int x) {
		int m = mat[0].length;
		int n = mat.length;

		int row = 0, col = m - 1;

		while (row < n && col >= 0) {
			if (mat[row][col] == x) {
				return true;
			} else if (mat[row][col] < x)
				row++;
			else
				col--;
		}
		return false;
	}
}

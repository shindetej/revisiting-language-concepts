package com.tejas.day041;

import java.util.Arrays;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] mat = { { 1, -1, 1 }, { -1, 0, 1 }, { 1, -1, 1 } };

		setMatrixZeroes(mat);

		for (int[] m : mat) {
			System.out.println(Arrays.toString(m));
		}
	}

	private static void setMatrixZeroes(int[][] mat) {
		int rowSize = mat.length;
		int colSize = mat[0].length;

		int flagCol = 1;

		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				if (mat[i][j] == 0) {
					// mark ith row 0
					mat[i][0] = 0;
					// mark column 0
					if (j == 0)
						flagCol = 0;
					else
						mat[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < rowSize; i++) {
			for (int j = 1; j < colSize; j++) {
				if (mat[i][0] == 0 || mat[0][j] == 0) {
					mat[i][j] = 0;
				}
			}
		}

		// corner case for 1st row
		if (mat[0][0] == 0) {
			for (int j = 0; j < colSize; j++) {
				mat[0][j] = 0;
			}
		}

		// case for 1st column
		if (flagCol == 0) {
			System.out.println("1st col zero");
			for (int i = 0; i < rowSize; i++) {
				mat[i][0] = 0;
			}
		}
	}

}

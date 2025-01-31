package com.tejas.day078;

public class sudokuBacktrackingCode {
	public static void main(String[] args) {
		int[][] mat = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		solveSudoku(mat);

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	static void solveSudoku(int[][] mat) {
		solveSudokuRec(mat, 0, 0);
	}

	static boolean solveSudokuRec(int[][] mat, int row, int col) {
		if (row == 8 && col == 9) {
			return true;
		}

		if (col == 9) {
			row++;
			col = 0;
		}

		if (mat[row][col] != 0) {
			return solveSudokuRec(mat, row, col + 1);
		}

		for (int i = 0; i <= 9; i++) {
			if (isSafe(mat, row, col, i)) {
				mat[row][col] = i;
				if (solveSudokuRec(mat, row, col + 1))
					return true;

				mat[row][col] = 0;

			}
		}

		return false;
	}

	static boolean isSafe(int[][] mat, int row, int col, int num) {
		// check if exist in row
		for (int x = 0; x < 9; x++) {
			if (mat[row][x] == num) {
				return false;
			}
		}
		// check if exist in col
		for (int x = 0; x < 9; x++) {
			if (mat[x][col] == num) {
				return false;
			}
		}

		int startRow = row - (row % 3);
		int startCol = col - (col % 3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (mat[i + startRow][j + startCol] == num)
					return false;
			}
		}
		return true;
	}
}

package com.tejas.day034;

import java.util.ArrayList;
import java.util.List;

public class SphericalMatrixTraverse {
	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		List<Integer> res = spirallyTraverse(mat);
		for (int ele : res) {
			System.out.print(ele + " ");
		}
	}

	public static ArrayList<Integer> spirallyTraverse(int mat[][]) {
		ArrayList<Integer> result = new ArrayList<>();
		int m = mat[0].length; // columns
		int n = mat.length; // rows

		int top = 0, left = 0;
		int bottom = n - 1, right = m - 1;

		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; ++i) {
				result.add(mat[top][i]);
			}
			top++;

			for (int i = top; i <= bottom; ++i) {
				result.add(mat[i][right]);
			}

			right--;

			if (top <= bottom) {
				for (int i = right; i >= left; --i) {
					result.add(mat[bottom][i]);
				}
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; --i) {
					result.add(mat[i][left]);
				}
				left++;
			}

		}
		return result;
	}
}

package com.tejas.day040;

public class SearchInSortedMatrix {
	public static void main(String[] args) {
		int[][] arr = { { 1, 5, 9 }, { 14, 20, 21 }, { 30, 34, 43 } };
		int x = 34;

		System.out.println("is found : " + searchInSortedMatrix(arr, x));
	}

	private static boolean searchInSortedMatrix(int[][] mat, int x) {
		int rowSize = mat.length;
		int colSize = mat[0].length;

		int lo = 0, hi = rowSize * colSize - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (mat[mid / colSize][mid % colSize] == x) {
				System.out.println("value fount at index mat["+mid/colSize+"]["+mid%colSize+"]");
				return true;
			} else if (mat[mid / colSize][mid % colSize] < x) {
				System.out.println("value less than mat["+mid/colSize+"]["+mid%colSize+"]");
				lo = mid + 1;
			} else {
				System.out.println("value greater than at mat["+mid/colSize+"]["+mid%colSize+"]");
				hi = mid - 1;
			}
		}
		return false;
	}
}

package com.tejas.day10;

public class MaxProductSubArray {
	public static void main(String[] args) {
		int[] arr = { -1, -3, -10, 0, 6 };
		System.out.println(maxProduct(arr));
	}

	private static int maxProduct(int[] arr) {
		int maxProduct = arr[0], minProduct = arr[0], finalProduct = arr[0];
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			if (arr[i] == 0) {
				maxProduct = 0;
				minProduct = 0;
			}
			if (arr[i] < 0) {
				
				// swap min and max product result
				int temp = maxProduct;
				maxProduct = minProduct;
				minProduct = temp;
			}

			maxProduct = Math.max(arr[i], maxProduct * arr[i]);
			minProduct = Math.min(arr[i], minProduct * arr[i]);
			finalProduct = Math.max(finalProduct, maxProduct);
			
		
		}

		return finalProduct;
	}
}

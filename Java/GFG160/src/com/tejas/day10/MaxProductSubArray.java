package com.tejas.day10;

public class MaxProductSubArray {
	public static void main(String[] args) {
		int[] arr = { 2,3,-2,4 };
		System.out.println(maxProduct(arr));
		System.out.println(maxProductBetter(arr));
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
	private static int maxProductBetter(int[] arr) {
		int maxProduct = arr[0], minProduct = arr[0], finalProduct = arr[0];
		int n = arr.length;
		int maxProd = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int product = 1;
			for (int j = i; j < n; j++) {
				product *= arr[j];
				maxProd = Math.max(product, maxProd);
			}
//			System.out.println("max sum after "+ i+"th iteration :"+maxSum );

		}
		return maxProd;
	}
}

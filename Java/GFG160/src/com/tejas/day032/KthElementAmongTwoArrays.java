package com.tejas.day032;

public class KthElementAmongTwoArrays {

	public static void main(String[] args) {
		int[] a = { 2, 3, 6, 7, 9};
		int[] b = {1, 4, 8, 10 };
		int k = 5;
		System.out.println(kthElement(a, b,k));
	}

	public static int kthElement(int a[], int b[], int k) {
		int n = a.length;
		int m = b.length;

		if (n > m) {
			return kthElement(b, a, k);
		}

		// set lo and hi
		int lo = Math.max(0, k - m);
		int hi = Math.min(k, n);

		while (lo <= hi) {
			int mid1 = (lo + hi) / 2;
			int mid2 = k - mid1;

			int l1 = Integer.MIN_VALUE;
			int l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE;
			int r2 = Integer.MAX_VALUE;

			if (mid1 != 0) {
				l1 = a[mid1 - 1];
			}
			if (mid1 != n) {
				r1 = a[mid1];
			}
			if (mid2 != 0) {
				l2 = b[mid2 - 1];
			}
			if (mid2 != m) {
				r2 = b[mid2];
			}

			if (l1 <= r2 && l2 <= r1) {
				return Math.max(l1, l2);
			}

			if (l1 > r2)
				hi = mid1 - 1;
			else
				lo = mid1 + 1;
		}
		return 0;
	}
}

package com.tejas.day051;

public class FindTripletsTwoptr {

	public static void main(String[] args) {
		int[] arr = { -3, -1, -1, 0, 1, 2 };
		int target = -2;

		System.out.println("triplets count "+countTriplets(arr, target));
	}

	public static int countTriplets(int[] arr, int target) {
		// Code Here
		int n = arr.length;
		int result = 0;
		for (int i = 0; i < n; i++) {
			int l = i + 1;
			int h = n - 1;

			while (l < h) {
				int sum = arr[i] + arr[l] + arr[h];

				if (sum < target) {
					l += 1;
				} else if (sum > target) {
					h -= 1;
				} else if (sum == target) {
					int e1 = arr[l];
					int e2 = arr[h];
					int cnt1 = 0;
					int cnt2 = 0;
					while (l <= h && arr[l] == e1) {
						l++;
						cnt1++;
					}
					while (l <= h && arr[h] == e2) {
						h--;
						cnt2++;
					}

					if (e1 == e2) {
						result += (cnt1 * (cnt1 - 1)) / 2;

					} else {
						result += (cnt1 * cnt2);
					}

				}
			}
		}
		return result;
	}
}

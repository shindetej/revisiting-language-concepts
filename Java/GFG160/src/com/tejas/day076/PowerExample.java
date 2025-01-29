package com.tejas.day076;

public class PowerExample {
	public static void main(String[] args) {
		System.out.println(power(3.00, 5));
	}

	static double power(double b, int e) {
		if (e == 0)
			return 1;
		if (e < 0)
			return 1 / power(b, -e);

		double ans = power(b, (e / 2));
		if (e % 2 == 0) {
			return ans * ans;
		} else {
			return b * ans * ans;
		}
	}
}

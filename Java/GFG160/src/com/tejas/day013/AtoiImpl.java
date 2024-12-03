package com.tejas.day013;

public class AtoiImpl {

	public static void main(String[] args) {
		System.out.println(myAtoi("42")); // Output: 42
		System.out.println(myAtoi("   -42")); // Output: -42
		System.out.println(myAtoi("4193 with words")); // Output: 4193
		System.out.println(myAtoi("words and 987")); // Output: 0
		System.out.println(myAtoi("-91283472332")); // Output: -2147483648 (Integer.MIN_VALUE)
		System.out.println(myAtoi("91283472332"));
	}

	/*
	 * Cases for atoi() conversion: Skip any leading whitespaces. Check for a sign
	 * (‘+’ or ‘-‘), default to positive if no sign is present. Read the integer by
	 * ignoring leading zeros until a non-digit character is encountered or end of
	 * the string is reached. If no digits are present, return 0. If the integer is
	 * greater than 231 – 1, then return 231 – 1 and if the integer is smaller than
	 * -231, then return -231.
	 */
	public static int myAtoi(String s) {
		// variable declarations
		int i = 0, n = s.length();

		// Removing whitespaces if any
		while (i < n && s.charAt(i) == ' ') {
			i++;
		}

		if (i == n)
			return 0;

		// Sign handling
		int sign = 1;
		if (s.charAt(i) == '-' || s.charAt(i) == '+') {
			sign = (s.charAt(i) == '-') ? -1 : 1;
			i++;
		}

		Long num = 0L;

		while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			num = num * 10 + (s.charAt(i) - '0');
			// check for overflow condition
			if (sign * num > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign * num < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;

			i++;
		}

		return (int) (sign * num);

	}
}

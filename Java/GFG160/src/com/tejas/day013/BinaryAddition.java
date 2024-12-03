package com.tejas.day013;

public class BinaryAddition {

	public static void main(String[] args) {
		String s1 = "00000011";
		String s2 = "10010";

		System.out.println("Addition of s1 and s2 binary : " + addBinary(s1, s2));
		System.out.println("251 binary: " + convertToBinary("117"));
		System.out.println("251 binary: " +binaryToDecimal("1111"));
	}

	public static String addBinary(String s1, String s2) {
		// Step 1: Determine the maximum length of the two input binary strings
		int maxLen = Math.max(s1.length(), s2.length());

		// Step 2: Convert input strings to StringBuilder for easier manipulation
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);

		// Step 3: Initialize carry to 0 (used for binary addition)
		int carry = 0;

		// Step 4: Pad the shorter binary string with leading zeros
		// Ensures both strings are of equal length for bit-by-bit addition
		while (sb1.length() < maxLen) {
			sb1.insert(0, '0');
		}
		while (sb2.length() < maxLen) {
			sb2.insert(0, '0');
		}

		// Step 5: Initialize a StringBuilder to store the binary addition result
		StringBuilder result = new StringBuilder();

		// Step 6: Start from the least significant bit (rightmost) and traverse
		// backward
		int i = sb1.length() - 1;
		int j = sb2.length() - 1;

		// Step 7: Perform binary addition bit by bit, considering the carry
		while (i >= 0 || j >= 0 || carry != 0) {
			int sum = carry; // Include carry from the previous step

			// Add the bit from the first binary string (if within bounds)
			if (i >= 0) {
				sum += sb1.charAt(i) - '0';
				i--; // Move to the next significant bit
			}

			// Add the bit from the second binary string (if within bounds)
			if (j >= 0) {
				sum += sb2.charAt(j) - '0';
				j--; // Move to the next significant bit
			}

			// Append the least significant bit of the sum to the result
			result.append(sum % 2);

			// Update carry for the next step (most significant bit of the sum)
			carry = sum / 2;
		}

		// Step 8: Reverse the result since bits were added from least to most
		// significant
		result = result.reverse();

		// Step 9: Remove leading zeros from the result
		int index = 0;
		while (index < result.length() && result.charAt(index) == '0') {
			index++; // Skip all leading zeroes
		}

		// Handle the case where the result is all zeros (e.g., "0000")
		String resultWithoutLeadingZeros = index == result.length() ? "0" : result.substring(index);

		// Step 10: Return the final result without leading zeros
		return resultWithoutLeadingZeros;

	}
	
	public static String convertToBinary(String s) {
		StringBuilder result = new StringBuilder();
		int num = Integer.parseInt(s);
		if(num == 0) {
			result.append(0);
		}
		
		while(num != 0 ) {
			// divide by 2
			result.append(num%2);
			num = num/2;	
		}
		return result.reverse().toString();
	}
	
//	public static int binaryToDecimal(String s) {
//		int result = 0;
//		
//		int power=0;
//		for(int i = s.length()-1;i >-1;i--) {
//			result+=Math.pow(2, power++)*(s.charAt(i) - '0');
//		}
//		return result;
//	}
	
	public static int binaryToDecimal(String s) {
	    int result = 0;

	    for (int i = 0; i < s.length(); i++) {
	    	
	    	System.out.println(result + "* 2 +"+ s.charAt(i));
	        result = result * 2 + (s.charAt(i) - '0');
	    }
	    return result;
	}

}

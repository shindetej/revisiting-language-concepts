package com.tejas.day18;

import java.util.Arrays;

public class MinCharForPalindrome {
	
	public static void main(String[] args) {
		String s = "abc";
		System.out.println(minChar(s));
		System.out.println(minChar("iver"));
		System.out.println(minChar("aabac"));
	}
	public static int minChar(String s) {
		int cnt = 0;
		int len = s.length();
		char[] charArray =  s.toCharArray();
		// REVERSE S
		for (int i = 0, j =len - 1; i < j; i++, j--) {
		    char temp = charArray[i];
		    charArray[i] = charArray[j];
		    charArray[j] = temp;
		}
		
		// lps array for string + # + reversed string
		String hashString = s+"#"+new String(charArray);

		int[] lps = getLPS(hashString);
		
		// length of string - last index value of lps array
		cnt = s.length() - lps[lps.length-1];
		return cnt;
	}
	
	public static int[] getLPS(String pat) {
	    int m = pat.length();
	    int[] lps = new int[m];
	    int length = 0; // Length of the previous longest prefix-suffix
	    int i = 1; // Start from the second character

	    while (i < m) {
	        if (pat.charAt(i) == pat.charAt(length)) {
	            length++;
	            lps[i] = length;
	            i++;
	        } else {
	            if (length != 0) {
	                // Fall back to the previous prefix length
	                length = lps[length - 1];
	            } else {
	                // No match
	                lps[i] = 0;
	                i++;
	            }
	        }
	    }
	    return lps;
	}
}

package com.tejas.day20;

import java.util.Arrays;

public class StringRotations {
	public static void main(String[] args) {
		String s1 = "aab";
		String s2 = "aba";
		System.out.println(" result by brut : " + areRotationsBrut(s1, s2));
		System.out.println(" result by KMP : " + areRotationsWithKMPAlgo(s1, s2));
	}

	public static boolean areRotationsBrut(String s1, String s2) {
		return (s1 + s1).contains(s2);
	}

	public static boolean areRotationsWithKMPAlgo(String s1, String s2) {
		String txt = s1 + s1;
		String pat = s2;

		int m = pat.length();
		int n = txt.length();

		int[] lps = getLPS(pat);
		System.out.println(Arrays.toString(lps));
		int i = 0;
		int j = 0;

		while (i < n) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}

			if (j == m) {
				return true;
			} else if (i < n && pat.charAt(j) != txt.charAt(i)) {
				
				// mismatch after j matches
				if (j != 0) {
					
					j = lps[j - 1];
				} else
					i = i + 1;

			}
		}
		return false;
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

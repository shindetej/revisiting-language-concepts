package com.tejas.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// KMP Algorithm
public class PatternMatching {

	public static void main(String[] args) {
		String pat = "aaba";
		String txt = "aabaacaadaabaaba";

		List<Integer> resultList = search(pat, txt);
		
		System.out.println(resultList);
	}

	private static List<Integer> search(String pat, String txt) {
		int plen = pat.length();
		int tlen = txt.length();

		List<Integer> resultList = new ArrayList<>();

		int[] lpsArray = getLPS(pat);
		System.out.println(Arrays.toString(lpsArray));

		int i = 0; // txt index
		int j = 0; // pattern index

		while (i < tlen) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}

			if (j == plen) {
				System.out.println(j); 
				resultList.add(i - j);
				j = lpsArray[j - 1];
			} else if (i < tlen && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = lpsArray[j-1];
				} else {
					i++;
				}
			}
		}
		return resultList;
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

package com.tejas.day111;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestWordChainDP {
	public static int longestStrChain(String[] words) {
		Arrays.sort(words, Comparator.comparingInt(String::length)); // Step 1: Sort by length

		Map<String, Integer> dp = new HashMap<>(); // Stores the longest chain ending at each word
		int maxLength = 1;

		for (String word : words) {
			int bestChain = 1; // Minimum chain length is 1 (word itself)

			// Generate all possible predecessors
			for (int i = 0; i < word.length(); i++) {
				String prevWord = word.substring(0, i) + word.substring(i + 1); // Remove one character
				bestChain = Math.max(bestChain, dp.getOrDefault(prevWord, 0) + 1);
			}

			dp.put(word, bestChain); // Store the best chain length for this word
			maxLength = Math.max(maxLength, bestChain); // Update global max length
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String[] words = { "ba", "b", "a", "bca", "bda", "bdca" };
		System.out.println(longestStrChain(words)); // Output: 4
	}
}

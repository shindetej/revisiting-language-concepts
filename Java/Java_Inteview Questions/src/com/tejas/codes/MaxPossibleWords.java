package com.tejas.codes;

import java.util.HashMap;
import java.util.Map;

public class MaxPossibleWords {

	public static void main(String[] args) {
		String s = "ballall";

		System.out.println(getCount(s, "ball"));
	}

	private static int getCount(String sample, String word) {

		// stack of s
		Map<Character, Integer> sampleMap = new HashMap<>();
		for (Character c : sample.toCharArray()) {
			sampleMap.put(c, sampleMap.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> wordMap = new HashMap<>();
		for (Character c1 : word.toCharArray()) {
			wordMap.put(c1, wordMap.getOrDefault(c1, 0) + 1);
		}

		System.out.println(sampleMap);
		System.out.println(wordMap);

		int count = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
			if (!sampleMap.containsKey(entry.getKey()))
				return 0;

			int quotient = sampleMap.get(entry.getKey()) / entry.getValue();
			System.out.println("sampleMap has " + entry.getKey() + "  : " + sampleMap.get(entry.getKey()) + " times");
			System.out.println("word has count for same character :  " + entry.getValue());
			count = Math.min(count, quotient);
			System.out.println("count " + count);
		}
		return count;
	}
}

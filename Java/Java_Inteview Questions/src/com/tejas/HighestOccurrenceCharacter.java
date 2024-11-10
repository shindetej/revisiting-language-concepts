package com.tejas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestOccurrenceCharacter {
	public static void main(String[] args) {
		String input = "mississipi"; // Example input
		char result = findHighestOccurrenceCharacter(input);
		System.out.println("The highest occurrence character is: " + result);

	

	}

	
	
	// USING putIfAbsent + merge

	public static char findHighestOccurrenceCharacterWithMergeMethod(String str) {
		HashMap<Character, Integer> charCountMap = new HashMap<>();

		// Count occurrences of each character using putIfAbsent and merge
		for (char ch : str.toCharArray()) {
			charCountMap.putIfAbsent(ch, 0); // Initialize count to 0 if not present
			charCountMap.merge(ch, 1, Integer::sum); // Increment count by 1
		}

		char maxChar = str.charAt(0);
		int maxCount = 0;

		// Find the character with the highest occurrence
		for (HashMap.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxChar = entry.getKey();
			}
		}

		return maxChar;
	}

	public static char findHighestOccurrenceCharacter(String str) {
		HashMap<Character, Integer> charCountMap = new HashMap<>();

		// Count occurrences of each character using putIfAbsent and merge
		for (char ch : str.toCharArray()) {
			charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
		}

		char maxChar = str.charAt(0);
		int maxCount = 0;

		// Find the character with the highest occurrence
		for (HashMap.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			System.out.println("Char : " + entry.getKey() + ", Count : " + entry.getValue());
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxChar = entry.getKey();
			}
		}

		return maxChar;
	}
}
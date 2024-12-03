package com.tejas.codes;

import java.util.HashMap;
import java.util.Map;

public class MaxPossibleWords {

	public static void main(String[] args) {
		String s = "nallodsbllolllbabannarlballnaonbblaollabbann";

		System.out.println(getCount(s, "balloon"));
		System.out.println("----------- BRUTE APPROACH ---------");
		System.out.println(getCountBrute(s));
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
			System.out.println(  entry.getKey() + " cnt : " + sampleMap.get(entry.getKey()));
//			System.out.println("need multiple of  " + entry.getValue());
			count = Math.min(count, quotient);
		}
		return count;
	}

	private static int getCountBrute(String sample) {
		String s = "balloon";
		int b_cnt = 0;
		int a_cnt = 0;
		int l_cnt = 0;
		int o_cnt = 0;
		int n_cnt = 0;

		for (int i = 0; i < sample.length(); i++) {
			if (sample.charAt(i) == 'b') {
				b_cnt++;
			}
			if (sample.charAt(i) == 'a') {
				a_cnt++;
			}
			if (sample.charAt(i) == 'l') {
				l_cnt++;
			}
			if (sample.charAt(i) == 'o') {
				o_cnt++;
			}
			if (sample.charAt(i) == 'n') {
				n_cnt++;
			}
		}

		System.out.println("b_cnt : " + b_cnt);
		System.out.println("a_cnt : " + a_cnt);
		System.out.println("l_cnt : " + l_cnt);
		System.out.println("o_cnt : " + o_cnt);
		System.out.println("n_cnt : " + n_cnt);

		int min = 0;
		if (b_cnt <= a_cnt && b_cnt <= (l_cnt / 2) && b_cnt <= (o_cnt / 2) && b_cnt <= n_cnt) {
			min = b_cnt;
		} else if (a_cnt <= (l_cnt / 2) && a_cnt <= (o_cnt / 2) && a_cnt <= n_cnt) {
			min = a_cnt;
		} 
		else if ( (l_cnt/2) <= (o_cnt / 2) && (l_cnt/2) <= n_cnt){
			min = l_cnt/2;
		}
		else if (  (o_cnt/2) <= n_cnt){
			min = o_cnt/2;
		}else {
			min = n_cnt;
		}

		return min;
	}
}

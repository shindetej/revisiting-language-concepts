package com.tejas.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * You are given an array of integer arr[] where each number represents a vote to a candidate. 
 * Return the candidates that have votes greater than one-third of the total votes, 
 * If there's not a majority vote, return an empty array. 
 * */
public class MajorityElement {
	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arr = { 2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6 };

		System.out.println(findMajority(arr));
	}

	public static List<Integer> findMajority(int[] nums) {

			int oneThirdVoteShare = nums.length / 3;
			Map<Integer,Integer> map =  new HashMap<>();
			List<Integer> result =  new ArrayList<>();
			for(int i :  nums)
			{
				map.put(i, map.getOrDefault(i, 0)+1);
			}
			
			for(Map.Entry<Integer, Integer> e : map.entrySet()) {
				if(e.getValue() > oneThirdVoteShare) {
					result.add(e.getKey());
				}
			}
	
			return result;
	}
	public static List<Integer> findMajorityWithJ8(int[] nums) {
		
		int oneThirdVoteShare = nums.length / 3;
		List<Integer> result = Arrays.stream(nums).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(n -> (n.getValue() > oneThirdVoteShare)).map(n -> n.getValue()).collect(Collectors.toList())
				.stream().map(Long::intValue).collect(Collectors.toList());
		
		return result;
	}

}

package com.tejas.day16;

import java.util.Map;
import java.util.*;

public class NonRepeatCharacter {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(" Non Repeating Character : "+ nonRepeatingChar(s));
		System.out.println(" Non Repeating Character Using character array: "+ nonRepeatingUsingArrayChar(s));
	}

	private static char nonRepeatingChar(String s) {
		// USE OF LINKEDHASHMAP PRESERVES ORDER OF INSERTION HENCE USE TO GET 1st NON REPEATING CHARACTER
		Map<Character,Integer> map =  new LinkedHashMap<>();
		
		for(Character c :  s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for(Map.Entry<Character,Integer> e :  map.entrySet()) {
			if(e.getValue() == 1)
				return e.getKey();
		}
		return '$';
	}
	
	
	private static char nonRepeatingUsingArrayChar(String s) {
		// TODO Auto-generated method stub
		char[] charArray =  new char[256]; //ASCII
		
		for(Character c :  s.toCharArray()) {
			charArray[c]++;
		}
		
		// THIS WILL NOT WORK AS WE NEED 1st Non Repeating Character in String
		// HENCE ITERATE OVER STRING 
//		for(int i = 0;i<charArray.length;i++) { 
//			if(charArray[i] == 1)
//				return (char) i;
//		}
		for(Character c : s.toCharArray())
		{
			if(charArray[c] == 1)
				return c;
		}
		return '$';
	}
	
	
	
}

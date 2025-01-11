package com.tejas.day058;

import java.util.HashSet;

public class LongestSubstringCount {
	
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println("count "+ longestUniqueSubstr(s));
	} 
	static public int longestUniqueSubstr(String s) {
	        HashSet<Character> set =  new HashSet<>();
	        
	        int start = 0;
	        int maxLength = 0;
	        
	        for(int end = 0 ; end<s.length();end++){
	            char c = s.charAt(end);
	            
	            while(set.contains(c)){
	                set.remove(s.charAt(start));
	                start++;
	            }
	            
	            set.add(c);
	            maxLength = Math.max(maxLength,end-start+1);
	        }
	        
	        return maxLength;
	    }
}

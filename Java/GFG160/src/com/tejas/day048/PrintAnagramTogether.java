package com.tejas.day048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintAnagramTogether {
	public static void main(String[] args) {
		String[] arr = { "listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art" };

		System.out.println(anagrams(arr));

	}

	public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
		// create linked hashmap
		 // create map 
	       Map<String ,ArrayList<String>> map = new HashMap<>();
	       
	       // create list
	       ArrayList<ArrayList<String>> resultList =  new ArrayList<>();
	       
	       for(String s: arr)
	       {
	           char[] carr= s.toCharArray();
	           Arrays.sort(carr);
	           String nstr= new String(carr);
	           // if given sorted string absent create new list
	           map.putIfAbsent(nstr,new ArrayList<String>());
	           // add string to list of strings
	           map.get(nstr).add(s);
	       }
	       
	      for(ArrayList<String> ls : map.values()){
	          resultList.add(ls);
	      } 
	       
	      resultList.sort((a,b)->(a.toString().compareTo(b.toString())));
	      return resultList;
	}
}

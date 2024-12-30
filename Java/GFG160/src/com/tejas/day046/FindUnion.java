package com.tejas.day046;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindUnion {
	public static void main(String[] args) {
		int[] a = {1, 2, 1, 1, 2 }, b = { 2,2,1,2,2};

		System.out.println(findUnion(a, b));
	}

	public static int findUnion(int[] a, int[] b) {
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			set.add(i);
		}
		for (int j : b) {
			set.add(j);
		}
	
		return set.size();
	}
}

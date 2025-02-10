package com.tejas.day088;

import java.util.HashMap;

import com.tejas.day080.Node;

public class SumKPath {

	public static void main(String[] args) {

		Node root = new Node(8);
		root.left = new Node(4);
		root.right = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(2);
		root.right.right = new Node(2);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(-2);
		root.left.right.right = new Node(1);

		int k = 7;
		System.out.println("Sum "+k+" found in total paths : "+sumK(root, k));
	}

	static int countPaths(Node node, int k, int sum, HashMap<Integer, Integer> prefSums) {
		if (node == null)
			return 0;

		int pathCount = 0;
		sum += node.data;
		if (sum == k)
			pathCount++;

		pathCount += prefSums.getOrDefault(sum - k, 0);

		prefSums.put(sum, prefSums.getOrDefault(sum, 0) + 1);

		pathCount += countPaths(node.left, k, sum, prefSums);
		pathCount += countPaths(node.right, k, sum, prefSums);

		prefSums.put(sum, prefSums.get(sum) - 1);
		return pathCount;

	}

	public static int sumK(Node root, int k) {
		HashMap<Integer, Integer> prefSums = new HashMap<>();
		return countPaths(root, k, 0, prefSums);
	}
}

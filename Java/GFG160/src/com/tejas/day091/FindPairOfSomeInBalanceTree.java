package com.tejas.day091;

import java.util.ArrayList;

import com.tejas.day080.Node;

public class FindPairOfSomeInBalanceTree {
	public static void main(String[] args) {

		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		int k = 5;

		System.out.println(findTarget(root, 37));
	}

	static void inorderTraverse(Node root, ArrayList<Integer> inorder) {
		if (root == null) {
			return;
		}

		inorderTraverse(root.left, inorder);
		inorder.add(root.data);

		inorderTraverse(root.right, inorder);
	}

	static boolean findTarget(Node root, int target) {
		// Write your code here
		ArrayList<Integer> inorder = new ArrayList<>();
		inorderTraverse(root, inorder);

		int left = 0;
		int right = inorder.size() - 1;

		while (left < right) {
			int sum = inorder.get(left) + inorder.get(right);
			if (sum == target) {
				return true;
			}

			if (sum < target)
				left++;

			else
				right--;
		}
		return false;
	}
}

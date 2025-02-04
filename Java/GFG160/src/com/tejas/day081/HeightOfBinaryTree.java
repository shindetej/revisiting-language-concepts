package com.tejas.day081;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.tejas.day080.Node;
import com.tejas.day080.TreeTraversal;

public class HeightOfBinaryTree {
	Node root;

	public HeightOfBinaryTree(int data) {
		this.root = new Node(data);
	}

	public static void main(String[] args) {
		HeightOfBinaryTree tt = new HeightOfBinaryTree(25);
		tt.add(10);
		tt.add(20);
		tt.add(40);
		tt.add(5);
		tt.add(15);

		int height = tt.height(tt.root);
		System.out.println(height);
		
		// DAY 82 activity
		System.out.println(tt.diameter(tt.root));
	}

	private void add(int data) {
		Node newNode = new Node(data);

		Node trav = this.root;
		Node parent = null;
		while (trav != null) {
			parent = trav;
			if (trav.data <= data) {
				trav = trav.left;
			} else if (trav.data > data) {
				trav = trav.right;
			}
		}

		if (parent.data < data) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}

	}

	int height(Node node) {
		// if node null return 0
		if (node == null) {
			return 0;
		}

		// queue for nodes
		Queue<Node> q = new LinkedList<>();

		q.add(node);
		int depth = 0;
		while (!q.isEmpty()) {
			int levelSize = q.size();
			for (int i = 0; i < levelSize; i++) {
				Node leaf = q.poll();
				if (leaf.left != null)
					q.add(leaf.left);
				if (leaf.right != null)
					q.add(leaf.right);
			}

			depth++;
		}

		return depth - 1;
	}
	
	static int recursiveDia(Node node,int[] result){
        if(node == null)
            return 0;
        
        int leftHeight = recursiveDia(node.left,result);
        int rightHeight= recursiveDia(node.right,result);
        
        result[0]=Math.max(result[0],leftHeight+rightHeight);
        
        return 1+ Math.max(leftHeight,rightHeight);
    }
    
    
    int diameter(Node root) {
        int[] result =  new int[1];
        
        recursiveDia(root,result);
        return result[0];
    }
}

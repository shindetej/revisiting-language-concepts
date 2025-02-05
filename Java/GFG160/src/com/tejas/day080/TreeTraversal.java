package com.tejas.day080;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.tejas.day080.Node;

public class TreeTraversal {
	Node root;
	public TreeTraversal(int data) {
		this.root = new Node(data);
	}

	public static void main(String[] args) {
		TreeTraversal tt = new TreeTraversal(25);
		tt.add(10);
		tt.add(20);
		tt.add(40);
		tt.add(5);
		tt.add(15);
		
		ArrayList<ArrayList<Integer>> numList  = tt.levelOrder(tt.root);
		System.out.println(numList);
		tt.mirror(tt.root);
		numList  = tt.levelOrder(tt.root);
		System.out.println(numList);
	}

	private void add(int data) {
		Node newNode = new Node(data);
		
		Node trav = this.root;
		Node parent = null;
		while(trav != null) {
			parent = trav;
			if(trav.data  <= data) {
				trav = trav.left;
			}else if(trav.data > data ) {
				trav= trav.right;
			}
		}
		
		if(parent.data < data) {
			parent.left = newNode;
		}else {
			parent.right = newNode;
		}
		
	}

	public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
		if (root == null) {
			return new ArrayList<>();
		}

		Queue<Node> q = new LinkedList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		q.add(root);
		int currentLevel = 0;
		while (!q.isEmpty()) {
			int len = q.size();
			result.add(new ArrayList<>());

			for (int i = 0; i < len; i++) {
				Node node = q.poll();
				result.get(currentLevel).add(node.data);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			currentLevel++;
		}
		return result;
	}
	
	void mirror(Node node) {
        if(node == null){
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            Node temp = current.right;
            current.right = current.left;
            current.left = temp;
            
            
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }
}

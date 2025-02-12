package com.tejas.day090;

import com.tejas.day080.Node;

public class KthSmallElement {
	 public static void main(String[] args) {

	        Node root = new Node(20);
	        root.left = new Node(8);
	        root.right = new Node(22);
	        root.left.left = new Node(4);
	        root.left.right = new Node(12);
	        root.left.right.left = new Node(10);
	        root.left.right.right = new Node(14);
	        int k = 5;

	        System.out.println(kthSmallest(root, k));
	    }
	
	// Return the Kth smallest element in the given BST
    public static void inorder(Node node,int k,int[] count,int[] result){
        if(node == null){
            return ;
        }
        
        inorder(node.left,k,count,result);
        
        count[0]++;
        if(count[0] ==k){
            result[0]=node.data;
            return;
        }
        
        inorder(node.right,k,count,result);
    }
    
    public static int kthSmallest(Node root, int k) {
        int[] result = new int[]{-1};
         inorder(root,k,new int[]{0},result);
         return result[0];
    }
}

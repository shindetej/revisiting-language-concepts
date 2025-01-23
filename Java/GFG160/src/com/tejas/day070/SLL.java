package com.tejas.day070;

public class SLL {
	Node head;

	public SLL(int data) {
		this.head = new Node(data);
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public Node addLast(int data) {
		Node newNode = new Node(data);
		
		Node trav = this.head;
		while(trav.next!=null) {
			trav = trav.next;
		}
		
		trav.next = newNode;
		
		return newNode;
	}
	
	
	
//	public void setRandomToHeadNode(Node node) {
//		this.head.random = node;
//	}
	
}

package com.tejas.day068;

public class SLL {
	Node head;

	public SLL(int data) {
		this.head = new Node(data);
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public void addLast(int data) {
		Node newNode = new Node(data);
		
		Node trav = this.head;
		while(trav.next!=null) {
			trav = trav.next;
		}
		
		trav.next = newNode;
	}
	
	
	
}

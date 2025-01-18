package com.tejas.day065;

public class ReverseLinkedList {
	
	public static void main(String[] args) {
		SLL list =  new SLL(10);
		
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(100);

		
		System.out.println("CREATED LINKED LIST");

		show(list.getHead());
		
		System.out.println("\n\nREVERSE LINKED LIST");
		show(reverseLinkedList(list.getHead()));
	}

	public static Node reverseLinkedList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node prev =  null;
		Node run =  head;
		
		while(run!= null)
		{
			Node runNext =  run.next;
			run.next = prev;
			prev = run;
			run = runNext;
		}
		return prev;
	}
	
	public static  void show(Node head) {
		if(head  ==  null) {
			System.out.println("Invalid List Show ");
		}
		
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + "-> ");
			trav = trav.next;
		}
	}
}




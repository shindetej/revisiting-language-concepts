package com.tejas.day066;

import com.tejas.day066.SLL;

public class RotateList {
	
	public static void main(String[] args) {
		SLL list =  new SLL(10);
		
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);

		
		System.out.println("CREATED LINKED LIST");

		show(list.getHead());
		
		System.out.println("\n\nREVERSE LINKED LIST");
		show(rotate(list.getHead(),4));
	}

	 public static Node rotate(Node head, int k) {
	        if(k == 0 || head == null){
	            return null;
	        }
	        
	        Node trav = head;
	        int len = 1;
	        while(trav.next != null){
	            len+=1;
	            trav = trav.next;
	        }
	        
	        k = k%len;
	        if(k==0){
	            return head;            
	        }
	        
	        // make last node in linked list as head to make it circular
	        trav.next = head;
	        
	        // set new traversal as run
	        Node run = head;
	        
	        for(int i = 1; i < k;i++){
	            run = run.next;
	        }
	        
	        head = run.next;
	        
	        run.next = null;
	        return head;

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




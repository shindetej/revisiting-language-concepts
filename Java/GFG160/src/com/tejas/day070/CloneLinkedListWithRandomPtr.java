package com.tejas.day070;

import com.tejas.day070.Node;
import com.tejas.day070.SLL;

public class CloneLinkedListWithRandomPtr {
	
	
	public static void main(String[] args) {
		SLL list = new SLL(10);
		
		Node ret20 = list.addLast(20);
		Node ret30 =   list.addLast(30);
		Node ret40 = list.addLast(40);
		Node ret34 = list.addLast(34);
		
		
		
		setRandomToNodes(list.getHead(), ret34);
		setRandomToNodes(ret20, ret40);
		setRandomToNodes(ret40, ret34);
		setRandomToNodes(ret30, ret40);
		setRandomToNodes(ret34, null);
		
		System.out.println("------- GET ORIGINAL LINKED LIST ---------- HASHCODE : "+ list.getHead().hashCode());
		show(list.getHead());
		
		Node clonedListNode  = cloneLinkedList(list.getHead());
		
		System.out.println("\n\n----------GET COPIED LINKED LIST ----------- HASHCODE : "+ clonedListNode.hashCode());
		show(clonedListNode);
	}
	
	// UTILITY FUNCTION NOT USED IN CODE
	public static void setRandomToNodes(Node orginalNode,Node random) {
		orginalNode.random = random;
	}
	
	static void insertCopyInBetween(Node head){
	    Node temp = head;
	    
	    // create linkedlist with copynodes in between original node
	    while(temp !=null){
	        Node nextElement = temp.next;
	        // create new copy node
	        Node copy = new Node(temp.data);
	        // connect with all ends
	        copy.next = nextElement;
	        temp.next = copy;
	        // go to next original node
	        temp = nextElement;
	    }
	    
	}

	static void connectRandomPointersInCopyList(Node head){
	    Node temp = head;
	    
	    while(temp != null){
	        Node copyNode = temp.next;
	        if(temp.random != null){
	            copyNode.random = temp.random.next;
	        }else{
	            copyNode.random = null;
	        }
	        
	        temp = temp.next.next;
	    }
	}

	static Node getCopiedListSeperately(Node head){
	    Node temp = head;
	    Node dummyNode = new Node(-1);
	    Node result = dummyNode;
	    
	    while(temp != null){
	        result.next =  temp.next;
	        result = result.next;
	        
	        // disconnect and goto original LL
	        temp.next = temp.next.next;
	        temp = temp.next;
	    }
	    return dummyNode.next;
	}


	public static Node cloneLinkedList(Node head) {
	   insertCopyInBetween(head);
	   connectRandomPointersInCopyList(head);
	   
	   return getCopiedListSeperately(head);
	   
	}
	
	public static void show(Node head) {
		if (head == null) {
			System.out.println("Invalid List Show ");
		}

		Node trav = head;
		while (trav != null) {
			if(trav.random != null)
				System.out.print("["+trav.data + " " +trav.random.data+ "] -> ");
			else 
				System.out.print("["+trav.data +  " NULL ] -> ");
			trav = trav.next;
		}
	}
}

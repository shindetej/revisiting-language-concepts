package com.tejas.day073;

import com.tejas.day072.Node;
import com.tejas.day072.SLL;

public class RemoveCycle {

	public static void main(String[] args) {
		SLL list = new SLL(10);

		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(70);
		list.addLast(80);
		list.addLast(340);
		Node lastNode = list.addLast(41);

		Node cycleNode = list.addCycle(list.getHead(), 3);

		if (cycleNode != null && cycleNode != list.getHead())
			lastNode.next = cycleNode;

		System.out.println("CREATED LINKED LIST");

		System.out.println("\n\n Is Cycle Detected In LinkedList : "+detectLoop(list.getHead()));
		removeLoop(list.getHead());
		System.out.println("\n\n Is Cycle Detected In LinkedList After removeLoop() : "+detectLoop(list.getHead()));
	}
	

	// Function to check if the linked list has a loop.
	public static boolean detectLoop(Node head) {
		Node fast = head;
		Node slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}

		return false;
	}
	
	public static void removeLoop(Node head) {
        Node fast = head ,slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) break;
        }
        
        if(fast == null || fast.next == null) return ;
        
        slow =  head;
        while(slow!=fast){
            slow=slow.next;
            fast= fast.next;
        }
        while(fast.next != slow){
            fast = fast.next;
        }
        fast.next = null;
    }
}

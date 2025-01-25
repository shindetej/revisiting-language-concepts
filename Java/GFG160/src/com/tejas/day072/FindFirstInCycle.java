package com.tejas.day072;

public class FindFirstInCycle {

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

		System.out.println("\n\n 1st Element Where Cycle Start Is Node With Data : "+findFirstNode(list.getHead()).data);

	}

	public static Node findFirstNode(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

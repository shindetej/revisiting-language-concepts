package com.tejas.day071;

public class FindCycle {

	public static void main(String[] args) {
		SLL list = new SLL(10);

		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(340);
		Node lastNode = list.addLast(41);

		Node cycleNode = list.addCycle(list.getHead(), 1);

		if (cycleNode != null && cycleNode != list.getHead())
			lastNode.next = cycleNode;

		System.out.println("CREATED LINKED LIST");

		System.out.println("\n\n Is Cycle Detected In LinkedList : "+detectLoop(list.getHead()));

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
}

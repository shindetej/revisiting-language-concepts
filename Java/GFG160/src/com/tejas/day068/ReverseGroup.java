package com.tejas.day068;

public class ReverseGroup {

	public static void main(String[] args) {
		SLL list = new SLL(10);

		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(340);
		list.addLast(41);
		list.addLast(45);
		list.addLast(100);

		System.out.println("CREATED LINKED LIST");

		show(list.getHead());

		System.out.println("\n\nREVERSE LINKED LIST");
		show(reverseKGroup(list.getHead(), 4));
	}

	public static Node reverseKGroup(Node head, int k) {
		if (head == null)
			return head;

		Node current = head;
		Node newHead = null;
		Node tail = null;

		while (current != null) {
			Node groupHead = current;
			Node prev = null;
			Node nextNode = null;
			int count = 0;
			while (current != null && count < k) {
				nextNode = current.next;
				current.next = prev;
				prev = current;
				current = nextNode;
				count++;
			}

			// connect head to 1st reversed group to get new head
			if (newHead == null) {
				newHead = prev;
			}

			if (tail != null) {
				tail.next = prev;
			}

			tail = groupHead;
		}
		return newHead;
	}

	public static void show(Node head) {
		if (head == null) {
			System.out.println("Invalid List Show ");
		}

		Node trav = head;
		while (trav != null) {
			System.out.print(trav.data + "-> ");
			trav = trav.next;
		}
	}
}

package com.tejas.day067;

import com.tejas.day067.SLL;

public class MergeSortedLists {

	public static void main(String[] args) {

		SLL list = new SLL(10);

		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);

		System.out.println("CREATED SORTED LINKED LIST 1");
		show(list.getHead());
		SLL list2 = new SLL(14);
		list2.addLast(21);
		list2.addLast(28);
		list2.addLast(29);
		list2.addLast(57);
		
		System.out.println("\n\nCREATED SORTED LINKED LIST 2");
		show(list2.getHead());

		System.out.println("\n\nMERGED SORTED LINKED LIST");
		show(sortedMerge(list.getHead(), list2.getHead()));

	}

	public static Node sortedMerge(Node head1, Node head2) {
		// Create new Node
		Node resultList = new Node(-1);
		Node run = resultList;

		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				run.next = head1;
				head1 = head1.next;
			} else {
				run.next = head2;
				head2 = head2.next;
			}

			run = run.next;
		}

		// if head 1 still has element and head2 all element added
		if (head1 != null) {
			run.next = head1;
		} else {
			// head 2 all element added back to sorted list
			run.next = head2;
		}

		return resultList.next;
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

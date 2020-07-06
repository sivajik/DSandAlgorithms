package com.gfg.ds.single.linkedlist;

public class Prob07_SearchInList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);

		list.head.next = second;
		list.head.next.next = third;
		list.head.next.next.next = fourth;
		list.head.next.next.next.next = fifth;
		list.head.next.next.next.next.next = sixth;

		list.printList();

		System.out.println("Search Status : " + list.searchItr(4));
		System.out.println("Search Status : " + list.searchRec(4));

		System.out.println("Search Status : " + list.searchItr(44));
		System.out.println("Search Status : " + list.searchRec(44));
	}

	static class LinkedList {
		Node head;

		public void printList() {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + ", ");
				temp = temp.next;
			}
			System.out.println("\n");
		}

		public boolean searchItr(int val) {
			Node temp = head;

			while (temp != null) {
				if (temp.data == val) {
					return true;
				}
				temp = temp.next;
			}
			return false;
		}

		public boolean searchRec(int val) {
			return searchRec(head, val);
		}

		private boolean searchRec(Node head2, int val) {
			if (head2 == null) {
				return false;
			}
			if (head2.data == val) {
				return true;
			} else {
				return searchRec(head2.next, val);
			}
		}
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
}
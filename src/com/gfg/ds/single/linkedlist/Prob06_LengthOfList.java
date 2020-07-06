package com.gfg.ds.single.linkedlist;

public class Prob06_LengthOfList {

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

		System.out.println("Length : " + list.lengthItr());
		System.out.println("Length : " + list.lengthRec());
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

		public int lengthItr() {
			Node temp = head;
			int count = 0;
			while (temp != null) {
				count++;
				temp = temp.next;
			}
			return count;
		}
		
		public int lengthRec() {
			return lengthRec(head);
		}

		private int lengthRec(Node head2) {
			if (head2 == null) {
				return 0;
			}
			return 1 + lengthRec(head2.next);
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
package com.gfg.ds.single.linkedlist;

public class Prob05_DeletionNodeByNode {

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

		list.deleteNodeByNode();
		list.printList();

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

		public void deleteNodeByNode() {
			Node temp = head;

			while (temp != null) {
				System.out.println("Deleting: " + temp.data);
				head = head.next;
				temp = head;
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

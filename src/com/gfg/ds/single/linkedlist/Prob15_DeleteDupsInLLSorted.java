package com.gfg.ds.single.linkedlist;

public class Prob15_DeleteDupsInLLSorted {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(1);
		Node third = new Node(3);
		Node fourth = new Node(3);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node seventh = new Node(6);

		list.head.next = second;
		list.head.next.next = third;
		list.head.next.next.next = fourth;
		list.head.next.next.next.next = fifth;
		list.head.next.next.next.next.next = sixth;
		list.head.next.next.next.next.next.next = seventh;

		list.printList();
		list.deleteDups();
		list.printList();
	}// 1 2 3 4 5 6 '7' -> '6' -> '5' -> '4' -> '3'

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

		public void deleteDups() {
			Node temp = head;
			while (temp != null && temp.next != null) {
				if (temp.data == temp.next.data) {
					temp.next = temp.next.next;
				} else {
					temp = temp.next;
				}
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
package com.gfg.ds.single.linkedlist;

public class Prob19_PairwiseSwapNodesInLL {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node seventh = new Node(7);

		list.head.next = second;
		list.head.next.next = third;
		list.head.next.next.next = fourth;
		list.head.next.next.next.next = fifth;
		list.head.next.next.next.next.next = sixth;
		list.head.next.next.next.next.next.next = seventh;

		list.printList();
		Node newHead = list.pairWiseSwap();
		list.printList(newHead);
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

		public void printList(Node newHead) {
			Node temp = newHead;
			while (temp != null) {
				System.out.print(temp.data + ", ");
				temp = temp.next;
			}
			System.out.println("\n");
		}

		public Node pairWiseSwap() {
			Node dummy = new Node(-999);
			dummy.next = head;

			Node curr = dummy;

			while (curr.next != null && curr.next.next != null) {
				Node first = curr.next;
				Node secod = curr.next.next;
				Node remain = secod.next;

				curr.next = secod;
				secod.next = first;
				first.next = remain;

				curr = curr.next.next;
			}
			return dummy.next;
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
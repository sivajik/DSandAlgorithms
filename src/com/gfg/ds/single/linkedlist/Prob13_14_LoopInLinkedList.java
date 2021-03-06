package com.gfg.ds.single.linkedlist;

public class Prob13_14_LoopInLinkedList {

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
		list.head.next.next.next.next.next.next.next = third;

		list.lenOfLoop();
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

		public void lenOfLoop() {
			Node slowPtr = head;
			Node fastPtr = head;

			boolean found = false;
			while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;

				if (slowPtr == fastPtr) {
					System.out.println("Loop Found");
					found = true;
					break;
				}
			}

			if (found) {
				int len = 0;
				Node temp = head;
				while (temp != slowPtr) {
					temp = temp.next;
					len++;
				}
				System.out.println("lenght of loop = " + len);
			} else {
				System.out.println("lenght of loop = " + 0);
			}

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
package com.gfg.ds.single.linkedlist;

public class Prob18_SwapNodesInLL {

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
		// list.swapNodes(1,7);
		list.swapNodes(3, 6);
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

		public void swapNodes(int x, int y) {
			Node currX = head, currY = head;
			Node prevX = null, prevY = null;

			while (currX != null && currX.data != x) {
				prevX = currX;
				currX = currX.next;
			}

			while (currY != null && currY.data != y) {
				prevY = currY;
				currY = currY.next;
			}

			if (currX == null || currY == null) {
				return;
			}

			if (prevX != null) {
				prevX.next = currY;
			} else { // prevX null means, x is head, now make y as head.
				head = currY;
			}

			if (prevY != null) {
				prevY.next = currX;
			} else {
				head = currX;
			}

			Node temp = currX.next;
			currX.next = currY.next;
			currY.next = temp;
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
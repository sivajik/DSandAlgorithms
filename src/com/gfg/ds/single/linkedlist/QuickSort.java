package com.gfg.ds.single.linkedlist;

public class QuickSort {
	Node partition(Node low, Node high) {
		int pivot = high.val;
		Node i = low.prev;

		for (Node j = low; j != null && j != high; j = j.next) {
			if (j != null && j.val < pivot) {
				i = (i == null) ? low : i.next;

				int temp = j.val;
				j.val = i.val;
				i.val = temp;
			}
		}

		i = (i == null) ? low : i.next;

		int temp = i.val;
		i.val = pivot;
		high.val = temp;
		return i;
	}

	void sort(Node head, Node last) {
		if (head != last && last != null && head != last.next) {
			Node partNode = partition(head, last);
			sort(head, partNode.prev);
			sort(partNode.next, last);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		Node n0 = new Node(10);
		Node n1 = new Node(7);
		Node n2 = new Node(8);
		Node n3 = new Node(9);
		Node n4 = new Node(1);
		Node n5 = new Node(5);

		link(n0, n1);
		link(n1, n2);
		link(n2, n3);
		link(n3, n4);
		link(n4, n5);

		printArray(n0);

		QuickSort ob = new QuickSort();
		ob.sort(n0, last(n0));

		System.out.println("sorted array");
		printArray(n0);
	}

	private static Node last(Node n0) {
		Node temp = n0;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	private static void link(Node n4, Node n5) {
		n4.next = n5;
		n5.prev = n4;
	}

	static class Node {
		int val;
		Node next;
		Node prev;

		Node(int val) {
			this.val = val;
		}
	}
}
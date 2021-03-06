package com.crackingthetcodingtinterviews.chapter02;

public class Prob_02_03 {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(18);
		l.add(92);
		l.add(13);
		l.add(64);
		l.add(55);
		l.add(46);
		l.add(37);
		l.add(28);
		l.add(19);

		l.print();
		deleteGivenNode(l.head, 3);
		l.print();
	}

	static void deleteGivenNode(LinkedListNode head, int k) {
		LinkedListNode temp = head;
		for (int i = 0; i < k-1; i++) {
			temp = temp.next;
		}
		// temp is the one to be deleted
		LinkedListNode nextNode = temp.next;
		temp.val = nextNode.val;
		temp.next = nextNode.next;
	}

	static class LinkedList {
		LinkedListNode head;

		public void add(int data) {
			LinkedListNode newNode = new LinkedListNode(data);
			if (head == null) {
				head = newNode;
			} else {
				LinkedListNode temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = newNode;
			}
		}

		public void print() {
			LinkedListNode temp = head;
			while (temp != null) {
				System.out.print(temp.val + "  ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	static class LinkedListNode {
		int val;
		LinkedListNode next;

		LinkedListNode(int x) {
			val = x;
		}
	}
}

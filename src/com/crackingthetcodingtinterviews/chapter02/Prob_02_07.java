package com.crackingthetcodingtinterviews.chapter02;

public class Prob_02_07 {

	public static void main(String[] args) {
		LinkedListNode n7 = new LinkedListNode(7);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n1 = new LinkedListNode(1);

		LinkedList l = new LinkedList();
		l.head = new LinkedListNode(3);
		l.head.next = new LinkedListNode(1);
		l.head.next.next = new LinkedListNode(5);
		l.head.next.next.next = new LinkedListNode(9);
		l.head.next.next.next.next = n7;
		l.head.next.next.next.next.next = n2;
		l.head.next.next.next.next.next.next = n1;

		LinkedList m = new LinkedList();
		m.head = new LinkedListNode(4);
		m.head.next = new LinkedListNode(4);
		m.head.next.next = n7;
		m.head.next.next.next = n2;
		m.head.next.next.next.next = n1;

		l.print();
		m.print();
		System.out.println("-----------");
		System.out.println(findintersection(l.head, m.head).val);

	}

	static LinkedListNode findintersection(LinkedListNode list1, LinkedListNode list2) {
		int len1 = getLen(list1);
		int len2 = getLen(list2);

		LinkedListNode bigger = null, smaller = null;

		if (len1 > len2) {
			bigger = list1;
			smaller = list2;
		} else {
			bigger = list2;
			smaller = list1;
		}

		int diff = Math.abs(len1 - len2);

		for (int i = 0; i < diff; i++) {
			bigger = bigger.next;
		}

		while (bigger != smaller && bigger != null && smaller != null) {
			bigger = bigger.next;
			smaller = smaller.next;
		}

		return bigger;
	}

	private static int getLen(LinkedListNode list1) {
		LinkedListNode temp = list1;
		int c = 0;
		while (temp != null) {
			c++;
			temp = temp.next;
		}
		return c;
	}

	static LinkedList addlists(LinkedListNode a, LinkedListNode b) {
		int carry = 0;

		LinkedList result = new LinkedList();
		;
		while (a != null && b != null) {
			int sum = (a.val + b.val + carry);

			int nodeVal = sum % 10;
			carry = sum / 10;
			result.add(nodeVal);
			a = a.next;
			b = b.next;
		}

		if (a == null && b != null) {
			int sum = (0 + b.val + carry);
			int nodeVal = sum % 10;
			carry = sum / 10;
			result.add(nodeVal);
			b = b.next;
		} else if (a != null && b == null) {
			int sum = (a.val + 0 + carry);
			int nodeVal = sum % 10;
			carry = sum / 10;
			result.add(nodeVal);
			a = a.next;
		}

		if (carry > 0) {
			result.add(carry);
		}
		return result;
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
			next = null;
		}
	}
}

package com.crackingthetcodingtinterviews.chapter02;

public class Prob_02_08 {

	public static void main(String[] args) {
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n11 = new LinkedListNode(1);
		LinkedListNode n5 = new LinkedListNode(5);
		LinkedListNode n9 = new LinkedListNode(9);

		LinkedListNode n7 = new LinkedListNode(7);


		LinkedList l = new LinkedList();
		l.head = n3;
		l.head.next = n11;
		l.head.next.next = n5;
		l.head.next.next.next = n9;
		l.head.next.next.next.next = n7;
		n7.next = n5;

		// l.print();
		
		System.out.println(loopStartNode(l.head).val);

	}

	static LinkedListNode loopStartNode(LinkedListNode list1) {
		LinkedListNode slow = list1;
		LinkedListNode fast = list1;

		while (true) { //we surely assume there is a loop
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		slow = list1;

		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
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

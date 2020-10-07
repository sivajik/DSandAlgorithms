package com.crackingthetcodingtinterviews.chapter02;

public class Prob_02_05 {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(7);
		l.add(1);
		l.add(6);

		LinkedList m = new LinkedList();
		m.add(5);
		m.add(9);
		m.add(2);
		m.add(2);
		
		l.print();
		m.print();
		System.out.println("-----------");
		LinkedList res = addlists(l.head, m.head);
		res.print();
	}

	static LinkedList reverse(LinkedList list) {
		LinkedListNode prev = null;
		LinkedListNode curr = list.head;

		while (curr != null) {
			LinkedListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		list.head = prev;
		return list;
	}

	static LinkedList addlists(LinkedListNode a, LinkedListNode b) {
		int carry = 0;

		LinkedList result = new LinkedList();;
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
		}
	}
}

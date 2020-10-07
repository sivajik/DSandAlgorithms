package com.crackingthetcodingtinterviews.chapter02;

import java.util.Stack;

public class Prob_02_06 {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(2);
			l.add(11);
		l.add(0);

		l.print();
		System.out.println(isPalindrome(l.head));
	}

	static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		Stack<LinkedListNode> stack = new Stack();

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			stack.push(slow);
			slow = slow.next;
		}

		if (fast != null) {
			// odd elements are ther.
			slow = slow.next;
		}

		while (slow != null) {
			LinkedListNode topElem = stack.pop();
			if (topElem.val != slow.val) {
				return false;
			}
			slow = slow.next;
		}

		return true;
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

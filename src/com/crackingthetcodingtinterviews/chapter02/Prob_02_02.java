package com.crackingthetcodingtinterviews.chapter02;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prob_02_02 {

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
		System.out.println(printKthToLast(l.head, 3));
		System.out.println(printKthToLast(l.head, 9));
		System.out.println(printKthToLast(l.head, 6));
	}

	static int printKthToLast(LinkedListNode head, int k) {
		Stack<LinkedListNode> s = new Stack<LinkedListNode>();
		LinkedListNode temp = head;
		while (temp != null) {
			s.push(temp);
			temp = temp.next;
		}
		
		int cntr = 0;
		LinkedListNode res = null;
		while (cntr != k) {
			res = s.pop();
			cntr++;
		}
		return res.val;
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

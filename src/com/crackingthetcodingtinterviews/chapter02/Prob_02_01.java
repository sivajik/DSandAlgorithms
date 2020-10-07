package com.crackingthetcodingtinterviews.chapter02;

import java.util.HashMap;
import java.util.Map;

public class Prob_02_01 {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(2);
		l.add(5);
		l.add(4);
		l.add(6);
		l.add(7);
		l.add(6);

		l.print();
		deleteDups(l.head);
		l.print();
	}

	static void deleteDups(LinkedListNode n) {
		LinkedListNode temp = n;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(temp.val, 1);

		while (temp.next != null) {
			if (map.containsKey(temp.next.val)) {
				temp.next = temp.next.next;
			} else {
				map.put(temp.next.val, 1);
				temp = temp.next;
			}
		}
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

package com.gfg.ds.single.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Prob17_DeleteDupsInLLUnSorted {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(3);
		Node third = new Node(5);
		Node fourth = new Node(1);
		Node fifth = new Node(5);
		Node sixth = new Node(3);
		Node seventh = new Node(6);

		list.head.next = second;
		list.head.next.next = third;
		list.head.next.next.next = fourth;
		list.head.next.next.next.next = fifth;
		list.head.next.next.next.next.next = sixth;
		list.head.next.next.next.next.next.next = seventh;

		list.printList();
		list.deleteDups();
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

		public void deleteDups() {
			Node curr = head;
			Node prev = null;
			Set<Integer> set = new HashSet<>();
			
			while (curr != null) {
				if (set.contains(curr.data)) {
					prev.next = curr.next;
				} else {
					set.add(curr.data);
					prev = curr;
				}
				curr = curr.next;
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
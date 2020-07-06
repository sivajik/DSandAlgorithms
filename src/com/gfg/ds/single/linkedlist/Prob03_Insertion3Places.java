package com.gfg.ds.single.linkedlist;

public class Prob03_Insertion3Places {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		list.head.next = second;
		list.head.next.next = third;
		list.printList();

		list.push(999);
		list.printList();

		list.insertAfter(second, 22);
		list.printList();
		
		list.append(33);
		list.printList();
	}

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

		public void push(int new_data) {
			Node temp = new Node(new_data);

			temp.next = head;
			head = temp;
		}

		public void insertAfter(Node prev_node, int new_data) {
			Node temp = new Node(new_data);

			temp.next = prev_node.next;
			prev_node.next = temp;
		}

		public void append(int new_data) {
			if (head == null) {
				head = new Node(new_data);
				return;
			}

			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}

			temp.next = new Node(new_data);
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

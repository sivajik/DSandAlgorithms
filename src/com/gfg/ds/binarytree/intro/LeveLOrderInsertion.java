package com.gfg.ds.binarytree.intro;

import java.util.LinkedList;
import java.util.Queue;

public class LeveLOrderInsertion {

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);

		tree.root.left = new Node(11);
		tree.root.right = new Node(9);

		tree.root.left.left = new Node(7);
		tree.root.left.right = null;

		tree.root.right.left = new Node(15);
		tree.root.right.right = new Node(8);

		tree.inOrder(tree.root);
		System.out.println();

		tree.insert(tree.root, 12);

		tree.inOrder(tree.root);
		System.out.println();
	}

	static class BinaryTree {
		Node root;

		public void inOrder(Node n1) {
			if (n1 != null) {
				inOrder(n1.left);
				System.out.print(n1.value + " ");
				inOrder(n1.right);
			}
		}

		public void insert(Node n1, int val) {
			Queue<Node> q = new LinkedList<>();
			q.add(n1);

			while (!q.isEmpty()) {
				Node temp = q.poll();

				if (temp.left == null) {
					Node n = new Node(val);
					temp.left = n;
					break;
				} else {
					q.add(temp.left);
				}

				if (temp.right == null) {
					Node n = new Node(val);
					temp.right = n;
					break;
				} else {
					q.add(temp.right);
				}
			}
		}
	}

	// ====
	static class Node {
		int value;
		Node left;
		Node right;

		public Node() {
		}

		public Node(int val) {
			this.value = val;
			this.left = null;
			this.right = null;
		}

	}
}

package com.gfg.ds.binarytree.intro;

import java.util.LinkedList;
import java.util.Queue;

public class AreMirrorImageItr {

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(3);

		tree.inOrder(tree.root);
		System.out.println();

		boolean output = tree.isSymmetric(tree.root);
		if (output == true)
			System.out.println("Symmetric");
		else
			System.out.println("Non Symmetric");
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

		public boolean isSymmetric(Node n1) {
			Queue<Node> q = new LinkedList<>();
			q.add(n1.left);
			q.add(n1.right);

			while (!q.isEmpty()) {
				Node l = q.poll();
				Node r = q.poll();

				if (l == null && r == null) {
					continue;
				}

				if ((l != null && r == null) || (l == null && r != null)) {
					return false;
				}

				if (l.value != r.value) {
					return false;
				}

				q.add(l.left);
				q.add(r.right);
				q.add(l.right);
				q.add(r.left);
			}

			return true;
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

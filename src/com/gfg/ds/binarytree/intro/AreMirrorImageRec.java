package com.gfg.ds.binarytree.intro;

public class AreMirrorImageRec {

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
			return isSymmetric(n1, n1);
		}

		private boolean isSymmetric(Node n1, Node n2) {
			if (n1 == null && n2 == null) {
				return true;
			}

			if (n1 != null && n2 != null && n1.value == n2.value) {
				return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
			}
			return false;
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

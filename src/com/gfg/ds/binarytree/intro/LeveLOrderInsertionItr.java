package com.gfg.ds.binarytree.intro;

public class LeveLOrderInsertionItr {

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

		tree.root = tree.insert(tree.root, 12);

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

		public Node insert(Node n1, int val) {
			if (n1 == null) {
				return new Node(val);
			}
			if (n1.left != null && n1.right != null) {
				insert(n1.left, val);
				insert(n1.right, val);
			}

			if (n1.left == null && n1.right != null) {
				n1.left = insert(n1.left, val);
			}
			if (n1.right == null && n1.left != null) {
				n1.right = insert(n1.right, val);
			}

			return n1;
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

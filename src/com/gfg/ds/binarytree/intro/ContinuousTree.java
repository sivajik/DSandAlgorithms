package com.gfg.ds.binarytree.intro;

public class ContinuousTree {

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(3);

		tree.root.left = new Node(2);
		tree.root.right = new Node(4);

		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		tree.root.right.left = null;
		tree.root.right.right = new Node(5);

		tree.inOrder(tree.root);
		System.out.println();

		System.out.println(tree.isContinuous(tree.root));

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

		public boolean isContinuous(Node n1) {
			if (n1 == null) {
				return true;
			}
			if (n1.left == null && n1.right == null) {
				return true;
			}
			if (n1.left == null && n1.right != null) {
				return Math.abs(n1.value - n1.right.value) == 1 && isContinuous(n1.right);
			}
			if (n1.left != null && n1.right == null) {
				return Math.abs(n1.value - n1.left.value) == 1 && isContinuous(n1.left);
			}
			return Math.abs(n1.value - n1.right.value) == 1 && isContinuous(n1.right)
					&& Math.abs(n1.value - n1.left.value) == 1 && isContinuous(n1.left);
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

package com.karumanchirev.chap06;

import java.util.LinkedList;
import java.util.Queue;

public class Prob20_DiameterBinaryTree {

	public static void main(String[] args) {

		BinaryTreeNode n1 = null;
		for (int i = 1; i <= 15; i++) {
			n1 = insert(n1, i);

		}
		System.out.println(n1.diameter(n1));
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		public int diameter(BinaryTreeNode a) {
			// Max ( Max(diamter(a.left), diameter(a.right)), 1 + height(a.left) +
			// height(a.right)
			if (a == null) {
				return 0;
			}

			int lHeight = height(a.left);
			int rHeight = height(a.right);

			int dLeft = diameter(a.left);
			int dRight = diameter(a.right);

			return Math.max(Math.max(dLeft, dRight), 1 + lHeight + rHeight);
		}

		public int height(BinaryTreeNode a) {
			if (a == null) {
				return 0;
			}
			return 1 + Math.max(height(a.left), height(a.right));
		}

		BinaryTreeNode(int x) {
			this.value = x;
			this.left = null;
			this.right = null;
		}

		public String toString() {
			return value + "";
		}
	}

	static public BinaryTreeNode insert(BinaryTreeNode root, int data) {
		if (root == null) {
			return new BinaryTreeNode(data);
		}

		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				if (tmp.left == null) {
					tmp.left = new BinaryTreeNode(data);
					return root;
				} else {
					q.add(tmp.left);
				}

				if (tmp.right == null) {
					tmp.right = new BinaryTreeNode(data);
					return root;
				} else {
					q.add(tmp.right);
				}
			}
		}
		return root;
	}
}

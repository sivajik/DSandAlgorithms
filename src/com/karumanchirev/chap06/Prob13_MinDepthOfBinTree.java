package com.karumanchirev.chap06;

import java.util.LinkedList;
import java.util.Queue;

public class Prob13_MinDepthOfBinTree {

	public static void main(String[] args) {

		BinaryTreeNode n1 = null;
		for (int i = 1; i <= 15; i++) {
			n1 = insert(n1, i);

		}
		System.out.println(n1.minDepth(n1));
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		public int minDepth(BinaryTreeNode root) {
			Queue<BinaryTreeNode> q = new LinkedList<>();
			q.add(root);
			q.add(null);

			int depth = 1;
			while (!q.isEmpty()) {
				BinaryTreeNode tmp = q.poll();
				if (tmp != null) {
					if (tmp.left == null && tmp.right == null) {
						return depth;
					}

					if (tmp.left != null) {
						q.add(tmp.left);
					}
					if (tmp.right != null) {
						q.add(tmp.right);
					}
				} else {
					if (!q.isEmpty()) {
						q.add(null);
						depth++;// just found a null so it's a level.
					}
				}
			}
			return depth;
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

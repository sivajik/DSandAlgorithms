package com.karumanchirev.chap06;

import java.util.LinkedList;
import java.util.Queue;

public class Prob05_InsertElemInBinTree {

	public static void main(String[] args) {

		BinaryTreeNode n1 = null;
		for (int i = 1; i <= 7; i++) {
			n1 = insert(n1, i);

		}
		n1.inOrder(n1);
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

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		public void inOrder(BinaryTreeNode root) {
			if (root != null) {
				inOrder(root.left);
				System.out.print(root.value + " ");
				inOrder(root.right);
			}
		}

		public boolean searchElementItr(BinaryTreeNode root, int data) {
			Queue<BinaryTreeNode> q = new LinkedList<>();
			q.add(root);

			while (!q.isEmpty()) {
				BinaryTreeNode tmp = q.poll();
				if (tmp != null) {
					if (tmp.value == data) {
						return true;
					}
					if (tmp.left != null) {
						q.add(tmp.left);
					}
					if (tmp.right != null) {
						q.add(tmp.right);
					}
				}
			}
			return false;
		}

		BinaryTreeNode(int x) {
			this.value = x;
			this.left = null;
			this.right = null;
		}
	}
}

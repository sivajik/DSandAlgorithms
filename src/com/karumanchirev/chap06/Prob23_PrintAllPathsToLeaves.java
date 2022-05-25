package com.karumanchirev.chap06;

import java.util.LinkedList;
import java.util.Queue;

public class Prob23_PrintAllPathsToLeaves {

	public static void main(String[] args) {

		BinaryTreeNode n1 = null;
		for (int i = 1; i <= 15; i++) {
			n1 = insert(n1, i);

		}
		n1.print(n1);
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		public void print(BinaryTreeNode root) {
			int[] path = new int[256];
			printPaths(root, path, 0);
		}

		public void printPaths(BinaryTreeNode root, int[] path, int len) {
			if (root == null) {
				return;
			}
			path[len++] = root.value;

			if (root.left == null && root.right == null) {
				printMe(path, len);
			} else {
				printPaths(root.left, path, len);
				printPaths(root.right, path, len);
			}
		}

		private void printMe(int[] path, int len) {
			for (int i = 0; i < len; i++) {
				System.out.print(path[i] + " ");
			}
			System.out.println();
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

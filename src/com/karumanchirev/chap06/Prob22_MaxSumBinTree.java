package com.karumanchirev.chap06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob22_MaxSumBinTree {

	public static void main(String[] args) {

		BinaryTreeNode n1 = null;
		for (int i = 1; i <= 15; i++) {
			n1 = insert(n1, i);

		}
		System.out.println(n1.maxSumAtLevel(n1));
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		public int maxSumAtLevel(BinaryTreeNode root) {
			Queue<BinaryTreeNode> q = new LinkedList<>();

			q.add(root);
			q.add(null);

			List<BinaryTreeNode> l = new ArrayList<>();
			int max = Integer.MIN_VALUE;
			int sum = 0;
			while (!q.isEmpty()) {
				BinaryTreeNode tmp = q.poll();
				if (tmp != null) {
					l.add(tmp);

					if (tmp.left != null) {
						q.add(tmp.left);
					}
					if (tmp.right != null) {
						q.add(tmp.right);
					}
				} else {
					List<BinaryTreeNode> ll = new ArrayList<>(l);
					sum = 0;
					for (BinaryTreeNode i : ll) {
						sum += i.value;
					}

					if (sum > max) {
						max = sum;
					}
					l.clear();
					if (!q.isEmpty()) {
						q.add(null);
					}
				}
			}
			return max;
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

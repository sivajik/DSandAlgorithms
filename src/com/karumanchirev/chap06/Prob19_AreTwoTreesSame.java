package com.karumanchirev.chap06;

import java.util.LinkedList;
import java.util.Queue;

public class Prob19_AreTwoTreesSame {

	public static void main(String[] args) {

		BinaryTreeNode n1 = null;
		for (int i = 1; i <= 17; i++) {
			n1 = insert(n1, i);

		}
		System.out.println(n1.areSymmetrical(n1, n1));
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		public boolean areSymmetrical(BinaryTreeNode a, BinaryTreeNode b) {
			if (a == null && b == null) {
				return true;
			}
			if ((a == null && b != null) || (a != null && b == null)) {
				return false;
			}
			return areSymmetrical(a.left, b.right) && areSymmetrical(a.right, b.left);
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

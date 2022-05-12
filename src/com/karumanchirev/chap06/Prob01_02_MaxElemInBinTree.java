package com.karumanchirev.chap06;

import java.util.LinkedList;

public class Prob01_02_MaxElemInBinTree {

	public static void main(String[] args) {

		BinaryTreeNode n1 = new BinaryTreeNode(1);

		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);

		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		int max = n1.maxElement(n1);
		int maxi = n1.maxElementIterative(n1);
		System.out.println(max);
		System.out.println(maxi);
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		public int maxElement(BinaryTreeNode root) {
			if (root != null) {
				int lMax = maxElement(root.left);
				int rMax = maxElement(root.right);
				return Math.max(root.value, Math.max(lMax, rMax));
			}
			return -1;
		}

		public int maxElementIterative(BinaryTreeNode root) {
			java.util.Queue<BinaryTreeNode> q = new LinkedList<>();
			q.add(root);
			int max = Integer.MIN_VALUE;

			while (!q.isEmpty()) {
				BinaryTreeNode tmp = q.poll();
				if (tmp != null) {
					if (tmp.value > max) {
						max = tmp.value;
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
	}
}

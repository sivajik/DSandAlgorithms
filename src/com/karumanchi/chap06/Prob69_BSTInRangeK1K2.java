package com.karumanchi.chap06;

public class Prob69_BSTInRangeK1K2 {

	public static void main(String[] args) {
		BinarySearchNode n1 = new BinarySearchNode(7);

		BinarySearchNode n2 = new BinarySearchNode(4);
		BinarySearchNode n3 = new BinarySearchNode(9);

		BinarySearchNode n4 = new BinarySearchNode(2);
		BinarySearchNode n5 = new BinarySearchNode(5);
		BinarySearchNode n6 = new BinarySearchNode(8);
		BinarySearchNode n7 = new BinarySearchNode(10);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		inOrder(n1);
		System.out.println();

		printInRange(n1, 2, 7);
	}

	private static void printInRange(BinarySearchNode root, int k1, int k2) {
		if (root == null) {
			return;
		}
		if (root.value >= k1) {
			printInRange(root.left, k1, k2);
		}
		if (root.value >= k1 && root.value <= k2) {
			System.out.print(root.value + " ");
		}
		if (root.value <= k2) {
			printInRange(root.right, k1, k2);
		}

	}

	public static void inOrder(BinarySearchNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
		}
	}

	static class BinarySearchNode {
		int value;
		BinarySearchNode left;
		BinarySearchNode right;

		BinarySearchNode(int x) {
			this.value = x;
			this.left = null;
			this.right = null;
		}
	}
}

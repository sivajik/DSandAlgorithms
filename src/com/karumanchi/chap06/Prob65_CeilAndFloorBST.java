package com.karumanchi.chap06;

public class Prob65_CeilAndFloorBST {

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

		System.out.println(floor(n1, 3));
		System.out.println(ceil(n1, 3));
	}

	private static int ceil(BinarySearchNode root, int i) {
		if (root == null) {
			return -1;
		}
		if (root.value == i) {
			return i;
		}
		if (i > root.value) {
			return ceil(root.right, i);
		}
		int left = ceil(root.left, i);
		if (left > i) {
			return left;
		} else {
			return root.value;
		}
	}

	private static int floor(BinarySearchNode root, int i) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		if (root.value == i) {
			return i;
		}
		if (i < root.value) { // 7 4 9
			return floor(root.left, i);
		}
		int right = floor(root.right, i);
		if (right < i) {
			return right;
		} else {
			return root.value;
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

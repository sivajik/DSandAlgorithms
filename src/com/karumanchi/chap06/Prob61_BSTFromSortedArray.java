package com.karumanchi.chap06;

public class Prob61_BSTFromSortedArray {

	public static void main(String[] args) {
		BinarySearchNode root = prepare(new int[] { 2, 4, 5, 7, 8, 9, 10 });
		inOrder(root);
	}

	private static BinarySearchNode prepare(int[] is) {
		return prepareBST(is, 0, is.length - 1);
	}

	private static BinarySearchNode prepareBST(int[] is, int left, int right) {
		if (left > right) {
			return null;
		} else {
			int mid = left + (right - left) / 2;
			BinarySearchNode root = new BinarySearchNode(is[mid]);
			root.left = prepareBST(is, left, mid - 1);
			root.right = prepareBST(is, mid + 1, right);
			return root;
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

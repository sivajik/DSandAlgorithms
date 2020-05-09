package com.karumanchi.chap06;

public class Prob57_IsBinaryTreeBST {

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

		System.out.println(isBST(n1));
	}

	public static boolean isBST(BinarySearchNode root) {
		return isBSTMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTMinMax(BinarySearchNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		return root.value > minValue && root.value < maxValue && isBSTMinMax(root.left, minValue, root.value)
				&& isBSTMinMax(root.right, root.value, maxValue);
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

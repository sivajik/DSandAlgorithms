package com.karumanchi.chap06;

public class BinarySearchOperations {

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

		System.out.println("Search 5 -> " + find(n1, 5).value);
		System.out.println("Search 5 -> " + findItr(n1, 5).value);
		System.out.println();
		System.out.println("Search min -> " + findMin(n1).value);
		System.out.println("Search min -> " + findMinItr(n1).value);
		System.out.println();
		System.out.println("Search max -> " + findMax(n1).value);
		System.out.println("Search max -> " + findMaxItr(n1).value);
	}

	public static BinarySearchNode findMin(BinarySearchNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null) {
			return root;
		}
		return findMin(root.left);
	}

	public static BinarySearchNode findMinItr(BinarySearchNode root) {
		if (root == null) {
			return null;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public static BinarySearchNode findMax(BinarySearchNode root) {
		if (root == null) {
			return null;
		}
		if (root.right == null) {
			return root;
		}
		return findMax(root.right);
	}

	public static BinarySearchNode findMaxItr(BinarySearchNode root) {
		if (root == null) {
			return null;
		}
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public static void inOrder(BinarySearchNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.value + " ");
			inOrder(root.right);
		}
	}

	public static BinarySearchNode find(BinarySearchNode root, int val) {
		if (root == null) {
			return null;
		}

		if (root.value == val) {
			return root;
		}
		if (val < root.value) {
			return find(root.left, val);
		}
		if (val > root.value) {
			return find(root.right, val);
		}
		return null;
	}

	public static BinarySearchNode findItr(BinarySearchNode root, int val) {
		while (root != null) {
			if (root.value == val) {
				return root;
			}
			if (val < root.value) {
				root = root.left;
			}
			if (val > root.value) {
				root = root.right;
			}
		}
		return null;
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

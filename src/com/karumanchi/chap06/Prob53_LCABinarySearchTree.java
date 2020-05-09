package com.karumanchi.chap06;

import java.util.ArrayList;
import java.util.List;

public class Prob53_LCABinarySearchTree {

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

		LCA(n1, 5, 10);
		System.out.println();
		System.out.println(LCA1(n1, 5, 2).value);
		System.out.println();
		System.out.println(LCA2(n1, 5, 2).value);
		
	}

	public static BinarySearchNode LCA2(BinarySearchNode root, int x, int y) {
		if (root == null) {
			return null;
		}
		if (x < root.value && y < root.value) {
			return LCA2(root.left, x, y);
		}
		if (x > root.value && y > root.value) {
			return LCA2(root.right, x, y);
		}
		return root;
	}

	public static BinarySearchNode LCA1(BinarySearchNode root, int x, int y) {
		if (root == null) {
			return null;
		}

		if (root.value == x || root.value == y) {
			return root;
		}
		BinarySearchNode le = LCA1(root.left, x, y);
		BinarySearchNode ri = LCA1(root.right, x, y);

		if (le != null && ri != null) {
			return root;
		}

		return le != null ? le : ri;
	}

	public static void LCA(BinarySearchNode root, int x, int y) {
		List<Integer> l1 = new ArrayList<>();
		getPathFromRoot(root, x, l1);

		List<Integer> l2 = new ArrayList<>();
		getPathFromRoot(root, y, l2);

		for (Integer n : l1) {
			System.out.print(n + " ");
		}
		System.out.println();

		for (Integer n : l2) {
			System.out.print(n + " ");
		}
		System.out.println();

		int joinPoint = -1;
		int i = 0, j = 0;
		while (true) {
			if (i == j && l1.get(i) == l2.get(j)) {
				i++;
				j++;
			} else {
				joinPoint = i - 1;
				break;
			}
		}

		for (i = l1.size() - 1; i > joinPoint; i--) {
			System.out.print(l1.get(i) + " -> ");
		}
		for (i = joinPoint; i < l2.size(); i++) {
			System.out.print(l2.get(i) + " -> ");
		}

	}

	public static boolean getPathFromRoot(BinarySearchNode root, int x, List<Integer> l) {
		if (root == null) {
			return false;
		}
		l.add(root.value);

		if (root.value == x) {
			return true;
		}

		if (getPathFromRoot(root.left, x, l) || getPathFromRoot(root.right, x, l)) {
			return true;
		}

		l.remove(l.size() - 1);
		return false;
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

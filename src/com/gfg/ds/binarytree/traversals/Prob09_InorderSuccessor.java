package com.gfg.ds.binarytree.traversals;

public class Prob09_InorderSuccessor {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, -999, 6 });
		populateInorderSuccessors(root);
		inOrder(root);
		System.out.println();
		printInOrderSucessors(root);
	}

	static TreeNode prev = null;

	public static void populateInorderSuccessors(TreeNode tree) {
		if (tree != null) {
			populateInorderSuccessors(tree.right);
			tree.inOrderSuccessor = prev;
			prev = tree;
			// System.out.print(tree.val + " ");
			populateInorderSuccessors(tree.left);
		}
	}

	public static void printInOrderSucessors(TreeNode tree) {
		if (tree != null) {
			printInOrderSucessors(tree.left);
			System.out.print(tree.val + "(" + (tree.inOrderSuccessor != null ? tree.inOrderSuccessor.val : -1) + ") ");
			printInOrderSucessors(tree.right);
		}
	}

	// ===
	public static TreeNode prepareTree(int[] values) {
		TreeNode[] treeArray = new TreeNode[values.length];
		for (int i = 0; i < values.length; i++) {
			if (values[i] == -999) {
				treeArray[i] = null;
			} else {
				treeArray[i] = new TreeNode(values[i]);
			}
		}

		for (int i = 0; i < values.length; i++) {
			TreeNode node = treeArray[i];
			if (((2 * i) + 1 < values.length) && ((2 * i) + 2 < values.length)) {
				node.left = treeArray[(2 * i) + 1];
				node.right = treeArray[(2 * i) + 2];
			}
		}
		return treeArray[0];
	}

	public static void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.val + " ");
			inOrder(tree.right);
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode inOrderSuccessor;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}

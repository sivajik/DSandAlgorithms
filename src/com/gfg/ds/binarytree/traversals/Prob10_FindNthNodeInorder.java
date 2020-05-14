package com.gfg.ds.binarytree.traversals;

public class Prob10_FindNthNodeInorder {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		inOrder(root);
		System.out.println();
		
		int n = 3;
		
		TreeNode node = new TreeNode(-1);
		findNthNode(root, n, node);
		System.out.println("Found " + n + "th Node: " + node.val);
	}

	static int counter = 0;

	public static void findNthNode(TreeNode tree, int n, TreeNode node) {
		if (tree != null) {
			findNthNode(tree.left, n, node);
			counter++;
			if (n == counter) {
				System.out.println("Found " + n + "th Node: " + tree.val);
				node.val = tree.val;
			}
			findNthNode(tree.right, n, node);
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

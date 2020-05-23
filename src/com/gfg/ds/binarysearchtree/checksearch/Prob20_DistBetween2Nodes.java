package com.gfg.ds.binarysearchtree.checksearch;

public class Prob20_DistBetween2Nodes {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 8, 3, 10, 1, 6, 9, 14, -999, -999, 4, 7, -999, -999, 13, 15 });
		inOrder(root);
		System.out.println();
		System.out.println(find(root, 1, 14));

	}

	private static int find(TreeNode root, int x, int y) {
		if (root == null) {
			return 0;
		}

		if (x < root.val && y < root.val) {
			return find(root.left, x, y);
		}

		if (x > root.val && y > root.val) {
			return find(root.right, x, y);
		}

		return distFromRoot(root, x) + distFromRoot(root, y);
	}

	private static int distFromRoot(TreeNode root, int x) {
		if (root == null) {
			return 0;
		}

		if (root.val == x) {
			return 0;
		}
		if (x < root.val) {
			return 1 + distFromRoot(root.left, x);
		}
		return 1 + distFromRoot(root.right, x);
	}

	// --------
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

	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			super();
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
}

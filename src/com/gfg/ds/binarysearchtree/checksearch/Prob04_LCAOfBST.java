package com.gfg.ds.binarysearchtree.checksearch;

public class Prob04_LCAOfBST {
	public static void main(String[] args) {
		int[] arr = new int[] { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		TreeNode root = prepareTree(arr);
		System.out.println(LCA(root, 4, 12).val);

	}

	private static TreeNode LCA(TreeNode root, int a, int b) {
		if (root == null) {
			return null;
		}

		if (a < root.val && b < root.val) {
			return LCA(root.left, a, b);
		}
		if (a > root.val && b > root.val) {
			return LCA(root.right, a, b);
		}
		return root;
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

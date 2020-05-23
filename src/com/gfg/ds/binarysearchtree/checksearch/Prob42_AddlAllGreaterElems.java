package com.gfg.ds.binarysearchtree.checksearch;

public class Prob42_AddlAllGreaterElems {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 50, 30, 70, 20, 40, 60, 80 });
		inOrder(root);
		System.out.println();
		addAllGreater(root);
		inOrder(root);

	}

	static int sum = 0;

	private static void addAllGreater(TreeNode root) {
		if (root != null) {
			addAllGreater(root.right);
			sum += root.val;
			root.val = sum;
			addAllGreater(root.left);
		}
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

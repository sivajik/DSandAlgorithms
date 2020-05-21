package com.gfg.ds.findinglca;

public class Prob01_LCAInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		TreeNode lca = findLCA(root, 4, 3);
		System.out.println(lca.val);
	}

	private static TreeNode findLCA(TreeNode node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		if (node.val == n1 || node.val == n2) {
			return node;
		}

		TreeNode left = findLCA(node.left, n1, n2);
		TreeNode rite = findLCA(node.right, n1, n2);

		if (left != null && rite != null) {
			return node;
		}

		if (left != null) {
			return left;
		} else {
			return rite;
		}

	}

	// =======
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

	public static void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.val + " ");
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

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

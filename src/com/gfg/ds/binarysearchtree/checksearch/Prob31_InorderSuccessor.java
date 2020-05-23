package com.gfg.ds.binarysearchtree.checksearch;

import java.util.HashMap;
import java.util.Map;

public class Prob31_InorderSuccessor {
	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 8, 3, 10, 1, 6, 9, 14, -999, -999, 4, 7, -999, -999, 13, 15 });
		inOrder(root);
		System.out.println();
		System.out.println(inOrderSuccessor(root, 8).val);
	}

	static Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();

	private static TreeNode inOrderSuccessor(TreeNode root, int data) {
		return inOrderSuccHelper(root, map.get(data));
	}

	private static TreeNode inOrderSuccHelper(TreeNode root, TreeNode node) {
		if (node == null) {
			return null;
		}

		if (node.right != null) {
			return min(node.right);
		} else {
			TreeNode succ = null;
			while (true) {
				if (node.val < root.val) {
					succ = root;
					root = root.left;
				} else if (node.val > root.val) {
					root  = root.right;
				} else {
					break;
				}

			}
			return succ;
		}
	}

	private static TreeNode min(TreeNode root) {
		while (root.left != null) {
			root = root.left;
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
				map.put(values[i], treeArray[i]);
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

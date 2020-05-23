package com.gfg.ds.binarysearchtree.checksearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob41_ReplaceWithLeastGreaterElem {

	public static void main(String[] args) {
		int[] arr = new int[] { 8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28 };
		makeBST(arr);
	}

	private static TreeNode makeBST(int[] arr) {
		int[] res = new int[arr.length];

		TreeNode root = null;
		for (int i = arr.length - 1; i >= 0; i--) {
			TreeNode[] succ = new TreeNode[1];
			root = insert(root, arr[i], succ);
			if (succ[0] != null) {
				res[i] = succ[0].val;
			} else {
				res[i] = -1;
			}
		}
		System.out.println(Arrays.toString(res));
		return root;
	}

	private static TreeNode insert(TreeNode root, int a, TreeNode[] succ) {
		if (root == null) {
			root = new TreeNode(a);
			return root;
		} else {
			if (a < root.val) {
				succ[0] = root;
				root.left = insert(root.left, a, succ);
			} else {
				root.right = insert(root.right, a, succ);
			}
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

	public static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	static Map<Integer, TreeNode> map = new HashMap<>();

	public static void inOrder(TreeNode root, List<TreeNode> l) {
		if (root != null) {
			inOrder(root.left, l);
			l.add(root);
			map.put(root.val, root);
			inOrder(root.right, l);
		}
	}

	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " [" + (root.succ != null ? root.succ.val : "-1") + "] ");
			inOrder(root.right);
		}
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		TreeNode succ;
		int val;

		public TreeNode(int val) {
			super();
			this.val = val;
			this.left = null;
			this.right = null;
			this.succ = null;
		}
	}
}

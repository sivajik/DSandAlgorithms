package com.gfg.ds.binarytree.traversals;

import java.util.HashMap;
import java.util.Map;

public class Prob04_GetPostOrderFromInPre {

	public static void main(String ars[]) {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };

		TreeNode root = getPostOrder(in, pre);
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
	}

	private static TreeNode getPostOrder(int[] in, int[] pre) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}

		return getPostOrderTree(in, 0, in.length - 1, pre, 0, pre.length - 1, map);
	}

	private static TreeNode getPostOrderTree(int[] in, int start, int end, int[] pre, int pStart, int pEnd,
			Map<Integer, Integer> map) {
		if (start > end || pStart > pEnd) {
			return null;
		}
		int rootElemVal = pre[pStart];
		int rootElemIndex = map.get(rootElemVal);

		TreeNode root = new TreeNode(rootElemVal);

		int preStartPost = pStart + rootElemIndex - start;

		root.left = getPostOrderTree(in, start, rootElemIndex - 1, pre, pStart + 1, preStartPost, map);
		root.right = getPostOrderTree(in, rootElemIndex + 1, end, pre, preStartPost + 1, pEnd, map);
		return root;
	}

	// ======
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

	public static void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.val + " ");
			inOrder(tree.right);
		}
	}

	public static void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.val + " ");
			preOrder(tree.left);
			preOrder(tree.right);
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

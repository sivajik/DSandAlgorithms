package com.gfg.ds.binarytree.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class Prob12_LevelOrderTree {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		levelOrderPrint(root);
	}

	public static void levelOrderPrint(TreeNode tree) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(tree);
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			System.out.print(t.val + " ");
			if (t.left != null) {
				q.add(t.left);
			}
			if (t.right != null) {
				q.add(t.right);
			}
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

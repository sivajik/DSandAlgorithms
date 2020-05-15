package com.gfg.ds.binarytree.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob18_LevelOrderReverseForm2 {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
				21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 });
		levelOrderPrint(root);
	}

	public static void levelOrderPrint(TreeNode tree) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(tree);
		q.add(null);

		List<TreeNode> list = new ArrayList<>();
		while (!q.isEmpty()) {
			TreeNode t = q.poll();
			if (t != null) {
				list.add(t);
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			} else {
				print(list);
				System.out.println();
				
				if (!q.isEmpty()) {
					list = new ArrayList<>();
					q.add(null);
				}
			}
		}

	}

	private static void print(List<TreeNode> list) {
		int i = 0;
		int j = list.size() - 1;
		while (i <= j) {
			System.out.print(list.get(i).val + " ");
			System.out.print(list.get(j).val + " ");
			i++;
			j--;
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

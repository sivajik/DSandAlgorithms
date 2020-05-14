package com.gfg.ds.binarytree.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Prob15_LevelOrderSpiralForm2Levels {

	public static void main(String[] args) {
		TreeNode root = prepareTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
				16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 ,30, 31});
		levelOrderPrint(root);
	}

	public static void levelOrderPrint(TreeNode tree) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(tree);
		q.add(null);

		int counter = 0;

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
				if (counter >=0 && counter <= 1) {
					for (TreeNode node : list) {
						System.out.print(node.val + " ");
					}
				} else if (counter >= 2 && counter <= 3){
					ListIterator<TreeNode> itr = list.listIterator(list.size());
					while (itr.hasPrevious()) {
						System.out.print(itr.previous().val + " ");
					}
				}
				counter += 1;
				
				if (counter == 4) {
					counter = 0;
				}
				
				if (!q.isEmpty()) {
					list.clear();
					q.add(null);
					System.out.println();
					System.out.println("---");
				}
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

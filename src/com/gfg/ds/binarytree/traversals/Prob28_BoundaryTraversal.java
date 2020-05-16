package com.gfg.ds.binarytree.traversals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob28_BoundaryTraversal {

	public static void main(String[] args) {
		BinaryTreeNode n1 = new BinaryTreeNode(1);

		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);

		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		n1.printBoundaryTraversal(n1);
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		BinaryTreeNode(int x) {
			this.value = x;
			this.left = null;
			this.right = null;
		}

		public void printBoundaryTraversal(BinaryTreeNode root) {
			printLeftboundary(root);
			printLeaves(root);

			List<BinaryTreeNode> list = new ArrayList<>();
			printRightBoundary(root, list);
			Collections.reverse(list);
			if (list.size() > 1) {
				list.remove(list.size() - 1);
			}
			for (BinaryTreeNode n : list) {
				System.out.print(n.value + " ");
			}
		}

		private void printRightBoundary(BinaryTreeNode root, List<BinaryTreeNode> list) {
			if (root == null) {
				return;
			}
			if (root.right != null) {
				// System.out.println(root.value);
				list.add(root);
				printRightBoundary(root.right, list);
			}

			if (root.right == null && root.left != null) {
				// System.out.println(root.value);
				list.add(root);
				printRightBoundary(root.left, list);
			}
		}

		private void printLeaves(BinaryTreeNode root) {
			if (root == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				System.out.print(root.value + " ");
			}
			printLeaves(root.left);
			printLeaves(root.right);
		}

		private void printLeftboundary(BinaryTreeNode root) {
			if (root == null) {
				return;
			}
			if (root.left != null) {
				System.out.print(root.value + " ");
				printLeftboundary(root.left);
			}
			if (root.left == null && root.right != null) {
				System.out.print(root.value + " ");
				printLeftboundary(root.right);
			}
		}

		Map<Integer, List<BinaryTreeNode>> map = new HashMap<>();

		private void printD(BinaryTreeNode root, int i) {
			if (root == null) {
				return;
			}
			if (map.containsKey(i)) {
				List<BinaryTreeNode> l = map.get(i);
				l.add(root);
				map.put(i, l);
			} else {
				List<BinaryTreeNode> l = new ArrayList<>();
				l.add(root);
				map.put(i, l);
			}

			if (root.left != null) {
				printD(root.left, i + 1);
			}

			if (root.right != null) {
				printD(root.right, i);
			}

		}

	}

}

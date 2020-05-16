package com.gfg.ds.binarytree.traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob26_DiagonlaOrder {

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

		n1.printDiagonal(n1);
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

		public void printDiagonal(BinaryTreeNode myRoot) {
			printD(myRoot, 0);

			for (Map.Entry<Integer, List<BinaryTreeNode>> eSet : map.entrySet()) {
				System.out.println(eSet.getKey());
				System.out.println("-----");
				for (BinaryTreeNode node : eSet.getValue()) {
					System.out.print(node.value + " ");
				}
				System.out.println();
				System.out.println();
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
				printD(root.left, i + 1 );
			}

			if (root.right != null) {
				printD(root.right, i );
			}

		}

	}

}

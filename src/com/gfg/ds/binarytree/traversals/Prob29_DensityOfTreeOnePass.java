package com.gfg.ds.binarytree.traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob29_DensityOfTreeOnePass {

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
/*
		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;
*/
		System.out.println(n1.densityOfTree(n1));
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

		public double densityOfTree(BinaryTreeNode root) {
			List<Integer> l = new ArrayList<>();
			l.add(0);
			int h = getHeightAndSize(root, l);
			double den = (double) l.get(0) / h;
			return den;
		}

		Map<Integer, List<BinaryTreeNode>> map = new HashMap<>();

		private int getHeightAndSize(BinaryTreeNode root, List<Integer> l) {
			if (root == null) {
				return 0;
			}

			int i = l.get(0);
			i++;
			l.set(0, i);

			int le = getHeightAndSize(root.left, l);
			int ri = getHeightAndSize(root.right, l);

			return 1 + Math.max(le, ri);
		}

	}

}

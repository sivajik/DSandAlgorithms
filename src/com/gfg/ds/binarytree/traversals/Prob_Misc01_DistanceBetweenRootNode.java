package com.gfg.ds.binarytree.traversals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob_Misc01_DistanceBetweenRootNode {

	public static void main(String[] args) {
		BinaryTreeNode n1 = new BinaryTreeNode(1);

		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);

		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);

		BinaryTreeNode n8 = new BinaryTreeNode(8);

		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right = n7;

		n7.right = n8;

		System.out.println(n1.calsDistTo(n1, 18, 0));
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

		public int calsDistTo(BinaryTreeNode root, int nodeVal, int dis) {
			if (root == null) {
				return -1;
			}

			if (root.value == nodeVal) {
				return dis;
			}
			int le = calsDistTo(root.left, nodeVal, dis + 1);
			if (le > 0) {
				return le;
			} else {
				return calsDistTo(root.right, nodeVal, dis + 1);
			}
		}
	}

}

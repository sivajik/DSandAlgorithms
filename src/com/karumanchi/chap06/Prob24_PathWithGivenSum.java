package com.karumanchi.chap06;

import java.util.ArrayList;

public class Prob24_PathWithGivenSum {

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

		System.out.println(n1.pathWithGivenSum(n1, 7));

		ArrayList<BinaryTreeNode> l = new ArrayList<BinaryTreeNode>();
		l.add(n1);
		System.out.println(n1.pathWithGivenSum1(n1, 7, l));
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

		public boolean pathWithGivenSum(BinaryTreeNode root, int sum) {
			if (root == null) {
				return false;
			}
			if (root.left == null && root.right == null && root.value == sum) {
				return true;
			}
			return pathWithGivenSum(root.left, sum - root.value) 
					|| pathWithGivenSum(root.right, sum - root.value);
		}

		public boolean pathWithGivenSum1(BinaryTreeNode root, int sum, ArrayList<BinaryTreeNode> l) {
			if (root == null) {
				return false;
			}
			if (root.left == null && root.right == null && root.value == sum) {
				print(l);
				return true;
			}
			return pathWithGivenSum1(root.left, sum - root.value, addNodeToList(l, root.left))
					|| pathWithGivenSum1(root.left, sum - root.value, addNodeToList(l, root.right));
		}

		private ArrayList<BinaryTreeNode> addNodeToList(ArrayList<BinaryTreeNode> l, BinaryTreeNode node) {
			l.add(node);
			return l;
		}

		private void print(ArrayList<BinaryTreeNode> l) {
			for (BinaryTreeNode n : l) {
				System.out.print(n.value + " ");
			}
			System.out.println();
		}
	}

}

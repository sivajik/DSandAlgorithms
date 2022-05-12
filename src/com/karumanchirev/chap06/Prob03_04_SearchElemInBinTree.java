package com.karumanchirev.chap06;

import java.util.LinkedList;
import java.util.Queue;

public class Prob03_04_SearchElemInBinTree {

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

		System.out.println(n1.searchElement(n1, 6));
		System.out.println(n1.searchElementItr(n1, 6));

	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		int value;

		BinaryTreeNode() {
		}

		public boolean searchElement(BinaryTreeNode root, int data) {
			if (root == null) {
				return false;
			}
			if (root.value == data) {
				return true;
			}
			return searchElement(root.left, data) || searchElement(root.right, data);
		}

		public boolean searchElementItr(BinaryTreeNode root, int data) {
			Queue<BinaryTreeNode> q = new LinkedList<>();
			q.add(root);

			while (!q.isEmpty()) {
				BinaryTreeNode tmp = q.poll();
				if (tmp != null) {
					if (tmp.value == data) {
						return true;
					}
					if (tmp.left != null) {
						q.add(tmp.left);
					}
					if (tmp.right != null) {
						q.add(tmp.right);
					}
				}
			}
			return false;
		}

		BinaryTreeNode(int x) {
			this.value = x;
			this.left = null;
			this.right = null;
		}
	}
}

package com.karumanchi.chap06;

import java.util.LinkedList;
import java.util.Queue;

public class Prob39_NextSibling {

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

		nextSiblings(n1);
		print(n1);
	}

	static void nextSiblings(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			if (tmp != null) {
				tmp.nextSibling = q.peek();
				if (tmp.left != null) {
					q.add(tmp.left);
				}
				if (tmp.right != null) {
					q.add(tmp.right);
				}
			} else {
				if (!q.isEmpty()) {
					q.add(null);
				}
			}
		}

	}

	private static void print(BinaryTreeNode x) {
		if (x != null) {
			print(x.left);
			System.out.print(x.value + "(" + (x.nextSibling != null ? x.nextSibling.value : -1) + ")  ");
			print(x.right);
		}
	}

	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		BinaryTreeNode nextSibling;
		int value;

		BinaryTreeNode() {
		}

		BinaryTreeNode(int x) {
			this.value = x;
			this.left = null;
			this.right = null;
			this.nextSibling = null;
		}
	}
}

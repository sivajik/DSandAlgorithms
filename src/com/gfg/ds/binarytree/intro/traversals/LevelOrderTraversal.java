package com.gfg.ds.binarytree.intro.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

		n1.leverOrderTraversal(n1);
		System.out.println();
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

		public void leverOrderTraversal(BinaryTreeNode myRoot) {
			Queue<BinaryTreeNode> q = new LinkedList<>();

			q.add(myRoot);
			while (!q.isEmpty()) {
				BinaryTreeNode node = q.poll();
				System.out.print(node.value + " "); // or add to a list

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
	}
}

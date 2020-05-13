package com.gfg.ds.binarytree.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

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

		n1.inOrderRecursive(n1);
		System.out.println();
		n1.inOrderIterative(n1);
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

		public void inOrderRecursive(BinaryTreeNode myRoot) {
			if (myRoot != null) {
				inOrderRecursive(myRoot.left);
				System.out.print(myRoot.value + " ");
				inOrderRecursive(myRoot.right);
			}
		}

		public void inOrderIterative(BinaryTreeNode root) {
			List<BinaryTreeNode> res = new ArrayList<>();
			boolean done = false;
			Stack<BinaryTreeNode> s = new Stack<>();
			while (!done) {
				if (root != null) {
					s.push(root);
					root = root.left;
				} else {
					if (s.isEmpty()) {
						done = true;
					} else {
						root = s.pop();
						res.add(root);
						root = root.right;
					}
				}
			}
			for (BinaryTreeNode r : res) {
				System.out.print(r.value + " ");
			}
			System.out.println();
		}
	}

}

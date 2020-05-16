package com.gfg.ds.binarytree.traversals;

import java.util.Stack;

public class Prob25_PostOrderTraverslItr {

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

		n1.postOrderRec(n1);
		System.out.println();
		n1.postOrderItr(n1);
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

		public void postOrderRec(BinaryTreeNode myRoot) {
			if (myRoot != null) {
				postOrderRec(myRoot.left);
				postOrderRec(myRoot.right);
				System.out.print(myRoot.value + " ");
			}
		}

		public void postOrderItr(BinaryTreeNode root) {
			Stack<BinaryTreeNode> s = new Stack<>();
			Stack<BinaryTreeNode> s2 = new Stack<>();

			s.push(root);

			while (!s.isEmpty()) {
				BinaryTreeNode t = s.pop();
				s2.push(t);
				if (t.left != null) {
					s.push(t.left);
				}
				if (t.right != null) {
					s.push(t.right);
				}

			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}

		}
	}

}

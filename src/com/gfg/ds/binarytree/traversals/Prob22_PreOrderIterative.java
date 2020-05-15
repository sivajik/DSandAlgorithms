package com.gfg.ds.binarytree.traversals;

import java.util.Stack;

public class Prob22_PreOrderIterative {

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

		n1.preOrderRec(n1);
		System.out.println();
		n1.preOrderItr(n1);
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

		public void preOrderRec(BinaryTreeNode myRoot) {
			if (myRoot != null) {
				System.out.print(myRoot.value + " ");
				preOrderRec(myRoot.left);
				preOrderRec(myRoot.right);
			}
		}

		public void preOrderItr(BinaryTreeNode root) {
			Stack<BinaryTreeNode> s = new Stack<>();
			s.push(root);

			while (!s.isEmpty()) {
				BinaryTreeNode t = s.pop();
				System.out.print(t.value +" ");
				if (t.right != null) {
					s.push(t.right);
				}
				if (t.left != null) {
					s.push(t.left);
				}
			}

		}
	}

}

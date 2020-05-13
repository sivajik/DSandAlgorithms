package com.gfg.ds.binarytree.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.gfg.ds.binarytree.traversals.InOrderTraversal.BinaryTreeNode;

public class PreOrderTraversal {

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

		n1.preOrderRecursive(n1);
		System.out.println();
		n1.preOrderIterative(n1);
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

		public void preOrderRecursive(BinaryTreeNode myRoot) {
			if (myRoot != null) {
				System.out.print(myRoot.value + " ");
				preOrderRecursive(myRoot.left);
				preOrderRecursive(myRoot.right);
			}
			
		}

		public void preOrderIterative(BinaryTreeNode root) {
			List<BinaryTreeNode> res = new ArrayList<>();
			
			Stack<BinaryTreeNode> s = new Stack<>();
			s.push(root);
			
			while (!s.isEmpty()) {
				BinaryTreeNode t = s.pop();
				res.add(t);
				
				if (t.right != null) {
					s.add(t.right);
				}
				if (t.left != null) {
					s.add(t.left);
				}
			}
			
			for (BinaryTreeNode r : res) {
				System.out.print(r.value + " ");
			}
			System.out.println();
		}
		
	}
}

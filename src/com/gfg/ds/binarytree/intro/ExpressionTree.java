package com.gfg.ds.binarytree.intro;

import java.util.Stack;

public class ExpressionTree {

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = makeExpressionTree("ab+ef*g*-");

		tree.inOrder(tree.root);
		System.out.println();
	}

	private static Node makeExpressionTree(String string) {
		Stack<Node> s = new Stack<Node>();
		for (char c : string.toCharArray()) {
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				Node r = s.pop();
				Node l = s.pop();

				Node newNode = new Node(c);
				newNode.left = l;
				newNode.right = r;
				s.push(newNode);
			} else {
				Node n = new Node((int) c);
				s.push(n);
			}
		}
		return s.pop();
	}

	static class BinaryTree {
		Node root;

		public void inOrder(Node n1) {
			if (n1 != null) {
				inOrder(n1.left);
				System.out.print( (char)n1.value + " ");
				inOrder(n1.right);
			}
		}

	}

	// ====
	static class Node {
		int value;
		Node left;
		Node right;

		public Node() {
		}

		public Node(int val) {
			this.value = val;
			this.left = null;
			this.right = null;
		}

	}

}
